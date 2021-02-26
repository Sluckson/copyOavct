package com.google.firebase.perf.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.p010firebaseperf.zzbq;
import com.google.android.gms.internal.p010firebaseperf.zzx;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzq {
    private final Runtime zzbs;
    private final ActivityManager zzeh;
    private final ActivityManager.MemoryInfo zzei;
    private final String zzej;
    private final Context zzek;

    zzq(Context context) {
        this(Runtime.getRuntime(), context);
    }

    @VisibleForTesting
    private zzq(Runtime runtime, Context context) {
        String str;
        this.zzbs = runtime;
        this.zzek = context;
        this.zzeh = (ActivityManager) context.getSystemService("activity");
        this.zzei = new ActivityManager.MemoryInfo();
        this.zzeh.getMemoryInfo(this.zzei);
        int myPid = Process.myPid();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = this.zzeh.getRunningAppProcesses();
        if (runningAppProcesses != null) {
            Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ActivityManager.RunningAppProcessInfo next = it.next();
                if (next.pid == myPid) {
                    str = next.processName;
                    break;
                }
            }
            this.zzej = str;
        }
        str = this.zzek.getPackageName();
        this.zzej = str;
    }

    public final String getProcessName() {
        return this.zzej;
    }

    public final int zzca() {
        return zzx.zza(zzbq.BYTES.zzt(this.zzbs.maxMemory()));
    }

    public final int zzcb() {
        return zzx.zza(zzbq.MEGABYTES.zzt((long) this.zzeh.getMemoryClass()));
    }

    public final int zzcc() {
        return zzx.zza(zzbq.BYTES.zzt(this.zzei.totalMem));
    }
}
