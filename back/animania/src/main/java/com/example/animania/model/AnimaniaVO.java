package com.example.animania.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document( collection = "Animania")
public class AnimaniaVO {

    @Id
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
