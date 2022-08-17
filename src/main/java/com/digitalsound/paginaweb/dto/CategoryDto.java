package com.digitalsound.paginaweb.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class CategoryDto {
    @NotBlank
    @Getter
    @Setter
    private String name;

    public CategoryDto(){}

    public CategoryDto(String name) {
        this.name = name;
    }
}
