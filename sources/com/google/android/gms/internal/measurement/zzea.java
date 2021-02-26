package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.5.0 */
public final class zzea {
    public static <T> zzeb<T> zza(zzeb<T> zzeb) {
        if ((zzeb instanceof zzec) || (zzeb instanceof zzed)) {
            return zzeb;
        }
        if (zzeb instanceof Serializable) {
            return new zzed(zzeb);
        }
        return new zzec(zzeb);
    }

    public static <T> zzeb<T> zza(@NullableDecl T t) {
        return new zzef(t);
    }
}
