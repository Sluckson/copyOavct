package p052cz.msebera.android.httpclient.cookie;

import p052cz.msebera.android.httpclient.annotation.Immutable;

@Immutable
/* renamed from: cz.msebera.android.httpclient.cookie.CookieRestrictionViolationException */
public class CookieRestrictionViolationException extends MalformedCookieException {
    private static final long serialVersionUID = 7371235577078589013L;

    public CookieRestrictionViolationException() {
    }

    public CookieRestrictionViolationException(String str) {
        super(str);
    }
}
