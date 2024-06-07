package com.boombastic.mediateca.utils.security;

import com.boombastic.mediateca.utils.models.Usuario;
import com.boombastic.mediateca.utils.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private UsuarioRepository usuarioRepository;

    @Autowired
    public CustomUserDetailsService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findFirstByNombreUsuario(username);
        if (usuario != null) {
            User authUser = new User(
                    usuario.getNombreUsuario(),
                    usuario.getContrasena(),
                    usuario.getTipoUsuariosList().stream().map((tipoUsuarios) -> new SimpleGrantedAuthority(tipoUsuarios.getNombre()))
                            .collect(Collectors.toList())
            );
            return authUser;
        } else {
            throw new UsernameNotFoundException("Usuario o contraseña inválidos");
        }
    }
}
