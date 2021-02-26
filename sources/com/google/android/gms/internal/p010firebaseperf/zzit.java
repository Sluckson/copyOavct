package com.google.android.gms.internal.p010firebaseperf;

import com.google.android.gms.internal.p010firebaseperf.zzfi;
import kotlin.text.Typography;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzit */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzit {

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzit$zza */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    public static final class zza extends zzfi<zza, zzb> implements zzgu {
        private static volatile zzhc<zza> zzii;
        /* access modifiers changed from: private */
        public static final zza zzxg;
        private int zzid;
        private int zzxe = -1;
        private int zzxf;

        /* renamed from: com.google.android.gms.internal.firebase-perf.zzit$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
        public enum C5075zza implements zzfm {
            UNKNOWN_MOBILE_SUBTYPE(0),
            GPRS(1),
            EDGE(2),
            UMTS(3),
            CDMA(4),
            EVDO_0(5),
            EVDO_A(6),
            RTT(7),
            HSDPA(8),
            HSUPA(9),
            HSPA(10),
            IDEN(11),
            EVDO_B(12),
            LTE(13),
            EHRPD(14),
            HSPAP(15),
            GSM(16),
            TD_SCDMA(17),
            IWLAN(18),
            LTE_CA(19),
            COMBINED(100);
            
            private static final zzfl<C5075zza> zziz = null;
            private final int value;

            public final int getNumber() {
                return this.value;
            }

            public static zzfo zzdq() {
                return zziw.zzjc;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + getNumber() + " name=" + name() + Typography.greater;
            }

            private C5075zza(int i) {
                this.value = i;
            }

            static {
                zziz = new zzix();
            }
        }

        /* renamed from: com.google.android.gms.internal.firebase-perf.zzit$zza$zzc */
        /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
        public enum zzc implements zzfm {
            NONE(-1),
            MOBILE(0),
            WIFI(1),
            MOBILE_MMS(2),
            MOBILE_SUPL(3),
            MOBILE_DUN(4),
            MOBILE_HIPRI(5),
            WIMAX(6),
            BLUETOOTH(7),
            DUMMY(8),
            ETHERNET(9),
            MOBILE_FOTA(10),
            MOBILE_IMS(11),
            MOBILE_CBS(12),
            WIFI_P2P(13),
            MOBILE_IA(14),
            MOBILE_EMERGENCY(15),
            PROXY(16),
            VPN(17);
            
            private static final zzfl<zzc> zziz = null;
            private final int value;

            public final int getNumber() {
                return this.value;
            }

            public static zzfo zzdq() {
                return zziz.zzjc;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + getNumber() + " name=" + name() + Typography.greater;
            }

            private zzc(int i) {
                this.value = i;
            }

            static {
                zziz = new zziy();
            }
        }

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.firebase-perf.zzit$zza$zzb */
        /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
        public static final class zzb extends zzfi.zza<zza, zzb> implements zzgu {
            private zzb() {
                super(zza.zzxg);
            }

            /* synthetic */ zzb(zziv zziv) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object dynamicMethod(zzfi.zzd zzd, Object obj, Object obj2) {
            switch (zziv.f172xa1df5c61[zzd.ordinal()]) {
                case 1:
                    return new zza();
                case 2:
                    return new zzb((zziv) null);
                case 3:
                    return zza((zzgs) zzxg, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", new Object[]{"zzid", "zzxe", zzc.zzdq(), "zzxf", C5075zza.zzdq()});
                case 4:
                    return zzxg;
                case 5:
                    zzhc<zza> zzhc = zzii;
                    if (zzhc == null) {
                        synchronized (zza.class) {
                            zzhc = zzii;
                            if (zzhc == null) {
                                zzhc = new zzfi.zzc<>(zzxg);
                                zzii = zzhc;
                            }
                        }
                    }
                    return zzhc;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zza zza = new zza();
            zzxg = zza;
            zzfi.zza(zza.class, zza);
        }
    }
}
