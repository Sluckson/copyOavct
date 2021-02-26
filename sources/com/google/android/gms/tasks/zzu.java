package com.google.android.gms.tasks;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-tasks@@17.0.2 */
final class zzu<TResult> extends Task<TResult> {
    private final Object zza = new Object();
    private final zzr<TResult> zzb = new zzr<>();
    @GuardedBy("mLock")
    private boolean zzc;
    private volatile boolean zzd;
    @GuardedBy("mLock")
    @Nullable
    private TResult zze;
    @GuardedBy("mLock")
    private Exception zzf;

    zzu() {
    }

    public final boolean isComplete() {
        boolean z;
        synchronized (this.zza) {
            z = this.zzc;
        }
        return z;
    }

    /* compiled from: com.google.android.gms:play-services-tasks@@17.0.2 */
    private static class zza extends LifecycleCallback {
        private final List<WeakReference<zzq<?>>> zza = new ArrayList();

        public static zza zza(Activity activity) {
            LifecycleFragment fragment = getFragment(activity);
            zza zza2 = (zza) fragment.getCallbackOrNull("TaskOnStopCallback", zza.class);
            return zza2 == null ? new zza(fragment) : zza2;
        }

        private zza(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.mLifecycleFragment.addCallback("TaskOnStopCallback", this);
        }

        public final <T> void zza(zzq<T> zzq) {
            synchronized (this.zza) {
                this.zza.add(new WeakReference(zzq));
            }
        }

        @MainThread
        public void onStop() {
            synchronized (this.zza) {
                for (WeakReference<zzq<?>> weakReference : this.zza) {
                    zzq zzq = (zzq) weakReference.get();
                    if (zzq != null) {
                        zzq.zza();
                    }
                }
                this.zza.clear();
            }
        }
    }

    public final boolean isCanceled() {
        return this.zzd;
    }

    public final boolean isSuccessful() {
        boolean z;
        synchronized (this.zza) {
            z = this.zzc && !this.zzd && this.zzf == null;
        }
        return z;
    }

    public final TResult getResult() {
        TResult tresult;
        synchronized (this.zza) {
            zzb();
            zzd();
            if (this.zzf == null) {
                tresult = this.zze;
            } else {
                throw new RuntimeExecutionException(this.zzf);
            }
        }
        return tresult;
    }

