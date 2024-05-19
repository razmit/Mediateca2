package com.boombastic.mediateca.utils.dtos;

import groovy.transform.builder.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentoMateriaDto {

    private Long id;
    private Long idMateria;
}
