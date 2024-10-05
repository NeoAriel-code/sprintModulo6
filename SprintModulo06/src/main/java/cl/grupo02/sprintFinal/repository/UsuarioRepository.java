package cl.grupo02.sprintFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.grupo02.sprintFinal.model.entity.Usuario;

import java.util.List;

/**
 * Interfaz que define los métodos de acceso a datos para la entidad Usuario.
 * Extiende JpaRepository para proporcionar funcionalidades CRUD.
 * 
 * @author Ariel Alfaro, Bastian Muñoz, Bastian Espinosa, Joshua Montt, Nicolas Gajardo
 * @version 1.0
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	  Usuario findByNickname(String nickname); // Cambiar a nickname

    /**
     * Busca usuarios por su tipo.
     * 
     * @param tipoUsuario el tipo de usuario a buscar
     * @return lista de usuarios que coinciden con el tipo
     */
    List<Usuario> findByTipoUsuario(String tipoUsuario);
    
    // Métodos personalizados si es necesario

    public interface ValidacionCrear {}
    public interface ValidacionActualizar {}
}
