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

public class CamelliaLightEngine implements BlockCipher {
    private static final int BLOCK_SIZE = 16;
    private static final int MASK8 = 255;
    private static final byte[] SBOX1;
    private static final int[] SIGMA = {-1600231809, 1003262091, -1233459112, 1286239154, -957401297, -380665154, 1426019237, -237801700, 283453434, -563598051, -1336506174, -1276722691};
    private boolean _keyis128;
    private boolean initialized;

    /* renamed from: ke */
    private int[] f6089ke = new int[12];

    /* renamed from: kw */
    private int[] f6090kw = new int[8];
    private int[] state = new int[4];
    private int[] subkey = new int[96];

    private byte lRot8(byte b, int i) {
        return (byte) (((b & 255) >>> (8 - i)) | (b << i));
    }

    private static int leftRotate(int i, int i2) {
        return (i << i2) + (i >>> (32 - i2));
    }

    private static int rightRotate(int i, int i2) {
        return (i >>> i2) + (i << (32 - i2));
    }

    public String getAlgorithmName() {
        return "Camellia";
    }

    public int getBlockSize() {
        return 16;
    }

    public void reset() {
    }

    static {
        byte[] bArr = new byte[256];
        bArr[0] = 112;
        bArr[1] = -126;
        bArr[2] = 44;
        bArr[3] = -20;
        bArr[4] = -77;
        bArr[5] = 39;
        bArr[6] = -64;
        bArr[7] = -27;
        bArr[8] = -28;
        bArr[9] = -123;
        bArr[10] = 87;
        bArr[11] = 53;
        bArr[12] = -22;
        bArr[13] = 12;
        bArr[14] = -82;
        bArr[15] = 65;
        bArr[16] = 35;
        bArr[17] = -17;
        bArr[18] = 107;
        bArr[19] = -109;
        bArr[20] = 69;
        bArr[21] = Ascii.f264EM;
        bArr[22] = -91;
        bArr[23] = AMFData.DATA_TYPE_BYTEARRAY;
        bArr[24] = -19;
        bArr[25] = 14;
        bArr[26] = 79;
        bArr[27] = 78;
        bArr[28] = Ascii.f267GS;
        bArr[29] = 101;
        bArr[30] = -110;
        bArr[31] = -67;
        bArr[32] = -122;
        bArr[33] = -72;
        bArr[34] = -81;
        bArr[35] = -113;
        bArr[36] = 124;
        bArr[37] = -21;
        bArr[38] = Ascii.f275US;
        bArr[39] = -50;
        bArr[40] = DocWriter.f569GT;
        bArr[41] = ByteBuffer.ZERO;
        bArr[42] = -36;
        bArr[43] = 95;
        bArr[44] = 94;
        bArr[45] = -59;
        bArr[46] = 11;
        bArr[47] = Ascii.SUB;
        bArr[48] = -90;
        bArr[49] = -31;
        bArr[50] = 57;
        bArr[51] = -54;
        bArr[52] = -43;
        bArr[53] = 71;
        bArr[54] = 93;
        bArr[55] = DocWriter.EQUALS;
        bArr[56] = -39;
        bArr[57] = 1;
        bArr[58] = 90;
        bArr[59] = -42;
        bArr[60] = 81;
        bArr[61] = 86;
        bArr[62] = 108;
        bArr[63] = 77;
        bArr[64] = -117;
        bArr[65] = 13;
        bArr[66] = -102;
        bArr[67] = 102;
        bArr[68] = -5;
        bArr[69] = -52;
        bArr[70] = -80;
        bArr[71] = 45;
        bArr[72] = 116;
        bArr[73] = 18;
        bArr[74] = 43;
        bArr[75] = 32;
        bArr[76] = -16;
        bArr[77] = -79;
        bArr[78] = -124;
        bArr[79] = -103;
        bArr[80] = -33;
        bArr[81] = 76;
        bArr[82] = -53;
        bArr[83] = -62;
        bArr[84] = 52;
        bArr[85] = 126;
        bArr[86] = 118;
        bArr[87] = 5;
        bArr[88] = 109;
        bArr[89] = -73;
        bArr[90] = -87;
        bArr[91] = 49;
        bArr[92] = -47;
        bArr[93] = Ascii.ETB;
        bArr[94] = 4;
        bArr[95] = -41;
        bArr[96] = 20;
        bArr[97] = 88;
        bArr[98] = 58;
        bArr[99] = 97;
        bArr[100] = -34;
        bArr[101] = Ascii.ESC;
        bArr[102] = 17;
        bArr[103] = Ascii.f266FS;
        bArr[104] = 50;
        bArr[105] = 15;
        bArr[106] = -100;
        bArr[107] = 22;
        bArr[108] = 83;
        bArr[109] = Ascii.CAN;
        bArr[110] = -14;
        bArr[111] = 34;
        bArr[112] = -2;
        bArr[113] = 68;
        bArr[114] = -49;
        bArr[115] = -78;
        bArr[116] = -61;
        bArr[117] = -75;
        bArr[118] = 122;
        bArr[119] = -111;
        bArr[120] = 36;
        bArr[121] = 8;
        bArr[122] = -24;
        bArr[123] = -88;
        bArr[124] = 96;
        bArr[125] = -4;
        bArr[126] = 105;
        bArr[127] = 80;
        bArr[128] = -86;
        bArr[129] = -48;
        bArr[130] = -96;
        bArr[131] = 125;
        bArr[132] = -95;
        bArr[133] = -119;
        bArr[134] = 98;
        bArr[135] = -105;
        bArr[136] = 84;
        bArr[137] = 91;
        bArr[138] = Ascii.f271RS;
        bArr[139] = -107;
        bArr[140] = -32;
        bArr[141] = -1;
        bArr[142] = 100;
        bArr[143] = -46;
        bArr[144] = 16;
        bArr[145] = -60;
        bArr[147] = 72;
        bArr[148] = -93;
        bArr[149] = -9;
        bArr[150] = 117;
        bArr[151] = -37;
        bArr[152] = -118;
        bArr[153] = 3;
        bArr[154] = -26;
        bArr[155] = -38;
        bArr[156] = 9;
        bArr[157] = 63;
        bArr[158] = -35;
        bArr[159] = -108;
        bArr[160] = -121;
        bArr[161] = 92;
        bArr[162] = -125;
        bArr[163] = 2;
        bArr[164] = -51;
        bArr[165] = 74;
        bArr[166] = -112;
        bArr[167] = 51;
        bArr[168] = 115;
        bArr[169] = 103;
        bArr[170] = -10;
        bArr[171] = -13;
        bArr[172] = -99;
        bArr[173] = Byte.MAX_VALUE;
        bArr[174] = -65;
        bArr[175] = -30;
        bArr[176] = 82;
        bArr[177] = -101;
        bArr[178] = -40;
        bArr[179] = 38;
        bArr[180] = -56;
        bArr[181] = 55;
        bArr[182] = -58;
        bArr[183] = 59;
        bArr[184] = -127;
        bArr[185] = -106;
        bArr[186] = 111;
        bArr[187] = 75;
        bArr[188] = 19;
        bArr[189] = -66;
        bArr[190] = 99;
        bArr[191] = 46;
        bArr[192] = -23;
        bArr[193] = 121;
        bArr[194] = -89;
        bArr[195] = -116;
        bArr[196] = -97;
        bArr[197] = 110;
        bArr[198] = PSSSigner.TRAILER_IMPLICIT;
        bArr[199] = -114;
        bArr[200] = 41;
        bArr[201] = -11;
        bArr[202] = -7;
        bArr[203] = -74;
        bArr[204] = DocWriter.FORWARD;
        bArr[205] = -3;
        bArr[206] = -76;
        bArr[207] = 89;
        bArr[208] = 120;
        bArr[209] = -104;
        bArr[210] = 6;
        bArr[211] = 106;
        bArr[212] = -25;
        bArr[213] = 70;
        bArr[214] = 113;
        bArr[215] = -70;
        bArr[216] = -44;
        bArr[217] = 37;
        bArr[218] = -85;
        bArr[219] = 66;
        bArr[220] = -120;
        bArr[221] = -94;
        bArr[222] = -115;
        bArr[223] = -6;
        bArr[224] = 114;
        bArr[225] = 7;
        bArr[226] = -71;
        bArr[227] = 85;
        bArr[228] = -8;
        bArr[229] = -18;
        bArr[230] = -84;
        bArr[231] = 10;
        bArr[232] = 54;
        bArr[233] = 73;
        bArr[234] = 42;
        bArr[235] = 104;
        bArr[236] = DocWriter.f570LT;
        bArr[237] = 56;
        bArr[238] = -15;
        bArr[239] = -92;
        bArr[240] = SignedBytes.MAX_POWER_OF_TWO;
        bArr[241] = 40;
        bArr[242] = -45;
        bArr[243] = 123;
        bArr[244] = -69;
        bArr[245] = -55;
        bArr[246] = 67;
        bArr[247] = -63;
        bArr[248] = Ascii.NAK;
        bArr[249] = -29;
        bArr[250] = -83;
        bArr[251] = -12;
        bArr[252] = 119;
        bArr[253] = -57;
        bArr[254] = Byte.MIN_VALUE;
        bArr[255] = -98;
        SBOX1 = bArr;
    }

