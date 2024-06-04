package com.boombastic.mediateca.utils.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "revista")
public class Revista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRevista;
    private Long idDocumento;
    private String issn;
    private String editorial;
    private String periodicidad;
    private LocalDate fechaPublicacion;
}
