package com.example.adopciones.adopciones.controller.impl;

import com.example.adopciones.adopciones.controller.AdopcionesAPI;
import com.example.adopciones.adopciones.model.AdopcionesVO;
import com.example.adopciones.adopciones.model.dto.AdopcionesDTO;
import com.example.adopciones.adopciones.repository.AdopcionesRepository;
import com.example.adopciones.adopciones.service.impl.AdopcionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class AdopcionesController implements AdopcionesAPI {

    @Autowired
    private AdopcionesService adopcionesService;

    @Autowired
    private AdopcionesRepository adopcionesRepository;


    @Override
    public ResponseEntity<List<AdopcionesDTO>> getAllAdopciones() {
        return ResponseEntity.ok(adopcionesService.getAllAdopciones());
    }

    @Override
    public ResponseEntity<Optional<AdopcionesDTO>> getAdopcionById(String id) {
        Optional<AdopcionesVO> dataVO = adopcionesRepository.findById(id);

        if (dataVO.isPresent()) {
            return new ResponseEntity(dataVO.get(), HttpStatus.OK);

        } else {
            return null;
        }
    }

    @Override
    public ResponseEntity<AdopcionesDTO> saveAdopciones(AdopcionesDTO adopcionesDTO) {
        return new ResponseEntity<>(adopcionesService.saveAdopcion(adopcionesDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<AdopcionesDTO> updateAdopciones(String id, AdopcionesDTO adopcionesDTO) {
        return new ResponseEntity<>(adopcionesService.updateAdopcion(id, adopcionesDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Boolean> deleteAdopciones(String id) {
        return adopcionesService.deleteAdopcion(id)
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
