package com.boombastic.mediateca.utils.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDto {
    private Long id;
    @NotEmpty(message = "Llene el form de nombre de usuario")
    private String nombreUsuario;
    @NotEmpty(message = "Llene el form de nombre de contraseña")
    private String contrasena;
    private int tiempoMora;
    private int cantidadMora;
    @NotEmpty(message = "Llene el form de nombre de código")
    private String codigoUsuario;
}
