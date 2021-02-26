package repack.org.bouncycastle.crypto.digests;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.lowagie.text.DocWriter;
import com.lowagie.text.pdf.ByteBuffer;
import com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFData;
import repack.org.bouncycastle.crypto.ExtendedDigest;
import repack.org.bouncycastle.crypto.signers.PSSSigner;

public class MD2Digest implements ExtendedDigest {
    private static final int DIGEST_LENGTH = 16;

    /* renamed from: S */
    private static final byte[] f5948S;

    /* renamed from: C */
    private byte[] f5949C = new byte[16];
    private int COff;

    /* renamed from: M */
    private byte[] f5950M = new byte[16];

    /* renamed from: X */
    private byte[] f5951X = new byte[48];
    private int mOff;
    private int xOff;

    public String getAlgorithmName() {
        return "MD2";
    }

    public int getByteLength() {
        return 16;
    }

    public int getDigestSize() {
        return 16;
    }

    public MD2Digest() {
        reset();
    }

    public MD2Digest(MD2Digest mD2Digest) {
        byte[] bArr = mD2Digest.f5951X;
        System.arraycopy(bArr, 0, this.f5951X, 0, bArr.length);
        this.xOff = mD2Digest.xOff;
        byte[] bArr2 = mD2Digest.f5950M;
        System.arraycopy(bArr2, 0, this.f5950M, 0, bArr2.length);
        this.mOff = mD2Digest.mOff;
        byte[] bArr3 = mD2Digest.f5949C;
        System.arraycopy(bArr3, 0, this.f5949C, 0, bArr3.length);
        this.COff = mD2Digest.COff;
    }

    public int doFinal(byte[] bArr, int i) {
        int length = this.f5950M.length;
        int i2 = this.mOff;
        byte b = (byte) (length - i2);
        while (true) {
            byte[] bArr2 = this.f5950M;
            if (i2 >= bArr2.length) {
                processCheckSum(bArr2);
                processBlock(this.f5950M);
                processBlock(this.f5949C);
                System.arraycopy(this.f5951X, this.xOff, bArr, i, 16);
                reset();
                return 16;
            }
            bArr2[i2] = b;
            i2++;
        }
    }

