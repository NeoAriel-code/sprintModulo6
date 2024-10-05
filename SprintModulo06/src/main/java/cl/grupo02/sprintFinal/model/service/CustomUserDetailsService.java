package cl.grupo02.sprintFinal.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import cl.grupo02.sprintFinal.model.entity.Usuario;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService; // Inyecta tu servicio de usuario

    @Override
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.findByNickname(nickname); // Obtén el usuario por nickname
        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + nickname);
        }

        // Retorna un objeto User de Spring Security
        return new User(
                usuario.getNickname(), // Nombre de usuario
                usuario.getContrasena(), // Contraseña encriptada
                Collections.singletonList(new SimpleGrantedAuthority(usuario.getTipoUsuario())) // Roles
        );
    }
}
