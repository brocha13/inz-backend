package com.bscthesis.backend.controller;

import com.bscthesis.backend.dto.RegisterRequest;
import com.bscthesis.backend.model.User;
import com.bscthesis.backend.service.MongoUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    MongoUserDetailsService userDetailsService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody RegisterRequest request){
        return userDetailsService.createUser(request);
    }
}
