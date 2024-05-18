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
    private Long id;
    @NonNull
    private String nombreUsuario;
    private String codigoUsuario;
    @NonNull
    private String contrasena;
    private int tiempoMora;
    private int cantidadMora;
    private String tipoUsuario;
}
