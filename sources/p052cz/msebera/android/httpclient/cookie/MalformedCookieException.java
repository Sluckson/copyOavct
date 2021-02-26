package p052cz.msebera.android.httpclient.cookie;

import p052cz.msebera.android.httpclient.ProtocolException;
import p052cz.msebera.android.httpclient.annotation.Immutable;

@Immutable
/* renamed from: cz.msebera.android.httpclient.cookie.MalformedCookieException */
public class MalformedCookieException extends ProtocolException {
    private static final long serialVersionUID = -6695462944287282185L;

    public MalformedCookieException() {
    }

    public MalformedCookieException(String str) {
        super(str);
    }

    public MalformedCookieException(String str, Throwable th) {
        super(str, th);
    }
}
