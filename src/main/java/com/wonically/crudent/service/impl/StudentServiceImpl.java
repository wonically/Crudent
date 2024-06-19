package com.wonically.crudent.service.impl;

import com.wonically.crudent.entity.Student;
import com.wonically.crudent.exception.AppException;
import com.wonically.crudent.exception.ErrorCode;
import com.wonically.crudent.model.request.StudentCreationRequest;
import com.wonically.crudent.model.request.StudentUpdateRequest;
import com.wonically.crudent.repository.StudentRepository;
import com.wonically.crudent.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;

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

        Student newStudent = Student.builder()
                .code(studentCreationRequest.getCode())
                .name(studentCreationRequest.getName())
                .age(studentCreationRequest.getAge())
                .gender(studentCreationRequest.getGender())
                .phoneNumber(studentCreationRequest.getPhoneNumber())
                .address(studentCreationRequest.getAddress())
                .email(studentCreationRequest.getEmail())
                .active(studentCreationRequest.getActive())
                .build();
        return studentRepository.save(newStudent);
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

        if (studentUpdateRequest.getName() != null) {
            updatedStudent.setName(studentUpdateRequest.getName());
        }

        if (studentUpdateRequest.getAge() != null) {
            updatedStudent.setAge(studentUpdateRequest.getAge());
        }

        if (studentUpdateRequest.getGender() != null) {
            updatedStudent.setGender(studentUpdateRequest.getGender());
        }

        if (studentUpdateRequest.getPhoneNumber() != null) {
            updatedStudent.setPhoneNumber(studentUpdateRequest.getPhoneNumber());
        }

        if (studentUpdateRequest.getAddress() != null) {
            updatedStudent.setAddress(studentUpdateRequest.getAddress());
        }

        if (studentUpdateRequest.getEmail() != null) {
            updatedStudent.setEmail(studentUpdateRequest.getEmail());
        }

        if (studentUpdateRequest.getActive() != null) {
            updatedStudent.setActive(studentUpdateRequest.getActive());
        }

        return studentRepository.save(updatedStudent);
    }
}
