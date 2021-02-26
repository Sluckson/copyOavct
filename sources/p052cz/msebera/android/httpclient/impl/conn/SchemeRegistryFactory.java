package p052cz.msebera.android.httpclient.impl.conn;

import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;
import p052cz.msebera.android.httpclient.conn.scheme.PlainSocketFactory;
import p052cz.msebera.android.httpclient.conn.scheme.Scheme;
import p052cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import p052cz.msebera.android.httpclient.conn.scheme.SchemeSocketFactory;
import p052cz.msebera.android.httpclient.conn.ssl.SSLSocketFactory;

@ThreadSafe
@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.SchemeRegistryFactory */
public final class SchemeRegistryFactory {
    public static SchemeRegistry createDefault() {
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, 80, (SchemeSocketFactory) PlainSocketFactory.getSocketFactory()));
        schemeRegistry.register(new Scheme("https", 443, (SchemeSocketFactory) SSLSocketFactory.getSocketFactory()));
        return schemeRegistry;
    }

    public static SchemeRegistry createSystemDefault() {
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme(HttpHost.DEFAULT_SCHEME_NAME, 80, (SchemeSocketFactory) PlainSocketFactory.getSocketFactory()));
        schemeRegistry.register(new Scheme("https", 443, (SchemeSocketFactory) SSLSocketFactory.getSystemSocketFactory()));
        return schemeRegistry;
    }
}
