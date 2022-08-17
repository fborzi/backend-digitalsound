package com.digitalsound.paginaweb.dto;

import com.digitalsound.paginaweb.models.Category;
import com.digitalsound.paginaweb.models.Subcategory;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Min;

public class ProductDto {

    @NotBlank
    @Getter @Setter
    private Integer code;
    @NotBlank
    @Getter @Setter
    private Category category;
    @NotBlank
    @Getter @Setter
    private Subcategory subcategory;
    @NotBlank
    @Getter @Setter
    private String name;
    @NotBlank
    @Getter @Setter
    private String description;
    @Min(0)
    @Getter @Setter
    private Double price;
    @NotBlank
    @Getter @Setter
    private String image;
    @NotBlank
    @Getter @Setter
    private int stock;
    @NotBlank
    @Getter @Setter
    private boolean active;

    public ProductDto(){}

    public ProductDto(Integer code,
                      Category category,
                      Subcategory subcategory,
                      String name,
                      String description,
                      Double price,
                      String image,
                      int stock,
                      boolean active){
        this.code = code;
        this.category = category;
        this.subcategory = subcategory;
        this.name = name;
        this.description = description;
        this.price = price;
        this.image = image;
        this.stock = stock;
        this.active = active;
    }
}
