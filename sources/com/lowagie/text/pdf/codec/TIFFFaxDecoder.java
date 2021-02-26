package com.lowagie.text.pdf.codec;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import com.lowagie.text.DocWriter;
import com.lowagie.text.pdf.ByteBuffer;
import com.wowza.gocoder.sdk.support.wmstransport.wms.amf.AMFData;
import repack.org.bouncycastle.crypto.signers.PSSSigner;

public class TIFFFaxDecoder {
    static short[] additionalMakeup = {28679, 28679, 31752, -32759, -31735, -30711, -29687, -28663, 29703, 29703, 30727, 30727, -27639, -26615, -25591, -24567};
    static short[] black;
    static byte[] flipTable;
    static short[] initBlack = {3226, 6412, 200, 168, 38, 38, 134, 134, 100, 100, 100, 100, 68, 68, 68, 68};
    static int[] table1;
    static int[] table2;
    static short[] twoBitBlack = {292, 260, 226, 226};
    static byte[] twoDCodes = {80, 88, Ascii.ETB, 71, Ascii.f271RS, Ascii.f271RS, DocWriter.f569GT, DocWriter.f569GT, 4, 4, 4, 4, 4, 4, 4, 4, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 11, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 35, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 51, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41, 41};
    static short[] white = {6430, 6400, 6400, 6400, 3225, 3225, 3225, 3225, 944, 944, 944, 944, 976, 976, 976, 976, 1456, 1456, 1456, 1456, 1488, 1488, 1488, 1488, 718, 718, 718, 718, 718, 718, 718, 718, 750, 750, 750, 750, 750, 750, 750, 750, 1520, 1520, 1520, 1520, 1552, 1552, 1552, 1552, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 428, 654, 654, 654, 654, 654, 654, 654, 654, 1072, 1072, 1072, 1072, 1104, 1104, 1104, 1104, 1136, 1136, 1136, 1136, 1168, 1168, 1168, 1168, 1200, 1200, 1200, 1200, 1232, 1232, 1232, 1232, 622, 622, 622, 622, 622, 622, 622, 622, 1008, 1008, 1008, 1008, 1040, 1040, 1040, 1040, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 44, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 396, 1712, 1712, 1712, 1712, 1744, 1744, 1744, 1744, 846, 846, 846, 846, 846, 846, 846, 846, 1264, 1264, 1264, 1264, 1296, 1296, 1296, 1296, 1328, 1328, 1328, 1328, 1360, 1360, 1360, 1360, 1392, 1392, 1392, 1392, 1424, 1424, 1424, 1424, 686, 686, 686, 686, 686, 686, 686, 686, 910, 910, 910, 910, 910, 910, 910, 910, 1968, 1968, 1968, 1968, 2000, 2000, 2000, 2000, 2032, 2032, 2032, 2032, 16, 16, 16, 16, 10257, 10257, 10257, 10257, 12305, 12305, 12305, 12305, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 330, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 362, 878, 878, 878, 878, 878, 878, 878, 878, 1904, 1904, 1904, 1904, 1936, 1936, 1936, 1936, -18413, -18413, -16365, -16365, -14317, -14317, -10221, -10221, 590, 590, 590, 590, 590, 590, 590, 590, 782, 782, 782, 782, 782, 782, 782, 782, 1584, 1584, 1584, 1584, 1616, 1616, 1616, 1616, 1648, 1648, 1648, 1648, 1680, 1680, 1680, 1680, 814, 814, 814, 814, 814, 814, 814, 814, 1776, 1776, 1776, 1776, 1808, 1808, 1808, 1808, 1840, 1840, 1840, 1840, 1872, 1872, 1872, 1872, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, 6157, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, -12275, 14353, 14353, 14353, 14353, 16401, 16401, 16401, 16401, 22547, 22547, 24595, 24595, 20497, 20497, 20497, 20497, 18449, 18449, 18449, 18449, 26643, 26643, 28691, 28691, 30739, 30739, -32749, -32749, -30701, -30701, -28653, -28653, -26605, -26605, -24557, -24557, -22509, -22509, -20461, -20461, 8207, 8207, 8207, 8207, 8207, 8207, 8207, 8207, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 72, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 104, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 4107, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 266, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 298, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 524, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 556, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 136, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 168, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 460, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 492, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 2059, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 200, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232, 232};
    private int bitPointer;
    private int bytePointer;
    private int changingElemSize = 0;
    private int compression = 2;
    private int[] currChangingElems;
    private byte[] data;
    private int fillBits = 0;
    private int fillOrder;

    /* renamed from: h */
    private int f786h;
    private int lastChangingElement = 0;
    private int oneD;
    private int[] prevChangingElems;
    private int uncompressedMode = 0;

    /* renamed from: w */
    private int f787w;

