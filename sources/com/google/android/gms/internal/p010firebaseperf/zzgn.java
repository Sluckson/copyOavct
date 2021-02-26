package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzgn */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzgn {
    private static final zzgl zzsx = zzii();
    private static final zzgl zzsy = new zzgo();

    static zzgl zzig() {
        return zzsx;
    }

    static zzgl zzih() {
        return zzsy;
    }

    private static zzgl zzii() {
        try {
            return (zzgl) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
