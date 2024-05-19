package com.boombastic.mediateca.utils.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DocumentoDto {

    private Long id;
    private Long idTipoDocumento;
    @NotEmpty(message = "Llene el form de titulo")
    private String titulo;
    private String autor;
    private int anoPublicacion;
    private String ubicacionFisica;
    private int cantidadDisponible;
    private String estado;
    private String fechaAdquisicion;
}
