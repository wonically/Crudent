package com.wonically.crudent.service;

import com.wonically.crudent.entity.Student;
import com.wonically.crudent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    public Student findStudentByCode(String code) {
        return studentRepository.findStudentByCode(code);
    }

    public List<Student> findStudentByNameContaining(String name) {
        return studentRepository.findStudentByNameContaining(name);
    }

    public List<Student> findStudentByAge(int age) {
        return studentRepository.findStudentByAge(age);
    }

    public List<Student> findStudentByGender(String gender) {
        return studentRepository.findStudentByGender(gender);
    }

    public List<Student> findStudentByPhoneNumberContaining(String phoneNumber) {
        return studentRepository.findStudentByPhoneNumberContaining(phoneNumber);
    }

    public List<Student> findStudentByEmailContaining(String email) {
        return studentRepository.findStudentByEmailContaining(email);
    }

    public List<Student> findStudentByHeightBetweenOrderByHeightAsc(float height) {
        return studentRepository.findStudentByHeightBetweenOrderByHeightAsc(height - 5, height + 5);
    }

    public List<Student> findStudentByWeightBetweenOrderByWeightAsc(float weight) {
        return studentRepository.findStudentByWeightBetweenOrderByWeightAsc(weight - 5, weight + 5);
    }

    public List<Student> findStudentByBloodTypeStartingWith(String bloodType) {
        return studentRepository.findStudentByBloodTypeStartingWith(bloodType);
    }

    public List<Student> findStudentByNationality(String nationality) {
        return studentRepository.findStudentByNationality(nationality);
    }

//    public List<Student> findStudentByCreatedAtAfterOrderByCreatedAtAsc(String createdAt) {
//        return studentRepository.findStudentByCreatedAtAfterOrderByCreatedAtAsc(createdAt);
//    }
//
//    public List<Student> findStudentByUpdatedAtAfterOrderByUpdatedAtAsc(String updatedAt) {
//        return studentRepository.findStudentByUpdatedAtAfterOrderByUpdatedAtAsc(updatedAt);
//    }

    public Student createStudent(Student student) {
        studentRepository.save(student);
        return student;
    }

//    public Student updateStudent(Long id, Student student) {
//        return studentRepository.updateByStudent(id,
//                student.getName(),
//                student.getAge(),
//                student.getGender(),
//                student.getPhoneNumber(),
//                student.getAddress(),
//                student.getEmail(),
//                student.getHeight(),
//                student.getWeight(),
//                student.getBloodType(),
//                student.getNationality(),
//                new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date()));
//    }
//
//    public void deleteStudentById(Long id) {
//        studentRepository.deleteStudentById(id);
//    }
//
//    public void deleteStudentByCode(String code) {
//        studentRepository.deleteStudentByCode(code);
//    }
}
