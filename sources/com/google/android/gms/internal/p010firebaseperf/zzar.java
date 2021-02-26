package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzar */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzar extends zzay<Long> {
    private static zzar zzau;

    private zzar() {
    }

    /* access modifiers changed from: protected */
    public final String zzaj() {
        return "fpr_session_gauge_cpu_capture_frequency_bg_ms";
    }

    /* access modifiers changed from: protected */
    public final String zzak() {
        return "com.google.firebase.perf.SessionsCpuCaptureFrequencyBackgroundMs";
    }

    /* access modifiers changed from: protected */
    public final String zzn() {
        return "sessions_cpu_capture_frequency_bg_ms";
    }

    public static synchronized zzar zzat() {
        zzar zzar;
        synchronized (zzar.class) {
            if (zzau == null) {
                zzau = new zzar();
            }
            zzar = zzau;
        }
        return zzar;
    }
}
