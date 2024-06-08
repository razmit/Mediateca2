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
@Table(name = "materiasdocumentos")
public class DocumentoMateria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMateriaDocumento;
    @ManyToOne
    @JoinColumn(name = "idDocumento", nullable = false)
    private Documento documento;
    @ManyToOne
    @JoinColumn(name = "idMateria", nullable = false)
    private Materia materia;
}
