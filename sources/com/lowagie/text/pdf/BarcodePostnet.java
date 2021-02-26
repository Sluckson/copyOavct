package com.lowagie.text.pdf;

import com.lowagie.text.Rectangle;
import harmony.java.awt.Color;

public class BarcodePostnet extends Barcode {
    private static final byte[][] BARS;

    static {
        byte[] bArr = new byte[5];
        bArr[0] = 1;
        bArr[1] = 1;
        byte[] bArr2 = new byte[5];
        bArr2[3] = 1;
        bArr2[4] = 1;
        byte[] bArr3 = new byte[5];
        bArr3[2] = 1;
        bArr3[4] = 1;
        byte[] bArr4 = new byte[5];
        bArr4[2] = 1;
        bArr4[3] = 1;
        byte[] bArr5 = new byte[5];
        bArr5[1] = 1;
        bArr5[4] = 1;
        byte[] bArr6 = new byte[5];
        bArr6[1] = 1;
        bArr6[3] = 1;
        byte[] bArr7 = new byte[5];
        bArr7[1] = 1;
        bArr7[2] = 1;
        byte[] bArr8 = new byte[5];
        bArr8[0] = 1;
        bArr8[4] = 1;
        byte[] bArr9 = new byte[5];
        bArr9[0] = 1;
        bArr9[3] = 1;
        byte[] bArr10 = new byte[5];
        bArr10[0] = 1;
        bArr10[2] = 1;
        BARS = new byte[][]{bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, bArr9, bArr10};
    }

    public BarcodePostnet() {
        this.f610n = 3.2727273f;
        this.f611x = 1.4399999f;
        this.barHeight = 9.0f;
        this.size = 3.6000001f;
        this.codeType = 7;
    }

    public static byte[] getBarsPostnet(String str) {
        int i = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            i += str.charAt(length) - '0';
        }
        String str2 = String.valueOf(str) + ((char) (((10 - (i % 10)) % 10) + 48));
        byte[] bArr = new byte[((str2.length() * 5) + 2)];
        bArr[0] = 1;
        bArr[bArr.length - 1] = 1;
        for (int i2 = 0; i2 < str2.length(); i2++) {
            System.arraycopy(BARS[str2.charAt(i2) - '0'], 0, bArr, (i2 * 5) + 1, 5);
        }
        return bArr;
    }

    public Rectangle getBarcodeSize() {
        return new Rectangle((((float) (((this.code.length() + 1) * 5) + 1)) * this.f610n) + this.f611x, this.barHeight);
    }

    public Rectangle placeBarcode(PdfContentByte pdfContentByte, Color color, Color color2) {
        if (color != null) {
            pdfContentByte.setColorFill(color);
        }
        byte[] barsPostnet = getBarsPostnet(this.code);
        byte b = 1;
        if (this.codeType == 8) {
            barsPostnet[0] = 0;
            barsPostnet[barsPostnet.length - 1] = 0;
            b = 0;
        }
        float f = 0.0f;
        for (int i = 0; i < barsPostnet.length; i++) {
            pdfContentByte.rectangle(f, 0.0f, this.f611x - this.inkSpreading, barsPostnet[i] == b ? this.barHeight : this.size);
            f += this.f610n;
        }
        pdfContentByte.fill();
        return getBarcodeSize();
    }
}
