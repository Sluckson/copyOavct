package com.google.android.gms.internal.p010firebaseperf;

import com.google.android.gms.internal.p010firebaseperf.zzfi;
import java.util.List;
import java.util.Map;
import kotlin.text.Typography;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzcx */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
public final class zzcx extends zzfi<zzcx, zzb> implements zzgu {
    private static volatile zzhc<zzcx> zzii;
    /* access modifiers changed from: private */
    public static final zzcx zzks;
    private int zzid;
    private zzgm<String, String> zzit = zzgm.zzid();
    private String zzkg = "";
    private int zzkh;
    private long zzki;
    private long zzkj;
    private int zzkk;
    private int zzkl;
    private String zzkm = "";
    private long zzkn;
    private long zzko;
    private long zzkp;
    private long zzkq;
    private zzfp<zzde> zzkr = zzhq();

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzcx$zza */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    static final class zza {
        static final zzgk<String, String> zzjb = zzgk.zza(zzio.STRING, "", zzio.STRING, "");
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzcx$zzc */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    public enum zzc implements zzfm {
        HTTP_METHOD_UNKNOWN(0),
        GET(1),
        PUT(2),
        POST(3),
        DELETE(4),
        HEAD(5),
        PATCH(6),
        OPTIONS(7),
        TRACE(8),
        CONNECT(9);
        
        private static final zzfl<zzc> zziz = null;
        private final int value;

        public final int getNumber() {
            return this.value;
        }

        public static zzc zzm(int i) {
            switch (i) {
                case 0:
                    return HTTP_METHOD_UNKNOWN;
                case 1:
                    return GET;
                case 2:
                    return PUT;
                case 3:
                    return POST;
                case 4:
                    return DELETE;
                case 5:
                    return HEAD;
                case 6:
                    return PATCH;
                case 7:
                    return OPTIONS;
                case 8:
                    return TRACE;
                case 9:
                    return CONNECT;
                default:
                    return null;
            }
        }

        public static zzfo zzdq() {
            return zzcz.zzjc;
        }

        public final String toString() {
            return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + getNumber() + " name=" + name() + Typography.greater;
        }

        private zzc(int i) {
            this.value = i;
        }

        static {
            zziz = new zzcy();
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzcx$zzd */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    public enum zzd implements zzfm {
        NETWORK_CLIENT_ERROR_REASON_UNKNOWN(0),
        GENERIC_CLIENT_ERROR(1);
        
        private static final zzfl<zzd> zziz = null;
        private final int value;

        public final int getNumber() {
            return this.value;
        }

        public static zzfo zzdq() {
            return zzda.zzjc;
        }

        public final String toString() {
            return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + getNumber() + " name=" + name() + Typography.greater;
        }

        private zzd(int i) {
            this.value = i;
        }

        static {
            zziz = new zzdb();
        }
    }

    private zzcx() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzcx$zzb */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    public static final class zzb extends zzfi.zza<zzcx, zzb> implements zzgu {
        private zzb() {
            super(zzcx.zzks);
        }

        public final zzb zzae(String str) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzcx) this.zzqt).setUrl(str);
            return this;
        }

        public final zzb zzb(zzc zzc) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzcx) this.zzqt).zza(zzc);
            return this;
        }

        public final zzb zzah(long j) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzcx) this.zzqt).zzab(j);
            return this;
        }

        public final zzb zzai(long j) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzcx) this.zzqt).zzac(j);
            return this;
        }

        public final zzb zzb(zzd zzd) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzcx) this.zzqt).zza(zzd);
            return this;
        }

        public final boolean zzbh() {
            return ((zzcx) this.zzqt).zzbh();
        }

        public final zzb zzl(int i) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzcx) this.zzqt).setHttpResponseCode(i);
            return this;
        }

        public final zzb zzaf(String str) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzcx) this.zzqt).setResponseContentType(str);
            return this;
        }

        public final zzb zzfc() {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzcx) this.zzqt).zzep();
            return this;
        }

        public final boolean zzeq() {
            return ((zzcx) this.zzqt).zzeq();
        }

        public final zzb zzaj(long j) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzcx) this.zzqt).zzad(j);
            return this;
        }

        public final zzb zzak(long j) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzcx) this.zzqt).zzae(j);
            return this;
        }

        public final long zzev() {
            return ((zzcx) this.zzqt).zzev();
        }

        public final zzb zzal(long j) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzcx) this.zzqt).zzaf(j);
            return this;
        }

        public final boolean zzew() {
            return ((zzcx) this.zzqt).zzew();
        }

        public final zzb zzam(long j) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzcx) this.zzqt).zzag(j);
            return this;
        }

        public final zzb zzfd() {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzcx) this.zzqt).zzdm().clear();
            return this;
        }

        public final zzb zzc(Map<String, String> map) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzcx) this.zzqt).zzdm().putAll(map);
            return this;
        }

        public final zzb zzb(Iterable<? extends zzde> iterable) {
            if (this.zzqu) {
                zzhi();
                this.zzqu = false;
            }
            ((zzcx) this.zzqt).zza(iterable);
            return this;
        }

        /* synthetic */ zzb(zzcw zzcw) {
            this();
        }
    }

    public final String getUrl() {
        return this.zzkg;
    }

    /* access modifiers changed from: private */
    public final void setUrl(String str) {
        str.getClass();
        this.zzid |= 1;
        this.zzkg = str;
    }

    public final boolean zzei() {
        return (this.zzid & 2) != 0;
    }

    public final zzc zzej() {
        zzc zzm = zzc.zzm(this.zzkh);
        return zzm == null ? zzc.HTTP_METHOD_UNKNOWN : zzm;
    }

    /* access modifiers changed from: private */
    public final void zza(zzc zzc2) {
        this.zzkh = zzc2.getNumber();
        this.zzid |= 2;
    }

    public final boolean zzek() {
        return (this.zzid & 4) != 0;
    }

    public final long zzel() {
        return this.zzki;
    }

    /* access modifiers changed from: private */
    public final void zzab(long j) {
        this.zzid |= 4;
        this.zzki = j;
    }

    public final boolean zzem() {
        return (this.zzid & 8) != 0;
    }

    public final long zzen() {
        return this.zzkj;
    }

    /* access modifiers changed from: private */
    public final void zzac(long j) {
        this.zzid |= 8;
        this.zzkj = j;
    }

    /* access modifiers changed from: private */
    public final void zza(zzd zzd2) {
        this.zzkk = zzd2.getNumber();
        this.zzid |= 16;
    }

    public final boolean zzbh() {
        return (this.zzid & 32) != 0;
    }

    public final int zzeo() {
        return this.zzkl;
    }

    /* access modifiers changed from: private */
    public final void setHttpResponseCode(int i) {
        this.zzid |= 32;
        this.zzkl = i;
    }

    /* access modifiers changed from: private */
    public final void setResponseContentType(String str) {
        str.getClass();
        this.zzid |= 64;
        this.zzkm = str;
    }

    /* access modifiers changed from: private */
    public final void zzep() {
        this.zzid &= -65;
        this.zzkm = zzks.zzkm;
    }

    public final boolean zzeq() {
        return (this.zzid & 128) != 0;
    }

    public final long zzer() {
        return this.zzkn;
    }

    /* access modifiers changed from: private */
    public final void zzad(long j) {
        this.zzid |= 128;
        this.zzkn = j;
    }

    public final boolean zzes() {
        return (this.zzid & 256) != 0;
    }

    public final long zzet() {
        return this.zzko;
    }

    /* access modifiers changed from: private */
    public final void zzae(long j) {
        this.zzid |= 256;
        this.zzko = j;
    }

    public final boolean zzeu() {
        return (this.zzid & 512) != 0;
    }

    public final long zzev() {
        return this.zzkp;
    }

    /* access modifiers changed from: private */
    public final void zzaf(long j) {
        this.zzid |= 512;
        this.zzkp = j;
    }

    public final boolean zzew() {
        return (this.zzid & 1024) != 0;
    }

    public final long zzex() {
        return this.zzkq;
    }

    /* access modifiers changed from: private */
    public final void zzag(long j) {
        this.zzid |= 1024;
        this.zzkq = j;
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

    /* access modifiers changed from: private */
    public final void zza(Iterable<? extends zzde> iterable) {
        zzfp<zzde> zzfp = this.zzkr;
        if (!zzfp.zzgj()) {
            this.zzkr = zzfi.zza(zzfp);
        }
        zzdz.zza(iterable, this.zzkr);
    }

    public static zzb zzez() {
        return (zzb) zzks.zzho();
    }

    /* access modifiers changed from: protected */
    public final Object dynamicMethod(zzfi.zzd zzd2, Object obj, Object obj2) {
        switch (zzcw.f165xa1df5c61[zzd2.ordinal()]) {
            case 1:
                return new zzcx();
            case 2:
                return new zzb((zzcw) null);
            case 3:
                return zza((zzgs) zzks, "\u0001\r\u0000\u0001\u0001\r\r\u0001\u0001\u0000\u0001ဈ\u0000\u0002ဌ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005င\u0005\u0006ဈ\u0006\u0007ဂ\u0007\bဂ\b\tဂ\t\nဂ\n\u000bဌ\u0004\f2\r\u001b", new Object[]{"zzid", "zzkg", "zzkh", zzc.zzdq(), "zzki", "zzkj", "zzkl", "zzkm", "zzkn", "zzko", "zzkp", "zzkq", "zzkk", zzd.zzdq(), "zzit", zza.zzjb, "zzkr", zzde.class});
            case 4:
                return zzks;
            case 5:
                zzhc<zzcx> zzhc = zzii;
                if (zzhc == null) {
                    synchronized (zzcx.class) {
                        zzhc = zzii;
                        if (zzhc == null) {
                            zzhc = new zzfi.zzc<>(zzks);
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

    public static zzcx zzfa() {
        return zzks;
    }

    static {
        zzcx zzcx = new zzcx();
        zzks = zzcx;
        zzfi.zza(zzcx.class, zzcx);
    }
}
