package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzne;
import com.google.android.gms.internal.measurement.zznf;
import kotlinx.coroutines.DebugKt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzkh {
    @VisibleForTesting
    private long zza;
    @VisibleForTesting
    private long zzb;
    private final zzaj zzc = new zzkg(this, this.zzd.zzy);
    private final /* synthetic */ zzkb zzd;

    public zzkh(zzkb zzkb) {
        this.zzd = zzkb;
        this.zza = zzkb.zzl().elapsedRealtime();
        this.zzb = this.zza;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zza(long j) {
        this.zzd.zzc();
        this.zzc.zzc();
        this.zza = j;
        this.zzb = this.zza;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final void zzb(long j) {
        this.zzc.zzc();
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        this.zzc.zzc();
        this.zza = 0;
        this.zzb = this.zza;
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzc() {
        this.zzd.zzc();
        zza(false, false, this.zzd.zzl().elapsedRealtime());
        this.zzd.zzd().zza(this.zzd.zzl().elapsedRealtime());
    }

    @WorkerThread
    public final boolean zza(boolean z, boolean z2, long j) {
        this.zzd.zzc();
        this.zzd.zzv();
        if (!zzne.zzb() || !this.zzd.zzs().zza(zzat.zzbr) || this.zzd.zzy.zzaa()) {
            this.zzd.zzr().zzp.zza(this.zzd.zzl().currentTimeMillis());
        }
        long j2 = j - this.zza;
        if (z || j2 >= 1000) {
            if (this.zzd.zzs().zza(zzat.zzat) && !z2) {
                j2 = (!zznf.zzb() || !this.zzd.zzs().zza(zzat.zzav)) ? zzb() : zzc(j);
            }
            this.zzd.zzq().zzw().zza("Recording user engagement, ms", Long.valueOf(j2));
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j2);
            zzim.zza(this.zzd.zzh().zza(!this.zzd.zzs().zzh().booleanValue()), bundle, true);
            if (this.zzd.zzs().zza(zzat.zzat) && !this.zzd.zzs().zza(zzat.zzau) && z2) {
                bundle.putLong("_fr", 1);
            }
            if (!this.zzd.zzs().zza(zzat.zzau) || !z2) {
                this.zzd.zze().zza(DebugKt.DEBUG_PROPERTY_VALUE_AUTO, "_e", bundle);
            }
            this.zza = j;
            this.zzc.zzc();
            this.zzc.zza(3600000);
            return true;
        }
        this.zzd.zzq().zzw().zza("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(j2));
        return false;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final long zzb() {
        long elapsedRealtime = this.zzd.zzl().elapsedRealtime();
        long j = elapsedRealtime - this.zzb;
        this.zzb = elapsedRealtime;
        return j;
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    @VisibleForTesting
    public final long zzc(long j) {
        long j2 = j - this.zzb;
        this.zzb = j;
        return j2;
    }
}
