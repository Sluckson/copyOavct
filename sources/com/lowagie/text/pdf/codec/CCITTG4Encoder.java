package com.lowagie.text.pdf.codec;

import com.google.android.exoplayer2.extractor.p008ts.PsExtractor;
import com.lowagie.text.pdf.ByteBuffer;
import com.lowagie.text.pdf.codec.wmf.MetaDo;
import com.wowza.gocoder.sdk.api.configuration.WOWZMediaConfig;
import com.wowza.gocoder.sdk.support.wse.jni.wmstransport.WMSTransport;
import p052cz.msebera.android.httpclient.HttpStatus;

public class CCITTG4Encoder {
    private static final int CODE = 1;
    private static final int EOL = 1;
    private static final int G3CODE_EOF = -3;
    private static final int G3CODE_EOL = -1;
    private static final int G3CODE_INCOMP = -4;
    private static final int G3CODE_INVALID = -2;
    private static final int LENGTH = 0;
    private static final int RUNLEN = 2;
    private static byte[] oneruns;
    private static byte[] zeroruns;
    private int[][] TIFFFaxBlackCodes;
    private int[][] TIFFFaxWhiteCodes;
    private int bit = 8;
    private int data;
    private byte[] dataBp;
    private int[] horizcode;
    private int[] msbmask;
    private int offsetData;
    private ByteBuffer outBuf = new ByteBuffer(1024);
    private int[] passcode;
    private byte[] refline;
    private int rowbytes;
    private int rowpixels;
    private int sizeData;
    private int[][] vcodes;

