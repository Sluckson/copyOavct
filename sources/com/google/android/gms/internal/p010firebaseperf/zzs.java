package com.google.android.gms.internal.p010firebaseperf;

import java.util.Iterator;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzs */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzs<K, V> extends zzn<Map.Entry<K, V>> {
    /* access modifiers changed from: private */
    public final transient int size;
    /* access modifiers changed from: private */
    public final transient Object[] zzm;
    private final transient zzo<K, V> zzq;
    private final transient int zzr = 0;

    zzs(zzo<K, V> zzo, Object[] objArr, int i, int i2) {
        this.zzq = zzo;
        this.zzm = objArr;
        this.size = i2;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzg() {
        return true;
    }

    public final zzv<Map.Entry<K, V>> zzb() {
        return (zzv) zzc().iterator();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        return zzc().zza(objArr, i);
    }

    /* access modifiers changed from: package-private */
    public final zzj<Map.Entry<K, V>> zzh() {
        return new zzr(this);
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value == null || !value.equals(this.zzq.get(key))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int size() {
        return this.size;
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
