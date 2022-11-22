package com.vitvn183.demosendmailfromfile.repositories;

import com.vitvn183.demosendmailfromfile.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
