package com.lowagie.text;

import com.google.android.exoplayer2.extractor.p008ts.PsExtractor;
import com.wowza.gocoder.sdk.support.wse.jni.wmstransport.WMSTransport;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import p052cz.msebera.android.httpclient.HttpStatus;

public class Jpeg extends Image {
    public static final byte[] JFIF_ID;
    public static final int M_APP0 = 224;
    public static final int M_APP2 = 226;
    public static final int M_APPE = 238;
    public static final int NOPARAM_MARKER = 2;
    public static final int[] NOPARAM_MARKERS = {208, 209, WMSTransport.SESSIONSTATE_CONNECT_REDIRECT, 211, 212, 213, 214, 215, 216, 1};
    public static final int NOT_A_MARKER = -1;
    public static final int UNSUPPORTED_MARKER = 1;
    public static final int[] UNSUPPORTED_MARKERS = {195, 197, 198, 199, 200, 201, 202, 203, HttpStatus.SC_RESET_CONTENT, HttpStatus.SC_PARTIAL_CONTENT, HttpStatus.SC_MULTI_STATUS};
    public static final int VALID_MARKER = 0;
    public static final int[] VALID_MARKERS = {PsExtractor.AUDIO_STREAM, 193, 194};
    private byte[][] icc;

    static {
        byte[] bArr = new byte[5];
        bArr[0] = 74;
        bArr[1] = 70;
        bArr[2] = 73;
        bArr[3] = 70;
        JFIF_ID = bArr;
    }

    Jpeg(Image image) {
        super(image);
    }

    public Jpeg(URL url) throws BadElementException, IOException {
        super(url);
        processParameters();
    }

    public Jpeg(byte[] bArr) throws BadElementException, IOException {
        super((URL) null);
        this.rawData = bArr;
        this.originalData = bArr;
        processParameters();
    }

    public Jpeg(byte[] bArr, float f, float f2) throws BadElementException, IOException {
        this(bArr);
        this.scaledWidth = f;
        this.scaledHeight = f2;
    }

    private static final int getShort(InputStream inputStream) throws IOException {
        return (inputStream.read() << 8) + inputStream.read();
    }

