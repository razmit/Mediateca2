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
@Table(name = "moraUsuario")
public class MoraUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMora;
    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private Usuario idUsuario;
    private int cantidadMora;
    private int tiempoMora;
}
