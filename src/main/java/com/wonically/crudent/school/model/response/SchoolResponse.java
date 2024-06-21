package com.wonically.crudent.school.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SchoolResponse {
    String code;
    String name;
    String address;
    String type;
    String level;
    String website;
    String email;
    Boolean active;
    Instant createdAt;
    Instant updatedAt;
}
