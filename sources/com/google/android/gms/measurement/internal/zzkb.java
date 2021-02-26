package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzq;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzkb extends zzg {
    protected final zzkj zza = new zzkj(this);
    protected final zzkh zzb = new zzkh(this);
    /* access modifiers changed from: private */
    public Handler zzc;
    private final zzkc zzd = new zzkc(this);

    zzkb(zzgb zzgb) {
        super(zzgb);
    }

    /* access modifiers changed from: protected */
    public final boolean zzy() {
        return false;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzaa() {
        zzc();
        if (this.zzc == null) {
            this.zzc = new zzq(Looper.getMainLooper());
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzb(long j) {
        zzc();
        zzaa();
        zzq().zzw().zza("Activity resumed, time", Long.valueOf(j));
        if (zzs().zza(zzat.zzbw)) {
            if (zzs().zzh().booleanValue() || zzr().zzr.zza()) {
                this.zzb.zza(j);
            }
            this.zzd.zza();
        } else {
            this.zzd.zza();
            if (zzs().zzh().booleanValue()) {
                this.zzb.zza(j);
            }
        }
        zzkj zzkj = this.zza;
        zzkj.zza.zzc();
        if (zzkj.zza.zzy.zzaa()) {
            if (!zzkj.zza.zzs().zza(zzat.zzbw)) {
                zzkj.zza.zzr().zzr.zza(false);
            }
            zzkj.zza(zzkj.zza.zzl().currentTimeMillis(), false);
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzc(long j) {
        zzc();
        zzaa();
        zzq().zzw().zza("Activity paused, time", Long.valueOf(j));
        this.zzd.zza(j);
        if (zzs().zzh().booleanValue()) {
            this.zzb.zzb(j);
        }
        zzkj zzkj = this.zza;
        if (!zzkj.zza.zzs().zza(zzat.zzbw)) {
            zzkj.zza.zzr().zzr.zza(true);
        }
    }

    public final boolean zza(boolean z, boolean z2, long j) {
        return this.zzb.zza(z, z2, j);
    }

    /* access modifiers changed from: package-private */
    public final long zza(long j) {
        return this.zzb.zzc(j);
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ zza zzd() {
        return super.zzd();
    }

    public final /* bridge */ /* synthetic */ zzhe zze() {
        return super.zze();
    }

    public final /* bridge */ /* synthetic */ zzeq zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zziv zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzim zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zzet zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzkb zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzal zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ zzev zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzkx zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzfu zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzex zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzfj zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzy zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }
}
