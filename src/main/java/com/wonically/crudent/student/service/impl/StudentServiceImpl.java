package com.wonically.crudent.student.service.impl;

import com.wonically.crudent.exception.AppException;
import com.wonically.crudent.exception.ErrorCode;
import com.wonically.crudent.school.repository.SchoolRepository;
import com.wonically.crudent.student.entity.Student;
import com.wonically.crudent.student.model.mapper.StudentMapper;
import com.wonically.crudent.student.model.request.StudentCreationRequest;
import com.wonically.crudent.student.model.request.StudentUpdateRequest;
import com.wonically.crudent.student.model.response.StudentResponse;
import com.wonically.crudent.student.repository.StudentRepository;
import com.wonically.crudent.student.service.StudentService;
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
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    SchoolRepository schoolRepository;

    @Override
    public StudentResponse createStudent(StudentCreationRequest studentCreationRequest) {
        if (studentRepository.existsByCode(studentCreationRequest.getCode())) {
            throw new AppException(ErrorCode.CODE_EXISTED);
        }

        if (!schoolRepository.existsByCode(studentCreationRequest.getSchoolCode())) {
            throw new AppException(ErrorCode.SCHOOL_NOT_EXISTED);
        } else {
            studentCreationRequest.setSchool(schoolRepository.findByCode(studentCreationRequest.getSchoolCode()));
        }

        if (studentRepository.existsByPhoneNumber(studentCreationRequest.getPhoneNumber())) {
            throw new AppException(ErrorCode.PHONE_NUMBER_EXISTED);
        }

        if (studentRepository.existsByEmail(studentCreationRequest.getEmail())) {
            throw new AppException(ErrorCode.EMAIL_EXISTED);
        }

        Student newStudent = studentMapper.toStudent(studentCreationRequest);
        return studentMapper.toStudentResponse(studentRepository.save(newStudent));
    }

    @Override
    public Page<StudentResponse> getStudents(int pageNo) {
        return studentRepository.findAll(PageRequest.of(pageNo, 5)).map(studentMapper::toStudentResponse);
    }

    @Override
    public StudentResponse getStudent(String code) {
        Student student = studentRepository.findByCode(code);
        if (student == null) {
            throw new AppException(ErrorCode.STUDENT_NOT_EXISTED);
        }

        return studentMapper.toStudentResponse(student);
    }

    @Override
    public Page<StudentResponse> getStudentBySchoolCode(String code, int pageNo) {
        return studentRepository.findAllBySchool_Code(code, PageRequest.of(pageNo, 5)).map(studentMapper::toStudentResponse);
    }

    @Override
    public StudentResponse updateStudent(String code, StudentUpdateRequest studentUpdateRequest) {
        Student updatedStudent = studentRepository.findByCode(code);
        if (updatedStudent == null) {
            throw new AppException(ErrorCode.STUDENT_NOT_EXISTED);
        }
        if (studentUpdateRequest.getSchoolCode() != null && !schoolRepository.existsByCode(studentUpdateRequest.getSchoolCode())) {
            throw new AppException(ErrorCode.SCHOOL_NOT_EXISTED);
        } else if (studentUpdateRequest.getSchoolCode() != null) {
            studentUpdateRequest.setSchool(schoolRepository.findByCode(studentUpdateRequest.getSchoolCode()));
        }

        studentMapper.toStudent(updatedStudent, studentUpdateRequest);
        return studentMapper.toStudentResponse(studentRepository.save(updatedStudent));
    }
}
