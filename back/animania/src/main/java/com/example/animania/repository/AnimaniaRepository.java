package com.example.animania.repository;

import com.example.animania.model.AnimaniaVO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimaniaRepository extends MongoRepository < AnimaniaVO, String > {

}
