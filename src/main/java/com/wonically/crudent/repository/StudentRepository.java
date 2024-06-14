package com.wonically.crudent.repository;

import com.wonically.crudent.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
