package com.wonically.crudent.controller;

import com.wonically.crudent.entity.Student;
import com.wonically.crudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/studentservice")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/list")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/search/{field}/{value}")
    public List<Student> search(@PathVariable String field, @PathVariable String value) {
        return switch (field) {
            case "id" -> studentService.findStudentById(Long.valueOf(value));
            case "code" -> studentService.findStudentByCode(value);
            case "name" -> studentService.findStudentByNameContaining(value);
            case "age" -> studentService.findStudentByAge(Integer.parseInt(value));
            case "gender" -> studentService.findStudentByGender(value);
            case "phoneNumber" -> studentService.findStudentByPhoneNumberContaining(value);
            case "email" -> studentService.findStudentByEmailContaining(value);
            case "height" -> studentService.findStudentByHeightBetweenOrderByHeightAsc(Float.parseFloat(value));
            case "weight" -> studentService.findStudentByWeightBetweenOrderByWeightAsc(Float.parseFloat(value));
            case "bloodType" -> studentService.findStudentByBloodTypeStartingWith(value);
            case "nationality" -> studentService.findStudentByNationality(value);
            case "createdAt" -> studentService.findStudentByCreatedAtAfterOrderByCreatedAtAsc(value);
            case "updatedAt" -> studentService.findStudentByUpdatedAtAfterOrderByUpdatedAtAsc(value);
            default -> studentService.findAll();
        };
    }
}

