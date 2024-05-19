package com.boombastic.mediateca.utils.dtos;

import groovy.transform.builder.Builder;
import lombok.Data;

@Data
@Builder
public class MateriaDto {

    private Long id;
    private String nombre;
}
