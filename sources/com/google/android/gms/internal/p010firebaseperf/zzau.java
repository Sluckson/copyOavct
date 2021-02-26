package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzau */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzau extends zzay<Float> {
    private static zzau zzax;

    private zzau() {
    }

    /* access modifiers changed from: protected */
    public final String zzaj() {
        return "fpr_vc_session_sampling_rate";
    }

    /* access modifiers changed from: protected */
    public final String zzak() {
        return "com.google.firebase.perf.SessionSamplingRate";
    }

    /* access modifiers changed from: protected */
    public final String zzn() {
        return "sessions_sampling_percentage";
    }

    public static synchronized zzau zzaw() {
        zzau zzau;
        synchronized (zzau.class) {
            if (zzax == null) {
                zzax = new zzau();
            }
            zzau = zzax;
        }
        return zzau;
    }
}
