package cl.grupo02.sprintFinal.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.grupo02.sprintFinal.model.entity.Administrativo;
import cl.grupo02.sprintFinal.model.entity.Usuario;
import cl.grupo02.sprintFinal.repository.AdministrativoRepository;

/**
 * Servicio para gestionar los administrativos.
 * 
 * @autor Ariel Alfaro
 * @autor Bastian Muñoz
 * @autor Bastian Espinosa
 * @autor Joshua Montt
 * @autor Nicolas Gajardo
 * @version 1.0
 */
@Service
public class AdministrativoService {

    @Autowired
    private AdministrativoRepository administrativoRepository;
    
    /**
     * Guarda o actualiza un administrativo en la base de datos.
     *
     * @param administrativo el objeto Administrativo a guardar o actualizar
     * @return el objeto Administrativo guardado o actualizado
     */
    @Transactional
    public Administrativo guardarAdministrativo(Administrativo administrativo) {
        return administrativoRepository.save(administrativo);
    }
    
    /**
     * Actualiza un administrativo existente.
     *
     * @param administrativo el objeto Administrativo con los datos actualizados
     * @return el objeto Administrativo actualizado
     * @throws IllegalArgumentException si el administrativo no existe
     */
    @Transactional
    public Administrativo actualizarAdministrativo(Administrativo administrativo) {
        if (administrativoRepository.existsById(administrativo.getIdAdministrativo())) {
            return administrativoRepository.save(administrativo);
        } else {
            throw new IllegalArgumentException("No se puede actualizar un cliente inexistente.");
        }
    }
    
    /**
     * Obtiene un administrativo asociado a un usuario específico.
     *
     * @param usuario el objeto Usuario asociado
     * @return el objeto Administrativo asociado, o null si no existe
     */
    public Administrativo obtenerAdministrativoPorUsuario(Usuario usuario) {
        return administrativoRepository.findByUsuario(usuario);
    }
        
    /**
     * Obtiene un administrativo por su identificador.
     *
     * @param id el identificador del administrativo
     * @return un Optional con el Administrativo si existe, o vacío si no
     */
    @Transactional(readOnly = true)
    public Optional<Administrativo> obtenerAdministrativoPorId(int id) {
        return administrativoRepository.findById(id);
    }

    /**
     * Obtiene todos los administrativos.
     *
     * @return una lista de todos los objetos Administrativo
     */
    @Transactional(readOnly = true)
    public List<Administrativo> obtenerTodosAdministrativos() {
        return administrativoRepository.findAll();
    }

    /**
     * Elimina un administrativo por su identificador.
     *
     * @param id el identificador del administrativo a eliminar
     */
    @Transactional
    public void eliminarAdministrativo(int id) {
        administrativoRepository.deleteById(id);
    }
}
