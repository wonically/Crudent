package com.wonically.crudent.exception;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error.", HttpStatus.INTERNAL_SERVER_ERROR),
    INVALID_CODE(1001, "Code must be from S001 to S999.", HttpStatus.BAD_REQUEST),
    CODE_EXISTED(1002, "Code has existed.", HttpStatus.BAD_REQUEST),
    INVALID_NAME(1003, "Each word must have its first letter capitalized, separated by one space, and end with a letter.", HttpStatus.BAD_REQUEST),
    INVALID_AGE(1004, "Your age must be from 18 to 30.", HttpStatus.BAD_REQUEST),
    INVALID_GENDER(1005, "Gender must be male or female.", HttpStatus.BAD_REQUEST),
    INVALID_PHONE_NUMBER(1006, "Phone number must be either (xxx) xxx-xxxx or xxx-xxx-xxxx, with optional +xxx country code.", HttpStatus.BAD_REQUEST),
    PHONE_NUMBER_EXISTED(1007, "Phone number has existed.", HttpStatus.BAD_REQUEST),
    INVALID_ADDRESS(1008, "Address must not be blank.", HttpStatus.BAD_REQUEST),
    ADDRESS_EXISTED(1009, "Address has existed.", HttpStatus.BAD_REQUEST),
    INVALID_EMAIL(1010, "Please enter correct email format.", HttpStatus.BAD_REQUEST),
    EMAIL_EXISTED(1011, "Email has existed.", HttpStatus.BAD_REQUEST),
    INVALID_ACTIVE(1012, "Active must be true or false.", HttpStatus.BAD_REQUEST),
    STUDENT_NOT_EXISTED(1013, "Student not existed.", HttpStatus.NOT_FOUND),
    INVALID_SCHOOL(1014, "School code must be from S01 to S99.", HttpStatus.BAD_REQUEST),
    INVALID_TYPE(1015, "Type must be public or private.", HttpStatus.BAD_REQUEST),
    INVALID_LEVEL(1016, "Level must be elementary, primary, secondary, high school, or university.", HttpStatus.BAD_REQUEST),
    INVALID_WEBSITE(1017, "Please enter correct website format.", HttpStatus.BAD_REQUEST),
    WEBSITE_EXISTED(1018, "Website has existed.", HttpStatus.BAD_REQUEST),
    SCHOOL_NOT_EXISTED(1019, "School not existed.", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1020, "Unauthenticated.", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1021, "You do not have permission.", HttpStatus.FORBIDDEN),
    ;

    final Integer code;
    final String message;
    final HttpStatus httpStatus;
}
