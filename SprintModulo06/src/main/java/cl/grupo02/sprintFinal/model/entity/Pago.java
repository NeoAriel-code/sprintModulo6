/**
 * Clase que representa un pago realizado por una empresa.
 * Incluye información como el monto, fecha y detalle del pago.
 *
 * @author Ariel Alfaro, Bastian Muñoz, Bastian Espinosa, Joshua Montt, Nicolas Gajardo
 * @version 1.0
 */
package cl.grupo02.sprintFinal.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pagos")
public class Pago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPago")
    private int idPago;

    private String rutEmpresa;
    private int monto;
    private String fecha;
    private String detallePago;

    /**
     * Constructor por defecto.
     */
    public Pago() {
        super();
    }

    /**
     * Constructor con todos los parámetros.
     * 
     * @param idPago       ID del pago (autogenerado).
     * @param rutEmpresa   RUT de la empresa que realiza el pago.
     * @param monto        Monto del pago.
     * @param fecha        Fecha en que se realizó el pago.
     * @param detallePago  Detalle adicional del pago.
     */
    public Pago(int idPago, String rutEmpresa, int monto, String fecha, String detallePago) {
        super();
        this.idPago = idPago;
        this.rutEmpresa = rutEmpresa;
        this.monto = monto;
        this.fecha = fecha;
        this.detallePago = detallePago;
    }

    // Getters y Setters

    /**
     * Obtiene el ID del pago.
     * 
     * @return ID del pago.
     */
    public int getIdPago() {
        return idPago;
    }

    /**
     * Establece el ID del pago.
     * 
     * @param idPago El ID del pago.
     */
    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    /**
     * Obtiene el RUT de la empresa que realiza el pago.
     * 
     * @return RUT de la empresa.
     */
    public String getRutEmpresa() {
        return rutEmpresa;
    }

    /**
     * Establece el RUT de la empresa que realiza el pago.
     * 
     * @param rutEmpresa El RUT de la empresa.
     */
    public void setRutEmpresa(String rutEmpresa) {
        this.rutEmpresa = rutEmpresa;
    }

    /**
     * Obtiene el monto del pago.
     * 
     * @return Monto del pago.
     */
    public int getMonto() {
        return monto;
    }

    /**
     * Establece el monto del pago.
     * 
     * @param monto El monto del pago.
     */
    public void setMonto(int monto) {
        this.monto = monto;
    }

    /**
     * Obtiene la fecha en que se realizó el pago.
     * 
     * @return Fecha del pago.
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha en que se realizó el pago.
     * 
     * @param fecha La fecha del pago.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Obtiene el detalle adicional del pago.
     * 
     * @return Detalle del pago.
     */
    public String getDetallePago() {
        return detallePago;
    }

    /**
     * Establece el detalle adicional del pago.
     * 
     * @param detallePago El detalle del pago.
     */
    public void setDetallePago(String detallePago) {
        this.detallePago = detallePago;
    }
}
