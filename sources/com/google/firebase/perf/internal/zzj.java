package com.google.firebase.perf.internal;

import com.google.android.gms.internal.p010firebaseperf.zzcq;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzj extends zzs {
    private final zzcq zzdp;

    zzj(zzcq zzcq) {
        this.zzdp = zzcq;
    }

    public final boolean zzbx() {
        if (!this.zzdp.zzdx()) {
            return false;
        }
        if (this.zzdp.zzeb() > 0 || this.zzdp.zzec() > 0) {
            return true;
        }
        return this.zzdp.zzdz() && this.zzdp.zzea().zzdt();
    }
}
