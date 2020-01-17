package com.bscthesis.backend.repository;

import com.bscthesis.backend.model.Character;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CharacterRepository extends MongoRepository <Character, String> {

    Optional<Character> findFirstByName(String name);
}
