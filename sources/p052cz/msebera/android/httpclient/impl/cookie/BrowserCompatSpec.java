package p052cz.msebera.android.httpclient.impl.cookie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import p052cz.msebera.android.httpclient.FormattedHeader;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HeaderElement;
import p052cz.msebera.android.httpclient.NameValuePair;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.cookie.ClientCookie;
import p052cz.msebera.android.httpclient.cookie.Cookie;
import p052cz.msebera.android.httpclient.cookie.CookieAttributeHandler;
import p052cz.msebera.android.httpclient.cookie.CookieOrigin;
import p052cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p052cz.msebera.android.httpclient.impl.cookie.BrowserCompatSpecFactory;
import p052cz.msebera.android.httpclient.message.BasicHeaderElement;
import p052cz.msebera.android.httpclient.message.BasicHeaderValueFormatter;
import p052cz.msebera.android.httpclient.message.BufferedHeader;
import p052cz.msebera.android.httpclient.message.ParserCursor;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.CharArrayBuffer;
import p052cz.msebera.android.httpclient.util.TextUtils;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.cookie.BrowserCompatSpec */
public class BrowserCompatSpec extends CookieSpecBase {
    private static final String[] DEFAULT_DATE_PATTERNS = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z"};
    private final String[] datepatterns;

    public int getVersion() {
        return 0;
    }

    public Header getVersionHeader() {
        return null;
    }

    public String toString() {
        return "compatibility";
    }

    public BrowserCompatSpec(String[] strArr, BrowserCompatSpecFactory.SecurityLevel securityLevel) {
        if (strArr != null) {
            this.datepatterns = (String[]) strArr.clone();
        } else {
            this.datepatterns = DEFAULT_DATE_PATTERNS;
        }
        int i = C43652.f4892xa779815d[securityLevel.ordinal()];
        if (i == 1) {
            registerAttribHandler(ClientCookie.PATH_ATTR, new BasicPathHandler());
        } else if (i == 2) {
            registerAttribHandler(ClientCookie.PATH_ATTR, new BasicPathHandler() {
                public void validate(Cookie cookie, CookieOrigin cookieOrigin) throws MalformedCookieException {
                }
            });
        } else {
            throw new RuntimeException("Unknown security level");
        }
        registerAttribHandler(ClientCookie.DOMAIN_ATTR, new BasicDomainHandler());
        registerAttribHandler("max-age", new BasicMaxAgeHandler());
        registerAttribHandler(ClientCookie.SECURE_ATTR, new BasicSecureHandler());
        registerAttribHandler(ClientCookie.COMMENT_ATTR, new BasicCommentHandler());
        registerAttribHandler(ClientCookie.EXPIRES_ATTR, new BasicExpiresHandler(this.datepatterns));
        registerAttribHandler(ClientCookie.VERSION_ATTR, new BrowserCompatVersionAttributeHandler());
    }

