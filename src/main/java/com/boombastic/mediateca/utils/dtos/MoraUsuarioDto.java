package com.boombastic.mediateca.utils.dtos;

import com.boombastic.mediateca.utils.models.Usuario;
import groovy.transform.builder.Builder;
import lombok.Data;

@Data
@Builder
public class MoraUsuarioDto {

    private long idMora;
    private Usuario idUsuario;
    private int cantidadMora;
    private int tiempoMora;
}
