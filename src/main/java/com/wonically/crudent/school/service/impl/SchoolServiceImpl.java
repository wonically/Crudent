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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        if (schoolRepository.existsBySchoolCode(schoolCreationRequest.getSchoolCode())) {
            throw new AppException(ErrorCode.CODE_EXISTED);
        }

        if (schoolRepository.existsByAddress(schoolCreationRequest.getAddress())) {
            throw new AppException(ErrorCode.ADDRESS_EXISTED);
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
    public List<SchoolResponse> createSchools(List<SchoolCreationRequest> schoolCreationRequests) {
        List<SchoolResponse> result = new ArrayList<>();
        for (SchoolCreationRequest schoolCreationRequest : schoolCreationRequests) {
            try {
                School newSchool = schoolMapper.toSchool(schoolCreationRequest);
                schoolRepository.save(newSchool);
                result.add(schoolMapper.toSchoolResponse(newSchool));
            } catch (RuntimeException exception) {
                result.add(SchoolResponse.builder()
                                .code(schoolCreationRequest.getSchoolCode())
                                .name("Error saving " + schoolCreationRequest.getName())
                                .address(exception.getMessage())
                                .build());
            }
        };
        return result;
    }

//    @Override
//    public Page<SchoolResponse> getSchools(int pageNo) {
//        return schoolRepository.findAll(PageRequest.of(pageNo, 5)).map(schoolMapper::toSchoolResponse);
//    }

    @Override
    public List<SchoolResponse> getSchools() {
        return schoolRepository.findAll().stream().map(schoolMapper::toSchoolResponse).toList();
    }

    @Override
    public SchoolResponse getSchool(String code) {
        School school = schoolRepository.findBySchoolCode(code);
        if (school == null) {
            throw new AppException(ErrorCode.SCHOOL_NOT_EXISTED);
        }
        return schoolMapper.toSchoolResponse(school);
    }

    @Override
    public SchoolResponse updateSchool(String code, SchoolUpdateRequest schoolUpdateRequest) {
        School updatedSchool = schoolRepository.findBySchoolCode(code);
        if (updatedSchool == null) {
            throw new AppException(ErrorCode.SCHOOL_NOT_EXISTED);
        }

        schoolMapper.toSchool(updatedSchool, schoolUpdateRequest);

        return schoolMapper.toSchoolResponse(schoolRepository.save(updatedSchool));
    }
}
