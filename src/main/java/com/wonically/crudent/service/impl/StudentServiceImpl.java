package com.wonically.crudent.service.impl;

import com.wonically.crudent.entity.Student;
import com.wonically.crudent.repository.StudentRepository;
import com.wonically.crudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        Student newStudent = Student.builder()
                .code(student.getCode())
                .name(student.getName())
                .age(student.getAge())
                .gender(student.getGender())
                .phoneNumber(student.getPhoneNumber())
                .address(student.getAddress())
                .email(student.getEmail())
                .height(student.getHeight())
                .weight(student.getWeight())
                .bloodType(student.getBloodType())
                .nationality(student.getNationality())
                .status(student.getStatus())
                .build();
        return studentRepository.save(newStudent);
    }
}
