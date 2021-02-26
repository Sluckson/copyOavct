package p052cz.msebera.android.httpclient.impl.cookie;

import java.util.Collections;
import java.util.List;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.cookie.Cookie;
import p052cz.msebera.android.httpclient.cookie.CookieOrigin;
import p052cz.msebera.android.httpclient.cookie.MalformedCookieException;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.cookie.IgnoreSpec */
public class IgnoreSpec extends CookieSpecBase {
    public int getVersion() {
        return 0;
    }

    public Header getVersionHeader() {
        return null;
    }

    public List<Cookie> parse(Header header, CookieOrigin cookieOrigin) throws MalformedCookieException {
        return Collections.emptyList();
    }

    public List<Header> formatCookies(List<Cookie> list) {
        return Collections.emptyList();
    }
}
