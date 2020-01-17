package com.bscthesis.backend.service;

import com.bscthesis.backend.dto.CharacterRequest;
import com.bscthesis.backend.model.Character;
import com.bscthesis.backend.model.User;
import com.bscthesis.backend.repository.CharacterRepository;
import com.bscthesis.backend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CharacterService {

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private UserRepository userRepository;

    public Character getCharacterByUserEmail(String userEmail) {
        Optional<User> user = userRepository.findByUsername(userEmail);
        Character character;
        if(user.isPresent()) {
            character = user.get().getCharacter();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
        }
        return character;
    }

    public Character createCharacter(CharacterRequest request) {
        Character character = new Character();
        character.setName(request.getName());
        return characterRepository.save(character);
    }
}
