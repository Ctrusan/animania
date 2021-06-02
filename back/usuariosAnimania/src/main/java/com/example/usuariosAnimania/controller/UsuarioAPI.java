package com.example.usuariosAnimania.controller;

import com.example.usuariosAnimania.controller.constant.EndPointsUris;
import com.example.usuariosAnimania.model.dto.UsuarioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

public interface UsuarioAPI {

    @GetMapping
    ResponseEntity<List<UsuarioDTO>> getAllUsuarios();

    @GetMapping(EndPointsUris.ID)
    ResponseEntity<Optional<UsuarioDTO>> getUsuarioById(@PathVariable final String id);

    @PostMapping
    ResponseEntity<UsuarioDTO> saveUsuario(@RequestBody final UsuarioDTO usuarioDTO);

    @PostMapping
    ResponseEntity<UsuarioDTO> saveAdmin(@RequestBody final UsuarioDTO usuarioDTO);

    @PutMapping(EndPointsUris.ID)
    ResponseEntity<UsuarioDTO> updateUsuario(@PathVariable final String id, @RequestBody final UsuarioDTO usuarioDTO);

    @DeleteMapping(EndPointsUris.ID)
    ResponseEntity<Boolean> deleteUsuario(@PathVariable final String id);
}
