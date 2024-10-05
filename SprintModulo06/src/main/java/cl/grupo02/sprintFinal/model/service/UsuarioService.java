package cl.grupo02.sprintFinal.model.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.grupo02.sprintFinal.model.entity.Usuario;
import cl.grupo02.sprintFinal.repository.UsuarioRepository;

/**
 * Servicio para gestionar los usuarios.
 * 
 * @autor Ariel Alfaro
 * @autor Bastian Muñoz
 * @autor Bastian Espinosa
 * @autor Joshua Montt
 * @autor Nicolas Gajardo
 * @version 1.0
 */
@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

    public Usuario findByNickname(String nickname) {
        return usuarioRepository.findByNickname(nickname);
    }
	
	// Método para actualizar un usuario existente

    /**
     * Actualiza un usuario existente.
     *
     * @param usuario el objeto Usuario con los datos actualizados
     * @return el objeto Usuario actualizado
     * @throws IllegalArgumentException si el usuario no existe
     */
    @Transactional
    public Usuario actualizarUsuario(Usuario usuario) {
        if (usuarioRepository.existsById(usuario.getIdUsuario())) {
            return usuarioRepository.save(usuario);
        } else {
            throw new IllegalArgumentException("No se puede actualizar un usuario inexistente.");
        }
    }

    /**
     * Guarda un nuevo usuario en la base de datos.
     *
     * @param usuario el objeto Usuario a guardar
     * @return el objeto Usuario guardado
     */
    @Transactional
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    /**
     * Obtiene un usuario por su identificador.
     *
     * @param id el identificador del usuario
     * @return un Optional con el Usuario si existe, o vacío si no
     */
    public Optional<Usuario> obtenerUsuarioPorId(int id) {
        return usuarioRepository.findById(id);
    }

    /**
     * Obtiene todos los usuarios.
     *
     * @return una lista de todos los objetos Usuario
     */
    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    /**
     * Elimina un usuario por su identificador.
     *
     * @param id el identificador del usuario a eliminar
     * @throws IllegalArgumentException si el usuario no existe
     */
    public void eliminarUsuario(int id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("No se puede eliminar un usuario inexistente.");
        }
    }

    /**
     * Obtiene los usuarios filtrados por tipo de usuario.
     *
     * @param tipoUsuario el tipo de usuario para filtrar (ej. cliente, profesional, administrativo)
     * @return una lista de usuarios que corresponden al tipo especificado
     */
    public List<Usuario> obtenerUsuariosPorTipo(String tipoUsuario) { 
        return usuarioRepository.findByTipoUsuario(tipoUsuario); 
    }
}
