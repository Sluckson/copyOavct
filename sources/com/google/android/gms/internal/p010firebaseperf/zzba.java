package com.google.android.gms.internal.p010firebaseperf;

import android.os.Build;
import android.os.Process;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import androidx.annotation.Nullable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.NotThreadSafe;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

@NotThreadSafe
/* renamed from: com.google.android.gms.internal.firebase-perf.zzba */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzba {
    private static final long zzbc = TimeUnit.SECONDS.toMicros(1);
    @Nullable
    private static zzba zzbd = null;
    @Nullable
    private ScheduledFuture zzbe = null;
    private final ScheduledExecutorService zzbf;
    private long zzbg;
    private final long zzbh;
    private final String zzbi;
    public final ConcurrentLinkedQueue<zzck> zzbj;

    private zzba() {
        long j = -1;
        this.zzbg = -1;
        this.zzbj = new ConcurrentLinkedQueue<>();
        this.zzbf = Executors.newSingleThreadScheduledExecutor();
        String num = Integer.toString(Process.myPid());
        StringBuilder sb = new StringBuilder(String.valueOf(num).length() + 11);
        sb.append("/proc/");
        sb.append(num);
        sb.append("/stat");
        this.zzbi = sb.toString();
        this.zzbh = Build.VERSION.SDK_INT >= 21 ? Os.sysconf(OsConstants._SC_CLK_TCK) : j;
    }

    public static boolean zzi(long j) {
        return j <= 0;
    }

    public static zzba zzbb() {
        if (zzbd == null) {
            zzbd = new zzba();
        }
        return zzbd;
    }

    public final void zza(long j, zzbw zzbw) {
        long j2 = this.zzbh;
        if (j2 != -1 && j2 != 0 && !zzi(j)) {
            if (this.zzbe == null) {
                zzb(j, zzbw);
            } else if (this.zzbg != j) {
                zzbc();
                zzb(j, zzbw);
            }
        }
    }

    public final void zzbc() {
        ScheduledFuture scheduledFuture = this.zzbe;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
            this.zzbe = null;
            this.zzbg = -1;
        }
    }

    public final void zza(zzbw zzbw) {
        zzb(zzbw);
    }

    private final synchronized void zzb(long j, zzbw zzbw) {
        this.zzbg = j;
        try {
            this.zzbe = this.zzbf.scheduleAtFixedRate(new zzbd(this, zzbw), 0, j, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("FirebasePerformance", valueOf.length() != 0 ? "Unable to start collecting Cpu Metrics: ".concat(valueOf) : new String("Unable to start collecting Cpu Metrics: "));
        }
    }

    private final synchronized void zzb(zzbw zzbw) {
        try {
            this.zzbf.schedule(new zzbc(this, zzbw), 0, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("FirebasePerformance", valueOf.length() != 0 ? "Unable to collect Cpu Metric: ".concat(valueOf) : new String("Unable to collect Cpu Metric: "));
        }
    }

    @Nullable
    private final zzck zzc(zzbw zzbw) {
        BufferedReader bufferedReader;
        if (zzbw == null) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(this.zzbi));
            long zzdc = zzbw.zzdc();
            String[] split = bufferedReader.readLine().split(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            zzck zzck = (zzck) ((zzfi) zzck.zzdr().zzy(zzdc).zzaa(zzh(Long.parseLong(split[14]) + Long.parseLong(split[16]))).zzz(zzh(Long.parseLong(split[13]) + Long.parseLong(split[15]))).zzhm());
            bufferedReader.close();
            return zzck;
        } catch (IOException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("FirebasePerformance", valueOf.length() != 0 ? "Unable to read 'proc/[pid]/stat' file: ".concat(valueOf) : new String("Unable to read 'proc/[pid]/stat' file: "));
            return null;
        } catch (ArrayIndexOutOfBoundsException | NullPointerException | NumberFormatException e2) {
            String valueOf2 = String.valueOf(e2.getMessage());
            Log.w("FirebasePerformance", valueOf2.length() != 0 ? "Unexpected '/proc/[pid]/stat' file format encountered: ".concat(valueOf2) : new String("Unexpected '/proc/[pid]/stat' file format encountered: "));
            return null;
        } catch (Throwable th) {
            zzz.zza(th, th);
        }
        throw th;
    }

    private final long zzh(long j) {
        return Math.round((((double) j) / ((double) this.zzbh)) * ((double) zzbc));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzbw zzbw) {
        zzck zzc = zzc(zzbw);
        if (zzc != null) {
            this.zzbj.add(zzc);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zzbw zzbw) {
        zzck zzc = zzc(zzbw);
        if (zzc != null) {
            this.zzbj.add(zzc);
        }
    }
}
