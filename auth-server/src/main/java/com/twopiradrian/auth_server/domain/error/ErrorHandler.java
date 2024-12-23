package com.twopiradrian.auth_server.domain.error;

import lombok.Getter;

@Getter
public class ErrorHandler extends RuntimeException {

    private final int httpCode;

    public ErrorHandler(ErrorType errorType) {
        super(errorType.getMessage());
        this.httpCode = errorType.getHttpCode();
    }

    public ErrorResponse toResponse() {
        return new ErrorResponse(this);
    }

}
