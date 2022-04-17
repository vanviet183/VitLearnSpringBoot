package com.vitvn183.demouploadfile.repositories;

import com.vitvn183.demouploadfile.entity.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileDBRepository extends JpaRepository<FileDB, Long> {

    Optional<FileDB> findById(String id);
}
