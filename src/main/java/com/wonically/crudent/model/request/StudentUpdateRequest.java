package com.wonically.crudent.model.request;

import com.wonically.crudent.util.PhoneNumber;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.UniqueElements;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentUpdateRequest {
    @Pattern(regexp = "^([A-Z][a-z]*\\s)+[A-Z][a-z]*$", message = "INVALID_NAME")
    private String name;

    @Range(min = 18, max = 30, message = "INVALID_AGE")
    private Integer age;

    @Pattern(regexp = "male|female", message = "INVALID_GENDER")
    private String gender;

    @PhoneNumber
    private String phoneNumber;

    private String address;

    @Email(message = "INVALID_EMAIL")
    private String email;

    private Boolean active;
}
