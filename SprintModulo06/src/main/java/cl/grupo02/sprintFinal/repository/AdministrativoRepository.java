package cl.grupo02.sprintFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.grupo02.sprintFinal.model.entity.Administrativo;
import cl.grupo02.sprintFinal.model.entity.Usuario;

/**
 * Interfaz que define los métodos de acceso a datos para la entidad Administrativo.
 * Extiende JpaRepository para proporcionar funcionalidades CRUD.
 * 
 * @author Ariel Alfaro, Bastian Muñoz, Bastian Espinosa, Joshua Montt, Nicolas Gajardo
 * @version 1.0
 */
@Repository
public interface AdministrativoRepository extends JpaRepository<Administrativo, Integer> {
    
    /**
     * Busca un Administrativo por su usuario asociado.
     *
     * @param usuario El usuario asociado al administrativo.
     * @return El administrativo correspondiente al usuario, o null si no se encuentra.
     */
    Administrativo findByUsuario(Usuario usuario);
}
