package p052cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import p052cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import p052cz.msebera.android.httpclient.conn.OperatedClientConnection;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoute;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.pool.AbstractConnPool;
import p052cz.msebera.android.httpclient.pool.ConnFactory;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.HttpConnPool */
class HttpConnPool extends AbstractConnPool<HttpRoute, OperatedClientConnection, HttpPoolEntry> {
    private static final AtomicLong COUNTER = new AtomicLong();
    public HttpClientAndroidLog log;
    private final long timeToLive;
    private final TimeUnit tunit;

    public HttpConnPool(HttpClientAndroidLog httpClientAndroidLog, ClientConnectionOperator clientConnectionOperator, int i, int i2, long j, TimeUnit timeUnit) {
        super(new InternalConnFactory(clientConnectionOperator), i, i2);
        this.log = httpClientAndroidLog;
        this.timeToLive = j;
        this.tunit = timeUnit;
    }

    /* access modifiers changed from: protected */
    public HttpPoolEntry createEntry(HttpRoute httpRoute, OperatedClientConnection operatedClientConnection) {
        return new HttpPoolEntry(this.log, Long.toString(COUNTER.getAndIncrement()), httpRoute, operatedClientConnection, this.timeToLive, this.tunit);
    }

    /* renamed from: cz.msebera.android.httpclient.impl.conn.HttpConnPool$InternalConnFactory */
    static class InternalConnFactory implements ConnFactory<HttpRoute, OperatedClientConnection> {
        private final ClientConnectionOperator connOperator;

        InternalConnFactory(ClientConnectionOperator clientConnectionOperator) {
            this.connOperator = clientConnectionOperator;
        }

        public OperatedClientConnection create(HttpRoute httpRoute) throws IOException {
            return this.connOperator.createConnection();
        }
    }
}
