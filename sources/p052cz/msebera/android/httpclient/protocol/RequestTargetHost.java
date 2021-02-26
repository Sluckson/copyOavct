package p052cz.msebera.android.httpclient.protocol;

import com.google.firebase.perf.FirebasePerformance;
import java.io.IOException;
import java.net.InetAddress;
import p052cz.msebera.android.httpclient.HttpConnection;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpInetConnection;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpRequestInterceptor;
import p052cz.msebera.android.httpclient.HttpVersion;
import p052cz.msebera.android.httpclient.ProtocolException;
import p052cz.msebera.android.httpclient.ProtocolVersion;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
/* renamed from: cz.msebera.android.httpclient.protocol.RequestTargetHost */
public class RequestTargetHost implements HttpRequestInterceptor {
    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        HttpCoreContext adapt = HttpCoreContext.adapt(httpContext);
        ProtocolVersion protocolVersion = httpRequest.getRequestLine().getProtocolVersion();
        if ((!httpRequest.getRequestLine().getMethod().equalsIgnoreCase(FirebasePerformance.HttpMethod.CONNECT) || !protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) && !httpRequest.containsHeader("Host")) {
            HttpHost targetHost = adapt.getTargetHost();
            if (targetHost == null) {
                HttpConnection connection = adapt.getConnection();
                if (connection instanceof HttpInetConnection) {
                    HttpInetConnection httpInetConnection = (HttpInetConnection) connection;
                    InetAddress remoteAddress = httpInetConnection.getRemoteAddress();
                    int remotePort = httpInetConnection.getRemotePort();
                    if (remoteAddress != null) {
                        targetHost = new HttpHost(remoteAddress.getHostName(), remotePort);
                    }
                }
                if (targetHost == null) {
                    if (!protocolVersion.lessEquals(HttpVersion.HTTP_1_0)) {
                        throw new ProtocolException("Target host missing");
                    }
                    return;
                }
            }
            httpRequest.addHeader("Host", targetHost.toHostString());
        }
    }
}
