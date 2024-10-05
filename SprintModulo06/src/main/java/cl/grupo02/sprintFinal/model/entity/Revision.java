/**
 * Clase que representa una Revisión dentro del sistema.
 * Cada Revisión está asociada a una Visita y contiene información sobre su nombre, detalles y estado.
 *
 * @author Ariel Alfaro, Bastian Muñoz, Bastian Espinosa, Joshua Montt, Nicolas Gajardo
 * @version 1.0
 */
package cl.grupo02.sprintFinal.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "revisiones")
public class Revision implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRevision")
    private int idRevision;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idVisita", nullable = false)
    private Visita visita;

    @NotBlank(message = "El nombre de la revisión es obligatorio.")
    @Size(max = 50, message = "El nombre de la revisión no debe exceder 50 caracteres.")
    @Column(name = "nombreRevision", length = 50, nullable = false)
    private String nombreRevision;

    @NotBlank(message = "El detalle de la revisión es obligatorio.")
    @Size(max = 500, message = "El detalle de la revisión no debe exceder 500 caracteres.")
    @Column(name = "detalleRevision", length = 500, nullable = false)
    private String detalleRevision;

    @NotBlank(message = "El estado de la revisión es obligatorio.")
    @Size(max = 20, message = "El estado de la revisión no debe exceder 20 caracteres.")
    @Column(name = "estadoRevision", length = 20, nullable = false)
    private String estadoRevision;

    // Constructores

    /**
     * Constructor por defecto.
     */
    public Revision() {
        super();
    }

    /**
     * Constructor con todos los campos.
     *
     * @param idRevision       ID de la revisión.
     * @param visita           Visita asociada a la revisión.
     * @param nombreRevision   Nombre de la revisión.
     * @param detalleRevision  Detalles de la revisión.
     * @param estadoRevision   Estado de la revisión.
     */
    public Revision(int idRevision, Visita visita,
                    @NotBlank(message = "El nombre de la revisión es obligatorio.") @Size(max = 50, message = "El nombre de la revisión no debe exceder 50 caracteres.") String nombreRevision,
                    @NotBlank(message = "El detalle de la revisión es obligatorio.") @Size(max = 500, message = "El detalle de la revisión no debe exceder 500 caracteres.") String detalleRevision,
                    @NotBlank(message = "El estado de la revisión es obligatorio.") @Size(max = 20, message = "El estado de la revisión no debe exceder 20 caracteres.") String estadoRevision) {
        this.idRevision = idRevision;
        this.visita = visita;
        this.nombreRevision = nombreRevision;
        this.detalleRevision = detalleRevision;
        this.estadoRevision = estadoRevision;
    }

    // Getters y Setters

    /**
     * Obtiene el ID de la revisión.
     *
     * @return ID de la revisión.
     */
    public int getIdRevision() {
        return idRevision;
    }

    /**
     * Establece el ID de la revisión.
     *
     * @param idRevision El ID de la revisión.
     */
    public void setIdRevision(int idRevision) {
        this.idRevision = idRevision;
    }

    /**
     * Obtiene la Visita asociada a la revisión.
     *
     * @return Visita asociada.
     */
    public Visita getVisita() {
        return visita;
    }

    /**
     * Establece la Visita asociada a la revisión.
     *
     * @param visita La Visita asociada.
     */
    public void setVisita(Visita visita) {
        this.visita = visita;
    }

    /**
     * Obtiene el nombre de la revisión.
     *
     * @return Nombre de la revisión.
     */
    public String getNombreRevision() {
        return nombreRevision;
    }

    /**
     * Establece el nombre de la revisión.
     *
     * @param nombreRevision El nombre de la revisión.
     */
    public void setNombreRevision(String nombreRevision) {
        this.nombreRevision = nombreRevision;
    }

    /**
     * Obtiene el detalle de la revisión.
     *
     * @return Detalles de la revisión.
     */
    public String getDetalleRevision() {
        return detalleRevision;
    }

    /**
     * Establece el detalle de la revisión.
     *
     * @param detalleRevision El detalle de la revisión.
     */
    public void setDetalleRevision(String detalleRevision) {
        this.detalleRevision = detalleRevision;
    }

    /**
     * Obtiene el estado de la revisión.
     *
     * @return Estado de la revisión.
     */
    public String getEstadoRevision() {
        return estadoRevision;
    }

    /**
     * Establece el estado de la revisión.
     *
     * @param estadoRevision El estado de la revisión.
     */
    public void setEstadoRevision(String estadoRevision) {
        this.estadoRevision = estadoRevision;
    }

    /**
     * Obtiene el valor serialVersionUID.
     *
     * @return serialVersionUID.
     */
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
