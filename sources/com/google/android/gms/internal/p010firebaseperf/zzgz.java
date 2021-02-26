package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzgz */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzgz {
    private static final zzgx zzts = zzio();
    private static final zzgx zztt = new zzha();

    static zzgx zzim() {
        return zzts;
    }

    static zzgx zzin() {
        return zztt;
    }

    private static zzgx zzio() {
        try {
            return (zzgx) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
