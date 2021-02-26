package com.lowagie.text.pdf;

import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Rectangle;

public class Barcode39 extends Barcode {
    private static final byte[][] BARS;
    private static final String CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%*";
    private static final String EXTENDED = "%U$A$B$C$D$E$F$G$H$I$J$K$L$M$N$O$P$Q$R$S$T$U$V$W$X$Y$Z%A%B%C%D%E  /A/B/C/D/E/F/G/H/I/J/K/L - ./O 0 1 2 3 4 5 6 7 8 9/Z%F%G%H%I%J%V A B C D E F G H I J K L M N O P Q R S T U V W X Y Z%K%L%M%N%O%W+A+B+C+D+E+F+G+H+I+J+K+L+M+N+O+P+Q+R+S+T+U+V+W+X+Y+Z%P%Q%R%S%T";

    static {
        byte[] bArr = new byte[9];
        bArr[3] = 1;
        bArr[4] = 1;
        bArr[6] = 1;
        byte[] bArr2 = new byte[9];
        bArr2[0] = 1;
        bArr2[3] = 1;
        bArr2[8] = 1;
        byte[] bArr3 = new byte[9];
        bArr3[2] = 1;
        bArr3[3] = 1;
        bArr3[8] = 1;
        byte[] bArr4 = new byte[9];
        bArr4[0] = 1;
        bArr4[2] = 1;
        bArr4[3] = 1;
        byte[] bArr5 = new byte[9];
        bArr5[3] = 1;
        bArr5[4] = 1;
        bArr5[8] = 1;
        byte[] bArr6 = new byte[9];
        bArr6[0] = 1;
        bArr6[3] = 1;
        bArr6[4] = 1;
        byte[] bArr7 = new byte[9];
        bArr7[2] = 1;
        bArr7[3] = 1;
        bArr7[4] = 1;
        byte[] bArr8 = new byte[9];
        bArr8[3] = 1;
        bArr8[6] = 1;
        bArr8[8] = 1;
        byte[] bArr9 = new byte[9];
        bArr9[0] = 1;
        bArr9[3] = 1;
        bArr9[6] = 1;
        byte[] bArr10 = new byte[9];
        bArr10[2] = 1;
        bArr10[3] = 1;
        bArr10[6] = 1;
        byte[] bArr11 = new byte[9];
        bArr11[0] = 1;
        bArr11[5] = 1;
        bArr11[8] = 1;
        byte[] bArr12 = new byte[9];
        bArr12[2] = 1;
        bArr12[5] = 1;
        bArr12[8] = 1;
        byte[] bArr13 = new byte[9];
        bArr13[0] = 1;
        bArr13[2] = 1;
        bArr13[5] = 1;
        byte[] bArr14 = new byte[9];
        bArr14[4] = 1;
        bArr14[5] = 1;
        bArr14[8] = 1;
        byte[] bArr15 = new byte[9];
        bArr15[0] = 1;
        bArr15[4] = 1;
        bArr15[5] = 1;
        byte[] bArr16 = new byte[9];
        bArr16[2] = 1;
        bArr16[4] = 1;
        bArr16[5] = 1;
        byte[] bArr17 = new byte[9];
        bArr17[5] = 1;
        bArr17[6] = 1;
        bArr17[8] = 1;
        byte[] bArr18 = new byte[9];
        bArr18[0] = 1;
        bArr18[5] = 1;
        bArr18[6] = 1;
        byte[] bArr19 = new byte[9];
        bArr19[2] = 1;
        bArr19[5] = 1;
        bArr19[6] = 1;
        byte[] bArr20 = new byte[9];
        bArr20[4] = 1;
        bArr20[5] = 1;
        bArr20[6] = 1;
        byte[] bArr21 = new byte[9];
        bArr21[0] = 1;
        bArr21[7] = 1;
        bArr21[8] = 1;
        byte[] bArr22 = new byte[9];
        bArr22[2] = 1;
        bArr22[7] = 1;
        bArr22[8] = 1;
        byte[] bArr23 = new byte[9];
        bArr23[0] = 1;
        bArr23[2] = 1;
        bArr23[7] = 1;
        byte[] bArr24 = new byte[9];
        bArr24[4] = 1;
        bArr24[7] = 1;
        bArr24[8] = 1;
        byte[] bArr25 = new byte[9];
        bArr25[0] = 1;
        bArr25[4] = 1;
        bArr25[7] = 1;
        byte[] bArr26 = new byte[9];
        bArr26[2] = 1;
        bArr26[4] = 1;
        bArr26[7] = 1;
        byte[] bArr27 = new byte[9];
        bArr27[6] = 1;
        bArr27[7] = 1;
        bArr27[8] = 1;
        byte[] bArr28 = new byte[9];
        bArr28[0] = 1;
        bArr28[6] = 1;
        bArr28[7] = 1;
        byte[] bArr29 = new byte[9];
        bArr29[2] = 1;
        bArr29[6] = 1;
        bArr29[7] = 1;
        byte[] bArr30 = new byte[9];
        bArr30[4] = 1;
        bArr30[6] = 1;
        bArr30[7] = 1;
        byte[] bArr31 = new byte[9];
        bArr31[0] = 1;
        bArr31[1] = 1;
        bArr31[8] = 1;
        byte[] bArr32 = new byte[9];
        bArr32[1] = 1;
        bArr32[2] = 1;
        bArr32[8] = 1;
        byte[] bArr33 = new byte[9];
        bArr33[0] = 1;
        bArr33[1] = 1;
        bArr33[2] = 1;
        byte[] bArr34 = new byte[9];
        bArr34[1] = 1;
        bArr34[4] = 1;
        bArr34[8] = 1;
        byte[] bArr35 = new byte[9];
        bArr35[0] = 1;
        bArr35[1] = 1;
        bArr35[4] = 1;
        byte[] bArr36 = new byte[9];
        bArr36[1] = 1;
        bArr36[2] = 1;
        bArr36[4] = 1;
        byte[] bArr37 = new byte[9];
        bArr37[1] = 1;
        bArr37[6] = 1;
        bArr37[8] = 1;
        byte[] bArr38 = new byte[9];
        bArr38[0] = 1;
        bArr38[1] = 1;
        bArr38[6] = 1;
        byte[] bArr39 = new byte[9];
        bArr39[1] = 1;
        bArr39[2] = 1;
        bArr39[6] = 1;
        byte[] bArr40 = new byte[9];
        bArr40[1] = 1;
        bArr40[3] = 1;
        bArr40[5] = 1;
        byte[] bArr41 = new byte[9];
        bArr41[1] = 1;
        bArr41[3] = 1;
        bArr41[7] = 1;
        byte[] bArr42 = new byte[9];
        bArr42[1] = 1;
        bArr42[5] = 1;
        bArr42[7] = 1;
        byte[] bArr43 = new byte[9];
        bArr43[3] = 1;
        bArr43[5] = 1;
        bArr43[7] = 1;
        byte[] bArr44 = new byte[9];
        bArr44[1] = 1;
        bArr44[4] = 1;
        bArr44[6] = 1;
        BARS = new byte[][]{bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, bArr9, bArr10, bArr11, bArr12, bArr13, bArr14, bArr15, bArr16, bArr17, bArr18, bArr19, bArr20, bArr21, bArr22, bArr23, bArr24, bArr25, bArr26, bArr27, bArr28, bArr29, bArr30, bArr31, bArr32, bArr33, bArr34, bArr35, bArr36, bArr37, bArr38, bArr39, bArr40, bArr41, bArr42, bArr43, bArr44};
    }

