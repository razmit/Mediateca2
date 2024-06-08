package com.boombastic.mediateca.utils.services;

import com.boombastic.mediateca.utils.dtos.CDDto;
import com.boombastic.mediateca.utils.models.CD;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CDService {

    List<CDDto> listAllCDs();
    void saveCD(CD cd);

    CDDto findCDById(Long cdId);

    void updateCD(CDDto cdDto);

    void delete(Long cdId);
}
