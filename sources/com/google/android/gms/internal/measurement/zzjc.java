package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.5.0 */
final class zzjc implements zziz {
    zzjc() {
    }

    public final Map<?, ?> zza(Object obj) {
        return (zzja) obj;
    }

    public final zzix<?, ?> zzf(Object obj) {
        zziy zziy = (zziy) obj;
        throw new NoSuchMethodError();
    }

    public final Map<?, ?> zzb(Object obj) {
        return (zzja) obj;
    }

    public final boolean zzc(Object obj) {
        return !((zzja) obj).zzd();
    }

    public final Object zzd(Object obj) {
        ((zzja) obj).zzc();
        return obj;
    }

    public final Object zze(Object obj) {
        return zzja.zza().zzb();
    }

    public final Object zza(Object obj, Object obj2) {
        zzja zzja = (zzja) obj;
        zzja zzja2 = (zzja) obj2;
        if (!zzja2.isEmpty()) {
            if (!zzja.zzd()) {
                zzja = zzja.zzb();
            }
            zzja.zza(zzja2);
        }
        return zzja;
    }

    public final int zza(int i, Object obj, Object obj2) {
        zzja zzja = (zzja) obj;
        zziy zziy = (zziy) obj2;
        if (zzja.isEmpty()) {
            return 0;
        }
        Iterator it = zzja.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
