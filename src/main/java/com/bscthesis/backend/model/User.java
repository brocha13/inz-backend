package com.bscthesis.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Document
public class User{
    @Id
    private ObjectId id;

    @NonNull
    @Indexed(unique = true)
    private String username;

    @NonNull
    private String password;

    @NonNull
    @Indexed(unique = true)
    private Character character;

    private Set<String> roles;

    public String getId() {
        return id.toString();
    }
}
