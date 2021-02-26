package com.google.firebase.perf.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.core.app.FrameMetricsAggregator;
import com.google.android.gms.internal.p010firebaseperf.zzah;
import com.google.android.gms.internal.p010firebaseperf.zzbk;
import com.google.android.gms.internal.p010firebaseperf.zzbl;
import com.google.android.gms.internal.p010firebaseperf.zzbm;
import com.google.android.gms.internal.p010firebaseperf.zzbw;
import com.google.android.gms.internal.p010firebaseperf.zzca;
import com.google.android.gms.internal.p010firebaseperf.zzcg;
import com.google.android.gms.internal.p010firebaseperf.zzdm;
import com.google.android.gms.internal.p010firebaseperf.zzfi;
import com.google.firebase.perf.metrics.Trace;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public class zza implements Application.ActivityLifecycleCallbacks {
    private static volatile zza zzcc;
    private boolean mRegistered = false;
    private zzd zzcd = null;
    private zzah zzce;
    private final zzbk zzcf;
    private boolean zzcg = true;
    private final WeakHashMap<Activity, Boolean> zzch = new WeakHashMap<>();
    private zzbw zzci;
    private zzbw zzcj;
    private final Map<String, Long> zzck = new HashMap();
    private AtomicInteger zzcl = new AtomicInteger(0);
    private zzcg zzcm = zzcg.BACKGROUND;
    private Set<WeakReference<C5081zza>> zzcn = new HashSet();
    private boolean zzco = false;
    private FrameMetricsAggregator zzcp;
    private final WeakHashMap<Activity, Trace> zzcq = new WeakHashMap<>();

    /* renamed from: com.google.firebase.perf.internal.zza$zza  reason: collision with other inner class name */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    public interface C5081zza {
        void zza(zzcg zzcg);
    }

    public static zza zzbl() {
        if (zzcc != null) {
            return zzcc;
        }
        return zzb((zzd) null);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    private static zza zzb(zzd zzd) {
        if (zzcc == null) {
            synchronized (zza.class) {
                if (zzcc == null) {
                    zzcc = new zza((zzd) null, new zzbk());
                }
            }
        }
        return zzcc;
    }

    private zza(zzd zzd, zzbk zzbk) {
        this.zzcf = zzbk;
        this.zzce = zzah.zzo();
        this.zzco = zzbp();
        if (this.zzco) {
            this.zzcp = new FrameMetricsAggregator();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zze(android.content.Context r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.mRegistered     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x0019 }
            boolean r0 = r2 instanceof android.app.Application     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0017
            android.app.Application r2 = (android.app.Application) r2     // Catch:{ all -> 0x0019 }
            r2.registerActivityLifecycleCallbacks(r1)     // Catch:{ all -> 0x0019 }
            r2 = 1
            r1.mRegistered = r2     // Catch:{ all -> 0x0019 }
        L_0x0017:
            monitor-exit(r1)
            return
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.internal.zza.zze(android.content.Context):void");
    }

    public final void zzb(@NonNull String str, long j) {
        synchronized (this.zzck) {
            Long l = this.zzck.get(str);
            if (l == null) {
                this.zzck.put(str, 1L);
            } else {
                this.zzck.put(str, Long.valueOf(l.longValue() + 1));
            }
        }
    }

    public final void zzc(int i) {
        this.zzcl.addAndGet(1);
    }

    public synchronized void onActivityStarted(Activity activity) {
        if (zza(activity) && this.zzce.zzp()) {
            this.zzcp.add(activity);
            zzbo();
            Trace trace = new Trace(zzb(activity), this.zzcd, this.zzcf, this);
            trace.start();
            this.zzcq.put(activity, trace);
        }
    }

    public synchronized void onActivityStopped(Activity activity) {
        Trace trace;
        int i;
        int i2;
        int i3;
        SparseIntArray sparseIntArray;
        if (zza(activity) && this.zzcq.containsKey(activity) && (trace = this.zzcq.get(activity)) != null) {
            this.zzcq.remove(activity);
            SparseIntArray[] remove = this.zzcp.remove(activity);
            if (remove == null || (sparseIntArray = remove[0]) == null) {
                i3 = 0;
                i2 = 0;
                i = 0;
            } else {
                i3 = 0;
                i2 = 0;
                i = 0;
                for (int i4 = 0; i4 < sparseIntArray.size(); i4++) {
                    int keyAt = sparseIntArray.keyAt(i4);
                    int valueAt = sparseIntArray.valueAt(i4);
                    i3 += valueAt;
                    if (keyAt > 700) {
                        i += valueAt;
                    }
                    if (keyAt > 16) {
                        i2 += valueAt;
                    }
                }
            }
            if (i3 > 0) {
                trace.putMetric(zzbm.FRAMES_TOTAL.toString(), (long) i3);
            }
            if (i2 > 0) {
                trace.putMetric(zzbm.FRAMES_SLOW.toString(), (long) i2);
            }
            if (i > 0) {
                trace.putMetric(zzbm.FRAMES_FROZEN.toString(), (long) i);
            }
            if (zzca.zzg(activity.getApplicationContext())) {
                String zzb = zzb(activity);
                StringBuilder sb = new StringBuilder(String.valueOf(zzb).length() + 81);
                sb.append("sendScreenTrace name:");
                sb.append(zzb);
                sb.append(" _fr_tot:");
                sb.append(i3);
                sb.append(" _fr_slo:");
                sb.append(i2);
                sb.append(" _fr_fzn:");
                sb.append(i);
                Log.d("FirebasePerformance", sb.toString());
            }
            trace.stop();
        }
        if (this.zzch.containsKey(activity)) {
            this.zzch.remove(activity);
            if (this.zzch.isEmpty()) {
                this.zzci = new zzbw();
                zzb(zzcg.BACKGROUND);
                zzb(false);
                zza(zzbl.FOREGROUND_TRACE_NAME.toString(), this.zzcj, this.zzci);
            }
        }
    }

    public synchronized void onActivityResumed(Activity activity) {
        if (this.zzch.isEmpty()) {
            this.zzcj = new zzbw();
            this.zzch.put(activity, true);
            zzb(zzcg.FOREGROUND);
            zzb(true);
            if (this.zzcg) {
                this.zzcg = false;
            } else {
                zza(zzbl.BACKGROUND_TRACE_NAME.toString(), this.zzci, this.zzcj);
            }
        } else {
            this.zzch.put(activity, true);
        }
    }

    public final boolean zzbm() {
        return this.zzcg;
    }

    public final zzcg zzbn() {
        return this.zzcm;
    }

    public final void zza(WeakReference<C5081zza> weakReference) {
        synchronized (this.zzcn) {
            this.zzcn.add(weakReference);
        }
    }

    public final void zzb(WeakReference<C5081zza> weakReference) {
        synchronized (this.zzcn) {
            this.zzcn.remove(weakReference);
        }
    }

    private final void zzb(zzcg zzcg2) {
        this.zzcm = zzcg2;
        synchronized (this.zzcn) {
            Iterator<WeakReference<C5081zza>> it = this.zzcn.iterator();
            while (it.hasNext()) {
                C5081zza zza = (C5081zza) it.next().get();
                if (zza != null) {
                    zza.zza(this.zzcm);
                } else {
                    it.remove();
                }
            }
        }
    }

    private final void zza(String str, zzbw zzbw, zzbw zzbw2) {
        if (this.zzce.zzp()) {
            zzbo();
            zzdm.zza zzb = zzdm.zzfy().zzah(str).zzao(zzbw.zzdb()).zzap(zzbw.zzk(zzbw2)).zzb(SessionManager.zzcm().zzcn().zzch());
            int andSet = this.zzcl.getAndSet(0);
            synchronized (this.zzck) {
                zzb.zzd(this.zzck);
                if (andSet != 0) {
                    zzb.zzc(zzbm.TRACE_STARTED_NOT_STOPPED.toString(), (long) andSet);
                }
                this.zzck.clear();
            }
            zzd zzd = this.zzcd;
            if (zzd != null) {
                zzd.zza((zzdm) ((zzfi) zzb.zzhm()), zzcg.FOREGROUND_BACKGROUND);
            }
        }
    }

    private final void zzb(boolean z) {
        zzbo();
        zzd zzd = this.zzcd;
        if (zzd != null) {
            zzd.zzc(z);
        }
    }

    private final void zzbo() {
        if (this.zzcd == null) {
            this.zzcd = zzd.zzbs();
        }
    }

    private final boolean zza(Activity activity) {
        return (!this.zzco || activity.getWindow() == null || (activity.getWindow().getAttributes().flags & 16777216) == 0) ? false : true;
    }

    private static boolean zzbp() {
        try {
            Class.forName("androidx.core.app.FrameMetricsAggregator");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private static String zzb(Activity activity) {
        String valueOf = String.valueOf(activity.getClass().getSimpleName());
        return valueOf.length() != 0 ? "_st_".concat(valueOf) : new String("_st_");
    }
}
