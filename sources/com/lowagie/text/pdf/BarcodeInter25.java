package com.lowagie.text.pdf;

import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Rectangle;

public class BarcodeInter25 extends Barcode {
    private static final byte[][] BARS;

    static {
        byte[] bArr = new byte[5];
        bArr[2] = 1;
        bArr[3] = 1;
        byte[] bArr2 = new byte[5];
        bArr2[0] = 1;
        bArr2[4] = 1;
        byte[] bArr3 = new byte[5];
        bArr3[1] = 1;
        bArr3[4] = 1;
        byte[] bArr4 = new byte[5];
        bArr4[0] = 1;
        bArr4[1] = 1;
        byte[] bArr5 = new byte[5];
        bArr5[2] = 1;
        bArr5[4] = 1;
        byte[] bArr6 = new byte[5];
        bArr6[0] = 1;
        bArr6[2] = 1;
        byte[] bArr7 = new byte[5];
        bArr7[1] = 1;
        bArr7[2] = 1;
        byte[] bArr8 = new byte[5];
        bArr8[3] = 1;
        bArr8[4] = 1;
        byte[] bArr9 = new byte[5];
        bArr9[0] = 1;
        bArr9[3] = 1;
        byte[] bArr10 = new byte[5];
        bArr10[1] = 1;
        bArr10[3] = 1;
        BARS = new byte[][]{bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, bArr9, bArr10};
    }

    public BarcodeInter25() {
        try {
            this.f611x = 0.8f;
            this.f610n = 2.0f;
            this.font = BaseFont.createFont("Helvetica", "winansi", false);
            this.size = 8.0f;
            this.baseline = this.size;
            this.barHeight = this.size * 3.0f;
            this.textAlignment = 1;
            this.generateChecksum = false;
            this.checksumText = false;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static String keepNumbers(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                stringBuffer.append(charAt);
            }
        }
        return stringBuffer.toString();
    }

