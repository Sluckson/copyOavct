package com.google.android.gms.tasks;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;

/* compiled from: com.google.android.gms:play-services-tasks@@17.0.2 */
public final class Tasks {

    /* compiled from: com.google.android.gms:play-services-tasks@@17.0.2 */
    interface zzc extends OnCanceledListener, OnFailureListener, OnSuccessListener<Object> {
    }

    @NonNull
    public static <TResult> Task<TResult> forResult(TResult tresult) {
        zzu zzu = new zzu();
        zzu.zza(tresult);
        return zzu;
    }

    /* compiled from: com.google.android.gms:play-services-tasks@@17.0.2 */
    private static final class zza implements zzc {
        private final CountDownLatch zza;

        private zza() {
            this.zza = new CountDownLatch(1);
        }

        public final void onSuccess(Object obj) {
            this.zza.countDown();
        }

        public final void onFailure(@NonNull Exception exc) {
            this.zza.countDown();
        }

        public final void onCanceled() {
            this.zza.countDown();
        }

        public final void zza() throws InterruptedException {
            this.zza.await();
        }

        public final boolean zza(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.zza.await(j, timeUnit);
        }

        /* synthetic */ zza(zzz zzz) {
            this();
        }
    }

    @NonNull
    public static <TResult> Task<TResult> forException(@NonNull Exception exc) {
        zzu zzu = new zzu();
        zzu.zza(exc);
        return zzu;
    }

    /* compiled from: com.google.android.gms:play-services-tasks@@17.0.2 */
    private static final class zzb implements zzc {
        private final Object zza = new Object();
        private final int zzb;
        private final zzu<Void> zzc;
        @GuardedBy("mLock")
        private int zzd;
        @GuardedBy("mLock")
        private int zze;
        @GuardedBy("mLock")
        private int zzf;
        @GuardedBy("mLock")
        private Exception zzg;
        @GuardedBy("mLock")
        private boolean zzh;

        public zzb(int i, zzu<Void> zzu) {
            this.zzb = i;
            this.zzc = zzu;
        }

        public final void onFailure(@NonNull Exception exc) {
            synchronized (this.zza) {
                this.zze++;
                this.zzg = exc;
                zza();
            }
        }

        public final void onSuccess(Object obj) {
            synchronized (this.zza) {
                this.zzd++;
                zza();
            }
        }

        public final void onCanceled() {
            synchronized (this.zza) {
                this.zzf++;
                this.zzh = true;
                zza();
            }
        }

        @GuardedBy("mLock")
        private final void zza() {
            int i = this.zzd;
            int i2 = this.zze;
            int i3 = i + i2 + this.zzf;
            int i4 = this.zzb;
            if (i3 != i4) {
                return;
            }
            if (this.zzg != null) {
                zzu<Void> zzu = this.zzc;
                StringBuilder sb = new StringBuilder(54);
                sb.append(i2);
                sb.append(" out of ");
                sb.append(i4);
                sb.append(" underlying tasks failed");
                zzu.zza((Exception) new ExecutionException(sb.toString(), this.zzg));
            } else if (this.zzh) {
                this.zzc.zza();
            } else {
                this.zzc.zza(null);
            }
        }
    }

    @NonNull
    public static <TResult> Task<TResult> forCanceled() {
        zzu zzu = new zzu();
        zzu.zza();
        return zzu;
    }

    @NonNull
    public static <TResult> Task<TResult> call(@NonNull Callable<TResult> callable) {
        return call(TaskExecutors.MAIN_THREAD, callable);
    }

    @NonNull
    public static <TResult> Task<TResult> call(@NonNull Executor executor, @NonNull Callable<TResult> callable) {
        Preconditions.checkNotNull(executor, "Executor must not be null");
        Preconditions.checkNotNull(callable, "Callback must not be null");
        zzu zzu = new zzu();
        executor.execute(new zzz(zzu, callable));
        return zzu;
    }

    public static <TResult> TResult await(@NonNull Task<TResult> task) throws ExecutionException, InterruptedException {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        if (task.isComplete()) {
            return zza(task);
        }
        zza zza2 = new zza((zzz) null);
        zza(task, zza2);
        zza2.zza();
        return zza(task);
    }

    public static <TResult> TResult await(@NonNull Task<TResult> task, long j, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        Preconditions.checkNotMainThread();
        Preconditions.checkNotNull(task, "Task must not be null");
        Preconditions.checkNotNull(timeUnit, "TimeUnit must not be null");
        if (task.isComplete()) {
            return zza(task);
        }
        zza zza2 = new zza((zzz) null);
        zza(task, zza2);
        if (zza2.zza(j, timeUnit)) {
            return zza(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    @NonNull
    public static Task<Void> whenAll(@Nullable Collection<? extends Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return forResult((Object) null);
        }
        for (Task task : collection) {
            if (task == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        zzu zzu = new zzu();
        zzb zzb2 = new zzb(collection.size(), zzu);
        for (Task zza2 : collection) {
            zza(zza2, zzb2);
        }
        return zzu;
    }

    @NonNull
    public static Task<Void> whenAll(@Nullable Task<?>... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return forResult((Object) null);
        }
        return whenAll((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }

    @NonNull
    public static <TResult> Task<List<TResult>> whenAllSuccess(@Nullable Collection<? extends Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return forResult(Collections.emptyList());
        }
        return whenAll(collection).continueWith(new zzy(collection));
    }

    @NonNull
    public static <TResult> Task<List<TResult>> whenAllSuccess(@Nullable Task<?>... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return forResult(Collections.emptyList());
        }
        return whenAllSuccess((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }

    @NonNull
    public static Task<List<Task<?>>> whenAllComplete(@Nullable Collection<? extends Task<?>> collection) {
        if (collection == null || collection.isEmpty()) {
            return forResult(Collections.emptyList());
        }
        return whenAll(collection).continueWithTask(new zzaa(collection));
    }

    @NonNull
    public static Task<List<Task<?>>> whenAllComplete(@Nullable Task<?>... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return forResult(Collections.emptyList());
        }
        return whenAllComplete((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }

    private static <TResult> TResult zza(@NonNull Task<TResult> task) throws ExecutionException {
        if (task.isSuccessful()) {
            return task.getResult();
        }
        if (task.isCanceled()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(task.getException());
    }

    private static void zza(Task<?> task, zzc zzc2) {
        task.addOnSuccessListener(TaskExecutors.zza, (OnSuccessListener<? super Object>) zzc2);
        task.addOnFailureListener(TaskExecutors.zza, (OnFailureListener) zzc2);
        task.addOnCanceledListener(TaskExecutors.zza, (OnCanceledListener) zzc2);
    }

    private Tasks() {
    }
}
