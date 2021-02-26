package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;

/* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
final /* synthetic */ class zzjw implements Runnable {
    private final zzju zza;
    private final zzex zzb;
    private final JobParameters zzc;

    zzjw(zzju zzju, zzex zzex, JobParameters jobParameters) {
        this.zza = zzju;
        this.zzb = zzex;
        this.zzc = jobParameters;
    }

    public final void run() {
        this.zza.zza(this.zzb, this.zzc);
    }
}
