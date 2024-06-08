package com.boombastic.mediateca.utils.dtos;

import com.boombastic.mediateca.utils.models.Documento;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CDDto {

    private Long id;
    private Documento documento;
    @NotEmpty(message = "Llene el form de nombre de artista")
    private String artista;
    @NotEmpty(message = "Llene el form de nombre de genero")
    private String genero;
    private int duracion;
    private int numCanciones;
}
