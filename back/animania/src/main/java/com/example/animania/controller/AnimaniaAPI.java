package com.example.animania.controller;

import com.example.animania.controller.constant.EndPointsUris;
import com.example.animania.model.dto.AnimaniaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RequestMapping(EndPointsUris.API + EndPointsUris.V1 + EndPointsUris.ANIMANIA)
public interface AnimaniaAPI {

    @GetMapping
    ResponseEntity<List<AnimaniaDTO>> getAlLAnimals();

    @GetMapping(EndPointsUris.ID)
    ResponseEntity<Optional<AnimaniaDTO>> getAnimalById(@PathVariable final String id);

    @GetMapping(EndPointsUris.TIPO)
    ResponseEntity<List<AnimaniaDTO>> findyByTipo(@PathVariable final String tipoAnimal);

    @GetMapping(EndPointsUris.CIUDAD)
    ResponseEntity<List<AnimaniaDTO>> findByCity(@PathVariable final String ciudad);

    @GetMapping(EndPointsUris.SEXO)
    ResponseEntity<List<AnimaniaDTO>> findBySex(@PathVariable final String sexo);

    @GetMapping(EndPointsUris.URGENCIA)
    ResponseEntity<List<AnimaniaDTO>> findByUrgencia(@PathVariable final String urgencia);

    @PostMapping
    ResponseEntity<AnimaniaDTO> save(@RequestBody final AnimaniaDTO tutorialDTO);

    @PutMapping(EndPointsUris.ID)
    ResponseEntity<AnimaniaDTO> updateAnimal(@PathVariable final String id, @RequestBody final AnimaniaDTO animaniaDTO);

    @DeleteMapping(EndPointsUris.ID)
    ResponseEntity<Boolean> deleteAnimal(@PathVariable final String id);

    @DeleteMapping
    ResponseEntity<Boolean> deleteAllAnimals();
}
