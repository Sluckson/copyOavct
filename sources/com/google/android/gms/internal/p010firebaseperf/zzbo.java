package com.google.android.gms.internal.p010firebaseperf;

import android.os.Bundle;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzbo */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzbo {
    private zzbi zzaj;
    private final Bundle zzhr;

    public zzbo() {
        this(new Bundle());
    }

    public zzbo(Bundle bundle) {
        this.zzhr = (Bundle) bundle.clone();
        this.zzaj = zzbi.zzcl();
    }

    private final boolean containsKey(String str) {
        return str != null && this.zzhr.containsKey(str);
    }

    public final zzbn<Boolean> zzb(String str) {
        if (!containsKey(str)) {
            return zzbn.zzda();
        }
        try {
            return zzbn.zzc((Boolean) this.zzhr.get(str));
        } catch (ClassCastException e) {
            this.zzaj.zzm(String.format("Metadata key %s contains type other than boolean: %s", new Object[]{str, e.getMessage()}));
            return zzbn.zzda();
        }
    }

    public final zzbn<Float> zzd(String str) {
        if (!containsKey(str)) {
            return zzbn.zzda();
        }
        try {
            return zzbn.zzc((Float) this.zzhr.get(str));
        } catch (ClassCastException e) {
            this.zzaj.zzm(String.format("Metadata key %s contains type other than float: %s", new Object[]{str, e.getMessage()}));
            return zzbn.zzda();
        }
    }

    public final zzbn<Long> zze(String str) {
        zzbn<Integer> zzp = zzp(str);
        if (zzp.isPresent()) {
            return zzbn.zzb(Long.valueOf((long) zzp.get().intValue()));
        }
        return zzbn.zzda();
    }

    private final zzbn<Integer> zzp(String str) {
        if (!containsKey(str)) {
            return zzbn.zzda();
        }
        try {
            return zzbn.zzc((Integer) this.zzhr.get(str));
        } catch (ClassCastException e) {
            this.zzaj.zzm(String.format("Metadata key %s contains type other than int: %s", new Object[]{str, e.getMessage()}));
            return zzbn.zzda();
        }
    }
}
