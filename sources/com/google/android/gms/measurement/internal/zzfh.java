package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.MainThread;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;

/* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
class zzfh extends BroadcastReceiver {
    @VisibleForTesting
    private static final String zza = "com.google.android.gms.measurement.internal.zzfh";
    /* access modifiers changed from: private */
    public final zzkp zzb;
    private boolean zzc;
    private boolean zzd;

    zzfh(zzkp zzkp) {
        Preconditions.checkNotNull(zzkp);
        this.zzb = zzkp;
    }

    @MainThread
    public void onReceive(Context context, Intent intent) {
        this.zzb.zzn();
        String action = intent.getAction();
        this.zzb.zzq().zzw().zza("NetworkBroadcastReceiver received action", action);
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            boolean zze = this.zzb.zzd().zze();
            if (this.zzd != zze) {
                this.zzd = zze;
                this.zzb.zzp().zza((Runnable) new zzfg(this, zze));
                return;
            }
            return;
        }
        this.zzb.zzq().zzh().zza("NetworkBroadcastReceiver received unknown action", action);
    }

    @WorkerThread
    public final void zza() {
        this.zzb.zzn();
        this.zzb.zzp().zzc();
        if (!this.zzc) {
            this.zzb.zzm().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.zzd = this.zzb.zzd().zze();
            this.zzb.zzq().zzw().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzd));
            this.zzc = true;
        }
    }

    @WorkerThread
    public final void zzb() {
        this.zzb.zzn();
        this.zzb.zzp().zzc();
        this.zzb.zzp().zzc();
        if (this.zzc) {
            this.zzb.zzq().zzw().zza("Unregistering connectivity change receiver");
            this.zzc = false;
            this.zzd = false;
            try {
                this.zzb.zzm().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.zzb.zzq().zze().zza("Failed to unregister the network broadcast receiver", e);
            }
        }
    }
}
