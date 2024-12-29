package com.twopiradrian.error;

public enum ErrorType {

    MISSING_REQUIRED_FIELDS("Missing required fields", 400),
    INVALID_FIELDS("Invalid fields", 400),

    USER_NOT_FOUND("User not found", 404),
    FORUM_NOT_FOUND("Forum not found", 404),

    UNAUTHORIZED("Unauthorized", 401),

    FORUM_NOT_ACTIVE("Forum not active", 400),
    COMMENT_NOT_FOUND("Comment not found", 404),

    INTERNAL_ERROR("Internal error", 500);

    private final String message;
    private final int httpCode;

    ErrorType(String message, int httpCode) {
        this.message = message;
        this.httpCode = httpCode;
    }

    public String getMessage() {
        return this.message;
    }

    public int getHttpCode() {
        return this.httpCode;
    }

}