    static {
        int[] iArr = new int[9];
        iArr[1] = 1;
        iArr[2] = 3;
        iArr[3] = 7;
        iArr[4] = 15;
        iArr[5] = 31;
        iArr[6] = 63;
        iArr[7] = 127;
        iArr[8] = 255;
        table1 = iArr;
        int[] iArr2 = new int[9];
        iArr2[1] = 128;
        iArr2[2] = 192;
        iArr2[3] = 224;
        iArr2[4] = 240;
        iArr2[5] = 248;
        iArr2[6] = 252;
        iArr2[7] = 254;
        iArr2[8] = 255;
        table2 = iArr2;
        byte[] bArr = new byte[256];
        bArr[1] = Byte.MIN_VALUE;
        bArr[2] = SignedBytes.MAX_POWER_OF_TWO;
        bArr[3] = -64;
        bArr[4] = 32;
        bArr[5] = -96;
        bArr[6] = 96;
        bArr[7] = -32;
        bArr[8] = 16;
        bArr[9] = -112;
        bArr[10] = 80;
        bArr[11] = -48;
        bArr[12] = ByteBuffer.ZERO;
        bArr[13] = -80;
        bArr[14] = 112;
        bArr[15] = -16;
        bArr[16] = 8;
        bArr[17] = -120;
        bArr[18] = 72;
        bArr[19] = -56;
        bArr[20] = 40;
        bArr[21] = -88;
        bArr[22] = 104;
        bArr[23] = -24;
        bArr[24] = Ascii.CAN;
        bArr[25] = -104;
        bArr[26] = 88;
        bArr[27] = -40;
        bArr[28] = 56;
        bArr[29] = -72;
        bArr[30] = 120;
        bArr[31] = -8;
        bArr[32] = 4;
        bArr[33] = -124;
        bArr[34] = 68;
        bArr[35] = -60;
        bArr[36] = 36;
        bArr[37] = -92;
        bArr[38] = 100;
        bArr[39] = -28;
        bArr[40] = 20;
        bArr[41] = -108;
        bArr[42] = 84;
        bArr[43] = -44;
        bArr[44] = 52;
        bArr[45] = -76;
        bArr[46] = 116;
        bArr[47] = -12;
        bArr[48] = 12;
        bArr[49] = -116;
        bArr[50] = 76;
        bArr[51] = -52;
        bArr[52] = 44;
        bArr[53] = -84;
        bArr[54] = 108;
        bArr[55] = -20;
        bArr[56] = Ascii.f266FS;
        bArr[57] = -100;
        bArr[58] = 92;
        bArr[59] = -36;
        bArr[60] = DocWriter.f570LT;
        bArr[61] = PSSSigner.TRAILER_IMPLICIT;
        bArr[62] = 124;
        bArr[63] = -4;
        bArr[64] = 2;
        bArr[65] = -126;
        bArr[66] = 66;
        bArr[67] = -62;
        bArr[68] = 34;
        bArr[69] = -94;
        bArr[70] = 98;
        bArr[71] = -30;
        bArr[72] = 18;
        bArr[73] = -110;
        bArr[74] = 82;
        bArr[75] = -46;
        bArr[76] = 50;
        bArr[77] = -78;
        bArr[78] = 114;
        bArr[79] = -14;
        bArr[80] = 10;
        bArr[81] = -118;
        bArr[82] = 74;
        bArr[83] = -54;
        bArr[84] = 42;
        bArr[85] = -86;
        bArr[86] = 106;
        bArr[87] = -22;
        bArr[88] = Ascii.SUB;
        bArr[89] = -102;
        bArr[90] = 90;
        bArr[91] = -38;
        bArr[92] = 58;
        bArr[93] = -70;
        bArr[94] = 122;
        bArr[95] = -6;
        bArr[96] = 6;
        bArr[97] = -122;
        bArr[98] = 70;
        bArr[99] = -58;
        bArr[100] = 38;
        bArr[101] = -90;
        bArr[102] = 102;
        bArr[103] = -26;
        bArr[104] = 22;
        bArr[105] = -106;
        bArr[106] = 86;
        bArr[107] = -42;
        bArr[108] = 54;
        bArr[109] = -74;
        bArr[110] = 118;
        bArr[111] = -10;
        bArr[112] = 14;
        bArr[113] = -114;
        bArr[114] = 78;
        bArr[115] = -50;
        bArr[116] = 46;
        bArr[117] = -82;
        bArr[118] = 110;
        bArr[119] = -18;
        bArr[120] = Ascii.f271RS;
        bArr[121] = -98;
        bArr[122] = 94;
        bArr[123] = -34;
        bArr[124] = DocWriter.f569GT;
        bArr[125] = -66;
        bArr[126] = 126;
        bArr[127] = -2;
        bArr[128] = 1;
        bArr[129] = -127;
        bArr[130] = 65;
        bArr[131] = -63;
        bArr[132] = AMFData.DATA_TYPE_BYTEARRAY;
        bArr[133] = -95;
        bArr[134] = 97;
        bArr[135] = -31;
        bArr[136] = 17;
        bArr[137] = -111;
        bArr[138] = 81;
        bArr[139] = -47;
        bArr[140] = 49;
        bArr[141] = -79;
        bArr[142] = 113;
        bArr[143] = -15;
        bArr[144] = 9;
        bArr[145] = -119;
        bArr[146] = 73;
        bArr[147] = -55;
        bArr[148] = 41;
        bArr[149] = -87;
        bArr[150] = 105;
        bArr[151] = -23;
        bArr[152] = Ascii.f264EM;
        bArr[153] = -103;
        bArr[154] = 89;
        bArr[155] = -39;
        bArr[156] = 57;
        bArr[157] = -71;
        bArr[158] = 121;
        bArr[159] = -7;
        bArr[160] = 5;
        bArr[161] = -123;
        bArr[162] = 69;
        bArr[163] = -59;
        bArr[164] = 37;
        bArr[165] = -91;
        bArr[166] = 101;
        bArr[167] = -27;
        bArr[168] = Ascii.NAK;
        bArr[169] = -107;
        bArr[170] = 85;
        bArr[171] = -43;
        bArr[172] = 53;
        bArr[173] = -75;
        bArr[174] = 117;
        bArr[175] = -11;
        bArr[176] = 13;
        bArr[177] = -115;
        bArr[178] = 77;
        bArr[179] = -51;
        bArr[180] = 45;
        bArr[181] = -83;
        bArr[182] = 109;
        bArr[183] = -19;
        bArr[184] = Ascii.f267GS;
        bArr[185] = -99;
        bArr[186] = 93;
        bArr[187] = -35;
        bArr[188] = DocWriter.EQUALS;
        bArr[189] = -67;
        bArr[190] = 125;
        bArr[191] = -3;
        bArr[192] = 3;
        bArr[193] = -125;
        bArr[194] = 67;
        bArr[195] = -61;
        bArr[196] = 35;
        bArr[197] = -93;
        bArr[198] = 99;
        bArr[199] = -29;
        bArr[200] = 19;
        bArr[201] = -109;
        bArr[202] = 83;
        bArr[203] = -45;
        bArr[204] = 51;
        bArr[205] = -77;
        bArr[206] = 115;
        bArr[207] = -13;
        bArr[208] = 11;
        bArr[209] = -117;
        bArr[210] = 75;
        bArr[211] = -53;
        bArr[212] = 43;
        bArr[213] = -85;
        bArr[214] = 107;
        bArr[215] = -21;
        bArr[216] = Ascii.ESC;
        bArr[217] = -101;
        bArr[218] = 91;
        bArr[219] = -37;
        bArr[220] = 59;
        bArr[221] = -69;
        bArr[222] = 123;
        bArr[223] = -5;
        bArr[224] = 7;
        bArr[225] = -121;
        bArr[226] = 71;
        bArr[227] = -57;
        bArr[228] = 39;
        bArr[229] = -89;
        bArr[230] = 103;
        bArr[231] = -25;
        bArr[232] = Ascii.ETB;
        bArr[233] = -105;
        bArr[234] = 87;
        bArr[235] = -41;
        bArr[236] = 55;
        bArr[237] = -73;
        bArr[238] = 119;
        bArr[239] = -9;
        bArr[240] = 15;
        bArr[241] = -113;
        bArr[242] = 79;
        bArr[243] = -49;
        bArr[244] = DocWriter.FORWARD;
        bArr[245] = -81;
        bArr[246] = 111;
        bArr[247] = -17;
        bArr[248] = Ascii.f275US;
        bArr[249] = -97;
        bArr[250] = 95;
        bArr[251] = -33;
        bArr[252] = 63;
        bArr[253] = -65;
        bArr[254] = Byte.MAX_VALUE;
        bArr[255] = -1;
        flipTable = bArr;
        short[] sArr = new short[512];
        sArr[0] = 62;
        sArr[1] = 62;
        sArr[2] = 30;
        sArr[3] = 30;
        sArr[32] = 3225;
        sArr[33] = 3225;
        sArr[34] = 3225;
        sArr[35] = 3225;
        sArr[36] = 3225;
        sArr[37] = 3225;
        sArr[38] = 3225;
        sArr[39] = 3225;
        sArr[40] = 3225;
        sArr[41] = 3225;
        sArr[42] = 3225;
        sArr[43] = 3225;
        sArr[44] = 3225;
        sArr[45] = 3225;
        sArr[46] = 3225;
        sArr[47] = 3225;
        sArr[48] = 3225;
        sArr[49] = 3225;
        sArr[50] = 3225;
        sArr[51] = 3225;
        sArr[52] = 3225;
        sArr[53] = 3225;
        sArr[54] = 3225;
        sArr[55] = 3225;
        sArr[56] = 3225;
        sArr[57] = 3225;
        sArr[58] = 3225;
        sArr[59] = 3225;
        sArr[60] = 3225;
        sArr[61] = 3225;
        sArr[62] = 3225;
        sArr[63] = 3225;
        sArr[64] = 588;
        sArr[65] = 588;
        sArr[66] = 588;
        sArr[67] = 588;
        sArr[68] = 588;
        sArr[69] = 588;
        sArr[70] = 588;
        sArr[71] = 588;
        sArr[72] = 1680;
        sArr[73] = 1680;
        sArr[74] = 20499;
        sArr[75] = 22547;
        sArr[76] = 24595;
        sArr[77] = 26643;
        sArr[78] = 1776;
        sArr[79] = 1776;
        sArr[80] = 1808;
        sArr[81] = 1808;
        sArr[82] = -24557;
        sArr[83] = -22509;
        sArr[84] = -20461;
        sArr[85] = -18413;
        sArr[86] = 1904;
        sArr[87] = 1904;
        sArr[88] = 1936;
        sArr[89] = 1936;
        sArr[90] = -16365;
        sArr[91] = -14317;
        sArr[92] = 782;
        sArr[93] = 782;
        sArr[94] = 782;
        sArr[95] = 782;
        sArr[96] = 814;
        sArr[97] = 814;
        sArr[98] = 814;
        sArr[99] = 814;
        sArr[100] = -12269;
        sArr[101] = -10221;
        sArr[102] = 10257;
        sArr[103] = 10257;
        sArr[104] = 12305;
        sArr[105] = 12305;
        sArr[106] = 14353;
        sArr[107] = 14353;
        sArr[108] = 16403;
        sArr[109] = 18451;
        sArr[110] = 1712;
        sArr[111] = 1712;
        sArr[112] = 1744;
        sArr[113] = 1744;
        sArr[114] = 28691;
        sArr[115] = 30739;
        sArr[116] = -32749;
        sArr[117] = -30701;
        sArr[118] = -28653;
        sArr[119] = -26605;
        sArr[120] = 2061;
        sArr[121] = 2061;
        sArr[122] = 2061;
        sArr[123] = 2061;
        sArr[124] = 2061;
        sArr[125] = 2061;
        sArr[126] = 2061;
        sArr[127] = 2061;
        sArr[128] = 424;
        sArr[129] = 424;
        sArr[130] = 424;
        sArr[131] = 424;
        sArr[132] = 424;
        sArr[133] = 424;
        sArr[134] = 424;
        sArr[135] = 424;
        sArr[136] = 424;
        sArr[137] = 424;
        sArr[138] = 424;
        sArr[139] = 424;
        sArr[140] = 424;
        sArr[141] = 424;
        sArr[142] = 424;
        sArr[143] = 424;
        sArr[144] = 424;
        sArr[145] = 424;
        sArr[146] = 424;
        sArr[147] = 424;
        sArr[148] = 424;
        sArr[149] = 424;
        sArr[150] = 424;
        sArr[151] = 424;
        sArr[152] = 424;
        sArr[153] = 424;
        sArr[154] = 424;
        sArr[155] = 424;
        sArr[156] = 424;
        sArr[157] = 424;
        sArr[158] = 424;
        sArr[159] = 424;
        sArr[160] = 750;
        sArr[161] = 750;
        sArr[162] = 750;
        sArr[163] = 750;
        sArr[164] = 1616;
        sArr[165] = 1616;
        sArr[166] = 1648;
        sArr[167] = 1648;
        sArr[168] = 1424;
        sArr[169] = 1424;
        sArr[170] = 1456;
        sArr[171] = 1456;
        sArr[172] = 1488;
        sArr[173] = 1488;
        sArr[174] = 1520;
        sArr[175] = 1520;
        sArr[176] = 1840;
        sArr[177] = 1840;
        sArr[178] = 1872;
        sArr[179] = 1872;
        sArr[180] = 1968;
        sArr[181] = 1968;
        sArr[182] = 8209;
        sArr[183] = 8209;
        sArr[184] = 524;
        sArr[185] = 524;
        sArr[186] = 524;
        sArr[187] = 524;
        sArr[188] = 524;
        sArr[189] = 524;
        sArr[190] = 524;
        sArr[191] = 524;
        sArr[192] = 556;
        sArr[193] = 556;
        sArr[194] = 556;
        sArr[195] = 556;
        sArr[196] = 556;
        sArr[197] = 556;
        sArr[198] = 556;
        sArr[199] = 556;
        sArr[200] = 1552;
        sArr[201] = 1552;
        sArr[202] = 1584;
        sArr[203] = 1584;
        sArr[204] = 2000;
        sArr[205] = 2000;
        sArr[206] = 2032;
        sArr[207] = 2032;
        sArr[208] = 976;
        sArr[209] = 976;
        sArr[210] = 1008;
        sArr[211] = 1008;
        sArr[212] = 1040;
        sArr[213] = 1040;
        sArr[214] = 1072;
        sArr[215] = 1072;
        sArr[216] = 1296;
        sArr[217] = 1296;
        sArr[218] = 1328;
        sArr[219] = 1328;
        sArr[220] = 718;
        sArr[221] = 718;
        sArr[222] = 718;
        sArr[223] = 718;
        sArr[224] = 456;
        sArr[225] = 456;
        sArr[226] = 456;
        sArr[227] = 456;
        sArr[228] = 456;
        sArr[229] = 456;
        sArr[230] = 456;
        sArr[231] = 456;
        sArr[232] = 456;
        sArr[233] = 456;
        sArr[234] = 456;
        sArr[235] = 456;
        sArr[236] = 456;
        sArr[237] = 456;
        sArr[238] = 456;
        sArr[239] = 456;
        sArr[240] = 456;
        sArr[241] = 456;
        sArr[242] = 456;
        sArr[243] = 456;
        sArr[244] = 456;
        sArr[245] = 456;
        sArr[246] = 456;
        sArr[247] = 456;
        sArr[248] = 456;
        sArr[249] = 456;
        sArr[250] = 456;
        sArr[251] = 456;
        sArr[252] = 456;
        sArr[253] = 456;
        sArr[254] = 456;
        sArr[255] = 456;
        sArr[256] = 326;
        sArr[257] = 326;
        sArr[258] = 326;
        sArr[259] = 326;
        sArr[260] = 326;
        sArr[261] = 326;
        sArr[262] = 326;
        sArr[263] = 326;
        sArr[264] = 326;
        sArr[265] = 326;
        sArr[266] = 326;
        sArr[267] = 326;
        sArr[268] = 326;
        sArr[269] = 326;
        sArr[270] = 326;
        sArr[271] = 326;
        sArr[272] = 326;
        sArr[273] = 326;
        sArr[274] = 326;
        sArr[275] = 326;
        sArr[276] = 326;
        sArr[277] = 326;
        sArr[278] = 326;
        sArr[279] = 326;
        sArr[280] = 326;
        sArr[281] = 326;
        sArr[282] = 326;
        sArr[283] = 326;
        sArr[284] = 326;
        sArr[285] = 326;
        sArr[286] = 326;
        sArr[287] = 326;
        sArr[288] = 326;
        sArr[289] = 326;
        sArr[290] = 326;
        sArr[291] = 326;
        sArr[292] = 326;
        sArr[293] = 326;
        sArr[294] = 326;
        sArr[295] = 326;
        sArr[296] = 326;
        sArr[297] = 326;
        sArr[298] = 326;
        sArr[299] = 326;
        sArr[300] = 326;
        sArr[301] = 326;
        sArr[302] = 326;
        sArr[303] = 326;
        sArr[304] = 326;
        sArr[305] = 326;
        sArr[306] = 326;
        sArr[307] = 326;
        sArr[308] = 326;
        sArr[309] = 326;
        sArr[310] = 326;
        sArr[311] = 326;
        sArr[312] = 326;
        sArr[313] = 326;
        sArr[314] = 326;
        sArr[315] = 326;
        sArr[316] = 326;
        sArr[317] = 326;
        sArr[318] = 326;
        sArr[319] = 326;
        sArr[320] = 358;
        sArr[321] = 358;
        sArr[322] = 358;
        sArr[323] = 358;
        sArr[324] = 358;
        sArr[325] = 358;
        sArr[326] = 358;
        sArr[327] = 358;
        sArr[328] = 358;
        sArr[329] = 358;
        sArr[330] = 358;
        sArr[331] = 358;
        sArr[332] = 358;
        sArr[333] = 358;
        sArr[334] = 358;
        sArr[335] = 358;
        sArr[336] = 358;
        sArr[337] = 358;
        sArr[338] = 358;
        sArr[339] = 358;
        sArr[340] = 358;
        sArr[341] = 358;
        sArr[342] = 358;
        sArr[343] = 358;
        sArr[344] = 358;
        sArr[345] = 358;
        sArr[346] = 358;
        sArr[347] = 358;
        sArr[348] = 358;
        sArr[349] = 358;
        sArr[350] = 358;
        sArr[351] = 358;
        sArr[352] = 358;
        sArr[353] = 358;
        sArr[354] = 358;
        sArr[355] = 358;
        sArr[356] = 358;
        sArr[357] = 358;
        sArr[358] = 358;
        sArr[359] = 358;
        sArr[360] = 358;
        sArr[361] = 358;
        sArr[362] = 358;
        sArr[363] = 358;
        sArr[364] = 358;
        sArr[365] = 358;
        sArr[366] = 358;
        sArr[367] = 358;
        sArr[368] = 358;
        sArr[369] = 358;
        sArr[370] = 358;
        sArr[371] = 358;
        sArr[372] = 358;
        sArr[373] = 358;
        sArr[374] = 358;
        sArr[375] = 358;
        sArr[376] = 358;
        sArr[377] = 358;
        sArr[378] = 358;
        sArr[379] = 358;
        sArr[380] = 358;
        sArr[381] = 358;
        sArr[382] = 358;
        sArr[383] = 358;
        sArr[384] = 490;
        sArr[385] = 490;
        sArr[386] = 490;
        sArr[387] = 490;
        sArr[388] = 490;
        sArr[389] = 490;
        sArr[390] = 490;
        sArr[391] = 490;
        sArr[392] = 490;
        sArr[393] = 490;
        sArr[394] = 490;
        sArr[395] = 490;
        sArr[396] = 490;
        sArr[397] = 490;
        sArr[398] = 490;
        sArr[399] = 490;
        sArr[400] = 4113;
        sArr[401] = 4113;
        sArr[402] = 6161;
        sArr[403] = 6161;
        sArr[404] = 848;
        sArr[405] = 848;
        sArr[406] = 880;
        sArr[407] = 880;
        sArr[408] = 912;
        sArr[409] = 912;
        sArr[410] = 944;
        sArr[411] = 944;
        sArr[412] = 622;
        sArr[413] = 622;
        sArr[414] = 622;
        sArr[415] = 622;
        sArr[416] = 654;
        sArr[417] = 654;
        sArr[418] = 654;
        sArr[419] = 654;
        sArr[420] = 1104;
        sArr[421] = 1104;
        sArr[422] = 1136;
        sArr[423] = 1136;
        sArr[424] = 1168;
        sArr[425] = 1168;
        sArr[426] = 1200;
        sArr[427] = 1200;
        sArr[428] = 1232;
        sArr[429] = 1232;
        sArr[430] = 1264;
        sArr[431] = 1264;
        sArr[432] = 686;
        sArr[433] = 686;
        sArr[434] = 686;
        sArr[435] = 686;
        sArr[436] = 1360;
        sArr[437] = 1360;
        sArr[438] = 1392;
        sArr[439] = 1392;
        sArr[440] = 12;
        sArr[441] = 12;
        sArr[442] = 12;
        sArr[443] = 12;
        sArr[444] = 12;
        sArr[445] = 12;
        sArr[446] = 12;
        sArr[447] = 12;
        sArr[448] = 390;
        sArr[449] = 390;
        sArr[450] = 390;
        sArr[451] = 390;
        sArr[452] = 390;
        sArr[453] = 390;
        sArr[454] = 390;
        sArr[455] = 390;
        sArr[456] = 390;
        sArr[457] = 390;
        sArr[458] = 390;
        sArr[459] = 390;
        sArr[460] = 390;
        sArr[461] = 390;
        sArr[462] = 390;
        sArr[463] = 390;
        sArr[464] = 390;
        sArr[465] = 390;
        sArr[466] = 390;
        sArr[467] = 390;
        sArr[468] = 390;
        sArr[469] = 390;
        sArr[470] = 390;
        sArr[471] = 390;
        sArr[472] = 390;
        sArr[473] = 390;
        sArr[474] = 390;
        sArr[475] = 390;
        sArr[476] = 390;
        sArr[477] = 390;
        sArr[478] = 390;
        sArr[479] = 390;
        sArr[480] = 390;
        sArr[481] = 390;
        sArr[482] = 390;
        sArr[483] = 390;
        sArr[484] = 390;
        sArr[485] = 390;
        sArr[486] = 390;
        sArr[487] = 390;
        sArr[488] = 390;
        sArr[489] = 390;
        sArr[490] = 390;
        sArr[491] = 390;
        sArr[492] = 390;
        sArr[493] = 390;
        sArr[494] = 390;
        sArr[495] = 390;
        sArr[496] = 390;
        sArr[497] = 390;
        sArr[498] = 390;
        sArr[499] = 390;
        sArr[500] = 390;
        sArr[501] = 390;
        sArr[502] = 390;
        sArr[503] = 390;
        sArr[504] = 390;
        sArr[505] = 390;
        sArr[506] = 390;
        sArr[507] = 390;
        sArr[508] = 390;
        sArr[509] = 390;
        sArr[510] = 390;
        sArr[511] = 390;
        black = sArr;
    }

