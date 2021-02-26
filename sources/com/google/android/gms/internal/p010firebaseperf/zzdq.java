package com.google.android.gms.internal.p010firebaseperf;

import com.google.android.gms.internal.p010firebaseperf.zzfi;
import kotlin.text.Typography;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzdq */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzdq extends zzfi<zzdq, zzb> implements zzgu {
    private static volatile zzhc<zzdq> zzii;
    /* access modifiers changed from: private */
    public static final zzdq zzmf;
    private int zzid;
    private int zzme;

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzdq$zza */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    public enum zza implements zzfm {
        SOURCE_UNKNOWN(0),
        FL_LEGACY_V1(1);
        
        private static final zzfl<zza> zziz = null;
        private final int value;

        public final int getNumber() {
            return this.value;
        }

        public static zzfo zzdq() {
            return zzdr.zzjc;
        }

        public final String toString() {
            return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + getNumber() + " name=" + name() + Typography.greater;
        }

        private zza(int i) {
            this.value = i;
        }

        static {
            zziz = new zzds();
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzdq$zzb */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    public static final class zzb extends zzfi.zza<zzdq, zzb> implements zzgu {
        private zzb() {
            super(zzdq.zzmf);
        }
    }

    private zzdq() {
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(zzfi.zzd zzd, Object obj, Object obj2) {
        switch (zzd) {
            case NEW_MUTABLE_INSTANCE:
                return new zzdq();
            case NEW_BUILDER:
                return new zzb();
            case BUILD_MESSAGE_INFO:
                return zza((zzgs) zzmf, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zzid", "zzme", zza.zzdq()});
            case GET_DEFAULT_INSTANCE:
                return zzmf;
            case GET_PARSER:
                zzhc<zzdq> zzhc = zzii;
                if (zzhc == null) {
                    synchronized (zzdq.class) {
                        zzhc = zzii;
                        if (zzhc == null) {
                            zzhc = new zzfi.zzc<>(zzmf);
                            zzii = zzhc;
                        }
                    }
                }
                return zzhc;
            case GET_MEMOIZED_IS_INITIALIZED:
                return (byte) 1;
            case SET_MEMOIZED_IS_INITIALIZED:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        zzdq zzdq = new zzdq();
        zzmf = zzdq;
        zzfi.zza(zzdq.class, zzdq);
    }
}
