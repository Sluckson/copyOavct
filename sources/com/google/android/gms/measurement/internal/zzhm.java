package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzhm implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ Object zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ zzhe zze;

    zzhm(zzhe zzhe, String str, String str2, Object obj, long j) {
        this.zze = zzhe;
        this.zza = str;
        this.zzb = str2;
        this.zzc = obj;
        this.zzd = j;
    }

    public final void run() {
        this.zze.zza(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
