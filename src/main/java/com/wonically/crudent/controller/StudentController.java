package com.wonically.crudent.controller;

import com.wonically.crudent.model.response.ApiResponse;
import com.wonically.crudent.model.request.StudentCreationRequest;
import com.wonically.crudent.model.request.StudentUpdateRequest;
import com.wonically.crudent.service.impl.StudentServiceImpl;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
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
    ResponseEntity<ApiResponse> getStudent(String code) {
        ApiResponse apiResponse = ApiResponse.builder()
               .result(studentServiceImpl.getStudent(code))
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
