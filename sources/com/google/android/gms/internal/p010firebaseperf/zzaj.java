package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzaj */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzaj extends zzay<Boolean> {
    private static zzaj zzam;

    private zzaj() {
    }

    /* access modifiers changed from: protected */
    public final String zzak() {
        return "isEnabled";
    }

    /* access modifiers changed from: protected */
    public final String zzn() {
        return "firebase_performance_collection_enabled";
    }

    protected static synchronized zzaj zzal() {
        zzaj zzaj;
        synchronized (zzaj.class) {
            if (zzam == null) {
                zzam = new zzaj();
            }
            zzaj = zzam;
        }
        return zzaj;
    }
}
