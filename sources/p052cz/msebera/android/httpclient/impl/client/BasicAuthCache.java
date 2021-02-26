package p052cz.msebera.android.httpclient.impl.client;

import java.util.HashMap;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.annotation.NotThreadSafe;
import p052cz.msebera.android.httpclient.auth.AuthScheme;
import p052cz.msebera.android.httpclient.client.AuthCache;
import p052cz.msebera.android.httpclient.conn.SchemePortResolver;
import p052cz.msebera.android.httpclient.conn.UnsupportedSchemeException;
import p052cz.msebera.android.httpclient.impl.conn.DefaultSchemePortResolver;
import p052cz.msebera.android.httpclient.util.Args;

@NotThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.client.BasicAuthCache */
public class BasicAuthCache implements AuthCache {
    private final HashMap<HttpHost, AuthScheme> map;
    private final SchemePortResolver schemePortResolver;

    public BasicAuthCache(SchemePortResolver schemePortResolver2) {
        this.map = new HashMap<>();
        this.schemePortResolver = schemePortResolver2 == null ? DefaultSchemePortResolver.INSTANCE : schemePortResolver2;
    }

    public BasicAuthCache() {
        this((SchemePortResolver) null);
    }

    /* access modifiers changed from: protected */
    public HttpHost getKey(HttpHost httpHost) {
        if (httpHost.getPort() <= 0) {
            try {
                return new HttpHost(httpHost.getHostName(), this.schemePortResolver.resolve(httpHost), httpHost.getSchemeName());
            } catch (UnsupportedSchemeException unused) {
            }
        }
        return httpHost;
    }

    public void put(HttpHost httpHost, AuthScheme authScheme) {
        Args.notNull(httpHost, "HTTP host");
        this.map.put(getKey(httpHost), authScheme);
    }

    public AuthScheme get(HttpHost httpHost) {
        Args.notNull(httpHost, "HTTP host");
        return this.map.get(getKey(httpHost));
    }

    public void remove(HttpHost httpHost) {
        Args.notNull(httpHost, "HTTP host");
        this.map.remove(getKey(httpHost));
    }

    public void clear() {
        this.map.clear();
    }

    public String toString() {
        return this.map.toString();
    }
}
