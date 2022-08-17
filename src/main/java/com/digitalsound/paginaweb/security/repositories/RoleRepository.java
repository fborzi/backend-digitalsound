package com.digitalsound.paginaweb.security.repositories;

import com.digitalsound.paginaweb.security.enums.RoleName;
import com.digitalsound.paginaweb.security.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Optional<Role> findByRoleName(RoleName roleName);
}

