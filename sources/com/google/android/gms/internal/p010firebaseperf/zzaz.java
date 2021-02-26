package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzaz */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzaz extends zzay<Float> {
    private static zzaz zzbb;

    private zzaz() {
    }

    /* access modifiers changed from: protected */
    public final String zzaj() {
        return "fpr_vc_trace_sampling_rate";
    }

    /* access modifiers changed from: protected */
    public final String zzak() {
        return "com.google.firebase.perf.TraceSamplingRate";
    }

    protected static synchronized zzaz zzba() {
        zzaz zzaz;
        synchronized (zzaz.class) {
            if (zzbb == null) {
                zzbb = new zzaz();
            }
            zzaz = zzbb;
        }
        return zzaz;
    }
}
