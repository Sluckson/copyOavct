package com.google.android.gms.internal.p010firebaseperf;

import com.google.firebase.perf.internal.zzb;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzai */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzai extends zzay<String> {
    private static zzai zzak;
    private static final zzo<Long, String> zzal = zzo.zza(461L, "FIREPERF_AUTOPUSH", 462L, zzb.zzcr, 675L, "FIREPERF_INTERNAL_LOW", 676L, "FIREPERF_INTERNAL_HIGH");

    private zzai() {
    }

    /* access modifiers changed from: protected */
    public final String zzaj() {
        return "fpr_log_source";
    }

    /* access modifiers changed from: protected */
    public final String zzak() {
        return "com.google.firebase.perf.LogSourceName";
    }

    public static synchronized zzai zzah() {
        zzai zzai;
        synchronized (zzai.class) {
            if (zzak == null) {
                zzak = new zzai();
            }
            zzai = zzak;
        }
        return zzai;
    }

    protected static String zzf(long j) {
        return zzal.get(Long.valueOf(j));
    }

    protected static boolean zzg(long j) {
        return zzal.containsKey(Long.valueOf(j));
    }

    protected static String zzai() {
        return zzb.zzcr;
    }
}
