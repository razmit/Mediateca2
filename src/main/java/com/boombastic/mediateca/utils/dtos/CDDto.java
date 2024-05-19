package com.boombastic.mediateca.utils.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CDDto {

    private Long id;
    private Long idDocumento;
    @NotEmpty(message = "Llene el form de nombre de artista")
    private String artista;
    @NotEmpty(message = "Llene el form de nombre de genero")
    private String genero;
    private int duracion;
    private int numCanciones;
}
