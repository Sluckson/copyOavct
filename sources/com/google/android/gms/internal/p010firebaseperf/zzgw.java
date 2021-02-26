package com.google.android.gms.internal.p010firebaseperf;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* renamed from: com.google.android.gms.internal.firebase-perf.zzgw */
/* compiled from: com.google.firebase:firebase-perf@@19.0.7 */
final class zzgw<T> implements zzhi<T> {
    private static final int[] zztd = new int[0];
    private static final Unsafe zzte = zzig.zzjk();
    private final zzgs zzsz;
    private final zzia<?, ?> zzta;
    private final boolean zztb;
    private final zzez<?> zztc;
    private final int[] zztf;
    private final Object[] zztg;
    private final int zzth;
    private final int zzti;
    private final boolean zztj;
    private final boolean zztk;
    private final boolean zztl;
    private final int[] zztm;
    private final int zztn;
    private final int zzto;
    private final zzgx zztp;
    private final zzgc zztq;
    private final zzgl zztr;

    private zzgw(int[] iArr, Object[] objArr, int i, int i2, zzgs zzgs, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzgx zzgx, zzgc zzgc, zzia<?, ?> zzia, zzez<?> zzez, zzgl zzgl) {
        this.zztf = iArr;
        this.zztg = objArr;
        this.zzth = i;
        this.zzti = i2;
        this.zztj = zzgs instanceof zzfi;
        this.zztk = z;
        this.zztb = zzez != null && zzez.zze(zzgs);
        this.zztl = false;
        this.zztm = iArr2;
        this.zztn = i3;
        this.zzto = i4;
        this.zztp = zzgx;
        this.zztq = zzgc;
        this.zzta = zzia;
        this.zztc = zzez;
        this.zzsz = zzgs;
        this.zztr = zzgl;
    }

