package cl.grupo02.sprintFinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.grupo02.sprintFinal.model.entity.Capacitacion;
import cl.grupo02.sprintFinal.model.entity.Usuario;
import cl.grupo02.sprintFinal.model.service.CapacitacionService;
import cl.grupo02.sprintFinal.model.service.UsuarioService;

/**
 * Controlador REST para exponer APIs de usuarios y capacitaciones.
 * 
 * @autor Ariel Alfaro
 * @autor Bastian Muñoz
 * @autor Bastian Espinosa
 * @autor Joshua Montt
 * @autor Nicolas Gajardo
 * @version 1.0
 */
@RestController
public class RestAPIController {
	
	@Autowired
	private UsuarioService usuarioService;

	/**
	 * Obtiene todos los usuarios en formato JSON.
	 *
	 * @return una lista de usuarios
	 */
	@RequestMapping(value="/api/usuarios", headers = "Accept=application/json")
	public List<Usuario> getUsuarios(){
		return usuarioService.obtenerTodosUsuarios();	
	}
	
	@Autowired
	private CapacitacionService capacitacionService;

	/**
	 * Obtiene todas las capacitaciones en formato JSON.
	 *
	 * @return una lista de capacitaciones
	 */
	@RequestMapping(value="/api/capacitaciones", headers = "Accept=application/json")
	public List<Capacitacion> getCapacitaciones(){
		return capacitacionService.obtenerTodasCapacitaciones();	
	}
	
}
