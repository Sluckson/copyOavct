package p052cz.msebera.android.httpclient.client.protocol;

import java.io.IOException;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpRequestInterceptor;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.protocol.HttpContext;

@Immutable
/* renamed from: cz.msebera.android.httpclient.client.protocol.RequestAcceptEncoding */
public class RequestAcceptEncoding implements HttpRequestInterceptor {
    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        if (!httpRequest.containsHeader("Accept-Encoding")) {
            httpRequest.addHeader("Accept-Encoding", "gzip,deflate");
        }
    }
}
