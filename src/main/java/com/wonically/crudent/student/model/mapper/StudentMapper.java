package com.wonically.crudent.student.model.mapper;

import com.wonically.crudent.student.entity.Student;
import com.wonically.crudent.student.model.request.StudentCreationRequest;
import com.wonically.crudent.student.model.request.StudentUpdateRequest;
import com.wonically.crudent.student.model.response.StudentResponse;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toStudent(StudentCreationRequest studentCreationRequest);

    @Mapping(target = "schoolName", expression = "java(student.getSchool().getName())")
    StudentResponse toStudentResponse(Student student);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toStudent(@MappingTarget Student student, StudentUpdateRequest studentUpdateRequest);
}
