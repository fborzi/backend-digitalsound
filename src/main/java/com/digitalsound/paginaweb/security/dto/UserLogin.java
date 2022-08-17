package com.digitalsound.paginaweb.security.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

public class UserLogin {

    @NotBlank
    @Getter @Setter private String username;
    @NotBlank
    @Getter @Setter private String password;

}
