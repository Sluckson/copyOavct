package com.lowagie.text.pdf;

import androidx.exifinterface.media.ExifInterface;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.lowagie.text.ExceptionConverter;

public class BarcodeEAN extends Barcode {
    private static final byte[][] BARS = {new byte[]{3, 2, 1, 1}, new byte[]{2, 2, 2, 1}, new byte[]{2, 1, 2, 2}, new byte[]{1, 4, 1, 1}, new byte[]{1, 1, 3, 2}, new byte[]{1, 2, 3, 1}, new byte[]{1, 1, 1, 4}, new byte[]{1, 3, 1, 2}, new byte[]{1, 2, 1, 3}, new byte[]{3, 1, 1, 2}};
    private static final int EVEN = 1;
    private static final int[] GUARD_EAN13;
    private static final int[] GUARD_EAN8;
    private static final int[] GUARD_EMPTY = new int[0];
    private static final int[] GUARD_UPCA;
    private static final int[] GUARD_UPCE;
    private static final int ODD = 0;
    private static final byte[][] PARITY13;
    private static final byte[][] PARITY2;
    private static final byte[][] PARITY5;
    private static final byte[][] PARITYE;
    private static final float[] TEXTPOS_EAN13 = {6.5f, 13.5f, 20.5f, 27.5f, 34.5f, 41.5f, 53.5f, 60.5f, 67.5f, 74.5f, 81.5f, 88.5f};
    private static final float[] TEXTPOS_EAN8 = {6.5f, 13.5f, 20.5f, 27.5f, 39.5f, 46.5f, 53.5f, 60.5f};
    private static final int TOTALBARS_EAN13 = 59;
    private static final int TOTALBARS_EAN8 = 43;
    private static final int TOTALBARS_SUPP2 = 13;
    private static final int TOTALBARS_SUPP5 = 31;
    private static final int TOTALBARS_UPCE = 33;

