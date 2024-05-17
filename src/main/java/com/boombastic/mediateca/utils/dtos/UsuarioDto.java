package com.boombastic.mediateca.utils.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioDto {
    private Long id_usuario;
    private String nombre_usuario;
    private String codigo_usuario;
    private int tiempo_mora;
    private int cantidad_mora;
    private String tipo_usuario;
}
