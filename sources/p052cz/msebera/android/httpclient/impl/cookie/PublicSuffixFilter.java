package p052cz.msebera.android.httpclient.impl.cookie;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import p052cz.msebera.android.httpclient.client.utils.Punycode;
import p052cz.msebera.android.httpclient.cookie.Cookie;
import p052cz.msebera.android.httpclient.cookie.CookieAttributeHandler;
import p052cz.msebera.android.httpclient.cookie.CookieOrigin;
import p052cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p052cz.msebera.android.httpclient.cookie.SetCookie;

/* renamed from: cz.msebera.android.httpclient.impl.cookie.PublicSuffixFilter */
public class PublicSuffixFilter implements CookieAttributeHandler {
    private Set<String> exceptions;
    private Set<String> suffixes;
    private final CookieAttributeHandler wrapped;

    public PublicSuffixFilter(CookieAttributeHandler cookieAttributeHandler) {
        this.wrapped = cookieAttributeHandler;
    }

    public void setPublicSuffixes(Collection<String> collection) {
        this.suffixes = new HashSet(collection);
    }

    public void setExceptions(Collection<String> collection) {
        this.exceptions = new HashSet(collection);
    }

    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        if (isForPublicSuffix(cookie)) {
            return false;
        }
        return this.wrapped.match(cookie, cookieOrigin);
    }

    public void parse(SetCookie setCookie, String str) throws MalformedCookieException {
        this.wrapped.parse(setCookie, str);
    }

    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        this.wrapped.validate(cookie, cookieOrigin);
    }

    private boolean isForPublicSuffix(Cookie cookie) {
        String domain = cookie.getDomain();
        if (domain.startsWith(".")) {
            domain = domain.substring(1);
        }
        String unicode = Punycode.toUnicode(domain);
        Set<String> set = this.exceptions;
        if ((set != null && set.contains(unicode)) || this.suffixes == null) {
            return false;
        }
        while (!this.suffixes.contains(unicode)) {
            if (unicode.startsWith("*.")) {
                unicode = unicode.substring(2);
            }
            int indexOf = unicode.indexOf(46);
            if (indexOf != -1) {
                unicode = "*" + unicode.substring(indexOf);
                if (unicode.length() <= 0) {
                }
            }
            return false;
        }
        return true;
    }
}
