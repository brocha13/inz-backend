package com.bscthesis.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Character {

    @Id
    private String id;

    @NonNull
    @Indexed(unique = true)
    private String name;

    private int health = 100;

    private int level = 1;
    private int damage = 10;
    private int armor = 0;

    private int strength = 10;
    private int agility = 10;
    private int intelligence = 10;
    private int stamina = 10;
    private int luck = 10;

    private int gold = 0;
    private Equipment equipment;
    private List<Item> items;
    private List<Equipment> itemsInShop;
}
