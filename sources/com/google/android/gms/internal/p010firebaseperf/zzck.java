package com.google.android.gms.internal.p010firebaseperf;

import com.google.android.gms.internal.p010firebaseperf.zzfi;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzck */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzck extends zzfi<zzck, zza> implements zzgu {
    private static volatile zzhc<zzck> zzii;
    /* access modifiers changed from: private */
    public static final zzck zzjf;
    private int zzid;
    private long zzik;
    private long zzjd;
    private long zzje;

    private zzck() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzck$zza */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    public static final class zza extends zzfi.zza<zzck, zza> implements zzgu {
        private zza() {
            super(zzck.zzjf);
        }

        public final zza zzy(long j) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzck) this.zzqt).zzu(j);
            return this;
        }

        public final zza zzz(long j) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzck) this.zzqt).zzw(j);
            return this;
        }

        public final zza zzaa(long j) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzck) this.zzqt).zzx(j);
            return this;
        }

        /* synthetic */ zza(zzcj zzcj) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final void zzu(long j) {
        this.zzid |= 1;
        this.zzik = j;
    }

    /* access modifiers changed from: private */
    public final void zzw(long j) {
        this.zzid |= 2;
        this.zzjd = j;
    }

    /* access modifiers changed from: private */
    public final void zzx(long j) {
        this.zzid |= 4;
        this.zzje = j;
    }

    public static zza zzdr() {
        return (zza) zzjf.zzho();
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(zzfi.zzd zzd, Object obj, Object obj2) {
        switch (zzcj.f160xa1df5c61[zzd.ordinal()]) {
            case 1:
                return new zzck();
            case 2:
                return new zza((zzcj) null);
            case 3:
                return zza((zzgs) zzjf, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002", new Object[]{"zzid", "zzik", "zzjd", "zzje"});
            case 4:
                return zzjf;
            case 5:
                zzhc<zzck> zzhc = zzii;
                if (zzhc == null) {
                    synchronized (zzck.class) {
                        zzhc = zzii;
                        if (zzhc == null) {
                            zzhc = new zzfi.zzc<>(zzjf);
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
        zzck zzck = new zzck();
        zzjf = zzck;
        zzfi.zza(zzck.class, zzck);
    }
}
