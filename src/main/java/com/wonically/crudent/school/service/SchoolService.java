package com.wonically.crudent.school.service;

import com.wonically.crudent.school.entity.School;
import com.wonically.crudent.school.model.request.SchoolCreationRequest;
import com.wonically.crudent.school.model.request.SchoolUpdateRequest;

import java.util.List;

public interface SchoolService {
    School createSchool(SchoolCreationRequest schoolCreationRequest);

    List<School> getSchools();

    School getSchool(String code);

    School updateSchool(String code, SchoolUpdateRequest schoolUpdateRequest);
}
