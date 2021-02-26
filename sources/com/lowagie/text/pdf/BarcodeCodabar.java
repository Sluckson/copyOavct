package com.lowagie.text.pdf;

import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Rectangle;

public class BarcodeCodabar extends Barcode {
    private static final byte[][] BARS;
    private static final String CHARS = "0123456789-$:/.+ABCD";
    private static final int START_STOP_IDX = 16;

    static {
        byte[] bArr = new byte[7];
        bArr[5] = 1;
        bArr[6] = 1;
        byte[] bArr2 = new byte[7];
        bArr2[4] = 1;
        bArr2[5] = 1;
        byte[] bArr3 = new byte[7];
        bArr3[3] = 1;
        bArr3[6] = 1;
        byte[] bArr4 = new byte[7];
        bArr4[0] = 1;
        bArr4[1] = 1;
        byte[] bArr5 = new byte[7];
        bArr5[2] = 1;
        bArr5[5] = 1;
        byte[] bArr6 = new byte[7];
        bArr6[0] = 1;
        bArr6[5] = 1;
        byte[] bArr7 = new byte[7];
        bArr7[1] = 1;
        bArr7[6] = 1;
        byte[] bArr8 = new byte[7];
        bArr8[1] = 1;
        bArr8[4] = 1;
        byte[] bArr9 = new byte[7];
        bArr9[1] = 1;
        bArr9[2] = 1;
        byte[] bArr10 = new byte[7];
        bArr10[0] = 1;
        bArr10[3] = 1;
        byte[] bArr11 = new byte[7];
        bArr11[3] = 1;
        bArr11[4] = 1;
        byte[] bArr12 = new byte[7];
        bArr12[2] = 1;
        bArr12[3] = 1;
        byte[] bArr13 = new byte[7];
        bArr13[0] = 1;
        bArr13[4] = 1;
        bArr13[6] = 1;
        byte[] bArr14 = new byte[7];
        bArr14[0] = 1;
        bArr14[2] = 1;
        bArr14[6] = 1;
        byte[] bArr15 = new byte[7];
        bArr15[0] = 1;
        bArr15[2] = 1;
        bArr15[4] = 1;
        byte[] bArr16 = new byte[7];
        bArr16[2] = 1;
        bArr16[4] = 1;
        bArr16[6] = 1;
        byte[] bArr17 = new byte[7];
        bArr17[2] = 1;
        bArr17[3] = 1;
        bArr17[5] = 1;
        byte[] bArr18 = new byte[7];
        bArr18[1] = 1;
        bArr18[3] = 1;
        bArr18[6] = 1;
        byte[] bArr19 = new byte[7];
        bArr19[3] = 1;
        bArr19[5] = 1;
        bArr19[6] = 1;
        byte[] bArr20 = new byte[7];
        bArr20[3] = 1;
        bArr20[4] = 1;
        bArr20[5] = 1;
        BARS = new byte[][]{bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, bArr9, bArr10, bArr11, bArr12, bArr13, bArr14, bArr15, bArr16, bArr17, bArr18, bArr19, bArr20};
    }

