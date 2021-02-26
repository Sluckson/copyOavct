package com.google.android.gms.internal.p010firebaseperf;

import com.google.android.gms.internal.p010firebaseperf.zzfi;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzcu */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzcu extends zzfi<zzcu, zza> implements zzgu {
    private static volatile zzhc<zzcu> zzii;
    /* access modifiers changed from: private */
    public static final zzcu zzkf;
    private int zzid;
    private long zzik;
    private int zzkd;
    private int zzke;

    private zzcu() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzcu$zza */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    public static final class zza extends zzfi.zza<zzcu, zza> implements zzgu {
        private zza() {
            super(zzcu.zzkf);
        }

        /* synthetic */ zza(zzcv zzcv) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(zzfi.zzd zzd, Object obj, Object obj2) {
        switch (zzcv.f164xa1df5c61[zzd.ordinal()]) {
            case 1:
                return new zzcu();
            case 2:
                return new zza((zzcv) null);
            case 3:
                return zza((zzgs) zzkf, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzid", "zzik", "zzkd", "zzke"});
            case 4:
                return zzkf;
            case 5:
                zzhc<zzcu> zzhc = zzii;
                if (zzhc == null) {
                    synchronized (zzcu.class) {
                        zzhc = zzii;
                        if (zzhc == null) {
                            zzhc = new zzfi.zzc<>(zzkf);
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
        zzcu zzcu = new zzcu();
        zzkf = zzcu;
        zzfi.zza(zzcu.class, zzcu);
    }
}
