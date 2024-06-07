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
@Table(name = "tesis")
public class Tesis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTesis;
    @ManyToOne
    @JoinColumn(name = "idDocumento", nullable = false)
    private Documento idDocumento;
    private String directorTesis;
    private String gradoObtenido;
    private String departamento;
}
