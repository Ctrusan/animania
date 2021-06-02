package com.example.usuariosAnimania.service.impl;

import com.example.usuariosAnimania.model.UsuarioVO;
import com.example.usuariosAnimania.model.dto.UsuarioDTO;
import com.example.usuariosAnimania.repository.UsuarioRepository;
import com.example.usuariosAnimania.service.converter.UsuarioConverterToDTO;
import com.example.usuariosAnimania.service.converter.UsuarioConverterToVO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UsuaroServiceImpl implements UsuariosService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioConverterToDTO usuarioConverterToDTO;

    @Autowired
    private UsuarioConverterToVO usuarioConverterToVO;


    @Override
    public List<UsuarioDTO> getAllUsuarios() {
        return usuarioRepository.findAll()
                .stream()
                .map(usuarioConverterToDTO::convert)
                .collect(Collectors.toList());
    }

    @Override
    public UsuarioDTO saveUsuario(UsuarioDTO usuarioDTO) {
        UsuarioVO usuarioVO = usuarioConverterToVO.convert(usuarioDTO);
        return usuarioConverterToDTO.convert(usuarioRepository.insert(usuarioVO));
    }

    @Override
    public UsuarioDTO saveAdmin(UsuarioDTO usuarioDTO) {
        UsuarioVO usuarioVO = usuarioConverterToVO.convert(usuarioDTO);
        return usuarioConverterToDTO.convert(usuarioRepository.insert(usuarioVO));
    }

    @Override
    public UsuarioDTO updateUsuario(String id, UsuarioDTO usuarioDTO) {
        Optional<UsuarioVO> opusuarioVO = usuarioRepository.findById(id);
        UsuarioVO usuarioVO = opusuarioVO.get();
        usuarioVO.setCorreo(usuarioDTO.getCorreo());
        usuarioVO.setContra(usuarioDTO.getContra());

        return usuarioConverterToDTO.convert(usuarioRepository.save(usuarioVO));
    }

    @Override
    public boolean deleteUsuario(String id) {
        try{
            usuarioRepository.deleteById(id);
            return Boolean.TRUE;
        } catch(Exception e) {
            return Boolean.FALSE;
        }
    }
}
