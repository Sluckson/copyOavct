package com.google.android.gms.internal.p010firebaseperf;

import java.lang.reflect.Type;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzff */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public enum zzff {
    DOUBLE(0, zzfh.SCALAR, zzfu.DOUBLE),
    FLOAT(1, zzfh.SCALAR, zzfu.FLOAT),
    INT64(2, zzfh.SCALAR, zzfu.LONG),
    UINT64(3, zzfh.SCALAR, zzfu.LONG),
    INT32(4, zzfh.SCALAR, zzfu.INT),
    FIXED64(5, zzfh.SCALAR, zzfu.LONG),
    FIXED32(6, zzfh.SCALAR, zzfu.INT),
    BOOL(7, zzfh.SCALAR, zzfu.BOOLEAN),
    STRING(8, zzfh.SCALAR, zzfu.STRING),
    MESSAGE(9, zzfh.SCALAR, zzfu.MESSAGE),
    BYTES(10, zzfh.SCALAR, zzfu.BYTE_STRING),
    UINT32(11, zzfh.SCALAR, zzfu.INT),
    ENUM(12, zzfh.SCALAR, zzfu.ENUM),
    SFIXED32(13, zzfh.SCALAR, zzfu.INT),
    SFIXED64(14, zzfh.SCALAR, zzfu.LONG),
    SINT32(15, zzfh.SCALAR, zzfu.INT),
    SINT64(16, zzfh.SCALAR, zzfu.LONG),
    GROUP(17, zzfh.SCALAR, zzfu.MESSAGE),
    DOUBLE_LIST(18, zzfh.VECTOR, zzfu.DOUBLE),
    FLOAT_LIST(19, zzfh.VECTOR, zzfu.FLOAT),
    INT64_LIST(20, zzfh.VECTOR, zzfu.LONG),
    UINT64_LIST(21, zzfh.VECTOR, zzfu.LONG),
    INT32_LIST(22, zzfh.VECTOR, zzfu.INT),
    FIXED64_LIST(23, zzfh.VECTOR, zzfu.LONG),
    FIXED32_LIST(24, zzfh.VECTOR, zzfu.INT),
    BOOL_LIST(25, zzfh.VECTOR, zzfu.BOOLEAN),
    STRING_LIST(26, zzfh.VECTOR, zzfu.STRING),
    MESSAGE_LIST(27, zzfh.VECTOR, zzfu.MESSAGE),
    BYTES_LIST(28, zzfh.VECTOR, zzfu.BYTE_STRING),
    UINT32_LIST(29, zzfh.VECTOR, zzfu.INT),
    ENUM_LIST(30, zzfh.VECTOR, zzfu.ENUM),
    SFIXED32_LIST(31, zzfh.VECTOR, zzfu.INT),
    SFIXED64_LIST(32, zzfh.VECTOR, zzfu.LONG),
    SINT32_LIST(33, zzfh.VECTOR, zzfu.INT),
    SINT64_LIST(34, zzfh.VECTOR, zzfu.LONG),
    DOUBLE_LIST_PACKED(35, zzfh.PACKED_VECTOR, zzfu.DOUBLE),
    FLOAT_LIST_PACKED(36, zzfh.PACKED_VECTOR, zzfu.FLOAT),
    INT64_LIST_PACKED(37, zzfh.PACKED_VECTOR, zzfu.LONG),
    UINT64_LIST_PACKED(38, zzfh.PACKED_VECTOR, zzfu.LONG),
    INT32_LIST_PACKED(39, zzfh.PACKED_VECTOR, zzfu.INT),
    FIXED64_LIST_PACKED(40, zzfh.PACKED_VECTOR, zzfu.LONG),
    FIXED32_LIST_PACKED(41, zzfh.PACKED_VECTOR, zzfu.INT),
    BOOL_LIST_PACKED(42, zzfh.PACKED_VECTOR, zzfu.BOOLEAN),
    UINT32_LIST_PACKED(43, zzfh.PACKED_VECTOR, zzfu.INT),
    ENUM_LIST_PACKED(44, zzfh.PACKED_VECTOR, zzfu.ENUM),
    SFIXED32_LIST_PACKED(45, zzfh.PACKED_VECTOR, zzfu.INT),
    SFIXED64_LIST_PACKED(46, zzfh.PACKED_VECTOR, zzfu.LONG),
    SINT32_LIST_PACKED(47, zzfh.PACKED_VECTOR, zzfu.INT),
    SINT64_LIST_PACKED(48, zzfh.PACKED_VECTOR, zzfu.LONG),
    GROUP_LIST(49, zzfh.VECTOR, zzfu.MESSAGE),
    MAP(50, zzfh.MAP, zzfu.VOID);
    
    private static final zzff[] zzqi = null;
    private static final Type[] zzqj = null;

    /* renamed from: id */
    private final int f171id;
    private final zzfu zzqe;
    private final zzfh zzqf;
    private final Class<?> zzqg;
    private final boolean zzqh;

    private zzff(int i, zzfh zzfh, zzfu zzfu) {
        int i2;
        this.f171id = i;
        this.zzqf = zzfh;
        this.zzqe = zzfu;
        int i3 = zzfe.zzod[zzfh.ordinal()];
        if (i3 == 1) {
            this.zzqg = zzfu.zzhv();
        } else if (i3 != 2) {
            this.zzqg = null;
        } else {
            this.zzqg = zzfu.zzhv();
        }
        boolean z = false;
        if (!(zzfh != zzfh.SCALAR || (i2 = zzfe.zzoe[zzfu.ordinal()]) == 1 || i2 == 2 || i2 == 3)) {
            z = true;
        }
        this.zzqh = z;
    }

    /* renamed from: id */
    public final int mo19941id() {
        return this.f171id;
    }

    static {
        int i;
        zzqj = new Type[0];
        zzff[] values = values();
        zzqi = new zzff[values.length];
        for (zzff zzff : values) {
            zzqi[zzff.f171id] = zzff;
        }
    }
}
