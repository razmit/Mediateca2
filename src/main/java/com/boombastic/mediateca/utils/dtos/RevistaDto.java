package com.boombastic.mediateca.utils.dtos;

import groovy.transform.builder.Builder;
import lombok.Data;

@Data
@Builder
public class RevistaDto {

    private Long id;
    private Long idDocumento;
    private String issn;
    private String editorial;
    private String periodicidad;
    private int fechaPublicacion;
}
