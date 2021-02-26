package com.google.firebase.perf.internal;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.p010firebaseperf.zzah;
import com.google.android.gms.internal.p010firebaseperf.zzba;
import com.google.android.gms.internal.p010firebaseperf.zzbf;
import com.google.android.gms.internal.p010firebaseperf.zzbw;
import com.google.android.gms.internal.p010firebaseperf.zzcg;
import com.google.android.gms.internal.p010firebaseperf.zzcp;
import com.google.android.gms.internal.p010firebaseperf.zzcq;
import com.google.android.gms.internal.p010firebaseperf.zzfi;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@Keep
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public class GaugeManager {
    private static GaugeManager zzdw = new GaugeManager();
    private final zzah zzac;
    private final ScheduledExecutorService zzdx;
    private final zzba zzdy;
    private final zzbf zzdz;
    @Nullable
    private zzd zzea;
    @Nullable
    private zzq zzeb;
    private zzcg zzec;
    @Nullable
    private String zzed;
    @Nullable
    private ScheduledFuture zzee;
    private final ConcurrentLinkedQueue<zza> zzef;

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    class zza {
        /* access modifiers changed from: private */
        public final zzcq zzdp;
        /* access modifiers changed from: private */
        public final zzcg zzec;

        zza(GaugeManager gaugeManager, zzcq zzcq, zzcg zzcg) {
            this.zzdp = zzcq;
            this.zzec = zzcg;
        }
    }

    private GaugeManager() {
        this(Executors.newSingleThreadScheduledExecutor(), (zzd) null, zzah.zzo(), (zzq) null, zzba.zzbb(), zzbf.zzbf());
    }

    @VisibleForTesting
    private GaugeManager(ScheduledExecutorService scheduledExecutorService, zzd zzd, zzah zzah, zzq zzq, zzba zzba, zzbf zzbf) {
        this.zzec = zzcg.APPLICATION_PROCESS_STATE_UNKNOWN;
        this.zzed = null;
        this.zzee = null;
        this.zzef = new ConcurrentLinkedQueue<>();
        this.zzdx = scheduledExecutorService;
        this.zzea = null;
        this.zzac = zzah;
        this.zzeb = null;
        this.zzdy = zzba;
        this.zzdz = zzbf;
    }

    public final void zzc(Context context) {
        this.zzeb = new zzq(context);
    }

    public static synchronized GaugeManager zzby() {
        GaugeManager gaugeManager;
        synchronized (GaugeManager.class) {
            gaugeManager = zzdw;
        }
        return gaugeManager;
    }

    public final void zza(zzr zzr, zzcg zzcg) {
        long j;
        boolean z;
        long j2;
        zzcg zzcg2 = zzcg;
        if (this.zzed != null) {
            zzbz();
        }
        zzbw zzcf = zzr.zzcf();
        int i = zzo.zzeg[zzcg.ordinal()];
        if (i == 1) {
            j = this.zzac.zzx();
        } else if (i != 2) {
            j = -1;
        } else {
            j = this.zzac.zzw();
        }
        if (zzba.zzi(j)) {
            j = -1;
        }
        boolean z2 = false;
        if (j == -1) {
            Log.d("FirebasePerformance", "Invalid Cpu Metrics collection frequency. Did not collect Cpu Metrics.");
            z = false;
        } else {
            this.zzdy.zza(j, zzcf);
            z = true;
        }
        if (!z) {
            j = -1;
        }
        int i2 = zzo.zzeg[zzcg.ordinal()];
        if (i2 == 1) {
            j2 = this.zzac.zzz();
        } else if (i2 != 2) {
            j2 = -1;
        } else {
            j2 = this.zzac.zzy();
        }
        if (zzbf.zzi(j2)) {
            j2 = -1;
        }
        if (j2 == -1) {
            Log.d("FirebasePerformance", "Invalid Memory Metrics collection frequency. Did not collect Memory Metrics.");
        } else {
            this.zzdz.zza(j2, zzcf);
            z2 = true;
        }
        if (z2) {
            if (j == -1) {
                j = j2;
            } else {
                j = Math.min(j, j2);
            }
        }
        if (j == -1) {
            Log.w("FirebasePerformance", "Invalid gauge collection frequency. Unable to start collecting Gauges.");
            return;
        }
        this.zzed = zzr.zzce();
        this.zzec = zzcg2;
        try {
            long j3 = j * 20;
            this.zzee = this.zzdx.scheduleAtFixedRate(new zzn(this, this.zzed, zzcg2), j3, j3, TimeUnit.MILLISECONDS);
        } catch (RejectedExecutionException e) {
            String valueOf = String.valueOf(e.getMessage());
            Log.w("FirebasePerformance", valueOf.length() != 0 ? "Unable to start collecting Gauges: ".concat(valueOf) : new String("Unable to start collecting Gauges: "));
        }
    }

    public final void zzbz() {
        String str = this.zzed;
        if (str != null) {
            zzcg zzcg = this.zzec;
            this.zzdy.zzbc();
            this.zzdz.zzbc();
            ScheduledFuture scheduledFuture = this.zzee;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.zzdx.schedule(new zzp(this, str, zzcg), 20, TimeUnit.MILLISECONDS);
            this.zzed = null;
            this.zzec = zzcg.APPLICATION_PROCESS_STATE_UNKNOWN;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final void zzd(String str, zzcg zzcg) {
        zzcq.zza zzed2 = zzcq.zzed();
        while (!this.zzdy.zzbj.isEmpty()) {
            zzed2.zzb(this.zzdy.zzbj.poll());
        }
        while (!this.zzdz.zzbr.isEmpty()) {
            zzed2.zzb(this.zzdz.zzbr.poll());
        }
        zzed2.zzad(str);
        zzc((zzcq) ((zzfi) zzed2.zzhm()), zzcg);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb(String str, zzcg zzcg) {
        if (this.zzeb == null) {
            return false;
        }
        zzc((zzcq) ((zzfi) zzcq.zzed().zzad(str).zzb((zzcp) ((zzfi) zzcp.zzdu().zzac(this.zzeb.getProcessName()).zzi(this.zzeb.zzcc()).zzj(this.zzeb.zzca()).zzk(this.zzeb.zzcb()).zzhm())).zzhm()), zzcg);
        return true;
    }

    private final void zzc(zzcq zzcq, zzcg zzcg) {
        zzd zzd = this.zzea;
        if (zzd == null) {
            zzd = zzd.zzbs();
        }
        this.zzea = zzd;
        zzd zzd2 = this.zzea;
        if (zzd2 != null) {
            zzd2.zza(zzcq, zzcg);
            while (!this.zzef.isEmpty()) {
                zza poll = this.zzef.poll();
                this.zzea.zza(poll.zzdp, poll.zzec);
            }
            return;
        }
        this.zzef.add(new zza(this, zzcq, zzcg));
    }

    public final void zzj(zzbw zzbw) {
        zzba zzba = this.zzdy;
        zzbf zzbf = this.zzdz;
        zzba.zza(zzbw);
        zzbf.zza(zzbw);
    }
}
