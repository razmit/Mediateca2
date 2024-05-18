package com.boombastic.mediateca.utils.services.impl;

import com.boombastic.mediateca.utils.dtos.UsuarioDto;
import com.boombastic.mediateca.utils.models.Usuario;
import com.boombastic.mediateca.utils.repository.UsuarioRepository;
import com.boombastic.mediateca.utils.services.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<UsuarioDto> listAllUsers() {

        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map((usuario) -> mapToUserDto(usuario)).collect(Collectors.toList());
    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public UsuarioDto mapToUserDto(Usuario usuario) {

        UsuarioDto usuarioDto = UsuarioDto.builder()
                .id(usuario.getId())
                .nombreUsuario(usuario.getNombreUsuario())
                .codigoUsuario(usuario.getCodigoUsuario())
                .contrasena(usuario.getContrasena())
                .tiempoMora(usuario.getTiempoMora())
                .cantidadMora(usuario.getCantidadMora())
                .tipoUsuario(usuario.getTipoUsuario())
                .build();

        return usuarioDto;
    }
}
