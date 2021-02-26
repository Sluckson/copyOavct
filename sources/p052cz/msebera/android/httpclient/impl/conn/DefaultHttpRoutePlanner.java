package p052cz.msebera.android.httpclient.impl.conn;

import java.net.InetAddress;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;
import p052cz.msebera.android.httpclient.conn.params.ConnRouteParams;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoute;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner;
import p052cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.Asserts;

@ThreadSafe
@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.DefaultHttpRoutePlanner */
public class DefaultHttpRoutePlanner implements HttpRoutePlanner {
    protected final SchemeRegistry schemeRegistry;

    public DefaultHttpRoutePlanner(SchemeRegistry schemeRegistry2) {
        Args.notNull(schemeRegistry2, "Scheme registry");
        this.schemeRegistry = schemeRegistry2;
    }

    public HttpRoute determineRoute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws HttpException {
        Args.notNull(httpRequest, "HTTP request");
        HttpRoute forcedRoute = ConnRouteParams.getForcedRoute(httpRequest.getParams());
        if (forcedRoute != null) {
            return forcedRoute;
        }
        Asserts.notNull(httpHost, "Target host");
        InetAddress localAddress = ConnRouteParams.getLocalAddress(httpRequest.getParams());
        HttpHost defaultProxy = ConnRouteParams.getDefaultProxy(httpRequest.getParams());
        try {
            boolean isLayered = this.schemeRegistry.getScheme(httpHost.getSchemeName()).isLayered();
            if (defaultProxy == null) {
                return new HttpRoute(httpHost, localAddress, isLayered);
            }
            return new HttpRoute(httpHost, localAddress, defaultProxy, isLayered);
        } catch (IllegalStateException e) {
            throw new HttpException(e.getMessage());
        }
    }
}
