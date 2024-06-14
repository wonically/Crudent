package com.wonically.crudent.service.impl;

import com.wonically.crudent.entity.Student;
import com.wonically.crudent.repository.StudentRepository;
import com.wonically.crudent.service.StudentService;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public List<Student> findStudentById(Long id) {
        return (List<Student>) studentRepository.findStudentById(id);
    }

    @Override
    public List<Student> findStudentByCode(String code) {
        return (List<Student>) studentRepository.findStudentByCode(code);
    }

    @Override
    public List<Student> findStudentByNameContaining(String name) {
        return studentRepository.findStudentByNameContaining(name);
    }

    @Override
    public List<Student> findStudentByAge(int age) {
        return studentRepository.findStudentByAge(age);
    }

    @Override
    public List<Student> findStudentByGender(String gender) {
        return studentRepository.findStudentByGender(gender);
    }

    @Override
    public List<Student> findStudentByPhoneNumberContaining(String phoneNumber) {
        return studentRepository.findStudentByPhoneNumberContaining(phoneNumber);
    }

    @Override
    public List<Student> findStudentByEmailContaining(String email) {
        return studentRepository.findStudentByEmailContaining(email);
    }

    @Override
    public List<Student> findStudentByHeightBetweenOrderByHeightAsc(float height) {
        return studentRepository.findStudentByHeightBetweenOrderByHeightAsc(height-5, height+5);
    }

    @Override
    public List<Student> findStudentByWeightBetweenOrderByWeightAsc(float weight) {
        return studentRepository.findStudentByWeightBetweenOrderByWeightAsc(weight-5, weight+5);
    }

    @Override
    public List<Student> findStudentByBloodTypeStartingWith(String bloodType) {
        return studentRepository.findStudentByBloodTypeStartingWith(bloodType);
    }

    @Override
    public List<Student> findStudentByNationality(String nationality) {
        return studentRepository.findStudentByNationality(nationality);
    }

    @Override
    public List<Student> findStudentByCreatedAtAfterOrderByCreatedAtAsc(String createdAt) {
        return studentRepository.findStudentByCreatedAtAfterOrderByCreatedAtAsc(createdAt);
    }

    @Override
    public List<Student> findStudentByUpdatedAtAfterOrderByUpdatedAtAsc(String updatedAt) {
        return studentRepository.findStudentByUpdatedAtAfterOrderByUpdatedAtAsc(updatedAt);
    }

    @Override
    public Student createStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        return studentRepository.updateByStudent(id,
                student.getName(),
                student.getAge(),
                student.getGender(),
                student.getPhoneNumber(),
                student.getAddress(),
                student.getEmail(),
                student.getHeight(),
                student.getWeight(),
                student.getBloodType(),
                student.getNationality(),
                new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteStudentById(id);
    }

    @Override
    public void deleteStudentByCode(String code) {
        studentRepository.deleteStudentByCode(code);
    }
}
