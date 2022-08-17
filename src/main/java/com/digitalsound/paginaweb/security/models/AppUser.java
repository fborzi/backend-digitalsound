package com.digitalsound.paginaweb.security.models;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private int id;

    @NotNull
    @Column(unique = true)
    @Getter @Setter private String username;

    @NotNull
    @Getter @Setter private String name;

    @NotNull
    @Getter @Setter private String lastName;

//    @Column(unique = true)
//    @Getter @Setter private String email;

    @NotNull
    @Getter @Setter private String password;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @Getter @Setter private Set<Role> userRoles = new HashSet<>();

    @NotNull
    @Getter @Setter private String business;

    @NotNull
    @Getter @Setter private String dni;

    public AppUser(){}

    public AppUser(@NotNull String username,
                @NotNull String name,
                @NotNull String lastName,
//                @NotNull String email,
                @NotNull String password,
                @NotNull String business,
                @NotNull String dni) {
        this.username = username;
        this.name = name;
        this.lastName = lastName;
//        this.email = email;
        this.password = password;
        this.business = business;
        this.dni = dni;
    }



}
