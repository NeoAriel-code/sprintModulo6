/**
 * Clase que representa una Visita en el sistema. 
 * Cada visita está asociada a un cliente y puede tener múltiples revisiones.
 * Incluye información sobre el día, hora, lugar y comentario de la visita.
 * 
 * @author Ariel Alfaro, Bastian Muñoz, Bastian Espinosa, Joshua Montt, Nicolas Gajardo
 * @version 1.0
 */
package cl.grupo02.sprintFinal.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "visitas")
public class Visita implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idVisita")
    private int idVisita;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente", nullable = false) // Usar idCliente como FK
    private Cliente cliente;

    @NotBlank(message = "El día de la visita es obligatorio.")
    @Size(max = 20, message = "El día de la visita no debe exceder 20 caracteres.")
    @Column(name = "diaVisita", length = 20, nullable = false)
    private String diaVisita;

    @NotBlank(message = "La hora de la visita es obligatoria.")
    @Size(max = 20, message = "La hora de la visita no debe exceder 20 caracteres.")
    @Column(name = "horaVisita", length = 20, nullable = false)
    private String horaVisita;

    @NotBlank(message = "El lugar es obligatorio.")
    @Size(max = 50, message = "El lugar no debe exceder 50 caracteres.")
    @Column(name = "lugar", length = 50, nullable = false)
    private String lugar;

    @NotBlank(message = "El comentario es obligatorio.")
    @Size(max = 100, message = "El comentario no debe exceder 100 caracteres.")
    @Column(name = "comentario", nullable = false, length = 100)
    private String comentario;

    @OneToMany(mappedBy = "visita", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Revision> revisiones;

    // Constructores

    /**
     * Constructor por defecto.
     */
    public Visita() {
        super();
    }

    /**
     * Constructor con todos los atributos.
     *
     * @param idVisita     ID de la visita.
     * @param cliente      Cliente asociado a la visita.
     * @param diaVisita    Día de la visita.
     * @param horaVisita   Hora de la visita.
     * @param lugar        Lugar de la visita.
     * @param comentario   Comentario sobre la visita.
     * @param revisiones   Lista de revisiones asociadas a la visita.
     */
    public Visita(int idVisita, Cliente cliente,
                  @NotBlank(message = "El día de la visita es obligatorio.") @Size(max = 20, message = "El día de la visita no debe exceder 20 caracteres.") String diaVisita,
                  @NotBlank(message = "La hora de la visita es obligatoria.") @Size(max = 20, message = "La hora de la visita no debe exceder 20 caracteres.") String horaVisita,
                  @NotBlank(message = "El lugar es obligatorio.") @Size(max = 50, message = "El lugar no debe exceder 50 caracteres.") String lugar,
                  @NotBlank(message = "El comentario es obligatorio.") @Size(max = 100, message = "El comentario no debe exceder 100 caracteres.") String comentario,
                  List<Revision> revisiones) {
        super();
        this.idVisita = idVisita;
        this.cliente = cliente;
        this.diaVisita = diaVisita;
        this.horaVisita = horaVisita;
        this.lugar = lugar;
        this.comentario = comentario;
        this.revisiones = revisiones;
    }

    // Getters y Setters

    /**
     * Obtiene el ID de la visita.
     *
     * @return ID de la visita.
     */
    public int getIdVisita() {
        return idVisita;
    }

    /**
     * Establece el ID de la visita.
     *
     * @param idVisita ID de la visita.
     */
    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    /**
     * Obtiene el cliente asociado a la visita.
     *
     * @return Cliente asociado a la visita.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Establece el cliente asociado a la visita.
     *
     * @param cliente Cliente asociado a la visita.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtiene el día de la visita.
     *
     * @return Día de la visita.
     */
    public String getDiaVisita() {
        return diaVisita;
    }

    /**
     * Establece el día de la visita.
     *
     * @param diaVisita Día de la visita.
     */
    public void setDiaVisita(String diaVisita) {
        this.diaVisita = diaVisita;
    }

    /**
     * Obtiene la hora de la visita.
     *
     * @return Hora de la visita.
     */
    public String getHoraVisita() {
        return horaVisita;
    }

    /**
     * Establece la hora de la visita.
     *
     * @param horaVisita Hora de la visita.
     */
    public void setHoraVisita(String horaVisita) {
        this.horaVisita = horaVisita;
    }

    /**
     * Obtiene el lugar de la visita.
     *
     * @return Lugar de la visita.
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * Establece el lugar de la visita.
     *
     * @param lugar Lugar de la visita.
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * Obtiene el comentario sobre la visita.
     *
     * @return Comentario sobre la visita.
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Establece el comentario sobre la visita.
     *
     * @param comentario Comentario sobre la visita.
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * Obtiene la lista de revisiones asociadas a la visita.
     *
     * @return Lista de revisiones.
     */
    public List<Revision> getRevisiones() {
        return revisiones;
    }

    /**
     * Establece la lista de revisiones asociadas a la visita.
     *
     * @param revisiones Lista de revisiones.
     */
    public void setRevisiones(List<Revision> revisiones) {
        this.revisiones = revisiones;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
