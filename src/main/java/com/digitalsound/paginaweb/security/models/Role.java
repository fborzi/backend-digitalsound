package com.digitalsound.paginaweb.security.models;

import com.digitalsound.paginaweb.security.enums.RoleName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private int id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Setter private RoleName roleName;

    public Role(){}

    public Role(@NotNull RoleName roleName) {
        this.roleName = roleName;
    }

    public RoleName getRoleName() {
        return roleName;
    }
}
