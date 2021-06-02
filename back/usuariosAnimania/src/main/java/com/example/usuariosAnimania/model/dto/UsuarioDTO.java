package com.example.usuariosAnimania.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder

public class UsuarioDTO {

    private String ID;
    private String correo;
    private String contra;
}
