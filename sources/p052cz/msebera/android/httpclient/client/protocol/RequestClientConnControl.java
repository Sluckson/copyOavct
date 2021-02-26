package p052cz.msebera.android.httpclient.client.protocol;

import com.google.firebase.perf.FirebasePerformance;
import java.io.IOException;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpRequestInterceptor;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.conn.routing.RouteInfo;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.protocol.HTTP;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
/* renamed from: cz.msebera.android.httpclient.client.protocol.RequestClientConnControl */
public class RequestClientConnControl implements HttpRequestInterceptor {
    private static final String PROXY_CONN_DIRECTIVE = "Proxy-Connection";
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());

    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        if (httpRequest.getRequestLine().getMethod().equalsIgnoreCase(FirebasePerformance.HttpMethod.CONNECT)) {
            httpRequest.setHeader(PROXY_CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
            return;
        }
        RouteInfo httpRoute = HttpClientContext.adapt(httpContext).getHttpRoute();
        if (httpRoute == null) {
            this.log.debug("Connection route not set in the context");
            return;
        }
        if ((httpRoute.getHopCount() == 1 || httpRoute.isTunnelled()) && !httpRequest.containsHeader("Connection")) {
            httpRequest.addHeader("Connection", HTTP.CONN_KEEP_ALIVE);
        }
        if (httpRoute.getHopCount() == 2 && !httpRoute.isTunnelled() && !httpRequest.containsHeader(PROXY_CONN_DIRECTIVE)) {
            httpRequest.addHeader(PROXY_CONN_DIRECTIVE, HTTP.CONN_KEEP_ALIVE);
        }
    }
}