    public CCITTG4Encoder(int i) {
        int[] iArr = new int[3];
        iArr[0] = 8;
        iArr[1] = 53;
        int[] iArr2 = new int[3];
        iArr2[0] = 12;
        iArr2[2] = -2;
        this.TIFFFaxWhiteCodes = new int[][]{iArr, new int[]{6, 7, 1}, new int[]{4, 7, 2}, new int[]{4, 8, 3}, new int[]{4, 11, 4}, new int[]{4, 12, 5}, new int[]{4, 14, 6}, new int[]{4, 15, 7}, new int[]{5, 19, 8}, new int[]{5, 20, 9}, new int[]{5, 7, 10}, new int[]{5, 8, 11}, new int[]{6, 8, 12}, new int[]{6, 3, 13}, new int[]{6, 52, 14}, new int[]{6, 53, 15}, new int[]{6, 42, 16}, new int[]{6, 43, 17}, new int[]{7, 39, 18}, new int[]{7, 12, 19}, new int[]{7, 8, 20}, new int[]{7, 23, 21}, new int[]{7, 3, 22}, new int[]{7, 4, 23}, new int[]{7, 40, 24}, new int[]{7, 43, 25}, new int[]{7, 19, 26}, new int[]{7, 36, 27}, new int[]{7, 24, 28}, new int[]{8, 2, 29}, new int[]{8, 3, 30}, new int[]{8, 26, 31}, new int[]{8, 27, 32}, new int[]{8, 18, 33}, new int[]{8, 19, 34}, new int[]{8, 20, 35}, new int[]{8, 21, 36}, new int[]{8, 22, 37}, new int[]{8, 23, 38}, new int[]{8, 40, 39}, new int[]{8, 41, 40}, new int[]{8, 42, 41}, new int[]{8, 43, 42}, new int[]{8, 44, 43}, new int[]{8, 45, 44}, new int[]{8, 4, 45}, new int[]{8, 5, 46}, new int[]{8, 10, 47}, new int[]{8, 11, 48}, new int[]{8, 82, 49}, new int[]{8, 83, 50}, new int[]{8, 84, 51}, new int[]{8, 85, 52}, new int[]{8, 36, 53}, new int[]{8, 37, 54}, new int[]{8, 88, 55}, new int[]{8, 89, 56}, new int[]{8, 90, 57}, new int[]{8, 91, 58}, new int[]{8, 74, 59}, new int[]{8, 75, 60}, new int[]{8, 50, 61}, new int[]{8, 51, 62}, new int[]{8, 52, 63}, new int[]{5, 27, 64}, new int[]{5, 18, 128}, new int[]{6, 23, PsExtractor.AUDIO_STREAM}, new int[]{7, 55, 256}, new int[]{8, 54, TIFFConstants.TIFFTAG_COLORMAP}, new int[]{8, 55, 384}, new int[]{8, 100, 448}, new int[]{8, 101, 512}, new int[]{8, 104, 576}, new int[]{8, 103, WOWZMediaConfig.DEFAULT_VIDEO_FRAME_WIDTH}, new int[]{9, HttpStatus.SC_NO_CONTENT, 704}, new int[]{9, HttpStatus.SC_RESET_CONTENT, 768}, new int[]{9, WMSTransport.SESSIONSTATE_CONNECT_REDIRECT, 832}, new int[]{9, 211, 896}, new int[]{9, 212, 960}, new int[]{9, 213, 1024}, new int[]{9, 214, 1088}, new int[]{9, 215, 1152}, new int[]{9, 216, 1216}, new int[]{9, 217, 1280}, new int[]{9, 218, 1344}, new int[]{9, 219, 1408}, new int[]{9, 152, 1472}, new int[]{9, 153, WMSTransport.PUSHPUBLISHSESSIONWOWZ_HANDSHAKESIZE_CLIENT1}, new int[]{9, 154, 1600}, new int[]{6, 24, 1664}, new int[]{9, 155, 1728}, new int[]{11, 8, 1792}, new int[]{11, 12, 1856}, new int[]{11, 13, 1920}, new int[]{12, 18, 1984}, new int[]{12, 19, 2048}, new int[]{12, 20, 2112}, new int[]{12, 21, 2176}, new int[]{12, 22, 2240}, new int[]{12, 23, 2304}, new int[]{12, 28, MetaDo.META_DIBBITBLT}, new int[]{12, 29, 2432}, new int[]{12, 30, 2496}, new int[]{12, 31, 2560}, new int[]{12, 1, -1}, new int[]{9, 1, -2}, new int[]{10, 1, -2}, new int[]{11, 1, -2}, iArr2};
        int[] iArr3 = new int[3];
        iArr3[0] = 10;
        iArr3[1] = 55;
        int[] iArr4 = new int[3];
        iArr4[0] = 12;
        iArr4[2] = -2;
        this.TIFFFaxBlackCodes = new int[][]{iArr3, new int[]{3, 2, 1}, new int[]{2, 3, 2}, new int[]{2, 2, 3}, new int[]{3, 3, 4}, new int[]{4, 3, 5}, new int[]{4, 2, 6}, new int[]{5, 3, 7}, new int[]{6, 5, 8}, new int[]{6, 4, 9}, new int[]{7, 4, 10}, new int[]{7, 5, 11}, new int[]{7, 7, 12}, new int[]{8, 4, 13}, new int[]{8, 7, 14}, new int[]{9, 24, 15}, new int[]{10, 23, 16}, new int[]{10, 24, 17}, new int[]{10, 8, 18}, new int[]{11, 103, 19}, new int[]{11, 104, 20}, new int[]{11, 108, 21}, new int[]{11, 55, 22}, new int[]{11, 40, 23}, new int[]{11, 23, 24}, new int[]{11, 24, 25}, new int[]{12, 202, 26}, new int[]{12, 203, 27}, new int[]{12, HttpStatus.SC_NO_CONTENT, 28}, new int[]{12, HttpStatus.SC_RESET_CONTENT, 29}, new int[]{12, 104, 30}, new int[]{12, 105, 31}, new int[]{12, 106, 32}, new int[]{12, 107, 33}, new int[]{12, WMSTransport.SESSIONSTATE_CONNECT_REDIRECT, 34}, new int[]{12, 211, 35}, new int[]{12, 212, 36}, new int[]{12, 213, 37}, new int[]{12, 214, 38}, new int[]{12, 215, 39}, new int[]{12, 108, 40}, new int[]{12, 109, 41}, new int[]{12, 218, 42}, new int[]{12, 219, 43}, new int[]{12, 84, 44}, new int[]{12, 85, 45}, new int[]{12, 86, 46}, new int[]{12, 87, 47}, new int[]{12, 100, 48}, new int[]{12, 101, 49}, new int[]{12, 82, 50}, new int[]{12, 83, 51}, new int[]{12, 36, 52}, new int[]{12, 55, 53}, new int[]{12, 56, 54}, new int[]{12, 39, 55}, new int[]{12, 40, 56}, new int[]{12, 88, 57}, new int[]{12, 89, 58}, new int[]{12, 43, 59}, new int[]{12, 44, 60}, new int[]{12, 90, 61}, new int[]{12, 102, 62}, new int[]{12, 103, 63}, new int[]{10, 15, 64}, new int[]{12, 200, 128}, new int[]{12, 201, PsExtractor.AUDIO_STREAM}, new int[]{12, 91, 256}, new int[]{12, 51, TIFFConstants.TIFFTAG_COLORMAP}, new int[]{12, 52, 384}, new int[]{12, 53, 448}, new int[]{13, 108, 512}, new int[]{13, 109, 576}, new int[]{13, 74, WOWZMediaConfig.DEFAULT_VIDEO_FRAME_WIDTH}, new int[]{13, 75, 704}, new int[]{13, 76, 768}, new int[]{13, 77, 832}, new int[]{13, 114, 896}, new int[]{13, 115, 960}, new int[]{13, 116, 1024}, new int[]{13, 117, 1088}, new int[]{13, 118, 1152}, new int[]{13, 119, 1216}, new int[]{13, 82, 1280}, new int[]{13, 83, 1344}, new int[]{13, 84, 1408}, new int[]{13, 85, 1472}, new int[]{13, 90, WMSTransport.PUSHPUBLISHSESSIONWOWZ_HANDSHAKESIZE_CLIENT1}, new int[]{13, 91, 1600}, new int[]{13, 100, 1664}, new int[]{13, 101, 1728}, new int[]{11, 8, 1792}, new int[]{11, 12, 1856}, new int[]{11, 13, 1920}, new int[]{12, 18, 1984}, new int[]{12, 19, 2048}, new int[]{12, 20, 2112}, new int[]{12, 21, 2176}, new int[]{12, 22, 2240}, new int[]{12, 23, 2304}, new int[]{12, 28, MetaDo.META_DIBBITBLT}, new int[]{12, 29, 2432}, new int[]{12, 30, 2496}, new int[]{12, 31, 2560}, new int[]{12, 1, -1}, new int[]{9, 1, -2}, new int[]{10, 1, -2}, new int[]{11, 1, -2}, iArr4};
        int[] iArr5 = new int[3];
        iArr5[0] = 3;
        iArr5[1] = 1;
        this.horizcode = iArr5;
        int[] iArr6 = new int[3];
        iArr6[0] = 4;
        iArr6[1] = 1;
        this.passcode = iArr6;
        int[] iArr7 = new int[3];
        iArr7[0] = 7;
        iArr7[1] = 3;
        int[] iArr8 = new int[3];
        iArr8[0] = 6;
        iArr8[1] = 3;
        int[] iArr9 = new int[3];
        iArr9[0] = 3;
        iArr9[1] = 3;
        int[] iArr10 = new int[3];
        iArr10[0] = 1;
        iArr10[1] = 1;
        int[] iArr11 = new int[3];
        iArr11[0] = 3;
        iArr11[1] = 2;
        int[] iArr12 = new int[3];
        iArr12[0] = 6;
        iArr12[1] = 2;
        int[] iArr13 = new int[3];
        iArr13[0] = 7;
        iArr13[1] = 2;
        this.vcodes = new int[][]{iArr7, iArr8, iArr9, iArr10, iArr11, iArr12, iArr13};
        int[] iArr14 = new int[9];
        iArr14[1] = 1;
        iArr14[2] = 3;
        iArr14[3] = 7;
        iArr14[4] = 15;
        iArr14[5] = 31;
        iArr14[6] = 63;
        iArr14[7] = 127;
        iArr14[8] = 255;
        this.msbmask = iArr14;
        this.rowpixels = i;
        this.rowbytes = (this.rowpixels + 7) / 8;
        this.refline = new byte[this.rowbytes];
    }

