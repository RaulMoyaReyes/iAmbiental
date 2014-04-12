/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.ujaen.iambiental.beans;

import es.ujaen.iambiental.excepciones.ActuadorErrorActualizar;
import es.ujaen.iambiental.excepciones.ActuadorErrorDatos;
import es.ujaen.iambiental.excepciones.ActuadorErrorEliminar;
import es.ujaen.iambiental.excepciones.ActuadorErrorPersistir;
import es.ujaen.iambiental.excepciones.ActuadorNoEncontrado;
import es.ujaen.iambiental.excepciones.ReglaProgramadaErrorActualizar;
import es.ujaen.iambiental.excepciones.ReglaProgramadaErrorDatos;
import es.ujaen.iambiental.excepciones.ReglaProgramadaErrorEliminar;
import es.ujaen.iambiental.excepciones.ReglaProgramadaErrorPersistir;
import es.ujaen.iambiental.excepciones.ReglaProgramadaNoEncontrada;
import es.ujaen.iambiental.excepciones.ReglaSensorActuadorErrorActualizar;
import es.ujaen.iambiental.excepciones.ReglaSensorActuadorErrorDatos;
import es.ujaen.iambiental.excepciones.ReglaSensorActuadorErrorEliminar;
import es.ujaen.iambiental.excepciones.ReglaSensorActuadorErrorPersistir;
import es.ujaen.iambiental.excepciones.ReglaSensorActuadorNoEncontrada;
import es.ujaen.iambiental.excepciones.SensorErrorActualizar;
import es.ujaen.iambiental.excepciones.SensorErrorDatos;
import es.ujaen.iambiental.excepciones.SensorErrorEliminar;
import es.ujaen.iambiental.excepciones.SensorErrorPersistir;
import es.ujaen.iambiental.excepciones.SensorNoEncontrado;
import es.ujaen.iambiental.excepciones.TareaProgramadaErrorActualizar;
import es.ujaen.iambiental.excepciones.TareaProgramadaErrorDatos;
import es.ujaen.iambiental.excepciones.TareaProgramadaErrorEliminar;
import es.ujaen.iambiental.excepciones.TareaProgramadaErrorPersistir;
import es.ujaen.iambiental.excepciones.TareaProgramadaNoEncontrada;
import es.ujaen.iambiental.modelos.Actuador;
import es.ujaen.iambiental.modelos.ReglaProgramada;
import es.ujaen.iambiental.modelos.ReglaSensorActuador;
import es.ujaen.iambiental.modelos.Sensor;
import es.ujaen.iambiental.modelos.TareaProgramada;
import java.util.Date;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 *
 * @author raulm
 */
@Component(value = "beanAdmin")
public class AdminBean {

    /**
     * Crear un sensor.
     *
     * @param sensor
     * @throws es.ujaen.iambiental.excepciones.SensorErrorDatos
     * @throws es.ujaen.iambiental.excepciones.SensorErrorPersistir
     */
    public void crearSensor(Sensor sensor) throws SensorErrorDatos, SensorErrorPersistir{
        
    }
    
    /**
     * Devuelve el sensor con el id indicado
     *
     * @param idSensor
     * @return Devuelve el sensor, null si no es encontrado.
     */
    public Sensor obtenerSensor(String idSensor) {
        return null;
    }
    
    /**
     * Elimina un sensor del sistema.
     *
     * @param idSensor
     * @throws es.ujaen.iambiental.excepciones.SensorErrorEliminar
     * @throws es.ujaen.iambiental.excepciones.SensorNoEncontrado
     */
    public void eliminarSensor(String idSensor) throws SensorErrorEliminar, SensorNoEncontrado{
        
    }
    
    /**
     * Modifica un sensor del sistema.
     *
     * @param sensor
     * @throws es.ujaen.iambiental.excepciones.SensorErrorActualizar
     */
    public void modificarSensor(Sensor sensor) throws SensorErrorActualizar{
        
    }
    
