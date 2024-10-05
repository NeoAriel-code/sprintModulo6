package cl.grupo02.sprintFinal.model.entity;

import javax.persistence.*;

/**
 * Representa un administrativo en la organización.
 * Contiene información relevante sobre el área en la que trabaja el administrativo y su experiencia previa.
 * Está asociado a un usuario mediante una relación de uno a uno.
 * 
 * @author Ariel Alfaro, Bastian Muñoz, Bastian Espinosa, Joshua Montt, Nicolas Gajardo
 * @version 1.0
 */
@Entity
@Table(name = "administrativos")
public class Administrativo {

    /**
     * Identificador único del administrativo.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdministrativo;

    /**
     * Clave foránea que referencia al usuario asociado.
     */
    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    /**
     * Área en la que trabaja el administrativo.
     */
    private String areaAdministrativo;

    /**
     * Experiencia previa del administrativo.
     */
    private String experienciaPrevia;

    /**
     * Constructor vacío. Crea una instancia de Administrativo sin inicializar los atributos.
     */
    public Administrativo() {
        super();
    }

    /**
     * Constructor con parámetros. Crea una instancia de Administrativo con los atributos especificados.
     *
     * @param idAdministrativo Identificador único del administrativo.
     * @param usuario Usuario asociado al administrativo.
     * @param areaAdministrativo Área en la que trabaja el administrativo.
     * @param experienciaPrevia Experiencia previa del administrativo.
     */
    public Administrativo(Integer idAdministrativo, Usuario usuario, String areaAdministrativo, String experienciaPrevia) {
        this.idAdministrativo = idAdministrativo;
        this.usuario = usuario;
        this.areaAdministrativo = areaAdministrativo;
        this.experienciaPrevia = experienciaPrevia;
    }

    /**
     * Obtiene el identificador único del administrativo.
     * 
     * @return idAdministrativo Identificador del administrativo.
     */
    public Integer getIdAdministrativo() {
        return idAdministrativo;
    }

    /**
     * Establece el identificador único del administrativo.
     * 
     * @param idAdministrativo Identificador del administrativo.
     */
    public void setIdAdministrativo(Integer idAdministrativo) {
        this.idAdministrativo = idAdministrativo;
    }

    /**
     * Obtiene el usuario asociado al administrativo.
     * 
     * @return usuario Usuario asociado.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario asociado al administrativo.
     * 
     * @param usuario Usuario a asociar.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene el área en la que trabaja el administrativo.
     * 
     * @return areaAdministrativo Área del administrativo.
     */
    public String getAreaAdministrativo() {
        return areaAdministrativo;
    }

    /**
     * Establece el área en la que trabaja el administrativo.
     * 
     * @param areaAdministrativo Área del administrativo.
     */
    public void setAreaAdministrativo(String areaAdministrativo) {
        this.areaAdministrativo = areaAdministrativo;
    }

    /**
     * Obtiene la experiencia previa del administrativo.
     * 
     * @return experienciaPrevia Experiencia previa del administrativo.
     */
    public String getExperienciaPrevia() {
        return experienciaPrevia;
    }

    /**
     * Establece la experiencia previa del administrativo.
     * 
     * @param experienciaPrevia Experiencia previa del administrativo.
     */
    public void setExperienciaPrevia(String experienciaPrevia) {
        this.experienciaPrevia = experienciaPrevia;
    }

}
