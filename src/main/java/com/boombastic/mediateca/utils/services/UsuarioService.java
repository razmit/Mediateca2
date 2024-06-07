package com.boombastic.mediateca.utils.services;

import com.boombastic.mediateca.utils.dtos.UsuarioDto;
import com.boombastic.mediateca.utils.models.Usuario;

import java.util.List;

public interface UsuarioService {

    List<UsuarioDto> listAllUsers();
    Usuario saveUsuario(Usuario usuario);

    void saveUser(UsuarioDto usuarioDto);

    UsuarioDto findUsuarioById(Long usuarioId);

    void updateUsuario(UsuarioDto usuarioDto);

    void delete(Long usuarioId);
}
