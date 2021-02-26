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
import repack.org.bouncycastle.crypto.params.RC2Parameters;
import repack.org.bouncycastle.crypto.signers.PSSSigner;

public class RC2Engine implements BlockCipher {
    private static final int BLOCK_SIZE = 8;
    private static byte[] piTable;
    private boolean encrypting;
    private int[] workingKey;

    private int rotateWordLeft(int i, int i2) {
        int i3 = i & 65535;
        return (i3 >> (16 - i2)) | (i3 << i2);
    }

    public String getAlgorithmName() {
        return "RC2";
    }

    public int getBlockSize() {
        return 8;
    }

    public void reset() {
    }

    static {
        byte[] bArr = new byte[256];
        bArr[0] = -39;
        bArr[1] = 120;
        bArr[2] = -7;
        bArr[3] = -60;
        bArr[4] = Ascii.f264EM;
        bArr[5] = -35;
        bArr[6] = -75;
        bArr[7] = -19;
        bArr[8] = 40;
        bArr[9] = -23;
        bArr[10] = -3;
        bArr[11] = 121;
        bArr[12] = 74;
        bArr[13] = -96;
        bArr[14] = -40;
        bArr[15] = -99;
        bArr[16] = -58;
        bArr[17] = 126;
        bArr[18] = 55;
        bArr[19] = -125;
        bArr[20] = 43;
        bArr[21] = 118;
        bArr[22] = 83;
        bArr[23] = -114;
        bArr[24] = 98;
        bArr[25] = 76;
        bArr[26] = 100;
        bArr[27] = -120;
        bArr[28] = 68;
        bArr[29] = -117;
        bArr[30] = -5;
        bArr[31] = -94;
        bArr[32] = Ascii.ETB;
        bArr[33] = -102;
        bArr[34] = 89;
        bArr[35] = -11;
        bArr[36] = -121;
        bArr[37] = -77;
        bArr[38] = 79;
        bArr[39] = 19;
        bArr[40] = 97;
        bArr[41] = 69;
        bArr[42] = 109;
        bArr[43] = -115;
        bArr[44] = 9;
        bArr[45] = -127;
        bArr[46] = 125;
        bArr[47] = 50;
        bArr[48] = -67;
        bArr[49] = -113;
        bArr[50] = SignedBytes.MAX_POWER_OF_TWO;
        bArr[51] = -21;
        bArr[52] = -122;
        bArr[53] = -73;
        bArr[54] = 123;
        bArr[55] = 11;
        bArr[56] = -16;
        bArr[57] = -107;
        bArr[58] = AMFData.DATA_TYPE_BYTEARRAY;
        bArr[59] = 34;
        bArr[60] = 92;
        bArr[61] = 107;
        bArr[62] = 78;
        bArr[63] = -126;
        bArr[64] = 84;
        bArr[65] = -42;
        bArr[66] = 101;
        bArr[67] = -109;
        bArr[68] = -50;
        bArr[69] = 96;
        bArr[70] = -78;
        bArr[71] = Ascii.f266FS;
        bArr[72] = 115;
        bArr[73] = 86;
        bArr[74] = -64;
        bArr[75] = 20;
        bArr[76] = -89;
        bArr[77] = -116;
        bArr[78] = -15;
        bArr[79] = -36;
        bArr[80] = 18;
        bArr[81] = 117;
        bArr[82] = -54;
        bArr[83] = Ascii.f275US;
        bArr[84] = 59;
        bArr[85] = -66;
        bArr[86] = -28;
        bArr[87] = -47;
        bArr[88] = 66;
        bArr[89] = DocWriter.EQUALS;
        bArr[90] = -44;
        bArr[91] = ByteBuffer.ZERO;
        bArr[92] = -93;
        bArr[93] = DocWriter.f570LT;
        bArr[94] = -74;
        bArr[95] = 38;
        bArr[96] = 111;
        bArr[97] = -65;
        bArr[98] = 14;
        bArr[99] = -38;
        bArr[100] = 70;
        bArr[101] = 105;
        bArr[102] = 7;
        bArr[103] = 87;
        bArr[104] = 39;
        bArr[105] = -14;
        bArr[106] = Ascii.f267GS;
        bArr[107] = -101;
        bArr[108] = PSSSigner.TRAILER_IMPLICIT;
        bArr[109] = -108;
        bArr[110] = 67;
        bArr[111] = 3;
        bArr[112] = -8;
        bArr[113] = 17;
        bArr[114] = -57;
        bArr[115] = -10;
        bArr[116] = -112;
        bArr[117] = -17;
        bArr[118] = DocWriter.f569GT;
        bArr[119] = -25;
        bArr[120] = 6;
        bArr[121] = -61;
        bArr[122] = -43;
        bArr[123] = DocWriter.FORWARD;
        bArr[124] = -56;
        bArr[125] = 102;
        bArr[126] = Ascii.f271RS;
        bArr[127] = -41;
        bArr[128] = 8;
        bArr[129] = -24;
        bArr[130] = -22;
        bArr[131] = -34;
        bArr[132] = Byte.MIN_VALUE;
        bArr[133] = 82;
        bArr[134] = -18;
        bArr[135] = -9;
        bArr[136] = -124;
        bArr[137] = -86;
        bArr[138] = 114;
        bArr[139] = -84;
        bArr[140] = 53;
        bArr[141] = 77;
        bArr[142] = 106;
        bArr[143] = 42;
        bArr[144] = -106;
        bArr[145] = Ascii.SUB;
        bArr[146] = -46;
        bArr[147] = 113;
        bArr[148] = 90;
        bArr[149] = Ascii.NAK;
        bArr[150] = 73;
        bArr[151] = 116;
        bArr[152] = 75;
        bArr[153] = -97;
        bArr[154] = -48;
        bArr[155] = 94;
        bArr[156] = 4;
        bArr[157] = Ascii.CAN;
        bArr[158] = -92;
        bArr[159] = -20;
        bArr[160] = -62;
        bArr[161] = -32;
        bArr[162] = 65;
        bArr[163] = 110;
        bArr[164] = 15;
        bArr[165] = 81;
        bArr[166] = -53;
        bArr[167] = -52;
        bArr[168] = 36;
        bArr[169] = -111;
        bArr[170] = -81;
        bArr[171] = 80;
        bArr[172] = -95;
        bArr[173] = -12;
        bArr[174] = 112;
        bArr[175] = 57;
        bArr[176] = -103;
        bArr[177] = 124;
        bArr[178] = 58;
        bArr[179] = -123;
        bArr[180] = 35;
        bArr[181] = -72;
        bArr[182] = -76;
        bArr[183] = 122;
        bArr[184] = -4;
        bArr[185] = 2;
        bArr[186] = 54;
        bArr[187] = 91;
        bArr[188] = 37;
        bArr[189] = 85;
        bArr[190] = -105;
        bArr[191] = 49;
        bArr[192] = 45;
        bArr[193] = 93;
        bArr[194] = -6;
        bArr[195] = -104;
        bArr[196] = -29;
        bArr[197] = -118;
        bArr[198] = -110;
        bArr[199] = -82;
        bArr[200] = 5;
        bArr[201] = -33;
        bArr[202] = 41;
        bArr[203] = 16;
        bArr[204] = 103;
        bArr[205] = 108;
        bArr[206] = -70;
        bArr[207] = -55;
        bArr[208] = -45;
        bArr[210] = -26;
        bArr[211] = -49;
        bArr[212] = -31;
        bArr[213] = -98;
        bArr[214] = -88;
        bArr[215] = 44;
        bArr[216] = 99;
        bArr[217] = 22;
        bArr[218] = 1;
        bArr[219] = 63;
        bArr[220] = 88;
        bArr[221] = -30;
        bArr[222] = -119;
        bArr[223] = -87;
        bArr[224] = 13;
        bArr[225] = 56;
        bArr[226] = 52;
        bArr[227] = Ascii.ESC;
        bArr[228] = -85;
        bArr[229] = 51;
        bArr[230] = -1;
        bArr[231] = -80;
        bArr[232] = -69;
        bArr[233] = 72;
        bArr[234] = 12;
        bArr[235] = 95;
        bArr[236] = -71;
        bArr[237] = -79;
        bArr[238] = -51;
        bArr[239] = 46;
        bArr[240] = -59;
        bArr[241] = -13;
        bArr[242] = -37;
        bArr[243] = 71;
        bArr[244] = -27;
        bArr[245] = -91;
        bArr[246] = -100;
        bArr[247] = 119;
        bArr[248] = 10;
        bArr[249] = -90;
        bArr[250] = 32;
        bArr[251] = 104;
        bArr[252] = -2;
        bArr[253] = Byte.MAX_VALUE;
        bArr[254] = -63;
        bArr[255] = -83;
        piTable = bArr;
    }

