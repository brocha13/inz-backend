package com.bscthesis.backend.controller;

import com.bscthesis.backend.dto.CharacterRequest;
import com.bscthesis.backend.model.Character;
import com.bscthesis.backend.service.CharacterService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/characters",produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Characters")
public class CharacterController {

    @Autowired
    private CharacterService characterService;

    @GetMapping
    public Character getCharacter(@RequestParam String email){
        return characterService.getCharacterByUserEmail(email);
    }

    @PostMapping
    public Character createCharacter(@RequestBody CharacterRequest request) {
        return characterService.createCharacter(request);
    }
}
