package p052cz.msebera.android.httpclient;

import p052cz.msebera.android.httpclient.protocol.HttpContext;

/* renamed from: cz.msebera.android.httpclient.ConnectionReuseStrategy */
public interface ConnectionReuseStrategy {
    boolean keepAlive(HttpResponse httpResponse, HttpContext httpContext);
}
