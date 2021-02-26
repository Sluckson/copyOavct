package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zznr;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final /* synthetic */ class zzhh implements Runnable {
    private final zzhe zza;
    private final Bundle zzb;

    zzhh(zzhe zzhe, Bundle bundle) {
        this.zza = zzhe;
        this.zzb = bundle;
    }

    public final void run() {
        zzhe zzhe = this.zza;
        Bundle bundle = this.zzb;
        if (zznr.zzb() && zzhe.zzs().zza(zzat.zzcg)) {
            if (bundle == null) {
                zzhe.zzr().zzx.zza(new Bundle());
                return;
            }
            Bundle zza2 = zzhe.zzr().zzx.zza();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    zzhe.zzo();
                    if (zzkx.zza(obj)) {
                        zzhe.zzo().zza(27, (String) null, (String) null, 0);
                    }
                    zzhe.zzq().zzj().zza("Invalid default event parameter type. Name, value", str, obj);
                } else if (zzkx.zzd(str)) {
                    zzhe.zzq().zzj().zza("Invalid default event parameter name. Name", str);
                } else if (obj == null) {
                    zza2.remove(str);
                } else if (zzhe.zzo().zza("param", str, 100, obj)) {
                    zzhe.zzo().zza(zza2, str, obj);
                }
            }
            zzhe.zzo();
            if (zzkx.zza(zza2, zzhe.zzs().zzd())) {
                zzhe.zzo().zza(26, (String) null, (String) null, 0);
                zzhe.zzq().zzj().zza("Too many default event parameters set. Discarding beyond event parameter limit");
            }
            zzhe.zzr().zzx.zza(zza2);
            zzhe.zzg().zza(zza2);
        }
    }
}
