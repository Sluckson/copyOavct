package com.google.firebase.analytics;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement-api@@17.5.0 */
final class zzc implements Callable<String> {
    private final /* synthetic */ FirebaseAnalytics zza;

    zzc(FirebaseAnalytics firebaseAnalytics) {
        this.zza = firebaseAnalytics;
    }

    public final /* synthetic */ Object call() throws Exception {
        String zza2 = this.zza.zzb();
        if (zza2 != null) {
            return zza2;
        }
        String zzh = this.zza.zzb.zzh();
        this.zza.zza(zzh);
        return zzh;
    }
}
