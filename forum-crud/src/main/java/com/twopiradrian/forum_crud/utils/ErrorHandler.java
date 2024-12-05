package com.twopiradrian.forum_crud.utils;

import lombok.Getter;

@Getter
public class ErrorHandler extends RuntimeException {

    private final int httpCode;

    public ErrorHandler(ErrorType errorType) {
        super(errorType.getMessage());
        this.httpCode = errorType.getHttpCode();
    }

}
