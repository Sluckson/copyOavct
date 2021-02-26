package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import androidx.annotation.MainThread;
import com.google.android.gms.measurement.internal.zzju;
import com.google.android.gms.measurement.internal.zzjy;

/* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
public final class AppMeasurementService extends Service implements zzjy {
    private zzju<AppMeasurementService> zza;

    private final zzju<AppMeasurementService> zza() {
        if (this.zza == null) {
            this.zza = new zzju<>(this);
        }
        return this.zza;
    }

    @MainThread
    public final void onCreate() {
        super.onCreate();
        zza().zza();
    }

    @MainThread
    public final void onDestroy() {
        zza().zzb();
        super.onDestroy();
    }

    @MainThread
    public final int onStartCommand(Intent intent, int i, int i2) {
        return zza().zza(intent, i, i2);
    }

    @MainThread
    public final IBinder onBind(Intent intent) {
        return zza().zza(intent);
    }

    @MainThread
    public final boolean onUnbind(Intent intent) {
        return zza().zzb(intent);
    }

    @MainThread
    public final void onRebind(Intent intent) {
        zza().zzc(intent);
    }

    public final boolean zza(int i) {
        return stopSelfResult(i);
    }

    public final void zza(JobParameters jobParameters, boolean z) {
        throw new UnsupportedOperationException();
    }

    public final void zza(Intent intent) {
        AppMeasurementReceiver.completeWakefulIntent(intent);
    }
}
