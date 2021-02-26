package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzfn {
    private final String zza;
    private final long zzb;
    private boolean zzc;
    private long zzd;
    private final /* synthetic */ zzfj zze;

    public zzfn(zzfj zzfj, String str, long j) {
        this.zze = zzfj;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = j;
    }

    @WorkerThread
    public final long zza() {
        if (!this.zzc) {
            this.zzc = true;
            this.zzd = this.zze.zzf().getLong(this.zza, this.zzb);
        }
        return this.zzd;
    }

    @WorkerThread
    public final void zza(long j) {
        SharedPreferences.Editor edit = this.zze.zzf().edit();
        edit.putLong(this.zza, j);
        edit.apply();
        this.zzd = j;
    }
}
