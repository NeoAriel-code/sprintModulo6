/**
 * Clase que representa un Usuario dentro del sistema. 
 * Un Usuario puede tener relaciones uno a uno con las entidades Cliente, Profesional y Administrativo.
 * Cada usuario posee un nickname, contraseña, run, entre otros atributos personales.
 *
 * @author Ariel Alfaro, Bastian Muñoz, Bastian Espinosa, Joshua Montt, Nicolas Gajardo
 * @version 1.0
 */
package cl.grupo02.sprintFinal.model.entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    private String nombreUsuario;
    private String apellidoUsuario;
    private String nickname;
    private String contrasena;
    private String runUsuario;
    private String correoUsuario;
    private String telefonoUsuario;
    private String tipoUsuario;

    // Relaciones uno a uno con las entidades hijas
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Cliente cliente;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Profesional profesional;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Administrativo administrativo;

    // Constructores

    /**
     * Constructor por defecto.
     */
    public Usuario() {
        super();
    }

    /**
     * Constructor con todos los atributos.
     *
     * @param idUsuario     ID del usuario.
     * @param nombreUsuario Nombre del usuario.
     * @param apellidoUsuario Apellido del usuario.
     * @param nickname      Apodo o nombre de usuario.
     * @param contrasena    Contraseña del usuario.
     * @param runUsuario    RUN del usuario.
     * @param correoUsuario Correo del usuario.
     * @param telefonoUsuario Teléfono del usuario.
     * @param tipoUsuario   Tipo de usuario (Cliente, Profesional o Administrativo).
     * @param cliente       Relación uno a uno con Cliente.
     * @param profesional   Relación uno a uno con Profesional.
     * @param administrativo Relación uno a uno con Administrativo.
     */
    public Usuario(Integer idUsuario, String nombreUsuario, String apellidoUsuario, String nickname, String contrasena,
                   String runUsuario, String correoUsuario, String telefonoUsuario, String tipoUsuario, 
                   Cliente cliente, Profesional profesional, Administrativo administrativo) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.nickname = nickname;
        this.contrasena = contrasena;
        this.runUsuario = runUsuario;
        this.correoUsuario = correoUsuario;
        this.telefonoUsuario = telefonoUsuario;
        this.tipoUsuario = tipoUsuario;
        this.cliente = cliente;
        this.profesional = profesional;
        this.administrativo = administrativo;
    }

    // Getters y Setters

    /**
     * Obtiene el ID del usuario.
     *
     * @return ID del usuario.
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el ID del usuario.
     *
     * @param idUsuario ID del usuario.
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return Nombre del usuario.
     */
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    /**
     * Establece el nombre del usuario.
     *
     * @param nombreUsuario Nombre del usuario.
     */
    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    /**
     * Obtiene el apellido del usuario.
     *
     * @return Apellido del usuario.
     */
    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    /**
     * Establece el apellido del usuario.
     *
     * @param apellidoUsuario Apellido del usuario.
     */
    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    /**
     * Obtiene el nickname del usuario.
     *
     * @return Nickname del usuario.
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Establece el nickname del usuario.
     *
     * @param nickname Nickname del usuario.
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * Obtiene la contraseña del usuario.
     *
     * @return Contraseña del usuario.
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece la contraseña del usuario.
     *
     * @param contrasena Contraseña del usuario.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el RUN del usuario.
     *
     * @return RUN del usuario.
     */
    public String getRunUsuario() {
        return runUsuario;
    }

    /**
     * Establece el RUN del usuario.
     *
     * @param runUsuario RUN del usuario.
     */
    public void setRunUsuario(String runUsuario) {
        this.runUsuario = runUsuario;
    }

    /**
     * Obtiene el correo del usuario.
     *
     * @return Correo del usuario.
     */
    public String getCorreoUsuario() {
        return correoUsuario;
    }

    /**
     * Establece el correo del usuario.
     *
     * @param correoUsuario Correo del usuario.
     */
    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    /**
     * Obtiene el teléfono del usuario.
     *
     * @return Teléfono del usuario.
     */
    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    /**
     * Establece el teléfono del usuario.
     *
     * @param telefonoUsuario Teléfono del usuario.
     */
    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    /**
     * Obtiene el tipo de usuario.
     *
     * @return Tipo de usuario.
     */
    public String getTipoUsuario() {
        return tipoUsuario;
    }

    /**
     * Establece el tipo de usuario.
     *
     * @param tipoUsuario Tipo de usuario.
     */
    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    /**
     * Obtiene la relación con Cliente.
     *
     * @return Relación uno a uno con Cliente.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece la relación con Cliente.
     *
     * @param cliente Relación uno a uno con Cliente.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene la relación con Profesional.
     *
     * @return Relación uno a uno con Profesional.
     */
    public Profesional getProfesional() {
        return profesional;
    }

    /**
     * Establece la relación con Profesional.
     *
     * @param profesional Relación uno a uno con Profesional.
     */
    public void setProfesional(Profesional profesional) {
        this.profesional = profesional;
    }

    /**
     * Obtiene la relación con Administrativo.
     *
     * @return Relación uno a uno con Administrativo.
     */
    public Administrativo getAdministrativo() {
        return administrativo;
    }

    /**
     * Establece la relación con Administrativo.
     *
     * @param administrativo Relación uno a uno con Administrativo.
     */
    public void setAdministrativo(Administrativo administrativo) {
        this.administrativo = administrativo;
    }
}
