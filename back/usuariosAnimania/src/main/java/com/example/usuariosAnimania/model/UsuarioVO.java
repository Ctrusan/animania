package com.example.usuariosAnimania.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioVO {

    @Id
    private String ID;
    private String correo;
    private String contra;
}
