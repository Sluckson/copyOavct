package p052cz.msebera.android.httpclient;

import p052cz.msebera.android.httpclient.protocol.HttpContext;

/* renamed from: cz.msebera.android.httpclient.HttpResponseFactory */
public interface HttpResponseFactory {
    HttpResponse newHttpResponse(ProtocolVersion protocolVersion, int i, HttpContext httpContext);

    HttpResponse newHttpResponse(StatusLine statusLine, HttpContext httpContext);
}
