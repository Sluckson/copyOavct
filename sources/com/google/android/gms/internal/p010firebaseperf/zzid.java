package com.google.android.gms.internal.p010firebaseperf;

import java.util.Iterator;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzid */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzid implements Iterator<String> {
    private Iterator<String> zzuz = this.zzva.zzuy.iterator();
    private final /* synthetic */ zzib zzva;

    zzid(zzib zzib) {
        this.zzva = zzib;
    }

    public final boolean hasNext() {
        return this.zzuz.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object next() {
        return this.zzuz.next();
    }
}
