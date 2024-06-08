package com.boombastic.mediateca.utils.services;

import java.util.List;

import com.boombastic.mediateca.utils.dtos.DVDDto;
import com.boombastic.mediateca.utils.models.DVD;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public interface DVDService
{
    List<DVDDto> listAllDvds();

    DVDDto findDvdById(Long dvdId);

    void updateDvd(@Valid DVDDto dvdDto);

    void delete(Long dvdId);

    void saveDvd(DVD dvd);
}
