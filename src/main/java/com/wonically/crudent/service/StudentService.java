package com.wonically.crudent.service;

import com.wonically.crudent.entity.Student;
import com.wonically.crudent.model.request.StudentCreationRequest;
import com.wonically.crudent.model.request.StudentUpdateRequest;

public interface StudentService {
    Student createStudent(StudentCreationRequest studentCreationRequest);

    Student getStudent(String code);

    Student updateStudent(String code, StudentUpdateRequest studentUpdateRequest);
}
