package com.google.android.gms.internal.p010firebaseperf;

import java.lang.reflect.Field;
import java.security.PrivilegedExceptionAction;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzif */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzif implements PrivilegedExceptionAction<Unsafe> {
    zzif() {
    }

    public final /* synthetic */ Object run() throws Exception {
        Class<Unsafe> cls = Unsafe.class;
        for (Field field : cls.getDeclaredFields()) {
            field.setAccessible(true);
            Object obj = field.get((Object) null);
            if (cls.isInstance(obj)) {
                return cls.cast(obj);
            }
        }
        return null;
    }
}
