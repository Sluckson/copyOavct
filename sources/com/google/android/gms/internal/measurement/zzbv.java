package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhv;
import java.util.List;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
public final class zzbv {

    /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
    public static final class zza extends zzhv<zza, C5076zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zza zzi;
        private static volatile zzjp<zza> zzj;
        private int zzc;
        private int zzd;
        private zzid<zze> zze = zzbs();
        private zzid<zzb> zzf = zzbs();
        private boolean zzg;
        private boolean zzh;

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.measurement.zzbv$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
        public static final class C5076zza extends zzhv.zzb<zza, C5076zza> implements zzji {
            private C5076zza() {
                super(zza.zzi);
            }

            public final int zza() {
                return ((zza) this.zza).zzd();
            }

            public final zze zza(int i) {
                return ((zza) this.zza).zza(i);
            }

            public final C5076zza zza(int i, zze.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(i, (zze) ((zzhv) zza.zzy()));
                return this;
            }

            public final int zzb() {
                return ((zza) this.zza).zzf();
            }

            public final zzb zzb(int i) {
                return ((zza) this.zza).zzb(i);
            }

            public final C5076zza zza(int i, zzb.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(i, (zzb) ((zzhv) zza.zzy()));
                return this;
            }

            /* synthetic */ C5076zza(zzbw zzbw) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final List<zze> zzc() {
            return this.zze;
        }

        public final int zzd() {
            return this.zze.size();
        }

        public final zze zza(int i) {
            return (zze) this.zze.get(i);
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zze zze2) {
            zze2.getClass();
            zzid<zze> zzid = this.zze;
            if (!zzid.zza()) {
                this.zze = zzhv.zza(zzid);
            }
            this.zze.set(i, zze2);
        }

        public final List<zzb> zze() {
            return this.zzf;
        }

        public final int zzf() {
            return this.zzf.size();
        }

