package com.twopiradrian.auth_server.domain.error;

public class ErrorResponse {

    public String message;

    public ErrorResponse(ErrorHandler errorHandler) {
        this.message = errorHandler.getMessage();
    }
}
