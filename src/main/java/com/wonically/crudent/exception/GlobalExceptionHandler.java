package com.wonically.crudent.exception;

import com.wonically.crudent.model.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    ApiResponse handlingRuntimeException(RuntimeException exception) {
        log.error("Exception: ", exception);
        return ApiResponse.builder()
                .code(ErrorCode.UNCATEGORIZED_EXCEPTION.getCode())
                .message(ErrorCode.UNCATEGORIZED_EXCEPTION.getMessage())
                .build();
    }

    @ExceptionHandler(value = AppException.class)
    ApiResponse handlingRuntimeException(AppException exception) {
        ErrorCode errorCode = exception.getErrorCode();

        return ApiResponse.builder()
                .code(errorCode.getCode())
                .message(exception.getMessage())
                .build();
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    ApiResponse handlingValidation(MethodArgumentNotValidException exception) {
        String enumKey = exception.getFieldError().getDefaultMessage();

        ErrorCode errorCode;
        try {
            errorCode = ErrorCode.valueOf(enumKey);
        } catch (IllegalArgumentException e) {
            errorCode = ErrorCode.UNCATEGORIZED_EXCEPTION;
        }

        return ApiResponse.builder()
                .code(errorCode.getCode())
                .message(errorCode.getMessage())
                .build();
    }
}
