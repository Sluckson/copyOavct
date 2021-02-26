package com.google.android.gms.internal.p010firebaseperf;

import com.google.android.gms.internal.p010firebaseperf.zzfi;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzcq */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzcq extends zzfi<zzcq, zza> implements zzgu {
    private static volatile zzhc<zzcq> zzii;
    /* access modifiers changed from: private */
    public static final zzcq zzjy;
    private int zzid;
    private String zzjt = "";
    private zzcp zzju;
    private zzfp<zzck> zzjv = zzhq();
    private zzfp<zzcd> zzjw = zzhq();
    private zzfp<zzcu> zzjx = zzhq();

    private zzcq() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzcq$zza */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    public static final class zza extends zzfi.zza<zzcq, zza> implements zzgu {
        private zza() {
            super(zzcq.zzjy);
        }

        public final zza zzad(String str) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzcq) this.zzqt).zzab(str);
            return this;
        }

        public final zza zzb(zzcp zzcp) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzcq) this.zzqt).zza(zzcp);
            return this;
        }

        public final zza zzb(zzck zzck) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzcq) this.zzqt).zza(zzck);
            return this;
        }

        public final zza zzb(zzcd zzcd) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzcq) this.zzqt).zza(zzcd);
            return this;
        }

        /* synthetic */ zza(zzcr zzcr) {
            this();
        }
    }

    public final boolean zzdx() {
        return (this.zzid & 1) != 0;
    }

    public final String zzdy() {
        return this.zzjt;
    }

    /* access modifiers changed from: private */
    public final void zzab(String str) {
        str.getClass();
        this.zzid |= 1;
        this.zzjt = str;
    }

    public final boolean zzdz() {
        return (this.zzid & 2) != 0;
    }

    public final zzcp zzea() {
        zzcp zzcp = this.zzju;
        return zzcp == null ? zzcp.zzdv() : zzcp;
    }

    /* access modifiers changed from: private */
    public final void zza(zzcp zzcp) {
        zzcp.getClass();
        this.zzju = zzcp;
        this.zzid |= 2;
    }

    public final int zzeb() {
        return this.zzjv.size();
    }

    /* access modifiers changed from: private */
    public final void zza(zzck zzck) {
        zzck.getClass();
        zzfp<zzck> zzfp = this.zzjv;
        if (!zzfp.zzgj()) {
            this.zzjv = zzfi.zza(zzfp);
        }
        this.zzjv.add(zzck);
    }

    public final int zzec() {
        return this.zzjw.size();
    }

    /* access modifiers changed from: private */
    public final void zza(zzcd zzcd) {
        zzcd.getClass();
        zzfp<zzcd> zzfp = this.zzjw;
        if (!zzfp.zzgj()) {
            this.zzjw = zzfi.zza(zzfp);
        }
        this.zzjw.add(zzcd);
    }

    public static zza zzed() {
        return (zza) zzjy.zzho();
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(zzfi.zzd zzd, Object obj, Object obj2) {
        switch (zzcr.f162xa1df5c61[zzd.ordinal()]) {
            case 1:
                return new zzcq();
            case 2:
                return new zza((zzcr) null);
            case 3:
                return zza((zzgs) zzjy, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0003\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဉ\u0001\u0004\u001b\u0005\u001b", new Object[]{"zzid", "zzjt", "zzjv", zzck.class, "zzju", "zzjw", zzcd.class, "zzjx", zzcu.class});
            case 4:
                return zzjy;
            case 5:
                zzhc<zzcq> zzhc = zzii;
                if (zzhc == null) {
                    synchronized (zzcq.class) {
                        zzhc = zzii;
                        if (zzhc == null) {
                            zzhc = new zzfi.zzc<>(zzjy);
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

    public static zzcq zzee() {
        return zzjy;
    }

    static {
        zzcq zzcq = new zzcq();
        zzjy = zzcq;
        zzfi.zza(zzcq.class, zzcq);
    }
}
