package cl.grupo02.sprintFinal.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import cl.grupo02.sprintFinal.model.entity.Usuario;

@ControllerAdvice
	public class GlobalControllerAdvice {

	    @ModelAttribute("usuario")
	    public Usuario getUsuario(HttpSession session) {
	        return (Usuario) session.getAttribute("usuario");
	    }
}
