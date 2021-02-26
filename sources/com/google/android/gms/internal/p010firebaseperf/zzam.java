package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzam */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzam extends zzay<Long> {
    private static zzam zzap;

    private zzam() {
    }

    /* access modifiers changed from: protected */
    public final String zzaj() {
        return "fpr_rl_time_limit_sec";
    }

    /* access modifiers changed from: protected */
    public final String zzak() {
        return "com.google.firebase.perf.TimeLimitSec";
    }

    public static synchronized zzam zzao() {
        zzam zzam;
        synchronized (zzam.class) {
            if (zzap == null) {
                zzap = new zzam();
            }
            zzam = zzap;
        }
        return zzam;
    }
}
