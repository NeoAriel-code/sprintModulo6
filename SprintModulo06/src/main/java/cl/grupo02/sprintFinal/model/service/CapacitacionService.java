package cl.grupo02.sprintFinal.model.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.grupo02.sprintFinal.model.entity.Capacitacion;
import cl.grupo02.sprintFinal.repository.CapacitacionRepository;

/**
 * Servicio para gestionar las capacitaciones.
 * 
 * @autor Ariel Alfaro
 * @autor Bastian Muñoz
 * @autor Bastian Espinosa
 * @autor Joshua Montt
 * @autor Nicolas Gajardo
 * @version 1.0
 */
@Service
public class CapacitacionService {

    @Autowired
    private CapacitacionRepository capacitacionRepository;

    @Autowired
    private RestTemplate restTemplate;

    /**
     * Guarda o actualiza una capacitación en la base de datos.
     *
     * @param capacitacion el objeto Capacitacion a guardar o actualizar
     * @return el objeto Capacitacion guardado o actualizado
     */
    @Transactional
    public Capacitacion guardarCapacitacion(Capacitacion capacitacion) {
        return capacitacionRepository.save(capacitacion);
    }

    /**
     * Obtiene una capacitación por su identificador.
     *
     * @param id el identificador de la capacitación
     * @return un Optional con la Capacitacion si existe, o vacío si no
     */
    public Optional<Capacitacion> obtenerCapacitacionPorId(int id) {
        return capacitacionRepository.findById(id);
    }

    /**
     * Obtiene todas las capacitaciones.
     *
     * @return una lista de todos los objetos Capacitacion
     */
    public List<Capacitacion> obtenerTodasCapacitaciones() {
        return capacitacionRepository.findAll();
    }

    /**
     * Elimina una capacitación por su identificador.
     *
     * @param id el identificador de la capacitación a eliminar
     */
    public void eliminarCapacitacion(int id) {
        capacitacionRepository.deleteById(id);
    }

    /**
     * Verifica si una capacitación es nueva.
     *
     * @param capacitacion el objeto Capacitacion a verificar
     * @return true si es nueva, false si ya existe
     */
    public boolean isNew(Capacitacion capacitacion) {
        // Si el ID es 0 o no se encuentra en la base de datos, es nueva
        if (capacitacion.getIdCapacitacion() == 0) {
            return true;
        }
        return capacitacionRepository.existsById(capacitacion.getIdCapacitacion());
    }

    /**
     * Obtiene capacitaciones desde una API externa.
     *
     * @return una lista de capacitaciones obtenidas de la API externa
     */
    public List<Capacitacion> obtenerCapacitacionesExternas() {
        String url = "http://localhost:8080/grupal08/api/capacitaciones";
        Capacitacion[] capacitaciones = restTemplate.getForObject(url, Capacitacion[].class);
        return Arrays.asList(capacitaciones);
    }
}
