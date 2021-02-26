package com.google.firebase.perf.internal;

import androidx.annotation.NonNull;
import com.google.android.gms.internal.p010firebaseperf.zzcg;
import com.google.firebase.perf.internal.zza;
import java.lang.ref.WeakReference;

/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public class zzc implements zza.C5081zza {
    private zza zzct;
    private zzcg zzcu;
    private boolean zzcv;
    private WeakReference<zza.C5081zza> zzcw;

    protected zzc() {
        this(zza.zzbl());
    }

    protected zzc(@NonNull zza zza) {
        this.zzcu = zzcg.APPLICATION_PROCESS_STATE_UNKNOWN;
        this.zzcv = false;
        this.zzct = zza;
        this.zzcw = new WeakReference<>(this);
    }

    /* access modifiers changed from: protected */
    public final void zzbq() {
        if (!this.zzcv) {
            this.zzcu = this.zzct.zzbn();
            this.zzct.zza(this.zzcw);
            this.zzcv = true;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzbr() {
        if (this.zzcv) {
            this.zzct.zzb(this.zzcw);
            this.zzcv = false;
        }
    }

    /* access modifiers changed from: protected */
    public final void zzc(int i) {
        this.zzct.zzc(1);
    }

    public void zza(zzcg zzcg) {
        if (this.zzcu == zzcg.APPLICATION_PROCESS_STATE_UNKNOWN) {
            this.zzcu = zzcg;
        } else if (this.zzcu != zzcg && zzcg != zzcg.APPLICATION_PROCESS_STATE_UNKNOWN) {
            this.zzcu = zzcg.FOREGROUND_BACKGROUND;
        }
    }

    public final zzcg zzbn() {
        return this.zzcu;
    }
}
