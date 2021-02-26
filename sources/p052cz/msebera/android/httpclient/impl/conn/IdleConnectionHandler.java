package p052cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import p052cz.msebera.android.httpclient.HttpConnection;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.IdleConnectionHandler */
public class IdleConnectionHandler {
    private final Map<HttpConnection, TimeValues> connectionToTimes = new HashMap();
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());

    public void add(HttpConnection httpConnection, long j, TimeUnit timeUnit) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.log.isDebugEnabled()) {
            HttpClientAndroidLog httpClientAndroidLog = this.log;
            httpClientAndroidLog.debug("Adding connection at: " + currentTimeMillis);
        }
        this.connectionToTimes.put(httpConnection, new TimeValues(currentTimeMillis, j, timeUnit));
    }

    public boolean remove(HttpConnection httpConnection) {
        TimeValues remove = this.connectionToTimes.remove(httpConnection);
        if (remove == null) {
            this.log.warn("Removing a connection that never existed!");
            return true;
        } else if (System.currentTimeMillis() <= remove.timeExpires) {
            return true;
        } else {
            return false;
        }
    }

    public void removeAll() {
        this.connectionToTimes.clear();
    }

    public void closeIdleConnections(long j) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        if (this.log.isDebugEnabled()) {
            HttpClientAndroidLog httpClientAndroidLog = this.log;
            httpClientAndroidLog.debug("Checking for connections, idle timeout: " + currentTimeMillis);
        }
        for (Map.Entry next : this.connectionToTimes.entrySet()) {
            HttpConnection httpConnection = (HttpConnection) next.getKey();
            long access$100 = ((TimeValues) next.getValue()).timeAdded;
            if (access$100 <= currentTimeMillis) {
                if (this.log.isDebugEnabled()) {
                    HttpClientAndroidLog httpClientAndroidLog2 = this.log;
                    httpClientAndroidLog2.debug("Closing idle connection, connection time: " + access$100);
                }
                try {
                    httpConnection.close();
                } catch (IOException e) {
                    this.log.debug("I/O error closing connection", e);
                }
            }
        }
    }

    public void closeExpiredConnections() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.log.isDebugEnabled()) {
            HttpClientAndroidLog httpClientAndroidLog = this.log;
            httpClientAndroidLog.debug("Checking for expired connections, now: " + currentTimeMillis);
        }
        for (Map.Entry next : this.connectionToTimes.entrySet()) {
            HttpConnection httpConnection = (HttpConnection) next.getKey();
            TimeValues timeValues = (TimeValues) next.getValue();
            if (timeValues.timeExpires <= currentTimeMillis) {
                if (this.log.isDebugEnabled()) {
                    HttpClientAndroidLog httpClientAndroidLog2 = this.log;
                    httpClientAndroidLog2.debug("Closing connection, expired @: " + timeValues.timeExpires);
                }
                try {
                    httpConnection.close();
                } catch (IOException e) {
                    this.log.debug("I/O error closing connection", e);
                }
            }
        }
    }

    /* renamed from: cz.msebera.android.httpclient.impl.conn.IdleConnectionHandler$TimeValues */
    private static class TimeValues {
        /* access modifiers changed from: private */
        public final long timeAdded;
        /* access modifiers changed from: private */
        public final long timeExpires;

        TimeValues(long j, long j2, TimeUnit timeUnit) {
            this.timeAdded = j;
            if (j2 > 0) {
                this.timeExpires = j + timeUnit.toMillis(j2);
            } else {
                this.timeExpires = Long.MAX_VALUE;
            }
        }
    }
}
