package com.google.android.gms.internal.p010firebaseperf;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzib */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzib extends AbstractList<String> implements zzfz, RandomAccess {
    /* access modifiers changed from: private */
    public final zzfz zzuy;

    public zzib(zzfz zzfz) {
        this.zzuy = zzfz;
    }

    public final zzfz zzhy() {
        return this;
    }

    public final Object getRaw(int i) {
        return this.zzuy.getRaw(i);
    }

    public final int size() {
        return this.zzuy.size();
    }

    public final void zzc(zzee zzee) {
        throw new UnsupportedOperationException();
    }

    public final ListIterator<String> listIterator(int i) {
        return new zzie(this, i);
    }

    public final Iterator<String> iterator() {
        return new zzid(this);
    }

    public final List<?> zzhx() {
        return this.zzuy.zzhx();
    }

    public final /* synthetic */ Object get(int i) {
        return (String) this.zzuy.get(i);
    }
}
