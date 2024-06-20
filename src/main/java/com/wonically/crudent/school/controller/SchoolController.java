package com.wonically.crudent.school.controller;

import com.wonically.crudent.model.response.ApiResponse;
import com.wonically.crudent.school.model.request.SchoolCreationRequest;
import com.wonically.crudent.school.model.request.SchoolUpdateRequest;
import com.wonically.crudent.school.service.impl.SchoolServiceImpl;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/school")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SchoolController {
    @Autowired
    SchoolServiceImpl schoolServiceImpl;

    @PostMapping("/create")
    ResponseEntity<ApiResponse> createSchool(@Valid @RequestBody SchoolCreationRequest schoolCreationRequest) {
        ApiResponse apiResponse = ApiResponse.builder()
                .result(schoolServiceImpl.createSchool(schoolCreationRequest))
                .build();
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @GetMapping("/list")
    ResponseEntity<ApiResponse> getSchools() {
        ApiResponse apiResponse = ApiResponse.builder()
                .result(schoolServiceImpl.getSchools())
                .build();
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @GetMapping("/{code}")
    ResponseEntity<ApiResponse> getSchool(@PathVariable String code) {
        ApiResponse apiResponse = ApiResponse.builder()
                .result(schoolServiceImpl.getSchool(code))
                .build();
        return ResponseEntity.badRequest().body(apiResponse);
    }

    @PutMapping("/put/{code}")
    ResponseEntity<ApiResponse> updateSchool (@Valid @PathVariable String code, @Valid @RequestBody SchoolUpdateRequest schoolUpdateRequest) {
        ApiResponse apiResponse = ApiResponse.builder()
                .result(schoolServiceImpl.updateSchool(code, schoolUpdateRequest))
                .build();
        return ResponseEntity.badRequest().body(apiResponse);
    }
}
