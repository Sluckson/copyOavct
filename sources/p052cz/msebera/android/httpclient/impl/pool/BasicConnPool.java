package p052cz.msebera.android.httpclient.impl.pool;

import java.util.concurrent.atomic.AtomicLong;
import p052cz.msebera.android.httpclient.HttpClientConnection;
import p052cz.msebera.android.httpclient.HttpHost;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;
import p052cz.msebera.android.httpclient.config.ConnectionConfig;
import p052cz.msebera.android.httpclient.config.SocketConfig;
import p052cz.msebera.android.httpclient.params.HttpParams;
import p052cz.msebera.android.httpclient.pool.AbstractConnPool;
import p052cz.msebera.android.httpclient.pool.ConnFactory;

@ThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.pool.BasicConnPool */
public class BasicConnPool extends AbstractConnPool<HttpHost, HttpClientConnection, BasicPoolEntry> {
    private static final AtomicLong COUNTER = new AtomicLong();

    public BasicConnPool(ConnFactory<HttpHost, HttpClientConnection> connFactory) {
        super(connFactory, 2, 20);
    }

    @Deprecated
    public BasicConnPool(HttpParams httpParams) {
        super(new BasicConnFactory(httpParams), 2, 20);
    }

    public BasicConnPool(SocketConfig socketConfig, ConnectionConfig connectionConfig) {
        super(new BasicConnFactory(socketConfig, connectionConfig), 2, 20);
    }

    public BasicConnPool() {
        super(new BasicConnFactory(SocketConfig.DEFAULT, ConnectionConfig.DEFAULT), 2, 20);
    }

    /* access modifiers changed from: protected */
    public BasicPoolEntry createEntry(HttpHost httpHost, HttpClientConnection httpClientConnection) {
        return new BasicPoolEntry(Long.toString(COUNTER.getAndIncrement()), httpHost, httpClientConnection);
    }
}
