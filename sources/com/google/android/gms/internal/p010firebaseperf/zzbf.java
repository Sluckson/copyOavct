package com.google.android.gms.internal.p010firebaseperf;

import android.annotation.SuppressLint;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* renamed from: com.google.android.gms.internal.firebase-perf.zzbf */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzbf {
    @SuppressLint({"StaticFieldLeak"})
    private static final zzbf zzbp = new zzbf();
    private final ScheduledExecutorService zzbq;
    public final ConcurrentLinkedQueue<zzcd> zzbr;
    private final Runtime zzbs;
    @Nullable
    private ScheduledFuture zzbt;
    private long zzbu;

    private zzbf() {
        this(Executors.newSingleThreadScheduledExecutor(), Runtime.getRuntime());
    }

    public static boolean zzi(long j) {
        return j <= 0;
    }

    @VisibleForTesting
    private zzbf(ScheduledExecutorService scheduledExecutorService, Runtime runtime) {
        this.zzbt = null;
        this.zzbu = -1;
        this.zzbq = scheduledExecutorService;
        this.zzbr = new ConcurrentLinkedQueue<>();
        this.zzbs = runtime;
    }

    public static zzbf zzbf() {
        return zzbp;
    }

    public final void zza(long j, zzbw zzbw) {
        if (!zzi(j)) {
            if (this.zzbt == null) {
                zzc(j, zzbw);
            } else if (this.zzbu != j) {
                zzbc();
                zzc(j, zzbw);
            }
        }
    }

    public final void zzbc() {
        ScheduledFuture scheduledFuture = this.zzbt;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.zzbt = null;
            this.zzbu = -1;
        }
    }

    public final void zza(zzbw zzbw) {
        zzf(zzbw);
    }

    private final synchronized void zzc(long j, zzbw zzbw) {
        this.zzbu = j;
        try {
            this.zzbt = this.zzbq.scheduleAtFixedRate(new zzbe(this, zzbw), 0, j, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("FirebasePerformance", valueOf.length() != 0 ? "Unable to start collecting Memory Metrics: ".concat(valueOf) : new String("Unable to start collecting Memory Metrics: "));
        }
    }

    private final synchronized void zzf(zzbw zzbw) {
        try {
            this.zzbq.schedule(new zzbh(this, zzbw), 0, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("FirebasePerformance", valueOf.length() != 0 ? "Unable to collect Memory Metric: ".concat(valueOf) : new String("Unable to collect Memory Metric: "));
        }
    }

    @Nullable
    private final zzcd zzg(zzbw zzbw) {
        if (zzbw == null) {
            return null;
        }
        return (zzcd) ((zzfi) zzcd.zzdg().zzv(zzbw.zzdc()).zze(zzx.zza(zzbq.BYTES.zzt(this.zzbs.totalMemory() - this.zzbs.freeMemory()))).zzhm());
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzh(zzbw zzbw) {
        zzcd zzg = zzg(zzbw);
        if (zzg != null) {
            this.zzbr.add(zzg);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzi(zzbw zzbw) {
        zzcd zzg = zzg(zzbw);
        if (zzg != null) {
            this.zzbr.add(zzg);
        }
    }
}
