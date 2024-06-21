package com.wonically.crudent.school.service.impl;

import com.wonically.crudent.exception.AppException;
import com.wonically.crudent.exception.ErrorCode;
import com.wonically.crudent.school.entity.School;
import com.wonically.crudent.school.model.mapper.SchoolMapper;
import com.wonically.crudent.school.model.request.SchoolCreationRequest;
import com.wonically.crudent.school.model.request.SchoolUpdateRequest;
import com.wonically.crudent.school.model.response.SchoolResponse;
import com.wonically.crudent.school.repository.SchoolRepository;
import com.wonically.crudent.school.service.SchoolService;
import com.wonically.crudent.student.model.mapper.StudentMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class SchoolServiceImpl implements SchoolService {
    @Autowired
    SchoolRepository schoolRepository;
    @Autowired
    SchoolMapper schoolMapper;
    @Autowired
    StudentMapper studentMapper;

    @Override
    public SchoolResponse createSchool(SchoolCreationRequest schoolCreationRequest) {
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

        return schoolMapper.toSchoolResponse(schoolRepository.save(newSchool));
    }

    @Override
    public Page<SchoolResponse> getSchools(int pageNo) {
        return schoolRepository.findAll(PageRequest.of(pageNo, 5)).map(schoolMapper::toSchoolResponse);
    }

    @Override
    public SchoolResponse getSchool(String code) {
        School school = schoolRepository.findByCode(code);
        if (school == null) {
            throw new AppException(ErrorCode.SCHOOL_NOT_EXISTED);
        }
        return schoolMapper.toSchoolResponse(school);
    }

    @Override
    public SchoolResponse updateSchool(String code, SchoolUpdateRequest schoolUpdateRequest) {
        School updatedSchool = schoolRepository.findByCode(code);
        if (updatedSchool == null) {
            throw new AppException(ErrorCode.SCHOOL_NOT_EXISTED);
        }

        schoolMapper.toSchool(updatedSchool, schoolUpdateRequest);

        return schoolMapper.toSchoolResponse(schoolRepository.save(updatedSchool));
    }
}
