package com.google.android.gms.internal.p010firebaseperf;

import com.google.android.gms.internal.p010firebaseperf.zzfi;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzcp */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzcp extends zzfi<zzcp, zza> implements zzgu {
    private static volatile zzhc<zzcp> zzii;
    /* access modifiers changed from: private */
    public static final zzcp zzjs;
    private int zzid;
    private String zzjm = "";
    private int zzjn;
    private int zzjo;
    private int zzjp;
    private int zzjq;
    private int zzjr;

    private zzcp() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzcp$zza */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    public static final class zza extends zzfi.zza<zzcp, zza> implements zzgu {
        private zza() {
            super(zzcp.zzjs);
        }

        public final zza zzac(String str) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzcp) this.zzqt).zzaa(str);
            return this;
        }

        public final zza zzi(int i) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzcp) this.zzqt).zzf(i);
            return this;
        }

        public final zza zzj(int i) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzcp) this.zzqt).zzg(i);
            return this;
        }

        public final zza zzk(int i) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzcp) this.zzqt).zzh(i);
            return this;
        }

        /* synthetic */ zza(zzco zzco) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final void zzaa(String str) {
        str.getClass();
        this.zzid |= 1;
        this.zzjm = str;
    }

    /* access modifiers changed from: private */
    public final void zzf(int i) {
        this.zzid |= 8;
        this.zzjp = i;
    }

    public final boolean zzdt() {
        return (this.zzid & 16) != 0;
    }

    /* access modifiers changed from: private */
    public final void zzg(int i) {
        this.zzid |= 16;
        this.zzjq = i;
    }

    /* access modifiers changed from: private */
    public final void zzh(int i) {
        this.zzid |= 32;
        this.zzjr = i;
    }

    public static zza zzdu() {
        return (zza) zzjs.zzho();
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(zzfi.zzd zzd, Object obj, Object obj2) {
        switch (zzco.f161xa1df5c61[zzd.ordinal()]) {
            case 1:
                return new zzcp();
            case 2:
                return new zza((zzco) null);
            case 3:
                return zza((zzgs) zzjs, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003င\u0003\u0004င\u0004\u0005င\u0005\u0006င\u0002", new Object[]{"zzid", "zzjm", "zzjn", "zzjp", "zzjq", "zzjr", "zzjo"});
            case 4:
                return zzjs;
            case 5:
                zzhc<zzcp> zzhc = zzii;
                if (zzhc == null) {
                    synchronized (zzcp.class) {
                        zzhc = zzii;
                        if (zzhc == null) {
                            zzhc = new zzfi.zzc<>(zzjs);
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

    public static zzcp zzdv() {
        return zzjs;
    }

    static {
        zzcp zzcp = new zzcp();
        zzjs = zzcp;
        zzfi.zza(zzcp.class, zzcp);
    }
}
