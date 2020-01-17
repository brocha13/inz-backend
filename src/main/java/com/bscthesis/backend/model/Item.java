package com.bscthesis.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@Data
public class Item {
    private int level;
    private String name;
    private int value;
}
