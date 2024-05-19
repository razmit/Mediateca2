package com.boombastic.mediateca.utils.dtos;

import groovy.transform.builder.Builder;
import lombok.Data;

@Data
@Builder
public class TipoDocumentoDto {

    private Long id;
    private String nombreTipo;
}
