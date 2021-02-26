package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.MainThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzae;
import com.google.android.gms.measurement.internal.zzjy;

/* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
public final class zzju<T extends Context & zzjy> {
    private final T zza;

    public zzju(T t) {
        Preconditions.checkNotNull(t);
        this.zza = t;
    }

    @MainThread
    public final void zza() {
        zzgb.zza(this.zza, (zzae) null, (Long) null).zzq().zzw().zza("Local AppMeasurementService is starting up");
    }

    @MainThread
    public final void zzb() {
        zzgb.zza(this.zza, (zzae) null, (Long) null).zzq().zzw().zza("Local AppMeasurementService is shutting down");
    }

    @MainThread
    public final int zza(Intent intent, int i, int i2) {
        zzex zzq = zzgb.zza(this.zza, (zzae) null, (Long) null).zzq();
        if (intent == null) {
            zzq.zzh().zza("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        zzq.zzw().zza("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            zza((Runnable) new zzjx(this, i2, zzq, intent));
        }
        return 2;
    }

    private final void zza(Runnable runnable) {
        zzkp zza2 = zzkp.zza((Context) this.zza);
        zza2.zzp().zza((Runnable) new zzjz(this, zza2, runnable));
    }

    @MainThread
    public final IBinder zza(Intent intent) {
        if (intent == null) {
            zzc().zze().zza("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new zzgc(zzkp.zza((Context) this.zza));
        }
        zzc().zzh().zza("onBind received unknown action", action);
        return null;
    }

    @MainThread
    public final boolean zzb(Intent intent) {
        if (intent == null) {
            zzc().zze().zza("onUnbind called with null intent");
            return true;
        }
        zzc().zzw().zza("onUnbind called for intent. action", intent.getAction());
        return true;
    }

    @TargetApi(24)
    @MainThread
    public final boolean zza(JobParameters jobParameters) {
        zzex zzq = zzgb.zza(this.zza, (zzae) null, (Long) null).zzq();
        String string = jobParameters.getExtras().getString("action");
        zzq.zzw().zza("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        zza((Runnable) new zzjw(this, zzq, jobParameters));
        return true;
    }

    @MainThread
    public final void zzc(Intent intent) {
        if (intent == null) {
            zzc().zze().zza("onRebind called with null intent");
            return;
        }
        zzc().zzw().zza("onRebind called. action", intent.getAction());
    }

    private final zzex zzc() {
        return zzgb.zza(this.zza, (zzae) null, (Long) null).zzq();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzex zzex, JobParameters jobParameters) {
        zzex.zzw().zza("AppMeasurementJobService processed last upload request.");
        ((zzjy) this.zza).zza(jobParameters, false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(int i, zzex zzex, Intent intent) {
        if (((zzjy) this.zza).zza(i)) {
            zzex.zzw().zza("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            zzc().zzw().zza("Completed wakeful intent.");
            ((zzjy) this.zza).zza(intent);
        }
    }
}
