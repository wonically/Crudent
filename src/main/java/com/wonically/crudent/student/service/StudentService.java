package com.wonically.crudent.student.service;

import com.wonically.crudent.school.model.request.SchoolCreationRequest;
import com.wonically.crudent.school.model.response.SchoolResponse;
import com.wonically.crudent.student.model.request.StudentCreationRequest;
import com.wonically.crudent.student.model.request.StudentUpdateRequest;
import com.wonically.crudent.student.model.response.StudentResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService {
    StudentResponse createStudent(StudentCreationRequest studentCreationRequest);

    List<StudentResponse> createStudents(List<StudentCreationRequest> studentCreationRequests);

//    Page<StudentResponse> getStudents(int pageNo);

    List<StudentResponse> getStudents();

    StudentResponse getStudent(String code);

//    Page<StudentResponse> getStudentBySchoolCode(String code, int pageNo);

    List<StudentResponse> getStudentBySchoolCode(String code);

    StudentResponse updateStudent(String code, StudentUpdateRequest studentUpdateRequest);
}
