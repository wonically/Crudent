package com.wonically.crudent.school.repository;

import com.wonically.crudent.school.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SchoolRepository extends JpaRepository<School, UUID> {
    Boolean existsByCode(String code);
    Boolean existsByAddress(String address);
    Boolean existsByWebsite(String website);
    Boolean existsByEmail(String email);
    School findByCode(String code);
}