    static {
        int[] iArr = new int[10];
        iArr[1] = 2;
        iArr[2] = 4;
        iArr[3] = 6;
        iArr[4] = 28;
        iArr[5] = 30;
        iArr[6] = 52;
        iArr[7] = 54;
        iArr[8] = 56;
        iArr[9] = 58;
        GUARD_UPCA = iArr;
        int[] iArr2 = new int[6];
        iArr2[1] = 2;
        iArr2[2] = 28;
        iArr2[3] = 30;
        iArr2[4] = 56;
        iArr2[5] = 58;
        GUARD_EAN13 = iArr2;
        int[] iArr3 = new int[6];
        iArr3[1] = 2;
        iArr3[2] = 20;
        iArr3[3] = 22;
        iArr3[4] = 40;
        iArr3[5] = 42;
        GUARD_EAN8 = iArr3;
        int[] iArr4 = new int[5];
        iArr4[1] = 2;
        iArr4[2] = 28;
        iArr4[3] = 30;
        iArr4[4] = 32;
        GUARD_UPCE = iArr4;
        byte[] bArr = new byte[6];
        bArr[2] = 1;
        bArr[4] = 1;
        bArr[5] = 1;
        byte[] bArr2 = new byte[6];
        bArr2[2] = 1;
        bArr2[3] = 1;
        bArr2[5] = 1;
        byte[] bArr3 = new byte[6];
        bArr3[2] = 1;
        bArr3[3] = 1;
        bArr3[4] = 1;
        byte[] bArr4 = new byte[6];
        bArr4[1] = 1;
        bArr4[4] = 1;
        bArr4[5] = 1;
        byte[] bArr5 = new byte[6];
        bArr5[1] = 1;
        bArr5[2] = 1;
        bArr5[5] = 1;
        byte[] bArr6 = new byte[6];
        bArr6[1] = 1;
        bArr6[2] = 1;
        bArr6[3] = 1;
        byte[] bArr7 = new byte[6];
        bArr7[1] = 1;
        bArr7[3] = 1;
        bArr7[5] = 1;
        byte[] bArr8 = new byte[6];
        bArr8[1] = 1;
        bArr8[3] = 1;
        bArr8[4] = 1;
        byte[] bArr9 = new byte[6];
        bArr9[1] = 1;
        bArr9[2] = 1;
        bArr9[4] = 1;
        PARITY13 = new byte[][]{new byte[6], bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, bArr9};
        byte[] bArr10 = new byte[2];
        bArr10[1] = 1;
        byte[] bArr11 = new byte[2];
        bArr11[0] = 1;
        PARITY2 = new byte[][]{new byte[2], bArr10, bArr11, new byte[]{1, 1}};
        byte[] bArr12 = new byte[5];
        bArr12[0] = 1;
        bArr12[1] = 1;
        byte[] bArr13 = new byte[5];
        bArr13[0] = 1;
        bArr13[2] = 1;
        byte[] bArr14 = new byte[5];
        bArr14[0] = 1;
        bArr14[3] = 1;
        byte[] bArr15 = new byte[5];
        bArr15[0] = 1;
        bArr15[4] = 1;
        byte[] bArr16 = new byte[5];
        bArr16[1] = 1;
        bArr16[2] = 1;
        byte[] bArr17 = new byte[5];
        bArr17[2] = 1;
        bArr17[3] = 1;
        byte[] bArr18 = new byte[5];
        bArr18[3] = 1;
        bArr18[4] = 1;
        byte[] bArr19 = new byte[5];
        bArr19[1] = 1;
        bArr19[3] = 1;
        byte[] bArr20 = new byte[5];
        bArr20[1] = 1;
        bArr20[4] = 1;
        byte[] bArr21 = new byte[5];
        bArr21[2] = 1;
        bArr21[4] = 1;
        PARITY5 = new byte[][]{bArr12, bArr13, bArr14, bArr15, bArr16, bArr17, bArr18, bArr19, bArr20, bArr21};
        byte[] bArr22 = new byte[6];
        bArr22[0] = 1;
        bArr22[1] = 1;
        bArr22[2] = 1;
        byte[] bArr23 = new byte[6];
        bArr23[0] = 1;
        bArr23[1] = 1;
        bArr23[3] = 1;
        byte[] bArr24 = new byte[6];
        bArr24[0] = 1;
        bArr24[1] = 1;
        bArr24[4] = 1;
        byte[] bArr25 = new byte[6];
        bArr25[0] = 1;
        bArr25[1] = 1;
        bArr25[5] = 1;
        byte[] bArr26 = new byte[6];
        bArr26[0] = 1;
        bArr26[2] = 1;
        bArr26[3] = 1;
        byte[] bArr27 = new byte[6];
        bArr27[0] = 1;
        bArr27[3] = 1;
        bArr27[4] = 1;
        byte[] bArr28 = new byte[6];
        bArr28[0] = 1;
        bArr28[4] = 1;
        bArr28[5] = 1;
        byte[] bArr29 = new byte[6];
        bArr29[0] = 1;
        bArr29[2] = 1;
        bArr29[4] = 1;
        byte[] bArr30 = new byte[6];
        bArr30[0] = 1;
        bArr30[2] = 1;
        bArr30[5] = 1;
        byte[] bArr31 = new byte[6];
        bArr31[0] = 1;
        bArr31[3] = 1;
        bArr31[5] = 1;
        PARITYE = new byte[][]{bArr22, bArr23, bArr24, bArr25, bArr26, bArr27, bArr28, bArr29, bArr30, bArr31};
    }

