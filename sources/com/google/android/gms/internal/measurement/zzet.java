package com.google.android.gms.internal.measurement;

import java.util.AbstractCollection;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
final class zzet extends AbstractCollection<V> {
    private final /* synthetic */ zzel zza;

    zzet(zzel zzel) {
        this.zza = zzel;
    }

    public final int size() {
        return this.zza.size();
    }

    public final void clear() {
        this.zza.clear();
    }

    public final Iterator<V> iterator() {
        return this.zza.zzg();
    }
}
