package com.vitvn183.demouploadfile.repositories;

import com.vitvn183.demouploadfile.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {
}
