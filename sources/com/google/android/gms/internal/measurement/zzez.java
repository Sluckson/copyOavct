package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzez<E> extends zzee<E> {
    private final zzew<E> zza;

    zzez(zzew<E> zzew, int i) {
        super(zzew.size(), i);
        this.zza = zzew;
    }

    /* access modifiers changed from: protected */
    public final E zza(int i) {
        return this.zza.get(i);
    }
}
