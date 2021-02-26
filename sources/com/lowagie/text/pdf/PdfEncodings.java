package com.lowagie.text.pdf;

import com.google.common.base.Ascii;
import com.lowagie.text.DocWriter;
import com.lowagie.text.ExceptionConverter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import kotlin.text.Typography;

public class PdfEncodings {
    protected static final int CIDCHAR = 2;
    protected static final int CIDNONE = 0;
    protected static final int CIDRANGE = 1;
    public static final byte[][] CRLF_CID_NEWLINE = {new byte[]{10}, new byte[]{13, 10}};
    static final HashMap cmaps = new HashMap();
    static HashMap extraEncodings = new HashMap();
    static final IntHashtable pdfEncoding = new IntHashtable();
    static final char[] pdfEncodingByteToChar;
    static final IntHashtable winansi = new IntHashtable();
    static final char[] winansiByteToChar;

    static {
        char[] cArr = new char[256];
        cArr[1] = 1;
        cArr[2] = 2;
        cArr[3] = 3;
        cArr[4] = 4;
        cArr[5] = 5;
        cArr[6] = 6;
        cArr[7] = 7;
        cArr[8] = 8;
        cArr[9] = 9;
        cArr[10] = 10;
        cArr[11] = 11;
        cArr[12] = 12;
        cArr[13] = 13;
        cArr[14] = 14;
        cArr[15] = 15;
        cArr[16] = 16;
        cArr[17] = 17;
        cArr[18] = 18;
        cArr[19] = 19;
        cArr[20] = 20;
        cArr[21] = 21;
        cArr[22] = 22;
        cArr[23] = 23;
        cArr[24] = 24;
        cArr[25] = 25;
        cArr[26] = 26;
        cArr[27] = 27;
        cArr[28] = 28;
        cArr[29] = 29;
        cArr[30] = 30;
        cArr[31] = 31;
        cArr[32] = ' ';
        cArr[33] = '!';
        cArr[34] = Typography.quote;
        cArr[35] = '#';
        cArr[36] = Typography.dollar;
        cArr[37] = '%';
        cArr[38] = Typography.amp;
        cArr[39] = '\'';
        cArr[40] = '(';
        cArr[41] = ')';
        cArr[42] = '*';
        cArr[43] = '+';
        cArr[44] = ',';
        cArr[45] = '-';
        cArr[46] = '.';
        cArr[47] = '/';
        cArr[48] = '0';
        cArr[49] = '1';
        cArr[50] = PdfWriter.VERSION_1_2;
        cArr[51] = PdfWriter.VERSION_1_3;
        cArr[52] = PdfWriter.VERSION_1_4;
        cArr[53] = PdfWriter.VERSION_1_5;
        cArr[54] = PdfWriter.VERSION_1_6;
        cArr[55] = PdfWriter.VERSION_1_7;
        cArr[56] = '8';
        cArr[57] = '9';
        cArr[58] = ':';
        cArr[59] = ';';
        cArr[60] = Typography.less;
        cArr[61] = '=';
        cArr[62] = Typography.greater;
        cArr[63] = '?';
        cArr[64] = '@';
        cArr[65] = 'A';
        cArr[66] = 'B';
        cArr[67] = 'C';
        cArr[68] = 'D';
        cArr[69] = 'E';
        cArr[70] = 'F';
        cArr[71] = 'G';
        cArr[72] = 'H';
        cArr[73] = 'I';
        cArr[74] = 'J';
        cArr[75] = 'K';
        cArr[76] = 'L';
        cArr[77] = 'M';
        cArr[78] = 'N';
        cArr[79] = 'O';
        cArr[80] = 'P';
        cArr[81] = 'Q';
        cArr[82] = 'R';
        cArr[83] = 'S';
        cArr[84] = 'T';
        cArr[85] = 'U';
        cArr[86] = 'V';
        cArr[87] = 'W';
        cArr[88] = 'X';
        cArr[89] = 'Y';
        cArr[90] = 'Z';
        cArr[91] = '[';
        cArr[92] = '\\';
        cArr[93] = ']';
        cArr[94] = '^';
        cArr[95] = '_';
        cArr[96] = '`';
        cArr[97] = 'a';
        cArr[98] = 'b';
        cArr[99] = Barcode128.CODE_AB_TO_C;
        cArr[100] = Barcode128.CODE_AC_TO_B;
        cArr[101] = Barcode128.CODE_BC_TO_A;
        cArr[102] = Barcode128.FNC1_INDEX;
        cArr[103] = Barcode128.START_A;
        cArr[104] = Barcode128.START_B;
        cArr[105] = Barcode128.START_C;
        cArr[106] = 'j';
        cArr[107] = 'k';
        cArr[108] = 'l';
        cArr[109] = 'm';
        cArr[110] = 'n';
        cArr[111] = 'o';
        cArr[112] = 'p';
        cArr[113] = 'q';
        cArr[114] = 'r';
        cArr[115] = 's';
        cArr[116] = 't';
        cArr[117] = 'u';
        cArr[118] = 'v';
        cArr[119] = 'w';
        cArr[120] = 'x';
        cArr[121] = 'y';
        cArr[122] = 'z';
        cArr[123] = '{';
        cArr[124] = '|';
        cArr[125] = '}';
        cArr[126] = '~';
        cArr[127] = Ascii.MAX;
        cArr[128] = Typography.euro;
        cArr[129] = 65533;
        cArr[130] = Typography.lowSingleQuote;
        cArr[131] = 402;
        cArr[132] = Typography.lowDoubleQuote;
        cArr[133] = Typography.ellipsis;
        cArr[134] = Typography.f6321dagger;
        cArr[135] = Typography.doubleDagger;
        cArr[136] = 710;
        cArr[137] = 8240;
        cArr[138] = 352;
        cArr[139] = 8249;
        cArr[140] = 338;
        cArr[141] = 65533;
        cArr[142] = 381;
        cArr[143] = 65533;
        cArr[144] = 65533;
        cArr[145] = Typography.leftSingleQuote;
        cArr[146] = Typography.rightSingleQuote;
        cArr[147] = Typography.leftDoubleQuote;
        cArr[148] = Typography.rightDoubleQuote;
        cArr[149] = Typography.bullet;
        cArr[150] = Typography.ndash;
        cArr[151] = Typography.mdash;
        cArr[152] = 732;
        cArr[153] = Typography.f5414tm;
        cArr[154] = 353;
        cArr[155] = 8250;
        cArr[156] = 339;
        cArr[157] = 65533;
        cArr[158] = 382;
        cArr[159] = 376;
        cArr[160] = Typography.nbsp;
        cArr[161] = 161;
        cArr[162] = Typography.cent;
        cArr[163] = Typography.pound;
        cArr[164] = 164;
        cArr[165] = 165;
        cArr[166] = 166;
        cArr[167] = Typography.section;
        cArr[168] = 168;
        cArr[169] = Typography.copyright;
        cArr[170] = 170;
        cArr[171] = Typography.leftGuillemete;
        cArr[172] = 172;
        cArr[173] = 173;
        cArr[174] = Typography.registered;
        cArr[175] = 175;
        cArr[176] = Typography.degree;
        cArr[177] = Typography.plusMinus;
        cArr[178] = 178;
        cArr[179] = 179;
        cArr[180] = 180;
        cArr[181] = 181;
        cArr[182] = Typography.paragraph;
        cArr[183] = Typography.middleDot;
        cArr[184] = 184;
        cArr[185] = 185;
        cArr[186] = 186;
        cArr[187] = Typography.rightGuillemete;
        cArr[188] = 188;
        cArr[189] = Typography.half;
        cArr[190] = 190;
        cArr[191] = 191;
        cArr[192] = 192;
        cArr[193] = 193;
        cArr[194] = 194;
        cArr[195] = Barcode128.DEL;
        cArr[196] = Barcode128.FNC3;
        cArr[197] = Barcode128.FNC2;
        cArr[198] = Barcode128.SHIFT;
        cArr[199] = Barcode128.CODE_C;
        cArr[200] = 200;
        cArr[201] = 201;
        cArr[202] = Barcode128.FNC1;
        cArr[203] = Barcode128.STARTA;
        cArr[204] = Barcode128.STARTB;
        cArr[205] = Barcode128.STARTC;
        cArr[206] = 206;
        cArr[207] = 207;
        cArr[208] = 208;
        cArr[209] = 209;
        cArr[210] = 210;
        cArr[211] = 211;
        cArr[212] = 212;
        cArr[213] = 213;
        cArr[214] = 214;
        cArr[215] = Typography.times;
        cArr[216] = 216;
        cArr[217] = 217;
        cArr[218] = 218;
        cArr[219] = 219;
        cArr[220] = 220;
        cArr[221] = 221;
        cArr[222] = 222;
        cArr[223] = 223;
        cArr[224] = 224;
        cArr[225] = 225;
        cArr[226] = 226;
        cArr[227] = 227;
        cArr[228] = 228;
        cArr[229] = 229;
        cArr[230] = 230;
        cArr[231] = 231;
        cArr[232] = 232;
        cArr[233] = 233;
        cArr[234] = 234;
        cArr[235] = 235;
        cArr[236] = 236;
        cArr[237] = 237;
        cArr[238] = 238;
        cArr[239] = 239;
        cArr[240] = 240;
        cArr[241] = 241;
        cArr[242] = 242;
        cArr[243] = 243;
        cArr[244] = 244;
        cArr[245] = 245;
        cArr[246] = 246;
        cArr[247] = 247;
        cArr[248] = 248;
        cArr[249] = 249;
        cArr[250] = 250;
        cArr[251] = 251;
        cArr[252] = 252;
        cArr[253] = 253;
        cArr[254] = 254;
        cArr[255] = 255;
        winansiByteToChar = cArr;
        char[] cArr2 = new char[256];
        cArr2[1] = 1;
        cArr2[2] = 2;
        cArr2[3] = 3;
        cArr2[4] = 4;
        cArr2[5] = 5;
        cArr2[6] = 6;
        cArr2[7] = 7;
        cArr2[8] = 8;
        cArr2[9] = 9;
        cArr2[10] = 10;
        cArr2[11] = 11;
        cArr2[12] = 12;
        cArr2[13] = 13;
        cArr2[14] = 14;
        cArr2[15] = 15;
        cArr2[16] = 16;
        cArr2[17] = 17;
        cArr2[18] = 18;
        cArr2[19] = 19;
        cArr2[20] = 20;
        cArr2[21] = 21;
        cArr2[22] = 22;
        cArr2[23] = 23;
        cArr2[24] = 24;
        cArr2[25] = 25;
        cArr2[26] = 26;
        cArr2[27] = 27;
        cArr2[28] = 28;
        cArr2[29] = 29;
        cArr2[30] = 30;
        cArr2[31] = 31;
        cArr2[32] = ' ';
        cArr2[33] = '!';
        cArr2[34] = Typography.quote;
        cArr2[35] = '#';
        cArr2[36] = Typography.dollar;
        cArr2[37] = '%';
        cArr2[38] = Typography.amp;
        cArr2[39] = '\'';
        cArr2[40] = '(';
        cArr2[41] = ')';
        cArr2[42] = '*';
        cArr2[43] = '+';
        cArr2[44] = ',';
        cArr2[45] = '-';
        cArr2[46] = '.';
        cArr2[47] = '/';
        cArr2[48] = '0';
        cArr2[49] = '1';
        cArr2[50] = PdfWriter.VERSION_1_2;
        cArr2[51] = PdfWriter.VERSION_1_3;
        cArr2[52] = PdfWriter.VERSION_1_4;
        cArr2[53] = PdfWriter.VERSION_1_5;
        cArr2[54] = PdfWriter.VERSION_1_6;
        cArr2[55] = PdfWriter.VERSION_1_7;
        cArr2[56] = '8';
        cArr2[57] = '9';
        cArr2[58] = ':';
        cArr2[59] = ';';
        cArr2[60] = Typography.less;
        cArr2[61] = '=';
        cArr2[62] = Typography.greater;
        cArr2[63] = '?';
        cArr2[64] = '@';
        cArr2[65] = 'A';
        cArr2[66] = 'B';
        cArr2[67] = 'C';
        cArr2[68] = 'D';
        cArr2[69] = 'E';
        cArr2[70] = 'F';
        cArr2[71] = 'G';
        cArr2[72] = 'H';
        cArr2[73] = 'I';
        cArr2[74] = 'J';
        cArr2[75] = 'K';
        cArr2[76] = 'L';
        cArr2[77] = 'M';
        cArr2[78] = 'N';
        cArr2[79] = 'O';
        cArr2[80] = 'P';
        cArr2[81] = 'Q';
        cArr2[82] = 'R';
        cArr2[83] = 'S';
        cArr2[84] = 'T';
        cArr2[85] = 'U';
        cArr2[86] = 'V';
        cArr2[87] = 'W';
        cArr2[88] = 'X';
        cArr2[89] = 'Y';
        cArr2[90] = 'Z';
        cArr2[91] = '[';
        cArr2[92] = '\\';
        cArr2[93] = ']';
        cArr2[94] = '^';
        cArr2[95] = '_';
        cArr2[96] = '`';
        cArr2[97] = 'a';
        cArr2[98] = 'b';
        cArr2[99] = Barcode128.CODE_AB_TO_C;
        cArr2[100] = Barcode128.CODE_AC_TO_B;
        cArr2[101] = Barcode128.CODE_BC_TO_A;
        cArr2[102] = Barcode128.FNC1_INDEX;
        cArr2[103] = Barcode128.START_A;
        cArr2[104] = Barcode128.START_B;
        cArr2[105] = Barcode128.START_C;
        cArr2[106] = 'j';
        cArr2[107] = 'k';
        cArr2[108] = 'l';
        cArr2[109] = 'm';
        cArr2[110] = 'n';
        cArr2[111] = 'o';
        cArr2[112] = 'p';
        cArr2[113] = 'q';
        cArr2[114] = 'r';
        cArr2[115] = 's';
        cArr2[116] = 't';
        cArr2[117] = 'u';
        cArr2[118] = 'v';
        cArr2[119] = 'w';
        cArr2[120] = 'x';
        cArr2[121] = 'y';
        cArr2[122] = 'z';
        cArr2[123] = '{';
        cArr2[124] = '|';
        cArr2[125] = '}';
        cArr2[126] = '~';
        cArr2[127] = Ascii.MAX;
        cArr2[128] = Typography.bullet;
        cArr2[129] = Typography.f6321dagger;
        cArr2[130] = Typography.doubleDagger;
        cArr2[131] = Typography.ellipsis;
        cArr2[132] = Typography.mdash;
        cArr2[133] = Typography.ndash;
        cArr2[134] = 402;
        cArr2[135] = 8260;
        cArr2[136] = 8249;
        cArr2[137] = 8250;
        cArr2[138] = 8722;
        cArr2[139] = 8240;
        cArr2[140] = Typography.lowDoubleQuote;
        cArr2[141] = Typography.leftDoubleQuote;
        cArr2[142] = Typography.rightDoubleQuote;
        cArr2[143] = Typography.leftSingleQuote;
        cArr2[144] = Typography.rightSingleQuote;
        cArr2[145] = Typography.lowSingleQuote;
        cArr2[146] = Typography.f5414tm;
        cArr2[147] = 64257;
        cArr2[148] = 64258;
        cArr2[149] = 321;
        cArr2[150] = 338;
        cArr2[151] = 352;
        cArr2[152] = 376;
        cArr2[153] = 381;
        cArr2[154] = 305;
        cArr2[155] = 322;
        cArr2[156] = 339;
        cArr2[157] = 353;
        cArr2[158] = 382;
        cArr2[159] = 65533;
        cArr2[160] = Typography.euro;
        cArr2[161] = 161;
        cArr2[162] = Typography.cent;
        cArr2[163] = Typography.pound;
        cArr2[164] = 164;
        cArr2[165] = 165;
        cArr2[166] = 166;
        cArr2[167] = Typography.section;
        cArr2[168] = 168;
        cArr2[169] = Typography.copyright;
        cArr2[170] = 170;
        cArr2[171] = Typography.leftGuillemete;
        cArr2[172] = 172;
        cArr2[173] = 173;
        cArr2[174] = Typography.registered;
        cArr2[175] = 175;
        cArr2[176] = Typography.degree;
        cArr2[177] = Typography.plusMinus;
        cArr2[178] = 178;
        cArr2[179] = 179;
        cArr2[180] = 180;
        cArr2[181] = 181;
        cArr2[182] = Typography.paragraph;
        cArr2[183] = Typography.middleDot;
        cArr2[184] = 184;
        cArr2[185] = 185;
        cArr2[186] = 186;
        cArr2[187] = Typography.rightGuillemete;
        cArr2[188] = 188;
        cArr2[189] = Typography.half;
        cArr2[190] = 190;
        cArr2[191] = 191;
        cArr2[192] = 192;
        cArr2[193] = 193;
        cArr2[194] = 194;
        cArr2[195] = Barcode128.DEL;
        cArr2[196] = Barcode128.FNC3;
        cArr2[197] = Barcode128.FNC2;
        cArr2[198] = Barcode128.SHIFT;
        cArr2[199] = Barcode128.CODE_C;
        cArr2[200] = 200;
        cArr2[201] = 201;
        cArr2[202] = Barcode128.FNC1;
        cArr2[203] = Barcode128.STARTA;
        cArr2[204] = Barcode128.STARTB;
        cArr2[205] = Barcode128.STARTC;
        cArr2[206] = 206;
        cArr2[207] = 207;
        cArr2[208] = 208;
        cArr2[209] = 209;
        cArr2[210] = 210;
        cArr2[211] = 211;
        cArr2[212] = 212;
        cArr2[213] = 213;
        cArr2[214] = 214;
        cArr2[215] = Typography.times;
        cArr2[216] = 216;
        cArr2[217] = 217;
        cArr2[218] = 218;
        cArr2[219] = 219;
        cArr2[220] = 220;
        cArr2[221] = 221;
        cArr2[222] = 222;
        cArr2[223] = 223;
        cArr2[224] = 224;
        cArr2[225] = 225;
        cArr2[226] = 226;
        cArr2[227] = 227;
        cArr2[228] = 228;
        cArr2[229] = 229;
        cArr2[230] = 230;
        cArr2[231] = 231;
        cArr2[232] = 232;
        cArr2[233] = 233;
        cArr2[234] = 234;
        cArr2[235] = 235;
        cArr2[236] = 236;
        cArr2[237] = 237;
        cArr2[238] = 238;
        cArr2[239] = 239;
        cArr2[240] = 240;
        cArr2[241] = 241;
        cArr2[242] = 242;
        cArr2[243] = 243;
        cArr2[244] = 244;
        cArr2[245] = 245;
        cArr2[246] = 246;
        cArr2[247] = 247;
        cArr2[248] = 248;
        cArr2[249] = 249;
        cArr2[250] = 250;
        cArr2[251] = 251;
        cArr2[252] = 252;
        cArr2[253] = 253;
        cArr2[254] = 254;
        cArr2[255] = 255;
        pdfEncodingByteToChar = cArr2;
        for (int i = 128; i < 161; i++) {
            char c = winansiByteToChar[i];
            if (c != 65533) {
                winansi.put(c, i);
            }
        }
        for (int i2 = 128; i2 < 161; i2++) {
            char c2 = pdfEncodingByteToChar[i2];
            if (c2 != 65533) {
                pdfEncoding.put(c2, i2);
            }
        }
        addExtraEncoding("Wingdings", new WingdingsConversion((WingdingsConversion) null));
        addExtraEncoding("Symbol", new SymbolConversion(true));
        addExtraEncoding("ZapfDingbats", new SymbolConversion(false));
        addExtraEncoding("SymbolTT", new SymbolTTConversion((SymbolTTConversion) null));
        addExtraEncoding("Cp437", new Cp437Conversion((Cp437Conversion) null));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v6, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: char} */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x005d, code lost:
        if (r6 <= 255) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0060, code lost:
        r6 = r1.get(r6);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final byte[] convertToBytes(java.lang.String r8, java.lang.String r9) {
        /*
            r0 = 0
            if (r8 != 0) goto L_0x0006
            byte[] r8 = new byte[r0]
            return r8
        L_0x0006:
            if (r9 == 0) goto L_0x00ab
            int r1 = r9.length()
            if (r1 != 0) goto L_0x0010
            goto L_0x00ab
        L_0x0010:
            java.util.HashMap r1 = extraEncodings
            java.lang.String r2 = r9.toLowerCase()
            java.lang.Object r1 = r1.get(r2)
            com.lowagie.text.pdf.ExtraEncoding r1 = (com.lowagie.text.pdf.ExtraEncoding) r1
            if (r1 == 0) goto L_0x0025
            byte[] r1 = r1.charToByte((java.lang.String) r8, (java.lang.String) r9)
            if (r1 == 0) goto L_0x0025
            return r1
        L_0x0025:
            r1 = 0
            java.lang.String r2 = "Cp1252"
            boolean r2 = r9.equals(r2)
            if (r2 == 0) goto L_0x0031
            com.lowagie.text.pdf.IntHashtable r1 = winansi
            goto L_0x003b
        L_0x0031:
            java.lang.String r2 = "PDF"
            boolean r2 = r9.equals(r2)
            if (r2 == 0) goto L_0x003b
            com.lowagie.text.pdf.IntHashtable r1 = pdfEncoding
        L_0x003b:
            r2 = 255(0xff, float:3.57E-43)
            if (r1 == 0) goto L_0x006f
            char[] r3 = r8.toCharArray()
            int r4 = r3.length
            byte[] r5 = new byte[r4]
            r8 = 0
            r9 = 0
        L_0x0048:
            if (r8 < r4) goto L_0x0053
            if (r9 != r4) goto L_0x004d
            return r5
        L_0x004d:
            byte[] r8 = new byte[r9]
            java.lang.System.arraycopy(r5, r0, r8, r0, r9)
            return r8
        L_0x0053:
            char r6 = r3[r8]
            r7 = 128(0x80, float:1.794E-43)
            if (r6 < r7) goto L_0x0064
            r7 = 160(0xa0, float:2.24E-43)
            if (r6 <= r7) goto L_0x0060
            if (r6 > r2) goto L_0x0060
            goto L_0x0064
        L_0x0060:
            int r6 = r1.get(r6)
        L_0x0064:
            if (r6 == 0) goto L_0x006c
            int r7 = r9 + 1
            byte r6 = (byte) r6
            r5[r9] = r6
            r9 = r7
        L_0x006c:
            int r8 = r8 + 1
            goto L_0x0048
        L_0x006f:
            java.lang.String r1 = "UnicodeBig"
            boolean r1 = r9.equals(r1)
            if (r1 == 0) goto L_0x009f
            char[] r1 = r8.toCharArray()
            int r3 = r1.length
            int r8 = r1.length
            r9 = 2
            int r8 = r8 * 2
            int r8 = r8 + r9
            byte[] r4 = new byte[r8]
            r8 = -2
            r4[r0] = r8
            r8 = -1
            r5 = 1
            r4[r5] = r8
        L_0x008a:
            if (r0 < r3) goto L_0x008d
            return r4
        L_0x008d:
            char r8 = r1[r0]
            int r5 = r9 + 1
            int r6 = r8 >> 8
            byte r6 = (byte) r6
            r4[r9] = r6
            int r9 = r5 + 1
            r8 = r8 & r2
            byte r8 = (byte) r8
            r4[r5] = r8
            int r0 = r0 + 1
            goto L_0x008a
        L_0x009f:
            byte[] r8 = r8.getBytes(r9)     // Catch:{ UnsupportedEncodingException -> 0x00a4 }
            return r8
        L_0x00a4:
            r8 = move-exception
            com.lowagie.text.ExceptionConverter r9 = new com.lowagie.text.ExceptionConverter
            r9.<init>(r8)
            throw r9
        L_0x00ab:
            int r9 = r8.length()
            byte[] r1 = new byte[r9]
        L_0x00b1:
            if (r0 < r9) goto L_0x00b4
            return r1
        L_0x00b4:
            char r2 = r8.charAt(r0)
            byte r2 = (byte) r2
            r1[r0] = r2
            int r0 = r0 + 1
            goto L_0x00b1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.PdfEncodings.convertToBytes(java.lang.String, java.lang.String):byte[]");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: char} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v13, resolved type: char} */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0043, code lost:
        if (r4 <= 255) goto L_0x004a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0046, code lost:
        r4 = r2.get(r4);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final byte[] convertToBytes(char r4, java.lang.String r5) {
        /*
            r0 = 1
            r1 = 0
            if (r5 == 0) goto L_0x0082
            int r2 = r5.length()
            if (r2 != 0) goto L_0x000c
            goto L_0x0082
        L_0x000c:
            java.util.HashMap r2 = extraEncodings
            java.lang.String r3 = r5.toLowerCase()
            java.lang.Object r2 = r2.get(r3)
            com.lowagie.text.pdf.ExtraEncoding r2 = (com.lowagie.text.pdf.ExtraEncoding) r2
            if (r2 == 0) goto L_0x0021
            byte[] r2 = r2.charToByte((char) r4, (java.lang.String) r5)
            if (r2 == 0) goto L_0x0021
            return r2
        L_0x0021:
            r2 = 0
            java.lang.String r3 = "Cp1252"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x002d
            com.lowagie.text.pdf.IntHashtable r2 = winansi
            goto L_0x0037
        L_0x002d:
            java.lang.String r3 = "PDF"
            boolean r3 = r5.equals(r3)
            if (r3 == 0) goto L_0x0037
            com.lowagie.text.pdf.IntHashtable r2 = pdfEncoding
        L_0x0037:
            r3 = 255(0xff, float:3.57E-43)
            if (r2 == 0) goto L_0x0055
            r5 = 128(0x80, float:1.794E-43)
            if (r4 < r5) goto L_0x004a
            r5 = 160(0xa0, float:2.24E-43)
            if (r4 <= r5) goto L_0x0046
            if (r4 > r3) goto L_0x0046
            goto L_0x004a
        L_0x0046:
            int r4 = r2.get(r4)
        L_0x004a:
            if (r4 == 0) goto L_0x0052
            byte[] r5 = new byte[r0]
            byte r4 = (byte) r4
            r5[r1] = r4
            return r5
        L_0x0052:
            byte[] r4 = new byte[r1]
            return r4
        L_0x0055:
            java.lang.String r2 = "UnicodeBig"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0072
            r5 = 4
            byte[] r5 = new byte[r5]
            r2 = -2
            r5[r1] = r2
            r1 = -1
            r5[r0] = r1
            r0 = 2
            int r1 = r4 >> 8
            byte r1 = (byte) r1
            r5[r0] = r1
            r0 = 3
            r4 = r4 & r3
            byte r4 = (byte) r4
            r5[r0] = r4
            return r5
        L_0x0072:
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ UnsupportedEncodingException -> 0x007b }
            byte[] r4 = r4.getBytes(r5)     // Catch:{ UnsupportedEncodingException -> 0x007b }
            return r4
        L_0x007b:
            r4 = move-exception
            com.lowagie.text.ExceptionConverter r5 = new com.lowagie.text.ExceptionConverter
            r5.<init>(r4)
            throw r5
        L_0x0082:
            byte[] r5 = new byte[r0]
            byte r4 = (byte) r4
            r5[r1] = r4
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.PdfEncodings.convertToBytes(char, java.lang.String):byte[]");
    }

    public static final String convertToString(byte[] bArr, String str) {
        String byteToChar;
        if (bArr == null) {
            return "";
        }
        int i = 0;
        if (str == null || str.length() == 0) {
            char[] cArr = new char[bArr.length];
            while (i < bArr.length) {
                cArr[i] = (char) (bArr[i] & 255);
                i++;
            }
            return new String(cArr);
        }
        ExtraEncoding extraEncoding = (ExtraEncoding) extraEncodings.get(str.toLowerCase());
        if (extraEncoding != null && (byteToChar = extraEncoding.byteToChar(bArr, str)) != null) {
            return byteToChar;
        }
        char[] cArr2 = null;
        if (str.equals("Cp1252")) {
            cArr2 = winansiByteToChar;
        } else if (str.equals(PdfObject.TEXT_PDFDOCENCODING)) {
            cArr2 = pdfEncodingByteToChar;
        }
        if (cArr2 != null) {
            int length = bArr.length;
            char[] cArr3 = new char[length];
            while (i < length) {
                cArr3[i] = cArr2[bArr[i] & 255];
                i++;
            }
            return new String(cArr3);
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e) {
            throw new ExceptionConverter(e);
        }
    }

    public static boolean isPdfDocEncoding(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt >= 128 && ((charAt <= 160 || charAt > 255) && !pdfEncoding.containsKey(charAt))) {
                return false;
            }
        }
        return true;
    }

    public static void clearCmap(String str) {
        synchronized (cmaps) {
            if (str.length() == 0) {
                cmaps.clear();
            } else {
                cmaps.remove(str);
            }
        }
    }

    public static void loadCmap(String str, byte[][] bArr) {
        char[][] cArr;
        try {
            synchronized (cmaps) {
                cArr = (char[][]) cmaps.get(str);
            }
            if (cArr == null) {
                char[][] readCmap = readCmap(str, bArr);
                synchronized (cmaps) {
                    cmaps.put(str, readCmap);
                }
            }
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    public static String convertCmap(String str, byte[] bArr) {
        return convertCmap(str, bArr, 0, bArr.length);
    }

    public static String convertCmap(String str, byte[] bArr, int i, int i2) {
        char[][] cArr;
        try {
            synchronized (cmaps) {
                cArr = (char[][]) cmaps.get(str);
            }
            if (cArr == null) {
                cArr = readCmap(str, (byte[][]) null);
                synchronized (cmaps) {
                    cmaps.put(str, cArr);
                }
            }
            return decodeSequence(bArr, i, i2, cArr);
        } catch (IOException e) {
            throw new ExceptionConverter(e);
        }
    }

    static String decodeSequence(byte[] bArr, int i, int i2, char[][] cArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i2 + i;
        char c = 0;
        while (i < i3) {
            char c2 = cArr[c][bArr[i] & 255];
            if ((32768 & c2) == 0) {
                stringBuffer.append((char) c2);
                c = 0;
            } else {
                c = c2 & BaseFont.CID_NEWLINE;
            }
            i++;
        }
        return stringBuffer.toString();
    }

    static char[][] readCmap(String str, byte[][] bArr) throws IOException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new char[256]);
        readCmap(str, arrayList);
        if (bArr != null) {
            for (int i = 0; i < bArr.length; i++) {
                encodeSequence(bArr[i].length, bArr[i], BaseFont.CID_NEWLINE, arrayList);
            }
        }
        return (char[][]) arrayList.toArray(new char[arrayList.size()][]);
    }

    static void readCmap(String str, ArrayList arrayList) throws IOException {
        InputStream resourceStream = BaseFont.getResourceStream("com/lowagie/text/pdf/fonts/cmaps/" + str);
        if (resourceStream != null) {
            encodeStream(resourceStream, arrayList);
            resourceStream.close();
            return;
        }
        throw new IOException("The Cmap " + str + " was not found.");
    }

    static void encodeStream(InputStream inputStream, ArrayList arrayList) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
        byte[] bArr = new byte[7];
        while (true) {
            char c = 0;
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    if (readLine.length() >= 6) {
                        if (c != 0) {
                            if (c != 1) {
                                if (c != 2) {
                                    continue;
                                } else if (readLine.indexOf("endcidchar") >= 0) {
                                    break;
                                } else {
                                    StringTokenizer stringTokenizer = new StringTokenizer(readLine);
                                    String nextToken = stringTokenizer.nextToken();
                                    int length = (nextToken.length() / 2) - 1;
                                    long parseLong = Long.parseLong(nextToken.substring(1, nextToken.length() - 1), 16);
                                    int parseInt = Integer.parseInt(stringTokenizer.nextToken());
                                    breakLong(parseLong, length, bArr);
                                    encodeSequence(length, bArr, (char) parseInt, arrayList);
                                }
                            } else if (readLine.indexOf("endcidrange") >= 0) {
                                break;
                            } else {
                                StringTokenizer stringTokenizer2 = new StringTokenizer(readLine);
                                String nextToken2 = stringTokenizer2.nextToken();
                                int length2 = (nextToken2.length() / 2) - 1;
                                String nextToken3 = stringTokenizer2.nextToken();
                                long parseLong2 = Long.parseLong(nextToken3.substring(1, nextToken3.length() - 1), 16);
                                int parseInt2 = Integer.parseInt(stringTokenizer2.nextToken());
                                for (long parseLong3 = Long.parseLong(nextToken2.substring(1, nextToken2.length() - 1), 16); parseLong3 <= parseLong2; parseLong3++) {
                                    breakLong(parseLong3, length2, bArr);
                                    encodeSequence(length2, bArr, (char) parseInt2, arrayList);
                                    parseInt2++;
                                }
                            }
                        } else if (readLine.indexOf("begincidrange") >= 0) {
                            c = 1;
                        } else if (readLine.indexOf("begincidchar") >= 0) {
                            c = 2;
                        } else if (readLine.indexOf("usecmap") >= 0) {
                            readCmap(new StringTokenizer(readLine).nextToken().substring(1), arrayList);
                        }
                    }
                } else {
                    return;
                }
            }
        }
    }

    static void breakLong(long j, int i, byte[] bArr) {
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((int) (j >> (((i - 1) - i2) * 8)));
        }
    }

    static void encodeSequence(int i, byte[] bArr, char c, ArrayList arrayList) {
        int i2 = i - 1;
        int i3 = 0;
        char c2 = 0;
        while (i3 < i2) {
            char[] cArr = (char[]) arrayList.get(c2);
            byte b = bArr[i3] & 255;
            char c3 = cArr[b];
            if (c3 == 0 || (c3 & 32768) != 0) {
                if (c3 == 0) {
                    arrayList.add(new char[256]);
                    c3 = (char) ((arrayList.size() - 1) | 32768);
                    cArr[b] = c3;
                }
                c2 = c3 & BaseFont.CID_NEWLINE;
                i3++;
            } else {
                throw new RuntimeException("Inconsistent mapping.");
            }
        }
        char[] cArr2 = (char[]) arrayList.get(c2);
        byte b2 = bArr[i2] & 255;
        if ((cArr2[b2] & 32768) == 0) {
            cArr2[b2] = c;
            return;
        }
        throw new RuntimeException("Inconsistent mapping.");
    }

    public static void addExtraEncoding(String str, ExtraEncoding extraEncoding) {
        synchronized (extraEncodings) {
            HashMap hashMap = (HashMap) extraEncodings.clone();
            hashMap.put(str.toLowerCase(), extraEncoding);
            extraEncodings = hashMap;
        }
    }

    private static class WingdingsConversion implements ExtraEncoding {
        private static final byte[] table;

        public String byteToChar(byte[] bArr, String str) {
            return null;
        }

        private WingdingsConversion() {
        }

        /* synthetic */ WingdingsConversion(WingdingsConversion wingdingsConversion) {
            this();
        }

        public byte[] charToByte(char c, String str) {
            byte b;
            if (c == ' ') {
                return new byte[]{(byte) c};
            } else if (c < 9985 || c > 10174 || (b = table[c - 9984]) == 0) {
                return new byte[0];
            } else {
                return new byte[]{b};
            }
        }

        public byte[] charToByte(String str, String str2) {
            byte b;
            int i;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            int i2 = 0;
            for (char c : charArray) {
                if (c == ' ') {
                    i = i2 + 1;
                    bArr[i2] = (byte) c;
                } else {
                    if (c >= 9985 && c <= 10174 && (b = table[c - 9984]) != 0) {
                        i = i2 + 1;
                        bArr[i2] = b;
                    }
                }
                i2 = i;
            }
            if (i2 == r0) {
                return bArr;
            }
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            return bArr2;
        }

        static {
            byte[] bArr = new byte[191];
            bArr[1] = 35;
            bArr[2] = 34;
            bArr[6] = 41;
            bArr[7] = DocWriter.f569GT;
            bArr[8] = 81;
            bArr[9] = 42;
            bArr[12] = 65;
            bArr[13] = 63;
            bArr[19] = -4;
            bArr[23] = -5;
            bArr[30] = 86;
            bArr[32] = 88;
            bArr[33] = 89;
            bArr[42] = -75;
            bArr[48] = -74;
            bArr[52] = -83;
            bArr[53] = -81;
            bArr[54] = -84;
            bArr[63] = 124;
            bArr[64] = 123;
            bArr[68] = 84;
            bArr[77] = -90;
            bArr[81] = 113;
            bArr[82] = 114;
            bArr[86] = 117;
            bArr[93] = 125;
            bArr[94] = 126;
            bArr[118] = -116;
            bArr[119] = -115;
            bArr[120] = -114;
            bArr[121] = -113;
            bArr[122] = -112;
            bArr[123] = -111;
            bArr[124] = -110;
            bArr[125] = -109;
            bArr[126] = -108;
            bArr[127] = -107;
            bArr[128] = -127;
            bArr[129] = -126;
            bArr[130] = -125;
            bArr[131] = -124;
            bArr[132] = -123;
            bArr[133] = -122;
            bArr[134] = -121;
            bArr[135] = -120;
            bArr[136] = -119;
            bArr[137] = -118;
            bArr[138] = -116;
            bArr[139] = -115;
            bArr[140] = -114;
            bArr[141] = -113;
            bArr[142] = -112;
            bArr[143] = -111;
            bArr[144] = -110;
            bArr[145] = -109;
            bArr[146] = -108;
            bArr[147] = -107;
            bArr[148] = -24;
            bArr[161] = -24;
            bArr[162] = -40;
            bArr[165] = -60;
            bArr[166] = -58;
            bArr[169] = -16;
            bArr[179] = -36;
            table = bArr;
        }
    }

    private static class Cp437Conversion implements ExtraEncoding {
        private static IntHashtable c2b = new IntHashtable();
        private static final char[] table = {Barcode128.CODE_C, 252, 233, 226, 228, 224, 229, 231, 234, 235, 232, 239, 238, 236, Barcode128.FNC3, Barcode128.FNC2, 201, 230, Barcode128.SHIFT, 244, 246, 242, 251, 249, 255, 214, 220, Typography.cent, Typography.pound, 165, 8359, 402, 225, 237, 243, 250, 241, 209, 170, 186, 191, 8976, 172, Typography.half, 188, 161, Typography.leftGuillemete, Typography.rightGuillemete, 9617, 9618, 9619, 9474, 9508, 9569, 9570, 9558, 9557, 9571, 9553, 9559, 9565, 9564, 9563, 9488, 9492, 9524, 9516, 9500, 9472, 9532, 9566, 9567, 9562, 9556, 9577, 9574, 9568, 9552, 9580, 9575, 9576, 9572, 9573, 9561, 9560, 9554, 9555, 9579, 9578, 9496, 9484, 9608, 9604, 9612, 9616, 9600, 945, 223, 915, 960, 931, 963, 181, 964, 934, 920, 937, 948, 8734, 966, 949, 8745, 8801, Typography.plusMinus, Typography.greaterOrEqual, Typography.lessOrEqual, 8992, 8993, 247, Typography.almostEqual, Typography.degree, 8729, Typography.middleDot, 8730, 8319, 178, 9632, Typography.nbsp};

        private Cp437Conversion() {
        }

        /* synthetic */ Cp437Conversion(Cp437Conversion cp437Conversion) {
            this();
        }

        static {
            int i = 0;
            while (true) {
                char[] cArr = table;
                if (i < cArr.length) {
                    c2b.put(cArr[i], i + 128);
                    i++;
                } else {
                    return;
                }
            }
        }

        public byte[] charToByte(String str, String str2) {
            int i;
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            int i2 = 0;
            for (char c : charArray) {
                if (c < 128) {
                    i = i2 + 1;
                    bArr[i2] = (byte) c;
                } else {
                    byte b = (byte) c2b.get(c);
                    if (b != 0) {
                        i = i2 + 1;
                        bArr[i2] = b;
                    }
                }
                i2 = i;
            }
            if (i2 == r0) {
                return bArr;
            }
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            return bArr2;
        }

        public byte[] charToByte(char c, String str) {
            if (c < 128) {
                return new byte[]{(byte) c};
            }
            byte b = (byte) c2b.get(c);
            if (b == 0) {
                return new byte[0];
            }
            return new byte[]{b};
        }

        public String byteToChar(byte[] bArr, String str) {
            int i;
            char[] cArr = new char[r8];
            int i2 = 0;
            for (byte b : bArr) {
                byte b2 = b & 255;
                if (b2 >= 32) {
                    if (b2 < 128) {
                        i = i2 + 1;
                        cArr[i2] = (char) b2;
                    } else {
                        i = i2 + 1;
                        cArr[i2] = table[b2 - 128];
                    }
                    i2 = i;
                }
            }
            return new String(cArr, 0, i2);
        }
    }

    private static class SymbolConversion implements ExtraEncoding {

        /* renamed from: t1 */
        private static final IntHashtable f638t1 = new IntHashtable();

        /* renamed from: t2 */
        private static final IntHashtable f639t2 = new IntHashtable();
        private static final char[] table1;
        private static final char[] table2;
        private IntHashtable translation;

        public String byteToChar(byte[] bArr, String str) {
            return null;
        }

        static {
            char[] cArr = new char[224];
            int i = 0;
            cArr[0] = ' ';
            cArr[1] = '!';
            cArr[2] = 8704;
            cArr[3] = '#';
            cArr[4] = 8707;
            cArr[5] = '%';
            cArr[6] = Typography.amp;
            cArr[7] = 8715;
            cArr[8] = '(';
            cArr[9] = ')';
            cArr[10] = '*';
            cArr[11] = '+';
            cArr[12] = ',';
            cArr[13] = '-';
            cArr[14] = '.';
            cArr[15] = '/';
            cArr[16] = '0';
            cArr[17] = '1';
            cArr[18] = PdfWriter.VERSION_1_2;
            cArr[19] = PdfWriter.VERSION_1_3;
            cArr[20] = PdfWriter.VERSION_1_4;
            cArr[21] = PdfWriter.VERSION_1_5;
            cArr[22] = PdfWriter.VERSION_1_6;
            cArr[23] = PdfWriter.VERSION_1_7;
            cArr[24] = '8';
            cArr[25] = '9';
            cArr[26] = ':';
            cArr[27] = ';';
            cArr[28] = Typography.less;
            cArr[29] = '=';
            cArr[30] = Typography.greater;
            cArr[31] = '?';
            cArr[32] = 8773;
            cArr[33] = 913;
            cArr[34] = 914;
            cArr[35] = 935;
            cArr[36] = 916;
            cArr[37] = 917;
            cArr[38] = 934;
            cArr[39] = 915;
            cArr[40] = 919;
            cArr[41] = 921;
            cArr[42] = 977;
            cArr[43] = 922;
            cArr[44] = 923;
            cArr[45] = 924;
            cArr[46] = 925;
            cArr[47] = 927;
            cArr[48] = 928;
            cArr[49] = 920;
            cArr[50] = 929;
            cArr[51] = 931;
            cArr[52] = 932;
            cArr[53] = 933;
            cArr[54] = 962;
            cArr[55] = 937;
            cArr[56] = 926;
            cArr[57] = 936;
            cArr[58] = 918;
            cArr[59] = '[';
            cArr[60] = 8756;
            cArr[61] = ']';
            cArr[62] = 8869;
            cArr[63] = '_';
            cArr[64] = 773;
            cArr[65] = 945;
            cArr[66] = 946;
            cArr[67] = 967;
            cArr[68] = 948;
            cArr[69] = 949;
            cArr[70] = 981;
            cArr[71] = 947;
            cArr[72] = 951;
            cArr[73] = 953;
            cArr[74] = 966;
            cArr[75] = 954;
            cArr[76] = 955;
            cArr[77] = 956;
            cArr[78] = 957;
            cArr[79] = 959;
            cArr[80] = 960;
            cArr[81] = 952;
            cArr[82] = 961;
            cArr[83] = 963;
            cArr[84] = 964;
            cArr[85] = 965;
            cArr[86] = 982;
            cArr[87] = 969;
            cArr[88] = 958;
            cArr[89] = 968;
            cArr[90] = 950;
            cArr[91] = '{';
            cArr[92] = '|';
            cArr[93] = '}';
            cArr[94] = '~';
            cArr[128] = Typography.euro;
            cArr[129] = 978;
            cArr[130] = Typography.prime;
            cArr[131] = Typography.lessOrEqual;
            cArr[132] = 8260;
            cArr[133] = 8734;
            cArr[134] = 402;
            cArr[135] = 9827;
            cArr[136] = 9830;
            cArr[137] = 9829;
            cArr[138] = 9824;
            cArr[139] = 8596;
            cArr[140] = 8592;
            cArr[141] = 8593;
            cArr[142] = 8594;
            cArr[143] = 8595;
            cArr[144] = Typography.degree;
            cArr[145] = Typography.plusMinus;
            cArr[146] = Typography.doublePrime;
            cArr[147] = Typography.greaterOrEqual;
            cArr[148] = Typography.times;
            cArr[149] = 8733;
            cArr[150] = 8706;
            cArr[151] = Typography.bullet;
            cArr[152] = 247;
            cArr[153] = Typography.notEqual;
            cArr[154] = 8801;
            cArr[155] = Typography.almostEqual;
            cArr[156] = Typography.ellipsis;
            cArr[157] = 9474;
            cArr[158] = 9472;
            cArr[159] = 8629;
            cArr[160] = 8501;
            cArr[161] = 8465;
            cArr[162] = 8476;
            cArr[163] = 8472;
            cArr[164] = 8855;
            cArr[165] = 8853;
            cArr[166] = 8709;
            cArr[167] = 8745;
            cArr[168] = 8746;
            cArr[169] = 8835;
            cArr[170] = 8839;
            cArr[171] = 8836;
            cArr[172] = 8834;
            cArr[173] = 8838;
            cArr[174] = 8712;
            cArr[175] = 8713;
            cArr[176] = 8736;
            cArr[177] = 8711;
            cArr[178] = Typography.registered;
            cArr[179] = Typography.copyright;
            cArr[180] = Typography.f5414tm;
            cArr[181] = 8719;
            cArr[182] = 8730;
            cArr[183] = Typography.bullet;
            cArr[184] = 172;
            cArr[185] = 8743;
            cArr[186] = 8744;
            cArr[187] = 8660;
            cArr[188] = 8656;
            cArr[189] = 8657;
            cArr[190] = 8658;
            cArr[191] = 8659;
            cArr[192] = 9674;
            cArr[193] = 9001;
            cArr[197] = 8721;
            cArr[198] = 9115;
            cArr[199] = 9116;
            cArr[200] = 9117;
            cArr[201] = 9121;
            cArr[202] = 9122;
            cArr[203] = 9123;
            cArr[204] = 9127;
            cArr[205] = 9128;
            cArr[206] = 9129;
            cArr[207] = 9130;
            cArr[209] = 9002;
            cArr[210] = 8747;
            cArr[211] = 8992;
            cArr[212] = 9134;
            cArr[213] = 8993;
            cArr[214] = 9118;
            cArr[215] = 9119;
            cArr[216] = 9120;
            cArr[217] = 9124;
            cArr[218] = 9125;
            cArr[219] = 9126;
            cArr[220] = 9131;
            cArr[221] = 9132;
            cArr[222] = 9133;
            table1 = cArr;
            char[] cArr2 = new char[224];
            cArr2[0] = ' ';
            cArr2[1] = 9985;
            cArr2[2] = 9986;
            cArr2[3] = 9987;
            cArr2[4] = 9988;
            cArr2[5] = 9742;
            cArr2[6] = 9990;
            cArr2[7] = 9991;
            cArr2[8] = 9992;
            cArr2[9] = 9993;
            cArr2[10] = 9755;
            cArr2[11] = 9758;
            cArr2[12] = 9996;
            cArr2[13] = 9997;
            cArr2[14] = 9998;
            cArr2[15] = 9999;
            cArr2[16] = 10000;
            cArr2[17] = 10001;
            cArr2[18] = 10002;
            cArr2[19] = 10003;
            cArr2[20] = 10004;
            cArr2[21] = 10005;
            cArr2[22] = 10006;
            cArr2[23] = 10007;
            cArr2[24] = 10008;
            cArr2[25] = 10009;
            cArr2[26] = 10010;
            cArr2[27] = 10011;
            cArr2[28] = 10012;
            cArr2[29] = 10013;
            cArr2[30] = 10014;
            cArr2[31] = 10015;
            cArr2[32] = 10016;
            cArr2[33] = 10017;
            cArr2[34] = 10018;
            cArr2[35] = 10019;
            cArr2[36] = 10020;
            cArr2[37] = 10021;
            cArr2[38] = 10022;
            cArr2[39] = 10023;
            cArr2[40] = 9733;
            cArr2[41] = 10025;
            cArr2[42] = 10026;
            cArr2[43] = 10027;
            cArr2[44] = 10028;
            cArr2[45] = 10029;
            cArr2[46] = 10030;
            cArr2[47] = 10031;
            cArr2[48] = 10032;
            cArr2[49] = 10033;
            cArr2[50] = 10034;
            cArr2[51] = 10035;
            cArr2[52] = 10036;
            cArr2[53] = 10037;
            cArr2[54] = 10038;
            cArr2[55] = 10039;
            cArr2[56] = 10040;
            cArr2[57] = 10041;
            cArr2[58] = 10042;
            cArr2[59] = 10043;
            cArr2[60] = 10044;
            cArr2[61] = 10045;
            cArr2[62] = 10046;
            cArr2[63] = 10047;
            cArr2[64] = 10048;
            cArr2[65] = 10049;
            cArr2[66] = 10050;
            cArr2[67] = 10051;
            cArr2[68] = 10052;
            cArr2[69] = 10053;
            cArr2[70] = 10054;
            cArr2[71] = 10055;
            cArr2[72] = 10056;
            cArr2[73] = 10057;
            cArr2[74] = 10058;
            cArr2[75] = 10059;
            cArr2[76] = 9679;
            cArr2[77] = 10061;
            cArr2[78] = 9632;
            cArr2[79] = 10063;
            cArr2[80] = 10064;
            cArr2[81] = 10065;
            cArr2[82] = 10066;
            cArr2[83] = 9650;
            cArr2[84] = 9660;
            cArr2[85] = 9670;
            cArr2[86] = 10070;
            cArr2[87] = 9687;
            cArr2[88] = 10072;
            cArr2[89] = 10073;
            cArr2[90] = 10074;
            cArr2[91] = 10075;
            cArr2[92] = 10076;
            cArr2[93] = 10077;
            cArr2[94] = 10078;
            cArr2[129] = 10081;
            cArr2[130] = 10082;
            cArr2[131] = 10083;
            cArr2[132] = 10084;
            cArr2[133] = 10085;
            cArr2[134] = 10086;
            cArr2[135] = 10087;
            cArr2[136] = 9827;
            cArr2[137] = 9830;
            cArr2[138] = 9829;
            cArr2[139] = 9824;
            cArr2[140] = 9312;
            cArr2[141] = 9313;
            cArr2[142] = 9314;
            cArr2[143] = 9315;
            cArr2[144] = 9316;
            cArr2[145] = 9317;
            cArr2[146] = 9318;
            cArr2[147] = 9319;
            cArr2[148] = 9320;
            cArr2[149] = 9321;
            cArr2[150] = 10102;
            cArr2[151] = 10103;
            cArr2[152] = 10104;
            cArr2[153] = 10105;
            cArr2[154] = 10106;
            cArr2[155] = 10107;
            cArr2[156] = 10108;
            cArr2[157] = 10109;
            cArr2[158] = 10110;
            cArr2[159] = 10111;
            cArr2[160] = 10112;
            cArr2[161] = 10113;
            cArr2[162] = 10114;
            cArr2[163] = 10115;
            cArr2[164] = 10116;
            cArr2[165] = 10117;
            cArr2[166] = 10118;
            cArr2[167] = 10119;
            cArr2[168] = 10120;
            cArr2[169] = 10121;
            cArr2[170] = 10122;
            cArr2[171] = 10123;
            cArr2[172] = 10124;
            cArr2[173] = 10125;
            cArr2[174] = 10126;
            cArr2[175] = 10127;
            cArr2[176] = 10128;
            cArr2[177] = 10129;
            cArr2[178] = 10130;
            cArr2[179] = 10131;
            cArr2[180] = 10132;
            cArr2[181] = 8594;
            cArr2[182] = 8596;
            cArr2[183] = 8597;
            cArr2[184] = 10136;
            cArr2[185] = 10137;
            cArr2[186] = 10138;
            cArr2[187] = 10139;
            cArr2[188] = 10140;
            cArr2[189] = 10141;
            cArr2[190] = 10142;
            cArr2[191] = 10143;
            cArr2[192] = 10144;
            cArr2[193] = 10145;
            cArr2[194] = 10146;
            cArr2[195] = 10147;
            cArr2[196] = 10148;
            cArr2[197] = 10149;
            cArr2[198] = 10150;
            cArr2[199] = 10151;
            cArr2[200] = 10152;
            cArr2[201] = 10153;
            cArr2[202] = 10154;
            cArr2[203] = 10155;
            cArr2[204] = 10156;
            cArr2[205] = 10157;
            cArr2[206] = 10158;
            cArr2[207] = 10159;
            cArr2[209] = 10161;
            cArr2[210] = 10162;
            cArr2[211] = 10163;
            cArr2[212] = 10164;
            cArr2[213] = 10165;
            cArr2[214] = 10166;
            cArr2[215] = 10167;
            cArr2[216] = 10168;
            cArr2[217] = 10169;
            cArr2[218] = 10170;
            cArr2[219] = 10171;
            cArr2[220] = 10172;
            cArr2[221] = 10173;
            cArr2[222] = 10174;
            table2 = cArr2;
            int i2 = 0;
            while (true) {
                char[] cArr3 = table1;
                if (i2 >= cArr3.length) {
                    break;
                }
                char c = cArr3[i2];
                if (c != 0) {
                    f638t1.put(c, i2 + 32);
                }
                i2++;
            }
            while (true) {
                char[] cArr4 = table2;
                if (i < cArr4.length) {
                    char c2 = cArr4[i];
                    if (c2 != 0) {
                        f639t2.put(c2, i + 32);
                    }
                    i++;
                } else {
                    return;
                }
            }
        }

        SymbolConversion(boolean z) {
            if (z) {
                this.translation = f638t1;
            } else {
                this.translation = f639t2;
            }
        }

        public byte[] charToByte(String str, String str2) {
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            int i = 0;
            for (char c : charArray) {
                byte b = (byte) this.translation.get(c);
                if (b != 0) {
                    bArr[i] = b;
                    i++;
                }
            }
            if (i == r0) {
                return bArr;
            }
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            return bArr2;
        }

        public byte[] charToByte(char c, String str) {
            byte b = (byte) this.translation.get(c);
            if (b == 0) {
                return new byte[0];
            }
            return new byte[]{b};
        }
    }

    private static class SymbolTTConversion implements ExtraEncoding {
        public String byteToChar(byte[] bArr, String str) {
            return null;
        }

        private SymbolTTConversion() {
        }

        /* synthetic */ SymbolTTConversion(SymbolTTConversion symbolTTConversion) {
            this();
        }

        public byte[] charToByte(char c, String str) {
            char c2 = 65280 & c;
            if (c2 != 0 && c2 != 61440) {
                return new byte[0];
            }
            return new byte[]{(byte) c};
        }

        public byte[] charToByte(String str, String str2) {
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            int i = 0;
            for (char c : charArray) {
                char c2 = 65280 & c;
                if (c2 == 0 || c2 == 61440) {
                    bArr[i] = (byte) c;
                    i++;
                }
            }
            if (i == r0) {
                return bArr;
            }
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            return bArr2;
        }
    }
}
