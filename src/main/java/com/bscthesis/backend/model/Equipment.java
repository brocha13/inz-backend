package com.bscthesis.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@Data
public class Equipment {
    private Item chest;
    private Item head;
    private Item legs;
    private Item feet;
    private Item mainHand;
    private Item offHand;
}
