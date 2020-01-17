package com.bscthesis.backend.dto;

import io.swagger.annotations.ApiModel;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@ApiModel
@Getter
public class CharacterRequest {

    @NotBlank
    private String name;

    private String description;
}
