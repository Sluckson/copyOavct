package p052cz.msebera.android.httpclient.impl.cookie;

import java.util.StringTokenizer;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.cookie.ClientCookie;
import p052cz.msebera.android.httpclient.cookie.Cookie;
import p052cz.msebera.android.httpclient.cookie.CookieAttributeHandler;
import p052cz.msebera.android.httpclient.cookie.CookieOrigin;
import p052cz.msebera.android.httpclient.cookie.CookieRestrictionViolationException;
import p052cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p052cz.msebera.android.httpclient.cookie.SetCookie;
import p052cz.msebera.android.httpclient.cookie.SetCookie2;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.cookie.RFC2965PortAttributeHandler */
public class RFC2965PortAttributeHandler implements CookieAttributeHandler {
    private static int[] parsePortAttribute(String str) throws MalformedCookieException {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            try {
                iArr[i] = Integer.parseInt(stringTokenizer.nextToken().trim());
                if (iArr[i] >= 0) {
                    i++;
                } else {
                    throw new MalformedCookieException("Invalid Port attribute.");
                }
            } catch (NumberFormatException e) {
                throw new MalformedCookieException("Invalid Port attribute: " + e.getMessage());
            }
        }
        return iArr;
    }

    private static boolean portMatch(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    public void parse(SetCookie setCookie, String str) throws MalformedCookieException {
        Args.notNull(setCookie, "Cookie");
        if (setCookie instanceof SetCookie2) {
            SetCookie2 setCookie2 = (SetCookie2) setCookie;
            if (str != null && str.trim().length() > 0) {
                setCookie2.setPorts(parsePortAttribute(str));
            }
        }
    }

    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieOrigin, "Cookie origin");
        int port = cookieOrigin.getPort();
        if ((cookie instanceof ClientCookie) && ((ClientCookie) cookie).containsAttribute(ClientCookie.PORT_ATTR) && !portMatch(port, cookie.getPorts())) {
            throw new CookieRestrictionViolationException("Port attribute violates RFC 2965: Request port not found in cookie's port list.");
        }
    }

    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieOrigin, "Cookie origin");
        int port = cookieOrigin.getPort();
        if (!(cookie instanceof ClientCookie) || !((ClientCookie) cookie).containsAttribute(ClientCookie.PORT_ATTR)) {
            return true;
        }
        if (cookie.getPorts() != null && portMatch(port, cookie.getPorts())) {
            return true;
        }
        return false;
    }
}
