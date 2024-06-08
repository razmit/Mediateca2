package com.boombastic.mediateca.utils.services.impl;

import com.boombastic.mediateca.utils.dtos.TesisDto;
import com.boombastic.mediateca.utils.dtos.UsuarioDto;
import com.boombastic.mediateca.utils.models.Usuario;
import com.boombastic.mediateca.utils.repository.UsuarioRepository;
import com.boombastic.mediateca.utils.services.TesisService;
import com.boombastic.mediateca.utils.services.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TesisServiceImpl implements TesisService {


    @Override
    public List<TesisDto> listAllTesis() {
        return List.of();
    }

    @Override
    public TesisDto findTesisById(Long tesisId) {
        return null;
    }

    @Override
    public void saveTesis(TesisDto tesisDto) {

    }

    @Override
    public void updateTesis(TesisDto tesisDto) {

    }

    @Override
    public void delete(Long tesisId) {

    }
}
