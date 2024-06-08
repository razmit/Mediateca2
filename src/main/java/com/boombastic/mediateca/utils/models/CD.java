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
@Table(name = "cdaudio")
public class CD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCdAudio;
    @ManyToOne
    @JoinColumn(name = "idDocumento", nullable = false)
    private Documento documento;
    private String artista;
    private String genero;
    private int duracion;
    private int numCanciones;
}
