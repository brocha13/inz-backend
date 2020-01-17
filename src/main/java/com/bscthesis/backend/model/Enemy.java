package com.bscthesis.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@Data
public class Enemy {

    private String name;
    private int health;
    private int damage;
}
