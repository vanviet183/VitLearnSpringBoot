package com.vitvn183.demouploadfile.repositories;

import com.vitvn183.demouploadfile.entities.Segment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SegmentRepository extends JpaRepository<Segment, Long> {
}
