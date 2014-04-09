/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package es.ujaen.iambiental.beans;

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
public class AdminBEAN {

    /**
     * Crear un sensor.
     *
     * @param sensor
     */
    public void crearSensor(Sensor sensor){
        
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
     */
    public void eliminarSensor(String idSensor) {
        
    }
    
    /**
     * Modifica un sensor del sistema.
     *
     * @param sensor
     */
    public void modificarSensor(Sensor sensor) {
        
    }
    
    /**
     * Crear un actuador.
     *
     * @param actuador
     */
    public void crearActuador(Actuador actuador){
        
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
     */
    public void eliminarActuador(String idActuador) {
        
    }
    
    /**
     * Modifica un actuador del sistema.
     *
     * @param actuador
     */
    public void modificarActuador(Actuador actuador) {
        
    }
    
    /**
     * Crear una tarea programada.
     *
     * @param tareaProgramada
     */
    public void crearTareaProgramada(TareaProgramada tareaProgramada){
        
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
     */
    public void eliminarTareaProgramada(String idTareaProgramada) {
        
    }
    
    /**
     * Modifica una tarea programada del sistema.
     *
     * @param tareaProgramada
     */
    public void modificarTareaProgramada(TareaProgramada tareaProgramada) {
        
    }
    
    /**
     * Crear una regla programada y asociarla a una tarea programada.
     *
     * @param reglaProgramada
     * @param idTareaProgramada
     */
    public void crearReglaProgramada(ReglaProgramada reglaProgramada, String idTareaProgramada){
        
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
     */
    public void eliminarReglaProgramada(String idReglaProgramada) {
        
    }
    
    /**
     * Modifica una regla programada del sistema.
     *
     * @param reglaProgramada
     */
    public void modificarReglaProgramada(ReglaProgramada reglaProgramada) {
        
    }
    
    /**
     * Crear una regla sensor-actuador.
     *
     * @param reglaSensorActuador
     */
    public void crearReglaSensorActuador(ReglaSensorActuador reglaSensorActuador){
        
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
     */
    public void eliminarReglaSensorActuador(String idReglaSensorActuador) {
        
    }
    
    /**
     * Modifica una regla sensor-actuador del sistema.
     *
     * @param reglaSensorActuador
     */
    public void modificarReglaSensorActuador(ReglaSensorActuador reglaSensorActuador) {
        
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
