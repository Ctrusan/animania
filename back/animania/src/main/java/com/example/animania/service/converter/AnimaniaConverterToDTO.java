package com.example.animania.service.converter;

import com.example.animania.model.AnimaniaVO;
import com.example.animania.model.dto.AnimaniaDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AnimaniaConverterToDTO implements Converter <AnimaniaVO, AnimaniaDTO> {

    @Override
    public AnimaniaDTO convert(AnimaniaVO animaniaVO) {
        return AnimaniaDTO.builder()
                .nombreAnimal(animaniaVO.getNombreAnimal())
                .tipoAnimal(animaniaVO.getTipoAnimal())
                .ciudad(animaniaVO.getCiudad())
                .sexo(animaniaVO.getSexo())
                .fechaNac(animaniaVO.getFechaNac())
                .descripcion(animaniaVO.getDescripcion())
                .imagenAnimal(animaniaVO.getImagenAnimal())
                .ID(animaniaVO.getID())
                .build();
    }
}
