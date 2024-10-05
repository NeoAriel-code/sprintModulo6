package cl.grupo02.sprintFinal.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.grupo02.sprintFinal.model.entity.Profesional;
import cl.grupo02.sprintFinal.model.entity.Usuario;
import cl.grupo02.sprintFinal.repository.ProfesionalRepository;

/**
 * Servicio para gestionar los profesionales.
 * 
 * @autor Ariel Alfaro
 * @autor Bastian Muñoz
 * @autor Bastian Espinosa
 * @autor Joshua Montt
 * @autor Nicolas Gajardo
 * @version 1.0
 */
@Service
public class ProfesionalService {

    @Autowired
    private ProfesionalRepository profesionalRepository;
    
    /**
     * Guarda un profesional en la base de datos.
     *
     * @param profesional el objeto Profesional a guardar
     * @return el objeto Profesional guardado
     */
    @Transactional
    public Profesional guardarProfesional(Profesional profesional) {
        return profesionalRepository.save(profesional);
    }
    
    /**
     * Actualiza un profesional existente.
     *
     * @param profesional el objeto Profesional con los datos actualizados
     * @return el objeto Profesional actualizado
     * @throws IllegalArgumentException si el profesional no existe
     */
    @Transactional
    public Profesional actualizarProfesional(Profesional profesional) {
        if (profesionalRepository.existsById(profesional.getIdProfesional())) {
            return profesionalRepository.save(profesional);
        } else {
            throw new IllegalArgumentException("No se puede actualizar un cliente inexistente.");
        }
    }
    
    /**
     * Obtiene un profesional asociado a un usuario específico.
     *
     * @param usuario el objeto Usuario asociado
     * @return el objeto Profesional asociado, o null si no existe
     */
    public Profesional obtenerProfesionalPorUsuario(Usuario usuario) {
        return profesionalRepository.findByUsuario(usuario);
    }
    
    /**
     * Obtiene un profesional por su identificador.
     *
     * @param id el identificador del profesional
     * @return un Optional con el Profesional si existe, o vacío si no
     */
    @Transactional(readOnly = true)
    public Optional<Profesional> obtenerProfesionalPorId(int id) {
        return profesionalRepository.findById(id);
    }

    /**
     * Obtiene todos los profesionales.
     *
     * @return una lista de todos los objetos Profesional
     */
    @Transactional(readOnly = true)
    public List<Profesional> obtenerTodosProfesionales() {
        return profesionalRepository.findAll();
    }

    /**
     * Elimina un profesional por su identificador.
     *
     * @param id el identificador del profesional a eliminar
     */
    @Transactional
    public void eliminarProfesional(int id) {
        profesionalRepository.deleteById(id);
    }
}
