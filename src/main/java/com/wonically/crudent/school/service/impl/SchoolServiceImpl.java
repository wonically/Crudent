package com.wonically.crudent.school.service.impl;

import com.wonically.crudent.exception.AppException;
import com.wonically.crudent.exception.ErrorCode;
import com.wonically.crudent.school.entity.School;
import com.wonically.crudent.school.model.mapper.SchoolMapper;
import com.wonically.crudent.school.model.request.SchoolCreationRequest;
import com.wonically.crudent.school.model.request.SchoolUpdateRequest;
import com.wonically.crudent.school.repository.SchoolRepository;
import com.wonically.crudent.school.service.SchoolService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    SchoolRepository schoolRepository;
    @Autowired
    SchoolMapper schoolMapper;

    @Override
    public School createSchool(SchoolCreationRequest schoolCreationRequest) {
        if (schoolRepository.existsByCode(schoolCreationRequest.getCode())) {
            throw new AppException(ErrorCode.CODE_EXISTED);
        }

        if (schoolRepository.existsByAddress(schoolCreationRequest.getAddress())) {
            throw new AppException(ErrorCode.PHONE_NUMBER_EXISTED);
        }

        if (schoolRepository.existsByWebsite(schoolCreationRequest.getWebsite())) {
            throw new AppException(ErrorCode.WEBSITE_EXISTED);
        }

        if (schoolRepository.existsByEmail(schoolCreationRequest.getEmail())) {
            throw new AppException(ErrorCode.EMAIL_EXISTED);
        }

        School newSchool = schoolMapper.toSchool(schoolCreationRequest);

        return schoolRepository.save(newSchool);
    }

    @Override
    public List<School> getSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public School getSchool(String code) {
        School school = schoolRepository.findByCode(code);
        if (school == null) {
            throw new AppException(ErrorCode.SCHOOL_NOT_EXISTED);
        }
        return school;
    }

    @Override
    public School updateSchool(String code, SchoolUpdateRequest schoolUpdateRequest) {
        School updatedSchool = schoolRepository.findByCode(code);
        if (updatedSchool == null) {
            throw new AppException(ErrorCode.SCHOOL_NOT_EXISTED);
        }

        schoolMapper.toSchool(updatedSchool, schoolUpdateRequest);

        return schoolRepository.save(updatedSchool);
    }
}
