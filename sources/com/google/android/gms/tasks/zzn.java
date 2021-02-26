package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-tasks@@17.0.2 */
final class zzn<TResult> implements zzq<TResult> {
    private final Executor zza;
    /* access modifiers changed from: private */
    public final Object zzb = new Object();
    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public OnSuccessListener<? super TResult> zzc;

    public zzn(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.zza = executor;
        this.zzc = onSuccessListener;
    }

    public final void zza(@NonNull Task<TResult> task) {
        if (task.isSuccessful()) {
            synchronized (this.zzb) {
                if (this.zzc != null) {
                    this.zza.execute(new zzm(this, task));
                }
            }
        }
    }

    public final void zza() {
        synchronized (this.zzb) {
            this.zzc = null;
        }
    }
}
