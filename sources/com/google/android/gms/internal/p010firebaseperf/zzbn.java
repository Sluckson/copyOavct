package com.google.android.gms.internal.p010firebaseperf;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzbn */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzbn<T> {
    private static final zzbn<?> zzhq = new zzbn<>();
    private final T value;

    private zzbn() {
        this.value = null;
    }

    private zzbn(T t) {
        if (t != null) {
            this.value = t;
            return;
        }
        throw new NullPointerException("value for optional is empty.");
    }

    public static <T> zzbn<T> zzda() {
        return zzhq;
    }

    public static <T> zzbn<T> zzb(T t) {
        return new zzbn<>(t);
    }

    public static <T> zzbn<T> zzc(T t) {
        if (t == null) {
            return zzhq;
        }
        return zzb(t);
    }

    public final T get() {
        T t = this.value;
        if (t != null) {
            return t;
        }
        throw new NoSuchElementException("No value present");
    }

    public final boolean isPresent() {
        return this.value != null;
    }
}
