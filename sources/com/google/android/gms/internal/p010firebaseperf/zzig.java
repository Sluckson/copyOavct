package com.google.android.gms.internal.p010firebaseperf;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzig */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzig {
    private static final Logger logger = Logger.getLogger(zzig.class.getName());
    private static final Class<?> zzmy = zzec.zzgi();
    private static final boolean zzno = zzjl();
    private static final Unsafe zzte = zzjk();
    private static final boolean zzvd = zzj(Long.TYPE);
    private static final boolean zzve = zzj(Integer.TYPE);
    private static final zzc zzvf;
    private static final boolean zzvg = zzjm();
    private static final long zzvh = ((long) zzh(byte[].class));
    private static final long zzvi = ((long) zzh(boolean[].class));
    private static final long zzvj = ((long) zzi(boolean[].class));
    private static final long zzvk = ((long) zzh(int[].class));
    private static final long zzvl = ((long) zzi(int[].class));
    private static final long zzvm = ((long) zzh(long[].class));
    private static final long zzvn = ((long) zzi(long[].class));
    private static final long zzvo = ((long) zzh(float[].class));
    private static final long zzvp = ((long) zzi(float[].class));
    private static final long zzvq = ((long) zzh(double[].class));
    private static final long zzvr = ((long) zzi(double[].class));
    private static final long zzvs = ((long) zzh(Object[].class));
    private static final long zzvt = ((long) zzi(Object[].class));
    private static final long zzvu;
    private static final int zzvv = ((int) (zzvh & 7));
    static final boolean zzvw = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    private zzig() {
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzig$zza */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    static final class zza extends zzc {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzx(Object obj, long j) {
            if (zzig.zzvw) {
                return zzig.zzp(obj, j);
            }
            return zzig.zzq(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzig.zzvw) {
                zzig.zza(obj, j, b);
            } else {
                zzig.zzb(obj, j, b);
            }
        }

        public final boolean zzl(Object obj, long j) {
            if (zzig.zzvw) {
                return zzig.zzr(obj, j);
            }
            return zzig.zzs(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzig.zzvw) {
                zzig.zzb(obj, j, z);
            } else {
                zzig.zzc(obj, j, z);
            }
        }

        public final float zzm(Object obj, long j) {
            return Float.intBitsToFloat(zzj(obj, j));
        }

        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        public final double zzn(Object obj, long j) {
            return Double.longBitsToDouble(zzk(obj, j));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzig$zzb */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    static final class zzb extends zzc {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzx(Object obj, long j) {
            if (zzig.zzvw) {
                return zzig.zzp(obj, j);
            }
            return zzig.zzq(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzig.zzvw) {
                zzig.zza(obj, j, b);
            } else {
                zzig.zzb(obj, j, b);
            }
        }

        public final boolean zzl(Object obj, long j) {
            if (zzig.zzvw) {
                return zzig.zzr(obj, j);
            }
            return zzig.zzs(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzig.zzvw) {
                zzig.zzb(obj, j, z);
            } else {
                zzig.zzc(obj, j, z);
            }
        }

        public final float zzm(Object obj, long j) {
            return Float.intBitsToFloat(zzj(obj, j));
        }

        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        public final double zzn(Object obj, long j) {
            return Double.longBitsToDouble(zzk(obj, j));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzig$zzd */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    static final class zzd extends zzc {
        zzd(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzx(Object obj, long j) {
            return this.zzvx.getByte(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            this.zzvx.putByte(obj, j, b);
        }

        public final boolean zzl(Object obj, long j) {
            return this.zzvx.getBoolean(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zzvx.putBoolean(obj, j, z);
        }

        public final float zzm(Object obj, long j) {
            return this.zzvx.getFloat(obj, j);
        }

        public final void zza(Object obj, long j, float f) {
            this.zzvx.putFloat(obj, j, f);
        }

        public final double zzn(Object obj, long j) {
            return this.zzvx.getDouble(obj, j);
        }

        public final void zza(Object obj, long j, double d) {
            this.zzvx.putDouble(obj, j, d);
        }
    }

    static boolean zzji() {
        return zzno;
    }

    /* renamed from: com.google.android.gms.internal.firebase-perf.zzig$zzc */
    /* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
    static abstract class zzc {
        Unsafe zzvx;

        zzc(Unsafe unsafe) {
            this.zzvx = unsafe;
        }

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zze(Object obj, long j, byte b);

        public abstract boolean zzl(Object obj, long j);

        public abstract float zzm(Object obj, long j);

        public abstract double zzn(Object obj, long j);

        public abstract byte zzx(Object obj, long j);

        public final int zzj(Object obj, long j) {
            return this.zzvx.getInt(obj, j);
        }

        public final void zza(Object obj, long j, int i) {
            this.zzvx.putInt(obj, j, i);
        }

        public final long zzk(Object obj, long j) {
            return this.zzvx.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzvx.putLong(obj, j, j2);
        }
    }

    static boolean zzjj() {
        return zzvg;
    }

    static <T> T zzg(Class<T> cls) {
        try {
            return zzte.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzh(Class<?> cls) {
        if (zzno) {
            return zzvf.zzvx.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzi(Class<?> cls) {
        if (zzno) {
            return zzvf.zzvx.arrayIndexScale(cls);
        }
        return -1;
    }

    static int zzj(Object obj, long j) {
        return zzvf.zzj(obj, j);
    }

    static void zza(Object obj, long j, int i) {
        zzvf.zza(obj, j, i);
    }

    static long zzk(Object obj, long j) {
        return zzvf.zzk(obj, j);
    }

    static void zza(Object obj, long j, long j2) {
        zzvf.zza(obj, j, j2);
    }

    static boolean zzl(Object obj, long j) {
        return zzvf.zzl(obj, j);
    }

    static void zza(Object obj, long j, boolean z) {
        zzvf.zza(obj, j, z);
    }

    static float zzm(Object obj, long j) {
        return zzvf.zzm(obj, j);
    }

    static void zza(Object obj, long j, float f) {
        zzvf.zza(obj, j, f);
    }

    static double zzn(Object obj, long j) {
        return zzvf.zzn(obj, j);
    }

    static void zza(Object obj, long j, double d) {
        zzvf.zza(obj, j, d);
    }

    static Object zzo(Object obj, long j) {
        return zzvf.zzvx.getObject(obj, j);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzvf.zzvx.putObject(obj, j, obj2);
    }

    static byte zza(byte[] bArr, long j) {
        return zzvf.zzx(bArr, zzvh + j);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzvf.zze(bArr, zzvh + j, b);
    }

    static Unsafe zzjk() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzif());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzjl() {
        Unsafe unsafe = zzte;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
            cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
            if (zzec.zzgh()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});
            cls.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});
            cls.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});
            cls.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzjm() {
        Unsafe unsafe = zzte;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            if (zzjn() == null) {
                return false;
            }
            if (zzec.zzgh()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Long.TYPE});
            cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
            cls.getMethod("getInt", new Class[]{Long.TYPE});
            cls.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Long.TYPE});
            cls.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzj(Class<?> cls) {
        if (!zzec.zzgh()) {
            return false;
        }
        try {
            Class<?> cls2 = zzmy;
            cls2.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls2.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls2.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls2.getMethod("peekByte", new Class[]{cls});
            cls2.getMethod("pokeByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            cls2.getMethod("peekByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field zzjn() {
        Field zzb2;
        if (zzec.zzgh() && (zzb2 = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
            return zzb2;
        }
        Field zzb3 = zzb(Buffer.class, "address");
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static byte zzp(Object obj, long j) {
        return (byte) (zzj(obj, -4 & j) >>> ((int) (((~j) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzj(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int zzj = zzj(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zzj & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zzj(obj, j2) & (~(255 << i))));
    }

    /* access modifiers changed from: private */
    public static boolean zzr(Object obj, long j) {
        return zzp(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00dc, code lost:
        r1 = zzvf;
     */
    static {
        /*
            java.lang.Class<com.google.android.gms.internal.firebase-perf.zzig> r0 = com.google.android.gms.internal.p010firebaseperf.zzig.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            logger = r0
            sun.misc.Unsafe r0 = zzjk()
            zzte = r0
            java.lang.Class r0 = com.google.android.gms.internal.p010firebaseperf.zzec.zzgi()
            zzmy = r0
            java.lang.Class r0 = java.lang.Long.TYPE
            boolean r0 = zzj(r0)
            zzvd = r0
            java.lang.Class r0 = java.lang.Integer.TYPE
            boolean r0 = zzj(r0)
            zzve = r0
            sun.misc.Unsafe r0 = zzte
            r1 = 0
            if (r0 != 0) goto L_0x002e
            goto L_0x0053
        L_0x002e:
            boolean r0 = com.google.android.gms.internal.p010firebaseperf.zzec.zzgh()
            if (r0 == 0) goto L_0x004c
            boolean r0 = zzvd
            if (r0 == 0) goto L_0x0040
            com.google.android.gms.internal.firebase-perf.zzig$zza r1 = new com.google.android.gms.internal.firebase-perf.zzig$zza
            sun.misc.Unsafe r0 = zzte
            r1.<init>(r0)
            goto L_0x0053
        L_0x0040:
            boolean r0 = zzve
            if (r0 == 0) goto L_0x0053
            com.google.android.gms.internal.firebase-perf.zzig$zzb r1 = new com.google.android.gms.internal.firebase-perf.zzig$zzb
            sun.misc.Unsafe r0 = zzte
            r1.<init>(r0)
            goto L_0x0053
        L_0x004c:
            com.google.android.gms.internal.firebase-perf.zzig$zzd r1 = new com.google.android.gms.internal.firebase-perf.zzig$zzd
            sun.misc.Unsafe r0 = zzte
            r1.<init>(r0)
        L_0x0053:
            zzvf = r1
            boolean r0 = zzjm()
            zzvg = r0
            boolean r0 = zzjl()
            zzno = r0
            java.lang.Class<byte[]> r0 = byte[].class
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzvh = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzvi = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            int r0 = zzi(r0)
            long r0 = (long) r0
            zzvj = r0
            java.lang.Class<int[]> r0 = int[].class
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzvk = r0
            java.lang.Class<int[]> r0 = int[].class
            int r0 = zzi(r0)
            long r0 = (long) r0
            zzvl = r0
            java.lang.Class<long[]> r0 = long[].class
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzvm = r0
            java.lang.Class<long[]> r0 = long[].class
            int r0 = zzi(r0)
            long r0 = (long) r0
            zzvn = r0
            java.lang.Class<float[]> r0 = float[].class
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzvo = r0
            java.lang.Class<float[]> r0 = float[].class
            int r0 = zzi(r0)
            long r0 = (long) r0
            zzvp = r0
            java.lang.Class<double[]> r0 = double[].class
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzvq = r0
            java.lang.Class<double[]> r0 = double[].class
            int r0 = zzi(r0)
            long r0 = (long) r0
            zzvr = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = zzh(r0)
            long r0 = (long) r0
            zzvs = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = zzi(r0)
            long r0 = (long) r0
            zzvt = r0
            java.lang.reflect.Field r0 = zzjn()
            if (r0 == 0) goto L_0x00e8
            com.google.android.gms.internal.firebase-perf.zzig$zzc r1 = zzvf
            if (r1 != 0) goto L_0x00e1
            goto L_0x00e8
        L_0x00e1:
            sun.misc.Unsafe r1 = r1.zzvx
            long r0 = r1.objectFieldOffset(r0)
            goto L_0x00ea
        L_0x00e8:
            r0 = -1
        L_0x00ea:
            zzvu = r0
            long r0 = zzvh
            r2 = 7
            long r0 = r0 & r2
            int r1 = (int) r0
            zzvv = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x00fe
            r0 = 1
            goto L_0x00ff
        L_0x00fe:
            r0 = 0
        L_0x00ff:
            zzvw = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p010firebaseperf.zzig.<clinit>():void");
    }
}