    public TIFFFaxDecoder(int i, int i2, int i3) {
        this.fillOrder = i;
        this.f787w = i2;
        this.f786h = i3;
        this.bitPointer = 0;
        this.bytePointer = 0;
        this.prevChangingElems = new int[i2];
        this.currChangingElems = new int[i2];
    }

    public static void reverseBits(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = flipTable[bArr[i] & 255];
        }
    }

    public void decode1D(byte[] bArr, byte[] bArr2, int i, int i2) {
        this.data = bArr2;
        int i3 = (this.f787w + 7) / 8;
        this.bitPointer = 0;
        this.bytePointer = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i2; i5++) {
            decodeNextScanline(bArr, i4, i);
            i4 += i3;
        }
    }

    public void decodeNextScanline(byte[] bArr, int i, int i2) {
        this.changingElemSize = 0;
        boolean z = true;
        while (true) {
            if (i2 >= this.f787w) {
                break;
            }
            while (z) {
                int nextNBits = nextNBits(10);
                short s = white[nextNBits];
                short s2 = s & 1;
                int i3 = (s >>> 1) & 15;
                if (i3 == 12) {
                    short s3 = additionalMakeup[(12 & (nextNBits << 2)) | nextLesserThan8Bits(2)];
                    i2 += (s3 >>> 4) & C3770w2.f1976b;
                    updatePointer(4 - ((s3 >>> 1) & 7));
                } else if (i3 == 0) {
                    throw new RuntimeException("Invalid code encountered.");
                } else if (i3 != 15) {
                    i2 += (s >>> 5) & 2047;
                    updatePointer(10 - i3);
                    if (s2 == 0) {
                        int[] iArr = this.currChangingElems;
                        int i4 = this.changingElemSize;
                        this.changingElemSize = i4 + 1;
                        iArr[i4] = i2;
                        z = false;
                    }
                } else {
                    throw new RuntimeException("EOL code word encountered in White run.");
                }
            }
            if (i2 != this.f787w) {
                while (!z) {
                    short s4 = initBlack[nextLesserThan8Bits(4)];
                    int i5 = (s4 >>> 1) & 15;
                    int i6 = (s4 >>> 5) & 2047;
                    if (i6 == 100) {
                        short s5 = black[nextNBits(9)];
                        short s6 = s5 & 1;
                        int i7 = (s5 >>> 1) & 15;
                        int i8 = (s5 >>> 5) & 2047;
                        if (i7 == 12) {
                            updatePointer(5);
                            short s7 = additionalMakeup[nextLesserThan8Bits(4)];
                            int i9 = (s7 >>> 4) & C3770w2.f1976b;
                            setToBlack(bArr, i, i2, i9);
                            r15 = i2 + i9;
                            updatePointer(4 - ((s7 >>> 1) & 7));
                        } else if (i7 != 15) {
                            setToBlack(bArr, i, i2, i8);
                            r15 = i2 + i8;
                            updatePointer(9 - i7);
                            if (s6 == 0) {
                                int[] iArr2 = this.currChangingElems;
                                int i10 = this.changingElemSize;
                                this.changingElemSize = i10 + 1;
                                iArr2[i10] = r15;
                            }
                        } else {
                            throw new RuntimeException("EOL code word encountered in Black run.");
                        }
                    } else if (i6 == 200) {
                        short s8 = twoBitBlack[nextLesserThan8Bits(2)];
                        int i11 = (s8 >>> 5) & 2047;
                        setToBlack(bArr, i, i2, i11);
                        r15 = i2 + i11;
                        updatePointer(2 - ((s8 >>> 1) & 15));
                        int[] iArr3 = this.currChangingElems;
                        int i12 = this.changingElemSize;
                        this.changingElemSize = i12 + 1;
                        iArr3[i12] = r15;
                    } else {
                        setToBlack(bArr, i, i2, i6);
                        r15 = i2 + i6;
                        updatePointer(4 - i5);
                        int[] iArr4 = this.currChangingElems;
                        int i13 = this.changingElemSize;
                        this.changingElemSize = i13 + 1;
                        iArr4[i13] = r15;
                    }
                    z = true;
                }
                if (i2 == this.f787w) {
                    if (this.compression == 2) {
                        advancePointer();
                    }
                }
            } else if (this.compression == 2) {
                advancePointer();
            }
        }
        int[] iArr5 = this.currChangingElems;
        int i14 = this.changingElemSize;
        this.changingElemSize = i14 + 1;
        iArr5[i14] = i2;
    }

    public void decode2D(byte[] bArr, byte[] bArr2, int i, int i2, long j) {
        int i3;
        byte[] bArr3 = bArr;
        int i4 = i;
        this.data = bArr2;
        this.compression = 3;
        boolean z = false;
        this.bitPointer = 0;
        this.bytePointer = 0;
        int i5 = (this.f787w + 7) / 8;
        int[] iArr = new int[2];
        this.oneD = (int) (j & 1);
        char c = 1;
        this.uncompressedMode = (int) ((j & 2) >> 1);
        this.fillBits = (int) ((j & 4) >> 2);
        if (readEOL(true) == 1) {
            decodeNextScanline(bArr3, 0, i4);
            int i6 = i5 + 0;
            int i7 = 1;
            int i8 = i2;
            while (i7 < i8) {
                if (readEOL(z) == 0) {
                    int[] iArr2 = this.prevChangingElems;
                    this.prevChangingElems = this.currChangingElems;
                    this.currChangingElems = iArr2;
                    this.lastChangingElement = z ? 1 : 0;
                    int i9 = i4;
                    int i10 = -1;
                    boolean z2 = true;
                    int i11 = 0;
                    char c2 = z;
                    while (i9 < this.f787w) {
                        getNextChangingElement(i10, z2, iArr);
                        int i12 = iArr[c2];
                        i10 = iArr[c];
                        byte b = twoDCodes[nextLesserThan8Bits(7)] & 255;
                        int i13 = (b & 120) >>> 3;
                        byte b2 = b & 7;
                        if (i13 == 0) {
                            if (!z2) {
                                setToBlack(bArr3, i6, i9, i10 - i9);
                            }
                            updatePointer(7 - b2);
                            i9 = i10;
                        } else if (i13 == 1) {
                            updatePointer(7 - b2);
                            if (z2) {
                                int decodeWhiteCodeWord = i9 + decodeWhiteCodeWord();
                                int i14 = i11 + 1;
                                this.currChangingElems[i11] = decodeWhiteCodeWord;
                                int decodeBlackCodeWord = decodeBlackCodeWord();
                                setToBlack(bArr3, i6, decodeWhiteCodeWord, decodeBlackCodeWord);
                                i9 = decodeWhiteCodeWord + decodeBlackCodeWord;
                                i3 = i14 + 1;
                                this.currChangingElems[i14] = i9;
                            } else {
                                int decodeBlackCodeWord2 = decodeBlackCodeWord();
                                setToBlack(bArr3, i6, i9, decodeBlackCodeWord2);
                                int i15 = i9 + decodeBlackCodeWord2;
                                int i16 = i11 + 1;
                                this.currChangingElems[i11] = i15;
                                i9 = i15 + decodeWhiteCodeWord();
                                i3 = i16 + 1;
                                this.currChangingElems[i16] = i9;
                            }
                            i11 = i3;
                            i10 = i9;
                        } else if (i13 <= 8) {
                            int i17 = i12 + (i13 - 5);
                            int i18 = i11 + 1;
                            this.currChangingElems[i11] = i17;
                            if (!z2) {
                                setToBlack(bArr3, i6, i9, i17 - i9);
                            }
                            z2 = !z2;
                            updatePointer(7 - b2);
                            i9 = i17;
                            i10 = i9;
                            i11 = i18;
                        } else {
                            throw new RuntimeException("Invalid code encountered while decoding 2D group 3 compressed data.");
                        }
                        c2 = 0;
                        c = 1;
                    }
                    this.currChangingElems[i11] = i9;
                    this.changingElemSize = i11 + 1;
                } else {
                    decodeNextScanline(bArr3, i6, i4);
                }
                i6 += i5;
                i7++;
                z = false;
                c = 1;
            }
            return;
        }
        throw new RuntimeException("First scanline must be 1D encoded.");
    }

    public void decodeT6(byte[] bArr, byte[] bArr2, int i, int i2, long j) {
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6;
        byte[] bArr3 = bArr;
        this.data = bArr2;
        this.compression = 4;
        int i7 = 0;
        this.bitPointer = 0;
        this.bytePointer = 0;
        int i8 = this.f787w;
        int i9 = (i8 + 7) / 8;
        int[] iArr = new int[2];
        char c = 1;
        this.uncompressedMode = (int) ((j & 2) >> 1);
        int[] iArr2 = this.currChangingElems;
        this.changingElemSize = 0;
        int i10 = this.changingElemSize;
        this.changingElemSize = i10 + 1;
        iArr2[i10] = i8;
        int i11 = this.changingElemSize;
        this.changingElemSize = i11 + 1;
        iArr2[i11] = i8;
        int i12 = i2;
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            int[] iArr3 = this.prevChangingElems;
            this.prevChangingElems = this.currChangingElems;
            this.currChangingElems = iArr3;
            this.lastChangingElement = i7;
            int i15 = i;
            int i16 = -1;
            boolean z2 = true;
            int i17 = 0;
            while (i15 < this.f787w) {
                getNextChangingElement(i16, z2, iArr);
                int i18 = iArr[i7];
                int i19 = iArr[c];
                byte b = twoDCodes[nextLesserThan8Bits(7)] & 255;
                int i20 = (b & 120) >>> 3;
                byte b2 = b & 7;
                if (i20 == 0) {
                    if (!z2) {
                        setToBlack(bArr3, i13, i15, i19 - i15);
                    }
                    updatePointer(7 - b2);
                    i12 = i2;
                    i15 = i19;
                    i16 = i15;
                } else if (i20 == 1) {
                    updatePointer(7 - b2);
                    if (z2) {
                        int decodeWhiteCodeWord = i15 + decodeWhiteCodeWord();
                        int i21 = i17 + 1;
                        iArr3[i17] = decodeWhiteCodeWord;
                        int decodeBlackCodeWord = decodeBlackCodeWord();
                        setToBlack(bArr3, i13, decodeWhiteCodeWord, decodeBlackCodeWord);
                        i5 = decodeWhiteCodeWord + decodeBlackCodeWord;
                        i6 = i21 + 1;
                        iArr3[i21] = i5;
                    } else {
                        int decodeBlackCodeWord2 = decodeBlackCodeWord();
                        setToBlack(bArr3, i13, i15, decodeBlackCodeWord2);
                        int i22 = i15 + decodeBlackCodeWord2;
                        int i23 = i17 + 1;
                        iArr3[i17] = i22;
                        i5 = i22 + decodeWhiteCodeWord();
                        i6 = i23 + 1;
                        iArr3[i23] = i5;
                    }
                    i17 = i6;
                    i16 = i5;
                    i12 = i2;
                    i15 = i16;
                } else if (i20 <= 8) {
                    i16 = i18 + (i20 - 5);
                    int i24 = i17 + 1;
                    iArr3[i17] = i16;
                    if (!z2) {
                        setToBlack(bArr3, i13, i15, i16 - i15);
                    }
                    z2 = !z2;
                    updatePointer(7 - b2);
                    i17 = i24;
                    i15 = i16;
                    i7 = 0;
                    c = 1;
                    i12 = i2;
                } else {
                    if (i20 != 11) {
                        i15 = this.f787w;
                        updatePointer(7 - b2);
                    } else if (nextLesserThan8Bits(3) == 7) {
                        boolean z3 = false;
                        int i25 = 0;
                        while (!z3) {
                            while (nextLesserThan8Bits(1) != 1) {
                                i25++;
                            }
                            if (i25 > 5) {
                                i25 -= 6;
                                if (!z2 && i25 > 0) {
                                    iArr3[i17] = i15;
                                    i17++;
                                }
                                i15 += i25;
                                if (i25 > 0) {
                                    i4 = 1;
                                    z2 = true;
                                } else {
                                    i4 = 1;
                                }
                                if (nextLesserThan8Bits(i4) == 0) {
                                    if (!z2) {
                                        iArr3[i17] = i15;
                                        i17++;
                                    }
                                    z2 = true;
                                } else {
                                    if (z2) {
                                        iArr3[i17] = i15;
                                        i17++;
                                    }
                                    z2 = false;
                                }
                                z3 = true;
                            }
                            if (i25 == 5) {
                                if (!z2) {
                                    iArr3[i17] = i15;
                                    i17++;
                                }
                                i15 += i25;
                                z = true;
                            } else {
                                int i26 = i15 + i25;
                                iArr3[i17] = i26;
                                setToBlack(bArr3, i13, i26, 1);
                                i15 = i26 + 1;
                                i17++;
                                z = false;
                            }
                        }
                    } else {
                        throw new RuntimeException("Invalid code encountered while decoding 2D group 4 compressed data.");
                    }
                    i12 = i2;
                }
                i7 = 0;
                c = 1;
            }
            if (i17 < iArr3.length) {
                i3 = i17 + 1;
                iArr3[i17] = i15;
            } else {
                i3 = i17;
            }
            this.changingElemSize = i3;
            i13 += i9;
        }
    }

    private void setToBlack(byte[] bArr, int i, int i2, int i3) {
        int i4 = (i * 8) + i2;
        int i5 = i3 + i4;
        int i6 = i4 >> 3;
        int i7 = i4 & 7;
        if (i7 > 0) {
            int i8 = 1 << (7 - i7);
            byte b = bArr[i6];
            while (i8 > 0 && i4 < i5) {
                b = (byte) (b | i8);
                i8 >>= 1;
                i4++;
            }
            bArr[i6] = b;
        }
        int i9 = i4 >> 3;
        while (i4 < i5 - 7) {
            bArr[i9] = -1;
            i4 += 8;
            i9++;
        }
        while (i4 < i5) {
            int i10 = i4 >> 3;
            bArr[i10] = (byte) (bArr[i10] | (1 << (7 - (i4 & 7))));
            i4++;
        }
    }

    private int decodeWhiteCodeWord() {
        boolean z = true;
        int i = 0;
        while (z) {
            int nextNBits = nextNBits(10);
            short s = white[nextNBits];
            short s2 = s & 1;
            int i2 = (s >>> 1) & 15;
            if (i2 == 12) {
                short s3 = additionalMakeup[nextLesserThan8Bits(2) | ((nextNBits << 2) & 12)];
                i += (s3 >>> 4) & C3770w2.f1976b;
                updatePointer(4 - ((s3 >>> 1) & 7));
            } else if (i2 == 0) {
                throw new RuntimeException("Invalid code encountered.");
            } else if (i2 != 15) {
                i += (s >>> 5) & 2047;
                updatePointer(10 - i2);
                if (s2 == 0) {
                    z = false;
                }
            } else {
                throw new RuntimeException("EOL code word encountered in White run.");
            }
        }
        return i;
    }

    private int decodeBlackCodeWord() {
        boolean z = false;
        int i = 0;
        while (!z) {
            short s = initBlack[nextLesserThan8Bits(4)];
            int i2 = (s >>> 1) & 15;
            int i3 = (s >>> 5) & 2047;
            if (i3 == 100) {
                short s2 = black[nextNBits(9)];
                short s3 = s2 & 1;
                int i4 = (s2 >>> 1) & 15;
                int i5 = (s2 >>> 5) & 2047;
                if (i4 == 12) {
                    updatePointer(5);
                    short s4 = additionalMakeup[nextLesserThan8Bits(4)];
                    i += (s4 >>> 4) & C3770w2.f1976b;
                    updatePointer(4 - ((s4 >>> 1) & 7));
                } else if (i4 != 15) {
                    i += i5;
                    updatePointer(9 - i4);
                    if (s3 != 0) {
                    }
                } else {
                    throw new RuntimeException("EOL code word encountered in Black run.");
                }
            } else if (i3 == 200) {
                short s5 = twoBitBlack[nextLesserThan8Bits(2)];
                i += (s5 >>> 5) & 2047;
                updatePointer(2 - ((s5 >>> 1) & 15));
            } else {
                i += i3;
                updatePointer(4 - i2);
            }
            z = true;
        }
        return i;
    }

    private int readEOL(boolean z) {
        int nextNBits;
        int i = this.fillBits;
        if (i == 0) {
            int nextNBits2 = nextNBits(12);
            if (z && nextNBits2 == 0 && nextNBits(4) == 1) {
                this.fillBits = 1;
                return 1;
            } else if (nextNBits2 != 1) {
                throw new RuntimeException("Scanline must begin with EOL code word.");
            }
        } else if (i == 1) {
            int i2 = 8 - this.bitPointer;
            if (nextNBits(i2) != 0) {
                throw new RuntimeException("All fill bits preceding EOL code must be 0.");
            } else if (i2 >= 4 || nextNBits(8) == 0) {
                do {
                    nextNBits = nextNBits(8);
                    if (nextNBits == 1) {
                    }
                } while (nextNBits == 0);
                throw new RuntimeException("All fill bits preceding EOL code must be 0.");
            } else {
                throw new RuntimeException("All fill bits preceding EOL code must be 0.");
            }
        }
        if (this.oneD == 0) {
            return 1;
        }
        return nextLesserThan8Bits(1);
    }

    private void getNextChangingElement(int i, boolean z, int[] iArr) {
        int[] iArr2 = this.prevChangingElems;
        int i2 = this.changingElemSize;
        int i3 = this.lastChangingElement;
        int i4 = i3 > 0 ? i3 - 1 : 0;
        int i5 = z ? i4 & -2 : i4 | 1;
        while (true) {
            if (i5 >= i2) {
                break;
            }
            int i6 = iArr2[i5];
            if (i6 > i) {
                this.lastChangingElement = i5;
                iArr[0] = i6;
                break;
            }
            i5 += 2;
        }
        int i7 = i5 + 1;
        if (i7 < i2) {
            iArr[1] = iArr2[i7];
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int nextNBits(int r12) {
        /*
            r11 = this;
            byte[] r0 = r11.data
            int r1 = r0.length
            r2 = 1
            int r1 = r1 - r2
            int r3 = r11.bytePointer
            int r4 = r11.fillOrder
            r5 = 2
            r6 = 0
            if (r4 != r2) goto L_0x0024
            byte r4 = r0[r3]
            if (r3 != r1) goto L_0x0014
        L_0x0011:
            r0 = 0
        L_0x0012:
            r1 = 0
            goto L_0x004d
        L_0x0014:
            int r7 = r3 + 1
            if (r7 != r1) goto L_0x001b
            byte r0 = r0[r7]
            goto L_0x0012
        L_0x001b:
            byte r1 = r0[r7]
            int r3 = r3 + r5
            byte r0 = r0[r3]
        L_0x0020:
            r10 = r1
            r1 = r0
            r0 = r10
            goto L_0x004d
        L_0x0024:
            if (r4 != r5) goto L_0x0091
            byte[] r4 = flipTable
            byte r7 = r0[r3]
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = r4[r7]
            if (r3 != r1) goto L_0x0032
            r4 = r7
            goto L_0x0011
        L_0x0032:
            int r8 = r3 + 1
            if (r8 != r1) goto L_0x003e
            byte r0 = r0[r8]
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = r4[r0]
            r4 = r7
            goto L_0x0012
        L_0x003e:
            byte r1 = r0[r8]
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r1 = r4[r1]
            int r3 = r3 + r5
            byte r0 = r0[r3]
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = r4[r0]
            r4 = r7
            goto L_0x0020
        L_0x004d:
            int r3 = r11.bitPointer
            r5 = 8
            int r3 = 8 - r3
            int r12 = r12 - r3
            if (r12 <= r5) goto L_0x005c
            int r7 = r12 + -8
            r8 = r7
            r7 = 8
            goto L_0x005e
        L_0x005c:
            r7 = r12
            r8 = 0
        L_0x005e:
            int r9 = r11.bytePointer
            int r9 = r9 + r2
            r11.bytePointer = r9
            int[] r9 = table1
            r3 = r9[r3]
            r3 = r3 & r4
            int r12 = r3 << r12
            int[] r3 = table2
            r4 = r3[r7]
            r0 = r0 & r4
            int r4 = 8 - r7
            int r0 = r0 >>> r4
            if (r8 == 0) goto L_0x0083
            int r0 = r0 << r8
            r3 = r3[r8]
            r1 = r1 & r3
            int r5 = r5 - r8
            int r1 = r1 >>> r5
            r0 = r0 | r1
            int r1 = r11.bytePointer
            int r1 = r1 + r2
            r11.bytePointer = r1
            r11.bitPointer = r8
            goto L_0x008f
        L_0x0083:
            if (r7 != r5) goto L_0x008d
            r11.bitPointer = r6
            int r1 = r11.bytePointer
            int r1 = r1 + r2
            r11.bytePointer = r1
            goto L_0x008f
        L_0x008d:
            r11.bitPointer = r7
        L_0x008f:
            r12 = r12 | r0
            return r12
        L_0x0091:
            java.lang.RuntimeException r12 = new java.lang.RuntimeException
            java.lang.String r0 = "TIFF_FILL_ORDER tag must be either 1 or 2."
            r12.<init>(r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.codec.TIFFFaxDecoder.nextNBits(int):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int nextLesserThan8Bits(int r10) {
        /*
            r9 = this;
            byte[] r0 = r9.data
            int r1 = r0.length
            r2 = 1
            int r1 = r1 - r2
            int r3 = r9.bytePointer
            int r4 = r9.fillOrder
            r5 = 0
            if (r4 != r2) goto L_0x0016
            byte r4 = r0[r3]
            if (r3 != r1) goto L_0x0012
        L_0x0010:
            r0 = 0
            goto L_0x002d
        L_0x0012:
            int r3 = r3 + r2
            byte r0 = r0[r3]
            goto L_0x002d
        L_0x0016:
            r6 = 2
            if (r4 != r6) goto L_0x0065
            byte[] r4 = flipTable
            byte r6 = r0[r3]
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte r6 = r4[r6]
            if (r3 != r1) goto L_0x0025
            r4 = r6
            goto L_0x0010
        L_0x0025:
            int r3 = r3 + r2
            byte r0 = r0[r3]
            r0 = r0 & 255(0xff, float:3.57E-43)
            byte r0 = r4[r0]
            r4 = r6
        L_0x002d:
            int r1 = r9.bitPointer
            r3 = 8
            int r6 = 8 - r1
            int r7 = r10 - r6
            int r8 = r6 - r10
            if (r8 < 0) goto L_0x004e
            int[] r0 = table1
            r0 = r0[r6]
            r0 = r0 & r4
            int r0 = r0 >>> r8
            int r1 = r1 + r10
            r9.bitPointer = r1
            int r10 = r9.bitPointer
            if (r10 != r3) goto L_0x0064
            r9.bitPointer = r5
            int r10 = r9.bytePointer
            int r10 = r10 + r2
            r9.bytePointer = r10
            goto L_0x0064
        L_0x004e:
            int[] r10 = table1
            r10 = r10[r6]
            r10 = r10 & r4
            int r1 = -r8
            int r10 = r10 << r1
            int[] r1 = table2
            r1 = r1[r7]
            r0 = r0 & r1
            int r3 = r3 - r7
            int r0 = r0 >>> r3
            r0 = r0 | r10
            int r10 = r9.bytePointer
            int r10 = r10 + r2
            r9.bytePointer = r10
            r9.bitPointer = r7
        L_0x0064:
            return r0
        L_0x0065:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException
            java.lang.String r0 = "TIFF_FILL_ORDER tag must be either 1 or 2."
            r10.<init>(r0)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.codec.TIFFFaxDecoder.nextLesserThan8Bits(int):int");
    }

    private void updatePointer(int i) {
        int i2 = this.bitPointer - i;
        if (i2 < 0) {
            this.bytePointer--;
            this.bitPointer = i2 + 8;
            return;
        }
        this.bitPointer = i2;
    }

    private boolean advancePointer() {
        if (this.bitPointer != 0) {
            this.bytePointer++;
            this.bitPointer = 0;
        }
        return true;
    }
}
