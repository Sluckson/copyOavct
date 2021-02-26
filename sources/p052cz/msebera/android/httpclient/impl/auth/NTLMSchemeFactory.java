package p052cz.msebera.android.httpclient.impl.auth;

import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.auth.AuthScheme;
import p052cz.msebera.android.httpclient.auth.AuthSchemeFactory;
import p052cz.msebera.android.httpclient.auth.AuthSchemeProvider;
import p052cz.msebera.android.httpclient.params.HttpParams;
import p052cz.msebera.android.httpclient.protocol.HttpContext;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.auth.NTLMSchemeFactory */
public class NTLMSchemeFactory implements AuthSchemeFactory, AuthSchemeProvider {
    public AuthScheme newInstance(HttpParams httpParams) {
        return new NTLMScheme();
    }

    public AuthScheme create(HttpContext httpContext) {
        return new NTLMScheme();
    }
}
