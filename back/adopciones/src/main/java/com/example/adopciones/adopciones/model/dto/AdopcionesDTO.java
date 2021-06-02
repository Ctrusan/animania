package com.example.adopciones.adopciones.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Builder

public class AdopcionesDTO {

    private String ID;
    private Date fechaAdopcion;
    private String idUsuario;
}
