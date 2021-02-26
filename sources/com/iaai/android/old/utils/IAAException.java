package com.iaai.android.old.utils;

import com.iaai.android.old.utils.constants.ErrorType;

public class IAAException extends RuntimeException {
    private static final long serialVersionUID = 1;
    public ErrorType errorType;

    public IAAException() {
        this.errorType = ErrorType.GENERAL;
    }

    public IAAException(ErrorType errorType2) {
        this();
        this.errorType = errorType2;
    }

    public IAAException(ErrorType errorType2, String str) {
        this(str);
        this.errorType = errorType2;
    }

    public IAAException(String str, Throwable th) {
        super(str, th);
        this.errorType = ErrorType.GENERAL;
    }

    public IAAException(String str) {
        super(str);
        this.errorType = ErrorType.GENERAL;
    }

    public IAAException(Throwable th) {
        super(th);
        this.errorType = ErrorType.GENERAL;
    }
}
