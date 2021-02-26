package com.google.inject.internal;

public class ErrorsException extends Exception {
    private final Errors errors;

    public ErrorsException(Errors errors2) {
        this.errors = errors2;
    }

    public Errors getErrors() {
        return this.errors;
    }
}
