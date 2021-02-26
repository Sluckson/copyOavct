package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzgk */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzgk<K, V> {
    private final V value;
    private final zzgj<K, V> zzsu;
    private final K zzsv;

    private zzgk(zzio zzio, K k, zzio zzio2, V v) {
        this.zzsu = new zzgj<>(zzio, k, zzio2, v);
        this.zzsv = k;
        this.value = v;
    }

    public static <K, V> zzgk<K, V> zza(zzio zzio, K k, zzio zzio2, V v) {
        return new zzgk<>(zzio, k, zzio2, v);
    }

    static <K, V> int zza(zzgj<K, V> zzgj, K k, V v) {
        return zzfa.zza(zzgj.zzsq, 1, k) + zzfa.zza(zzgj.zzss, 2, v);
    }

    public final int zza(int i, K k, V v) {
        return zzev.zzy(i) + zzev.zzaf(zza(this.zzsu, k, v));
    }

    /* access modifiers changed from: package-private */
    public final zzgj<K, V> zzic() {
        return this.zzsu;
    }
}
