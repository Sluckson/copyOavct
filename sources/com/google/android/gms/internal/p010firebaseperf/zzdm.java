package com.google.android.gms.internal.p010firebaseperf;

import com.google.android.gms.internal.p010firebaseperf.zzfi;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzdm */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzdm extends zzfi<zzdm, zza> implements zzgu {
    private static volatile zzhc<zzdm> zzii;
    /* access modifiers changed from: private */
    public static final zzdm zzmd;
    private int zzid;
    private zzgm<String, String> zzit = zzgm.zzid();
    private long zzkn;
    private zzfp<zzde> zzkr = zzhq();
    private String zzly = "";
    private boolean zzlz;
    private long zzma;
    private zzgm<String, Long> zzmb = zzgm.zzid();
    private zzfp<zzdm> zzmc = zzhq();

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzdm$zzb */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    static final class zzb {
        static final zzgk<String, String> zzjb = zzgk.zza(zzio.STRING, "", zzio.STRING, "");
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzdm$zzc */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    static final class zzc {
        static final zzgk<String, Long> zzjb = zzgk.zza(zzio.STRING, "", zzio.INT64, 0L);
    }

    private zzdm() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzdm$zza */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    public static final class zza extends zzfi.zza<zzdm, zza> implements zzgu {
        private zza() {
            super(zzdm.zzmd);
        }

        public final zza zzah(String str) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzdm) this.zzqt).setName(str);
            return this;
        }

        public final zza zzao(long j) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzdm) this.zzqt).zzad(j);
            return this;
        }

        public final zza zzap(long j) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzdm) this.zzqt).zzan(j);
            return this;
        }

        public final zza zzc(String str, long j) {
            str.getClass();
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzdm) this.zzqt).zzft().put(str, Long.valueOf(j));
            return this;
        }

        public final zza zzd(Map<String, Long> map) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzdm) this.zzqt).zzft().putAll(map);
            return this;
        }

        public final zza zzf(zzdm zzdm) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzdm) this.zzqt).zzc(zzdm);
            return this;
        }

        public final zza zzd(Iterable<? extends zzdm> iterable) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzdm) this.zzqt).zzc(iterable);
            return this;
        }

        public final zza zze(Map<String, String> map) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzdm) this.zzqt).zzdm().putAll(map);
            return this;
        }

        public final zza zzb(zzde zzde) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzdm) this.zzqt).zza(zzde);
            return this;
        }

        public final zza zze(Iterable<? extends zzde> iterable) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzdm) this.zzqt).zza(iterable);
            return this;
        }

        /* synthetic */ zza(zzdo zzdo) {
            this();
        }
    }

    public final String getName() {
        return this.zzly;
    }

    /* access modifiers changed from: private */
    public final void setName(String str) {
        str.getClass();
        this.zzid |= 1;
        this.zzly = str;
    }

    public final boolean zzeq() {
        return (this.zzid & 4) != 0;
    }

    /* access modifiers changed from: private */
    public final void zzad(long j) {
        this.zzid |= 4;
        this.zzkn = j;
    }

    public final long getDurationUs() {
        return this.zzma;
    }

    /* access modifiers changed from: private */
    public final void zzan(long j) {
        this.zzid |= 8;
        this.zzma = j;
    }

    public final int zzfr() {
        return this.zzmb.size();
    }

    public final Map<String, Long> zzfs() {
        return Collections.unmodifiableMap(this.zzmb);
    }

    /* access modifiers changed from: private */
    public final Map<String, Long> zzft() {
        if (!this.zzmb.isMutable()) {
            this.zzmb = this.zzmb.zzie();
        }
        return this.zzmb;
    }

    public final List<zzdm> zzfu() {
        return this.zzmc;
    }

    private final void zzfv() {
        zzfp<zzdm> zzfp = this.zzmc;
        if (!zzfp.zzgj()) {
            this.zzmc = zzfi.zza(zzfp);
        }
    }

    /* access modifiers changed from: private */
    public final void zzc(zzdm zzdm) {
        zzdm.getClass();
        zzfv();
        this.zzmc.add(zzdm);
    }

    /* access modifiers changed from: private */
    public final void zzc(Iterable<? extends zzdm> iterable) {
        zzfv();
        zzdz.zza(iterable, this.zzmc);
    }

    public final Map<String, String> zzfw() {
        return Collections.unmodifiableMap(this.zzit);
    }

    /* access modifiers changed from: private */
    public final Map<String, String> zzdm() {
        if (!this.zzit.isMutable()) {
            this.zzit = this.zzit.zzie();
        }
        return this.zzit;
    }

    public final List<zzde> zzey() {
        return this.zzkr;
    }

    private final void zzfx() {
        zzfp<zzde> zzfp = this.zzkr;
        if (!zzfp.zzgj()) {
            this.zzkr = zzfi.zza(zzfp);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(zzde zzde) {
        zzde.getClass();
        zzfx();
        this.zzkr.add(zzde);
    }

    /* access modifiers changed from: private */
    public final void zza(Iterable<? extends zzde> iterable) {
        zzfx();
        zzdz.zza(iterable, this.zzkr);
    }

    public static zza zzfy() {
        return (zza) zzmd.zzho();
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(zzfi.zzd zzd, Object obj, Object obj2) {
        switch (zzdo.f168xa1df5c61[zzd.ordinal()]) {
            case 1:
                return new zzdm();
            case 2:
                return new zza((zzdo) null);
            case 3:
                return zza((zzgs) zzmd, "\u0001\b\u0000\u0001\u0001\t\b\u0002\u0002\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0004ဂ\u0002\u0005ဂ\u0003\u00062\u0007\u001b\b2\t\u001b", new Object[]{"zzid", "zzly", "zzlz", "zzkn", "zzma", "zzmb", zzc.zzjb, "zzmc", zzdm.class, "zzit", zzb.zzjb, "zzkr", zzde.class});
            case 4:
                return zzmd;
            case 5:
                zzhc<zzdm> zzhc = zzii;
                if (zzhc == null) {
                    synchronized (zzdm.class) {
                        zzhc = zzii;
                        if (zzhc == null) {
                            zzhc = new zzfi.zzc<>(zzmd);
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

    public static zzdm zzfz() {
        return zzmd;
    }

    static {
        zzdm zzdm = new zzdm();
        zzmd = zzdm;
        zzfi.zza(zzdm.class, zzdm);
    }
}
