package com.wonically.crudent.service.impl;

import com.wonically.crudent.repository.StudentRepository;
import com.wonically.crudent.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    StudentRepository studentRepository;
}
