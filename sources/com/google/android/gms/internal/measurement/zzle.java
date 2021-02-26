package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.5.0 */
public enum zzle {
    DOUBLE(zzlh.DOUBLE, 1),
    FLOAT(zzlh.FLOAT, 5),
    INT64(zzlh.LONG, 0),
    UINT64(zzlh.LONG, 0),
    INT32(zzlh.INT, 0),
    FIXED64(zzlh.LONG, 1),
    FIXED32(zzlh.INT, 5),
    BOOL(zzlh.BOOLEAN, 0),
    STRING(zzlh.STRING, 2),
    GROUP(zzlh.MESSAGE, 3),
    MESSAGE(zzlh.MESSAGE, 2),
    BYTES(zzlh.BYTE_STRING, 2),
    UINT32(zzlh.INT, 0),
    ENUM(zzlh.ENUM, 0),
    SFIXED32(zzlh.INT, 5),
    SFIXED64(zzlh.LONG, 1),
    SINT32(zzlh.INT, 0),
    SINT64(zzlh.LONG, 0);
    
    private final zzlh zzs;
    private final int zzt;

    private zzle(zzlh zzlh, int i) {
        this.zzs = zzlh;
        this.zzt = i;
    }

    public final zzlh zza() {
        return this.zzs;
    }

    public final int zzb() {
        return this.zzt;
    }
}
