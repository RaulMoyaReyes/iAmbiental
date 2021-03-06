package es.ujaen.iambiental.clienteadmin;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import es.ujaen.iambiental.modelos.Actuador;
import es.ujaen.iambiental.modelos.Dependencia;
import es.ujaen.iambiental.modelos.Sensor;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author agustin
 * @author Raúl Moya Reyes <www.raulmoya.com>
 */
@WebServlet(name = "actuadores", urlPatterns = {"/actuadores/*"})
public class actuadores extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        RequestDispatcher rd;

        //Variables de las url del servidor
        String srvUrl = request.getContextPath() + request.getServletPath();
        request.setAttribute("srvUrl", srvUrl);
        request.setAttribute("appUrl", request.getContextPath());

        //Pathinfo
        String action = (request.getPathInfo() != null ? request.getPathInfo() : "");

        // Mapeador
        ObjectMapper mapper = new ObjectMapper();

        //Cliente para JSON
        DefaultClientConfig defaultClientConfig = new DefaultClientConfig();
        defaultClientConfig.getClasses().add(JacksonJsonProvider.class);
        Client cliente = Client.create(defaultClientConfig);
        WebResource recurso = cliente.resource("http://localhost:8084/servidorWeb/recursos");

        // Dependencias
        ClientResponse responseJSOND = recurso.path("/dependencias").accept("application/json").get(ClientResponse.class);
        List<Dependencia> dependencias = responseJSOND.getEntity(List.class);

        // Actuadores
        ClientResponse responseJSONA = recurso.path("/actuadores").accept("application/json").get(ClientResponse.class);
        List<Actuador> actuadores = responseJSONA.getEntity(List.class);

        //Cabecera
        request.setAttribute("mainMenuOption", "actuadores");
        rd = request.getRequestDispatcher("/WEB-INF/cabecera.jsp");
        rd.include(request, response);

        //Cuerpo
        switch (action) {
            case "/listado":
            default: //Ninguna opción seleccionada
                request.setAttribute("actuadores", actuadores);
                rd = request.getRequestDispatcher("/WEB-INF/actuadores/index.jsp");
                rd.include(request, response);
                rd = request.getRequestDispatcher("/WEB-INF/actuadores/modalEliminar.jsp");
                rd.include(request, response);
                break;
            case "/insertar": //Insertar dependencia
                if (request.getParameter("crear") != null) {
                    int idFisico = Integer.parseInt(request.getParameter("idFisico"));
                    String descripcion = request.getParameter("descripcion");
                    int idD = Integer.parseInt(request.getParameter("dependencia"));
                    Dependencia d = null;
                    for (int i = 0; i < dependencias.size() && d == null; i++) {
                        Dependencia aux = mapper.convertValue(dependencias.get(i), Dependencia.class);
                        if (aux.getId() == idD) {
                            d = aux;
                        }
                    }
                    String ip = request.getParameter("ip");
                    String puerto = request.getParameter("puerto");
                    int tipo = Integer.parseInt(request.getParameter("tipo"));

                    recurso.path("/actuadores")
                            .type("application/json")
                            .put(ClientResponse.class, new Actuador(descripcion, d, ip, puerto, tipo, idFisico));

                    response.sendRedirect("/clienteAdmin/actuadores");

                } else {
                    request.setAttribute("actuadores", actuadores);
                    request.setAttribute("dependencias", dependencias);
                    rd = request.getRequestDispatcher("/WEB-INF/actuadores/insertar.jsp");
                    rd.include(request, response);
                }
                break;
            case "/ver": //Ver dependencia
                request.setAttribute("actuadores", actuadores);
                int id = Integer.parseInt(request.getParameter("id"));
                Actuador a = null;
                for (int i = 0; i < actuadores.size() && a == null; i++) { // no cambiar al for-loop
                    Actuador aux = mapper.convertValue(actuadores.get(i), Actuador.class);
                    if (aux.getId() == id) {
                        a = aux;
                    }
                }
                request.setAttribute("actuador", a);
                rd = request.getRequestDispatcher("/WEB-INF/actuadores/ver.jsp");
                rd.include(request, response);
                rd = request.getRequestDispatcher("/WEB-INF/actuadores/modalEliminar.jsp");
                rd.include(request, response);
                break;
            case "/historico": //Ver histórico
                request.setAttribute("actuadores", actuadores);
                
                id = Integer.parseInt(request.getParameter("id"));
                a = null;
                for (int i = 0; i < actuadores.size() && a == null; i++) {
                    Actuador aux = mapper.convertValue(actuadores.get(i), Actuador.class);
                    if (aux.getId() == id) {
                        a = aux;
                    }
                }
                request.setAttribute("actuador", a);
                // Historico //new Date(114,03,28,12,00), new Date(115,04,30,14,00));

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                String fechaInicio = request.getParameter("fechaInicio");
                try {
                    fechaInicio = Long.toString(sdf.parse(fechaInicio).getTime());
                } catch (Exception ex) {
                    fechaInicio = "0";
                }
                
                String fechaFinal = request.getParameter("fechaFinal");
                try {
                    fechaFinal = Long.toString(sdf.parse(fechaFinal).getTime());
                } catch (Exception ex) {
                    fechaFinal = Long.toString(Long.MAX_VALUE);
                }
                
                
                ClientResponse responseJSONH = recurso.path("/actuadores/" + id + "/historico")
                        .queryParam("fechaInicio", fechaInicio)
                        .queryParam("fechaFinal", fechaFinal)
                        .accept("application/json")
                        .get(ClientResponse.class);
                List<HistoricoActuadores> historico = responseJSONH.getEntity(List.class);
                request.setAttribute("historico", historico);
                rd = request.getRequestDispatcher("/WEB-INF/actuadores/historico.jsp");
                rd.include(request, response);
                rd = request.getRequestDispatcher("/WEB-INF/actuadores/modalEliminar.jsp");
                rd.include(request, response);
                break;
            case "/eliminar": //Dependencia eliminada
                id = Integer.parseInt(request.getParameter("id"));
                a = null;
                for (int i = 0; i < actuadores.size() && a == null; i++) { // no cambiar al for-loop
                    Actuador aux = mapper.convertValue(actuadores.get(i), Actuador.class);
                    if (aux.getId() == id) {
                        a = aux;
                    }
                }
                request.setAttribute("eliminado", a.getDescripcion());
                recurso.path("/actuadores/" + id).delete();
                request.setAttribute("actuadores", actuadores);
                response.sendRedirect("/clienteAdmin/actuadores");
                break;

            case "/editar": //Insertar dependencia
                if (request.getParameter("modificar") != null) {
                    id = Integer.parseInt(request.getParameter("modificar"));
                    int idFisico = Integer.parseInt(request.getParameter("idFisico"));
                    String descripcion = request.getParameter("descripcion");
                    int idD = Integer.parseInt(request.getParameter("dependencia"));
                    Dependencia d = null;
                    for (int i = 0; i < dependencias.size() && d == null; i++) {
                        Dependencia aux = mapper.convertValue(dependencias.get(i), Dependencia.class);
                        if (aux.getId() == idD) {
                            d = aux;
                        }
                    }
                    String ip = request.getParameter("ip");
                    String puerto = request.getParameter("puerto");
                    int tipo = Integer.parseInt(request.getParameter("tipo"));

                    a = null;
                    for (int i = 0; i < actuadores.size() && a == null; i++) {
                        Actuador aux = mapper.convertValue(actuadores.get(i), Actuador.class);
                        if (aux.getId() == id) {
                            a = aux;
                        }
                    }
                    a.setDescripcion(descripcion);
                    a.setDependencia(d);
                    a.setIp(ip);
                    a.setPuerto(puerto);
                    a.setIdFisico(idFisico);
                    a.setTipo(tipo);

                    recurso.path("/actuadores/" + id)
                            .type("application/json")
                            .post(ClientResponse.class, a);

                    response.sendRedirect("/clienteAdmin/actuadores");
                } else {
                    request.setAttribute("actuadores", actuadores);
                    request.setAttribute("dependencias", dependencias);
                    id = Integer.parseInt(request.getParameter("id"));
                    a = null;
                    for (int i = 0; i < actuadores.size() && a == null; i++) { // no cambiar al for-loop
                        Actuador aux = mapper.convertValue(actuadores.get(i), Actuador.class);
                        if (aux.getId() == id) {
                            a = aux;
                        }
                    }
                    request.setAttribute("actuador", a);
                    rd = request.getRequestDispatcher("/WEB-INF/actuadores/editar.jsp");
                    rd.include(request, response);
                    rd = request.getRequestDispatcher("/WEB-INF/actuadores/modalEliminar.jsp");
                    rd.include(request, response);
                }
                break;
        }
        //Footer
        rd = request.getRequestDispatcher("/WEB-INF/pie.jsp");
        rd.include(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