    /* JADX WARNING: Removed duplicated region for block: B:164:0x034d  */
    /* JADX WARNING: Removed duplicated region for block: B:177:0x0396  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static <T> com.google.android.gms.internal.p010firebaseperf.zzgw<T> zza(java.lang.Class<T> r33, com.google.android.gms.internal.p010firebaseperf.zzgq r34, com.google.android.gms.internal.p010firebaseperf.zzgx r35, com.google.android.gms.internal.p010firebaseperf.zzgc r36, com.google.android.gms.internal.p010firebaseperf.zzia<?, ?> r37, com.google.android.gms.internal.p010firebaseperf.zzez<?> r38, com.google.android.gms.internal.p010firebaseperf.zzgl r39) {
        /*
            r0 = r34
            boolean r1 = r0 instanceof com.google.android.gms.internal.p010firebaseperf.zzhf
            if (r1 == 0) goto L_0x040d
            com.google.android.gms.internal.firebase-perf.zzhf r0 = (com.google.android.gms.internal.p010firebaseperf.zzhf) r0
            int r1 = r0.zzij()
            int r2 = com.google.android.gms.internal.p010firebaseperf.zzhe.zzty
            r3 = 0
            r4 = 1
            if (r1 != r2) goto L_0x0014
            r11 = 1
            goto L_0x0015
        L_0x0014:
            r11 = 0
        L_0x0015:
            java.lang.String r1 = r0.zziq()
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
            int[] r5 = zztd
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
            sun.misc.Unsafe r3 = zzte
            java.lang.Object[] r17 = r0.zzir()
            com.google.android.gms.internal.firebase-perf.zzgs r18 = r0.zzil()
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
            com.google.android.gms.internal.firebase-perf.zzgw r1 = new com.google.android.gms.internal.firebase-perf.zzgw
            com.google.android.gms.internal.firebase-perf.zzgs r10 = r0.zzil()
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
            com.google.android.gms.internal.firebase-perf.zzht r0 = (com.google.android.gms.internal.p010firebaseperf.zzht) r0
            int r0 = r0.zzij()
            int r1 = com.google.android.gms.internal.p010firebaseperf.zzhe.zzty
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p010firebaseperf.zzgw.zza(java.lang.Class, com.google.android.gms.internal.firebase-perf.zzgq, com.google.android.gms.internal.firebase-perf.zzgx, com.google.android.gms.internal.firebase-perf.zzgc, com.google.android.gms.internal.firebase-perf.zzia, com.google.android.gms.internal.firebase-perf.zzez, com.google.android.gms.internal.firebase-perf.zzgl):com.google.android.gms.internal.firebase-perf.zzgw");
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

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.p010firebaseperf.zzhk.zze(com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r10, r6), com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r10, r6) == com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r10, r6) == com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r10, r6) == com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r10, r6) == com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r10, r6) == com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r10, r6) == com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.p010firebaseperf.zzhk.zze(com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r10, r6), com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.p010firebaseperf.zzhk.zze(com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r10, r6), com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.p010firebaseperf.zzhk.zze(com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r10, r6), com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.p010firebaseperf.zzig.zzl(r10, r6) == com.google.android.gms.internal.p010firebaseperf.zzig.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r10, r6) == com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r10, r6) == com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r10, r6) == com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r10, r6) == com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r10, r6) == com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.p010firebaseperf.zzig.zzm(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.p010firebaseperf.zzig.zzm(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.p010firebaseperf.zzig.zzn(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.p010firebaseperf.zzig.zzn(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01c1, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.p010firebaseperf.zzhk.zze(com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r10, r6), com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r11, r6)) != false) goto L_0x01c2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zztf
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01c9
            int r4 = r9.zzar(r2)
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
            int r4 = r9.zzas(r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r10, r4)
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r11, r4)
            if (r8 != r4) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r11, r6)
            boolean r3 = com.google.android.gms.internal.p010firebaseperf.zzhk.zze(r3, r4)
            goto L_0x01c2
        L_0x004a:
            java.lang.Object r3 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r11, r6)
            boolean r3 = com.google.android.gms.internal.p010firebaseperf.zzhk.zze(r3, r4)
            goto L_0x01c2
        L_0x0058:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x006e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0082:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0094:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00a8:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00ba:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00cc:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00de:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00f4:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x010a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0120:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            boolean r4 = com.google.android.gms.internal.p010firebaseperf.zzig.zzl(r10, r6)
            boolean r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzl(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0132:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0144:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0157:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0168:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x017b:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x018e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            float r4 = com.google.android.gms.internal.p010firebaseperf.zzig.zzm(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzm(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x01a7:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            double r4 = com.google.android.gms.internal.p010firebaseperf.zzig.zzn(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.p010firebaseperf.zzig.zzn(r11, r6)
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
            com.google.android.gms.internal.firebase-perf.zzia<?, ?> r0 = r9.zzta
            java.lang.Object r0 = r0.zzp(r10)
            com.google.android.gms.internal.firebase-perf.zzia<?, ?> r2 = r9.zzta
            java.lang.Object r2 = r2.zzp(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            return r1
        L_0x01dc:
            boolean r0 = r9.zztb
            if (r0 == 0) goto L_0x01f1
            com.google.android.gms.internal.firebase-perf.zzez<?> r0 = r9.zztc
            com.google.android.gms.internal.firebase-perf.zzfa r10 = r0.zzd(r10)
            com.google.android.gms.internal.firebase-perf.zzez<?> r0 = r9.zztc
            com.google.android.gms.internal.firebase-perf.zzfa r11 = r0.zzd(r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f1:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p010firebaseperf.zzgw.equals(java.lang.Object, java.lang.Object):boolean");
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
    public final int hashCode(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zztf
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x022c
            int r3 = r8.zzar(r1)
            int[] r4 = r8.zztf
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
            java.lang.Object r3 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x0032:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzh(r9, r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzfj.zzaz(r3)
            goto L_0x0227
        L_0x0044:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzg(r9, r5)
            goto L_0x0227
        L_0x0052:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzh(r9, r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzfj.zzaz(r3)
            goto L_0x0227
        L_0x0064:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzg(r9, r5)
            goto L_0x0227
        L_0x0072:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzg(r9, r5)
            goto L_0x0227
        L_0x0080:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzg(r9, r5)
            goto L_0x0227
        L_0x008e:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00a0:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            java.lang.Object r3 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r9, r5)
            int r2 = r2 * 53
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00b2:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x00c6:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            boolean r3 = zzi(r9, r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzfj.zzh(r3)
            goto L_0x0227
        L_0x00d8:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzg(r9, r5)
            goto L_0x0227
        L_0x00e6:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzh(r9, r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzfj.zzaz(r3)
            goto L_0x0227
        L_0x00f8:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            int r3 = zzg(r9, r5)
            goto L_0x0227
        L_0x0106:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzh(r9, r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzfj.zzaz(r3)
            goto L_0x0227
        L_0x0118:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            long r3 = zzh(r9, r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzfj.zzaz(r3)
            goto L_0x0227
        L_0x012a:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            float r3 = zzf(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x013c:
            boolean r3 = r8.zza(r9, (int) r4, (int) r1)
            if (r3 == 0) goto L_0x0228
            int r2 = r2 * 53
            double r3 = zze(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzfj.zzaz(r3)
            goto L_0x0227
        L_0x0152:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x015e:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x016a:
            java.lang.Object r3 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
            goto L_0x01c3
        L_0x0175:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r9, r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzfj.zzaz(r3)
            goto L_0x0227
        L_0x0181:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r9, r5)
            goto L_0x0227
        L_0x0189:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r9, r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzfj.zzaz(r3)
            goto L_0x0227
        L_0x0195:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r9, r5)
            goto L_0x0227
        L_0x019d:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r9, r5)
            goto L_0x0227
        L_0x01a5:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r9, r5)
            goto L_0x0227
        L_0x01ad:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r9, r5)
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01b9:
            java.lang.Object r3 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r9, r5)
            if (r3 == 0) goto L_0x01c3
            int r7 = r3.hashCode()
        L_0x01c3:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x0228
        L_0x01c7:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0227
        L_0x01d4:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.p010firebaseperf.zzig.zzl(r9, r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzfj.zzh(r3)
            goto L_0x0227
        L_0x01df:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r9, r5)
            goto L_0x0227
        L_0x01e6:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r9, r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzfj.zzaz(r3)
            goto L_0x0227
        L_0x01f1:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r9, r5)
            goto L_0x0227
        L_0x01f8:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r9, r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzfj.zzaz(r3)
            goto L_0x0227
        L_0x0203:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r9, r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzfj.zzaz(r3)
            goto L_0x0227
        L_0x020e:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.p010firebaseperf.zzig.zzm(r9, r5)
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0227
        L_0x0219:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.p010firebaseperf.zzig.zzn(r9, r5)
            long r3 = java.lang.Double.doubleToLongBits(r3)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzfj.zzaz(r3)
        L_0x0227:
            int r2 = r2 + r3
        L_0x0228:
            int r1 = r1 + 3
            goto L_0x0005
        L_0x022c:
            int r2 = r2 * 53
            com.google.android.gms.internal.firebase-perf.zzia<?, ?> r0 = r8.zzta
            java.lang.Object r0 = r0.zzp(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zztb
            if (r0 == 0) goto L_0x024a
            int r2 = r2 * 53
            com.google.android.gms.internal.firebase-perf.zzez<?> r0 = r8.zztc
            com.google.android.gms.internal.firebase-perf.zzfa r9 = r0.zzd(r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x024a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p010firebaseperf.zzgw.hashCode(java.lang.Object):int");
    }

    public final void zzd(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zztf.length; i += 3) {
                int zzar = zzar(i);
                long j = (long) (1048575 & zzar);
                int i2 = this.zztf[i];
                switch ((zzar & 267386880) >>> 20) {
                    case 0:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzig.zza((Object) t, j, zzig.zzn(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzig.zza((Object) t, j, zzig.zzm(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzig.zza((Object) t, j, zzig.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 3:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzig.zza((Object) t, j, zzig.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 4:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzig.zza((Object) t, j, zzig.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 5:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzig.zza((Object) t, j, zzig.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 6:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzig.zza((Object) t, j, zzig.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 7:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzig.zza((Object) t, j, zzig.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 8:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzig.zza((Object) t, j, zzig.zzo(t2, j));
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
                            zzig.zza((Object) t, j, zzig.zzo(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 11:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzig.zza((Object) t, j, zzig.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 12:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzig.zza((Object) t, j, zzig.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 13:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzig.zza((Object) t, j, zzig.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 14:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzig.zza((Object) t, j, zzig.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 15:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzig.zza((Object) t, j, zzig.zzj(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 16:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzig.zza((Object) t, j, zzig.zzk(t2, j));
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
                        this.zztq.zza(t, t2, j);
                        break;
                    case 50:
                        zzhk.zza(this.zztr, t, t2, j);
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
                            zzig.zza((Object) t, j, zzig.zzo(t2, j));
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
                            zzig.zza((Object) t, j, zzig.zzo(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 68:
                        zzb(t, t2, i);
                        break;
                }
            }
            zzhk.zza(this.zzta, t, t2);
            if (this.zztb) {
                zzhk.zza(this.zztc, t, t2);
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    private final void zza(T t, T t2, int i) {
        long zzar = (long) (zzar(i) & 1048575);
        if (zza(t2, i)) {
            Object zzo = zzig.zzo(t, zzar);
            Object zzo2 = zzig.zzo(t2, zzar);
            if (zzo != null && zzo2 != null) {
                zzig.zza((Object) t, zzar, zzfj.zzb(zzo, zzo2));
                zzb(t, i);
            } else if (zzo2 != null) {
                zzig.zza((Object) t, zzar, zzo2);
                zzb(t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzar = zzar(i);
        int i2 = this.zztf[i];
        long j = (long) (zzar & 1048575);
        if (zza(t2, i2, i)) {
            Object zzo = zzig.zzo(t, j);
            Object zzo2 = zzig.zzo(t2, j);
            if (zzo != null && zzo2 != null) {
                zzig.zza((Object) t, j, zzfj.zzb(zzo, zzo2));
                zzb(t, i2, i);
            } else if (zzo2 != null) {
                zzig.zza((Object) t, j, zzo2);
                zzb(t, i2, i);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:398:0x0834, code lost:
        r9 = (r9 + r10) + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:418:0x090d, code lost:
        r13 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:434:0x0955, code lost:
        r5 = r5 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:472:0x0a02, code lost:
        r5 = r5 + r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:481:0x0a24, code lost:
        r3 = r3 + 3;
        r9 = r13;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzn(T r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            boolean r2 = r0.zztk
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 0
            r7 = 1
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r9 = 0
            r11 = 0
            if (r2 == 0) goto L_0x04f2
            sun.misc.Unsafe r2 = zzte
            r12 = 0
            r13 = 0
        L_0x0016:
            int[] r14 = r0.zztf
            int r14 = r14.length
            if (r12 >= r14) goto L_0x04ea
            int r14 = r0.zzar(r12)
            r15 = r14 & r3
            int r15 = r15 >>> 20
            int[] r3 = r0.zztf
            r3 = r3[r12]
            r14 = r14 & r8
            long r5 = (long) r14
            com.google.android.gms.internal.firebase-perf.zzff r14 = com.google.android.gms.internal.p010firebaseperf.zzff.DOUBLE_LIST_PACKED
            int r14 = r14.mo19941id()
            if (r15 < r14) goto L_0x0041
            com.google.android.gms.internal.firebase-perf.zzff r14 = com.google.android.gms.internal.p010firebaseperf.zzff.SINT64_LIST_PACKED
            int r14 = r14.mo19941id()
            if (r15 > r14) goto L_0x0041
            int[] r14 = r0.zztf
            int r17 = r12 + 2
            r14 = r14[r17]
            r14 = r14 & r8
            goto L_0x0042
        L_0x0041:
            r14 = 0
        L_0x0042:
            switch(r15) {
                case 0: goto L_0x04d6;
                case 1: goto L_0x04ca;
                case 2: goto L_0x04ba;
                case 3: goto L_0x04aa;
                case 4: goto L_0x049a;
                case 5: goto L_0x048e;
                case 6: goto L_0x0482;
                case 7: goto L_0x0476;
                case 8: goto L_0x0458;
                case 9: goto L_0x0444;
                case 10: goto L_0x0433;
                case 11: goto L_0x0424;
                case 12: goto L_0x0415;
                case 13: goto L_0x040a;
                case 14: goto L_0x03ff;
                case 15: goto L_0x03f0;
                case 16: goto L_0x03e1;
                case 17: goto L_0x03cc;
                case 18: goto L_0x03c1;
                case 19: goto L_0x03b8;
                case 20: goto L_0x03af;
                case 21: goto L_0x03a6;
                case 22: goto L_0x039d;
                case 23: goto L_0x0394;
                case 24: goto L_0x038b;
                case 25: goto L_0x0382;
                case 26: goto L_0x0379;
                case 27: goto L_0x036c;
                case 28: goto L_0x0363;
                case 29: goto L_0x035a;
                case 30: goto L_0x0350;
                case 31: goto L_0x0346;
                case 32: goto L_0x033c;
                case 33: goto L_0x0332;
                case 34: goto L_0x0328;
                case 35: goto L_0x0308;
                case 36: goto L_0x02eb;
                case 37: goto L_0x02ce;
                case 38: goto L_0x02b1;
                case 39: goto L_0x0293;
                case 40: goto L_0x0275;
                case 41: goto L_0x0257;
                case 42: goto L_0x0239;
                case 43: goto L_0x021b;
                case 44: goto L_0x01fd;
                case 45: goto L_0x01df;
                case 46: goto L_0x01c1;
                case 47: goto L_0x01a3;
                case 48: goto L_0x0185;
                case 49: goto L_0x0177;
                case 50: goto L_0x0167;
                case 51: goto L_0x0159;
                case 52: goto L_0x014d;
                case 53: goto L_0x013d;
                case 54: goto L_0x012d;
                case 55: goto L_0x011d;
                case 56: goto L_0x0111;
                case 57: goto L_0x0105;
                case 58: goto L_0x00f9;
                case 59: goto L_0x00db;
                case 60: goto L_0x00c7;
                case 61: goto L_0x00b5;
                case 62: goto L_0x00a5;
                case 63: goto L_0x0095;
                case 64: goto L_0x0089;
                case 65: goto L_0x007d;
                case 66: goto L_0x006d;
                case 67: goto L_0x005d;
                case 68: goto L_0x0047;
                default: goto L_0x0045;
            }
        L_0x0045:
            goto L_0x04e4
        L_0x0047:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r1, r5)
            com.google.android.gms.internal.firebase-perf.zzgs r5 = (com.google.android.gms.internal.p010firebaseperf.zzgs) r5
            com.google.android.gms.internal.firebase-perf.zzhi r6 = r0.zzap(r12)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzc(r3, r5, r6)
            goto L_0x03c9
        L_0x005d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzf((int) r3, (long) r5)
            goto L_0x03c9
        L_0x006d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzg(r1, r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzk(r3, r5)
            goto L_0x03c9
        L_0x007d:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzh((int) r3, (long) r9)
            goto L_0x03c9
        L_0x0089:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzm(r3, r11)
            goto L_0x03c9
        L_0x0095:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzg(r1, r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzn(r3, r5)
            goto L_0x03c9
        L_0x00a5:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzg(r1, r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzj(r3, r5)
            goto L_0x03c9
        L_0x00b5:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r1, r5)
            com.google.android.gms.internal.firebase-perf.zzee r5 = (com.google.android.gms.internal.p010firebaseperf.zzee) r5
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzc((int) r3, (com.google.android.gms.internal.p010firebaseperf.zzee) r5)
            goto L_0x03c9
        L_0x00c7:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r1, r5)
            com.google.android.gms.internal.firebase-perf.zzhi r6 = r0.zzap(r12)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzc((int) r3, (java.lang.Object) r5, (com.google.android.gms.internal.p010firebaseperf.zzhi) r6)
            goto L_0x03c9
        L_0x00db:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.p010firebaseperf.zzee
            if (r6 == 0) goto L_0x00f1
            com.google.android.gms.internal.firebase-perf.zzee r5 = (com.google.android.gms.internal.p010firebaseperf.zzee) r5
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzc((int) r3, (com.google.android.gms.internal.p010firebaseperf.zzee) r5)
            goto L_0x03c9
        L_0x00f1:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzb((int) r3, (java.lang.String) r5)
            goto L_0x03c9
        L_0x00f9:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzb((int) r3, (boolean) r7)
            goto L_0x03c9
        L_0x0105:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzl(r3, r11)
            goto L_0x03c9
        L_0x0111:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzg((int) r3, (long) r9)
            goto L_0x03c9
        L_0x011d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = zzg(r1, r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzi(r3, r5)
            goto L_0x03c9
        L_0x012d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zze((int) r3, (long) r5)
            goto L_0x03c9
        L_0x013d:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = zzh(r1, r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzd((int) r3, (long) r5)
            goto L_0x03c9
        L_0x014d:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzb((int) r3, (float) r4)
            goto L_0x03c9
        L_0x0159:
            boolean r5 = r0.zza(r1, (int) r3, (int) r12)
            if (r5 == 0) goto L_0x04e4
            r5 = 0
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzb((int) r3, (double) r5)
            goto L_0x03c9
        L_0x0167:
            com.google.android.gms.internal.firebase-perf.zzgl r14 = r0.zztr
            java.lang.Object r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r1, r5)
            java.lang.Object r6 = r0.zzaq(r12)
            int r3 = r14.zzb(r3, r5, r6)
            goto L_0x03c9
        L_0x0177:
            java.util.List r5 = zzd((java.lang.Object) r1, (long) r5)
            com.google.android.gms.internal.firebase-perf.zzhi r6 = r0.zzap(r12)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzd(r3, r5, r6)
            goto L_0x03c9
        L_0x0185:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p010firebaseperf.zzhk.zze(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztl
            if (r6 == 0) goto L_0x0199
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0199:
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzy(r3)
            int r6 = com.google.android.gms.internal.p010firebaseperf.zzev.zzaa(r5)
            goto L_0x0324
        L_0x01a3:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzi((java.util.List<java.lang.Integer>) r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztl
            if (r6 == 0) goto L_0x01b7
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01b7:
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzy(r3)
            int r6 = com.google.android.gms.internal.p010firebaseperf.zzev.zzaa(r5)
            goto L_0x0324
        L_0x01c1:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzk(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztl
            if (r6 == 0) goto L_0x01d5
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01d5:
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzy(r3)
            int r6 = com.google.android.gms.internal.p010firebaseperf.zzev.zzaa(r5)
            goto L_0x0324
        L_0x01df:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzj(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztl
            if (r6 == 0) goto L_0x01f3
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x01f3:
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzy(r3)
            int r6 = com.google.android.gms.internal.p010firebaseperf.zzev.zzaa(r5)
            goto L_0x0324
        L_0x01fd:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzf((java.util.List<java.lang.Integer>) r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztl
            if (r6 == 0) goto L_0x0211
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0211:
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzy(r3)
            int r6 = com.google.android.gms.internal.p010firebaseperf.zzev.zzaa(r5)
            goto L_0x0324
        L_0x021b:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzh(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztl
            if (r6 == 0) goto L_0x022f
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x022f:
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzy(r3)
            int r6 = com.google.android.gms.internal.p010firebaseperf.zzev.zzaa(r5)
            goto L_0x0324
        L_0x0239:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzl(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztl
            if (r6 == 0) goto L_0x024d
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x024d:
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzy(r3)
            int r6 = com.google.android.gms.internal.p010firebaseperf.zzev.zzaa(r5)
            goto L_0x0324
        L_0x0257:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzj(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztl
            if (r6 == 0) goto L_0x026b
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x026b:
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzy(r3)
            int r6 = com.google.android.gms.internal.p010firebaseperf.zzev.zzaa(r5)
            goto L_0x0324
        L_0x0275:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzk(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztl
            if (r6 == 0) goto L_0x0289
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0289:
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzy(r3)
            int r6 = com.google.android.gms.internal.p010firebaseperf.zzev.zzaa(r5)
            goto L_0x0324
        L_0x0293:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzg(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztl
            if (r6 == 0) goto L_0x02a7
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02a7:
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzy(r3)
            int r6 = com.google.android.gms.internal.p010firebaseperf.zzev.zzaa(r5)
            goto L_0x0324
        L_0x02b1:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzd(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztl
            if (r6 == 0) goto L_0x02c5
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02c5:
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzy(r3)
            int r6 = com.google.android.gms.internal.p010firebaseperf.zzev.zzaa(r5)
            goto L_0x0324
        L_0x02ce:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzc(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztl
            if (r6 == 0) goto L_0x02e2
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02e2:
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzy(r3)
            int r6 = com.google.android.gms.internal.p010firebaseperf.zzev.zzaa(r5)
            goto L_0x0324
        L_0x02eb:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzj(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztl
            if (r6 == 0) goto L_0x02ff
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x02ff:
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzy(r3)
            int r6 = com.google.android.gms.internal.p010firebaseperf.zzev.zzaa(r5)
            goto L_0x0324
        L_0x0308:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzk(r5)
            if (r5 <= 0) goto L_0x04e4
            boolean r6 = r0.zztl
            if (r6 == 0) goto L_0x031c
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x031c:
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzy(r3)
            int r6 = com.google.android.gms.internal.p010firebaseperf.zzev.zzaa(r5)
        L_0x0324:
            int r3 = r3 + r6
            int r3 = r3 + r5
            goto L_0x03c9
        L_0x0328:
            java.util.List r5 = zzd((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzq(r3, r5, r11)
            goto L_0x03c9
        L_0x0332:
            java.util.List r5 = zzd((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzu(r3, r5, r11)
            goto L_0x03c9
        L_0x033c:
            java.util.List r5 = zzd((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzw(r3, r5, r11)
            goto L_0x03c9
        L_0x0346:
            java.util.List r5 = zzd((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzv(r3, r5, r11)
            goto L_0x03c9
        L_0x0350:
            java.util.List r5 = zzd((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzr(r3, r5, r11)
            goto L_0x03c9
        L_0x035a:
            java.util.List r5 = zzd((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzt(r3, r5, r11)
            goto L_0x03c9
        L_0x0363:
            java.util.List r5 = zzd((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzd(r3, r5)
            goto L_0x03c9
        L_0x036c:
            java.util.List r5 = zzd((java.lang.Object) r1, (long) r5)
            com.google.android.gms.internal.firebase-perf.zzhi r6 = r0.zzap(r12)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzc((int) r3, (java.util.List<?>) r5, (com.google.android.gms.internal.p010firebaseperf.zzhi) r6)
            goto L_0x03c9
        L_0x0379:
            java.util.List r5 = zzd((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzc(r3, r5)
            goto L_0x03c9
        L_0x0382:
            java.util.List r5 = zzd((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzx(r3, r5, r11)
            goto L_0x03c9
        L_0x038b:
            java.util.List r5 = zzd((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzv(r3, r5, r11)
            goto L_0x03c9
        L_0x0394:
            java.util.List r5 = zzd((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzw(r3, r5, r11)
            goto L_0x03c9
        L_0x039d:
            java.util.List r5 = zzd((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzs(r3, r5, r11)
            goto L_0x03c9
        L_0x03a6:
            java.util.List r5 = zzd((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzp(r3, r5, r11)
            goto L_0x03c9
        L_0x03af:
            java.util.List r5 = zzd((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzo(r3, r5, r11)
            goto L_0x03c9
        L_0x03b8:
            java.util.List r5 = zzd((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzv(r3, r5, r11)
            goto L_0x03c9
        L_0x03c1:
            java.util.List r5 = zzd((java.lang.Object) r1, (long) r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzw(r3, r5, r11)
        L_0x03c9:
            int r13 = r13 + r3
            goto L_0x04e4
        L_0x03cc:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r1, r5)
            com.google.android.gms.internal.firebase-perf.zzgs r5 = (com.google.android.gms.internal.p010firebaseperf.zzgs) r5
            com.google.android.gms.internal.firebase-perf.zzhi r6 = r0.zzap(r12)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzc(r3, r5, r6)
            goto L_0x03c9
        L_0x03e1:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzf((int) r3, (long) r5)
            goto L_0x03c9
        L_0x03f0:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r1, r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzk(r3, r5)
            goto L_0x03c9
        L_0x03ff:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzh((int) r3, (long) r9)
            goto L_0x03c9
        L_0x040a:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzm(r3, r11)
            goto L_0x03c9
        L_0x0415:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r1, r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzn(r3, r5)
            goto L_0x03c9
        L_0x0424:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r1, r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzj(r3, r5)
            goto L_0x03c9
        L_0x0433:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r1, r5)
            com.google.android.gms.internal.firebase-perf.zzee r5 = (com.google.android.gms.internal.p010firebaseperf.zzee) r5
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzc((int) r3, (com.google.android.gms.internal.p010firebaseperf.zzee) r5)
            goto L_0x03c9
        L_0x0444:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r1, r5)
            com.google.android.gms.internal.firebase-perf.zzhi r6 = r0.zzap(r12)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzc((int) r3, (java.lang.Object) r5, (com.google.android.gms.internal.p010firebaseperf.zzhi) r6)
            goto L_0x03c9
        L_0x0458:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            java.lang.Object r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.p010firebaseperf.zzee
            if (r6 == 0) goto L_0x046e
            com.google.android.gms.internal.firebase-perf.zzee r5 = (com.google.android.gms.internal.p010firebaseperf.zzee) r5
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzc((int) r3, (com.google.android.gms.internal.p010firebaseperf.zzee) r5)
            goto L_0x03c9
        L_0x046e:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzb((int) r3, (java.lang.String) r5)
            goto L_0x03c9
        L_0x0476:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzb((int) r3, (boolean) r7)
            goto L_0x03c9
        L_0x0482:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzl(r3, r11)
            goto L_0x03c9
        L_0x048e:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzg((int) r3, (long) r9)
            goto L_0x03c9
        L_0x049a:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            int r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r1, r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzi(r3, r5)
            goto L_0x03c9
        L_0x04aa:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zze((int) r3, (long) r5)
            goto L_0x03c9
        L_0x04ba:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x04e4
            long r5 = com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r1, r5)
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzd((int) r3, (long) r5)
            goto L_0x03c9
        L_0x04ca:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzb((int) r3, (float) r4)
            goto L_0x03c9
        L_0x04d6:
            boolean r5 = r0.zza(r1, (int) r12)
            if (r5 == 0) goto L_0x04e4
            r5 = 0
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzev.zzb((int) r3, (double) r5)
            goto L_0x03c9
        L_0x04e4:
            int r12 = r12 + 3
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            goto L_0x0016
        L_0x04ea:
            com.google.android.gms.internal.firebase-perf.zzia<?, ?> r2 = r0.zzta
            int r1 = zza(r2, r1)
            int r13 = r13 + r1
            return r13
        L_0x04f2:
            sun.misc.Unsafe r2 = zzte
            r3 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            r12 = 0
        L_0x04fa:
            int[] r13 = r0.zztf
            int r13 = r13.length
            if (r3 >= r13) goto L_0x0a2b
            int r13 = r0.zzar(r3)
            int[] r14 = r0.zztf
            r15 = r14[r3]
            r16 = 267386880(0xff00000, float:2.3665827E-29)
            r17 = r13 & r16
            int r4 = r17 >>> 20
            r11 = 17
            if (r4 > r11) goto L_0x0526
            int r11 = r3 + 2
            r11 = r14[r11]
            r14 = r11 & r8
            int r18 = r11 >>> 20
            int r18 = r7 << r18
            if (r14 == r6) goto L_0x0523
            long r9 = (long) r14
            int r12 = r2.getInt(r1, r9)
            goto L_0x0524
        L_0x0523:
            r14 = r6
        L_0x0524:
            r6 = r14
            goto L_0x0546
        L_0x0526:
            boolean r9 = r0.zztl
            if (r9 == 0) goto L_0x0543
            com.google.android.gms.internal.firebase-perf.zzff r9 = com.google.android.gms.internal.p010firebaseperf.zzff.DOUBLE_LIST_PACKED
            int r9 = r9.mo19941id()
            if (r4 < r9) goto L_0x0543
            com.google.android.gms.internal.firebase-perf.zzff r9 = com.google.android.gms.internal.p010firebaseperf.zzff.SINT64_LIST_PACKED
            int r9 = r9.mo19941id()
            if (r4 > r9) goto L_0x0543
            int[] r9 = r0.zztf
            int r10 = r3 + 2
            r9 = r9[r10]
            r11 = r9 & r8
            goto L_0x0544
        L_0x0543:
            r11 = 0
        L_0x0544:
            r18 = 0
        L_0x0546:
            r9 = r13 & r8
            long r9 = (long) r9
            switch(r4) {
                case 0: goto L_0x0a15;
                case 1: goto L_0x0a05;
                case 2: goto L_0x09f3;
                case 3: goto L_0x09e3;
                case 4: goto L_0x09d3;
                case 5: goto L_0x09c4;
                case 6: goto L_0x09b8;
                case 7: goto L_0x09ae;
                case 8: goto L_0x0992;
                case 9: goto L_0x0980;
                case 10: goto L_0x0971;
                case 11: goto L_0x0964;
                case 12: goto L_0x0957;
                case 13: goto L_0x094c;
                case 14: goto L_0x0941;
                case 15: goto L_0x0934;
                case 16: goto L_0x0927;
                case 17: goto L_0x0914;
                case 18: goto L_0x0900;
                case 19: goto L_0x08f4;
                case 20: goto L_0x08e8;
                case 21: goto L_0x08dc;
                case 22: goto L_0x08d0;
                case 23: goto L_0x08c4;
                case 24: goto L_0x08b8;
                case 25: goto L_0x08ac;
                case 26: goto L_0x08a1;
                case 27: goto L_0x0892;
                case 28: goto L_0x0886;
                case 29: goto L_0x0879;
                case 30: goto L_0x086c;
                case 31: goto L_0x085f;
                case 32: goto L_0x0852;
                case 33: goto L_0x0845;
                case 34: goto L_0x0838;
                case 35: goto L_0x0818;
                case 36: goto L_0x07fb;
                case 37: goto L_0x07de;
                case 38: goto L_0x07c1;
                case 39: goto L_0x07a3;
                case 40: goto L_0x0785;
                case 41: goto L_0x0767;
                case 42: goto L_0x0749;
                case 43: goto L_0x072b;
                case 44: goto L_0x070d;
                case 45: goto L_0x06ef;
                case 46: goto L_0x06d1;
                case 47: goto L_0x06b3;
                case 48: goto L_0x0695;
                case 49: goto L_0x0685;
                case 50: goto L_0x0675;
                case 51: goto L_0x0667;
                case 52: goto L_0x065a;
                case 53: goto L_0x064a;
                case 54: goto L_0x063a;
                case 55: goto L_0x062a;
                case 56: goto L_0x061c;
                case 57: goto L_0x060f;
                case 58: goto L_0x0603;
                case 59: goto L_0x05e5;
                case 60: goto L_0x05d1;
                case 61: goto L_0x05bf;
                case 62: goto L_0x05af;
                case 63: goto L_0x059f;
                case 64: goto L_0x0592;
                case 65: goto L_0x0584;
                case 66: goto L_0x0574;
                case 67: goto L_0x0564;
                case 68: goto L_0x054e;
                default: goto L_0x054c;
            }
        L_0x054c:
            goto L_0x090c
        L_0x054e:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x090c
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.firebase-perf.zzgs r4 = (com.google.android.gms.internal.p010firebaseperf.zzgs) r4
            com.google.android.gms.internal.firebase-perf.zzhi r9 = r0.zzap(r3)
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzev.zzc(r15, r4, r9)
            goto L_0x090b
        L_0x0564:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x090c
            long r9 = zzh(r1, r9)
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzev.zzf((int) r15, (long) r9)
            goto L_0x090b
        L_0x0574:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x090c
            int r4 = zzg(r1, r9)
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzev.zzk(r15, r4)
            goto L_0x090b
        L_0x0584:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x090c
            r9 = 0
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzev.zzh((int) r15, (long) r9)
            goto L_0x090b
        L_0x0592:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x090c
            r4 = 0
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzev.zzm(r15, r4)
            goto L_0x0955
        L_0x059f:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x090c
            int r4 = zzg(r1, r9)
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzev.zzn(r15, r4)
            goto L_0x090b
        L_0x05af:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x090c
            int r4 = zzg(r1, r9)
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzev.zzj(r15, r4)
            goto L_0x090b
        L_0x05bf:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x090c
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.firebase-perf.zzee r4 = (com.google.android.gms.internal.p010firebaseperf.zzee) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzev.zzc((int) r15, (com.google.android.gms.internal.p010firebaseperf.zzee) r4)
            goto L_0x090b
        L_0x05d1:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x090c
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.firebase-perf.zzhi r9 = r0.zzap(r3)
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzc((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.p010firebaseperf.zzhi) r9)
            goto L_0x090b
        L_0x05e5:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x090c
            java.lang.Object r4 = r2.getObject(r1, r9)
            boolean r9 = r4 instanceof com.google.android.gms.internal.p010firebaseperf.zzee
            if (r9 == 0) goto L_0x05fb
            com.google.android.gms.internal.firebase-perf.zzee r4 = (com.google.android.gms.internal.p010firebaseperf.zzee) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzev.zzc((int) r15, (com.google.android.gms.internal.p010firebaseperf.zzee) r4)
            goto L_0x090b
        L_0x05fb:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzev.zzb((int) r15, (java.lang.String) r4)
            goto L_0x090b
        L_0x0603:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x090c
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzev.zzb((int) r15, (boolean) r7)
            goto L_0x090b
        L_0x060f:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x090c
            r4 = 0
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzev.zzl(r15, r4)
            goto L_0x0955
        L_0x061c:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x090c
            r9 = 0
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzev.zzg((int) r15, (long) r9)
            goto L_0x090b
        L_0x062a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x090c
            int r4 = zzg(r1, r9)
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzev.zzi(r15, r4)
            goto L_0x090b
        L_0x063a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x090c
            long r9 = zzh(r1, r9)
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzev.zze((int) r15, (long) r9)
            goto L_0x090b
        L_0x064a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x090c
            long r9 = zzh(r1, r9)
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzev.zzd((int) r15, (long) r9)
            goto L_0x090b
        L_0x065a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x090c
            r4 = 0
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzev.zzb((int) r15, (float) r4)
            goto L_0x0955
        L_0x0667:
            boolean r4 = r0.zza(r1, (int) r15, (int) r3)
            if (r4 == 0) goto L_0x090c
            r9 = 0
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzev.zzb((int) r15, (double) r9)
            goto L_0x090b
        L_0x0675:
            com.google.android.gms.internal.firebase-perf.zzgl r4 = r0.zztr
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.lang.Object r10 = r0.zzaq(r3)
            int r4 = r4.zzb(r15, r9, r10)
            goto L_0x090b
        L_0x0685:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase-perf.zzhi r9 = r0.zzap(r3)
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzd(r15, r4, r9)
            goto L_0x090b
        L_0x0695:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zze(r4)
            if (r4 <= 0) goto L_0x090c
            boolean r9 = r0.zztl
            if (r9 == 0) goto L_0x06a9
            long r9 = (long) r11
            r2.putInt(r1, r9, r4)
        L_0x06a9:
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzev.zzy(r15)
            int r10 = com.google.android.gms.internal.p010firebaseperf.zzev.zzaa(r4)
            goto L_0x0834
        L_0x06b3:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzi((java.util.List<java.lang.Integer>) r4)
            if (r4 <= 0) goto L_0x090c
            boolean r9 = r0.zztl
            if (r9 == 0) goto L_0x06c7
            long r9 = (long) r11
            r2.putInt(r1, r9, r4)
        L_0x06c7:
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzev.zzy(r15)
            int r10 = com.google.android.gms.internal.p010firebaseperf.zzev.zzaa(r4)
            goto L_0x0834
        L_0x06d1:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzk(r4)
            if (r4 <= 0) goto L_0x090c
            boolean r9 = r0.zztl
            if (r9 == 0) goto L_0x06e5
            long r9 = (long) r11
            r2.putInt(r1, r9, r4)
        L_0x06e5:
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzev.zzy(r15)
            int r10 = com.google.android.gms.internal.p010firebaseperf.zzev.zzaa(r4)
            goto L_0x0834
        L_0x06ef:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzj(r4)
            if (r4 <= 0) goto L_0x090c
            boolean r9 = r0.zztl
            if (r9 == 0) goto L_0x0703
            long r9 = (long) r11
            r2.putInt(r1, r9, r4)
        L_0x0703:
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzev.zzy(r15)
            int r10 = com.google.android.gms.internal.p010firebaseperf.zzev.zzaa(r4)
            goto L_0x0834
        L_0x070d:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzf((java.util.List<java.lang.Integer>) r4)
            if (r4 <= 0) goto L_0x090c
            boolean r9 = r0.zztl
            if (r9 == 0) goto L_0x0721
            long r9 = (long) r11
            r2.putInt(r1, r9, r4)
        L_0x0721:
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzev.zzy(r15)
            int r10 = com.google.android.gms.internal.p010firebaseperf.zzev.zzaa(r4)
            goto L_0x0834
        L_0x072b:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzh(r4)
            if (r4 <= 0) goto L_0x090c
            boolean r9 = r0.zztl
            if (r9 == 0) goto L_0x073f
            long r9 = (long) r11
            r2.putInt(r1, r9, r4)
        L_0x073f:
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzev.zzy(r15)
            int r10 = com.google.android.gms.internal.p010firebaseperf.zzev.zzaa(r4)
            goto L_0x0834
        L_0x0749:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzl(r4)
            if (r4 <= 0) goto L_0x090c
            boolean r9 = r0.zztl
            if (r9 == 0) goto L_0x075d
            long r9 = (long) r11
            r2.putInt(r1, r9, r4)
        L_0x075d:
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzev.zzy(r15)
            int r10 = com.google.android.gms.internal.p010firebaseperf.zzev.zzaa(r4)
            goto L_0x0834
        L_0x0767:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzj(r4)
            if (r4 <= 0) goto L_0x090c
            boolean r9 = r0.zztl
            if (r9 == 0) goto L_0x077b
            long r9 = (long) r11
            r2.putInt(r1, r9, r4)
        L_0x077b:
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzev.zzy(r15)
            int r10 = com.google.android.gms.internal.p010firebaseperf.zzev.zzaa(r4)
            goto L_0x0834
        L_0x0785:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzk(r4)
            if (r4 <= 0) goto L_0x090c
            boolean r9 = r0.zztl
            if (r9 == 0) goto L_0x0799
            long r9 = (long) r11
            r2.putInt(r1, r9, r4)
        L_0x0799:
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzev.zzy(r15)
            int r10 = com.google.android.gms.internal.p010firebaseperf.zzev.zzaa(r4)
            goto L_0x0834
        L_0x07a3:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzg(r4)
            if (r4 <= 0) goto L_0x090c
            boolean r9 = r0.zztl
            if (r9 == 0) goto L_0x07b7
            long r9 = (long) r11
            r2.putInt(r1, r9, r4)
        L_0x07b7:
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzev.zzy(r15)
            int r10 = com.google.android.gms.internal.p010firebaseperf.zzev.zzaa(r4)
            goto L_0x0834
        L_0x07c1:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzd(r4)
            if (r4 <= 0) goto L_0x090c
            boolean r9 = r0.zztl
            if (r9 == 0) goto L_0x07d5
            long r9 = (long) r11
            r2.putInt(r1, r9, r4)
        L_0x07d5:
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzev.zzy(r15)
            int r10 = com.google.android.gms.internal.p010firebaseperf.zzev.zzaa(r4)
            goto L_0x0834
        L_0x07de:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzc(r4)
            if (r4 <= 0) goto L_0x090c
            boolean r9 = r0.zztl
            if (r9 == 0) goto L_0x07f2
            long r9 = (long) r11
            r2.putInt(r1, r9, r4)
        L_0x07f2:
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzev.zzy(r15)
            int r10 = com.google.android.gms.internal.p010firebaseperf.zzev.zzaa(r4)
            goto L_0x0834
        L_0x07fb:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzj(r4)
            if (r4 <= 0) goto L_0x090c
            boolean r9 = r0.zztl
            if (r9 == 0) goto L_0x080f
            long r9 = (long) r11
            r2.putInt(r1, r9, r4)
        L_0x080f:
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzev.zzy(r15)
            int r10 = com.google.android.gms.internal.p010firebaseperf.zzev.zzaa(r4)
            goto L_0x0834
        L_0x0818:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzk(r4)
            if (r4 <= 0) goto L_0x090c
            boolean r9 = r0.zztl
            if (r9 == 0) goto L_0x082c
            long r9 = (long) r11
            r2.putInt(r1, r9, r4)
        L_0x082c:
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzev.zzy(r15)
            int r10 = com.google.android.gms.internal.p010firebaseperf.zzev.zzaa(r4)
        L_0x0834:
            int r9 = r9 + r10
            int r9 = r9 + r4
            goto L_0x0955
        L_0x0838:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            r11 = 0
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzq(r15, r4, r11)
            goto L_0x090b
        L_0x0845:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzu(r15, r4, r11)
            goto L_0x090b
        L_0x0852:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzw(r15, r4, r11)
            goto L_0x090b
        L_0x085f:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzv(r15, r4, r11)
            goto L_0x090b
        L_0x086c:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzr(r15, r4, r11)
            goto L_0x090b
        L_0x0879:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzt(r15, r4, r11)
            goto L_0x090b
        L_0x0886:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzd(r15, r4)
            goto L_0x090b
        L_0x0892:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase-perf.zzhi r9 = r0.zzap(r3)
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzc((int) r15, (java.util.List<?>) r4, (com.google.android.gms.internal.p010firebaseperf.zzhi) r9)
            goto L_0x090b
        L_0x08a1:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzc(r15, r4)
            goto L_0x090b
        L_0x08ac:
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            r11 = 0
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzx(r15, r4, r11)
            goto L_0x090b
        L_0x08b8:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzv(r15, r4, r11)
            goto L_0x090b
        L_0x08c4:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzw(r15, r4, r11)
            goto L_0x090b
        L_0x08d0:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzs(r15, r4, r11)
            goto L_0x090b
        L_0x08dc:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzp(r15, r4, r11)
            goto L_0x090b
        L_0x08e8:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzo(r15, r4, r11)
            goto L_0x090b
        L_0x08f4:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzv(r15, r4, r11)
            goto L_0x090b
        L_0x0900:
            r11 = 0
            java.lang.Object r4 = r2.getObject(r1, r9)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzw(r15, r4, r11)
        L_0x090b:
            int r5 = r5 + r4
        L_0x090c:
            r4 = 0
        L_0x090d:
            r9 = 0
            r10 = 0
            r13 = 0
            goto L_0x0a24
        L_0x0914:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090c
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.firebase-perf.zzgs r4 = (com.google.android.gms.internal.p010firebaseperf.zzgs) r4
            com.google.android.gms.internal.firebase-perf.zzhi r9 = r0.zzap(r3)
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzev.zzc(r15, r4, r9)
            goto L_0x090b
        L_0x0927:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090c
            long r9 = r2.getLong(r1, r9)
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzev.zzf((int) r15, (long) r9)
            goto L_0x090b
        L_0x0934:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090c
            int r4 = r2.getInt(r1, r9)
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzev.zzk(r15, r4)
            goto L_0x090b
        L_0x0941:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090c
            r9 = 0
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzev.zzh((int) r15, (long) r9)
            goto L_0x090b
        L_0x094c:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090c
            r4 = 0
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzev.zzm(r15, r4)
        L_0x0955:
            int r5 = r5 + r9
            goto L_0x090c
        L_0x0957:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090c
            int r4 = r2.getInt(r1, r9)
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzev.zzn(r15, r4)
            goto L_0x090b
        L_0x0964:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090c
            int r4 = r2.getInt(r1, r9)
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzev.zzj(r15, r4)
            goto L_0x090b
        L_0x0971:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090c
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.firebase-perf.zzee r4 = (com.google.android.gms.internal.p010firebaseperf.zzee) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzev.zzc((int) r15, (com.google.android.gms.internal.p010firebaseperf.zzee) r4)
            goto L_0x090b
        L_0x0980:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090c
            java.lang.Object r4 = r2.getObject(r1, r9)
            com.google.android.gms.internal.firebase-perf.zzhi r9 = r0.zzap(r3)
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzhk.zzc((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.p010firebaseperf.zzhi) r9)
            goto L_0x090b
        L_0x0992:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090c
            java.lang.Object r4 = r2.getObject(r1, r9)
            boolean r9 = r4 instanceof com.google.android.gms.internal.p010firebaseperf.zzee
            if (r9 == 0) goto L_0x09a6
            com.google.android.gms.internal.firebase-perf.zzee r4 = (com.google.android.gms.internal.p010firebaseperf.zzee) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzev.zzc((int) r15, (com.google.android.gms.internal.p010firebaseperf.zzee) r4)
            goto L_0x090b
        L_0x09a6:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzev.zzb((int) r15, (java.lang.String) r4)
            goto L_0x090b
        L_0x09ae:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090c
            int r4 = com.google.android.gms.internal.p010firebaseperf.zzev.zzb((int) r15, (boolean) r7)
            goto L_0x090b
        L_0x09b8:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x090c
            r4 = 0
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzev.zzl(r15, r4)
            int r5 = r5 + r9
            goto L_0x090d
        L_0x09c4:
            r4 = 0
            r9 = r12 & r18
            if (r9 == 0) goto L_0x09d0
            r13 = 0
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzev.zzg((int) r15, (long) r13)
            goto L_0x0a02
        L_0x09d0:
            r13 = 0
            goto L_0x0a03
        L_0x09d3:
            r4 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a03
            int r9 = r2.getInt(r1, r9)
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzev.zzi(r15, r9)
            goto L_0x0a02
        L_0x09e3:
            r4 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a03
            long r9 = r2.getLong(r1, r9)
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzev.zze((int) r15, (long) r9)
            goto L_0x0a02
        L_0x09f3:
            r4 = 0
            r13 = 0
            r11 = r12 & r18
            if (r11 == 0) goto L_0x0a03
            long r9 = r2.getLong(r1, r9)
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzev.zzd((int) r15, (long) r9)
        L_0x0a02:
            int r5 = r5 + r9
        L_0x0a03:
            r9 = 0
            goto L_0x0a12
        L_0x0a05:
            r4 = 0
            r13 = 0
            r9 = r12 & r18
            if (r9 == 0) goto L_0x0a03
            r9 = 0
            int r10 = com.google.android.gms.internal.p010firebaseperf.zzev.zzb((int) r15, (float) r9)
            int r5 = r5 + r10
        L_0x0a12:
            r10 = 0
            goto L_0x0a24
        L_0x0a15:
            r4 = 0
            r9 = 0
            r13 = 0
            r10 = r12 & r18
            if (r10 == 0) goto L_0x0a12
            r10 = 0
            int r15 = com.google.android.gms.internal.p010firebaseperf.zzev.zzb((int) r15, (double) r10)
            int r5 = r5 + r15
        L_0x0a24:
            int r3 = r3 + 3
            r9 = r13
            r4 = 0
            r11 = 0
            goto L_0x04fa
        L_0x0a2b:
            r4 = 0
            com.google.android.gms.internal.firebase-perf.zzia<?, ?> r2 = r0.zzta
            int r2 = zza(r2, r1)
            int r5 = r5 + r2
            boolean r2 = r0.zztb
            if (r2 == 0) goto L_0x0a85
            com.google.android.gms.internal.firebase-perf.zzez<?> r2 = r0.zztc
            com.google.android.gms.internal.firebase-perf.zzfa r1 = r2.zzd(r1)
            r2 = 0
        L_0x0a3e:
            com.google.android.gms.internal.firebase-perf.zzhj<T, java.lang.Object> r3 = r1.zznv
            int r3 = r3.zzit()
            if (r4 >= r3) goto L_0x0a5e
            com.google.android.gms.internal.firebase-perf.zzhj<T, java.lang.Object> r3 = r1.zznv
            java.util.Map$Entry r3 = r3.zzau(r4)
            java.lang.Object r6 = r3.getKey()
            com.google.android.gms.internal.firebase-perf.zzfc r6 = (com.google.android.gms.internal.p010firebaseperf.zzfc) r6
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzfa.zzb((com.google.android.gms.internal.p010firebaseperf.zzfc<?>) r6, (java.lang.Object) r3)
            int r2 = r2 + r3
            int r4 = r4 + 1
            goto L_0x0a3e
        L_0x0a5e:
            com.google.android.gms.internal.firebase-perf.zzhj<T, java.lang.Object> r1 = r1.zznv
            java.lang.Iterable r1 = r1.zziu()
            java.util.Iterator r1 = r1.iterator()
        L_0x0a68:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0a84
            java.lang.Object r3 = r1.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            com.google.android.gms.internal.firebase-perf.zzfc r4 = (com.google.android.gms.internal.p010firebaseperf.zzfc) r4
            java.lang.Object r3 = r3.getValue()
            int r3 = com.google.android.gms.internal.p010firebaseperf.zzfa.zzb((com.google.android.gms.internal.p010firebaseperf.zzfc<?>) r4, (java.lang.Object) r3)
            int r2 = r2 + r3
            goto L_0x0a68
        L_0x0a84:
            int r5 = r5 + r2
        L_0x0a85:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p010firebaseperf.zzgw.zzn(java.lang.Object):int");
    }

    private static <UT, UB> int zza(zzia<UT, UB> zzia, T t) {
        return zzia.zzn(zzia.zzp(t));
    }

    private static List<?> zzd(Object obj, long j) {
        return (List) zzig.zzo(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0553  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.p010firebaseperf.zziu r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zzgx()
            int r1 = com.google.android.gms.internal.p010firebaseperf.zzhe.zzub
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x0529
            com.google.android.gms.internal.firebase-perf.zzia<?, ?> r0 = r13.zzta
            zza(r0, r14, (com.google.android.gms.internal.p010firebaseperf.zziu) r15)
            boolean r0 = r13.zztb
            if (r0 == 0) goto L_0x0032
            com.google.android.gms.internal.firebase-perf.zzez<?> r0 = r13.zztc
            com.google.android.gms.internal.firebase-perf.zzfa r0 = r0.zzd(r14)
            com.google.android.gms.internal.firebase-perf.zzhj<T, java.lang.Object> r1 = r0.zznv
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0032
            java.util.Iterator r0 = r0.descendingIterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0034
        L_0x0032:
            r0 = r3
            r1 = r0
        L_0x0034:
            int[] r7 = r13.zztf
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0039:
            if (r7 < 0) goto L_0x0511
            int r8 = r13.zzar(r7)
            int[] r9 = r13.zztf
            r9 = r9[r7]
        L_0x0043:
            if (r1 == 0) goto L_0x0061
            com.google.android.gms.internal.firebase-perf.zzez<?> r10 = r13.zztc
            int r10 = r10.zzb(r1)
            if (r10 <= r9) goto L_0x0061
            com.google.android.gms.internal.firebase-perf.zzez<?> r10 = r13.zztc
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
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            com.google.android.gms.internal.firebase-perf.zzhi r10 = r13.zzap(r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.p010firebaseperf.zzhi) r10)
            goto L_0x050d
        L_0x007f:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x050d
        L_0x0090:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            r15.zzg(r9, r8)
            goto L_0x050d
        L_0x00a1:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            r15.zzj(r9, r10)
            goto L_0x050d
        L_0x00b2:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            r15.zzo(r9, r8)
            goto L_0x050d
        L_0x00c3:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            r15.zzp(r9, r8)
            goto L_0x050d
        L_0x00d4:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            r15.zzf(r9, r8)
            goto L_0x050d
        L_0x00e5:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            com.google.android.gms.internal.firebase-perf.zzee r8 = (com.google.android.gms.internal.p010firebaseperf.zzee) r8
            r15.zza((int) r9, (com.google.android.gms.internal.p010firebaseperf.zzee) r8)
            goto L_0x050d
        L_0x00f8:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            com.google.android.gms.internal.firebase-perf.zzhi r10 = r13.zzap(r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.p010firebaseperf.zzhi) r10)
            goto L_0x050d
        L_0x010d:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.p010firebaseperf.zziu) r15)
            goto L_0x050d
        L_0x011e:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzi(r14, r10)
            r15.zza((int) r9, (boolean) r8)
            goto L_0x050d
        L_0x012f:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            r15.zzh(r9, r8)
            goto L_0x050d
        L_0x0140:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            r15.zzc(r9, r10)
            goto L_0x050d
        L_0x0151:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            r15.zze(r9, r8)
            goto L_0x050d
        L_0x0162:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x050d
        L_0x0173:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            r15.zzi(r9, r10)
            goto L_0x050d
        L_0x0184:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzf(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x050d
        L_0x0195:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zze(r14, r10)
            r15.zza((int) r9, (double) r10)
            goto L_0x050d
        L_0x01a6:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            r13.zza(r15, r9, r8, r7)
            goto L_0x050d
        L_0x01b1:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzhi r10 = r13.zzap(r7)
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzb((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.p010firebaseperf.zziu) r15, (com.google.android.gms.internal.p010firebaseperf.zzhi) r10)
            goto L_0x050d
        L_0x01c6:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zze(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01d7:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzj(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01e8:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzg(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01f9:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzl(r9, r8, r15, r4)
            goto L_0x050d
        L_0x020a:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzm(r9, r8, r15, r4)
            goto L_0x050d
        L_0x021b:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzi(r9, r8, r15, r4)
            goto L_0x050d
        L_0x022c:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzn(r9, r8, r15, r4)
            goto L_0x050d
        L_0x023d:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzk(r9, r8, r15, r4)
            goto L_0x050d
        L_0x024e:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzf(r9, r8, r15, r4)
            goto L_0x050d
        L_0x025f:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzh(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0270:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzd(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0281:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzc(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0292:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.p010firebaseperf.zziu) r15, (boolean) r4)
            goto L_0x050d
        L_0x02a3:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.p010firebaseperf.zziu) r15, (boolean) r4)
            goto L_0x050d
        L_0x02b4:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zze(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02c5:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzj(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02d6:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzg(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02e7:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzl(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02f8:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzm(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0309:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzi(r9, r8, r15, r5)
            goto L_0x050d
        L_0x031a:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzb(r9, r8, r15)
            goto L_0x050d
        L_0x032b:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase-perf.zzhi r10 = r13.zzap(r7)
            com.google.android.gms.internal.p010firebaseperf.zzhk.zza((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.p010firebaseperf.zziu) r15, (com.google.android.gms.internal.p010firebaseperf.zzhi) r10)
            goto L_0x050d
        L_0x0340:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zza((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.p010firebaseperf.zziu) r15)
            goto L_0x050d
        L_0x0351:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzn(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0362:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzk(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0373:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzf(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0384:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzh(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0395:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzd(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03a6:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzc(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03b7:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.p010firebaseperf.zziu) r15, (boolean) r5)
            goto L_0x050d
        L_0x03c8:
            int[] r9 = r13.zztf
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.p010firebaseperf.zzhk.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.p010firebaseperf.zziu) r15, (boolean) r5)
            goto L_0x050d
        L_0x03d9:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            com.google.android.gms.internal.firebase-perf.zzhi r10 = r13.zzap(r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.p010firebaseperf.zzhi) r10)
            goto L_0x050d
        L_0x03ee:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x050d
        L_0x03ff:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r14, r10)
            r15.zzg(r9, r8)
            goto L_0x050d
        L_0x0410:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r14, r10)
            r15.zzj(r9, r10)
            goto L_0x050d
        L_0x0421:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r14, r10)
            r15.zzo(r9, r8)
            goto L_0x050d
        L_0x0432:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r14, r10)
            r15.zzp(r9, r8)
            goto L_0x050d
        L_0x0443:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r14, r10)
            r15.zzf(r9, r8)
            goto L_0x050d
        L_0x0454:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            com.google.android.gms.internal.firebase-perf.zzee r8 = (com.google.android.gms.internal.p010firebaseperf.zzee) r8
            r15.zza((int) r9, (com.google.android.gms.internal.p010firebaseperf.zzee) r8)
            goto L_0x050d
        L_0x0467:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            com.google.android.gms.internal.firebase-perf.zzhi r10 = r13.zzap(r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.p010firebaseperf.zzhi) r10)
            goto L_0x050d
        L_0x047c:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.p010firebaseperf.zziu) r15)
            goto L_0x050d
        L_0x048d:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzl(r14, r10)
            r15.zza((int) r9, (boolean) r8)
            goto L_0x050d
        L_0x049e:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r14, r10)
            r15.zzh(r9, r8)
            goto L_0x050d
        L_0x04ae:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r14, r10)
            r15.zzc(r9, r10)
            goto L_0x050d
        L_0x04be:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r14, r10)
            r15.zze(r9, r8)
            goto L_0x050d
        L_0x04ce:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x050d
        L_0x04de:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r14, r10)
            r15.zzi(r9, r10)
            goto L_0x050d
        L_0x04ee:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.p010firebaseperf.zzig.zzm(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x050d
        L_0x04fe:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.p010firebaseperf.zzig.zzn(r14, r10)
            r15.zza((int) r9, (double) r10)
        L_0x050d:
            int r7 = r7 + -3
            goto L_0x0039
        L_0x0511:
            if (r1 == 0) goto L_0x0528
            com.google.android.gms.internal.firebase-perf.zzez<?> r14 = r13.zztc
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
            boolean r0 = r13.zztk
            if (r0 == 0) goto L_0x0a46
            boolean r0 = r13.zztb
            if (r0 == 0) goto L_0x054a
            com.google.android.gms.internal.firebase-perf.zzez<?> r0 = r13.zztc
            com.google.android.gms.internal.firebase-perf.zzfa r0 = r0.zzd(r14)
            com.google.android.gms.internal.firebase-perf.zzhj<T, java.lang.Object> r1 = r0.zznv
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x054a
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x054c
        L_0x054a:
            r0 = r3
            r1 = r0
        L_0x054c:
            int[] r7 = r13.zztf
            int r7 = r7.length
            r8 = r1
            r1 = 0
        L_0x0551:
            if (r1 >= r7) goto L_0x0a29
            int r9 = r13.zzar(r1)
            int[] r10 = r13.zztf
            r10 = r10[r1]
        L_0x055b:
            if (r8 == 0) goto L_0x0579
            com.google.android.gms.internal.firebase-perf.zzez<?> r11 = r13.zztc
            int r11 = r11.zzb(r8)
            if (r11 > r10) goto L_0x0579
            com.google.android.gms.internal.firebase-perf.zzez<?> r11 = r13.zztc
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
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            com.google.android.gms.internal.firebase-perf.zzhi r11 = r13.zzap(r1)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.p010firebaseperf.zzhi) r11)
            goto L_0x0a25
        L_0x0597:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0a25
        L_0x05a8:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            r15.zzg(r10, r9)
            goto L_0x0a25
        L_0x05b9:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            r15.zzj(r10, r11)
            goto L_0x0a25
        L_0x05ca:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            r15.zzo(r10, r9)
            goto L_0x0a25
        L_0x05db:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            r15.zzp(r10, r9)
            goto L_0x0a25
        L_0x05ec:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            r15.zzf(r10, r9)
            goto L_0x0a25
        L_0x05fd:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            com.google.android.gms.internal.firebase-perf.zzee r9 = (com.google.android.gms.internal.p010firebaseperf.zzee) r9
            r15.zza((int) r10, (com.google.android.gms.internal.p010firebaseperf.zzee) r9)
            goto L_0x0a25
        L_0x0610:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            com.google.android.gms.internal.firebase-perf.zzhi r11 = r13.zzap(r1)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.p010firebaseperf.zzhi) r11)
            goto L_0x0a25
        L_0x0625:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.p010firebaseperf.zziu) r15)
            goto L_0x0a25
        L_0x0636:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzi(r14, r11)
            r15.zza((int) r10, (boolean) r9)
            goto L_0x0a25
        L_0x0647:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            r15.zzh(r10, r9)
            goto L_0x0a25
        L_0x0658:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            r15.zzc(r10, r11)
            goto L_0x0a25
        L_0x0669:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            r15.zze(r10, r9)
            goto L_0x0a25
        L_0x067a:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0a25
        L_0x068b:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            r15.zzi(r10, r11)
            goto L_0x0a25
        L_0x069c:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzf(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0a25
        L_0x06ad:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zze(r14, r11)
            r15.zza((int) r10, (double) r11)
            goto L_0x0a25
        L_0x06be:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            r13.zza(r15, r10, r9, r1)
            goto L_0x0a25
        L_0x06c9:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase-perf.zzhi r11 = r13.zzap(r1)
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzb((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.p010firebaseperf.zziu) r15, (com.google.android.gms.internal.p010firebaseperf.zzhi) r11)
            goto L_0x0a25
        L_0x06de:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zze(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x06ef:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzj(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0700:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzg(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0711:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzl(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0722:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzm(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0733:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzi(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0744:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzn(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0755:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzk(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0766:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzf(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0777:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzh(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0788:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzd(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x0799:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzc(r10, r9, r15, r4)
            goto L_0x0a25
        L_0x07aa:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.p010firebaseperf.zziu) r15, (boolean) r4)
            goto L_0x0a25
        L_0x07bb:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.p010firebaseperf.zziu) r15, (boolean) r4)
            goto L_0x0a25
        L_0x07cc:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zze(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x07dd:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzj(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x07ee:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzg(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x07ff:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzl(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x0810:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzm(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x0821:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzi(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x0832:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzb(r10, r9, r15)
            goto L_0x0a25
        L_0x0843:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase-perf.zzhi r11 = r13.zzap(r1)
            com.google.android.gms.internal.p010firebaseperf.zzhk.zza((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.p010firebaseperf.zziu) r15, (com.google.android.gms.internal.p010firebaseperf.zzhi) r11)
            goto L_0x0a25
        L_0x0858:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zza((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.p010firebaseperf.zziu) r15)
            goto L_0x0a25
        L_0x0869:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzn(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x087a:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzk(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x088b:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzf(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x089c:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzh(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x08ad:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzd(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x08be:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzc(r10, r9, r15, r5)
            goto L_0x0a25
        L_0x08cf:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.p010firebaseperf.zziu) r15, (boolean) r5)
            goto L_0x0a25
        L_0x08e0:
            int[] r10 = r13.zztf
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.p010firebaseperf.zziu) r15, (boolean) r5)
            goto L_0x0a25
        L_0x08f1:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            com.google.android.gms.internal.firebase-perf.zzhi r11 = r13.zzap(r1)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.p010firebaseperf.zzhi) r11)
            goto L_0x0a25
        L_0x0906:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0a25
        L_0x0917:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r14, r11)
            r15.zzg(r10, r9)
            goto L_0x0a25
        L_0x0928:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r14, r11)
            r15.zzj(r10, r11)
            goto L_0x0a25
        L_0x0939:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r14, r11)
            r15.zzo(r10, r9)
            goto L_0x0a25
        L_0x094a:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r14, r11)
            r15.zzp(r10, r9)
            goto L_0x0a25
        L_0x095b:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r14, r11)
            r15.zzf(r10, r9)
            goto L_0x0a25
        L_0x096c:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            com.google.android.gms.internal.firebase-perf.zzee r9 = (com.google.android.gms.internal.p010firebaseperf.zzee) r9
            r15.zza((int) r10, (com.google.android.gms.internal.p010firebaseperf.zzee) r9)
            goto L_0x0a25
        L_0x097f:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            com.google.android.gms.internal.firebase-perf.zzhi r11 = r13.zzap(r1)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.p010firebaseperf.zzhi) r11)
            goto L_0x0a25
        L_0x0994:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzo(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.p010firebaseperf.zziu) r15)
            goto L_0x0a25
        L_0x09a5:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzl(r14, r11)
            r15.zza((int) r10, (boolean) r9)
            goto L_0x0a25
        L_0x09b6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r14, r11)
            r15.zzh(r10, r9)
            goto L_0x0a25
        L_0x09c6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r14, r11)
            r15.zzc(r10, r11)
            goto L_0x0a25
        L_0x09d6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzj(r14, r11)
            r15.zze(r10, r9)
            goto L_0x0a25
        L_0x09e6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0a25
        L_0x09f6:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.p010firebaseperf.zzig.zzk(r14, r11)
            r15.zzi(r10, r11)
            goto L_0x0a25
        L_0x0a06:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzm(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0a25
        L_0x0a16:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0a25
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.p010firebaseperf.zzig.zzn(r14, r11)
            r15.zza((int) r10, (double) r11)
        L_0x0a25:
            int r1 = r1 + 3
            goto L_0x0551
        L_0x0a29:
            if (r8 == 0) goto L_0x0a40
            com.google.android.gms.internal.firebase-perf.zzez<?> r1 = r13.zztc
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
            com.google.android.gms.internal.firebase-perf.zzia<?, ?> r0 = r13.zzta
            zza(r0, r14, (com.google.android.gms.internal.p010firebaseperf.zziu) r15)
            return
        L_0x0a46:
            r13.zzb(r14, (com.google.android.gms.internal.p010firebaseperf.zziu) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p010firebaseperf.zzgw.zza(java.lang.Object, com.google.android.gms.internal.firebase-perf.zziu):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:172:0x049f  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0032  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r18, com.google.android.gms.internal.p010firebaseperf.zziu r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.zztb
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.firebase-perf.zzez<?> r3 = r0.zztc
            com.google.android.gms.internal.firebase-perf.zzfa r3 = r3.zzd(r1)
            com.google.android.gms.internal.firebase-perf.zzhj<T, java.lang.Object> r5 = r3.zznv
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0023
            java.util.Iterator r3 = r3.iterator()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0025
        L_0x0023:
            r3 = 0
            r5 = 0
        L_0x0025:
            int[] r6 = r0.zztf
            int r6 = r6.length
            sun.misc.Unsafe r7 = zzte
            r11 = r5
            r5 = 0
            r10 = 1048575(0xfffff, float:1.469367E-39)
            r12 = 0
        L_0x0030:
            if (r5 >= r6) goto L_0x049c
            int r13 = r0.zzar(r5)
            int[] r14 = r0.zztf
            r15 = r14[r5]
            r16 = 267386880(0xff00000, float:2.3665827E-29)
            r16 = r13 & r16
            int r4 = r16 >>> 20
            boolean r9 = r0.zztk
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
            com.google.android.gms.internal.firebase-perf.zzez<?> r8 = r0.zztc
            int r8 = r8.zzb(r11)
            if (r8 > r15) goto L_0x0086
            com.google.android.gms.internal.firebase-perf.zzez<?> r8 = r0.zztc
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
            com.google.android.gms.internal.firebase-perf.zzhi r9 = r0.zzap(r5)
            r2.zzb((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.p010firebaseperf.zzhi) r9)
            goto L_0x008e
        L_0x00a3:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r13 = zzh(r1, r13)
            r2.zzb((int) r15, (long) r13)
            goto L_0x008e
        L_0x00b1:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzg(r1, r13)
            r2.zzg(r15, r4)
            goto L_0x008e
        L_0x00bf:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r13 = zzh(r1, r13)
            r2.zzj(r15, r13)
            goto L_0x008e
        L_0x00cd:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzg(r1, r13)
            r2.zzo(r15, r4)
            goto L_0x008e
        L_0x00db:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzg(r1, r13)
            r2.zzp(r15, r4)
            goto L_0x008e
        L_0x00e9:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzg(r1, r13)
            r2.zzf(r15, r4)
            goto L_0x008e
        L_0x00f7:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.firebase-perf.zzee r4 = (com.google.android.gms.internal.p010firebaseperf.zzee) r4
            r2.zza((int) r15, (com.google.android.gms.internal.p010firebaseperf.zzee) r4)
            goto L_0x008e
        L_0x0107:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.firebase-perf.zzhi r9 = r0.zzap(r5)
            r2.zza((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.p010firebaseperf.zzhi) r9)
            goto L_0x008e
        L_0x011a:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r7.getObject(r1, r13)
            zza((int) r15, (java.lang.Object) r4, (com.google.android.gms.internal.p010firebaseperf.zziu) r2)
            goto L_0x008e
        L_0x0129:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            boolean r4 = zzi(r1, r13)
            r2.zza((int) r15, (boolean) r4)
            goto L_0x008e
        L_0x0138:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzg(r1, r13)
            r2.zzh(r15, r4)
            goto L_0x008e
        L_0x0147:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r13 = zzh(r1, r13)
            r2.zzc(r15, r13)
            goto L_0x008e
        L_0x0156:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            int r4 = zzg(r1, r13)
            r2.zze(r15, r4)
            goto L_0x008e
        L_0x0165:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r13 = zzh(r1, r13)
            r2.zza((int) r15, (long) r13)
            goto L_0x008e
        L_0x0174:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            long r13 = zzh(r1, r13)
            r2.zzi(r15, r13)
            goto L_0x008e
        L_0x0183:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            float r4 = zzf(r1, r13)
            r2.zza((int) r15, (float) r4)
            goto L_0x008e
        L_0x0192:
            boolean r4 = r0.zza(r1, (int) r15, (int) r5)
            if (r4 == 0) goto L_0x008e
            double r13 = zze(r1, r13)
            r2.zza((int) r15, (double) r13)
            goto L_0x008e
        L_0x01a1:
            java.lang.Object r4 = r7.getObject(r1, r13)
            r0.zza(r2, r15, r4, r5)
            goto L_0x008e
        L_0x01aa:
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase-perf.zzhi r13 = r0.zzap(r5)
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzb((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.p010firebaseperf.zziu) r2, (com.google.android.gms.internal.p010firebaseperf.zzhi) r13)
            goto L_0x008e
        L_0x01bd:
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r15 = 1
            com.google.android.gms.internal.p010firebaseperf.zzhk.zze(r4, r9, r2, r15)
            goto L_0x008e
        L_0x01cd:
            r15 = 1
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzj(r4, r9, r2, r15)
            goto L_0x008e
        L_0x01dd:
            r15 = 1
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzg(r4, r9, r2, r15)
            goto L_0x008e
        L_0x01ed:
            r15 = 1
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzl(r4, r9, r2, r15)
            goto L_0x008e
        L_0x01fd:
            r15 = 1
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzm(r4, r9, r2, r15)
            goto L_0x008e
        L_0x020d:
            r15 = 1
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzi(r4, r9, r2, r15)
            goto L_0x008e
        L_0x021d:
            r15 = 1
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzn(r4, r9, r2, r15)
            goto L_0x008e
        L_0x022d:
            r15 = 1
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzk(r4, r9, r2, r15)
            goto L_0x008e
        L_0x023d:
            r15 = 1
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzf(r4, r9, r2, r15)
            goto L_0x008e
        L_0x024d:
            r15 = 1
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzh(r4, r9, r2, r15)
            goto L_0x008e
        L_0x025d:
            r15 = 1
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzd(r4, r9, r2, r15)
            goto L_0x008e
        L_0x026d:
            r15 = 1
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzc(r4, r9, r2, r15)
            goto L_0x008e
        L_0x027d:
            r15 = 1
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.p010firebaseperf.zziu) r2, (boolean) r15)
            goto L_0x008e
        L_0x028d:
            r15 = 1
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.p010firebaseperf.zziu) r2, (boolean) r15)
            goto L_0x008e
        L_0x029d:
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r15 = 0
            com.google.android.gms.internal.p010firebaseperf.zzhk.zze(r4, r9, r2, r15)
            goto L_0x008e
        L_0x02ad:
            r15 = 0
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzj(r4, r9, r2, r15)
            goto L_0x008e
        L_0x02bd:
            r15 = 0
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzg(r4, r9, r2, r15)
            goto L_0x008e
        L_0x02cd:
            r15 = 0
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzl(r4, r9, r2, r15)
            goto L_0x008e
        L_0x02dd:
            r15 = 0
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzm(r4, r9, r2, r15)
            goto L_0x008e
        L_0x02ed:
            r15 = 0
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzi(r4, r9, r2, r15)
            goto L_0x008e
        L_0x02fd:
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzb(r4, r9, r2)
            goto L_0x008e
        L_0x030c:
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase-perf.zzhi r13 = r0.zzap(r5)
            com.google.android.gms.internal.p010firebaseperf.zzhk.zza((int) r4, (java.util.List<?>) r9, (com.google.android.gms.internal.p010firebaseperf.zziu) r2, (com.google.android.gms.internal.p010firebaseperf.zzhi) r13)
            goto L_0x008e
        L_0x031f:
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zza((int) r4, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.p010firebaseperf.zziu) r2)
            goto L_0x008e
        L_0x032e:
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            r15 = 0
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzn(r4, r9, r2, r15)
            goto L_0x008e
        L_0x033e:
            r15 = 0
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzk(r4, r9, r2, r15)
            goto L_0x008e
        L_0x034e:
            r15 = 0
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzf(r4, r9, r2, r15)
            goto L_0x008e
        L_0x035e:
            r15 = 0
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzh(r4, r9, r2, r15)
            goto L_0x008e
        L_0x036e:
            r15 = 0
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzd(r4, r9, r2, r15)
            goto L_0x008e
        L_0x037e:
            r15 = 0
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzc(r4, r9, r2, r15)
            goto L_0x008e
        L_0x038e:
            r15 = 0
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zzb((int) r4, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.p010firebaseperf.zziu) r2, (boolean) r15)
            goto L_0x008e
        L_0x039e:
            r15 = 0
            int[] r4 = r0.zztf
            r4 = r4[r5]
            java.lang.Object r9 = r7.getObject(r1, r13)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.p010firebaseperf.zzhk.zza((int) r4, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.p010firebaseperf.zziu) r2, (boolean) r15)
            goto L_0x008e
        L_0x03ae:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            java.lang.Object r9 = r7.getObject(r1, r13)
            com.google.android.gms.internal.firebase-perf.zzhi r13 = r0.zzap(r5)
            r2.zzb((int) r15, (java.lang.Object) r9, (com.google.android.gms.internal.p010firebaseperf.zzhi) r13)
            goto L_0x0498
        L_0x03bf:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            long r13 = r7.getLong(r1, r13)
            r2.zzb((int) r15, (long) r13)
            goto L_0x0498
        L_0x03cc:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            int r9 = r7.getInt(r1, r13)
            r2.zzg(r15, r9)
            goto L_0x0498
        L_0x03d9:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            long r13 = r7.getLong(r1, r13)
            r2.zzj(r15, r13)
            goto L_0x0498
        L_0x03e6:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            int r9 = r7.getInt(r1, r13)
            r2.zzo(r15, r9)
            goto L_0x0498
        L_0x03f3:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            int r9 = r7.getInt(r1, r13)
            r2.zzp(r15, r9)
            goto L_0x0498
        L_0x0400:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            int r9 = r7.getInt(r1, r13)
            r2.zzf(r15, r9)
            goto L_0x0498
        L_0x040d:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            java.lang.Object r9 = r7.getObject(r1, r13)
            com.google.android.gms.internal.firebase-perf.zzee r9 = (com.google.android.gms.internal.p010firebaseperf.zzee) r9
            r2.zza((int) r15, (com.google.android.gms.internal.p010firebaseperf.zzee) r9)
            goto L_0x0498
        L_0x041c:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            java.lang.Object r9 = r7.getObject(r1, r13)
            com.google.android.gms.internal.firebase-perf.zzhi r13 = r0.zzap(r5)
            r2.zza((int) r15, (java.lang.Object) r9, (com.google.android.gms.internal.p010firebaseperf.zzhi) r13)
            goto L_0x0498
        L_0x042d:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            java.lang.Object r9 = r7.getObject(r1, r13)
            zza((int) r15, (java.lang.Object) r9, (com.google.android.gms.internal.p010firebaseperf.zziu) r2)
            goto L_0x0498
        L_0x0439:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            boolean r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzl(r1, r13)
            r2.zza((int) r15, (boolean) r9)
            goto L_0x0498
        L_0x0445:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            int r9 = r7.getInt(r1, r13)
            r2.zzh(r15, r9)
            goto L_0x0498
        L_0x0451:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            long r13 = r7.getLong(r1, r13)
            r2.zzc(r15, r13)
            goto L_0x0498
        L_0x045d:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            int r9 = r7.getInt(r1, r13)
            r2.zze(r15, r9)
            goto L_0x0498
        L_0x0469:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            long r13 = r7.getLong(r1, r13)
            r2.zza((int) r15, (long) r13)
            goto L_0x0498
        L_0x0475:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            long r13 = r7.getLong(r1, r13)
            r2.zzi(r15, r13)
            goto L_0x0498
        L_0x0481:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            float r9 = com.google.android.gms.internal.p010firebaseperf.zzig.zzm(r1, r13)
            r2.zza((int) r15, (float) r9)
            goto L_0x0498
        L_0x048d:
            r4 = 0
            r9 = r9 & r12
            if (r9 == 0) goto L_0x0498
            double r13 = com.google.android.gms.internal.p010firebaseperf.zzig.zzn(r1, r13)
            r2.zza((int) r15, (double) r13)
        L_0x0498:
            int r5 = r5 + 3
            goto L_0x0030
        L_0x049c:
            r14 = r11
        L_0x049d:
            if (r14 == 0) goto L_0x04b4
            com.google.android.gms.internal.firebase-perf.zzez<?> r4 = r0.zztc
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
            com.google.android.gms.internal.firebase-perf.zzia<?, ?> r3 = r0.zzta
            zza(r3, r1, (com.google.android.gms.internal.p010firebaseperf.zziu) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p010firebaseperf.zzgw.zzb(java.lang.Object, com.google.android.gms.internal.firebase-perf.zziu):void");
    }

    private final <K, V> void zza(zziu zziu, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zziu.zza(i, this.zztr.zzk(zzaq(i2)), this.zztr.zzi(obj));
        }
    }

    private static <UT, UB> void zza(zzia<UT, UB> zzia, T t, zziu zziu) throws IOException {
        zzia.zza(zzia.zzp(t), zziu);
    }

    private final zzhi zzap(int i) {
        int i2 = (i / 3) << 1;
        zzhi zzhi = (zzhi) this.zztg[i2];
        if (zzhi != null) {
            return zzhi;
        }
        zzhi zze = zzhd.zzip().zze((Class) this.zztg[i2 + 1]);
        this.zztg[i2] = zze;
        return zze;
    }

    private final Object zzaq(int i) {
        return this.zztg[(i / 3) << 1];
    }

    public final void zzf(T t) {
        int i;
        int i2 = this.zztn;
        while (true) {
            i = this.zzto;
            if (i2 >= i) {
                break;
            }
            long zzar = (long) (zzar(this.zztm[i2]) & 1048575);
            Object zzo = zzig.zzo(t, zzar);
            if (zzo != null) {
                zzig.zza((Object) t, zzar, this.zztr.zzj(zzo));
            }
            i2++;
        }
        int length = this.zztm.length;
        while (i < length) {
            this.zztq.zza(t, (long) this.zztm[i]);
            i++;
        }
        this.zzta.zzf(t);
        if (this.zztb) {
            this.zztc.zzf(t);
        }
    }

    public final boolean zzm(T t) {
        int i;
        int i2;
        T t2 = t;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean z = true;
            if (i5 >= this.zztn) {
                return !this.zztb || this.zztc.zzd(t2).isInitialized();
            }
            int i6 = this.zztm[i5];
            int i7 = this.zztf[i6];
            int zzar = zzar(i6);
            int i8 = this.zztf[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                i = i9 != 1048575 ? zzte.getInt(t2, (long) i9) : i4;
                i2 = i9;
            } else {
                i2 = i3;
                i = i4;
            }
            if (((268435456 & zzar) != 0) && !zza(t, i6, i2, i, i10)) {
                return false;
            }
            int i11 = (267386880 & zzar) >>> 20;
            if (i11 != 9 && i11 != 17) {
                if (i11 != 27) {
                    if (i11 == 60 || i11 == 68) {
                        if (zza(t2, i7, i6) && !zza((Object) t2, zzar, zzap(i6))) {
                            return false;
                        }
                    } else if (i11 != 49) {
                        if (i11 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzi = this.zztr.zzi(zzig.zzo(t2, (long) (zzar & 1048575)));
                            if (!zzi.isEmpty()) {
                                if (this.zztr.zzk(zzaq(i6)).zzss.zzjo() == zzir.MESSAGE) {
                                    zzhi<?> zzhi = null;
                                    Iterator<?> it = zzi.values().iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object next = it.next();
                                        if (zzhi == null) {
                                            zzhi = zzhd.zzip().zze(next.getClass());
                                        }
                                        if (!zzhi.zzm(next)) {
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
                List list = (List) zzig.zzo(t2, (long) (zzar & 1048575));
                if (!list.isEmpty()) {
                    zzhi zzap = zzap(i6);
                    int i12 = 0;
                    while (true) {
                        if (i12 >= list.size()) {
                            break;
                        } else if (!zzap.zzm(list.get(i12))) {
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
            } else if (zza(t, i6, i2, i, i10) && !zza((Object) t2, zzar, zzap(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
    }

    private static boolean zza(Object obj, int i, zzhi zzhi) {
        return zzhi.zzm(zzig.zzo(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zziu zziu) throws IOException {
        if (obj instanceof String) {
            zziu.zza(i, (String) obj);
        } else {
            zziu.zza(i, (zzee) obj);
        }
    }

    private final int zzar(int i) {
        return this.zztf[i + 1];
    }

    private final int zzas(int i) {
        return this.zztf[i + 2];
    }

    private static <T> double zze(T t, long j) {
        return ((Double) zzig.zzo(t, j)).doubleValue();
    }

    private static <T> float zzf(T t, long j) {
        return ((Float) zzig.zzo(t, j)).floatValue();
    }

    private static <T> int zzg(T t, long j) {
        return ((Integer) zzig.zzo(t, j)).intValue();
    }

    private static <T> long zzh(T t, long j) {
        return ((Long) zzig.zzo(t, j)).longValue();
    }

    private static <T> boolean zzi(T t, long j) {
        return ((Boolean) zzig.zzo(t, j)).booleanValue();
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
        int zzas = zzas(i);
        long j = (long) (zzas & 1048575);
        if (j == 1048575) {
            int zzar = zzar(i);
            long j2 = (long) (zzar & 1048575);
            switch ((zzar & 267386880) >>> 20) {
                case 0:
                    return zzig.zzn(t, j2) != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
                case 1:
                    return zzig.zzm(t, j2) != 0.0f;
                case 2:
                    return zzig.zzk(t, j2) != 0;
                case 3:
                    return zzig.zzk(t, j2) != 0;
                case 4:
                    return zzig.zzj(t, j2) != 0;
                case 5:
                    return zzig.zzk(t, j2) != 0;
                case 6:
                    return zzig.zzj(t, j2) != 0;
                case 7:
                    return zzig.zzl(t, j2);
                case 8:
                    Object zzo = zzig.zzo(t, j2);
                    if (zzo instanceof String) {
                        return !((String) zzo).isEmpty();
                    }
                    if (zzo instanceof zzee) {
                        return !zzee.zzna.equals(zzo);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzig.zzo(t, j2) != null;
                case 10:
                    return !zzee.zzna.equals(zzig.zzo(t, j2));
                case 11:
                    return zzig.zzj(t, j2) != 0;
                case 12:
                    return zzig.zzj(t, j2) != 0;
                case 13:
                    return zzig.zzj(t, j2) != 0;
                case 14:
                    return zzig.zzk(t, j2) != 0;
                case 15:
                    return zzig.zzj(t, j2) != 0;
                case 16:
                    return zzig.zzk(t, j2) != 0;
                case 17:
                    return zzig.zzo(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (zzig.zzj(t, j) & (1 << (zzas >>> 20))) != 0;
        }
    }

    private final void zzb(T t, int i) {
        int zzas = zzas(i);
        long j = (long) (1048575 & zzas);
        if (j != 1048575) {
            zzig.zza((Object) t, j, (1 << (zzas >>> 20)) | zzig.zzj(t, j));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzig.zzj(t, (long) (zzas(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzig.zza((Object) t, (long) (zzas(i2) & 1048575), i);
    }
}
