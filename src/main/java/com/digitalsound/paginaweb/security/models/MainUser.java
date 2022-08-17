package com.digitalsound.paginaweb.security.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MainUser implements UserDetails {

    private String username;
    private String name;
    private String lastName;
//    private String email;
    private String password;
    private String business;
    private String dni;
    private Collection<? extends GrantedAuthority> authorities;

    public MainUser(String username,
                    String name,
                    String lastName,
//                    String email,
                    String password,
                    String business,
                    String dni,
                    Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.name = name;
        this.lastName = lastName;
//        this.email = email;
        this.password = password;
        this.business = business;
        this.dni = dni;
        this.authorities = authorities;
    }

    public static MainUser build(AppUser appUser){
        List<GrantedAuthority> authorities = appUser.getUserRoles()
                .stream().map(role -> new SimpleGrantedAuthority(role.getRoleName().name()))
                .collect(Collectors.toList());
        return new MainUser(appUser.getUsername(),
                            appUser.getName(),
                            appUser.getLastName(),
//                            appUser.getEmail(),
                            appUser.getPassword(),
                            appUser.getBusiness(),
                            appUser.getDni(),
                            authorities);
    }

    /*public static UsuarioPrincipal build(Usuario usuario){
        List<GrantedAuthority> authorities =
                usuario.getRoles().stream().map(rol -> new SimpleGrantedAuthority(rol
                        .getRolNombre().name())).collect(Collectors.toList());
        return new UsuarioPrincipal(usuario.getNombre(), usuario.getNombreUsuario(), usuario.getEmail(), usuario.getPassword(), authorities);
    }*/

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBusiness() {
        return business;
    }

    public String getDni() {
        return dni;
    }
}
