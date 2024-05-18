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
    @NotEmpty(message = "Llene el form de nombre de usuario")
    private String codigoUsuario;
    @NotEmpty(message = "Llene el form de nombre de usuario")
    private String contrasena;
    private int tiempoMora;
    private int cantidadMora;
    private String tipoUsuario;
}
