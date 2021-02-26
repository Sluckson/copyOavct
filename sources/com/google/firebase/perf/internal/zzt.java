package com.google.firebase.perf.internal;

import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.internal.p010firebaseperf.zzah;
import com.google.android.gms.internal.p010firebaseperf.zzbk;
import com.google.android.gms.internal.p010firebaseperf.zzbl;
import com.google.android.gms.internal.p010firebaseperf.zzca;
import com.google.android.gms.internal.p010firebaseperf.zzd;
import com.google.android.gms.internal.p010firebaseperf.zzdd;
import com.google.android.gms.internal.p010firebaseperf.zzde;
import com.google.android.gms.internal.p010firebaseperf.zzdl;
import java.util.List;
import java.util.Random;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzt {
    private final zzah zzac;
    private boolean zzdi;
    private final float zzeo;
    private zzv zzep;
    private zzv zzeq;

    public zzt(@NonNull Context context, double d, long j) {
        this(100.0d, 500, new zzbk(), new Random().nextFloat(), zzah.zzo());
        this.zzdi = zzca.zzg(context);
    }

    private zzt(double d, long j, zzbk zzbk, float f, zzah zzah) {
        float f2 = f;
        boolean z = false;
        this.zzdi = false;
        this.zzep = null;
        this.zzeq = null;
        if (0.0f <= f2 && f2 < 1.0f) {
            z = true;
        }
        zzd.checkArgument(z, "Sampling bucket ID should be in range [0.0f, 1.0f).");
        this.zzeo = f2;
        this.zzac = zzah;
        zzbk zzbk2 = zzbk;
        zzah zzah2 = zzah;
        this.zzep = new zzv(100.0d, 500, zzbk2, zzah2, "Trace", this.zzdi);
        this.zzeq = new zzv(100.0d, 500, zzbk2, zzah2, "Network", this.zzdi);
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb(zzdd zzdd) {
        if (zzdd.zzfg()) {
            if (!(this.zzeo < this.zzac.zzt()) && !zzb(zzdd.zzfh().zzey())) {
                return false;
            }
        }
        if (zzdd.zzfi()) {
            if (!(this.zzeo < this.zzac.zzu()) && !zzb(zzdd.zzfj().zzey())) {
                return false;
            }
        }
        if (!((!zzdd.zzfg() || ((!zzdd.zzfh().getName().equals(zzbl.FOREGROUND_TRACE_NAME.toString()) && !zzdd.zzfh().getName().equals(zzbl.BACKGROUND_TRACE_NAME.toString())) || zzdd.zzfh().zzfr() <= 0)) && !zzdd.zzfk())) {
            return true;
        }
        if (zzdd.zzfi()) {
            return this.zzeq.zzb(zzdd);
        }
        if (zzdd.zzfg()) {
            return this.zzep.zzb(zzdd);
        }
        return false;
    }

    private static boolean zzb(List<zzde> list) {
        if (list.size() <= 0 || list.get(0).zzfo() <= 0 || list.get(0).zzn(0) != zzdl.GAUGES_AND_SYSTEM_EVENTS) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void zzc(boolean z) {
        this.zzep.zzc(z);
        this.zzeq.zzc(z);
    }
}
