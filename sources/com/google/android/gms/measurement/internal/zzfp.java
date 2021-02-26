package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzfp {
    private final String zza;
    private final String zzb = null;
    private boolean zzc;
    private String zzd;
    private final /* synthetic */ zzfj zze;

    public zzfp(zzfj zzfj, String str, String str2) {
        this.zze = zzfj;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
    }

    @WorkerThread
    public final String zza() {
        if (!this.zzc) {
            this.zzc = true;
            this.zzd = this.zze.zzf().getString(this.zza, (String) null);
        }
        return this.zzd;
    }

    @WorkerThread
    public final void zza(String str) {
        SharedPreferences.Editor edit = this.zze.zzf().edit();
        edit.putString(this.zza, str);
        edit.apply();
        this.zzd = str;
    }
}