    private static void roldq(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = i3 + 0;
        int i5 = i2 + 0;
        int i6 = i2 + 1;
        int i7 = 32 - i;
        iArr2[i4] = (iArr[i5] << i) | (iArr[i6] >>> i7);
        int i8 = i3 + 1;
        int i9 = i2 + 2;
        iArr2[i8] = (iArr[i6] << i) | (iArr[i9] >>> i7);
        int i10 = i3 + 2;
        int i11 = i2 + 3;
        iArr2[i10] = (iArr[i9] << i) | (iArr[i11] >>> i7);
        int i12 = i3 + 3;
        iArr2[i12] = (iArr[i11] << i) | (iArr[i5] >>> i7);
        iArr[i5] = iArr2[i4];
        iArr[i6] = iArr2[i8];
        iArr[i9] = iArr2[i10];
        iArr[i11] = iArr2[i12];
    }

    private static void decroldq(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = i3 + 2;
        int i5 = i2 + 0;
        int i6 = i2 + 1;
        int i7 = 32 - i;
        iArr2[i4] = (iArr[i5] << i) | (iArr[i6] >>> i7);
        int i8 = i3 + 3;
        int i9 = i2 + 2;
        iArr2[i8] = (iArr[i6] << i) | (iArr[i9] >>> i7);
        int i10 = i3 + 0;
        int i11 = i2 + 3;
        iArr2[i10] = (iArr[i9] << i) | (iArr[i11] >>> i7);
        int i12 = i3 + 1;
        iArr2[i12] = (iArr[i11] << i) | (iArr[i5] >>> i7);
        iArr[i5] = iArr2[i4];
        iArr[i6] = iArr2[i8];
        iArr[i9] = iArr2[i10];
        iArr[i11] = iArr2[i12];
    }

