package repack.org.bouncycastle.jce.provider;

import repack.org.bouncycastle.jce.exception.ExtException;

public class AnnotatedException extends Exception implements ExtException {
    private Throwable _underlyingException;

    AnnotatedException(String str, Throwable th) {
        super(str);
        this._underlyingException = th;
    }

    AnnotatedException(String str) {
        this(str, (Throwable) null);
    }

    /* access modifiers changed from: package-private */
    public Throwable getUnderlyingException() {
        return this._underlyingException;
    }

    public Throwable getCause() {
        return this._underlyingException;
    }
}
