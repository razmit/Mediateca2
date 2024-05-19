package com.boombastic.mediateca.utils.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LibroDto {

    private Long id;
    private Long idDocumento;
    @NotEmpty(message = "Llene el form de nombre de ISBN")
    private String isbn;
    private String editorial;
    private int numPaginas;
}
