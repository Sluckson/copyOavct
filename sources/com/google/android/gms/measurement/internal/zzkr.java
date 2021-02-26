package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
final class zzkr implements zzfc {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzkp zzb;

    zzkr(zzkp zzkp, String str) {
        this.zzb = zzkp;
        this.zza = str;
    }

    public final void zza(String str, int i, Throwable th, byte[] bArr, Map<String, List<String>> map) {
        this.zzb.zza(i, th, bArr, this.zza);
    }
}
