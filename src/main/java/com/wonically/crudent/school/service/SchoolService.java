package com.wonically.crudent.school.service;

import com.wonically.crudent.school.model.request.SchoolCreationRequest;
import com.wonically.crudent.school.model.request.SchoolUpdateRequest;
import com.wonically.crudent.school.model.response.SchoolResponse;
import org.springframework.data.domain.Page;

public interface SchoolService {
    SchoolResponse createSchool(SchoolCreationRequest schoolCreationRequest);

    Page<SchoolResponse> getSchools(int pageNo);

    SchoolResponse getSchool(String code);

    SchoolResponse updateSchool(String code, SchoolUpdateRequest schoolUpdateRequest);
}
