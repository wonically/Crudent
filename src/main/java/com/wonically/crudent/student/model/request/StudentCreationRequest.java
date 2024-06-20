package com.wonically.crudent.student.model.request;

import com.wonically.crudent.school.entity.School;
import com.wonically.crudent.util.PhoneNumber;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class StudentCreationRequest {
    @NotBlank(message = "INVALID_CODE")
    @Pattern(regexp = "^S[0-9]{3}$", message = "INVALID_CODE")
    String code;

    @NotBlank(message = "INVALID_SCHOOL")
    @Pattern(regexp = "^S[0-9]{2}$", message = "INVALID_SCHOOL")
    String schoolCode;

    School school;

    @NotBlank(message = "INVALID_NAME")
    @Pattern(regexp = "^([A-Z][a-z]*\\s)+[A-Z][a-z]*$", message = "INVALID_NAME")
    String name;

    @NotNull(message = "INVALID_AGE")
    @Range(min = 18, max = 30, message = "INVALID_AGE")
    Integer age;

    @NotBlank(message = "INVALID_GENDER")
    @Pattern(regexp = "male|female", message = "INVALID_GENDER")
    String gender;

    @NotBlank(message = "INVALID_PHONE_NUMBER")
    @PhoneNumber
    String phoneNumber;

    @NotBlank(message = "INVALID_ADDRESS")
    String address;

    @NotBlank(message = "INVALID_EMAIL")
    @Email(message = "INVALID_EMAIL")
    String email;

    @NotNull(message = "INVALID_ACTIVE")
    Boolean active;
}
