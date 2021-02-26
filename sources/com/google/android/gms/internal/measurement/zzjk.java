package com.google.android.gms.internal.measurement;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.5.0 */
final class zzjk<T> implements zzjv<T> {
    private static final int[] zza = new int[0];
    private static final Unsafe zzb = zzkt.zzc();
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzjg zzg;
    private final boolean zzh;
    private final boolean zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int[] zzl;
    private final int zzm;
    private final int zzn;
    private final zzjo zzo;
    private final zziq zzp;
    private final zzkn<?, ?> zzq;
    private final zzhk<?> zzr;
    private final zziz zzs;

    private zzjk(int[] iArr, Object[] objArr, int i, int i2, zzjg zzjg, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzjo zzjo, zziq zziq, zzkn<?, ?> zzkn, zzhk<?> zzhk, zziz zziz) {
        this.zzc = iArr;
        this.zzd = objArr;
        this.zze = i;
        this.zzf = i2;
        this.zzi = zzjg instanceof zzhv;
        this.zzj = z;
        this.zzh = zzhk != null && zzhk.zza(zzjg);
        this.zzk = false;
        this.zzl = iArr2;
        this.zzm = i3;
        this.zzn = i4;
        this.zzo = zzjo;
        this.zzp = zziq;
        this.zzq = zzkn;
        this.zzr = zzhk;
        this.zzg = zzjg;
        this.zzs = zziz;
    }

