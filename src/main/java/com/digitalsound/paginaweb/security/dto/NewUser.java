package com.digitalsound.paginaweb.security.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

public class NewUser {
    @NotBlank
    @Getter @Setter private String username;
    @NotBlank
    @Getter @Setter private String name;
    @NotBlank
    @Getter @Setter private String lastName;
//    @Email
//    @Getter @Setter private String email;
    @NotBlank
    @Getter @Setter private String password;
    @NotBlank
    @Getter @Setter private String business;
    @NotBlank
    @Getter @Setter private String dni;

    @Getter @Setter private Set<String> userRoles = new HashSet<>();
}
