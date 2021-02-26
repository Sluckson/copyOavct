package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzak */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzak extends zzay<Long> {
    private static zzak zzan;

    private zzak() {
    }

    /* access modifiers changed from: protected */
    public final String zzaj() {
        return "fpr_rl_network_event_count_fg";
    }

    /* access modifiers changed from: protected */
    public final String zzak() {
        return "com.google.firebase.perf.NetworkEventCountForeground";
    }

    public static synchronized zzak zzam() {
        zzak zzak;
        synchronized (zzak.class) {
            if (zzan == null) {
                zzan = new zzak();
            }
            zzak = zzan;
        }
        return zzak;
    }
}
