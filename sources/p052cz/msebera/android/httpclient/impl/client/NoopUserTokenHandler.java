package p052cz.msebera.android.httpclient.impl.client;

import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.client.UserTokenHandler;
import p052cz.msebera.android.httpclient.protocol.HttpContext;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.client.NoopUserTokenHandler */
public class NoopUserTokenHandler implements UserTokenHandler {
    public static final NoopUserTokenHandler INSTANCE = new NoopUserTokenHandler();

    public Object getUserToken(HttpContext httpContext) {
        return null;
    }
}