    public final <X extends Throwable> TResult getResult(@NonNull Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.zza) {
            zzb();
            zzd();
            if (cls.isInstance(this.zzf)) {
                throw ((Throwable) cls.cast(this.zzf));
            } else if (this.zzf == null) {
                tresult = this.zze;
            } else {
                throw new RuntimeExecutionException(this.zzf);
            }
        }
        return tresult;
    }

    @Nullable
    public final Exception getException() {
        Exception exc;
        synchronized (this.zza) {
            exc = this.zzf;
        }
        return exc;
    }

    @NonNull
    public final Task<TResult> addOnSuccessListener(@NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        return addOnSuccessListener(TaskExecutors.MAIN_THREAD, onSuccessListener);
    }

    @NonNull
    public final Task<TResult> addOnSuccessListener(@NonNull Executor executor, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        this.zzb.zza(new zzn(zzw.zza(executor), onSuccessListener));
        zze();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnSuccessListener(@NonNull Activity activity, @NonNull OnSuccessListener<? super TResult> onSuccessListener) {
        zzn zzn = new zzn(zzw.zza(TaskExecutors.MAIN_THREAD), onSuccessListener);
        this.zzb.zza(zzn);
        zza.zza(activity).zza(zzn);
        zze();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnFailureListener(@NonNull OnFailureListener onFailureListener) {
        return addOnFailureListener(TaskExecutors.MAIN_THREAD, onFailureListener);
    }

    @NonNull
    public final Task<TResult> addOnFailureListener(@NonNull Executor executor, @NonNull OnFailureListener onFailureListener) {
        this.zzb.zza(new zzk(zzw.zza(executor), onFailureListener));
        zze();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnFailureListener(@NonNull Activity activity, @NonNull OnFailureListener onFailureListener) {
        zzk zzk = new zzk(zzw.zza(TaskExecutors.MAIN_THREAD), onFailureListener);
        this.zzb.zza(zzk);
        zza.zza(activity).zza(zzk);
        zze();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnCompleteListener(@NonNull OnCompleteListener<TResult> onCompleteListener) {
        return addOnCompleteListener(TaskExecutors.MAIN_THREAD, onCompleteListener);
    }

    @NonNull
    public final Task<TResult> addOnCompleteListener(@NonNull Executor executor, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        this.zzb.zza(new zzj(zzw.zza(executor), onCompleteListener));
        zze();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnCompleteListener(@NonNull Activity activity, @NonNull OnCompleteListener<TResult> onCompleteListener) {
        zzj zzj = new zzj(zzw.zza(TaskExecutors.MAIN_THREAD), onCompleteListener);
        this.zzb.zza(zzj);
        zza.zza(activity).zza(zzj);
        zze();
        return this;
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Continuation<TResult, TContinuationResult> continuation) {
        return continueWith(TaskExecutors.MAIN_THREAD, continuation);
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> continueWith(@NonNull Executor executor, @NonNull Continuation<TResult, TContinuationResult> continuation) {
        zzu zzu = new zzu();
        this.zzb.zza(new zzc(zzw.zza(executor), continuation, zzu));
        zze();
        return zzu;
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        return continueWithTask(TaskExecutors.MAIN_THREAD, continuation);
    }

    @NonNull
    public final Task<TResult> addOnCanceledListener(@NonNull OnCanceledListener onCanceledListener) {
        return addOnCanceledListener(TaskExecutors.MAIN_THREAD, onCanceledListener);
    }

    @NonNull
    public final Task<TResult> addOnCanceledListener(@NonNull Executor executor, @NonNull OnCanceledListener onCanceledListener) {
        this.zzb.zza(new zzf(zzw.zza(executor), onCanceledListener));
        zze();
        return this;
    }

    @NonNull
    public final Task<TResult> addOnCanceledListener(@NonNull Activity activity, @NonNull OnCanceledListener onCanceledListener) {
        zzf zzf2 = new zzf(zzw.zza(TaskExecutors.MAIN_THREAD), onCanceledListener);
        this.zzb.zza(zzf2);
        zza.zza(activity).zza(zzf2);
        zze();
        return this;
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(@NonNull Executor executor, @NonNull Continuation<TResult, Task<TContinuationResult>> continuation) {
        zzu zzu = new zzu();
        this.zzb.zza(new zzd(zzw.zza(executor), continuation, zzu));
        zze();
        return zzu;
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Executor executor, SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        zzu zzu = new zzu();
        this.zzb.zza(new zzo(zzw.zza(executor), successContinuation, zzu));
        zze();
        return zzu;
    }

    @NonNull
    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(@NonNull SuccessContinuation<TResult, TContinuationResult> successContinuation) {
        return onSuccessTask(TaskExecutors.MAIN_THREAD, successContinuation);
    }

    public final void zza(TResult tresult) {
        synchronized (this.zza) {
            zzc();
            this.zzc = true;
            this.zze = tresult;
        }
        this.zzb.zza(this);
    }

    public final boolean zzb(TResult tresult) {
        synchronized (this.zza) {
            if (this.zzc) {
                return false;
            }
            this.zzc = true;
            this.zze = tresult;
            this.zzb.zza(this);
            return true;
        }
    }

    public final void zza(@NonNull Exception exc) {
        Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (this.zza) {
            zzc();
            this.zzc = true;
            this.zzf = exc;
        }
        this.zzb.zza(this);
    }

    public final boolean zzb(@NonNull Exception exc) {
        Preconditions.checkNotNull(exc, "Exception must not be null");
        synchronized (this.zza) {
            if (this.zzc) {
                return false;
            }
            this.zzc = true;
            this.zzf = exc;
            this.zzb.zza(this);
            return true;
        }
    }

    public final boolean zza() {
        synchronized (this.zza) {
            if (this.zzc) {
                return false;
            }
            this.zzc = true;
            this.zzd = true;
            this.zzb.zza(this);
            return true;
        }
    }

    @GuardedBy("mLock")
    private final void zzb() {
        Preconditions.checkState(this.zzc, "Task is not yet complete");
    }

    @GuardedBy("mLock")
    private final void zzc() {
        Preconditions.checkState(!this.zzc, "Task is already complete");
    }

    @GuardedBy("mLock")
    private final void zzd() {
        if (this.zzd) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void zze() {
        synchronized (this.zza) {
            if (this.zzc) {
                this.zzb.zza(this);
            }
        }
    }
}
