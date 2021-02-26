package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.5.0 */
final class zzku implements Iterator<String> {
    private Iterator<String> zza = this.zzb.zza.iterator();
    private final /* synthetic */ zzks zzb;

    zzku(zzks zzks) {
        this.zzb = zzks;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return this.zza.next();
    }
}
