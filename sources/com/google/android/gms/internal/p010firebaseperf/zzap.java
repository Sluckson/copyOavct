package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzap */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzap extends zzay<String> {
    private static zzap zzas;

    protected zzap() {
    }

    /* access modifiers changed from: protected */
    public final String zzaj() {
        return "fpr_disabled_android_versions";
    }

    /* access modifiers changed from: protected */
    public final String zzak() {
        return "com.google.firebase.perf.SdkDisabledVersions";
    }

    protected static synchronized zzap zzar() {
        zzap zzap;
        synchronized (zzap.class) {
            if (zzas == null) {
                zzas = new zzap();
            }
            zzap = zzas;
        }
        return zzap;
    }
}
