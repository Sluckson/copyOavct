package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzag */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzag extends zzay<Boolean> {
    private static zzag zzaf;

    private zzag() {
    }

    /* access modifiers changed from: protected */
    public final String zzn() {
        return "firebase_performance_collection_deactivated";
    }

    protected static synchronized zzag zzm() {
        zzag zzag;
        synchronized (zzag.class) {
            if (zzaf == null) {
                zzaf = new zzag();
            }
            zzag = zzaf;
        }
        return zzag;
    }
}
