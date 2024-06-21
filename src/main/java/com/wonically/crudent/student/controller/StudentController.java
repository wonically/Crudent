package com.wonically.crudent.student.controller;

import com.wonically.crudent.model.response.ApiResponse;
import com.wonically.crudent.student.model.request.StudentCreationRequest;
import com.wonically.crudent.student.model.request.StudentUpdateRequest;
import com.wonically.crudent.student.service.impl.StudentServiceImpl;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentController {
    @Autowired
    StudentServiceImpl studentServiceImpl;

    @PostMapping("/create")
    ApiResponse createStudent(@Valid @RequestBody StudentCreationRequest studentCreationRequest) {
        return ApiResponse.builder()
                .result(studentServiceImpl.createStudent(studentCreationRequest))
                .build();
    }

    @PostMapping("/creates")
    ApiResponse createStudents(@RequestBody @Valid List<StudentCreationRequest> studentCreationRequests) {
        return ApiResponse.builder()
                .result(studentServiceImpl.createStudents(studentCreationRequests))
                .build();
    }

    @GetMapping("/list/{pageNo}")
    ApiResponse getStudents(@PathVariable int pageNo) {
        return ApiResponse.builder()
               .result(studentServiceImpl.getStudents(pageNo - 1))
               .build();
    }

    @GetMapping("/{code}")
    ApiResponse getStudent(@PathVariable String code) {
        return ApiResponse.builder()
               .result(studentServiceImpl.getStudent(code))
               .build();
    }

    @GetMapping("/school/{code}/{pageNo}")
    ApiResponse getStudentBySchoolCode(@PathVariable String code, @PathVariable int pageNo) {
        return ApiResponse.builder()
                .result(studentServiceImpl.getStudentBySchoolCode(code, pageNo - 1))
                .build();
    }

    @PutMapping("/put/{code}")
    ApiResponse updateStudent (@Valid @PathVariable String code, @Valid @RequestBody StudentUpdateRequest studentUpdateRequest) {
        return ApiResponse.builder()
                .result(studentServiceImpl.updateStudent(code, studentUpdateRequest))
                .build();
    }
}
