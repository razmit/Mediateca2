package com.boombastic.mediateca.utils.services.impl;

import com.boombastic.mediateca.utils.dtos.UsuarioDto;
import com.boombastic.mediateca.utils.repository.UsuarioRepository;
import com.boombastic.mediateca.utils.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UsuarioServiceImpl implements UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<UsuarioDto> listAllUsers() {
        return List.of();
    }
}
