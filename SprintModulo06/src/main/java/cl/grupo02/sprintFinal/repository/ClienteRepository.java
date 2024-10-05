package cl.grupo02.sprintFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.grupo02.sprintFinal.model.entity.Cliente;
import cl.grupo02.sprintFinal.model.entity.Usuario;

/**
 * Interfaz que define los métodos de acceso a datos para la entidad Cliente.
 * Extiende JpaRepository para proporcionar funcionalidades CRUD.
 * 
 * @author Ariel Alfaro, Bastian Muñoz, Bastian Espinosa, Joshua Montt, Nicolas Gajardo
 * @version 1.0
 */
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
    /**
     * Busca un Cliente por el usuario asociado.
     * 
     * @param usuario el usuario asociado al cliente
     * @return el Cliente correspondiente al usuario, o null si no se encuentra
     */
    Cliente findByUsuario(Usuario usuario);

    /**
     * Busca un Cliente por su RUT de empresa.
     * 
     * @param rutEmpresa el RUT de la empresa del cliente
     * @return el Cliente correspondiente al RUT, o null si no se encuentra
     */
    Cliente findByRutEmpresa(String rutEmpresa);
}
