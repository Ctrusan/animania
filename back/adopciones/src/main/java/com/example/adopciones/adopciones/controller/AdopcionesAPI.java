package com.example.adopciones.adopciones.controller;

import com.example.adopciones.adopciones.controller.constant.EndPointsUris;
import com.example.adopciones.adopciones.model.dto.AdopcionesDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface AdopcionesAPI {

    @GetMapping
    ResponseEntity<List<AdopcionesDTO>> getAllAdopciones();

    @GetMapping(EndPointsUris.ID)
    ResponseEntity<Optional<AdopcionesDTO>> getAdopcionById(@PathVariable final String id);

    @PostMapping
    ResponseEntity<AdopcionesDTO> saveAdopciones(@RequestBody final AdopcionesDTO adopcionesDTO);

    @PutMapping(EndPointsUris.ID)
    ResponseEntity<AdopcionesDTO> updateAdopciones(@PathVariable final String id, @RequestBody final AdopcionesDTO adopcionesDTO);

    @DeleteMapping(EndPointsUris.ID)
    ResponseEntity<Boolean> deleteAdopciones(@PathVariable final String id);
}
