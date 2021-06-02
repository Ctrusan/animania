package com.example.adopciones.adopciones.repository;

import com.example.adopciones.adopciones.model.AdopcionesVO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AdopcionesRepository extends MongoRepository<AdopcionesVO, String >  {
}
