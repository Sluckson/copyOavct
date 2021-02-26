package com.google.android.gms.internal.p010firebaseperf;

import com.google.android.gms.internal.p010firebaseperf.zzfi;
import com.google.android.gms.internal.p010firebaseperf.zzit;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzct */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzct extends zzfi<zzct, zza> implements zzgu {
    private static volatile zzhc<zzct> zzii;
    /* access modifiers changed from: private */
    public static final zzct zzkc;
    private int zzid;
    private String zzif = "";
    private String zzjz = "";
    private String zzka = "";
    private zzit.zza zzkb;

    private zzct() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzct$zza */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    public static final class zza extends zzfi.zza<zzct, zza> implements zzgu {
        private zza() {
            super(zzct.zzkc);
        }

        /* synthetic */ zza(zzcs zzcs) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(zzfi.zzd zzd, Object obj, Object obj2) {
        switch (zzcs.f163xa1df5c61[zzd.ordinal()]) {
            case 1:
                return new zzct();
            case 2:
                return new zza((zzcs) null);
            case 3:
                return zza((zzgs) zzkc, "\u0001\u0004\u0000\u0001\u0002\u0005\u0004\u0000\u0000\u0000\u0002ဈ\u0000\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဉ\u0003", new Object[]{"zzid", "zzif", "zzjz", "zzka", "zzkb"});
            case 4:
                return zzkc;
            case 5:
                zzhc<zzct> zzhc = zzii;
                if (zzhc == null) {
                    synchronized (zzct.class) {
                        zzhc = zzii;
                        if (zzhc == null) {
                            zzhc = new zzfi.zzc<>(zzkc);
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
        zzct zzct = new zzct();
        zzkc = zzct;
        zzfi.zza(zzct.class, zzct);
    }
}
