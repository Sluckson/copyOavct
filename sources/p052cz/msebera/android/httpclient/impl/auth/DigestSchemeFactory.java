package p052cz.msebera.android.httpclient.impl.auth;

import java.nio.charset.Charset;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.auth.AuthScheme;
import p052cz.msebera.android.httpclient.auth.AuthSchemeFactory;
import p052cz.msebera.android.httpclient.auth.AuthSchemeProvider;
import p052cz.msebera.android.httpclient.params.HttpParams;
import p052cz.msebera.android.httpclient.protocol.HttpContext;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.auth.DigestSchemeFactory */
public class DigestSchemeFactory implements AuthSchemeFactory, AuthSchemeProvider {
    private final Charset charset;

    public DigestSchemeFactory(Charset charset2) {
        this.charset = charset2;
    }

    public DigestSchemeFactory() {
        this((Charset) null);
    }

    public AuthScheme newInstance(HttpParams httpParams) {
        return new DigestScheme();
    }

    public AuthScheme create(HttpContext httpContext) {
        return new DigestScheme(this.charset);
    }
}