    private int[] generateWorkingKey(byte[] bArr, int i) {
        int[] iArr = new int[128];
        for (int i2 = 0; i2 != bArr.length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        int length = bArr.length;
        if (length < 128) {
            int i3 = iArr[length - 1];
            int i4 = length;
            int i5 = 0;
            while (true) {
                int i6 = i5 + 1;
                i3 = piTable[(i3 + iArr[i5]) & 255] & 255;
                int i7 = i4 + 1;
                iArr[i4] = i3;
                if (i7 >= 128) {
                    break;
                }
                i4 = i7;
                i5 = i6;
            }
        }
        int i8 = (i + 7) >> 3;
        int i9 = 128 - i8;
        int i10 = piTable[(255 >> ((-i) & 7)) & iArr[i9]] & 255;
        iArr[i9] = i10;
        for (int i11 = i9 - 1; i11 >= 0; i11--) {
            i10 = piTable[i10 ^ iArr[i11 + i8]] & 255;
            iArr[i11] = i10;
        }
        int[] iArr2 = new int[64];
        for (int i12 = 0; i12 != iArr2.length; i12++) {
            int i13 = i12 * 2;
            iArr2[i12] = iArr[i13] + (iArr[i13 + 1] << 8);
        }
        return iArr2;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        this.encrypting = z;
        if (cipherParameters instanceof RC2Parameters) {
            RC2Parameters rC2Parameters = (RC2Parameters) cipherParameters;
            this.workingKey = generateWorkingKey(rC2Parameters.getKey(), rC2Parameters.getEffectiveKeyBits());
        } else if (cipherParameters instanceof KeyParameter) {
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            this.workingKey = generateWorkingKey(key, key.length * 8);
        } else {
            throw new IllegalArgumentException("invalid parameter passed to RC2 init - " + cipherParameters.getClass().getName());
        }
    }

    public final int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.workingKey == null) {
            throw new IllegalStateException("RC2 engine not initialised");
        } else if (i + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 8 > bArr2.length) {
            throw new DataLengthException("output buffer too short");
        } else if (this.encrypting) {
            encryptBlock(bArr, i, bArr2, i2);
            return 8;
        } else {
            decryptBlock(bArr, i, bArr2, i2);
            return 8;
        }
    }

    private void encryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = ((bArr[i + 7] & 255) << 8) + (bArr[i + 6] & 255);
        int i4 = ((bArr[i + 5] & 255) << 8) + (bArr[i + 4] & 255);
        int i5 = ((bArr[i + 3] & 255) << 8) + (bArr[i + 2] & 255);
        int i6 = ((bArr[i + 1] & 255) << 8) + (bArr[i + 0] & 255);
        for (int i7 = 0; i7 <= 16; i7 += 4) {
            i6 = rotateWordLeft(i6 + ((~i3) & i5) + (i4 & i3) + this.workingKey[i7], 1);
            i5 = rotateWordLeft(i5 + ((~i6) & i4) + (i3 & i6) + this.workingKey[i7 + 1], 2);
            i4 = rotateWordLeft(i4 + ((~i5) & i3) + (i6 & i5) + this.workingKey[i7 + 2], 3);
            i3 = rotateWordLeft(i3 + ((~i4) & i6) + (i5 & i4) + this.workingKey[i7 + 3], 5);
        }
        int[] iArr = this.workingKey;
        int i8 = i6 + iArr[i3 & 63];
        int i9 = i5 + iArr[i8 & 63];
        int i10 = i4 + iArr[i9 & 63];
        int i11 = i3 + iArr[i10 & 63];
        for (int i12 = 20; i12 <= 40; i12 += 4) {
            i8 = rotateWordLeft(i8 + ((~i11) & i9) + (i10 & i11) + this.workingKey[i12], 1);
            i9 = rotateWordLeft(i9 + ((~i8) & i10) + (i11 & i8) + this.workingKey[i12 + 1], 2);
            i10 = rotateWordLeft(i10 + ((~i9) & i11) + (i8 & i9) + this.workingKey[i12 + 2], 3);
            i11 = rotateWordLeft(i11 + ((~i10) & i8) + (i9 & i10) + this.workingKey[i12 + 3], 5);
        }
        int[] iArr2 = this.workingKey;
        int i13 = i8 + iArr2[i11 & 63];
        int i14 = i9 + iArr2[i13 & 63];
        int i15 = i10 + iArr2[i14 & 63];
        int i16 = i11 + iArr2[i15 & 63];
        for (int i17 = 44; i17 < 64; i17 += 4) {
            i13 = rotateWordLeft(i13 + ((~i16) & i14) + (i15 & i16) + this.workingKey[i17], 1);
            i14 = rotateWordLeft(i14 + ((~i13) & i15) + (i16 & i13) + this.workingKey[i17 + 1], 2);
            i15 = rotateWordLeft(i15 + ((~i14) & i16) + (i13 & i14) + this.workingKey[i17 + 2], 3);
            i16 = rotateWordLeft(i16 + ((~i15) & i13) + (i14 & i15) + this.workingKey[i17 + 3], 5);
        }
        bArr2[i2 + 0] = (byte) i13;
        bArr2[i2 + 1] = (byte) (i13 >> 8);
        bArr2[i2 + 2] = (byte) i14;
        bArr2[i2 + 3] = (byte) (i14 >> 8);
        bArr2[i2 + 4] = (byte) i15;
        bArr2[i2 + 5] = (byte) (i15 >> 8);
        bArr2[i2 + 6] = (byte) i16;
        bArr2[i2 + 7] = (byte) (i16 >> 8);
    }

    private void decryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = ((bArr[i + 7] & 255) << 8) + (bArr[i + 6] & 255);
        int i4 = ((bArr[i + 5] & 255) << 8) + (bArr[i + 4] & 255);
        int i5 = ((bArr[i + 3] & 255) << 8) + (bArr[i + 2] & 255);
        int i6 = ((bArr[i + 1] & 255) << 8) + (bArr[i + 0] & 255);
        for (int i7 = 60; i7 >= 44; i7 -= 4) {
            i3 = rotateWordLeft(i3, 11) - ((((~i4) & i6) + (i5 & i4)) + this.workingKey[i7 + 3]);
            i4 = rotateWordLeft(i4, 13) - ((((~i5) & i3) + (i6 & i5)) + this.workingKey[i7 + 2]);
            i5 = rotateWordLeft(i5, 14) - ((((~i6) & i4) + (i3 & i6)) + this.workingKey[i7 + 1]);
            i6 = rotateWordLeft(i6, 15) - ((((~i3) & i5) + (i4 & i3)) + this.workingKey[i7]);
        }
        int[] iArr = this.workingKey;
        int i8 = i3 - iArr[i4 & 63];
        int i9 = i4 - iArr[i5 & 63];
        int i10 = i5 - iArr[i6 & 63];
        int i11 = i6 - iArr[i8 & 63];
        for (int i12 = 40; i12 >= 20; i12 -= 4) {
            i8 = rotateWordLeft(i8, 11) - ((((~i9) & i11) + (i10 & i9)) + this.workingKey[i12 + 3]);
            i9 = rotateWordLeft(i9, 13) - ((((~i10) & i8) + (i11 & i10)) + this.workingKey[i12 + 2]);
            i10 = rotateWordLeft(i10, 14) - ((((~i11) & i9) + (i8 & i11)) + this.workingKey[i12 + 1]);
            i11 = rotateWordLeft(i11, 15) - ((((~i8) & i10) + (i9 & i8)) + this.workingKey[i12]);
        }
        int[] iArr2 = this.workingKey;
        int i13 = i8 - iArr2[i9 & 63];
        int i14 = i9 - iArr2[i10 & 63];
        int i15 = i10 - iArr2[i11 & 63];
        int i16 = i11 - iArr2[i13 & 63];
        for (int i17 = 16; i17 >= 0; i17 -= 4) {
            i13 = rotateWordLeft(i13, 11) - ((((~i14) & i16) + (i15 & i14)) + this.workingKey[i17 + 3]);
            i14 = rotateWordLeft(i14, 13) - ((((~i15) & i13) + (i16 & i15)) + this.workingKey[i17 + 2]);
            i15 = rotateWordLeft(i15, 14) - ((((~i16) & i14) + (i13 & i16)) + this.workingKey[i17 + 1]);
            i16 = rotateWordLeft(i16, 15) - ((((~i13) & i15) + (i14 & i13)) + this.workingKey[i17]);
        }
        bArr2[i2 + 0] = (byte) i16;
        bArr2[i2 + 1] = (byte) (i16 >> 8);
        bArr2[i2 + 2] = (byte) i15;
        bArr2[i2 + 3] = (byte) (i15 >> 8);
        bArr2[i2 + 4] = (byte) i14;
        bArr2[i2 + 5] = (byte) (i14 >> 8);
        bArr2[i2 + 6] = (byte) i13;
        bArr2[i2 + 7] = (byte) (i13 >> 8);
    }
}
