package p052cz.msebera.android.httpclient.impl.cookie;

import java.util.Locale;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.cookie.ClientCookie;
import p052cz.msebera.android.httpclient.cookie.Cookie;
import p052cz.msebera.android.httpclient.cookie.CookieAttributeHandler;
import p052cz.msebera.android.httpclient.cookie.CookieOrigin;
import p052cz.msebera.android.httpclient.cookie.CookieRestrictionViolationException;
import p052cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p052cz.msebera.android.httpclient.cookie.SetCookie;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.cookie.RFC2965DomainAttributeHandler */
public class RFC2965DomainAttributeHandler implements CookieAttributeHandler {
    public void parse(SetCookie setCookie, String str) throws MalformedCookieException {
        Args.notNull(setCookie, "Cookie");
        if (str == null) {
            throw new MalformedCookieException("Missing value for domain attribute");
        } else if (str.trim().length() != 0) {
            String lowerCase = str.toLowerCase(Locale.ENGLISH);
            if (!str.startsWith(".")) {
                lowerCase = '.' + lowerCase;
            }
            setCookie.setDomain(lowerCase);
        } else {
            throw new MalformedCookieException("Blank value for domain attribute");
        }
    }

    public boolean domainMatch(String str, String str2) {
        return str.equals(str2) || (str2.startsWith(".") && str.endsWith(str2));
    }

    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieOrigin, "Cookie origin");
        String lowerCase = cookieOrigin.getHost().toLowerCase(Locale.ENGLISH);
        if (cookie.getDomain() != null) {
            String lowerCase2 = cookie.getDomain().toLowerCase(Locale.ENGLISH);
            if (!(cookie instanceof ClientCookie) || !((ClientCookie) cookie).containsAttribute(ClientCookie.DOMAIN_ATTR)) {
                if (!cookie.getDomain().equals(lowerCase)) {
                    throw new CookieRestrictionViolationException("Illegal domain attribute: \"" + cookie.getDomain() + "\"." + "Domain of origin: \"" + lowerCase + "\"");
                }
            } else if (lowerCase2.startsWith(".")) {
                int indexOf = lowerCase2.indexOf(46, 1);
                if ((indexOf < 0 || indexOf == lowerCase2.length() - 1) && !lowerCase2.equals(".local")) {
                    throw new CookieRestrictionViolationException("Domain attribute \"" + cookie.getDomain() + "\" violates RFC 2965: the value contains no embedded dots " + "and the value is not .local");
                } else if (!domainMatch(lowerCase, lowerCase2)) {
                    throw new CookieRestrictionViolationException("Domain attribute \"" + cookie.getDomain() + "\" violates RFC 2965: effective host name does not " + "domain-match domain attribute.");
                } else if (lowerCase.substring(0, lowerCase.length() - lowerCase2.length()).indexOf(46) != -1) {
                    throw new CookieRestrictionViolationException("Domain attribute \"" + cookie.getDomain() + "\" violates RFC 2965: " + "effective host minus domain may not contain any dots");
                }
            } else {
                throw new CookieRestrictionViolationException("Domain attribute \"" + cookie.getDomain() + "\" violates RFC 2109: domain must start with a dot");
            }
        } else {
            throw new CookieRestrictionViolationException("Invalid cookie state: domain not specified");
        }
    }

    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieOrigin, "Cookie origin");
        String lowerCase = cookieOrigin.getHost().toLowerCase(Locale.ENGLISH);
        String domain = cookie.getDomain();
        if (domainMatch(lowerCase, domain) && lowerCase.substring(0, lowerCase.length() - domain.length()).indexOf(46) == -1) {
            return true;
        }
        return false;
    }
}
