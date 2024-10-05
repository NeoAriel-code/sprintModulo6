package cl.grupo02.sprintFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.grupo02.sprintFinal.model.entity.Capacitacion;

/**
 * Interfaz que define los métodos de acceso a datos para la entidad Capacitacion.
 * Extiende JpaRepository para proporcionar funcionalidades CRUD.
 * 
 * @author Ariel Alfaro, Bastian Muñoz, Bastian Espinosa, Joshua Montt, Nicolas Gajardo
 * @version 1.0
 */
@Repository
public interface CapacitacionRepository extends JpaRepository<Capacitacion, Integer> {
    // Métodos básicos para utilizar el CRUD de JPA.
}
