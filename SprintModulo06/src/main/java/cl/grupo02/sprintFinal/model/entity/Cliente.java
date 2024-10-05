package cl.grupo02.sprintFinal.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Representa un cliente de la empresa. 
 * Contiene información sobre la empresa del cliente, como su nombre, RUT, teléfono, correo, dirección y comuna.
 * También tiene una relación con la entidad Usuario y con una lista de visitas asociadas.
 * 
 * @author Ariel Alfaro, Bastian Muñoz, Bastian Espinosa, Joshua Montt, Nicolas Gajardo
 * @version 1.0
 */
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Identificador único del cliente.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCliente")
    private int idCliente;

    /**
     * Usuario asociado al cliente. La relación es de muchos a uno.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario usuario;

    /**
     * Nombre de la empresa del cliente.
     */
    @Column(name = "nombreEmpresa", length = 50, nullable = false)
    private String nombreEmpresa;

    /**
     * RUT de la empresa del cliente. Es único.
     */
    @Column(name = "rutEmpresa", length = 20, unique = true, nullable = false)
    private String rutEmpresa;

    /**
     * Teléfono de la empresa del cliente.
     */
    @Column(name = "telefonoEmpresa", length = 20)
    private String telefonoEmpresa;

    /**
     * Correo electrónico de la empresa del cliente.
     */
    @Column(name = "correoEmpresa", length = 50)
    private String correoEmpresa;

    /**
     * Dirección de la empresa del cliente.
     */
    @Column(name = "direccionEmpresa", length = 100)
    private String direccionEmpresa;

    /**
     * Comuna donde se ubica la empresa del cliente.
     */
    @Column(name = "comunaEmpresa", length = 50)
    private String comunaEmpresa;

    /**
     * Lista de visitas asociadas al cliente. La relación es de uno a muchos.
     */
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Visita> visitas;

    /**
     * Constructor vacío. Crea una instancia de Cliente sin inicializar los atributos.
     */
    public Cliente() {
    }

    /**
     * Constructor con todos los atributos del cliente, excepto el identificador.
     *
     * @param usuario Usuario asociado al cliente.
     * @param nombreEmpresa Nombre de la empresa del cliente.
     * @param rutEmpresa RUT de la empresa del cliente.
     * @param telefonoEmpresa Teléfono de la empresa del cliente.
     * @param correoEmpresa Correo electrónico de la empresa del cliente.
     * @param direccionEmpresa Dirección de la empresa del cliente.
     * @param comunaEmpresa Comuna donde se ubica la empresa del cliente.
     */
    public Cliente(Usuario usuario, String nombreEmpresa, String rutEmpresa, String telefonoEmpresa, 
                   String correoEmpresa, String direccionEmpresa, String comunaEmpresa) {
        this.usuario = usuario;
        this.nombreEmpresa = nombreEmpresa;
        this.rutEmpresa = rutEmpresa;
        this.telefonoEmpresa = telefonoEmpresa;
        this.correoEmpresa = correoEmpresa;
        this.direccionEmpresa = direccionEmpresa;
        this.comunaEmpresa = comunaEmpresa;
    }

    /**
     * Obtiene el identificador único del cliente.
     * 
     * @return idCliente Identificador del cliente.
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el identificador único del cliente.
     * 
     * @param idCliente Identificador del cliente.
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Obtiene el usuario asociado al cliente.
     * 
     * @return usuario Usuario asociado.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Establece el usuario asociado al cliente.
     * 
     * @param usuario Usuario a asociar.
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene el nombre de la empresa del cliente.
     * 
     * @return nombreEmpresa Nombre de la empresa.
     */
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    /**
     * Establece el nombre de la empresa del cliente.
     * 
     * @param nombreEmpresa Nombre de la empresa.
     */
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    /**
     * Obtiene el RUT de la empresa del cliente.
     * 
     * @return rutEmpresa RUT de la empresa.
     */
    public String getRutEmpresa() {
        return rutEmpresa;
    }

    /**
     * Establece el RUT de la empresa del cliente.
     * 
     * @param rutEmpresa RUT de la empresa.
     */
    public void setRutEmpresa(String rutEmpresa) {
        this.rutEmpresa = rutEmpresa;
    }

    /**
     * Obtiene el teléfono de la empresa del cliente.
     * 
     * @return telefonoEmpresa Teléfono de la empresa.
     */
    public String getTelefonoEmpresa() {
        return telefonoEmpresa;
    }

    /**
     * Establece el teléfono de la empresa del cliente.
     * 
     * @param telefonoEmpresa Teléfono de la empresa.
     */
    public void setTelefonoEmpresa(String telefonoEmpresa) {
        this.telefonoEmpresa = telefonoEmpresa;
    }

    /**
     * Obtiene el correo electrónico de la empresa del cliente.
     * 
     * @return correoEmpresa Correo electrónico de la empresa.
     */
    public String getCorreoEmpresa() {
        return correoEmpresa;
    }

    /**
     * Establece el correo electrónico de la empresa del cliente.
     * 
     * @param correoEmpresa Correo electrónico de la empresa.
     */
    public void setCorreoEmpresa(String correoEmpresa) {
        this.correoEmpresa = correoEmpresa;
    }

    /**
     * Obtiene la dirección de la empresa del cliente.
     * 
     * @return direccionEmpresa Dirección de la empresa.
     */
    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    /**
     * Establece la dirección de la empresa del cliente.
     * 
     * @param direccionEmpresa Dirección de la empresa.
     */
    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    /**
     * Obtiene la comuna donde se ubica la empresa del cliente.
     * 
     * @return comunaEmpresa Comuna de la empresa.
     */
    public String getComunaEmpresa() {
        return comunaEmpresa;
    }

    /**
     * Establece la comuna donde se ubica la empresa del cliente.
     * 
     * @param comunaEmpresa Comuna de la empresa.
     */
    public void setComunaEmpresa(String comunaEmpresa) {
        this.comunaEmpresa = comunaEmpresa;
    }

    /**
     * Obtiene la lista de visitas asociadas al cliente.
     * 
     * @return visitas Lista de visitas.
     */
    public List<Visita> getVisitas() {
        return visitas;
    }

    /**
     * Establece la lista de visitas asociadas al cliente.
     * 
     * @param visitas Lista de visitas.
     */
    public void setVisitas(List<Visita> visitas) {
        this.visitas = visitas;
    }
}

