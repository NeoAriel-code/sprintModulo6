package cl.grupo02.sprintFinal.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controlador para gestionar la página de inicio.
 * 
 * @author Ariel Alfaro
 * @author Bastian Muñoz
 * @author Bastian Espinosa
 * @author Joshua Montt
 * @author Nicolas Gajardo
 * @version 1.0
 */
@Controller
public class HomeController {

    private static final Logger logger = LogManager.getLogger(HomeController.class);

    /**
     * Muestra la página de inicio.
     *
     * @param request la solicitud HTTP
     * @return el nombre de la vista de inicio
     */
    @GetMapping(path = {"/"})
    public String paginaInicio(HttpServletRequest request) {
        // Depuración
        logger.info("Solicitud GET: {}", request.getRequestURI());

        // Mostrar página
        return "home";
    }

}
