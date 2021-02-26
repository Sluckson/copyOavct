package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.5.0 */
final class zzkb extends zzkh {
    private final /* synthetic */ zzka zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzkb(zzka zzka) {
        super(zzka, (zzjz) null);
        this.zza = zzka;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzkc(this.zza, (zzjz) null);
    }

    /* synthetic */ zzkb(zzka zzka, zzjz zzjz) {
        this(zzka);
    }
}
