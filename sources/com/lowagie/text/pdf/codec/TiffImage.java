package com.lowagie.text.pdf.codec;

import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.RandomAccessFileOrArray;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class TiffImage {
    public static int getNumberOfPages(RandomAccessFileOrArray randomAccessFileOrArray) {
        try {
            return TIFFDirectory.getNumDirectories(randomAccessFileOrArray);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    static int getDpi(TIFFField tIFFField, int i) {
        double d;
        if (tIFFField == null) {
            return 0;
        }
        long[] asRational = tIFFField.getAsRational(0);
        float f = ((float) asRational[0]) / ((float) asRational[1]);
        if (i == 1 || i == 2) {
            d = (double) f;
        } else if (i != 3) {
            return 0;
        } else {
            d = ((double) f) * 2.54d;
        }
        return (int) (d + 0.5d);
    }

    public static Image getTiffImage(RandomAccessFileOrArray randomAccessFileOrArray, int i) {
        return getTiffImage(randomAccessFileOrArray, i, false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x01d9  */
    /* JADX WARNING: Removed duplicated region for block: B:115:0x01e9 A[Catch:{ RuntimeException -> 0x0279, Exception -> 0x029e }] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01ef A[Catch:{ RuntimeException -> 0x0279, Exception -> 0x029e }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007b A[Catch:{ RuntimeException -> 0x0279, Exception -> 0x029e }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0081 A[Catch:{ RuntimeException -> 0x0279, Exception -> 0x029e }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0099 A[Catch:{ RuntimeException -> 0x0279, Exception -> 0x029e }] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a5 A[Catch:{ RuntimeException -> 0x0279, Exception -> 0x029e }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00af A[Catch:{ RuntimeException -> 0x0279, Exception -> 0x029e }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00b7 A[Catch:{ RuntimeException -> 0x0279, Exception -> 0x029e }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ba A[Catch:{ RuntimeException -> 0x0279, Exception -> 0x029e }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d0 A[Catch:{ RuntimeException -> 0x0279, Exception -> 0x029e }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00f2 A[Catch:{ RuntimeException -> 0x0279, Exception -> 0x029e }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x0108 A[Catch:{ RuntimeException -> 0x0279, Exception -> 0x029e }] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x010e A[Catch:{ RuntimeException -> 0x0279, Exception -> 0x029e }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0124 A[Catch:{ RuntimeException -> 0x0279, Exception -> 0x029e }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0126 A[Catch:{ RuntimeException -> 0x0279, Exception -> 0x029e }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x012a A[Catch:{ RuntimeException -> 0x0279, Exception -> 0x029e }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0188 A[ADDED_TO_REGION, Catch:{ RuntimeException -> 0x0279, Exception -> 0x029e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.lowagie.text.Image getTiffImage(com.lowagie.text.pdf.RandomAccessFileOrArray r43, int r44, boolean r45) {
        /*
            r1 = r43
            r0 = r44
            r2 = 1
            if (r0 < r2) goto L_0x02a5
            com.lowagie.text.pdf.codec.TIFFDirectory r3 = new com.lowagie.text.pdf.codec.TIFFDirectory     // Catch:{ Exception -> 0x029e }
            int r0 = r0 - r2
            r3.<init>(r1, r0)     // Catch:{ Exception -> 0x029e }
            r0 = 322(0x142, float:4.51E-43)
            boolean r0 = r3.isTagPresent(r0)     // Catch:{ Exception -> 0x029e }
            if (r0 != 0) goto L_0x0296
            r0 = 259(0x103, float:3.63E-43)
            long r4 = r3.getFieldAsLong(r0)     // Catch:{ Exception -> 0x029e }
            int r5 = (int) r4     // Catch:{ Exception -> 0x029e }
            r4 = 32771(0x8003, float:4.5922E-41)
            r6 = 4
            r7 = 3
            r8 = 2
            if (r5 == r8) goto L_0x002f
            if (r5 == r7) goto L_0x002f
            if (r5 == r6) goto L_0x002f
            if (r5 == r4) goto L_0x002f
            com.lowagie.text.Image r0 = getTiffImageColor(r3, r1)     // Catch:{ Exception -> 0x029e }
            return r0
        L_0x002f:
            r0 = 274(0x112, float:3.84E-43)
            boolean r9 = r3.isTagPresent(r0)     // Catch:{ Exception -> 0x029e }
            r10 = 8
            r11 = 5
            if (r9 == 0) goto L_0x0064
            long r13 = r3.getFieldAsLong(r0)     // Catch:{ Exception -> 0x029e }
            int r0 = (int) r13     // Catch:{ Exception -> 0x029e }
            if (r0 == r7) goto L_0x005d
            if (r0 != r6) goto L_0x0044
            goto L_0x005d
        L_0x0044:
            if (r0 == r11) goto L_0x0056
            if (r0 != r10) goto L_0x0049
            goto L_0x0056
        L_0x0049:
            r9 = 6
            if (r0 == r9) goto L_0x004f
            r9 = 7
            if (r0 != r9) goto L_0x0064
        L_0x004f:
            r0 = -1077342245(0xffffffffbfc90fdb, float:-1.5707964)
            r9 = -1077342245(0xffffffffbfc90fdb, float:-1.5707964)
            goto L_0x0065
        L_0x0056:
            r0 = 1070141403(0x3fc90fdb, float:1.5707964)
            r9 = 1070141403(0x3fc90fdb, float:1.5707964)
            goto L_0x0065
        L_0x005d:
            r0 = 1078530011(0x40490fdb, float:3.1415927)
            r9 = 1078530011(0x40490fdb, float:3.1415927)
            goto L_0x0065
        L_0x0064:
            r9 = 0
        L_0x0065:
            r0 = 257(0x101, float:3.6E-43)
            long r13 = r3.getFieldAsLong(r0)     // Catch:{ Exception -> 0x029e }
            int r14 = (int) r13     // Catch:{ Exception -> 0x029e }
            r13 = 256(0x100, float:3.59E-43)
            long r10 = r3.getFieldAsLong(r13)     // Catch:{ Exception -> 0x029e }
            int r15 = (int) r10     // Catch:{ Exception -> 0x029e }
            r10 = 296(0x128, float:4.15E-43)
            boolean r11 = r3.isTagPresent(r10)     // Catch:{ Exception -> 0x029e }
            if (r11 == 0) goto L_0x0081
            long r10 = r3.getFieldAsLong(r10)     // Catch:{ Exception -> 0x029e }
            int r11 = (int) r10     // Catch:{ Exception -> 0x029e }
            goto L_0x0082
        L_0x0081:
            r11 = 2
        L_0x0082:
            r10 = 282(0x11a, float:3.95E-43)
            com.lowagie.text.pdf.codec.TIFFField r10 = r3.getField(r10)     // Catch:{ Exception -> 0x029e }
            int r10 = getDpi(r10, r11)     // Catch:{ Exception -> 0x029e }
            r0 = 283(0x11b, float:3.97E-43)
            com.lowagie.text.pdf.codec.TIFFField r0 = r3.getField(r0)     // Catch:{ Exception -> 0x029e }
            int r0 = getDpi(r0, r11)     // Catch:{ Exception -> 0x029e }
            r13 = 0
            if (r11 != r2) goto L_0x00a5
            if (r0 == 0) goto L_0x00a0
            float r10 = (float) r10     // Catch:{ Exception -> 0x029e }
            float r0 = (float) r0     // Catch:{ Exception -> 0x029e }
            float r0 = r10 / r0
            goto L_0x00a1
        L_0x00a0:
            r0 = 0
        L_0x00a1:
            r12 = r0
            r10 = 0
            r11 = 0
            goto L_0x00a7
        L_0x00a5:
            r11 = r0
            r12 = 0
        L_0x00a7:
            r0 = 278(0x116, float:3.9E-43)
            boolean r0 = r3.isTagPresent(r0)     // Catch:{ Exception -> 0x029e }
            if (r0 == 0) goto L_0x00b7
            r0 = 278(0x116, float:3.9E-43)
            long r6 = r3.getFieldAsLong(r0)     // Catch:{ Exception -> 0x029e }
            int r0 = (int) r6     // Catch:{ Exception -> 0x029e }
            goto L_0x00b8
        L_0x00b7:
            r0 = r14
        L_0x00b8:
            if (r0 <= 0) goto L_0x00bf
            if (r0 <= r14) goto L_0x00bd
            goto L_0x00bf
        L_0x00bd:
            r6 = r0
            goto L_0x00c0
        L_0x00bf:
            r6 = r14
        L_0x00c0:
            r0 = 273(0x111, float:3.83E-43)
            long[] r7 = getArrayLongShort(r3, r0)     // Catch:{ Exception -> 0x029e }
            r0 = 279(0x117, float:3.91E-43)
            long[] r0 = getArrayLongShort(r3, r0)     // Catch:{ Exception -> 0x029e }
            r23 = 0
            if (r0 == 0) goto L_0x00ee
            int r4 = r0.length     // Catch:{ Exception -> 0x029e }
            if (r4 != r2) goto L_0x00eb
            r25 = r0[r13]     // Catch:{ Exception -> 0x029e }
            int r4 = (r25 > r23 ? 1 : (r25 == r23 ? 0 : -1))
            if (r4 == 0) goto L_0x00ee
            r25 = r0[r13]     // Catch:{ Exception -> 0x029e }
            r27 = r7[r13]     // Catch:{ Exception -> 0x029e }
            long r25 = r25 + r27
            int r4 = r43.length()     // Catch:{ Exception -> 0x029e }
            r28 = r9
            long r8 = (long) r4     // Catch:{ Exception -> 0x029e }
            int r4 = (r25 > r8 ? 1 : (r25 == r8 ? 0 : -1))
            if (r4 <= 0) goto L_0x00ff
            goto L_0x00f0
        L_0x00eb:
            r28 = r9
            goto L_0x00ff
        L_0x00ee:
            r28 = r9
        L_0x00f0:
            if (r14 != r6) goto L_0x00ff
            long[] r0 = new long[r2]     // Catch:{ Exception -> 0x029e }
            int r4 = r43.length()     // Catch:{ Exception -> 0x029e }
            r8 = r7[r13]     // Catch:{ Exception -> 0x029e }
            int r9 = (int) r8     // Catch:{ Exception -> 0x029e }
            int r4 = r4 - r9
            long r8 = (long) r4     // Catch:{ Exception -> 0x029e }
            r0[r13] = r8     // Catch:{ Exception -> 0x029e }
        L_0x00ff:
            r4 = r0
            r0 = 266(0x10a, float:3.73E-43)
            com.lowagie.text.pdf.codec.TIFFField r0 = r3.getField(r0)     // Catch:{ Exception -> 0x029e }
            if (r0 == 0) goto L_0x010e
            int r0 = r0.getAsInt(r13)     // Catch:{ Exception -> 0x029e }
            r8 = r0
            goto L_0x010f
        L_0x010e:
            r8 = 1
        L_0x010f:
            r9 = 2
            r0 = 262(0x106, float:3.67E-43)
            boolean r0 = r3.isTagPresent(r0)     // Catch:{ Exception -> 0x029e }
            if (r0 == 0) goto L_0x0126
            r0 = 262(0x106, float:3.67E-43)
            long r25 = r3.getFieldAsLong(r0)     // Catch:{ Exception -> 0x029e }
            r29 = 1
            int r0 = (r25 > r29 ? 1 : (r25 == r29 ? 0 : -1))
            if (r0 != 0) goto L_0x0126
            r0 = 1
            goto L_0x0127
        L_0x0126:
            r0 = 0
        L_0x0127:
            r9 = 2
            if (r5 == r9) goto L_0x017f
            r9 = 3
            if (r5 == r9) goto L_0x014e
            r9 = 4
            if (r5 == r9) goto L_0x013a
            r9 = 32771(0x8003, float:4.5922E-41)
            if (r5 == r9) goto L_0x017f
            r9 = r0
            r25 = r23
            r0 = 0
            goto L_0x0186
        L_0x013a:
            r9 = 293(0x125, float:4.1E-43)
            com.lowagie.text.pdf.codec.TIFFField r9 = r3.getField(r9)     // Catch:{ Exception -> 0x029e }
            if (r9 == 0) goto L_0x0148
            long r25 = r9.getAsLong(r13)     // Catch:{ Exception -> 0x029e }
            r9 = r0
            goto L_0x014b
        L_0x0148:
            r9 = r0
            r25 = r23
        L_0x014b:
            r0 = 256(0x100, float:3.59E-43)
            goto L_0x0186
        L_0x014e:
            r0 = r0 | 12
            r9 = 292(0x124, float:4.09E-43)
            com.lowagie.text.pdf.codec.TIFFField r9 = r3.getField(r9)     // Catch:{ Exception -> 0x029e }
            if (r9 == 0) goto L_0x0181
            long r25 = r9.getAsLong(r13)     // Catch:{ Exception -> 0x029e }
            r29 = 1
            long r29 = r25 & r29
            int r9 = (r29 > r23 ? 1 : (r29 == r23 ? 0 : -1))
            if (r9 == 0) goto L_0x0169
            r9 = 258(0x102, float:3.62E-43)
            r16 = 258(0x102, float:3.62E-43)
            goto L_0x016b
        L_0x0169:
            r16 = 257(0x101, float:3.6E-43)
        L_0x016b:
            r29 = 4
            long r29 = r25 & r29
            int r9 = (r29 > r23 ? 1 : (r29 == r23 ? 0 : -1))
            if (r9 == 0) goto L_0x0175
            r0 = r0 | 2
        L_0x0175:
            r9 = r0
            r0 = r16
            r41 = r23
            r23 = r25
            r25 = r41
            goto L_0x0186
        L_0x017f:
            r0 = r0 | 10
        L_0x0181:
            r9 = r0
            r25 = r23
            r0 = 257(0x101, float:3.6E-43)
        L_0x0186:
            if (r45 == 0) goto L_0x01a9
            if (r6 != r14) goto L_0x01a9
            r5 = r4[r13]     // Catch:{ Exception -> 0x029e }
            int r4 = (int) r5     // Catch:{ Exception -> 0x029e }
            byte[] r4 = new byte[r4]     // Catch:{ Exception -> 0x029e }
            r5 = r7[r13]     // Catch:{ Exception -> 0x029e }
            r1.seek((long) r5)     // Catch:{ Exception -> 0x029e }
            r1.readFully(r4)     // Catch:{ Exception -> 0x029e }
            r17 = 0
            r16 = r14
            r18 = r0
            r19 = r9
            r20 = r4
            com.lowagie.text.Image r0 = com.lowagie.text.Image.getInstance((int) r15, (int) r16, (boolean) r17, (int) r18, (int) r19, (byte[]) r20)     // Catch:{ Exception -> 0x029e }
            r0.setInverted(r2)     // Catch:{ Exception -> 0x029e }
            goto L_0x01ca
        L_0x01a9:
            com.lowagie.text.pdf.codec.CCITTG4Encoder r13 = new com.lowagie.text.pdf.codec.CCITTG4Encoder     // Catch:{ Exception -> 0x029e }
            r13.<init>(r15)     // Catch:{ Exception -> 0x029e }
            r36 = r23
            r2 = 0
            r23 = r5
            r5 = r14
        L_0x01b4:
            int r0 = r7.length     // Catch:{ Exception -> 0x029e }
            if (r2 < r0) goto L_0x01ef
            byte[] r20 = r13.close()     // Catch:{ Exception -> 0x029e }
            r0 = 0
            r18 = 256(0x100, float:3.59E-43)
            r17 = 1
            r19 = r9 & 1
            r16 = r14
            r17 = r0
            com.lowagie.text.Image r0 = com.lowagie.text.Image.getInstance((int) r15, (int) r16, (boolean) r17, (int) r18, (int) r19, (byte[]) r20)     // Catch:{ Exception -> 0x029e }
        L_0x01ca:
            r0.setDpi(r10, r11)     // Catch:{ Exception -> 0x029e }
            r0.setXYRatio(r12)     // Catch:{ Exception -> 0x029e }
            r1 = 34675(0x8773, float:4.859E-41)
            boolean r1 = r3.isTagPresent(r1)     // Catch:{ Exception -> 0x029e }
            if (r1 == 0) goto L_0x01df
            r1 = 34675(0x8773, float:4.859E-41)
            r3.getField(r1)     // Catch:{ RuntimeException -> 0x01df }
        L_0x01df:
            r1 = 5
            r0.setOriginalType(r1)     // Catch:{ Exception -> 0x029e }
            r21 = 0
            int r1 = (r28 > r21 ? 1 : (r28 == r21 ? 0 : -1))
            if (r1 == 0) goto L_0x01ee
            r1 = r28
            r0.setInitialRotation(r1)     // Catch:{ Exception -> 0x029e }
        L_0x01ee:
            return r0
        L_0x01ef:
            r38 = r10
            r22 = r28
            r17 = 1
            r21 = 0
            r24 = 5
            r28 = r9
            r9 = r4[r2]     // Catch:{ Exception -> 0x029e }
            int r0 = (int) r9     // Catch:{ Exception -> 0x029e }
            byte[] r9 = new byte[r0]     // Catch:{ Exception -> 0x029e }
            r39 = r3
            r10 = r4
            r3 = r7[r2]     // Catch:{ Exception -> 0x029e }
            r1.seek((long) r3)     // Catch:{ Exception -> 0x029e }
            r1.readFully(r9)     // Catch:{ Exception -> 0x029e }
            int r3 = java.lang.Math.min(r6, r5)     // Catch:{ Exception -> 0x029e }
            com.lowagie.text.pdf.codec.TIFFFaxDecoder r4 = new com.lowagie.text.pdf.codec.TIFFFaxDecoder     // Catch:{ Exception -> 0x029e }
            r4.<init>(r8, r15, r3)     // Catch:{ Exception -> 0x029e }
            int r0 = r15 + 7
            r40 = 8
            int r0 = r0 / 8
            int r0 = r0 * r3
            byte[] r1 = new byte[r0]     // Catch:{ Exception -> 0x029e }
            r44 = r7
            r7 = r23
            r23 = r8
            r8 = 2
            if (r7 == r8) goto L_0x0233
            r8 = 3
            if (r7 == r8) goto L_0x024b
            r8 = 4
            if (r7 == r8) goto L_0x0235
            r8 = 32771(0x8003, float:4.5922E-41)
            if (r7 == r8) goto L_0x0233
            goto L_0x0277
        L_0x0233:
            r8 = 0
            goto L_0x027a
        L_0x0235:
            r8 = 32771(0x8003, float:4.5922E-41)
            r32 = 0
            r29 = r4
            r30 = r1
            r31 = r9
            r33 = r3
            r34 = r25
            r29.decodeT6(r30, r31, r32, r33, r34)     // Catch:{ Exception -> 0x029e }
            r13.fax4Encode(r1, r3)     // Catch:{ Exception -> 0x029e }
            goto L_0x0277
        L_0x024b:
            r8 = 32771(0x8003, float:4.5922E-41)
            r32 = 0
            r29 = r4
            r30 = r1
            r31 = r9
            r33 = r3
            r34 = r36
            r29.decode2D(r30, r31, r32, r33, r34)     // Catch:{ RuntimeException -> 0x025e }
            goto L_0x0274
        L_0x025e:
            r0 = move-exception
            r20 = r0
            r29 = 4
            long r36 = r36 ^ r29
            r32 = 0
            r29 = r4
            r30 = r1
            r31 = r9
            r33 = r3
            r34 = r36
            r29.decode2D(r30, r31, r32, r33, r34)     // Catch:{ RuntimeException -> 0x0279 }
        L_0x0274:
            r13.fax4Encode(r1, r3)     // Catch:{ Exception -> 0x029e }
        L_0x0277:
            r8 = 0
            goto L_0x0280
        L_0x0279:
            throw r20     // Catch:{ Exception -> 0x029e }
        L_0x027a:
            r4.decode1D(r1, r9, r8, r3)     // Catch:{ Exception -> 0x029e }
            r13.fax4Encode(r1, r3)     // Catch:{ Exception -> 0x029e }
        L_0x0280:
            int r5 = r5 - r6
            int r2 = r2 + 1
            r1 = r43
            r4 = r10
            r8 = r23
            r9 = r28
            r10 = r38
            r3 = r39
            r23 = r7
            r28 = r22
            r7 = r44
            goto L_0x01b4
        L_0x0296:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x029e }
            java.lang.String r1 = "Tiles are not supported."
            r0.<init>(r1)     // Catch:{ Exception -> 0x029e }
            throw r0     // Catch:{ Exception -> 0x029e }
        L_0x029e:
            r0 = move-exception
            com.lowagie.text.ExceptionConverter r1 = new com.lowagie.text.ExceptionConverter
            r1.<init>(r0)
            throw r1
        L_0x02a5:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "The page number must be >= 1."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.codec.TiffImage.getTiffImage(com.lowagie.text.pdf.RandomAccessFileOrArray, int, boolean):com.lowagie.text.Image");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:195:0x03c0, code lost:
        if (r0 != 32946) goto L_0x03c2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x02ec  */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x02fa A[Catch:{ Exception -> 0x0409 }] */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x0367 A[Catch:{ Exception -> 0x0409 }] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x036f A[Catch:{ Exception -> 0x0409 }] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0401 A[Catch:{ Exception -> 0x0409 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a1 A[Catch:{ Exception -> 0x0409 }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00bc A[Catch:{ Exception -> 0x0409 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected static com.lowagie.text.Image getTiffImageColor(com.lowagie.text.pdf.codec.TIFFDirectory r32, com.lowagie.text.pdf.RandomAccessFileOrArray r33) {
        /*
            r0 = r32
            r1 = r33
            r2 = 259(0x103, float:3.63E-43)
            long r2 = r0.getFieldAsLong(r2)     // Catch:{ Exception -> 0x0409 }
            int r3 = (int) r2
            r2 = 32946(0x80b2, float:4.6167E-41)
            r4 = 32773(0x8005, float:4.5925E-41)
            java.lang.String r5 = " is not supported."
            r6 = 6
            r7 = 5
            r8 = 7
            r9 = 8
            r10 = 1
            if (r3 == r10) goto L_0x003f
            if (r3 == r4) goto L_0x003f
            if (r3 == r2) goto L_0x003f
            if (r3 == r7) goto L_0x003f
            if (r3 == r6) goto L_0x003f
            if (r3 == r8) goto L_0x003f
            if (r3 != r9) goto L_0x0028
            goto L_0x003f
        L_0x0028:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0409 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0409 }
            java.lang.String r2 = "The compression "
            r1.<init>(r2)     // Catch:{ Exception -> 0x0409 }
            r1.append(r3)     // Catch:{ Exception -> 0x0409 }
            r1.append(r5)     // Catch:{ Exception -> 0x0409 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0409 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0409 }
            throw r0     // Catch:{ Exception -> 0x0409 }
        L_0x003f:
            r11 = 262(0x106, float:3.67E-43)
            long r11 = r0.getFieldAsLong(r11)     // Catch:{ Exception -> 0x0409 }
            int r12 = (int) r11     // Catch:{ Exception -> 0x0409 }
            r11 = 3
            r13 = 2
            if (r12 == 0) goto L_0x006e
            if (r12 == r10) goto L_0x006e
            if (r12 == r13) goto L_0x006e
            if (r12 == r11) goto L_0x006e
            if (r12 == r7) goto L_0x006e
            if (r3 == r6) goto L_0x006e
            if (r3 != r8) goto L_0x0057
            goto L_0x006e
        L_0x0057:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0409 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0409 }
            java.lang.String r2 = "The photometric "
            r1.<init>(r2)     // Catch:{ Exception -> 0x0409 }
            r1.append(r12)     // Catch:{ Exception -> 0x0409 }
            r1.append(r5)     // Catch:{ Exception -> 0x0409 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0409 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0409 }
            throw r0     // Catch:{ Exception -> 0x0409 }
        L_0x006e:
            r14 = 274(0x112, float:3.84E-43)
            boolean r15 = r0.isTagPresent(r14)     // Catch:{ Exception -> 0x0409 }
            r16 = 0
            if (r15 == 0) goto L_0x0098
            long r14 = r0.getFieldAsLong(r14)     // Catch:{ Exception -> 0x0409 }
            int r15 = (int) r14     // Catch:{ Exception -> 0x0409 }
            if (r15 == r11) goto L_0x0094
            r14 = 4
            if (r15 != r14) goto L_0x0083
            goto L_0x0094
        L_0x0083:
            if (r15 == r7) goto L_0x0090
            if (r15 != r9) goto L_0x0088
            goto L_0x0090
        L_0x0088:
            if (r15 == r6) goto L_0x008c
            if (r15 != r8) goto L_0x0098
        L_0x008c:
            r14 = -1077342245(0xffffffffbfc90fdb, float:-1.5707964)
            goto L_0x0099
        L_0x0090:
            r14 = 1070141403(0x3fc90fdb, float:1.5707964)
            goto L_0x0099
        L_0x0094:
            r14 = 1078530011(0x40490fdb, float:3.1415927)
            goto L_0x0099
        L_0x0098:
            r14 = 0
        L_0x0099:
            r15 = 284(0x11c, float:3.98E-43)
            boolean r17 = r0.isTagPresent(r15)     // Catch:{ Exception -> 0x0409 }
            if (r17 == 0) goto L_0x00b4
            long r17 = r0.getFieldAsLong(r15)     // Catch:{ Exception -> 0x0409 }
            r19 = 2
            int r15 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r15 == 0) goto L_0x00ac
            goto L_0x00b4
        L_0x00ac:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0409 }
            java.lang.String r1 = "Planar images are not supported."
            r0.<init>(r1)     // Catch:{ Exception -> 0x0409 }
            throw r0     // Catch:{ Exception -> 0x0409 }
        L_0x00b4:
            r15 = 338(0x152, float:4.74E-43)
            boolean r15 = r0.isTagPresent(r15)     // Catch:{ Exception -> 0x0409 }
            if (r15 != 0) goto L_0x0401
            r15 = 277(0x115, float:3.88E-43)
            boolean r15 = r0.isTagPresent(r15)     // Catch:{ Exception -> 0x0409 }
            if (r15 == 0) goto L_0x00ce
            r15 = 277(0x115, float:3.88E-43)
            r18 = r12
            long r11 = r0.getFieldAsLong(r15)     // Catch:{ Exception -> 0x0409 }
            int r12 = (int) r11     // Catch:{ Exception -> 0x0409 }
            goto L_0x00d1
        L_0x00ce:
            r18 = r12
            r12 = 1
        L_0x00d1:
            r11 = 258(0x102, float:3.62E-43)
            boolean r11 = r0.isTagPresent(r11)     // Catch:{ Exception -> 0x0409 }
            if (r11 == 0) goto L_0x00e3
            r11 = 258(0x102, float:3.62E-43)
            r19 = r3
            long r2 = r0.getFieldAsLong(r11)     // Catch:{ Exception -> 0x0409 }
            int r3 = (int) r2     // Catch:{ Exception -> 0x0409 }
            goto L_0x00e6
        L_0x00e3:
            r19 = r3
            r3 = 1
        L_0x00e6:
            if (r3 == r10) goto L_0x0107
            if (r3 == r13) goto L_0x0107
            r2 = 4
            if (r3 == r2) goto L_0x0107
            if (r3 != r9) goto L_0x00f0
            goto L_0x0107
        L_0x00f0:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0409 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0409 }
            java.lang.String r2 = "Bits per sample "
            r1.<init>(r2)     // Catch:{ Exception -> 0x0409 }
            r1.append(r3)     // Catch:{ Exception -> 0x0409 }
            r1.append(r5)     // Catch:{ Exception -> 0x0409 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0409 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0409 }
            throw r0     // Catch:{ Exception -> 0x0409 }
        L_0x0107:
            r2 = 257(0x101, float:3.6E-43)
            long r4 = r0.getFieldAsLong(r2)     // Catch:{ Exception -> 0x0409 }
            int r2 = (int) r4     // Catch:{ Exception -> 0x0409 }
            r4 = 256(0x100, float:3.59E-43)
            long r4 = r0.getFieldAsLong(r4)     // Catch:{ Exception -> 0x0409 }
            int r5 = (int) r4     // Catch:{ Exception -> 0x0409 }
            r4 = 296(0x128, float:4.15E-43)
            boolean r4 = r0.isTagPresent(r4)     // Catch:{ Exception -> 0x0409 }
            if (r4 == 0) goto L_0x0127
            r4 = 296(0x128, float:4.15E-43)
            r20 = r12
            long r11 = r0.getFieldAsLong(r4)     // Catch:{ Exception -> 0x0409 }
            int r4 = (int) r11     // Catch:{ Exception -> 0x0409 }
            goto L_0x012a
        L_0x0127:
            r20 = r12
            r4 = 2
        L_0x012a:
            r11 = 282(0x11a, float:3.95E-43)
            com.lowagie.text.pdf.codec.TIFFField r11 = r0.getField(r11)     // Catch:{ Exception -> 0x0409 }
            int r11 = getDpi(r11, r4)     // Catch:{ Exception -> 0x0409 }
            r12 = 283(0x11b, float:3.97E-43)
            com.lowagie.text.pdf.codec.TIFFField r12 = r0.getField(r12)     // Catch:{ Exception -> 0x0409 }
            int r4 = getDpi(r12, r4)     // Catch:{ Exception -> 0x0409 }
            r12 = 266(0x10a, float:3.73E-43)
            com.lowagie.text.pdf.codec.TIFFField r12 = r0.getField(r12)     // Catch:{ Exception -> 0x0409 }
            r15 = 0
            if (r12 == 0) goto L_0x014c
            int r12 = r12.getAsInt(r15)     // Catch:{ Exception -> 0x0409 }
            goto L_0x014d
        L_0x014c:
            r12 = 1
        L_0x014d:
            if (r12 != r13) goto L_0x0151
            r12 = 1
            goto L_0x0152
        L_0x0151:
            r12 = 0
        L_0x0152:
            r8 = 278(0x116, float:3.9E-43)
            boolean r8 = r0.isTagPresent(r8)     // Catch:{ Exception -> 0x0409 }
            if (r8 == 0) goto L_0x0164
            r8 = 278(0x116, float:3.9E-43)
            r27 = r14
            long r13 = r0.getFieldAsLong(r8)     // Catch:{ Exception -> 0x0409 }
            int r8 = (int) r13     // Catch:{ Exception -> 0x0409 }
            goto L_0x0167
        L_0x0164:
            r27 = r14
            r8 = r2
        L_0x0167:
            if (r8 <= 0) goto L_0x016b
            if (r8 <= r2) goto L_0x016c
        L_0x016b:
            r8 = r2
        L_0x016c:
            r13 = 273(0x111, float:3.83E-43)
            long[] r13 = getArrayLongShort(r0, r13)     // Catch:{ Exception -> 0x0409 }
            r14 = 279(0x117, float:3.91E-43)
            long[] r14 = getArrayLongShort(r0, r14)     // Catch:{ Exception -> 0x0409 }
            if (r14 == 0) goto L_0x0194
            int r6 = r14.length     // Catch:{ Exception -> 0x0409 }
            if (r6 != r10) goto L_0x01a4
            r24 = r14[r15]     // Catch:{ Exception -> 0x0409 }
            r28 = 0
            int r6 = (r24 > r28 ? 1 : (r24 == r28 ? 0 : -1))
            if (r6 == 0) goto L_0x0194
            r24 = r14[r15]     // Catch:{ Exception -> 0x0409 }
            r28 = r13[r15]     // Catch:{ Exception -> 0x0409 }
            long r24 = r24 + r28
            int r6 = r33.length()     // Catch:{ Exception -> 0x0409 }
            long r9 = (long) r6     // Catch:{ Exception -> 0x0409 }
            int r6 = (r24 > r9 ? 1 : (r24 == r9 ? 0 : -1))
            if (r6 <= 0) goto L_0x01a4
        L_0x0194:
            if (r2 != r8) goto L_0x01a4
            r6 = 1
            long[] r14 = new long[r6]     // Catch:{ Exception -> 0x0409 }
            int r6 = r33.length()     // Catch:{ Exception -> 0x0409 }
            r9 = r13[r15]     // Catch:{ Exception -> 0x0409 }
            int r10 = (int) r9     // Catch:{ Exception -> 0x0409 }
            int r6 = r6 - r10
            long r9 = (long) r6     // Catch:{ Exception -> 0x0409 }
            r14[r15] = r9     // Catch:{ Exception -> 0x0409 }
        L_0x01a4:
            r9 = r19
            if (r9 != r7) goto L_0x01ec
            r10 = 317(0x13d, float:4.44E-43)
            com.lowagie.text.pdf.codec.TIFFField r10 = r0.getField(r10)     // Catch:{ Exception -> 0x0409 }
            if (r10 == 0) goto L_0x01e3
            int r10 = r10.getAsInt(r15)     // Catch:{ Exception -> 0x0409 }
            r6 = 1
            if (r10 == r6) goto L_0x01c3
            r6 = 2
            if (r10 != r6) goto L_0x01bb
            goto L_0x01c4
        L_0x01bb:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x0409 }
            java.lang.String r1 = "Illegal value for Predictor in TIFF file."
            r0.<init>(r1)     // Catch:{ Exception -> 0x0409 }
            throw r0     // Catch:{ Exception -> 0x0409 }
        L_0x01c3:
            r6 = 2
        L_0x01c4:
            if (r10 != r6) goto L_0x01e4
            r6 = 8
            if (r3 != r6) goto L_0x01cb
            goto L_0x01e4
        L_0x01cb:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ Exception -> 0x0409 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0409 }
            java.lang.String r2 = java.lang.String.valueOf(r3)     // Catch:{ Exception -> 0x0409 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0409 }
            java.lang.String r2 = "-bit samples are not supported for Horizontal differencing Predictor."
            r1.append(r2)     // Catch:{ Exception -> 0x0409 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0409 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0409 }
            throw r0     // Catch:{ Exception -> 0x0409 }
        L_0x01e3:
            r10 = 1
        L_0x01e4:
            com.lowagie.text.pdf.codec.TIFFLZWDecoder r6 = new com.lowagie.text.pdf.codec.TIFFLZWDecoder     // Catch:{ Exception -> 0x0409 }
            r7 = r20
            r6.<init>(r5, r10, r7)     // Catch:{ Exception -> 0x0409 }
            goto L_0x01ef
        L_0x01ec:
            r7 = r20
            r6 = 0
        L_0x01ef:
            r10 = 1
            if (r3 != r10) goto L_0x0201
            if (r7 != r10) goto L_0x0201
            com.lowagie.text.pdf.codec.CCITTG4Encoder r10 = new com.lowagie.text.pdf.codec.CCITTG4Encoder     // Catch:{ Exception -> 0x0409 }
            r10.<init>(r5)     // Catch:{ Exception -> 0x0409 }
            r23 = r6
            r20 = r10
            r6 = 6
            r10 = 0
            r15 = 0
            goto L_0x021b
        L_0x0201:
            java.io.ByteArrayOutputStream r10 = new java.io.ByteArrayOutputStream     // Catch:{ Exception -> 0x0409 }
            r10.<init>()     // Catch:{ Exception -> 0x0409 }
            r15 = 6
            if (r9 == r15) goto L_0x0215
            r15 = 7
            if (r9 == r15) goto L_0x0215
            java.util.zip.DeflaterOutputStream r15 = new java.util.zip.DeflaterOutputStream     // Catch:{ Exception -> 0x0409 }
            r15.<init>(r10)     // Catch:{ Exception -> 0x0409 }
            r23 = r6
            r6 = 6
            goto L_0x0219
        L_0x0215:
            r23 = r6
            r6 = 6
            r15 = 0
        L_0x0219:
            r20 = 0
        L_0x021b:
            if (r9 != r6) goto L_0x0269
            r2 = 513(0x201, float:7.19E-43)
            boolean r2 = r0.isTagPresent(r2)     // Catch:{ Exception -> 0x0409 }
            if (r2 == 0) goto L_0x0261
            r2 = 513(0x201, float:7.19E-43)
            long r2 = r0.getFieldAsLong(r2)     // Catch:{ Exception -> 0x0409 }
            int r3 = (int) r2     // Catch:{ Exception -> 0x0409 }
            int r2 = r33.length()     // Catch:{ Exception -> 0x0409 }
            int r2 = r2 - r3
            r5 = 514(0x202, float:7.2E-43)
            boolean r5 = r0.isTagPresent(r5)     // Catch:{ Exception -> 0x0409 }
            if (r5 == 0) goto L_0x0245
            r2 = 514(0x202, float:7.2E-43)
            long r5 = r0.getFieldAsLong(r2)     // Catch:{ Exception -> 0x0409 }
            int r2 = (int) r5     // Catch:{ Exception -> 0x0409 }
            r5 = 0
            r6 = r14[r5]     // Catch:{ Exception -> 0x0409 }
            int r5 = (int) r6     // Catch:{ Exception -> 0x0409 }
            int r2 = r2 + r5
        L_0x0245:
            int r5 = r33.length()     // Catch:{ Exception -> 0x0409 }
            int r5 = r5 - r3
            int r2 = java.lang.Math.min(r2, r5)     // Catch:{ Exception -> 0x0409 }
            byte[] r2 = new byte[r2]     // Catch:{ Exception -> 0x0409 }
            int r5 = r33.getFilePointer()     // Catch:{ Exception -> 0x0409 }
            int r5 = r5 + r3
            r1.seek((int) r5)     // Catch:{ Exception -> 0x0409 }
            r1.readFully(r2)     // Catch:{ Exception -> 0x0409 }
            com.lowagie.text.Jpeg r1 = new com.lowagie.text.Jpeg     // Catch:{ Exception -> 0x0409 }
            r1.<init>((byte[]) r2)     // Catch:{ Exception -> 0x0409 }
            goto L_0x0283
        L_0x0261:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x0409 }
            java.lang.String r1 = "Missing tag(s) for OJPEG compression."
            r0.<init>(r1)     // Catch:{ Exception -> 0x0409 }
            throw r0     // Catch:{ Exception -> 0x0409 }
        L_0x0269:
            r6 = 7
            if (r9 != r6) goto L_0x02a1
            int r2 = r14.length     // Catch:{ Exception -> 0x0409 }
            r3 = 1
            if (r2 > r3) goto L_0x0287
            r6 = 0
            r2 = r14[r6]     // Catch:{ Exception -> 0x0409 }
            int r3 = (int) r2     // Catch:{ Exception -> 0x0409 }
            byte[] r2 = new byte[r3]     // Catch:{ Exception -> 0x0409 }
            r7 = r13[r6]     // Catch:{ Exception -> 0x0409 }
            r1.seek((long) r7)     // Catch:{ Exception -> 0x0409 }
            r1.readFully(r2)     // Catch:{ Exception -> 0x0409 }
            com.lowagie.text.Jpeg r1 = new com.lowagie.text.Jpeg     // Catch:{ Exception -> 0x0409 }
            r1.<init>((byte[]) r2)     // Catch:{ Exception -> 0x0409 }
        L_0x0283:
            r2 = r1
            r1 = r18
            goto L_0x02da
        L_0x0287:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x0409 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0409 }
            java.lang.String r2 = "Compression JPEG is only supported with a single strip. This image has "
            r1.<init>(r2)     // Catch:{ Exception -> 0x0409 }
            int r2 = r14.length     // Catch:{ Exception -> 0x0409 }
            r1.append(r2)     // Catch:{ Exception -> 0x0409 }
            java.lang.String r2 = " strips."
            r1.append(r2)     // Catch:{ Exception -> 0x0409 }
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0409 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0409 }
            throw r0     // Catch:{ Exception -> 0x0409 }
        L_0x02a1:
            r6 = 0
            r25 = r8
            r24 = r12
            r12 = r2
        L_0x02a7:
            int r8 = r13.length     // Catch:{ Exception -> 0x0409 }
            if (r6 < r8) goto L_0x0375
            r8 = 1
            if (r3 != r8) goto L_0x02c9
            if (r7 != r8) goto L_0x02c9
            r22 = 0
            r23 = 256(0x100, float:3.59E-43)
            r1 = r18
            if (r1 != r8) goto L_0x02ba
            r24 = 1
            goto L_0x02bc
        L_0x02ba:
            r24 = 0
        L_0x02bc:
            byte[] r25 = r20.close()     // Catch:{ Exception -> 0x0409 }
            r20 = r5
            r21 = r2
            com.lowagie.text.Image r2 = com.lowagie.text.Image.getInstance((int) r20, (int) r21, (boolean) r22, (int) r23, (int) r24, (byte[]) r25)     // Catch:{ Exception -> 0x0409 }
            goto L_0x02da
        L_0x02c9:
            r1 = r18
            r15.close()     // Catch:{ Exception -> 0x0409 }
            byte[] r6 = r10.toByteArray()     // Catch:{ Exception -> 0x0409 }
            com.lowagie.text.Image r2 = com.lowagie.text.Image.getInstance(r5, r2, r7, r3, r6)     // Catch:{ Exception -> 0x0409 }
            r3 = 1
            r2.setDeflated(r3)     // Catch:{ Exception -> 0x0409 }
        L_0x02da:
            r2.setDpi(r11, r4)     // Catch:{ Exception -> 0x0409 }
            r8 = 6
            if (r9 == r8) goto L_0x0365
            r3 = 7
            if (r9 == r3) goto L_0x0365
            r3 = 34675(0x8773, float:4.859E-41)
            boolean r3 = r0.isTagPresent(r3)     // Catch:{ Exception -> 0x0409 }
            if (r3 == 0) goto L_0x02f2
            r3 = 34675(0x8773, float:4.859E-41)
            r0.getField(r3)     // Catch:{ RuntimeException -> 0x02f2 }
        L_0x02f2:
            r3 = 320(0x140, float:4.48E-43)
            boolean r3 = r0.isTagPresent(r3)     // Catch:{ Exception -> 0x0409 }
            if (r3 == 0) goto L_0x0361
            r3 = 320(0x140, float:4.48E-43)
            com.lowagie.text.pdf.codec.TIFFField r0 = r0.getField(r3)     // Catch:{ Exception -> 0x0409 }
            char[] r0 = r0.getAsChars()     // Catch:{ Exception -> 0x0409 }
            int r3 = r0.length     // Catch:{ Exception -> 0x0409 }
            byte[] r3 = new byte[r3]     // Catch:{ Exception -> 0x0409 }
            int r4 = r0.length     // Catch:{ Exception -> 0x0409 }
            r17 = 3
            int r4 = r4 / 3
            int r5 = r4 * 2
            r6 = 0
        L_0x030f:
            if (r6 < r4) goto L_0x0340
            com.lowagie.text.pdf.PdfArray r0 = new com.lowagie.text.pdf.PdfArray     // Catch:{ Exception -> 0x0409 }
            r0.<init>()     // Catch:{ Exception -> 0x0409 }
            com.lowagie.text.pdf.PdfName r5 = com.lowagie.text.pdf.PdfName.INDEXED     // Catch:{ Exception -> 0x0409 }
            r0.add((com.lowagie.text.pdf.PdfObject) r5)     // Catch:{ Exception -> 0x0409 }
            com.lowagie.text.pdf.PdfName r5 = com.lowagie.text.pdf.PdfName.DEVICERGB     // Catch:{ Exception -> 0x0409 }
            r0.add((com.lowagie.text.pdf.PdfObject) r5)     // Catch:{ Exception -> 0x0409 }
            com.lowagie.text.pdf.PdfNumber r5 = new com.lowagie.text.pdf.PdfNumber     // Catch:{ Exception -> 0x0409 }
            r6 = 1
            int r4 = r4 - r6
            r5.<init>((int) r4)     // Catch:{ Exception -> 0x0409 }
            r0.add((com.lowagie.text.pdf.PdfObject) r5)     // Catch:{ Exception -> 0x0409 }
            com.lowagie.text.pdf.PdfString r4 = new com.lowagie.text.pdf.PdfString     // Catch:{ Exception -> 0x0409 }
            r4.<init>((byte[]) r3)     // Catch:{ Exception -> 0x0409 }
            r0.add((com.lowagie.text.pdf.PdfObject) r4)     // Catch:{ Exception -> 0x0409 }
            com.lowagie.text.pdf.PdfDictionary r3 = new com.lowagie.text.pdf.PdfDictionary     // Catch:{ Exception -> 0x0409 }
            r3.<init>()     // Catch:{ Exception -> 0x0409 }
            com.lowagie.text.pdf.PdfName r4 = com.lowagie.text.pdf.PdfName.COLORSPACE     // Catch:{ Exception -> 0x0409 }
            r3.put(r4, r0)     // Catch:{ Exception -> 0x0409 }
            r2.setAdditional(r3)     // Catch:{ Exception -> 0x0409 }
            goto L_0x0361
        L_0x0340:
            int r7 = r6 * 3
            char r8 = r0[r6]     // Catch:{ Exception -> 0x0409 }
            r9 = 8
            int r8 = r8 >>> r9
            byte r8 = (byte) r8     // Catch:{ Exception -> 0x0409 }
            r3[r7] = r8     // Catch:{ Exception -> 0x0409 }
            int r8 = r7 + 1
            int r10 = r6 + r4
            char r10 = r0[r10]     // Catch:{ Exception -> 0x0409 }
            int r10 = r10 >>> r9
            byte r10 = (byte) r10     // Catch:{ Exception -> 0x0409 }
            r3[r8] = r10     // Catch:{ Exception -> 0x0409 }
            int r7 = r7 + 2
            int r8 = r6 + r5
            char r8 = r0[r8]     // Catch:{ Exception -> 0x0409 }
            int r8 = r8 >>> r9
            byte r8 = (byte) r8     // Catch:{ Exception -> 0x0409 }
            r3[r7] = r8     // Catch:{ Exception -> 0x0409 }
            int r6 = r6 + 1
            goto L_0x030f
        L_0x0361:
            r0 = 5
            r2.setOriginalType(r0)     // Catch:{ Exception -> 0x0409 }
        L_0x0365:
            if (r1 != 0) goto L_0x036b
            r0 = 1
            r2.setInverted(r0)     // Catch:{ Exception -> 0x0409 }
        L_0x036b:
            int r0 = (r27 > r16 ? 1 : (r27 == r16 ? 0 : -1))
            if (r0 == 0) goto L_0x0374
            r0 = r27
            r2.setInitialRotation(r0)     // Catch:{ Exception -> 0x0409 }
        L_0x0374:
            return r2
        L_0x0375:
            r30 = r9
            r17 = 3
            r8 = r14[r6]     // Catch:{ Exception -> 0x0409 }
            int r9 = (int) r8     // Catch:{ Exception -> 0x0409 }
            byte[] r8 = new byte[r9]     // Catch:{ Exception -> 0x0409 }
            r31 = r10
            r9 = r13[r6]     // Catch:{ Exception -> 0x0409 }
            r1.seek((long) r9)     // Catch:{ Exception -> 0x0409 }
            r1.readFully(r8)     // Catch:{ Exception -> 0x0409 }
            r9 = r25
            int r10 = java.lang.Math.min(r9, r12)     // Catch:{ Exception -> 0x0409 }
            r0 = r30
            r1 = 1
            if (r0 == r1) goto L_0x03a4
            int r1 = r5 * r3
            int r1 = r1 * r7
            r25 = 7
            int r1 = r1 + 7
            r26 = 8
            int r1 = r1 / 8
            int r1 = r1 * r10
            byte[] r1 = new byte[r1]     // Catch:{ Exception -> 0x0409 }
            goto L_0x03a7
        L_0x03a4:
            r25 = 7
            r1 = 0
        L_0x03a7:
            if (r24 == 0) goto L_0x03ac
            com.lowagie.text.pdf.codec.TIFFFaxDecoder.reverseBits(r8)     // Catch:{ Exception -> 0x0409 }
        L_0x03ac:
            r26 = r2
            r2 = 1
            if (r0 == r2) goto L_0x03da
            r2 = 5
            if (r0 == r2) goto L_0x03d3
            r2 = 8
            if (r0 == r2) goto L_0x03cc
            r2 = 32773(0x8005, float:4.5925E-41)
            if (r0 == r2) goto L_0x03c5
            r2 = 32946(0x80b2, float:4.6167E-41)
            if (r0 == r2) goto L_0x03cf
        L_0x03c2:
            r2 = r23
            goto L_0x03d8
        L_0x03c5:
            r2 = 32946(0x80b2, float:4.6167E-41)
            decodePackbits(r8, r1)     // Catch:{ Exception -> 0x0409 }
            goto L_0x03c2
        L_0x03cc:
            r2 = 32946(0x80b2, float:4.6167E-41)
        L_0x03cf:
            inflate(r8, r1)     // Catch:{ Exception -> 0x0409 }
            goto L_0x03c2
        L_0x03d3:
            r2 = r23
            r2.decode(r8, r1, r10)     // Catch:{ Exception -> 0x0409 }
        L_0x03d8:
            r8 = 1
            goto L_0x03de
        L_0x03da:
            r2 = r23
            r1 = r8
            goto L_0x03d8
        L_0x03de:
            if (r3 != r8) goto L_0x03e8
            if (r7 != r8) goto L_0x03e8
            r8 = r20
            r8.fax4Encode(r1, r10)     // Catch:{ Exception -> 0x0409 }
            goto L_0x03ed
        L_0x03e8:
            r8 = r20
            r15.write(r1)     // Catch:{ Exception -> 0x0409 }
        L_0x03ed:
            int r12 = r12 - r9
            int r6 = r6 + 1
            r1 = r33
            r23 = r2
            r20 = r8
            r25 = r9
            r2 = r26
            r10 = r31
            r9 = r0
            r0 = r32
            goto L_0x02a7
        L_0x0401:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ Exception -> 0x0409 }
            java.lang.String r1 = "Extra samples are not supported."
            r0.<init>(r1)     // Catch:{ Exception -> 0x0409 }
            throw r0     // Catch:{ Exception -> 0x0409 }
        L_0x0409:
            r0 = move-exception
            com.lowagie.text.ExceptionConverter r1 = new com.lowagie.text.ExceptionConverter
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.codec.TiffImage.getTiffImageColor(com.lowagie.text.pdf.codec.TIFFDirectory, com.lowagie.text.pdf.RandomAccessFileOrArray):com.lowagie.text.Image");
    }

    static long[] getArrayLongShort(TIFFDirectory tIFFDirectory, int i) {
        TIFFField field = tIFFDirectory.getField(i);
        if (field == null) {
            return null;
        }
        if (field.getType() == 4) {
            return field.getAsLongs();
        }
        char[] asChars = field.getAsChars();
        long[] jArr = new long[asChars.length];
        for (int i2 = 0; i2 < asChars.length; i2++) {
            jArr[i2] = (long) asChars[i2];
        }
        return jArr;
    }

    public static void decodePackbits(byte[] bArr, byte[] bArr2) {
        int i = 0;
        int i2 = 0;
        while (i < bArr2.length) {
            try {
                int i3 = i2 + 1;
                byte b = bArr[i2];
                if (b >= 0 && b <= Byte.MAX_VALUE) {
                    int i4 = i3;
                    int i5 = i;
                    int i6 = 0;
                    while (i6 < b + 1) {
                        bArr2[i5] = bArr[i4];
                        i6++;
                        i5++;
                        i4++;
                    }
                    i = i5;
                    i2 = i4;
                } else if (b > -1 || b < -127) {
                    i2 = i3 + 1;
                } else {
                    int i7 = i3 + 1;
                    byte b2 = bArr[i3];
                    int i8 = i;
                    int i9 = 0;
                    while (i9 < (-b) + 1) {
                        int i10 = i8 + 1;
                        bArr2[i8] = b2;
                        i9++;
                        i8 = i10;
                    }
                    i2 = i7;
                    i = i8;
                }
            } catch (Exception unused) {
                return;
            }
        }
    }

    public static void inflate(byte[] bArr, byte[] bArr2) {
        Inflater inflater = new Inflater();
        inflater.setInput(bArr);
        try {
            inflater.inflate(bArr2);
        } catch (DataFormatException e) {
            throw new ExceptionConverter(e);
        }
    }
}
