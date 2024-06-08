package com.boombastic.mediateca.utils.services;

import com.boombastic.mediateca.utils.dtos.TesisDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface TesisService {

    List<TesisDto> listAllTesis();

    TesisDto findTesisById(Long tesisId);

    void saveTesis(@Valid TesisDto tesisDto);

    void updateTesis(@Valid TesisDto tesisDto);

    void delete(Long tesisId);
}
