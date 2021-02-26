package p052cz.msebera.android.httpclient.impl.cookie;

import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p052cz.msebera.android.httpclient.cookie.SetCookie;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.cookie.BrowserCompatVersionAttributeHandler */
public class BrowserCompatVersionAttributeHandler extends AbstractCookieAttributeHandler {
    public void parse(SetCookie setCookie, String str) throws MalformedCookieException {
        Args.notNull(setCookie, "Cookie");
        if (str != null) {
            int i = 0;
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
            }
            setCookie.setVersion(i);
            return;
        }
        throw new MalformedCookieException("Missing value for version attribute");
    }
}
