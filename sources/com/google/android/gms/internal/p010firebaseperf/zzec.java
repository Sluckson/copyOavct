package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzec */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzec {
    private static final Class<?> zzmy = zzai("libcore.io.Memory");
    private static final boolean zzmz = (zzai("org.robolectric.Robolectric") != null);

    static boolean zzgh() {
        return zzmy != null && !zzmz;
    }

    static Class<?> zzgi() {
        return zzmy;
    }

    private static <T> Class<T> zzai(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
