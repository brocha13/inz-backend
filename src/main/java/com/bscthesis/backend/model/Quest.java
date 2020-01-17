package com.bscthesis.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@Data
public class Quest {
    private int level;
    private Enemy enemy;
    private Item item;
}
