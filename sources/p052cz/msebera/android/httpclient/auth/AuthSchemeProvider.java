package p052cz.msebera.android.httpclient.auth;

import p052cz.msebera.android.httpclient.protocol.HttpContext;

/* renamed from: cz.msebera.android.httpclient.auth.AuthSchemeProvider */
public interface AuthSchemeProvider {
    AuthScheme create(HttpContext httpContext);
}