    public void reset() {
        this.xOff = 0;
        int i = 0;
        while (true) {
            byte[] bArr = this.f5951X;
            if (i == bArr.length) {
                break;
            }
            bArr[i] = 0;
            i++;
        }
        this.mOff = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr2 = this.f5950M;
            if (i2 == bArr2.length) {
                break;
            }
            bArr2[i2] = 0;
            i2++;
        }
        this.COff = 0;
        int i3 = 0;
        while (true) {
            byte[] bArr3 = this.f5949C;
            if (i3 != bArr3.length) {
                bArr3[i3] = 0;
                i3++;
            } else {
                return;
            }
        }
    }

    public void update(byte b) {
        byte[] bArr = this.f5950M;
        int i = this.mOff;
        this.mOff = i + 1;
        bArr[i] = b;
        if (this.mOff == 16) {
            processCheckSum(bArr);
            processBlock(this.f5950M);
            this.mOff = 0;
        }
    }

    public void update(byte[] bArr, int i, int i2) {
        while (this.mOff != 0 && i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
        while (i2 > 16) {
            System.arraycopy(bArr, i, this.f5950M, 0, 16);
            processCheckSum(this.f5950M);
            processBlock(this.f5950M);
            i2 -= 16;
            i += 16;
        }
        while (i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
    }

    /* access modifiers changed from: protected */
    public void processCheckSum(byte[] bArr) {
        byte b = this.f5949C[15];
        for (int i = 0; i < 16; i++) {
            byte[] bArr2 = this.f5949C;
            bArr2[i] = (byte) (f5948S[(b ^ bArr[i]) & 255] ^ bArr2[i]);
            b = bArr2[i];
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: byte} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void processBlock(byte[] r7) {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L_0x0002:
            r2 = 16
            if (r1 < r2) goto L_0x002a
            r7 = 0
            r2 = 0
        L_0x0008:
            r1 = 18
            if (r2 < r1) goto L_0x000d
            return
        L_0x000d:
            r1 = r7
            r7 = 0
        L_0x000f:
            r3 = 48
            if (r7 < r3) goto L_0x0019
            int r1 = r1 + r2
            int r7 = r1 % 256
            int r2 = r2 + 1
            goto L_0x0008
        L_0x0019:
            byte[] r3 = r6.f5951X
            byte r4 = r3[r7]
            byte[] r5 = f5948S
            byte r1 = r5[r1]
            r1 = r1 ^ r4
            byte r1 = (byte) r1
            r3[r7] = r1
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r7 = r7 + 1
            goto L_0x000f
        L_0x002a:
            byte[] r2 = r6.f5951X
            int r3 = r1 + 16
            byte r4 = r7[r1]
            r2[r3] = r4
            int r3 = r1 + 32
            byte r4 = r7[r1]
            byte r5 = r2[r1]
            r4 = r4 ^ r5
            byte r4 = (byte) r4
            r2[r3] = r4
            int r1 = r1 + 1
            goto L_0x0002
        */
        throw new UnsupportedOperationException("Method not decompiled: repack.org.bouncycastle.crypto.digests.MD2Digest.processBlock(byte[]):void");
    }

    static {
        byte[] bArr = new byte[256];
        bArr[0] = 41;
        bArr[1] = 46;
        bArr[2] = 67;
        bArr[3] = -55;
        bArr[4] = -94;
        bArr[5] = -40;
        bArr[6] = 124;
        bArr[7] = 1;
        bArr[8] = DocWriter.EQUALS;
        bArr[9] = 54;
        bArr[10] = 84;
        bArr[11] = -95;
        bArr[12] = -20;
        bArr[13] = -16;
        bArr[14] = 6;
        bArr[15] = 19;
        bArr[16] = 98;
        bArr[17] = -89;
        bArr[18] = 5;
        bArr[19] = -13;
        bArr[20] = -64;
        bArr[21] = -57;
        bArr[22] = 115;
        bArr[23] = -116;
        bArr[24] = -104;
        bArr[25] = -109;
        bArr[26] = 43;
        bArr[27] = -39;
        bArr[28] = PSSSigner.TRAILER_IMPLICIT;
        bArr[29] = 76;
        bArr[30] = -126;
        bArr[31] = -54;
        bArr[32] = Ascii.f271RS;
        bArr[33] = -101;
        bArr[34] = 87;
        bArr[35] = DocWriter.f570LT;
        bArr[36] = -3;
        bArr[37] = -44;
        bArr[38] = -32;
        bArr[39] = 22;
        bArr[40] = 103;
        bArr[41] = 66;
        bArr[42] = 111;
        bArr[43] = Ascii.CAN;
        bArr[44] = -118;
        bArr[45] = Ascii.ETB;
        bArr[46] = -27;
        bArr[47] = 18;
        bArr[48] = -66;
        bArr[49] = 78;
        bArr[50] = -60;
        bArr[51] = -42;
        bArr[52] = -38;
        bArr[53] = -98;
        bArr[54] = -34;
        bArr[55] = 73;
        bArr[56] = -96;
        bArr[57] = -5;
        bArr[58] = -11;
        bArr[59] = -114;
        bArr[60] = -69;
        bArr[61] = DocWriter.FORWARD;
        bArr[62] = -18;
        bArr[63] = 122;
        bArr[64] = -87;
        bArr[65] = 104;
        bArr[66] = 121;
        bArr[67] = -111;
        bArr[68] = Ascii.NAK;
        bArr[69] = -78;
        bArr[70] = 7;
        bArr[71] = 63;
        bArr[72] = -108;
        bArr[73] = -62;
        bArr[74] = 16;
        bArr[75] = -119;
        bArr[76] = 11;
        bArr[77] = 34;
        bArr[78] = 95;
        bArr[79] = AMFData.DATA_TYPE_BYTEARRAY;
        bArr[80] = Byte.MIN_VALUE;
        bArr[81] = Byte.MAX_VALUE;
        bArr[82] = 93;
        bArr[83] = -102;
        bArr[84] = 90;
        bArr[85] = -112;
        bArr[86] = 50;
        bArr[87] = 39;
        bArr[88] = 53;
        bArr[89] = DocWriter.f569GT;
        bArr[90] = -52;
        bArr[91] = -25;
        bArr[92] = -65;
        bArr[93] = -9;
        bArr[94] = -105;
        bArr[95] = 3;
        bArr[96] = -1;
        bArr[97] = Ascii.f264EM;
        bArr[98] = ByteBuffer.ZERO;
        bArr[99] = -77;
        bArr[100] = 72;
        bArr[101] = -91;
        bArr[102] = -75;
        bArr[103] = -47;
        bArr[104] = -41;
        bArr[105] = 94;
        bArr[106] = -110;
        bArr[107] = 42;
        bArr[108] = -84;
        bArr[109] = 86;
        bArr[110] = -86;
        bArr[111] = -58;
        bArr[112] = 79;
        bArr[113] = -72;
        bArr[114] = 56;
        bArr[115] = -46;
        bArr[116] = -106;
        bArr[117] = -92;
        bArr[118] = 125;
        bArr[119] = -74;
        bArr[120] = 118;
        bArr[121] = -4;
        bArr[122] = 107;
        bArr[123] = -30;
        bArr[124] = -100;
        bArr[125] = 116;
        bArr[126] = 4;
        bArr[127] = -15;
        bArr[128] = 69;
        bArr[129] = -99;
        bArr[130] = 112;
        bArr[131] = 89;
        bArr[132] = 100;
        bArr[133] = 113;
        bArr[134] = -121;
        bArr[135] = 32;
        bArr[136] = -122;
        bArr[137] = 91;
        bArr[138] = -49;
        bArr[139] = 101;
        bArr[140] = -26;
        bArr[141] = 45;
        bArr[142] = -88;
        bArr[143] = 2;
        bArr[144] = Ascii.ESC;
        bArr[145] = 96;
        bArr[146] = 37;
        bArr[147] = -83;
        bArr[148] = -82;
        bArr[149] = -80;
        bArr[150] = -71;
        bArr[151] = -10;
        bArr[152] = Ascii.f266FS;
        bArr[153] = 70;
        bArr[154] = 97;
        bArr[155] = 105;
        bArr[156] = 52;
        bArr[157] = SignedBytes.MAX_POWER_OF_TWO;
        bArr[158] = 126;
        bArr[159] = 15;
        bArr[160] = 85;
        bArr[161] = 71;
        bArr[162] = -93;
        bArr[163] = 35;
        bArr[164] = -35;
        bArr[165] = 81;
        bArr[166] = -81;
        bArr[167] = 58;
        bArr[168] = -61;
        bArr[169] = 92;
        bArr[170] = -7;
        bArr[171] = -50;
        bArr[172] = -70;
        bArr[173] = -59;
        bArr[174] = -22;
        bArr[175] = 38;
        bArr[176] = 44;
        bArr[177] = 83;
        bArr[178] = 13;
        bArr[179] = 110;
        bArr[180] = -123;
        bArr[181] = 40;
        bArr[182] = -124;
        bArr[183] = 9;
        bArr[184] = -45;
        bArr[185] = -33;
        bArr[186] = -51;
        bArr[187] = -12;
        bArr[188] = 65;
        bArr[189] = -127;
        bArr[190] = 77;
        bArr[191] = 82;
        bArr[192] = 106;
        bArr[193] = -36;
        bArr[194] = 55;
        bArr[195] = -56;
        bArr[196] = 108;
        bArr[197] = -63;
        bArr[198] = -85;
        bArr[199] = -6;
        bArr[200] = 36;
        bArr[201] = -31;
        bArr[202] = 123;
        bArr[203] = 8;
        bArr[204] = 12;
        bArr[205] = -67;
        bArr[206] = -79;
        bArr[207] = 74;
        bArr[208] = 120;
        bArr[209] = -120;
        bArr[210] = -107;
        bArr[211] = -117;
        bArr[212] = -29;
        bArr[213] = 99;
        bArr[214] = -24;
        bArr[215] = 109;
        bArr[216] = -23;
        bArr[217] = -53;
        bArr[218] = -43;
        bArr[219] = -2;
        bArr[220] = 59;
        bArr[222] = Ascii.f267GS;
        bArr[223] = 57;
        bArr[224] = -14;
        bArr[225] = -17;
        bArr[226] = -73;
        bArr[227] = 14;
        bArr[228] = 102;
        bArr[229] = 88;
        bArr[230] = -48;
        bArr[231] = -28;
        bArr[232] = -90;
        bArr[233] = 119;
        bArr[234] = 114;
        bArr[235] = -8;
        bArr[236] = -21;
        bArr[237] = 117;
        bArr[238] = 75;
        bArr[239] = 10;
        bArr[240] = 49;
        bArr[241] = 68;
        bArr[242] = 80;
        bArr[243] = -76;
        bArr[244] = -113;
        bArr[245] = -19;
        bArr[246] = Ascii.f275US;
        bArr[247] = Ascii.SUB;
        bArr[248] = -37;
        bArr[249] = -103;
        bArr[250] = -115;
        bArr[251] = 51;
        bArr[252] = -97;
        bArr[253] = 17;
        bArr[254] = -125;
        bArr[255] = 20;
        f5948S = bArr;
    }
}
