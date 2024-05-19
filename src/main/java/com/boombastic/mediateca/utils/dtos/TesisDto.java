package com.boombastic.mediateca.utils.dtos;

import groovy.transform.builder.Builder;
import lombok.Data;

@Data
@Builder
public class TesisDto {

    private Long id;
    private Long idDocumento;
    private String directorTesis;
    private String gradoObtenido;
    private String departamento;
}
