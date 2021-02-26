package com.google.android.gms.internal.p010firebaseperf;

import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzw */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzw {
    static int zza(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i = ~(~(i + (next != null ? next.hashCode() : 0)));
        }
        return i;
    }

    static boolean zza(Set<?> set, @NullableDecl Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                return set.size() == set2.size() && set.containsAll(set2);
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
    }
}
