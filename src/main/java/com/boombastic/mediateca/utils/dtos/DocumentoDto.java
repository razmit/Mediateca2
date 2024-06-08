package com.boombastic.mediateca.utils.dtos;

import com.boombastic.mediateca.utils.models.DocumentoMateria;
import com.boombastic.mediateca.utils.models.Materia;
import com.boombastic.mediateca.utils.models.TipoDocumento;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class DocumentoDto {

    private Long id;
    private TipoDocumento tipoDocumento;
    @NotEmpty(message = "Llene el form de titulo")
    private String titulo;
    private String autor;
    private int anoPublicacion;
    private String ubicacionFisica;
    private int cantidadDisponible;
    private String estado;
    private String fechaAdquisicion;
    private List<Materia> materia;
}
