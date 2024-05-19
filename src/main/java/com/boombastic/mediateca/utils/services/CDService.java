package com.boombastic.mediateca.utils.services;

import com.boombastic.mediateca.utils.dtos.CDDto;
import com.boombastic.mediateca.utils.models.CD;

import java.util.List;

public interface CDService {

    List<CDDto> listAllCDs();
    CD saveCD(CD cd);

    CDDto findCDById(Long cdId);

    void updateCD(CDDto cdDto);

    void delete(Long cdId);
}
