package p052cz.msebera.android.httpclient.impl.client;

import java.net.ProxySelector;
import p052cz.msebera.android.httpclient.ConnectionReuseStrategy;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;
import p052cz.msebera.android.httpclient.conn.ClientConnectionManager;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoutePlanner;
import p052cz.msebera.android.httpclient.impl.DefaultConnectionReuseStrategy;
import p052cz.msebera.android.httpclient.impl.NoConnectionReuseStrategy;
import p052cz.msebera.android.httpclient.impl.conn.PoolingClientConnectionManager;
import p052cz.msebera.android.httpclient.impl.conn.ProxySelectorRoutePlanner;
import p052cz.msebera.android.httpclient.impl.conn.SchemeRegistryFactory;
import p052cz.msebera.android.httpclient.params.HttpParams;

@ThreadSafe
@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.client.SystemDefaultHttpClient */
public class SystemDefaultHttpClient extends DefaultHttpClient {
    public SystemDefaultHttpClient(HttpParams httpParams) {
        super((ClientConnectionManager) null, httpParams);
    }

    public SystemDefaultHttpClient() {
        super((ClientConnectionManager) null, (HttpParams) null);
    }

    /* access modifiers changed from: protected */
    public ClientConnectionManager createClientConnectionManager() {
        PoolingClientConnectionManager poolingClientConnectionManager = new PoolingClientConnectionManager(SchemeRegistryFactory.createSystemDefault());
        if ("true".equalsIgnoreCase(System.getProperty("http.keepAlive", "true"))) {
            int parseInt = Integer.parseInt(System.getProperty("http.maxConnections", "5"));
            poolingClientConnectionManager.setDefaultMaxPerRoute(parseInt);
            poolingClientConnectionManager.setMaxTotal(parseInt * 2);
        }
        return poolingClientConnectionManager;
    }

    /* access modifiers changed from: protected */
    public HttpRoutePlanner createHttpRoutePlanner() {
        return new ProxySelectorRoutePlanner(getConnectionManager().getSchemeRegistry(), ProxySelector.getDefault());
    }

    /* access modifiers changed from: protected */
    public ConnectionReuseStrategy createConnectionReuseStrategy() {
        if ("true".equalsIgnoreCase(System.getProperty("http.keepAlive", "true"))) {
            return new DefaultConnectionReuseStrategy();
        }
        return new NoConnectionReuseStrategy();
    }
}