    public BarcodeEAN() {
        try {
            this.f611x = 0.8f;
            this.font = BaseFont.createFont("Helvetica", "winansi", false);
            this.size = 8.0f;
            this.baseline = this.size;
            this.barHeight = this.size * 3.0f;
            this.guardBars = true;
            this.codeType = 1;
            this.code = "";
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static int calculateEANParity(String str) {
        int i = 3;
        int i2 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            i2 += (str.charAt(length) - '0') * i;
            i ^= 2;
        }
        return (10 - (i2 % 10)) % 10;
    }

    public static String convertUPCAtoUPCE(String str) {
        if (str.length() == 12 && (str.startsWith("0") || str.startsWith(IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE))) {
            if (str.substring(3, 6).equals("000") || str.substring(3, 6).equals("100") || str.substring(3, 6).equals("200")) {
                if (str.substring(6, 8).equals("00")) {
                    return String.valueOf(str.substring(0, 1)) + str.substring(1, 3) + str.substring(8, 11) + str.substring(3, 4) + str.substring(11);
                }
            } else if (str.substring(4, 6).equals("00")) {
                if (str.substring(6, 9).equals("000")) {
                    return String.valueOf(str.substring(0, 1)) + str.substring(1, 4) + str.substring(9, 11) + ExifInterface.GPS_MEASUREMENT_3D + str.substring(11);
                }
            } else if (str.substring(5, 6).equals("0")) {
                if (str.substring(6, 10).equals("0000")) {
                    return String.valueOf(str.substring(0, 1)) + str.substring(1, 5) + str.substring(10, 11) + "4" + str.substring(11);
                }
            } else if (str.charAt(10) >= '5' && str.substring(6, 10).equals("0000")) {
                return String.valueOf(str.substring(0, 1)) + str.substring(1, 6) + str.substring(10, 11) + str.substring(11);
            }
        }
        return null;
    }

    public static byte[] getBarsEAN13(String str) {
        int[] iArr = new int[str.length()];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = str.charAt(i) - '0';
        }
        byte[] bArr = new byte[59];
        bArr[0] = 1;
        bArr[1] = 1;
        bArr[2] = 1;
        byte[] bArr2 = PARITY13[iArr[0]];
        int i2 = 0;
        int i3 = 3;
        while (i2 < bArr2.length) {
            int i4 = i2 + 1;
            byte[] bArr3 = BARS[iArr[i4]];
            if (bArr2[i2] == 0) {
                int i5 = i3 + 1;
                bArr[i3] = bArr3[0];
                int i6 = i5 + 1;
                bArr[i5] = bArr3[1];
                int i7 = i6 + 1;
                bArr[i6] = bArr3[2];
                i3 = i7 + 1;
                bArr[i7] = bArr3[3];
            } else {
                int i8 = i3 + 1;
                bArr[i3] = bArr3[3];
                int i9 = i8 + 1;
                bArr[i8] = bArr3[2];
                int i10 = i9 + 1;
                bArr[i9] = bArr3[1];
                i3 = i10 + 1;
                bArr[i10] = bArr3[0];
            }
            i2 = i4;
        }
        int i11 = i3 + 1;
        bArr[i3] = 1;
        int i12 = i11 + 1;
        bArr[i11] = 1;
        int i13 = i12 + 1;
        bArr[i12] = 1;
        int i14 = i13 + 1;
        bArr[i13] = 1;
        int i15 = i14 + 1;
        bArr[i14] = 1;
        for (int i16 = 7; i16 < 13; i16++) {
            byte[] bArr4 = BARS[iArr[i16]];
            int i17 = i15 + 1;
            bArr[i15] = bArr4[0];
            int i18 = i17 + 1;
            bArr[i17] = bArr4[1];
            int i19 = i18 + 1;
            bArr[i18] = bArr4[2];
            i15 = i19 + 1;
            bArr[i19] = bArr4[3];
        }
        int i20 = i15 + 1;
        bArr[i15] = 1;
        bArr[i20] = 1;
        bArr[i20 + 1] = 1;
        return bArr;
    }

