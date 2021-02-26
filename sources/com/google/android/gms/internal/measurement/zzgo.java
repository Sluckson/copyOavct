package com.google.android.gms.internal.measurement;

import java.util.Comparator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.5.0 */
final class zzgo implements Comparator<zzgm> {
    zzgo() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzgm zzgm = (zzgm) obj;
        zzgm zzgm2 = (zzgm) obj2;
        zzgv zzgv = (zzgv) zzgm.iterator();
        zzgv zzgv2 = (zzgv) zzgm2.iterator();
        while (zzgv.hasNext() && zzgv2.hasNext()) {
            int compare = Integer.compare(zzgm.zzb(zzgv.zza()), zzgm.zzb(zzgv2.zza()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzgm.zza(), zzgm2.zza());
    }
}
