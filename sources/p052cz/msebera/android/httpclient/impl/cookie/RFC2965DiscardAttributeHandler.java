package p052cz.msebera.android.httpclient.impl.cookie;

import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.cookie.Cookie;
import p052cz.msebera.android.httpclient.cookie.CookieAttributeHandler;
import p052cz.msebera.android.httpclient.cookie.CookieOrigin;
import p052cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p052cz.msebera.android.httpclient.cookie.SetCookie;
import p052cz.msebera.android.httpclient.cookie.SetCookie2;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.cookie.RFC2965DiscardAttributeHandler */
public class RFC2965DiscardAttributeHandler implements CookieAttributeHandler {
    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        return true;
    }

    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
    }

    public void parse(SetCookie setCookie, String str) throws MalformedCookieException {
        if (setCookie instanceof SetCookie2) {
            ((SetCookie2) setCookie).setDiscard(true);
        }
    }
}
