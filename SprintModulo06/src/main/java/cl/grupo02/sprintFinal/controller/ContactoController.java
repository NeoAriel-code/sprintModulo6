package cl.grupo02.sprintFinal.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controlador para gestionar el formulario de contacto.
 * 
 * @autor Ariel Alfaro
 * @autor Bastian Muñoz
 * @autor Bastian Espinosa
 * @autor Joshua Montt
 * @autor Nicolas Gajardo
 * @version 1.0
 */
@Controller
public class ContactoController {

    /**
     * Muestra la página de contacto.
     *
     * @param request la solicitud HTTP
     * @return el nombre de la vista de contacto
     */
    @GetMapping(path = { "/contacto" })
    public String mostrarContacto(HttpServletRequest request) {
        // Mostrar página
        return "contacto";
    }

    /**
     * Procesa el envío del formulario de contacto.
     *
     * @param email el correo electrónico del usuario
     * @param nombre el nombre del usuario
     * @param asunto el asunto del mensaje
     * @param mensaje el contenido del mensaje
     * @return el objeto ModelAndView con la vista de contacto y el mensaje de confirmación
     */
    @RequestMapping(path = {"/contacto"})
    public ModelAndView crearContacto(@RequestParam("email") String email, 
                                      @RequestParam("nombre") String nombre,
                                      @RequestParam("asunto") String asunto, 
                                      @RequestParam("mensaje") String mensaje) {
        ModelAndView modelAndView = new ModelAndView("contacto");

        // Imprimir los datos recibidos por consola
        System.out.println("===== Datos del Formulario de Contacto =====");
        System.out.println("Correo Electrónico: " + email);
        System.out.println("Nombre: " + nombre);
        System.out.println("Asunto: " + asunto);
        System.out.println("Mensaje: " + mensaje);
        System.out.println("==========================================");

        // Mensaje fijo de confirmación para la vista
        modelAndView.addObject("mensaje", "Formulario de contacto enviado correctamente.");

        return modelAndView;
    }
}
