package com.boombastic.mediateca.utils.services.impl;

import com.boombastic.mediateca.utils.dtos.DVDDto;
import com.boombastic.mediateca.utils.dtos.UsuarioDto;
import com.boombastic.mediateca.utils.models.Usuario;
import com.boombastic.mediateca.utils.repository.UsuarioRepository;
import com.boombastic.mediateca.utils.services.DVDService;
import com.boombastic.mediateca.utils.services.UsuarioService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DVDServiceImpl implements DVDService {


    @Override
    public List<DVDDto> listAllDvds() {
        return List.of();
    }

    @Override
    public DVDDto findDvdById(Long dvdId) {
        return null;
    }

    @Override
    public void updateDvd(DVDDto dvdDto) {

    }

    @Override
    public void delete(Long dvdId) {

    }

    @Override
    public void saveDvd(DVDDto dvd) {

    }
}
