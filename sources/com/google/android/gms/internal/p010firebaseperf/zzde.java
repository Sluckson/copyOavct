package com.google.android.gms.internal.p010firebaseperf;

import com.google.android.gms.internal.p010firebaseperf.zzfi;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzde */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzde extends zzfi<zzde, zza> implements zzgu {
    private static volatile zzhc<zzde> zzii;
    private static final zzfq<Integer, zzdl> zzlo = new zzdg();
    /* access modifiers changed from: private */
    public static final zzde zzlp;
    private int zzid;
    private String zzjt = "";
    private zzfn zzln = zzhp();

    private zzde() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzde$zza */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    public static final class zza extends zzfi.zza<zzde, zza> implements zzgu {
        private zza() {
            super(zzde.zzlp);
        }

        public final zza zzag(String str) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzde) this.zzqt).zzab(str);
            return this;
        }

        public final zza zzb(zzdl zzdl) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzde) this.zzqt).zza(zzdl);
            return this;
        }

        /* synthetic */ zza(zzdg zzdg) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public final void zzab(String str) {
        str.getClass();
        this.zzid |= 1;
        this.zzjt = str;
    }

    public final int zzfo() {
        return this.zzln.size();
    }

    public final zzdl zzn(int i) {
        return zzlo.convert(Integer.valueOf(this.zzln.getInt(0)));
    }

    /* access modifiers changed from: private */
    public final void zza(zzdl zzdl) {
        zzdl.getClass();
        if (!this.zzln.zzgj()) {
            zzfn zzfn = this.zzln;
            int size = zzfn.size();
            this.zzln = zzfn.zzak(size == 0 ? 10 : size << 1);
        }
        this.zzln.zzal(zzdl.getNumber());
    }

    public static zza zzfp() {
        return (zza) zzlp.zzho();
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(zzfi.zzd zzd, Object obj, Object obj2) {
        switch (zzdf.f167xa1df5c61[zzd.ordinal()]) {
            case 1:
                return new zzde();
            case 2:
                return new zza((zzdg) null);
            case 3:
                return zza((zzgs) zzlp, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001e", new Object[]{"zzid", "zzjt", "zzln", zzdl.zzdq()});
            case 4:
                return zzlp;
            case 5:
                zzhc<zzde> zzhc = zzii;
                if (zzhc == null) {
                    synchronized (zzde.class) {
                        zzhc = zzii;
                        if (zzhc == null) {
                            zzhc = new zzfi.zzc<>(zzlp);
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
        zzde zzde = new zzde();
        zzlp = zzde;
        zzfi.zza(zzde.class, zzde);
    }
}
