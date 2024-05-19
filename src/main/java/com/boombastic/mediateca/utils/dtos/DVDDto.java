package com.boombastic.mediateca.utils.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DVDDto {

    private Long id;
    private Long idDocumento;
    @NotBlank(message = "Rellene el form de director")
    private String director;
    private String genero;
    private int duracion;
}