    public Barcode39() {
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
            this.startStopText = true;
            this.extended = false;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static byte[] getBarsCode39(String str) {
        String str2 = "*" + str + "*";
        byte[] bArr = new byte[((str2.length() * 10) - 1)];
        int i = 0;
        while (i < str2.length()) {
            int indexOf = CHARS.indexOf(str2.charAt(i));
            if (indexOf >= 0) {
                System.arraycopy(BARS[indexOf], 0, bArr, i * 10, 9);
                i++;
            } else {
                throw new IllegalArgumentException("The character '" + str2.charAt(i) + "' is illegal in code 39.");
            }
        }
        return bArr;
    }

    public static String getCode39Ex(String str) {
        String str2 = "";
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt <= 127) {
                int i2 = charAt * 2;
                char charAt2 = EXTENDED.charAt(i2);
                char charAt3 = EXTENDED.charAt(i2 + 1);
                if (charAt2 != ' ') {
                    str2 = String.valueOf(str2) + charAt2;
                }
                str2 = String.valueOf(str2) + charAt3;
                i++;
            } else {
                throw new IllegalArgumentException("The character '" + charAt + "' is illegal in code 39 extended.");
            }
        }
        return str2;
    }

    static char getChecksum(String str) {
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            int indexOf = CHARS.indexOf(str.charAt(i));
            if (indexOf >= 0) {
                i2 += indexOf;
                i++;
            } else {
                throw new IllegalArgumentException("The character '" + str.charAt(i) + "' is illegal in code 39.");
            }
        }
        return CHARS.charAt(i2 % 43);
    }

    public Rectangle getBarcodeSize() {
        float f;
        float f2;
        String str = this.code;
        if (this.extended) {
            str = getCode39Ex(this.code);
        }
        float f3 = 0.0f;
        if (this.font != null) {
            if (this.baseline > 0.0f) {
                f2 = this.baseline - this.font.getFontDescriptor(3, this.size);
            } else {
                f2 = (-this.baseline) + this.size;
            }
            f3 = f2;
            String str2 = this.code;
            if (this.generateChecksum && this.checksumText) {
                str2 = String.valueOf(str2) + getChecksum(str);
            }
            if (this.startStopText) {
                str2 = "*" + str2 + "*";
            }
            BaseFont baseFont = this.font;
            if (this.altText != null) {
                str2 = this.altText;
            }
            f = baseFont.getWidthPoint(str2, this.size);
        } else {
            f = 0.0f;
        }
        int length = str.length() + 2;
        if (this.generateChecksum) {
            length++;
        }
        return new Rectangle(Math.max((((float) length) * ((this.f611x * 6.0f) + (this.f611x * 3.0f * this.f610n))) + (((float) (length - 1)) * this.f611x), f), this.barHeight + f3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x0101  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.lowagie.text.Rectangle placeBarcode(com.lowagie.text.pdf.PdfContentByte r12, harmony.java.awt.Color r13, harmony.java.awt.Color r14) {
        /*
            r11 = this;
            java.lang.String r0 = r11.code
            java.lang.String r1 = r11.code
            boolean r2 = r11.extended
            if (r2 == 0) goto L_0x000e
            java.lang.String r1 = r11.code
            java.lang.String r1 = getCode39Ex(r1)
        L_0x000e:
            com.lowagie.text.pdf.BaseFont r2 = r11.font
            r3 = 0
            if (r2 == 0) goto L_0x0053
            boolean r2 = r11.generateChecksum
            if (r2 == 0) goto L_0x002f
            boolean r2 = r11.checksumText
            if (r2 == 0) goto L_0x002f
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r0 = java.lang.String.valueOf(r0)
            r2.<init>(r0)
            char r0 = getChecksum(r1)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
        L_0x002f:
            boolean r2 = r11.startStopText
            if (r2 == 0) goto L_0x0044
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "*"
            r2.<init>(r4)
            r2.append(r0)
            r2.append(r4)
            java.lang.String r0 = r2.toString()
        L_0x0044:
            com.lowagie.text.pdf.BaseFont r2 = r11.font
            java.lang.String r4 = r11.altText
            if (r4 == 0) goto L_0x004c
            java.lang.String r0 = r11.altText
        L_0x004c:
            float r4 = r11.size
            float r2 = r2.getWidthPoint((java.lang.String) r0, (float) r4)
            goto L_0x0054
        L_0x0053:
            r2 = 0
        L_0x0054:
            boolean r4 = r11.generateChecksum
            if (r4 == 0) goto L_0x006c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = java.lang.String.valueOf(r1)
            r4.<init>(r5)
            char r1 = getChecksum(r1)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
        L_0x006c:
            int r4 = r1.length()
            r5 = 2
            int r4 = r4 + r5
            float r6 = (float) r4
            r7 = 1086324736(0x40c00000, float:6.0)
            float r8 = r11.f611x
            float r8 = r8 * r7
            r7 = 1077936128(0x40400000, float:3.0)
            float r9 = r11.f611x
            float r9 = r9 * r7
            float r7 = r11.f610n
            float r9 = r9 * r7
            float r8 = r8 + r9
            float r6 = r6 * r8
            r7 = 1
            int r4 = r4 - r7
            float r4 = (float) r4
            float r8 = r11.f611x
            float r4 = r4 * r8
            float r6 = r6 + r4
            int r4 = r11.textAlignment
            if (r4 == 0) goto L_0x00ac
            if (r4 == r5) goto L_0x00a3
            r4 = 1073741824(0x40000000, float:2.0)
            int r5 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r5 <= 0) goto L_0x009d
            float r2 = r2 - r6
            float r2 = r2 / r4
            goto L_0x00ad
        L_0x009d:
            float r6 = r6 - r2
            float r2 = r6 / r4
        L_0x00a0:
            r4 = r2
            r2 = 0
            goto L_0x00ae
        L_0x00a3:
            int r4 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x00a9
            float r2 = r2 - r6
            goto L_0x00ad
        L_0x00a9:
            float r2 = r6 - r2
            goto L_0x00a0
        L_0x00ac:
            r2 = 0
        L_0x00ad:
            r4 = 0
        L_0x00ae:
            com.lowagie.text.pdf.BaseFont r5 = r11.font
            if (r5 == 0) goto L_0x00cf
            float r5 = r11.baseline
            int r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x00be
            float r5 = r11.barHeight
            float r6 = r11.baseline
            float r5 = r5 - r6
            goto L_0x00d0
        L_0x00be:
            com.lowagie.text.pdf.BaseFont r3 = r11.font
            r5 = 3
            float r6 = r11.size
            float r3 = r3.getFontDescriptor(r5, r6)
            float r3 = -r3
            float r5 = r11.baseline
            float r5 = r5 + r3
            r10 = r5
            r5 = r3
            r3 = r10
            goto L_0x00d0
        L_0x00cf:
            r5 = 0
        L_0x00d0:
            byte[] r1 = getBarsCode39(r1)
            if (r13 == 0) goto L_0x00d9
            r12.setColorFill(r13)
        L_0x00d9:
            r13 = 0
        L_0x00da:
            int r6 = r1.length
            if (r13 < r6) goto L_0x0101
            r12.fill()
            com.lowagie.text.pdf.BaseFont r13 = r11.font
            if (r13 == 0) goto L_0x00fc
            if (r14 == 0) goto L_0x00e9
            r12.setColorFill(r14)
        L_0x00e9:
            r12.beginText()
            com.lowagie.text.pdf.BaseFont r13 = r11.font
            float r14 = r11.size
            r12.setFontAndSize(r13, r14)
            r12.setTextMatrix(r4, r5)
            r12.showText((java.lang.String) r0)
            r12.endText()
        L_0x00fc:
            com.lowagie.text.Rectangle r12 = r11.getBarcodeSize()
            return r12
        L_0x0101:
            byte r6 = r1[r13]
            if (r6 != 0) goto L_0x0108
            float r6 = r11.f611x
            goto L_0x010e
        L_0x0108:
            float r6 = r11.f611x
            float r8 = r11.f610n
            float r6 = r6 * r8
        L_0x010e:
            if (r7 == 0) goto L_0x0119
            float r8 = r11.inkSpreading
            float r8 = r6 - r8
            float r9 = r11.barHeight
            r12.rectangle(r2, r3, r8, r9)
        L_0x0119:
            r7 = r7 ^ 1
            float r2 = r2 + r6
            int r13 = r13 + 1
            goto L_0x00da
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.Barcode39.placeBarcode(com.lowagie.text.pdf.PdfContentByte, harmony.java.awt.Color, harmony.java.awt.Color):com.lowagie.text.Rectangle");
    }
}
