package com.example.adopciones.adopciones.service.converter;


import com.example.adopciones.adopciones.model.AdopcionesVO;
import com.example.adopciones.adopciones.model.dto.AdopcionesDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AdopcionesConverterToVO implements Converter <AdopcionesDTO, AdopcionesVO> {

    @Override
    public AdopcionesVO convert(AdopcionesDTO adopcionesDTO) {
        return AdopcionesVO.builder()
                .ID(adopcionesDTO.getID())
                .fechaAdopcion(adopcionesDTO.getFechaAdopcion())
                .idUsuario(adopcionesDTO.getIdUsuario())
                .build();
    }
}
