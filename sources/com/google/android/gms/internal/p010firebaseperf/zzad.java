package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzad */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzad extends zzac {
    private final zzab zzx = new zzab();

    zzad() {
    }

    public final void zza(Throwable th, Throwable th2) {
        if (th2 == th) {
            throw new IllegalArgumentException("Self suppression is not allowed.", th2);
        } else if (th2 != null) {
            this.zzx.zza(th, true).add(th2);
        } else {
            throw new NullPointerException("The suppressed exception cannot be null.");
        }
    }
}
