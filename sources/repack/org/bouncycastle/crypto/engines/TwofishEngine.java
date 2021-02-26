package repack.org.bouncycastle.crypto.engines;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.lowagie.text.DocWriter;
import com.lowagie.text.pdf.ByteBuffer;
import com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFData;
import repack.org.bouncycastle.crypto.BlockCipher;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.DataLengthException;
import repack.org.bouncycastle.crypto.params.KeyParameter;
import repack.org.bouncycastle.crypto.signers.PSSSigner;

public final class TwofishEngine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;
    private static final int GF256_FDBK = 361;
    private static final int GF256_FDBK_2 = 180;
    private static final int GF256_FDBK_4 = 90;
    private static final int INPUT_WHITEN = 0;
    private static final int MAX_KEY_BITS = 256;
    private static final int MAX_ROUNDS = 16;
    private static final int OUTPUT_WHITEN = 4;

    /* renamed from: P */
    private static final byte[][] f6127P;
    private static final int P_00 = 1;
    private static final int P_01 = 0;
    private static final int P_02 = 0;
    private static final int P_03 = 1;
    private static final int P_04 = 1;
    private static final int P_10 = 0;
    private static final int P_11 = 0;
    private static final int P_12 = 1;
    private static final int P_13 = 1;
    private static final int P_14 = 0;
    private static final int P_20 = 1;
    private static final int P_21 = 1;
    private static final int P_22 = 0;
    private static final int P_23 = 0;
    private static final int P_24 = 0;
    private static final int P_30 = 0;
    private static final int P_31 = 1;
    private static final int P_32 = 1;
    private static final int P_33 = 0;
    private static final int P_34 = 1;
    private static final int ROUNDS = 16;
    private static final int ROUND_SUBKEYS = 8;
    private static final int RS_GF_FDBK = 333;
    private static final int SK_BUMP = 16843009;
    private static final int SK_ROTL = 9;
    private static final int SK_STEP = 33686018;
    private static final int TOTAL_SUBKEYS = 40;
    private boolean encrypting = false;
    private int[] gMDS0 = new int[256];
    private int[] gMDS1 = new int[256];
    private int[] gMDS2 = new int[256];
    private int[] gMDS3 = new int[256];
    private int[] gSBox;
    private int[] gSubKeys;
    private int k64Cnt = 0;
    private byte[] workingKey = null;

    private int LFSR1(int i) {
        return ((i & 1) != 0 ? 180 : 0) ^ (i >> 1);
    }

    private int LFSR2(int i) {
        int i2 = 0;
        int i3 = (i >> 2) ^ ((i & 2) != 0 ? 180 : 0);
        if ((i & 1) != 0) {
            i2 = 90;
        }
        return i3 ^ i2;
    }

    private int RS_rem(int i) {
        int i2 = (i >>> 24) & 255;
        int i3 = 0;
        int i4 = ((i2 << 1) ^ ((i2 & 128) != 0 ? 333 : 0)) & 255;
        int i5 = i2 >>> 1;
        if ((i2 & 1) != 0) {
            i3 = 166;
        }
        int i6 = (i5 ^ i3) ^ i4;
        return ((((i << 8) ^ (i6 << 24)) ^ (i4 << 16)) ^ (i6 << 8)) ^ i2;
    }

    /* renamed from: b0 */
    private int m4822b0(int i) {
        return i & 255;
    }

    /* renamed from: b1 */
    private int m4823b1(int i) {
        return (i >>> 8) & 255;
    }

    /* renamed from: b2 */
    private int m4824b2(int i) {
        return (i >>> 16) & 255;
    }

    /* renamed from: b3 */
    private int m4825b3(int i) {
        return (i >>> 24) & 255;
    }

    public String getAlgorithmName() {
        return "Twofish";
    }

    public int getBlockSize() {
        return 16;
    }

    static {
        byte[] bArr = new byte[256];
        bArr[0] = -87;
        bArr[1] = 103;
        bArr[2] = -77;
        bArr[3] = -24;
        bArr[4] = 4;
        bArr[5] = -3;
        bArr[6] = -93;
        bArr[7] = 118;
        bArr[8] = -102;
        bArr[9] = -110;
        bArr[10] = Byte.MIN_VALUE;
        bArr[11] = 120;
        bArr[12] = -28;
        bArr[13] = -35;
        bArr[14] = -47;
        bArr[15] = 56;
        bArr[16] = 13;
        bArr[17] = -58;
        bArr[18] = 53;
        bArr[19] = -104;
        bArr[20] = Ascii.CAN;
        bArr[21] = -9;
        bArr[22] = -20;
        bArr[23] = 108;
        bArr[24] = 67;
        bArr[25] = 117;
        bArr[26] = 55;
        bArr[27] = 38;
        bArr[28] = -6;
        bArr[29] = 19;
        bArr[30] = -108;
        bArr[31] = 72;
        bArr[32] = -14;
        bArr[33] = -48;
        bArr[34] = -117;
        bArr[35] = ByteBuffer.ZERO;
        bArr[36] = -124;
        bArr[37] = 84;
        bArr[38] = -33;
        bArr[39] = 35;
        bArr[40] = Ascii.f264EM;
        bArr[41] = 91;
        bArr[42] = DocWriter.EQUALS;
        bArr[43] = 89;
        bArr[44] = -13;
        bArr[45] = -82;
        bArr[46] = -94;
        bArr[47] = -126;
        bArr[48] = 99;
        bArr[49] = 1;
        bArr[50] = -125;
        bArr[51] = 46;
        bArr[52] = -39;
        bArr[53] = 81;
        bArr[54] = -101;
        bArr[55] = 124;
        bArr[56] = -90;
        bArr[57] = -21;
        bArr[58] = -91;
        bArr[59] = -66;
        bArr[60] = 22;
        bArr[61] = 12;
        bArr[62] = -29;
        bArr[63] = 97;
        bArr[64] = -64;
        bArr[65] = -116;
        bArr[66] = 58;
        bArr[67] = -11;
        bArr[68] = 115;
        bArr[69] = 44;
        bArr[70] = 37;
        bArr[71] = 11;
        bArr[72] = -69;
        bArr[73] = 78;
        bArr[74] = -119;
        bArr[75] = 107;
        bArr[76] = 83;
        bArr[77] = 106;
        bArr[78] = -76;
        bArr[79] = -15;
        bArr[80] = -31;
        bArr[81] = -26;
        bArr[82] = -67;
        bArr[83] = 69;
        bArr[84] = -30;
        bArr[85] = -12;
        bArr[86] = -74;
        bArr[87] = 102;
        bArr[88] = -52;
        bArr[89] = -107;
        bArr[90] = 3;
        bArr[91] = 86;
        bArr[92] = -44;
        bArr[93] = Ascii.f266FS;
        bArr[94] = Ascii.f271RS;
        bArr[95] = -41;
        bArr[96] = -5;
        bArr[97] = -61;
        bArr[98] = -114;
        bArr[99] = -75;
        bArr[100] = -23;
        bArr[101] = -49;
        bArr[102] = -65;
        bArr[103] = -70;
        bArr[104] = -22;
        bArr[105] = 119;
        bArr[106] = 57;
        bArr[107] = -81;
        bArr[108] = 51;
        bArr[109] = -55;
        bArr[110] = 98;
        bArr[111] = 113;
        bArr[112] = -127;
        bArr[113] = 121;
        bArr[114] = 9;
        bArr[115] = -83;
        bArr[116] = 36;
        bArr[117] = -51;
        bArr[118] = -7;
        bArr[119] = -40;
        bArr[120] = -27;
        bArr[121] = -59;
        bArr[122] = -71;
        bArr[123] = 77;
        bArr[124] = 68;
        bArr[125] = 8;
        bArr[126] = -122;
        bArr[127] = -25;
        bArr[128] = -95;
        bArr[129] = Ascii.f267GS;
        bArr[130] = -86;
        bArr[131] = -19;
        bArr[132] = 6;
        bArr[133] = 112;
        bArr[134] = -78;
        bArr[135] = -46;
        bArr[136] = 65;
        bArr[137] = 123;
        bArr[138] = -96;
        bArr[139] = 17;
        bArr[140] = 49;
        bArr[141] = -62;
        bArr[142] = 39;
        bArr[143] = -112;
        bArr[144] = 32;
        bArr[145] = -10;
        bArr[146] = 96;
        bArr[147] = -1;
        bArr[148] = -106;
        bArr[149] = 92;
        bArr[150] = -79;
        bArr[151] = -85;
        bArr[152] = -98;
        bArr[153] = -100;
        bArr[154] = 82;
        bArr[155] = Ascii.ESC;
        bArr[156] = 95;
        bArr[157] = -109;
        bArr[158] = 10;
        bArr[159] = -17;
        bArr[160] = -111;
        bArr[161] = -123;
        bArr[162] = 73;
        bArr[163] = -18;
        bArr[164] = 45;
        bArr[165] = 79;
        bArr[166] = -113;
        bArr[167] = 59;
        bArr[168] = 71;
        bArr[169] = -121;
        bArr[170] = 109;
        bArr[171] = 70;
        bArr[172] = -42;
        bArr[173] = DocWriter.f569GT;
        bArr[174] = 105;
        bArr[175] = 100;
        bArr[176] = 42;
        bArr[177] = -50;
        bArr[178] = -53;
        bArr[179] = DocWriter.FORWARD;
        bArr[180] = -4;
        bArr[181] = -105;
        bArr[182] = 5;
        bArr[183] = 122;
        bArr[184] = -84;
        bArr[185] = Byte.MAX_VALUE;
        bArr[186] = -43;
        bArr[187] = Ascii.SUB;
        bArr[188] = 75;
        bArr[189] = 14;
        bArr[190] = -89;
        bArr[191] = 90;
        bArr[192] = 40;
        bArr[193] = 20;
        bArr[194] = 63;
        bArr[195] = 41;
        bArr[196] = -120;
        bArr[197] = DocWriter.f570LT;
        bArr[198] = 76;
        bArr[199] = 2;
        bArr[200] = -72;
        bArr[201] = -38;
        bArr[202] = -80;
        bArr[203] = Ascii.ETB;
        bArr[204] = 85;
        bArr[205] = Ascii.f275US;
        bArr[206] = -118;
        bArr[207] = 125;
        bArr[208] = 87;
        bArr[209] = -57;
        bArr[210] = -115;
        bArr[211] = 116;
        bArr[212] = -73;
        bArr[213] = -60;
        bArr[214] = -97;
        bArr[215] = 114;
        bArr[216] = 126;
        bArr[217] = Ascii.NAK;
        bArr[218] = 34;
        bArr[219] = 18;
        bArr[220] = 88;
        bArr[221] = 7;
        bArr[222] = -103;
        bArr[223] = 52;
        bArr[224] = 110;
        bArr[225] = 80;
        bArr[226] = -34;
        bArr[227] = 104;
        bArr[228] = 101;
        bArr[229] = PSSSigner.TRAILER_IMPLICIT;
        bArr[230] = -37;
        bArr[231] = -8;
        bArr[232] = -56;
        bArr[233] = -88;
        bArr[234] = 43;
        bArr[235] = SignedBytes.MAX_POWER_OF_TWO;
        bArr[236] = -36;
        bArr[237] = -2;
        bArr[238] = 50;
        bArr[239] = -92;
        bArr[240] = -54;
        bArr[241] = 16;
        bArr[242] = AMFData.DATA_TYPE_BYTEARRAY;
        bArr[243] = -16;
        bArr[244] = -45;
        bArr[245] = 93;
        bArr[246] = 15;
        bArr[248] = 111;
        bArr[249] = -99;
        bArr[250] = 54;
        bArr[251] = 66;
        bArr[252] = 74;
        bArr[253] = 94;
        bArr[254] = -63;
        bArr[255] = -32;
        byte[] bArr2 = new byte[256];
        bArr2[0] = 117;
        bArr2[1] = -13;
        bArr2[2] = -58;
        bArr2[3] = -12;
        bArr2[4] = -37;
        bArr2[5] = 123;
        bArr2[6] = -5;
        bArr2[7] = -56;
        bArr2[8] = 74;
        bArr2[9] = -45;
        bArr2[10] = -26;
        bArr2[11] = 107;
        bArr2[12] = 69;
        bArr2[13] = 125;
        bArr2[14] = -24;
        bArr2[15] = 75;
        bArr2[16] = -42;
        bArr2[17] = 50;
        bArr2[18] = -40;
        bArr2[19] = -3;
        bArr2[20] = 55;
        bArr2[21] = 113;
        bArr2[22] = -15;
        bArr2[23] = -31;
        bArr2[24] = ByteBuffer.ZERO;
        bArr2[25] = 15;
        bArr2[26] = -8;
        bArr2[27] = Ascii.ESC;
        bArr2[28] = -121;
        bArr2[29] = -6;
        bArr2[30] = 6;
        bArr2[31] = 63;
        bArr2[32] = 94;
        bArr2[33] = -70;
        bArr2[34] = -82;
        bArr2[35] = 91;
        bArr2[36] = -118;
        bArr2[38] = PSSSigner.TRAILER_IMPLICIT;
        bArr2[39] = -99;
        bArr2[40] = 109;
        bArr2[41] = -63;
        bArr2[42] = -79;
        bArr2[43] = 14;
        bArr2[44] = Byte.MIN_VALUE;
        bArr2[45] = 93;
        bArr2[46] = -46;
        bArr2[47] = -43;
        bArr2[48] = -96;
        bArr2[49] = -124;
        bArr2[50] = 7;
        bArr2[51] = 20;
        bArr2[52] = -75;
        bArr2[53] = -112;
        bArr2[54] = 44;
        bArr2[55] = -93;
        bArr2[56] = -78;
        bArr2[57] = 115;
        bArr2[58] = 76;
        bArr2[59] = 84;
        bArr2[60] = -110;
        bArr2[61] = 116;
        bArr2[62] = 54;
        bArr2[63] = 81;
        bArr2[64] = 56;
        bArr2[65] = -80;
        bArr2[66] = -67;
        bArr2[67] = 90;
        bArr2[68] = -4;
        bArr2[69] = 96;
        bArr2[70] = 98;
        bArr2[71] = -106;
        bArr2[72] = 108;
        bArr2[73] = 66;
        bArr2[74] = -9;
        bArr2[75] = 16;
        bArr2[76] = 124;
        bArr2[77] = 40;
        bArr2[78] = 39;
        bArr2[79] = -116;
        bArr2[80] = 19;
        bArr2[81] = -107;
        bArr2[82] = -100;
        bArr2[83] = -57;
        bArr2[84] = 36;
        bArr2[85] = 70;
        bArr2[86] = 59;
        bArr2[87] = 112;
        bArr2[88] = -54;
        bArr2[89] = -29;
        bArr2[90] = -123;
        bArr2[91] = -53;
        bArr2[92] = 17;
        bArr2[93] = -48;
        bArr2[94] = -109;
        bArr2[95] = -72;
        bArr2[96] = -90;
        bArr2[97] = -125;
        bArr2[98] = 32;
        bArr2[99] = -1;
        bArr2[100] = -97;
        bArr2[101] = 119;
        bArr2[102] = -61;
        bArr2[103] = -52;
        bArr2[104] = 3;
        bArr2[105] = 111;
        bArr2[106] = 8;
        bArr2[107] = -65;
        bArr2[108] = SignedBytes.MAX_POWER_OF_TWO;
        bArr2[109] = -25;
        bArr2[110] = 43;
        bArr2[111] = -30;
        bArr2[112] = 121;
        bArr2[113] = 12;
        bArr2[114] = -86;
        bArr2[115] = -126;
        bArr2[116] = 65;
        bArr2[117] = 58;
        bArr2[118] = -22;
        bArr2[119] = -71;
        bArr2[120] = -28;
        bArr2[121] = -102;
        bArr2[122] = -92;
        bArr2[123] = -105;
        bArr2[124] = 126;
        bArr2[125] = -38;
        bArr2[126] = 122;
        bArr2[127] = Ascii.ETB;
        bArr2[128] = 102;
        bArr2[129] = -108;
        bArr2[130] = -95;
        bArr2[131] = Ascii.f267GS;
        bArr2[132] = DocWriter.EQUALS;
        bArr2[133] = -16;
        bArr2[134] = -34;
        bArr2[135] = -77;
        bArr2[136] = 11;
        bArr2[137] = 114;
        bArr2[138] = -89;
        bArr2[139] = Ascii.f266FS;
        bArr2[140] = -17;
        bArr2[141] = -47;
        bArr2[142] = 83;
        bArr2[143] = DocWriter.f569GT;
        bArr2[144] = -113;
        bArr2[145] = 51;
        bArr2[146] = 38;
        bArr2[147] = 95;
        bArr2[148] = -20;
        bArr2[149] = 118;
        bArr2[150] = 42;
        bArr2[151] = 73;
        bArr2[152] = -127;
        bArr2[153] = -120;
        bArr2[154] = -18;
        bArr2[155] = AMFData.DATA_TYPE_BYTEARRAY;
        bArr2[156] = -60;
        bArr2[157] = Ascii.SUB;
        bArr2[158] = -21;
        bArr2[159] = -39;
        bArr2[160] = -59;
        bArr2[161] = 57;
        bArr2[162] = -103;
        bArr2[163] = -51;
        bArr2[164] = -83;
        bArr2[165] = 49;
        bArr2[166] = -117;
        bArr2[167] = 1;
        bArr2[168] = Ascii.CAN;
        bArr2[169] = 35;
        bArr2[170] = -35;
        bArr2[171] = Ascii.f275US;
        bArr2[172] = 78;
        bArr2[173] = 45;
        bArr2[174] = -7;
        bArr2[175] = 72;
        bArr2[176] = 79;
        bArr2[177] = -14;
        bArr2[178] = 101;
        bArr2[179] = -114;
        bArr2[180] = 120;
        bArr2[181] = 92;
        bArr2[182] = 88;
        bArr2[183] = Ascii.f264EM;
        bArr2[184] = -115;
        bArr2[185] = -27;
        bArr2[186] = -104;
        bArr2[187] = 87;
        bArr2[188] = 103;
        bArr2[189] = Byte.MAX_VALUE;
        bArr2[190] = 5;
        bArr2[191] = 100;
        bArr2[192] = -81;
        bArr2[193] = 99;
        bArr2[194] = -74;
        bArr2[195] = -2;
        bArr2[196] = -11;
        bArr2[197] = -73;
        bArr2[198] = DocWriter.f570LT;
        bArr2[199] = -91;
        bArr2[200] = -50;
        bArr2[201] = -23;
        bArr2[202] = 104;
        bArr2[203] = 68;
        bArr2[204] = -32;
        bArr2[205] = 77;
        bArr2[206] = 67;
        bArr2[207] = 105;
        bArr2[208] = 41;
        bArr2[209] = 46;
        bArr2[210] = -84;
        bArr2[211] = Ascii.NAK;
        bArr2[212] = 89;
        bArr2[213] = -88;
        bArr2[214] = 10;
        bArr2[215] = -98;
        bArr2[216] = 110;
        bArr2[217] = 71;
        bArr2[218] = -33;
        bArr2[219] = 52;
        bArr2[220] = 53;
        bArr2[221] = 106;
        bArr2[222] = -49;
        bArr2[223] = -36;
        bArr2[224] = 34;
        bArr2[225] = -55;
        bArr2[226] = -64;
        bArr2[227] = -101;
        bArr2[228] = -119;
        bArr2[229] = -44;
        bArr2[230] = -19;
        bArr2[231] = -85;
        bArr2[232] = 18;
        bArr2[233] = -94;
        bArr2[234] = 13;
        bArr2[235] = 82;
        bArr2[236] = -69;
        bArr2[237] = 2;
        bArr2[238] = DocWriter.FORWARD;
        bArr2[239] = -87;
        bArr2[240] = -41;
        bArr2[241] = 97;
        bArr2[242] = Ascii.f271RS;
        bArr2[243] = -76;
        bArr2[244] = 80;
        bArr2[245] = 4;
        bArr2[246] = -10;
        bArr2[247] = -62;
        bArr2[248] = 22;
        bArr2[249] = 37;
        bArr2[250] = -122;
        bArr2[251] = 86;
        bArr2[252] = 85;
        bArr2[253] = 9;
        bArr2[254] = -66;
        bArr2[255] = -111;
        f6127P = new byte[][]{bArr, bArr2};
    }

    public TwofishEngine() {
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        int[] iArr3 = new int[2];
        for (int i = 0; i < 256; i++) {
            int i2 = f6127P[0][i] & 255;
            iArr[0] = i2;
            iArr2[0] = Mx_X(i2) & 255;
            iArr3[0] = Mx_Y(i2) & 255;
            int i3 = f6127P[1][i] & 255;
            iArr[1] = i3;
            iArr2[1] = Mx_X(i3) & 255;
            iArr3[1] = Mx_Y(i3) & 255;
            this.gMDS0[i] = iArr[1] | (iArr2[1] << 8) | (iArr3[1] << 16) | (iArr3[1] << 24);
            this.gMDS1[i] = iArr3[0] | (iArr3[0] << 8) | (iArr2[0] << 16) | (iArr[0] << 24);
            this.gMDS2[i] = (iArr3[1] << 24) | iArr2[1] | (iArr3[1] << 8) | (iArr[1] << 16);
            this.gMDS3[i] = iArr2[0] | (iArr[0] << 8) | (iArr3[0] << 16) | (iArr2[0] << 24);
        }
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.encrypting = z;
            this.workingKey = ((KeyParameter) cipherParameters).getKey();
            byte[] bArr = this.workingKey;
            this.k64Cnt = bArr.length / 8;
            setKey(bArr);
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to Twofish init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.workingKey == null) {
            throw new IllegalStateException("Twofish not initialised");
        } else if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 16 > bArr2.length) {
            throw new DataLengthException("output buffer too short");
        } else if (this.encrypting) {
            encryptBlock(bArr, i, bArr2, i2);
            return 16;
        } else {
            decryptBlock(bArr, i, bArr2, i2);
            return 16;
        }
    }

    public void reset() {
        byte[] bArr = this.workingKey;
        if (bArr != null) {
            setKey(bArr);
        }
    }

    private void setKey(byte[] bArr) {
        byte b;
        byte b2;
        byte b3;
        byte b4;
        byte b5;
        byte b6;
        byte b7;
        byte b8;
        byte[] bArr2 = bArr;
        int[] iArr = new int[4];
        int[] iArr2 = new int[4];
        int[] iArr3 = new int[4];
        this.gSubKeys = new int[40];
        int i = this.k64Cnt;
        if (i < 1) {
            throw new IllegalArgumentException("Key size less than 64 bits");
        } else if (i <= 4) {
            for (int i2 = 0; i2 < this.k64Cnt; i2++) {
                int i3 = i2 * 8;
                iArr[i2] = BytesTo32Bits(bArr2, i3);
                iArr2[i2] = BytesTo32Bits(bArr2, i3 + 4);
                iArr3[(this.k64Cnt - 1) - i2] = RS_MDS_Encode(iArr[i2], iArr2[i2]);
            }
            for (int i4 = 0; i4 < 20; i4++) {
                int i5 = SK_STEP * i4;
                int F32 = F32(i5, iArr);
                int F322 = F32(i5 + SK_BUMP, iArr2);
                int i6 = (F322 >>> 24) | (F322 << 8);
                int i7 = F32 + i6;
                int[] iArr4 = this.gSubKeys;
                int i8 = i4 * 2;
                iArr4[i8] = i7;
                int i9 = i7 + i6;
                iArr4[i8 + 1] = (i9 << 9) | (i9 >>> 23);
            }
            int i10 = iArr3[0];
            int i11 = iArr3[1];
            int i12 = 2;
            int i13 = iArr3[2];
            int i14 = iArr3[3];
            this.gSBox = new int[1024];
            int i15 = 0;
            while (i15 < 256) {
                int i16 = this.k64Cnt & 3;
                if (i16 != 0) {
                    if (i16 == 1) {
                        int i17 = i15 * 2;
                        this.gSBox[i17] = this.gMDS0[(f6127P[0][i15] & 255) ^ m4822b0(i10)];
                        this.gSBox[i17 + 1] = this.gMDS1[(f6127P[0][i15] & 255) ^ m4823b1(i10)];
                        this.gSBox[i17 + 512] = this.gMDS2[(f6127P[1][i15] & 255) ^ m4824b2(i10)];
                        this.gSBox[i17 + 513] = this.gMDS3[(f6127P[1][i15] & 255) ^ m4825b3(i10)];
                    } else if (i16 == i12) {
                        b4 = i15;
                        b3 = b4;
                        b2 = b3;
                        b = b2;
                        int[] iArr5 = this.gSBox;
                        int i18 = i15 * 2;
                        int[] iArr6 = this.gMDS0;
                        byte[][] bArr3 = f6127P;
                        iArr5[i18] = iArr6[(bArr3[0][(bArr3[0][b4] & 255) ^ m4822b0(i11)] & 255) ^ m4822b0(i10)];
                        int[] iArr7 = this.gMDS1;
                        byte[][] bArr4 = f6127P;
                        this.gSBox[i18 + 1] = iArr7[(bArr4[0][(bArr4[1][b3] & 255) ^ m4823b1(i11)] & 255) ^ m4823b1(i10)];
                        int[] iArr8 = this.gMDS2;
                        byte[][] bArr5 = f6127P;
                        this.gSBox[i18 + 512] = iArr8[(bArr5[1][(bArr5[0][b2] & 255) ^ m4824b2(i11)] & 255) ^ m4824b2(i10)];
                        int[] iArr9 = this.gMDS3;
                        byte[][] bArr6 = f6127P;
                        this.gSBox[i18 + 513] = iArr9[(bArr6[1][(bArr6[1][b] & 255) ^ m4825b3(i11)] & 255) ^ m4825b3(i10)];
                    } else if (i16 == 3) {
                        b8 = i15;
                        b7 = b8;
                        b6 = b7;
                        b5 = b6;
                    }
                    i15++;
                    i12 = 2;
                } else {
                    b8 = (f6127P[1][i15] & 255) ^ m4822b0(i14);
                    b7 = (f6127P[0][i15] & 255) ^ m4823b1(i14);
                    b6 = (f6127P[0][i15] & 255) ^ m4824b2(i14);
                    b5 = (f6127P[1][i15] & 255) ^ m4825b3(i14);
                }
                b4 = (f6127P[1][b8] & 255) ^ m4822b0(i13);
                b3 = (f6127P[1][b7] & 255) ^ m4823b1(i13);
                b2 = (f6127P[0][b6] & 255) ^ m4824b2(i13);
                b = (f6127P[0][b5] & 255) ^ m4825b3(i13);
                int[] iArr52 = this.gSBox;
                int i182 = i15 * 2;
                int[] iArr62 = this.gMDS0;
                byte[][] bArr32 = f6127P;
                iArr52[i182] = iArr62[(bArr32[0][(bArr32[0][b4] & 255) ^ m4822b0(i11)] & 255) ^ m4822b0(i10)];
                int[] iArr72 = this.gMDS1;
                byte[][] bArr42 = f6127P;
                this.gSBox[i182 + 1] = iArr72[(bArr42[0][(bArr42[1][b3] & 255) ^ m4823b1(i11)] & 255) ^ m4823b1(i10)];
                int[] iArr82 = this.gMDS2;
                byte[][] bArr52 = f6127P;
                this.gSBox[i182 + 512] = iArr82[(bArr52[1][(bArr52[0][b2] & 255) ^ m4824b2(i11)] & 255) ^ m4824b2(i10)];
                int[] iArr92 = this.gMDS3;
                byte[][] bArr62 = f6127P;
                this.gSBox[i182 + 513] = iArr92[(bArr62[1][(bArr62[1][b] & 255) ^ m4825b3(i11)] & 255) ^ m4825b3(i10)];
                i15++;
                i12 = 2;
            }
        } else {
            throw new IllegalArgumentException("Key size larger than 256 bits");
        }
    }

    private void encryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = 0;
        int BytesTo32Bits = BytesTo32Bits(bArr, i) ^ this.gSubKeys[0];
        int BytesTo32Bits2 = BytesTo32Bits(bArr, i + 4) ^ this.gSubKeys[1];
        int BytesTo32Bits3 = BytesTo32Bits(bArr, i + 8) ^ this.gSubKeys[2];
        int BytesTo32Bits4 = BytesTo32Bits(bArr, i + 12) ^ this.gSubKeys[3];
        int i4 = 8;
        while (i3 < 16) {
            int Fe32_0 = Fe32_0(BytesTo32Bits);
            int Fe32_3 = Fe32_3(BytesTo32Bits2);
            int[] iArr = this.gSubKeys;
            int i5 = i4 + 1;
            int i6 = BytesTo32Bits3 ^ ((Fe32_0 + Fe32_3) + iArr[i4]);
            BytesTo32Bits3 = (i6 >>> 1) | (i6 << 31);
            int i7 = (BytesTo32Bits4 >>> 31) | (BytesTo32Bits4 << 1);
            int i8 = i5 + 1;
            BytesTo32Bits4 = i7 ^ ((Fe32_0 + (Fe32_3 * 2)) + iArr[i5]);
            int Fe32_02 = Fe32_0(BytesTo32Bits3);
            int Fe32_32 = Fe32_3(BytesTo32Bits4);
            int[] iArr2 = this.gSubKeys;
            int i9 = i8 + 1;
            int i10 = BytesTo32Bits ^ ((Fe32_02 + Fe32_32) + iArr2[i8]);
            BytesTo32Bits = (i10 >>> 1) | (i10 << 31);
            i3 += 2;
            BytesTo32Bits2 = ((BytesTo32Bits2 << 1) | (BytesTo32Bits2 >>> 31)) ^ ((Fe32_02 + (Fe32_32 * 2)) + iArr2[i9]);
            i4 = i9 + 1;
        }
        Bits32ToBytes(this.gSubKeys[4] ^ BytesTo32Bits3, bArr2, i2);
        Bits32ToBytes(BytesTo32Bits4 ^ this.gSubKeys[5], bArr2, i2 + 4);
        Bits32ToBytes(this.gSubKeys[6] ^ BytesTo32Bits, bArr2, i2 + 8);
        Bits32ToBytes(this.gSubKeys[7] ^ BytesTo32Bits2, bArr2, i2 + 12);
    }

    private void decryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int BytesTo32Bits = BytesTo32Bits(bArr, i) ^ this.gSubKeys[4];
        int BytesTo32Bits2 = BytesTo32Bits(bArr, i + 4) ^ this.gSubKeys[5];
        int i3 = 39;
        int BytesTo32Bits3 = BytesTo32Bits(bArr, i + 8) ^ this.gSubKeys[6];
        int BytesTo32Bits4 = BytesTo32Bits(bArr, i + 12) ^ this.gSubKeys[7];
        int i4 = 0;
        while (i4 < 16) {
            int Fe32_0 = Fe32_0(BytesTo32Bits);
            int Fe32_3 = Fe32_3(BytesTo32Bits2);
            int[] iArr = this.gSubKeys;
            int i5 = i3 - 1;
            int i6 = BytesTo32Bits4 ^ (((Fe32_3 * 2) + Fe32_0) + iArr[i3]);
            int i7 = (BytesTo32Bits3 << 1) | (BytesTo32Bits3 >>> 31);
            int i8 = i5 - 1;
            int i9 = i7 ^ ((Fe32_0 + Fe32_3) + iArr[i5]);
            BytesTo32Bits4 = (i6 << 31) | (i6 >>> 1);
            int Fe32_02 = Fe32_0(i9);
            int Fe32_32 = Fe32_3(BytesTo32Bits4);
            int[] iArr2 = this.gSubKeys;
            int i10 = i8 - 1;
            int i11 = BytesTo32Bits2 ^ (((Fe32_32 * 2) + Fe32_02) + iArr2[i8]);
            BytesTo32Bits = ((BytesTo32Bits >>> 31) | (BytesTo32Bits << 1)) ^ ((Fe32_02 + Fe32_32) + iArr2[i10]);
            BytesTo32Bits2 = (i11 << 31) | (i11 >>> 1);
            i4 += 2;
            BytesTo32Bits3 = i9;
            i3 = i10 - 1;
        }
        Bits32ToBytes(this.gSubKeys[0] ^ BytesTo32Bits3, bArr2, i2);
        Bits32ToBytes(this.gSubKeys[1] ^ BytesTo32Bits4, bArr2, i2 + 4);
        Bits32ToBytes(this.gSubKeys[2] ^ BytesTo32Bits, bArr2, i2 + 8);
        Bits32ToBytes(this.gSubKeys[3] ^ BytesTo32Bits2, bArr2, i2 + 12);
    }

    private int F32(int i, int[] iArr) {
        int i2;
        int i3;
        int b0 = m4822b0(i);
        int b1 = m4823b1(i);
        int b2 = m4824b2(i);
        int b3 = m4825b3(i);
        int i4 = iArr[0];
        int i5 = iArr[1];
        int i6 = iArr[2];
        int i7 = iArr[3];
        int i8 = this.k64Cnt & 3;
        if (i8 == 0) {
            b0 = (f6127P[1][b0] & 255) ^ m4822b0(i7);
            b1 = (f6127P[0][b1] & 255) ^ m4823b1(i7);
            b2 = (f6127P[0][b2] & 255) ^ m4824b2(i7);
            b3 = (f6127P[1][b3] & 255) ^ m4825b3(i7);
        } else if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    return 0;
                }
            }
            int[] iArr2 = this.gMDS0;
            byte[][] bArr = f6127P;
            int i9 = iArr2[(bArr[0][(bArr[0][b0] & 255) ^ m4822b0(i5)] & 255) ^ m4822b0(i4)];
            int[] iArr3 = this.gMDS1;
            byte[][] bArr2 = f6127P;
            int i10 = i9 ^ iArr3[(bArr2[0][(bArr2[1][b1] & 255) ^ m4823b1(i5)] & 255) ^ m4823b1(i4)];
            int[] iArr4 = this.gMDS2;
            byte[][] bArr3 = f6127P;
            i2 = i10 ^ iArr4[(bArr3[1][(bArr3[0][b2] & 255) ^ m4824b2(i5)] & 255) ^ m4824b2(i4)];
            int[] iArr5 = this.gMDS3;
            byte[][] bArr4 = f6127P;
            i3 = iArr5[(bArr4[1][(bArr4[1][b3] & 255) ^ m4825b3(i5)] & 255) ^ m4825b3(i4)];
            return i2 ^ i3;
        } else {
            i2 = (this.gMDS0[(f6127P[0][b0] & 255) ^ m4822b0(i4)] ^ this.gMDS1[(f6127P[0][b1] & 255) ^ m4823b1(i4)]) ^ this.gMDS2[(f6127P[1][b2] & 255) ^ m4824b2(i4)];
            i3 = this.gMDS3[(f6127P[1][b3] & 255) ^ m4825b3(i4)];
            return i2 ^ i3;
        }
        b0 = m4822b0(i6) ^ (f6127P[1][b0] & 255);
        b1 = m4823b1(i6) ^ (f6127P[1][b1] & 255);
        b2 = m4824b2(i6) ^ (f6127P[0][b2] & 255);
        b3 = (f6127P[0][b3] & 255) ^ m4825b3(i6);
        int[] iArr22 = this.gMDS0;
        byte[][] bArr5 = f6127P;
        int i92 = iArr22[(bArr5[0][(bArr5[0][b0] & 255) ^ m4822b0(i5)] & 255) ^ m4822b0(i4)];
        int[] iArr32 = this.gMDS1;
        byte[][] bArr22 = f6127P;
        int i102 = i92 ^ iArr32[(bArr22[0][(bArr22[1][b1] & 255) ^ m4823b1(i5)] & 255) ^ m4823b1(i4)];
        int[] iArr42 = this.gMDS2;
        byte[][] bArr32 = f6127P;
        i2 = i102 ^ iArr42[(bArr32[1][(bArr32[0][b2] & 255) ^ m4824b2(i5)] & 255) ^ m4824b2(i4)];
        int[] iArr52 = this.gMDS3;
        byte[][] bArr42 = f6127P;
        i3 = iArr52[(bArr42[1][(bArr42[1][b3] & 255) ^ m4825b3(i5)] & 255) ^ m4825b3(i4)];
        return i2 ^ i3;
    }

    private int RS_MDS_Encode(int i, int i2) {
        int i3 = i2;
        for (int i4 = 0; i4 < 4; i4++) {
            i3 = RS_rem(i3);
        }
        int i5 = i ^ i3;
        for (int i6 = 0; i6 < 4; i6++) {
            i5 = RS_rem(i5);
        }
        return i5;
    }

    private int Mx_X(int i) {
        return i ^ LFSR2(i);
    }

    private int Mx_Y(int i) {
        return LFSR2(i) ^ (LFSR1(i) ^ i);
    }

    private int Fe32_0(int i) {
        int[] iArr = this.gSBox;
        return iArr[(((i >>> 24) & 255) * 2) + 513] ^ ((iArr[((i & 255) * 2) + 0] ^ iArr[(((i >>> 8) & 255) * 2) + 1]) ^ iArr[(((i >>> 16) & 255) * 2) + 512]);
    }

    private int Fe32_3(int i) {
        int[] iArr = this.gSBox;
        return iArr[(((i >>> 16) & 255) * 2) + 513] ^ ((iArr[(((i >>> 24) & 255) * 2) + 0] ^ iArr[((i & 255) * 2) + 1]) ^ iArr[(((i >>> 8) & 255) * 2) + 512]);
    }

    private int BytesTo32Bits(byte[] bArr, int i) {
        return ((bArr[i + 3] & 255) << Ascii.CAN) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private void Bits32ToBytes(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) i;
        bArr[i2 + 1] = (byte) (i >> 8);
        bArr[i2 + 2] = (byte) (i >> 16);
        bArr[i2 + 3] = (byte) (i >> 24);
    }
}