    public static byte[] getBarsEAN8(String str) {
        int i;
        int[] iArr = new int[str.length()];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = str.charAt(i2) - '0';
        }
        byte[] bArr = new byte[43];
        bArr[0] = 1;
        bArr[1] = 1;
        bArr[2] = 1;
        int i3 = 0;
        int i4 = 3;
        while (true) {
            if (i3 >= 4) {
                break;
            }
            byte[] bArr2 = BARS[iArr[i3]];
            int i5 = i4 + 1;
            bArr[i4] = bArr2[0];
            int i6 = i5 + 1;
            bArr[i5] = bArr2[1];
            int i7 = i6 + 1;
            bArr[i6] = bArr2[2];
            i4 = i7 + 1;
            bArr[i7] = bArr2[3];
            i3++;
        }
        int i8 = i4 + 1;
        bArr[i4] = 1;
        int i9 = i8 + 1;
        bArr[i8] = 1;
        int i10 = i9 + 1;
        bArr[i9] = 1;
        int i11 = i10 + 1;
        bArr[i10] = 1;
        int i12 = i11 + 1;
        bArr[i11] = 1;
        for (i = 4; i < 8; i++) {
            byte[] bArr3 = BARS[iArr[i]];
            int i13 = i12 + 1;
            bArr[i12] = bArr3[0];
            int i14 = i13 + 1;
            bArr[i13] = bArr3[1];
            int i15 = i14 + 1;
            bArr[i14] = bArr3[2];
            i12 = i15 + 1;
            bArr[i15] = bArr3[3];
        }
        int i16 = i12 + 1;
        bArr[i12] = 1;
        bArr[i16] = 1;
        bArr[i16 + 1] = 1;
        return bArr;
    }

    public static byte[] getBarsUPCE(String str) {
        int[] iArr = new int[str.length()];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = str.charAt(i) - '0';
        }
        byte[] bArr = new byte[33];
        byte b = iArr[0] != 0 ? (byte) 1 : 0;
        bArr[0] = 1;
        bArr[1] = 1;
        bArr[2] = 1;
        byte[] bArr2 = PARITYE[iArr[iArr.length - 1]];
        int i2 = 3;
        for (int i3 = 1; i3 < iArr.length - 1; i3++) {
            byte[] bArr3 = BARS[iArr[i3]];
            if (bArr2[i3 - 1] == b) {
                int i4 = i2 + 1;
                bArr[i2] = bArr3[0];
                int i5 = i4 + 1;
                bArr[i4] = bArr3[1];
                int i6 = i5 + 1;
                bArr[i5] = bArr3[2];
                i2 = i6 + 1;
                bArr[i6] = bArr3[3];
            } else {
                int i7 = i2 + 1;
                bArr[i2] = bArr3[3];
                int i8 = i7 + 1;
                bArr[i7] = bArr3[2];
                int i9 = i8 + 1;
                bArr[i8] = bArr3[1];
                i2 = i9 + 1;
                bArr[i9] = bArr3[0];
            }
        }
        int i10 = i2 + 1;
        bArr[i2] = 1;
        int i11 = i10 + 1;
        bArr[i10] = 1;
        int i12 = i11 + 1;
        bArr[i11] = 1;
        int i13 = i12 + 1;
        bArr[i12] = 1;
        bArr[i13] = 1;
        bArr[i13 + 1] = 1;
        return bArr;
    }

    public static byte[] getBarsSupplemental2(String str) {
        int[] iArr = new int[2];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = str.charAt(i) - '0';
        }
        byte[] bArr = new byte[13];
        bArr[0] = 1;
        bArr[1] = 1;
        bArr[2] = 2;
        byte[] bArr2 = PARITY2[((iArr[0] * 10) + iArr[1]) % 4];
        int i2 = 3;
        for (int i3 = 0; i3 < bArr2.length; i3++) {
            if (i3 == 1) {
                int i4 = i2 + 1;
                bArr[i2] = 1;
                i2 = i4 + 1;
                bArr[i4] = 1;
            }
            byte[] bArr3 = BARS[iArr[i3]];
            if (bArr2[i3] == 0) {
                int i5 = i2 + 1;
                bArr[i2] = bArr3[0];
                int i6 = i5 + 1;
                bArr[i5] = bArr3[1];
                int i7 = i6 + 1;
                bArr[i6] = bArr3[2];
                i2 = i7 + 1;
                bArr[i7] = bArr3[3];
            } else {
                int i8 = i2 + 1;
                bArr[i2] = bArr3[3];
                int i9 = i8 + 1;
                bArr[i8] = bArr3[2];
                int i10 = i9 + 1;
                bArr[i9] = bArr3[1];
                i2 = i10 + 1;
                bArr[i10] = bArr3[0];
            }
        }
        return bArr;
    }

    public static byte[] getBarsSupplemental5(String str) {
        int[] iArr = new int[5];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = str.charAt(i) - '0';
        }
        byte[] bArr = new byte[31];
        bArr[0] = 1;
        bArr[1] = 1;
        bArr[2] = 2;
        byte[] bArr2 = PARITY5[((((iArr[0] + iArr[2]) + iArr[4]) * 3) + ((iArr[1] + iArr[3]) * 9)) % 10];
        int i2 = 3;
        for (int i3 = 0; i3 < bArr2.length; i3++) {
            if (i3 != 0) {
                int i4 = i2 + 1;
                bArr[i2] = 1;
                i2 = i4 + 1;
                bArr[i4] = 1;
            }
            byte[] bArr3 = BARS[iArr[i3]];
            if (bArr2[i3] == 0) {
                int i5 = i2 + 1;
                bArr[i2] = bArr3[0];
                int i6 = i5 + 1;
                bArr[i5] = bArr3[1];
                int i7 = i6 + 1;
                bArr[i6] = bArr3[2];
                i2 = i7 + 1;
                bArr[i7] = bArr3[3];
            } else {
                int i8 = i2 + 1;
                bArr[i2] = bArr3[3];
                int i9 = i8 + 1;
                bArr[i8] = bArr3[2];
                int i10 = i9 + 1;
                bArr[i9] = bArr3[1];
                i2 = i10 + 1;
                bArr[i10] = bArr3[0];
            }
        }
        return bArr;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0089, code lost:
        r2 = r2 + r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008f, code lost:
        r1 = r1 * r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a8, code lost:
        r1 = r1 + r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00ae, code lost:
        return new com.lowagie.text.Rectangle(r1, r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.lowagie.text.Rectangle getBarcodeSize() {
        /*
            r6 = this;
            float r0 = r6.barHeight
            com.lowagie.text.pdf.BaseFont r1 = r6.font
            if (r1 == 0) goto L_0x0021
            float r1 = r6.baseline
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 > 0) goto L_0x0014
            float r1 = r6.baseline
            float r1 = -r1
            float r2 = r6.size
            float r1 = r1 + r2
            goto L_0x0020
        L_0x0014:
            float r1 = r6.baseline
            com.lowagie.text.pdf.BaseFont r2 = r6.font
            r3 = 3
            float r4 = r6.size
            float r2 = r2.getFontDescriptor(r3, r4)
            float r1 = r1 - r2
        L_0x0020:
            float r0 = r0 + r1
        L_0x0021:
            int r1 = r6.codeType
            r2 = 1119748096(0x42be0000, float:95.0)
            r3 = 0
            switch(r1) {
                case 1: goto L_0x0092;
                case 2: goto L_0x008b;
                case 3: goto L_0x0063;
                case 4: goto L_0x003b;
                case 5: goto L_0x0036;
                case 6: goto L_0x0031;
                default: goto L_0x0029;
            }
        L_0x0029:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "Invalid code type."
            r0.<init>(r1)
            throw r0
        L_0x0031:
            float r1 = r6.f611x
            r2 = 1111228416(0x423c0000, float:47.0)
            goto L_0x008f
        L_0x0036:
            float r1 = r6.f611x
            r2 = 1101004800(0x41a00000, float:20.0)
            goto L_0x008f
        L_0x003b:
            float r1 = r6.f611x
            r2 = 1112276992(0x424c0000, float:51.0)
            float r1 = r1 * r2
            com.lowagie.text.pdf.BaseFont r2 = r6.font
            if (r2 == 0) goto L_0x00a9
            com.lowagie.text.pdf.BaseFont r2 = r6.font
            java.lang.String r4 = r6.code
            char r3 = r4.charAt(r3)
            float r4 = r6.size
            float r2 = r2.getWidthPoint((int) r3, (float) r4)
            com.lowagie.text.pdf.BaseFont r3 = r6.font
            java.lang.String r4 = r6.code
            r5 = 7
            char r4 = r4.charAt(r5)
            float r5 = r6.size
            float r3 = r3.getWidthPoint((int) r4, (float) r5)
            goto L_0x0089
        L_0x0063:
            float r1 = r6.f611x
            float r1 = r1 * r2
            com.lowagie.text.pdf.BaseFont r2 = r6.font
            if (r2 == 0) goto L_0x00a9
            com.lowagie.text.pdf.BaseFont r2 = r6.font
            java.lang.String r4 = r6.code
            char r3 = r4.charAt(r3)
            float r4 = r6.size
            float r2 = r2.getWidthPoint((int) r3, (float) r4)
            com.lowagie.text.pdf.BaseFont r3 = r6.font
            java.lang.String r4 = r6.code
            r5 = 11
            char r4 = r4.charAt(r5)
            float r5 = r6.size
            float r3 = r3.getWidthPoint((int) r4, (float) r5)
        L_0x0089:
            float r2 = r2 + r3
            goto L_0x00a8
        L_0x008b:
            float r1 = r6.f611x
            r2 = 1116078080(0x42860000, float:67.0)
        L_0x008f:
            float r1 = r1 * r2
            goto L_0x00a9
        L_0x0092:
            float r1 = r6.f611x
            float r1 = r1 * r2
            com.lowagie.text.pdf.BaseFont r2 = r6.font
            if (r2 == 0) goto L_0x00a9
            com.lowagie.text.pdf.BaseFont r2 = r6.font
            java.lang.String r4 = r6.code
            char r3 = r4.charAt(r3)
            float r4 = r6.size
            float r2 = r2.getWidthPoint((int) r3, (float) r4)
        L_0x00a8:
            float r1 = r1 + r2
        L_0x00a9:
            com.lowagie.text.Rectangle r2 = new com.lowagie.text.Rectangle
            r2.<init>(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.BarcodeEAN.getBarcodeSize():com.lowagie.text.Rectangle");
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00a8  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01f9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.lowagie.text.Rectangle placeBarcode(com.lowagie.text.pdf.PdfContentByte r18, harmony.java.awt.Color r19, harmony.java.awt.Color r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r20
            com.lowagie.text.Rectangle r3 = r17.getBarcodeSize()
            com.lowagie.text.pdf.BaseFont r4 = r0.font
            r5 = 3
            r6 = 0
            if (r4 == 0) goto L_0x0029
            float r4 = r0.baseline
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 > 0) goto L_0x001c
            float r4 = r0.barHeight
            float r7 = r0.baseline
            float r4 = r4 - r7
            goto L_0x002a
        L_0x001c:
            com.lowagie.text.pdf.BaseFont r4 = r0.font
            float r7 = r0.size
            float r4 = r4.getFontDescriptor(r5, r7)
            float r4 = -r4
            float r7 = r0.baseline
            float r7 = r7 + r4
            goto L_0x002b
        L_0x0029:
            r4 = 0
        L_0x002a:
            r7 = 0
        L_0x002b:
            int r8 = r0.codeType
            r9 = 0
            r10 = 1
            if (r8 == r10) goto L_0x0037
            if (r8 == r5) goto L_0x0037
            r5 = 4
            if (r8 == r5) goto L_0x0037
            goto L_0x004b
        L_0x0037:
            com.lowagie.text.pdf.BaseFont r5 = r0.font
            if (r5 == 0) goto L_0x004b
            com.lowagie.text.pdf.BaseFont r5 = r0.font
            java.lang.String r8 = r0.code
            char r8 = r8.charAt(r9)
            float r11 = r0.size
            float r5 = r5.getWidthPoint((int) r8, (float) r11)
            float r5 = r5 + r6
            goto L_0x004c
        L_0x004b:
            r5 = 0
        L_0x004c:
            r8 = 0
            int[] r11 = GUARD_EMPTY
            int r12 = r0.codeType
            switch(r12) {
                case 1: goto L_0x008c;
                case 2: goto L_0x0083;
                case 3: goto L_0x006c;
                case 4: goto L_0x0063;
                case 5: goto L_0x005c;
                case 6: goto L_0x0055;
                default: goto L_0x0054;
            }
        L_0x0054:
            goto L_0x0094
        L_0x0055:
            java.lang.String r8 = r0.code
            byte[] r8 = getBarsSupplemental5(r8)
            goto L_0x0094
        L_0x005c:
            java.lang.String r8 = r0.code
            byte[] r8 = getBarsSupplemental2(r8)
            goto L_0x0094
        L_0x0063:
            java.lang.String r8 = r0.code
            byte[] r8 = getBarsUPCE(r8)
            int[] r11 = GUARD_UPCE
            goto L_0x0094
        L_0x006c:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            java.lang.String r11 = "0"
            r8.<init>(r11)
            java.lang.String r11 = r0.code
            r8.append(r11)
            java.lang.String r8 = r8.toString()
            byte[] r8 = getBarsEAN13(r8)
            int[] r11 = GUARD_UPCA
            goto L_0x0094
        L_0x0083:
            java.lang.String r8 = r0.code
            byte[] r8 = getBarsEAN8(r8)
            int[] r11 = GUARD_EAN8
            goto L_0x0094
        L_0x008c:
            java.lang.String r8 = r0.code
            byte[] r8 = getBarsEAN13(r8)
            int[] r11 = GUARD_EAN13
        L_0x0094:
            com.lowagie.text.pdf.BaseFont r12 = r0.font
            r13 = 1073741824(0x40000000, float:2.0)
            if (r12 == 0) goto L_0x00a8
            float r12 = r0.baseline
            int r12 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r12 <= 0) goto L_0x00a8
            boolean r12 = r0.guardBars
            if (r12 == 0) goto L_0x00a8
            float r12 = r0.baseline
            float r12 = r12 / r13
            goto L_0x00a9
        L_0x00a8:
            r12 = 0
        L_0x00a9:
            if (r19 == 0) goto L_0x00ae
            r18.setColorFill(r19)
        L_0x00ae:
            r16 = r5
            r14 = 0
            r15 = 1
        L_0x00b2:
            int r9 = r8.length
            if (r14 < r9) goto L_0x01f9
            r18.fill()
            com.lowagie.text.pdf.BaseFont r7 = r0.font
            if (r7 == 0) goto L_0x01f8
            if (r2 == 0) goto L_0x00c1
            r1.setColorFill(r2)
        L_0x00c1:
            r18.beginText()
            com.lowagie.text.pdf.BaseFont r2 = r0.font
            float r7 = r0.size
            r1.setFontAndSize(r2, r7)
            int r2 = r0.codeType
            r7 = 8
            switch(r2) {
                case 1: goto L_0x01be;
                case 2: goto L_0x0198;
                case 3: goto L_0x014d;
                case 4: goto L_0x0103;
                case 5: goto L_0x00d4;
                case 6: goto L_0x00d4;
                default: goto L_0x00d2;
            }
        L_0x00d2:
            goto L_0x01f5
        L_0x00d4:
            r2 = 0
        L_0x00d5:
            java.lang.String r5 = r0.code
            int r5 = r5.length()
            if (r2 < r5) goto L_0x00df
            goto L_0x01f5
        L_0x00df:
            java.lang.String r5 = r0.code
            int r6 = r2 + 1
            java.lang.String r5 = r5.substring(r2, r6)
            com.lowagie.text.pdf.BaseFont r7 = r0.font
            float r8 = r0.size
            float r7 = r7.getWidthPoint((java.lang.String) r5, (float) r8)
            r8 = 1089470464(0x40f00000, float:7.5)
            int r2 = r2 * 9
            float r2 = (float) r2
            float r2 = r2 + r8
            float r8 = r0.f611x
            float r2 = r2 * r8
            float r7 = r7 / r13
            float r2 = r2 - r7
            r1.setTextMatrix(r2, r4)
            r1.showText((java.lang.String) r5)
            r2 = r6
            goto L_0x00d5
        L_0x0103:
            r1.setTextMatrix(r6, r4)
            java.lang.String r2 = r0.code
            r6 = 0
            java.lang.String r2 = r2.substring(r6, r10)
            r1.showText((java.lang.String) r2)
        L_0x0110:
            r2 = 7
            if (r10 < r2) goto L_0x0128
            float r6 = r0.f611x
            r8 = 1112276992(0x424c0000, float:51.0)
            float r6 = r6 * r8
            float r5 = r5 + r6
            r1.setTextMatrix(r5, r4)
            java.lang.String r4 = r0.code
            java.lang.String r2 = r4.substring(r2, r7)
            r1.showText((java.lang.String) r2)
            goto L_0x01f5
        L_0x0128:
            java.lang.String r2 = r0.code
            int r6 = r10 + 1
            java.lang.String r2 = r2.substring(r10, r6)
            com.lowagie.text.pdf.BaseFont r8 = r0.font
            float r9 = r0.size
            float r8 = r8.getWidthPoint((java.lang.String) r2, (float) r9)
            float[] r9 = TEXTPOS_EAN13
            int r10 = r10 + -1
            r9 = r9[r10]
            float r10 = r0.f611x
            float r9 = r9 * r10
            float r9 = r9 + r5
            float r8 = r8 / r13
            float r9 = r9 - r8
            r1.setTextMatrix(r9, r4)
            r1.showText((java.lang.String) r2)
            r10 = r6
            goto L_0x0110
        L_0x014d:
            r1.setTextMatrix(r6, r4)
            java.lang.String r2 = r0.code
            r6 = 0
            java.lang.String r2 = r2.substring(r6, r10)
            r1.showText((java.lang.String) r2)
        L_0x015a:
            r2 = 11
            if (r10 < r2) goto L_0x0175
            float r6 = r0.f611x
            r7 = 1119748096(0x42be0000, float:95.0)
            float r6 = r6 * r7
            float r5 = r5 + r6
            r1.setTextMatrix(r5, r4)
            java.lang.String r4 = r0.code
            r5 = 12
            java.lang.String r2 = r4.substring(r2, r5)
            r1.showText((java.lang.String) r2)
            goto L_0x01f5
        L_0x0175:
            java.lang.String r2 = r0.code
            int r6 = r10 + 1
            java.lang.String r2 = r2.substring(r10, r6)
            com.lowagie.text.pdf.BaseFont r7 = r0.font
            float r8 = r0.size
            float r7 = r7.getWidthPoint((java.lang.String) r2, (float) r8)
            float[] r8 = TEXTPOS_EAN13
            r8 = r8[r10]
            float r9 = r0.f611x
            float r8 = r8 * r9
            float r8 = r8 + r5
            float r7 = r7 / r13
            float r8 = r8 - r7
            r1.setTextMatrix(r8, r4)
            r1.showText((java.lang.String) r2)
            r10 = r6
            goto L_0x015a
        L_0x0198:
            r2 = 0
        L_0x0199:
            if (r2 < r7) goto L_0x019c
            goto L_0x01f5
        L_0x019c:
            java.lang.String r5 = r0.code
            int r6 = r2 + 1
            java.lang.String r5 = r5.substring(r2, r6)
            com.lowagie.text.pdf.BaseFont r8 = r0.font
            float r9 = r0.size
            float r8 = r8.getWidthPoint((java.lang.String) r5, (float) r9)
            float[] r9 = TEXTPOS_EAN8
            r2 = r9[r2]
            float r9 = r0.f611x
            float r2 = r2 * r9
            float r8 = r8 / r13
            float r2 = r2 - r8
            r1.setTextMatrix(r2, r4)
            r1.showText((java.lang.String) r5)
            r2 = r6
            goto L_0x0199
        L_0x01be:
            r1.setTextMatrix(r6, r4)
            java.lang.String r2 = r0.code
            r9 = 0
            java.lang.String r2 = r2.substring(r9, r10)
            r1.showText((java.lang.String) r2)
        L_0x01cb:
            r2 = 13
            if (r10 < r2) goto L_0x01d0
            goto L_0x01f5
        L_0x01d0:
            java.lang.String r2 = r0.code
            int r6 = r10 + 1
            java.lang.String r2 = r2.substring(r10, r6)
            com.lowagie.text.pdf.BaseFont r7 = r0.font
            float r8 = r0.size
            float r7 = r7.getWidthPoint((java.lang.String) r2, (float) r8)
            float[] r8 = TEXTPOS_EAN13
            int r10 = r10 + -1
            r8 = r8[r10]
            float r9 = r0.f611x
            float r8 = r8 * r9
            float r8 = r8 + r5
            float r7 = r7 / r13
            float r8 = r8 - r7
            r1.setTextMatrix(r8, r4)
            r1.showText((java.lang.String) r2)
            r10 = r6
            goto L_0x01cb
        L_0x01f5:
            r18.endText()
        L_0x01f8:
            return r3
        L_0x01f9:
            r9 = 0
            byte r6 = r8[r14]
            float r6 = (float) r6
            float r9 = r0.f611x
            float r6 = r6 * r9
            if (r15 == 0) goto L_0x0224
            int r9 = java.util.Arrays.binarySearch(r11, r14)
            if (r9 < 0) goto L_0x0218
            float r9 = r7 - r12
            float r10 = r0.inkSpreading
            float r10 = r6 - r10
            float r13 = r0.barHeight
            float r13 = r13 + r12
            r2 = r16
            r1.rectangle(r2, r9, r10, r13)
            goto L_0x0226
        L_0x0218:
            r2 = r16
            float r9 = r0.inkSpreading
            float r9 = r6 - r9
            float r10 = r0.barHeight
            r1.rectangle(r2, r7, r9, r10)
            goto L_0x0226
        L_0x0224:
            r2 = r16
        L_0x0226:
            r15 = r15 ^ 1
            float r16 = r2 + r6
            int r14 = r14 + 1
            r2 = r20
            r6 = 0
            r10 = 1
            r13 = 1073741824(0x40000000, float:2.0)
            goto L_0x00b2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.BarcodeEAN.placeBarcode(com.lowagie.text.pdf.PdfContentByte, harmony.java.awt.Color, harmony.java.awt.Color):com.lowagie.text.Rectangle");
    }
}
