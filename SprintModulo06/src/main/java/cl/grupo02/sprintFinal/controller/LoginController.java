package cl.grupo02.sprintFinal.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controlador para gestionar la autenticación de usuarios.
 * 
 * @author 
 *         Ariel Alfaro, 
 *         Bastian Muñoz, 
 *         Bastian Espinosa, 
 *         Joshua Montt, 
 *         Nicolas Gajardo
 * @version 1.0
 */
@Controller
public class LoginController {
	
    /** 
     * Objeto {@link Logger} que contiene los métodos de depuración 
     */
    private static final Logger logger = LogManager.getLogger(LoginController.class);

    /**
     * Muestra la página de inicio de sesión.
     *
     * @return un objeto {@link ModelAndView} que redirige a la vista de login
     */
	@RequestMapping(value = { "/login" })
	public ModelAndView mostrarLogin() {
		return new ModelAndView("login");
	}

    /**
     * Maneja los errores de inicio de sesión.
     *
     * @return un objeto {@link ModelAndView} que redirige a la vista de login con un mensaje de error
     */
	@RequestMapping(value = { "/error" })
	public ModelAndView errorLogin() {
		return new ModelAndView("login", "error", "true");
	}

    /**
     * Procesa el cierre de sesión exitoso.
     *
     * @param request la solicitud HTTP
     * @return un objeto {@link ModelAndView} que redirige a la vista de confirmación de cierre de sesión
     */
	@GetMapping(value = { "/logout-success"})
	public ModelAndView logout(HttpServletRequest request) {
        logger.info("Solicitud GET: {}", request.getRequestURI());
    	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    	if (auth != null) {
    		SecurityContextHolder.getContext().setAuthentication(null);
    	}
        // Mostrar página
        return new ModelAndView("logout-success");
	}
}