    public void fax4Encode(byte[] bArr, int i, int i2) {
        this.dataBp = bArr;
        this.offsetData = i;
        this.sizeData = i2;
        while (this.sizeData > 0) {
            Fax3Encode2DRow();
            System.arraycopy(this.dataBp, this.offsetData, this.refline, 0, this.rowbytes);
            int i3 = this.offsetData;
            int i4 = this.rowbytes;
            this.offsetData = i3 + i4;
            this.sizeData -= i4;
        }
    }

    public static byte[] compress(byte[] bArr, int i, int i2) {
        CCITTG4Encoder cCITTG4Encoder = new CCITTG4Encoder(i);
        cCITTG4Encoder.fax4Encode(bArr, 0, cCITTG4Encoder.rowbytes * i2);
        return cCITTG4Encoder.close();
    }

    public void fax4Encode(byte[] bArr, int i) {
        fax4Encode(bArr, 0, this.rowbytes * i);
    }

    private void putcode(int[] iArr) {
        putBits(iArr[1], iArr[0]);
    }

    private void putspan(int i, int[][] iArr) {
        while (i >= 2624) {
            int[] iArr2 = iArr[103];
            putBits(iArr2[1], iArr2[0]);
            i -= iArr2[2];
        }
        if (i >= 64) {
            int[] iArr3 = iArr[(i >> 6) + 63];
            putBits(iArr3[1], iArr3[0]);
            i -= iArr3[2];
        }
        putBits(iArr[i][1], iArr[i][0]);
    }

