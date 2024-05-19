package com.boombastic.mediateca.utils.dtos;

import groovy.transform.builder.Builder;
import lombok.Data;

@Data
@Builder
public class PrestamoDto {

    private Long id;
    private Long idUsuario;
    private Long idDocumento;
    private String fechaPrestamo;
    private String fechaDevolucion;
    private String estado;
    private double mora;
}
