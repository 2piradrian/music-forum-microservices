package com.twopiradrian.forum_crud.domain.error;

import lombok.Getter;

@Getter
public enum ErrorType {

    MISSING_REQUIRED_FIELDS("Missing required fields", 400),
    INVALID_FIELDS("Invalid fields", 400),

    USER_NOT_FOUND("User not found", 404),
    FORUM_NOT_FOUND("Forum not found", 404);

    private final String message;
    private final int httpCode;

    ErrorType(String message, int httpCode) {
        this.message = message;
        this.httpCode = httpCode;
    }
}
