package com.wonically.crudent.model.response;

import lombok.*;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentResponse {
    String code;
    String name;
    Integer age;
    String gender;
    String phoneNumber;
    String address;
    String email;
    Boolean active;
}
