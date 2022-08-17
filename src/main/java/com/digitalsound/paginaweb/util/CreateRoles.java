package com.digitalsound.paginaweb.util;

import com.digitalsound.paginaweb.security.enums.RoleName;
import com.digitalsound.paginaweb.security.models.Role;
import com.digitalsound.paginaweb.security.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * MUY IMPORTANTE: ESTA CLASE SÓLO SE EJECUTARÁ UNA VEZ PARA CREAR LOS ROLES.
 * UNA VEZ CREADOS SE DEBERÁ ELIMINAR O BIEN COMENTAR EL CÓDIGO
 *
 */
@Component
public class CreateRoles  implements CommandLineRunner {
    @Autowired
    RoleService roleService;

    @Override
    public void run(String... args) throws Exception {
//        Role roleAdmin = new Role(RoleName.ROLE_ADMIN);
//        Role roleUser = new Role(RoleName.ROLE_USER);
//        roleService.save(roleAdmin);
//        roleService.save(roleUser);

    }
}