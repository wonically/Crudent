package com.wonically.crudent.student.model.response;

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
public class StudentResponse {
    String code;
    String schoolName;
    String name;
    Integer age;
    String gender;
    String phoneNumber;
    String address;
    String email;
    Boolean active;
    Instant createdAt;
    Instant updatedAt;
}
