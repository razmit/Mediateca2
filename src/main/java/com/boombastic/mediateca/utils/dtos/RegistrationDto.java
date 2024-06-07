package com.boombastic.mediateca.utils.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RegistrationDto {

    private Long id;
    @NotEmpty
    private String nombreUsuario;
    @NotEmpty
    private String contrasena;
}
