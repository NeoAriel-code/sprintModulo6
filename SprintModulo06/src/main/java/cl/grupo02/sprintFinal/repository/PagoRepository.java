package cl.grupo02.sprintFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cl.grupo02.sprintFinal.model.entity.Pago;

/**
 * Interfaz que define los métodos de acceso a datos para la entidad Pago.
 * Extiende JpaRepository para proporcionar funcionalidades CRUD.
 * 
 * @author Ariel Alfaro, Bastian Muñoz, Bastian Espinosa, Joshua Montt, Nicolas Gajardo
 * @version 1.0
 */
@Repository
public interface PagoRepository extends JpaRepository<Pago, Integer> {
    // Métodos básicos para utilizar el CRUD de JPA.
}
