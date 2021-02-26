package com.google.android.gms.internal.p010firebaseperf;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzgv */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzgv<T> implements zzhi<T> {
    private final zzgs zzsz;
    private final zzia<?, ?> zzta;
    private final boolean zztb;
    private final zzez<?> zztc;

    private zzgv(zzia<?, ?> zzia, zzez<?> zzez, zzgs zzgs) {
        this.zzta = zzia;
        this.zztb = zzez.zze(zzgs);
        this.zztc = zzez;
        this.zzsz = zzgs;
    }

    static <T> zzgv<T> zza(zzia<?, ?> zzia, zzez<?> zzez, zzgs zzgs) {
        return new zzgv<>(zzia, zzez, zzgs);
    }

    public final boolean equals(T t, T t2) {
        if (!this.zzta.zzp(t).equals(this.zzta.zzp(t2))) {
            return false;
        }
        if (this.zztb) {
            return this.zztc.zzd(t).equals(this.zztc.zzd(t2));
        }
        return true;
    }

    public final int hashCode(T t) {
        int hashCode = this.zzta.zzp(t).hashCode();
        return this.zztb ? (hashCode * 53) + this.zztc.zzd(t).hashCode() : hashCode;
    }

    public final void zzd(T t, T t2) {
        zzhk.zza(this.zzta, t, t2);
        if (this.zztb) {
            zzhk.zza(this.zztc, t, t2);
        }
    }

    public final void zza(T t, zziu zziu) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.zztc.zzd(t).iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            zzfc zzfc = (zzfc) next.getKey();
            if (zzfc.zzhe() != zzir.MESSAGE || zzfc.zzhf() || zzfc.zzhg()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzfv) {
                zziu.zza(zzfc.getNumber(), (Object) ((zzfv) next).zzhw().zzge());
            } else {
                zziu.zza(zzfc.getNumber(), next.getValue());
            }
        }
        zzia<?, ?> zzia = this.zzta;
        zzia.zzc(zzia.zzp(t), zziu);
    }

    public final void zzf(T t) {
        this.zzta.zzf(t);
        this.zztc.zzf(t);
    }

    public final boolean zzm(T t) {
        return this.zztc.zzd(t).isInitialized();
    }

    public final int zzn(T t) {
        zzia<?, ?> zzia = this.zzta;
        int zzq = zzia.zzq(zzia.zzp(t)) + 0;
        return this.zztb ? zzq + this.zztc.zzd(t).zzgz() : zzq;
    }
}
