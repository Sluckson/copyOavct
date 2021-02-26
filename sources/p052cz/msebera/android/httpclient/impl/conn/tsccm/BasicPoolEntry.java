package p052cz.msebera.android.httpclient.impl.conn.tsccm;

import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;
import p052cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import p052cz.msebera.android.httpclient.conn.OperatedClientConnection;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoute;
import p052cz.msebera.android.httpclient.impl.conn.AbstractPoolEntry;
import p052cz.msebera.android.httpclient.util.Args;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.tsccm.BasicPoolEntry */
public class BasicPoolEntry extends AbstractPoolEntry {
    private final long created;
    private long expiry;
    private long updated;
    private final long validUntil;

    /* access modifiers changed from: protected */
    public final BasicPoolEntryRef getWeakRef() {
        return null;
    }

    public BasicPoolEntry(ClientConnectionOperator clientConnectionOperator, HttpRoute httpRoute, ReferenceQueue<Object> referenceQueue) {
        super(clientConnectionOperator, httpRoute);
        Args.notNull(httpRoute, "HTTP route");
        this.created = System.currentTimeMillis();
        this.validUntil = Long.MAX_VALUE;
        this.expiry = this.validUntil;
    }

    public BasicPoolEntry(ClientConnectionOperator clientConnectionOperator, HttpRoute httpRoute) {
        this(clientConnectionOperator, httpRoute, -1, TimeUnit.MILLISECONDS);
    }

    public BasicPoolEntry(ClientConnectionOperator clientConnectionOperator, HttpRoute httpRoute, long j, TimeUnit timeUnit) {
        super(clientConnectionOperator, httpRoute);
        Args.notNull(httpRoute, "HTTP route");
        this.created = System.currentTimeMillis();
        if (j > 0) {
            this.validUntil = this.created + timeUnit.toMillis(j);
        } else {
            this.validUntil = Long.MAX_VALUE;
        }
        this.expiry = this.validUntil;
    }

    /* access modifiers changed from: protected */
    public final OperatedClientConnection getConnection() {
        return this.connection;
    }

    /* access modifiers changed from: protected */
    public final HttpRoute getPlannedRoute() {
        return this.route;
    }

    /* access modifiers changed from: protected */
    public void shutdownEntry() {
        super.shutdownEntry();
    }

    public long getCreated() {
        return this.created;
    }

    public long getUpdated() {
        return this.updated;
    }

    public long getExpiry() {
        return this.expiry;
    }

    public long getValidUntil() {
        return this.validUntil;
    }

    public void updateExpiry(long j, TimeUnit timeUnit) {
        this.updated = System.currentTimeMillis();
        this.expiry = Math.min(this.validUntil, j > 0 ? this.updated + timeUnit.toMillis(j) : Long.MAX_VALUE);
    }

    public boolean isExpired(long j) {
        return j >= this.expiry;
    }
}
