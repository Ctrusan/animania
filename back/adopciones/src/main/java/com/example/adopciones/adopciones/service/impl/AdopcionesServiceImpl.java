package com.example.adopciones.adopciones.service.impl;

import com.example.adopciones.adopciones.model.AdopcionesVO;
import com.example.adopciones.adopciones.model.dto.AdopcionesDTO;
import com.example.adopciones.adopciones.repository.AdopcionesRepository;
import com.example.adopciones.adopciones.service.converter.AdopcionesConverterToDTO;
import com.example.adopciones.adopciones.service.converter.AdopcionesConverterToVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AdopcionesServiceImpl implements AdopcionesService {

    @Autowired
    private AdopcionesRepository adopcionesRepository;

    @Autowired
    private AdopcionesConverterToDTO adopcionesConverterToDTO;

    @Autowired
    private AdopcionesConverterToVO adopcionesConverterToVO;


    @Override
    public List<AdopcionesDTO> getAllAdopciones() {
        return adopcionesRepository.findAll()
                .stream()
                .map(adopcionesConverterToDTO::convert)
                .collect(Collectors.toList());
    }

    @Override
    public AdopcionesDTO saveAdopcion(AdopcionesDTO adopcionesDTO) {
        AdopcionesVO adopcionesVO = adopcionesConverterToVO.convert(adopcionesDTO);
        return adopcionesConverterToDTO.convert(adopcionesRepository.insert(adopcionesVO));
    }

    @Override
    public AdopcionesDTO updateAdopcion(String id, AdopcionesDTO adopcionesDTO) {
        Optional<AdopcionesVO> opAdopcionesVO = adopcionesRepository.findById(id);
        AdopcionesVO adopcionesVO = opAdopcionesVO.get();
        adopcionesVO.setFechaAdopcion(adopcionesDTO.getFechaAdopcion());
        adopcionesVO.setIdUsuario(adopcionesDTO.getIdUsuario());

        return adopcionesConverterToDTO.convert(adopcionesRepository.save(adopcionesVO));
    }

    @Override
    public boolean deleteAdopcion(String id) {
        try{
            adopcionesRepository.deleteById(id);
            return Boolean.TRUE;
        } catch(Exception e) {
            return Boolean.FALSE;
        }
    }
}

