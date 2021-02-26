package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import androidx.annotation.MainThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzae;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzft {
    private final zzfs zza;

    public zzft(zzfs zzfs) {
        Preconditions.checkNotNull(zzfs);
        this.zza = zzfs;
    }

    public static boolean zza(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) == null || !receiverInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    @MainThread
    public final void zza(Context context, Intent intent) {
        zzex zzq = zzgb.zza(context, (zzae) null, (Long) null).zzq();
        if (intent == null) {
            zzq.zzh().zza("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        zzq.zzw().zza("Local receiver got", action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            zzq.zzw().zza("Starting wakeful intent.");
            this.zza.doStartService(context, className);
        } else if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
            zzq.zzh().zza("Install Referrer Broadcasts are deprecated");
        }
    }
}
