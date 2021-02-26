package p052cz.msebera.android.httpclient.protocol;

import java.io.IOException;
import p052cz.msebera.android.httpclient.HttpException;
import p052cz.msebera.android.httpclient.HttpRequest;
import p052cz.msebera.android.httpclient.HttpResponse;

/* renamed from: cz.msebera.android.httpclient.protocol.HttpRequestHandler */
public interface HttpRequestHandler {
    void handle(HttpRequest httpRequest, HttpResponse httpResponse, HttpContext httpContext) throws HttpException, IOException;
}
