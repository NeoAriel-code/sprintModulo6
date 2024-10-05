package cl.grupo02.sprintFinal.model.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.grupo02.sprintFinal.model.entity.Pago;
import cl.grupo02.sprintFinal.repository.PagoRepository;

/**
 * Servicio para gestionar los pagos.
 * 
 * @autor Ariel Alfaro
 * @autor Bastian Muñoz
 * @autor Bastian Espinosa
 * @autor Joshua Montt
 * @autor Nicolas Gajardo
 * @version 1.0
 */
@Service
public class PagoService {

    @Autowired
    private PagoRepository pagoRepository;
    
    /**
     * Guarda un pago en la base de datos.
     *
     * @param pago el objeto Pago a guardar
     * @return el objeto Pago guardado
     */
    public Pago guardarPago(Pago pago) {
        return pagoRepository.save(pago);
    }
    
    /**
     * Obtiene un pago por su identificador.
     *
     * @param id el identificador del pago
     * @return un Optional con el Pago si existe, o vacío si no
     */
    public Optional<Pago> obtenerPagoPorId(int id) {
        return pagoRepository.findById(id);
    }
    
    /**
     * Obtiene todos los pagos.
     *
     * @return una lista de todos los objetos Pago
     */
    public List<Pago> obtenerTodosPagos() {
        return pagoRepository.findAll();
    }
    
    /**
     * Elimina un pago por su identificador.
     *
     * @param id el identificador del pago a eliminar
     */
    public void eliminarPago(int id) {
        pagoRepository.deleteById(id);
    }
}
