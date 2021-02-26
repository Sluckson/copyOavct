package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzak {
    final String zza;
    final String zzb;
    final long zzc;
    final long zzd;
    final zzam zze;
    private final String zzf;

    private zzak(zzgb zzgb, String str, String str2, String str3, long j, long j2, zzam zzam) {
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzam);
        this.zza = str2;
        this.zzb = str3;
        this.zzf = TextUtils.isEmpty(str) ? null : str;
        this.zzc = j;
        this.zzd = j2;
        long j3 = this.zzd;
        if (j3 != 0 && j3 > this.zzc) {
            zzgb.zzq().zzh().zza("Event created with reverse previous/current timestamps. appId, name", zzex.zza(str2), zzex.zza(str3));
        }
        this.zze = zzam;
    }

    zzak(zzgb zzgb, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        zzam zzam;
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        this.zza = str2;
        this.zzb = str3;
        this.zzf = TextUtils.isEmpty(str) ? null : str;
        this.zzc = j;
        this.zzd = j2;
        long j3 = this.zzd;
        if (j3 != 0 && j3 > this.zzc) {
            zzgb.zzq().zzh().zza("Event created with reverse previous/current timestamps. appId", zzex.zza(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            zzam = new zzam(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String str4 = (String) it.next();
                if (str4 == null) {
                    zzgb.zzq().zze().zza("Param name can't be null");
                    it.remove();
                } else {
                    Object zza2 = zzgb.zzh().zza(str4, bundle2.get(str4));
                    if (zza2 == null) {
                        zzgb.zzq().zzh().zza("Param value can't be null", zzgb.zzi().zzb(str4));
                        it.remove();
                    } else {
                        zzgb.zzh().zza(bundle2, str4, zza2);
                    }
                }
            }
            zzam = new zzam(bundle2);
        }
        this.zze = zzam;
    }

    /* access modifiers changed from: package-private */
    public final zzak zza(zzgb zzgb, long j) {
        return new zzak(zzgb, this.zzf, this.zza, this.zzb, this.zzc, j, this.zze);
    }

    public final String toString() {
        String str = this.zza;
        String str2 = this.zzb;
        String valueOf = String.valueOf(this.zze);
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 33 + String.valueOf(str2).length() + String.valueOf(valueOf).length());
        sb.append("Event{appId='");
        sb.append(str);
        sb.append("', name='");
        sb.append(str2);
        sb.append("', params=");
        sb.append(valueOf);
        sb.append('}');
        return sb.toString();
    }
}
