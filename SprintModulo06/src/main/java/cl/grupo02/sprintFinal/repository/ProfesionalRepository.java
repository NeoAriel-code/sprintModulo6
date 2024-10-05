package cl.grupo02.sprintFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.grupo02.sprintFinal.model.entity.Profesional;
import cl.grupo02.sprintFinal.model.entity.Usuario;

/**
 * Interfaz que define los métodos de acceso a datos para la entidad Profesional.
 * Extiende JpaRepository para proporcionar funcionalidades CRUD.
 * 
 * @author Ariel Alfaro, Bastian Muñoz, Bastian Espinosa, Joshua Montt, Nicolas Gajardo
 * @version 1.0
 */
@Repository
public interface ProfesionalRepository extends JpaRepository<Profesional, Integer> {
    
    /**
     * Busca un Profesional por el usuario asociado.
     * 
     * @param usuario el usuario asociado al profesional
     * @return el Profesional correspondiente al usuario, o null si no se encuentra
     */
    Profesional findByUsuario(Usuario usuario);
}
