package com.google.android.gms.measurement.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzm;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzfz<V> extends FutureTask<V> implements Comparable<zzfz<V>> {
    final boolean zza;
    private final long zzb = zzfu.zzj.getAndIncrement();
    private final String zzc;
    private final /* synthetic */ zzfu zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfz(zzfu zzfu, Callable<V> callable, boolean z, String str) {
        super(zzm.zza().zza(callable));
        this.zzd = zzfu;
        Preconditions.checkNotNull(str);
        this.zzc = str;
        this.zza = z;
        if (this.zzb == Long.MAX_VALUE) {
            zzfu.zzq().zze().zza("Tasks index overflow");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzfz(zzfu zzfu, Runnable runnable, boolean z, String str) {
        super(zzm.zza().zza(runnable), (Object) null);
        this.zzd = zzfu;
        Preconditions.checkNotNull(str);
        this.zzc = str;
        this.zza = z;
        if (this.zzb == Long.MAX_VALUE) {
            zzfu.zzq().zze().zza("Tasks index overflow");
        }
    }

    /* access modifiers changed from: protected */
    public final void setException(Throwable th) {
        this.zzd.zzq().zze().zza(this.zzc, th);
        if (th instanceof zzfx) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), th);
        }
        super.setException(th);
    }

    public final /* synthetic */ int compareTo(@NonNull Object obj) {
        zzfz zzfz = (zzfz) obj;
        boolean z = this.zza;
        if (z != zzfz.zza) {
            return z ? -1 : 1;
        }
        long j = this.zzb;
        long j2 = zzfz.zzb;
        if (j < j2) {
            return -1;
        }
        if (j > j2) {
            return 1;
        }
        this.zzd.zzq().zzf().zza("Two tasks share the same index. index", Long.valueOf(this.zzb));
        return 0;
    }
}
