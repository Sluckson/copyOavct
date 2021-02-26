package com.google.android.gms.internal.p010firebaseperf;

import java.util.Comparator;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzeg */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzeg implements Comparator<zzee> {
    zzeg() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzee zzee = (zzee) obj;
        zzee zzee2 = (zzee) obj2;
        zzen zzen = (zzen) zzee.iterator();
        zzen zzen2 = (zzen) zzee2.iterator();
        while (zzen.hasNext() && zzen2.hasNext()) {
            int compare = Integer.compare(zzee.zza(zzen.nextByte()), zzee.zza(zzen2.nextByte()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzee.size(), zzee2.size());
    }
}
