package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzfx */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public class zzfx {
    private static final zzew zzmv = zzew.zzgw();
    private zzee zzsb;
    private volatile zzgs zzsc;
    private volatile zzee zzsd;

    public int hashCode() {
        return 1;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfx)) {
            return false;
        }
        zzfx zzfx = (zzfx) obj;
        zzgs zzgs = this.zzsc;
        zzgs zzgs2 = zzfx.zzsc;
        if (zzgs == null && zzgs2 == null) {
            return zzge().equals(zzfx.zzge());
        }
        if (zzgs != null && zzgs2 != null) {
            return zzgs.equals(zzgs2);
        }
        if (zzgs != null) {
            return zzgs.equals(zzfx.zzg(zzgs.zzhn()));
        }
        return zzg(zzgs2.zzhn()).equals(zzgs2);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(6:7|8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0012 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.google.android.gms.internal.p010firebaseperf.zzgs zzg(com.google.android.gms.internal.p010firebaseperf.zzgs r2) {
        /*
            r1 = this;
            com.google.android.gms.internal.firebase-perf.zzgs r0 = r1.zzsc
            if (r0 != 0) goto L_0x001d
            monitor-enter(r1)
            com.google.android.gms.internal.firebase-perf.zzgs r0 = r1.zzsc     // Catch:{ all -> 0x001a }
            if (r0 == 0) goto L_0x000b
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x000b:
            r1.zzsc = r2     // Catch:{ zzfs -> 0x0012 }
            com.google.android.gms.internal.firebase-perf.zzee r0 = com.google.android.gms.internal.p010firebaseperf.zzee.zzna     // Catch:{ zzfs -> 0x0012 }
            r1.zzsd = r0     // Catch:{ zzfs -> 0x0012 }
            goto L_0x0018
        L_0x0012:
            r1.zzsc = r2     // Catch:{ all -> 0x001a }
            com.google.android.gms.internal.firebase-perf.zzee r2 = com.google.android.gms.internal.p010firebaseperf.zzee.zzna     // Catch:{ all -> 0x001a }
            r1.zzsd = r2     // Catch:{ all -> 0x001a }
        L_0x0018:
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            goto L_0x001d
        L_0x001a:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x001a }
            throw r2
        L_0x001d:
            com.google.android.gms.internal.firebase-perf.zzgs r2 = r1.zzsc
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p010firebaseperf.zzfx.zzg(com.google.android.gms.internal.firebase-perf.zzgs):com.google.android.gms.internal.firebase-perf.zzgs");
    }

    public final zzgs zzh(zzgs zzgs) {
        zzgs zzgs2 = this.zzsc;
        this.zzsb = null;
        this.zzsd = null;
        this.zzsc = zzgs;
        return zzgs2;
    }

    public final int getSerializedSize() {
        if (this.zzsd != null) {
            return this.zzsd.size();
        }
        if (this.zzsc != null) {
            return this.zzsc.getSerializedSize();
        }
        return 0;
    }

    public final zzee zzge() {
        if (this.zzsd != null) {
            return this.zzsd;
        }
        synchronized (this) {
            if (this.zzsd != null) {
                zzee zzee = this.zzsd;
                return zzee;
            }
            if (this.zzsc == null) {
                this.zzsd = zzee.zzna;
            } else {
                this.zzsd = this.zzsc.zzge();
            }
            zzee zzee2 = this.zzsd;
            return zzee2;
        }
    }
}
