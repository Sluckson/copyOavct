package p052cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import p052cz.msebera.android.httpclient.conn.OperatedClientConnection;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoute;
import p052cz.msebera.android.httpclient.conn.routing.RouteTracker;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.pool.PoolEntry;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.HttpPoolEntry */
class HttpPoolEntry extends PoolEntry<HttpRoute, OperatedClientConnection> {
    public HttpClientAndroidLog log;
    private final RouteTracker tracker;

    public HttpPoolEntry(HttpClientAndroidLog httpClientAndroidLog, String str, HttpRoute httpRoute, OperatedClientConnection operatedClientConnection, long j, TimeUnit timeUnit) {
        super(str, httpRoute, operatedClientConnection, j, timeUnit);
        this.log = httpClientAndroidLog;
        this.tracker = new RouteTracker(httpRoute);
    }

    public boolean isExpired(long j) {
        boolean isExpired = super.isExpired(j);
        if (isExpired && this.log.isDebugEnabled()) {
            HttpClientAndroidLog httpClientAndroidLog = this.log;
            httpClientAndroidLog.debug("Connection " + this + " expired @ " + new Date(getExpiry()));
        }
        return isExpired;
    }

    /* access modifiers changed from: package-private */
    public RouteTracker getTracker() {
        return this.tracker;
    }

    /* access modifiers changed from: package-private */
    public HttpRoute getPlannedRoute() {
        return (HttpRoute) getRoute();
    }

    /* access modifiers changed from: package-private */
    public HttpRoute getEffectiveRoute() {
        return this.tracker.toRoute();
    }

    public boolean isClosed() {
        return !((OperatedClientConnection) getConnection()).isOpen();
    }

    public void close() {
        try {
            ((OperatedClientConnection) getConnection()).close();
        } catch (IOException e) {
            this.log.debug("I/O error closing connection", e);
        }
    }
}
