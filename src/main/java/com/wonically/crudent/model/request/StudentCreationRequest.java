package com.wonically.crudent.model.request;

import com.wonically.crudent.util.PhoneNumber;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

@Builder
@Data
public class StudentCreationRequest {
    @NotBlank(message = "INVALID_CODE")
    @Pattern(regexp = "^S[0-9]{3}$", message = "INVALID_CODE")
    private String code;

    @NotBlank(message = "INVALID_NAME")
    @Pattern(regexp = "^([A-Z][a-z]*\\s)+[A-Z][a-z]*$", message = "INVALID_NAME")
    private String name;

    @NotNull(message = "INVALID_AGE")
    @Range(min = 18, max = 30, message = "INVALID_AGE")
    private Integer age;

    @NotBlank(message = "INVALID_GENDER")
    @Pattern(regexp = "male|female", message = "INVALID_GENDER")
    private String gender;

    @NotBlank(message = "INVALID_PHONE_NUMBER")
    @PhoneNumber
    private String phoneNumber;

    @NotBlank(message = "INVALID_ADDRESS")
    private String address;

    @NotBlank(message = "INVALID_EMAIL")
    @Email(message = "INVALID_EMAIL")
    private String email;

    @NotNull(message = "INVALID_ACTIVE")
    private Boolean active;
}
