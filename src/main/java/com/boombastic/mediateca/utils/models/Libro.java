package com.boombastic.mediateca.utils.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.Doc;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibro;
    @ManyToOne
    @JoinColumn(name = "idDocumento", nullable = false)
    private Documento idDocumento;
    private String titulo;
    private String autor;
    private String genero;
    private String isbn;
    private String editorial;
    private int numPaginas;

}
