package com.google.android.gms.internal.p010firebaseperf;

import com.google.android.gms.internal.p010firebaseperf.zzce;
import com.google.android.gms.internal.p010firebaseperf.zzfi;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzdd */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzdd extends zzfi<zzdd, zza> implements zzgu {
    private static volatile zzhc<zzdd> zzii;
    /* access modifiers changed from: private */
    public static final zzdd zzlm;
    private int zzid;
    private zzce zzlh;
    private zzdm zzli;
    private zzcx zzlj;
    private zzcq zzlk;
    private zzdq zzll;

    private zzdd() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzdd$zza */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    public static final class zza extends zzfi.zza<zzdd, zza> implements zzgu {
        private zza() {
            super(zzdd.zzlm);
        }

        public final zza zza(zzce.zza zza) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzdd) this.zzqt).zzb((zzce) ((zzfi) zza.zzhm()));
            return this;
        }

        public final zza zzb(zzdm zzdm) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzdd) this.zzqt).zza(zzdm);
            return this;
        }

        public final zza zzd(zzcx zzcx) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzdd) this.zzqt).zzc(zzcx);
            return this;
        }

        public final zza zzb(zzcq zzcq) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzdd) this.zzqt).zza(zzcq);
            return this;
        }

        /* synthetic */ zza(zzdc zzdc) {
            this();
        }
    }

    public final boolean zzfe() {
        return (this.zzid & 1) != 0;
    }

    public final zzce zzff() {
        zzce zzce = this.zzlh;
        return zzce == null ? zzce.zzdo() : zzce;
    }

    /* access modifiers changed from: private */
    public final void zzb(zzce zzce) {
        zzce.getClass();
        this.zzlh = zzce;
        this.zzid |= 1;
    }

    public final boolean zzfg() {
        return (this.zzid & 2) != 0;
    }

    public final zzdm zzfh() {
        zzdm zzdm = this.zzli;
        return zzdm == null ? zzdm.zzfz() : zzdm;
    }

    /* access modifiers changed from: private */
    public final void zza(zzdm zzdm) {
        zzdm.getClass();
        this.zzli = zzdm;
        this.zzid |= 2;
    }

    public final boolean zzfi() {
        return (this.zzid & 4) != 0;
    }

    public final zzcx zzfj() {
        zzcx zzcx = this.zzlj;
        return zzcx == null ? zzcx.zzfa() : zzcx;
    }

    /* access modifiers changed from: private */
    public final void zzc(zzcx zzcx) {
        zzcx.getClass();
        this.zzlj = zzcx;
        this.zzid |= 4;
    }

    public final boolean zzfk() {
        return (this.zzid & 8) != 0;
    }

    public final zzcq zzfl() {
        zzcq zzcq = this.zzlk;
        return zzcq == null ? zzcq.zzee() : zzcq;
    }

    /* access modifiers changed from: private */
    public final void zza(zzcq zzcq) {
        zzcq.getClass();
        this.zzlk = zzcq;
        this.zzid |= 8;
    }

    public static zza zzfm() {
        return (zza) zzlm.zzho();
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(zzfi.zzd zzd, Object obj, Object obj2) {
        switch (zzdc.f166xa1df5c61[zzd.ordinal()]) {
            case 1:
                return new zzdd();
            case 2:
                return new zza((zzdc) null);
            case 3:
                return zza((zzgs) zzlm, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဉ\u0004", new Object[]{"zzid", "zzlh", "zzli", "zzlj", "zzlk", "zzll"});
            case 4:
                return zzlm;
            case 5:
                zzhc<zzdd> zzhc = zzii;
                if (zzhc == null) {
                    synchronized (zzdd.class) {
                        zzhc = zzii;
                        if (zzhc == null) {
                            zzhc = new zzfi.zzc<>(zzlm);
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
        zzdd zzdd = new zzdd();
        zzlm = zzdd;
        zzfi.zza(zzdd.class, zzdd);
    }
}
