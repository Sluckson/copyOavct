package com.google.android.gms.internal.p010firebaseperf;

import com.google.android.gms.internal.p010firebaseperf.zzfi;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzdv */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzdv extends zzfi<zzdv, zza> implements zzgu {
    private static volatile zzhc<zzdv> zzii;
    /* access modifiers changed from: private */
    public static final zzdv zzmt;
    private int zzid;
    private String zzif = "";
    private String zzmp = "";
    private int zzmq;
    private int zzmr;
    private int zzms;

    private zzdv() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzdv$zza */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    public static final class zza extends zzfi.zza<zzdv, zza> implements zzgu {
        private zza() {
            super(zzdv.zzmt);
        }

        /* synthetic */ zza(zzdx zzdx) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(zzfi.zzd zzd, Object obj, Object obj2) {
        switch (zzdx.f170xa1df5c61[zzd.ordinal()]) {
            case 1:
                return new zzdv();
            case 2:
                return new zza((zzdx) null);
            case 3:
                return zza((zzgs) zzmt, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဌ\u0002\u0004ဌ\u0003\u0005ဌ\u0004", new Object[]{"zzid", "zzif", "zzmp", "zzmq", zzdh.zzdq(), "zzmr", zzdu.zzdq(), "zzms", zzcl.zzdq()});
            case 4:
                return zzmt;
            case 5:
                zzhc<zzdv> zzhc = zzii;
                if (zzhc == null) {
                    synchronized (zzdv.class) {
                        zzhc = zzii;
                        if (zzhc == null) {
                            zzhc = new zzfi.zzc<>(zzmt);
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
        zzdv zzdv = new zzdv();
        zzmt = zzdv;
        zzfi.zza(zzdv.class, zzdv);
    }
}
