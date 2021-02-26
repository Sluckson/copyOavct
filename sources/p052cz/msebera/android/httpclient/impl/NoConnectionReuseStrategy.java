package p052cz.msebera.android.httpclient.impl;

import p052cz.msebera.android.httpclient.ConnectionReuseStrategy;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.protocol.HttpContext;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.NoConnectionReuseStrategy */
public class NoConnectionReuseStrategy implements ConnectionReuseStrategy {
    public static final NoConnectionReuseStrategy INSTANCE = new NoConnectionReuseStrategy();

    public boolean keepAlive(HttpResponse httpResponse, HttpContext httpContext) {
        return false;
    }
}