    private void putBits(int i, int i2) {
        int i3;
        while (true) {
            i3 = this.bit;
            if (i2 <= i3) {
                break;
            }
            this.data |= i >> (i2 - i3);
            i2 -= i3;
            this.outBuf.append((byte) this.data);
            this.data = 0;
            this.bit = 8;
        }
        this.data = ((i & this.msbmask[i2]) << (i3 - i2)) | this.data;
        this.bit = i3 - i2;
        if (this.bit == 0) {
            this.outBuf.append((byte) this.data);
            this.data = 0;
            this.bit = 8;
        }
    }

    private void Fax3Encode2DRow() {
        int finddiff = pixel(this.dataBp, this.offsetData, 0) != 0 ? 0 : finddiff(this.dataBp, this.offsetData, 0, this.rowpixels, 0);
        int finddiff2 = pixel(this.refline, 0, 0) != 0 ? 0 : finddiff(this.refline, 0, 0, this.rowpixels, 0);
        int i = 0;
        while (true) {
            byte[] bArr = this.refline;
            int finddiff22 = finddiff2(bArr, 0, finddiff2, this.rowpixels, pixel(bArr, 0, finddiff2));
            if (finddiff22 >= finddiff) {
                int i2 = finddiff2 - finddiff;
                if (-3 > i2 || i2 > 3) {
                    byte[] bArr2 = this.dataBp;
                    int i3 = this.offsetData;
                    int finddiff23 = finddiff2(bArr2, i3, finddiff, this.rowpixels, pixel(bArr2, i3, finddiff));
                    putcode(this.horizcode);
                    if (i + finddiff == 0 || pixel(this.dataBp, this.offsetData, i) == 0) {
                        putspan(finddiff - i, this.TIFFFaxWhiteCodes);
                        putspan(finddiff23 - finddiff, this.TIFFFaxBlackCodes);
                    } else {
                        putspan(finddiff - i, this.TIFFFaxBlackCodes);
                        putspan(finddiff23 - finddiff, this.TIFFFaxWhiteCodes);
                    }
                    i = finddiff23;
                } else {
                    putcode(this.vcodes[i2 + 3]);
                    i = finddiff;
                }
            } else {
                putcode(this.passcode);
                i = finddiff22;
            }
            int i4 = this.rowpixels;
            if (i < i4) {
                byte[] bArr3 = this.dataBp;
                int i5 = this.offsetData;
                finddiff = finddiff(bArr3, i5, i, i4, pixel(bArr3, i5, i));
                finddiff2 = finddiff(this.refline, 0, finddiff(this.refline, 0, i, this.rowpixels, pixel(this.dataBp, this.offsetData, i) ^ 1), this.rowpixels, pixel(this.dataBp, this.offsetData, i));
            } else {
                return;
            }
        }
    }

    private void Fax4PostEncode() {
        putBits(1, 12);
        putBits(1, 12);
        if (this.bit != 8) {
            this.outBuf.append((byte) this.data);
            this.data = 0;
            this.bit = 8;
        }
    }

