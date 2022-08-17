package com.digitalsound.paginaweb.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    @Getter @Setter private Integer id;

    @Column(name="product_code")
    @Getter @Setter private Integer code;

    //@OneToOne
    @Column(name="product_category")
    @Getter @Setter private Category category;

    //@OneToOne
    @Column(name="product_subcategory")
    @Getter @Setter private Subcategory subcategory;
    @Column(name="product_name")
    @Getter @Setter private String name;
    @Column(name="product_description")
    @Getter @Setter private String description;
    @Column(name="product_price")
    @Getter @Setter private double price;
    @Column(name="product_image")
    @Getter @Setter private String image;
    @Column(name="product_stock")
    @Getter @Setter private int stock;
    @Column(name="active")
    @Getter @Setter private boolean active;


    public Product() {
    }

    public Product(Category category,
                   Subcategory subcategory,
                   String name,
                   String description,
                   double price,
                   String image,
                   int stock,
                   boolean active){
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
