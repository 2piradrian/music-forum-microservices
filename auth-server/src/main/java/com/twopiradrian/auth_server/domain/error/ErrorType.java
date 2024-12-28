package com.twopiradrian.auth_server.domain.error;

import lombok.Getter;

@Getter
public enum ErrorType {

    MISSING_REQUIRED_FIELDS("Missing required fields", 400),
    INVALID_FIELDS("Invalid fields", 400),

    USER_NOT_FOUND("User not found", 404),
    USERNAME_ALREADY_EXISTS("Username already exists", 409),
    EMAIL_ALREADY_EXISTS("Email already exists", 409),

    INVALID_PASSWORD("Invalid password", 401),
    UNAUTHORIZED("Unauthorized", 401),

    INTERNAL_ERROR("Internal error", 500);

    private final String message;
    private final int httpCode;

    ErrorType(String message, int httpCode) {
        this.message = message;
        this.httpCode = httpCode;
    }

}
