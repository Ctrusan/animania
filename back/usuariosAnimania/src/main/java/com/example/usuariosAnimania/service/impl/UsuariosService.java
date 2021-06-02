package com.example.usuariosAnimania.service.impl;

import com.example.usuariosAnimania.model.dto.UsuarioDTO;

import java.util.List;

public interface UsuariosService {

    List<UsuarioDTO> getAllUsuarios();
    UsuarioDTO saveUsuario(final UsuarioDTO usuarioDTO);
    UsuarioDTO saveAdmin(final UsuarioDTO usuarioDTO);
    UsuarioDTO updateUsuario(String id, final UsuarioDTO usuarioDTO);
    boolean deleteUsuario(final String id);

}