    /* renamed from: cz.msebera.android.httpclient.impl.cookie.BrowserCompatSpec$2 */
    static /* synthetic */ class C43652 {

        /* renamed from: $SwitchMap$cz$msebera$android$httpclient$impl$cookie$BrowserCompatSpecFactory$SecurityLevel */
        static final /* synthetic */ int[] f4892xa779815d = new int[BrowserCompatSpecFactory.SecurityLevel.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            /*
                cz.msebera.android.httpclient.impl.cookie.BrowserCompatSpecFactory$SecurityLevel[] r0 = p052cz.msebera.android.httpclient.impl.cookie.BrowserCompatSpecFactory.SecurityLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4892xa779815d = r0
                int[] r0 = f4892xa779815d     // Catch:{ NoSuchFieldError -> 0x0014 }
                cz.msebera.android.httpclient.impl.cookie.BrowserCompatSpecFactory$SecurityLevel r1 = p052cz.msebera.android.httpclient.impl.cookie.BrowserCompatSpecFactory.SecurityLevel.SECURITYLEVEL_DEFAULT     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f4892xa779815d     // Catch:{ NoSuchFieldError -> 0x001f }
                cz.msebera.android.httpclient.impl.cookie.BrowserCompatSpecFactory$SecurityLevel r1 = p052cz.msebera.android.httpclient.impl.cookie.BrowserCompatSpecFactory.SecurityLevel.SECURITYLEVEL_IE_MEDIUM     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p052cz.msebera.android.httpclient.impl.cookie.BrowserCompatSpec.C43652.<clinit>():void");
        }
    }

    public BrowserCompatSpec(String[] strArr) {
        this(strArr, BrowserCompatSpecFactory.SecurityLevel.SECURITYLEVEL_DEFAULT);
    }

    public BrowserCompatSpec() {
        this((String[]) null, BrowserCompatSpecFactory.SecurityLevel.SECURITYLEVEL_DEFAULT);
    }

    public List<Cookie> parse(Header header, CookieOrigin cookieOrigin) throws MalformedCookieException {
        ParserCursor parserCursor;
        CharArrayBuffer charArrayBuffer;
        Args.notNull(header, "Header");
        Args.notNull(cookieOrigin, "Cookie origin");
        if (header.getName().equalsIgnoreCase("Set-Cookie")) {
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
            if (!z && z2) {
                return parse(elements, cookieOrigin);
            }
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
            HeaderElement parseHeader = netscapeDraftHeaderParser.parseHeader(charArrayBuffer, parserCursor);
            String name = parseHeader.getName();
            String value2 = parseHeader.getValue();
            if (name == null || TextUtils.isBlank(name)) {
                throw new MalformedCookieException("Cookie name may not be empty");
            }
            BasicClientCookie basicClientCookie = new BasicClientCookie(name, value2);
            basicClientCookie.setPath(getDefaultPath(cookieOrigin));
            basicClientCookie.setDomain(getDefaultDomain(cookieOrigin));
            NameValuePair[] parameters = parseHeader.getParameters();
            for (int length = parameters.length - 1; length >= 0; length--) {
                NameValuePair nameValuePair = parameters[length];
                String lowerCase = nameValuePair.getName().toLowerCase(Locale.ENGLISH);
                basicClientCookie.setAttribute(lowerCase, nameValuePair.getValue());
                CookieAttributeHandler findAttribHandler = findAttribHandler(lowerCase);
                if (findAttribHandler != null) {
                    findAttribHandler.parse(basicClientCookie, nameValuePair.getValue());
                }
            }
            if (z) {
                basicClientCookie.setVersion(0);
            }
            return Collections.singletonList(basicClientCookie);
        }
        throw new MalformedCookieException("Unrecognized cookie header '" + header.toString() + "'");
    }

    private static boolean isQuoteEnclosed(String str) {
        return str != null && str.startsWith("\"") && str.endsWith("\"");
    }

    public List<Header> formatCookies(List<Cookie> list) {
        Args.notEmpty(list, "List of cookies");
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(list.size() * 20);
        charArrayBuffer.append("Cookie");
        charArrayBuffer.append(": ");
        for (int i = 0; i < list.size(); i++) {
            Cookie cookie = list.get(i);
            if (i > 0) {
                charArrayBuffer.append("; ");
            }
            String name = cookie.getName();
            String value = cookie.getValue();
            if (cookie.getVersion() <= 0 || isQuoteEnclosed(value)) {
                charArrayBuffer.append(name);
                charArrayBuffer.append("=");
                if (value != null) {
                    charArrayBuffer.append(value);
                }
            } else {
                BasicHeaderValueFormatter.INSTANCE.formatHeaderElement(charArrayBuffer, (HeaderElement) new BasicHeaderElement(name, value), false);
            }
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new BufferedHeader(charArrayBuffer));
        return arrayList;
    }
}
