package com.wonically.crudent.student.service;

import com.wonically.crudent.student.entity.Student;
import com.wonically.crudent.student.model.request.StudentCreationRequest;
import com.wonically.crudent.student.model.request.StudentUpdateRequest;

import java.util.List;

public interface StudentService {
    Student createStudent(StudentCreationRequest studentCreationRequest);

    List<Student> getStudents();

    Student getStudent(String code);

    Student updateStudent(String code, StudentUpdateRequest studentUpdateRequest);
}
