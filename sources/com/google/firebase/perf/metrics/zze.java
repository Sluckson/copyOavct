package com.google.firebase.perf.metrics;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.p010firebaseperf.zzde;
import com.google.android.gms.internal.p010firebaseperf.zzdm;
import com.google.android.gms.internal.p010firebaseperf.zzfi;
import com.google.firebase.perf.internal.zzr;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zze {
    private final Trace zzgm;

    zze(@NonNull Trace trace) {
        this.zzgm = trace;
    }

    /* access modifiers changed from: package-private */
    public final zzdm zzcx() {
        zzdm.zza zzap = zzdm.zzfy().zzah(this.zzgm.getName()).zzao(this.zzgm.zzct().zzdb()).zzap(this.zzgm.zzct().zzk(this.zzgm.zzcu()));
        for (zzb next : this.zzgm.zzcs().values()) {
            zzap.zzc(next.getName(), next.getCount());
        }
        List<Trace> zzcv = this.zzgm.zzcv();
        if (!zzcv.isEmpty()) {
            for (Trace zze : zzcv) {
                zzap.zzf(new zze(zze).zzcx());
            }
        }
        zzap.zze(this.zzgm.getAttributes());
        zzde[] zza = zzr.zza(this.zzgm.zzcw());
        if (zza != null) {
            zzap.zze((Iterable<? extends zzde>) Arrays.asList(zza));
        }
        return (zzdm) ((zzfi) zzap.zzhm());
    }
}
