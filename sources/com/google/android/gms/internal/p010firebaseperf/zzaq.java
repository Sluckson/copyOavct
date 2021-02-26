package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzaq */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzaq extends zzay<Long> {
    private static zzaq zzat;

    private zzaq() {
    }

    /* access modifiers changed from: protected */
    public final String zzaj() {
        return "fpr_session_gauge_cpu_capture_frequency_fg_ms";
    }

    /* access modifiers changed from: protected */
    public final String zzak() {
        return "com.google.firebase.perf.SessionsCpuCaptureFrequencyForegroundMs";
    }

    /* access modifiers changed from: protected */
    public final String zzn() {
        return "sessions_cpu_capture_frequency_fg_ms";
    }

    public static synchronized zzaq zzas() {
        zzaq zzaq;
        synchronized (zzaq.class) {
            if (zzat == null) {
                zzat = new zzaq();
            }
            zzaq = zzat;
        }
        return zzaq;
    }
}
