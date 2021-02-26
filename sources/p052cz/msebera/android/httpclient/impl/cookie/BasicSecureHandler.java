package p052cz.msebera.android.httpclient.impl.cookie;

import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.cookie.Cookie;
import p052cz.msebera.android.httpclient.cookie.CookieOrigin;
import p052cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p052cz.msebera.android.httpclient.cookie.SetCookie;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.cookie.BasicSecureHandler */
public class BasicSecureHandler extends AbstractCookieAttributeHandler {
    public void parse(SetCookie setCookie, String str) throws MalformedCookieException {
        Args.notNull(setCookie, "Cookie");
        setCookie.setSecure(true);
    }

    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieOrigin, "Cookie origin");
        return !cookie.isSecure() || cookieOrigin.isSecure();
    }
}
