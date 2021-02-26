package p052cz.msebera.android.httpclient.protocol;

import java.io.IOException;
import p052cz.msebera.android.httpclient.Header;
import p052cz.msebera.android.httpclient.HttpEntity;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.HttpResponseInterceptor;
import p052cz.msebera.android.httpclient.HttpVersion;
import p052cz.msebera.android.httpclient.ProtocolVersion;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
/* renamed from: cz.msebera.android.httpclient.protocol.ResponseConnControl */
public class ResponseConnControl implements HttpResponseInterceptor {
    public void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpResponse, "HTTP response");
        HttpCoreContext adapt = HttpCoreContext.adapt(httpContext);
        int statusCode = httpResponse.getStatusLine().getStatusCode();
        if (statusCode == 400 || statusCode == 408 || statusCode == 411 || statusCode == 413 || statusCode == 414 || statusCode == 503 || statusCode == 501) {
            httpResponse.setHeader("Connection", HTTP.CONN_CLOSE);
            return;
        }
        Header firstHeader = httpResponse.getFirstHeader("Connection");
        if (firstHeader == null || !HTTP.CONN_CLOSE.equalsIgnoreCase(firstHeader.getValue())) {
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                ProtocolVersion protocolVersion = httpResponse.getStatusLine().getProtocolVersion();
                if (entity.getContentLength() < 0 && (!entity.isChunked() || protocolVersion.lessEquals(HttpVersion.HTTP_1_0))) {
                    httpResponse.setHeader("Connection", HTTP.CONN_CLOSE);
                    return;
                }
            }
            HttpRequest request = adapt.getRequest();
            if (request != null) {
                Header firstHeader2 = request.getFirstHeader("Connection");
                if (firstHeader2 != null) {
                    httpResponse.setHeader("Connection", firstHeader2.getValue());
                } else if (request.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0)) {
                    httpResponse.setHeader("Connection", HTTP.CONN_CLOSE);
                }
            }
        }
    }
}
