package p052cz.msebera.android.httpclient.impl.conn;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import p052cz.msebera.android.httpclient.HttpClientConnection;
import p052cz.msebera.android.httpclient.annotation.GuardedBy;
import p052cz.msebera.android.httpclient.annotation.ThreadSafe;
import p052cz.msebera.android.httpclient.conn.ClientConnectionManager;
import p052cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import p052cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import p052cz.msebera.android.httpclient.conn.ManagedClientConnection;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoute;
import p052cz.msebera.android.httpclient.conn.scheme.SchemeRegistry;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.Asserts;

@ThreadSafe
@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.BasicClientConnectionManager */
public class BasicClientConnectionManager implements ClientConnectionManager {
    private static final AtomicLong COUNTER = new AtomicLong();
    public static final String MISUSE_MESSAGE = "Invalid use of BasicClientConnManager: connection still allocated.\nMake sure to release the connection before allocating another one.";
    @GuardedBy("this")
    private ManagedClientConnectionImpl conn;
    private final ClientConnectionOperator connOperator;
    public HttpClientAndroidLog log;
    @GuardedBy("this")
    private HttpPoolEntry poolEntry;
    private final SchemeRegistry schemeRegistry;
    @GuardedBy("this")
    private volatile boolean shutdown;

    public BasicClientConnectionManager(SchemeRegistry schemeRegistry2) {
        this.log = new HttpClientAndroidLog(getClass());
        Args.notNull(schemeRegistry2, "Scheme registry");
        this.schemeRegistry = schemeRegistry2;
        this.connOperator = createConnectionOperator(schemeRegistry2);
    }

    public BasicClientConnectionManager() {
        this(SchemeRegistryFactory.createDefault());
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        try {
            shutdown();
        } finally {
            super.finalize();
        }
    }

    public SchemeRegistry getSchemeRegistry() {
        return this.schemeRegistry;
    }

    /* access modifiers changed from: protected */
    public ClientConnectionOperator createConnectionOperator(SchemeRegistry schemeRegistry2) {
        return new DefaultClientConnectionOperator(schemeRegistry2);
    }

    public final ClientConnectionRequest requestConnection(final HttpRoute httpRoute, final Object obj) {
        return new ClientConnectionRequest() {
            public void abortRequest() {
            }

            public ManagedClientConnection getConnection(long j, TimeUnit timeUnit) {
                return BasicClientConnectionManager.this.getConnection(httpRoute, obj);
            }
        };
    }

    private void assertNotShutdown() {
        Asserts.check(!this.shutdown, "Connection manager has been shut down");
    }

    /* access modifiers changed from: package-private */
    public ManagedClientConnection getConnection(HttpRoute httpRoute, Object obj) {
        ManagedClientConnectionImpl managedClientConnectionImpl;
        Args.notNull(httpRoute, "Route");
        synchronized (this) {
            assertNotShutdown();
            if (this.log.isDebugEnabled()) {
                HttpClientAndroidLog httpClientAndroidLog = this.log;
                httpClientAndroidLog.debug("Get connection for route " + httpRoute);
            }
            Asserts.check(this.conn == null, MISUSE_MESSAGE);
            if (this.poolEntry != null && !this.poolEntry.getPlannedRoute().equals(httpRoute)) {
                this.poolEntry.close();
                this.poolEntry = null;
            }
            if (this.poolEntry == null) {
                this.poolEntry = new HttpPoolEntry(this.log, Long.toString(COUNTER.getAndIncrement()), httpRoute, this.connOperator.createConnection(), 0, TimeUnit.MILLISECONDS);
            }
            if (this.poolEntry.isExpired(System.currentTimeMillis())) {
                this.poolEntry.close();
                this.poolEntry.getTracker().reset();
            }
            this.conn = new ManagedClientConnectionImpl(this, this.connOperator, this.poolEntry);
            managedClientConnectionImpl = this.conn;
        }
        return managedClientConnectionImpl;
    }

