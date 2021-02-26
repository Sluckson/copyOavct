package com.google.android.gms.internal.p010firebaseperf;

import androidx.annotation.VisibleForTesting;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzbi */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzbi {
    private static zzbi zzff;
    private boolean zzdi;
    private zzbj zzfg;

    public static synchronized zzbi zzcl() {
        zzbi zzbi;
        synchronized (zzbi.class) {
            if (zzff == null) {
                zzff = new zzbi();
            }
            zzbi = zzff;
        }
        return zzbi;
    }

    @VisibleForTesting
    private zzbi(zzbj zzbj) {
        this.zzdi = false;
        this.zzfg = zzbj.zzcp();
    }

    private zzbi() {
        this((zzbj) null);
    }

    public final void zze(boolean z) {
        this.zzdi = z;
    }

    public final void zzm(String str) {
        if (this.zzdi) {
            zzbj.zzm(str);
        }
    }
}
