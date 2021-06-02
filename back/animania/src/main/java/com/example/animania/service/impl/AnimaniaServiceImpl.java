package com.example.animania.service.impl;

import com.example.animania.model.AnimaniaVO;
import com.example.animania.model.dto.AnimaniaDTO;
import com.example.animania.repository.AnimaniaRepository;
import com.example.animania.service.converter.AnimaniaConverterToDTO;
import com.example.animania.service.converter.AnimaniaConverterToVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AnimaniaServiceImpl implements AnimaniaService {

    @Autowired
    private AnimaniaRepository animaniaRepository;

    @Autowired
    private AnimaniaConverterToDTO animaniaConverterToDTO;

    @Autowired
    private AnimaniaConverterToVO animaniaConverterToVO;

    @Override
    public List<AnimaniaDTO> getAllAnimals() {
        return animaniaRepository.findAll()
                .stream()
                .map(animaniaConverterToDTO::convert)
                .collect(Collectors.toList());
    }

    @Override
    public List<AnimaniaDTO> findyByTipo(String tipoAnimal) {
        return animaniaRepository.findAll()
                .stream()
                .map(animaniaConverterToDTO::convert)
                .filter(tutorialDTO -> tutorialDTO.getTipoAnimal().contains(tipoAnimal))
                .collect(Collectors.toList());
    }

    @Override
    public List<AnimaniaDTO> findByCity(String ciudad) {
        return animaniaRepository.findAll()
                .stream()
                .map(animaniaConverterToDTO::convert)
                .filter(tutorialDTO -> tutorialDTO.getCiudad().contains(ciudad))
                .collect(Collectors.toList());
    }

    @Override
    public List<AnimaniaDTO> findBySex(String sexo) {
        return animaniaRepository.findAll()
                .stream()
                .map(animaniaConverterToDTO::convert)
                .filter(tutorialDTO -> tutorialDTO.getSexo().contains(sexo))
                .collect(Collectors.toList());
    }

    @Override
    public List<AnimaniaDTO> findByUrgencia(String urgencia) {
        return animaniaRepository.findAll()
                .stream()
                .map(animaniaConverterToDTO::convert)
                .filter(tutorialDTO -> tutorialDTO.getSexo().contains(urgencia))
                .collect(Collectors.toList());
    }

    @Override
    public AnimaniaDTO save(AnimaniaDTO animaniaDTO) {
        AnimaniaVO animaniaVO = animaniaConverterToVO.convert(animaniaDTO);
        return animaniaConverterToDTO.convert(animaniaRepository.insert(animaniaVO));
    }

    @Override
    public AnimaniaDTO updateAnimal(String id, AnimaniaDTO animaniaDTO) {
        Optional<AnimaniaVO> opanimaniaVO = animaniaRepository.findById(id);
        AnimaniaVO animaniaVO = opanimaniaVO.get();
        animaniaVO.setNombreAnimal(animaniaDTO.getNombreAnimal());
        animaniaVO.setTipoAnimal(animaniaDTO.getTipoAnimal());
        animaniaVO.setUrgenciaAnimal(animaniaDTO.getUrgenciaAnimal());
        animaniaVO.setCiudad(animaniaDTO.getCiudad());
        animaniaVO.setSexo(animaniaDTO.getSexo());
        animaniaVO.setImagenAnimal(animaniaDTO.getImagenAnimal());
        animaniaVO.setFechaNac(animaniaDTO.getFechaNac());
        animaniaVO.setDescripcion(animaniaDTO.getDescripcion());

        return animaniaConverterToDTO.convert(animaniaRepository.save(animaniaVO));
    }

    @Override
    public boolean deleteAnimal(String id) {
        try{
           animaniaRepository.deleteById(id);
            return Boolean.TRUE;
        } catch(Exception e) {
            return Boolean.FALSE;
        }
    }

    @Override
    public boolean deleteAllAnimals() {
        try{
            animaniaRepository.deleteAll();
            return Boolean.TRUE;
        } catch(Exception e) {
            return Boolean.FALSE;
        }
    }
}
