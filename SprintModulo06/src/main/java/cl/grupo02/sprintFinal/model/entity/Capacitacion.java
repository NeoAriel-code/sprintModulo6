package cl.grupo02.sprintFinal.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Representa una capacitación realizada para una empresa. 
 * Contiene información sobre la empresa, el nombre de la capacitación y detalles adicionales.
 * 
 * @author Ariel Alfaro, Bastian Muñoz, Bastian Espinosa, Joshua Montt, Nicolas Gajardo
 * @version 1.0
 */
@Entity
@Table(name = "capacitaciones")
public class Capacitacion {

    /**
     * Identificador único de la capacitación.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCapacitacion")
    private Integer idCapacitacion;

    /**
     * RUT de la empresa a la que se realizó la capacitación.
     */
    private String rutEmpresa;

    /**
     * Nombre de la capacitación.
     */
    private String nombreCapacitacion;

    /**
     * Detalles adicionales sobre la capacitación.
     */
    private String detalleCapacitacion;

    /**
     * Constructor vacío. Crea una instancia de Capacitacion sin inicializar los atributos.
     */
    public Capacitacion() {
        super();
    }

    /**
     * Constructor con todos los campos, incluyendo el identificador de la capacitación.
     *
     * @param idCapacitacion Identificador único de la capacitación.
     * @param rutEmpresa RUT de la empresa a la que se realizó la capacitación.
     * @param nombreCapacitacion Nombre de la capacitación.
     * @param detalleCapacitacion Detalles adicionales sobre la capacitación.
     */
    public Capacitacion(Integer idCapacitacion, String rutEmpresa, String nombreCapacitacion, String detalleCapacitacion) {
        super();
        this.idCapacitacion = idCapacitacion;
        this.rutEmpresa = rutEmpresa;
        this.nombreCapacitacion = nombreCapacitacion;
        this.detalleCapacitacion = detalleCapacitacion;
    }

    /**
     * Constructor que excluye el identificador de la capacitación.
     *
     * @param rutEmpresa RUT de la empresa a la que se realizó la capacitación.
     * @param nombreCapacitacion Nombre de la capacitación.
     * @param detalleCapacitacion Detalles adicionales sobre la capacitación.
     */
    public Capacitacion(String rutEmpresa, String nombreCapacitacion, String detalleCapacitacion) {
        super();
        this.rutEmpresa = rutEmpresa;
        this.nombreCapacitacion = nombreCapacitacion;
        this.detalleCapacitacion = detalleCapacitacion;
    }

    /**
     * Obtiene el identificador único de la capacitación.
     * 
     * @return idCapacitacion Identificador de la capacitación.
     */
    public Integer getIdCapacitacion() {
        return idCapacitacion;
    }

    /**
     * Establece el identificador único de la capacitación.
     * 
     * @param idCapacitacion Identificador de la capacitación.
     */
    public void setIdCapacitacion(Integer idCapacitacion) {
        this.idCapacitacion = idCapacitacion;
    }

    /**
     * Obtiene el RUT de la empresa a la que se realizó la capacitación.
     * 
     * @return rutEmpresa RUT de la empresa.
     */
    public String getRutEmpresa() {
        return rutEmpresa;
    }

    /**
     * Establece el RUT de la empresa a la que se realizó la capacitación.
     * 
     * @param rutEmpresa RUT de la empresa.
     */
    public void setRutEmpresa(String rutEmpresa) {
        this.rutEmpresa = rutEmpresa;
    }

    /**
     * Obtiene el nombre de la capacitación.
     * 
     * @return nombreCapacitacion Nombre de la capacitación.
     */
    public String getNombreCapacitacion() {
        return nombreCapacitacion;
    }

    /**
     * Establece el nombre de la capacitación.
     * 
     * @param nombreCapacitacion Nombre de la capacitación.
     */
    public void setNombreCapacitacion(String nombreCapacitacion) {
        this.nombreCapacitacion = nombreCapacitacion;
    }

    /**
     * Obtiene los detalles adicionales sobre la capacitación.
     * 
     * @return detalleCapacitacion Detalles de la capacitación.
     */
    public String getDetalleCapacitacion() {
        return detalleCapacitacion;
    }

    /**
     * Establece los detalles adicionales sobre la capacitación.
     * 
     * @param detalleCapacitacion Detalles de la capacitación.
     */
    public void setDetalleCapacitacion(String detalleCapacitacion) {
        this.detalleCapacitacion = detalleCapacitacion;
    }
}
