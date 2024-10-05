package cl.grupo02.sprintFinal.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cl.grupo02.sprintFinal.model.entity.Capacitacion;
import cl.grupo02.sprintFinal.model.entity.Cliente;
import cl.grupo02.sprintFinal.model.service.CapacitacionService;
import cl.grupo02.sprintFinal.model.service.ClienteService;

/**
 * Controlador para gestionar las capacitaciones.
 * 
 * @author Ariel Alfaro
 * @author Bastian Muñoz
 * @author Bastian Espinosa
 * @author Joshua Montt
 * @author Nicolas Gajardo
 * @version 1.0
 */
@Controller
@RequestMapping("/capacitaciones")
public class CapacitacionController {

    @Autowired
    private CapacitacionService capacitacionService;
    
	@Autowired
	private ClienteService clienteService;

    /**
     * Lista todas las capacitaciones.
     *
     * @param model el modelo para agregar atributos
     * @return el nombre de la vista para listar las capacitaciones
     */
    @GetMapping
    public String listarCapacitaciones(Model model) {
        // Obtener capacitaciones desde la base de datos
        List<Capacitacion> capacitaciones = capacitacionService.obtenerTodasCapacitaciones();

        // Agregar la lista al modelo
        model.addAttribute("capacitaciones", capacitaciones);

        return "listarCapacitaciones"; // Asegúrate de que esta vista existe
    }

    /**
     * Muestra el formulario para crear una nueva capacitación.
     *
     * @param model el modelo para agregar atributos
     * @return el nombre de la vista para crear una capacitación
     */
    @GetMapping("/nueva")
    public String mostrarFormularioCreacion(Model model) {
    	List<Cliente> clientes = clienteService.obtenerTodosClientes();
    	model.addAttribute("clientes", clientes);
        model.addAttribute("capacitacion", new Capacitacion());
        return "crearCapacitacion";
    }

    /**
     * Procesa la creación de una nueva capacitación.
     *
     * @param capacitacion el objeto de capacitación a crear
     * @param result el resultado de la validación
     * @param redirectAttributes atributos para redirección
     * @param model el modelo para agregar atributos
     * @return redirecciona a la lista de capacitaciones o muestra el formulario con errores
     */
    @PostMapping
    public String crearCapacitacion(@Valid @ModelAttribute("capacitacion") Capacitacion capacitacion,
                                    BindingResult result,
                                    RedirectAttributes redirectAttributes,
                                    Model model) {
        if (result.hasErrors()) {
            return "crearCapacitacion";
        }

        try {
            capacitacionService.guardarCapacitacion(capacitacion);
            redirectAttributes.addFlashAttribute("mensaje", "Capacitación creada exitosamente.");

            return "redirect:/capacitaciones";
        } catch (Exception e) {
            model.addAttribute("error", "Ocurrió un error al crear la capacitación: " + e.getMessage());
            return "crearCapacitacion";
        }
    }

    /**
     * Muestra los detalles de una capacitación específica.
     *
     * @param id el identificador de la capacitación
     * @param model el modelo para agregar atributos
     * @return el nombre de la vista para ver la capacitación o redirige si no se encuentra
     */
    @GetMapping("/{id}")
    public String verCapacitacion(@PathVariable("id") Integer id, Model model) {
        Optional<Capacitacion> optionalCapacitacion = capacitacionService.obtenerCapacitacionPorId(id);
        if (!optionalCapacitacion.isPresent()) {
            model.addAttribute("error", "Capacitación no encontrada.");
            return "redirect:/capacitaciones";
        }
        model.addAttribute("capacitacion", optionalCapacitacion.get());
        return "verCapacitacion"; // Crea este JSP si lo deseas
    }

    /**
     * Elimina una capacitación específica.
     *
     * @param id el identificador de la capacitación a eliminar
     * @param redirectAttributes atributos para redirección
     * @return redirecciona a la lista de capacitaciones
     */
    @GetMapping("/{id}/eliminar")
    public String eliminarCapacitacion(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        try {
            capacitacionService.eliminarCapacitacion(id);
            redirectAttributes.addFlashAttribute("mensaje", "Capacitación eliminada exitosamente.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error al eliminar la capacitación: " + e.getMessage());
        }
        return "redirect:/capacitaciones";
    }

    /**
     * Muestra el formulario para editar una capacitación existente.
     *
     * @param id el identificador de la capacitación a editar
     * @param model el modelo para agregar atributos
     * @return el nombre de la vista para editar la capacitación o redirige si no se encuentra
     */
    @GetMapping("/{id}/editar")
    public String mostrarFormularioEdicion(@PathVariable("id") Integer id, Model model) {
        Optional<Capacitacion> optionalCapacitacion = capacitacionService.obtenerCapacitacionPorId(id);
        if (!optionalCapacitacion.isPresent()) {
            model.addAttribute("error", "Capacitación no encontrada.");
            return "redirect:/capacitaciones";
        }
        model.addAttribute("capacitacion", optionalCapacitacion.get());
        return "editarCapacitacion"; // Crea este JSP si lo deseas
    }

    /**
     * Procesa la edición de una capacitación existente.
     *
     * @param id el identificador de la capacitación a editar
     * @param capacitacion el objeto de capacitación con los datos actualizados
     * @param result el resultado de la validación
     * @param redirectAttributes atributos para redirección
     * @param model el modelo para agregar atributos
     * @return redirecciona a la lista de capacitaciones o muestra el formulario con errores
     */
    
    @PostMapping("/{id}/editar")
    public String editarCapacitacion(@PathVariable("id") Integer id,
                                     @Valid @ModelAttribute("capacitacion") Capacitacion capacitacion,
                                     BindingResult result,
                                     RedirectAttributes redirectAttributes,
                                     Model model) {
        if (result.hasErrors()) {
            return "editarCapacitacion";
        }

        try {
            capacitacion.setIdCapacitacion(id); // Asegurarse de que el ID es correcto
            capacitacionService.guardarCapacitacion(capacitacion);
            redirectAttributes.addFlashAttribute("mensaje", "Capacitación actualizada exitosamente.");

            return "redirect:/capacitaciones";
        } catch (Exception e) {
            model.addAttribute("error", "Ocurrió un error al actualizar la capacitación: " + e.getMessage());
            return "editarCapacitacion";
        }
    }
}
