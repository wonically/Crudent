package com.wonically.crudent.model.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse <T> {
    @Builder.Default
    private Integer code = 1000;

    @Builder.Default
    private String message = "Success";
    private T result;
}
