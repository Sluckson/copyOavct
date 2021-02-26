package p052cz.msebera.android.httpclient.impl.auth;

import p052cz.msebera.android.httpclient.annotation.Immutable;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.auth.UnsupportedDigestAlgorithmException */
public class UnsupportedDigestAlgorithmException extends RuntimeException {
    private static final long serialVersionUID = 319558534317118022L;

    public UnsupportedDigestAlgorithmException() {
    }

    public UnsupportedDigestAlgorithmException(String str) {
        super(str);
    }

    public UnsupportedDigestAlgorithmException(String str, Throwable th) {
        super(str, th);
    }
}
