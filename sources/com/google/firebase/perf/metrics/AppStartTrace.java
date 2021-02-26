package com.google.firebase.perf.metrics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.p010firebaseperf.zzbk;
import com.google.android.gms.internal.p010firebaseperf.zzbw;
import com.google.firebase.perf.internal.zzd;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public class AppStartTrace implements Application.ActivityLifecycleCallbacks {
    private static final long zzfn = TimeUnit.MINUTES.toMicros(1);
    private static volatile AppStartTrace zzfo;
    private boolean mRegistered = false;
    private zzd zzcd = null;
    private final zzbk zzcf;
    private Context zzfp;
    private WeakReference<Activity> zzfq;
    private WeakReference<Activity> zzfr;
    private boolean zzfs = false;
    /* access modifiers changed from: private */
    public zzbw zzft = null;
    private zzbw zzfu = null;
    private zzbw zzfv = null;
    /* access modifiers changed from: private */
    public boolean zzfw = false;

    @Keep
    public static void setLauncherActivityOnCreateTime(String str) {
    }

    @Keep
    public static void setLauncherActivityOnResumeTime(String str) {
    }

    @Keep
    public static void setLauncherActivityOnStartTime(String str) {
    }

    public void onActivityDestroyed(Activity activity) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    public static class zza implements Runnable {
        private final AppStartTrace zzfm;

        public zza(AppStartTrace appStartTrace) {
            this.zzfm = appStartTrace;
        }

        public final void run() {
            if (this.zzfm.zzft == null) {
                boolean unused = this.zzfm.zzfw = true;
            }
        }
    }

    public static AppStartTrace zzcq() {
        if (zzfo != null) {
            return zzfo;
        }
        return zza((zzd) null, new zzbk());
    }

    private static AppStartTrace zza(zzd zzd, zzbk zzbk) {
        if (zzfo == null) {
            synchronized (AppStartTrace.class) {
                if (zzfo == null) {
                    zzfo = new AppStartTrace((zzd) null, zzbk);
                }
            }
        }
        return zzfo;
    }

    private AppStartTrace(@Nullable zzd zzd, @NonNull zzbk zzbk) {
        this.zzcf = zzbk;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zze(@androidx.annotation.NonNull android.content.Context r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.mRegistered     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            android.content.Context r2 = r2.getApplicationContext()     // Catch:{ all -> 0x001c }
            boolean r0 = r2 instanceof android.app.Application     // Catch:{ all -> 0x001c }
            if (r0 == 0) goto L_0x001a
            r0 = r2
            android.app.Application r0 = (android.app.Application) r0     // Catch:{ all -> 0x001c }
            r0.registerActivityLifecycleCallbacks(r1)     // Catch:{ all -> 0x001c }
            r0 = 1
            r1.mRegistered = r0     // Catch:{ all -> 0x001c }
            r1.zzfp = r2     // Catch:{ all -> 0x001c }
        L_0x001a:
            monitor-exit(r1)
            return
        L_0x001c:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.zze(android.content.Context):void");
    }

    private final synchronized void zzcr() {
        if (this.mRegistered) {
            ((Application) this.zzfp).unregisterActivityLifecycleCallbacks(this);
            this.mRegistered = false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002c, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002e, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onActivityCreated(android.app.Activity r4, android.os.Bundle r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r5 = r3.zzfw     // Catch:{ all -> 0x002f }
            if (r5 != 0) goto L_0x002d
            com.google.android.gms.internal.firebase-perf.zzbw r5 = r3.zzft     // Catch:{ all -> 0x002f }
            if (r5 == 0) goto L_0x000a
            goto L_0x002d
        L_0x000a:
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x002f }
            r5.<init>(r4)     // Catch:{ all -> 0x002f }
            r3.zzfq = r5     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.firebase-perf.zzbw r4 = new com.google.android.gms.internal.firebase-perf.zzbw     // Catch:{ all -> 0x002f }
            r4.<init>()     // Catch:{ all -> 0x002f }
            r3.zzft = r4     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.firebase-perf.zzbw r4 = com.google.firebase.perf.provider.FirebasePerfProvider.zzcz()     // Catch:{ all -> 0x002f }
            com.google.android.gms.internal.firebase-perf.zzbw r5 = r3.zzft     // Catch:{ all -> 0x002f }
            long r4 = r4.zzk(r5)     // Catch:{ all -> 0x002f }
            long r0 = zzfn     // Catch:{ all -> 0x002f }
            int r2 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r2 <= 0) goto L_0x002b
            r4 = 1
            r3.zzfs = r4     // Catch:{ all -> 0x002f }
        L_0x002b:
            monitor-exit(r3)
            return
        L_0x002d:
            monitor-exit(r3)
            return
        L_0x002f:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.onActivityCreated(android.app.Activity, android.os.Bundle):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0018, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onActivityStarted(android.app.Activity r1) {
        /*
            r0 = this;
            monitor-enter(r0)
            boolean r1 = r0.zzfw     // Catch:{ all -> 0x0019 }
            if (r1 != 0) goto L_0x0017
            com.google.android.gms.internal.firebase-perf.zzbw r1 = r0.zzfu     // Catch:{ all -> 0x0019 }
            if (r1 != 0) goto L_0x0017
            boolean r1 = r0.zzfs     // Catch:{ all -> 0x0019 }
            if (r1 == 0) goto L_0x000e
            goto L_0x0017
        L_0x000e:
            com.google.android.gms.internal.firebase-perf.zzbw r1 = new com.google.android.gms.internal.firebase-perf.zzbw     // Catch:{ all -> 0x0019 }
            r1.<init>()     // Catch:{ all -> 0x0019 }
            r0.zzfu = r1     // Catch:{ all -> 0x0019 }
            monitor-exit(r0)
            return
        L_0x0017:
            monitor-exit(r0)
            return
        L_0x0019:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.onActivityStarted(android.app.Activity):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0143, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0145, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onActivityResumed(android.app.Activity r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.zzfw     // Catch:{ all -> 0x0146 }
            if (r0 != 0) goto L_0x0144
            com.google.android.gms.internal.firebase-perf.zzbw r0 = r6.zzfv     // Catch:{ all -> 0x0146 }
            if (r0 != 0) goto L_0x0144
            boolean r0 = r6.zzfs     // Catch:{ all -> 0x0146 }
            if (r0 == 0) goto L_0x000f
            goto L_0x0144
        L_0x000f:
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0146 }
            r0.<init>(r7)     // Catch:{ all -> 0x0146 }
            r6.zzfr = r0     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzbw r0 = new com.google.android.gms.internal.firebase-perf.zzbw     // Catch:{ all -> 0x0146 }
            r0.<init>()     // Catch:{ all -> 0x0146 }
            r6.zzfv = r0     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzbw r0 = com.google.firebase.perf.provider.FirebasePerfProvider.zzcz()     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzbi r1 = com.google.android.gms.internal.p010firebaseperf.zzbi.zzcl()     // Catch:{ all -> 0x0146 }
            java.lang.Class r7 = r7.getClass()     // Catch:{ all -> 0x0146 }
            java.lang.String r7 = r7.getName()     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzbw r2 = r6.zzfv     // Catch:{ all -> 0x0146 }
            long r2 = r0.zzk(r2)     // Catch:{ all -> 0x0146 }
            java.lang.String r4 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0146 }
            int r4 = r4.length()     // Catch:{ all -> 0x0146 }
            int r4 = r4 + 47
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0146 }
            r5.<init>(r4)     // Catch:{ all -> 0x0146 }
            java.lang.String r4 = "onResume(): "
            r5.append(r4)     // Catch:{ all -> 0x0146 }
            r5.append(r7)     // Catch:{ all -> 0x0146 }
            java.lang.String r7 = ": "
            r5.append(r7)     // Catch:{ all -> 0x0146 }
            r5.append(r2)     // Catch:{ all -> 0x0146 }
            java.lang.String r7 = " microseconds"
            r5.append(r7)     // Catch:{ all -> 0x0146 }
            java.lang.String r7 = r5.toString()     // Catch:{ all -> 0x0146 }
            r1.zzm(r7)     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzdm$zza r7 = com.google.android.gms.internal.p010firebaseperf.zzdm.zzfy()     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzbl r1 = com.google.android.gms.internal.p010firebaseperf.zzbl.APP_START_TRACE_NAME     // Catch:{ all -> 0x0146 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzdm$zza r7 = r7.zzah(r1)     // Catch:{ all -> 0x0146 }
            long r1 = r0.zzdb()     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzdm$zza r7 = r7.zzao(r1)     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzbw r1 = r6.zzfv     // Catch:{ all -> 0x0146 }
            long r1 = r0.zzk(r1)     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzdm$zza r7 = r7.zzap(r1)     // Catch:{ all -> 0x0146 }
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0146 }
            r2 = 3
            r1.<init>(r2)     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzdm$zza r2 = com.google.android.gms.internal.p010firebaseperf.zzdm.zzfy()     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzbl r3 = com.google.android.gms.internal.p010firebaseperf.zzbl.ON_CREATE_TRACE_NAME     // Catch:{ all -> 0x0146 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzdm$zza r2 = r2.zzah(r3)     // Catch:{ all -> 0x0146 }
            long r3 = r0.zzdb()     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzdm$zza r2 = r2.zzao(r3)     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzbw r3 = r6.zzft     // Catch:{ all -> 0x0146 }
            long r3 = r0.zzk(r3)     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzdm$zza r0 = r2.zzap(r3)     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzgs r0 = r0.zzhm()     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzfi r0 = (com.google.android.gms.internal.p010firebaseperf.zzfi) r0     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzdm r0 = (com.google.android.gms.internal.p010firebaseperf.zzdm) r0     // Catch:{ all -> 0x0146 }
            r1.add(r0)     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzdm$zza r0 = com.google.android.gms.internal.p010firebaseperf.zzdm.zzfy()     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzbl r2 = com.google.android.gms.internal.p010firebaseperf.zzbl.ON_START_TRACE_NAME     // Catch:{ all -> 0x0146 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzdm$zza r2 = r0.zzah(r2)     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzbw r3 = r6.zzft     // Catch:{ all -> 0x0146 }
            long r3 = r3.zzdb()     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzdm$zza r2 = r2.zzao(r3)     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzbw r3 = r6.zzft     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzbw r4 = r6.zzfu     // Catch:{ all -> 0x0146 }
            long r3 = r3.zzk(r4)     // Catch:{ all -> 0x0146 }
            r2.zzap(r3)     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzgs r0 = r0.zzhm()     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzfi r0 = (com.google.android.gms.internal.p010firebaseperf.zzfi) r0     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzdm r0 = (com.google.android.gms.internal.p010firebaseperf.zzdm) r0     // Catch:{ all -> 0x0146 }
            r1.add(r0)     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzdm$zza r0 = com.google.android.gms.internal.p010firebaseperf.zzdm.zzfy()     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzbl r2 = com.google.android.gms.internal.p010firebaseperf.zzbl.ON_RESUME_TRACE_NAME     // Catch:{ all -> 0x0146 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzdm$zza r2 = r0.zzah(r2)     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzbw r3 = r6.zzfu     // Catch:{ all -> 0x0146 }
            long r3 = r3.zzdb()     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzdm$zza r2 = r2.zzao(r3)     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzbw r3 = r6.zzfu     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzbw r4 = r6.zzfv     // Catch:{ all -> 0x0146 }
            long r3 = r3.zzk(r4)     // Catch:{ all -> 0x0146 }
            r2.zzap(r3)     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzgs r0 = r0.zzhm()     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzfi r0 = (com.google.android.gms.internal.p010firebaseperf.zzfi) r0     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzdm r0 = (com.google.android.gms.internal.p010firebaseperf.zzdm) r0     // Catch:{ all -> 0x0146 }
            r1.add(r0)     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzdm$zza r0 = r7.zzd((java.lang.Iterable<? extends com.google.android.gms.internal.p010firebaseperf.zzdm>) r1)     // Catch:{ all -> 0x0146 }
            com.google.firebase.perf.internal.SessionManager r1 = com.google.firebase.perf.internal.SessionManager.zzcm()     // Catch:{ all -> 0x0146 }
            com.google.firebase.perf.internal.zzr r1 = r1.zzcn()     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzde r1 = r1.zzch()     // Catch:{ all -> 0x0146 }
            r0.zzb(r1)     // Catch:{ all -> 0x0146 }
            com.google.firebase.perf.internal.zzd r0 = r6.zzcd     // Catch:{ all -> 0x0146 }
            if (r0 != 0) goto L_0x0128
            com.google.firebase.perf.internal.zzd r0 = com.google.firebase.perf.internal.zzd.zzbs()     // Catch:{ all -> 0x0146 }
            r6.zzcd = r0     // Catch:{ all -> 0x0146 }
        L_0x0128:
            com.google.firebase.perf.internal.zzd r0 = r6.zzcd     // Catch:{ all -> 0x0146 }
            if (r0 == 0) goto L_0x013b
            com.google.firebase.perf.internal.zzd r0 = r6.zzcd     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzgs r7 = r7.zzhm()     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzfi r7 = (com.google.android.gms.internal.p010firebaseperf.zzfi) r7     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzdm r7 = (com.google.android.gms.internal.p010firebaseperf.zzdm) r7     // Catch:{ all -> 0x0146 }
            com.google.android.gms.internal.firebase-perf.zzcg r1 = com.google.android.gms.internal.p010firebaseperf.zzcg.FOREGROUND_BACKGROUND     // Catch:{ all -> 0x0146 }
            r0.zza((com.google.android.gms.internal.p010firebaseperf.zzdm) r7, (com.google.android.gms.internal.p010firebaseperf.zzcg) r1)     // Catch:{ all -> 0x0146 }
        L_0x013b:
            boolean r7 = r6.mRegistered     // Catch:{ all -> 0x0146 }
            if (r7 == 0) goto L_0x0142
            r6.zzcr()     // Catch:{ all -> 0x0146 }
        L_0x0142:
            monitor-exit(r6)
            return
        L_0x0144:
            monitor-exit(r6)
            return
        L_0x0146:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.metrics.AppStartTrace.onActivityResumed(android.app.Activity):void");
    }

    public synchronized void onActivityStopped(Activity activity) {
    }
}
