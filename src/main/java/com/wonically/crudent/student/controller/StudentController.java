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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentController {
    @Autowired
    StudentServiceImpl studentServiceImpl;

    @PostMapping("/create")
    ResponseEntity<ApiResponse> createStudent(@Valid @RequestBody StudentCreationRequest studentCreationRequest) {
        ApiResponse apiResponse = ApiResponse.builder()
                .result(studentServiceImpl.createStudent(studentCreationRequest))
                .build();
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @GetMapping("/list")
    ResponseEntity<ApiResponse> getStudents() {
        ApiResponse apiResponse = ApiResponse.builder()
               .result(studentServiceImpl.getStudents())
               .build();
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @GetMapping("/{code}")
    ResponseEntity<ApiResponse> getStudent(@PathVariable String code) {
        ApiResponse apiResponse = ApiResponse.builder()
               .result(studentServiceImpl.getStudent(code))
               .build();
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @PutMapping("/put/{code}")
    ResponseEntity<ApiResponse> updateStudent (@Valid @PathVariable String code, @Valid @RequestBody StudentUpdateRequest studentUpdateRequest) {
        ApiResponse apiResponse = ApiResponse.builder()
                .result(studentServiceImpl.updateStudent(code, studentUpdateRequest))
                .build();
        return ResponseEntity.badRequest().body(apiResponse);
    }
}