    public byte[] close() {
        Fax4PostEncode();
        return this.outBuf.toByteArray();
    }

    private int pixel(byte[] bArr, int i, int i2) {
        if (i2 >= this.rowpixels) {
            return 0;
        }
        return ((bArr[i + (i2 >> 3)] & 255) >> (7 - (i2 & 7))) & 1;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: byte} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int find1span(byte[] r3, int r4, int r5, int r6) {
        /*
            int r6 = r6 - r5
            int r0 = r5 >> 3
            int r4 = r4 + r0
            r0 = 8
            if (r6 <= 0) goto L_0x0023
            r5 = r5 & 7
            if (r5 == 0) goto L_0x0023
            byte[] r1 = oneruns
            byte r2 = r3[r4]
            int r2 = r2 << r5
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte r1 = r1[r2]
            int r2 = 8 - r5
            if (r1 <= r2) goto L_0x001a
            r1 = r2
        L_0x001a:
            if (r1 <= r6) goto L_0x001d
            r1 = r6
        L_0x001d:
            int r5 = r5 + r1
            if (r5 >= r0) goto L_0x0021
            return r1
        L_0x0021:
            int r6 = r6 - r1
            goto L_0x0048
        L_0x0023:
            r1 = 0
        L_0x0024:
            if (r6 >= r0) goto L_0x0035
            if (r6 <= 0) goto L_0x0034
            byte[] r5 = oneruns
            byte r3 = r3[r4]
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte r3 = r5[r3]
            if (r3 <= r6) goto L_0x0033
            r3 = r6
        L_0x0033:
            int r1 = r1 + r3
        L_0x0034:
            return r1
        L_0x0035:
            byte r5 = r3[r4]
            r2 = -1
            if (r5 == r2) goto L_0x0044
            byte[] r5 = oneruns
            byte r3 = r3[r4]
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte r3 = r5[r3]
            int r1 = r1 + r3
            return r1
        L_0x0044:
            int r1 = r1 + 8
            int r6 = r6 + -8
        L_0x0048:
            int r4 = r4 + 1
            goto L_0x0024
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.codec.CCITTG4Encoder.find1span(byte[], int, int, int):int");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: byte} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0035  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int find0span(byte[] r3, int r4, int r5, int r6) {
        /*
            int r6 = r6 - r5
            int r0 = r5 >> 3
            int r4 = r4 + r0
            r0 = 8
            if (r6 <= 0) goto L_0x0023
            r5 = r5 & 7
            if (r5 == 0) goto L_0x0023
            byte[] r1 = zeroruns
            byte r2 = r3[r4]
            int r2 = r2 << r5
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte r1 = r1[r2]
            int r2 = 8 - r5
            if (r1 <= r2) goto L_0x001a
            r1 = r2
        L_0x001a:
            if (r1 <= r6) goto L_0x001d
            r1 = r6
        L_0x001d:
            int r5 = r5 + r1
            if (r5 >= r0) goto L_0x0021
            return r1
        L_0x0021:
            int r6 = r6 - r1
            goto L_0x0047
        L_0x0023:
            r1 = 0
        L_0x0024:
            if (r6 >= r0) goto L_0x0035
            if (r6 <= 0) goto L_0x0034
            byte[] r5 = zeroruns
            byte r3 = r3[r4]
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte r3 = r5[r3]
            if (r3 <= r6) goto L_0x0033
            r3 = r6
        L_0x0033:
            int r1 = r1 + r3
        L_0x0034:
            return r1
        L_0x0035:
            byte r5 = r3[r4]
            if (r5 == 0) goto L_0x0043
            byte[] r5 = zeroruns
            byte r3 = r3[r4]
            r3 = r3 & 255(0xff, float:3.57E-43)
            byte r3 = r5[r3]
            int r1 = r1 + r3
            return r1
        L_0x0043:
            int r1 = r1 + 8
            int r6 = r6 + -8
        L_0x0047:
            int r4 = r4 + 1
            goto L_0x0024
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.codec.CCITTG4Encoder.find0span(byte[], int, int, int):int");
    }

    private static int finddiff(byte[] bArr, int i, int i2, int i3, int i4) {
        return i2 + (i4 != 0 ? find1span(bArr, i, i2, i3) : find0span(bArr, i, i2, i3));
    }

    private static int finddiff2(byte[] bArr, int i, int i2, int i3, int i4) {
        return i2 < i3 ? finddiff(bArr, i, i2, i3, i4) : i3;
    }

    static {
        byte[] bArr = new byte[256];
        bArr[0] = 8;
        bArr[1] = 7;
        bArr[2] = 6;
        bArr[3] = 6;
        bArr[4] = 5;
        bArr[5] = 5;
        bArr[6] = 5;
        bArr[7] = 5;
        bArr[8] = 4;
        bArr[9] = 4;
        bArr[10] = 4;
        bArr[11] = 4;
        bArr[12] = 4;
        bArr[13] = 4;
        bArr[14] = 4;
        bArr[15] = 4;
        bArr[16] = 3;
        bArr[17] = 3;
        bArr[18] = 3;
        bArr[19] = 3;
        bArr[20] = 3;
        bArr[21] = 3;
        bArr[22] = 3;
        bArr[23] = 3;
        bArr[24] = 3;
        bArr[25] = 3;
        bArr[26] = 3;
        bArr[27] = 3;
        bArr[28] = 3;
        bArr[29] = 3;
        bArr[30] = 3;
        bArr[31] = 3;
        bArr[32] = 2;
        bArr[33] = 2;
        bArr[34] = 2;
        bArr[35] = 2;
        bArr[36] = 2;
        bArr[37] = 2;
        bArr[38] = 2;
        bArr[39] = 2;
        bArr[40] = 2;
        bArr[41] = 2;
        bArr[42] = 2;
        bArr[43] = 2;
        bArr[44] = 2;
        bArr[45] = 2;
        bArr[46] = 2;
        bArr[47] = 2;
        bArr[48] = 2;
        bArr[49] = 2;
        bArr[50] = 2;
        bArr[51] = 2;
        bArr[52] = 2;
        bArr[53] = 2;
        bArr[54] = 2;
        bArr[55] = 2;
        bArr[56] = 2;
        bArr[57] = 2;
        bArr[58] = 2;
        bArr[59] = 2;
        bArr[60] = 2;
        bArr[61] = 2;
        bArr[62] = 2;
        bArr[63] = 2;
        bArr[64] = 1;
        bArr[65] = 1;
        bArr[66] = 1;
        bArr[67] = 1;
        bArr[68] = 1;
        bArr[69] = 1;
        bArr[70] = 1;
        bArr[71] = 1;
        bArr[72] = 1;
        bArr[73] = 1;
        bArr[74] = 1;
        bArr[75] = 1;
        bArr[76] = 1;
        bArr[77] = 1;
        bArr[78] = 1;
        bArr[79] = 1;
        bArr[80] = 1;
        bArr[81] = 1;
        bArr[82] = 1;
        bArr[83] = 1;
        bArr[84] = 1;
        bArr[85] = 1;
        bArr[86] = 1;
        bArr[87] = 1;
        bArr[88] = 1;
        bArr[89] = 1;
        bArr[90] = 1;
        bArr[91] = 1;
        bArr[92] = 1;
        bArr[93] = 1;
        bArr[94] = 1;
        bArr[95] = 1;
        bArr[96] = 1;
        bArr[97] = 1;
        bArr[98] = 1;
        bArr[99] = 1;
        bArr[100] = 1;
        bArr[101] = 1;
        bArr[102] = 1;
        bArr[103] = 1;
        bArr[104] = 1;
        bArr[105] = 1;
        bArr[106] = 1;
        bArr[107] = 1;
        bArr[108] = 1;
        bArr[109] = 1;
        bArr[110] = 1;
        bArr[111] = 1;
        bArr[112] = 1;
        bArr[113] = 1;
        bArr[114] = 1;
        bArr[115] = 1;
        bArr[116] = 1;
        bArr[117] = 1;
        bArr[118] = 1;
        bArr[119] = 1;
        bArr[120] = 1;
        bArr[121] = 1;
        bArr[122] = 1;
        bArr[123] = 1;
        bArr[124] = 1;
        bArr[125] = 1;
        bArr[126] = 1;
        bArr[127] = 1;
        zeroruns = bArr;
        byte[] bArr2 = new byte[256];
        bArr2[128] = 1;
        bArr2[129] = 1;
        bArr2[130] = 1;
        bArr2[131] = 1;
        bArr2[132] = 1;
        bArr2[133] = 1;
        bArr2[134] = 1;
        bArr2[135] = 1;
        bArr2[136] = 1;
        bArr2[137] = 1;
        bArr2[138] = 1;
        bArr2[139] = 1;
        bArr2[140] = 1;
        bArr2[141] = 1;
        bArr2[142] = 1;
        bArr2[143] = 1;
        bArr2[144] = 1;
        bArr2[145] = 1;
        bArr2[146] = 1;
        bArr2[147] = 1;
        bArr2[148] = 1;
        bArr2[149] = 1;
        bArr2[150] = 1;
        bArr2[151] = 1;
        bArr2[152] = 1;
        bArr2[153] = 1;
        bArr2[154] = 1;
        bArr2[155] = 1;
        bArr2[156] = 1;
        bArr2[157] = 1;
        bArr2[158] = 1;
        bArr2[159] = 1;
        bArr2[160] = 1;
        bArr2[161] = 1;
        bArr2[162] = 1;
        bArr2[163] = 1;
        bArr2[164] = 1;
        bArr2[165] = 1;
        bArr2[166] = 1;
        bArr2[167] = 1;
        bArr2[168] = 1;
        bArr2[169] = 1;
        bArr2[170] = 1;
        bArr2[171] = 1;
        bArr2[172] = 1;
        bArr2[173] = 1;
        bArr2[174] = 1;
        bArr2[175] = 1;
        bArr2[176] = 1;
        bArr2[177] = 1;
        bArr2[178] = 1;
        bArr2[179] = 1;
        bArr2[180] = 1;
        bArr2[181] = 1;
        bArr2[182] = 1;
        bArr2[183] = 1;
        bArr2[184] = 1;
        bArr2[185] = 1;
        bArr2[186] = 1;
        bArr2[187] = 1;
        bArr2[188] = 1;
        bArr2[189] = 1;
        bArr2[190] = 1;
        bArr2[191] = 1;
        bArr2[192] = 2;
        bArr2[193] = 2;
        bArr2[194] = 2;
        bArr2[195] = 2;
        bArr2[196] = 2;
        bArr2[197] = 2;
        bArr2[198] = 2;
        bArr2[199] = 2;
        bArr2[200] = 2;
        bArr2[201] = 2;
        bArr2[202] = 2;
        bArr2[203] = 2;
        bArr2[204] = 2;
        bArr2[205] = 2;
        bArr2[206] = 2;
        bArr2[207] = 2;
        bArr2[208] = 2;
        bArr2[209] = 2;
        bArr2[210] = 2;
        bArr2[211] = 2;
        bArr2[212] = 2;
        bArr2[213] = 2;
        bArr2[214] = 2;
        bArr2[215] = 2;
        bArr2[216] = 2;
        bArr2[217] = 2;
        bArr2[218] = 2;
        bArr2[219] = 2;
        bArr2[220] = 2;
        bArr2[221] = 2;
        bArr2[222] = 2;
        bArr2[223] = 2;
        bArr2[224] = 3;
        bArr2[225] = 3;
        bArr2[226] = 3;
        bArr2[227] = 3;
        bArr2[228] = 3;
        bArr2[229] = 3;
        bArr2[230] = 3;
        bArr2[231] = 3;
        bArr2[232] = 3;
        bArr2[233] = 3;
        bArr2[234] = 3;
        bArr2[235] = 3;
        bArr2[236] = 3;
        bArr2[237] = 3;
        bArr2[238] = 3;
        bArr2[239] = 3;
        bArr2[240] = 4;
        bArr2[241] = 4;
        bArr2[242] = 4;
        bArr2[243] = 4;
        bArr2[244] = 4;
        bArr2[245] = 4;
        bArr2[246] = 4;
        bArr2[247] = 4;
        bArr2[248] = 5;
        bArr2[249] = 5;
        bArr2[250] = 5;
        bArr2[251] = 5;
        bArr2[252] = 6;
        bArr2[253] = 6;
        bArr2[254] = 7;
        bArr2[255] = 8;
        oneruns = bArr2;
    }
}
