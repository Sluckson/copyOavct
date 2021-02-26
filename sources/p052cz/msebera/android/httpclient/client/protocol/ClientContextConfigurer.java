package p052cz.msebera.android.httpclient.client.protocol;

import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.auth.AuthSchemeRegistry;
import p052cz.msebera.android.httpclient.client.CookieStore;
import p052cz.msebera.android.httpclient.client.CredentialsProvider;
import p052cz.msebera.android.httpclient.cookie.CookieSpecRegistry;
import p052cz.msebera.android.httpclient.protocol.HttpContext;
import p052cz.msebera.android.httpclient.util.Args;

@NotThreadSafe
@Deprecated
/* renamed from: cz.msebera.android.httpclient.client.protocol.ClientContextConfigurer */
public class ClientContextConfigurer implements ClientContext {
    private final HttpContext context;

    public ClientContextConfigurer(HttpContext httpContext) {
        Args.notNull(httpContext, "HTTP context");
        this.context = httpContext;
    }

    public void setCookieSpecRegistry(CookieSpecRegistry cookieSpecRegistry) {
        this.context.setAttribute("http.cookiespec-registry", cookieSpecRegistry);
    }

    public void setAuthSchemeRegistry(AuthSchemeRegistry authSchemeRegistry) {
        this.context.setAttribute("http.authscheme-registry", authSchemeRegistry);
    }

    public void setCookieStore(CookieStore cookieStore) {
        this.context.setAttribute("http.cookie-store", cookieStore);
    }

    public void setCredentialsProvider(CredentialsProvider credentialsProvider) {
        this.context.setAttribute("http.auth.credentials-provider", credentialsProvider);
    }
}