    private void shutdownConnection(HttpClientConnection httpClientConnection) {
        try {
            httpClientConnection.shutdown();
        } catch (IOException e) {
            if (this.log.isDebugEnabled()) {
                this.log.debug("I/O exception shutting down connection", e);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00bc, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void releaseConnection(p052cz.msebera.android.httpclient.conn.ManagedClientConnection r5, long r6, java.util.concurrent.TimeUnit r8) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof p052cz.msebera.android.httpclient.impl.conn.ManagedClientConnectionImpl
            java.lang.String r1 = "Connection class mismatch, connection not obtained from this manager"
            p052cz.msebera.android.httpclient.util.Args.check(r0, r1)
            r0 = r5
            cz.msebera.android.httpclient.impl.conn.ManagedClientConnectionImpl r0 = (p052cz.msebera.android.httpclient.impl.conn.ManagedClientConnectionImpl) r0
            monitor-enter(r0)
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r1 = r4.log     // Catch:{ all -> 0x00d1 }
            boolean r1 = r1.isDebugEnabled()     // Catch:{ all -> 0x00d1 }
            if (r1 == 0) goto L_0x0029
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r1 = r4.log     // Catch:{ all -> 0x00d1 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d1 }
            r2.<init>()     // Catch:{ all -> 0x00d1 }
            java.lang.String r3 = "Releasing connection "
            r2.append(r3)     // Catch:{ all -> 0x00d1 }
            r2.append(r5)     // Catch:{ all -> 0x00d1 }
            java.lang.String r5 = r2.toString()     // Catch:{ all -> 0x00d1 }
            r1.debug(r5)     // Catch:{ all -> 0x00d1 }
        L_0x0029:
            cz.msebera.android.httpclient.impl.conn.HttpPoolEntry r5 = r0.getPoolEntry()     // Catch:{ all -> 0x00d1 }
            if (r5 != 0) goto L_0x0031
            monitor-exit(r0)     // Catch:{ all -> 0x00d1 }
            return
        L_0x0031:
            cz.msebera.android.httpclient.conn.ClientConnectionManager r5 = r0.getManager()     // Catch:{ all -> 0x00d1 }
            if (r5 != r4) goto L_0x0039
            r5 = 1
            goto L_0x003a
        L_0x0039:
            r5 = 0
        L_0x003a:
            java.lang.String r1 = "Connection not obtained from this manager"
            p052cz.msebera.android.httpclient.util.Asserts.check(r5, r1)     // Catch:{ all -> 0x00d1 }
            monitor-enter(r4)     // Catch:{ all -> 0x00d1 }
            boolean r5 = r4.shutdown     // Catch:{ all -> 0x00ce }
            if (r5 == 0) goto L_0x004a
            r4.shutdownConnection(r0)     // Catch:{ all -> 0x00ce }
            monitor-exit(r4)     // Catch:{ all -> 0x00ce }
            monitor-exit(r0)     // Catch:{ all -> 0x00d1 }
            return
        L_0x004a:
            r5 = 0
            boolean r1 = r0.isOpen()     // Catch:{ all -> 0x00bd }
            if (r1 == 0) goto L_0x005a
            boolean r1 = r0.isMarkedReusable()     // Catch:{ all -> 0x00bd }
            if (r1 != 0) goto L_0x005a
            r4.shutdownConnection(r0)     // Catch:{ all -> 0x00bd }
        L_0x005a:
            boolean r1 = r0.isMarkedReusable()     // Catch:{ all -> 0x00bd }
            if (r1 == 0) goto L_0x00ab
            cz.msebera.android.httpclient.impl.conn.HttpPoolEntry r1 = r4.poolEntry     // Catch:{ all -> 0x00bd }
            if (r8 == 0) goto L_0x0066
            r2 = r8
            goto L_0x0068
        L_0x0066:
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00bd }
        L_0x0068:
            r1.updateExpiry(r6, r2)     // Catch:{ all -> 0x00bd }
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r1 = r4.log     // Catch:{ all -> 0x00bd }
            boolean r1 = r1.isDebugEnabled()     // Catch:{ all -> 0x00bd }
            if (r1 == 0) goto L_0x00ab
            r1 = 0
            int r3 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0093
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bd }
            r1.<init>()     // Catch:{ all -> 0x00bd }
            java.lang.String r2 = "for "
            r1.append(r2)     // Catch:{ all -> 0x00bd }
            r1.append(r6)     // Catch:{ all -> 0x00bd }
            java.lang.String r6 = " "
            r1.append(r6)     // Catch:{ all -> 0x00bd }
            r1.append(r8)     // Catch:{ all -> 0x00bd }
            java.lang.String r6 = r1.toString()     // Catch:{ all -> 0x00bd }
            goto L_0x0095
        L_0x0093:
            java.lang.String r6 = "indefinitely"
        L_0x0095:
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r7 = r4.log     // Catch:{ all -> 0x00bd }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bd }
            r8.<init>()     // Catch:{ all -> 0x00bd }
            java.lang.String r1 = "Connection can be kept alive "
            r8.append(r1)     // Catch:{ all -> 0x00bd }
            r8.append(r6)     // Catch:{ all -> 0x00bd }
            java.lang.String r6 = r8.toString()     // Catch:{ all -> 0x00bd }
            r7.debug(r6)     // Catch:{ all -> 0x00bd }
        L_0x00ab:
            r0.detach()     // Catch:{ all -> 0x00ce }
            r4.conn = r5     // Catch:{ all -> 0x00ce }
            cz.msebera.android.httpclient.impl.conn.HttpPoolEntry r6 = r4.poolEntry     // Catch:{ all -> 0x00ce }
            boolean r6 = r6.isClosed()     // Catch:{ all -> 0x00ce }
            if (r6 == 0) goto L_0x00ba
            r4.poolEntry = r5     // Catch:{ all -> 0x00ce }
        L_0x00ba:
            monitor-exit(r4)     // Catch:{ all -> 0x00ce }
            monitor-exit(r0)     // Catch:{ all -> 0x00d1 }
            return
        L_0x00bd:
            r6 = move-exception
            r0.detach()     // Catch:{ all -> 0x00ce }
            r4.conn = r5     // Catch:{ all -> 0x00ce }
            cz.msebera.android.httpclient.impl.conn.HttpPoolEntry r7 = r4.poolEntry     // Catch:{ all -> 0x00ce }
            boolean r7 = r7.isClosed()     // Catch:{ all -> 0x00ce }
            if (r7 == 0) goto L_0x00cd
            r4.poolEntry = r5     // Catch:{ all -> 0x00ce }
        L_0x00cd:
            throw r6     // Catch:{ all -> 0x00ce }
        L_0x00ce:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00ce }
            throw r5     // Catch:{ all -> 0x00d1 }
        L_0x00d1:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00d1 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p052cz.msebera.android.httpclient.impl.conn.BasicClientConnectionManager.releaseConnection(cz.msebera.android.httpclient.conn.ManagedClientConnection, long, java.util.concurrent.TimeUnit):void");
    }

    public void closeExpiredConnections() {
        synchronized (this) {
            assertNotShutdown();
            long currentTimeMillis = System.currentTimeMillis();
            if (this.poolEntry != null && this.poolEntry.isExpired(currentTimeMillis)) {
                this.poolEntry.close();
                this.poolEntry.getTracker().reset();
            }
        }
    }

    public void closeIdleConnections(long j, TimeUnit timeUnit) {
        Args.notNull(timeUnit, "Time unit");
        synchronized (this) {
            assertNotShutdown();
            long millis = timeUnit.toMillis(j);
            if (millis < 0) {
                millis = 0;
            }
            long currentTimeMillis = System.currentTimeMillis() - millis;
            if (this.poolEntry != null && this.poolEntry.getUpdated() <= currentTimeMillis) {
                this.poolEntry.close();
                this.poolEntry.getTracker().reset();
            }
        }
    }

    public void shutdown() {
        synchronized (this) {
            this.shutdown = true;
            try {
                if (this.poolEntry != null) {
                    this.poolEntry.close();
                }
            } finally {
                this.poolEntry = null;
                this.conn = null;
            }
        }
    }
}
