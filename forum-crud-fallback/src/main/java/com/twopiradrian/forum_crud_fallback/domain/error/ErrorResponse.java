package com.twopiradrian.forum_crud_fallback.domain.error;

public class ErrorResponse {

    public String message;

    public ErrorResponse(ErrorHandler errorHandler) {
        this.message = errorHandler.getMessage();
    }
}
