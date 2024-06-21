package com.wonically.crudent.student.repository;

import com.wonically.crudent.student.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {
    Boolean existsByCode(String code);
    Boolean existsByPhoneNumber(String phoneNumber);
    Boolean existsByEmail(String email);
    Student findByCode(String code);
    Page<Student> findAllBySchool_Code(String code, Pageable pageable);
}
