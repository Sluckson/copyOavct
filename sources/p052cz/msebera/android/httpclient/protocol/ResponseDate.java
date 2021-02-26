package p052cz.msebera.android.httpclient.protocol;

import java.io.IOException;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.HttpResponseInterceptor;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;
import p052cz.msebera.android.httpclient.util.Args;

@ThreadSafe
/* renamed from: cz.msebera.android.httpclient.protocol.ResponseDate */
public class ResponseDate implements HttpResponseInterceptor {
    private static final HttpDateGenerator DATE_GENERATOR = new HttpDateGenerator();

    public void process(HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException {
        Args.notNull(httpResponse, "HTTP response");
        if (httpResponse.getStatusLine().getStatusCode() >= 200 && !httpResponse.containsHeader("Date")) {
            httpResponse.setHeader("Date", DATE_GENERATOR.getCurrentDate());
        }
    }
}
