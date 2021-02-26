package com.google.android.gms.internal.p010firebaseperf;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzio */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public enum zzio {
    DOUBLE(zzir.DOUBLE, 1),
    FLOAT(zzir.FLOAT, 5),
    INT64(zzir.LONG, 0),
    UINT64(zzir.LONG, 0),
    INT32(zzir.INT, 0),
    FIXED64(zzir.LONG, 1),
    FIXED32(zzir.INT, 5),
    BOOL(zzir.BOOLEAN, 0),
    STRING(zzir.STRING, 2),
    GROUP(zzir.MESSAGE, 3),
    MESSAGE(zzir.MESSAGE, 2),
    BYTES(zzir.BYTE_STRING, 2),
    UINT32(zzir.INT, 0),
    ENUM(zzir.ENUM, 0),
    SFIXED32(zzir.INT, 5),
    SFIXED64(zzir.LONG, 1),
    SINT32(zzir.INT, 0),
    SINT64(zzir.LONG, 0);
    
    private final zzir zzwr;
    private final int zzws;

    private zzio(zzir zzir, int i) {
        this.zzwr = zzir;
        this.zzws = i;
    }

    public final zzir zzjo() {
        return this.zzwr;
    }

    public final int zzjp() {
        return this.zzws;
    }
}
