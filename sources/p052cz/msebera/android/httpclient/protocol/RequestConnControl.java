package p052cz.msebera.android.httpclient.protocol;

import com.google.firebase.perf.FirebasePerformance;
import java.io.IOException;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpRequestInterceptor;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
/* renamed from: cz.msebera.android.httpclient.protocol.RequestConnControl */
public class RequestConnControl implements HttpRequestInterceptor {
    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        if (!httpRequest.getRequestLine().getMethod().equalsIgnoreCase(FirebasePerformance.HttpMethod.CONNECT) && !httpRequest.containsHeader("Connection")) {
            httpRequest.addHeader("Connection", HTTP.CONN_KEEP_ALIVE);
        }
    }
}
