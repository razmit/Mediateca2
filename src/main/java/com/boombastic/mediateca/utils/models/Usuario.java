package com.boombastic.mediateca.utils.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
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
    private String nombreUsuario;
    private String codigoUsuario;
    private String contrasena;
    private int tiempoMora;
    private int cantidadMora;
    private String tipoUsuario;
}
