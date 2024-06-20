package com.wonically.crudent.service.impl;

import com.wonically.crudent.entity.Student;
import com.wonically.crudent.exception.AppException;
import com.wonically.crudent.exception.ErrorCode;
import com.wonically.crudent.model.mapper.StudentMapper;
import com.wonically.crudent.model.request.StudentCreationRequest;
import com.wonically.crudent.model.request.StudentUpdateRequest;
import com.wonically.crudent.repository.StudentRepository;
import com.wonically.crudent.service.StudentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    StudentMapper studentMapper;

    @Override
    public Student createStudent(StudentCreationRequest studentCreationRequest) {
        if (studentRepository.existsByCode(studentCreationRequest.getCode())) {
            throw new AppException(ErrorCode.CODE_EXISTED);
        }

        if (studentRepository.existsByPhoneNumber(studentCreationRequest.getPhoneNumber())) {
            throw new AppException(ErrorCode.PHONE_NUMBER_EXISTED);
        }

        if (studentRepository.existsByEmail(studentCreationRequest.getEmail())) {
            throw new AppException(ErrorCode.EMAIL_EXISTED);
        }

        Student newStudent = studentMapper.toStudent(studentCreationRequest);

        return studentRepository.save(newStudent);
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudent(String code) {
        Student student = studentRepository.findByCode(code);
        if (student == null) {
            throw new AppException(ErrorCode.STUDENT_NOT_EXISTED);
        }
        return student;
    }

    @Override
    public Student updateStudent(String code, StudentUpdateRequest studentUpdateRequest) {
        Student updatedStudent = studentRepository.findByCode(code);
        if (updatedStudent == null) {
            throw new AppException(ErrorCode.STUDENT_NOT_EXISTED);
        }

        studentMapper.toStudent(updatedStudent, studentUpdateRequest);

        return studentRepository.save(updatedStudent);
    }
}
