package com.google.android.gms.internal.measurement;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.5.0 */
final class zzjr {
    private static final zzjr zza = new zzjr();
    private final zzjy zzb = new zzit();
    private final ConcurrentMap<Class<?>, zzjv<?>> zzc = new ConcurrentHashMap();

    public static zzjr zza() {
        return zza;
    }

    public final <T> zzjv<T> zza(Class<T> cls) {
        zzhx.zza(cls, "messageType");
        zzjv<T> zzjv = (zzjv) this.zzc.get(cls);
        if (zzjv != null) {
            return zzjv;
        }
        zzjv<T> zza2 = this.zzb.zza(cls);
        zzhx.zza(cls, "messageType");
        zzhx.zza(zza2, "schema");
        zzjv<T> putIfAbsent = this.zzc.putIfAbsent(cls, zza2);
        return putIfAbsent != null ? putIfAbsent : zza2;
    }

    public final <T> zzjv<T> zza(T t) {
        return zza(t.getClass());
    }

    private zzjr() {
    }
}
