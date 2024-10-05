package cl.grupo02.sprintFinal.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.grupo02.sprintFinal.model.entity.Visita;
import cl.grupo02.sprintFinal.repository.VisitaRepository;

/**
 * Servicio para gestionar las visitas.
 * 
 * @autor Ariel Alfaro
 * @autor Bastian Muñoz
 * @autor Bastian Espinosa
 * @autor Joshua Montt
 * @autor Nicolas Gajardo
 * @version 1.0
 */
@Service
public class VisitaService {

    @Autowired
    private VisitaRepository visitaRepository;

    /**
     * Guarda o actualiza una visita en la base de datos.
     *
     * @param visita el objeto Visita a guardar o actualizar
     * @return el objeto Visita guardado o actualizado
     */
    public Visita guardarVisita(Visita visita) {
        return visitaRepository.save(visita);
    }

    /**
     * Obtiene una visita por su identificador.
     *
     * @param idVisita el identificador de la visita
     * @return el objeto Visita si existe, o null si no
     */
    public Visita obtenerVisitaPorId(int idVisita) {
        return visitaRepository.findById(idVisita).orElse(null);
    }

    /**
     * Obtiene todas las visitas con sus revisiones y clientes asociados.
     *
     * @return una lista de todas las visitas con detalles asociados
     */
    @Transactional
    public List<Visita> obtenerTodasVisitas() {
        return visitaRepository.findAllWithClienteAndRevisiones();
    }

    /**
     * Elimina una visita por su identificador.
     *
     * @param id el identificador de la visita a eliminar
     */
    public void eliminarVisita(int id) {
        visitaRepository.deleteById(id);
    }
}
