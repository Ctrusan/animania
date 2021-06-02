package com.example.adopciones.adopciones.service.impl;

import com.example.adopciones.adopciones.model.dto.AdopcionesDTO;

import java.util.List;

public interface AdopcionesService {

    List<AdopcionesDTO> getAllAdopciones();
    AdopcionesDTO saveAdopcion(final AdopcionesDTO usuarioDTO);
    AdopcionesDTO updateAdopcion(String id, final AdopcionesDTO adopcionesDTO);
    boolean deleteAdopcion(final String id);

}
