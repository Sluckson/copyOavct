package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzas */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzas extends zzay<Long> {
    private static zzas zzav;

    private zzas() {
    }

    /* access modifiers changed from: protected */
    public final String zzaj() {
        return "fpr_session_gauge_memory_capture_frequency_bg_ms";
    }

    /* access modifiers changed from: protected */
    public final String zzak() {
        return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyBackgroundMs";
    }

    /* access modifiers changed from: protected */
    public final String zzn() {
        return "sessions_memory_capture_frequency_bg_ms";
    }

    public static synchronized zzas zzau() {
        zzas zzas;
        synchronized (zzas.class) {
            if (zzav == null) {
                zzav = new zzas();
            }
            zzas = zzav;
        }
        return zzas;
    }
}
