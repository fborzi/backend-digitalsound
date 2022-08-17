package com.digitalsound.paginaweb.models;

import com.digitalsound.paginaweb.security.models.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="category_id")
    @Getter @Setter private Integer id;

    @Column(name="category_name")
    @Getter @Setter private String name;

    @OneToMany
    @JoinColumn (name="subcategories_id")
    @Getter @Setter private Set<Subcategory> subcategories = new HashSet<>();
}
