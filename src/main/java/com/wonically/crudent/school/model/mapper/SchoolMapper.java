package com.wonically.crudent.school.model.mapper;

import com.wonically.crudent.school.entity.School;
import com.wonically.crudent.school.model.request.SchoolCreationRequest;
import com.wonically.crudent.school.model.request.SchoolUpdateRequest;
import com.wonically.crudent.school.model.response.SchoolResponse;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface SchoolMapper {
    School toSchool(SchoolCreationRequest schoolCreationRequest);

    SchoolResponse toSchoolResponse(School school);

    @BeanMapping(nullValuePropertyMappingStrategy =  NullValuePropertyMappingStrategy.IGNORE)
    void toSchool(@MappingTarget School school, SchoolUpdateRequest schoolUpdateRequest);
}
