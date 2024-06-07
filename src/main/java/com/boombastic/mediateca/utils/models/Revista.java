package com.boombastic.mediateca.utils.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.Doc;
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
    @ManyToOne
    @JoinColumn(name = "idDocumento", nullable = false)
    private Documento idDocumento;
    private String issn;
    private String editorial;
    private String periodicidad;
    private LocalDate fechaPublicacion;
}
