package com.wonically.crudent.student.model.request;

import com.wonically.crudent.school.entity.School;
import com.wonically.crudent.util.PhoneNumber;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentUpdateRequest {
    @Pattern(regexp = "^S[0-9]{2}$", message = "INVALID_SCHOOL")
    String schoolCode;

    School school;

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
