package cl.grupo02.sprintFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import cl.grupo02.sprintFinal.model.entity.Visita;

import java.util.List;

/**
 * Interfaz que define los métodos de acceso a datos para la entidad Visita.
 * Extiende JpaRepository para proporcionar funcionalidades CRUD.
 * 
 * @author Ariel Alfaro, Bastian Muñoz, Bastian Espinosa, Joshua Montt, Nicolas Gajardo
 * @version 1.0
 */
@Repository
public interface VisitaRepository extends JpaRepository<Visita, Integer> {

    /**
     * Consulta para obtener todas las visitas con sus clientes y revisiones.
     * 
     * @return lista de visitas con clientes y revisiones cargados
     */
    @Query("SELECT v FROM Visita v JOIN FETCH v.cliente LEFT JOIN FETCH v.revisiones")
    List<Visita> findAllWithClienteAndRevisiones();
}
