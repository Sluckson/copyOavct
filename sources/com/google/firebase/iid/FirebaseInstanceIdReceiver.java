package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: com.google.firebase:firebase-iid@@20.2.1 */
public final class FirebaseInstanceIdReceiver extends WakefulBroadcastReceiver {
    private final ExecutorService zza = zzh.zzb();

    public final void onReceive(@NonNull Context context, @NonNull Intent intent) {
        zzb zzb;
        if (intent != null) {
            Parcelable parcelableExtra = intent.getParcelableExtra("wrapped_intent");
            Intent intent2 = parcelableExtra instanceof Intent ? (Intent) parcelableExtra : null;
            if (intent2 != null) {
                intent = intent2;
            }
            intent.setComponent((ComponentName) null);
            intent.setPackage(context.getPackageName());
            if (Build.VERSION.SDK_INT <= 18) {
                intent.removeCategory(context.getPackageName());
            }
            if ("google.com/iid".equals(intent.getStringExtra("from"))) {
                zzb = new zzz(this.zza);
            } else {
                zzb = new zza(context, this.zza);
            }
            zzb.zza(intent).addOnCompleteListener((Executor) this.zza, new zzr(isOrderedBroadcast(), goAsync()));
        }
    }

    static final /* synthetic */ void zza(boolean z, BroadcastReceiver.PendingResult pendingResult, Task task) {
        if (z) {
            pendingResult.setResultCode(task.isSuccessful() ? ((Integer) task.getResult()).intValue() : 500);
        }
        pendingResult.finish();
    }
}
