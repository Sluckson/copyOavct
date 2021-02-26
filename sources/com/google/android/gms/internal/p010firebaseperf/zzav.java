package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzav */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzav extends zzay<Long> {
    private static zzav zzay;

    private zzav() {
    }

    /* access modifiers changed from: protected */
    public final String zzaj() {
        return "fpr_session_gauge_memory_capture_frequency_fg_ms";
    }

    /* access modifiers changed from: protected */
    public final String zzak() {
        return "com.google.firebase.perf.SessionsMemoryCaptureFrequencyForegroundMs";
    }

    /* access modifiers changed from: protected */
    public final String zzn() {
        return "sessions_memory_capture_frequency_fg_ms";
    }

    public static synchronized zzav zzax() {
        zzav zzav;
        synchronized (zzav.class) {
            if (zzay == null) {
                zzay = new zzav();
            }
            zzav = zzay;
        }
        return zzav;
    }
}
