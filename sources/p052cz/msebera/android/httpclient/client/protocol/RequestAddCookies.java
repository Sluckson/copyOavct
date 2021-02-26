package p052cz.msebera.android.httpclient.client.protocol;

import com.google.firebase.perf.FirebasePerformance;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpRequestInterceptor;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.client.CookieStore;
import p052cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import p052cz.msebera.android.httpclient.config.Lookup;
import p052cz.msebera.android.httpclient.conn.routing.RouteInfo;
import p052cz.msebera.android.httpclient.cookie.Cookie;
import p052cz.msebera.android.httpclient.cookie.CookieOrigin;
import p052cz.msebera.android.httpclient.cookie.CookieSpec;
import p052cz.msebera.android.httpclient.cookie.CookieSpecProvider;
import p052cz.msebera.android.httpclient.cookie.SetCookie2;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.TextUtils;

@Immutable
/* renamed from: cz.msebera.android.httpclient.client.protocol.RequestAddCookies */
public class RequestAddCookies implements HttpRequestInterceptor {
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());

    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        URI uri;
        Header versionHeader;
        Args.notNull(httpRequest, "HTTP request");
        Args.notNull(httpContext, "HTTP context");
        if (!httpRequest.getRequestLine().getMethod().equalsIgnoreCase(FirebasePerformance.HttpMethod.CONNECT)) {
            HttpClientContext adapt = HttpClientContext.adapt(httpContext);
            CookieStore cookieStore = adapt.getCookieStore();
            if (cookieStore == null) {
                this.log.debug("Cookie store not specified in HTTP context");
                return;
            }
            Lookup<CookieSpecProvider> cookieSpecRegistry = adapt.getCookieSpecRegistry();
            if (cookieSpecRegistry == null) {
                this.log.debug("CookieSpec registry not specified in HTTP context");
                return;
            }
            HttpHost targetHost = adapt.getTargetHost();
            if (targetHost == null) {
                this.log.debug("Target host not set in the context");
                return;
            }
            RouteInfo httpRoute = adapt.getHttpRoute();
            if (httpRoute == null) {
                this.log.debug("Connection route not set in the context");
                return;
            }
            String cookieSpec = adapt.getRequestConfig().getCookieSpec();
            if (cookieSpec == null) {
                cookieSpec = "best-match";
            }
            if (this.log.isDebugEnabled()) {
                this.log.debug("CookieSpec selected: " + cookieSpec);
            }
            String str = null;
            if (httpRequest instanceof HttpUriRequest) {
                uri = ((HttpUriRequest) httpRequest).getURI();
            } else {
                try {
                    uri = new URI(httpRequest.getRequestLine().getUri());
                } catch (URISyntaxException unused) {
                    uri = null;
                }
            }
            if (uri != null) {
                str = uri.getPath();
            }
            String hostName = targetHost.getHostName();
            int port = targetHost.getPort();
            if (port < 0) {
                port = httpRoute.getTargetHost().getPort();
            }
            boolean z = false;
            if (port < 0) {
                port = 0;
            }
            if (TextUtils.isEmpty(str)) {
                str = "/";
            }
            CookieOrigin cookieOrigin = new CookieOrigin(hostName, port, str, httpRoute.isSecure());
            CookieSpecProvider lookup = cookieSpecRegistry.lookup(cookieSpec);
            if (lookup != null) {
                CookieSpec create = lookup.create(adapt);
                ArrayList<Cookie> arrayList = new ArrayList<>(cookieStore.getCookies());
                ArrayList<Cookie> arrayList2 = new ArrayList<>();
                Date date = new Date();
                for (Cookie cookie : arrayList) {
                    if (!cookie.isExpired(date)) {
                        if (create.match(cookie, cookieOrigin)) {
                            if (this.log.isDebugEnabled()) {
                                this.log.debug("Cookie " + cookie + " match " + cookieOrigin);
                            }
                            arrayList2.add(cookie);
                        }
                    } else if (this.log.isDebugEnabled()) {
                        this.log.debug("Cookie " + cookie + " expired");
                    }
                }
                if (!arrayList2.isEmpty()) {
                    for (Header addHeader : create.formatCookies(arrayList2)) {
                        httpRequest.addHeader(addHeader);
                    }
                }
                int version = create.getVersion();
                if (version > 0) {
                    for (Cookie cookie2 : arrayList2) {
                        if (version != cookie2.getVersion() || !(cookie2 instanceof SetCookie2)) {
                            z = true;
                        }
                    }
                    if (z && (versionHeader = create.getVersionHeader()) != null) {
                        httpRequest.addHeader(versionHeader);
                    }
                }
                httpContext.setAttribute("http.cookie-spec", create);
                httpContext.setAttribute("http.cookie-origin", cookieOrigin);
                return;
            }
            throw new HttpException("Unsupported cookie policy: " + cookieSpec);
        }
    }
}
