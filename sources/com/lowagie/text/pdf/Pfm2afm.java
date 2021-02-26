package com.lowagie.text.pdf;

import androidx.exifinterface.media.ExifInterface;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lowagie.text.ElementTags;
import com.lowagie.text.html.HtmlTags;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public final class Pfm2afm {
    private int[] Win2PSStd;
    private String[] WinChars = {"W00", "W01", "W02", "W03", "macron", "breve", "dotaccent", "W07", "ring", "W09", "W0a", "W0b", "W0c", "W0d", "W0e", "W0f", "hungarumlaut", "ogonek", "caron", "W13", "W14", "W15", "W16", "W17", "W18", "W19", "W1a", "W1b", "W1c", "W1d", "W1e", "W1f", "space", "exclam", "quotedbl", "numbersign", "dollar", "percent", "ampersand", "quotesingle", "parenleft", "parenright", "asterisk", "plus", "comma", "hyphen", "period", "slash", "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "colon", "semicolon", "less", "equal", "greater", "question", "at", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "bracketleft", "backslash", "bracketright", "asciicircum", "underscore", "grave", HtmlTags.ANCHOR, HtmlTags.f603B, "c", "d", "e", "f", "g", "h", HtmlTags.f606I, "j", "k", "l", "m", "n", "o", "p", "q", "r", HtmlTags.f607S, "t", HtmlTags.f608U, "v", "w", "x", "y", "z", "braceleft", "bar", "braceright", "asciitilde", "W7f", "euro", "W81", "quotesinglbase", "florin", "quotedblbase", "ellipsis", "dagger", "daggerdbl", "circumflex", "perthousand", "Scaron", "guilsinglleft", "OE", "W8d", "Zcaron", "W8f", "W90", "quoteleft", "quoteright", "quotedblleft", "quotedblright", "bullet", "endash", "emdash", "tilde", "trademark", "scaron", "guilsinglright", "oe", "W9d", "zcaron", "Ydieresis", "reqspace", "exclamdown", "cent", "sterling", FirebaseAnalytics.Param.CURRENCY, "yen", "brokenbar", ElementTags.SECTION, "dieresis", "copyright", "ordfeminine", "guillemotleft", "logicalnot", "syllable", "registered", "macron", "degree", "plusminus", "twosuperior", "threesuperior", "acute", "mu", ElementTags.PARAGRAPH, "periodcentered", "cedilla", "onesuperior", "ordmasculine", "guillemotright", "onequarter", "onehalf", "threequarters", "questiondown", "Agrave", "Aacute", "Acircumflex", "Atilde", "Adieresis", "Aring", "AE", "Ccedilla", "Egrave", "Eacute", "Ecircumflex", "Edieresis", "Igrave", "Iacute", "Icircumflex", "Idieresis", "Eth", "Ntilde", "Ograve", "Oacute", "Ocircumflex", "Otilde", "Odieresis", "multiply", "Oslash", "Ugrave", "Uacute", "Ucircumflex", "Udieresis", "Yacute", "Thorn", "germandbls", "agrave", "aacute", "acircumflex", "atilde", "adieresis", "aring", "ae", "ccedilla", "egrave", "eacute", "ecircumflex", "edieresis", "igrave", "iacute", "icircumflex", "idieresis", "eth", "ntilde", "ograve", "oacute", "ocircumflex", "otilde", "odieresis", "divide", "oslash", "ugrave", "uacute", "ucircumflex", "udieresis", "yacute", "thorn", "ydieresis"};
    private int[] WinClass;
    private short ascender;
    private short ascent;
    private short avgwidth;
    private int bitoff;
    private int bits;
    private byte brkchar;
    private short capheight;
    private byte charset;
    private int chartab;
    private String copyright;
    private byte defchar;
    private short descender;
    private int device;
    private short extleading;
    private short extlen;
    private int face;
    private int firstchar;
    private int fontname;
    private int h_len;
    private short horres;

    /* renamed from: in */
    private RandomAccessFileOrArray f760in;
    private short intleading;
    private boolean isMono;
    private byte italic;
    private int kernpairs;
    private byte kind;
    private int lastchar;
    private short maxwidth;
    private PrintWriter out;
    private byte overs;
    private short pixheight;
    private short pixwidth;
    private short points;
    private int psext;
    private int res1;
    private int res2;
    private short type;
    private byte uline;
    private short verres;
    private short vers;
    private short weight;
    private short widthby;
    private short xheight;

    private Pfm2afm(RandomAccessFileOrArray randomAccessFileOrArray, OutputStream outputStream) throws IOException {
        int[] iArr = new int[256];
        iArr[4] = 197;
        iArr[5] = 198;
        iArr[6] = 199;
        iArr[8] = 202;
        iArr[10] = 205;
        iArr[11] = 206;
        iArr[12] = 207;
        iArr[32] = 32;
        iArr[33] = 33;
        iArr[34] = 34;
        iArr[35] = 35;
        iArr[36] = 36;
        iArr[37] = 37;
        iArr[38] = 38;
        iArr[39] = 169;
        iArr[40] = 40;
        iArr[41] = 41;
        iArr[42] = 42;
        iArr[43] = 43;
        iArr[44] = 44;
        iArr[45] = 45;
        iArr[46] = 46;
        iArr[47] = 47;
        iArr[48] = 48;
        iArr[49] = 49;
        iArr[50] = 50;
        iArr[51] = 51;
        iArr[52] = 52;
        iArr[53] = 53;
        iArr[54] = 54;
        iArr[55] = 55;
        iArr[56] = 56;
        iArr[57] = 57;
        iArr[58] = 58;
        iArr[59] = 59;
        iArr[60] = 60;
        iArr[61] = 61;
        iArr[62] = 62;
        iArr[63] = 63;
        iArr[64] = 64;
        iArr[65] = 65;
        iArr[66] = 66;
        iArr[67] = 67;
        iArr[68] = 68;
        iArr[69] = 69;
        iArr[70] = 70;
        iArr[71] = 71;
        iArr[72] = 72;
        iArr[73] = 73;
        iArr[74] = 74;
        iArr[75] = 75;
        iArr[76] = 76;
        iArr[77] = 77;
        iArr[78] = 78;
        iArr[79] = 79;
        iArr[80] = 80;
        iArr[81] = 81;
        iArr[82] = 82;
        iArr[83] = 83;
        iArr[84] = 84;
        iArr[85] = 85;
        iArr[86] = 86;
        iArr[87] = 87;
        iArr[88] = 88;
        iArr[89] = 89;
        iArr[90] = 90;
        iArr[91] = 91;
        iArr[92] = 92;
        iArr[93] = 93;
        iArr[94] = 94;
        iArr[95] = 95;
        iArr[96] = 193;
        iArr[97] = 97;
        iArr[98] = 98;
        iArr[99] = 99;
        iArr[100] = 100;
        iArr[101] = 101;
        iArr[102] = 102;
        iArr[103] = 103;
        iArr[104] = 104;
        iArr[105] = 105;
        iArr[106] = 106;
        iArr[107] = 107;
        iArr[108] = 108;
        iArr[109] = 109;
        iArr[110] = 110;
        iArr[111] = 111;
        iArr[112] = 112;
        iArr[113] = 113;
        iArr[114] = 114;
        iArr[115] = 115;
        iArr[116] = 116;
        iArr[117] = 117;
        iArr[118] = 118;
        iArr[119] = 119;
        iArr[120] = 120;
        iArr[121] = 121;
        iArr[122] = 122;
        iArr[123] = 123;
        iArr[124] = 124;
        iArr[125] = 125;
        iArr[126] = 126;
        iArr[127] = 127;
        iArr[130] = 184;
        iArr[131] = 166;
        iArr[132] = 185;
        iArr[133] = 188;
        iArr[134] = 178;
        iArr[135] = 179;
        iArr[136] = 195;
        iArr[137] = 189;
        iArr[139] = 172;
        iArr[140] = 234;
        iArr[145] = 96;
        iArr[147] = 170;
        iArr[148] = 186;
        iArr[149] = 183;
        iArr[150] = 177;
        iArr[151] = 208;
        iArr[152] = 196;
        iArr[155] = 173;
        iArr[156] = 250;
        iArr[161] = 161;
        iArr[162] = 162;
        iArr[163] = 163;
        iArr[164] = 168;
        iArr[165] = 165;
        iArr[167] = 167;
        iArr[168] = 200;
        iArr[170] = 227;
        iArr[171] = 171;
        iArr[175] = 197;
        iArr[180] = 194;
        iArr[182] = 182;
        iArr[183] = 180;
        iArr[184] = 203;
        iArr[186] = 235;
        iArr[187] = 187;
        iArr[191] = 191;
        iArr[198] = 225;
        iArr[216] = 233;
        iArr[223] = 251;
        iArr[230] = 241;
        iArr[248] = 249;
        this.Win2PSStd = iArr;
        int[] iArr2 = new int[256];
        iArr2[4] = 2;
        iArr2[5] = 2;
        iArr2[6] = 2;
        iArr2[8] = 2;
        iArr2[10] = 2;
        iArr2[11] = 2;
        iArr2[12] = 2;
        iArr2[32] = 1;
        iArr2[33] = 1;
        iArr2[34] = 1;
        iArr2[35] = 1;
        iArr2[36] = 1;
        iArr2[37] = 1;
        iArr2[38] = 1;
        iArr2[39] = 1;
        iArr2[40] = 1;
        iArr2[41] = 1;
        iArr2[42] = 1;
        iArr2[43] = 1;
        iArr2[44] = 1;
        iArr2[45] = 1;
        iArr2[46] = 1;
        iArr2[47] = 1;
        iArr2[48] = 1;
        iArr2[49] = 1;
        iArr2[50] = 1;
        iArr2[51] = 1;
        iArr2[52] = 1;
        iArr2[53] = 1;
        iArr2[54] = 1;
        iArr2[55] = 1;
        iArr2[56] = 1;
        iArr2[57] = 1;
        iArr2[58] = 1;
        iArr2[59] = 1;
        iArr2[60] = 1;
        iArr2[61] = 1;
        iArr2[62] = 1;
        iArr2[63] = 1;
        iArr2[64] = 1;
        iArr2[65] = 1;
        iArr2[66] = 1;
        iArr2[67] = 1;
        iArr2[68] = 1;
        iArr2[69] = 1;
        iArr2[70] = 1;
        iArr2[71] = 1;
        iArr2[72] = 1;
        iArr2[73] = 1;
        iArr2[74] = 1;
        iArr2[75] = 1;
        iArr2[76] = 1;
        iArr2[77] = 1;
        iArr2[78] = 1;
        iArr2[79] = 1;
        iArr2[80] = 1;
        iArr2[81] = 1;
        iArr2[82] = 1;
        iArr2[83] = 1;
        iArr2[84] = 1;
        iArr2[85] = 1;
        iArr2[86] = 1;
        iArr2[87] = 1;
        iArr2[88] = 1;
        iArr2[89] = 1;
        iArr2[90] = 1;
        iArr2[91] = 1;
        iArr2[92] = 1;
        iArr2[93] = 1;
        iArr2[94] = 1;
        iArr2[95] = 1;
        iArr2[96] = 1;
        iArr2[97] = 1;
        iArr2[98] = 1;
        iArr2[99] = 1;
        iArr2[100] = 1;
        iArr2[101] = 1;
        iArr2[102] = 1;
        iArr2[103] = 1;
        iArr2[104] = 1;
        iArr2[105] = 1;
        iArr2[106] = 1;
        iArr2[107] = 1;
        iArr2[108] = 1;
        iArr2[109] = 1;
        iArr2[110] = 1;
        iArr2[111] = 1;
        iArr2[112] = 1;
        iArr2[113] = 1;
        iArr2[114] = 1;
        iArr2[115] = 1;
        iArr2[116] = 1;
        iArr2[117] = 1;
        iArr2[118] = 1;
        iArr2[119] = 1;
        iArr2[120] = 1;
        iArr2[121] = 1;
        iArr2[122] = 1;
        iArr2[123] = 1;
        iArr2[124] = 1;
        iArr2[125] = 1;
        iArr2[126] = 1;
        iArr2[127] = 2;
        iArr2[130] = 2;
        iArr2[132] = 2;
        iArr2[133] = 2;
        iArr2[134] = 2;
        iArr2[135] = 2;
        iArr2[136] = 2;
        iArr2[137] = 2;
        iArr2[138] = 2;
        iArr2[139] = 2;
        iArr2[140] = 2;
        iArr2[145] = 3;
        iArr2[146] = 3;
        iArr2[147] = 2;
        iArr2[148] = 2;
        iArr2[149] = 2;
        iArr2[150] = 2;
        iArr2[151] = 2;
        iArr2[152] = 2;
        iArr2[153] = 2;
        iArr2[154] = 2;
        iArr2[155] = 2;
        iArr2[156] = 2;
        iArr2[159] = 2;
        iArr2[160] = 1;
        iArr2[161] = 1;
        iArr2[162] = 1;
        iArr2[163] = 1;
        iArr2[164] = 1;
        iArr2[165] = 1;
        iArr2[166] = 1;
        iArr2[167] = 1;
        iArr2[168] = 1;
        iArr2[169] = 1;
        iArr2[170] = 1;
        iArr2[171] = 1;
        iArr2[172] = 1;
        iArr2[173] = 1;
        iArr2[174] = 1;
        iArr2[175] = 1;
        iArr2[176] = 1;
        iArr2[177] = 1;
        iArr2[178] = 1;
        iArr2[179] = 1;
        iArr2[180] = 1;
        iArr2[181] = 1;
        iArr2[182] = 1;
        iArr2[183] = 1;
        iArr2[184] = 1;
        iArr2[185] = 1;
        iArr2[186] = 1;
        iArr2[187] = 1;
        iArr2[188] = 1;
        iArr2[189] = 1;
        iArr2[190] = 1;
        iArr2[191] = 1;
        iArr2[192] = 1;
        iArr2[193] = 1;
        iArr2[194] = 1;
        iArr2[195] = 1;
        iArr2[196] = 1;
        iArr2[197] = 1;
        iArr2[198] = 1;
        iArr2[199] = 1;
        iArr2[200] = 1;
        iArr2[201] = 1;
        iArr2[202] = 1;
        iArr2[203] = 1;
        iArr2[204] = 1;
        iArr2[205] = 1;
        iArr2[206] = 1;
        iArr2[207] = 1;
        iArr2[208] = 1;
        iArr2[209] = 1;
        iArr2[210] = 1;
        iArr2[211] = 1;
        iArr2[212] = 1;
        iArr2[213] = 1;
        iArr2[214] = 1;
        iArr2[215] = 1;
        iArr2[216] = 1;
        iArr2[217] = 1;
        iArr2[218] = 1;
        iArr2[219] = 1;
        iArr2[220] = 1;
        iArr2[221] = 1;
        iArr2[222] = 1;
        iArr2[223] = 1;
        iArr2[224] = 1;
        iArr2[225] = 1;
        iArr2[226] = 1;
        iArr2[227] = 1;
        iArr2[228] = 1;
        iArr2[229] = 1;
        iArr2[230] = 1;
        iArr2[231] = 1;
        iArr2[232] = 1;
        iArr2[233] = 1;
        iArr2[234] = 1;
        iArr2[235] = 1;
        iArr2[236] = 1;
        iArr2[237] = 1;
        iArr2[238] = 1;
        iArr2[239] = 1;
        iArr2[240] = 1;
        iArr2[241] = 1;
        iArr2[242] = 1;
        iArr2[243] = 1;
        iArr2[244] = 1;
        iArr2[245] = 1;
        iArr2[246] = 1;
        iArr2[247] = 1;
        iArr2[248] = 1;
        iArr2[249] = 1;
        iArr2[250] = 1;
        iArr2[251] = 1;
        iArr2[252] = 1;
        iArr2[253] = 1;
        iArr2[254] = 1;
        iArr2[255] = 1;
        this.WinClass = iArr2;
        this.f760in = randomAccessFileOrArray;
        this.out = new PrintWriter(new OutputStreamWriter(outputStream, "ISO-8859-1"));
    }

    public static void convert(RandomAccessFileOrArray randomAccessFileOrArray, OutputStream outputStream) throws IOException {
        Pfm2afm pfm2afm = new Pfm2afm(randomAccessFileOrArray, outputStream);
        pfm2afm.openpfm();
        pfm2afm.putheader();
        pfm2afm.putchartab();
        pfm2afm.putkerntab();
        pfm2afm.puttrailer();
        pfm2afm.out.flush();
    }

    public static void main(String[] strArr) {
        try {
            RandomAccessFileOrArray randomAccessFileOrArray = new RandomAccessFileOrArray(strArr[0]);
            FileOutputStream fileOutputStream = new FileOutputStream(strArr[1]);
            convert(randomAccessFileOrArray, fileOutputStream);
            randomAccessFileOrArray.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String readString(int i) throws IOException {
        byte[] bArr = new byte[i];
        this.f760in.readFully(bArr);
        int i2 = 0;
        while (i2 < bArr.length && bArr[i2] != 0) {
            i2++;
        }
        return new String(bArr, 0, i2, "ISO-8859-1");
    }

    private String readString() throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            int read = this.f760in.read();
            if (read <= 0) {
                return stringBuffer.toString();
            }
            stringBuffer.append((char) read);
        }
    }

    private void outval(int i) {
        this.out.print(' ');
        this.out.print(i);
    }

    private void outchar(int i, int i2, String str) {
        this.out.print("C ");
        outval(i);
        this.out.print(" ; WX ");
        outval(i2);
        if (str != null) {
            this.out.print(" ; N ");
            this.out.print(str);
        }
        this.out.print(" ;\n");
    }

    private void openpfm() throws IOException {
        int i;
        this.f760in.seek(0);
        this.vers = this.f760in.readShortLE();
        this.h_len = this.f760in.readIntLE();
        this.copyright = readString(60);
        this.type = this.f760in.readShortLE();
        this.points = this.f760in.readShortLE();
        this.verres = this.f760in.readShortLE();
        this.horres = this.f760in.readShortLE();
        this.ascent = this.f760in.readShortLE();
        this.intleading = this.f760in.readShortLE();
        this.extleading = this.f760in.readShortLE();
        this.italic = (byte) this.f760in.read();
        this.uline = (byte) this.f760in.read();
        this.overs = (byte) this.f760in.read();
        this.weight = this.f760in.readShortLE();
        this.charset = (byte) this.f760in.read();
        this.pixwidth = this.f760in.readShortLE();
        this.pixheight = this.f760in.readShortLE();
        this.kind = (byte) this.f760in.read();
        this.avgwidth = this.f760in.readShortLE();
        this.maxwidth = this.f760in.readShortLE();
        this.firstchar = this.f760in.read();
        this.lastchar = this.f760in.read();
        this.defchar = (byte) this.f760in.read();
        this.brkchar = (byte) this.f760in.read();
        this.widthby = this.f760in.readShortLE();
        this.device = this.f760in.readIntLE();
        this.face = this.f760in.readIntLE();
        this.bits = this.f760in.readIntLE();
        this.bitoff = this.f760in.readIntLE();
        this.extlen = this.f760in.readShortLE();
        this.psext = this.f760in.readIntLE();
        this.chartab = this.f760in.readIntLE();
        this.res1 = this.f760in.readIntLE();
        this.kernpairs = this.f760in.readIntLE();
        this.res2 = this.f760in.readIntLE();
        this.fontname = this.f760in.readIntLE();
        if (this.h_len != this.f760in.length() || this.extlen != 30 || (i = this.fontname) < 75 || i > 512) {
            throw new IOException("Not a valid PFM file.");
        }
        this.f760in.seek(this.psext + 14);
        this.capheight = this.f760in.readShortLE();
        this.xheight = this.f760in.readShortLE();
        this.ascender = this.f760in.readShortLE();
        this.descender = this.f760in.readShortLE();
    }

    private void putheader() throws IOException {
        this.out.print("StartFontMetrics 2.0\n");
        if (this.copyright.length() > 0) {
            PrintWriter printWriter = this.out;
            printWriter.print("Comment " + this.copyright + 10);
        }
        this.out.print("FontName ");
        this.f760in.seek(this.fontname);
        String readString = readString();
        this.out.print(readString);
        this.out.print("\nEncodingScheme ");
        if (this.charset != 0) {
            this.out.print("FontSpecific\n");
        } else {
            this.out.print("AdobeStandardEncoding\n");
        }
        PrintWriter printWriter2 = this.out;
        printWriter2.print("FullName " + readString.replace('-', ' '));
        int i = this.face;
        if (i != 0) {
            this.f760in.seek(i);
            PrintWriter printWriter3 = this.out;
            printWriter3.print("\nFamilyName " + readString());
        }
        this.out.print("\nWeight ");
        if (this.weight > 475 || readString.toLowerCase().indexOf("bold") >= 0) {
            this.out.print("Bold");
        } else {
            short s = this.weight;
            if ((s < 325 && s != 0) || readString.toLowerCase().indexOf("light") >= 0) {
                this.out.print("Light");
            } else if (readString.toLowerCase().indexOf("black") >= 0) {
                this.out.print("Black");
            } else {
                this.out.print("Medium");
            }
        }
        this.out.print("\nItalicAngle ");
        if (this.italic != 0 || readString.toLowerCase().indexOf("italic") >= 0) {
            this.out.print("-12.00");
        } else {
            this.out.print("0");
        }
        this.out.print("\nIsFixedPitch ");
        if ((this.kind & 1) == 0 || this.avgwidth == this.maxwidth) {
            this.out.print("true");
            this.isMono = true;
        } else {
            this.out.print(PdfBoolean.FALSE);
            this.isMono = false;
        }
        this.out.print("\nFontBBox");
        if (this.isMono) {
            outval(-20);
        } else {
            outval(-100);
        }
        outval(-(this.descender + 5));
        outval(this.maxwidth + 10);
        outval(this.ascent + 5);
        this.out.print("\nCapHeight");
        outval(this.capheight);
        this.out.print("\nXHeight");
        outval(this.xheight);
        this.out.print("\nDescender");
        outval(this.descender);
        this.out.print("\nAscender");
        outval(this.ascender);
        this.out.print(10);
    }

    private void putchartab() throws IOException {
        int i = (this.lastchar - this.firstchar) + 1;
        int[] iArr = new int[i];
        this.f760in.seek(this.chartab);
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = this.f760in.readUnsignedShortLE();
        }
        int[] iArr2 = new int[256];
        if (this.charset == 0) {
            for (int i3 = this.firstchar; i3 <= this.lastchar; i3++) {
                int[] iArr3 = this.Win2PSStd;
                if (iArr3[i3] != 0) {
                    iArr2[iArr3[i3]] = i3;
                }
            }
        }
        this.out.print("StartCharMetrics");
        outval(i);
        this.out.print(10);
        if (this.charset != 0) {
            for (int i4 = this.firstchar; i4 <= this.lastchar; i4++) {
                int i5 = this.firstchar;
                if (iArr[i4 - i5] != 0) {
                    outchar(i4, iArr[i4 - i5], (String) null);
                }
            }
        } else {
            for (int i6 = 0; i6 < 256; i6++) {
                int i7 = iArr2[i6];
                if (i7 != 0) {
                    outchar(i6, iArr[i7 - this.firstchar], this.WinChars[i7]);
                    iArr[i7 - this.firstchar] = 0;
                }
            }
            for (int i8 = this.firstchar; i8 <= this.lastchar; i8++) {
                int i9 = this.firstchar;
                if (iArr[i8 - i9] != 0) {
                    outchar(-1, iArr[i8 - i9], this.WinChars[i8]);
                }
            }
        }
        this.out.print("EndCharMetrics\n");
    }

    private void putkerntab() throws IOException {
        int i = this.kernpairs;
        if (i != 0) {
            this.f760in.seek(i);
            int[] iArr = new int[(this.f760in.readUnsignedShortLE() * 3)];
            int i2 = 0;
            int i3 = 0;
            while (i2 < iArr.length) {
                int i4 = i2 + 1;
                iArr[i2] = this.f760in.read();
                int i5 = i4 + 1;
                iArr[i4] = this.f760in.read();
                int i6 = i5 + 1;
                int readShortLE = this.f760in.readShortLE();
                iArr[i5] = readShortLE;
                if (readShortLE != 0) {
                    i3++;
                }
                i2 = i6;
            }
            if (i3 != 0) {
                this.out.print("StartKernData\nStartKernPairs");
                outval(i3);
                this.out.print(10);
                for (int i7 = 0; i7 < iArr.length; i7 += 3) {
                    int i8 = i7 + 2;
                    if (iArr[i8] != 0) {
                        this.out.print("KPX ");
                        this.out.print(this.WinChars[iArr[i7]]);
                        this.out.print(' ');
                        this.out.print(this.WinChars[iArr[i7 + 1]]);
                        outval(iArr[i8]);
                        this.out.print(10);
                    }
                }
                this.out.print("EndKernPairs\nEndKernData\n");
            }
        }
    }

    private void puttrailer() {
        this.out.print("EndFontMetrics\n");
    }
}
