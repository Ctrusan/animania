package com.example.adopciones.adopciones.service.converter;
import com.example.adopciones.adopciones.model.AdopcionesVO;
import com.example.adopciones.adopciones.model.dto.AdopcionesDTO;
import org.springframework.core.convert.converter.Converter;

public class AdopcionesConverterToDTO implements Converter <AdopcionesVO, AdopcionesDTO> {

    @Override
    public AdopcionesDTO convert(AdopcionesVO adopcionesVO) {
        return AdopcionesDTO.builder()
                .ID(adopcionesVO.getID())
                .fechaAdopcion(adopcionesVO.getFechaAdopcion())
                .idUsuario(adopcionesVO.getIdUsuario())
                .build();
    }
}
