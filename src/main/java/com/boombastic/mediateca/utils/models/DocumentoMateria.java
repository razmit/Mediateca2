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
    private Long idDocumento;
    private Long idMateria;
}