    public static char getChecksum(String str) {
        int i = 3;
        int i2 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            i2 += (str.charAt(length) - '0') * i;
            i ^= 2;
        }
        return (char) (((10 - (i2 % 10)) % 10) + 48);
    }

    public static byte[] getBarsInter25(String str) {
        String keepNumbers = keepNumbers(str);
        if ((keepNumbers.length() & 1) == 0) {
            byte[] bArr = new byte[((keepNumbers.length() * 5) + 7)];
            bArr[0] = 0;
            bArr[1] = 0;
            bArr[2] = 0;
            int i = 4;
            bArr[3] = 0;
            int length = keepNumbers.length() / 2;
            int i2 = 0;
            while (i2 < length) {
                int i3 = i2 * 2;
                byte[][] bArr2 = BARS;
                byte[] bArr3 = bArr2[keepNumbers.charAt(i3) - '0'];
                byte[] bArr4 = bArr2[keepNumbers.charAt(i3 + 1) - '0'];
                int i4 = i;
                for (int i5 = 0; i5 < 5; i5++) {
                    int i6 = i4 + 1;
                    bArr[i4] = bArr3[i5];
                    i4 = i6 + 1;
                    bArr[i6] = bArr4[i5];
                }
                i2++;
                i = i4;
            }
            int i7 = i + 1;
            bArr[i] = 1;
            bArr[i7] = 0;
            bArr[i7 + 1] = 0;
            return bArr;
        }
        throw new IllegalArgumentException("The text length must be even.");
    }

    public Rectangle getBarcodeSize() {
        float f;
        float f2;
        float f3 = 0.0f;
        if (this.font != null) {
            if (this.baseline > 0.0f) {
                f2 = this.baseline - this.font.getFontDescriptor(3, this.size);
            } else {
                f2 = (-this.baseline) + this.size;
            }
            f3 = f2;
            String str = this.code;
            if (this.generateChecksum && this.checksumText) {
                str = String.valueOf(str) + getChecksum(str);
            }
            BaseFont baseFont = this.font;
            if (this.altText != null) {
                str = this.altText;
            }
            f = baseFont.getWidthPoint(str, this.size);
        } else {
            f = 0.0f;
        }
        int length = keepNumbers(this.code).length();
        if (this.generateChecksum) {
            length++;
        }
        return new Rectangle(Math.max((((float) length) * ((this.f611x * 3.0f) + (this.f611x * 2.0f * this.f610n))) + ((this.f610n + 6.0f) * this.f611x), f), this.barHeight + f3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0096  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ba  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.lowagie.text.Rectangle placeBarcode(com.lowagie.text.pdf.PdfContentByte r12, harmony.java.awt.Color r13, harmony.java.awt.Color r14) {
        /*
            r11 = this;
            java.lang.String r0 = r11.code
            com.lowagie.text.pdf.BaseFont r1 = r11.font
            r2 = 0
            if (r1 == 0) goto L_0x0032
            boolean r1 = r11.generateChecksum
            if (r1 == 0) goto L_0x0023
            boolean r1 = r11.checksumText
            if (r1 == 0) goto L_0x0023
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r3 = java.lang.String.valueOf(r0)
            r1.<init>(r3)
            char r0 = getChecksum(r0)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
        L_0x0023:
            com.lowagie.text.pdf.BaseFont r1 = r11.font
            java.lang.String r3 = r11.altText
            if (r3 == 0) goto L_0x002b
            java.lang.String r0 = r11.altText
        L_0x002b:
            float r3 = r11.size
            float r1 = r1.getWidthPoint((java.lang.String) r0, (float) r3)
            goto L_0x0033
        L_0x0032:
            r1 = 0
        L_0x0033:
            java.lang.String r3 = r11.code
            java.lang.String r3 = keepNumbers(r3)
            boolean r4 = r11.generateChecksum
            if (r4 == 0) goto L_0x0051
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = java.lang.String.valueOf(r3)
            r4.<init>(r5)
            char r3 = getChecksum(r3)
            r4.append(r3)
            java.lang.String r3 = r4.toString()
        L_0x0051:
            int r4 = r3.length()
            float r4 = (float) r4
            r5 = 1077936128(0x40400000, float:3.0)
            float r6 = r11.f611x
            float r6 = r6 * r5
            float r5 = r11.f611x
            r7 = 1073741824(0x40000000, float:2.0)
            float r5 = r5 * r7
            float r8 = r11.f610n
            float r5 = r5 * r8
            float r6 = r6 + r5
            float r4 = r4 * r6
            r5 = 1086324736(0x40c00000, float:6.0)
            float r6 = r11.f610n
            float r6 = r6 + r5
            float r5 = r11.f611x
            float r6 = r6 * r5
            float r4 = r4 + r6
            int r5 = r11.textAlignment
            if (r5 == 0) goto L_0x0090
            r6 = 2
            if (r5 == r6) goto L_0x0087
            int r5 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r5 <= 0) goto L_0x0081
            float r1 = r1 - r4
            float r1 = r1 / r7
            goto L_0x0091
        L_0x0081:
            float r4 = r4 - r1
            float r1 = r4 / r7
        L_0x0084:
            r4 = r1
            r1 = 0
            goto L_0x0092
        L_0x0087:
            int r5 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r5 <= 0) goto L_0x008d
            float r1 = r1 - r4
            goto L_0x0091
        L_0x008d:
            float r1 = r4 - r1
            goto L_0x0084
        L_0x0090:
            r1 = 0
        L_0x0091:
            r4 = 0
        L_0x0092:
            com.lowagie.text.pdf.BaseFont r5 = r11.font
            if (r5 == 0) goto L_0x00b3
            float r5 = r11.baseline
            int r5 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r5 > 0) goto L_0x00a2
            float r5 = r11.barHeight
            float r6 = r11.baseline
            float r5 = r5 - r6
            goto L_0x00b4
        L_0x00a2:
            com.lowagie.text.pdf.BaseFont r2 = r11.font
            r5 = 3
            float r6 = r11.size
            float r2 = r2.getFontDescriptor(r5, r6)
            float r2 = -r2
            float r5 = r11.baseline
            float r5 = r5 + r2
            r10 = r5
            r5 = r2
            r2 = r10
            goto L_0x00b4
        L_0x00b3:
            r5 = 0
        L_0x00b4:
            byte[] r3 = getBarsInter25(r3)
            if (r13 == 0) goto L_0x00bd
            r12.setColorFill(r13)
        L_0x00bd:
            r13 = 0
            r6 = 1
        L_0x00bf:
            int r7 = r3.length
            if (r13 < r7) goto L_0x00e6
            r12.fill()
            com.lowagie.text.pdf.BaseFont r13 = r11.font
            if (r13 == 0) goto L_0x00e1
            if (r14 == 0) goto L_0x00ce
            r12.setColorFill(r14)
        L_0x00ce:
            r12.beginText()
            com.lowagie.text.pdf.BaseFont r13 = r11.font
            float r14 = r11.size
            r12.setFontAndSize(r13, r14)
            r12.setTextMatrix(r4, r5)
            r12.showText((java.lang.String) r0)
            r12.endText()
        L_0x00e1:
            com.lowagie.text.Rectangle r12 = r11.getBarcodeSize()
            return r12
        L_0x00e6:
            byte r7 = r3[r13]
            if (r7 != 0) goto L_0x00ed
            float r7 = r11.f611x
            goto L_0x00f3
        L_0x00ed:
            float r7 = r11.f611x
            float r8 = r11.f610n
            float r7 = r7 * r8
        L_0x00f3:
            if (r6 == 0) goto L_0x00fe
            float r8 = r11.inkSpreading
            float r8 = r7 - r8
            float r9 = r11.barHeight
            r12.rectangle(r1, r2, r8, r9)
        L_0x00fe:
            r6 = r6 ^ 1
            float r1 = r1 + r7
            int r13 = r13 + 1
            goto L_0x00bf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.BarcodeInter25.placeBarcode(com.lowagie.text.pdf.PdfContentByte, harmony.java.awt.Color, harmony.java.awt.Color):com.lowagie.text.Rectangle");
    }
}
