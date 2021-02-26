package repack.org.bouncycastle.crypto.engines;

import repack.org.bouncycastle.crypto.BlockCipher;
import repack.org.bouncycastle.crypto.CipherParameters;
import repack.org.bouncycastle.crypto.DataLengthException;
import repack.org.bouncycastle.crypto.params.KeyParameter;
import repack.org.bouncycastle.crypto.tls.AlertDescription;

public class SkipjackEngine implements BlockCipher {
    static final int BLOCK_SIZE = 8;
    static short[] ftable;
    private boolean encrypting;
    private int[] key0;
    private int[] key1;
    private int[] key2;
    private int[] key3;

    public String getAlgorithmName() {
        return "SKIPJACK";
    }

    public int getBlockSize() {
        return 8;
    }

    public void reset() {
    }

    static {
        short[] sArr = new short[256];
        sArr[0] = 163;
        sArr[1] = 215;
        sArr[2] = 9;
        sArr[3] = 131;
        sArr[4] = 248;
        sArr[5] = 72;
        sArr[6] = 246;
        sArr[7] = 244;
        sArr[8] = 179;
        sArr[9] = 33;
        sArr[10] = 21;
        sArr[11] = 120;
        sArr[12] = 153;
        sArr[13] = 177;
        sArr[14] = 175;
        sArr[15] = 249;
        sArr[16] = 231;
        sArr[17] = 45;
        sArr[18] = 77;
        sArr[19] = 138;
        sArr[20] = 206;
        sArr[21] = 76;
        sArr[22] = 202;
        sArr[23] = 46;
        sArr[24] = 82;
        sArr[25] = 149;
        sArr[26] = 217;
        sArr[27] = 30;
        sArr[28] = 78;
        sArr[29] = 56;
        sArr[30] = 68;
        sArr[31] = 40;
        sArr[32] = 10;
        sArr[33] = 223;
        sArr[34] = 2;
        sArr[35] = 160;
        sArr[36] = 23;
        sArr[37] = 241;
        sArr[38] = 96;
        sArr[39] = 104;
        sArr[40] = 18;
        sArr[41] = 183;
        sArr[42] = 122;
        sArr[43] = 195;
        sArr[44] = 233;
        sArr[45] = 250;
        sArr[46] = 61;
        sArr[47] = 83;
        sArr[48] = 150;
        sArr[49] = 132;
        sArr[50] = 107;
        sArr[51] = 186;
        sArr[52] = 242;
        sArr[53] = 99;
        sArr[54] = 154;
        sArr[55] = 25;
        sArr[56] = 124;
        sArr[57] = 174;
        sArr[58] = 229;
        sArr[59] = 245;
        sArr[60] = 247;
        sArr[61] = 22;
        sArr[62] = 106;
        sArr[63] = 162;
        sArr[64] = 57;
        sArr[65] = 182;
        sArr[66] = 123;
        sArr[67] = 15;
        sArr[68] = 193;
        sArr[69] = 147;
        sArr[70] = 129;
        sArr[71] = 27;
        sArr[72] = 238;
        sArr[73] = 180;
        sArr[74] = 26;
        sArr[75] = 234;
        sArr[76] = 208;
        sArr[77] = 145;
        sArr[78] = 47;
        sArr[79] = 184;
        sArr[80] = 85;
        sArr[81] = 185;
        sArr[82] = 218;
        sArr[83] = 133;
        sArr[84] = 63;
        sArr[85] = 65;
        sArr[86] = 191;
        sArr[87] = 224;
        sArr[88] = 90;
        sArr[89] = 88;
        sArr[90] = 128;
        sArr[91] = 95;
        sArr[92] = 102;
        sArr[93] = 11;
        sArr[94] = 216;
        sArr[95] = 144;
        sArr[96] = 53;
        sArr[97] = 213;
        sArr[98] = 192;
        sArr[99] = 167;
        sArr[100] = 51;
        sArr[101] = 6;
        sArr[102] = 101;
        sArr[103] = 105;
        sArr[104] = 69;
        sArr[106] = 148;
        sArr[107] = 86;
        sArr[108] = 109;
        sArr[109] = 152;
        sArr[110] = 155;
        sArr[111] = 118;
        sArr[112] = 151;
        sArr[113] = 252;
        sArr[114] = 178;
        sArr[115] = 194;
        sArr[116] = 176;
        sArr[117] = 254;
        sArr[118] = 219;
        sArr[119] = 32;
        sArr[120] = 225;
        sArr[121] = 235;
        sArr[122] = 214;
        sArr[123] = 228;
        sArr[124] = 221;
        sArr[125] = 71;
        sArr[126] = 74;
        sArr[127] = 29;
        sArr[128] = 66;
        sArr[129] = 237;
        sArr[130] = 158;
        sArr[131] = AlertDescription.unsupported_extension;
        sArr[132] = 73;
        sArr[133] = 60;
        sArr[134] = 205;
        sArr[135] = 67;
        sArr[136] = 39;
        sArr[137] = 210;
        sArr[138] = 7;
        sArr[139] = 212;
        sArr[140] = 222;
        sArr[141] = 199;
        sArr[142] = 103;
        sArr[143] = 24;
        sArr[144] = 137;
        sArr[145] = 203;
        sArr[146] = 48;
        sArr[147] = 31;
        sArr[148] = 141;
        sArr[149] = 198;
        sArr[150] = 143;
        sArr[151] = 170;
        sArr[152] = 200;
        sArr[153] = 116;
        sArr[154] = 220;
        sArr[155] = 201;
        sArr[156] = 93;
        sArr[157] = 92;
        sArr[158] = 49;
        sArr[159] = 164;
        sArr[160] = AlertDescription.unrecognized_name;
        sArr[161] = 136;
        sArr[162] = 97;
        sArr[163] = 44;
        sArr[164] = 159;
        sArr[165] = 13;
        sArr[166] = 43;
        sArr[167] = 135;
        sArr[168] = 80;
        sArr[169] = 130;
        sArr[170] = 84;
        sArr[171] = 100;
        sArr[172] = 38;
        sArr[173] = 125;
        sArr[174] = 3;
        sArr[175] = 64;
        sArr[176] = 52;
        sArr[177] = 75;
        sArr[178] = 28;
        sArr[179] = AlertDescription.unknown_psk_identity;
        sArr[180] = 209;
        sArr[181] = 196;
        sArr[182] = 253;
        sArr[183] = 59;
        sArr[184] = 204;
        sArr[185] = 251;
        sArr[186] = 127;
        sArr[187] = 171;
        sArr[188] = 230;
        sArr[189] = 62;
        sArr[190] = 91;
        sArr[191] = 165;
        sArr[192] = 173;
        sArr[193] = 4;
        sArr[194] = 35;
        sArr[195] = 156;
        sArr[196] = 20;
        sArr[197] = 81;
        sArr[198] = 34;
        sArr[199] = 240;
        sArr[200] = 41;
        sArr[201] = 121;
        sArr[202] = AlertDescription.bad_certificate_status_response;
        sArr[203] = 126;
        sArr[204] = 255;
        sArr[205] = 140;
        sArr[206] = 14;
        sArr[207] = 226;
        sArr[208] = 12;
        sArr[209] = 239;
        sArr[210] = 188;
        sArr[211] = AlertDescription.bad_certificate_hash_value;
        sArr[212] = 117;
        sArr[213] = AlertDescription.certificate_unobtainable;
        sArr[214] = 55;
        sArr[215] = 161;
        sArr[216] = 236;
        sArr[217] = 211;
        sArr[218] = 142;
        sArr[219] = 98;
        sArr[220] = 139;
        sArr[221] = 134;
        sArr[222] = 16;
        sArr[223] = 232;
        sArr[224] = 8;
        sArr[225] = 119;
        sArr[226] = 17;
        sArr[227] = 190;
        sArr[228] = 146;
        sArr[229] = 79;
        sArr[230] = 36;
        sArr[231] = 197;
        sArr[232] = 50;
        sArr[233] = 54;
        sArr[234] = 157;
        sArr[235] = 207;
        sArr[236] = 243;
        sArr[237] = 166;
        sArr[238] = 187;
        sArr[239] = 172;
        sArr[240] = 94;
        sArr[241] = 108;
        sArr[242] = 169;
        sArr[243] = 19;
        sArr[244] = 87;
        sArr[245] = 37;
        sArr[246] = 181;
        sArr[247] = 227;
        sArr[248] = 189;
        sArr[249] = 168;
        sArr[250] = 58;
        sArr[251] = 1;
        sArr[252] = 5;
        sArr[253] = 89;
        sArr[254] = 42;
        sArr[255] = 70;
        ftable = sArr;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            byte[] key = ((KeyParameter) cipherParameters).getKey();
            this.encrypting = z;
            this.key0 = new int[32];
            this.key1 = new int[32];
            this.key2 = new int[32];
            this.key3 = new int[32];
            for (int i = 0; i < 32; i++) {
                int i2 = i * 4;
                this.key0[i] = key[i2 % 10] & 255;
                this.key1[i] = key[(i2 + 1) % 10] & 255;
                this.key2[i] = key[(i2 + 2) % 10] & 255;
                this.key3[i] = key[(i2 + 3) % 10] & 255;
            }
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to SKIPJACK init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.key1 == null) {
            throw new IllegalStateException("SKIPJACK engine not initialised");
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

    /* renamed from: g */
    private int m4820g(int i, int i2) {
        short s = i2 & 255;
        short[] sArr = ftable;
        short s2 = ((i2 >> 8) & 255) ^ sArr[this.key0[i] ^ s];
        short s3 = s ^ sArr[this.key1[i] ^ s2];
        short s4 = s2 ^ sArr[this.key2[i] ^ s3];
        return (s4 << 8) + (sArr[this.key3[i] ^ s4] ^ s3);
    }

    public int encryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = (bArr[i + 0] << 8) + (bArr[i + 1] & 255);
        int i4 = (bArr[i + 2] << 8) + (bArr[i + 3] & 255);
        int i5 = (bArr[i + 4] << 8) + (bArr[i + 5] & 255);
        int i6 = (bArr[i + 6] << 8) + (bArr[i + 7] & 255);
        int i7 = 0;
        int i8 = 0;
        while (i7 < 2) {
            int i9 = i3;
            int i10 = 0;
            while (i10 < 8) {
                int g = m4820g(i8, i9);
                i8++;
                i10++;
                int i11 = i5;
                i5 = i4;
                i4 = g;
                i9 = (i6 ^ g) ^ i8;
                i6 = i11;
            }
            int i12 = 0;
            while (i12 < 8) {
                int i13 = i8 + 1;
                int g2 = m4820g(i8, i9);
                i12++;
                i9 = i6;
                i6 = i5;
                i5 = (i4 ^ i9) ^ i13;
                i4 = g2;
                i8 = i13;
            }
            i7++;
            i3 = i9;
        }
        bArr2[i2 + 0] = (byte) (i3 >> 8);
        bArr2[i2 + 1] = (byte) i3;
        bArr2[i2 + 2] = (byte) (i4 >> 8);
        bArr2[i2 + 3] = (byte) i4;
        bArr2[i2 + 4] = (byte) (i5 >> 8);
        bArr2[i2 + 5] = (byte) i5;
        bArr2[i2 + 6] = (byte) (i6 >> 8);
        bArr2[i2 + 7] = (byte) i6;
        return 8;
    }

