package com.google.android.gms.internal.p010firebaseperf;

import com.google.android.gms.internal.p010firebaseperf.zzfi;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzcd */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzcd extends zzfi<zzcd, zza> implements zzgu {
    private static volatile zzhc<zzcd> zzii;
    /* access modifiers changed from: private */
    public static final zzcd zzim;
    private int zzid;
    private long zzik;
    private int zzil;

    private zzcd() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzcd$zza */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    public static final class zza extends zzfi.zza<zzcd, zza> implements zzgu {
        private zza() {
            super(zzcd.zzim);
        }

        public final zza zzv(long j) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzcd) this.zzqt).zzu(j);
            return this;
        }

        public final zza zze(int i) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzcd) this.zzqt).zzd(i);
            return this;
        }

        /* synthetic */ zza(zzcc zzcc) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final void zzu(long j) {
        this.zzid |= 1;
        this.zzik = j;
    }

    /* access modifiers changed from: private */
    public final void zzd(int i) {
        this.zzid |= 2;
        this.zzil = i;
    }

    public static zza zzdg() {
        return (zza) zzim.zzho();
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(zzfi.zzd zzd, Object obj, Object obj2) {
        switch (zzcc.f158xa1df5c61[zzd.ordinal()]) {
            case 1:
                return new zzcd();
            case 2:
                return new zza((zzcc) null);
            case 3:
                return zza((zzgs) zzim, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002င\u0001", new Object[]{"zzid", "zzik", "zzil"});
            case 4:
                return zzim;
            case 5:
                zzhc<zzcd> zzhc = zzii;
                if (zzhc == null) {
                    synchronized (zzcd.class) {
                        zzhc = zzii;
                        if (zzhc == null) {
                            zzhc = new zzfi.zzc<>(zzim);
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
        zzcd zzcd = new zzcd();
        zzim = zzcd;
        zzfi.zza(zzcd.class, zzcd);
    }
}
