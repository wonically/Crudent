package com.wonically.crudent.repository;

import com.wonically.crudent.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
//    List<Student> getStudents();
//    Student getStudentById(Long id);
//    Student createStudent(Student student);
//    Student updateById(Long id);
//    void deleteById(Long id);
}
