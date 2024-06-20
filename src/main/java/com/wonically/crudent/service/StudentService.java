package com.wonically.crudent.service;

import com.wonically.crudent.entity.Student;
import com.wonically.crudent.model.request.StudentCreationRequest;
import com.wonically.crudent.model.request.StudentUpdateRequest;

import java.util.List;

public interface StudentService {
    Student createStudent(StudentCreationRequest studentCreationRequest);

    List<Student> getStudents();

    Student getStudent(String code);

    Student updateStudent(String code, StudentUpdateRequest studentUpdateRequest);
}