    /**
     * Crear un actuador.
     *
     * @param actuador
     * @throws es.ujaen.iambiental.excepciones.ActuadorErrorDatos
     * @throws es.ujaen.iambiental.excepciones.ActuadorErrorPersistir
     */
    public void crearActuador(Actuador actuador) throws ActuadorErrorDatos, ActuadorErrorPersistir{
        
    }
    
    /**
     * Devuelve el actuador con el id indicado
     *
     * @param idActuador
     * @return Devuelve el actuador, null si no es encontrado.
     */
    public Actuador obtenerActuador(String idActuador) {
        return null;
    }
    
    /**
     * Elimina un actuador del sistema.
     *
     * @param idActuador
     * @throws es.ujaen.iambiental.excepciones.ActuadorErrorEliminar
     * @throws es.ujaen.iambiental.excepciones.ActuadorNoEncontrado
     */
    public void eliminarActuador(String idActuador) throws ActuadorErrorEliminar, ActuadorNoEncontrado {
        
    }
    
    /**
     * Modifica un actuador del sistema.
     *
     * @param actuador
     * @throws es.ujaen.iambiental.excepciones.ActuadorErrorActualizar
     */
    public void modificarActuador(Actuador actuador) throws ActuadorErrorActualizar {
        
    }
    
    /**
     * Crear una tarea programada.
     *
     * @param tareaProgramada
     * @throws es.ujaen.iambiental.excepciones.TareaProgramadaErrorDatos
     * @throws es.ujaen.iambiental.excepciones.TareaProgramadaErrorPersistir
     */
    public void crearTareaProgramada(TareaProgramada tareaProgramada) throws TareaProgramadaErrorDatos, TareaProgramadaErrorPersistir{
        
    }
    
    /**
     * Devuelve la tarea programada con el id indicado
     *
     * @param idTareaProgramada
     * @return Devuelve la tarea programada, null si no es encontrada.
     */
    public TareaProgramada obtenerTareaProgramada(String idTareaProgramada) {
        return null;
    }
    
    /**
     * Elimina una tarea programada del sistema.
     *
     * @param idTareaProgramada
     * @throws es.ujaen.iambiental.excepciones.TareaProgramadaErrorEliminar
     * @throws es.ujaen.iambiental.excepciones.TareaProgramadaNoEncontrada
     */
    public void eliminarTareaProgramada(String idTareaProgramada) throws TareaProgramadaErrorEliminar, TareaProgramadaNoEncontrada {
        
    }
    
    /**
     * Modifica una tarea programada del sistema.
     *
     * @param tareaProgramada
     * @throws es.ujaen.iambiental.excepciones.TareaProgramadaErrorActualizar
     */
    public void modificarTareaProgramada(TareaProgramada tareaProgramada) throws TareaProgramadaErrorActualizar {
        
    }
    
    /**
     * Crear una regla programada y asociarla a una tarea programada.
     *
     * @param reglaProgramada
     * @param idTareaProgramada
     * @throws es.ujaen.iambiental.excepciones.ReglaProgramadaErrorDatos
     * @throws es.ujaen.iambiental.excepciones.ReglaProgramadaErrorPersistir
     */
    public void crearReglaProgramada(ReglaProgramada reglaProgramada, String idTareaProgramada) throws ReglaProgramadaErrorDatos, ReglaProgramadaErrorPersistir{
        
    }
    
    /**
     * Devuelve la regla programada con el id indicado
     *
     * @param idReglaProgramada
     * @return Devuelve el actuador, null si no es encontrado.
     */
    public ReglaProgramada obtenerReglaProgramada(String idReglaProgramada) {
        return null;
    }
    
    /**
     * Elimina una regla programada del sistema.
     *
     * @param idReglaProgramada
     * @throws es.ujaen.iambiental.excepciones.ReglaProgramadaErrorEliminar
     * @throws es.ujaen.iambiental.excepciones.ReglaProgramadaNoEncontrada
     */
    public void eliminarReglaProgramada(String idReglaProgramada) throws ReglaProgramadaErrorEliminar, ReglaProgramadaNoEncontrada {
        
    }
    
