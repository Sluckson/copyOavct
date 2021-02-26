package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.lang.Thread;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzfw implements Thread.UncaughtExceptionHandler {
    private final String zza;
    private final /* synthetic */ zzfu zzb;

    public zzfw(zzfu zzfu, String str) {
        this.zzb = zzfu;
        Preconditions.checkNotNull(str);
        this.zza = str;
    }

    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.zzb.zzq().zze().zza(this.zza, th);
    }
}
