package com.wonically.crudent.model.mapper;

import com.wonically.crudent.entity.Student;
import com.wonically.crudent.model.request.StudentCreationRequest;
import com.wonically.crudent.model.request.StudentUpdateRequest;
import com.wonically.crudent.model.response.StudentResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toStudent(StudentCreationRequest studentCreationRequest);

    @BeanMapping(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
    void toStudent(@MappingTarget Student student, StudentUpdateRequest studentUpdateRequest);

    StudentResponse toStudentResponse(Student student);
}
