package com.example.adopciones.adopciones.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdopcionesVO {

    @Id
    private String ID;
    private Date fechaAdopcion;
    private String idUsuario;

}
