package com.wonically.crudent.service;

import com.wonically.crudent.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();

    List<Student> findStudentById(Long id);

    List<Student> findStudentByCode(String code);

    List<Student> findStudentByNameContaining(String name);

    List<Student> findStudentByAge(int age);

    List<Student> findStudentByGender(String gender);

    List<Student> findStudentByPhoneNumberContaining(String phoneNumber);

    List<Student> findStudentByEmailContaining(String email);

    List<Student> findStudentByHeightBetweenOrderByHeightAsc(float height);

    List<Student> findStudentByWeightBetweenOrderByWeightAsc(float weight);

    List<Student> findStudentByBloodTypeStartingWith(String bloodType);

    List<Student> findStudentByNationality(String nationality);

    List<Student> findStudentByCreatedAtAfterOrderByCreatedAtAsc(String createdAt);

    List<Student> findStudentByUpdatedAtAfterOrderByUpdatedAtAsc(String updatedAt);

    Student createStudent(Student student);

    Student updateStudent(Long id, Student student);

    void deleteStudentById(Long id);

    void deleteStudentByCode(String code);
}
