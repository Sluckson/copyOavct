package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.5.0 */
public final class zziy<K, V> {
    static <K, V> void zza(zzhf zzhf, zzix<K, V> zzix, K k, V v) throws IOException {
        zzho.zza(zzhf, zzix.zza, 1, k);
        zzho.zza(zzhf, zzix.zzc, 2, v);
    }

    static <K, V> int zza(zzix<K, V> zzix, K k, V v) {
        return zzho.zza(zzix.zza, 1, k) + zzho.zza(zzix.zzc, 2, v);
    }
}
