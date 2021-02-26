package p052cz.msebera.android.httpclient.impl.conn;

import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.annotation.Immutable;
import p052cz.msebera.android.httpclient.conn.SchemePortResolver;
import p052cz.msebera.android.httpclient.conn.UnsupportedSchemeException;
import p052cz.msebera.android.httpclient.util.Args;

@Immutable
/* renamed from: cz.msebera.android.httpclient.impl.conn.DefaultSchemePortResolver */
public class DefaultSchemePortResolver implements SchemePortResolver {
    public static final DefaultSchemePortResolver INSTANCE = new DefaultSchemePortResolver();

    public int resolve(HttpHost httpHost) throws UnsupportedSchemeException {
        Args.notNull(httpHost, "HTTP host");
        int port = httpHost.getPort();
        if (port > 0) {
            return port;
        }
        String schemeName = httpHost.getSchemeName();
        if (schemeName.equalsIgnoreCase(HttpHost.DEFAULT_SCHEME_NAME)) {
            return 80;
        }
        if (schemeName.equalsIgnoreCase("https")) {
            return 443;
        }
        throw new UnsupportedSchemeException(schemeName + " protocol is not supported");
    }
}
