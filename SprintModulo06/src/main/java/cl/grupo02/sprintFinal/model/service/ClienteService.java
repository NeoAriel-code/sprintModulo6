package cl.grupo02.sprintFinal.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.grupo02.sprintFinal.model.entity.Cliente;
import cl.grupo02.sprintFinal.model.entity.FormularioUsuario;
import cl.grupo02.sprintFinal.model.entity.Usuario;
import cl.grupo02.sprintFinal.repository.ClienteRepository;
import cl.grupo02.sprintFinal.repository.UsuarioRepository;

/**
 * Servicio para gestionar los clientes.
 * 
 * @autor Ariel Alfaro
 * @autor Bastian Muñoz
 * @autor Bastian Espinosa
 * @autor Joshua Montt
 * @autor Nicolas Gajardo
 * @version 1.0
 */
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    /**
     * Guarda un cliente en la base de datos.
     *
     * @param cliente el objeto Cliente a guardar
     * @return el objeto Cliente guardado
     */
    @Transactional
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }
    
    /**
     * Obtiene un cliente asociado a un usuario específico.
     *
     * @param usuario el objeto Usuario asociado
     * @return el objeto Cliente asociado, o null si no existe
     */
    public Cliente obtenerClientePorUsuario(Usuario usuario) {
        return clienteRepository.findByUsuario(usuario);
    }
    
    /**
     * Actualiza un cliente existente.
     *
     * @param cliente el objeto Cliente con los datos actualizados
     * @return el objeto Cliente actualizado
     * @throws IllegalArgumentException si el cliente no existe
     */
    @Transactional
    public Cliente actualizarCliente(Cliente cliente) {
        if (clienteRepository.existsById(cliente.getIdCliente())) {
            return clienteRepository.save(cliente);
        } else {
            throw new IllegalArgumentException("No se puede actualizar un cliente inexistente.");
        }
    }

    /**
     * Obtiene un cliente por su identificador.
     *
     * @param idCliente el identificador del cliente
     * @return el objeto Cliente si existe, o null si no
     */
    public Cliente obtenerClientePorId(int idCliente) {
        return clienteRepository.findById(idCliente).orElse(null);
    }

    /**
     * Obtiene todos los clientes.
     *
     * @return una lista de todos los objetos Cliente
     */
    public List<Cliente> obtenerTodosClientes() {
        return clienteRepository.findAll();
    }

    /**
     * Elimina un cliente por su identificador.
     *
     * @param id el identificador del cliente a eliminar
     */
    @Transactional
    public void eliminarCliente(int id) {
        clienteRepository.deleteById(id);
    }
    
    /**
     * Crea un nuevo cliente a partir de un formulario de usuario.
     *
     * @param form el formulario de usuario con los datos necesarios
     */
    public void crearCliente(FormularioUsuario form) {
        // Crear y guardar el Usuario
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(form.getNombreUsuario());
        usuario.setApellidoUsuario(form.getApellidoUsuario());
        usuario.setNickname(form.getNickname());
        usuario.setContrasena(form.getContrasena());
        usuario.setRunUsuario(form.getRunUsuario());
        usuario.setCorreoUsuario(form.getCorreoUsuario());
        usuario.setTelefonoUsuario(form.getTelefonoUsuario());
        usuario.setTipoUsuario("cliente");
        usuario = usuarioRepository.save(usuario);

        // Crear y guardar el Cliente
        Cliente cliente = new Cliente();
        cliente.setUsuario(usuario);
        cliente.setNombreEmpresa(form.getNombreEmpresa());
        cliente.setRutEmpresa(form.getRutEmpresa());
        cliente.setTelefonoEmpresa(form.getTelefonoEmpresa());
        cliente.setCorreoEmpresa(form.getCorreoEmpresa());
        cliente.setDireccionEmpresa(form.getDireccionEmpresa());
        cliente.setComunaEmpresa(form.getComunaEmpresa());
        clienteRepository.save(cliente);
    }
}
