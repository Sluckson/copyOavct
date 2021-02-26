package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzao */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzao extends zzay<Boolean> {
    private static zzao zzar;

    protected zzao() {
    }

    /* access modifiers changed from: protected */
    public final String zzaj() {
        return "fpr_enabled";
    }

    /* access modifiers changed from: protected */
    public final String zzak() {
        return "com.google.firebase.perf.SdkEnabled";
    }

    protected static synchronized zzao zzaq() {
        zzao zzao;
        synchronized (zzao.class) {
            if (zzar == null) {
                zzar = new zzao();
            }
            zzao = zzar;
        }
        return zzao;
    }
}
