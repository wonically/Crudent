package com.wonically.crudent.student.model.mapper;

import com.wonically.crudent.student.entity.Student;
import com.wonically.crudent.student.model.request.StudentCreationRequest;
import com.wonically.crudent.student.model.request.StudentUpdateRequest;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    Student toStudent(StudentCreationRequest studentCreationRequest);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void toStudent(@MappingTarget Student student, StudentUpdateRequest studentUpdateRequest);
}
