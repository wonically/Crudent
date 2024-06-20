package com.wonically.crudent.controller;

import com.wonically.crudent.model.response.ApiResponse;
import com.wonically.crudent.model.request.StudentCreationRequest;
import com.wonically.crudent.model.request.StudentUpdateRequest;
import com.wonically.crudent.service.impl.StudentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
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

    @PatchMapping("/patch/{code}")
    ResponseEntity<ApiResponse> updateStudent (@Valid @PathVariable String code, @Valid @RequestBody StudentUpdateRequest studentUpdateRequest) {
        ApiResponse apiResponse = ApiResponse.builder()
                .result(studentServiceImpl.updateStudent(code, studentUpdateRequest))
                .build();
        return ResponseEntity.badRequest().body(apiResponse);
    }
}
