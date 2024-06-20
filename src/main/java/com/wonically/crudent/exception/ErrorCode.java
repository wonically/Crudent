package com.wonically.crudent.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION(9999, "Uncategorized error.", HttpStatus.INTERNAL_SERVER_ERROR),
    CODE_EXISTED(1001, "Code has existed.", HttpStatus.BAD_REQUEST),
    INVALID_CODE(1002, "Code must be from S001 to S999.", HttpStatus.BAD_REQUEST),
    INVALID_NAME(1003, "Each word must have its first letter capitalized, separated by one space, and end with a letter.", HttpStatus.BAD_REQUEST),
    INVALID_AGE(1004, "Your age must be from 18 to 30.", HttpStatus.BAD_REQUEST),
    INVALID_GENDER(1005, "Gender must be male or female.", HttpStatus.BAD_REQUEST),
    INVALID_PHONE_NUMBER(1006, "Phone number must be either (xxx) xxx-xxxx or xxx-xxx-xxxx, with optional +xxx country code.", HttpStatus.BAD_REQUEST),
    PHONE_NUMBER_EXISTED(1007, "Phone number has existed.", HttpStatus.BAD_REQUEST),
    INVALID_ADDRESS(1008, "Address must not be blank.", HttpStatus.BAD_REQUEST),
    INVALID_EMAIL(1009, "Please enter correct email format.", HttpStatus.BAD_REQUEST),
    EMAIL_EXISTED(1010, "Email has existed.", HttpStatus.BAD_REQUEST),
    INVALID_ACTIVE(1011, "Active must be true or false.", HttpStatus.BAD_REQUEST),
    STUDENT_NOT_EXISTED(1012, "Student not existed.", HttpStatus.NOT_FOUND),
    UNAUTHENTICATED(1013, "Unauthenticated.", HttpStatus.UNAUTHORIZED),
    UNAUTHORIZED(1014, "You do not have permission.", HttpStatus.FORBIDDEN),
    ;

    Integer code;
    String message;
    HttpStatus httpStatus;
}