    public BarcodeCodabar() {
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
            this.startStopText = false;
            this.codeType = 12;
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public static byte[] getBarsCodabar(String str) {
        String upperCase = str.toUpperCase();
        int length = upperCase.length();
        if (length >= 2) {
            if (CHARS.indexOf(upperCase.charAt(0)) >= 16) {
                int i = length - 1;
                if (CHARS.indexOf(upperCase.charAt(i)) >= 16) {
                    byte[] bArr = new byte[((upperCase.length() * 8) - 1)];
                    int i2 = 0;
                    while (i2 < length) {
                        int indexOf = CHARS.indexOf(upperCase.charAt(i2));
                        if (indexOf >= 16 && i2 > 0 && i2 < i) {
                            throw new IllegalArgumentException("In codabar, start/stop characters are only allowed at the extremes.");
                        } else if (indexOf >= 0) {
                            System.arraycopy(BARS[indexOf], 0, bArr, i2 * 8, 7);
                            i2++;
                        } else {
                            throw new IllegalArgumentException("The character '" + upperCase.charAt(i2) + "' is illegal in codabar.");
                        }
                    }
                    return bArr;
                }
            }
            throw new IllegalArgumentException("Codabar must have one of 'ABCD' as start/stop character.");
        }
        throw new IllegalArgumentException("Codabar must have at least a start and stop character.");
    }

    public static String calculateChecksum(String str) {
        if (str.length() < 2) {
            return str;
        }
        String upperCase = str.toUpperCase();
        int length = upperCase.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i += CHARS.indexOf(upperCase.charAt(i2));
        }
        int i3 = length - 1;
        return String.valueOf(str.substring(0, i3)) + CHARS.charAt((((i + 15) / 16) * 16) - i) + str.substring(i3);
    }

