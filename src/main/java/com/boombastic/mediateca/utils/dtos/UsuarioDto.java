package com.boombastic.mediateca.utils.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDto {
    private Long id;
    private String nombreUsuario;
    private String codigoUsuario;
    private String contrasena;
    private int tiempoMora;
    private int cantidadMora;
    private String tipoUsuario;
}
