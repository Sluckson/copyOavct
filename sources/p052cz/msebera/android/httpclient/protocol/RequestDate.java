package p052cz.msebera.android.httpclient.protocol;

import java.io.IOException;
import p052cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpRequestInterceptor;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;
import p052cz.msebera.android.httpclient.util.Args;

@ThreadSafe
/* renamed from: cz.msebera.android.httpclient.protocol.RequestDate */
public class RequestDate implements HttpRequestInterceptor {
    private static final HttpDateGenerator DATE_GENERATOR = new HttpDateGenerator();

    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpRequest, "HTTP request");
        if ((httpRequest instanceof HttpEntityEnclosingRequest) && !httpRequest.containsHeader("Date")) {
            httpRequest.setHeader("Date", DATE_GENERATOR.getCurrentDate());
        }
    }
}