        public final zzb zzb(int i) {
            return (zzb) this.zzf.get(i);
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zzb zzb) {
            zzb.getClass();
            zzid<zzb> zzid = this.zzf;
            if (!zzid.zza()) {
                this.zzf = zzhv.zza(zzid);
            }
            this.zzf.set(i, zzb);
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbw.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C5076zza((zzbw) null);
                case 3:
                    return zza((zzjg) zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzc", "zzd", "zze", zze.class, "zzf", zzb.class, "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzjp<zza> zzjp = zzj;
                    if (zzjp == null) {
                        synchronized (zza.class) {
                            zzjp = zzj;
                            if (zzjp == null) {
                                zzjp = new zzhv.zza<>(zzi);
                                zzj = zzjp;
                            }
                        }
                    }
                    return zzjp;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zza zza = new zza();
            zzi = zza;
            zzhv.zza(zza.class, zza);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
    public static final class zzb extends zzhv<zzb, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzb zzl;
        private static volatile zzjp<zzb> zzm;
        private int zzc;
        private int zzd;
        private String zze = "";
        private zzid<zzc> zzf = zzbs();
        private boolean zzg;
        private zzd zzh;
        private boolean zzi;
        private boolean zzj;
        private boolean zzk;

        private zzb() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
        public static final class zza extends zzhv.zzb<zzb, zza> implements zzji {
            private zza() {
                super(zzb.zzl);
            }

            public final String zza() {
                return ((zzb) this.zza).zzc();
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzb) this.zza).zza(str);
                return this;
            }

            public final int zzb() {
                return ((zzb) this.zza).zze();
            }

            public final zzc zza(int i) {
                return ((zzb) this.zza).zza(i);
            }

            public final zza zza(int i, zzc zzc) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzb) this.zza).zza(i, zzc);
                return this;
            }

            /* synthetic */ zza(zzbw zzbw) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final String zzc() {
            return this.zze;
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        public final List<zzc> zzd() {
            return this.zzf;
        }

        public final int zze() {
            return this.zzf.size();
        }

        public final zzc zza(int i) {
            return (zzc) this.zzf.get(i);
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zzc zzc2) {
            zzc2.getClass();
            zzid<zzc> zzid = this.zzf;
            if (!zzid.zza()) {
                this.zzf = zzhv.zza(zzid);
            }
            this.zzf.set(i, zzc2);
        }

        public final boolean zzf() {
            return (this.zzc & 8) != 0;
        }

        public final zzd zzg() {
            zzd zzd2 = this.zzh;
            return zzd2 == null ? zzd.zzk() : zzd2;
        }

        public final boolean zzh() {
            return this.zzi;
        }

        public final boolean zzi() {
            return this.zzj;
        }

        public final boolean zzj() {
            return (this.zzc & 64) != 0;
        }

        public final boolean zzk() {
            return this.zzk;
        }

        public static zza zzl() {
            return (zza) zzl.zzbm();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbw.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzbw) null);
                case 3:
                    return zza((zzjg) zzl, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzc", "zzd", "zze", "zzf", zzc.class, "zzg", "zzh", "zzi", "zzj", "zzk"});
                case 4:
                    return zzl;
                case 5:
                    zzjp<zzb> zzjp = zzm;
                    if (zzjp == null) {
                        synchronized (zzb.class) {
                            zzjp = zzm;
                            if (zzjp == null) {
                                zzjp = new zzhv.zza<>(zzl);
                                zzm = zzjp;
                            }
                        }
                    }
                    return zzjp;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zzb zzb = new zzb();
            zzl = zzb;
            zzhv.zza(zzb.class, zzb);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
    public static final class zzd extends zzhv<zzd, zzb> implements zzji {
        /* access modifiers changed from: private */
        public static final zzd zzi;
        private static volatile zzjp<zzd> zzj;
        private int zzc;
        private int zzd;
        private boolean zze;
        private String zzf = "";
        private String zzg = "";
        private String zzh = "";

        /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
        public enum zza implements zzia {
            UNKNOWN_COMPARISON_TYPE(0),
            LESS_THAN(1),
            GREATER_THAN(2),
            EQUAL(3),
            BETWEEN(4);
            
            private static final zzhz<zza> zzf = null;
            private final int zzg;

            public final int zza() {
                return this.zzg;
            }

            public static zza zza(int i) {
                if (i == 0) {
                    return UNKNOWN_COMPARISON_TYPE;
                }
                if (i == 1) {
                    return LESS_THAN;
                }
                if (i == 2) {
                    return GREATER_THAN;
                }
                if (i == 3) {
                    return EQUAL;
                }
                if (i != 4) {
                    return null;
                }
                return BETWEEN;
            }

            public static zzic zzb() {
                return zzbx.zza;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzg + " name=" + name() + Typography.greater;
            }

            private zza(int i) {
                this.zzg = i;
            }

            static {
                zzf = new zzby();
            }
        }

        private zzd() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
        public static final class zzb extends zzhv.zzb<zzd, zzb> implements zzji {
            private zzb() {
                super(zzd.zzi);
            }

            /* synthetic */ zzb(zzbw zzbw) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final zza zzb() {
            zza zza2 = zza.zza(this.zzd);
            return zza2 == null ? zza.UNKNOWN_COMPARISON_TYPE : zza2;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final boolean zzd() {
            return this.zze;
        }

        public final boolean zze() {
            return (this.zzc & 4) != 0;
        }

        public final String zzf() {
            return this.zzf;
        }

        public final boolean zzg() {
            return (this.zzc & 8) != 0;
        }

        public final String zzh() {
            return this.zzg;
        }

        public final boolean zzi() {
            return (this.zzc & 16) != 0;
        }

        public final String zzj() {
            return this.zzh;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbw.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zzb((zzbw) null);
                case 3:
                    return zza((zzjg) zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zzc", "zzd", zza.zzb(), "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzjp<zzd> zzjp = zzj;
                    if (zzjp == null) {
                        synchronized (zzd.class) {
                            zzjp = zzj;
                            if (zzjp == null) {
                                zzjp = new zzhv.zza<>(zzi);
                                zzj = zzjp;
                            }
                        }
                    }
                    return zzjp;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzd zzk() {
            return zzi;
        }

        static {
            zzd zzd2 = new zzd();
            zzi = zzd2;
            zzhv.zza(zzd.class, zzd2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
    public static final class zzf extends zzhv<zzf, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzf zzh;
        private static volatile zzjp<zzf> zzi;
        private int zzc;
        private int zzd;
        private String zze = "";
        private boolean zzf;
        private zzid<String> zzg = zzhv.zzbs();

        /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
        public enum zzb implements zzia {
            UNKNOWN_MATCH_TYPE(0),
            REGEXP(1),
            BEGINS_WITH(2),
            ENDS_WITH(3),
            PARTIAL(4),
            EXACT(5),
            IN_LIST(6);
            
            private static final zzhz<zzb> zzh = null;
            private final int zzi;

            public final int zza() {
                return this.zzi;
            }

            public static zzb zza(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN_MATCH_TYPE;
                    case 1:
                        return REGEXP;
                    case 2:
                        return BEGINS_WITH;
                    case 3:
                        return ENDS_WITH;
                    case 4:
                        return PARTIAL;
                    case 5:
                        return EXACT;
                    case 6:
                        return IN_LIST;
                    default:
                        return null;
                }
            }

            public static zzic zzb() {
                return zzcb.zza;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzi + " name=" + name() + Typography.greater;
            }

            private zzb(int i) {
                this.zzi = i;
            }

            static {
                zzh = new zzbz();
            }
        }

        private zzf() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
        public static final class zza extends zzhv.zzb<zzf, zza> implements zzji {
            private zza() {
                super(zzf.zzh);
            }

            /* synthetic */ zza(zzbw zzbw) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final zzb zzb() {
            zzb zza2 = zzb.zza(this.zzd);
            return zza2 == null ? zzb.UNKNOWN_MATCH_TYPE : zza2;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final String zzd() {
            return this.zze;
        }

        public final boolean zze() {
            return (this.zzc & 4) != 0;
        }

        public final boolean zzf() {
            return this.zzf;
        }

        public final List<String> zzg() {
            return this.zzg;
        }

        public final int zzh() {
            return this.zzg.size();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbw.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza((zzbw) null);
                case 3:
                    return zza((zzjg) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zzc", "zzd", zzb.zzb(), "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzjp<zzf> zzjp = zzi;
                    if (zzjp == null) {
                        synchronized (zzf.class) {
                            zzjp = zzi;
                            if (zzjp == null) {
                                zzjp = new zzhv.zza<>(zzh);
                                zzi = zzjp;
                            }
                        }
                    }
                    return zzjp;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzf zzi() {
            return zzh;
        }

        static {
            zzf zzf2 = new zzf();
            zzh = zzf2;
            zzhv.zza(zzf.class, zzf2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
    public static final class zzc extends zzhv<zzc, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzc zzh;
        private static volatile zzjp<zzc> zzi;
        private int zzc;
        private zzf zzd;
        private zzd zze;
        private boolean zzf;
        private String zzg = "";

        private zzc() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
        public static final class zza extends zzhv.zzb<zzc, zza> implements zzji {
            private zza() {
                super(zzc.zzh);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(str);
                return this;
            }

            /* synthetic */ zza(zzbw zzbw) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final zzf zzb() {
            zzf zzf2 = this.zzd;
            return zzf2 == null ? zzf.zzi() : zzf2;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final zzd zzd() {
            zzd zzd2 = this.zze;
            return zzd2 == null ? zzd.zzk() : zzd2;
        }

        public final boolean zze() {
            return (this.zzc & 4) != 0;
        }

        public final boolean zzf() {
            return this.zzf;
        }

        public final boolean zzg() {
            return (this.zzc & 8) != 0;
        }

        public final String zzh() {
            return this.zzg;
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 8;
            this.zzg = str;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbw.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzbw) null);
                case 3:
                    return zza((zzjg) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzjp<zzc> zzjp = zzi;
                    if (zzjp == null) {
                        synchronized (zzc.class) {
                            zzjp = zzi;
                            if (zzjp == null) {
                                zzjp = new zzhv.zza<>(zzh);
                                zzi = zzjp;
                            }
                        }
                    }
                    return zzjp;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public static zzc zzi() {
            return zzh;
        }

        static {
            zzc zzc2 = new zzc();
            zzh = zzc2;
            zzhv.zza(zzc.class, zzc2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
    public static final class zze extends zzhv<zze, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zze zzj;
        private static volatile zzjp<zze> zzk;
        private int zzc;
        private int zzd;
        private String zze = "";
        private zzc zzf;
        private boolean zzg;
        private boolean zzh;
        private boolean zzi;

        private zze() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
        public static final class zza extends zzhv.zzb<zze, zza> implements zzji {
            private zza() {
                super(zze.zzj);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zza(str);
                return this;
            }

            /* synthetic */ zza(zzbw zzbw) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        public final String zzc() {
            return this.zze;
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        public final zzc zzd() {
            zzc zzc2 = this.zzf;
            return zzc2 == null ? zzc.zzi() : zzc2;
        }

        public final boolean zze() {
            return this.zzg;
        }

        public final boolean zzf() {
            return this.zzh;
        }

        public final boolean zzg() {
            return (this.zzc & 32) != 0;
        }

        public final boolean zzh() {
            return this.zzi;
        }

        public static zza zzi() {
            return (zza) zzj.zzbm();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbw.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza((zzbw) null);
                case 3:
                    return zza((zzjg) zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzjp<zze> zzjp = zzk;
                    if (zzjp == null) {
                        synchronized (zze.class) {
                            zzjp = zzk;
                            if (zzjp == null) {
                                zzjp = new zzhv.zza<>(zzj);
                                zzk = zzjp;
                            }
                        }
                    }
                    return zzjp;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zze zze2 = new zze();
            zzj = zze2;
            zzhv.zza(zze.class, zze2);
        }
    }
}
