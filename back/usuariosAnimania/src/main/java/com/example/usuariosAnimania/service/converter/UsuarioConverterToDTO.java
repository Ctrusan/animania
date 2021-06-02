package com.example.usuariosAnimania.service.converter;
import com.example.usuariosAnimania.model.UsuarioVO;
import com.example.usuariosAnimania.model.dto.UsuarioDTO;
import org.springframework.core.convert.converter.Converter;

public class UsuarioConverterToDTO implements Converter <UsuarioVO, UsuarioDTO> {

    @Override
    public UsuarioDTO convert(UsuarioVO usuarioVO) {
        return UsuarioDTO.builder()
                .ID(usuarioVO.getID())
                .correo(usuarioVO.getCorreo())
                .contra(usuarioVO.getContra())
                .build();
    }
}
