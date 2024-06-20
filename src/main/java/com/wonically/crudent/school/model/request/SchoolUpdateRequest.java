package com.wonically.crudent.school.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SchoolUpdateRequest {
    @Pattern(regexp = "^([A-Za-z]*\\s)+[A-Za-z]*$", message = "INVALID_NAME")
    String name;

    String address;

    @Pattern(regexp = "public|private", message = "INVALID_TYPE")
    String type;

    @Pattern(regexp = "elementary|primary|secondary|high school|university", message = "INVALID_LEVEL")
    String level;

    @Pattern(regexp = "^(https?://)?(www\\.)?([a-zA-Z0-9]+(-[a-zA-Z0-9]+)*\\.)+[a-zA-Z]{2,}(:[0-9]{1,5})?(/\\S*)?$", message = "INVALID_WEBSITE")
    String website;

    @Email(message = "INVALID_EMAIL")
    String email;

    Boolean active;
}
