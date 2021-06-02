package com.example.animania.service.impl;

import com.example.animania.model.dto.AnimaniaDTO;

import java.util.List;

public interface AnimaniaService {

    List<AnimaniaDTO> getAllAnimals();
    List<AnimaniaDTO> findyByTipo(final String tipoAnimal);
    List<AnimaniaDTO> findByCity(final String ciudad);
    List<AnimaniaDTO> findBySex(final String sexo);
    List<AnimaniaDTO> findByUrgencia(final String urgencia);
    AnimaniaDTO save(final AnimaniaDTO animaniaDTO);
    AnimaniaDTO updateAnimal(String id, final AnimaniaDTO animaniaDTO);
    boolean deleteAnimal(final String id);
    boolean deleteAllAnimals();
}
