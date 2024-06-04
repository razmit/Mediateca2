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
@Table(name = "dvd")
public class DVD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDVD;
    private Long idDocumento;
    private String director;
    private String genero;
    private int duracion;
}
