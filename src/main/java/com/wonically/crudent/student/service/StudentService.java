package com.wonically.crudent.student.service;

import com.wonically.crudent.student.model.request.StudentCreationRequest;
import com.wonically.crudent.student.model.request.StudentUpdateRequest;
import com.wonically.crudent.student.model.response.StudentResponse;
import org.springframework.data.domain.Page;

public interface StudentService {
    StudentResponse createStudent(StudentCreationRequest studentCreationRequest);

    Page<StudentResponse> getStudents(int pageNo);

    StudentResponse getStudent(String code);

    Page<StudentResponse> getStudentBySchoolCode(String code, int pageNo);

    StudentResponse updateStudent(String code, StudentUpdateRequest studentUpdateRequest);
}
