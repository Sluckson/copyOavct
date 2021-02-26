package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-tasks@@17.0.2 */
final class zzo<TResult, TContinuationResult> implements OnCanceledListener, OnFailureListener, OnSuccessListener<TContinuationResult>, zzq<TResult> {
    private final Executor zza;
    /* access modifiers changed from: private */
    public final SuccessContinuation<TResult, TContinuationResult> zzb;
    private final zzu<TContinuationResult> zzc;

    public zzo(@NonNull Executor executor, @NonNull SuccessContinuation<TResult, TContinuationResult> successContinuation, @NonNull zzu<TContinuationResult> zzu) {
        this.zza = executor;
        this.zzb = successContinuation;
        this.zzc = zzu;
    }

    public final void zza(@NonNull Task<TResult> task) {
        this.zza.execute(new zzp(this, task));
    }

    public final void zza() {
        throw new UnsupportedOperationException();
    }

    public final void onSuccess(TContinuationResult tcontinuationresult) {
        this.zzc.zza(tcontinuationresult);
    }

    public final void onFailure(@NonNull Exception exc) {
        this.zzc.zza(exc);
    }

    public final void onCanceled() {
        this.zzc.zza();
    }
}
