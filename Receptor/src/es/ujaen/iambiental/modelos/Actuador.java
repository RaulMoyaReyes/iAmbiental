package es.ujaen.iambiental.modelos;

import java.util.Date;

/**
 *
 * @author Gabriel
 * @author Raúl Moya Reyes <www.raulmoya.es>
 * @author Vicente
 */
public class Actuador {

    private int id;
    private Date fecha;
    private float dato;
    private String ip;
    private String puerto;
    private int estado;
    private int tipo;
    private int idFisico;

    public Actuador() {

    }

    public Actuador(int idFisico, float dato, int estado, Date fecha, String ip, String puerto) {
        this.idFisico = idFisico;
        this.dato = dato;
        this.estado = estado;
        this.fecha = fecha;
        this.ip = ip;
        this.puerto = puerto;
    }

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getDato() {
        return dato;
    }

    public void setDato(float dato) {
        this.dato = dato;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPuerto() {
        return puerto;
    }

    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getIdFisico() {
        return idFisico;
    }

    public void setIdFisico(int idFisico) {
        this.idFisico = idFisico;
    }

}
