package com.example.animania.controller.impl;

import com.example.animania.controller.AnimaniaAPI;
import com.example.animania.model.AnimaniaVO;
import com.example.animania.model.dto.AnimaniaDTO;
import com.example.animania.repository.AnimaniaRepository;
import com.example.animania.service.impl.AnimaniaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class AnimaniaController implements AnimaniaAPI {

    @Autowired
    private AnimaniaService animaniaService;

    @Autowired
    private AnimaniaRepository animaniaRepository;

    @Override
    public ResponseEntity<List<AnimaniaDTO>> getAlLAnimals() {
        return ResponseEntity.ok(animaniaService.getAllAnimals());
    }

    @Override
    public ResponseEntity<Optional<AnimaniaDTO>> getAnimalById(String id) {
        Optional<AnimaniaVO> dataVO = animaniaRepository.findById(id);

        if (dataVO.isPresent()) {
            return new ResponseEntity(dataVO.get(), HttpStatus.OK);

        } else {
            return null;
        }
    }

    @Override
    public ResponseEntity<List<AnimaniaDTO>> findyByTipo(String tipoAnimal) {
        return ResponseEntity.ok(animaniaService.findyByTipo(tipoAnimal));
    }

    @Override
    public ResponseEntity<List<AnimaniaDTO>> findByCity(String ciudad) {
        return ResponseEntity.ok(animaniaService.findByCity(ciudad));
    }

    @Override
    public ResponseEntity<List<AnimaniaDTO>> findBySex(String sexo) {
        return ResponseEntity.ok(animaniaService.findBySex(sexo));
    }

    @Override
    public ResponseEntity<List<AnimaniaDTO>> findByUrgencia(String urgencia) {
        return ResponseEntity.ok(animaniaService.findByUrgencia(urgencia));
    }

    @Override
    public ResponseEntity<AnimaniaDTO> save(AnimaniaDTO animaniaDTO) {
        return new ResponseEntity<>(animaniaService.save(animaniaDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<AnimaniaDTO> updateAnimal(String id, AnimaniaDTO animaniaDTO) {
        return new ResponseEntity<>(animaniaService.updateAnimal(id, animaniaDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Boolean> deleteAnimal(String id) {
        return animaniaService.deleteAnimal(id)
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @Override
    public ResponseEntity<Boolean> deleteAllAnimals() {
        return animaniaService.deleteAllAnimals()
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
