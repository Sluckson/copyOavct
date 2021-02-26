package p052cz.msebera.android.httpclient.client.protocol;

import java.io.IOException;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HeaderIterator;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.HttpResponseInterceptor;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.client.CookieStore;
import p052cz.msebera.android.httpclient.cookie.Cookie;
import p052cz.msebera.android.httpclient.cookie.CookieOrigin;
import p052cz.msebera.android.httpclient.cookie.CookieSpec;
import p052cz.msebera.android.httpclient.cookie.MalformedCookieException;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
/* renamed from: cz.msebera.android.httpclient.client.protocol.ResponseProcessCookies */
public class ResponseProcessCookies implements HttpResponseInterceptor {
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());

    public void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpResponse, "HTTP request");
        Args.notNull(httpContext, "HTTP context");
        HttpClientContext adapt = HttpClientContext.adapt(httpContext);
        CookieSpec cookieSpec = adapt.getCookieSpec();
        if (cookieSpec == null) {
            this.log.debug("Cookie spec not specified in HTTP context");
            return;
        }
        CookieStore cookieStore = adapt.getCookieStore();
        if (cookieStore == null) {
            this.log.debug("Cookie store not specified in HTTP context");
            return;
        }
        CookieOrigin cookieOrigin = adapt.getCookieOrigin();
        if (cookieOrigin == null) {
            this.log.debug("Cookie origin not specified in HTTP context");
            return;
        }
        processCookies(httpResponse.headerIterator("Set-Cookie"), cookieSpec, cookieOrigin, cookieStore);
        if (cookieSpec.getVersion() > 0) {
            processCookies(httpResponse.headerIterator("Set-Cookie2"), cookieSpec, cookieOrigin, cookieStore);
        }
    }

    private void processCookies(HeaderIterator headerIterator, CookieSpec cookieSpec, CookieOrigin cookieOrigin, CookieStore cookieStore) {
        while (headerIterator.hasNext()) {
            Header nextHeader = headerIterator.nextHeader();
            try {
                for (Cookie next : cookieSpec.parse(nextHeader, cookieOrigin)) {
                    try {
                        cookieSpec.validate(next, cookieOrigin);
                        cookieStore.addCookie(next);
                        if (this.log.isDebugEnabled()) {
                            HttpClientAndroidLog httpClientAndroidLog = this.log;
                            httpClientAndroidLog.debug("Cookie accepted [" + formatCooke(next) + "]");
                        }
                    } catch (MalformedCookieException e) {
                        if (this.log.isWarnEnabled()) {
                            HttpClientAndroidLog httpClientAndroidLog2 = this.log;
                            httpClientAndroidLog2.warn("Cookie rejected [" + formatCooke(next) + "] " + e.getMessage());
                        }
                    }
                }
            } catch (MalformedCookieException e2) {
                if (this.log.isWarnEnabled()) {
                    HttpClientAndroidLog httpClientAndroidLog3 = this.log;
                    httpClientAndroidLog3.warn("Invalid cookie header: \"" + nextHeader + "\". " + e2.getMessage());
                }
            }
        }
    }

    private static String formatCooke(Cookie cookie) {
        StringBuilder sb = new StringBuilder();
        sb.append(cookie.getName());
        sb.append("=\"");
        String value = cookie.getValue();
        if (value != null) {
            if (value.length() > 100) {
                value = value.substring(0, 100) + "...";
            }
            sb.append(value);
        }
        sb.append("\"");
        sb.append(", version:");
        sb.append(Integer.toString(cookie.getVersion()));
        sb.append(", domain:");
        sb.append(cookie.getDomain());
        sb.append(", path:");
        sb.append(cookie.getPath());
        sb.append(", expiry:");
        sb.append(cookie.getExpiryDate());
        return sb.toString();
    }
}
