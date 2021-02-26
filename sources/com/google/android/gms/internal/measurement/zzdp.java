package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzdp {
    private final boolean zza;

    public zzdp(zzdo zzdo) {
        zzdw.zza(zzdo, (Object) "BuildInfo must be non-null");
        this.zza = !zzdo.zza();
    }

    public final boolean zza(String str) {
        zzdw.zza(str, (Object) "flagName must not be null");
        if (!this.zza) {
            return true;
        }
        return zzdr.zza.zza().zza(str);
    }
}
