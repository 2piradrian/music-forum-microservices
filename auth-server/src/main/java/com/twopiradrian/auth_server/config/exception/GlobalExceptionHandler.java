package com.twopiradrian.auth_server.config.exception;

import com.twopiradrian.auth_server.domain.error.ErrorHandler;
import com.twopiradrian.auth_server.domain.error.ErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ErrorHandler.class)
    public ResponseEntity<?> handleErrorHandler(ErrorHandler e) {
        return ResponseEntity.status(e.getHttpCode()).body(e.toResponse());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ErrorType.INTERNAL_ERROR.getMessage());
    }

}