    private static void roldqo32(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = i3 + 0;
        int i5 = i2 + 1;
        int i6 = i - 32;
        int i7 = i2 + 2;
        int i8 = 64 - i;
        iArr2[i4] = (iArr[i5] << i6) | (iArr[i7] >>> i8);
        int i9 = i3 + 1;
        int i10 = i2 + 3;
        iArr2[i9] = (iArr[i7] << i6) | (iArr[i10] >>> i8);
        int i11 = i3 + 2;
        int i12 = i2 + 0;
        iArr2[i11] = (iArr[i10] << i6) | (iArr[i12] >>> i8);
        int i13 = i3 + 3;
        iArr2[i13] = (iArr[i5] >>> i8) | (iArr[i12] << i6);
        iArr[i12] = iArr2[i4];
        iArr[i5] = iArr2[i9];
        iArr[i7] = iArr2[i11];
        iArr[i10] = iArr2[i13];
    }

    private static void decroldqo32(int i, int[] iArr, int i2, int[] iArr2, int i3) {
        int i4 = i3 + 2;
        int i5 = i2 + 1;
        int i6 = i - 32;
        int i7 = i2 + 2;
        int i8 = 64 - i;
        iArr2[i4] = (iArr[i5] << i6) | (iArr[i7] >>> i8);
        int i9 = i3 + 3;
        int i10 = i2 + 3;
        iArr2[i9] = (iArr[i7] << i6) | (iArr[i10] >>> i8);
        int i11 = i3 + 0;
        int i12 = i2 + 0;
        iArr2[i11] = (iArr[i10] << i6) | (iArr[i12] >>> i8);
        int i13 = i3 + 1;
        iArr2[i13] = (iArr[i5] >>> i8) | (iArr[i12] << i6);
        iArr[i12] = iArr2[i4];
        iArr[i5] = iArr2[i9];
        iArr[i7] = iArr2[i11];
        iArr[i10] = iArr2[i13];
    }

