/**
 * Clase que representa el formulario para la creación o actualización de un usuario.
 * Contiene los datos comunes para todos los tipos de usuarios (administrativo, cliente, profesional),
 * así como campos específicos para cada tipo.
 *
 * @author Ariel Alfaro, Bastian Muñoz, Bastian Espinosa, Joshua Montt, Nicolas Gajardo
 * @version 1.0
 */
package cl.grupo02.sprintFinal.model.entity;

import javax.validation.constraints.NotEmpty;
import cl.grupo02.sprintFinal.repository.UsuarioRepository.ValidacionCrear;

public class FormularioUsuario {

    private Integer idUsuario;

    @NotEmpty(message = "El nombre es obligatorio")
    private String nombreUsuario;

    @NotEmpty(message = "El apellido es obligatorio")
    private String apellidoUsuario;

    @NotEmpty(message = "El nickname es obligatorio")
    private String nickname;

    @NotEmpty(message = "La contraseña es obligatoria", groups = ValidacionCrear.class)
    private String contrasena;

    @NotEmpty(message = "El RUN es obligatorio")
    private String runUsuario;

    @NotEmpty(message = "El correo es obligatorio")
    private String correoUsuario;

    @NotEmpty(message = "El teléfono es obligatorio")
    private String telefonoUsuario;

    @NotEmpty(message = "El tipo de usuario es obligatorio")
    private String tipoUsuario;

    // Campos específicos para Administrativo
    private String areaAdministrativo;
    private String experienciaPrevia;

    // Campos específicos para Cliente
    private String nombreEmpresa;
    private String rutEmpresa;
    private String telefonoEmpresa;
    private String correoEmpresa;
    private String direccionEmpresa;
    private String comunaEmpresa;

    // Campos específicos para Profesional
    private String tituloProfesional;
    private String fechaIngresoProfesional;

    /**
     * Constructor por defecto.
     */
    public FormularioUsuario() {}

    // Getters y Setters

    /**
     * Obtiene el ID del usuario.
     * @return ID del usuario.
     */
    public Integer getIdUsuario() {
        return idUsuario;
    }

    /**
     * Establece el ID del usuario.
     * @param idUsuario El ID del usuario.
     */
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    // Campos comunes

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRunUsuario() {
        return runUsuario;
    }

    public void setRunUsuario(String runUsuario) {
        this.runUsuario = runUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getTelefonoUsuario() {
        return telefonoUsuario;
    }

    public void setTelefonoUsuario(String telefonoUsuario) {
        this.telefonoUsuario = telefonoUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    // Campos específicos para Administrativo
    public String getAreaAdministrativo() {
        return areaAdministrativo;
    }

    public void setAreaAdministrativo(String areaAdministrativo) {
        this.areaAdministrativo = areaAdministrativo;
    }

    public String getExperienciaPrevia() {
        return experienciaPrevia;
    }

    public void setExperienciaPrevia(String experienciaPrevia) {
        this.experienciaPrevia = experienciaPrevia;
    }

    // Campos específicos para Cliente
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getRutEmpresa() {
        return rutEmpresa;
    }

    public void setRutEmpresa(String rutEmpresa) {
        this.rutEmpresa = rutEmpresa;
    }

    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    public String getCorreoEmpresa() {
        return correoEmpresa;
    }

    public void setCorreoEmpresa(String correoEmpresa) {
        this.correoEmpresa = correoEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    public String getComunaEmpresa() {
        return comunaEmpresa;
    }

    public void setComunaEmpresa(String comunaEmpresa) {
        this.comunaEmpresa = comunaEmpresa;
    }

    // Campos específicos para Profesional
    public String getTituloProfesional() {
        return tituloProfesional;
    }

    public void setTituloProfesional(String tituloProfesional) {
        this.tituloProfesional = tituloProfesional;
    }

    public String getFechaIngresoProfesional() {
        return fechaIngresoProfesional;
    }

    public void setFechaIngresoProfesional(String fechaIngresoProfesional) {
        this.fechaIngresoProfesional = fechaIngresoProfesional;
    }
}
