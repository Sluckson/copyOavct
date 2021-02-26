package p052cz.msebera.android.httpclient.impl.client;

import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.HttpResponse;
import p052cz.msebera.android.httpclient.auth.AuthState;
import p052cz.msebera.android.httpclient.client.AuthenticationStrategy;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.protocol.HttpContext;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.client.HttpAuthenticator */
public class HttpAuthenticator extends p052cz.msebera.android.httpclient.impl.auth.HttpAuthenticator {
    public HttpAuthenticator(HttpClientAndroidLog httpClientAndroidLog) {
        super(httpClientAndroidLog);
    }

    public HttpAuthenticator() {
    }

    public boolean authenticate(HttpHost httpHost, HttpResponse httpResponse, AuthenticationStrategy authenticationStrategy, AuthState authState, HttpContext httpContext) {
        return handleAuthChallenge(httpHost, httpResponse, authenticationStrategy, authState, httpContext);
    }
}
