package com.google.android.gms.internal.p010firebaseperf;

import android.util.Log;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzbj */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzbj {
    private static zzbj zzfk = null;
    private static String zzfl = "FirebasePerformance";

    public static synchronized zzbj zzcp() {
        zzbj zzbj;
        synchronized (zzbj.class) {
            if (zzfk == null) {
                zzfk = new zzbj();
            }
            zzbj = zzfk;
        }
        return zzbj;
    }

    static void zzm(String str) {
        Log.d(zzfl, str);
    }

    private zzbj() {
    }
}
