package repack.org.bouncycastle.crypto.engines;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.lowagie.text.DocWriter;
import com.lowagie.text.pdf.ByteBuffer;
import com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFData;
import java.lang.reflect.Array;
import repack.org.bouncycastle.crypto.BlockCipher;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.DataLengthException;
import repack.org.bouncycastle.crypto.params.KeyParameter;
import repack.org.bouncycastle.crypto.signers.PSSSigner;
import repack.org.bouncycastle.crypto.tls.CipherSuite;

public class AESLightEngine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;

    /* renamed from: S */
    private static final byte[] f6064S;

    /* renamed from: Si */
    private static final byte[] f6065Si;

    /* renamed from: m1 */
    private static final int f6066m1 = -2139062144;

    /* renamed from: m2 */
    private static final int f6067m2 = 2139062143;

    /* renamed from: m3 */
    private static final int f6068m3 = 27;
    private static final int[] rcon = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, 171, 77, 154, 47, 94, 188, 99, 198, 151, 53, 106, 212, 179, 125, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, 239, 197, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA};

    /* renamed from: C0 */
    private int f6069C0;

    /* renamed from: C1 */
    private int f6070C1;

    /* renamed from: C2 */
    private int f6071C2;

    /* renamed from: C3 */
    private int f6072C3;
    private int ROUNDS;
    private int[][] WorkingKey = null;
    private boolean forEncryption;

    private int FFmulX(int i) {
        return (((i & f6066m1) >>> 7) * 27) ^ ((f6067m2 & i) << 1);
    }

    private int shift(int i, int i2) {
        return (i << (-i2)) | (i >>> i2);
    }

    public String getAlgorithmName() {
        return "AES";
    }

    public int getBlockSize() {
        return 16;
    }

    public void reset() {
    }

    static {
        byte[] bArr = new byte[256];
        bArr[0] = 99;
        bArr[1] = 124;
        bArr[2] = 119;
        bArr[3] = 123;
        bArr[4] = -14;
        bArr[5] = 107;
        bArr[6] = 111;
        bArr[7] = -59;
        bArr[8] = ByteBuffer.ZERO;
        bArr[9] = 1;
        bArr[10] = 103;
        bArr[11] = 43;
        bArr[12] = -2;
        bArr[13] = -41;
        bArr[14] = -85;
        bArr[15] = 118;
        bArr[16] = -54;
        bArr[17] = -126;
        bArr[18] = -55;
        bArr[19] = 125;
        bArr[20] = -6;
        bArr[21] = 89;
        bArr[22] = 71;
        bArr[23] = -16;
        bArr[24] = -83;
        bArr[25] = -44;
        bArr[26] = -94;
        bArr[27] = -81;
        bArr[28] = -100;
        bArr[29] = -92;
        bArr[30] = 114;
        bArr[31] = -64;
        bArr[32] = -73;
        bArr[33] = -3;
        bArr[34] = -109;
        bArr[35] = 38;
        bArr[36] = 54;
        bArr[37] = 63;
        bArr[38] = -9;
        bArr[39] = -52;
        bArr[40] = 52;
        bArr[41] = -91;
        bArr[42] = -27;
        bArr[43] = -15;
        bArr[44] = 113;
        bArr[45] = -40;
        bArr[46] = 49;
        bArr[47] = Ascii.NAK;
        bArr[48] = 4;
        bArr[49] = -57;
        bArr[50] = 35;
        bArr[51] = -61;
        bArr[52] = Ascii.CAN;
        bArr[53] = -106;
        bArr[54] = 5;
        bArr[55] = -102;
        bArr[56] = 7;
        bArr[57] = 18;
        bArr[58] = Byte.MIN_VALUE;
        bArr[59] = -30;
        bArr[60] = -21;
        bArr[61] = 39;
        bArr[62] = -78;
        bArr[63] = 117;
        bArr[64] = 9;
        bArr[65] = -125;
        bArr[66] = 44;
        bArr[67] = Ascii.SUB;
        bArr[68] = Ascii.ESC;
        bArr[69] = 110;
        bArr[70] = 90;
        bArr[71] = -96;
        bArr[72] = 82;
        bArr[73] = 59;
        bArr[74] = -42;
        bArr[75] = -77;
        bArr[76] = 41;
        bArr[77] = -29;
        bArr[78] = DocWriter.FORWARD;
        bArr[79] = -124;
        bArr[80] = 83;
        bArr[81] = -47;
        bArr[83] = -19;
        bArr[84] = 32;
        bArr[85] = -4;
        bArr[86] = -79;
        bArr[87] = 91;
        bArr[88] = 106;
        bArr[89] = -53;
        bArr[90] = -66;
        bArr[91] = 57;
        bArr[92] = 74;
        bArr[93] = 76;
        bArr[94] = 88;
        bArr[95] = -49;
        bArr[96] = -48;
        bArr[97] = -17;
        bArr[98] = -86;
        bArr[99] = -5;
        bArr[100] = 67;
        bArr[101] = 77;
        bArr[102] = 51;
        bArr[103] = -123;
        bArr[104] = 69;
        bArr[105] = -7;
        bArr[106] = 2;
        bArr[107] = Byte.MAX_VALUE;
        bArr[108] = 80;
        bArr[109] = DocWriter.f570LT;
        bArr[110] = -97;
        bArr[111] = -88;
        bArr[112] = 81;
        bArr[113] = -93;
        bArr[114] = SignedBytes.MAX_POWER_OF_TWO;
        bArr[115] = -113;
        bArr[116] = -110;
        bArr[117] = -99;
        bArr[118] = 56;
        bArr[119] = -11;
        bArr[120] = PSSSigner.TRAILER_IMPLICIT;
        bArr[121] = -74;
        bArr[122] = -38;
        bArr[123] = AMFData.DATA_TYPE_BYTEARRAY;
        bArr[124] = 16;
        bArr[125] = -1;
        bArr[126] = -13;
        bArr[127] = -46;
        bArr[128] = -51;
        bArr[129] = 12;
        bArr[130] = 19;
        bArr[131] = -20;
        bArr[132] = 95;
        bArr[133] = -105;
        bArr[134] = 68;
        bArr[135] = Ascii.ETB;
        bArr[136] = -60;
        bArr[137] = -89;
        bArr[138] = 126;
        bArr[139] = DocWriter.EQUALS;
        bArr[140] = 100;
        bArr[141] = 93;
        bArr[142] = Ascii.f264EM;
        bArr[143] = 115;
        bArr[144] = 96;
        bArr[145] = -127;
        bArr[146] = 79;
        bArr[147] = -36;
        bArr[148] = 34;
        bArr[149] = 42;
        bArr[150] = -112;
        bArr[151] = -120;
        bArr[152] = 70;
        bArr[153] = -18;
        bArr[154] = -72;
        bArr[155] = 20;
        bArr[156] = -34;
        bArr[157] = 94;
        bArr[158] = 11;
        bArr[159] = -37;
        bArr[160] = -32;
        bArr[161] = 50;
        bArr[162] = 58;
        bArr[163] = 10;
        bArr[164] = 73;
        bArr[165] = 6;
        bArr[166] = 36;
        bArr[167] = 92;
        bArr[168] = -62;
        bArr[169] = -45;
        bArr[170] = -84;
        bArr[171] = 98;
        bArr[172] = -111;
        bArr[173] = -107;
        bArr[174] = -28;
        bArr[175] = 121;
        bArr[176] = -25;
        bArr[177] = -56;
        bArr[178] = 55;
        bArr[179] = 109;
        bArr[180] = -115;
        bArr[181] = -43;
        bArr[182] = 78;
        bArr[183] = -87;
        bArr[184] = 108;
        bArr[185] = 86;
        bArr[186] = -12;
        bArr[187] = -22;
        bArr[188] = 101;
        bArr[189] = 122;
        bArr[190] = -82;
        bArr[191] = 8;
        bArr[192] = -70;
        bArr[193] = 120;
        bArr[194] = 37;
        bArr[195] = 46;
        bArr[196] = Ascii.f266FS;
        bArr[197] = -90;
        bArr[198] = -76;
        bArr[199] = -58;
        bArr[200] = -24;
        bArr[201] = -35;
        bArr[202] = 116;
        bArr[203] = Ascii.f275US;
        bArr[204] = 75;
        bArr[205] = -67;
        bArr[206] = -117;
        bArr[207] = -118;
        bArr[208] = 112;
        bArr[209] = DocWriter.f569GT;
        bArr[210] = -75;
        bArr[211] = 102;
        bArr[212] = 72;
        bArr[213] = 3;
        bArr[214] = -10;
        bArr[215] = 14;
        bArr[216] = 97;
        bArr[217] = 53;
        bArr[218] = 87;
        bArr[219] = -71;
        bArr[220] = -122;
        bArr[221] = -63;
        bArr[222] = Ascii.f267GS;
        bArr[223] = -98;
        bArr[224] = -31;
        bArr[225] = -8;
        bArr[226] = -104;
        bArr[227] = 17;
        bArr[228] = 105;
        bArr[229] = -39;
        bArr[230] = -114;
        bArr[231] = -108;
        bArr[232] = -101;
        bArr[233] = Ascii.f271RS;
        bArr[234] = -121;
        bArr[235] = -23;
        bArr[236] = -50;
        bArr[237] = 85;
        bArr[238] = 40;
        bArr[239] = -33;
        bArr[240] = -116;
        bArr[241] = -95;
        bArr[242] = -119;
        bArr[243] = 13;
        bArr[244] = -65;
        bArr[245] = -26;
        bArr[246] = 66;
        bArr[247] = 104;
        bArr[248] = 65;
        bArr[249] = -103;
        bArr[250] = 45;
        bArr[251] = 15;
        bArr[252] = -80;
        bArr[253] = 84;
        bArr[254] = -69;
        bArr[255] = 22;
        f6064S = bArr;
        byte[] bArr2 = new byte[256];
        bArr2[0] = 82;
        bArr2[1] = 9;
        bArr2[2] = 106;
        bArr2[3] = -43;
        bArr2[4] = ByteBuffer.ZERO;
        bArr2[5] = 54;
        bArr2[6] = -91;
        bArr2[7] = 56;
        bArr2[8] = -65;
        bArr2[9] = SignedBytes.MAX_POWER_OF_TWO;
        bArr2[10] = -93;
        bArr2[11] = -98;
        bArr2[12] = -127;
        bArr2[13] = -13;
        bArr2[14] = -41;
        bArr2[15] = -5;
        bArr2[16] = 124;
        bArr2[17] = -29;
        bArr2[18] = 57;
        bArr2[19] = -126;
        bArr2[20] = -101;
        bArr2[21] = DocWriter.FORWARD;
        bArr2[22] = -1;
        bArr2[23] = -121;
        bArr2[24] = 52;
        bArr2[25] = -114;
        bArr2[26] = 67;
        bArr2[27] = 68;
        bArr2[28] = -60;
        bArr2[29] = -34;
        bArr2[30] = -23;
        bArr2[31] = -53;
        bArr2[32] = 84;
        bArr2[33] = 123;
        bArr2[34] = -108;
        bArr2[35] = 50;
        bArr2[36] = -90;
        bArr2[37] = -62;
        bArr2[38] = 35;
        bArr2[39] = DocWriter.EQUALS;
        bArr2[40] = -18;
        bArr2[41] = 76;
        bArr2[42] = -107;
        bArr2[43] = 11;
        bArr2[44] = 66;
        bArr2[45] = -6;
        bArr2[46] = -61;
        bArr2[47] = 78;
        bArr2[48] = 8;
        bArr2[49] = 46;
        bArr2[50] = -95;
        bArr2[51] = 102;
        bArr2[52] = 40;
        bArr2[53] = -39;
        bArr2[54] = 36;
        bArr2[55] = -78;
        bArr2[56] = 118;
        bArr2[57] = 91;
        bArr2[58] = -94;
        bArr2[59] = 73;
        bArr2[60] = 109;
        bArr2[61] = -117;
        bArr2[62] = -47;
        bArr2[63] = 37;
        bArr2[64] = 114;
        bArr2[65] = -8;
        bArr2[66] = -10;
        bArr2[67] = 100;
        bArr2[68] = -122;
        bArr2[69] = 104;
        bArr2[70] = -104;
        bArr2[71] = 22;
        bArr2[72] = -44;
        bArr2[73] = -92;
        bArr2[74] = 92;
        bArr2[75] = -52;
        bArr2[76] = 93;
        bArr2[77] = 101;
        bArr2[78] = -74;
        bArr2[79] = -110;
        bArr2[80] = 108;
        bArr2[81] = 112;
        bArr2[82] = 72;
        bArr2[83] = 80;
        bArr2[84] = -3;
        bArr2[85] = -19;
        bArr2[86] = -71;
        bArr2[87] = -38;
        bArr2[88] = 94;
        bArr2[89] = Ascii.NAK;
        bArr2[90] = 70;
        bArr2[91] = 87;
        bArr2[92] = -89;
        bArr2[93] = -115;
        bArr2[94] = -99;
        bArr2[95] = -124;
        bArr2[96] = -112;
        bArr2[97] = -40;
        bArr2[98] = -85;
        bArr2[100] = -116;
        bArr2[101] = PSSSigner.TRAILER_IMPLICIT;
        bArr2[102] = -45;
        bArr2[103] = 10;
        bArr2[104] = -9;
        bArr2[105] = -28;
        bArr2[106] = 88;
        bArr2[107] = 5;
        bArr2[108] = -72;
        bArr2[109] = -77;
        bArr2[110] = 69;
        bArr2[111] = 6;
        bArr2[112] = -48;
        bArr2[113] = 44;
        bArr2[114] = Ascii.f271RS;
        bArr2[115] = -113;
        bArr2[116] = -54;
        bArr2[117] = 63;
        bArr2[118] = 15;
        bArr2[119] = 2;
        bArr2[120] = -63;
        bArr2[121] = -81;
        bArr2[122] = -67;
        bArr2[123] = 3;
        bArr2[124] = 1;
        bArr2[125] = 19;
        bArr2[126] = -118;
        bArr2[127] = 107;
        bArr2[128] = 58;
        bArr2[129] = -111;
        bArr2[130] = 17;
        bArr2[131] = 65;
        bArr2[132] = 79;
        bArr2[133] = 103;
        bArr2[134] = -36;
        bArr2[135] = -22;
        bArr2[136] = -105;
        bArr2[137] = -14;
        bArr2[138] = -49;
        bArr2[139] = -50;
        bArr2[140] = -16;
        bArr2[141] = -76;
        bArr2[142] = -26;
        bArr2[143] = 115;
        bArr2[144] = -106;
        bArr2[145] = -84;
        bArr2[146] = 116;
        bArr2[147] = 34;
        bArr2[148] = -25;
        bArr2[149] = -83;
        bArr2[150] = 53;
        bArr2[151] = -123;
        bArr2[152] = -30;
        bArr2[153] = -7;
        bArr2[154] = 55;
        bArr2[155] = -24;
        bArr2[156] = Ascii.f266FS;
        bArr2[157] = 117;
        bArr2[158] = -33;
        bArr2[159] = 110;
        bArr2[160] = 71;
        bArr2[161] = -15;
        bArr2[162] = Ascii.SUB;
        bArr2[163] = 113;
        bArr2[164] = Ascii.f267GS;
        bArr2[165] = 41;
        bArr2[166] = -59;
        bArr2[167] = -119;
        bArr2[168] = 111;
        bArr2[169] = -73;
        bArr2[170] = 98;
        bArr2[171] = 14;
        bArr2[172] = -86;
        bArr2[173] = Ascii.CAN;
        bArr2[174] = -66;
        bArr2[175] = Ascii.ESC;
        bArr2[176] = -4;
        bArr2[177] = 86;
        bArr2[178] = DocWriter.f569GT;
        bArr2[179] = 75;
        bArr2[180] = -58;
        bArr2[181] = -46;
        bArr2[182] = 121;
        bArr2[183] = 32;
        bArr2[184] = -102;
        bArr2[185] = -37;
        bArr2[186] = -64;
        bArr2[187] = -2;
        bArr2[188] = 120;
        bArr2[189] = -51;
        bArr2[190] = 90;
        bArr2[191] = -12;
        bArr2[192] = Ascii.f275US;
        bArr2[193] = -35;
        bArr2[194] = -88;
        bArr2[195] = 51;
        bArr2[196] = -120;
        bArr2[197] = 7;
        bArr2[198] = -57;
        bArr2[199] = 49;
        bArr2[200] = -79;
        bArr2[201] = 18;
        bArr2[202] = 16;
        bArr2[203] = 89;
        bArr2[204] = 39;
        bArr2[205] = Byte.MIN_VALUE;
        bArr2[206] = -20;
        bArr2[207] = 95;
        bArr2[208] = 96;
        bArr2[209] = 81;
        bArr2[210] = Byte.MAX_VALUE;
        bArr2[211] = -87;
        bArr2[212] = Ascii.f264EM;
        bArr2[213] = -75;
        bArr2[214] = 74;
        bArr2[215] = 13;
        bArr2[216] = 45;
        bArr2[217] = -27;
        bArr2[218] = 122;
        bArr2[219] = -97;
        bArr2[220] = -109;
        bArr2[221] = -55;
        bArr2[222] = -100;
        bArr2[223] = -17;
        bArr2[224] = -96;
        bArr2[225] = -32;
        bArr2[226] = 59;
        bArr2[227] = 77;
        bArr2[228] = -82;
        bArr2[229] = 42;
        bArr2[230] = -11;
        bArr2[231] = -80;
        bArr2[232] = -56;
        bArr2[233] = -21;
        bArr2[234] = -69;
        bArr2[235] = DocWriter.f570LT;
        bArr2[236] = -125;
        bArr2[237] = 83;
        bArr2[238] = -103;
        bArr2[239] = 97;
        bArr2[240] = Ascii.ETB;
        bArr2[241] = 43;
        bArr2[242] = 4;
        bArr2[243] = 126;
        bArr2[244] = -70;
        bArr2[245] = 119;
        bArr2[246] = -42;
        bArr2[247] = 38;
        bArr2[248] = -31;
        bArr2[249] = 105;
        bArr2[250] = 20;
        bArr2[251] = 99;
        bArr2[252] = 85;
        bArr2[253] = AMFData.DATA_TYPE_BYTEARRAY;
        bArr2[254] = 12;
        bArr2[255] = 125;
        f6065Si = bArr2;
    }

    private int mcol(int i) {
        int FFmulX = FFmulX(i);
        return shift(i, 24) ^ ((FFmulX ^ shift(i ^ FFmulX, 8)) ^ shift(i, 16));
    }

    private int inv_mcol(int i) {
        int FFmulX = FFmulX(i);
        int FFmulX2 = FFmulX(FFmulX);
        int FFmulX3 = FFmulX(FFmulX2);
        int i2 = i ^ FFmulX3;
        int shift = shift(FFmulX ^ i2, 8);
        return shift(i2, 24) ^ ((shift ^ (FFmulX3 ^ (FFmulX ^ FFmulX2))) ^ shift(FFmulX2 ^ i2, 16));
    }

    private int subWord(int i) {
        byte[] bArr = f6064S;
        return (bArr[(i >> 24) & 255] << Ascii.CAN) | (bArr[i & 255] & 255) | ((bArr[(i >> 8) & 255] & 255) << 8) | ((bArr[(i >> 16) & 255] & 255) << 16);
    }

    private int[][] generateWorkingKey(byte[] bArr, boolean z) {
        int length = bArr.length / 4;
        if ((length == 4 || length == 6 || length == 8) && length * 4 == bArr.length) {
            this.ROUNDS = length + 6;
            int[][] iArr = (int[][]) Array.newInstance(int.class, new int[]{this.ROUNDS + 1, 4});
            int i = 0;
            int i2 = 0;
            while (i < bArr.length) {
                iArr[i2 >> 2][i2 & 3] = (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | (bArr[i + 3] << Ascii.CAN);
                i += 4;
                i2++;
            }
            int i3 = (this.ROUNDS + 1) << 2;
            for (int i4 = length; i4 < i3; i4++) {
                int i5 = i4 - 1;
                int i6 = iArr[i5 >> 2][i5 & 3];
                int i7 = i4 % length;
                if (i7 == 0) {
                    i6 = subWord(shift(i6, 8)) ^ rcon[(i4 / length) - 1];
                } else if (length > 6 && i7 == 4) {
                    i6 = subWord(i6);
                }
                int i8 = i4 - length;
                iArr[i4 >> 2][i4 & 3] = i6 ^ iArr[i8 >> 2][i8 & 3];
            }
            if (!z) {
                for (int i9 = 1; i9 < this.ROUNDS; i9++) {
                    for (int i10 = 0; i10 < 4; i10++) {
                        iArr[i9][i10] = inv_mcol(iArr[i9][i10]);
                    }
                }
            }
            return iArr;
        }
        throw new IllegalArgumentException("Key length not 128/192/256 bits.");
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.WorkingKey = generateWorkingKey(((KeyParameter) cipherParameters).getKey(), z);
            this.forEncryption = z;
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to AES init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.WorkingKey == null) {
            throw new IllegalStateException("AES engine not initialised");
        } else if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 16 > bArr2.length) {
            throw new DataLengthException("output buffer too short");
        } else if (this.forEncryption) {
            unpackBlock(bArr, i);
            encryptBlock(this.WorkingKey);
            packBlock(bArr2, i2);
            return 16;
        } else {
            unpackBlock(bArr, i);
            decryptBlock(this.WorkingKey);
            packBlock(bArr2, i2);
            return 16;
        }
    }

    private void unpackBlock(byte[] bArr, int i) {
        int i2 = i + 1;
        this.f6069C0 = bArr[i] & 255;
        int i3 = i2 + 1;
        this.f6069C0 |= (bArr[i2] & 255) << 8;
        int i4 = i3 + 1;
        this.f6069C0 |= (bArr[i3] & 255) << 16;
        int i5 = i4 + 1;
        this.f6069C0 |= bArr[i4] << Ascii.CAN;
        int i6 = i5 + 1;
        this.f6070C1 = bArr[i5] & 255;
        int i7 = i6 + 1;
        this.f6070C1 = ((bArr[i6] & 255) << 8) | this.f6070C1;
        int i8 = i7 + 1;
        this.f6070C1 |= (bArr[i7] & 255) << 16;
        int i9 = i8 + 1;
        this.f6070C1 |= bArr[i8] << Ascii.CAN;
        int i10 = i9 + 1;
        this.f6071C2 = bArr[i9] & 255;
        int i11 = i10 + 1;
        this.f6071C2 = ((bArr[i10] & 255) << 8) | this.f6071C2;
        int i12 = i11 + 1;
        this.f6071C2 |= (bArr[i11] & 255) << 16;
        int i13 = i12 + 1;
        this.f6071C2 |= bArr[i12] << Ascii.CAN;
        int i14 = i13 + 1;
        this.f6072C3 = bArr[i13] & 255;
        int i15 = i14 + 1;
        this.f6072C3 = ((bArr[i14] & 255) << 8) | this.f6072C3;
        this.f6072C3 |= (bArr[i15] & 255) << 16;
        this.f6072C3 = (bArr[i15 + 1] << Ascii.CAN) | this.f6072C3;
    }

    private void packBlock(byte[] bArr, int i) {
        int i2 = i + 1;
        int i3 = this.f6069C0;
        bArr[i] = (byte) i3;
        int i4 = i2 + 1;
        bArr[i2] = (byte) (i3 >> 8);
        int i5 = i4 + 1;
        bArr[i4] = (byte) (i3 >> 16);
        int i6 = i5 + 1;
        bArr[i5] = (byte) (i3 >> 24);
        int i7 = i6 + 1;
        int i8 = this.f6070C1;
        bArr[i6] = (byte) i8;
        int i9 = i7 + 1;
        bArr[i7] = (byte) (i8 >> 8);
        int i10 = i9 + 1;
        bArr[i9] = (byte) (i8 >> 16);
        int i11 = i10 + 1;
        bArr[i10] = (byte) (i8 >> 24);
        int i12 = i11 + 1;
        int i13 = this.f6071C2;
        bArr[i11] = (byte) i13;
        int i14 = i12 + 1;
        bArr[i12] = (byte) (i13 >> 8);
        int i15 = i14 + 1;
        bArr[i14] = (byte) (i13 >> 16);
        int i16 = i15 + 1;
        bArr[i15] = (byte) (i13 >> 24);
        int i17 = i16 + 1;
        int i18 = this.f6072C3;
        bArr[i16] = (byte) i18;
        int i19 = i17 + 1;
        bArr[i17] = (byte) (i18 >> 8);
        bArr[i19] = (byte) (i18 >> 16);
        bArr[i19 + 1] = (byte) (i18 >> 24);
    }

    private void encryptBlock(int[][] iArr) {
        this.f6069C0 ^= iArr[0][0];
        this.f6070C1 ^= iArr[0][1];
        this.f6071C2 ^= iArr[0][2];
        this.f6072C3 ^= iArr[0][3];
        int i = 1;
        while (i < this.ROUNDS - 1) {
            byte[] bArr = f6064S;
            int mcol = mcol((bArr[(this.f6072C3 >> 24) & 255] << Ascii.CAN) ^ (((bArr[this.f6069C0 & 255] & 255) ^ ((bArr[(this.f6070C1 >> 8) & 255] & 255) << 8)) ^ ((bArr[(this.f6071C2 >> 16) & 255] & 255) << 16))) ^ iArr[i][0];
            byte[] bArr2 = f6064S;
            int mcol2 = mcol((bArr2[(this.f6069C0 >> 24) & 255] << Ascii.CAN) ^ (((bArr2[this.f6070C1 & 255] & 255) ^ ((bArr2[(this.f6071C2 >> 8) & 255] & 255) << 8)) ^ ((bArr2[(this.f6072C3 >> 16) & 255] & 255) << 16))) ^ iArr[i][1];
            byte[] bArr3 = f6064S;
            int mcol3 = mcol((bArr3[(this.f6070C1 >> 24) & 255] << Ascii.CAN) ^ (((bArr3[this.f6071C2 & 255] & 255) ^ ((bArr3[(this.f6072C3 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(this.f6069C0 >> 16) & 255] & 255) << 16))) ^ iArr[i][2];
            byte[] bArr4 = f6064S;
            int i2 = i + 1;
            int mcol4 = iArr[i][3] ^ mcol((bArr4[(this.f6071C2 >> 24) & 255] << Ascii.CAN) ^ (((bArr4[this.f6072C3 & 255] & 255) ^ ((bArr4[(this.f6069C0 >> 8) & 255] & 255) << 8)) ^ ((bArr4[(this.f6070C1 >> 16) & 255] & 255) << 16)));
            byte[] bArr5 = f6064S;
            this.f6069C0 = mcol((bArr5[(mcol4 >> 24) & 255] << Ascii.CAN) ^ (((bArr5[mcol & 255] & 255) ^ ((bArr5[(mcol2 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(mcol3 >> 16) & 255] & 255) << 16))) ^ iArr[i2][0];
            byte[] bArr6 = f6064S;
            this.f6070C1 = mcol((bArr6[(mcol >> 24) & 255] << Ascii.CAN) ^ (((bArr6[mcol2 & 255] & 255) ^ ((bArr6[(mcol3 >> 8) & 255] & 255) << 8)) ^ ((bArr6[(mcol4 >> 16) & 255] & 255) << 16))) ^ iArr[i2][1];
            byte[] bArr7 = f6064S;
            this.f6071C2 = mcol((bArr7[(mcol2 >> 24) & 255] << Ascii.CAN) ^ (((bArr7[mcol3 & 255] & 255) ^ ((bArr7[(mcol4 >> 8) & 255] & 255) << 8)) ^ ((bArr7[(mcol >> 16) & 255] & 255) << 16))) ^ iArr[i2][2];
            byte[] bArr8 = f6064S;
            this.f6072C3 = mcol((((bArr8[mcol4 & 255] & 255) ^ ((bArr8[(mcol >> 8) & 255] & 255) << 8)) ^ ((bArr8[(mcol2 >> 16) & 255] & 255) << 16)) ^ (bArr8[(mcol3 >> 24) & 255] << Ascii.CAN)) ^ iArr[i2][3];
            i = i2 + 1;
        }
        byte[] bArr9 = f6064S;
        int mcol5 = mcol((bArr9[(this.f6072C3 >> 24) & 255] << Ascii.CAN) ^ (((bArr9[this.f6069C0 & 255] & 255) ^ ((bArr9[(this.f6070C1 >> 8) & 255] & 255) << 8)) ^ ((bArr9[(this.f6071C2 >> 16) & 255] & 255) << 16))) ^ iArr[i][0];
        byte[] bArr10 = f6064S;
        int mcol6 = mcol((bArr10[(this.f6069C0 >> 24) & 255] << Ascii.CAN) ^ (((bArr10[this.f6070C1 & 255] & 255) ^ ((bArr10[(this.f6071C2 >> 8) & 255] & 255) << 8)) ^ ((bArr10[(this.f6072C3 >> 16) & 255] & 255) << 16))) ^ iArr[i][1];
        byte[] bArr11 = f6064S;
        int mcol7 = mcol((bArr11[(this.f6070C1 >> 24) & 255] << Ascii.CAN) ^ (((bArr11[this.f6071C2 & 255] & 255) ^ ((bArr11[(this.f6072C3 >> 8) & 255] & 255) << 8)) ^ ((bArr11[(this.f6069C0 >> 16) & 255] & 255) << 16))) ^ iArr[i][2];
        byte[] bArr12 = f6064S;
        int i3 = i + 1;
        int mcol8 = iArr[i][3] ^ mcol((bArr12[(this.f6071C2 >> 24) & 255] << Ascii.CAN) ^ (((bArr12[this.f6072C3 & 255] & 255) ^ ((bArr12[(this.f6069C0 >> 8) & 255] & 255) << 8)) ^ ((bArr12[(this.f6070C1 >> 16) & 255] & 255) << 16)));
        byte[] bArr13 = f6064S;
        this.f6069C0 = iArr[i3][0] ^ ((((bArr13[mcol5 & 255] & 255) ^ ((bArr13[(mcol6 >> 8) & 255] & 255) << 8)) ^ ((bArr13[(mcol7 >> 16) & 255] & 255) << 16)) ^ (bArr13[(mcol8 >> 24) & 255] << Ascii.CAN));
        this.f6070C1 = ((((bArr13[mcol6 & 255] & 255) ^ ((bArr13[(mcol7 >> 8) & 255] & 255) << 8)) ^ ((bArr13[(mcol8 >> 16) & 255] & 255) << 16)) ^ (bArr13[(mcol5 >> 24) & 255] << Ascii.CAN)) ^ iArr[i3][1];
        this.f6071C2 = ((((bArr13[mcol7 & 255] & 255) ^ ((bArr13[(mcol8 >> 8) & 255] & 255) << 8)) ^ ((bArr13[(mcol5 >> 16) & 255] & 255) << 16)) ^ (bArr13[(mcol6 >> 24) & 255] << Ascii.CAN)) ^ iArr[i3][2];
        this.f6072C3 = iArr[i3][3] ^ ((((bArr13[mcol8 & 255] & 255) ^ ((bArr13[(mcol5 >> 8) & 255] & 255) << 8)) ^ ((bArr13[(mcol6 >> 16) & 255] & 255) << 16)) ^ (bArr13[(mcol7 >> 24) & 255] << Ascii.CAN));
    }

    private void decryptBlock(int[][] iArr) {
        int i = this.f6069C0;
        int i2 = this.ROUNDS;
        this.f6069C0 = i ^ iArr[i2][0];
        this.f6070C1 ^= iArr[i2][1];
        this.f6071C2 ^= iArr[i2][2];
        this.f6072C3 ^= iArr[i2][3];
        int i3 = i2 - 1;
        while (i3 > 1) {
            byte[] bArr = f6065Si;
            int inv_mcol = inv_mcol((bArr[(this.f6070C1 >> 24) & 255] << Ascii.CAN) ^ (((bArr[this.f6069C0 & 255] & 255) ^ ((bArr[(this.f6072C3 >> 8) & 255] & 255) << 8)) ^ ((bArr[(this.f6071C2 >> 16) & 255] & 255) << 16))) ^ iArr[i3][0];
            byte[] bArr2 = f6065Si;
            int inv_mcol2 = inv_mcol((bArr2[(this.f6071C2 >> 24) & 255] << Ascii.CAN) ^ (((bArr2[this.f6070C1 & 255] & 255) ^ ((bArr2[(this.f6069C0 >> 8) & 255] & 255) << 8)) ^ ((bArr2[(this.f6072C3 >> 16) & 255] & 255) << 16))) ^ iArr[i3][1];
            byte[] bArr3 = f6065Si;
            int inv_mcol3 = inv_mcol((bArr3[(this.f6072C3 >> 24) & 255] << Ascii.CAN) ^ (((bArr3[this.f6071C2 & 255] & 255) ^ ((bArr3[(this.f6070C1 >> 8) & 255] & 255) << 8)) ^ ((bArr3[(this.f6069C0 >> 16) & 255] & 255) << 16))) ^ iArr[i3][2];
            byte[] bArr4 = f6065Si;
            int i4 = i3 - 1;
            int inv_mcol4 = iArr[i3][3] ^ inv_mcol((bArr4[(this.f6069C0 >> 24) & 255] << Ascii.CAN) ^ (((bArr4[this.f6072C3 & 255] & 255) ^ ((bArr4[(this.f6071C2 >> 8) & 255] & 255) << 8)) ^ ((bArr4[(this.f6070C1 >> 16) & 255] & 255) << 16)));
            byte[] bArr5 = f6065Si;
            this.f6069C0 = inv_mcol((bArr5[(inv_mcol2 >> 24) & 255] << Ascii.CAN) ^ (((bArr5[inv_mcol & 255] & 255) ^ ((bArr5[(inv_mcol4 >> 8) & 255] & 255) << 8)) ^ ((bArr5[(inv_mcol3 >> 16) & 255] & 255) << 16))) ^ iArr[i4][0];
            byte[] bArr6 = f6065Si;
            this.f6070C1 = inv_mcol((bArr6[(inv_mcol3 >> 24) & 255] << Ascii.CAN) ^ (((bArr6[inv_mcol2 & 255] & 255) ^ ((bArr6[(inv_mcol >> 8) & 255] & 255) << 8)) ^ ((bArr6[(inv_mcol4 >> 16) & 255] & 255) << 16))) ^ iArr[i4][1];
            byte[] bArr7 = f6065Si;
            this.f6071C2 = inv_mcol((bArr7[(inv_mcol4 >> 24) & 255] << Ascii.CAN) ^ (((bArr7[inv_mcol3 & 255] & 255) ^ ((bArr7[(inv_mcol2 >> 8) & 255] & 255) << 8)) ^ ((bArr7[(inv_mcol >> 16) & 255] & 255) << 16))) ^ iArr[i4][2];
            byte[] bArr8 = f6065Si;
            i3 = i4 - 1;
            this.f6072C3 = inv_mcol((bArr8[(inv_mcol >> 24) & 255] << Ascii.CAN) ^ (((bArr8[inv_mcol4 & 255] & 255) ^ ((bArr8[(inv_mcol3 >> 8) & 255] & 255) << 8)) ^ ((bArr8[(inv_mcol2 >> 16) & 255] & 255) << 16))) ^ iArr[i4][3];
        }
        byte[] bArr9 = f6065Si;
        int inv_mcol5 = inv_mcol((bArr9[(this.f6070C1 >> 24) & 255] << Ascii.CAN) ^ (((bArr9[this.f6069C0 & 255] & 255) ^ ((bArr9[(this.f6072C3 >> 8) & 255] & 255) << 8)) ^ ((bArr9[(this.f6071C2 >> 16) & 255] & 255) << 16))) ^ iArr[i3][0];
        byte[] bArr10 = f6065Si;
        int inv_mcol6 = inv_mcol((bArr10[(this.f6071C2 >> 24) & 255] << Ascii.CAN) ^ (((bArr10[this.f6070C1 & 255] & 255) ^ ((bArr10[(this.f6069C0 >> 8) & 255] & 255) << 8)) ^ ((bArr10[(this.f6072C3 >> 16) & 255] & 255) << 16))) ^ iArr[i3][1];
        byte[] bArr11 = f6065Si;
        int inv_mcol7 = inv_mcol((bArr11[(this.f6072C3 >> 24) & 255] << Ascii.CAN) ^ (((bArr11[this.f6071C2 & 255] & 255) ^ ((bArr11[(this.f6070C1 >> 8) & 255] & 255) << 8)) ^ ((bArr11[(this.f6069C0 >> 16) & 255] & 255) << 16))) ^ iArr[i3][2];
        byte[] bArr12 = f6065Si;
        int inv_mcol8 = iArr[i3][3] ^ inv_mcol((bArr12[(this.f6069C0 >> 24) & 255] << Ascii.CAN) ^ (((bArr12[this.f6072C3 & 255] & 255) ^ ((bArr12[(this.f6071C2 >> 8) & 255] & 255) << 8)) ^ ((bArr12[(this.f6070C1 >> 16) & 255] & 255) << 16)));
        byte[] bArr13 = f6065Si;
        this.f6069C0 = ((((bArr13[inv_mcol5 & 255] & 255) ^ ((bArr13[(inv_mcol8 >> 8) & 255] & 255) << 8)) ^ ((bArr13[(inv_mcol7 >> 16) & 255] & 255) << 16)) ^ (bArr13[(inv_mcol6 >> 24) & 255] << Ascii.CAN)) ^ iArr[0][0];
        this.f6070C1 = iArr[0][1] ^ ((((bArr13[inv_mcol6 & 255] & 255) ^ ((bArr13[(inv_mcol5 >> 8) & 255] & 255) << 8)) ^ ((bArr13[(inv_mcol8 >> 16) & 255] & 255) << 16)) ^ (bArr13[(inv_mcol7 >> 24) & 255] << Ascii.CAN));
        this.f6071C2 = ((((bArr13[inv_mcol7 & 255] & 255) ^ ((bArr13[(inv_mcol6 >> 8) & 255] & 255) << 8)) ^ ((bArr13[(inv_mcol5 >> 16) & 255] & 255) << 16)) ^ (bArr13[(inv_mcol8 >> 24) & 255] << Ascii.CAN)) ^ iArr[0][2];
        this.f6072C3 = iArr[0][3] ^ ((bArr13[(inv_mcol5 >> 24) & 255] << Ascii.CAN) ^ (((bArr13[inv_mcol8 & 255] & 255) ^ ((bArr13[(inv_mcol7 >> 8) & 255] & 255) << 8)) ^ ((bArr13[(inv_mcol6 >> 16) & 255] & 255) << 16)));
    }
}
