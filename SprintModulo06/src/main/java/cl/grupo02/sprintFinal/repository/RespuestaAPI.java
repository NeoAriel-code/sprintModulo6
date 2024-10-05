package cl.grupo02.sprintFinal.repository;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Clase que representa una respuesta API genérica.
 * Incluye información sobre el estado HTTP, método y mensaje de la respuesta.
 * 
 * @author Ariel Alfaro, Bastian Muñoz, Bastian Espinosa, Joshua Montt, Nicolas Gajardo
 * @version 1.0
 */
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class RespuestaAPI {

    /** Marca de tiempo que representa la fecha cuando se generó la respuesta */
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", shape = JsonFormat.Shape.STRING)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime timestamp;

    /** Objeto {@link HttpStatus} que representa el estado de la respuesta */
    private HttpStatus httpStatus;

    /** Código del estado HTTP */
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int httpStatusCode;

    /** Método que se ejecutó para generar la respuesta */
    private String method;

    /** Mensaje de la respuesta */
    private String message;

    // Constructores
    public RespuestaAPI() {
        timestamp = LocalDateTime.now();
        httpStatus = HttpStatus.OK;
        httpStatusCode = httpStatus.value();
        method = null;
        message = null;
    }

    public RespuestaAPI(HttpStatus httpStatus, String method, String message) {
        this();
        this.httpStatus = httpStatus;
        this.httpStatusCode = httpStatus.value();
        this.method = method;
        this.message = message;
    }

    // Getters
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public String getMethod() {
        return method;
    }

    public String getMessage() {
        return message;
    }

    // Setters
    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.httpStatusCode = httpStatus.value();
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    // Herencias (Object)
    @Override
    public String toString() {
        return "RespuestaAPI [timestamp=" + timestamp + ", httpStatus=" + httpStatus + ", httpStatusCode="
                + httpStatusCode + ", method=" + method + ", message=" + message + "]";
    }
}
