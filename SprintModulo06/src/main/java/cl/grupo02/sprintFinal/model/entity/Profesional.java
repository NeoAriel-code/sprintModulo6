/**
 * Clase que representa un Profesional en el sistema.
 * Un Profesional está asociado a un Usuario y tiene información sobre su título y fecha de ingreso.
 *
 * @author Ariel Alfaro, Bastian Muñoz, Bastian Espinosa, Joshua Montt, Nicolas Gajardo
 * @version 1.0
 */
package cl.grupo02.sprintFinal.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "profesionales")
public class Profesional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProfesional;

    // Clave foránea a Usuario
    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    private String tituloProfesional;
    private String fechaIngresoProfesional;

    /**
     * Constructor por defecto.
     */
    public Profesional() {
        super();
    }

    /**
     * Constructor con todos los campos.
     * 
     * @param idProfesional        ID del profesional (autogenerado).
     * @param usuario              Usuario asociado al profesional.
     * @param tituloProfesional    Título profesional del usuario.
     * @param fechaIngresoProfesional Fecha de ingreso del profesional.
     */
    public Profesional(Integer idProfesional, Usuario usuario, String tituloProfesional, String fechaIngresoProfesional) {
        this.idProfesional = idProfesional;
        this.usuario = usuario;
        this.tituloProfesional = tituloProfesional;
        this.fechaIngresoProfesional = fechaIngresoProfesional;
    }

    // Getters y Setters

    /**
     * Obtiene el ID del profesional.
     * 
     * @return ID del profesional.
     */
    public Integer getIdProfesional() {
        return idProfesional;
    }

    /**
     * Establece el ID del profesional.
     * 
     * @param idProfesional El ID del profesional.
     */
    public void setIdProfesional(Integer idProfesional) {
        this.idProfesional = idProfesional;
    }

    /**
     * Obtiene el Usuario asociado al profesional.
     * 
     * @return Usuario asociado.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el Usuario asociado al profesional.
     * 
     * @param usuario El Usuario asociado.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene el título profesional del profesional.
     * 
     * @return Título profesional.
     */
    public String getTituloProfesional() {
        return tituloProfesional;
    }

    /**
     * Establece el título profesional del profesional.
     * 
     * @param tituloProfesional El título profesional.
     */
    public void setTituloProfesional(String tituloProfesional) {
        this.tituloProfesional = tituloProfesional;
    }

    /**
     * Obtiene la fecha de ingreso del profesional.
     * 
     * @return Fecha de ingreso del profesional.
     */
    public String getFechaIngresoProfesional() {
        return fechaIngresoProfesional;
    }

    /**
     * Establece la fecha de ingreso del profesional.
     * 
     * @param fechaIngresoProfesional La fecha de ingreso del profesional.
     */
    public void setFechaIngresoProfesional(String fechaIngresoProfesional) {
        this.fechaIngresoProfesional = fechaIngresoProfesional;
    }
}
