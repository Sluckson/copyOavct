package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
final class zzgv implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ long zzd;
    private final /* synthetic */ zzgc zze;

    zzgv(zzgc zzgc, String str, String str2, String str3, long j) {
        this.zze = zzgc;
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = j;
    }

    public final void run() {
        String str = this.zza;
        if (str == null) {
            this.zze.zza.zzu().zzu().zza(this.zzb, (zzin) null);
            return;
        }
        this.zze.zza.zzu().zzu().zza(this.zzb, new zzin(this.zzc, str, this.zzd));
    }
}
