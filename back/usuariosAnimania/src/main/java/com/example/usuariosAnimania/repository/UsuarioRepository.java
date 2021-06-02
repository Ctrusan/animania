package com.example.usuariosAnimania.repository;

import com.example.usuariosAnimania.model.UsuarioVO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuarioRepository extends MongoRepository<UsuarioVO, String >  {
}
