package com.google.android.gms.internal.p010firebaseperf;

import com.google.android.gms.internal.p010firebaseperf.zzfi;
import java.io.IOException;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzey */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzey extends zzez<zzfi.zze> {
    zzey() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zze(zzgs zzgs) {
        return zzgs instanceof zzfi.zzb;
    }

    /* access modifiers changed from: package-private */
    public final zzfa<zzfi.zze> zzd(Object obj) {
        return ((zzfi.zzb) obj).zzqy;
    }

    /* access modifiers changed from: package-private */
    public final zzfa<zzfi.zze> zze(Object obj) {
        zzfi.zzb zzb = (zzfi.zzb) obj;
        if (zzb.zzqy.isImmutable()) {
            zzb.zzqy = (zzfa) zzb.zzqy.clone();
        }
        return zzb.zzqy;
    }

    /* access modifiers changed from: package-private */
    public final void zzf(Object obj) {
        zzd(obj).zzgk();
    }

    /* access modifiers changed from: package-private */
    public final int zzb(Map.Entry<?, ?> entry) {
        zzfi.zze zze = (zzfi.zze) entry.getKey();
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zziu zziu, Map.Entry<?, ?> entry) throws IOException {
        zzfi.zze zze = (zzfi.zze) entry.getKey();
        throw new NoSuchMethodError();
    }
}
