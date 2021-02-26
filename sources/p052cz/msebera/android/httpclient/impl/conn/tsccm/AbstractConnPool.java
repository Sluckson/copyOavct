package p052cz.msebera.android.httpclient.impl.conn.tsccm;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import p052cz.msebera.android.httpclient.annotation.GuardedBy;
import p052cz.msebera.android.httpclient.conn.ConnectionPoolTimeoutException;
import p052cz.msebera.android.httpclient.conn.OperatedClientConnection;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoute;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.impl.conn.IdleConnectionHandler;
import p052cz.msebera.android.httpclient.util.Args;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.tsccm.AbstractConnPool */
public abstract class AbstractConnPool {
    protected IdleConnectionHandler idleConnHandler = new IdleConnectionHandler();
    protected volatile boolean isShutDown;
    protected Set<BasicPoolEntryRef> issuedConnections;
    @GuardedBy("poolLock")
    protected Set<BasicPoolEntry> leasedConnections = new HashSet();
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());
    @GuardedBy("poolLock")
    protected int numConnections;
    protected final Lock poolLock = new ReentrantLock();
    protected ReferenceQueue<Object> refQueue;

    public abstract void deleteClosedConnections();

    public void enableConnectionGC() throws IllegalStateException {
    }

    public abstract void freeEntry(BasicPoolEntry basicPoolEntry, boolean z, long j, TimeUnit timeUnit);

    /* access modifiers changed from: protected */
    public abstract void handleLostEntry(HttpRoute httpRoute);

    public void handleReference(Reference<?> reference) {
    }

    public abstract PoolEntryRequest requestPoolEntry(HttpRoute httpRoute, Object obj);

    protected AbstractConnPool() {
    }

    public final BasicPoolEntry getEntry(HttpRoute httpRoute, Object obj, long j, TimeUnit timeUnit) throws ConnectionPoolTimeoutException, InterruptedException {
        return requestPoolEntry(httpRoute, obj).getPoolEntry(j, timeUnit);
    }

    public void closeIdleConnections(long j, TimeUnit timeUnit) {
        Args.notNull(timeUnit, "Time unit");
        this.poolLock.lock();
        try {
            this.idleConnHandler.closeIdleConnections(timeUnit.toMillis(j));
        } finally {
            this.poolLock.unlock();
        }
    }

    public void closeExpiredConnections() {
        this.poolLock.lock();
        try {
            this.idleConnHandler.closeExpiredConnections();
        } finally {
            this.poolLock.unlock();
        }
    }

    public void shutdown() {
        this.poolLock.lock();
        try {
            if (!this.isShutDown) {
                Iterator<BasicPoolEntry> it = this.leasedConnections.iterator();
                while (it.hasNext()) {
                    it.remove();
                    closeConnection(it.next().getConnection());
                }
                this.idleConnHandler.removeAll();
                this.isShutDown = true;
                this.poolLock.unlock();
            }
        } finally {
            this.poolLock.unlock();
        }
    }

    /* access modifiers changed from: protected */
    public void closeConnection(OperatedClientConnection operatedClientConnection) {
        if (operatedClientConnection != null) {
            try {
                operatedClientConnection.close();
            } catch (IOException e) {
                this.log.debug("I/O error closing connection", e);
            }
        }
    }
}
