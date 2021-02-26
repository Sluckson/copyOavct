package com.google.firebase.perf.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.internal.p010firebaseperf.zzah;
import com.google.android.gms.internal.p010firebaseperf.zzbm;
import com.google.android.gms.internal.p010firebaseperf.zzbz;
import com.google.android.gms.internal.p010firebaseperf.zzca;
import com.google.android.gms.internal.p010firebaseperf.zzce;
import com.google.android.gms.internal.p010firebaseperf.zzcg;
import com.google.android.gms.internal.p010firebaseperf.zzcq;
import com.google.android.gms.internal.p010firebaseperf.zzcx;
import com.google.android.gms.internal.p010firebaseperf.zzdd;
import com.google.android.gms.internal.p010firebaseperf.zzdm;
import com.google.android.gms.internal.p010firebaseperf.zzfi;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.perf.FirebasePerformance;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public class zzd {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile zzd zzcx;
    private zzah zzac = null;
    private final ExecutorService zzcy = new ThreadPoolExecutor(0, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private FirebaseApp zzcz;
    @Nullable
    private FirebasePerformance zzda;
    private FirebaseInstanceId zzdb = null;
    private Context zzdc;
    private ClearcutLogger zzdd = null;
    private String zzde;
    private final zzce.zza zzdf = zzce.zzdn();
    private zzt zzdg = null;
    private zza zzdh = null;
    private boolean zzdi;

    @Nullable
    public static zzd zzbs() {
        if (zzcx == null) {
            synchronized (zzd.class) {
                if (zzcx == null) {
                    try {
                        FirebaseApp.getInstance();
                        zzcx = new zzd((ExecutorService) null, (ClearcutLogger) null, (zzt) null, (zza) null, (FirebaseInstanceId) null, (zzah) null);
                    } catch (IllegalStateException unused) {
                        return null;
                    }
                }
            }
        }
        return zzcx;
    }

    @VisibleForTesting(otherwise = 2)
    private zzd(@Nullable ExecutorService executorService, @Nullable ClearcutLogger clearcutLogger, @Nullable zzt zzt, @Nullable zza zza, @Nullable FirebaseInstanceId firebaseInstanceId, @Nullable zzah zzah) {
        this.zzcy.execute(new zzg(this));
    }

    public final void zza(@NonNull zzdm zzdm, zzcg zzcg) {
        this.zzcy.execute(new zzf(this, zzdm, zzcg));
        SessionManager.zzcm().zzco();
    }

    public final void zza(@NonNull zzcx zzcx2, zzcg zzcg) {
        this.zzcy.execute(new zzi(this, zzcx2, zzcg));
        SessionManager.zzcm().zzco();
    }

    public final void zza(zzcq zzcq, zzcg zzcg) {
        this.zzcy.execute(new zzh(this, zzcq, zzcg));
        SessionManager.zzcm().zzco();
    }

    public final void zzc(boolean z) {
        this.zzcy.execute(new zzk(this, z));
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzbt() {
        this.zzcz = FirebaseApp.getInstance();
        this.zzda = FirebasePerformance.getInstance();
        this.zzdc = this.zzcz.getApplicationContext();
        this.zzde = this.zzcz.getOptions().getApplicationId();
        this.zzdf.zzy(this.zzde).zza(zzbz.zzdd().zzt(this.zzdc.getPackageName()).zzu(zzb.VERSION_NAME).zzv(zzf(this.zzdc)));
        zzbu();
        zzt zzt = this.zzdg;
        if (zzt == null) {
            zzt = new zzt(this.zzdc, 100.0d, 500);
        }
        this.zzdg = zzt;
        zza zza = this.zzdh;
        if (zza == null) {
            zza = zza.zzbl();
        }
        this.zzdh = zza;
        zzah zzah = this.zzac;
        if (zzah == null) {
            zzah = zzah.zzo();
        }
        this.zzac = zzah;
        this.zzac.zzc(this.zzdc);
        this.zzdi = zzca.zzg(this.zzdc);
        if (this.zzdd == null) {
            try {
                this.zzdd = ClearcutLogger.anonymousLogger(this.zzdc, this.zzac.zzag());
            } catch (SecurityException e) {
                String valueOf = String.valueOf(e.getMessage());
                Log.w("FirebasePerformance", valueOf.length() != 0 ? "Caught SecurityException while init ClearcutLogger: ".concat(valueOf) : new String("Caught SecurityException while init ClearcutLogger: "));
                this.zzdd = null;
            }
        }
    }

    @WorkerThread
    private final void zza(@NonNull zzdd zzdd2) {
        if (this.zzdd == null || !zzbv()) {
            return;
        }
        if (!zzdd2.zzff().hasAppInstanceId()) {
            Log.w("FirebasePerformance", "App Instance ID is null or empty, dropping the log");
            return;
        }
        Context context = this.zzdc;
        ArrayList arrayList = new ArrayList();
        if (zzdd2.zzfg()) {
            arrayList.add(new zzl(zzdd2.zzfh()));
        }
        if (zzdd2.zzfi()) {
            arrayList.add(new zzm(zzdd2.zzfj(), context));
        }
        if (zzdd2.zzfe()) {
            arrayList.add(new zze(zzdd2.zzff()));
        }
        if (zzdd2.zzfk()) {
            arrayList.add(new zzj(zzdd2.zzfl()));
        }
        boolean z = false;
        if (!arrayList.isEmpty()) {
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    z = true;
                    break;
                }
                Object obj = arrayList2.get(i);
                i++;
                if (!((zzs) obj).zzbx()) {
                    break;
                }
            }
        } else {
            Log.d("FirebasePerformance", "No validators found for PerfMetric.");
        }
        if (!z) {
            Log.w("FirebasePerformance", "Unable to process the PerfMetric due to missing or invalid values. See earlier log statements for additional information on the specific missing/invalid values.");
        } else if (!this.zzdg.zzb(zzdd2)) {
            if (zzdd2.zzfi()) {
                this.zzdh.zzb(zzbm.NETWORK_TRACE_EVENT_RATE_LIMITED.toString(), 1);
            } else if (zzdd2.zzfg()) {
                this.zzdh.zzb(zzbm.TRACE_EVENT_RATE_LIMITED.toString(), 1);
            }
            if (!this.zzdi) {
                return;
            }
            if (zzdd2.zzfi()) {
                String valueOf = String.valueOf(zzdd2.zzfj().getUrl());
                Log.i("FirebasePerformance", valueOf.length() != 0 ? "Rate Limited NetworkRequestMetric - ".concat(valueOf) : new String("Rate Limited NetworkRequestMetric - "));
            } else if (zzdd2.zzfg()) {
                String valueOf2 = String.valueOf(zzdd2.zzfh().getName());
                Log.i("FirebasePerformance", valueOf2.length() != 0 ? "Rate Limited TraceMetric - ".concat(valueOf2) : new String("Rate Limited TraceMetric - "));
            }
        } else {
            try {
                this.zzdd.newEvent(zzdd2.toByteArray()).log();
            } catch (SecurityException unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzb(zzcq zzcq, zzcg zzcg) {
        if (zzbv()) {
            if (this.zzdi) {
                Log.d("FirebasePerformance", String.format("Logging GaugeMetric. Cpu Metrics: %d, Memory Metrics: %d, Has Metadata: %b, Session ID: %s", new Object[]{Integer.valueOf(zzcq.zzeb()), Integer.valueOf(zzcq.zzec()), Boolean.valueOf(zzcq.zzdz()), zzcq.zzdy()}));
            }
            zzdd.zza zzfm = zzdd.zzfm();
            zzbu();
            zzfm.zza(this.zzdf.zzf(zzcg)).zzb(zzcq);
            zza((zzdd) ((zzfi) zzfm.zzhm()));
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzb(@NonNull zzdm zzdm, zzcg zzcg) {
        Map<String, String> map;
        if (zzbv()) {
            if (this.zzdi) {
                Log.d("FirebasePerformance", String.format("Logging TraceMetric - %s %dms", new Object[]{zzdm.getName(), Long.valueOf(zzdm.getDurationUs() / 1000)}));
            }
            zzbu();
            zzdd.zza zzfm = zzdd.zzfm();
            zzce.zza zzf = ((zzce.zza) ((zzfi.zza) this.zzdf.clone())).zzf(zzcg);
            zzbw();
            FirebasePerformance firebasePerformance = this.zzda;
            if (firebasePerformance != null) {
                map = firebasePerformance.getAttributes();
            } else {
                map = Collections.emptyMap();
            }
            zza((zzdd) ((zzfi) zzfm.zza(zzf.zzb(map)).zzb(zzdm).zzhm()));
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public final void zzb(@NonNull zzcx zzcx2, zzcg zzcg) {
        long j;
        if (zzbv()) {
            if (this.zzdi) {
                long j2 = 0;
                if (!zzcx2.zzew()) {
                    j = 0;
                } else {
                    j = zzcx2.zzex();
                }
                if (zzcx2.zzem()) {
                    j2 = zzcx2.zzen();
                }
                Log.d("FirebasePerformance", String.format("Logging NetworkRequestMetric - %s %db %dms,", new Object[]{zzcx2.getUrl(), Long.valueOf(j2), Long.valueOf(j / 1000)}));
            }
            zzbu();
            zza((zzdd) ((zzfi) zzdd.zzfm().zza(this.zzdf.zzf(zzcg)).zzd(zzcx2).zzhm()));
        }
    }

    @WorkerThread
    public final void zzd(boolean z) {
        this.zzdg.zzc(z);
    }

    private static String zzf(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    @WorkerThread
    private final void zzbu() {
        if (!this.zzdf.hasAppInstanceId() && zzbv()) {
            if (this.zzdb == null) {
                this.zzdb = FirebaseInstanceId.getInstance();
            }
            String id = this.zzdb.getId();
            if (id != null && !id.isEmpty()) {
                this.zzdf.zzz(id);
            }
        }
    }

    @VisibleForTesting(otherwise = 2)
    private final boolean zzbv() {
        zzbw();
        if (this.zzac == null) {
            this.zzac = zzah.zzo();
        }
        FirebasePerformance firebasePerformance = this.zzda;
        return firebasePerformance != null && firebasePerformance.isPerformanceCollectionEnabled() && this.zzac.zzs();
    }

    private final void zzbw() {
        if (this.zzda == null) {
            this.zzda = this.zzcz != null ? FirebasePerformance.getInstance() : null;
        }
    }
}
