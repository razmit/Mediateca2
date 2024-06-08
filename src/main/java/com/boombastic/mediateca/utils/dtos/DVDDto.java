package com.boombastic.mediateca.utils.dtos;

import com.boombastic.mediateca.utils.models.Documento;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DVDDto {

    private Long id;
    private Documento documento;
    @NotBlank(message = "Rellene el form de director")
    private String director;
    private String genero;
    private int duracion;
}
