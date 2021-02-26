package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzfb */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzfb {
    private static final zzez<?> zznz = new zzey();
    private static final zzez<?> zzoa = zzha();

    private static zzez<?> zzha() {
        try {
            return (zzez) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static zzez<?> zzhb() {
        return zznz;
    }

    static zzez<?> zzhc() {
        zzez<?> zzez = zzoa;
        if (zzez != null) {
            return zzez;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
