package p052cz.msebera.android.httpclient.conn;

import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.protocol.HttpContext;

/* renamed from: cz.msebera.android.httpclient.conn.ConnectionKeepAliveStrategy */
public interface ConnectionKeepAliveStrategy {
    long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext);
}
