package com.wonically.crudent.school.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SchoolCreationRequest {
    @NotBlank(message = "INVALID_CODE")
    @Pattern(regexp = "^S[0-9]{2}$", message = "INVALID_CODE")
    String schoolCode;

    @NotBlank(message = "INVALID_NAME")
    @Pattern(regexp = "^([A-Za-z]*\\s)+[A-Za-z]*$", message = "INVALID_NAME")
    String name;

    @NotBlank(message = "INVALID_ADDRESS")
    String address;

    @NotBlank(message = "INVALID_TYPE")
    @Pattern(regexp = "public|private", message = "INVALID_TYPE")
    String type;

    @NotBlank(message = "INVALID_LEVEL")
    @Pattern(regexp = "elementary|primary|secondary|high school|university", message = "INVALID_LEVEL")
    String level;

    @NotBlank(message = "INVALID_WEBSITE")
    @Pattern(regexp = "^(https?://)?(www\\.)?([a-zA-Z0-9]+(-[a-zA-Z0-9]+)*\\.)+[a-zA-Z]{2,}(:[0-9]{1,5})?(/\\S*)?$", message = "INVALID_WEBSITE")
    String website;

    @NotBlank(message = "INVALID_EMAIL")
    @Email(message = "INVALID_EMAIL")
    String email;

    @NotNull(message = "INVALID_ACTIVE")
    Boolean active;
}
