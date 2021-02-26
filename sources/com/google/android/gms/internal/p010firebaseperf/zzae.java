package com.google.android.gms.internal.p010firebaseperf;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzae */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzae extends WeakReference<Throwable> {
    private final int zzy;

    public zzae(Throwable th, ReferenceQueue<Throwable> referenceQueue) {
        super(th, referenceQueue);
        if (th != null) {
            this.zzy = System.identityHashCode(th);
            return;
        }
        throw new NullPointerException("The referent cannot be null");
    }

    public final int hashCode() {
        return this.zzy;
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (this == obj) {
                return true;
            }
            zzae zzae = (zzae) obj;
            return this.zzy == zzae.zzy && get() == zzae.get();
        }
    }
}
