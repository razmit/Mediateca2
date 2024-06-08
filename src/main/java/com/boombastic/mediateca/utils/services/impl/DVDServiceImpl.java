package com.boombastic.mediateca.utils.services.impl;


import com.boombastic.mediateca.utils.dtos.DVDDto;
import com.boombastic.mediateca.utils.models.DVD;
import com.boombastic.mediateca.utils.services.DVDService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DVDServiceImpl implements DVDService {

    private List<DVDDto> dvds = new ArrayList<>();

    @Override
    public List<DVDDto> listAllDvds(){
        return dvds;
    }

    @Override
    public DVDDto findDvdById(Long dvdId){
        return dvds.stream().filter(dvdDto -> dvdDto.getId().equals(dvdId)).findFirst().orElse(null);
    }

    @Override
    public void saveDvd(DVDDto dvd){
        DVDDto dvdDto = DVDDto.builder()
                .id((long)(dvds.size()+1))
                .documento(dvd.getDocumento())
                .director(dvd.getDirector())
                .genero(dvd.getGenero())
                .duracion(dvd.getDuracion())
                .build();
        dvds.add(dvdDto);
    }
    @Override
    public void updateDvd(DVDDto dvdDto){
        DVDDto existingDvd = findDvdById(dvdDto.getId());
        if(existingDvd != null){
            existingDvd.setDuracion(dvdDto.getDuracion());
            existingDvd.setGenero(dvdDto.getGenero());
            existingDvd.setDirector(dvdDto.getDirector());
            existingDvd.setDocumento(dvdDto.getDocumento());
        }
    }

    @Override
    public void delete(Long dvdID){
        dvds.removeIf(dvdDto -> dvdDto.getId().equals(dvdID));
    }

}
