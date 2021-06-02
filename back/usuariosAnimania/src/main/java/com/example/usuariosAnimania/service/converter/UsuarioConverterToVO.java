package com.example.usuariosAnimania.service.converter;


import com.example.usuariosAnimania.model.UsuarioVO;
import com.example.usuariosAnimania.model.dto.UsuarioDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConverterToVO implements Converter <UsuarioDTO, UsuarioVO> {

    @Override
    public UsuarioVO convert(UsuarioDTO usuarioDTO) {
        return UsuarioVO.builder()
                .ID(usuarioDTO.getID())
                .correo(usuarioDTO.getCorreo())
                .contra(usuarioDTO.getContra())
                .build();
    }
}
