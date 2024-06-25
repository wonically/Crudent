package com.wonically.crudent.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ResponseStatus
public class ApiResponse <T> {
    @Builder.Default
    Integer code = 1000;

    @Builder.Default
    String message = "Success";
    T result;
}
