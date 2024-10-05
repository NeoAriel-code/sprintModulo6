package cl.grupo02.sprintFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import cl.grupo02.sprintFinal.model.entity.Revision;

import java.util.List;

/**
 * Interfaz que define los métodos de acceso a datos para la entidad Revision.
 * Extiende JpaRepository para proporcionar funcionalidades CRUD.
 * 
 * @author Ariel Alfaro, Bastian Muñoz, Bastian Espinosa, Joshua Montt, Nicolas Gajardo
 * @version 1.0
 */
@Repository
public interface RevisionRepository extends JpaRepository<Revision, Integer> {

    /**
     * Consulta para obtener todas las revisiones con sus visitas y clientes.
     * 
     * @return lista de revisiones con visitas y clientes cargados
     */
    @Query("SELECT DISTINCT r FROM Revision r JOIN FETCH r.visita v JOIN FETCH v.cliente c")
    List<Revision> findAllWithVisitaAndCliente();
}
