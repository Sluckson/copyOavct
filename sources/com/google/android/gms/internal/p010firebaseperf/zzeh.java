package com.google.android.gms.internal.p010firebaseperf;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzeh */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzeh extends zzej {
    private final int limit = this.zznd.size();
    private int position = 0;
    private final /* synthetic */ zzee zznd;

    zzeh(zzee zzee) {
        this.zznd = zzee;
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    public final byte nextByte() {
        int i = this.position;
        if (i < this.limit) {
            this.position = i + 1;
            return this.zznd.zzr(i);
        }
        throw new NoSuchElementException();
    }
}
