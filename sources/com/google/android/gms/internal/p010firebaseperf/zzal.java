package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzal */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzal extends zzay<Long> {
    private static zzal zzao;

    private zzal() {
    }

    /* access modifiers changed from: protected */
    public final String zzaj() {
        return "fpr_rl_network_event_count_bg";
    }

    /* access modifiers changed from: protected */
    public final String zzak() {
        return "com.google.firebase.perf.NetworkEventCountBackground";
    }

    public static synchronized zzal zzan() {
        zzal zzal;
        synchronized (zzal.class) {
            if (zzao == null) {
                zzao = new zzal();
            }
            zzal = zzao;
        }
        return zzal;
    }
}
