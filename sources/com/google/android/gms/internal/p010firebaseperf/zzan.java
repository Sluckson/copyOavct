package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzan */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzan extends zzay<Float> {
    private static zzan zzaq;

    private zzan() {
    }

    /* access modifiers changed from: protected */
    public final String zzaj() {
        return "fpr_vc_network_request_sampling_rate";
    }

    /* access modifiers changed from: protected */
    public final String zzak() {
        return "com.google.firebase.perf.NetworkRequestSamplingRate";
    }

    protected static synchronized zzan zzap() {
        zzan zzan;
        synchronized (zzan.class) {
            if (zzaq == null) {
                zzaq = new zzan();
            }
            zzan = zzaq;
        }
        return zzan;
    }
}
