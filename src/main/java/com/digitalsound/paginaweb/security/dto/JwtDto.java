package com.digitalsound.paginaweb.security.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class JwtDto {
    @Getter @Setter private String token;
//    @Getter @Setter private String bearer = "Bearer";
//    @Getter @Setter private String username;
//    @Getter @Setter private Collection<? extends GrantedAuthority> authorities;

    public JwtDto(String token) {
        this.token = token;
//        this.username = username;
//        this.authorities = authorities;
    }
}
