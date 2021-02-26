package com.google.android.gms.internal.p010firebaseperf;

import com.google.android.gms.internal.p010firebaseperf.zzbz;
import com.google.android.gms.internal.p010firebaseperf.zzfi;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzce */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzce extends zzfi<zzce, zza> implements zzgu {
    private static volatile zzhc<zzce> zzii;
    /* access modifiers changed from: private */
    public static final zzce zziu;
    private int zzid;
    private String zzin = "";
    private String zzio = "";
    private zzbz zzip;
    private zzct zziq;
    private zzdv zzir;
    private int zzis;
    private zzgm<String, String> zzit = zzgm.zzid();

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzce$zzb */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    static final class zzb {
        static final zzgk<String, String> zzjb = zzgk.zza(zzio.STRING, "", zzio.STRING, "");
    }

    private zzce() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzce$zza */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    public static final class zza extends zzfi.zza<zzce, zza> implements zzgu {
        private zza() {
            super(zzce.zziu);
        }

        public final zza zzy(String str) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzce) this.zzqt).zzw(str);
            return this;
        }

        public final boolean hasAppInstanceId() {
            return ((zzce) this.zzqt).hasAppInstanceId();
        }

        public final zza zzz(String str) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzce) this.zzqt).zzx(str);
            return this;
        }

        public final zza zza(zzbz.zza zza) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzce) this.zzqt).zza((zzbz) ((zzfi) zza.zzhm()));
            return this;
        }

        public final zza zzf(zzcg zzcg) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzce) this.zzqt).zze(zzcg);
            return this;
        }

        public final zza zzb(Map<String, String> map) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzce) this.zzqt).zzdm().putAll(map);
            return this;
        }

        /* synthetic */ zza(zzcf zzcf) {
            this();
        }
    }

    public final boolean zzdi() {
        return (this.zzid & 1) != 0;
    }

    /* access modifiers changed from: private */
    public final void zzw(String str) {
        str.getClass();
        this.zzid |= 1;
        this.zzin = str;
    }

    public final boolean hasAppInstanceId() {
        return (this.zzid & 2) != 0;
    }

    /* access modifiers changed from: private */
    public final void zzx(String str) {
        str.getClass();
        this.zzid |= 2;
        this.zzio = str;
    }

    public final boolean zzdj() {
        return (this.zzid & 4) != 0;
    }

    public final zzbz zzdk() {
        zzbz zzbz = this.zzip;
        return zzbz == null ? zzbz.zzde() : zzbz;
    }

    /* access modifiers changed from: private */
    public final void zza(zzbz zzbz) {
        zzbz.getClass();
        this.zzip = zzbz;
        this.zzid |= 4;
    }

    public final boolean zzdl() {
        return (this.zzid & 32) != 0;
    }

    /* access modifiers changed from: private */
    public final void zze(zzcg zzcg) {
        this.zzis = zzcg.getNumber();
        this.zzid |= 32;
    }

    /* access modifiers changed from: private */
    public final Map<String, String> zzdm() {
        if (!this.zzit.isMutable()) {
            this.zzit = this.zzit.zzie();
        }
        return this.zzit;
    }

    public static zza zzdn() {
        return (zza) zziu.zzho();
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(zzfi.zzd zzd, Object obj, Object obj2) {
        switch (zzcf.f159xa1df5c61[zzd.ordinal()]) {
            case 1:
                return new zzce();
            case 2:
                return new zza((zzcf) null);
            case 3:
                return zza((zzgs) zziu, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0001\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဉ\u0003\u0005ဌ\u0005\u00062\u0007ဉ\u0004", new Object[]{"zzid", "zzin", "zzio", "zzip", "zziq", "zzis", zzcg.zzdq(), "zzit", zzb.zzjb, "zzir"});
            case 4:
                return zziu;
            case 5:
                zzhc<zzce> zzhc = zzii;
                if (zzhc == null) {
                    synchronized (zzce.class) {
                        zzhc = zzii;
                        if (zzhc == null) {
                            zzhc = new zzfi.zzc<>(zziu);
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

    public static zzce zzdo() {
        return zziu;
    }

    static {
        zzce zzce = new zzce();
        zziu = zzce;
        zzfi.zza(zzce.class, zzce);
    }
}
