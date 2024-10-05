package cl.grupo02.sprintFinal.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.grupo02.sprintFinal.model.entity.Revision;
import cl.grupo02.sprintFinal.model.entity.Visita;
import cl.grupo02.sprintFinal.model.service.RevisionService;
import cl.grupo02.sprintFinal.model.service.VisitaService;

import javax.validation.Valid;

/**
 * Controlador para gestionar las revisiones.
 * 
 * @autor Ariel Alfaro
 * @autor Bastian Muñoz
 * @autor Bastian Espinosa
 * @autor Joshua Montt
 * @autor Nicolas Gajardo
 * @version 1.0
 */
@Controller
public class RevisionController {

    @Autowired
    private RevisionService revisionService;

    @Autowired
    private VisitaService visitaService;

    private static final Logger logger = LogManager.getLogger(RevisionController.class);

    /**
     * Lista todas las revisiones.
     *
     * @param model el modelo para agregar atributos
     * @return el nombre de la vista para listar las revisiones
     */
    @GetMapping("/listarRevisiones")
    public String listarRevisiones(Model model) {
        List<Revision> revisiones = revisionService.obtenerTodasRevisiones();
        model.addAttribute("revisiones", revisiones);
        return "listarRevisiones"; // Asegúrate de tener esta vista creada
    }

    /**
     * Muestra el formulario para crear una nueva revisión.
     *
     * @param model el modelo para agregar atributos
     * @param idVisita el identificador de la visita asociada
     * @return el nombre de la vista para crear una revisión
     */
    @GetMapping("/crearRevision")
    public String mostrarCrearRevision(Model model, @RequestParam("idVisita") int idVisita) {
        Revision revision = new Revision();
        Visita visita = visitaService.obtenerVisitaPorId(idVisita);
        if (visita == null) {
            // Manejar el caso donde la visita no existe
            model.addAttribute("error", "Visita no encontrada.");
            return "redirect:/listarVisitas"; // O la vista que consideres apropiada
        }
        revision.setVisita(visita);
        model.addAttribute("revision", revision);
        return "crearRevision";
    }

    /**
     * Procesa la creación de una nueva revisión.
     *
     * @param revision el objeto de revisión a crear
     * @param bindingResult el resultado de la validación
     * @param idVisita el identificador de la visita asociada
     * @param model el modelo para agregar atributos
     * @param redirectAttributes atributos para redirección
     * @return redirige a la lista de revisiones o muestra el formulario con errores
     */
    @PostMapping("/crearRevision")
    public String crearRevision(@Valid Revision revision, 
                                BindingResult bindingResult, 
                                @RequestParam("visita.idVisita") int idVisita, 
                                Model model, 
                                RedirectAttributes redirectAttributes) {
        // Obtener la Visita por ID
        Visita visita = visitaService.obtenerVisitaPorId(idVisita);
        if (visita == null) {
            bindingResult.rejectValue("visita", "error.revision", "Visita no encontrada.");
        } else {
            revision.setVisita(visita);
        }

        if (bindingResult.hasErrors()) {
            // Retornar a la vista de creación con los errores de validación
            model.addAttribute("revision", revision);
            return "crearRevision";
        }

        try {
            // Guardar la revisión en la base de datos
            Revision nuevaRevision = revisionService.guardarRevision(revision);
            logger.info("Revisión guardada con éxito: " + nuevaRevision.getIdRevision());

            // Configurar un mensaje de éxito
            String mensaje = "Revisión creada exitosamente.";

            // Añadir el mensaje como Flash Attribute
            redirectAttributes.addFlashAttribute("mensaje", mensaje);

            // Redirigir a la vista que lista las revisiones
            return "redirect:/listarRevisiones";
        } catch (Exception e) {
            logger.error("Error al guardar la revisión: ", e);
            // Configurar un mensaje de error
            String error = "Ha ocurrido un error al guardar la revisión. Por favor, inténtalo de nuevo.";

            // Añadir el mensaje como Flash Attribute
            redirectAttributes.addFlashAttribute("error", error);

            // Retornar a la vista de creación con el idVisita
            return "redirect:/crearRevision?idVisita=" + idVisita;
        }
    }

}
