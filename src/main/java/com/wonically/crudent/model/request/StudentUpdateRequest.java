package com.wonically.crudent.model.request;

import com.wonically.crudent.util.PhoneNumber;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Range;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentUpdateRequest {
    @Pattern(regexp = "^([A-Z][a-z]*\\s)+[A-Z][a-z]*$", message = "INVALID_NAME")
    String name;

    @Range(min = 18, max = 30, message = "INVALID_AGE")
    Integer age;

    @Pattern(regexp = "male|female", message = "INVALID_GENDER")
    String gender;

    @PhoneNumber
    String phoneNumber;

    String address;

    @Email(message = "INVALID_EMAIL")
    String email;

    Boolean active;
}
