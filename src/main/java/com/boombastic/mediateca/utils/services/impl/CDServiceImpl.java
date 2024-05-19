package com.boombastic.mediateca.utils.services.impl;

import com.boombastic.mediateca.utils.dtos.CDDto;
import com.boombastic.mediateca.utils.dtos.UsuarioDto;
import com.boombastic.mediateca.utils.models.CD;
import com.boombastic.mediateca.utils.models.Usuario;
import com.boombastic.mediateca.utils.repository.CDRepository;
import com.boombastic.mediateca.utils.repository.CDRepository;
import com.boombastic.mediateca.utils.services.CDService;
import com.boombastic.mediateca.utils.services.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CDServiceImpl implements CDService {

    private CDRepository cdRepository;

    public CDServiceImpl(CDRepository cdRepository) {
        this.cdRepository = cdRepository;
    }


    @Override
    public List<CDDto> listAllCDs() {
        return List.of();
    }

    @Override
    public CD saveCD(CD cd) {
        return null;
    }

    @Override
    public CDDto findCDById(Long cdId) {
        return null;
    }

    @Override
    public void updateCD(CDDto cdDto) {

    }

    @Override
    public void delete(Long cdId) {

    }
}
