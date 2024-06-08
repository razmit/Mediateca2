package com.boombastic.mediateca.utils.services.impl;

import com.boombastic.mediateca.utils.dtos.CDDto;
import com.boombastic.mediateca.utils.models.CD;
import com.boombastic.mediateca.utils.repository.CDRepository;
import com.boombastic.mediateca.utils.services.CDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CDServiceImpl implements CDService {

    private CDRepository cdRepository;

    @Autowired
    public CDServiceImpl(CDRepository cdRepository) {
        this.cdRepository = cdRepository;
    }

    @Override
    public List<CDDto> listAllCDs() {
        List<CD> cds = cdRepository.findAll();
        return cds.stream().map(this::mapToCDDto).collect(Collectors.toList());
    }

    @Override
    public CD saveCD(CD cd) {
        return cdRepository.save(cd);
    }

    @Override
    public CDDto findCDById(Long cdId) {
        Optional<CD> cdOptional = cdRepository.findById(cdId);
        return cdOptional.map(this::mapToCDDto).orElse(null);
    }

    @Override
    public void updateCD(CDDto cdDto) {
        CD cd = mapToCD(cdDto);
        cdRepository.save(cd);
    }

    @Override
    public void delete(Long cdId) {
        cdRepository.deleteById(cdId);
    }

    public CDDto mapToCDDto(CD cd) {
        return CDDto.builder()
                .id(cd.getIdCdAudio())
                .documento(cd.getDocumento())
                .artista(cd.getArtista())
                .duracion(cd.getDuracion())
                .genero(cd.getGenero())
                .numCanciones(cd.getNumCanciones())
                .build();
    }

    public CD mapToCD(CDDto cdDto) {
        return CD.builder()
                .idCdAudio(cdDto.getId())
                .documento(cdDto.getDocumento())
                .artista(cdDto.getArtista())
                .duracion(cdDto.getDuracion())
                .genero(cdDto.getGenero())
                .numCanciones(cdDto.getNumCanciones())
                .build();
    }
}
