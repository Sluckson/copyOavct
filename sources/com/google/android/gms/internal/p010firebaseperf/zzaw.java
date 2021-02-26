package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzaw */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzaw extends zzay<Long> {
    private static zzaw zzaz;

    private zzaw() {
    }

    /* access modifiers changed from: protected */
    public final String zzaj() {
        return "fpr_rl_trace_event_count_fg";
    }

    /* access modifiers changed from: protected */
    public final String zzak() {
        return "com.google.firebase.perf.TraceEventCountForeground";
    }

    public static synchronized zzaw zzay() {
        zzaw zzaw;
        synchronized (zzaw.class) {
            if (zzaz == null) {
                zzaz = new zzaw();
            }
            zzaw = zzaz;
        }
        return zzaw;
    }
}