    /**
     * Modifica una regla programada del sistema.
     *
     * @param reglaProgramada
     * @throws es.ujaen.iambiental.excepciones.ReglaProgramadaErrorActualizar
     */
    public void modificarReglaProgramada(ReglaProgramada reglaProgramada) throws ReglaProgramadaErrorActualizar {
        
    }
    
    /**
     * Crear una regla sensor-actuador.
     *
     * @param reglaSensorActuador
     * @throws es.ujaen.iambiental.excepciones.ReglaSensorActuadorErrorDatos
     * @throws es.ujaen.iambiental.excepciones.ReglaSensorActuadorErrorPersistir
     */
    public void crearReglaSensorActuador(ReglaSensorActuador reglaSensorActuador) throws ReglaSensorActuadorErrorDatos, ReglaSensorActuadorErrorPersistir{
        
    }
    
    /**
     * Devuelve la regla sensor-actuador con el id indicado
     *
     * @param idReglaSensorActuador
     * @return Devuelve la regla sensor-actuador, null si no es encontrado.
     */
    public ReglaSensorActuador obtenerReglaSensorActuador(String idReglaSensorActuador) {
        return null;
    }
    
    /**
     * Elimina una regla sensor-actuador del sistema.
     *
     * @param idReglaSensorActuador
     * @throws es.ujaen.iambiental.excepciones.ReglaSensorActuadorErrorEliminar
     * @throws es.ujaen.iambiental.excepciones.ReglaSensorActuadorNoEncontrada
     */
    public void eliminarReglaSensorActuador(String idReglaSensorActuador) throws ReglaSensorActuadorErrorEliminar, ReglaSensorActuadorNoEncontrada {
        
    }
    
    /**
     * Modifica una regla sensor-actuador del sistema.
     *
     * @param reglaSensorActuador
     * @throws es.ujaen.iambiental.excepciones.ReglaSensorActuadorErrorActualizar
     */
    public void modificarReglaSensorActuador(ReglaSensorActuador reglaSensorActuador) throws ReglaSensorActuadorErrorActualizar {
        
    }
    
    /**
     * Devuelve un mapa con la lista de sensores.
     *
     * @return Devuelve un mapa con la lista de sensores
     */
    public Map<String, Sensor> listarSensores() {
        return null;
    }
    
    /**
     * Devuelve un mapa con la lista de actuadores.
     *
     * @return Devuelve un mapa con la lista de actuadores
     */
    public Map<String, Actuador> listarActuadores() {
        return null;
    }
    
    /**
     * Devuelve un mapa con la lista de tareas programadas.
     *
     * @return Devuelve un mapa con la lista de tareas programadas
     */
    public Map<String, TareaProgramada> listarTareasProgramadas() {
        return null;
    }
    
    /**
     * Devuelve un mapa con la lista de reglas programadas.
     *
     * @return Devuelve un mapa con la lista de reglas programadas
     */
    public Map<String, ReglaProgramada> listarReglasProgramadas() {
        return null;
    }
    
    /**
     * Devuelve un mapa con la lista de reglas sensor-actuador.
     *
     * @return Devuelve un mapa con la lista de reglas sensor-actuador
     */
    public Map<String, ReglaSensorActuador> listarReglasSensorActuador() {
        return null;
    }
    
    /**
     * Devuelve un mapa con el histórico de valores de un sensor.
     *
     * @param idSensor
     * @param fechaInicio
     * @param fechaFinal
     * @return Devuelve un mapa con el histórico de valores de un sensor
     */
    public Map<Date, Double> obtenerHistoricoSensor(String idSensor, Date fechaInicio, Date fechaFinal) {
        return null;
    }
    
    /**
     * Devuelve un mapa con el histórico de valores de un actuador.
     *
     * @param idActuador
     * @param fechaInicio
     * @param fechaFinal
     * @return Devuelve un mapa con el histórico de valores de un actuador
     */
    public Map<Date, Double> obtenerHistoricoActuador(String idActuador, Date fechaInicio, Date fechaFinal) {
        return null;
    }
    
}
