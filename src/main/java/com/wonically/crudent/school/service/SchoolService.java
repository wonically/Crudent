package com.wonically.crudent.school.service;

import com.wonically.crudent.school.model.request.SchoolCreationRequest;
import com.wonically.crudent.school.model.request.SchoolUpdateRequest;
import com.wonically.crudent.school.model.response.SchoolResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface SchoolService {
    SchoolResponse createSchool(SchoolCreationRequest schoolCreationRequest);

    List<SchoolResponse> createSchools(List<SchoolCreationRequest> schoolCreationRequests);

//    Page<SchoolResponse> getSchools(int pageNo);

    List<SchoolResponse> getSchools();

    SchoolResponse getSchool(String code);

    SchoolResponse updateSchool(String code, SchoolUpdateRequest schoolUpdateRequest);
}
