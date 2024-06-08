package com.boombastic.mediateca.utils.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "documentos")
public class Documento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDocumento;
    @ManyToOne
    @JoinColumn(name = "idTipoDocumento", nullable = false)
    private TipoDocumento tipoDocumento;
    private String titulo;
    private String autor;
    private int anoPublicacion;
    private String ubicacionFisica;
    private int cantidadDisponible;
    private String estado;
    private String fechaAdquisicion;

    @OneToMany(mappedBy = "documento", cascade = CascadeType.ALL)
    private List<CD> cds = new ArrayList<>();
    @OneToMany(mappedBy = "idDocumento")
    private List<DVD> dvds = new ArrayList<>();
    @OneToMany(mappedBy = "idDocumento")
    private List<Libro> libros = new ArrayList<>();
    @OneToMany(mappedBy = "idDocumento")
    private List<Revista> revistas = new ArrayList<>();
    @OneToMany(mappedBy = "idDocumento")
    private List<Tesis> teses = new ArrayList<>();
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "documento_materia",
            joinColumns = {@JoinColumn(name = "doc_id", referencedColumnName = "idDocumento")},
            inverseJoinColumns = {@JoinColumn(name = "materia_id", referencedColumnName = "idMateria")}
    )
//    @OneToMany(mappedBy = "documento")
    private List<Materia> docMateriaList = new ArrayList<>();
}
