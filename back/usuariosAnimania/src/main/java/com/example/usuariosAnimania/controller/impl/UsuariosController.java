package com.example.usuariosAnimania.controller.impl;

import com.example.usuariosAnimania.controller.UsuarioAPI;
import com.example.usuariosAnimania.model.UsuarioVO;
import com.example.usuariosAnimania.model.dto.UsuarioDTO;
import com.example.usuariosAnimania.repository.UsuarioRepository;
import com.example.usuariosAnimania.service.impl.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public class UsuariosController implements UsuarioAPI {

    @Autowired
    private UsuariosService usuariosService;

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public ResponseEntity<List<UsuarioDTO>> getAllUsuarios() {
        return ResponseEntity.ok(usuariosService.getAllUsuarios());
    }

    @Override
    public ResponseEntity<Optional<UsuarioDTO>> getUsuarioById(String id) {
        Optional<UsuarioVO> dataVO = usuarioRepository.findById(id);

        if (dataVO.isPresent()) {
            return new ResponseEntity(dataVO.get(), HttpStatus.OK);

        } else {
            return null;
        }
    }

    @Override
    public ResponseEntity<UsuarioDTO> saveUsuario(UsuarioDTO usuarioDTO) {
        return new ResponseEntity<>(usuariosService.saveUsuario(usuarioDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UsuarioDTO> saveAdmin(UsuarioDTO usuarioDTO) {
        return new ResponseEntity<>(usuariosService.saveAdmin(usuarioDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<UsuarioDTO> updateUsuario(String id, UsuarioDTO usuarioDTO) {
        return new ResponseEntity<>(usuariosService.updateUsuario(id, usuarioDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Boolean> deleteUsuario(String id) {
        return usuariosService.deleteUsuario(id)
                ? ResponseEntity.ok(true)
                : new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
