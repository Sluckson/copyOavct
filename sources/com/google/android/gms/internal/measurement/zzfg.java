package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzfg extends zzfs<T> {
    private boolean zza;
    private final /* synthetic */ Object zzb;

    zzfg(Object obj) {
        this.zzb = obj;
    }

    public final boolean hasNext() {
        return !this.zza;
    }

    public final T next() {
        if (!this.zza) {
            this.zza = true;
            return this.zzb;
        }
        throw new NoSuchElementException();
    }
}
