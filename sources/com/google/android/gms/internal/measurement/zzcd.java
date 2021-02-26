package com.google.android.gms.internal.measurement;

import com.google.android.exoplayer2.C1119C;
import com.google.android.gms.internal.measurement.zzhv;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.lowagie.text.pdf.PdfFormField;
import java.util.Collections;
import java.util.List;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
public final class zzcd {

    /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
    public static final class zzc extends zzhv<zzc, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzc zzi;
        private static volatile zzjp<zzc> zzj;
        private int zzc;
        private zzid<zze> zzd = zzbs();
        private String zze = "";
        private long zzf;
        private long zzg;
        private int zzh;

        private zzc() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
        public static final class zza extends zzhv.zzb<zzc, zza> implements zzji {
            private zza() {
                super(zzc.zzi);
            }

            public final List<zze> zza() {
                return Collections.unmodifiableList(((zzc) this.zza).zza());
            }

            public final int zzb() {
                return ((zzc) this.zza).zzb();
            }

            public final zze zza(int i) {
                return ((zzc) this.zza).zza(i);
            }

            public final zza zza(int i, zze zze) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(i, zze);
                return this;
            }

            public final zza zza(int i, zze.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(i, (zze) ((zzhv) zza.zzy()));
                return this;
            }

            public final zza zza(zze zze) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(zze);
                return this;
            }

            public final zza zza(zze.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza((zze) ((zzhv) zza.zzy()));
                return this;
            }

            public final zza zza(Iterable<? extends zze> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(iterable);
                return this;
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zzm();
                return this;
            }

            public final zza zzb(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zzb(i);
                return this;
            }

            public final String zzd() {
                return ((zzc) this.zza).zzc();
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(str);
                return this;
            }

            public final boolean zze() {
                return ((zzc) this.zza).zzd();
            }

            public final long zzf() {
                return ((zzc) this.zza).zze();
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zza(j);
                return this;
            }

            public final long zzg() {
                return ((zzc) this.zza).zzg();
            }

            public final zza zzb(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzc) this.zza).zzb(j);
                return this;
            }

            /* synthetic */ zza(zzce zzce) {
                this();
            }
        }

        public final List<zze> zza() {
            return this.zzd;
        }

        public final int zzb() {
            return this.zzd.size();
        }

        public final zze zza(int i) {
            return (zze) this.zzd.get(i);
        }

        private final void zzl() {
            zzid<zze> zzid = this.zzd;
            if (!zzid.zza()) {
                this.zzd = zzhv.zza(zzid);
            }
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zze zze2) {
            zze2.getClass();
            zzl();
            this.zzd.set(i, zze2);
        }

        /* access modifiers changed from: private */
        public final void zza(zze zze2) {
            zze2.getClass();
            zzl();
            this.zzd.add(zze2);
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends zze> iterable) {
            zzl();
            zzgd.zza(iterable, this.zzd);
        }

        /* access modifiers changed from: private */
        public final void zzm() {
            this.zzd = zzbs();
        }

        /* access modifiers changed from: private */
        public final void zzb(int i) {
            zzl();
            this.zzd.remove(i);
        }

        public final String zzc() {
            return this.zze;
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zze = str;
        }

        public final boolean zzd() {
            return (this.zzc & 2) != 0;
        }

        public final long zze() {
            return this.zzf;
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 2;
            this.zzf = j;
        }

        public final boolean zzf() {
            return (this.zzc & 4) != 0;
        }

        public final long zzg() {
            return this.zzg;
        }

        /* access modifiers changed from: private */
        public final void zzb(long j) {
            this.zzc |= 4;
            this.zzg = j;
        }

        public final boolean zzh() {
            return (this.zzc & 8) != 0;
        }

        public final int zzi() {
            return this.zzh;
        }

        public static zza zzj() {
            return (zza) zzi.zzbm();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzce.zza[i - 1]) {
                case 1:
                    return new zzc();
                case 2:
                    return new zza((zzce) null);
                case 3:
                    return zza((zzjg) zzi, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zzc", "zzd", zze.class, "zze", "zzf", "zzg", "zzh"});
                case 4:
                    return zzi;
                case 5:
                    zzjp<zzc> zzjp = zzj;
                    if (zzjp == null) {
                        synchronized (zzc.class) {
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
            zzc zzc2 = new zzc();
            zzi = zzc2;
            zzhv.zza(zzc.class, zzc2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
    public static final class zzf extends zzhv<zzf, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzf zzd;
        private static volatile zzjp<zzf> zze;
        private zzid<zzg> zzc = zzbs();

        private zzf() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
        public static final class zza extends zzhv.zzb<zzf, zza> implements zzji {
            private zza() {
                super(zzf.zzd);
            }

            public final zzg zza(int i) {
                return ((zzf) this.zza).zza(0);
            }

            public final zza zza(zzg.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzf) this.zza).zza((zzg) ((zzhv) zza.zzy()));
                return this;
            }

            /* synthetic */ zza(zzce zzce) {
                this();
            }
        }

        public final List<zzg> zza() {
            return this.zzc;
        }

        public final zzg zza(int i) {
            return (zzg) this.zzc.get(0);
        }

        /* access modifiers changed from: private */
        public final void zza(zzg zzg) {
            zzg.getClass();
            zzid<zzg> zzid = this.zzc;
            if (!zzid.zza()) {
                this.zzc = zzhv.zza(zzid);
            }
            this.zzc.add(zzg);
        }

        public static zza zzb() {
            return (zza) zzd.zzbm();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzce.zza[i - 1]) {
                case 1:
                    return new zzf();
                case 2:
                    return new zza((zzce) null);
                case 3:
                    return zza((zzjg) zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzg.class});
                case 4:
                    return zzd;
                case 5:
                    zzjp<zzf> zzjp = zze;
                    if (zzjp == null) {
                        synchronized (zzf.class) {
                            zzjp = zze;
                            if (zzjp == null) {
                                zzjp = new zzhv.zza<>(zzd);
                                zze = zzjp;
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
            zzf zzf = new zzf();
            zzd = zzf;
            zzhv.zza(zzf.class, zzf);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
    public static final class zza extends zzhv<zza, C5078zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zza zzh;
        private static volatile zzjp<zza> zzi;
        private int zzc;
        private int zzd;
        private zzi zze;
        private zzi zzf;
        private boolean zzg;

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.measurement.zzcd$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
        public static final class C5078zza extends zzhv.zzb<zza, C5078zza> implements zzji {
            private C5078zza() {
                super(zza.zzh);
            }

            public final C5078zza zza(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(i);
                return this;
            }

            public final C5078zza zza(zzi.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zza) this.zza).zza((zzi) ((zzhv) zza.zzy()));
                return this;
            }

            public final C5078zza zza(zzi zzi) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zza) this.zza).zzb(zzi);
                return this;
            }

            public final C5078zza zza(boolean z) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zza) this.zza).zza(z);
                return this;
            }

            /* synthetic */ C5078zza(zzce zzce) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        /* access modifiers changed from: private */
        public final void zza(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        public final zzi zzc() {
            zzi zzi2 = this.zze;
            return zzi2 == null ? zzi.zzj() : zzi2;
        }

        /* access modifiers changed from: private */
        public final void zza(zzi zzi2) {
            zzi2.getClass();
            this.zze = zzi2;
            this.zzc |= 2;
        }

        public final boolean zzd() {
            return (this.zzc & 4) != 0;
        }

        public final zzi zze() {
            zzi zzi2 = this.zzf;
            return zzi2 == null ? zzi.zzj() : zzi2;
        }

        /* access modifiers changed from: private */
        public final void zzb(zzi zzi2) {
            zzi2.getClass();
            this.zzf = zzi2;
            this.zzc |= 4;
        }

        public final boolean zzf() {
            return (this.zzc & 8) != 0;
        }

        public final boolean zzg() {
            return this.zzg;
        }

        /* access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 8;
            this.zzg = z;
        }

        public static C5078zza zzh() {
            return (C5078zza) zzh.zzbm();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzce.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C5078zza((zzce) null);
                case 3:
                    return zza((zzjg) zzh, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg"});
                case 4:
                    return zzh;
                case 5:
                    zzjp<zza> zzjp = zzi;
                    if (zzjp == null) {
                        synchronized (zza.class) {
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

        static {
            zza zza = new zza();
            zzh = zza;
            zzhv.zza(zza.class, zza);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
    public static final class zzb extends zzhv<zzb, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzb zzf;
        private static volatile zzjp<zzb> zzg;
        private int zzc;
        private int zzd;
        private long zze;

        private zzb() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
        public static final class zza extends zzhv.zzb<zzb, zza> implements zzji {
            private zza() {
                super(zzb.zzf);
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzb) this.zza).zza(i);
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzb) this.zza).zza(j);
                return this;
            }

            /* synthetic */ zza(zzce zzce) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        /* access modifiers changed from: private */
        public final void zza(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final long zzd() {
            return this.zze;
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 2;
            this.zze = j;
        }

        public static zza zze() {
            return (zza) zzf.zzbm();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzce.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzce) null);
                case 3:
                    return zza((zzjg) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzjp<zzb> zzjp = zzg;
                    if (zzjp == null) {
                        synchronized (zzb.class) {
                            zzjp = zzg;
                            if (zzjp == null) {
                                zzjp = new zzhv.zza<>(zzf);
                                zzg = zzjp;
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
            zzf = zzb;
            zzhv.zza(zzb.class, zzb);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
    public static final class zzd extends zzhv<zzd, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzd zzf;
        private static volatile zzjp<zzd> zzg;
        private int zzc;
        private String zzd = "";
        private long zze;

        private zzd() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
        public static final class zza extends zzhv.zzb<zzd, zza> implements zzji {
            private zza() {
                super(zzd.zzf);
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzd) this.zza).zza(str);
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzd) this.zza).zza(j);
                return this;
            }

            /* synthetic */ zza(zzce zzce) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 2;
            this.zze = j;
        }

        public static zza zza() {
            return (zza) zzf.zzbm();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzce.zza[i - 1]) {
                case 1:
                    return new zzd();
                case 2:
                    return new zza((zzce) null);
                case 3:
                    return zza((zzjg) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzjp<zzd> zzjp = zzg;
                    if (zzjp == null) {
                        synchronized (zzd.class) {
                            zzjp = zzg;
                            if (zzjp == null) {
                                zzjp = new zzhv.zza<>(zzf);
                                zzg = zzjp;
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
            zzd zzd2 = new zzd();
            zzf = zzd2;
            zzhv.zza(zzd.class, zzd2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
    public static final class zze extends zzhv<zze, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zze zzj;
        private static volatile zzjp<zze> zzk;
        private int zzc;
        private String zzd = "";
        private String zze = "";
        private long zzf;
        private float zzg;
        private double zzh;
        private zzid<zze> zzi = zzbs();

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

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zzb(str);
                return this;
            }

            public final zza zza() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zzo();
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zza(j);
                return this;
            }

            public final zza zzb() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zzp();
                return this;
            }

            public final zza zza(double d) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zza(d);
                return this;
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zzq();
                return this;
            }

            public final int zzd() {
                return ((zze) this.zza).zzl();
            }

            public final zza zza(zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zze((zze) ((zzhv) zza.zzy()));
                return this;
            }

            public final zza zza(Iterable<? extends zze> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zza(iterable);
                return this;
            }

            public final zza zze() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zze) this.zza).zzs();
                return this;
            }

            /* synthetic */ zza(zzce zzce) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final String zzb() {
            return this.zzd;
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 1;
            this.zzd = str;
        }

        public final boolean zzc() {
            return (this.zzc & 2) != 0;
        }

        public final String zzd() {
            return this.zze;
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 2;
            this.zze = str;
        }

        /* access modifiers changed from: private */
        public final void zzo() {
            this.zzc &= -3;
            this.zze = zzj.zze;
        }

        public final boolean zze() {
            return (this.zzc & 4) != 0;
        }

        public final long zzf() {
            return this.zzf;
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 4;
            this.zzf = j;
        }

        /* access modifiers changed from: private */
        public final void zzp() {
            this.zzc &= -5;
            this.zzf = 0;
        }

        public final boolean zzg() {
            return (this.zzc & 8) != 0;
        }

        public final float zzh() {
            return this.zzg;
        }

        public final boolean zzi() {
            return (this.zzc & 16) != 0;
        }

        public final double zzj() {
            return this.zzh;
        }

        /* access modifiers changed from: private */
        public final void zza(double d) {
            this.zzc |= 16;
            this.zzh = d;
        }

        /* access modifiers changed from: private */
        public final void zzq() {
            this.zzc &= -17;
            this.zzh = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }

        public final List<zze> zzk() {
            return this.zzi;
        }

        public final int zzl() {
            return this.zzi.size();
        }

        private final void zzr() {
            zzid<zze> zzid = this.zzi;
            if (!zzid.zza()) {
                this.zzi = zzhv.zza(zzid);
            }
        }

        /* access modifiers changed from: private */
        public final void zze(zze zze2) {
            zze2.getClass();
            zzr();
            this.zzi.add(zze2);
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends zze> iterable) {
            zzr();
            zzgd.zza(iterable, this.zzi);
        }

        /* access modifiers changed from: private */
        public final void zzs() {
            this.zzi = zzbs();
        }

        public static zza zzm() {
            return (zza) zzj.zzbm();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzce.zza[i - 1]) {
                case 1:
                    return new zze();
                case 2:
                    return new zza((zzce) null);
                case 3:
                    return zza((zzjg) zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", zze.class});
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

    /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
    public static final class zzg extends zzhv<zzg, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzg zzaw;
        private static volatile zzjp<zzg> zzax;
        private int zzaa;
        private String zzab = "";
        private String zzac = "";
        private boolean zzad;
        private zzid<zza> zzae = zzbs();
        private String zzaf = "";
        private int zzag;
        private int zzah;
        private int zzai;
        private String zzaj = "";
        private long zzak;
        private long zzal;
        private String zzam = "";
        private String zzan = "";
        private int zzao;
        private String zzap = "";
        private zzh zzaq;
        private zzib zzar = zzbq();
        private long zzas;
        private long zzat;
        private String zzau = "";
        private String zzav = "";
        private int zzc;
        private int zzd;
        private int zze;
        private zzid<zzc> zzf = zzbs();
        private zzid<zzk> zzg = zzbs();
        private long zzh;
        private long zzi;
        private long zzj;
        private long zzk;
        private long zzl;
        private String zzm = "";
        private String zzn = "";
        private String zzo = "";
        private String zzp = "";
        private int zzq;
        private String zzr = "";
        private String zzs = "";
        private String zzt = "";
        private long zzu;
        private long zzv;
        private String zzw = "";
        private boolean zzx;
        private String zzy = "";
        private long zzz;

        private zzg() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
        public static final class zza extends zzhv.zzb<zzg, zza> implements zzji {
            private zza() {
                super(zzg.zzaw);
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzd(1);
                return this;
            }

            public final List<zzc> zza() {
                return Collections.unmodifiableList(((zzg) this.zza).zzc());
            }

            public final int zzb() {
                return ((zzg) this.zza).zzd();
            }

            public final zzc zzb(int i) {
                return ((zzg) this.zza).zza(i);
            }

            public final zza zza(int i, zzc.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(i, (zzc) ((zzhv) zza.zzy()));
                return this;
            }

            public final zza zza(zzc.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzc) ((zzhv) zza.zzy()));
                return this;
            }

            public final zza zza(Iterable<? extends zzc> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(iterable);
                return this;
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzbx();
                return this;
            }

            public final zza zzc(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zze(i);
                return this;
            }

            public final List<zzk> zzd() {
                return Collections.unmodifiableList(((zzg) this.zza).zze());
            }

            public final int zze() {
                return ((zzg) this.zza).zzf();
            }

            public final zzk zzd(int i) {
                return ((zzg) this.zza).zzb(i);
            }

            public final zza zza(int i, zzk zzk) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(i, zzk);
                return this;
            }

            public final zza zza(zzk zzk) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(zzk);
                return this;
            }

            public final zza zza(zzk.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzk) ((zzhv) zza.zzy()));
                return this;
            }

            public final zza zzb(Iterable<? extends zzk> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzb(iterable);
                return this;
            }

            public final zza zze(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzf(i);
                return this;
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(j);
                return this;
            }

            public final long zzf() {
                return ((zzg) this.zza).zzj();
            }

            public final zza zzb(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzb(j);
                return this;
            }

            public final long zzg() {
                return ((zzg) this.zza).zzl();
            }

            public final zza zzc(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzc(j);
                return this;
            }

            public final zza zzd(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzd(j);
                return this;
            }

            public final zza zzh() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzbz();
                return this;
            }

            public final zza zze(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zze(j);
                return this;
            }

            public final zza zzi() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzca();
                return this;
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzb(str);
                return this;
            }

            public final zza zzc(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzc(str);
                return this;
            }

            public final zza zzd(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzd(str);
                return this;
            }

            public final zza zzf(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzg(i);
                return this;
            }

            public final zza zze(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zze(str);
                return this;
            }

            public final String zzj() {
                return ((zzg) this.zza).zzx();
            }

            public final zza zzf(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzf(str);
                return this;
            }

            public final zza zzg(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzg(str);
                return this;
            }

            public final zza zzf(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzf(j);
                return this;
            }

            public final zza zzg(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzg(j);
                return this;
            }

            public final zza zzh(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzh(str);
                return this;
            }

            public final zza zzk() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzcb();
                return this;
            }

            public final zza zza(boolean z) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza(z);
                return this;
            }

            public final zza zzl() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzcc();
                return this;
            }

            public final zza zzi(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzi(str);
                return this;
            }

            public final zza zzm() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzcd();
                return this;
            }

            public final zza zzh(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzh(j);
                return this;
            }

            public final zza zzg(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzh(i);
                return this;
            }

            public final zza zzj(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzj(str);
                return this;
            }

            public final zza zzn() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzce();
                return this;
            }

            public final String zzo() {
                return ((zzg) this.zza).zzam();
            }

            public final zza zzk(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzk(str);
                return this;
            }

            public final zza zzb(boolean z) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzb(z);
                return this;
            }

            public final zza zzc(Iterable<? extends zza> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzc(iterable);
                return this;
            }

            public final zza zzp() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzcf();
                return this;
            }

            public final zza zzl(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzl(str);
                return this;
            }

            public final zza zzh(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzi(i);
                return this;
            }

            public final zza zzm(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzm(str);
                return this;
            }

            public final zza zzq() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzcg();
                return this;
            }

            public final zza zzi(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzi(j);
                return this;
            }

            public final zza zzj(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzj(j);
                return this;
            }

            public final zza zzn(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzn((String) null);
                return this;
            }

            public final zza zzr() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzch();
                return this;
            }

            public final zza zzi(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzj(i);
                return this;
            }

            public final zza zzo(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzo(str);
                return this;
            }

            public final zza zza(zzh.zzb zzb) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zza((zzh) ((zzhv) zzb.zzy()));
                return this;
            }

            public final zza zzd(Iterable<? extends Integer> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzd(iterable);
                return this;
            }

            public final zza zzk(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzk(j);
                return this;
            }

            public final zza zzl(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzl(j);
                return this;
            }

            public final String zzs() {
                return ((zzg) this.zza).zzbe();
            }

            public final zza zzp(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzp(str);
                return this;
            }

            public final zza zzq(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzg) this.zza).zzq(str);
                return this;
            }

            /* synthetic */ zza(zzce zzce) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zze;
        }

        /* access modifiers changed from: private */
        public final void zzd(int i) {
            this.zzc |= 1;
            this.zze = 1;
        }

        public final List<zzc> zzc() {
            return this.zzf;
        }

        public final int zzd() {
            return this.zzf.size();
        }

        public final zzc zza(int i) {
            return (zzc) this.zzf.get(i);
        }

        private final void zzbw() {
            zzid<zzc> zzid = this.zzf;
            if (!zzid.zza()) {
                this.zzf = zzhv.zza(zzid);
            }
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zzc zzc2) {
            zzc2.getClass();
            zzbw();
            this.zzf.set(i, zzc2);
        }

        /* access modifiers changed from: private */
        public final void zza(zzc zzc2) {
            zzc2.getClass();
            zzbw();
            this.zzf.add(zzc2);
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends zzc> iterable) {
            zzbw();
            zzgd.zza(iterable, this.zzf);
        }

        /* access modifiers changed from: private */
        public final void zzbx() {
            this.zzf = zzbs();
        }

        /* access modifiers changed from: private */
        public final void zze(int i) {
            zzbw();
            this.zzf.remove(i);
        }

        public final List<zzk> zze() {
            return this.zzg;
        }

        public final int zzf() {
            return this.zzg.size();
        }

        public final zzk zzb(int i) {
            return (zzk) this.zzg.get(i);
        }

        private final void zzby() {
            zzid<zzk> zzid = this.zzg;
            if (!zzid.zza()) {
                this.zzg = zzhv.zza(zzid);
            }
        }

        /* access modifiers changed from: private */
        public final void zza(int i, zzk zzk2) {
            zzk2.getClass();
            zzby();
            this.zzg.set(i, zzk2);
        }

        /* access modifiers changed from: private */
        public final void zza(zzk zzk2) {
            zzk2.getClass();
            zzby();
            this.zzg.add(zzk2);
        }

        /* access modifiers changed from: private */
        public final void zzb(Iterable<? extends zzk> iterable) {
            zzby();
            zzgd.zza(iterable, this.zzg);
        }

        /* access modifiers changed from: private */
        public final void zzf(int i) {
            zzby();
            this.zzg.remove(i);
        }

        public final boolean zzg() {
            return (this.zzc & 2) != 0;
        }

        public final long zzh() {
            return this.zzh;
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 2;
            this.zzh = j;
        }

        public final boolean zzi() {
            return (this.zzc & 4) != 0;
        }

        public final long zzj() {
            return this.zzi;
        }

        /* access modifiers changed from: private */
        public final void zzb(long j) {
            this.zzc |= 4;
            this.zzi = j;
        }

        public final boolean zzk() {
            return (this.zzc & 8) != 0;
        }

        public final long zzl() {
            return this.zzj;
        }

        /* access modifiers changed from: private */
        public final void zzc(long j) {
            this.zzc |= 8;
            this.zzj = j;
        }

        public final boolean zzm() {
            return (this.zzc & 16) != 0;
        }

        public final long zzn() {
            return this.zzk;
        }

        /* access modifiers changed from: private */
        public final void zzd(long j) {
            this.zzc |= 16;
            this.zzk = j;
        }

        /* access modifiers changed from: private */
        public final void zzbz() {
            this.zzc &= -17;
            this.zzk = 0;
        }

        public final boolean zzo() {
            return (this.zzc & 32) != 0;
        }

        public final long zzp() {
            return this.zzl;
        }

        /* access modifiers changed from: private */
        public final void zze(long j) {
            this.zzc |= 32;
            this.zzl = j;
        }

        /* access modifiers changed from: private */
        public final void zzca() {
            this.zzc &= -33;
            this.zzl = 0;
        }

        public final String zzq() {
            return this.zzm;
        }

        /* access modifiers changed from: private */
        public final void zza(String str) {
            str.getClass();
            this.zzc |= 64;
            this.zzm = str;
        }

        public final String zzr() {
            return this.zzn;
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 128;
            this.zzn = str;
        }

        public final String zzs() {
            return this.zzo;
        }

        /* access modifiers changed from: private */
        public final void zzc(String str) {
            str.getClass();
            this.zzc |= 256;
            this.zzo = str;
        }

        public final String zzt() {
            return this.zzp;
        }

        /* access modifiers changed from: private */
        public final void zzd(String str) {
            str.getClass();
            this.zzc |= 512;
            this.zzp = str;
        }

        public final boolean zzu() {
            return (this.zzc & 1024) != 0;
        }

        public final int zzv() {
            return this.zzq;
        }

        /* access modifiers changed from: private */
        public final void zzg(int i) {
            this.zzc |= 1024;
            this.zzq = i;
        }

        public final String zzw() {
            return this.zzr;
        }

        /* access modifiers changed from: private */
        public final void zze(String str) {
            str.getClass();
            this.zzc |= 2048;
            this.zzr = str;
        }

        public final String zzx() {
            return this.zzs;
        }

        /* access modifiers changed from: private */
        public final void zzf(String str) {
            str.getClass();
            this.zzc |= 4096;
            this.zzs = str;
        }

        public final String zzy() {
            return this.zzt;
        }

        /* access modifiers changed from: private */
        public final void zzg(String str) {
            str.getClass();
            this.zzc |= 8192;
            this.zzt = str;
        }

        public final boolean zzz() {
            return (this.zzc & 16384) != 0;
        }

        public final long zzaa() {
            return this.zzu;
        }

        /* access modifiers changed from: private */
        public final void zzf(long j) {
            this.zzc |= 16384;
            this.zzu = j;
        }

        public final boolean zzab() {
            return (this.zzc & 32768) != 0;
        }

        public final long zzac() {
            return this.zzv;
        }

        /* access modifiers changed from: private */
        public final void zzg(long j) {
            this.zzc |= 32768;
            this.zzv = j;
        }

        public final String zzad() {
            return this.zzw;
        }

        /* access modifiers changed from: private */
        public final void zzh(String str) {
            str.getClass();
            this.zzc |= 65536;
            this.zzw = str;
        }

        /* access modifiers changed from: private */
        public final void zzcb() {
            this.zzc &= -65537;
            this.zzw = zzaw.zzw;
        }

        public final boolean zzae() {
            return (this.zzc & 131072) != 0;
        }

        public final boolean zzaf() {
            return this.zzx;
        }

        /* access modifiers changed from: private */
        public final void zza(boolean z) {
            this.zzc |= 131072;
            this.zzx = z;
        }

        /* access modifiers changed from: private */
        public final void zzcc() {
            this.zzc &= -131073;
            this.zzx = false;
        }

        public final String zzag() {
            return this.zzy;
        }

        /* access modifiers changed from: private */
        public final void zzi(String str) {
            str.getClass();
            this.zzc |= 262144;
            this.zzy = str;
        }

        /* access modifiers changed from: private */
        public final void zzcd() {
            this.zzc &= -262145;
            this.zzy = zzaw.zzy;
        }

        public final boolean zzah() {
            return (this.zzc & 524288) != 0;
        }

        public final long zzai() {
            return this.zzz;
        }

        /* access modifiers changed from: private */
        public final void zzh(long j) {
            this.zzc |= 524288;
            this.zzz = j;
        }

        public final boolean zzaj() {
            return (this.zzc & 1048576) != 0;
        }

        public final int zzak() {
            return this.zzaa;
        }

        /* access modifiers changed from: private */
        public final void zzh(int i) {
            this.zzc |= 1048576;
            this.zzaa = i;
        }

        public final String zzal() {
            return this.zzab;
        }

        /* access modifiers changed from: private */
        public final void zzj(String str) {
            str.getClass();
            this.zzc |= 2097152;
            this.zzab = str;
        }

        /* access modifiers changed from: private */
        public final void zzce() {
            this.zzc &= -2097153;
            this.zzab = zzaw.zzab;
        }

        public final String zzam() {
            return this.zzac;
        }

        /* access modifiers changed from: private */
        public final void zzk(String str) {
            str.getClass();
            this.zzc |= 4194304;
            this.zzac = str;
        }

        public final boolean zzan() {
            return (this.zzc & 8388608) != 0;
        }

        public final boolean zzao() {
            return this.zzad;
        }

        /* access modifiers changed from: private */
        public final void zzb(boolean z) {
            this.zzc |= 8388608;
            this.zzad = z;
        }

        public final List<zza> zzap() {
            return this.zzae;
        }

        /* access modifiers changed from: private */
        public final void zzc(Iterable<? extends zza> iterable) {
            zzid<zza> zzid = this.zzae;
            if (!zzid.zza()) {
                this.zzae = zzhv.zza(zzid);
            }
            zzgd.zza(iterable, this.zzae);
        }

        /* access modifiers changed from: private */
        public final void zzcf() {
            this.zzae = zzbs();
        }

        public final String zzaq() {
            return this.zzaf;
        }

        /* access modifiers changed from: private */
        public final void zzl(String str) {
            str.getClass();
            this.zzc |= 16777216;
            this.zzaf = str;
        }

        public final boolean zzar() {
            return (this.zzc & PdfFormField.FF_RADIOSINUNISON) != 0;
        }

        public final int zzas() {
            return this.zzag;
        }

        /* access modifiers changed from: private */
        public final void zzi(int i) {
            this.zzc |= PdfFormField.FF_RADIOSINUNISON;
            this.zzag = i;
        }

        public final String zzat() {
            return this.zzaj;
        }

        /* access modifiers changed from: private */
        public final void zzm(String str) {
            str.getClass();
            this.zzc |= C1119C.ENCODING_PCM_MU_LAW;
            this.zzaj = str;
        }

        /* access modifiers changed from: private */
        public final void zzcg() {
            this.zzc &= -268435457;
            this.zzaj = zzaw.zzaj;
        }

        public final boolean zzau() {
            return (this.zzc & 536870912) != 0;
        }

        public final long zzav() {
            return this.zzak;
        }

        /* access modifiers changed from: private */
        public final void zzi(long j) {
            this.zzc |= 536870912;
            this.zzak = j;
        }

        public final boolean zzaw() {
            return (this.zzc & 1073741824) != 0;
        }

        public final long zzax() {
            return this.zzal;
        }

        /* access modifiers changed from: private */
        public final void zzj(long j) {
            this.zzc |= 1073741824;
            this.zzal = j;
        }

        public final String zzay() {
            return this.zzam;
        }

        /* access modifiers changed from: private */
        public final void zzn(String str) {
            str.getClass();
            this.zzc |= Integer.MIN_VALUE;
            this.zzam = str;
        }

        /* access modifiers changed from: private */
        public final void zzch() {
            this.zzc &= Integer.MAX_VALUE;
            this.zzam = zzaw.zzam;
        }

        public final boolean zzaz() {
            return (this.zzd & 2) != 0;
        }

        public final int zzba() {
            return this.zzao;
        }

        /* access modifiers changed from: private */
        public final void zzj(int i) {
            this.zzd |= 2;
            this.zzao = i;
        }

        public final String zzbb() {
            return this.zzap;
        }

        /* access modifiers changed from: private */
        public final void zzo(String str) {
            str.getClass();
            this.zzd |= 4;
            this.zzap = str;
        }

        /* access modifiers changed from: private */
        public final void zza(zzh zzh2) {
            zzh2.getClass();
            this.zzaq = zzh2;
            this.zzd |= 8;
        }

        /* access modifiers changed from: private */
        public final void zzd(Iterable<? extends Integer> iterable) {
            zzib zzib = this.zzar;
            if (!zzib.zza()) {
                int size = zzib.size();
                this.zzar = zzib.zzb(size == 0 ? 10 : size << 1);
            }
            zzgd.zza(iterable, this.zzar);
        }

        public final boolean zzbc() {
            return (this.zzd & 16) != 0;
        }

        public final long zzbd() {
            return this.zzas;
        }

        /* access modifiers changed from: private */
        public final void zzk(long j) {
            this.zzd |= 16;
            this.zzas = j;
        }

        /* access modifiers changed from: private */
        public final void zzl(long j) {
            this.zzd |= 32;
            this.zzat = j;
        }

        public final String zzbe() {
            return this.zzau;
        }

        /* access modifiers changed from: private */
        public final void zzp(String str) {
            str.getClass();
            this.zzd |= 64;
            this.zzau = str;
        }

        public final boolean zzbf() {
            return (this.zzd & 128) != 0;
        }

        public final String zzbg() {
            return this.zzav;
        }

        /* access modifiers changed from: private */
        public final void zzq(String str) {
            str.getClass();
            this.zzd |= 128;
            this.zzav = str;
        }

        public static zza zzbh() {
            return (zza) zzaw.zzbm();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzce.zza[i - 1]) {
                case 1:
                    return new zzg();
                case 2:
                    return new zza((zzce) null);
                case 3:
                    return zza((zzjg) zzaw, "\u0001,\u0000\u0002\u00014,\u0000\u0004\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဂ\u0001\u0005ဂ\u0002\u0006ဂ\u0003\u0007ဂ\u0005\bဈ\u0006\tဈ\u0007\nဈ\b\u000bဈ\t\fင\n\rဈ\u000b\u000eဈ\f\u0010ဈ\r\u0011ဂ\u000e\u0012ဂ\u000f\u0013ဈ\u0010\u0014ဇ\u0011\u0015ဈ\u0012\u0016ဂ\u0013\u0017င\u0014\u0018ဈ\u0015\u0019ဈ\u0016\u001aဂ\u0004\u001cဇ\u0017\u001d\u001b\u001eဈ\u0018\u001fင\u0019 င\u001a!င\u001b\"ဈ\u001c#ဂ\u001d$ဂ\u001e%ဈ\u001f&ဈ 'င!)ဈ\",ဉ#-\u001d.ဂ$/ဂ%2ဈ&4ဈ'", new Object[]{"zzc", "zzd", "zze", "zzf", zzc.class, "zzg", zzk.class, "zzh", "zzi", "zzj", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz", "zzaa", "zzab", "zzac", "zzk", "zzad", "zzae", zza.class, "zzaf", "zzag", "zzah", "zzai", "zzaj", "zzak", "zzal", "zzam", "zzan", "zzao", "zzap", "zzaq", "zzar", "zzas", "zzat", "zzau", "zzav"});
                case 4:
                    return zzaw;
                case 5:
                    zzjp<zzg> zzjp = zzax;
                    if (zzjp == null) {
                        synchronized (zzg.class) {
                            zzjp = zzax;
                            if (zzjp == null) {
                                zzjp = new zzhv.zza<>(zzaw);
                                zzax = zzjp;
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
            zzg zzg2 = new zzg();
            zzaw = zzg2;
            zzhv.zza(zzg.class, zzg2);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
    public static final class zzh extends zzhv<zzh, zzb> implements zzji {
        /* access modifiers changed from: private */
        public static final zzh zzf;
        private static volatile zzjp<zzh> zzg;
        private int zzc;
        private int zzd = 1;
        private zzid<zzd> zze = zzbs();

        /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
        public enum zza implements zzia {
            RADS(1),
            PROVISIONING(2);
            
            private static final zzhz<zza> zzc = null;
            private final int zzd;

            public final int zza() {
                return this.zzd;
            }

            public static zza zza(int i) {
                if (i == 1) {
                    return RADS;
                }
                if (i != 2) {
                    return null;
                }
                return PROVISIONING;
            }

            public static zzic zzb() {
                return zzcf.zza;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzd + " name=" + name() + Typography.greater;
            }

            private zza(int i) {
                this.zzd = i;
            }

            static {
                zzc = new zzcg();
            }
        }

        private zzh() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
        public static final class zzb extends zzhv.zzb<zzh, zzb> implements zzji {
            private zzb() {
                super(zzh.zzf);
            }

            public final zzb zza(zzd.zza zza) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzh) this.zza).zza((zzd) ((zzhv) zza.zzy()));
                return this;
            }

            /* synthetic */ zzb(zzce zzce) {
                this();
            }
        }

        /* access modifiers changed from: private */
        public final void zza(zzd zzd2) {
            zzd2.getClass();
            zzid<zzd> zzid = this.zze;
            if (!zzid.zza()) {
                this.zze = zzhv.zza(zzid);
            }
            this.zze.add(zzd2);
        }

        public static zzb zza() {
            return (zzb) zzf.zzbm();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzce.zza[i - 1]) {
                case 1:
                    return new zzh();
                case 2:
                    return new zzb((zzce) null);
                case 3:
                    return zza((zzjg) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zzc", "zzd", zza.zzb(), "zze", zzd.class});
                case 4:
                    return zzf;
                case 5:
                    zzjp<zzh> zzjp = zzg;
                    if (zzjp == null) {
                        synchronized (zzh.class) {
                            zzjp = zzg;
                            if (zzjp == null) {
                                zzjp = new zzhv.zza<>(zzf);
                                zzg = zzjp;
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
            zzh zzh = new zzh();
            zzf = zzh;
            zzhv.zza(zzh.class, zzh);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
    public static final class zzi extends zzhv<zzi, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzi zzg;
        private static volatile zzjp<zzi> zzh;
        private zzie zzc = zzbr();
        private zzie zzd = zzbr();
        private zzid<zzb> zze = zzbs();
        private zzid<zzj> zzf = zzbs();

        private zzi() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
        public static final class zza extends zzhv.zzb<zzi, zza> implements zzji {
            private zza() {
                super(zzi.zzg);
            }

            public final zza zza(Iterable<? extends Long> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).zza(iterable);
                return this;
            }

            public final zza zza() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzl();
                return this;
            }

            public final zza zzb(Iterable<? extends Long> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzb(iterable);
                return this;
            }

            public final zza zzb() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzm();
                return this;
            }

            public final zza zzc(Iterable<? extends zzb> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzc(iterable);
                return this;
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzd(i);
                return this;
            }

            public final zza zzd(Iterable<? extends zzj> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).zzd(iterable);
                return this;
            }

            public final zza zzb(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzi) this.zza).zze(i);
                return this;
            }

            /* synthetic */ zza(zzce zzce) {
                this();
            }
        }

        public final List<Long> zza() {
            return this.zzc;
        }

        public final int zzb() {
            return this.zzc.size();
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends Long> iterable) {
            zzie zzie = this.zzc;
            if (!zzie.zza()) {
                this.zzc = zzhv.zza(zzie);
            }
            zzgd.zza(iterable, this.zzc);
        }

        /* access modifiers changed from: private */
        public final void zzl() {
            this.zzc = zzbr();
        }

        public final List<Long> zzc() {
            return this.zzd;
        }

        public final int zzd() {
            return this.zzd.size();
        }

        /* access modifiers changed from: private */
        public final void zzb(Iterable<? extends Long> iterable) {
            zzie zzie = this.zzd;
            if (!zzie.zza()) {
                this.zzd = zzhv.zza(zzie);
            }
            zzgd.zza(iterable, this.zzd);
        }

        /* access modifiers changed from: private */
        public final void zzm() {
            this.zzd = zzbr();
        }

        public final List<zzb> zze() {
            return this.zze;
        }

        public final int zzf() {
            return this.zze.size();
        }

        public final zzb zza(int i) {
            return (zzb) this.zze.get(i);
        }

        private final void zzn() {
            zzid<zzb> zzid = this.zze;
            if (!zzid.zza()) {
                this.zze = zzhv.zza(zzid);
            }
        }

        /* access modifiers changed from: private */
        public final void zzc(Iterable<? extends zzb> iterable) {
            zzn();
            zzgd.zza(iterable, this.zze);
        }

        /* access modifiers changed from: private */
        public final void zzd(int i) {
            zzn();
            this.zze.remove(i);
        }

        public final List<zzj> zzg() {
            return this.zzf;
        }

        public final int zzh() {
            return this.zzf.size();
        }

        public final zzj zzb(int i) {
            return (zzj) this.zzf.get(i);
        }

        private final void zzo() {
            zzid<zzj> zzid = this.zzf;
            if (!zzid.zza()) {
                this.zzf = zzhv.zza(zzid);
            }
        }

        /* access modifiers changed from: private */
        public final void zzd(Iterable<? extends zzj> iterable) {
            zzo();
            zzgd.zza(iterable, this.zzf);
        }

        /* access modifiers changed from: private */
        public final void zze(int i) {
            zzo();
            this.zzf.remove(i);
        }

        public static zza zzi() {
            return (zza) zzg.zzbm();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzce.zza[i - 1]) {
                case 1:
                    return new zzi();
                case 2:
                    return new zza((zzce) null);
                case 3:
                    return zza((zzjg) zzg, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzc", "zzd", "zze", zzb.class, "zzf", zzj.class});
                case 4:
                    return zzg;
                case 5:
                    zzjp<zzi> zzjp = zzh;
                    if (zzjp == null) {
                        synchronized (zzi.class) {
                            zzjp = zzh;
                            if (zzjp == null) {
                                zzjp = new zzhv.zza<>(zzg);
                                zzh = zzjp;
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

        public static zzi zzj() {
            return zzg;
        }

        static {
            zzi zzi = new zzi();
            zzg = zzi;
            zzhv.zza(zzi.class, zzi);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
    public static final class zzj extends zzhv<zzj, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzj zzf;
        private static volatile zzjp<zzj> zzg;
        private int zzc;
        private int zzd;
        private zzie zze = zzbr();

        private zzj() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
        public static final class zza extends zzhv.zzb<zzj, zza> implements zzji {
            private zza() {
                super(zzj.zzf);
            }

            public final zza zza(int i) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzj) this.zza).zzb(i);
                return this;
            }

            public final zza zza(Iterable<? extends Long> iterable) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzj) this.zza).zza(iterable);
                return this;
            }

            /* synthetic */ zza(zzce zzce) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final int zzb() {
            return this.zzd;
        }

        /* access modifiers changed from: private */
        public final void zzb(int i) {
            this.zzc |= 1;
            this.zzd = i;
        }

        public final List<Long> zzc() {
            return this.zze;
        }

        public final int zzd() {
            return this.zze.size();
        }

        public final long zza(int i) {
            return this.zze.zzb(i);
        }

        /* access modifiers changed from: private */
        public final void zza(Iterable<? extends Long> iterable) {
            zzie zzie = this.zze;
            if (!zzie.zza()) {
                this.zze = zzhv.zza(zzie);
            }
            zzgd.zza(iterable, this.zze);
        }

        public static zza zze() {
            return (zza) zzf.zzbm();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzce.zza[i - 1]) {
                case 1:
                    return new zzj();
                case 2:
                    return new zza((zzce) null);
                case 3:
                    return zza((zzjg) zzf, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzc", "zzd", "zze"});
                case 4:
                    return zzf;
                case 5:
                    zzjp<zzj> zzjp = zzg;
                    if (zzjp == null) {
                        synchronized (zzj.class) {
                            zzjp = zzg;
                            if (zzjp == null) {
                                zzjp = new zzhv.zza<>(zzf);
                                zzg = zzjp;
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
            zzj zzj = new zzj();
            zzf = zzj;
            zzhv.zza(zzj.class, zzj);
        }
    }

    /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
    public static final class zzk extends zzhv<zzk, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzk zzj;
        private static volatile zzjp<zzk> zzk;
        private int zzc;
        private long zzd;
        private String zze = "";
        private String zzf = "";
        private long zzg;
        private float zzh;
        private double zzi;

        private zzk() {
        }

        /* compiled from: com.google.android.gms:play-services-measurement@@17.5.0 */
        public static final class zza extends zzhv.zzb<zzk, zza> implements zzji {
            private zza() {
                super(zzk.zzj);
            }

            public final zza zza(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).zza(j);
                return this;
            }

            public final zza zza(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).zza(str);
                return this;
            }

            public final zza zzb(String str) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzb(str);
                return this;
            }

            public final zza zza() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzl();
                return this;
            }

            public final zza zzb(long j) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzb(j);
                return this;
            }

            public final zza zzb() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzm();
                return this;
            }

            public final zza zza(double d) {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).zza(d);
                return this;
            }

            public final zza zzc() {
                if (this.zzb) {
                    zzu();
                    this.zzb = false;
                }
                ((zzk) this.zza).zzn();
                return this;
            }

            /* synthetic */ zza(zzce zzce) {
                this();
            }
        }

        public final boolean zza() {
            return (this.zzc & 1) != 0;
        }

        public final long zzb() {
            return this.zzd;
        }

        /* access modifiers changed from: private */
        public final void zza(long j) {
            this.zzc |= 1;
            this.zzd = j;
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

        public final boolean zzd() {
            return (this.zzc & 4) != 0;
        }

        public final String zze() {
            return this.zzf;
        }

        /* access modifiers changed from: private */
        public final void zzb(String str) {
            str.getClass();
            this.zzc |= 4;
            this.zzf = str;
        }

        /* access modifiers changed from: private */
        public final void zzl() {
            this.zzc &= -5;
            this.zzf = zzj.zzf;
        }

        public final boolean zzf() {
            return (this.zzc & 8) != 0;
        }

        public final long zzg() {
            return this.zzg;
        }

        /* access modifiers changed from: private */
        public final void zzb(long j) {
            this.zzc |= 8;
            this.zzg = j;
        }

        /* access modifiers changed from: private */
        public final void zzm() {
            this.zzc &= -9;
            this.zzg = 0;
        }

        public final boolean zzh() {
            return (this.zzc & 32) != 0;
        }

        public final double zzi() {
            return this.zzi;
        }

        /* access modifiers changed from: private */
        public final void zza(double d) {
            this.zzc |= 32;
            this.zzi = d;
        }

        /* access modifiers changed from: private */
        public final void zzn() {
            this.zzc &= -33;
            this.zzi = FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
        }

        public static zza zzj() {
            return (zza) zzj.zzbm();
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzce.zza[i - 1]) {
                case 1:
                    return new zzk();
                case 2:
                    return new zza((zzce) null);
                case 3:
                    return zza((zzjg) zzj, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
                case 4:
                    return zzj;
                case 5:
                    zzjp<zzk> zzjp = zzk;
                    if (zzjp == null) {
                        synchronized (zzk.class) {
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
            zzk zzk2 = new zzk();
            zzj = zzk2;
            zzhv.zza(zzk.class, zzk2);
        }
    }
}
