package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzat */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzat extends zzay<Long> {
    private static zzat zzaw;

    private zzat() {
    }

    /* access modifiers changed from: protected */
    public final String zzaj() {
        return "fpr_session_max_duration_min";
    }

    /* access modifiers changed from: protected */
    public final String zzak() {
        return "com.google.firebase.perf.SessionsMaxDurationMinutes";
    }

    /* access modifiers changed from: protected */
    public final String zzn() {
        return "sessions_max_length_minutes";
    }

    public static synchronized zzat zzav() {
        zzat zzat;
        synchronized (zzat.class) {
            if (zzaw == null) {
                zzaw = new zzat();
            }
            zzat = zzaw;
        }
        return zzat;
    }
}
