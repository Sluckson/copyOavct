package com.medallia.digital.mobilesdk;

public abstract class MedalliaDigitalError {
    private int errorCode;
    private String message;

    protected MedalliaDigitalError(int i, String str) {
        this.errorCode = i;
        this.message = str;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getMessage() {
        return "(" + this.errorCode + ") " + this.message;
    }
}
