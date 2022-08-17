package com.digitalsound.paginaweb.models;

import com.digitalsound.paginaweb.security.models.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Subcategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="subcategory_id")
    @Getter @Setter private Integer id;

    @Column(name="subcategory_name")
    @Getter @Setter private String name;

    @OneToMany
    @JoinColumn (name="product_id")
    @Getter @Setter private Set<Product> products = new HashSet<>();
}
