package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.5.0 */
final class zziv implements zzjd {
    private zzjd[] zza;

    zziv(zzjd... zzjdArr) {
        this.zza = zzjdArr;
    }

    public final boolean zza(Class<?> cls) {
        for (zzjd zza2 : this.zza) {
            if (zza2.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzje zzb(Class<?> cls) {
        for (zzjd zzjd : this.zza) {
            if (zzjd.zza(cls)) {
                return zzjd.zzb(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
