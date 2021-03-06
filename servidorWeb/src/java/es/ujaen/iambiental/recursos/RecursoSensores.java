package es.ujaen.iambiental.recursos;

import es.ujaen.iambiental.beans.AdminBean;
import es.ujaen.iambiental.beans.ClienteUsoBean;
import es.ujaen.iambiental.excepciones.SensorErrorActualizar;
import es.ujaen.iambiental.excepciones.SensorErrorDatos;
import es.ujaen.iambiental.excepciones.SensorErrorEliminar;
import es.ujaen.iambiental.excepciones.SensorErrorPersistir;
import es.ujaen.iambiental.excepciones.SensorNoEncontrado;
import es.ujaen.iambiental.modelos.HistoricoSensores;
import es.ujaen.iambiental.modelos.Sensor;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Recurso REST para el cliente de administración
 *
 * @author Gabri
 * @author Raúl Moya Reyes <www.raulmoya.es>
 */
@Path("/sensores")
@Component(value = "recursoSensores")
public class RecursoSensores {

    @Autowired
    AdminBean administrador;

    @Autowired
    ClienteUsoBean clienteUso;

    @GET
    @Path("/{idSensor}")
    @Produces("application/json; charset=utf-8")
    public Response obtenerSensor(@PathParam("idSensor") Integer idSensor) {
        Sensor sensor = administrador.obtenerSensor(idSensor);
        if (sensor == null) {
            throw new WebApplicationException(
                    Response.status(Status.NOT_FOUND).entity("Sensor no encontrado.").build()
            );
        }
        return Response.ok(sensor).build();

    }

    @GET
    @Produces("application/json; charset=utf-8")
    public ArrayList<Sensor> listarSensores() {
        return new ArrayList(administrador.listarSensores().values());

    }

    @PUT
    @Consumes("application/json")
    public Response crearSensor(Sensor sensor) {
        if (sensor == null) {
            throw new WebApplicationException(
                    Response.status(Status.BAD_REQUEST).entity("Falta el objeto sensor.").build()
            );
        }

        try {
            administrador.crearSensor(sensor);
        } catch (SensorErrorDatos | SensorErrorPersistir e) {
            throw new WebApplicationException(
                    Response.status(Status.NOT_ACCEPTABLE).entity("Error al crear el sensor.").build()
            );
        }
        return Response.status(Status.ACCEPTED).build();
    }

    @DELETE
    @Path("/{idSensor}")
    public Response eliminarSensor(@PathParam("idSensor") Integer idSensor) {
        Sensor sensor = administrador.obtenerSensor(idSensor);
        if (sensor == null) {
            throw new WebApplicationException(
                    Response.status(Status.NOT_FOUND).entity("Sensor no encontrado.").build()
            );
        } else {
            try {
                administrador.eliminarSensor(idSensor);
            } catch (SensorErrorEliminar | SensorNoEncontrado e) {
                throw new WebApplicationException(
                        Response.status(Status.NOT_ACCEPTABLE).entity("Error al eliminar el sensor.").build()
                );
            }
            return Response.status(Status.ACCEPTED).build();
        }
    }

    @POST
    @Path("/{idSensor}")
    @Consumes("application/json")
    public Response modificarSensor(@PathParam("idSensor") Integer idSensor, Sensor sensor) {
        if (sensor == null) {
            throw new WebApplicationException(
                    Response.status(Status.BAD_REQUEST).entity("Falta el objeto sensor.").build()
            );
        }

        if (administrador.obtenerSensor(idSensor) == null) {
            throw new WebApplicationException(
                    Response.status(Status.NOT_FOUND).entity("Sensor no encontrado.").build()
            );
        }
        try {
            administrador.modificarSensor(sensor);
        } catch (SensorErrorActualizar e) {
            throw new WebApplicationException(
                    Response.status(Status.NOT_ACCEPTABLE).entity("Error al actualizar el sensor.").build()
            );
        }
        return Response.status(Status.ACCEPTED).build();
    }

    @GET
    @Path("/{idSensor}/historico")
    @Produces("application/json; charset=utf-8")
    public Response obtenerHistoricoSensor(@PathParam("idSensor") Integer idSensor, @QueryParam("fechaInicio") long fechaInicio, @QueryParam("fechaFinal") long fechaFinal){
        Sensor sensor = administrador.obtenerSensor(idSensor);
        
        
        if (sensor == null) {
            throw new WebApplicationException(
                    Response.status(Status.NOT_FOUND).entity("Sensor no encontrado.").build()
            );
        } else {
            Date inicio = new Date(fechaInicio);
            Date fin = new Date(fechaFinal);
            List<HistoricoSensores> historico = administrador.obtenerHistoricoSensor(idSensor, inicio, fin);
            if (historico == null) {
                throw new WebApplicationException(
                        Response.status(Status.NOT_FOUND).entity("Historico no encontrado.").build()
                );
            }
            return Response.ok(historico).build();
        }
    }

    @GET
    @Path("/dependencia/{idDependencia}")
    @Produces("application/json; charset=utf-8")
    public ArrayList<Sensor> listarSensores(@PathParam("idDependencia") int idDependencia) {
        return new ArrayList(clienteUso.listarSensores(idDependencia).values());
    }

}
