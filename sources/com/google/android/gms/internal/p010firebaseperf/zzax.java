package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzax */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzax extends zzay<Long> {
    private static zzax zzba;

    private zzax() {
    }

    /* access modifiers changed from: protected */
    public final String zzaj() {
        return "fpr_rl_trace_event_count_bg";
    }

    /* access modifiers changed from: protected */
    public final String zzak() {
        return "com.google.firebase.perf.TraceEventCountBackground";
    }

    public static synchronized zzax zzaz() {
        zzax zzax;
        synchronized (zzax.class) {
            if (zzba == null) {
                zzba = new zzax();
            }
            zzax = zzba;
        }
        return zzax;
    }
}
