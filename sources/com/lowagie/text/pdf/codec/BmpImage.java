package com.lowagie.text.pdf.codec;

import com.lowagie.text.BadElementException;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Image;
import com.lowagie.text.ImgRaw;
import com.lowagie.text.Utilities;
import com.lowagie.text.pdf.PdfArray;
import com.lowagie.text.pdf.PdfDictionary;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfNumber;
import com.lowagie.text.pdf.PdfObject;
import com.lowagie.text.pdf.PdfString;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public class BmpImage {
    private static final int BI_BITFIELDS = 3;
    private static final int BI_RGB = 0;
    private static final int BI_RLE4 = 2;
    private static final int BI_RLE8 = 1;
    private static final int LCS_CALIBRATED_RGB = 0;
    private static final int LCS_CMYK = 2;
    private static final int LCS_sRGB = 1;
    private static final int VERSION_2_1_BIT = 0;
    private static final int VERSION_2_24_BIT = 3;
    private static final int VERSION_2_4_BIT = 1;
    private static final int VERSION_2_8_BIT = 2;
    private static final int VERSION_3_1_BIT = 4;
    private static final int VERSION_3_24_BIT = 7;
    private static final int VERSION_3_4_BIT = 5;
    private static final int VERSION_3_8_BIT = 6;
    private static final int VERSION_3_NT_16_BIT = 8;
    private static final int VERSION_3_NT_32_BIT = 9;
    private static final int VERSION_4_16_BIT = 13;
    private static final int VERSION_4_1_BIT = 10;
    private static final int VERSION_4_24_BIT = 14;
    private static final int VERSION_4_32_BIT = 15;
    private static final int VERSION_4_4_BIT = 11;
    private static final int VERSION_4_8_BIT = 12;
    private int alphaMask;
    private long bitmapFileSize;
    private long bitmapOffset;
    private int bitsPerPixel;
    private int blueMask;
    private long compression;
    private int greenMask;
    int height;
    private long imageSize;
    private int imageType;
    private InputStream inputStream;
    private boolean isBottomUp;
    private int numBands;
    private byte[] palette;
    public HashMap properties = new HashMap();
    private int redMask;
    int width;
    private long xPelsPerMeter;
    private long yPelsPerMeter;

    private int findMask(int i) {
        for (int i2 = 0; i2 < 32 && (i & 1) != 1; i2++) {
            i >>>= 1;
        }
        return i;
    }

    private int findShift(int i) {
        int i2 = 0;
        while (i2 < 32 && (i & 1) != 1) {
            i >>>= 1;
            i2++;
        }
        return i2;
    }

    BmpImage(InputStream inputStream2, boolean z, int i) throws IOException {
        this.bitmapFileSize = (long) i;
        this.bitmapOffset = 0;
        process(inputStream2, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0017  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.lowagie.text.Image getImage(java.net.URL r2) throws java.io.IOException {
        /*
            java.io.InputStream r0 = com.google.firebase.perf.network.FirebasePerfUrlConnection.openStream(r2)     // Catch:{ all -> 0x0013 }
            com.lowagie.text.Image r1 = getImage((java.io.InputStream) r0)     // Catch:{ all -> 0x0011 }
            r1.setUrl(r2)     // Catch:{ all -> 0x0011 }
            if (r0 == 0) goto L_0x0010
            r0.close()
        L_0x0010:
            return r1
        L_0x0011:
            r2 = move-exception
            goto L_0x0015
        L_0x0013:
            r2 = move-exception
            r0 = 0
        L_0x0015:
            if (r0 == 0) goto L_0x001a
            r0.close()
        L_0x001a:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.codec.BmpImage.getImage(java.net.URL):com.lowagie.text.Image");
    }

    public static Image getImage(InputStream inputStream2) throws IOException {
        return getImage(inputStream2, false, 0);
    }

    public static Image getImage(InputStream inputStream2, boolean z, int i) throws IOException {
        BmpImage bmpImage = new BmpImage(inputStream2, z, i);
        try {
            Image image = bmpImage.getImage();
            image.setDpi((int) ((((double) bmpImage.xPelsPerMeter) * 0.0254d) + 0.5d), (int) ((((double) bmpImage.yPelsPerMeter) * 0.0254d) + 0.5d));
            image.setOriginalType(4);
            return image;
        } catch (BadElementException e) {
            throw new ExceptionConverter(e);
        }
    }

    public static Image getImage(String str) throws IOException {
        return getImage(Utilities.toURL(str));
    }

    public static Image getImage(byte[] bArr) throws IOException {
        Image image = getImage((InputStream) new ByteArrayInputStream(bArr));
        image.setOriginalData(bArr);
        return image;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x044b, code lost:
        r6 = ((int) r14) * 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x044e, code lost:
        r0.bitmapOffset = r1 + ((long) r6);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void process(java.io.InputStream r34, boolean r35) throws java.io.IOException {
        /*
            r33 = this;
            r0 = r33
            r1 = r34
            if (r35 != 0) goto L_0x0013
            boolean r2 = r1 instanceof java.io.BufferedInputStream
            if (r2 == 0) goto L_0x000b
            goto L_0x0013
        L_0x000b:
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream
            r2.<init>(r1)
            r0.inputStream = r2
            goto L_0x0015
        L_0x0013:
            r0.inputStream = r1
        L_0x0015:
            if (r35 != 0) goto L_0x004e
            java.io.InputStream r1 = r0.inputStream
            int r1 = r0.readUnsignedByte(r1)
            r2 = 66
            if (r1 != r2) goto L_0x0046
            java.io.InputStream r1 = r0.inputStream
            int r1 = r0.readUnsignedByte(r1)
            r2 = 77
            if (r1 != r2) goto L_0x0046
            java.io.InputStream r1 = r0.inputStream
            long r1 = r0.readDWord(r1)
            r0.bitmapFileSize = r1
            java.io.InputStream r1 = r0.inputStream
            r0.readWord(r1)
            java.io.InputStream r1 = r0.inputStream
            r0.readWord(r1)
            java.io.InputStream r1 = r0.inputStream
            long r1 = r0.readDWord(r1)
            r0.bitmapOffset = r1
            goto L_0x004e
        L_0x0046:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Invalid magic value for BMP file."
            r1.<init>(r2)
            throw r1
        L_0x004e:
            java.io.InputStream r1 = r0.inputStream
            long r1 = r0.readDWord(r1)
            r3 = 12
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x006b
            java.io.InputStream r3 = r0.inputStream
            int r3 = r0.readWord(r3)
            r0.width = r3
            java.io.InputStream r3 = r0.inputStream
            int r3 = r0.readWord(r3)
            r0.height = r3
            goto L_0x007b
        L_0x006b:
            java.io.InputStream r3 = r0.inputStream
            int r3 = r0.readLong(r3)
            r0.width = r3
            java.io.InputStream r3 = r0.inputStream
            int r3 = r0.readLong(r3)
            r0.height = r3
        L_0x007b:
            java.io.InputStream r3 = r0.inputStream
            int r3 = r0.readWord(r3)
            java.io.InputStream r4 = r0.inputStream
            int r4 = r0.readWord(r4)
            r0.bitsPerPixel = r4
            java.util.HashMap r4 = r0.properties
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r3)
            java.lang.String r3 = "color_planes"
            r4.put(r3, r6)
            java.util.HashMap r3 = r0.properties
            java.lang.Integer r4 = new java.lang.Integer
            int r6 = r0.bitsPerPixel
            r4.<init>(r6)
            java.lang.String r6 = "bits_per_pixel"
            r3.put(r6, r4)
            r3 = 3
            r0.numBands = r3
            long r6 = r0.bitmapOffset
            r8 = 0
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 != 0) goto L_0x00b0
            r0.bitmapOffset = r1
        L_0x00b0:
            r6 = 16
            java.lang.String r7 = "bmp_version"
            r10 = 8
            r11 = 0
            r12 = 2
            r13 = 1
            r14 = 4
            if (r5 != 0) goto L_0x0109
            java.util.HashMap r5 = r0.properties
            java.lang.String r8 = "BMP v. 2.x"
            r5.put(r7, r8)
            int r5 = r0.bitsPerPixel
            if (r5 != r13) goto L_0x00ca
            r0.imageType = r11
            goto L_0x00da
        L_0x00ca:
            if (r5 != r14) goto L_0x00cf
            r0.imageType = r13
            goto L_0x00da
        L_0x00cf:
            if (r5 != r10) goto L_0x00d4
            r0.imageType = r12
            goto L_0x00da
        L_0x00d4:
            r7 = 24
            if (r5 != r7) goto L_0x00da
            r0.imageType = r3
        L_0x00da:
            long r7 = r0.bitmapOffset
            r15 = 14
            long r15 = r7 - r15
            long r15 = r15 - r1
            r17 = 3
            long r14 = r15 / r17
            int r5 = (int) r14
            int r5 = r5 * 3
            int r9 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r9 != 0) goto L_0x0104
            int r7 = r0.imageType
            if (r7 == 0) goto L_0x00ff
            if (r7 == r13) goto L_0x00fc
            if (r7 == r12) goto L_0x00f9
            if (r7 == r3) goto L_0x00f7
            goto L_0x0100
        L_0x00f7:
            r5 = 0
            goto L_0x0100
        L_0x00f9:
            r5 = 768(0x300, float:1.076E-42)
            goto L_0x0100
        L_0x00fc:
            r5 = 48
            goto L_0x0100
        L_0x00ff:
            r5 = 6
        L_0x0100:
            long r7 = (long) r5
            long r1 = r1 + r7
            r0.bitmapOffset = r1
        L_0x0104:
            r0.readPalette(r5)
            goto L_0x0479
        L_0x0109:
            java.io.InputStream r5 = r0.inputStream
            long r14 = r0.readDWord(r5)
            r0.compression = r14
            java.io.InputStream r5 = r0.inputStream
            long r14 = r0.readDWord(r5)
            r0.imageSize = r14
            java.io.InputStream r5 = r0.inputStream
            int r5 = r0.readLong(r5)
            long r14 = (long) r5
            r0.xPelsPerMeter = r14
            java.io.InputStream r5 = r0.inputStream
            int r5 = r0.readLong(r5)
            long r14 = (long) r5
            r0.yPelsPerMeter = r14
            java.io.InputStream r5 = r0.inputStream
            long r14 = r0.readDWord(r5)
            java.io.InputStream r5 = r0.inputStream
            long r8 = r0.readDWord(r5)
            long r4 = r0.compression
            int r5 = (int) r4
            java.lang.String r4 = "compression"
            if (r5 == 0) goto L_0x015d
            if (r5 == r13) goto L_0x0155
            if (r5 == r12) goto L_0x014d
            if (r5 == r3) goto L_0x0145
            goto L_0x0164
        L_0x0145:
            java.util.HashMap r5 = r0.properties
            java.lang.String r11 = "BI_BITFIELDS"
            r5.put(r4, r11)
            goto L_0x0164
        L_0x014d:
            java.util.HashMap r5 = r0.properties
            java.lang.String r11 = "BI_RLE4"
            r5.put(r4, r11)
            goto L_0x0164
        L_0x0155:
            java.util.HashMap r5 = r0.properties
            java.lang.String r11 = "BI_RLE8"
            r5.put(r4, r11)
            goto L_0x0164
        L_0x015d:
            java.util.HashMap r5 = r0.properties
            java.lang.String r11 = "BI_RGB"
            r5.put(r4, r11)
        L_0x0164:
            java.util.HashMap r4 = r0.properties
            java.lang.Long r5 = new java.lang.Long
            long r10 = r0.xPelsPerMeter
            r5.<init>(r10)
            java.lang.String r10 = "x_pixels_per_meter"
            r4.put(r10, r5)
            java.util.HashMap r4 = r0.properties
            java.lang.Long r5 = new java.lang.Long
            long r10 = r0.yPelsPerMeter
            r5.<init>(r10)
            java.lang.String r10 = "y_pixels_per_meter"
            r4.put(r10, r5)
            java.util.HashMap r4 = r0.properties
            java.lang.Long r5 = new java.lang.Long
            r5.<init>(r14)
            java.lang.String r10 = "colors_used"
            r4.put(r10, r5)
            java.util.HashMap r4 = r0.properties
            java.lang.Long r5 = new java.lang.Long
            r5.<init>(r8)
            java.lang.String r8 = "colors_important"
            r4.put(r8, r5)
            r4 = 40
            java.lang.String r8 = "blue_mask"
            java.lang.String r9 = "green_mask"
            java.lang.String r10 = "red_mask"
            int r11 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r11 != 0) goto L_0x02fc
            long r4 = r0.compression
            int r5 = (int) r4
            if (r5 == 0) goto L_0x021d
            if (r5 == r13) goto L_0x021d
            if (r5 == r12) goto L_0x021d
            if (r5 != r3) goto L_0x0215
            int r1 = r0.bitsPerPixel
            if (r1 != r6) goto L_0x01b8
            r2 = 8
            r0.imageType = r2
            goto L_0x01c0
        L_0x01b8:
            r2 = 32
            if (r1 != r2) goto L_0x01c0
            r1 = 9
            r0.imageType = r1
        L_0x01c0:
            java.io.InputStream r1 = r0.inputStream
            long r1 = r0.readDWord(r1)
            int r2 = (int) r1
            r0.redMask = r2
            java.io.InputStream r1 = r0.inputStream
            long r1 = r0.readDWord(r1)
            int r2 = (int) r1
            r0.greenMask = r2
            java.io.InputStream r1 = r0.inputStream
            long r1 = r0.readDWord(r1)
            int r2 = (int) r1
            r0.blueMask = r2
            java.util.HashMap r1 = r0.properties
            java.lang.Integer r2 = new java.lang.Integer
            int r4 = r0.redMask
            r2.<init>(r4)
            r1.put(r10, r2)
            java.util.HashMap r1 = r0.properties
            java.lang.Integer r2 = new java.lang.Integer
            int r4 = r0.greenMask
            r2.<init>(r4)
            r1.put(r9, r2)
            java.util.HashMap r1 = r0.properties
            java.lang.Integer r2 = new java.lang.Integer
            int r4 = r0.blueMask
            r2.<init>(r4)
            r1.put(r8, r2)
            r1 = 0
            int r4 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x020c
            int r1 = (int) r14
            r2 = 4
            int r1 = r1 * 4
            r0.readPalette(r1)
        L_0x020c:
            java.util.HashMap r1 = r0.properties
            java.lang.String r2 = "BMP v. 3.x NT"
            r1.put(r7, r2)
            goto L_0x0479
        L_0x0215:
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Invalid compression specified in BMP file."
            r1.<init>(r2)
            throw r1
        L_0x021d:
            int r4 = r0.bitsPerPixel
            if (r4 != r13) goto L_0x0226
            r5 = 4
            r0.imageType = r5
            goto L_0x02ad
        L_0x0226:
            r5 = 4
            if (r4 != r5) goto L_0x022e
            r4 = 5
            r0.imageType = r4
            goto L_0x02ad
        L_0x022e:
            r5 = 8
            if (r4 != r5) goto L_0x0237
            r4 = 6
            r0.imageType = r4
            goto L_0x02ad
        L_0x0237:
            r11 = 24
            if (r4 != r11) goto L_0x023f
            r4 = 7
            r0.imageType = r4
            goto L_0x02ad
        L_0x023f:
            if (r4 != r6) goto L_0x0274
            r0.imageType = r5
            r4 = 31744(0x7c00, float:4.4483E-41)
            r0.redMask = r4
            r4 = 992(0x3e0, float:1.39E-42)
            r0.greenMask = r4
            r4 = 31
            r0.blueMask = r4
            java.util.HashMap r4 = r0.properties
            java.lang.Integer r5 = new java.lang.Integer
            int r11 = r0.redMask
            r5.<init>(r11)
            r4.put(r10, r5)
            java.util.HashMap r4 = r0.properties
            java.lang.Integer r5 = new java.lang.Integer
            int r10 = r0.greenMask
            r5.<init>(r10)
            r4.put(r9, r5)
            java.util.HashMap r4 = r0.properties
            java.lang.Integer r5 = new java.lang.Integer
            int r9 = r0.blueMask
            r5.<init>(r9)
            r4.put(r8, r5)
            goto L_0x02ad
        L_0x0274:
            r5 = 32
            if (r4 != r5) goto L_0x02ad
            r4 = 9
            r0.imageType = r4
            r4 = 16711680(0xff0000, float:2.3418052E-38)
            r0.redMask = r4
            r4 = 65280(0xff00, float:9.1477E-41)
            r0.greenMask = r4
            r4 = 255(0xff, float:3.57E-43)
            r0.blueMask = r4
            java.util.HashMap r4 = r0.properties
            java.lang.Integer r5 = new java.lang.Integer
            int r11 = r0.redMask
            r5.<init>(r11)
            r4.put(r10, r5)
            java.util.HashMap r4 = r0.properties
            java.lang.Integer r5 = new java.lang.Integer
            int r10 = r0.greenMask
            r5.<init>(r10)
            r4.put(r9, r5)
            java.util.HashMap r4 = r0.properties
            java.lang.Integer r5 = new java.lang.Integer
            int r9 = r0.blueMask
            r5.<init>(r9)
            r4.put(r8, r5)
        L_0x02ad:
            long r4 = r0.bitmapOffset
            r8 = 14
            long r8 = r4 - r8
            long r8 = r8 - r1
            r10 = 4
            long r8 = r8 / r10
            int r9 = (int) r8
            r8 = 4
            int r9 = r9 * 4
            int r10 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r10 != 0) goto L_0x02f0
            int r4 = r0.imageType
            if (r4 == r8) goto L_0x02e0
            r5 = 5
            if (r4 == r5) goto L_0x02d6
            r5 = 6
            if (r4 == r5) goto L_0x02cb
            r9 = 0
            goto L_0x02ec
        L_0x02cb:
            r4 = 0
            int r8 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r8 != 0) goto L_0x02d3
            r14 = 256(0x100, double:1.265E-321)
        L_0x02d3:
            int r4 = (int) r14
            r8 = 4
            goto L_0x02e9
        L_0x02d6:
            r4 = 0
            r8 = 4
            int r9 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r9 != 0) goto L_0x02e8
            r14 = 16
            goto L_0x02e8
        L_0x02e0:
            r4 = 0
            int r9 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r9 != 0) goto L_0x02e8
            r14 = 2
        L_0x02e8:
            int r4 = (int) r14
        L_0x02e9:
            int r11 = r4 * 4
            r9 = r11
        L_0x02ec:
            long r4 = (long) r9
            long r1 = r1 + r4
            r0.bitmapOffset = r1
        L_0x02f0:
            r0.readPalette(r9)
            java.util.HashMap r1 = r0.properties
            java.lang.String r2 = "BMP v. 3.x"
            r1.put(r7, r2)
            goto L_0x0479
        L_0x02fc:
            r4 = 108(0x6c, double:5.34E-322)
            int r11 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r11 != 0) goto L_0x05c5
            java.util.HashMap r4 = r0.properties
            java.lang.String r5 = "BMP v. 4.x"
            r4.put(r7, r5)
            java.io.InputStream r4 = r0.inputStream
            long r4 = r0.readDWord(r4)
            int r5 = (int) r4
            r0.redMask = r5
            java.io.InputStream r4 = r0.inputStream
            long r4 = r0.readDWord(r4)
            int r5 = (int) r4
            r0.greenMask = r5
            java.io.InputStream r4 = r0.inputStream
            long r4 = r0.readDWord(r4)
            int r5 = (int) r4
            r0.blueMask = r5
            java.io.InputStream r4 = r0.inputStream
            long r4 = r0.readDWord(r4)
            int r5 = (int) r4
            r0.alphaMask = r5
            java.io.InputStream r4 = r0.inputStream
            long r4 = r0.readDWord(r4)
            java.io.InputStream r7 = r0.inputStream
            int r7 = r0.readLong(r7)
            java.io.InputStream r11 = r0.inputStream
            int r11 = r0.readLong(r11)
            java.io.InputStream r3 = r0.inputStream
            int r3 = r0.readLong(r3)
            java.io.InputStream r12 = r0.inputStream
            int r12 = r0.readLong(r12)
            java.io.InputStream r6 = r0.inputStream
            int r6 = r0.readLong(r6)
            java.io.InputStream r13 = r0.inputStream
            int r13 = r0.readLong(r13)
            r19 = r13
            java.io.InputStream r13 = r0.inputStream
            int r13 = r0.readLong(r13)
            r20 = r13
            java.io.InputStream r13 = r0.inputStream
            int r13 = r0.readLong(r13)
            r21 = r13
            java.io.InputStream r13 = r0.inputStream
            int r13 = r0.readLong(r13)
            r22 = r13
            java.io.InputStream r13 = r0.inputStream
            r23 = r12
            long r12 = r0.readDWord(r13)
            r24 = r12
            java.io.InputStream r12 = r0.inputStream
            long r12 = r0.readDWord(r12)
            r26 = r12
            java.io.InputStream r12 = r0.inputStream
            long r12 = r0.readDWord(r12)
            r28 = r12
            int r12 = r0.bitsPerPixel
            r13 = 1
            if (r12 != r13) goto L_0x0395
            r12 = 10
            r0.imageType = r12
            goto L_0x03e3
        L_0x0395:
            r13 = 4
            if (r12 != r13) goto L_0x039d
            r12 = 11
            r0.imageType = r12
            goto L_0x03e3
        L_0x039d:
            r13 = 8
            if (r12 != r13) goto L_0x03a6
            r12 = 12
            r0.imageType = r12
            goto L_0x03e3
        L_0x03a6:
            r13 = 16
            if (r12 != r13) goto L_0x03c0
            r12 = 13
            r0.imageType = r12
            long r12 = r0.compression
            int r13 = (int) r12
            if (r13 != 0) goto L_0x03e3
            r12 = 31744(0x7c00, float:4.4483E-41)
            r0.redMask = r12
            r12 = 992(0x3e0, float:1.39E-42)
            r0.greenMask = r12
            r12 = 31
            r0.blueMask = r12
            goto L_0x03e3
        L_0x03c0:
            r13 = 24
            if (r12 != r13) goto L_0x03c9
            r12 = 14
            r0.imageType = r12
            goto L_0x03e3
        L_0x03c9:
            r13 = 32
            if (r12 != r13) goto L_0x03e3
            r12 = 15
            r0.imageType = r12
            long r12 = r0.compression
            int r13 = (int) r12
            if (r13 != 0) goto L_0x03e3
            r12 = 16711680(0xff0000, float:2.3418052E-38)
            r0.redMask = r12
            r12 = 65280(0xff00, float:9.1477E-41)
            r0.greenMask = r12
            r12 = 255(0xff, float:3.57E-43)
            r0.blueMask = r12
        L_0x03e3:
            java.util.HashMap r12 = r0.properties
            java.lang.Integer r13 = new java.lang.Integer
            r30 = r6
            int r6 = r0.redMask
            r13.<init>(r6)
            r12.put(r10, r13)
            java.util.HashMap r6 = r0.properties
            java.lang.Integer r10 = new java.lang.Integer
            int r12 = r0.greenMask
            r10.<init>(r12)
            r6.put(r9, r10)
            java.util.HashMap r6 = r0.properties
            java.lang.Integer r9 = new java.lang.Integer
            int r10 = r0.blueMask
            r9.<init>(r10)
            r6.put(r8, r9)
            java.util.HashMap r6 = r0.properties
            java.lang.Integer r8 = new java.lang.Integer
            int r9 = r0.alphaMask
            r8.<init>(r9)
            java.lang.String r9 = "alpha_mask"
            r6.put(r9, r8)
            long r8 = r0.bitmapOffset
            r12 = 14
            long r12 = r8 - r12
            long r12 = r12 - r1
            r31 = 4
            long r12 = r12 / r31
            int r6 = (int) r12
            r10 = 4
            int r6 = r6 * 4
            int r12 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
            if (r12 != 0) goto L_0x0452
            int r6 = r0.imageType
            switch(r6) {
                case 10: goto L_0x0443;
                case 11: goto L_0x043a;
                case 12: goto L_0x0431;
                default: goto L_0x042f;
            }
        L_0x042f:
            r6 = 0
            goto L_0x044e
        L_0x0431:
            r8 = 0
            int r6 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r6 != 0) goto L_0x044b
            r14 = 256(0x100, double:1.265E-321)
            goto L_0x044b
        L_0x043a:
            r8 = 0
            int r6 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r6 != 0) goto L_0x044b
            r14 = 16
            goto L_0x044b
        L_0x0443:
            r8 = 0
            int r6 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r6 != 0) goto L_0x044b
            r14 = 2
        L_0x044b:
            int r6 = (int) r14
            int r6 = r6 * 4
        L_0x044e:
            long r8 = (long) r6
            long r1 = r1 + r8
            r0.bitmapOffset = r1
        L_0x0452:
            r0.readPalette(r6)
            int r1 = (int) r4
            if (r1 == 0) goto L_0x0512
            r2 = 1
            if (r1 == r2) goto L_0x0470
            r2 = 2
            if (r1 == r2) goto L_0x045f
            goto L_0x0479
        L_0x045f:
            java.util.HashMap r1 = r0.properties
            java.lang.String r2 = "color_space"
            java.lang.String r3 = "LCS_CMYK"
            r1.put(r2, r3)
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Not implemented yet."
            r1.<init>(r2)
            throw r1
        L_0x0470:
            java.util.HashMap r1 = r0.properties
            java.lang.String r2 = "color_space"
            java.lang.String r3 = "LCS_sRGB"
            r1.put(r2, r3)
        L_0x0479:
            int r1 = r0.height
            if (r1 <= 0) goto L_0x0482
            r2 = 1
            r0.isBottomUp = r2
            r3 = 0
            goto L_0x048c
        L_0x0482:
            r2 = 1
            r3 = 0
            r0.isBottomUp = r3
            int r1 = java.lang.Math.abs(r1)
            r0.height = r1
        L_0x048c:
            int r1 = r0.bitsPerPixel
            if (r1 == r2) goto L_0x04b1
            r2 = 4
            if (r1 == r2) goto L_0x04b1
            r2 = 8
            if (r1 != r2) goto L_0x0498
            goto L_0x04b1
        L_0x0498:
            r2 = 16
            if (r1 != r2) goto L_0x04a0
            r2 = 3
            r0.numBands = r2
            goto L_0x04fa
        L_0x04a0:
            r2 = 3
            r3 = 32
            if (r1 != r3) goto L_0x04ae
            int r1 = r0.alphaMask
            if (r1 != 0) goto L_0x04aa
            goto L_0x04ab
        L_0x04aa:
            r2 = 4
        L_0x04ab:
            r0.numBands = r2
            goto L_0x04fa
        L_0x04ae:
            r0.numBands = r2
            goto L_0x04fa
        L_0x04b1:
            r1 = 1
            r0.numBands = r1
            int r2 = r0.imageType
            r4 = 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x04e9
            if (r2 == r1) goto L_0x04e9
            r1 = 2
            if (r2 != r1) goto L_0x04c0
            goto L_0x04e9
        L_0x04c0:
            byte[] r1 = r0.palette
            int r1 = r1.length
            r2 = 4
            int r1 = r1 / r2
            if (r1 <= r4) goto L_0x04c9
            r1 = 256(0x100, float:3.59E-43)
        L_0x04c9:
            byte[] r2 = new byte[r1]
            byte[] r5 = new byte[r1]
            byte[] r6 = new byte[r1]
        L_0x04cf:
            if (r3 < r1) goto L_0x04d2
            goto L_0x04fa
        L_0x04d2:
            int r4 = r3 * 4
            byte[] r7 = r0.palette
            byte r8 = r7[r4]
            r6[r3] = r8
            int r8 = r4 + 1
            byte r8 = r7[r8]
            r5[r3] = r8
            r8 = 2
            int r4 = r4 + r8
            byte r4 = r7[r4]
            r2[r3] = r4
            int r3 = r3 + 1
            goto L_0x04cf
        L_0x04e9:
            byte[] r1 = r0.palette
            int r1 = r1.length
            r2 = 3
            int r1 = r1 / r2
            if (r1 <= r4) goto L_0x04f2
            r1 = 256(0x100, float:3.59E-43)
        L_0x04f2:
            byte[] r2 = new byte[r1]
            byte[] r4 = new byte[r1]
            byte[] r5 = new byte[r1]
        L_0x04f8:
            if (r3 < r1) goto L_0x04fb
        L_0x04fa:
            return
        L_0x04fb:
            int r6 = r3 * 3
            byte[] r7 = r0.palette
            byte r8 = r7[r6]
            r5[r3] = r8
            int r8 = r6 + 1
            byte r8 = r7[r8]
            r4[r3] = r8
            r8 = 2
            int r6 = r6 + r8
            byte r6 = r7[r6]
            r2[r3] = r6
            int r3 = r3 + 1
            goto L_0x04f8
        L_0x0512:
            java.util.HashMap r1 = r0.properties
            java.lang.String r2 = "color_space"
            java.lang.String r4 = "LCS_CALIBRATED_RGB"
            r1.put(r2, r4)
            java.util.HashMap r1 = r0.properties
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r7)
            java.lang.String r4 = "redX"
            r1.put(r4, r2)
            java.util.HashMap r1 = r0.properties
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r11)
            java.lang.String r4 = "redY"
            r1.put(r4, r2)
            java.util.HashMap r1 = r0.properties
            java.lang.Integer r2 = new java.lang.Integer
            r2.<init>(r3)
            java.lang.String r3 = "redZ"
            r1.put(r3, r2)
            java.util.HashMap r1 = r0.properties
            java.lang.Integer r2 = new java.lang.Integer
            r3 = r23
            r2.<init>(r3)
            java.lang.String r3 = "greenX"
            r1.put(r3, r2)
            java.util.HashMap r1 = r0.properties
            java.lang.Integer r2 = new java.lang.Integer
            r3 = r30
            r2.<init>(r3)
            java.lang.String r3 = "greenY"
            r1.put(r3, r2)
            java.util.HashMap r1 = r0.properties
            java.lang.Integer r2 = new java.lang.Integer
            r3 = r19
            r2.<init>(r3)
            java.lang.String r3 = "greenZ"
            r1.put(r3, r2)
            java.util.HashMap r1 = r0.properties
            java.lang.Integer r2 = new java.lang.Integer
            r3 = r20
            r2.<init>(r3)
            java.lang.String r3 = "blueX"
            r1.put(r3, r2)
            java.util.HashMap r1 = r0.properties
            java.lang.Integer r2 = new java.lang.Integer
            r3 = r21
            r2.<init>(r3)
            java.lang.String r3 = "blueY"
            r1.put(r3, r2)
            java.util.HashMap r1 = r0.properties
            java.lang.Integer r2 = new java.lang.Integer
            r3 = r22
            r2.<init>(r3)
            java.lang.String r3 = "blueZ"
            r1.put(r3, r2)
            java.util.HashMap r1 = r0.properties
            java.lang.Long r2 = new java.lang.Long
            r3 = r24
            r2.<init>(r3)
            java.lang.String r3 = "gamma_red"
            r1.put(r3, r2)
            java.util.HashMap r1 = r0.properties
            java.lang.Long r2 = new java.lang.Long
            r3 = r26
            r2.<init>(r3)
            java.lang.String r3 = "gamma_green"
            r1.put(r3, r2)
            java.util.HashMap r1 = r0.properties
            java.lang.Long r2 = new java.lang.Long
            r3 = r28
            r2.<init>(r3)
            java.lang.String r3 = "gamma_blue"
            r1.put(r3, r2)
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "Not implemented yet."
            r1.<init>(r2)
            throw r1
        L_0x05c5:
            java.util.HashMap r1 = r0.properties
            java.lang.String r2 = "BMP v. 5.x"
            r1.put(r7, r2)
            java.lang.RuntimeException r1 = new java.lang.RuntimeException
            java.lang.String r2 = "BMP version 5 not implemented yet."
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.codec.BmpImage.process(java.io.InputStream, boolean):void");
    }

    private byte[] getPalette(int i) {
        byte[] bArr = this.palette;
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[((bArr.length / i) * 3)];
        int length = bArr.length / i;
        for (int i2 = 0; i2 < length; i2++) {
            int i3 = i2 * i;
            int i4 = i2 * 3;
            byte[] bArr3 = this.palette;
            int i5 = i3 + 1;
            bArr2[i4 + 2] = bArr3[i3];
            bArr2[i4 + 1] = bArr3[i5];
            bArr2[i4] = bArr3[i5 + 1];
        }
        return bArr2;
    }

    private Image getImage() throws IOException, BadElementException {
        switch (this.imageType) {
            case 0:
                return read1Bit(3);
            case 1:
                return read4Bit(3);
            case 2:
                return read8Bit(3);
            case 3:
                byte[] bArr = new byte[(this.width * this.height * 3)];
                read24Bit(bArr);
                return new ImgRaw(this.width, this.height, 3, 8, bArr);
            case 4:
                return read1Bit(4);
            case 5:
                int i = (int) this.compression;
                if (i == 0) {
                    return read4Bit(4);
                }
                if (i == 2) {
                    return readRLE4();
                }
                throw new RuntimeException("Invalid compression specified for BMP file.");
            case 6:
                int i2 = (int) this.compression;
                if (i2 == 0) {
                    return read8Bit(4);
                }
                if (i2 == 1) {
                    return readRLE8();
                }
                throw new RuntimeException("Invalid compression specified for BMP file.");
            case 7:
                byte[] bArr2 = new byte[(this.width * this.height * 3)];
                read24Bit(bArr2);
                return new ImgRaw(this.width, this.height, 3, 8, bArr2);
            case 8:
                return read1632Bit(false);
            case 9:
                return read1632Bit(true);
            case 10:
                return read1Bit(4);
            case 11:
                int i3 = (int) this.compression;
                if (i3 == 0) {
                    return read4Bit(4);
                }
                if (i3 == 2) {
                    return readRLE4();
                }
                throw new RuntimeException("Invalid compression specified for BMP file.");
            case 12:
                int i4 = (int) this.compression;
                if (i4 == 0) {
                    return read8Bit(4);
                }
                if (i4 == 1) {
                    return readRLE8();
                }
                throw new RuntimeException("Invalid compression specified for BMP file.");
            case 13:
                return read1632Bit(false);
            case 14:
                byte[] bArr3 = new byte[(this.width * this.height * 3)];
                read24Bit(bArr3);
                return new ImgRaw(this.width, this.height, 3, 8, bArr3);
            case 15:
                return read1632Bit(true);
            default:
                return null;
        }
    }

    private Image indexedModel(byte[] bArr, int i, int i2) throws BadElementException {
        ImgRaw imgRaw = new ImgRaw(this.width, this.height, 1, i, bArr);
        PdfArray pdfArray = new PdfArray();
        pdfArray.add((PdfObject) PdfName.INDEXED);
        pdfArray.add((PdfObject) PdfName.DEVICERGB);
        byte[] palette2 = getPalette(i2);
        pdfArray.add((PdfObject) new PdfNumber((palette2.length / 3) - 1));
        pdfArray.add((PdfObject) new PdfString(palette2));
        PdfDictionary pdfDictionary = new PdfDictionary();
        pdfDictionary.put(PdfName.COLORSPACE, pdfArray);
        imgRaw.setAdditional(pdfDictionary);
        return imgRaw;
    }

    private void readPalette(int i) throws IOException {
        if (i != 0) {
            this.palette = new byte[i];
            int i2 = 0;
            while (i2 < i) {
                int read = this.inputStream.read(this.palette, i2, i - i2);
                if (read >= 0) {
                    i2 += read;
                } else {
                    throw new RuntimeException("incomplete palette");
                }
            }
            this.properties.put("palette", this.palette);
        }
    }

    private Image read1Bit(int i) throws IOException, BadElementException {
        int i2 = this.width;
        byte[] bArr = new byte[(((i2 + 7) / 8) * this.height)];
        int ceil = (int) Math.ceil(((double) i2) / 8.0d);
        int i3 = ceil % 4;
        int i4 = 0;
        int i5 = (i3 != 0 ? 4 - i3 : 0) + ceil;
        int i6 = this.height * i5;
        byte[] bArr2 = new byte[i6];
        int i7 = 0;
        while (i7 < i6) {
            i7 += this.inputStream.read(bArr2, i7, i6 - i7);
        }
        if (this.isBottomUp) {
            while (i4 < this.height) {
                int i8 = i4 + 1;
                System.arraycopy(bArr2, i6 - (i8 * i5), bArr, i4 * ceil, ceil);
                i4 = i8;
            }
        } else {
            while (i4 < this.height) {
                System.arraycopy(bArr2, i4 * i5, bArr, i4 * ceil, ceil);
                i4++;
            }
        }
        return indexedModel(bArr, 1, i);
    }

    private Image read4Bit(int i) throws IOException, BadElementException {
        int i2 = this.width;
        byte[] bArr = new byte[(((i2 + 1) / 2) * this.height)];
        int ceil = (int) Math.ceil(((double) i2) / 2.0d);
        int i3 = ceil % 4;
        int i4 = 0;
        int i5 = (i3 != 0 ? 4 - i3 : 0) + ceil;
        int i6 = this.height * i5;
        byte[] bArr2 = new byte[i6];
        int i7 = 0;
        while (i7 < i6) {
            i7 += this.inputStream.read(bArr2, i7, i6 - i7);
        }
        if (this.isBottomUp) {
            while (i4 < this.height) {
                int i8 = i4 + 1;
                System.arraycopy(bArr2, i6 - (i8 * i5), bArr, i4 * ceil, ceil);
                i4 = i8;
            }
        } else {
            while (i4 < this.height) {
                System.arraycopy(bArr2, i4 * i5, bArr, i4 * ceil, ceil);
                i4++;
            }
        }
        return indexedModel(bArr, 4, i);
    }

    private Image read8Bit(int i) throws IOException, BadElementException {
        int i2 = this.width;
        byte[] bArr = new byte[(this.height * i2)];
        int i3 = i2 * 8;
        int i4 = 0;
        int ceil = i3 % 32 != 0 ? (int) Math.ceil(((double) ((((i3 / 32) + 1) * 32) - i3)) / 8.0d) : 0;
        int i5 = (this.width + ceil) * this.height;
        byte[] bArr2 = new byte[i5];
        int i6 = 0;
        while (i6 < i5) {
            i6 += this.inputStream.read(bArr2, i6, i5 - i6);
        }
        if (this.isBottomUp) {
            while (i4 < this.height) {
                int i7 = i4 + 1;
                int i8 = this.width;
                System.arraycopy(bArr2, i5 - ((i8 + ceil) * i7), bArr, i4 * i8, i8);
                i4 = i7;
            }
        } else {
            while (i4 < this.height) {
                int i9 = this.width;
                System.arraycopy(bArr2, (i9 + ceil) * i4, bArr, i4 * i9, i9);
                i4++;
            }
        }
        return indexedModel(bArr, 8, i);
    }

    private void read24Bit(byte[] bArr) {
        int i = this.width * 24;
        int ceil = i % 32 != 0 ? (int) Math.ceil(((double) ((((i / 32) + 1) * 32) - i)) / 8.0d) : 0;
        int i2 = (((this.width * 3) + 3) / 4) * 4 * this.height;
        byte[] bArr2 = new byte[i2];
        int i3 = 0;
        while (i3 < i2) {
            try {
                int read = this.inputStream.read(bArr2, i3, i2 - i3);
                if (read < 0) {
                    break;
                }
                i3 += read;
            } catch (IOException e) {
                throw new ExceptionConverter(e);
            }
        }
        if (this.isBottomUp) {
            int i4 = ((this.width * this.height) * 3) - 1;
            int i5 = -ceil;
            int i6 = 0;
            while (i6 < this.height) {
                i6++;
                int i7 = (i4 - ((this.width * i6) * 3)) + 1;
                int i8 = i5 + ceil;
                for (int i9 = 0; i9 < this.width; i9++) {
                    int i10 = i8 + 1;
                    bArr[i7 + 2] = bArr2[i8];
                    int i11 = i10 + 1;
                    bArr[i7 + 1] = bArr2[i10];
                    i8 = i11 + 1;
                    bArr[i7] = bArr2[i11];
                    i7 += 3;
                }
                i5 = i8;
            }
            return;
        }
        int i12 = -ceil;
        int i13 = 0;
        int i14 = 0;
        while (i14 < this.height) {
            int i15 = i12 + ceil;
            for (int i16 = 0; i16 < this.width; i16++) {
                int i17 = i15 + 1;
                bArr[i13 + 2] = bArr2[i15];
                int i18 = i17 + 1;
                bArr[i13 + 1] = bArr2[i17];
                i15 = i18 + 1;
                bArr[i13] = bArr2[i18];
                i13 += 3;
            }
            i14++;
            i12 = i15;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00bd  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0055  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.lowagie.text.Image read1632Bit(boolean r21) throws java.io.IOException, com.lowagie.text.BadElementException {
        /*
            r20 = this;
            r0 = r20
            int r1 = r0.redMask
            int r1 = r0.findMask(r1)
            int r2 = r0.redMask
            int r2 = r0.findShift(r2)
            int r3 = r1 + 1
            int r4 = r0.greenMask
            int r4 = r0.findMask(r4)
            int r5 = r0.greenMask
            int r5 = r0.findShift(r5)
            int r6 = r4 + 1
            int r7 = r0.blueMask
            int r7 = r0.findMask(r7)
            int r8 = r0.blueMask
            int r8 = r0.findShift(r8)
            int r9 = r7 + 1
            int r10 = r0.width
            int r11 = r0.height
            int r11 = r11 * r10
            int r11 = r11 * 3
            byte[] r11 = new byte[r11]
            if (r21 != 0) goto L_0x004f
            int r10 = r10 * 16
            int r13 = r10 % 32
            if (r13 == 0) goto L_0x004f
            int r13 = r10 / 32
            int r13 = r13 + 1
            int r13 = r13 * 32
            int r13 = r13 - r10
            double r13 = (double) r13
            r15 = 4620693217682128896(0x4020000000000000, double:8.0)
            double r13 = r13 / r15
            double r13 = java.lang.Math.ceil(r13)
            int r10 = (int) r13
            goto L_0x0050
        L_0x004f:
            r10 = 0
        L_0x0050:
            long r13 = r0.imageSize
            int r14 = (int) r13
            if (r14 != 0) goto L_0x0059
            long r13 = r0.bitmapFileSize
            long r13 = r0.bitmapOffset
        L_0x0059:
            boolean r13 = r0.isBottomUp
            if (r13 == 0) goto L_0x00bd
            int r13 = r0.height
            int r13 = r13 + -1
        L_0x0061:
            if (r13 >= 0) goto L_0x0064
            goto L_0x00c5
        L_0x0064:
            int r14 = r0.width
            int r14 = r14 * 3
            int r14 = r14 * r13
            r15 = r14
            r14 = 0
        L_0x006c:
            int r12 = r0.width
            if (r14 < r12) goto L_0x007e
            r12 = 0
        L_0x0071:
            if (r12 < r10) goto L_0x0076
            int r13 = r13 + -1
            goto L_0x0061
        L_0x0076:
            java.io.InputStream r14 = r0.inputStream
            r14.read()
            int r12 = r12 + 1
            goto L_0x0071
        L_0x007e:
            if (r21 == 0) goto L_0x008a
            java.io.InputStream r12 = r0.inputStream
            r17 = r13
            long r12 = r0.readDWord(r12)
            int r13 = (int) r12
            goto L_0x0092
        L_0x008a:
            r17 = r13
            java.io.InputStream r12 = r0.inputStream
            int r13 = r0.readWord(r12)
        L_0x0092:
            int r12 = r15 + 1
            int r18 = r13 >>> r2
            r19 = r2
            r2 = r18 & r1
            int r2 = r2 * 256
            int r2 = r2 / r3
            byte r2 = (byte) r2
            r11[r15] = r2
            int r2 = r12 + 1
            int r15 = r13 >>> r5
            r15 = r15 & r4
            int r15 = r15 * 256
            int r15 = r15 / r6
            byte r15 = (byte) r15
            r11[r12] = r15
            int r15 = r2 + 1
            int r12 = r13 >>> r8
            r12 = r12 & r7
            int r12 = r12 * 256
            int r12 = r12 / r9
            byte r12 = (byte) r12
            r11[r2] = r12
            int r14 = r14 + 1
            r13 = r17
            r2 = r19
            goto L_0x006c
        L_0x00bd:
            r19 = r2
            r2 = 0
            r12 = 0
        L_0x00c1:
            int r13 = r0.height
            if (r2 < r13) goto L_0x00d5
        L_0x00c5:
            com.lowagie.text.ImgRaw r1 = new com.lowagie.text.ImgRaw
            int r13 = r0.width
            int r14 = r0.height
            r15 = 3
            r16 = 8
            r12 = r1
            r17 = r11
            r12.<init>(r13, r14, r15, r16, r17)
            return r1
        L_0x00d5:
            r13 = r12
            r12 = 0
        L_0x00d7:
            int r14 = r0.width
            if (r12 < r14) goto L_0x00ea
            r12 = 0
        L_0x00dc:
            if (r12 < r10) goto L_0x00e2
            int r2 = r2 + 1
            r12 = r13
            goto L_0x00c1
        L_0x00e2:
            java.io.InputStream r14 = r0.inputStream
            r14.read()
            int r12 = r12 + 1
            goto L_0x00dc
        L_0x00ea:
            if (r21 == 0) goto L_0x00f4
            java.io.InputStream r14 = r0.inputStream
            long r14 = r0.readDWord(r14)
            int r15 = (int) r14
            goto L_0x00fa
        L_0x00f4:
            java.io.InputStream r14 = r0.inputStream
            int r15 = r0.readWord(r14)
        L_0x00fa:
            int r14 = r13 + 1
            int r17 = r15 >>> r19
            r0 = r17 & r1
            int r0 = r0 * 256
            int r0 = r0 / r3
            byte r0 = (byte) r0
            r11[r13] = r0
            int r0 = r14 + 1
            int r13 = r15 >>> r5
            r13 = r13 & r4
            int r13 = r13 * 256
            int r13 = r13 / r6
            byte r13 = (byte) r13
            r11[r14] = r13
            int r13 = r0 + 1
            int r14 = r15 >>> r8
            r14 = r14 & r7
            int r14 = r14 * 256
            int r14 = r14 / r9
            byte r14 = (byte) r14
            r11[r0] = r14
            int r12 = r12 + 1
            r0 = r20
            goto L_0x00d7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.codec.BmpImage.read1632Bit(boolean):com.lowagie.text.Image");
    }

    private Image readRLE8() throws IOException, BadElementException {
        int i = (int) this.imageSize;
        if (i == 0) {
            i = (int) (this.bitmapFileSize - this.bitmapOffset);
        }
        byte[] bArr = new byte[i];
        int i2 = 0;
        int i3 = 0;
        while (i3 < i) {
            i3 += this.inputStream.read(bArr, i3, i - i3);
        }
        byte[] decodeRLE = decodeRLE(true, bArr);
        int i4 = this.width;
        int i5 = this.height * i4;
        if (this.isBottomUp) {
            byte[] bArr2 = new byte[decodeRLE.length];
            while (i2 < this.height) {
                int i6 = i2 + 1;
                System.arraycopy(decodeRLE, i5 - (i6 * i4), bArr2, i2 * i4, i4);
                i2 = i6;
            }
            decodeRLE = bArr2;
        }
        return indexedModel(decodeRLE, 8, 4);
    }

    private Image readRLE4() throws IOException, BadElementException {
        byte[] bArr;
        int i = (int) this.imageSize;
        if (i == 0) {
            i = (int) (this.bitmapFileSize - this.bitmapOffset);
        }
        byte[] bArr2 = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            i2 += this.inputStream.read(bArr2, i2, i - i2);
        }
        byte[] decodeRLE = decodeRLE(false, bArr2);
        if (this.isBottomUp) {
            int i3 = this.width;
            int i4 = this.height;
            byte[] bArr3 = new byte[(i3 * i4)];
            int i5 = 0;
            for (int i6 = i4 - 1; i6 >= 0; i6--) {
                int i7 = this.width;
                int i8 = i6 * i7;
                int i9 = i7 + i5;
                while (i5 != i9) {
                    bArr3[i5] = decodeRLE[i8];
                    i5++;
                    i8++;
                }
            }
            bArr = bArr3;
        } else {
            bArr = decodeRLE;
        }
        int i10 = (this.width + 1) / 2;
        byte[] bArr4 = new byte[(this.height * i10)];
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i12 < this.height) {
            int i14 = i11;
            for (int i15 = 0; i15 < this.width; i15++) {
                if ((i15 & 1) == 0) {
                    bArr4[(i15 / 2) + i13] = (byte) (bArr[i14] << 4);
                    i14++;
                } else {
                    int i16 = (i15 / 2) + i13;
                    bArr4[i16] = (byte) (((byte) (bArr[i14] & 15)) | bArr4[i16]);
                    i14++;
                }
            }
            i13 += i10;
            i12++;
            i11 = i14;
        }
        return indexedModel(bArr4, 4, 4);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v0, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: byte} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] decodeRLE(boolean r17, byte[] r18) {
        /*
            r16 = this;
            r0 = r16
            r1 = r18
            int r2 = r0.width
            int r3 = r0.height
            int r2 = r2 * r3
            byte[] r2 = new byte[r2]
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x0011:
            int r8 = r0.height     // Catch:{ RuntimeException -> 0x00d4 }
            if (r4 >= r8) goto L_0x00d4
            int r8 = r1.length     // Catch:{ RuntimeException -> 0x00d4 }
            if (r5 < r8) goto L_0x001a
            goto L_0x00d4
        L_0x001a:
            int r8 = r5 + 1
            byte r5 = r1[r5]     // Catch:{ RuntimeException -> 0x00d4 }
            r5 = r5 & 255(0xff, float:3.57E-43)
            r9 = 1
            if (r5 == 0) goto L_0x0056
            int r10 = r8 + 1
            byte r8 = r1[r8]     // Catch:{ RuntimeException -> 0x00d4 }
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r17 == 0) goto L_0x003a
            r9 = r7
            r7 = r5
        L_0x002d:
            if (r7 != 0) goto L_0x0031
            r7 = r9
            goto L_0x003f
        L_0x0031:
            int r11 = r9 + 1
            byte r12 = (byte) r8     // Catch:{ RuntimeException -> 0x00d4 }
            r2[r9] = r12     // Catch:{ RuntimeException -> 0x00d4 }
            int r7 = r7 + -1
            r9 = r11
            goto L_0x002d
        L_0x003a:
            r11 = r7
            r7 = 0
        L_0x003c:
            if (r7 < r5) goto L_0x0042
            r7 = r11
        L_0x003f:
            int r6 = r6 + r5
            r5 = r10
            goto L_0x0011
        L_0x0042:
            int r12 = r11 + 1
            r13 = r7 & 1
            if (r13 != r9) goto L_0x004b
            r13 = r8 & 15
            goto L_0x004f
        L_0x004b:
            int r13 = r8 >>> 4
            r13 = r13 & 15
        L_0x004f:
            byte r13 = (byte) r13     // Catch:{ RuntimeException -> 0x00d4 }
            r2[r11] = r13     // Catch:{ RuntimeException -> 0x00d4 }
            int r7 = r7 + 1
            r11 = r12
            goto L_0x003c
        L_0x0056:
            int r5 = r8 + 1
            byte r8 = r1[r8]     // Catch:{ RuntimeException -> 0x00d4 }
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r8 != r9) goto L_0x0060
            goto L_0x00d4
        L_0x0060:
            if (r8 == 0) goto L_0x00cb
            r10 = 2
            if (r8 == r10) goto L_0x00b6
            if (r17 == 0) goto L_0x007d
            r11 = r5
            r5 = r8
        L_0x0069:
            if (r5 != 0) goto L_0x006d
            r5 = r11
            goto L_0x0085
        L_0x006d:
            int r12 = r7 + 1
            int r13 = r11 + 1
            byte r11 = r1[r11]     // Catch:{ RuntimeException -> 0x00d4 }
            r11 = r11 & 255(0xff, float:3.57E-43)
            byte r11 = (byte) r11     // Catch:{ RuntimeException -> 0x00d4 }
            r2[r7] = r11     // Catch:{ RuntimeException -> 0x00d4 }
            int r5 = r5 + -1
            r7 = r12
            r11 = r13
            goto L_0x0069
        L_0x007d:
            r11 = r7
            r12 = 0
            r7 = r5
            r5 = 0
        L_0x0081:
            if (r5 < r8) goto L_0x0097
            r5 = r7
            r7 = r11
        L_0x0085:
            int r6 = r6 + r8
            if (r17 == 0) goto L_0x008d
            r8 = r8 & 1
            if (r8 != r9) goto L_0x0011
            goto L_0x0093
        L_0x008d:
            r8 = r8 & 3
            if (r8 == r9) goto L_0x0093
            if (r8 != r10) goto L_0x0011
        L_0x0093:
            int r5 = r5 + 1
            goto L_0x0011
        L_0x0097:
            r13 = r5 & 1
            if (r13 != 0) goto L_0x00a4
            int r12 = r7 + 1
            byte r7 = r1[r7]     // Catch:{ RuntimeException -> 0x00d4 }
            r7 = r7 & 255(0xff, float:3.57E-43)
            r15 = r12
            r12 = r7
            r7 = r15
        L_0x00a4:
            int r14 = r11 + 1
            if (r13 != r9) goto L_0x00ab
            r13 = r12 & 15
            goto L_0x00af
        L_0x00ab:
            int r13 = r12 >>> 4
            r13 = r13 & 15
        L_0x00af:
            byte r13 = (byte) r13     // Catch:{ RuntimeException -> 0x00d4 }
            r2[r11] = r13     // Catch:{ RuntimeException -> 0x00d4 }
            int r5 = r5 + 1
            r11 = r14
            goto L_0x0081
        L_0x00b6:
            int r7 = r5 + 1
            byte r5 = r1[r5]     // Catch:{ RuntimeException -> 0x00d4 }
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r6 = r6 + r5
            int r5 = r7 + 1
            byte r7 = r1[r7]     // Catch:{ RuntimeException -> 0x00d4 }
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r4 = r4 + r7
            int r7 = r0.width     // Catch:{ RuntimeException -> 0x00d4 }
            int r7 = r7 * r4
            int r7 = r7 + r6
            goto L_0x0011
        L_0x00cb:
            int r4 = r4 + 1
            int r6 = r0.width     // Catch:{ RuntimeException -> 0x00d4 }
            int r7 = r4 * r6
            r6 = 0
            goto L_0x0011
        L_0x00d4:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.codec.BmpImage.decodeRLE(boolean, byte[]):byte[]");
    }

    private int readUnsignedByte(InputStream inputStream2) throws IOException {
        return inputStream2.read() & 255;
    }

    private int readUnsignedShort(InputStream inputStream2) throws IOException {
        return ((readUnsignedByte(inputStream2) << 8) | readUnsignedByte(inputStream2)) & 65535;
    }

    private int readShort(InputStream inputStream2) throws IOException {
        return (readUnsignedByte(inputStream2) << 8) | readUnsignedByte(inputStream2);
    }

    private int readWord(InputStream inputStream2) throws IOException {
        return readUnsignedShort(inputStream2);
    }

    private long readUnsignedInt(InputStream inputStream2) throws IOException {
        int readUnsignedByte = readUnsignedByte(inputStream2);
        int readUnsignedByte2 = readUnsignedByte(inputStream2);
        return ((long) ((readUnsignedByte(inputStream2) << 24) | (readUnsignedByte(inputStream2) << 16) | (readUnsignedByte2 << 8) | readUnsignedByte)) & -1;
    }

    private int readInt(InputStream inputStream2) throws IOException {
        int readUnsignedByte = readUnsignedByte(inputStream2);
        int readUnsignedByte2 = readUnsignedByte(inputStream2);
        return (readUnsignedByte(inputStream2) << 24) | (readUnsignedByte(inputStream2) << 16) | (readUnsignedByte2 << 8) | readUnsignedByte;
    }

    private long readDWord(InputStream inputStream2) throws IOException {
        return readUnsignedInt(inputStream2);
    }

    private int readLong(InputStream inputStream2) throws IOException {
        return readInt(inputStream2);
    }
}
