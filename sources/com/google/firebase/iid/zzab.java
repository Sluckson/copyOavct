package com.google.firebase.iid;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.firebase_messaging.zza;
import com.google.android.gms.internal.firebase_messaging.zzf;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.firebase:firebase-iid@@20.2.1 */
public final class zzab {
    @GuardedBy("MessengerIpcClient.class")
    private static zzab zza;
    /* access modifiers changed from: private */
    public final Context zzb;
    /* access modifiers changed from: private */
    public final ScheduledExecutorService zzc;
    @GuardedBy("this")
    private zzac zzd = new zzac(this);
    @GuardedBy("this")
    private int zze = 1;

    public static synchronized zzab zza(Context context) {
        zzab zzab;
        synchronized (zzab.class) {
            if (zza == null) {
                zza = new zzab(context, zza.zza().zza(1, new NamedThreadFactory("MessengerIpcClient"), zzf.zzb));
            }
            zzab = zza;
        }
        return zzab;
    }

    @VisibleForTesting
    private zzab(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzc = scheduledExecutorService;
        this.zzb = context.getApplicationContext();
    }

    public final Task<Void> zza(int i, Bundle bundle) {
        return zza(new zzak(zza(), 2, bundle));
    }

    public final Task<Bundle> zzb(int i, Bundle bundle) {
        return zza(new zzap(zza(), 1, bundle));
    }

    private final synchronized <T> Task<T> zza(zzan<T> zzan) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(zzan);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 9);
            sb.append("Queueing ");
            sb.append(valueOf);
            Log.d("MessengerIpcClient", sb.toString());
        }
        if (!this.zzd.zza((zzan<?>) zzan)) {
            this.zzd = new zzac(this);
            this.zzd.zza((zzan<?>) zzan);
        }
        return zzan.zzb.getTask();
    }

    private final synchronized int zza() {
        int i;
        i = this.zze;
        this.zze = i + 1;
        return i;
    }
}
