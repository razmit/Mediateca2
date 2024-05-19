package com.boombastic.mediateca.utils.services;

import com.boombastic.mediateca.utils.dtos.CDDto;
import com.boombastic.mediateca.utils.dtos.DVDDto;
import com.boombastic.mediateca.utils.dtos.UsuarioDto;
import com.boombastic.mediateca.utils.models.CD;
import com.boombastic.mediateca.utils.models.DVD;
import com.boombastic.mediateca.utils.models.Usuario;

import java.util.List;

public interface DVDService {

    List<DVDDto> listAllDVDs();
    DVD saveDVD(DVD dvd);

    DVDDto findDVDById(Long dvdId);

    void updateDVD(DVDDto dvdDto);

    void delete(Long dvdId);
}
