package com.example.animania.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter
@Setter
@Builder
public class AnimaniaDTO {

    private String ID;
    private String nombreAnimal;
    private String tipoAnimal;
    private String ciudad;
    private String sexo;
    private Date fechaNac;
    private String urgenciaAnimal;
    private String imagenAnimal;
    private String descripcion;
}
