package com.boombastic.mediateca.utils.models;

import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;
    private String nombreUsuario;
    private String tipoUsuario;
    private String contrasena;
    private int cantidadMora;
    private int tiempoMora;
    private String codigoUsuario;
}
