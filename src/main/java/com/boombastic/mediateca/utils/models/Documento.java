package com.boombastic.mediateca.utils.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "documentos")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idTipoDocumento;
    private String titulo;
    private String autor;
    private int anoPublicacion;
    private String ubicacionFisica;
    private int cantidadDisponible;
    private String estado;
    private String fechaAdquisicion;
}
