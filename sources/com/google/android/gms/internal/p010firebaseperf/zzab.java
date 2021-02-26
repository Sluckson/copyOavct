package com.google.android.gms.internal.p010firebaseperf;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzab */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzab {
    private final ConcurrentHashMap<zzae, List<Throwable>> zzu = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zzv = new ReferenceQueue<>();

    zzab() {
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        Reference<? extends Throwable> poll = this.zzv.poll();
        while (poll != null) {
            this.zzu.remove(poll);
            poll = this.zzv.poll();
        }
        List<Throwable> list = this.zzu.get(new zzae(th, (ReferenceQueue<Throwable>) null));
        if (list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.zzu.putIfAbsent(new zzae(th, this.zzv), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