    /* renamed from: h */
    private int m4821h(int i, int i2) {
        short s = i2 & 255;
        short s2 = (i2 >> 8) & 255;
        short[] sArr = ftable;
        short s3 = s ^ sArr[this.key3[i] ^ s2];
        short s4 = s2 ^ sArr[this.key2[i] ^ s3];
        short s5 = s3 ^ sArr[this.key1[i] ^ s4];
        return ((sArr[this.key0[i] ^ s5] ^ s4) << 8) + s5;
    }

    public int decryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = (bArr[i + 0] << 8) + (bArr[i + 1] & 255);
        int i4 = (bArr[i + 2] << 8) + (bArr[i + 3] & 255);
        int i5 = (bArr[i + 4] << 8) + (bArr[i + 5] & 255);
        int i6 = (bArr[i + 6] << 8) + (bArr[i + 7] & 255);
        int i7 = 0;
        int i8 = 31;
        while (i7 < 2) {
            int i9 = i4;
            int i10 = i3;
            int i11 = 0;
            while (i11 < 8) {
                int h = m4821h(i8, i9);
                i8--;
                i11++;
                int i12 = i6;
                i6 = i10;
                i10 = h;
                i9 = (i5 ^ h) ^ (i8 + 1);
                i5 = i12;
            }
            int i13 = 0;
            int i14 = i8;
            int i15 = i10;
            i4 = i9;
            int i16 = i14;
            while (i13 < 8) {
                int h2 = m4821h(i16, i4);
                i16--;
                i13++;
                int i17 = (i15 ^ i4) ^ (i16 + 1);
                i15 = h2;
                i4 = i5;
                i5 = i6;
                i6 = i17;
            }
            i7++;
            i3 = i15;
            i8 = i16;
        }
        bArr2[i2 + 0] = (byte) (i3 >> 8);
        bArr2[i2 + 1] = (byte) i3;
        bArr2[i2 + 2] = (byte) (i4 >> 8);
        bArr2[i2 + 3] = (byte) i4;
        bArr2[i2 + 4] = (byte) (i5 >> 8);
        bArr2[i2 + 5] = (byte) i5;
        bArr2[i2 + 6] = (byte) (i6 >> 8);
        bArr2[i2 + 7] = (byte) i6;
        return 8;
    }
}
