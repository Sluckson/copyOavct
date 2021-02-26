package p052cz.msebera.android.httpclient.impl.conn;

import java.net.InetAddress;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.ProtocolException;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.client.config.RequestConfig;
import p052cz.msebera.android.httpclient.client.protocol.HttpClientContext;
import p052cz.msebera.android.httpclient.conn.SchemePortResolver;
import p052cz.msebera.android.httpclient.conn.UnsupportedSchemeException;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoute;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.conn.DefaultRoutePlanner */
public class DefaultRoutePlanner implements HttpRoutePlanner {
    private final SchemePortResolver schemePortResolver;

    /* access modifiers changed from: protected */
    public HttpHost determineProxy(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws HttpException {
        return null;
    }

    public DefaultRoutePlanner(SchemePortResolver schemePortResolver2) {
        this.schemePortResolver = schemePortResolver2 == null ? DefaultSchemePortResolver.INSTANCE : schemePortResolver2;
    }

    public HttpRoute determineRoute(HttpHost httpHost, HttpRequest httpRequest, HttpContext httpContext) throws HttpException {
        Args.notNull(httpRequest, "Request");
        if (httpHost != null) {
            RequestConfig requestConfig = HttpClientContext.adapt(httpContext).getRequestConfig();
            InetAddress localAddress = requestConfig.getLocalAddress();
            HttpHost proxy = requestConfig.getProxy();
            if (proxy == null) {
                proxy = determineProxy(httpHost, httpRequest, httpContext);
            }
            if (httpHost.getPort() <= 0) {
                try {
                    httpHost = new HttpHost(httpHost.getHostName(), this.schemePortResolver.resolve(httpHost), httpHost.getSchemeName());
                } catch (UnsupportedSchemeException e) {
                    throw new HttpException(e.getMessage());
                }
            }
            boolean equalsIgnoreCase = httpHost.getSchemeName().equalsIgnoreCase("https");
            if (proxy == null) {
                return new HttpRoute(httpHost, localAddress, equalsIgnoreCase);
            }
            return new HttpRoute(httpHost, localAddress, proxy, equalsIgnoreCase);
        }
        throw new ProtocolException("Target host is not specified");
    }
}
