package p052cz.msebera.android.httpclient.impl.execchain;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import p052cz.msebera.android.httpclient.HttpClientConnection;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;
import p052cz.msebera.android.httpclient.concurrent.Cancellable;
import p052cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger;
import p052cz.msebera.android.httpclient.conn.HttpClientConnectionManager;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;

@ThreadSafe
/* renamed from: cz.msebera.android.httpclient.impl.execchain.ConnectionHolder */
class ConnectionHolder implements ConnectionReleaseTrigger, Cancellable, Closeable {
    public HttpClientAndroidLog log;
    private final HttpClientConnection managedConn;
    private final HttpClientConnectionManager manager;
    private volatile boolean released;
    private volatile boolean reusable;
    private volatile Object state;
    private volatile TimeUnit tunit;
    private volatile long validDuration;

    public ConnectionHolder(HttpClientAndroidLog httpClientAndroidLog, HttpClientConnectionManager httpClientConnectionManager, HttpClientConnection httpClientConnection) {
        this.log = httpClientAndroidLog;
        this.manager = httpClientConnectionManager;
        this.managedConn = httpClientConnection;
    }

    public boolean isReusable() {
        return this.reusable;
    }

    public void markReusable() {
        this.reusable = true;
    }

    public void markNonReusable() {
        this.reusable = false;
    }

    public void setState(Object obj) {
        this.state = obj;
    }

    public void setValidFor(long j, TimeUnit timeUnit) {
        synchronized (this.managedConn) {
            this.validDuration = j;
            this.tunit = timeUnit;
        }
    }

    public void releaseConnection() {
        synchronized (this.managedConn) {
            if (!this.released) {
                this.released = true;
                if (this.reusable) {
                    this.manager.releaseConnection(this.managedConn, this.state, this.validDuration, this.tunit);
                } else {
                    try {
                        this.managedConn.close();
                        this.log.debug("Connection discarded");
                        this.manager.releaseConnection(this.managedConn, (Object) null, 0, TimeUnit.MILLISECONDS);
                    } catch (IOException e) {
                        try {
                            if (this.log.isDebugEnabled()) {
                                this.log.debug(e.getMessage(), e);
                            }
                        } finally {
                            this.manager.releaseConnection(this.managedConn, (Object) null, 0, TimeUnit.MILLISECONDS);
                        }
                    }
                }
            }
        }
    }

    public void abortConnection() {
        synchronized (this.managedConn) {
            if (!this.released) {
                this.released = true;
                try {
                    this.managedConn.shutdown();
                    this.log.debug("Connection discarded");
                    this.manager.releaseConnection(this.managedConn, (Object) null, 0, TimeUnit.MILLISECONDS);
                } catch (IOException e) {
                    try {
                        if (this.log.isDebugEnabled()) {
                            this.log.debug(e.getMessage(), e);
                        }
                    } finally {
                        this.manager.releaseConnection(this.managedConn, (Object) null, 0, TimeUnit.MILLISECONDS);
                    }
                }
            }
        }
    }

    public boolean cancel() {
        boolean z = this.released;
        this.log.debug("Cancelling request execution");
        abortConnection();
        return !z;
    }

    public boolean isReleased() {
        return this.released;
    }

    public void close() throws IOException {
        abortConnection();
    }
}
