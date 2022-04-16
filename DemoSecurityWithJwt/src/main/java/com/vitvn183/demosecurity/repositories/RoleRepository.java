package com.vitvn183.demosecurity.repositories;

import com.vitvn183.demosecurity.common.ERole;
import com.vitvn183.demosecurity.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);
}
