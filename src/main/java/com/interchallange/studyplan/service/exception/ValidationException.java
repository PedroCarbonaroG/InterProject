package com.interchallange.studyplan.service.exception;

public class ValidationException extends RuntimeException {

    private static final String DEFAULT_ERROR_MESSAGE = "Validation Exception, some validation in system was failed";

    public ValidationException() {
        super(DEFAULT_ERROR_MESSAGE);
    }

    public ValidationException(String errorMsg) {
        super(errorMsg);
    }

}
