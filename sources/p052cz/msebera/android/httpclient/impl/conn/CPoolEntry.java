package p052cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import p052cz.msebera.android.httpclient.HttpClientConnection;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;
import p052cz.msebera.android.httpclient.conn.ManagedHttpClientConnection;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoute;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.pool.PoolEntry;

@ThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.conn.CPoolEntry */
class CPoolEntry extends PoolEntry<HttpRoute, ManagedHttpClientConnection> {
    public HttpClientAndroidLog log;
    private volatile boolean routeComplete;

    public CPoolEntry(HttpClientAndroidLog httpClientAndroidLog, String str, HttpRoute httpRoute, ManagedHttpClientConnection managedHttpClientConnection, long j, TimeUnit timeUnit) {
        super(str, httpRoute, managedHttpClientConnection, j, timeUnit);
        this.log = httpClientAndroidLog;
    }

    public void markRouteComplete() {
        this.routeComplete = true;
    }

    public boolean isRouteComplete() {
        return this.routeComplete;
    }

    public void closeConnection() throws IOException {
        ((HttpClientConnection) getConnection()).close();
    }

    public void shutdownConnection() throws IOException {
        ((HttpClientConnection) getConnection()).shutdown();
    }

    public boolean isExpired(long j) {
        boolean isExpired = super.isExpired(j);
        if (isExpired && this.log.isDebugEnabled()) {
            HttpClientAndroidLog httpClientAndroidLog = this.log;
            httpClientAndroidLog.debug("Connection " + this + " expired @ " + new Date(getExpiry()));
        }
        return isExpired;
    }

    public boolean isClosed() {
        return !((HttpClientConnection) getConnection()).isOpen();
    }

    public void close() {
        try {
            closeConnection();
        } catch (IOException e) {
            this.log.debug("I/O error closing connection", e);
        }
    }
}
