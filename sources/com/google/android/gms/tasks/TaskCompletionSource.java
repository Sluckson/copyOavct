package com.google.android.gms.tasks;

import androidx.annotation.NonNull;

/* compiled from: com.google.android.gms:play-services-tasks@@17.0.2 */
public class TaskCompletionSource<TResult> {
    /* access modifiers changed from: private */
    public final zzu<TResult> zza = new zzu<>();

    public TaskCompletionSource() {
    }

    public TaskCompletionSource(@NonNull CancellationToken cancellationToken) {
        cancellationToken.onCanceledRequested(new zzs(this));
    }

    public void setResult(TResult tresult) {
        this.zza.zza(tresult);
    }

    public boolean trySetResult(TResult tresult) {
        return this.zza.zzb(tresult);
    }

    public void setException(@NonNull Exception exc) {
        this.zza.zza(exc);
    }

    public boolean trySetException(@NonNull Exception exc) {
        return this.zza.zzb(exc);
    }

    @NonNull
    public Task<TResult> getTask() {
        return this.zza;
    }
}
