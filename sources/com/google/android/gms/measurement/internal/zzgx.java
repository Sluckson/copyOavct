package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
abstract class zzgx extends zzgu {
    private boolean zza;

    zzgx(zzgb zzgb) {
        super(zzgb);
        this.zzy.zza(this);
    }

    /* access modifiers changed from: protected */
    /* renamed from: g_ */
    public void mo23267g_() {
    }

    /* access modifiers changed from: protected */
    public abstract boolean zzd();

    /* access modifiers changed from: package-private */
    public final boolean zzz() {
        return this.zza;
    }

    /* access modifiers changed from: protected */
    public final void zzaa() {
        if (!zzz()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void zzab() {
        if (this.zza) {
            throw new IllegalStateException("Can't initialize twice");
        } else if (!zzd()) {
            this.zzy.zzae();
            this.zza = true;
        }
    }

    public final void zzac() {
        if (!this.zza) {
            mo23267g_();
            this.zzy.zzae();
            this.zza = true;
            return;
        }
        throw new IllegalStateException("Can't initialize twice");
    }
}
