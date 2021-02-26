package com.google.android.gms.internal.p010firebaseperf;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzhd */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzhd {
    private static final zzhd zztu = new zzhd();
    private final zzhh zztv = new zzgf();
    private final ConcurrentMap<Class<?>, zzhi<?>> zztw = new ConcurrentHashMap();

    public static zzhd zzip() {
        return zztu;
    }

    public final <T> zzhi<T> zze(Class<T> cls) {
        zzfj.checkNotNull(cls, "messageType");
        zzhi<T> zzhi = (zzhi) this.zztw.get(cls);
        if (zzhi != null) {
            return zzhi;
        }
        zzhi<T> zzd = this.zztv.zzd(cls);
        zzfj.checkNotNull(cls, "messageType");
        zzfj.checkNotNull(zzd, "schema");
        zzhi<T> putIfAbsent = this.zztw.putIfAbsent(cls, zzd);
        return putIfAbsent != null ? putIfAbsent : zzd;
    }

    public final <T> zzhi<T> zzo(T t) {
        return zze(t.getClass());
    }

    private zzhd() {
    }
}
