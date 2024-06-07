package com.boombastic.mediateca.utils.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "tipos_usuarios",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "idUsuario")},
            inverseJoinColumns = {@JoinColumn(name = "userType_id", referencedColumnName = "idTipoUsuario")}
    )
    private List<TipoUsuarios> tipoUsuariosList = new ArrayList<>();
    private String contrasena;
    private int cantidadMora;
    private int tiempoMora;
    private String codigoUsuario;
}
