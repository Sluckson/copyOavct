package p052cz.msebera.android.httpclient.impl.cookie;

import java.util.List;
import p052cz.msebera.android.httpclient.FormattedHeader;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HeaderElement;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.cookie.ClientCookie;
import p052cz.msebera.android.httpclient.cookie.Cookie;
import p052cz.msebera.android.httpclient.cookie.CookieOrigin;
import p052cz.msebera.android.httpclient.cookie.CookieSpec;
import p052cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p052cz.msebera.android.httpclient.cookie.SetCookie2;
import p052cz.msebera.android.httpclient.message.ParserCursor;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.CharArrayBuffer;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.cookie.BestMatchSpec */
public class BestMatchSpec implements CookieSpec {
    private BrowserCompatSpec compat;
    private final String[] datepatterns;
    private RFC2109Spec obsoleteStrict;
    private final boolean oneHeader;
    private RFC2965Spec strict;

    public String toString() {
        return "best-match";
    }

    public BestMatchSpec(String[] strArr, boolean z) {
        String[] strArr2;
        if (strArr == null) {
            strArr2 = null;
        } else {
            strArr2 = (String[]) strArr.clone();
        }
        this.datepatterns = strArr2;
        this.oneHeader = z;
    }

    public BestMatchSpec() {
        this((String[]) null, false);
    }

    private RFC2965Spec getStrict() {
        if (this.strict == null) {
            this.strict = new RFC2965Spec(this.datepatterns, this.oneHeader);
        }
        return this.strict;
    }

    private RFC2109Spec getObsoleteStrict() {
        if (this.obsoleteStrict == null) {
            this.obsoleteStrict = new RFC2109Spec(this.datepatterns, this.oneHeader);
        }
        return this.obsoleteStrict;
    }

    private BrowserCompatSpec getCompat() {
        if (this.compat == null) {
            this.compat = new BrowserCompatSpec(this.datepatterns);
        }
        return this.compat;
    }

    public List<Cookie> parse(Header header, CookieOrigin cookieOrigin) throws MalformedCookieException {
        ParserCursor parserCursor;
        CharArrayBuffer charArrayBuffer;
        Args.notNull(header, "Header");
        Args.notNull(cookieOrigin, "Cookie origin");
        HeaderElement[] elements = header.getElements();
        boolean z = false;
        boolean z2 = false;
        for (HeaderElement headerElement : elements) {
            if (headerElement.getParameterByName(ClientCookie.VERSION_ATTR) != null) {
                z2 = true;
            }
            if (headerElement.getParameterByName(ClientCookie.EXPIRES_ATTR) != null) {
                z = true;
            }
        }
        if (z || !z2) {
            NetscapeDraftHeaderParser netscapeDraftHeaderParser = NetscapeDraftHeaderParser.DEFAULT;
            if (header instanceof FormattedHeader) {
                FormattedHeader formattedHeader = (FormattedHeader) header;
                charArrayBuffer = formattedHeader.getBuffer();
                parserCursor = new ParserCursor(formattedHeader.getValuePos(), charArrayBuffer.length());
            } else {
                String value = header.getValue();
                if (value != null) {
                    charArrayBuffer = new CharArrayBuffer(value.length());
                    charArrayBuffer.append(value);
                    parserCursor = new ParserCursor(0, charArrayBuffer.length());
                } else {
                    throw new MalformedCookieException("Header value is null");
                }
            }
            return getCompat().parse(new HeaderElement[]{netscapeDraftHeaderParser.parseHeader(charArrayBuffer, parserCursor)}, cookieOrigin);
        } else if ("Set-Cookie2".equals(header.getName())) {
            return getStrict().parse(elements, cookieOrigin);
        } else {
            return getObsoleteStrict().parse(elements, cookieOrigin);
        }
    }

    public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieOrigin, "Cookie origin");
        if (cookie.getVersion() <= 0) {
            getCompat().validate(cookie, cookieOrigin);
        } else if (cookie instanceof SetCookie2) {
            getStrict().validate(cookie, cookieOrigin);
        } else {
            getObsoleteStrict().validate(cookie, cookieOrigin);
        }
    }

    public boolean match(Cookie cookie, CookieOrigin cookieOrigin) {
        Args.notNull(cookie, "Cookie");
        Args.notNull(cookieOrigin, "Cookie origin");
        if (cookie.getVersion() <= 0) {
            return getCompat().match(cookie, cookieOrigin);
        }
        if (cookie instanceof SetCookie2) {
            return getStrict().match(cookie, cookieOrigin);
        }
        return getObsoleteStrict().match(cookie, cookieOrigin);
    }

    public List<Header> formatCookies(List<Cookie> list) {
        Args.notNull(list, "List of cookies");
        int i = Integer.MAX_VALUE;
        boolean z = true;
        for (Cookie next : list) {
            if (!(next instanceof SetCookie2)) {
                z = false;
            }
            if (next.getVersion() < i) {
                i = next.getVersion();
            }
        }
        if (i <= 0) {
            return getCompat().formatCookies(list);
        }
        if (z) {
            return getStrict().formatCookies(list);
        }
        return getObsoleteStrict().formatCookies(list);
    }

    public int getVersion() {
        return getStrict().getVersion();
    }

    public Header getVersionHeader() {
        return getStrict().getVersionHeader();
    }
}
