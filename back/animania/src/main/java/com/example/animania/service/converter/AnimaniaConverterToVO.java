package com.example.animania.service.converter;

import com.example.animania.model.AnimaniaVO;
import com.example.animania.model.dto.AnimaniaDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AnimaniaConverterToVO implements Converter <AnimaniaDTO, AnimaniaVO > {

    @Override
    public AnimaniaVO convert(AnimaniaDTO animaniaDTO) {
        return AnimaniaVO.builder()
                .nombreAnimal(animaniaDTO.getNombreAnimal())
                .tipoAnimal(animaniaDTO.getTipoAnimal())
                .ciudad(animaniaDTO.getCiudad())
                .sexo(animaniaDTO.getSexo())
                .fechaNac(animaniaDTO.getFechaNac())
                .descripcion(animaniaDTO.getDescripcion())
                .imagenAnimal(animaniaDTO.getImagenAnimal())
                .ID(animaniaDTO.getID())
                .build();
    }
}