    private static final int marker(int i) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr = VALID_MARKERS;
            if (i3 >= iArr.length) {
                int i4 = 0;
                while (true) {
                    int[] iArr2 = NOPARAM_MARKERS;
                    if (i4 >= iArr2.length) {
                        while (true) {
                            int[] iArr3 = UNSUPPORTED_MARKERS;
                            if (i2 >= iArr3.length) {
                                return -1;
                            }
                            if (i == iArr3[i2]) {
                                return 1;
                            }
                            i2++;
                        }
                    } else if (i == iArr2[i4]) {
                        return 2;
                    } else {
                        i4++;
                    }
                }
            } else if (i == iArr[i3]) {
                return 0;
            } else {
                i3++;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:125:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0130, code lost:
        com.lowagie.text.Utilities.skip(r2, 2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0139, code lost:
        if (r2.read() != 8) goto L_0x01a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:71:0x013b, code lost:
        r13.scaledHeight = (float) getShort(r2);
        setTop(r13.scaledHeight);
        r13.scaledWidth = (float) getShort(r2);
        setRight(r13.scaledWidth);
        r13.colorspace = r2.read();
        r13.bpc = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x015b, code lost:
        if (r2 == null) goto L_0x0160;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x015d, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0160, code lost:
        r13.plainWidth = getWidth();
        r13.plainHeight = getHeight();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:75:0x016e, code lost:
        if (r13.icc == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0170, code lost:
        r0 = 0;
        r2 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0172, code lost:
        r3 = r13.icc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0175, code lost:
        if (r0 < r3.length) goto L_0x0195;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0177, code lost:
        r5 = new byte[r2];
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x017a, code lost:
        r2 = r13.icc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x017d, code lost:
        if (r4 < r2.length) goto L_0x0182;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x017f, code lost:
        r13.icc = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0182, code lost:
        java.lang.System.arraycopy(r2[r4], 14, r5, r0, r2[r4].length - 14);
        r0 = r0 + (r13.icc[r4].length - 14);
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0197, code lost:
        if (r3[r0] != null) goto L_0x019c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0199, code lost:
        r13.icc = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x019b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x019c, code lost:
        r2 = r2 + (r3[r0].length - 14);
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x01bc, code lost:
        throw new com.lowagie.text.BadElementException(java.lang.String.valueOf(r3) + " must have 8 bits per component.");
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x020a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void processParameters() throws com.lowagie.text.BadElementException, java.io.IOException {
        /*
            r13 = this;
            r0 = 32
            r13.type = r0
            r0 = 1
            r13.originalType = r0
            r1 = 0
            byte[] r2 = r13.rawData     // Catch:{ all -> 0x0206 }
            if (r2 != 0) goto L_0x001c
            java.net.URL r2 = r13.url     // Catch:{ all -> 0x0206 }
            java.io.InputStream r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.openStream(r2)     // Catch:{ all -> 0x0206 }
            java.net.URL r3 = r13.url     // Catch:{ all -> 0x0019 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0019 }
            goto L_0x0025
        L_0x0019:
            r0 = move-exception
            goto L_0x0208
        L_0x001c:
            java.io.ByteArrayInputStream r2 = new java.io.ByteArrayInputStream     // Catch:{ all -> 0x0206 }
            byte[] r3 = r13.rawData     // Catch:{ all -> 0x0206 }
            r2.<init>(r3)     // Catch:{ all -> 0x0206 }
            java.lang.String r3 = "Byte array"
        L_0x0025:
            int r4 = r2.read()     // Catch:{ all -> 0x0019 }
            r5 = 255(0xff, float:3.57E-43)
            if (r4 != r5) goto L_0x01ee
            int r4 = r2.read()     // Catch:{ all -> 0x0019 }
            r6 = 216(0xd8, float:3.03E-43)
            if (r4 != r6) goto L_0x01ee
            r4 = 0
            r6 = 1
        L_0x0037:
            int r7 = r2.read()     // Catch:{ all -> 0x0019 }
            if (r7 < 0) goto L_0x01e6
            if (r7 != r5) goto L_0x0037
            int r7 = r2.read()     // Catch:{ all -> 0x0019 }
            r8 = 2
            if (r6 == 0) goto L_0x00ce
            r9 = 224(0xe0, float:3.14E-43)
            if (r7 != r9) goto L_0x00ce
            int r6 = getShort(r2)     // Catch:{ all -> 0x0019 }
            r7 = 16
            if (r6 >= r7) goto L_0x0058
            int r6 = r6 + -2
            com.lowagie.text.Utilities.skip(r2, r6)     // Catch:{ all -> 0x0019 }
            goto L_0x00b1
        L_0x0058:
            byte[] r7 = JFIF_ID     // Catch:{ all -> 0x0019 }
            int r7 = r7.length     // Catch:{ all -> 0x0019 }
            byte[] r7 = new byte[r7]     // Catch:{ all -> 0x0019 }
            int r9 = r2.read(r7)     // Catch:{ all -> 0x0019 }
            int r10 = r7.length     // Catch:{ all -> 0x0019 }
            if (r9 != r10) goto L_0x00b6
            r9 = 0
        L_0x0065:
            int r10 = r7.length     // Catch:{ all -> 0x0019 }
            if (r9 < r10) goto L_0x006a
            r9 = 1
            goto L_0x0073
        L_0x006a:
            byte r10 = r7[r9]     // Catch:{ all -> 0x0019 }
            byte[] r11 = JFIF_ID     // Catch:{ all -> 0x0019 }
            byte r11 = r11[r9]     // Catch:{ all -> 0x0019 }
            if (r10 == r11) goto L_0x00b3
            r9 = 0
        L_0x0073:
            if (r9 != 0) goto L_0x007d
            int r6 = r6 + -2
            int r7 = r7.length     // Catch:{ all -> 0x0019 }
            int r6 = r6 - r7
            com.lowagie.text.Utilities.skip(r2, r6)     // Catch:{ all -> 0x0019 }
            goto L_0x00b1
        L_0x007d:
            com.lowagie.text.Utilities.skip(r2, r8)     // Catch:{ all -> 0x0019 }
            int r9 = r2.read()     // Catch:{ all -> 0x0019 }
            int r10 = getShort(r2)     // Catch:{ all -> 0x0019 }
            int r11 = getShort(r2)     // Catch:{ all -> 0x0019 }
            if (r9 != r0) goto L_0x0093
            r13.dpiX = r10     // Catch:{ all -> 0x0019 }
            r13.dpiY = r11     // Catch:{ all -> 0x0019 }
            goto L_0x00a8
        L_0x0093:
            if (r9 != r8) goto L_0x00a8
            float r8 = (float) r10     // Catch:{ all -> 0x0019 }
            r9 = 1076006748(0x40228f5c, float:2.54)
            float r8 = r8 * r9
            r10 = 1056964608(0x3f000000, float:0.5)
            float r8 = r8 + r10
            int r8 = (int) r8     // Catch:{ all -> 0x0019 }
            r13.dpiX = r8     // Catch:{ all -> 0x0019 }
            float r8 = (float) r11     // Catch:{ all -> 0x0019 }
            float r8 = r8 * r9
            float r8 = r8 + r10
            int r8 = (int) r8     // Catch:{ all -> 0x0019 }
            r13.dpiY = r8     // Catch:{ all -> 0x0019 }
        L_0x00a8:
            int r6 = r6 + -2
            int r7 = r7.length     // Catch:{ all -> 0x0019 }
            int r6 = r6 - r7
            int r6 = r6 + -7
            com.lowagie.text.Utilities.skip(r2, r6)     // Catch:{ all -> 0x0019 }
        L_0x00b1:
            r6 = 0
            goto L_0x0037
        L_0x00b3:
            int r9 = r9 + 1
            goto L_0x0065
        L_0x00b6:
            com.lowagie.text.BadElementException r0 = new com.lowagie.text.BadElementException     // Catch:{ all -> 0x0019 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0019 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0019 }
            r1.<init>(r3)     // Catch:{ all -> 0x0019 }
            java.lang.String r3 = " corrupted JFIF marker."
            r1.append(r3)     // Catch:{ all -> 0x0019 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0019 }
            r0.<init>((java.lang.String) r1)     // Catch:{ all -> 0x0019 }
            throw r0     // Catch:{ all -> 0x0019 }
        L_0x00ce:
            r9 = 238(0xee, float:3.34E-43)
            java.lang.String r10 = "ISO-8859-1"
            if (r7 != r9) goto L_0x00ff
            int r7 = getShort(r2)     // Catch:{ all -> 0x0019 }
            int r7 = r7 - r8
            byte[] r8 = new byte[r7]     // Catch:{ all -> 0x0019 }
            r9 = 0
        L_0x00dc:
            if (r9 < r7) goto L_0x00f5
            int r7 = r8.length     // Catch:{ all -> 0x0019 }
            r9 = 12
            if (r7 < r9) goto L_0x0037
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x0019 }
            r9 = 5
            r7.<init>(r8, r4, r9, r10)     // Catch:{ all -> 0x0019 }
            java.lang.String r8 = "Adobe"
            boolean r7 = r7.equals(r8)     // Catch:{ all -> 0x0019 }
            if (r7 == 0) goto L_0x0037
            r13.invert = r0     // Catch:{ all -> 0x0019 }
            goto L_0x0037
        L_0x00f5:
            int r11 = r2.read()     // Catch:{ all -> 0x0019 }
            byte r11 = (byte) r11     // Catch:{ all -> 0x0019 }
            r8[r9] = r11     // Catch:{ all -> 0x0019 }
            int r9 = r9 + 1
            goto L_0x00dc
        L_0x00ff:
            r9 = 226(0xe2, float:3.17E-43)
            r11 = 14
            if (r7 != r9) goto L_0x012a
            int r7 = getShort(r2)     // Catch:{ all -> 0x0019 }
            int r7 = r7 - r8
            byte[] r8 = new byte[r7]     // Catch:{ all -> 0x0019 }
            r9 = 0
        L_0x010d:
            if (r9 < r7) goto L_0x0120
            int r7 = r8.length     // Catch:{ all -> 0x0019 }
            if (r7 < r11) goto L_0x0037
            java.lang.String r7 = new java.lang.String     // Catch:{ all -> 0x0019 }
            r9 = 11
            r7.<init>(r8, r4, r9, r10)     // Catch:{ all -> 0x0019 }
            java.lang.String r8 = "ICC_PROFILE"
            r7.equals(r8)     // Catch:{ all -> 0x0019 }
            goto L_0x0037
        L_0x0120:
            int r12 = r2.read()     // Catch:{ all -> 0x0019 }
            byte r12 = (byte) r12     // Catch:{ all -> 0x0019 }
            r8[r9] = r12     // Catch:{ all -> 0x0019 }
            int r9 = r9 + 1
            goto L_0x010d
        L_0x012a:
            int r6 = marker(r7)     // Catch:{ all -> 0x0019 }
            if (r6 != 0) goto L_0x01bd
            com.lowagie.text.Utilities.skip(r2, r8)     // Catch:{ all -> 0x0019 }
            int r0 = r2.read()     // Catch:{ all -> 0x0019 }
            r5 = 8
            if (r0 != r5) goto L_0x01a5
            int r0 = getShort(r2)     // Catch:{ all -> 0x0019 }
            float r0 = (float) r0     // Catch:{ all -> 0x0019 }
            r13.scaledHeight = r0     // Catch:{ all -> 0x0019 }
            float r0 = r13.scaledHeight     // Catch:{ all -> 0x0019 }
            r13.setTop(r0)     // Catch:{ all -> 0x0019 }
            int r0 = getShort(r2)     // Catch:{ all -> 0x0019 }
            float r0 = (float) r0     // Catch:{ all -> 0x0019 }
            r13.scaledWidth = r0     // Catch:{ all -> 0x0019 }
            float r0 = r13.scaledWidth     // Catch:{ all -> 0x0019 }
            r13.setRight(r0)     // Catch:{ all -> 0x0019 }
            int r0 = r2.read()     // Catch:{ all -> 0x0019 }
            r13.colorspace = r0     // Catch:{ all -> 0x0019 }
            r13.bpc = r5     // Catch:{ all -> 0x0019 }
            if (r2 == 0) goto L_0x0160
            r2.close()
        L_0x0160:
            float r0 = r13.getWidth()
            r13.plainWidth = r0
            float r0 = r13.getHeight()
            r13.plainHeight = r0
            byte[][] r0 = r13.icc
            if (r0 == 0) goto L_0x01a4
            r0 = 0
            r2 = 0
        L_0x0172:
            byte[][] r3 = r13.icc
            int r5 = r3.length
            if (r0 < r5) goto L_0x0195
            byte[] r5 = new byte[r2]
            r0 = 0
        L_0x017a:
            byte[][] r2 = r13.icc
            int r3 = r2.length
            if (r4 < r3) goto L_0x0182
            r13.icc = r1
            goto L_0x01a4
        L_0x0182:
            r3 = r2[r4]
            r2 = r2[r4]
            int r2 = r2.length
            int r2 = r2 - r11
            java.lang.System.arraycopy(r3, r11, r5, r0, r2)
            byte[][] r2 = r13.icc
            r2 = r2[r4]
            int r2 = r2.length
            int r2 = r2 - r11
            int r0 = r0 + r2
            int r4 = r4 + 1
            goto L_0x017a
        L_0x0195:
            r5 = r3[r0]
            if (r5 != 0) goto L_0x019c
            r13.icc = r1
            return
        L_0x019c:
            r3 = r3[r0]
            int r3 = r3.length
            int r3 = r3 - r11
            int r2 = r2 + r3
            int r0 = r0 + 1
            goto L_0x0172
        L_0x01a4:
            return
        L_0x01a5:
            com.lowagie.text.BadElementException r0 = new com.lowagie.text.BadElementException     // Catch:{ all -> 0x0019 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0019 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0019 }
            r1.<init>(r3)     // Catch:{ all -> 0x0019 }
            java.lang.String r3 = " must have 8 bits per component."
            r1.append(r3)     // Catch:{ all -> 0x0019 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0019 }
            r0.<init>((java.lang.String) r1)     // Catch:{ all -> 0x0019 }
            throw r0     // Catch:{ all -> 0x0019 }
        L_0x01bd:
            if (r6 == r0) goto L_0x01cb
            if (r6 == r8) goto L_0x00b1
            int r6 = getShort(r2)     // Catch:{ all -> 0x0019 }
            int r6 = r6 - r8
            com.lowagie.text.Utilities.skip(r2, r6)     // Catch:{ all -> 0x0019 }
            goto L_0x00b1
        L_0x01cb:
            com.lowagie.text.BadElementException r0 = new com.lowagie.text.BadElementException     // Catch:{ all -> 0x0019 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0019 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0019 }
            r1.<init>(r3)     // Catch:{ all -> 0x0019 }
            java.lang.String r3 = ": unsupported JPEG marker: "
            r1.append(r3)     // Catch:{ all -> 0x0019 }
            r1.append(r7)     // Catch:{ all -> 0x0019 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0019 }
            r0.<init>((java.lang.String) r1)     // Catch:{ all -> 0x0019 }
            throw r0     // Catch:{ all -> 0x0019 }
        L_0x01e6:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0019 }
            java.lang.String r1 = "Premature EOF while reading JPG."
            r0.<init>(r1)     // Catch:{ all -> 0x0019 }
            throw r0     // Catch:{ all -> 0x0019 }
        L_0x01ee:
            com.lowagie.text.BadElementException r0 = new com.lowagie.text.BadElementException     // Catch:{ all -> 0x0019 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0019 }
            java.lang.String r3 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0019 }
            r1.<init>(r3)     // Catch:{ all -> 0x0019 }
            java.lang.String r3 = " is not a valid JPEG-file."
            r1.append(r3)     // Catch:{ all -> 0x0019 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0019 }
            r0.<init>((java.lang.String) r1)     // Catch:{ all -> 0x0019 }
            throw r0     // Catch:{ all -> 0x0019 }
        L_0x0206:
            r0 = move-exception
            r2 = r1
        L_0x0208:
            if (r2 == 0) goto L_0x020d
            r2.close()
        L_0x020d:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.Jpeg.processParameters():void");
    }
}
