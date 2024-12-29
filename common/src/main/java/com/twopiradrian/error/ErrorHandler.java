package com.twopiradrian.error;

public class ErrorHandler extends RuntimeException {

    private final int httpCode;

    public ErrorHandler(ErrorType errorType) {
        super(errorType.getMessage());
        this.httpCode = errorType.getHttpCode();
    }

    public ErrorResponse toResponse() {
        return new ErrorResponse(this);
    }

    public int getHttpCode() {
        return this.httpCode;
    }

}
