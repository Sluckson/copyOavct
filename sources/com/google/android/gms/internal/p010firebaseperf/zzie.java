package com.google.android.gms.internal.p010firebaseperf;

import java.util.ListIterator;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzie */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzie implements ListIterator<String> {
    private final /* synthetic */ zzib zzva;
    private ListIterator<String> zzvb = this.zzva.zzuy.listIterator(this.zzvc);
    private final /* synthetic */ int zzvc;

    zzie(zzib zzib, int i) {
        this.zzva = zzib;
        this.zzvc = i;
    }

    public final boolean hasNext() {
        return this.zzvb.hasNext();
    }

    public final boolean hasPrevious() {
        return this.zzvb.hasPrevious();
    }

    public final int nextIndex() {
        return this.zzvb.nextIndex();
    }

    public final int previousIndex() {
        return this.zzvb.previousIndex();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void add(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ void set(Object obj) {
        String str = (String) obj;
        throw new UnsupportedOperationException();
    }

    public final /* synthetic */ Object previous() {
        return this.zzvb.previous();
    }

    public final /* synthetic */ Object next() {
        return this.zzvb.next();
    }
}
