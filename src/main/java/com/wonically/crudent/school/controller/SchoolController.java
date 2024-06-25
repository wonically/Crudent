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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/school")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SchoolController {
    @Autowired
    SchoolServiceImpl schoolServiceImpl;

    @PostMapping("/create")
    ApiResponse createSchool(@Valid @RequestBody SchoolCreationRequest schoolCreationRequest) {
        return ApiResponse.builder()
                .result(schoolServiceImpl.createSchool(schoolCreationRequest))
                .build();
    }

    @PostMapping("/creates")
    ApiResponse createSchools(@RequestBody List<@Valid SchoolCreationRequest> schoolCreationRequests) {
        return ApiResponse.builder()
               .result(schoolServiceImpl.createSchools(schoolCreationRequests))
               .build();
    }

//    @GetMapping("/list/{pageNo}")
//    ApiResponse getSchools(@PathVariable int pageNo) {
//        return ApiResponse.builder()
//                .result(schoolServiceImpl.getSchools(pageNo - 1))
//                .build();
//    }

    @GetMapping("/list")
    ApiResponse getSchools() {
        return ApiResponse.builder()
                .result(schoolServiceImpl.getSchools())
                .build();
    }

    @GetMapping("/{code}")
    ApiResponse getSchool(@PathVariable String code) {
        return ApiResponse.builder()
                .result(schoolServiceImpl.getSchool(code))
                .build();
    }

    @PutMapping("/put/{code}")
    ApiResponse updateSchool (@Valid @PathVariable String code, @Valid @RequestBody SchoolUpdateRequest schoolUpdateRequest) {
        return ApiResponse.builder()
                .result(schoolServiceImpl.updateSchool(code, schoolUpdateRequest))
                .build();
    }
}
