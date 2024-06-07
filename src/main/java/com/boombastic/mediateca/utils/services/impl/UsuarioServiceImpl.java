package com.boombastic.mediateca.utils.services.impl;

import com.boombastic.mediateca.utils.dtos.UsuarioDto;
import com.boombastic.mediateca.utils.models.TipoUsuarios;
import com.boombastic.mediateca.utils.models.Usuario;
import com.boombastic.mediateca.utils.repository.TipoUsuarioRepository;
import com.boombastic.mediateca.utils.repository.UsuarioRepository;
import com.boombastic.mediateca.utils.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;
    private TipoUsuarioRepository tipoUsuarioRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, TipoUsuarioRepository tipoUsuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.tipoUsuarioRepository = tipoUsuarioRepository;
        this.passwordEncoder = passwordEncoder;
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

    @Override
    public void saveUser(UsuarioDto usuarioDto) {
        Usuario user = new Usuario();
        user.setNombreUsuario(usuarioDto.getNombreUsuario());
//        user.setContrasena(passwordEncoder.encode(usuarioDto.getContrasena()));
        user.setContrasena(usuarioDto.getContrasena());
        TipoUsuarios tp = tipoUsuarioRepository.findByNombre("ALUMNO");
        user.setTipoUsuariosList(Arrays.asList(tp));
        usuarioRepository.save(user);
    }

    @Override
    public UsuarioDto findUsuarioById(Long id) {
        Usuario usuario = usuarioRepository.findById(id).get();
        return mapToUserDto(usuario);
    }

    @Override
    public void updateUsuario(UsuarioDto dto) {
        Usuario usuario = mapToUser(dto);
        usuarioRepository.save(usuario);
    }

    @Override
    public void delete(Long usuarioId) {
        usuarioRepository.deleteById(usuarioId);
    }

    public Usuario mapToUser(UsuarioDto usuario){
            Usuario usuarioDto = Usuario.builder()
                    .idUsuario(usuario.getId())
                    .nombreUsuario(usuario.getNombreUsuario())
                    .contrasena(usuario.getContrasena())
                    .build();

            return usuarioDto;
    }

    public UsuarioDto mapToUserDto(Usuario usuario) {

        UsuarioDto usuarioDto = UsuarioDto.builder()
                .id(usuario.getIdUsuario())
                .nombreUsuario(usuario.getNombreUsuario())
                .contrasena(usuario.getContrasena())
                .build();

        return usuarioDto;
    }
}
