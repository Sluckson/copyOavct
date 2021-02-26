package com.google.inject;

public final class OutOfScopeException extends RuntimeException {
    public OutOfScopeException(String str) {
        super(str);
    }

    public OutOfScopeException(String str, Throwable th) {
        super(str, th);
    }

    public OutOfScopeException(Throwable th) {
        super(th);
    }
}
