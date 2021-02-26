package com.google.android.gms.internal.p010firebaseperf;

import com.google.android.gms.internal.p010firebaseperf.zzfi;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzbz */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzbz extends zzfi<zzbz, zza> implements zzgu {
    /* access modifiers changed from: private */
    public static final zzbz zzih;
    private static volatile zzhc<zzbz> zzii;
    private int zzid;
    private String zzie = "";
    private String zzif = "";
    private String zzig = "";

    private zzbz() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzbz$zza */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    public static final class zza extends zzfi.zza<zzbz, zza> implements zzgu {
        private zza() {
            super(zzbz.zzih);
        }

        public final zza zzt(String str) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzbz) this.zzqt).zzq(str);
            return this;
        }

        public final zza zzu(String str) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzbz) this.zzqt).zzr(str);
            return this;
        }

        public final zza zzv(String str) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzbz) this.zzqt).zzs(str);
            return this;
        }

        /* synthetic */ zza(zzcb zzcb) {
            this();
        }
    }

    public final boolean hasPackageName() {
        return (this.zzid & 1) != 0;
    }

    /* access modifiers changed from: private */
    public final void zzq(String str) {
        str.getClass();
        this.zzid |= 1;
        this.zzie = str;
    }

    public final boolean hasSdkVersion() {
        return (this.zzid & 2) != 0;
    }

    /* access modifiers changed from: private */
    public final void zzr(String str) {
        str.getClass();
        this.zzid |= 2;
        this.zzif = str;
    }

    /* access modifiers changed from: private */
    public final void zzs(String str) {
        str.getClass();
        this.zzid |= 4;
        this.zzig = str;
    }

    public static zza zzdd() {
        return (zza) zzih.zzho();
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(zzfi.zzd zzd, Object obj, Object obj2) {
        switch (zzcb.f157xa1df5c61[zzd.ordinal()]) {
            case 1:
                return new zzbz();
            case 2:
                return new zza((zzcb) null);
            case 3:
                return zza((zzgs) zzih, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"zzid", "zzie", "zzif", "zzig"});
            case 4:
                return zzih;
            case 5:
                zzhc<zzbz> zzhc = zzii;
                if (zzhc == null) {
                    synchronized (zzbz.class) {
                        zzhc = zzii;
                        if (zzhc == null) {
                            zzhc = new zzfi.zzc<>(zzih);
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

    public static zzbz zzde() {
        return zzih;
    }

    static {
        zzbz zzbz = new zzbz();
        zzih = zzbz;
        zzfi.zza(zzbz.class, zzbz);
    }
}
