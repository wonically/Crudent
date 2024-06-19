package com.wonically.crudent.repository;

import com.wonically.crudent.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Boolean existsByCode(String code);
    Boolean existsByPhoneNumber(String phoneNumber);
    Boolean existsByEmail(String email);
    Student findByCode(String code);
}
