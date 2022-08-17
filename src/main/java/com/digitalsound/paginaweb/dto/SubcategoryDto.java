package com.digitalsound.paginaweb.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class SubcategoryDto {
    @NotBlank
    @Getter
    @Setter
    private String name;

    public SubcategoryDto(){}

    public SubcategoryDto(String name){
        this.name = name;
    }
}
