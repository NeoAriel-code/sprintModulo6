package cl.grupo02.sprintFinal.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Controlador global para manejar excepciones en la aplicación.
 * 
 * @autor Ariel Alfaro
 * @autor Bastian Muñoz
 * @autor Bastian Espinosa
 * @autor Joshua Montt
 * @autor Nicolas Gajardo
 * @version 1.0
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Maneja las excepciones de tipo IllegalArgumentException.
     *
     * @param e la excepción capturada
     * @param model el modelo para agregar atributos
     * @return el nombre de la vista de error
     */
    @ExceptionHandler(IllegalArgumentException.class)
    public String manejarIllegalArgumentException(IllegalArgumentException e, Model model) {
        model.addAttribute("error", e.getMessage());
        return "error"; // Nombre de la vista de error
    }

    // Otros métodos para manejar diferentes excepciones
}