    private int bytes2int(byte[] bArr, int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            i2 = (i2 << 8) + (bArr[i3 + i] & 255);
        }
        return i2;
    }

    private void int2bytes(int i, byte[] bArr, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[(3 - i3) + i2] = (byte) i;
            i >>>= 8;
        }
    }

    private int sbox2(int i) {
        return lRot8(SBOX1[i], 1) & 255;
    }

    private int sbox3(int i) {
        return lRot8(SBOX1[i], 7) & 255;
    }

    private int sbox4(int i) {
        return SBOX1[lRot8((byte) i, 1) & 255] & 255;
    }

    private void camelliaF2(int[] iArr, int[] iArr2, int i) {
        int i2 = iArr[0] ^ iArr2[i + 0];
        int sbox4 = sbox4(i2 & 255) | (sbox3((i2 >>> 8) & 255) << 8) | (sbox2((i2 >>> 16) & 255) << 16);
        byte[] bArr = SBOX1;
        int i3 = iArr[1] ^ iArr2[i + 1];
        int leftRotate = leftRotate((bArr[i3 & 255] & 255) | (sbox4((i3 >>> 8) & 255) << 8) | (sbox3((i3 >>> 16) & 255) << 16) | (sbox2((i3 >>> 24) & 255) << 24), 8);
        int i4 = (((bArr[(i2 >>> 24) & 255] & 255) << Ascii.CAN) | sbox4) ^ leftRotate;
        int leftRotate2 = leftRotate(leftRotate, 8) ^ i4;
        int rightRotate = rightRotate(i4, 8) ^ leftRotate2;
        iArr[2] = (leftRotate(leftRotate2, 16) ^ rightRotate) ^ iArr[2];
        iArr[3] = leftRotate(rightRotate, 8) ^ iArr[3];
        int i5 = iArr[2] ^ iArr2[i + 2];
        int sbox42 = sbox4(i5 & 255) | (sbox3((i5 >>> 8) & 255) << 8) | (sbox2((i5 >>> 16) & 255) << 16);
        byte[] bArr2 = SBOX1;
        int i6 = ((bArr2[(i5 >>> 24) & 255] & 255) << Ascii.CAN) | sbox42;
        int i7 = iArr2[i + 3] ^ iArr[3];
        int leftRotate3 = leftRotate((sbox2((i7 >>> 24) & 255) << 24) | (bArr2[i7 & 255] & 255) | (sbox4((i7 >>> 8) & 255) << 8) | (sbox3((i7 >>> 16) & 255) << 16), 8);
        int i8 = i6 ^ leftRotate3;
        int leftRotate4 = leftRotate(leftRotate3, 8) ^ i8;
        int rightRotate2 = rightRotate(i8, 8) ^ leftRotate4;
        iArr[0] = (leftRotate(leftRotate4, 16) ^ rightRotate2) ^ iArr[0];
        iArr[1] = iArr[1] ^ leftRotate(rightRotate2, 8);
    }

    private void camelliaFLs(int[] iArr, int[] iArr2, int i) {
        iArr[1] = iArr[1] ^ leftRotate(iArr[0] & iArr2[i + 0], 1);
        iArr[0] = iArr[0] ^ (iArr2[i + 1] | iArr[1]);
        iArr[2] = iArr[2] ^ (iArr2[i + 3] | iArr[3]);
        iArr[3] = leftRotate(iArr2[i + 2] & iArr[2], 1) ^ iArr[3];
    }

    private void setKey(boolean z, byte[] bArr) {
        byte[] bArr2 = bArr;
        int[] iArr = new int[8];
        int[] iArr2 = new int[4];
        int[] iArr3 = new int[4];
        int[] iArr4 = new int[4];
        int length = bArr2.length;
        int i = 12;
        if (length == 16) {
            this._keyis128 = true;
            iArr[0] = bytes2int(bArr2, 0);
            iArr[1] = bytes2int(bArr2, 4);
            iArr[2] = bytes2int(bArr2, 8);
            iArr[3] = bytes2int(bArr2, 12);
            iArr[7] = 0;
            iArr[6] = 0;
            iArr[5] = 0;
            iArr[4] = 0;
        } else if (length == 24) {
            iArr[0] = bytes2int(bArr2, 0);
            iArr[1] = bytes2int(bArr2, 4);
            iArr[2] = bytes2int(bArr2, 8);
            iArr[3] = bytes2int(bArr2, 12);
            iArr[4] = bytes2int(bArr2, 16);
            iArr[5] = bytes2int(bArr2, 20);
            iArr[6] = ~iArr[4];
            iArr[7] = ~iArr[5];
            this._keyis128 = false;
        } else if (length == 32) {
            iArr[0] = bytes2int(bArr2, 0);
            iArr[1] = bytes2int(bArr2, 4);
            iArr[2] = bytes2int(bArr2, 8);
            iArr[3] = bytes2int(bArr2, 12);
            iArr[4] = bytes2int(bArr2, 16);
            iArr[5] = bytes2int(bArr2, 20);
            iArr[6] = bytes2int(bArr2, 24);
            iArr[7] = bytes2int(bArr2, 28);
            this._keyis128 = false;
        } else {
            throw new IllegalArgumentException("key sizes are only 16/24/32 bytes.");
        }
        int i2 = 0;
        while (i2 < 4) {
            iArr2[i2] = iArr[i2] ^ iArr[i2 + 4];
            i2++;
            i = 12;
        }
        camelliaF2(iArr2, SIGMA, 0);
        int i3 = 0;
        while (i3 < 4) {
            iArr2[i3] = iArr2[i3] ^ iArr[i3];
            i3++;
            i = 12;
        }
        camelliaF2(iArr2, SIGMA, 4);
        if (!this._keyis128) {
            for (int i4 = 0; i4 < 4; i4++) {
                iArr3[i4] = iArr2[i4] ^ iArr[i4 + 4];
            }
            camelliaF2(iArr3, SIGMA, 8);
            if (z) {
                int[] iArr5 = this.f6090kw;
                iArr5[0] = iArr[0];
                iArr5[1] = iArr[1];
                iArr5[2] = iArr[2];
                iArr5[3] = iArr[3];
                roldqo32(45, iArr, 0, this.subkey, 16);
                roldq(15, iArr, 0, this.f6089ke, 4);
                roldq(17, iArr, 0, this.subkey, 32);
                roldqo32(34, iArr, 0, this.subkey, 44);
                roldq(15, iArr, 4, this.subkey, 4);
                roldq(15, iArr, 4, this.f6089ke, 0);
                roldq(30, iArr, 4, this.subkey, 24);
                roldqo32(34, iArr, 4, this.subkey, 36);
                roldq(15, iArr2, 0, this.subkey, 8);
                roldq(30, iArr2, 0, this.subkey, 20);
                int[] iArr6 = this.f6089ke;
                iArr6[8] = iArr2[1];
                iArr6[9] = iArr2[2];
                iArr6[10] = iArr2[3];
                iArr6[11] = iArr2[0];
                roldqo32(49, iArr2, 0, this.subkey, 40);
                int[] iArr7 = this.subkey;
                iArr7[0] = iArr3[0];
                iArr7[1] = iArr3[1];
                iArr7[2] = iArr3[2];
                iArr7[3] = iArr3[3];
                roldq(30, iArr3, 0, iArr7, 12);
                roldq(30, iArr3, 0, this.subkey, 28);
                roldqo32(51, iArr3, 0, this.f6090kw, 4);
                return;
            }
            int[] iArr8 = this.f6090kw;
            iArr8[4] = iArr[0];
            iArr8[5] = iArr[1];
            iArr8[6] = iArr[2];
            iArr8[7] = iArr[3];
            decroldqo32(45, iArr, 0, this.subkey, 28);
            decroldq(15, iArr, 0, this.f6089ke, 4);
            decroldq(17, iArr, 0, this.subkey, 12);
            decroldqo32(34, iArr, 0, this.subkey, 0);
            decroldq(15, iArr, 4, this.subkey, 40);
            decroldq(15, iArr, 4, this.f6089ke, 8);
            decroldq(30, iArr, 4, this.subkey, 20);
            decroldqo32(34, iArr, 4, this.subkey, 8);
            decroldq(15, iArr2, 0, this.subkey, 36);
            decroldq(30, iArr2, 0, this.subkey, 24);
            int[] iArr9 = this.f6089ke;
            iArr9[2] = iArr2[1];
            iArr9[3] = iArr2[2];
            iArr9[0] = iArr2[3];
            iArr9[1] = iArr2[0];
            decroldqo32(49, iArr2, 0, this.subkey, 4);
            int[] iArr10 = this.subkey;
            iArr10[46] = iArr3[0];
            iArr10[47] = iArr3[1];
            iArr10[44] = iArr3[2];
            iArr10[45] = iArr3[3];
            decroldq(30, iArr3, 0, iArr10, 32);
            decroldq(30, iArr3, 0, this.subkey, 16);
            roldqo32(51, iArr3, 0, this.f6090kw, 0);
        } else if (z) {
            int[] iArr11 = this.f6090kw;
            iArr11[0] = iArr[0];
            iArr11[1] = iArr[1];
            iArr11[2] = iArr[2];
            iArr11[3] = iArr[3];
            roldq(15, iArr, 0, this.subkey, 4);
            roldq(30, iArr, 0, this.subkey, i);
            roldq(15, iArr, 0, iArr4, 0);
            int[] iArr12 = this.subkey;
            iArr12[18] = iArr4[2];
            iArr12[19] = iArr4[3];
            roldq(17, iArr, 0, this.f6089ke, 4);
            roldq(17, iArr, 0, this.subkey, 24);
            roldq(17, iArr, 0, this.subkey, 32);
            int[] iArr13 = this.subkey;
            iArr13[0] = iArr2[0];
            iArr13[1] = iArr2[1];
            iArr13[2] = iArr2[2];
            iArr13[3] = iArr2[3];
            roldq(15, iArr2, 0, iArr13, 8);
            roldq(15, iArr2, 0, this.f6089ke, 0);
            roldq(15, iArr2, 0, iArr4, 0);
            int[] iArr14 = this.subkey;
            iArr14[16] = iArr4[0];
            iArr14[17] = iArr4[1];
            roldq(15, iArr2, 0, iArr14, 20);
            roldqo32(34, iArr2, 0, this.subkey, 28);
            roldq(17, iArr2, 0, this.f6090kw, 4);
        } else {
            int[] iArr15 = this.f6090kw;
            iArr15[4] = iArr[0];
            iArr15[5] = iArr[1];
            iArr15[6] = iArr[2];
            iArr15[7] = iArr[3];
            decroldq(15, iArr, 0, this.subkey, 28);
            decroldq(30, iArr, 0, this.subkey, 20);
            decroldq(15, iArr, 0, iArr4, 0);
            int[] iArr16 = this.subkey;
            iArr16[16] = iArr4[0];
            iArr16[17] = iArr4[1];
            decroldq(17, iArr, 0, this.f6089ke, 0);
            decroldq(17, iArr, 0, this.subkey, 8);
            decroldq(17, iArr, 0, this.subkey, 0);
            int[] iArr17 = this.subkey;
            iArr17[34] = iArr2[0];
            iArr17[35] = iArr2[1];
            iArr17[32] = iArr2[2];
            iArr17[33] = iArr2[3];
            decroldq(15, iArr2, 0, iArr17, 24);
            decroldq(15, iArr2, 0, this.f6089ke, 4);
            decroldq(15, iArr2, 0, iArr4, 0);
            int[] iArr18 = this.subkey;
            iArr18[18] = iArr4[2];
            iArr18[19] = iArr4[3];
            decroldq(15, iArr2, 0, iArr18, i);
            decroldqo32(34, iArr2, 0, this.subkey, 4);
            roldq(17, iArr2, 0, this.f6090kw, 0);
        }
    }

    private int processBlock128(byte[] bArr, int i, byte[] bArr2, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            this.state[i3] = bytes2int(bArr, (i3 * 4) + i);
            int[] iArr = this.state;
            iArr[i3] = iArr[i3] ^ this.f6090kw[i3];
        }
        camelliaF2(this.state, this.subkey, 0);
        camelliaF2(this.state, this.subkey, 4);
        camelliaF2(this.state, this.subkey, 8);
        camelliaFLs(this.state, this.f6089ke, 0);
        camelliaF2(this.state, this.subkey, 12);
        camelliaF2(this.state, this.subkey, 16);
        camelliaF2(this.state, this.subkey, 20);
        camelliaFLs(this.state, this.f6089ke, 4);
        camelliaF2(this.state, this.subkey, 24);
        camelliaF2(this.state, this.subkey, 28);
        camelliaF2(this.state, this.subkey, 32);
        int[] iArr2 = this.state;
        int i4 = iArr2[2];
        int[] iArr3 = this.f6090kw;
        iArr2[2] = iArr3[4] ^ i4;
        iArr2[3] = iArr2[3] ^ iArr3[5];
        iArr2[0] = iArr2[0] ^ iArr3[6];
        iArr2[1] = iArr3[7] ^ iArr2[1];
        int2bytes(iArr2[2], bArr2, i2);
        int2bytes(this.state[3], bArr2, i2 + 4);
        int2bytes(this.state[0], bArr2, i2 + 8);
        int2bytes(this.state[1], bArr2, i2 + 12);
        return 16;
    }

    private int processBlock192or256(byte[] bArr, int i, byte[] bArr2, int i2) {
        for (int i3 = 0; i3 < 4; i3++) {
            this.state[i3] = bytes2int(bArr, (i3 * 4) + i);
            int[] iArr = this.state;
            iArr[i3] = iArr[i3] ^ this.f6090kw[i3];
        }
        camelliaF2(this.state, this.subkey, 0);
        camelliaF2(this.state, this.subkey, 4);
        camelliaF2(this.state, this.subkey, 8);
        camelliaFLs(this.state, this.f6089ke, 0);
        camelliaF2(this.state, this.subkey, 12);
        camelliaF2(this.state, this.subkey, 16);
        camelliaF2(this.state, this.subkey, 20);
        camelliaFLs(this.state, this.f6089ke, 4);
        camelliaF2(this.state, this.subkey, 24);
        camelliaF2(this.state, this.subkey, 28);
        camelliaF2(this.state, this.subkey, 32);
        camelliaFLs(this.state, this.f6089ke, 8);
        camelliaF2(this.state, this.subkey, 36);
        camelliaF2(this.state, this.subkey, 40);
        camelliaF2(this.state, this.subkey, 44);
        int[] iArr2 = this.state;
        int i4 = iArr2[2];
        int[] iArr3 = this.f6090kw;
        iArr2[2] = i4 ^ iArr3[4];
        iArr2[3] = iArr2[3] ^ iArr3[5];
        iArr2[0] = iArr2[0] ^ iArr3[6];
        iArr2[1] = iArr3[7] ^ iArr2[1];
        int2bytes(iArr2[2], bArr2, i2);
        int2bytes(this.state[3], bArr2, i2 + 4);
        int2bytes(this.state[0], bArr2, i2 + 8);
        int2bytes(this.state[1], bArr2, i2 + 12);
        return 16;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            setKey(z, ((KeyParameter) cipherParameters).getKey());
            this.initialized = true;
            return;
        }
        throw new IllegalArgumentException("only simple KeyParameter expected.");
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) throws IllegalStateException {
        if (!this.initialized) {
            throw new IllegalStateException("Camellia is not initialized");
        } else if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 + 16 > bArr2.length) {
            throw new DataLengthException("output buffer too short");
        } else if (this._keyis128) {
            return processBlock128(bArr, i, bArr2, i2);
        } else {
            return processBlock192or256(bArr, i, bArr2, i2);
        }
    }
}
