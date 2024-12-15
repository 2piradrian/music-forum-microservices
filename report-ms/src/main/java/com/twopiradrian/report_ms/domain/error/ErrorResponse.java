package com.twopiradrian.report_ms.domain.error;

public class ErrorResponse {

    public String message;

    public ErrorResponse(ErrorHandler errorHandler) {
        this.message = errorHandler.getMessage();
    }
}
