package com.digitalsound.paginaweb.security.services;

import com.digitalsound.paginaweb.security.enums.RoleName;
import com.digitalsound.paginaweb.security.models.Role;
import com.digitalsound.paginaweb.security.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Optional<Role> findByName(RoleName roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    public void save(Role role) {
        roleRepository.save(role);
    }
}
