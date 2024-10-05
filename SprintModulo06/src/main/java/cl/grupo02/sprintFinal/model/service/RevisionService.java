package cl.grupo02.sprintFinal.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.grupo02.sprintFinal.model.entity.Revision;
import cl.grupo02.sprintFinal.repository.RevisionRepository;

import java.util.List;

/**
 * Servicio para gestionar las revisiones.
 * 
 * @autor Ariel Alfaro
 * @autor Bastian Muñoz
 * @autor Bastian Espinosa
 * @autor Joshua Montt
 * @autor Nicolas Gajardo
 * @version 1.0
 */
@Service
public class RevisionService {

    @Autowired
    private RevisionRepository revisionRepository;

    /**
     * Obtiene todas las revisiones con sus visitas y clientes.
     *
     * @return una lista de todas las revisiones con detalles asociados
     */
    public List<Revision> obtenerTodasRevisiones() {
        return revisionRepository.findAllWithVisitaAndCliente();
    }

    /**
     * Guarda una nueva revisión en la base de datos.
     *
     * @param revision el objeto Revision a guardar
     * @return el objeto Revision guardado
     */
    public Revision guardarRevision(Revision revision) {
        return revisionRepository.save(revision);
    }
}
