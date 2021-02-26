package p052cz.msebera.android.httpclient.impl.conn.tsccm;

import java.util.LinkedList;
import java.util.Queue;
import p052cz.msebera.android.httpclient.conn.params.ConnPerRoute;
import p052cz.msebera.android.httpclient.conn.routing.HttpRoute;
import p052cz.msebera.android.httpclient.extras.HttpClientAndroidLog;
import p052cz.msebera.android.httpclient.util.Args;
import p052cz.msebera.android.httpclient.util.Asserts;

@Deprecated
/* renamed from: cz.msebera.android.httpclient.impl.conn.tsccm.RouteSpecificPool */
public class RouteSpecificPool {
    protected final ConnPerRoute connPerRoute;
    protected final LinkedList<BasicPoolEntry> freeEntries;
    public HttpClientAndroidLog log = new HttpClientAndroidLog(getClass());
    protected final int maxEntries;
    protected int numEntries;
    protected final HttpRoute route;
    protected final Queue<WaitingThread> waitingThreads;

    @Deprecated
    public RouteSpecificPool(HttpRoute httpRoute, int i) {
        this.route = httpRoute;
        this.maxEntries = i;
        this.connPerRoute = new ConnPerRoute() {
            public int getMaxForRoute(HttpRoute httpRoute) {
                return RouteSpecificPool.this.maxEntries;
            }
        };
        this.freeEntries = new LinkedList<>();
        this.waitingThreads = new LinkedList();
        this.numEntries = 0;
    }

    public RouteSpecificPool(HttpRoute httpRoute, ConnPerRoute connPerRoute2) {
        this.route = httpRoute;
        this.connPerRoute = connPerRoute2;
        this.maxEntries = connPerRoute2.getMaxForRoute(httpRoute);
        this.freeEntries = new LinkedList<>();
        this.waitingThreads = new LinkedList();
        this.numEntries = 0;
    }

    public final HttpRoute getRoute() {
        return this.route;
    }

    public final int getMaxEntries() {
        return this.maxEntries;
    }

    public boolean isUnused() {
        return this.numEntries < 1 && this.waitingThreads.isEmpty();
    }

    public int getCapacity() {
        return this.connPerRoute.getMaxForRoute(this.route) - this.numEntries;
    }

    public final int getEntryCount() {
        return this.numEntries;
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public p052cz.msebera.android.httpclient.impl.conn.tsccm.BasicPoolEntry allocEntry(java.lang.Object r4) {
        /*
            r3 = this;
            java.util.LinkedList<cz.msebera.android.httpclient.impl.conn.tsccm.BasicPoolEntry> r0 = r3.freeEntries
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0032
            java.util.LinkedList<cz.msebera.android.httpclient.impl.conn.tsccm.BasicPoolEntry> r0 = r3.freeEntries
            int r1 = r0.size()
            java.util.ListIterator r0 = r0.listIterator(r1)
        L_0x0012:
            boolean r1 = r0.hasPrevious()
            if (r1 == 0) goto L_0x0032
            java.lang.Object r1 = r0.previous()
            cz.msebera.android.httpclient.impl.conn.tsccm.BasicPoolEntry r1 = (p052cz.msebera.android.httpclient.impl.conn.tsccm.BasicPoolEntry) r1
            java.lang.Object r2 = r1.getState()
            if (r2 == 0) goto L_0x002e
            java.lang.Object r2 = r1.getState()
            boolean r2 = p052cz.msebera.android.httpclient.util.LangUtils.equals((java.lang.Object) r4, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x0012
        L_0x002e:
            r0.remove()
            return r1
        L_0x0032:
            int r4 = r3.getCapacity()
            if (r4 != 0) goto L_0x005c
            java.util.LinkedList<cz.msebera.android.httpclient.impl.conn.tsccm.BasicPoolEntry> r4 = r3.freeEntries
            boolean r4 = r4.isEmpty()
            if (r4 != 0) goto L_0x005c
            java.util.LinkedList<cz.msebera.android.httpclient.impl.conn.tsccm.BasicPoolEntry> r4 = r3.freeEntries
            java.lang.Object r4 = r4.remove()
            cz.msebera.android.httpclient.impl.conn.tsccm.BasicPoolEntry r4 = (p052cz.msebera.android.httpclient.impl.conn.tsccm.BasicPoolEntry) r4
            r4.shutdownEntry()
            cz.msebera.android.httpclient.conn.OperatedClientConnection r0 = r4.getConnection()
            r0.close()     // Catch:{ IOException -> 0x0053 }
            goto L_0x005b
        L_0x0053:
            r0 = move-exception
            cz.msebera.android.httpclient.extras.HttpClientAndroidLog r1 = r3.log
            java.lang.String r2 = "I/O error closing connection"
            r1.debug(r2, r0)
        L_0x005b:
            return r4
        L_0x005c:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p052cz.msebera.android.httpclient.impl.conn.tsccm.RouteSpecificPool.allocEntry(java.lang.Object):cz.msebera.android.httpclient.impl.conn.tsccm.BasicPoolEntry");
    }

    public void freeEntry(BasicPoolEntry basicPoolEntry) {
        int i = this.numEntries;
        if (i < 1) {
            throw new IllegalStateException("No entry created for this pool. " + this.route);
        } else if (i > this.freeEntries.size()) {
            this.freeEntries.add(basicPoolEntry);
        } else {
            throw new IllegalStateException("No entry allocated from this pool. " + this.route);
        }
    }

    public void createdEntry(BasicPoolEntry basicPoolEntry) {
        Args.check(this.route.equals(basicPoolEntry.getPlannedRoute()), "Entry not planned for this pool");
        this.numEntries++;
    }

    public boolean deleteEntry(BasicPoolEntry basicPoolEntry) {
        boolean remove = this.freeEntries.remove(basicPoolEntry);
        if (remove) {
            this.numEntries--;
        }
        return remove;
    }

    public void dropEntry() {
        Asserts.check(this.numEntries > 0, "There is no entry that could be dropped");
        this.numEntries--;
    }

    public void queueThread(WaitingThread waitingThread) {
        Args.notNull(waitingThread, "Waiting thread");
        this.waitingThreads.add(waitingThread);
    }

    public boolean hasThread() {
        return !this.waitingThreads.isEmpty();
    }

    public WaitingThread nextThread() {
        return this.waitingThreads.peek();
    }

    public void removeThread(WaitingThread waitingThread) {
        if (waitingThread != null) {
            this.waitingThreads.remove(waitingThread);
        }
    }
}
