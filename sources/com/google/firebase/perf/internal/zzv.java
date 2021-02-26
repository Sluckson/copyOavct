package com.google.firebase.perf.internal;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.p010firebaseperf.zzah;
import com.google.android.gms.internal.p010firebaseperf.zzbk;
import com.google.android.gms.internal.p010firebaseperf.zzbw;
import com.google.android.gms.internal.p010firebaseperf.zzdd;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzv {
    private static final long zzev = TimeUnit.SECONDS.toMicros(1);
    private final zzbk zzcf;
    private final boolean zzdi;
    private long zzew;
    private double zzex;
    private zzbw zzey = new zzbw();
    private long zzez;
    private double zzfa;
    private long zzfb;
    private double zzfc;
    private long zzfd;

    zzv(double d, long j, zzbk zzbk, zzah zzah, String str, boolean z) {
        long j2;
        long j3;
        this.zzcf = zzbk;
        this.zzew = j;
        this.zzex = d;
        this.zzez = j;
        long zzaf = zzah.zzaf();
        if (str == "Trace") {
            j2 = zzah.zzab();
        } else {
            j2 = zzah.zzad();
        }
        this.zzfa = ((double) j2) / ((double) zzaf);
        this.zzfb = j2;
        if (z) {
            Log.d("FirebasePerformance", String.format("Foreground %s logging rate:%f, burst capacity:%d", new Object[]{str, Double.valueOf(this.zzfa), Long.valueOf(this.zzfb)}));
        }
        long zzaf2 = zzah.zzaf();
        if (str == "Trace") {
            j3 = zzah.zzac();
        } else {
            j3 = zzah.zzae();
        }
        this.zzfc = ((double) j3) / ((double) zzaf2);
        this.zzfd = j3;
        if (z) {
            Log.d("FirebasePerformance", String.format("Background %s logging rate:%f, capacity:%d", new Object[]{str, Double.valueOf(this.zzfc), Long.valueOf(this.zzfd)}));
        }
        this.zzdi = z;
    }

    /* access modifiers changed from: package-private */
    public final synchronized boolean zzb(@NonNull zzdd zzdd) {
        zzbw zzbw = new zzbw();
        this.zzez = Math.min(this.zzez + Math.max(0, (long) ((((double) this.zzey.zzk(zzbw)) * this.zzex) / ((double) zzev))), this.zzew);
        if (this.zzez > 0) {
            this.zzez--;
            this.zzey = zzbw;
            return true;
        }
        if (this.zzdi) {
            Log.w("FirebasePerformance", "Exceeded log rate limit, dropping the log.");
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzc(boolean z) {
        this.zzex = z ? this.zzfa : this.zzfc;
        this.zzew = z ? this.zzfb : this.zzfd;
    }
}