    private static boolean zzf(int i) {
        return (i & 536870912) != 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:164:0x034d  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0396  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.measurement.zzjk<T> zza(java.lang.Class<T> r33, com.google.android.gms.internal.measurement.zzje r34, com.google.android.gms.internal.measurement.zzjo r35, com.google.android.gms.internal.measurement.zziq r36, com.google.android.gms.internal.measurement.zzkn<?, ?> r37, com.google.android.gms.internal.measurement.zzhk<?> r38, com.google.android.gms.internal.measurement.zziz r39) {
        /*
            r0 = r34
            boolean r1 = r0 instanceof com.google.android.gms.internal.measurement.zzjt
            if (r1 == 0) goto L_0x040d
            com.google.android.gms.internal.measurement.zzjt r0 = (com.google.android.gms.internal.measurement.zzjt) r0
            int r1 = r0.zza()
            int r2 = com.google.android.gms.internal.measurement.zzhv.zze.zzi
            r3 = 0
            r4 = 1
            if (r1 != r2) goto L_0x0014
            r11 = 1
            goto L_0x0015
        L_0x0014:
            r11 = 0
        L_0x0015:
            java.lang.String r1 = r0.zzd()
            int r2 = r1.length()
            char r5 = r1.charAt(r3)
            r6 = 55296(0xd800, float:7.7486E-41)
            if (r5 < r6) goto L_0x0031
            r5 = 1
        L_0x0027:
            int r7 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r6) goto L_0x0032
            r5 = r7
            goto L_0x0027
        L_0x0031:
            r7 = 1
        L_0x0032:
            int r5 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x0051
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x003e:
            int r10 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r6) goto L_0x004e
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r5 = r5 << r9
            r7 = r7 | r5
            int r9 = r9 + 13
            r5 = r10
            goto L_0x003e
        L_0x004e:
            int r5 = r5 << r9
            r7 = r7 | r5
            goto L_0x0052
        L_0x0051:
            r10 = r5
        L_0x0052:
            if (r7 != 0) goto L_0x0061
            int[] r5 = zza
            r15 = r5
            r5 = 0
            r7 = 0
            r9 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r16 = 0
            goto L_0x018a
        L_0x0061:
            int r5 = r10 + 1
            char r7 = r1.charAt(r10)
            if (r7 < r6) goto L_0x0080
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r9 = 13
        L_0x006d:
            int r10 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r6) goto L_0x007d
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r5 = r5 << r9
            r7 = r7 | r5
            int r9 = r9 + 13
            r5 = r10
            goto L_0x006d
        L_0x007d:
            int r5 = r5 << r9
            r5 = r5 | r7
            goto L_0x0082
        L_0x0080:
            r10 = r5
            r5 = r7
        L_0x0082:
            int r7 = r10 + 1
            char r9 = r1.charAt(r10)
            if (r9 < r6) goto L_0x00a1
            r9 = r9 & 8191(0x1fff, float:1.1478E-41)
            r10 = 13
        L_0x008e:
            int r12 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x009e
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r10
            r9 = r9 | r7
            int r10 = r10 + 13
            r7 = r12
            goto L_0x008e
        L_0x009e:
            int r7 = r7 << r10
            r9 = r9 | r7
            goto L_0x00a2
        L_0x00a1:
            r12 = r7
        L_0x00a2:
            int r7 = r12 + 1
            char r10 = r1.charAt(r12)
            if (r10 < r6) goto L_0x00c2
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r12 = 13
        L_0x00ae:
            int r13 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x00be
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r12
            r10 = r10 | r7
            int r12 = r12 + 13
            r7 = r13
            goto L_0x00ae
        L_0x00be:
            int r7 = r7 << r12
            r7 = r7 | r10
            r10 = r7
            goto L_0x00c3
        L_0x00c2:
            r13 = r7
        L_0x00c3:
            int r7 = r13 + 1
            char r12 = r1.charAt(r13)
            if (r12 < r6) goto L_0x00e3
            r12 = r12 & 8191(0x1fff, float:1.1478E-41)
            r13 = 13
        L_0x00cf:
            int r14 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x00df
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r13
            r12 = r12 | r7
            int r13 = r13 + 13
            r7 = r14
            goto L_0x00cf
        L_0x00df:
            int r7 = r7 << r13
            r7 = r7 | r12
            r12 = r7
            goto L_0x00e4
        L_0x00e3:
            r14 = r7
        L_0x00e4:
            int r7 = r14 + 1
            char r13 = r1.charAt(r14)
            if (r13 < r6) goto L_0x0104
            r13 = r13 & 8191(0x1fff, float:1.1478E-41)
            r14 = 13
        L_0x00f0:
            int r15 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x0100
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r14
            r13 = r13 | r7
            int r14 = r14 + 13
            r7 = r15
            goto L_0x00f0
        L_0x0100:
            int r7 = r7 << r14
            r7 = r7 | r13
            r13 = r7
            goto L_0x0105
        L_0x0104:
            r15 = r7
        L_0x0105:
            int r7 = r15 + 1
            char r14 = r1.charAt(r15)
            if (r14 < r6) goto L_0x0127
            r14 = r14 & 8191(0x1fff, float:1.1478E-41)
            r15 = 13
        L_0x0111:
            int r16 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x0122
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            int r7 = r7 << r15
            r14 = r14 | r7
            int r15 = r15 + 13
            r7 = r16
            goto L_0x0111
        L_0x0122:
            int r7 = r7 << r15
            r7 = r7 | r14
            r14 = r7
            r7 = r16
        L_0x0127:
            int r15 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 < r6) goto L_0x014a
            r7 = r7 & 8191(0x1fff, float:1.1478E-41)
            r16 = 13
        L_0x0133:
            int r17 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r6) goto L_0x0145
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r16
            r7 = r7 | r15
            int r16 = r16 + 13
            r15 = r17
            goto L_0x0133
        L_0x0145:
            int r15 = r15 << r16
            r7 = r7 | r15
            r15 = r17
        L_0x014a:
            int r16 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r6) goto L_0x0175
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            r17 = 13
            r32 = r16
            r16 = r15
            r15 = r32
        L_0x015c:
            int r18 = r15 + 1
            char r15 = r1.charAt(r15)
            if (r15 < r6) goto L_0x016f
            r15 = r15 & 8191(0x1fff, float:1.1478E-41)
            int r15 = r15 << r17
            r16 = r16 | r15
            int r17 = r17 + 13
            r15 = r18
            goto L_0x015c
        L_0x016f:
            int r15 = r15 << r17
            r15 = r16 | r15
            r16 = r18
        L_0x0175:
            int r17 = r15 + r14
            int r7 = r17 + r7
            int[] r7 = new int[r7]
            int r17 = r5 << 1
            int r9 = r17 + r9
            r32 = r16
            r16 = r5
            r5 = r14
            r14 = r15
            r15 = r7
            r7 = r9
            r9 = r10
            r10 = r32
        L_0x018a:
            sun.misc.Unsafe r3 = zzb
            java.lang.Object[] r17 = r0.zze()
            com.google.android.gms.internal.measurement.zzjg r18 = r0.zzc()
            java.lang.Class r8 = r18.getClass()
            int r6 = r13 * 3
            int[] r6 = new int[r6]
            int r13 = r13 << r4
            java.lang.Object[] r13 = new java.lang.Object[r13]
            int r19 = r14 + r5
            r21 = r14
            r22 = r19
            r5 = 0
            r20 = 0
        L_0x01a8:
            if (r10 >= r2) goto L_0x03ea
            int r23 = r10 + 1
            char r10 = r1.charAt(r10)
            r4 = 55296(0xd800, float:7.7486E-41)
            if (r10 < r4) goto L_0x01dc
            r10 = r10 & 8191(0x1fff, float:1.1478E-41)
            r25 = 13
            r32 = r23
            r23 = r10
            r10 = r32
        L_0x01bf:
            int r26 = r10 + 1
            char r10 = r1.charAt(r10)
            if (r10 < r4) goto L_0x01d5
            r4 = r10 & 8191(0x1fff, float:1.1478E-41)
            int r4 = r4 << r25
            r23 = r23 | r4
            int r25 = r25 + 13
            r10 = r26
            r4 = 55296(0xd800, float:7.7486E-41)
            goto L_0x01bf
        L_0x01d5:
            int r4 = r10 << r25
            r10 = r23 | r4
            r4 = r26
            goto L_0x01de
        L_0x01dc:
            r4 = r23
        L_0x01de:
            int r23 = r4 + 1
            char r4 = r1.charAt(r4)
            r25 = r2
            r2 = 55296(0xd800, float:7.7486E-41)
            if (r4 < r2) goto L_0x0212
            r4 = r4 & 8191(0x1fff, float:1.1478E-41)
            r26 = 13
            r32 = r23
            r23 = r4
            r4 = r32
        L_0x01f5:
            int r27 = r4 + 1
            char r4 = r1.charAt(r4)
            if (r4 < r2) goto L_0x020b
            r2 = r4 & 8191(0x1fff, float:1.1478E-41)
            int r2 = r2 << r26
            r23 = r23 | r2
            int r26 = r26 + 13
            r4 = r27
            r2 = 55296(0xd800, float:7.7486E-41)
            goto L_0x01f5
        L_0x020b:
            int r2 = r4 << r26
            r4 = r23 | r2
            r2 = r27
            goto L_0x0214
        L_0x0212:
            r2 = r23
        L_0x0214:
            r23 = r14
            r14 = r4 & 255(0xff, float:3.57E-43)
            r26 = r12
            r12 = r4 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0223
            int r12 = r5 + 1
            r15[r5] = r20
            r5 = r12
        L_0x0223:
            r12 = 51
            r29 = r5
            if (r14 < r12) goto L_0x02bc
            int r12 = r2 + 1
            char r2 = r1.charAt(r2)
            r5 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r5) goto L_0x0252
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r30 = 13
        L_0x0238:
            int r31 = r12 + 1
            char r12 = r1.charAt(r12)
            if (r12 < r5) goto L_0x024d
            r5 = r12 & 8191(0x1fff, float:1.1478E-41)
            int r5 = r5 << r30
            r2 = r2 | r5
            int r30 = r30 + 13
            r12 = r31
            r5 = 55296(0xd800, float:7.7486E-41)
            goto L_0x0238
        L_0x024d:
            int r5 = r12 << r30
            r2 = r2 | r5
            r12 = r31
        L_0x0252:
            int r5 = r14 + -51
            r30 = r12
            r12 = 9
            if (r5 == r12) goto L_0x0273
            r12 = 17
            if (r5 != r12) goto L_0x025f
            goto L_0x0273
        L_0x025f:
            r12 = 12
            if (r5 != r12) goto L_0x0271
            if (r11 != 0) goto L_0x0271
            int r5 = r20 / 3
            r12 = 1
            int r5 = r5 << r12
            int r5 = r5 + r12
            int r12 = r7 + 1
            r7 = r17[r7]
            r13[r5] = r7
            r7 = r12
        L_0x0271:
            r12 = 1
            goto L_0x0280
        L_0x0273:
            int r5 = r20 / 3
            r12 = 1
            int r5 = r5 << r12
            int r5 = r5 + r12
            int r24 = r7 + 1
            r7 = r17[r7]
            r13[r5] = r7
            r7 = r24
        L_0x0280:
            int r2 = r2 << r12
            r5 = r17[r2]
            boolean r12 = r5 instanceof java.lang.reflect.Field
            if (r12 == 0) goto L_0x028a
            java.lang.reflect.Field r5 = (java.lang.reflect.Field) r5
            goto L_0x0292
        L_0x028a:
            java.lang.String r5 = (java.lang.String) r5
            java.lang.reflect.Field r5 = zza((java.lang.Class<?>) r8, (java.lang.String) r5)
            r17[r2] = r5
        L_0x0292:
            r12 = r6
            long r5 = r3.objectFieldOffset(r5)
            int r6 = (int) r5
            int r2 = r2 + 1
            r5 = r17[r2]
            r27 = r6
            boolean r6 = r5 instanceof java.lang.reflect.Field
            if (r6 == 0) goto L_0x02a5
            java.lang.reflect.Field r5 = (java.lang.reflect.Field) r5
            goto L_0x02ad
        L_0x02a5:
            java.lang.String r5 = (java.lang.String) r5
            java.lang.reflect.Field r5 = zza((java.lang.Class<?>) r8, (java.lang.String) r5)
            r17[r2] = r5
        L_0x02ad:
            long r5 = r3.objectFieldOffset(r5)
            int r2 = (int) r5
            r5 = r2
            r18 = r8
            r6 = r27
            r28 = r30
            r2 = 0
            goto L_0x03ae
        L_0x02bc:
            r12 = r6
            int r5 = r7 + 1
            r6 = r17[r7]
            java.lang.String r6 = (java.lang.String) r6
            java.lang.reflect.Field r6 = zza((java.lang.Class<?>) r8, (java.lang.String) r6)
            r7 = 9
            if (r14 == r7) goto L_0x032e
            r7 = 17
            if (r14 != r7) goto L_0x02d0
            goto L_0x032e
        L_0x02d0:
            r7 = 27
            if (r14 == r7) goto L_0x031f
            r7 = 49
            if (r14 != r7) goto L_0x02d9
            goto L_0x031f
        L_0x02d9:
            r7 = 12
            if (r14 == r7) goto L_0x030b
            r7 = 30
            if (r14 == r7) goto L_0x030b
            r7 = 44
            if (r14 != r7) goto L_0x02e6
            goto L_0x030b
        L_0x02e6:
            r7 = 50
            if (r14 != r7) goto L_0x033c
            int r7 = r21 + 1
            r15[r21] = r20
            int r21 = r20 / 3
            r24 = 1
            int r21 = r21 << 1
            int r27 = r5 + 1
            r5 = r17[r5]
            r13[r21] = r5
            r5 = r4 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L_0x0308
            int r21 = r21 + 1
            int r5 = r27 + 1
            r27 = r17[r27]
            r13[r21] = r27
            r27 = r5
        L_0x0308:
            r21 = r7
            goto L_0x033e
        L_0x030b:
            if (r11 != 0) goto L_0x031c
            int r7 = r20 / 3
            r24 = 1
            int r7 = r7 << 1
            int r7 = r7 + 1
            int r27 = r5 + 1
            r5 = r17[r5]
            r13[r7] = r5
            goto L_0x033e
        L_0x031c:
            r24 = 1
            goto L_0x033c
        L_0x031f:
            r24 = 1
            int r7 = r20 / 3
            int r7 = r7 << 1
            int r7 = r7 + 1
            int r27 = r5 + 1
            r5 = r17[r5]
            r13[r7] = r5
            goto L_0x033e
        L_0x032e:
            r24 = 1
            int r7 = r20 / 3
            int r7 = r7 << 1
            int r7 = r7 + 1
            java.lang.Class r27 = r6.getType()
            r13[r7] = r27
        L_0x033c:
            r27 = r5
        L_0x033e:
            long r5 = r3.objectFieldOffset(r6)
            int r6 = (int) r5
            r5 = r4 & 4096(0x1000, float:5.74E-42)
            r7 = 4096(0x1000, float:5.74E-42)
            if (r5 != r7) goto L_0x0396
            r5 = 17
            if (r14 > r5) goto L_0x0396
            int r5 = r2 + 1
            char r2 = r1.charAt(r2)
            r7 = 55296(0xd800, float:7.7486E-41)
            if (r2 < r7) goto L_0x0372
            r2 = r2 & 8191(0x1fff, float:1.1478E-41)
            r18 = 13
        L_0x035c:
            int r28 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 < r7) goto L_0x036e
            r5 = r5 & 8191(0x1fff, float:1.1478E-41)
            int r5 = r5 << r18
            r2 = r2 | r5
            int r18 = r18 + 13
            r5 = r28
            goto L_0x035c
        L_0x036e:
            int r5 = r5 << r18
            r2 = r2 | r5
            goto L_0x0374
        L_0x0372:
            r28 = r5
        L_0x0374:
            r5 = 1
            int r18 = r16 << 1
            int r24 = r2 / 32
            int r18 = r18 + r24
            r5 = r17[r18]
            boolean r7 = r5 instanceof java.lang.reflect.Field
            if (r7 == 0) goto L_0x0384
            java.lang.reflect.Field r5 = (java.lang.reflect.Field) r5
            goto L_0x038c
        L_0x0384:
            java.lang.String r5 = (java.lang.String) r5
            java.lang.reflect.Field r5 = zza((java.lang.Class<?>) r8, (java.lang.String) r5)
            r17[r18] = r5
        L_0x038c:
            r18 = r8
            long r7 = r3.objectFieldOffset(r5)
            int r5 = (int) r7
            int r2 = r2 % 32
            goto L_0x039e
        L_0x0396:
            r18 = r8
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r28 = r2
            r2 = 0
        L_0x039e:
            r7 = 18
            if (r14 < r7) goto L_0x03ac
            r7 = 49
            if (r14 > r7) goto L_0x03ac
            int r7 = r22 + 1
            r15[r22] = r6
            r22 = r7
        L_0x03ac:
            r7 = r27
        L_0x03ae:
            int r8 = r20 + 1
            r12[r20] = r10
            int r10 = r8 + 1
            r20 = r1
            r1 = r4 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x03bd
            r1 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x03be
        L_0x03bd:
            r1 = 0
        L_0x03be:
            r4 = r4 & 256(0x100, float:3.59E-43)
            if (r4 == 0) goto L_0x03c5
            r4 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x03c6
        L_0x03c5:
            r4 = 0
        L_0x03c6:
            r1 = r1 | r4
            int r4 = r14 << 20
            r1 = r1 | r4
            r1 = r1 | r6
            r12[r8] = r1
            int r1 = r10 + 1
            int r2 = r2 << 20
            r2 = r2 | r5
            r12[r10] = r2
            r6 = r12
            r8 = r18
            r14 = r23
            r2 = r25
            r12 = r26
            r10 = r28
            r5 = r29
            r4 = 1
            r32 = r20
            r20 = r1
            r1 = r32
            goto L_0x01a8
        L_0x03ea:
            r26 = r12
            r23 = r14
            r12 = r6
            com.google.android.gms.internal.measurement.zzjk r1 = new com.google.android.gms.internal.measurement.zzjk
            com.google.android.gms.internal.measurement.zzjg r10 = r0.zzc()
            r0 = 0
            r5 = r1
            r7 = r13
            r8 = r9
            r9 = r26
            r12 = r0
            r13 = r15
            r15 = r19
            r16 = r35
            r17 = r36
            r18 = r37
            r19 = r38
            r20 = r39
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return r1
        L_0x040d:
            com.google.android.gms.internal.measurement.zzkk r0 = (com.google.android.gms.internal.measurement.zzkk) r0
            int r0 = r0.zza()
            int r1 = com.google.android.gms.internal.measurement.zzhv.zze.zzi
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zza(java.lang.Class, com.google.android.gms.internal.measurement.zzje, com.google.android.gms.internal.measurement.zzjo, com.google.android.gms.internal.measurement.zziq, com.google.android.gms.internal.measurement.zzkn, com.google.android.gms.internal.measurement.zzhk, com.google.android.gms.internal.measurement.zziz):com.google.android.gms.internal.measurement.zzjk");
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    public final T zza() {
        return this.zzo.zza(this.zzg);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.measurement.zzjx.zza(com.google.android.gms.internal.measurement.zzkt.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkt.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.measurement.zzkt.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkt.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.measurement.zzkt.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkt.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.measurement.zzjx.zza(com.google.android.gms.internal.measurement.zzkt.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkt.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.measurement.zzjx.zza(com.google.android.gms.internal.measurement.zzkt.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkt.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.measurement.zzjx.zza(com.google.android.gms.internal.measurement.zzkt.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkt.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.measurement.zzkt.zzc(r10, r6) == com.google.android.gms.internal.measurement.zzkt.zzc(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.measurement.zzkt.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkt.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r10, r6) == com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.measurement.zzkt.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkt.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.measurement.zzkt.zzb(r10, r6) == com.google.android.gms.internal.measurement.zzkt.zzb(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzkt.zzd(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.measurement.zzkt.zzd(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzkt.zze(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.measurement.zzkt.zze(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01c1, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.measurement.zzjx.zza(com.google.android.gms.internal.measurement.zzkt.zzf(r10, r6), com.google.android.gms.internal.measurement.zzkt.zzf(r11, r6)) != false) goto L_0x01c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zzc
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01c9
            int r4 = r9.zzd((int) r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            switch(r4) {
                case 0: goto L_0x01a7;
                case 1: goto L_0x018e;
                case 2: goto L_0x017b;
                case 3: goto L_0x0168;
                case 4: goto L_0x0157;
                case 5: goto L_0x0144;
                case 6: goto L_0x0132;
                case 7: goto L_0x0120;
                case 8: goto L_0x010a;
                case 9: goto L_0x00f4;
                case 10: goto L_0x00de;
                case 11: goto L_0x00cc;
                case 12: goto L_0x00ba;
                case 13: goto L_0x00a8;
                case 14: goto L_0x0094;
                case 15: goto L_0x0082;
                case 16: goto L_0x006e;
                case 17: goto L_0x0058;
                case 18: goto L_0x004a;
                case 19: goto L_0x004a;
                case 20: goto L_0x004a;
                case 21: goto L_0x004a;
                case 22: goto L_0x004a;
                case 23: goto L_0x004a;
                case 24: goto L_0x004a;
                case 25: goto L_0x004a;
                case 26: goto L_0x004a;
                case 27: goto L_0x004a;
                case 28: goto L_0x004a;
                case 29: goto L_0x004a;
                case 30: goto L_0x004a;
                case 31: goto L_0x004a;
                case 32: goto L_0x004a;
                case 33: goto L_0x004a;
                case 34: goto L_0x004a;
                case 35: goto L_0x004a;
                case 36: goto L_0x004a;
                case 37: goto L_0x004a;
                case 38: goto L_0x004a;
                case 39: goto L_0x004a;
                case 40: goto L_0x004a;
                case 41: goto L_0x004a;
                case 42: goto L_0x004a;
                case 43: goto L_0x004a;
                case 44: goto L_0x004a;
                case 45: goto L_0x004a;
                case 46: goto L_0x004a;
                case 47: goto L_0x004a;
                case 48: goto L_0x004a;
                case 49: goto L_0x004a;
                case 50: goto L_0x003c;
                case 51: goto L_0x001c;
                case 52: goto L_0x001c;
                case 53: goto L_0x001c;
                case 54: goto L_0x001c;
                case 55: goto L_0x001c;
                case 56: goto L_0x001c;
                case 57: goto L_0x001c;
                case 58: goto L_0x001c;
                case 59: goto L_0x001c;
                case 60: goto L_0x001c;
                case 61: goto L_0x001c;
                case 62: goto L_0x001c;
                case 63: goto L_0x001c;
                case 64: goto L_0x001c;
                case 65: goto L_0x001c;
                case 66: goto L_0x001c;
                case 67: goto L_0x001c;
                case 68: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x01c2
        L_0x001c:
            int r4 = r9.zze((int) r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r10, (long) r4)
            int r4 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r11, (long) r4)
            if (r8 != r4) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzkt.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkt.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzjx.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkt.zzf(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzkt.zzf(r11, r6)
            boolean r3 = com.google.android.gms.internal.measurement.zzjx.zza((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c2
        L_0x004a:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkt.zzf(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzkt.zzf(r11, r6)
            boolean r3 = com.google.android.gms.internal.measurement.zzjx.zza((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01c2
        L_0x0058:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzkt.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkt.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzjx.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x006e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.measurement.zzkt.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzkt.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0082:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0094:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.measurement.zzkt.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzkt.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00a8:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00ba:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00cc:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00de:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzkt.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkt.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzjx.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00f4:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzkt.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkt.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzjx.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x010a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzkt.zzf(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkt.zzf(r11, r6)
            boolean r4 = com.google.android.gms.internal.measurement.zzjx.zza((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0120:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            boolean r4 = com.google.android.gms.internal.measurement.zzkt.zzc(r10, r6)
            boolean r5 = com.google.android.gms.internal.measurement.zzkt.zzc(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0132:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0144:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.measurement.zzkt.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzkt.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0157:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r10, (long) r6)
            int r5 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r11, (long) r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0168:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.measurement.zzkt.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzkt.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x017b:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.measurement.zzkt.zzb(r10, r6)
            long r6 = com.google.android.gms.internal.measurement.zzkt.zzb(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x018e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            float r4 = com.google.android.gms.internal.measurement.zzkt.zzd(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.measurement.zzkt.zzd(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x01a7:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            double r4 = com.google.android.gms.internal.measurement.zzkt.zze(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.measurement.zzkt.zze(r11, r6)
            long r6 = java.lang.Double.doubleToLongBits(r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
        L_0x01c1:
            r3 = 0
        L_0x01c2:
            if (r3 != 0) goto L_0x01c5
            return r1
        L_0x01c5:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x01c9:
            com.google.android.gms.internal.measurement.zzkn<?, ?> r0 = r9.zzq
            java.lang.Object r0 = r0.zzb(r10)
            com.google.android.gms.internal.measurement.zzkn<?, ?> r2 = r9.zzq
            java.lang.Object r2 = r2.zzb(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            return r1
        L_0x01dc:
            boolean r0 = r9.zzh
            if (r0 == 0) goto L_0x01f1
            com.google.android.gms.internal.measurement.zzhk<?> r0 = r9.zzr
            com.google.android.gms.internal.measurement.zzho r10 = r0.zza((java.lang.Object) r10)
            com.google.android.gms.internal.measurement.zzhk<?> r0 = r9.zzr
            com.google.android.gms.internal.measurement.zzho r11 = r0.zza((java.lang.Object) r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zza(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x01c3, code lost:
        r2 = (r2 * 53) + r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0227, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x0228, code lost:
        r1 = r1 + 3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzc
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x022c
            int r3 = r8.zzd((int) r1)
            int[] r4 = r8.zzc
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = r3 & r7
            int r3 = r3 >>> 20
            r7 = 37
            switch(r3) {
                case 0: goto L_0x0219;
                case 1: goto L_0x020e;
                case 2: goto L_0x0203;
                case 3: goto L_0x01f8;
                case 4: goto L_0x01f1;
                case 5: goto L_0x01e6;
                case 6: goto L_0x01df;
                case 7: goto L_0x01d4;
                case 8: goto L_0x01c7;
                case 9: goto L_0x01b9;
                case 10: goto L_0x01ad;
                case 11: goto L_0x01a5;
                case 12: goto L_0x019d;
                case 13: goto L_0x0195;
                case 14: goto L_0x0189;
                case 15: goto L_0x0181;
                case 16: goto L_0x0175;
                case 17: goto L_0x016a;
                case 18: goto L_0x015e;
                case 19: goto L_0x015e;
                case 20: goto L_0x015e;
                case 21: goto L_0x015e;
                case 22: goto L_0x015e;
                case 23: goto L_0x015e;
                case 24: goto L_0x015e;
                case 25: goto L_0x015e;
                case 26: goto L_0x015e;
                case 27: goto L_0x015e;
                case 28: goto L_0x015e;
                case 29: goto L_0x015e;
                case 30: goto L_0x015e;
                case 31: goto L_0x015e;
                case 32: goto L_0x015e;
                case 33: goto L_0x015e;
                case 34: goto L_0x015e;
                case 35: goto L_0x015e;
                case 36: goto L_0x015e;
                case 37: goto L_0x015e;
                case 38: goto L_0x015e;
                case 39: goto L_0x015e;
                case 40: goto L_0x015e;
                case 41: goto L_0x015e;
                case 42: goto L_0x015e;
                case 43: goto L_0x015e;
                case 44: goto L_0x015e;
                case 45: goto L_0x015e;
                case 46: goto L_0x015e;
                case 47: goto L_0x015e;
                case 48: goto L_0x015e;
                case 49: goto L_0x015e;
                case 50: goto L_0x0152;
                case 51: goto L_0x013c;
                case 52: goto L_0x012a;
                case 53: goto L_0x0118;
                case 54: goto L_0x0106;
                case 55: goto L_0x00f8;
                case 56: goto L_0x00e6;
                case 57: goto L_0x00d8;
                case 58: goto L_0x00c6;
                case 59: goto L_0x00b2;
                case 60: goto L_0x00a0;
                case 61: goto L_0x008e;
                case 62: goto L_0x0080;
                case 63: goto L_0x0072;
                case 64: goto L_0x0064;
                case 65: goto L_0x0052;
                case 66: goto L_0x0044;
                case 67: goto L_0x0032;
                case 68: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x0228
        L_0x0020:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkt.zzf(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x0032:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zze(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzhx.zza((long) r3)
            goto L_0x0227
        L_0x0044:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzd(r9, r5)
            goto L_0x0227
        L_0x0052:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zze(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzhx.zza((long) r3)
            goto L_0x0227
        L_0x0064:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzd(r9, r5)
            goto L_0x0227
        L_0x0072:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzd(r9, r5)
            goto L_0x0227
        L_0x0080:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzd(r9, r5)
            goto L_0x0227
        L_0x008e:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkt.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00a0:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkt.zzf(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00b2:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkt.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00c6:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            boolean r3 = zzf(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzhx.zza((boolean) r3)
            goto L_0x0227
        L_0x00d8:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzd(r9, r5)
            goto L_0x0227
        L_0x00e6:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zze(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzhx.zza((long) r3)
            goto L_0x0227
        L_0x00f8:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzd(r9, r5)
            goto L_0x0227
        L_0x0106:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zze(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzhx.zza((long) r3)
            goto L_0x0227
        L_0x0118:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zze(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzhx.zza((long) r3)
            goto L_0x0227
        L_0x012a:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            float r3 = zzc(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x013c:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            double r3 = zzb(r9, (long) r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.measurement.zzhx.zza((long) r3)
            goto L_0x0227
        L_0x0152:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkt.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x015e:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkt.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x016a:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkt.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
            goto L_0x01c3
        L_0x0175:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzkt.zzb(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzhx.zza((long) r3)
            goto L_0x0227
        L_0x0181:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x0189:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzkt.zzb(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzhx.zza((long) r3)
            goto L_0x0227
        L_0x0195:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x019d:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01a5:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01ad:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkt.zzf(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01b9:
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkt.zzf(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
        L_0x01c3:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0228
        L_0x01c7:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzkt.zzf(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01d4:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.measurement.zzkt.zzc(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzhx.zza((boolean) r3)
            goto L_0x0227
        L_0x01df:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01e6:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzkt.zzb(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzhx.zza((long) r3)
            goto L_0x0227
        L_0x01f1:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r9, (long) r5)
            goto L_0x0227
        L_0x01f8:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzkt.zzb(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzhx.zza((long) r3)
            goto L_0x0227
        L_0x0203:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.measurement.zzkt.zzb(r9, r5)
            int r3 = com.google.android.gms.internal.measurement.zzhx.zza((long) r3)
            goto L_0x0227
        L_0x020e:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.measurement.zzkt.zzd(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x0219:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.measurement.zzkt.zze(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.measurement.zzhx.zza((long) r3)
        L_0x0227:
            int r2 = r2 + r3
        L_0x0228:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022c:
            int r2 = r2 * 53
            com.google.android.gms.internal.measurement.zzkn<?, ?> r0 = r8.zzq
            java.lang.Object r0 = r0.zzb(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzh
            if (r0 == 0) goto L_0x024a
            int r2 = r2 * 53
            com.google.android.gms.internal.measurement.zzhk<?> r0 = r8.zzr
            com.google.android.gms.internal.measurement.zzho r9 = r0.zza((java.lang.Object) r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x024a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zza(java.lang.Object):int");
    }

    public final void zzb(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzc.length; i += 3) {
                int zzd2 = zzd(i);
                long j = (long) (1048575 & zzd2);
                int i2 = this.zzc[i];
                switch ((zzd2 & 267386880) >>> 20) {
                    case 0:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkt.zza((Object) t, j, zzkt.zze(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkt.zza((Object) t, j, zzkt.zzd(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkt.zza((Object) t, j, zzkt.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 3:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkt.zza((Object) t, j, zzkt.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 4:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkt.zza((Object) t, j, zzkt.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 5:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkt.zza((Object) t, j, zzkt.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 6:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkt.zza((Object) t, j, zzkt.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 7:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkt.zza((Object) t, j, zzkt.zzc(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 8:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkt.zza((Object) t, j, zzkt.zzf(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 9:
                        zza(t, t2, i);
                        break;
                    case 10:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkt.zza((Object) t, j, zzkt.zzf(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 11:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkt.zza((Object) t, j, zzkt.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 12:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkt.zza((Object) t, j, zzkt.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 13:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkt.zza((Object) t, j, zzkt.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 14:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkt.zza((Object) t, j, zzkt.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 15:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkt.zza((Object) t, j, zzkt.zza((Object) t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 16:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzkt.zza((Object) t, j, zzkt.zzb(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 17:
                        zza(t, t2, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.zzp.zza(t, t2, j);
                        break;
                    case 50:
                        zzjx.zza(this.zzs, t, t2, j);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zzkt.zza((Object) t, j, zzkt.zzf(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 60:
                        zzb(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zzkt.zza((Object) t, j, zzkt.zzf(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 68:
                        zzb(t, t2, i);
                        break;
                }
            }
            zzjx.zza(this.zzq, t, t2);
            if (this.zzh) {
                zzjx.zza(this.zzr, t, t2);
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    private final void zza(T t, T t2, int i) {
        long zzd2 = (long) (zzd(i) & 1048575);
        if (zza(t2, i)) {
            Object zzf2 = zzkt.zzf(t, zzd2);
            Object zzf3 = zzkt.zzf(t2, zzd2);
            if (zzf2 != null && zzf3 != null) {
                zzkt.zza((Object) t, zzd2, zzhx.zza(zzf2, zzf3));
                zzb(t, i);
            } else if (zzf3 != null) {
                zzkt.zza((Object) t, zzd2, zzf3);
                zzb(t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzd2 = zzd(i);
        int i2 = this.zzc[i];
        long j = (long) (zzd2 & 1048575);
        if (zza(t2, i2, i)) {
            Object zzf2 = zzkt.zzf(t, j);
            Object zzf3 = zzkt.zzf(t2, j);
            if (zzf2 != null && zzf3 != null) {
                zzkt.zza((Object) t, j, zzhx.zza(zzf2, zzf3));
                zzb(t, i2, i);
            } else if (zzf3 != null) {
                zzkt.zza((Object) t, j, zzf3);
                zzb(t, i2, i);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:305:0x072f, code lost:
        r8 = (r8 + r9) + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:322:0x07fb, code lost:
        r5 = r5 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:328:0x0810, code lost:
        r13 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:344:0x0855, code lost:
        r5 = r5 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:383:0x0909, code lost:
        r5 = r5 + r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:391:0x092c, code lost:
        r3 = r3 + 3;
        r9 = r13;
        r7 = 1048575;
        r8 = 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(T r19) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            boolean r2 = r0.zzj
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 1
            r9 = 0
            r11 = 0
            if (r2 == 0) goto L_0x047d
            sun.misc.Unsafe r2 = zzb
            r12 = 0
            r13 = 0
        L_0x0016:
            int[] r14 = r0.zzc
            int r14 = r14.length
            if (r12 >= r14) goto L_0x0475
            int r14 = r0.zzd((int) r12)
            r15 = r14 & r3
            int r15 = r15 >>> 20
            int[] r3 = r0.zzc
            r3 = r3[r12]
            r14 = r14 & r7
            long r5 = (long) r14
            com.google.android.gms.internal.measurement.zzhp r14 = com.google.android.gms.internal.measurement.zzhp.DOUBLE_LIST_PACKED
            int r14 = r14.zza()
            if (r15 < r14) goto L_0x003f
            com.google.android.gms.internal.measurement.zzhp r14 = com.google.android.gms.internal.measurement.zzhp.SINT64_LIST_PACKED
            int r14 = r14.zza()
            if (r15 > r14) goto L_0x003f
            int[] r14 = r0.zzc
            int r17 = r12 + 2
            r14 = r14[r17]
        L_0x003f:
            switch(r15) {
                case 0: goto L_0x0461;
                case 1: goto L_0x0455;
                case 2: goto L_0x0445;
                case 3: goto L_0x0435;
                case 4: goto L_0x0425;
                case 5: goto L_0x0419;
                case 6: goto L_0x040d;
                case 7: goto L_0x0401;
                case 8: goto L_0x03e3;
                case 9: goto L_0x03cf;
                case 10: goto L_0x03be;
                case 11: goto L_0x03af;
                case 12: goto L_0x03a0;
                case 13: goto L_0x0395;
                case 14: goto L_0x038a;
                case 15: goto L_0x037b;
                case 16: goto L_0x036c;
                case 17: goto L_0x0357;
                case 18: goto L_0x034c;
                case 19: goto L_0x0343;
                case 20: goto L_0x033a;
                case 21: goto L_0x0331;
                case 22: goto L_0x0328;
                case 23: goto L_0x031f;
                case 24: goto L_0x0316;
                case 25: goto L_0x030d;
                case 26: goto L_0x0304;
                case 27: goto L_0x02f7;
                case 28: goto L_0x02ee;
                case 29: goto L_0x02e5;
                case 30: goto L_0x02db;
                case 31: goto L_0x02d1;
                case 32: goto L_0x02c7;
                case 33: goto L_0x02bd;
                case 34: goto L_0x02b3;
                case 35: goto L_0x029b;
                case 36: goto L_0x0286;
                case 37: goto L_0x0271;
                case 38: goto L_0x025c;
                case 39: goto L_0x0247;
                case 40: goto L_0x0232;
                case 41: goto L_0x021c;
                case 42: goto L_0x0206;
                case 43: goto L_0x01f0;
                case 44: goto L_0x01da;
                case 45: goto L_0x01c4;
                case 46: goto L_0x01ae;
                case 47: goto L_0x0198;
                case 48: goto L_0x0182;
                case 49: goto L_0x0174;
                case 50: goto L_0x0164;
                case 51: goto L_0x0156;
                case 52: goto L_0x014a;
                case 53: goto L_0x013a;
                case 54: goto L_0x012a;
                case 55: goto L_0x011a;
                case 56: goto L_0x010e;
                case 57: goto L_0x0102;
                case 58: goto L_0x00f6;
                case 59: goto L_0x00d8;
                case 60: goto L_0x00c4;
                case 61: goto L_0x00b2;
                case 62: goto L_0x00a2;
                case 63: goto L_0x0092;
                case 64: goto L_0x0086;
                case 65: goto L_0x007a;
                case 66: goto L_0x006a;
                case 67: goto L_0x005a;
                case 68: goto L_0x0044;
                default: goto L_0x0042;
            }
        L_0x0042:
            goto L_0x046f
        L_0x0044:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x046f
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkt.zzf(r1, r5)
            com.google.android.gms.internal.measurement.zzjg r5 = (com.google.android.gms.internal.measurement.zzjg) r5
            com.google.android.gms.internal.measurement.zzjv r6 = r0.zza((int) r12)
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzc(r3, r5, r6)
            goto L_0x0354
        L_0x005a:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x046f
            long r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzf((int) r3, (long) r5)
            goto L_0x0354
        L_0x006a:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x046f
            int r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzh((int) r3, (int) r5)
            goto L_0x0354
        L_0x007a:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzh((int) r3, (long) r9)
            goto L_0x0354
        L_0x0086:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzj(r3, r11)
            goto L_0x0354
        L_0x0092:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x046f
            int r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzk(r3, r5)
            goto L_0x0354
        L_0x00a2:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x046f
            int r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r3, (int) r5)
            goto L_0x0354
        L_0x00b2:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x046f
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkt.zzf(r1, r5)
            com.google.android.gms.internal.measurement.zzgm r5 = (com.google.android.gms.internal.measurement.zzgm) r5
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzc((int) r3, (com.google.android.gms.internal.measurement.zzgm) r5)
            goto L_0x0354
        L_0x00c4:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x046f
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkt.zzf(r1, r5)
            com.google.android.gms.internal.measurement.zzjv r6 = r0.zza((int) r12)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zza((int) r3, (java.lang.Object) r5, (com.google.android.gms.internal.measurement.zzjv) r6)
            goto L_0x0354
        L_0x00d8:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x046f
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkt.zzf(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.measurement.zzgm
            if (r6 == 0) goto L_0x00ee
            com.google.android.gms.internal.measurement.zzgm r5 = (com.google.android.gms.internal.measurement.zzgm) r5
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzc((int) r3, (com.google.android.gms.internal.measurement.zzgm) r5)
            goto L_0x0354
        L_0x00ee:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzb((int) r3, (java.lang.String) r5)
            goto L_0x0354
        L_0x00f6:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzb((int) r3, (boolean) r8)
            goto L_0x0354
        L_0x0102:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzi(r3, r11)
            goto L_0x0354
        L_0x010e:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r3, (long) r9)
            goto L_0x0354
        L_0x011a:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x046f
            int r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzf((int) r3, (int) r5)
            goto L_0x0354
        L_0x012a:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x046f
            long r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzhf.zze((int) r3, (long) r5)
            goto L_0x0354
        L_0x013a:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x046f
            long r5 = zze(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzd((int) r3, (long) r5)
            goto L_0x0354
        L_0x014a:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzb((int) r3, (float) r4)
            goto L_0x0354
        L_0x0156:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x046f
            r5 = 0
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzb((int) r3, (double) r5)
            goto L_0x0354
        L_0x0164:
            com.google.android.gms.internal.measurement.zziz r14 = r0.zzs
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkt.zzf(r1, r5)
            java.lang.Object r6 = r0.zzb((int) r12)
            int r3 = r14.zza(r3, r5, r6)
            goto L_0x0354
        L_0x0174:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            com.google.android.gms.internal.measurement.zzjv r6 = r0.zza((int) r12)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zzb((int) r3, (java.util.List<com.google.android.gms.internal.measurement.zzjg>) r5, (com.google.android.gms.internal.measurement.zzjv) r6)
            goto L_0x0354
        L_0x0182:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzjx.zzc(r5)
            if (r5 <= 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.measurement.zzhf.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r5)
            goto L_0x02af
        L_0x0198:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzjx.zzg(r5)
            if (r5 <= 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.measurement.zzhf.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r5)
            goto L_0x02af
        L_0x01ae:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzjx.zzi(r5)
            if (r5 <= 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.measurement.zzhf.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r5)
            goto L_0x02af
        L_0x01c4:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzjx.zzh(r5)
            if (r5 <= 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.measurement.zzhf.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r5)
            goto L_0x02af
        L_0x01da:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzjx.zzd(r5)
            if (r5 <= 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.measurement.zzhf.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r5)
            goto L_0x02af
        L_0x01f0:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzjx.zzf(r5)
            if (r5 <= 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.measurement.zzhf.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r5)
            goto L_0x02af
        L_0x0206:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzjx.zzj(r5)
            if (r5 <= 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.measurement.zzhf.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r5)
            goto L_0x02af
        L_0x021c:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzjx.zzh(r5)
            if (r5 <= 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.measurement.zzhf.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r5)
            goto L_0x02af
        L_0x0232:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzjx.zzi(r5)
            if (r5 <= 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.measurement.zzhf.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r5)
            goto L_0x02af
        L_0x0247:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzjx.zze(r5)
            if (r5 <= 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.measurement.zzhf.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r5)
            goto L_0x02af
        L_0x025c:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzjx.zzb(r5)
            if (r5 <= 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.measurement.zzhf.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r5)
            goto L_0x02af
        L_0x0271:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzjx.zza((java.util.List<java.lang.Long>) r5)
            if (r5 <= 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.measurement.zzhf.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r5)
            goto L_0x02af
        L_0x0286:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzjx.zzh(r5)
            if (r5 <= 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.measurement.zzhf.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r5)
            goto L_0x02af
        L_0x029b:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.measurement.zzjx.zzi(r5)
            if (r5 <= 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.measurement.zzhf.zze((int) r3)
            int r6 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r5)
        L_0x02af:
            int r3 = r3 + r6
            int r3 = r3 + r5
            goto L_0x0354
        L_0x02b3:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zzc(r3, r5, r11)
            goto L_0x0354
        L_0x02bd:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zzg(r3, r5, r11)
            goto L_0x0354
        L_0x02c7:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zzi(r3, r5, r11)
            goto L_0x0354
        L_0x02d1:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zzh(r3, r5, r11)
            goto L_0x0354
        L_0x02db:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zzd(r3, r5, r11)
            goto L_0x0354
        L_0x02e5:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zzf(r3, r5, r11)
            goto L_0x0354
        L_0x02ee:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zzb(r3, r5)
            goto L_0x0354
        L_0x02f7:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            com.google.android.gms.internal.measurement.zzjv r6 = r0.zza((int) r12)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zza((int) r3, (java.util.List<?>) r5, (com.google.android.gms.internal.measurement.zzjv) r6)
            goto L_0x0354
        L_0x0304:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zza((int) r3, (java.util.List<?>) r5)
            goto L_0x0354
        L_0x030d:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zzj(r3, r5, r11)
            goto L_0x0354
        L_0x0316:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zzh(r3, r5, r11)
            goto L_0x0354
        L_0x031f:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zzi(r3, r5, r11)
            goto L_0x0354
        L_0x0328:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zze(r3, r5, r11)
            goto L_0x0354
        L_0x0331:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zzb((int) r3, (java.util.List<java.lang.Long>) r5, (boolean) r11)
            goto L_0x0354
        L_0x033a:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zza((int) r3, (java.util.List<java.lang.Long>) r5, (boolean) r11)
            goto L_0x0354
        L_0x0343:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zzh(r3, r5, r11)
            goto L_0x0354
        L_0x034c:
            java.util.List r5 = zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zzi(r3, r5, r11)
        L_0x0354:
            int r13 = r13 + r3
            goto L_0x046f
        L_0x0357:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x046f
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkt.zzf(r1, r5)
            com.google.android.gms.internal.measurement.zzjg r5 = (com.google.android.gms.internal.measurement.zzjg) r5
            com.google.android.gms.internal.measurement.zzjv r6 = r0.zza((int) r12)
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzc(r3, r5, r6)
            goto L_0x0354
        L_0x036c:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x046f
            long r5 = com.google.android.gms.internal.measurement.zzkt.zzb(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzf((int) r3, (long) r5)
            goto L_0x0354
        L_0x037b:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x046f
            int r5 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzh((int) r3, (int) r5)
            goto L_0x0354
        L_0x038a:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzh((int) r3, (long) r9)
            goto L_0x0354
        L_0x0395:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzj(r3, r11)
            goto L_0x0354
        L_0x03a0:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x046f
            int r5 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzk(r3, r5)
            goto L_0x0354
        L_0x03af:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x046f
            int r5 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r3, (int) r5)
            goto L_0x0354
        L_0x03be:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x046f
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkt.zzf(r1, r5)
            com.google.android.gms.internal.measurement.zzgm r5 = (com.google.android.gms.internal.measurement.zzgm) r5
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzc((int) r3, (com.google.android.gms.internal.measurement.zzgm) r5)
            goto L_0x0354
        L_0x03cf:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x046f
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkt.zzf(r1, r5)
            com.google.android.gms.internal.measurement.zzjv r6 = r0.zza((int) r12)
            int r3 = com.google.android.gms.internal.measurement.zzjx.zza((int) r3, (java.lang.Object) r5, (com.google.android.gms.internal.measurement.zzjv) r6)
            goto L_0x0354
        L_0x03e3:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x046f
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkt.zzf(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.measurement.zzgm
            if (r6 == 0) goto L_0x03f9
            com.google.android.gms.internal.measurement.zzgm r5 = (com.google.android.gms.internal.measurement.zzgm) r5
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzc((int) r3, (com.google.android.gms.internal.measurement.zzgm) r5)
            goto L_0x0354
        L_0x03f9:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzb((int) r3, (java.lang.String) r5)
            goto L_0x0354
        L_0x0401:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzb((int) r3, (boolean) r8)
            goto L_0x0354
        L_0x040d:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzi(r3, r11)
            goto L_0x0354
        L_0x0419:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r3, (long) r9)
            goto L_0x0354
        L_0x0425:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x046f
            int r5 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzf((int) r3, (int) r5)
            goto L_0x0354
        L_0x0435:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x046f
            long r5 = com.google.android.gms.internal.measurement.zzkt.zzb(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzhf.zze((int) r3, (long) r5)
            goto L_0x0354
        L_0x0445:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x046f
            long r5 = com.google.android.gms.internal.measurement.zzkt.zzb(r1, r5)
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzd((int) r3, (long) r5)
            goto L_0x0354
        L_0x0455:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x046f
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzb((int) r3, (float) r4)
            goto L_0x0354
        L_0x0461:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x046f
            r5 = 0
            int r3 = com.google.android.gms.internal.measurement.zzhf.zzb((int) r3, (double) r5)
            goto L_0x0354
        L_0x046f:
            int r12 = r12 + 3
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            goto L_0x0016
        L_0x0475:
            com.google.android.gms.internal.measurement.zzkn<?, ?> r2 = r0.zzq
            int r1 = zza(r2, r1)
            int r13 = r13 + r1
            return r13
        L_0x047d:
            sun.misc.Unsafe r2 = zzb
            r3 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            r12 = 0
        L_0x0485:
            int[] r13 = r0.zzc
            int r13 = r13.length
            if (r3 >= r13) goto L_0x0937
            int r13 = r0.zzd((int) r3)
            int[] r14 = r0.zzc
            r15 = r14[r3]
            r16 = 267386880(0xff00000, float:2.3665827E-29)
            r17 = r13 & r16
            int r4 = r17 >>> 20
            r11 = 17
            if (r4 > r11) goto L_0x04b1
            int r11 = r3 + 2
            r11 = r14[r11]
            r14 = r11 & r7
            int r11 = r11 >>> 20
            int r11 = r8 << r11
            if (r14 == r6) goto L_0x04ae
            long r8 = (long) r14
            int r12 = r2.getInt(r1, r8)
            goto L_0x04af
        L_0x04ae:
            r14 = r6
        L_0x04af:
            r6 = r14
            goto L_0x04b2
        L_0x04b1:
            r11 = 0
        L_0x04b2:
            r8 = r13 & r7
            long r8 = (long) r8
            switch(r4) {
                case 0: goto L_0x091c;
                case 1: goto L_0x090b;
                case 2: goto L_0x08fa;
                case 3: goto L_0x08ea;
                case 4: goto L_0x08da;
                case 5: goto L_0x08ca;
                case 6: goto L_0x08ba;
                case 7: goto L_0x08ae;
                case 8: goto L_0x0892;
                case 9: goto L_0x0880;
                case 10: goto L_0x0871;
                case 11: goto L_0x0864;
                case 12: goto L_0x0857;
                case 13: goto L_0x084c;
                case 14: goto L_0x0841;
                case 15: goto L_0x0834;
                case 16: goto L_0x0827;
                case 17: goto L_0x0814;
                case 18: goto L_0x0800;
                case 19: goto L_0x07f0;
                case 20: goto L_0x07e4;
                case 21: goto L_0x07d8;
                case 22: goto L_0x07cc;
                case 23: goto L_0x07c0;
                case 24: goto L_0x07b4;
                case 25: goto L_0x07a8;
                case 26: goto L_0x079d;
                case 27: goto L_0x078d;
                case 28: goto L_0x0781;
                case 29: goto L_0x0774;
                case 30: goto L_0x0767;
                case 31: goto L_0x075a;
                case 32: goto L_0x074d;
                case 33: goto L_0x0740;
                case 34: goto L_0x0733;
                case 35: goto L_0x071b;
                case 36: goto L_0x0706;
                case 37: goto L_0x06f1;
                case 38: goto L_0x06dc;
                case 39: goto L_0x06c7;
                case 40: goto L_0x06b2;
                case 41: goto L_0x069c;
                case 42: goto L_0x0686;
                case 43: goto L_0x0670;
                case 44: goto L_0x065a;
                case 45: goto L_0x0644;
                case 46: goto L_0x062e;
                case 47: goto L_0x0618;
                case 48: goto L_0x0602;
                case 49: goto L_0x05f2;
                case 50: goto L_0x05e2;
                case 51: goto L_0x05d4;
                case 52: goto L_0x05c7;
                case 53: goto L_0x05b7;
                case 54: goto L_0x05a7;
                case 55: goto L_0x0597;
                case 56: goto L_0x0589;
                case 57: goto L_0x057c;
                case 58: goto L_0x056f;
                case 59: goto L_0x0551;
                case 60: goto L_0x053d;
                case 61: goto L_0x052b;
                case 62: goto L_0x051b;
                case 63: goto L_0x050b;
                case 64: goto L_0x04fe;
                case 65: goto L_0x04f0;
                case 66: goto L_0x04e0;
                case 67: goto L_0x04d0;
                case 68: goto L_0x04ba;
                default: goto L_0x04b8;
            }
        L_0x04b8:
            goto L_0x080c
        L_0x04ba:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080c
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.measurement.zzjg r4 = (com.google.android.gms.internal.measurement.zzjg) r4
            com.google.android.gms.internal.measurement.zzjv r8 = r0.zza((int) r3)
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzc(r15, r4, r8)
            goto L_0x080b
        L_0x04d0:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080c
            long r8 = zze(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzf((int) r15, (long) r8)
            goto L_0x080b
        L_0x04e0:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080c
            int r4 = zzd(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzh((int) r15, (int) r4)
            goto L_0x080b
        L_0x04f0:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080c
            r8 = 0
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzh((int) r15, (long) r8)
            goto L_0x080b
        L_0x04fe:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080c
            r4 = 0
            int r8 = com.google.android.gms.internal.measurement.zzhf.zzj(r15, r4)
            goto L_0x0855
        L_0x050b:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080c
            int r4 = zzd(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzk(r15, r4)
            goto L_0x080b
        L_0x051b:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080c
            int r4 = zzd(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r15, (int) r4)
            goto L_0x080b
        L_0x052b:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080c
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.measurement.zzgm r4 = (com.google.android.gms.internal.measurement.zzgm) r4
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzc((int) r15, (com.google.android.gms.internal.measurement.zzgm) r4)
            goto L_0x080b
        L_0x053d:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080c
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.measurement.zzjv r8 = r0.zza((int) r3)
            int r4 = com.google.android.gms.internal.measurement.zzjx.zza((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzjv) r8)
            goto L_0x080b
        L_0x0551:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080c
            java.lang.Object r4 = r2.getObject(r1, r8)
            boolean r8 = r4 instanceof com.google.android.gms.internal.measurement.zzgm
            if (r8 == 0) goto L_0x0567
            com.google.android.gms.internal.measurement.zzgm r4 = (com.google.android.gms.internal.measurement.zzgm) r4
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzc((int) r15, (com.google.android.gms.internal.measurement.zzgm) r4)
            goto L_0x080b
        L_0x0567:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzb((int) r15, (java.lang.String) r4)
            goto L_0x080b
        L_0x056f:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080c
            r4 = 1
            int r8 = com.google.android.gms.internal.measurement.zzhf.zzb((int) r15, (boolean) r4)
            goto L_0x0855
        L_0x057c:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080c
            r4 = 0
            int r8 = com.google.android.gms.internal.measurement.zzhf.zzi(r15, r4)
            goto L_0x0855
        L_0x0589:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080c
            r8 = 0
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r15, (long) r8)
            goto L_0x080b
        L_0x0597:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080c
            int r4 = zzd(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzf((int) r15, (int) r4)
            goto L_0x080b
        L_0x05a7:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080c
            long r8 = zze(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzhf.zze((int) r15, (long) r8)
            goto L_0x080b
        L_0x05b7:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080c
            long r8 = zze(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzd((int) r15, (long) r8)
            goto L_0x080b
        L_0x05c7:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080c
            r4 = 0
            int r8 = com.google.android.gms.internal.measurement.zzhf.zzb((int) r15, (float) r4)
            goto L_0x0855
        L_0x05d4:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x080c
            r8 = 0
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzb((int) r15, (double) r8)
            goto L_0x080b
        L_0x05e2:
            com.google.android.gms.internal.measurement.zziz r4 = r0.zzs
            java.lang.Object r8 = r2.getObject(r1, r8)
            java.lang.Object r9 = r0.zzb((int) r3)
            int r4 = r4.zza(r15, r8, r9)
            goto L_0x080b
        L_0x05f2:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.measurement.zzjv r8 = r0.zza((int) r3)
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzb((int) r15, (java.util.List<com.google.android.gms.internal.measurement.zzjg>) r4, (com.google.android.gms.internal.measurement.zzjv) r8)
            goto L_0x080b
        L_0x0602:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzc(r4)
            if (r4 <= 0) goto L_0x080c
            int r8 = com.google.android.gms.internal.measurement.zzhf.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r4)
            goto L_0x072f
        L_0x0618:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzg(r4)
            if (r4 <= 0) goto L_0x080c
            int r8 = com.google.android.gms.internal.measurement.zzhf.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r4)
            goto L_0x072f
        L_0x062e:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzi(r4)
            if (r4 <= 0) goto L_0x080c
            int r8 = com.google.android.gms.internal.measurement.zzhf.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r4)
            goto L_0x072f
        L_0x0644:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzh(r4)
            if (r4 <= 0) goto L_0x080c
            int r8 = com.google.android.gms.internal.measurement.zzhf.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r4)
            goto L_0x072f
        L_0x065a:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzd(r4)
            if (r4 <= 0) goto L_0x080c
            int r8 = com.google.android.gms.internal.measurement.zzhf.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r4)
            goto L_0x072f
        L_0x0670:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzf(r4)
            if (r4 <= 0) goto L_0x080c
            int r8 = com.google.android.gms.internal.measurement.zzhf.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r4)
            goto L_0x072f
        L_0x0686:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzj(r4)
            if (r4 <= 0) goto L_0x080c
            int r8 = com.google.android.gms.internal.measurement.zzhf.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r4)
            goto L_0x072f
        L_0x069c:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzh(r4)
            if (r4 <= 0) goto L_0x080c
            int r8 = com.google.android.gms.internal.measurement.zzhf.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r4)
            goto L_0x072f
        L_0x06b2:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzi(r4)
            if (r4 <= 0) goto L_0x080c
            int r8 = com.google.android.gms.internal.measurement.zzhf.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r4)
            goto L_0x072f
        L_0x06c7:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zze(r4)
            if (r4 <= 0) goto L_0x080c
            int r8 = com.google.android.gms.internal.measurement.zzhf.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r4)
            goto L_0x072f
        L_0x06dc:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzb(r4)
            if (r4 <= 0) goto L_0x080c
            int r8 = com.google.android.gms.internal.measurement.zzhf.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r4)
            goto L_0x072f
        L_0x06f1:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zza((java.util.List<java.lang.Long>) r4)
            if (r4 <= 0) goto L_0x080c
            int r8 = com.google.android.gms.internal.measurement.zzhf.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r4)
            goto L_0x072f
        L_0x0706:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzh(r4)
            if (r4 <= 0) goto L_0x080c
            int r8 = com.google.android.gms.internal.measurement.zzhf.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r4)
            goto L_0x072f
        L_0x071b:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzi(r4)
            if (r4 <= 0) goto L_0x080c
            int r8 = com.google.android.gms.internal.measurement.zzhf.zze((int) r15)
            int r9 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r4)
        L_0x072f:
            int r8 = r8 + r9
            int r8 = r8 + r4
            goto L_0x0855
        L_0x0733:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            r10 = 0
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzc(r15, r4, r10)
            goto L_0x07fb
        L_0x0740:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzg(r15, r4, r10)
            goto L_0x07fb
        L_0x074d:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzi(r15, r4, r10)
            goto L_0x07fb
        L_0x075a:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzh(r15, r4, r10)
            goto L_0x07fb
        L_0x0767:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzd(r15, r4, r10)
            goto L_0x07fb
        L_0x0774:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzf(r15, r4, r10)
            goto L_0x080b
        L_0x0781:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzb(r15, r4)
            goto L_0x080b
        L_0x078d:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.measurement.zzjv r8 = r0.zza((int) r3)
            int r4 = com.google.android.gms.internal.measurement.zzjx.zza((int) r15, (java.util.List<?>) r4, (com.google.android.gms.internal.measurement.zzjv) r8)
            goto L_0x080b
        L_0x079d:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zza((int) r15, (java.util.List<?>) r4)
            goto L_0x080b
        L_0x07a8:
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            r10 = 0
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzj(r15, r4, r10)
            goto L_0x07fb
        L_0x07b4:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzh(r15, r4, r10)
            goto L_0x07fb
        L_0x07c0:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzi(r15, r4, r10)
            goto L_0x07fb
        L_0x07cc:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zze(r15, r4, r10)
            goto L_0x07fb
        L_0x07d8:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzb((int) r15, (java.util.List<java.lang.Long>) r4, (boolean) r10)
            goto L_0x07fb
        L_0x07e4:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zza((int) r15, (java.util.List<java.lang.Long>) r4, (boolean) r10)
            goto L_0x07fb
        L_0x07f0:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzh(r15, r4, r10)
        L_0x07fb:
            int r5 = r5 + r4
            r4 = 1
        L_0x07fd:
            r7 = 0
            goto L_0x0810
        L_0x0800:
            r10 = 0
            java.lang.Object r4 = r2.getObject(r1, r8)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.measurement.zzjx.zzi(r15, r4, r10)
        L_0x080b:
            int r5 = r5 + r4
        L_0x080c:
            r4 = 1
        L_0x080d:
            r7 = 0
            r10 = 0
        L_0x0810:
            r13 = 0
            goto L_0x092c
        L_0x0814:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x080c
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.measurement.zzjg r4 = (com.google.android.gms.internal.measurement.zzjg) r4
            com.google.android.gms.internal.measurement.zzjv r8 = r0.zza((int) r3)
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzc(r15, r4, r8)
            goto L_0x080b
        L_0x0827:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x080c
            long r8 = r2.getLong(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzf((int) r15, (long) r8)
            goto L_0x080b
        L_0x0834:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x080c
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzh((int) r15, (int) r4)
            goto L_0x080b
        L_0x0841:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x080c
            r8 = 0
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzh((int) r15, (long) r8)
            goto L_0x080b
        L_0x084c:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x080c
            r4 = 0
            int r8 = com.google.android.gms.internal.measurement.zzhf.zzj(r15, r4)
        L_0x0855:
            int r5 = r5 + r8
            goto L_0x080c
        L_0x0857:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x080c
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzk(r15, r4)
            goto L_0x080b
        L_0x0864:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x080c
            int r4 = r2.getInt(r1, r8)
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r15, (int) r4)
            goto L_0x080b
        L_0x0871:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x080c
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.measurement.zzgm r4 = (com.google.android.gms.internal.measurement.zzgm) r4
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzc((int) r15, (com.google.android.gms.internal.measurement.zzgm) r4)
            goto L_0x080b
        L_0x0880:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x080c
            java.lang.Object r4 = r2.getObject(r1, r8)
            com.google.android.gms.internal.measurement.zzjv r8 = r0.zza((int) r3)
            int r4 = com.google.android.gms.internal.measurement.zzjx.zza((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzjv) r8)
            goto L_0x080b
        L_0x0892:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x080c
            java.lang.Object r4 = r2.getObject(r1, r8)
            boolean r8 = r4 instanceof com.google.android.gms.internal.measurement.zzgm
            if (r8 == 0) goto L_0x08a6
            com.google.android.gms.internal.measurement.zzgm r4 = (com.google.android.gms.internal.measurement.zzgm) r4
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzc((int) r15, (com.google.android.gms.internal.measurement.zzgm) r4)
            goto L_0x080b
        L_0x08a6:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.measurement.zzhf.zzb((int) r15, (java.lang.String) r4)
            goto L_0x080b
        L_0x08ae:
            r4 = r12 & r11
            if (r4 == 0) goto L_0x080c
            r4 = 1
            int r8 = com.google.android.gms.internal.measurement.zzhf.zzb((int) r15, (boolean) r4)
            int r5 = r5 + r8
            goto L_0x080d
        L_0x08ba:
            r4 = 1
            r8 = r12 & r11
            if (r8 == 0) goto L_0x08c7
            r10 = 0
            int r8 = com.google.android.gms.internal.measurement.zzhf.zzi(r15, r10)
            int r5 = r5 + r8
            goto L_0x07fd
        L_0x08c7:
            r10 = 0
            goto L_0x07fd
        L_0x08ca:
            r4 = 1
            r10 = 0
            r8 = r12 & r11
            if (r8 == 0) goto L_0x08d7
            r13 = 0
            int r8 = com.google.android.gms.internal.measurement.zzhf.zzg((int) r15, (long) r13)
            goto L_0x0909
        L_0x08d7:
            r13 = 0
            goto L_0x0919
        L_0x08da:
            r4 = 1
            r10 = 0
            r13 = 0
            r11 = r11 & r12
            if (r11 == 0) goto L_0x0919
            int r8 = r2.getInt(r1, r8)
            int r8 = com.google.android.gms.internal.measurement.zzhf.zzf((int) r15, (int) r8)
            goto L_0x0909
        L_0x08ea:
            r4 = 1
            r10 = 0
            r13 = 0
            r11 = r11 & r12
            if (r11 == 0) goto L_0x0919
            long r8 = r2.getLong(r1, r8)
            int r8 = com.google.android.gms.internal.measurement.zzhf.zze((int) r15, (long) r8)
            goto L_0x0909
        L_0x08fa:
            r4 = 1
            r10 = 0
            r13 = 0
            r11 = r11 & r12
            if (r11 == 0) goto L_0x0919
            long r8 = r2.getLong(r1, r8)
            int r8 = com.google.android.gms.internal.measurement.zzhf.zzd((int) r15, (long) r8)
        L_0x0909:
            int r5 = r5 + r8
            goto L_0x0919
        L_0x090b:
            r4 = 1
            r10 = 0
            r13 = 0
            r8 = r12 & r11
            if (r8 == 0) goto L_0x0919
            r8 = 0
            int r9 = com.google.android.gms.internal.measurement.zzhf.zzb((int) r15, (float) r8)
            int r5 = r5 + r9
        L_0x0919:
            r7 = 0
            goto L_0x092c
        L_0x091c:
            r4 = 1
            r8 = 0
            r10 = 0
            r13 = 0
            r9 = r12 & r11
            if (r9 == 0) goto L_0x0919
            r7 = 0
            int r11 = com.google.android.gms.internal.measurement.zzhf.zzb((int) r15, (double) r7)
            int r5 = r5 + r11
        L_0x092c:
            int r3 = r3 + 3
            r9 = r13
            r4 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
            r8 = 1
            r11 = 0
            goto L_0x0485
        L_0x0937:
            r10 = 0
            com.google.android.gms.internal.measurement.zzkn<?, ?> r2 = r0.zzq
            int r2 = zza(r2, r1)
            int r5 = r5 + r2
            boolean r2 = r0.zzh
            if (r2 == 0) goto L_0x0991
            com.google.android.gms.internal.measurement.zzhk<?> r2 = r0.zzr
            com.google.android.gms.internal.measurement.zzho r1 = r2.zza((java.lang.Object) r1)
            r2 = 0
        L_0x094a:
            com.google.android.gms.internal.measurement.zzka<T, java.lang.Object> r3 = r1.zza
            int r3 = r3.zzc()
            if (r10 >= r3) goto L_0x096a
            com.google.android.gms.internal.measurement.zzka<T, java.lang.Object> r3 = r1.zza
            java.util.Map$Entry r3 = r3.zzb((int) r10)
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.measurement.zzhq r4 = (com.google.android.gms.internal.measurement.zzhq) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.measurement.zzho.zza((com.google.android.gms.internal.measurement.zzhq<?>) r4, (java.lang.Object) r3)
            int r2 = r2 + r3
            int r10 = r10 + 1
            goto L_0x094a
        L_0x096a:
            com.google.android.gms.internal.measurement.zzka<T, java.lang.Object> r1 = r1.zza
            java.lang.Iterable r1 = r1.zzd()
            java.util.Iterator r1 = r1.iterator()
        L_0x0974:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0990
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.measurement.zzhq r4 = (com.google.android.gms.internal.measurement.zzhq) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.measurement.zzho.zza((com.google.android.gms.internal.measurement.zzhq<?>) r4, (java.lang.Object) r3)
            int r2 = r2 + r3
            goto L_0x0974
        L_0x0990:
            int r5 = r5 + r2
        L_0x0991:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zzb(java.lang.Object):int");
    }

    private static <UT, UB> int zza(zzkn<UT, UB> zzkn, T t) {
        return zzkn.zzf(zzkn.zzb(t));
    }

    private static List<?> zza(Object obj, long j) {
        return (List) zzkt.zzf(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0553  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.measurement.zzlk r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zza()
            int r1 = com.google.android.gms.internal.measurement.zzhv.zze.zzk
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x0529
            com.google.android.gms.internal.measurement.zzkn<?, ?> r0 = r13.zzq
            zza(r0, r14, (com.google.android.gms.internal.measurement.zzlk) r15)
            boolean r0 = r13.zzh
            if (r0 == 0) goto L_0x0032
            com.google.android.gms.internal.measurement.zzhk<?> r0 = r13.zzr
            com.google.android.gms.internal.measurement.zzho r0 = r0.zza((java.lang.Object) r14)
            com.google.android.gms.internal.measurement.zzka<T, java.lang.Object> r1 = r0.zza
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0032
            java.util.Iterator r0 = r0.zze()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0034
        L_0x0032:
            r0 = r3
            r1 = r0
        L_0x0034:
            int[] r7 = r13.zzc
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0039:
            if (r7 < 0) goto L_0x0511
            int r8 = r13.zzd((int) r7)
            int[] r9 = r13.zzc
            r9 = r9[r7]
        L_0x0043:
            if (r1 == 0) goto L_0x0061
            com.google.android.gms.internal.measurement.zzhk<?> r10 = r13.zzr
            int r10 = r10.zza((java.util.Map.Entry<?, ?>) r1)
            if (r10 <= r9) goto L_0x0061
            com.google.android.gms.internal.measurement.zzhk<?> r10 = r13.zzr
            r10.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005f
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0043
        L_0x005f:
            r1 = r3
            goto L_0x0043
        L_0x0061:
            r10 = r8 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x04fe;
                case 1: goto L_0x04ee;
                case 2: goto L_0x04de;
                case 3: goto L_0x04ce;
                case 4: goto L_0x04be;
                case 5: goto L_0x04ae;
                case 6: goto L_0x049e;
                case 7: goto L_0x048d;
                case 8: goto L_0x047c;
                case 9: goto L_0x0467;
                case 10: goto L_0x0454;
                case 11: goto L_0x0443;
                case 12: goto L_0x0432;
                case 13: goto L_0x0421;
                case 14: goto L_0x0410;
                case 15: goto L_0x03ff;
                case 16: goto L_0x03ee;
                case 17: goto L_0x03d9;
                case 18: goto L_0x03c8;
                case 19: goto L_0x03b7;
                case 20: goto L_0x03a6;
                case 21: goto L_0x0395;
                case 22: goto L_0x0384;
                case 23: goto L_0x0373;
                case 24: goto L_0x0362;
                case 25: goto L_0x0351;
                case 26: goto L_0x0340;
                case 27: goto L_0x032b;
                case 28: goto L_0x031a;
                case 29: goto L_0x0309;
                case 30: goto L_0x02f8;
                case 31: goto L_0x02e7;
                case 32: goto L_0x02d6;
                case 33: goto L_0x02c5;
                case 34: goto L_0x02b4;
                case 35: goto L_0x02a3;
                case 36: goto L_0x0292;
                case 37: goto L_0x0281;
                case 38: goto L_0x0270;
                case 39: goto L_0x025f;
                case 40: goto L_0x024e;
                case 41: goto L_0x023d;
                case 42: goto L_0x022c;
                case 43: goto L_0x021b;
                case 44: goto L_0x020a;
                case 45: goto L_0x01f9;
                case 46: goto L_0x01e8;
                case 47: goto L_0x01d7;
                case 48: goto L_0x01c6;
                case 49: goto L_0x01b1;
                case 50: goto L_0x01a6;
                case 51: goto L_0x0195;
                case 52: goto L_0x0184;
                case 53: goto L_0x0173;
                case 54: goto L_0x0162;
                case 55: goto L_0x0151;
                case 56: goto L_0x0140;
                case 57: goto L_0x012f;
                case 58: goto L_0x011e;
                case 59: goto L_0x010d;
                case 60: goto L_0x00f8;
                case 61: goto L_0x00e5;
                case 62: goto L_0x00d4;
                case 63: goto L_0x00c3;
                case 64: goto L_0x00b2;
                case 65: goto L_0x00a1;
                case 66: goto L_0x0090;
                case 67: goto L_0x007f;
                case 68: goto L_0x006a;
                default: goto L_0x0068;
            }
        L_0x0068:
            goto L_0x050d
        L_0x006a:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzjv r10 = r13.zza((int) r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzjv) r10)
            goto L_0x050d
        L_0x007f:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zze((int) r9, (long) r10)
            goto L_0x050d
        L_0x0090:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzf(r9, r8)
            goto L_0x050d
        L_0x00a1:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x050d
        L_0x00b2:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zza((int) r9, (int) r8)
            goto L_0x050d
        L_0x00c3:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzb((int) r9, (int) r8)
            goto L_0x050d
        L_0x00d4:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zze((int) r9, (int) r8)
            goto L_0x050d
        L_0x00e5:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzgm r8 = (com.google.android.gms.internal.measurement.zzgm) r8
            r15.zza((int) r9, (com.google.android.gms.internal.measurement.zzgm) r8)
            goto L_0x050d
        L_0x00f8:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzjv r10 = r13.zza((int) r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzjv) r10)
            goto L_0x050d
        L_0x010d:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzlk) r15)
            goto L_0x050d
        L_0x011e:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzf(r14, r10)
            r15.zza((int) r9, (boolean) r8)
            goto L_0x050d
        L_0x012f:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzd((int) r9, (int) r8)
            goto L_0x050d
        L_0x0140:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zzd((int) r9, (long) r10)
            goto L_0x050d
        L_0x0151:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzd(r14, r10)
            r15.zzc((int) r9, (int) r8)
            goto L_0x050d
        L_0x0162:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zzc((int) r9, (long) r10)
            goto L_0x050d
        L_0x0173:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zze(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x050d
        L_0x0184:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzc(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x050d
        L_0x0195:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zzb(r14, (long) r10)
            r15.zza((int) r9, (double) r10)
            goto L_0x050d
        L_0x01a6:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            r13.zza((com.google.android.gms.internal.measurement.zzlk) r15, (int) r9, (java.lang.Object) r8, (int) r7)
            goto L_0x050d
        L_0x01b1:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjv r10 = r13.zza((int) r7)
            com.google.android.gms.internal.measurement.zzjx.zzb((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.measurement.zzlk) r15, (com.google.android.gms.internal.measurement.zzjv) r10)
            goto L_0x050d
        L_0x01c6:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zze(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01d7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzj(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01e8:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzg(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01f9:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzl(r9, r8, r15, r4)
            goto L_0x050d
        L_0x020a:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzm(r9, r8, r15, r4)
            goto L_0x050d
        L_0x021b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzi(r9, r8, r15, r4)
            goto L_0x050d
        L_0x022c:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzn(r9, r8, r15, r4)
            goto L_0x050d
        L_0x023d:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzk(r9, r8, r15, r4)
            goto L_0x050d
        L_0x024e:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzf(r9, r8, r15, r4)
            goto L_0x050d
        L_0x025f:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzh(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0270:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzd(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0281:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzc(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0292:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.measurement.zzlk) r15, (boolean) r4)
            goto L_0x050d
        L_0x02a3:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.measurement.zzlk) r15, (boolean) r4)
            goto L_0x050d
        L_0x02b4:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zze(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02c5:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzj(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02d6:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzg(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02e7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzl(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02f8:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzm(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0309:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzi(r9, r8, r15, r5)
            goto L_0x050d
        L_0x031a:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzb((int) r9, (java.util.List<com.google.android.gms.internal.measurement.zzgm>) r8, (com.google.android.gms.internal.measurement.zzlk) r15)
            goto L_0x050d
        L_0x032b:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjv r10 = r13.zza((int) r7)
            com.google.android.gms.internal.measurement.zzjx.zza((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.measurement.zzlk) r15, (com.google.android.gms.internal.measurement.zzjv) r10)
            goto L_0x050d
        L_0x0340:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zza((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.measurement.zzlk) r15)
            goto L_0x050d
        L_0x0351:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzn(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0362:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzk(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0373:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzf(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0384:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzh(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0395:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzd(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03a6:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzc(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03b7:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.measurement.zzlk) r15, (boolean) r5)
            goto L_0x050d
        L_0x03c8:
            int[] r9 = r13.zzc
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.measurement.zzjx.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.measurement.zzlk) r15, (boolean) r5)
            goto L_0x050d
        L_0x03d9:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzjv r10 = r13.zza((int) r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzjv) r10)
            goto L_0x050d
        L_0x03ee:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzkt.zzb(r14, r10)
            r15.zze((int) r9, (long) r10)
            goto L_0x050d
        L_0x03ff:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r10)
            r15.zzf(r9, r8)
            goto L_0x050d
        L_0x0410:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzkt.zzb(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x050d
        L_0x0421:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r10)
            r15.zza((int) r9, (int) r8)
            goto L_0x050d
        L_0x0432:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r10)
            r15.zzb((int) r9, (int) r8)
            goto L_0x050d
        L_0x0443:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r10)
            r15.zze((int) r9, (int) r8)
            goto L_0x050d
        L_0x0454:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzgm r8 = (com.google.android.gms.internal.measurement.zzgm) r8
            r15.zza((int) r9, (com.google.android.gms.internal.measurement.zzgm) r8)
            goto L_0x050d
        L_0x0467:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            com.google.android.gms.internal.measurement.zzjv r10 = r13.zza((int) r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzjv) r10)
            goto L_0x050d
        L_0x047c:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.measurement.zzlk) r15)
            goto L_0x050d
        L_0x048d:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.measurement.zzkt.zzc(r14, r10)
            r15.zza((int) r9, (boolean) r8)
            goto L_0x050d
        L_0x049e:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r10)
            r15.zzd((int) r9, (int) r8)
            goto L_0x050d
        L_0x04ae:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzkt.zzb(r14, r10)
            r15.zzd((int) r9, (long) r10)
            goto L_0x050d
        L_0x04be:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r10)
            r15.zzc((int) r9, (int) r8)
            goto L_0x050d
        L_0x04ce:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzkt.zzb(r14, r10)
            r15.zzc((int) r9, (long) r10)
            goto L_0x050d
        L_0x04de:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.measurement.zzkt.zzb(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x050d
        L_0x04ee:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.measurement.zzkt.zzd(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x050d
        L_0x04fe:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.measurement.zzkt.zze(r14, r10)
            r15.zza((int) r9, (double) r10)
        L_0x050d:
            int r7 = r7 + -3
            goto L_0x0039
        L_0x0511:
            if (r1 == 0) goto L_0x0528
            com.google.android.gms.internal.measurement.zzhk<?> r14 = r13.zzr
            r14.zza(r15, r1)
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x0526
            java.lang.Object r14 = r0.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r1 = r14
            goto L_0x0511
        L_0x0526:
            r1 = r3
            goto L_0x0511
        L_0x0528:
            return
        L_0x0529:
            boolean r0 = r13.zzj
            if (r0 == 0) goto L_0x0a46
            boolean r0 = r13.zzh
            if (r0 == 0) goto L_0x054a
            com.google.android.gms.internal.measurement.zzhk<?> r0 = r13.zzr
            com.google.android.gms.internal.measurement.zzho r0 = r0.zza((java.lang.Object) r14)
            com.google.android.gms.internal.measurement.zzka<T, java.lang.Object> r1 = r0.zza
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x054a
            java.util.Iterator r0 = r0.zzd()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x054c
        L_0x054a:
            r0 = r3
            r1 = r0
        L_0x054c:
            int[] r7 = r13.zzc
            int r7 = r7.length
            r8 = r1
            r1 = 0
        L_0x0551:
            if (r1 >= r7) goto L_0x0a29
            int r9 = r13.zzd((int) r1)
            int[] r10 = r13.zzc
            r10 = r10[r1]
        L_0x055b:
            if (r8 == 0) goto L_0x0579
            com.google.android.gms.internal.measurement.zzhk<?> r11 = r13.zzr
            int r11 = r11.zza((java.util.Map.Entry<?, ?>) r8)
            if (r11 > r10) goto L_0x0579
            com.google.android.gms.internal.measurement.zzhk<?> r11 = r13.zzr
            r11.zza(r15, r8)
            boolean r8 = r0.hasNext()
            if (r8 == 0) goto L_0x0577
            java.lang.Object r8 = r0.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            goto L_0x055b
        L_0x0577:
            r8 = r3
            goto L_0x055b
        L_0x0579:
            r11 = r9 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0a16;
                case 1: goto L_0x0a06;
                case 2: goto L_0x09f6;
                case 3: goto L_0x09e6;
                case 4: goto L_0x09d6;
                case 5: goto L_0x09c6;
                case 6: goto L_0x09b6;
                case 7: goto L_0x09a5;
                case 8: goto L_0x0994;
                case 9: goto L_0x097f;
                case 10: goto L_0x096c;
                case 11: goto L_0x095b;
                case 12: goto L_0x094a;
                case 13: goto L_0x0939;
                case 14: goto L_0x0928;
                case 15: goto L_0x0917;
                case 16: goto L_0x0906;
                case 17: goto L_0x08f1;
                case 18: goto L_0x08e0;
                case 19: goto L_0x08cf;
                case 20: goto L_0x08be;
                case 21: goto L_0x08ad;
                case 22: goto L_0x089c;
                case 23: goto L_0x088b;
                case 24: goto L_0x087a;
                case 25: goto L_0x0869;
                case 26: goto L_0x0858;
                case 27: goto L_0x0843;
                case 28: goto L_0x0832;
                case 29: goto L_0x0821;
                case 30: goto L_0x0810;
                case 31: goto L_0x07ff;
                case 32: goto L_0x07ee;
                case 33: goto L_0x07dd;
                case 34: goto L_0x07cc;
                case 35: goto L_0x07bb;
                case 36: goto L_0x07aa;
                case 37: goto L_0x0799;
                case 38: goto L_0x0788;
                case 39: goto L_0x0777;
                case 40: goto L_0x0766;
                case 41: goto L_0x0755;
                case 42: goto L_0x0744;
                case 43: goto L_0x0733;
                case 44: goto L_0x0722;
                case 45: goto L_0x0711;
                case 46: goto L_0x0700;
                case 47: goto L_0x06ef;
                case 48: goto L_0x06de;
                case 49: goto L_0x06c9;
                case 50: goto L_0x06be;
                case 51: goto L_0x06ad;
                case 52: goto L_0x069c;
                case 53: goto L_0x068b;
                case 54: goto L_0x067a;
                case 55: goto L_0x0669;
                case 56: goto L_0x0658;
                case 57: goto L_0x0647;
                case 58: goto L_0x0636;
                case 59: goto L_0x0625;
                case 60: goto L_0x0610;
                case 61: goto L_0x05fd;
                case 62: goto L_0x05ec;
                case 63: goto L_0x05db;
                case 64: goto L_0x05ca;
                case 65: goto L_0x05b9;
                case 66: goto L_0x05a8;
                case 67: goto L_0x0597;
                case 68: goto L_0x0582;
                default: goto L_0x0580;
            }
        L_0x0580:
            goto L_0x0a25
        L_0x0582:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzjv r11 = r13.zza((int) r1)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzjv) r11)
            goto L_0x0a25
        L_0x0597:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zze((int) r10, (long) r11)
            goto L_0x0a25
        L_0x05a8:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzf(r10, r9)
            goto L_0x0a25
        L_0x05b9:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0a25
        L_0x05ca:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zza((int) r10, (int) r9)
            goto L_0x0a25
        L_0x05db:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzb((int) r10, (int) r9)
            goto L_0x0a25
        L_0x05ec:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zze((int) r10, (int) r9)
            goto L_0x0a25
        L_0x05fd:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzgm r9 = (com.google.android.gms.internal.measurement.zzgm) r9
            r15.zza((int) r10, (com.google.android.gms.internal.measurement.zzgm) r9)
            goto L_0x0a25
        L_0x0610:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzjv r11 = r13.zza((int) r1)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzjv) r11)
            goto L_0x0a25
        L_0x0625:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzlk) r15)
            goto L_0x0a25
        L_0x0636:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzf(r14, r11)
            r15.zza((int) r10, (boolean) r9)
            goto L_0x0a25
        L_0x0647:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzd((int) r10, (int) r9)
            goto L_0x0a25
        L_0x0658:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zzd((int) r10, (long) r11)
            goto L_0x0a25
        L_0x0669:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzd(r14, r11)
            r15.zzc((int) r10, (int) r9)
            goto L_0x0a25
        L_0x067a:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zzc((int) r10, (long) r11)
            goto L_0x0a25
        L_0x068b:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zze(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0a25
        L_0x069c:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzc(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0a25
        L_0x06ad:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zzb(r14, (long) r11)
            r15.zza((int) r10, (double) r11)
            goto L_0x0a25
        L_0x06be:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            r13.zza((com.google.android.gms.internal.measurement.zzlk) r15, (int) r10, (java.lang.Object) r9, (int) r1)
            goto L_0x0a25
        L_0x06c9:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjv r11 = r13.zza((int) r1)
            com.google.android.gms.internal.measurement.zzjx.zzb((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.measurement.zzlk) r15, (com.google.android.gms.internal.measurement.zzjv) r11)
            goto L_0x0a25
        L_0x06de:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zze(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x06ef:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzj(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0700:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzg(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0711:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzl(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0722:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzm(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0733:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzi(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0744:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzn(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0755:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzk(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0766:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzf(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0777:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzh(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0788:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzd(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0799:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzc(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x07aa:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.measurement.zzlk) r15, (boolean) r4)
            goto L_0x0a25
        L_0x07bb:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.measurement.zzlk) r15, (boolean) r4)
            goto L_0x0a25
        L_0x07cc:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zze(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x07dd:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzj(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x07ee:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzg(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x07ff:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzl(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x0810:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzm(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x0821:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzi(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x0832:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzb((int) r10, (java.util.List<com.google.android.gms.internal.measurement.zzgm>) r9, (com.google.android.gms.internal.measurement.zzlk) r15)
            goto L_0x0a25
        L_0x0843:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjv r11 = r13.zza((int) r1)
            com.google.android.gms.internal.measurement.zzjx.zza((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.measurement.zzlk) r15, (com.google.android.gms.internal.measurement.zzjv) r11)
            goto L_0x0a25
        L_0x0858:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zza((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.measurement.zzlk) r15)
            goto L_0x0a25
        L_0x0869:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzn(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x087a:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzk(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x088b:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzf(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x089c:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzh(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x08ad:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzd(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x08be:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzc(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x08cf:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.measurement.zzlk) r15, (boolean) r5)
            goto L_0x0a25
        L_0x08e0:
            int[] r10 = r13.zzc
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.measurement.zzlk) r15, (boolean) r5)
            goto L_0x0a25
        L_0x08f1:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzjv r11 = r13.zza((int) r1)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzjv) r11)
            goto L_0x0a25
        L_0x0906:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzkt.zzb(r14, r11)
            r15.zze((int) r10, (long) r11)
            goto L_0x0a25
        L_0x0917:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r11)
            r15.zzf(r10, r9)
            goto L_0x0a25
        L_0x0928:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzkt.zzb(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0a25
        L_0x0939:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r11)
            r15.zza((int) r10, (int) r9)
            goto L_0x0a25
        L_0x094a:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r11)
            r15.zzb((int) r10, (int) r9)
            goto L_0x0a25
        L_0x095b:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r11)
            r15.zze((int) r10, (int) r9)
            goto L_0x0a25
        L_0x096c:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzgm r9 = (com.google.android.gms.internal.measurement.zzgm) r9
            r15.zza((int) r10, (com.google.android.gms.internal.measurement.zzgm) r9)
            goto L_0x0a25
        L_0x097f:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            com.google.android.gms.internal.measurement.zzjv r11 = r13.zza((int) r1)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzjv) r11)
            goto L_0x0a25
        L_0x0994:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.measurement.zzkt.zzf(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzlk) r15)
            goto L_0x0a25
        L_0x09a5:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.measurement.zzkt.zzc(r14, r11)
            r15.zza((int) r10, (boolean) r9)
            goto L_0x0a25
        L_0x09b6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r11)
            r15.zzd((int) r10, (int) r9)
            goto L_0x0a25
        L_0x09c6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzkt.zzb(r14, r11)
            r15.zzd((int) r10, (long) r11)
            goto L_0x0a25
        L_0x09d6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r11)
            r15.zzc((int) r10, (int) r9)
            goto L_0x0a25
        L_0x09e6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzkt.zzb(r14, r11)
            r15.zzc((int) r10, (long) r11)
            goto L_0x0a25
        L_0x09f6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.measurement.zzkt.zzb(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0a25
        L_0x0a06:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.measurement.zzkt.zzd(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0a25
        L_0x0a16:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.measurement.zzkt.zze(r14, r11)
            r15.zza((int) r10, (double) r11)
        L_0x0a25:
            int r1 = r1 + 3
            goto L_0x0551
        L_0x0a29:
            if (r8 == 0) goto L_0x0a40
            com.google.android.gms.internal.measurement.zzhk<?> r1 = r13.zzr
            r1.zza(r15, r8)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0a3e
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            r8 = r1
            goto L_0x0a29
        L_0x0a3e:
            r8 = r3
            goto L_0x0a29
        L_0x0a40:
            com.google.android.gms.internal.measurement.zzkn<?, ?> r0 = r13.zzq
            zza(r0, r14, (com.google.android.gms.internal.measurement.zzlk) r15)
            return
        L_0x0a46:
            r13.zzb(r14, (com.google.android.gms.internal.measurement.zzlk) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzlk):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:172:0x049f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r18, com.google.android.gms.internal.measurement.zzlk r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.zzh
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.measurement.zzhk<?> r3 = r0.zzr
            com.google.android.gms.internal.measurement.zzho r3 = r3.zza((java.lang.Object) r1)
            com.google.android.gms.internal.measurement.zzka<T, java.lang.Object> r5 = r3.zza
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0023
            java.util.Iterator r3 = r3.zzd()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0025
        L_0x0023:
            r3 = 0
            r5 = 0
        L_0x0025:
            int[] r6 = r0.zzc
            int r6 = r6.length
            sun.misc.Unsafe r7 = zzb
            r11 = r5
            r5 = 0
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r12 = 0
        L_0x0030:
            if (r5 >= r6) goto L_0x049c
            int r13 = r0.zzd((int) r5)
            int[] r14 = r0.zzc
            r15 = r14[r5]
            r16 = 267386880(0xff00000, float:2.3665827E-29)
            r16 = r13 & r16
            int r4 = r16 >>> 20
            boolean r9 = r0.zzj
            if (r9 != 0) goto L_0x0064
            r9 = 17
            if (r4 > r9) goto L_0x0064
            int r9 = r5 + 2
            r9 = r14[r9]
            r14 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r9 & r14
            if (r8 == r10) goto L_0x005a
            r14 = r11
            long r10 = (long) r8
            int r12 = r7.getInt(r1, r10)
            goto L_0x005c
        L_0x005a:
            r14 = r11
            r8 = r10
        L_0x005c:
            int r9 = r9 >>> 20
            r10 = 1
            int r9 = r10 << r9
            r10 = r8
            r11 = r14
            goto L_0x0067
        L_0x0064:
            r14 = r11
            r11 = r14
            r9 = 0
        L_0x0067:
            if (r11 == 0) goto L_0x0086
            com.google.android.gms.internal.measurement.zzhk<?> r8 = r0.zzr
            int r8 = r8.zza((java.util.Map.Entry<?, ?>) r11)
            if (r8 > r15) goto L_0x0086
            com.google.android.gms.internal.measurement.zzhk<?> r8 = r0.zzr
            r8.zza(r2, r11)
            boolean r8 = r3.hasNext()
            if (r8 == 0) goto L_0x0084
            java.lang.Object r8 = r3.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            r11 = r8
            goto L_0x0067
        L_0x0084:
            r11 = 0
            goto L_0x0067
        L_0x0086:
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r13 = r13 & r8
            long r13 = (long) r13
            switch(r4) {
                case 0: goto L_0x048d;
                case 1: goto L_0x0481;
                case 2: goto L_0x0475;
                case 3: goto L_0x0469;
                case 4: goto L_0x045d;
                case 5: goto L_0x0451;
                case 6: goto L_0x0445;
                case 7: goto L_0x0439;
                case 8: goto L_0x042d;
                case 9: goto L_0x041c;
                case 10: goto L_0x040d;
                case 11: goto L_0x0400;
                case 12: goto L_0x03f3;
                case 13: goto L_0x03e6;
                case 14: goto L_0x03d9;
                case 15: goto L_0x03cc;
                case 16: goto L_0x03bf;
                case 17: goto L_0x03ae;
                case 18: goto L_0x039e;
                case 19: goto L_0x038e;
                case 20: goto L_0x037e;
                case 21: goto L_0x036e;
                case 22: goto L_0x035e;
                case 23: goto L_0x034e;
                case 24: goto L_0x033e;
                case 25: goto L_0x032e;
                case 26: goto L_0x031f;
                case 27: goto L_0x030c;
                case 28: goto L_0x02fd;
                case 29: goto L_0x02ed;
                case 30: goto L_0x02dd;
                case 31: goto L_0x02cd;
                case 32: goto L_0x02bd;
                case 33: goto L_0x02ad;
                case 34: goto L_0x029d;
                case 35: goto L_0x028d;
                case 36: goto L_0x027d;
                case 37: goto L_0x026d;
                case 38: goto L_0x025d;
                case 39: goto L_0x024d;
                case 40: goto L_0x023d;
                case 41: goto L_0x022d;
                case 42: goto L_0x021d;
                case 43: goto L_0x020d;
                case 44: goto L_0x01fd;
                case 45: goto L_0x01ed;
                case 46: goto L_0x01dd;
                case 47: goto L_0x01cd;
                case 48: goto L_0x01bd;
                case 49: goto L_0x01aa;
                case 50: goto L_0x01a1;
                case 51: goto L_0x0192;
                case 52: goto L_0x0183;
                case 53: goto L_0x0174;
                case 54: goto L_0x0165;
                case 55: goto L_0x0156;
                case 56: goto L_0x0147;
                case 57: goto L_0x0138;
                case 58: goto L_0x0129;
                case 59: goto L_0x011a;
                case 60: goto L_0x0107;
                case 61: goto L_0x00f7;
                case 62: goto L_0x00e9;
                case 63: goto L_0x00db;
                case 64: goto L_0x00cd;
                case 65: goto L_0x00bf;
                case 66: goto L_0x00b1;
                case 67: goto L_0x00a3;
                case 68: goto L_0x0091;
                default: goto L_0x008e;
            }
        L_0x008e:
            r4 = 0
            goto L_0x0498
        L_0x0091:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.measurement.zzjv r9 = r0.zza((int) r5)
            r2.zzb((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzjv) r9)
            goto L_0x008e
        L_0x00a3:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r13 = zze(r1, r13)
            r2.zze((int) r15, (long) r13)
            goto L_0x008e
        L_0x00b1:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzd(r1, r13)
            r2.zzf(r15, r4)
            goto L_0x008e
        L_0x00bf:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r13 = zze(r1, r13)
            r2.zzb((int) r15, (long) r13)
            goto L_0x008e
        L_0x00cd:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzd(r1, r13)
            r2.zza((int) r15, (int) r4)
            goto L_0x008e
        L_0x00db:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzd(r1, r13)
            r2.zzb((int) r15, (int) r4)
            goto L_0x008e
        L_0x00e9:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzd(r1, r13)
            r2.zze((int) r15, (int) r4)
            goto L_0x008e
        L_0x00f7:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.measurement.zzgm r4 = (com.google.android.gms.internal.measurement.zzgm) r4
            r2.zza((int) r15, (com.google.android.gms.internal.measurement.zzgm) r4)
            goto L_0x008e
        L_0x0107:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.measurement.zzjv r9 = r0.zza((int) r5)
            r2.zza((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzjv) r9)
            goto L_0x008e
        L_0x011a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r7.getObject(r1, r13)
            zza((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.measurement.zzlk) r2)
            goto L_0x008e
        L_0x0129:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            boolean r4 = zzf(r1, r13)
            r2.zza((int) r15, (boolean) r4)
            goto L_0x008e
        L_0x0138:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzd(r1, r13)
            r2.zzd((int) r15, (int) r4)
            goto L_0x008e
        L_0x0147:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r13 = zze(r1, r13)
            r2.zzd((int) r15, (long) r13)
            goto L_0x008e
        L_0x0156:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzd(r1, r13)
            r2.zzc((int) r15, (int) r4)
            goto L_0x008e
        L_0x0165:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r13 = zze(r1, r13)
            r2.zzc((int) r15, (long) r13)
            goto L_0x008e
        L_0x0174:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r13 = zze(r1, r13)
            r2.zza((int) r15, (long) r13)
            goto L_0x008e
        L_0x0183:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            float r4 = zzc(r1, r13)
            r2.zza((int) r15, (float) r4)
            goto L_0x008e
        L_0x0192:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            double r13 = zzb(r1, (long) r13)
            r2.zza((int) r15, (double) r13)
            goto L_0x008e
        L_0x01a1:
            java.lang.Object r4 = r7.getObject(r1, r13)
            r0.zza((com.google.android.gms.internal.measurement.zzlk) r2, (int) r15, (java.lang.Object) r4, (int) r5)
            goto L_0x008e
        L_0x01aa:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjv r13 = r0.zza((int) r5)
            com.google.android.gms.internal.measurement.zzjx.zzb((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.measurement.zzlk) r2, (com.google.android.gms.internal.measurement.zzjv) r13)
            goto L_0x008e
        L_0x01bd:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r15 = 1
            com.google.android.gms.internal.measurement.zzjx.zze(r4, r9, r2, r15)
            goto L_0x008e
        L_0x01cd:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzj(r4, r9, r2, r15)
            goto L_0x008e
        L_0x01dd:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzg(r4, r9, r2, r15)
            goto L_0x008e
        L_0x01ed:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzl(r4, r9, r2, r15)
            goto L_0x008e
        L_0x01fd:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzm(r4, r9, r2, r15)
            goto L_0x008e
        L_0x020d:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzi(r4, r9, r2, r15)
            goto L_0x008e
        L_0x021d:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzn(r4, r9, r2, r15)
            goto L_0x008e
        L_0x022d:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzk(r4, r9, r2, r15)
            goto L_0x008e
        L_0x023d:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzf(r4, r9, r2, r15)
            goto L_0x008e
        L_0x024d:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzh(r4, r9, r2, r15)
            goto L_0x008e
        L_0x025d:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzd(r4, r9, r2, r15)
            goto L_0x008e
        L_0x026d:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzc(r4, r9, r2, r15)
            goto L_0x008e
        L_0x027d:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.measurement.zzlk) r2, (boolean) r15)
            goto L_0x008e
        L_0x028d:
            r15 = 1
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.measurement.zzlk) r2, (boolean) r15)
            goto L_0x008e
        L_0x029d:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r15 = 0
            com.google.android.gms.internal.measurement.zzjx.zze(r4, r9, r2, r15)
            goto L_0x008e
        L_0x02ad:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzj(r4, r9, r2, r15)
            goto L_0x008e
        L_0x02bd:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzg(r4, r9, r2, r15)
            goto L_0x008e
        L_0x02cd:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzl(r4, r9, r2, r15)
            goto L_0x008e
        L_0x02dd:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzm(r4, r9, r2, r15)
            goto L_0x008e
        L_0x02ed:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzi(r4, r9, r2, r15)
            goto L_0x008e
        L_0x02fd:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzb((int) r4, (java.util.List<com.google.android.gms.internal.measurement.zzgm>) r9, (com.google.android.gms.internal.measurement.zzlk) r2)
            goto L_0x008e
        L_0x030c:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjv r13 = r0.zza((int) r5)
            com.google.android.gms.internal.measurement.zzjx.zza((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.measurement.zzlk) r2, (com.google.android.gms.internal.measurement.zzjv) r13)
            goto L_0x008e
        L_0x031f:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zza((int) r4, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.measurement.zzlk) r2)
            goto L_0x008e
        L_0x032e:
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r15 = 0
            com.google.android.gms.internal.measurement.zzjx.zzn(r4, r9, r2, r15)
            goto L_0x008e
        L_0x033e:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzk(r4, r9, r2, r15)
            goto L_0x008e
        L_0x034e:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzf(r4, r9, r2, r15)
            goto L_0x008e
        L_0x035e:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzh(r4, r9, r2, r15)
            goto L_0x008e
        L_0x036e:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzd(r4, r9, r2, r15)
            goto L_0x008e
        L_0x037e:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzc(r4, r9, r2, r15)
            goto L_0x008e
        L_0x038e:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.measurement.zzlk) r2, (boolean) r15)
            goto L_0x008e
        L_0x039e:
            r15 = 0
            int[] r4 = r0.zzc
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.measurement.zzjx.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.measurement.zzlk) r2, (boolean) r15)
            goto L_0x008e
        L_0x03ae:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            java.lang.Object r9 = r7.getObject(r1, r13)
            com.google.android.gms.internal.measurement.zzjv r13 = r0.zza((int) r5)
            r2.zzb((int) r15, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzjv) r13)
            goto L_0x0498
        L_0x03bf:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            long r13 = r7.getLong(r1, r13)
            r2.zze((int) r15, (long) r13)
            goto L_0x0498
        L_0x03cc:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            int r9 = r7.getInt(r1, r13)
            r2.zzf(r15, r9)
            goto L_0x0498
        L_0x03d9:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            long r13 = r7.getLong(r1, r13)
            r2.zzb((int) r15, (long) r13)
            goto L_0x0498
        L_0x03e6:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            int r9 = r7.getInt(r1, r13)
            r2.zza((int) r15, (int) r9)
            goto L_0x0498
        L_0x03f3:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            int r9 = r7.getInt(r1, r13)
            r2.zzb((int) r15, (int) r9)
            goto L_0x0498
        L_0x0400:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            int r9 = r7.getInt(r1, r13)
            r2.zze((int) r15, (int) r9)
            goto L_0x0498
        L_0x040d:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            java.lang.Object r9 = r7.getObject(r1, r13)
            com.google.android.gms.internal.measurement.zzgm r9 = (com.google.android.gms.internal.measurement.zzgm) r9
            r2.zza((int) r15, (com.google.android.gms.internal.measurement.zzgm) r9)
            goto L_0x0498
        L_0x041c:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            java.lang.Object r9 = r7.getObject(r1, r13)
            com.google.android.gms.internal.measurement.zzjv r13 = r0.zza((int) r5)
            r2.zza((int) r15, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzjv) r13)
            goto L_0x0498
        L_0x042d:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            java.lang.Object r9 = r7.getObject(r1, r13)
            zza((int) r15, (java.lang.Object) r9, (com.google.android.gms.internal.measurement.zzlk) r2)
            goto L_0x0498
        L_0x0439:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            boolean r9 = com.google.android.gms.internal.measurement.zzkt.zzc(r1, r13)
            r2.zza((int) r15, (boolean) r9)
            goto L_0x0498
        L_0x0445:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            int r9 = r7.getInt(r1, r13)
            r2.zzd((int) r15, (int) r9)
            goto L_0x0498
        L_0x0451:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            long r13 = r7.getLong(r1, r13)
            r2.zzd((int) r15, (long) r13)
            goto L_0x0498
        L_0x045d:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            int r9 = r7.getInt(r1, r13)
            r2.zzc((int) r15, (int) r9)
            goto L_0x0498
        L_0x0469:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            long r13 = r7.getLong(r1, r13)
            r2.zzc((int) r15, (long) r13)
            goto L_0x0498
        L_0x0475:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            long r13 = r7.getLong(r1, r13)
            r2.zza((int) r15, (long) r13)
            goto L_0x0498
        L_0x0481:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            float r9 = com.google.android.gms.internal.measurement.zzkt.zzd(r1, r13)
            r2.zza((int) r15, (float) r9)
            goto L_0x0498
        L_0x048d:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            double r13 = com.google.android.gms.internal.measurement.zzkt.zze(r1, r13)
            r2.zza((int) r15, (double) r13)
        L_0x0498:
            int r5 = r5 + 3
            goto L_0x0030
        L_0x049c:
            r14 = r11
        L_0x049d:
            if (r14 == 0) goto L_0x04b4
            com.google.android.gms.internal.measurement.zzhk<?> r4 = r0.zzr
            r4.zza(r2, r14)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04b2
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r14 = r4
            goto L_0x049d
        L_0x04b2:
            r14 = 0
            goto L_0x049d
        L_0x04b4:
            com.google.android.gms.internal.measurement.zzkn<?, ?> r3 = r0.zzq
            zza(r3, r1, (com.google.android.gms.internal.measurement.zzlk) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zzb(java.lang.Object, com.google.android.gms.internal.measurement.zzlk):void");
    }

    private final <K, V> void zza(zzlk zzlk, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzlk.zza(i, this.zzs.zzf(zzb(i2)), this.zzs.zzb(obj));
        }
    }

    private static <UT, UB> void zza(zzkn<UT, UB> zzkn, T t, zzlk zzlk) throws IOException {
        zzkn.zza(zzkn.zzb(t), zzlk);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:148|149|(1:151)|152|(5:174|154|(2:157|155)|256|(2:159|264)(1:265))(1:252)) */
    /* JADX WARNING: Code restructure failed: missing block: B:149:?, code lost:
        r7.zza(r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x05a0, code lost:
        if (r10 == null) goto L_0x05a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x05a2, code lost:
        r10 = r7.zzc(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x05ab, code lost:
        if (r7.zza(r10, r14) == false) goto L_0x05ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x05ad, code lost:
        r14 = r12.zzm;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x05b1, code lost:
        if (r14 < r12.zzn) goto L_0x05b3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x05b3, code lost:
        r10 = zza((java.lang.Object) r13, r12.zzl[r14], r10, r7);
        r14 = r14 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x05be, code lost:
        if (r10 != null) goto L_0x05c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x05c0, code lost:
        r7.zzb((java.lang.Object) r13, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:148:0x059d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r13, com.google.android.gms.internal.measurement.zzjw r14, com.google.android.gms.internal.measurement.zzhi r15) throws java.io.IOException {
        /*
            r12 = this;
            if (r15 == 0) goto L_0x05dc
            com.google.android.gms.internal.measurement.zzkn<?, ?> r7 = r12.zzq
            com.google.android.gms.internal.measurement.zzhk<?> r8 = r12.zzr
            r9 = 0
            r0 = r9
            r10 = r0
        L_0x0009:
            int r1 = r14.zza()     // Catch:{ all -> 0x05c4 }
            int r2 = r12.zzg(r1)     // Catch:{ all -> 0x05c4 }
            if (r2 >= 0) goto L_0x0077
            r2 = 2147483647(0x7fffffff, float:NaN)
            if (r1 != r2) goto L_0x002f
            int r14 = r12.zzm
        L_0x001a:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x0029
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x001a
        L_0x0029:
            if (r10 == 0) goto L_0x002e
            r7.zzb((java.lang.Object) r13, r10)
        L_0x002e:
            return
        L_0x002f:
            boolean r2 = r12.zzh     // Catch:{ all -> 0x05c4 }
            if (r2 != 0) goto L_0x0035
            r2 = r9
            goto L_0x003c
        L_0x0035:
            com.google.android.gms.internal.measurement.zzjg r2 = r12.zzg     // Catch:{ all -> 0x05c4 }
            java.lang.Object r1 = r8.zza(r15, r2, r1)     // Catch:{ all -> 0x05c4 }
            r2 = r1
        L_0x003c:
            if (r2 == 0) goto L_0x0051
            if (r0 != 0) goto L_0x0044
            com.google.android.gms.internal.measurement.zzho r0 = r8.zzb(r13)     // Catch:{ all -> 0x05c4 }
        L_0x0044:
            r11 = r0
            r0 = r8
            r1 = r14
            r3 = r15
            r4 = r11
            r5 = r10
            r6 = r7
            java.lang.Object r10 = r0.zza(r1, r2, r3, r4, r5, r6)     // Catch:{ all -> 0x05c4 }
            r0 = r11
            goto L_0x0009
        L_0x0051:
            r7.zza((com.google.android.gms.internal.measurement.zzjw) r14)     // Catch:{ all -> 0x05c4 }
            if (r10 != 0) goto L_0x005a
            java.lang.Object r10 = r7.zzc(r13)     // Catch:{ all -> 0x05c4 }
        L_0x005a:
            boolean r1 = r7.zza(r10, (com.google.android.gms.internal.measurement.zzjw) r14)     // Catch:{ all -> 0x05c4 }
            if (r1 != 0) goto L_0x0009
            int r14 = r12.zzm
        L_0x0062:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x0071
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x0062
        L_0x0071:
            if (r10 == 0) goto L_0x0076
            r7.zzb((java.lang.Object) r13, r10)
        L_0x0076:
            return
        L_0x0077:
            int r3 = r12.zzd((int) r2)     // Catch:{ all -> 0x05c4 }
            r4 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r3
            int r4 = r4 >>> 20
            r5 = 1048575(0xfffff, float:1.469367E-39)
            switch(r4) {
                case 0: goto L_0x0571;
                case 1: goto L_0x0562;
                case 2: goto L_0x0553;
                case 3: goto L_0x0544;
                case 4: goto L_0x0535;
                case 5: goto L_0x0526;
                case 6: goto L_0x0517;
                case 7: goto L_0x0508;
                case 8: goto L_0x0500;
                case 9: goto L_0x04cf;
                case 10: goto L_0x04c0;
                case 11: goto L_0x04b1;
                case 12: goto L_0x048f;
                case 13: goto L_0x0480;
                case 14: goto L_0x0471;
                case 15: goto L_0x0462;
                case 16: goto L_0x0453;
                case 17: goto L_0x0422;
                case 18: goto L_0x0414;
                case 19: goto L_0x0406;
                case 20: goto L_0x03f8;
                case 21: goto L_0x03ea;
                case 22: goto L_0x03dc;
                case 23: goto L_0x03ce;
                case 24: goto L_0x03c0;
                case 25: goto L_0x03b2;
                case 26: goto L_0x0390;
                case 27: goto L_0x037e;
                case 28: goto L_0x0370;
                case 29: goto L_0x0362;
                case 30: goto L_0x034d;
                case 31: goto L_0x033f;
                case 32: goto L_0x0331;
                case 33: goto L_0x0323;
                case 34: goto L_0x0315;
                case 35: goto L_0x0307;
                case 36: goto L_0x02f9;
                case 37: goto L_0x02eb;
                case 38: goto L_0x02dd;
                case 39: goto L_0x02cf;
                case 40: goto L_0x02c1;
                case 41: goto L_0x02b3;
                case 42: goto L_0x02a5;
                case 43: goto L_0x0297;
                case 44: goto L_0x0282;
                case 45: goto L_0x0274;
                case 46: goto L_0x0266;
                case 47: goto L_0x0258;
                case 48: goto L_0x024a;
                case 49: goto L_0x0238;
                case 50: goto L_0x01f6;
                case 51: goto L_0x01e4;
                case 52: goto L_0x01d2;
                case 53: goto L_0x01c0;
                case 54: goto L_0x01ae;
                case 55: goto L_0x019c;
                case 56: goto L_0x018a;
                case 57: goto L_0x0178;
                case 58: goto L_0x0166;
                case 59: goto L_0x015e;
                case 60: goto L_0x012d;
                case 61: goto L_0x011f;
                case 62: goto L_0x010d;
                case 63: goto L_0x00e8;
                case 64: goto L_0x00d6;
                case 65: goto L_0x00c4;
                case 66: goto L_0x00b2;
                case 67: goto L_0x00a0;
                case 68: goto L_0x008e;
                default: goto L_0x0086;
            }
        L_0x0086:
            if (r10 != 0) goto L_0x0580
            java.lang.Object r10 = r7.zza()     // Catch:{ zzif -> 0x059d }
            goto L_0x0580
        L_0x008e:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzjv r5 = r12.zza((int) r2)     // Catch:{ zzif -> 0x059d }
            java.lang.Object r5 = r14.zzb(r5, r15)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x00a0:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x059d }
            long r5 = r14.zzt()     // Catch:{ zzif -> 0x059d }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x00b2:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x059d }
            int r5 = r14.zzs()     // Catch:{ zzif -> 0x059d }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x00c4:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x059d }
            long r5 = r14.zzr()     // Catch:{ zzif -> 0x059d }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x00d6:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x059d }
            int r5 = r14.zzq()     // Catch:{ zzif -> 0x059d }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x00e8:
            int r4 = r14.zzp()     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzic r6 = r12.zzc((int) r2)     // Catch:{ zzif -> 0x059d }
            if (r6 == 0) goto L_0x00ff
            boolean r6 = r6.zza(r4)     // Catch:{ zzif -> 0x059d }
            if (r6 == 0) goto L_0x00f9
            goto L_0x00ff
        L_0x00f9:
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzjx.zza((int) r1, (int) r4, r10, r7)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x00ff:
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzif -> 0x059d }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r5, (java.lang.Object) r3)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x010d:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x059d }
            int r5 = r14.zzo()     // Catch:{ zzif -> 0x059d }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x011f:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzgm r5 = r14.zzn()     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x012d:
            boolean r4 = r12.zza(r13, (int) r1, (int) r2)     // Catch:{ zzif -> 0x059d }
            if (r4 == 0) goto L_0x0149
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x059d }
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzkt.zzf(r13, r3)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzjv r6 = r12.zza((int) r2)     // Catch:{ zzif -> 0x059d }
            java.lang.Object r6 = r14.zza(r6, r15)     // Catch:{ zzif -> 0x059d }
            java.lang.Object r5 = com.google.android.gms.internal.measurement.zzhx.zza((java.lang.Object) r5, (java.lang.Object) r6)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x059d }
            goto L_0x0159
        L_0x0149:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzjv r5 = r12.zza((int) r2)     // Catch:{ zzif -> 0x059d }
            java.lang.Object r5 = r14.zza(r5, r15)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzif -> 0x059d }
        L_0x0159:
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x015e:
            r12.zza((java.lang.Object) r13, (int) r3, (com.google.android.gms.internal.measurement.zzjw) r14)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0166:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x059d }
            boolean r5 = r14.zzk()     // Catch:{ zzif -> 0x059d }
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0178:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x059d }
            int r5 = r14.zzj()     // Catch:{ zzif -> 0x059d }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x018a:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x059d }
            long r5 = r14.zzi()     // Catch:{ zzif -> 0x059d }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x019c:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x059d }
            int r5 = r14.zzh()     // Catch:{ zzif -> 0x059d }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x01ae:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x059d }
            long r5 = r14.zzf()     // Catch:{ zzif -> 0x059d }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x01c0:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x059d }
            long r5 = r14.zzg()     // Catch:{ zzif -> 0x059d }
            java.lang.Long r5 = java.lang.Long.valueOf(r5)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x01d2:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x059d }
            float r5 = r14.zze()     // Catch:{ zzif -> 0x059d }
            java.lang.Float r5 = java.lang.Float.valueOf(r5)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x01e4:
            r3 = r3 & r5
            long r3 = (long) r3     // Catch:{ zzif -> 0x059d }
            double r5 = r14.zzd()     // Catch:{ zzif -> 0x059d }
            java.lang.Double r5 = java.lang.Double.valueOf(r5)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r5)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r1, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x01f6:
            java.lang.Object r1 = r12.zzb((int) r2)     // Catch:{ zzif -> 0x059d }
            int r2 = r12.zzd((int) r2)     // Catch:{ zzif -> 0x059d }
            r2 = r2 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.lang.Object r4 = com.google.android.gms.internal.measurement.zzkt.zzf(r13, r2)     // Catch:{ zzif -> 0x059d }
            if (r4 != 0) goto L_0x0210
            com.google.android.gms.internal.measurement.zziz r4 = r12.zzs     // Catch:{ zzif -> 0x059d }
            java.lang.Object r4 = r4.zze(r1)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r2, (java.lang.Object) r4)     // Catch:{ zzif -> 0x059d }
            goto L_0x0227
        L_0x0210:
            com.google.android.gms.internal.measurement.zziz r5 = r12.zzs     // Catch:{ zzif -> 0x059d }
            boolean r5 = r5.zzc(r4)     // Catch:{ zzif -> 0x059d }
            if (r5 == 0) goto L_0x0227
            com.google.android.gms.internal.measurement.zziz r5 = r12.zzs     // Catch:{ zzif -> 0x059d }
            java.lang.Object r5 = r5.zze(r1)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zziz r6 = r12.zzs     // Catch:{ zzif -> 0x059d }
            r6.zza(r5, r4)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r2, (java.lang.Object) r5)     // Catch:{ zzif -> 0x059d }
            r4 = r5
        L_0x0227:
            com.google.android.gms.internal.measurement.zziz r2 = r12.zzs     // Catch:{ zzif -> 0x059d }
            java.util.Map r2 = r2.zza(r4)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zziz r3 = r12.zzs     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzix r1 = r3.zzf(r1)     // Catch:{ zzif -> 0x059d }
            r14.zza(r2, r1, (com.google.android.gms.internal.measurement.zzhi) r15)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0238:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzjv r1 = r12.zza((int) r2)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zziq r2 = r12.zzp     // Catch:{ zzif -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzif -> 0x059d }
            r14.zzb(r2, r1, r15)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x024a:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zzq(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0258:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zzp(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0266:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zzo(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0274:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zzn(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0282:
            com.google.android.gms.internal.measurement.zziq r4 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzif -> 0x059d }
            java.util.List r3 = r4.zza(r13, r5)     // Catch:{ zzif -> 0x059d }
            r14.zzm(r3)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzic r2 = r12.zzc((int) r2)     // Catch:{ zzif -> 0x059d }
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzjx.zza(r1, r3, r2, r10, r7)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0297:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zzl(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x02a5:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zzh(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x02b3:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zzg(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x02c1:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zzf(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x02cf:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zze(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x02dd:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zzc(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x02eb:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zzd(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x02f9:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zzb(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0307:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zza(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0315:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zzq(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0323:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zzp(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0331:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zzo(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x033f:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zzn(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x034d:
            com.google.android.gms.internal.measurement.zziq r4 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r3 = r3 & r5
            long r5 = (long) r3     // Catch:{ zzif -> 0x059d }
            java.util.List r3 = r4.zza(r13, r5)     // Catch:{ zzif -> 0x059d }
            r14.zzm(r3)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzic r2 = r12.zzc((int) r2)     // Catch:{ zzif -> 0x059d }
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzjx.zza(r1, r3, r2, r10, r7)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0362:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zzl(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0370:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zzk(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x037e:
            com.google.android.gms.internal.measurement.zzjv r1 = r12.zza((int) r2)     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zziq r4 = r12.zzp     // Catch:{ zzif -> 0x059d }
            java.util.List r2 = r4.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zza(r2, r1, (com.google.android.gms.internal.measurement.zzhi) r15)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0390:
            boolean r1 = zzf(r3)     // Catch:{ zzif -> 0x059d }
            if (r1 == 0) goto L_0x03a4
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zzj(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x03a4:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zzi(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x03b2:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zzh(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x03c0:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zzg(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x03ce:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zzf(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x03dc:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zze(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x03ea:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zzc(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x03f8:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zzd(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0406:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zzb(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0414:
            com.google.android.gms.internal.measurement.zziq r1 = r12.zzp     // Catch:{ zzif -> 0x059d }
            r2 = r3 & r5
            long r2 = (long) r2     // Catch:{ zzif -> 0x059d }
            java.util.List r1 = r1.zza(r13, r2)     // Catch:{ zzif -> 0x059d }
            r14.zza(r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0422:
            boolean r1 = r12.zza(r13, (int) r2)     // Catch:{ zzif -> 0x059d }
            if (r1 == 0) goto L_0x0440
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x059d }
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzkt.zzf(r13, r3)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzjv r2 = r12.zza((int) r2)     // Catch:{ zzif -> 0x059d }
            java.lang.Object r2 = r14.zzb(r2, r15)     // Catch:{ zzif -> 0x059d }
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzhx.zza((java.lang.Object) r1, (java.lang.Object) r2)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0440:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzjv r1 = r12.zza((int) r2)     // Catch:{ zzif -> 0x059d }
            java.lang.Object r1 = r14.zzb(r1, r15)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0453:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x059d }
            long r5 = r14.zzt()     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0462:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x059d }
            int r1 = r14.zzs()     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0471:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x059d }
            long r5 = r14.zzr()     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0480:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x059d }
            int r1 = r14.zzq()     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x048f:
            int r4 = r14.zzp()     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzic r6 = r12.zzc((int) r2)     // Catch:{ zzif -> 0x059d }
            if (r6 == 0) goto L_0x04a6
            boolean r6 = r6.zza(r4)     // Catch:{ zzif -> 0x059d }
            if (r6 == 0) goto L_0x04a0
            goto L_0x04a6
        L_0x04a0:
            java.lang.Object r10 = com.google.android.gms.internal.measurement.zzjx.zza((int) r1, (int) r4, r10, r7)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x04a6:
            r1 = r3 & r5
            long r5 = (long) r1     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r5, (int) r4)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x04b1:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x059d }
            int r1 = r14.zzo()     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x04c0:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzgm r1 = r14.zzn()     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x04cf:
            boolean r1 = r12.zza(r13, (int) r2)     // Catch:{ zzif -> 0x059d }
            if (r1 == 0) goto L_0x04ed
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x059d }
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzkt.zzf(r13, r3)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzjv r2 = r12.zza((int) r2)     // Catch:{ zzif -> 0x059d }
            java.lang.Object r2 = r14.zza(r2, r15)     // Catch:{ zzif -> 0x059d }
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzhx.zza((java.lang.Object) r1, (java.lang.Object) r2)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x04ed:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzjv r1 = r12.zza((int) r2)     // Catch:{ zzif -> 0x059d }
            java.lang.Object r1 = r14.zza(r1, r15)     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (java.lang.Object) r1)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0500:
            r12.zza((java.lang.Object) r13, (int) r3, (com.google.android.gms.internal.measurement.zzjw) r14)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0508:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x059d }
            boolean r1 = r14.zzk()     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (boolean) r1)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0517:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x059d }
            int r1 = r14.zzj()     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0526:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x059d }
            long r5 = r14.zzi()     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0535:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x059d }
            int r1 = r14.zzh()     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (int) r1)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0544:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x059d }
            long r5 = r14.zzf()     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0553:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x059d }
            long r5 = r14.zzg()     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (long) r5)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0562:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x059d }
            float r1 = r14.zze()     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (float) r1)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0571:
            r1 = r3 & r5
            long r3 = (long) r1     // Catch:{ zzif -> 0x059d }
            double r5 = r14.zzd()     // Catch:{ zzif -> 0x059d }
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r13, (long) r3, (double) r5)     // Catch:{ zzif -> 0x059d }
            r12.zzb(r13, (int) r2)     // Catch:{ zzif -> 0x059d }
            goto L_0x0009
        L_0x0580:
            boolean r1 = r7.zza(r10, (com.google.android.gms.internal.measurement.zzjw) r14)     // Catch:{ zzif -> 0x059d }
            if (r1 != 0) goto L_0x0009
            int r14 = r12.zzm
        L_0x0588:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x0597
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x0588
        L_0x0597:
            if (r10 == 0) goto L_0x059c
            r7.zzb((java.lang.Object) r13, r10)
        L_0x059c:
            return
        L_0x059d:
            r7.zza((com.google.android.gms.internal.measurement.zzjw) r14)     // Catch:{ all -> 0x05c4 }
            if (r10 != 0) goto L_0x05a7
            java.lang.Object r1 = r7.zzc(r13)     // Catch:{ all -> 0x05c4 }
            r10 = r1
        L_0x05a7:
            boolean r1 = r7.zza(r10, (com.google.android.gms.internal.measurement.zzjw) r14)     // Catch:{ all -> 0x05c4 }
            if (r1 != 0) goto L_0x0009
            int r14 = r12.zzm
        L_0x05af:
            int r15 = r12.zzn
            if (r14 >= r15) goto L_0x05be
            int[] r15 = r12.zzl
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r15, r10, r7)
            int r14 = r14 + 1
            goto L_0x05af
        L_0x05be:
            if (r10 == 0) goto L_0x05c3
            r7.zzb((java.lang.Object) r13, r10)
        L_0x05c3:
            return
        L_0x05c4:
            r14 = move-exception
            int r15 = r12.zzm
        L_0x05c7:
            int r0 = r12.zzn
            if (r15 >= r0) goto L_0x05d6
            int[] r0 = r12.zzl
            r0 = r0[r15]
            java.lang.Object r10 = r12.zza((java.lang.Object) r13, (int) r0, r10, r7)
            int r15 = r15 + 1
            goto L_0x05c7
        L_0x05d6:
            if (r10 == 0) goto L_0x05db
            r7.zzb((java.lang.Object) r13, r10)
        L_0x05db:
            throw r14
        L_0x05dc:
            java.lang.NullPointerException r13 = new java.lang.NullPointerException
            r13.<init>()
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zza(java.lang.Object, com.google.android.gms.internal.measurement.zzjw, com.google.android.gms.internal.measurement.zzhi):void");
    }

    private static zzkq zze(Object obj) {
        zzhv zzhv = (zzhv) obj;
        zzkq zzkq = zzhv.zzb;
        if (zzkq != zzkq.zza()) {
            return zzkq;
        }
        zzkq zzb2 = zzkq.zzb();
        zzhv.zzb = zzb2;
        return zzb2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return r2 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return r2 + 8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zza(byte[] r1, int r2, int r3, com.google.android.gms.internal.measurement.zzle r4, java.lang.Class<?> r5, com.google.android.gms.internal.measurement.zzgl r6) throws java.io.IOException {
        /*
            int[] r0 = com.google.android.gms.internal.measurement.zzjj.zza
            int r4 = r4.ordinal()
            r4 = r0[r4]
            switch(r4) {
                case 1: goto L_0x0099;
                case 2: goto L_0x0094;
                case 3: goto L_0x0087;
                case 4: goto L_0x007a;
                case 5: goto L_0x007a;
                case 6: goto L_0x006f;
                case 7: goto L_0x006f;
                case 8: goto L_0x0064;
                case 9: goto L_0x0057;
                case 10: goto L_0x0057;
                case 11: goto L_0x0057;
                case 12: goto L_0x004a;
                case 13: goto L_0x004a;
                case 14: goto L_0x003d;
                case 15: goto L_0x002b;
                case 16: goto L_0x0019;
                case 17: goto L_0x0013;
                default: goto L_0x000b;
            }
        L_0x000b:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "unsupported field type."
            r1.<init>(r2)
            throw r1
        L_0x0013:
            int r1 = com.google.android.gms.internal.measurement.zzgi.zzd(r1, r2, r6)
            goto L_0x00ae
        L_0x0019:
            int r1 = com.google.android.gms.internal.measurement.zzgi.zzb(r1, r2, r6)
            long r2 = r6.zzb
            long r2 = com.google.android.gms.internal.measurement.zzgy.zza((long) r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r6.zzc = r2
            goto L_0x00ae
        L_0x002b:
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r1, r2, r6)
            int r2 = r6.zza
            int r2 = com.google.android.gms.internal.measurement.zzgy.zze(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.zzc = r2
            goto L_0x00ae
        L_0x003d:
            com.google.android.gms.internal.measurement.zzjr r4 = com.google.android.gms.internal.measurement.zzjr.zza()
            com.google.android.gms.internal.measurement.zzjv r4 = r4.zza(r5)
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza((com.google.android.gms.internal.measurement.zzjv) r4, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzgl) r6)
            goto L_0x00ae
        L_0x004a:
            int r1 = com.google.android.gms.internal.measurement.zzgi.zzb(r1, r2, r6)
            long r2 = r6.zzb
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r6.zzc = r2
            goto L_0x00ae
        L_0x0057:
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r1, r2, r6)
            int r2 = r6.zza
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r6.zzc = r2
            goto L_0x00ae
        L_0x0064:
            float r1 = com.google.android.gms.internal.measurement.zzgi.zzd(r1, r2)
            java.lang.Float r1 = java.lang.Float.valueOf(r1)
            r6.zzc = r1
            goto L_0x0084
        L_0x006f:
            long r3 = com.google.android.gms.internal.measurement.zzgi.zzb(r1, r2)
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r6.zzc = r1
            goto L_0x0091
        L_0x007a:
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r1, r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r6.zzc = r1
        L_0x0084:
            int r1 = r2 + 4
            goto L_0x00ae
        L_0x0087:
            double r3 = com.google.android.gms.internal.measurement.zzgi.zzc(r1, r2)
            java.lang.Double r1 = java.lang.Double.valueOf(r3)
            r6.zzc = r1
        L_0x0091:
            int r1 = r2 + 8
            goto L_0x00ae
        L_0x0094:
            int r1 = com.google.android.gms.internal.measurement.zzgi.zze(r1, r2, r6)
            goto L_0x00ae
        L_0x0099:
            int r1 = com.google.android.gms.internal.measurement.zzgi.zzb(r1, r2, r6)
            long r2 = r6.zzb
            r4 = 0
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L_0x00a7
            r2 = 1
            goto L_0x00a8
        L_0x00a7:
            r2 = 0
        L_0x00a8:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            r6.zzc = r2
        L_0x00ae:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zza(byte[], int, int, com.google.android.gms.internal.measurement.zzle, java.lang.Class, com.google.android.gms.internal.measurement.zzgl):int");
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0422 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01eb  */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.android.gms.internal.measurement.zzgl r30) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r2 = r21
            r6 = r23
            r8 = r24
            r9 = r28
            r7 = r30
            sun.misc.Unsafe r11 = zzb
            java.lang.Object r11 = r11.getObject(r1, r9)
            com.google.android.gms.internal.measurement.zzid r11 = (com.google.android.gms.internal.measurement.zzid) r11
            boolean r12 = r11.zza()
            r13 = 1
            if (r12 != 0) goto L_0x0036
            int r12 = r11.size()
            if (r12 != 0) goto L_0x002c
            r12 = 10
            goto L_0x002d
        L_0x002c:
            int r12 = r12 << r13
        L_0x002d:
            com.google.android.gms.internal.measurement.zzid r11 = r11.zza(r12)
            sun.misc.Unsafe r12 = zzb
            r12.putObject(r1, r9, r11)
        L_0x0036:
            r9 = 5
            r14 = 0
            r10 = 2
            switch(r27) {
                case 18: goto L_0x03e4;
                case 19: goto L_0x03a6;
                case 20: goto L_0x0365;
                case 21: goto L_0x0365;
                case 22: goto L_0x034b;
                case 23: goto L_0x030c;
                case 24: goto L_0x02cd;
                case 25: goto L_0x0276;
                case 26: goto L_0x01c3;
                case 27: goto L_0x01a9;
                case 28: goto L_0x0151;
                case 29: goto L_0x034b;
                case 30: goto L_0x0119;
                case 31: goto L_0x02cd;
                case 32: goto L_0x030c;
                case 33: goto L_0x00cc;
                case 34: goto L_0x007f;
                case 35: goto L_0x03e4;
                case 36: goto L_0x03a6;
                case 37: goto L_0x0365;
                case 38: goto L_0x0365;
                case 39: goto L_0x034b;
                case 40: goto L_0x030c;
                case 41: goto L_0x02cd;
                case 42: goto L_0x0276;
                case 43: goto L_0x034b;
                case 44: goto L_0x0119;
                case 45: goto L_0x02cd;
                case 46: goto L_0x030c;
                case 47: goto L_0x00cc;
                case 48: goto L_0x007f;
                case 49: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x0422
        L_0x003f:
            r1 = 3
            if (r6 != r1) goto L_0x0422
            com.google.android.gms.internal.measurement.zzjv r1 = r0.zza((int) r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r22 = r1
            r23 = r18
            r24 = r19
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza((com.google.android.gms.internal.measurement.zzjv) r22, (byte[]) r23, (int) r24, (int) r25, (int) r26, (com.google.android.gms.internal.measurement.zzgl) r27)
            java.lang.Object r8 = r7.zzc
            r11.add(r8)
        L_0x005f:
            if (r4 >= r5) goto L_0x0422
            int r8 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r9 = r7.zza
            if (r2 != r9) goto L_0x0422
            r22 = r1
            r23 = r18
            r24 = r8
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza((com.google.android.gms.internal.measurement.zzjv) r22, (byte[]) r23, (int) r24, (int) r25, (int) r26, (com.google.android.gms.internal.measurement.zzgl) r27)
            java.lang.Object r8 = r7.zzc
            r11.add(r8)
            goto L_0x005f
        L_0x007f:
            if (r6 != r10) goto L_0x00a3
            com.google.android.gms.internal.measurement.zziu r11 = (com.google.android.gms.internal.measurement.zziu) r11
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x008a:
            if (r1 >= r2) goto L_0x009a
            int r1 = com.google.android.gms.internal.measurement.zzgi.zzb(r3, r1, r7)
            long r4 = r7.zzb
            long r4 = com.google.android.gms.internal.measurement.zzgy.zza((long) r4)
            r11.zza((long) r4)
            goto L_0x008a
        L_0x009a:
            if (r1 != r2) goto L_0x009e
            goto L_0x0423
        L_0x009e:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zza()
            throw r1
        L_0x00a3:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.measurement.zziu r11 = (com.google.android.gms.internal.measurement.zziu) r11
            int r1 = com.google.android.gms.internal.measurement.zzgi.zzb(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.measurement.zzgy.zza((long) r8)
            r11.zza((long) r8)
        L_0x00b4:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.measurement.zzgi.zzb(r3, r4, r7)
            long r8 = r7.zzb
            long r8 = com.google.android.gms.internal.measurement.zzgy.zza((long) r8)
            r11.zza((long) r8)
            goto L_0x00b4
        L_0x00cc:
            if (r6 != r10) goto L_0x00f0
            com.google.android.gms.internal.measurement.zzhy r11 = (com.google.android.gms.internal.measurement.zzhy) r11
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x00d7:
            if (r1 >= r2) goto L_0x00e7
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r1, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzgy.zze(r4)
            r11.zzd(r4)
            goto L_0x00d7
        L_0x00e7:
            if (r1 != r2) goto L_0x00eb
            goto L_0x0423
        L_0x00eb:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zza()
            throw r1
        L_0x00f0:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.measurement.zzhy r11 = (com.google.android.gms.internal.measurement.zzhy) r11
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzgy.zze(r4)
            r11.zzd(r4)
        L_0x0101:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r4 = r7.zza
            int r4 = com.google.android.gms.internal.measurement.zzgy.zze(r4)
            r11.zzd(r4)
            goto L_0x0101
        L_0x0119:
            if (r6 != r10) goto L_0x0120
            int r2 = com.google.android.gms.internal.measurement.zzgi.zza((byte[]) r3, (int) r4, (com.google.android.gms.internal.measurement.zzid<?>) r11, (com.google.android.gms.internal.measurement.zzgl) r7)
            goto L_0x0131
        L_0x0120:
            if (r6 != 0) goto L_0x0422
            r2 = r21
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r11
            r7 = r30
            int r2 = com.google.android.gms.internal.measurement.zzgi.zza((int) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzid<?>) r6, (com.google.android.gms.internal.measurement.zzgl) r7)
        L_0x0131:
            com.google.android.gms.internal.measurement.zzhv r1 = (com.google.android.gms.internal.measurement.zzhv) r1
            com.google.android.gms.internal.measurement.zzkq r3 = r1.zzb
            com.google.android.gms.internal.measurement.zzkq r4 = com.google.android.gms.internal.measurement.zzkq.zza()
            if (r3 != r4) goto L_0x013c
            r3 = 0
        L_0x013c:
            com.google.android.gms.internal.measurement.zzic r4 = r0.zzc((int) r8)
            com.google.android.gms.internal.measurement.zzkn<?, ?> r5 = r0.zzq
            r6 = r22
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzjx.zza(r6, r11, r4, r3, r5)
            com.google.android.gms.internal.measurement.zzkq r3 = (com.google.android.gms.internal.measurement.zzkq) r3
            if (r3 == 0) goto L_0x014e
            r1.zzb = r3
        L_0x014e:
            r1 = r2
            goto L_0x0423
        L_0x0151:
            if (r6 != r10) goto L_0x0422
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x01a4
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x019f
            if (r4 != 0) goto L_0x0167
            com.google.android.gms.internal.measurement.zzgm r4 = com.google.android.gms.internal.measurement.zzgm.zza
            r11.add(r4)
            goto L_0x016f
        L_0x0167:
            com.google.android.gms.internal.measurement.zzgm r6 = com.google.android.gms.internal.measurement.zzgm.zza((byte[]) r3, (int) r1, (int) r4)
            r11.add(r6)
        L_0x016e:
            int r1 = r1 + r4
        L_0x016f:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r4 = r7.zza
            if (r4 < 0) goto L_0x019a
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0195
            if (r4 != 0) goto L_0x018d
            com.google.android.gms.internal.measurement.zzgm r4 = com.google.android.gms.internal.measurement.zzgm.zza
            r11.add(r4)
            goto L_0x016f
        L_0x018d:
            com.google.android.gms.internal.measurement.zzgm r6 = com.google.android.gms.internal.measurement.zzgm.zza((byte[]) r3, (int) r1, (int) r4)
            r11.add(r6)
            goto L_0x016e
        L_0x0195:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zza()
            throw r1
        L_0x019a:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zzb()
            throw r1
        L_0x019f:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zza()
            throw r1
        L_0x01a4:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zzb()
            throw r1
        L_0x01a9:
            if (r6 != r10) goto L_0x0422
            com.google.android.gms.internal.measurement.zzjv r1 = r0.zza((int) r8)
            r22 = r1
            r23 = r21
            r24 = r18
            r25 = r19
            r26 = r20
            r27 = r11
            r28 = r30
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r22, r23, r24, r25, r26, r27, r28)
            goto L_0x0423
        L_0x01c3:
            if (r6 != r10) goto L_0x0422
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r25 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 != 0) goto L_0x0216
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x0211
            if (r6 != 0) goto L_0x01de
            r11.add(r1)
            goto L_0x01e9
        L_0x01de:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzhx.zza
            r8.<init>(r3, r4, r6, r9)
            r11.add(r8)
        L_0x01e8:
            int r4 = r4 + r6
        L_0x01e9:
            if (r4 >= r5) goto L_0x0422
            int r6 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0422
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x020c
            if (r6 != 0) goto L_0x0201
            r11.add(r1)
            goto L_0x01e9
        L_0x0201:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.measurement.zzhx.zza
            r8.<init>(r3, r4, r6, r9)
            r11.add(r8)
            goto L_0x01e8
        L_0x020c:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zzb()
            throw r1
        L_0x0211:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zzb()
            throw r1
        L_0x0216:
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x0271
            if (r6 != 0) goto L_0x0224
            r11.add(r1)
            goto L_0x0237
        L_0x0224:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.measurement.zzkw.zza((byte[]) r3, (int) r4, (int) r8)
            if (r9 == 0) goto L_0x026c
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzhx.zza
            r9.<init>(r3, r4, r6, r10)
            r11.add(r9)
        L_0x0236:
            r4 = r8
        L_0x0237:
            if (r4 >= r5) goto L_0x0422
            int r6 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0422
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r6, r7)
            int r6 = r7.zza
            if (r6 < 0) goto L_0x0267
            if (r6 != 0) goto L_0x024f
            r11.add(r1)
            goto L_0x0237
        L_0x024f:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.measurement.zzkw.zza((byte[]) r3, (int) r4, (int) r8)
            if (r9 == 0) goto L_0x0262
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.measurement.zzhx.zza
            r9.<init>(r3, r4, r6, r10)
            r11.add(r9)
            goto L_0x0236
        L_0x0262:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zzh()
            throw r1
        L_0x0267:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zzb()
            throw r1
        L_0x026c:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zzh()
            throw r1
        L_0x0271:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zzb()
            throw r1
        L_0x0276:
            r1 = 0
            if (r6 != r10) goto L_0x029e
            com.google.android.gms.internal.measurement.zzgk r11 = (com.google.android.gms.internal.measurement.zzgk) r11
            int r2 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r4 = r7.zza
            int r4 = r4 + r2
        L_0x0282:
            if (r2 >= r4) goto L_0x0295
            int r2 = com.google.android.gms.internal.measurement.zzgi.zzb(r3, r2, r7)
            long r5 = r7.zzb
            int r8 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x0290
            r5 = 1
            goto L_0x0291
        L_0x0290:
            r5 = 0
        L_0x0291:
            r11.zza((boolean) r5)
            goto L_0x0282
        L_0x0295:
            if (r2 != r4) goto L_0x0299
            goto L_0x014e
        L_0x0299:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zza()
            throw r1
        L_0x029e:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.measurement.zzgk r11 = (com.google.android.gms.internal.measurement.zzgk) r11
            int r4 = com.google.android.gms.internal.measurement.zzgi.zzb(r3, r4, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x02ae
            r6 = 1
            goto L_0x02af
        L_0x02ae:
            r6 = 0
        L_0x02af:
            r11.zza((boolean) r6)
        L_0x02b2:
            if (r4 >= r5) goto L_0x0422
            int r6 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r8 = r7.zza
            if (r2 != r8) goto L_0x0422
            int r4 = com.google.android.gms.internal.measurement.zzgi.zzb(r3, r6, r7)
            long r8 = r7.zzb
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x02c8
            r6 = 1
            goto L_0x02c9
        L_0x02c8:
            r6 = 0
        L_0x02c9:
            r11.zza((boolean) r6)
            goto L_0x02b2
        L_0x02cd:
            if (r6 != r10) goto L_0x02ed
            com.google.android.gms.internal.measurement.zzhy r11 = (com.google.android.gms.internal.measurement.zzhy) r11
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x02d8:
            if (r1 >= r2) goto L_0x02e4
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r1)
            r11.zzd(r4)
            int r1 = r1 + 4
            goto L_0x02d8
        L_0x02e4:
            if (r1 != r2) goto L_0x02e8
            goto L_0x0423
        L_0x02e8:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zza()
            throw r1
        L_0x02ed:
            if (r6 != r9) goto L_0x0422
            com.google.android.gms.internal.measurement.zzhy r11 = (com.google.android.gms.internal.measurement.zzhy) r11
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r18, r19)
            r11.zzd(r1)
        L_0x02f8:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4)
            r11.zzd(r1)
            goto L_0x02f8
        L_0x030c:
            if (r6 != r10) goto L_0x032c
            com.google.android.gms.internal.measurement.zziu r11 = (com.google.android.gms.internal.measurement.zziu) r11
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0317:
            if (r1 >= r2) goto L_0x0323
            long r4 = com.google.android.gms.internal.measurement.zzgi.zzb(r3, r1)
            r11.zza((long) r4)
            int r1 = r1 + 8
            goto L_0x0317
        L_0x0323:
            if (r1 != r2) goto L_0x0327
            goto L_0x0423
        L_0x0327:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zza()
            throw r1
        L_0x032c:
            if (r6 != r13) goto L_0x0422
            com.google.android.gms.internal.measurement.zziu r11 = (com.google.android.gms.internal.measurement.zziu) r11
            long r8 = com.google.android.gms.internal.measurement.zzgi.zzb(r18, r19)
            r11.zza((long) r8)
        L_0x0337:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            long r8 = com.google.android.gms.internal.measurement.zzgi.zzb(r3, r4)
            r11.zza((long) r8)
            goto L_0x0337
        L_0x034b:
            if (r6 != r10) goto L_0x0353
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza((byte[]) r3, (int) r4, (com.google.android.gms.internal.measurement.zzid<?>) r11, (com.google.android.gms.internal.measurement.zzgl) r7)
            goto L_0x0423
        L_0x0353:
            if (r6 != 0) goto L_0x0422
            r22 = r18
            r23 = r19
            r24 = r20
            r25 = r11
            r26 = r30
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza((int) r21, (byte[]) r22, (int) r23, (int) r24, (com.google.android.gms.internal.measurement.zzid<?>) r25, (com.google.android.gms.internal.measurement.zzgl) r26)
            goto L_0x0423
        L_0x0365:
            if (r6 != r10) goto L_0x0385
            com.google.android.gms.internal.measurement.zziu r11 = (com.google.android.gms.internal.measurement.zziu) r11
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x0370:
            if (r1 >= r2) goto L_0x037c
            int r1 = com.google.android.gms.internal.measurement.zzgi.zzb(r3, r1, r7)
            long r4 = r7.zzb
            r11.zza((long) r4)
            goto L_0x0370
        L_0x037c:
            if (r1 != r2) goto L_0x0380
            goto L_0x0423
        L_0x0380:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zza()
            throw r1
        L_0x0385:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.measurement.zziu r11 = (com.google.android.gms.internal.measurement.zziu) r11
            int r1 = com.google.android.gms.internal.measurement.zzgi.zzb(r3, r4, r7)
            long r8 = r7.zzb
            r11.zza((long) r8)
        L_0x0392:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.measurement.zzgi.zzb(r3, r4, r7)
            long r8 = r7.zzb
            r11.zza((long) r8)
            goto L_0x0392
        L_0x03a6:
            if (r6 != r10) goto L_0x03c5
            com.google.android.gms.internal.measurement.zzhu r11 = (com.google.android.gms.internal.measurement.zzhu) r11
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03b1:
            if (r1 >= r2) goto L_0x03bd
            float r4 = com.google.android.gms.internal.measurement.zzgi.zzd(r3, r1)
            r11.zza((float) r4)
            int r1 = r1 + 4
            goto L_0x03b1
        L_0x03bd:
            if (r1 != r2) goto L_0x03c0
            goto L_0x0423
        L_0x03c0:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zza()
            throw r1
        L_0x03c5:
            if (r6 != r9) goto L_0x0422
            com.google.android.gms.internal.measurement.zzhu r11 = (com.google.android.gms.internal.measurement.zzhu) r11
            float r1 = com.google.android.gms.internal.measurement.zzgi.zzd(r18, r19)
            r11.zza((float) r1)
        L_0x03d0:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            float r1 = com.google.android.gms.internal.measurement.zzgi.zzd(r3, r4)
            r11.zza((float) r1)
            goto L_0x03d0
        L_0x03e4:
            if (r6 != r10) goto L_0x0403
            com.google.android.gms.internal.measurement.zzhg r11 = (com.google.android.gms.internal.measurement.zzhg) r11
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r7)
            int r2 = r7.zza
            int r2 = r2 + r1
        L_0x03ef:
            if (r1 >= r2) goto L_0x03fb
            double r4 = com.google.android.gms.internal.measurement.zzgi.zzc(r3, r1)
            r11.zza((double) r4)
            int r1 = r1 + 8
            goto L_0x03ef
        L_0x03fb:
            if (r1 != r2) goto L_0x03fe
            goto L_0x0423
        L_0x03fe:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zza()
            throw r1
        L_0x0403:
            if (r6 != r13) goto L_0x0422
            com.google.android.gms.internal.measurement.zzhg r11 = (com.google.android.gms.internal.measurement.zzhg) r11
            double r8 = com.google.android.gms.internal.measurement.zzgi.zzc(r18, r19)
            r11.zza((double) r8)
        L_0x040e:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r1, r7)
            int r6 = r7.zza
            if (r2 != r6) goto L_0x0423
            double r8 = com.google.android.gms.internal.measurement.zzgi.zzc(r3, r4)
            r11.zza((double) r8)
            goto L_0x040e
        L_0x0422:
            r1 = r4
        L_0x0423:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.measurement.zzgl):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <K, V> int zza(T r8, byte[] r9, int r10, int r11, int r12, long r13, com.google.android.gms.internal.measurement.zzgl r15) throws java.io.IOException {
        /*
            r7 = this;
            sun.misc.Unsafe r0 = zzb
            java.lang.Object r12 = r7.zzb((int) r12)
            java.lang.Object r1 = r0.getObject(r8, r13)
            com.google.android.gms.internal.measurement.zziz r2 = r7.zzs
            boolean r2 = r2.zzc(r1)
            if (r2 == 0) goto L_0x0021
            com.google.android.gms.internal.measurement.zziz r2 = r7.zzs
            java.lang.Object r2 = r2.zze(r12)
            com.google.android.gms.internal.measurement.zziz r3 = r7.zzs
            r3.zza(r2, r1)
            r0.putObject(r8, r13, r2)
            r1 = r2
        L_0x0021:
            com.google.android.gms.internal.measurement.zziz r8 = r7.zzs
            com.google.android.gms.internal.measurement.zzix r8 = r8.zzf(r12)
            com.google.android.gms.internal.measurement.zziz r12 = r7.zzs
            java.util.Map r12 = r12.zza(r1)
            int r10 = com.google.android.gms.internal.measurement.zzgi.zza(r9, r10, r15)
            int r13 = r15.zza
            if (r13 < 0) goto L_0x0097
            int r14 = r11 - r10
            if (r13 > r14) goto L_0x0097
            int r13 = r13 + r10
            K r14 = r8.zzb
            V r0 = r8.zzd
        L_0x003e:
            if (r10 >= r13) goto L_0x008c
            int r1 = r10 + 1
            byte r10 = r9[r10]
            if (r10 >= 0) goto L_0x004c
            int r1 = com.google.android.gms.internal.measurement.zzgi.zza((int) r10, (byte[]) r9, (int) r1, (com.google.android.gms.internal.measurement.zzgl) r15)
            int r10 = r15.zza
        L_0x004c:
            r2 = r1
            int r1 = r10 >>> 3
            r3 = r10 & 7
            r4 = 1
            if (r1 == r4) goto L_0x0072
            r4 = 2
            if (r1 == r4) goto L_0x0058
            goto L_0x0087
        L_0x0058:
            com.google.android.gms.internal.measurement.zzle r1 = r8.zzc
            int r1 = r1.zzb()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.measurement.zzle r4 = r8.zzc
            V r10 = r8.zzd
            java.lang.Class r5 = r10.getClass()
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzle) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.measurement.zzgl) r6)
            java.lang.Object r0 = r15.zzc
            goto L_0x003e
        L_0x0072:
            com.google.android.gms.internal.measurement.zzle r1 = r8.zza
            int r1 = r1.zzb()
            if (r3 != r1) goto L_0x0087
            com.google.android.gms.internal.measurement.zzle r4 = r8.zza
            r5 = 0
            r1 = r9
            r3 = r11
            r6 = r15
            int r10 = zza((byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzle) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.measurement.zzgl) r6)
            java.lang.Object r14 = r15.zzc
            goto L_0x003e
        L_0x0087:
            int r10 = com.google.android.gms.internal.measurement.zzgi.zza((int) r10, (byte[]) r9, (int) r2, (int) r11, (com.google.android.gms.internal.measurement.zzgl) r15)
            goto L_0x003e
        L_0x008c:
            if (r10 != r13) goto L_0x0092
            r12.put(r14, r0)
            return r13
        L_0x0092:
            com.google.android.gms.internal.measurement.zzig r8 = com.google.android.gms.internal.measurement.zzig.zzg()
            throw r8
        L_0x0097:
            com.google.android.gms.internal.measurement.zzig r8 = com.google.android.gms.internal.measurement.zzig.zza()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zza(java.lang.Object, byte[], int, int, int, long, com.google.android.gms.internal.measurement.zzgl):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x018a, code lost:
        r2 = r4 + 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x019b, code lost:
        r2 = r4 + 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x019d, code lost:
        r12.putInt(r1, r13, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, int r25, long r26, int r28, com.google.android.gms.internal.measurement.zzgl r29) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r2 = r21
            r8 = r22
            r5 = r23
            r9 = r26
            r6 = r28
            r11 = r29
            sun.misc.Unsafe r12 = zzb
            int[] r7 = r0.zzc
            int r13 = r6 + 2
            r7 = r7[r13]
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r7 & r13
            long r13 = (long) r7
            r7 = 5
            r15 = 2
            switch(r25) {
                case 51: goto L_0x018d;
                case 52: goto L_0x017d;
                case 53: goto L_0x016d;
                case 54: goto L_0x016d;
                case 55: goto L_0x015d;
                case 56: goto L_0x014e;
                case 57: goto L_0x0140;
                case 58: goto L_0x0127;
                case 59: goto L_0x00f3;
                case 60: goto L_0x00c5;
                case 61: goto L_0x00b8;
                case 62: goto L_0x015d;
                case 63: goto L_0x008a;
                case 64: goto L_0x0140;
                case 65: goto L_0x014e;
                case 66: goto L_0x0075;
                case 67: goto L_0x0060;
                case 68: goto L_0x0028;
                default: goto L_0x0026;
            }
        L_0x0026:
            goto L_0x01a1
        L_0x0028:
            r7 = 3
            if (r5 != r7) goto L_0x01a1
            r2 = r2 & -8
            r7 = r2 | 4
            com.google.android.gms.internal.measurement.zzjv r2 = r0.zza((int) r6)
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r7
            r7 = r29
            int r2 = com.google.android.gms.internal.measurement.zzgi.zza((com.google.android.gms.internal.measurement.zzjv) r2, (byte[]) r3, (int) r4, (int) r5, (int) r6, (com.google.android.gms.internal.measurement.zzgl) r7)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x004b
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x004c
        L_0x004b:
            r15 = 0
        L_0x004c:
            if (r15 != 0) goto L_0x0055
            java.lang.Object r3 = r11.zzc
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0055:
            java.lang.Object r3 = r11.zzc
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzhx.zza((java.lang.Object) r15, (java.lang.Object) r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0060:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzgi.zzb(r3, r4, r11)
            long r3 = r11.zzb
            long r3 = com.google.android.gms.internal.measurement.zzgy.zza((long) r3)
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0075:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r11)
            int r3 = r11.zza
            int r3 = com.google.android.gms.internal.measurement.zzgy.zze(r3)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x008a:
            if (r5 != 0) goto L_0x01a1
            int r3 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r11)
            int r4 = r11.zza
            com.google.android.gms.internal.measurement.zzic r5 = r0.zzc((int) r6)
            if (r5 == 0) goto L_0x00ae
            boolean r5 = r5.zza(r4)
            if (r5 == 0) goto L_0x009f
            goto L_0x00ae
        L_0x009f:
            com.google.android.gms.internal.measurement.zzkq r1 = zze((java.lang.Object) r17)
            long r4 = (long) r4
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r1.zza((int) r2, (java.lang.Object) r4)
            r2 = r3
            goto L_0x01a2
        L_0x00ae:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r12.putObject(r1, r9, r2)
            r2 = r3
            goto L_0x019d
        L_0x00b8:
            if (r5 != r15) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzgi.zze(r3, r4, r11)
            java.lang.Object r3 = r11.zzc
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x00c5:
            if (r5 != r15) goto L_0x01a1
            com.google.android.gms.internal.measurement.zzjv r2 = r0.zza((int) r6)
            r5 = r20
            int r2 = com.google.android.gms.internal.measurement.zzgi.zza((com.google.android.gms.internal.measurement.zzjv) r2, (byte[]) r3, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzgl) r11)
            int r3 = r12.getInt(r1, r13)
            if (r3 != r8) goto L_0x00dc
            java.lang.Object r15 = r12.getObject(r1, r9)
            goto L_0x00dd
        L_0x00dc:
            r15 = 0
        L_0x00dd:
            if (r15 != 0) goto L_0x00e5
            java.lang.Object r3 = r11.zzc
            r12.putObject(r1, r9, r3)
            goto L_0x00ee
        L_0x00e5:
            java.lang.Object r3 = r11.zzc
            java.lang.Object r3 = com.google.android.gms.internal.measurement.zzhx.zza((java.lang.Object) r15, (java.lang.Object) r3)
            r12.putObject(r1, r9, r3)
        L_0x00ee:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x00f3:
            if (r5 != r15) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r11)
            int r4 = r11.zza
            if (r4 != 0) goto L_0x0103
            java.lang.String r3 = ""
            r12.putObject(r1, r9, r3)
            goto L_0x0122
        L_0x0103:
            r5 = 536870912(0x20000000, float:1.0842022E-19)
            r5 = r24 & r5
            if (r5 == 0) goto L_0x0117
            int r5 = r2 + r4
            boolean r5 = com.google.android.gms.internal.measurement.zzkw.zza((byte[]) r3, (int) r2, (int) r5)
            if (r5 == 0) goto L_0x0112
            goto L_0x0117
        L_0x0112:
            com.google.android.gms.internal.measurement.zzig r1 = com.google.android.gms.internal.measurement.zzig.zzh()
            throw r1
        L_0x0117:
            java.lang.String r5 = new java.lang.String
            java.nio.charset.Charset r6 = com.google.android.gms.internal.measurement.zzhx.zza
            r5.<init>(r3, r2, r4, r6)
            r12.putObject(r1, r9, r5)
            int r2 = r2 + r4
        L_0x0122:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x0127:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzgi.zzb(r3, r4, r11)
            long r3 = r11.zzb
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0137
            r15 = 1
            goto L_0x0138
        L_0x0137:
            r15 = 0
        L_0x0138:
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r15)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x0140:
            if (r5 != r7) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzgi.zza(r18, r19)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r12.putObject(r1, r9, r2)
            goto L_0x018a
        L_0x014e:
            r2 = 1
            if (r5 != r2) goto L_0x01a1
            long r2 = com.google.android.gms.internal.measurement.zzgi.zzb(r18, r19)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r12.putObject(r1, r9, r2)
            goto L_0x019b
        L_0x015d:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzgi.zza(r3, r4, r11)
            int r3 = r11.zza
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x016d:
            if (r5 != 0) goto L_0x01a1
            int r2 = com.google.android.gms.internal.measurement.zzgi.zzb(r3, r4, r11)
            long r3 = r11.zzb
            java.lang.Long r3 = java.lang.Long.valueOf(r3)
            r12.putObject(r1, r9, r3)
            goto L_0x019d
        L_0x017d:
            if (r5 != r7) goto L_0x01a1
            float r2 = com.google.android.gms.internal.measurement.zzgi.zzd(r18, r19)
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            r12.putObject(r1, r9, r2)
        L_0x018a:
            int r2 = r4 + 4
            goto L_0x019d
        L_0x018d:
            r2 = 1
            if (r5 != r2) goto L_0x01a1
            double r2 = com.google.android.gms.internal.measurement.zzgi.zzc(r18, r19)
            java.lang.Double r2 = java.lang.Double.valueOf(r2)
            r12.putObject(r1, r9, r2)
        L_0x019b:
            int r2 = r4 + 8
        L_0x019d:
            r12.putInt(r1, r13, r8)
            goto L_0x01a2
        L_0x01a1:
            r2 = r4
        L_0x01a2:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zza(java.lang.Object, byte[], int, int, int, int, int, int, int, long, int, com.google.android.gms.internal.measurement.zzgl):int");
    }

    private final zzjv zza(int i) {
        int i2 = (i / 3) << 1;
        zzjv zzjv = (zzjv) this.zzd[i2];
        if (zzjv != null) {
            return zzjv;
        }
        zzjv zza2 = zzjr.zza().zza((Class) this.zzd[i2 + 1]);
        this.zzd[i2] = zza2;
        return zza2;
    }

    private final Object zzb(int i) {
        return this.zzd[(i / 3) << 1];
    }

    private final zzic zzc(int i) {
        return (zzic) this.zzd[((i / 3) << 1) + 1];
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v7, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r19v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v12, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v13, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v14, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v15, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v19, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v20, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v21, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v22, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v23, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v26, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v28, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v25, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v29, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v31, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v16, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v32, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v17, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v27, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v40, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v33, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v18, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v30, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v41, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v42, resolved type: byte} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x03c0, code lost:
        if (r0 == r15) goto L_0x0427;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0403, code lost:
        if (r0 == r15) goto L_0x0427;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x025c, code lost:
        r5 = r6 | r22;
        r6 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x0260, code lost:
        r3 = r8;
        r1 = r9;
        r9 = r13;
        r13 = r2;
        r2 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x02ce, code lost:
        r5 = r6 | r22;
        r6 = r30;
        r0 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x030c, code lost:
        r5 = r6 | r22;
        r6 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0310, code lost:
        r3 = r8;
        r1 = r9;
        r2 = r11;
        r9 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0314, code lost:
        r13 = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0316, code lost:
        r11 = r32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x031a, code lost:
        r23 = r30;
        r2 = r3;
        r22 = r6;
        r7 = r8;
        r30 = r9;
        r26 = r10;
        r17 = r11;
        r6 = r32;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x042d A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0444  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0488  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(T r28, byte[] r29, int r30, int r31, int r32, com.google.android.gms.internal.measurement.zzgl r33) throws java.io.IOException {
        /*
            r27 = this;
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r33
            sun.misc.Unsafe r10 = zzb
            r16 = 0
            r0 = r30
            r1 = -1
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0019:
            if (r0 >= r13) goto L_0x04c6
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002a
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.measurement.zzgl) r9)
            int r3 = r9.zza
            r4 = r3
            r3 = r0
            goto L_0x002b
        L_0x002a:
            r4 = r0
        L_0x002b:
            int r0 = r4 >>> 3
            r7 = r4 & 7
            r8 = 3
            if (r0 <= r1) goto L_0x0038
            int r2 = r2 / r8
            int r1 = r15.zza((int) r0, (int) r2)
            goto L_0x003c
        L_0x0038:
            int r1 = r15.zzg(r0)
        L_0x003c:
            r2 = r1
            r1 = -1
            if (r2 != r1) goto L_0x0051
            r30 = r0
            r2 = r3
            r7 = r4
            r22 = r5
            r23 = r6
            r26 = r10
            r6 = r11
            r17 = 0
            r18 = -1
            goto L_0x042b
        L_0x0051:
            int[] r1 = r15.zzc
            int r19 = r2 + 1
            r8 = r1[r19]
            r19 = 267386880(0xff00000, float:2.3665827E-29)
            r19 = r8 & r19
            int r11 = r19 >>> 20
            r19 = r4
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r8 & r17
            long r12 = (long) r4
            r4 = 17
            r20 = r8
            if (r11 > r4) goto L_0x032a
            int r4 = r2 + 2
            r1 = r1[r4]
            int r4 = r1 >>> 20
            r8 = 1
            int r22 = r8 << r4
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r4
            if (r1 == r6) goto L_0x0087
            if (r6 == r4) goto L_0x0080
            long r8 = (long) r6
            r10.putInt(r14, r8, r5)
        L_0x0080:
            long r5 = (long) r1
            int r5 = r10.getInt(r14, r5)
            r8 = r1
            goto L_0x0088
        L_0x0087:
            r8 = r6
        L_0x0088:
            r6 = r5
            r1 = 5
            switch(r11) {
                case 0: goto L_0x02f0;
                case 1: goto L_0x02d4;
                case 2: goto L_0x02ab;
                case 3: goto L_0x02ab;
                case 4: goto L_0x028e;
                case 5: goto L_0x0267;
                case 6: goto L_0x023f;
                case 7: goto L_0x0212;
                case 8: goto L_0x01e8;
                case 9: goto L_0x01ad;
                case 10: goto L_0x018f;
                case 11: goto L_0x028e;
                case 12: goto L_0x0150;
                case 13: goto L_0x023f;
                case 14: goto L_0x0267;
                case 15: goto L_0x012f;
                case 16: goto L_0x00fb;
                case 17: goto L_0x009e;
                default: goto L_0x008d;
            }
        L_0x008d:
            r12 = r29
            r13 = r33
            r9 = r0
            r11 = r2
            r30 = r8
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x031a
        L_0x009e:
            r5 = 3
            if (r7 != r5) goto L_0x00e9
            int r1 = r0 << 3
            r5 = r1 | 4
            com.google.android.gms.internal.measurement.zzjv r1 = r15.zza((int) r2)
            r9 = r0
            r0 = r1
            r18 = -1
            r1 = r29
            r11 = r2
            r2 = r3
            r3 = r31
            r7 = r19
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r5
            r5 = r33
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza((com.google.android.gms.internal.measurement.zzjv) r0, (byte[]) r1, (int) r2, (int) r3, (int) r4, (com.google.android.gms.internal.measurement.zzgl) r5)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x00cb
            r4 = r33
            java.lang.Object r1 = r4.zzc
            r10.putObject(r14, r12, r1)
            goto L_0x00da
        L_0x00cb:
            r4 = r33
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r4.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzhx.zza((java.lang.Object) r1, (java.lang.Object) r2)
            r10.putObject(r14, r12, r1)
        L_0x00da:
            r5 = r6 | r22
            r12 = r29
            r13 = r31
            r3 = r7
            r6 = r8
            r1 = r9
            r2 = r11
            r11 = r32
            r9 = r4
            goto L_0x0019
        L_0x00e9:
            r9 = r0
            r11 = r2
            r7 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            r30 = r8
            r8 = r7
            goto L_0x031a
        L_0x00fb:
            r4 = r33
            r9 = r0
            r11 = r2
            r5 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x0127
            r1 = r12
            r12 = r29
            int r7 = com.google.android.gms.internal.measurement.zzgi.zzb(r12, r3, r4)
            r20 = r1
            long r0 = r4.zzb
            long r23 = com.google.android.gms.internal.measurement.zzgy.zza((long) r0)
            r0 = r10
            r2 = r20
            r1 = r28
            r13 = r4
            r30 = r8
            r8 = r5
            r4 = r23
            r0.putLong(r1, r2, r4)
            goto L_0x02ce
        L_0x0127:
            r12 = r29
            r13 = r4
            r30 = r8
            r8 = r5
            goto L_0x031a
        L_0x012f:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != 0) goto L_0x031a
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza(r12, r3, r13)
            int r1 = r13.zza
            int r1 = com.google.android.gms.internal.measurement.zzgy.zze(r1)
            r10.putInt(r14, r4, r1)
            goto L_0x030c
        L_0x0150:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != 0) goto L_0x031a
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza(r12, r3, r13)
            int r1 = r13.zza
            com.google.android.gms.internal.measurement.zzic r2 = r15.zzc((int) r11)
            if (r2 == 0) goto L_0x018a
            boolean r2 = r2.zza(r1)
            if (r2 == 0) goto L_0x0175
            goto L_0x018a
        L_0x0175:
            com.google.android.gms.internal.measurement.zzkq r2 = zze((java.lang.Object) r28)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zza((int) r8, (java.lang.Object) r1)
            r5 = r6
            r3 = r8
            r1 = r9
            r2 = r11
            r9 = r13
            r6 = r30
            goto L_0x0314
        L_0x018a:
            r10.putInt(r14, r4, r1)
            goto L_0x030c
        L_0x018f:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r0 = 2
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != r0) goto L_0x031a
            int r0 = com.google.android.gms.internal.measurement.zzgi.zze(r12, r3, r13)
            java.lang.Object r1 = r13.zzc
            r10.putObject(r14, r4, r1)
            goto L_0x030c
        L_0x01ad:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r0 = 2
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != r0) goto L_0x01e4
            com.google.android.gms.internal.measurement.zzjv r0 = r15.zza((int) r11)
            r2 = r31
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza((com.google.android.gms.internal.measurement.zzjv) r0, (byte[]) r12, (int) r3, (int) r2, (com.google.android.gms.internal.measurement.zzgl) r13)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x01d5
            java.lang.Object r1 = r13.zzc
            r10.putObject(r14, r4, r1)
            goto L_0x025c
        L_0x01d5:
            java.lang.Object r1 = r10.getObject(r14, r4)
            java.lang.Object r3 = r13.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzhx.zza((java.lang.Object) r1, (java.lang.Object) r3)
            r10.putObject(r14, r4, r1)
            goto L_0x025c
        L_0x01e4:
            r2 = r31
            goto L_0x031a
        L_0x01e8:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r0 = 2
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r2 = r31
            r13 = r33
            if (r7 != r0) goto L_0x031a
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r20 & r0
            if (r0 != 0) goto L_0x0208
            int r0 = com.google.android.gms.internal.measurement.zzgi.zzc(r12, r3, r13)
            goto L_0x020c
        L_0x0208:
            int r0 = com.google.android.gms.internal.measurement.zzgi.zzd(r12, r3, r13)
        L_0x020c:
            java.lang.Object r1 = r13.zzc
            r10.putObject(r14, r4, r1)
            goto L_0x025c
        L_0x0212:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r2 = r31
            r13 = r33
            if (r7 != 0) goto L_0x031a
            int r0 = com.google.android.gms.internal.measurement.zzgi.zzb(r12, r3, r13)
            r3 = r0
            long r0 = r13.zzb
            r20 = 0
            int r7 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r7 == 0) goto L_0x0235
            r0 = 1
            goto L_0x0236
        L_0x0235:
            r0 = 0
        L_0x0236:
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r4, (boolean) r0)
            r5 = r6 | r22
            r6 = r30
            r0 = r3
            goto L_0x0260
        L_0x023f:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r2 = r31
            r13 = r33
            if (r7 != r1) goto L_0x031a
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza(r12, r3)
            r10.putInt(r14, r4, r0)
            int r0 = r3 + 4
        L_0x025c:
            r5 = r6 | r22
            r6 = r30
        L_0x0260:
            r3 = r8
            r1 = r9
            r9 = r13
            r13 = r2
            r2 = r11
            goto L_0x0316
        L_0x0267:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r0 = 1
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r2 = r31
            r13 = r33
            if (r7 != r0) goto L_0x031a
            long r20 = com.google.android.gms.internal.measurement.zzgi.zzb(r12, r3)
            r0 = r10
            r1 = r28
            r7 = r3
            r2 = r4
            r4 = r20
            r0.putLong(r1, r2, r4)
            int r0 = r7 + 8
            goto L_0x030c
        L_0x028e:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != 0) goto L_0x031a
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza(r12, r3, r13)
            int r1 = r13.zza
            r10.putInt(r14, r4, r1)
            goto L_0x030c
        L_0x02ab:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != 0) goto L_0x031a
            int r7 = com.google.android.gms.internal.measurement.zzgi.zzb(r12, r3, r13)
            long r2 = r13.zzb
            r0 = r10
            r1 = r28
            r20 = r2
            r2 = r4
            r4 = r20
            r0.putLong(r1, r2, r4)
        L_0x02ce:
            r5 = r6 | r22
            r6 = r30
            r0 = r7
            goto L_0x0310
        L_0x02d4:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != r1) goto L_0x031a
            float r0 = com.google.android.gms.internal.measurement.zzgi.zzd(r12, r3)
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r4, (float) r0)
            int r0 = r3 + 4
            goto L_0x030c
        L_0x02f0:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r0 = 1
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != r0) goto L_0x031a
            double r0 = com.google.android.gms.internal.measurement.zzgi.zzc(r12, r3)
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r4, (double) r0)
            int r0 = r3 + 8
        L_0x030c:
            r5 = r6 | r22
            r6 = r30
        L_0x0310:
            r3 = r8
            r1 = r9
            r2 = r11
            r9 = r13
        L_0x0314:
            r13 = r31
        L_0x0316:
            r11 = r32
            goto L_0x0019
        L_0x031a:
            r23 = r30
            r2 = r3
            r22 = r6
            r7 = r8
            r30 = r9
            r26 = r10
            r17 = r11
            r6 = r32
            goto L_0x042b
        L_0x032a:
            r4 = r2
            r1 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r9
            r9 = r0
            r0 = 27
            if (r11 != r0) goto L_0x0391
            r0 = 2
            if (r7 != r0) goto L_0x0382
            java.lang.Object r0 = r10.getObject(r14, r1)
            com.google.android.gms.internal.measurement.zzid r0 = (com.google.android.gms.internal.measurement.zzid) r0
            boolean r7 = r0.zza()
            if (r7 != 0) goto L_0x035c
            int r7 = r0.size()
            if (r7 != 0) goto L_0x0353
            r7 = 10
            goto L_0x0355
        L_0x0353:
            int r7 = r7 << 1
        L_0x0355:
            com.google.android.gms.internal.measurement.zzid r0 = r0.zza(r7)
            r10.putObject(r14, r1, r0)
        L_0x035c:
            r7 = r0
            com.google.android.gms.internal.measurement.zzjv r0 = r15.zza((int) r4)
            r1 = r8
            r2 = r29
            r17 = r4
            r4 = r31
            r22 = r5
            r5 = r7
            r23 = r6
            r6 = r33
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza(r0, r1, r2, r3, r4, r5, r6)
            r11 = r32
            r3 = r8
            r1 = r9
            r9 = r13
            r2 = r17
            r5 = r22
            r6 = r23
            r13 = r31
            goto L_0x0019
        L_0x0382:
            r17 = r4
            r22 = r5
            r23 = r6
            r15 = r3
            r19 = r8
            r30 = r9
            r26 = r10
            goto L_0x0406
        L_0x0391:
            r17 = r4
            r22 = r5
            r23 = r6
            r0 = 49
            if (r11 > r0) goto L_0x03de
            r6 = r20
            long r5 = (long) r6
            r0 = r27
            r24 = r1
            r1 = r28
            r2 = r29
            r4 = r3
            r15 = r4
            r4 = r31
            r20 = r5
            r5 = r8
            r6 = r9
            r19 = r8
            r8 = r17
            r30 = r9
            r26 = r10
            r9 = r20
            r12 = r24
            r14 = r33
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.measurement.zzgl) r14)
            if (r0 != r15) goto L_0x03c4
            goto L_0x0427
        L_0x03c4:
            r15 = r27
            r14 = r28
            r12 = r29
            r1 = r30
            r13 = r31
            r11 = r32
            r9 = r33
            r2 = r17
            r3 = r19
        L_0x03d6:
            r5 = r22
            r6 = r23
            r10 = r26
            goto L_0x0019
        L_0x03de:
            r24 = r1
            r15 = r3
            r19 = r8
            r30 = r9
            r26 = r10
            r6 = r20
            r0 = 50
            if (r11 != r0) goto L_0x040c
            r0 = 2
            if (r7 != r0) goto L_0x0406
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r17
            r6 = r24
            r8 = r33
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.measurement.zzgl) r8)
            if (r0 != r15) goto L_0x03c4
            goto L_0x0427
        L_0x0406:
            r6 = r32
            r2 = r15
        L_0x0409:
            r7 = r19
            goto L_0x042b
        L_0x040c:
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r19
            r8 = r6
            r6 = r30
            r9 = r11
            r10 = r24
            r12 = r17
            r13 = r33
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.measurement.zzgl) r13)
            if (r0 != r15) goto L_0x04b0
        L_0x0427:
            r6 = r32
            r2 = r0
            goto L_0x0409
        L_0x042b:
            if (r7 != r6) goto L_0x043e
            if (r6 != 0) goto L_0x0430
            goto L_0x043e
        L_0x0430:
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r27
            r11 = r28
            r3 = r7
            r1 = r22
            r0 = r23
            goto L_0x04d7
        L_0x043e:
            r8 = r27
            boolean r0 = r8.zzh
            if (r0 == 0) goto L_0x0488
            r9 = r33
            com.google.android.gms.internal.measurement.zzhi r0 = r9.zzd
            com.google.android.gms.internal.measurement.zzhi r1 = com.google.android.gms.internal.measurement.zzhi.zza()
            if (r0 == r1) goto L_0x0483
            com.google.android.gms.internal.measurement.zzjg r0 = r8.zzg
            com.google.android.gms.internal.measurement.zzhi r1 = r9.zzd
            r10 = r30
            com.google.android.gms.internal.measurement.zzhv$zzf r0 = r1.zza(r0, r10)
            if (r0 != 0) goto L_0x0473
            com.google.android.gms.internal.measurement.zzkq r4 = zze((java.lang.Object) r28)
            r0 = r7
            r1 = r29
            r3 = r31
            r5 = r33
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzkq) r4, (com.google.android.gms.internal.measurement.zzgl) r5)
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r6
            r3 = r7
            r15 = r8
            goto L_0x04c1
        L_0x0473:
            r11 = r28
            r0 = r11
            com.google.android.gms.internal.measurement.zzhv$zzd r0 = (com.google.android.gms.internal.measurement.zzhv.zzd) r0
            r0.zza()
            com.google.android.gms.internal.measurement.zzho<com.google.android.gms.internal.measurement.zzhv$zzc> r0 = r0.zzc
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        L_0x0483:
            r11 = r28
            r10 = r30
            goto L_0x048e
        L_0x0488:
            r11 = r28
            r10 = r30
            r9 = r33
        L_0x048e:
            com.google.android.gms.internal.measurement.zzkq r4 = zze((java.lang.Object) r28)
            r0 = r7
            r1 = r29
            r3 = r31
            r5 = r33
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzkq) r4, (com.google.android.gms.internal.measurement.zzgl) r5)
            r12 = r29
            r13 = r31
            r3 = r7
            r15 = r8
            r1 = r10
            r14 = r11
            r2 = r17
            r5 = r22
            r10 = r26
            r11 = r6
            r6 = r23
            goto L_0x0019
        L_0x04b0:
            r10 = r30
            r7 = r19
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r33
            r3 = r7
        L_0x04c1:
            r1 = r10
            r2 = r17
            goto L_0x03d6
        L_0x04c6:
            r22 = r5
            r23 = r6
            r26 = r10
            r6 = r11
            r11 = r14
            r8 = r15
            r2 = r0
            r1 = r22
            r0 = r23
            r4 = 1048575(0xfffff, float:1.469367E-39)
        L_0x04d7:
            if (r0 == r4) goto L_0x04df
            long r4 = (long) r0
            r0 = r26
            r0.putInt(r11, r4, r1)
        L_0x04df:
            r0 = 0
            int r1 = r8.zzm
        L_0x04e2:
            int r4 = r8.zzn
            if (r1 >= r4) goto L_0x04f5
            int[] r4 = r8.zzl
            r4 = r4[r1]
            com.google.android.gms.internal.measurement.zzkn<?, ?> r5 = r8.zzq
            java.lang.Object r0 = r8.zza((java.lang.Object) r11, (int) r4, r0, r5)
            com.google.android.gms.internal.measurement.zzkq r0 = (com.google.android.gms.internal.measurement.zzkq) r0
            int r1 = r1 + 1
            goto L_0x04e2
        L_0x04f5:
            if (r0 == 0) goto L_0x04fc
            com.google.android.gms.internal.measurement.zzkn<?, ?> r1 = r8.zzq
            r1.zzb((java.lang.Object) r11, r0)
        L_0x04fc:
            if (r6 != 0) goto L_0x0508
            r0 = r31
            if (r2 != r0) goto L_0x0503
            goto L_0x050e
        L_0x0503:
            com.google.android.gms.internal.measurement.zzig r0 = com.google.android.gms.internal.measurement.zzig.zzg()
            throw r0
        L_0x0508:
            r0 = r31
            if (r2 > r0) goto L_0x050f
            if (r3 != r6) goto L_0x050f
        L_0x050e:
            return r2
        L_0x050f:
            com.google.android.gms.internal.measurement.zzig r0 = com.google.android.gms.internal.measurement.zzig.zzg()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.measurement.zzgl):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r17v5, resolved type: byte} */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x034b, code lost:
        if (r0 == r15) goto L_0x0370;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x036e, code lost:
        if (r0 == r15) goto L_0x0370;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0370, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01e2, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0255, code lost:
        r6 = r6 | r23;
        r2 = r7;
        r9 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x025b, code lost:
        r2 = r5;
        r29 = r10;
        r30 = r20;
        r20 = r7;
        r7 = r30;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x0302, code lost:
        if (r0 == r15) goto L_0x0370;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r32, byte[] r33, int r34, int r35, com.google.android.gms.internal.measurement.zzgl r36) throws java.io.IOException {
        /*
            r31 = this;
            r15 = r31
            r14 = r32
            r12 = r33
            r13 = r35
            r11 = r36
            boolean r0 = r15.zzj
            if (r0 == 0) goto L_0x03b5
            sun.misc.Unsafe r9 = zzb
            r10 = -1
            r16 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r34
            r1 = -1
            r2 = 0
            r6 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001e:
            if (r0 >= r13) goto L_0x0398
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0030
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza((int) r0, (byte[]) r12, (int) r3, (com.google.android.gms.internal.measurement.zzgl) r11)
            int r3 = r11.zza
            r4 = r0
            r17 = r3
            goto L_0x0033
        L_0x0030:
            r17 = r0
            r4 = r3
        L_0x0033:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x0040
            int r2 = r2 / 3
            int r0 = r15.zza((int) r5, (int) r2)
            goto L_0x0044
        L_0x0040:
            int r0 = r15.zzg(r5)
        L_0x0044:
            r2 = r0
            if (r2 != r10) goto L_0x0052
            r2 = r4
            r25 = r5
            r29 = r9
            r19 = -1
            r20 = 0
            goto L_0x0372
        L_0x0052:
            int[] r0 = r15.zzc
            int r1 = r2 + 1
            r1 = r0[r1]
            r18 = 267386880(0xff00000, float:2.3665827E-29)
            r18 = r1 & r18
            int r10 = r18 >>> 20
            r34 = r5
            r5 = r1 & r8
            r18 = r9
            long r8 = (long) r5
            r5 = 17
            r21 = r1
            if (r10 > r5) goto L_0x0268
            int r5 = r2 + 2
            r0 = r0[r5]
            int r5 = r0 >>> 20
            r1 = 1
            int r23 = r1 << r5
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            if (r0 == r7) goto L_0x0094
            if (r7 == r5) goto L_0x0085
            r20 = r2
            long r1 = (long) r7
            r7 = r18
            r7.putInt(r14, r1, r6)
            goto L_0x0089
        L_0x0085:
            r20 = r2
            r7 = r18
        L_0x0089:
            if (r0 == r5) goto L_0x0091
            long r1 = (long) r0
            int r1 = r7.getInt(r14, r1)
            r6 = r1
        L_0x0091:
            r2 = r7
            r7 = r0
            goto L_0x0098
        L_0x0094:
            r20 = r2
            r2 = r18
        L_0x0098:
            r0 = 5
            switch(r10) {
                case 0: goto L_0x023c;
                case 1: goto L_0x0223;
                case 2: goto L_0x01ff;
                case 3: goto L_0x01ff;
                case 4: goto L_0x01e5;
                case 5: goto L_0x01c1;
                case 6: goto L_0x01a8;
                case 7: goto L_0x0186;
                case 8: goto L_0x0161;
                case 9: goto L_0x0132;
                case 10: goto L_0x0118;
                case 11: goto L_0x01e5;
                case 12: goto L_0x00ff;
                case 13: goto L_0x01a8;
                case 14: goto L_0x01c1;
                case 15: goto L_0x00e2;
                case 16: goto L_0x00ab;
                default: goto L_0x009c;
            }
        L_0x009c:
            r25 = r34
            r10 = r2
            r5 = r4
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            goto L_0x025b
        L_0x00ab:
            if (r3 != 0) goto L_0x00d4
            int r10 = com.google.android.gms.internal.measurement.zzgi.zzb(r12, r4, r11)
            long r0 = r11.zzb
            long r17 = com.google.android.gms.internal.measurement.zzgy.zza((long) r0)
            r0 = r2
            r1 = r32
            r4 = r2
            r30 = r20
            r20 = r7
            r7 = r30
            r2 = r8
            r25 = r34
            r8 = r4
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r17
            r0.putLong(r1, r2, r4)
            r6 = r6 | r23
            r2 = r7
            r9 = r8
            r0 = r10
            goto L_0x02b2
        L_0x00d4:
            r25 = r34
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            r10 = r2
            goto L_0x01e2
        L_0x00e2:
            r25 = r34
            r10 = r2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != 0) goto L_0x01e2
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza(r12, r4, r11)
            int r1 = r11.zza
            int r1 = com.google.android.gms.internal.measurement.zzgy.zze(r1)
            r10.putInt(r14, r8, r1)
            goto L_0x0255
        L_0x00ff:
            r25 = r34
            r10 = r2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != 0) goto L_0x01e2
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza(r12, r4, r11)
            int r1 = r11.zza
            r10.putInt(r14, r8, r1)
            goto L_0x0255
        L_0x0118:
            r25 = r34
            r10 = r2
            r0 = 2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != r0) goto L_0x01e2
            int r0 = com.google.android.gms.internal.measurement.zzgi.zze(r12, r4, r11)
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            goto L_0x0255
        L_0x0132:
            r25 = r34
            r10 = r2
            r0 = 2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != r0) goto L_0x01e2
            com.google.android.gms.internal.measurement.zzjv r0 = r15.zza((int) r7)
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza((com.google.android.gms.internal.measurement.zzjv) r0, (byte[]) r12, (int) r4, (int) r13, (com.google.android.gms.internal.measurement.zzgl) r11)
            java.lang.Object r1 = r10.getObject(r14, r8)
            if (r1 != 0) goto L_0x0156
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            goto L_0x0255
        L_0x0156:
            java.lang.Object r2 = r11.zzc
            java.lang.Object r1 = com.google.android.gms.internal.measurement.zzhx.zza((java.lang.Object) r1, (java.lang.Object) r2)
            r10.putObject(r14, r8, r1)
            goto L_0x0255
        L_0x0161:
            r25 = r34
            r10 = r2
            r0 = 2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != r0) goto L_0x01e2
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r21 & r0
            if (r0 != 0) goto L_0x017b
            int r0 = com.google.android.gms.internal.measurement.zzgi.zzc(r12, r4, r11)
            goto L_0x017f
        L_0x017b:
            int r0 = com.google.android.gms.internal.measurement.zzgi.zzd(r12, r4, r11)
        L_0x017f:
            java.lang.Object r1 = r11.zzc
            r10.putObject(r14, r8, r1)
            goto L_0x0255
        L_0x0186:
            r25 = r34
            r10 = r2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != 0) goto L_0x01e2
            int r0 = com.google.android.gms.internal.measurement.zzgi.zzb(r12, r4, r11)
            long r1 = r11.zzb
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x01a2
            r1 = 1
            goto L_0x01a3
        L_0x01a2:
            r1 = 0
        L_0x01a3:
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r8, (boolean) r1)
            goto L_0x0255
        L_0x01a8:
            r25 = r34
            r10 = r2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != r0) goto L_0x01e2
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza(r12, r4)
            r10.putInt(r14, r8, r0)
            int r0 = r4 + 4
            goto L_0x0255
        L_0x01c1:
            r25 = r34
            r10 = r2
            r0 = 1
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != r0) goto L_0x01e2
            long r17 = com.google.android.gms.internal.measurement.zzgi.zzb(r12, r4)
            r0 = r10
            r1 = r32
            r2 = r8
            r8 = r4
            r4 = r17
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x0255
        L_0x01e2:
            r5 = r4
            goto L_0x025b
        L_0x01e5:
            r25 = r34
            r10 = r2
            r5 = r4
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != 0) goto L_0x025b
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza(r12, r5, r11)
            int r1 = r11.zza
            r10.putInt(r14, r8, r1)
            goto L_0x0255
        L_0x01ff:
            r25 = r34
            r10 = r2
            r5 = r4
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != 0) goto L_0x025b
            int r17 = com.google.android.gms.internal.measurement.zzgi.zzb(r12, r5, r11)
            long r4 = r11.zzb
            r0 = r10
            r1 = r32
            r2 = r8
            r0.putLong(r1, r2, r4)
            r6 = r6 | r23
            r2 = r7
            r9 = r10
            r0 = r17
            goto L_0x02b2
        L_0x0223:
            r25 = r34
            r10 = r2
            r5 = r4
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != r0) goto L_0x025b
            float r0 = com.google.android.gms.internal.measurement.zzgi.zzd(r12, r5)
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r8, (float) r0)
            int r0 = r5 + 4
            goto L_0x0255
        L_0x023c:
            r25 = r34
            r10 = r2
            r5 = r4
            r0 = 1
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r30 = r20
            r20 = r7
            r7 = r30
            if (r3 != r0) goto L_0x025b
            double r0 = com.google.android.gms.internal.measurement.zzgi.zzc(r12, r5)
            com.google.android.gms.internal.measurement.zzkt.zza((java.lang.Object) r14, (long) r8, (double) r0)
            int r0 = r5 + 8
        L_0x0255:
            r6 = r6 | r23
            r2 = r7
            r9 = r10
            goto L_0x02b2
        L_0x025b:
            r2 = r5
            r29 = r10
            r19 = -1
            r30 = r20
            r20 = r7
            r7 = r30
            goto L_0x0372
        L_0x0268:
            r25 = r34
            r5 = r4
            r20 = r7
            r4 = r18
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r7 = r2
            r0 = 27
            if (r10 != r0) goto L_0x02c5
            r0 = 2
            if (r3 != r0) goto L_0x02b8
            java.lang.Object r0 = r4.getObject(r14, r8)
            com.google.android.gms.internal.measurement.zzid r0 = (com.google.android.gms.internal.measurement.zzid) r0
            boolean r1 = r0.zza()
            if (r1 != 0) goto L_0x0298
            int r1 = r0.size()
            if (r1 != 0) goto L_0x028f
            r1 = 10
            goto L_0x0291
        L_0x028f:
            int r1 = r1 << 1
        L_0x0291:
            com.google.android.gms.internal.measurement.zzid r0 = r0.zza(r1)
            r4.putObject(r14, r8, r0)
        L_0x0298:
            r8 = r0
            com.google.android.gms.internal.measurement.zzjv r0 = r15.zza((int) r7)
            r1 = r17
            r2 = r33
            r3 = r5
            r18 = r4
            r4 = r35
            r5 = r8
            r8 = r6
            r6 = r36
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza(r0, r1, r2, r3, r4, r5, r6)
            r2 = r7
            r6 = r8
            r9 = r18
        L_0x02b2:
            r7 = r20
            r1 = r25
            goto L_0x0392
        L_0x02b8:
            r29 = r4
            r15 = r5
            r27 = r6
            r28 = r20
            r19 = -1
            r20 = r7
            goto L_0x034e
        L_0x02c5:
            r18 = r4
            r0 = 49
            if (r10 > r0) goto L_0x031a
            r1 = r21
            long r1 = (long) r1
            r0 = r31
            r21 = r1
            r1 = r32
            r2 = r33
            r4 = r3
            r3 = r5
            r34 = r4
            r4 = r35
            r15 = r5
            r5 = r17
            r27 = r6
            r6 = r25
            r28 = r20
            r20 = r7
            r7 = r34
            r23 = r8
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r20
            r29 = r18
            r19 = -1
            r18 = r10
            r9 = r21
            r11 = r18
            r12 = r23
            r14 = r36
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (long) r9, (int) r11, (long) r12, (com.google.android.gms.internal.measurement.zzgl) r14)
            if (r0 != r15) goto L_0x0306
            goto L_0x0370
        L_0x0306:
            r15 = r31
            r14 = r32
            r12 = r33
            r13 = r35
            r11 = r36
            r2 = r20
            r1 = r25
            r6 = r27
            r7 = r28
            goto L_0x0390
        L_0x031a:
            r34 = r3
            r15 = r5
            r27 = r6
            r23 = r8
            r29 = r18
            r28 = r20
            r1 = r21
            r19 = -1
            r20 = r7
            r18 = r10
            r0 = 50
            r9 = r18
            if (r9 != r0) goto L_0x0354
            r7 = r34
            r0 = 2
            if (r7 != r0) goto L_0x034e
            r0 = r31
            r1 = r32
            r2 = r33
            r3 = r15
            r4 = r35
            r5 = r20
            r6 = r23
            r8 = r36
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (long) r6, (com.google.android.gms.internal.measurement.zzgl) r8)
            if (r0 != r15) goto L_0x0306
            goto L_0x0370
        L_0x034e:
            r2 = r15
        L_0x034f:
            r6 = r27
            r7 = r28
            goto L_0x0372
        L_0x0354:
            r7 = r34
            r0 = r31
            r8 = r1
            r1 = r32
            r2 = r33
            r3 = r15
            r4 = r35
            r5 = r17
            r6 = r25
            r10 = r23
            r12 = r20
            r13 = r36
            int r0 = r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (int) r6, (int) r7, (int) r8, (int) r9, (long) r10, (int) r12, (com.google.android.gms.internal.measurement.zzgl) r13)
            if (r0 != r15) goto L_0x0306
        L_0x0370:
            r2 = r0
            goto L_0x034f
        L_0x0372:
            com.google.android.gms.internal.measurement.zzkq r4 = zze((java.lang.Object) r32)
            r0 = r17
            r1 = r33
            r3 = r35
            r5 = r36
            int r0 = com.google.android.gms.internal.measurement.zzgi.zza((int) r0, (byte[]) r1, (int) r2, (int) r3, (com.google.android.gms.internal.measurement.zzkq) r4, (com.google.android.gms.internal.measurement.zzgl) r5)
            r15 = r31
            r14 = r32
            r12 = r33
            r13 = r35
            r11 = r36
            r2 = r20
            r1 = r25
        L_0x0390:
            r9 = r29
        L_0x0392:
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            goto L_0x001e
        L_0x0398:
            r27 = r6
            r29 = r9
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 == r1) goto L_0x03ab
            long r1 = (long) r7
            r3 = r32
            r6 = r27
            r4 = r29
            r4.putInt(r3, r1, r6)
        L_0x03ab:
            r4 = r35
            if (r0 != r4) goto L_0x03b0
            return
        L_0x03b0:
            com.google.android.gms.internal.measurement.zzig r0 = com.google.android.gms.internal.measurement.zzig.zzg()
            throw r0
        L_0x03b5:
            r4 = r13
            r3 = r14
            r5 = 0
            r0 = r31
            r1 = r32
            r2 = r33
            r3 = r34
            r4 = r35
            r6 = r36
            r0.zza(r1, (byte[]) r2, (int) r3, (int) r4, (int) r5, (com.google.android.gms.internal.measurement.zzgl) r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzjk.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.measurement.zzgl):void");
    }

    public final void zzc(T t) {
        int i;
        int i2 = this.zzm;
        while (true) {
            i = this.zzn;
            if (i2 >= i) {
                break;
            }
            long zzd2 = (long) (zzd(this.zzl[i2]) & 1048575);
            Object zzf2 = zzkt.zzf(t, zzd2);
            if (zzf2 != null) {
                zzkt.zza((Object) t, zzd2, this.zzs.zzd(zzf2));
            }
            i2++;
        }
        int length = this.zzl.length;
        while (i < length) {
            this.zzp.zzb(t, (long) this.zzl[i]);
            i++;
        }
        this.zzq.zzd(t);
        if (this.zzh) {
            this.zzr.zzc(t);
        }
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzkn<UT, UB> zzkn) {
        zzic zzc2;
        int i2 = this.zzc[i];
        Object zzf2 = zzkt.zzf(obj, (long) (zzd(i) & 1048575));
        if (zzf2 == null || (zzc2 = zzc(i)) == null) {
            return ub;
        }
        return zza(i, i2, this.zzs.zza(zzf2), zzc2, ub, zzkn);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzic zzic, UB ub, zzkn<UT, UB> zzkn) {
        zzix<?, ?> zzf2 = this.zzs.zzf(zzb(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!zzic.zza(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzkn.zza();
                }
                zzgu zzc2 = zzgm.zzc(zziy.zza(zzf2, next.getKey(), next.getValue()));
                try {
                    zziy.zza(zzc2.zzb(), zzf2, next.getKey(), next.getValue());
                    zzkn.zza(ub, i2, zzc2.zza());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    public final boolean zzd(T t) {
        int i;
        int i2;
        T t2 = t;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean z = true;
            if (i5 >= this.zzm) {
                return !this.zzh || this.zzr.zza((Object) t2).zzf();
            }
            int i6 = this.zzl[i5];
            int i7 = this.zzc[i6];
            int zzd2 = zzd(i6);
            int i8 = this.zzc[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                i = i9 != 1048575 ? zzb.getInt(t2, (long) i9) : i4;
                i2 = i9;
            } else {
                i2 = i3;
                i = i4;
            }
            if (((268435456 & zzd2) != 0) && !zza(t, i6, i2, i, i10)) {
                return false;
            }
            int i11 = (267386880 & zzd2) >>> 20;
            if (i11 != 9 && i11 != 17) {
                if (i11 != 27) {
                    if (i11 == 60 || i11 == 68) {
                        if (zza(t2, i7, i6) && !zza((Object) t2, zzd2, zza(i6))) {
                            return false;
                        }
                    } else if (i11 != 49) {
                        if (i11 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzb2 = this.zzs.zzb(zzkt.zzf(t2, (long) (zzd2 & 1048575)));
                            if (!zzb2.isEmpty()) {
                                if (this.zzs.zzf(zzb(i6)).zzc.zza() == zzlh.MESSAGE) {
                                    zzjv<?> zzjv = null;
                                    Iterator<?> it = zzb2.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzjv == null) {
                                            zzjv = zzjr.zza().zza(next.getClass());
                                        }
                                        if (!zzjv.zzd(next)) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zzkt.zzf(t2, (long) (zzd2 & 1048575));
                if (!list.isEmpty()) {
                    zzjv zza2 = zza(i6);
                    int i12 = 0;
                    while (true) {
                        if (i12 >= list.size()) {
                            break;
                        } else if (!zza2.zzd(list.get(i12))) {
                            z = false;
                            break;
                        } else {
                            i12++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (zza(t, i6, i2, i, i10) && !zza((Object) t2, zzd2, zza(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
    }

    private static boolean zza(Object obj, int i, zzjv zzjv) {
        return zzjv.zzd(zzkt.zzf(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzlk zzlk) throws IOException {
        if (obj instanceof String) {
            zzlk.zza(i, (String) obj);
        } else {
            zzlk.zza(i, (zzgm) obj);
        }
    }

    private final void zza(Object obj, int i, zzjw zzjw) throws IOException {
        if (zzf(i)) {
            zzkt.zza(obj, (long) (i & 1048575), (Object) zzjw.zzm());
        } else if (this.zzi) {
            zzkt.zza(obj, (long) (i & 1048575), (Object) zzjw.zzl());
        } else {
            zzkt.zza(obj, (long) (i & 1048575), (Object) zzjw.zzn());
        }
    }

    private final int zzd(int i) {
        return this.zzc[i + 1];
    }

    private final int zze(int i) {
        return this.zzc[i + 2];
    }

    private static <T> double zzb(T t, long j) {
        return ((Double) zzkt.zzf(t, j)).doubleValue();
    }

    private static <T> float zzc(T t, long j) {
        return ((Float) zzkt.zzf(t, j)).floatValue();
    }

    private static <T> int zzd(T t, long j) {
        return ((Integer) zzkt.zzf(t, j)).intValue();
    }

    private static <T> long zze(T t, long j) {
        return ((Long) zzkt.zzf(t, j)).longValue();
    }

    private static <T> boolean zzf(T t, long j) {
        return ((Boolean) zzkt.zzf(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zza(t, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zza(T t, int i) {
        int zze2 = zze(i);
        long j = (long) (zze2 & 1048575);
        if (j == 1048575) {
            int zzd2 = zzd(i);
            long j2 = (long) (zzd2 & 1048575);
            switch ((zzd2 & 267386880) >>> 20) {
                case 0:
                    return zzkt.zze(t, j2) != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                case 1:
                    return zzkt.zzd(t, j2) != 0.0f;
                case 2:
                    return zzkt.zzb(t, j2) != 0;
                case 3:
                    return zzkt.zzb(t, j2) != 0;
                case 4:
                    return zzkt.zza((Object) t, j2) != 0;
                case 5:
                    return zzkt.zzb(t, j2) != 0;
                case 6:
                    return zzkt.zza((Object) t, j2) != 0;
                case 7:
                    return zzkt.zzc(t, j2);
                case 8:
                    Object zzf2 = zzkt.zzf(t, j2);
                    if (zzf2 instanceof String) {
                        return !((String) zzf2).isEmpty();
                    }
                    if (zzf2 instanceof zzgm) {
                        return !zzgm.zza.equals(zzf2);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzkt.zzf(t, j2) != null;
                case 10:
                    return !zzgm.zza.equals(zzkt.zzf(t, j2));
                case 11:
                    return zzkt.zza((Object) t, j2) != 0;
                case 12:
                    return zzkt.zza((Object) t, j2) != 0;
                case 13:
                    return zzkt.zza((Object) t, j2) != 0;
                case 14:
                    return zzkt.zzb(t, j2) != 0;
                case 15:
                    return zzkt.zza((Object) t, j2) != 0;
                case 16:
                    return zzkt.zzb(t, j2) != 0;
                case 17:
                    return zzkt.zzf(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (zzkt.zza((Object) t, j) & (1 << (zze2 >>> 20))) != 0;
        }
    }

    private final void zzb(T t, int i) {
        int zze2 = zze(i);
        long j = (long) (1048575 & zze2);
        if (j != 1048575) {
            zzkt.zza((Object) t, j, (1 << (zze2 >>> 20)) | zzkt.zza((Object) t, j));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzkt.zza((Object) t, (long) (zze(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzkt.zza((Object) t, (long) (zze(i2) & 1048575), i);
    }

    private final int zzg(int i) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, 0);
    }

    private final int zza(int i, int i2) {
        if (i < this.zze || i > this.zzf) {
            return -1;
        }
        return zzb(i, i2);
    }

    private final int zzb(int i, int i2) {
        int length = (this.zzc.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzc[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }
}