    public Rectangle getBarcodeSize() {
        float f;
        float f2;
        String str = this.code;
        if (this.generateChecksum && this.checksumText) {
            str = calculateChecksum(this.code);
        }
        if (!this.startStopText) {
            str = str.substring(1, str.length() - 1);
        }
        float f3 = 0.0f;
        if (this.font != null) {
            if (this.baseline > 0.0f) {
                f2 = this.baseline - this.font.getFontDescriptor(3, this.size);
            } else {
                f2 = (-this.baseline) + this.size;
            }
            f3 = f2;
            BaseFont baseFont = this.font;
            if (this.altText != null) {
                str = this.altText;
            }
            f = baseFont.getWidthPoint(str, this.size);
        } else {
            f = 0.0f;
        }
        String str2 = this.code;
        if (this.generateChecksum) {
            str2 = calculateChecksum(this.code);
        }
        byte[] barsCodabar = getBarsCodabar(str2);
        int i = 0;
        for (byte b : barsCodabar) {
            i += b;
        }
        return new Rectangle(Math.max(this.f611x * (((float) (barsCodabar.length - i)) + (((float) i) * this.f610n)), f), this.barHeight + f3);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.lowagie.text.Rectangle placeBarcode(com.lowagie.text.pdf.PdfContentByte r12, harmony.java.awt.Color r13, harmony.java.awt.Color r14) {
        /*
            r11 = this;
            java.lang.String r0 = r11.code
            boolean r1 = r11.generateChecksum
            if (r1 == 0) goto L_0x0010
            boolean r1 = r11.checksumText
            if (r1 == 0) goto L_0x0010
            java.lang.String r0 = r11.code
            java.lang.String r0 = calculateChecksum(r0)
        L_0x0010:
            boolean r1 = r11.startStopText
            r2 = 1
            if (r1 != 0) goto L_0x001e
            int r1 = r0.length()
            int r1 = r1 - r2
            java.lang.String r0 = r0.substring(r2, r1)
        L_0x001e:
            com.lowagie.text.pdf.BaseFont r1 = r11.font
            r3 = 0
            if (r1 == 0) goto L_0x0032
            com.lowagie.text.pdf.BaseFont r1 = r11.font
            java.lang.String r4 = r11.altText
            if (r4 == 0) goto L_0x002b
            java.lang.String r0 = r11.altText
        L_0x002b:
            float r4 = r11.size
            float r1 = r1.getWidthPoint((java.lang.String) r0, (float) r4)
            goto L_0x0033
        L_0x0032:
            r1 = 0
        L_0x0033:
            boolean r4 = r11.generateChecksum
            if (r4 == 0) goto L_0x003e
            java.lang.String r4 = r11.code
            java.lang.String r4 = calculateChecksum(r4)
            goto L_0x0040
        L_0x003e:
            java.lang.String r4 = r11.code
        L_0x0040:
            byte[] r4 = getBarsCodabar(r4)
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x0047:
            int r8 = r4.length
            if (r6 < r8) goto L_0x00e6
            int r6 = r4.length
            int r6 = r6 - r7
            float r8 = r11.f611x
            float r6 = (float) r6
            float r7 = (float) r7
            float r9 = r11.f610n
            float r7 = r7 * r9
            float r6 = r6 + r7
            float r8 = r8 * r6
            int r6 = r11.textAlignment
            if (r6 == 0) goto L_0x0076
            r7 = 2
            if (r6 == r7) goto L_0x006d
            r6 = 1073741824(0x40000000, float:2.0)
            int r7 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r7 <= 0) goto L_0x0067
            float r1 = r1 - r8
            float r1 = r1 / r6
            goto L_0x0077
        L_0x0067:
            float r8 = r8 - r1
            float r1 = r8 / r6
        L_0x006a:
            r8 = r1
            r1 = 0
            goto L_0x0078
        L_0x006d:
            int r6 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r6 <= 0) goto L_0x0073
            float r1 = r1 - r8
            goto L_0x0077
        L_0x0073:
            float r1 = r8 - r1
            goto L_0x006a
        L_0x0076:
            r1 = 0
        L_0x0077:
            r8 = 0
        L_0x0078:
            com.lowagie.text.pdf.BaseFont r6 = r11.font
            if (r6 == 0) goto L_0x009a
            float r6 = r11.baseline
            int r6 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r6 > 0) goto L_0x008a
            float r6 = r11.barHeight
            float r7 = r11.baseline
            float r6 = r6 - r7
            r10 = r6
            r9 = 0
            goto L_0x009c
        L_0x008a:
            com.lowagie.text.pdf.BaseFont r3 = r11.font
            r6 = 3
            float r7 = r11.size
            float r3 = r3.getFontDescriptor(r6, r7)
            float r3 = -r3
            float r6 = r11.baseline
            float r6 = r6 + r3
            r10 = r3
            r9 = r6
            goto L_0x009c
        L_0x009a:
            r9 = 0
            r10 = 0
        L_0x009c:
            if (r13 == 0) goto L_0x00a1
            r12.setColorFill(r13)
        L_0x00a1:
            int r13 = r4.length
            if (r5 < r13) goto L_0x00c8
            r12.fill()
            com.lowagie.text.pdf.BaseFont r13 = r11.font
            if (r13 == 0) goto L_0x00c3
            if (r14 == 0) goto L_0x00b0
            r12.setColorFill(r14)
        L_0x00b0:
            r12.beginText()
            com.lowagie.text.pdf.BaseFont r13 = r11.font
            float r14 = r11.size
            r12.setFontAndSize(r13, r14)
            r12.setTextMatrix(r8, r10)
            r12.showText((java.lang.String) r0)
            r12.endText()
        L_0x00c3:
            com.lowagie.text.Rectangle r12 = r11.getBarcodeSize()
            return r12
        L_0x00c8:
            byte r13 = r4[r5]
            if (r13 != 0) goto L_0x00cf
            float r13 = r11.f611x
            goto L_0x00d5
        L_0x00cf:
            float r13 = r11.f611x
            float r3 = r11.f610n
            float r13 = r13 * r3
        L_0x00d5:
            if (r2 == 0) goto L_0x00e0
            float r3 = r11.inkSpreading
            float r3 = r13 - r3
            float r6 = r11.barHeight
            r12.rectangle(r1, r9, r3, r6)
        L_0x00e0:
            r2 = r2 ^ 1
            float r1 = r1 + r13
            int r5 = r5 + 1
            goto L_0x00a1
        L_0x00e6:
            byte r8 = r4[r6]
            int r7 = r7 + r8
            int r6 = r6 + 1
            goto L_0x0047
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.BarcodeCodabar.placeBarcode(com.lowagie.text.pdf.PdfContentByte, harmony.java.awt.Color, harmony.java.awt.Color):com.lowagie.text.Rectangle");
    }
}
