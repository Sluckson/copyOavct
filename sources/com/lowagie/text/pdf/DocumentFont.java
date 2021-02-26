package com.lowagie.text.pdf;

import com.lowagie.text.DocumentException;
import com.lowagie.text.ExceptionConverter;
import java.io.IOException;
import java.util.HashMap;

public class DocumentFont extends BaseFont {
    private static String[] cjkEncs = {AsianFontMapper.JapaneseEncoding_H, AsianFontMapper.JapaneseEncoding_H, AsianFontMapper.ChineseSimplifiedEncoding_H, AsianFontMapper.ChineseTraditionalEncoding_H, AsianFontMapper.ChineseTraditionalEncoding_H, AsianFontMapper.KoreanEncoding_H, AsianFontMapper.KoreanEncoding_H, AsianFontMapper.ChineseTraditionalEncoding_H, AsianFontMapper.ChineseSimplifiedEncoding_H, AsianFontMapper.KoreanEncoding_H, AsianFontMapper.JapaneseEncoding_H};
    private static String[] cjkEncs2 = {AsianFontMapper.ChineseTraditionalEncoding_H, AsianFontMapper.ChineseSimplifiedEncoding_H, AsianFontMapper.KoreanEncoding_H, AsianFontMapper.JapaneseEncoding_H, "UniCNS-UTF16-H", "UniGB-UTF16-H", "UniKS-UTF16-H", "UniJIS-UTF16-H"};
    private static String[] cjkNames = {AsianFontMapper.JapaneseFont_Min, AsianFontMapper.JapaneseFont_Go, AsianFontMapper.ChineseSimplifiedFont, AsianFontMapper.ChineseTraditionalFont_MHei, AsianFontMapper.ChineseTraditionalFont_MSung, AsianFontMapper.KoreanFont_GoThic, AsianFontMapper.KoreanFont_SMyeongJo, "MSungStd-Light", "STSongStd-Light", "HYSMyeongJoStd-Medium", "KozMinPro-Regular"};
    private static String[] cjkNames2 = {"MSungStd-Light", "STSongStd-Light", "HYSMyeongJoStd-Medium", "KozMinPro-Regular"};
    private static final int[] stdEnc;
    private float Ascender = 800.0f;
    private float CapHeight = 700.0f;
    private float Descender = -200.0f;
    private float ItalicAngle = 0.0f;
    private BaseFont cjkMirror;
    private IntHashtable diffmap;
    private PdfDictionary font;
    private String fontName;
    private boolean isType0 = false;
    private float llx = -50.0f;
    private float lly = -200.0f;
    private HashMap metrics = new HashMap();
    private PRIndirectReference refFont;
    private IntHashtable uni2byte = new IntHashtable();
    private float urx = 100.0f;
    private float ury = 900.0f;

    public int[] getCharBBox(int i) {
        return null;
    }

    public PdfStream getFullFontStream() {
        return null;
    }

    public int getKerning(int i, int i2) {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int[] getRawCharBBox(int i, String str) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public int getRawWidth(int i, String str) {
        return 0;
    }

    public boolean hasKernPairs() {
        return false;
    }

    public boolean setKerning(int i, int i2, int i3) {
        return false;
    }

    public void setPostscriptFontName(String str) {
    }

    /* access modifiers changed from: package-private */
    public void writeFont(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, Object[] objArr) throws DocumentException, IOException {
    }

    static {
        int[] iArr = new int[256];
        iArr[32] = 32;
        iArr[33] = 33;
        iArr[34] = 34;
        iArr[35] = 35;
        iArr[36] = 36;
        iArr[37] = 37;
        iArr[38] = 38;
        iArr[39] = 8217;
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
        iArr[96] = 8216;
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
        iArr[161] = 161;
        iArr[162] = 162;
        iArr[163] = 163;
        iArr[164] = 8260;
        iArr[165] = 165;
        iArr[166] = 402;
        iArr[167] = 167;
        iArr[168] = 164;
        iArr[169] = 39;
        iArr[170] = 8220;
        iArr[171] = 171;
        iArr[172] = 8249;
        iArr[173] = 8250;
        iArr[174] = 64257;
        iArr[175] = 64258;
        iArr[177] = 8211;
        iArr[178] = 8224;
        iArr[179] = 8225;
        iArr[180] = 183;
        iArr[182] = 182;
        iArr[183] = 8226;
        iArr[184] = 8218;
        iArr[185] = 8222;
        iArr[186] = 8221;
        iArr[187] = 187;
        iArr[188] = 8230;
        iArr[189] = 8240;
        iArr[191] = 191;
        iArr[193] = 96;
        iArr[194] = 180;
        iArr[195] = 710;
        iArr[196] = 732;
        iArr[197] = 175;
        iArr[198] = 728;
        iArr[199] = 729;
        iArr[200] = 168;
        iArr[202] = 730;
        iArr[203] = 184;
        iArr[205] = 733;
        iArr[206] = 731;
        iArr[207] = 711;
        iArr[208] = 8212;
        iArr[225] = 198;
        iArr[227] = 170;
        iArr[232] = 321;
        iArr[233] = 216;
        iArr[234] = 338;
        iArr[235] = 186;
        iArr[241] = 230;
        iArr[245] = 305;
        iArr[248] = 322;
        iArr[249] = 248;
        iArr[250] = 339;
        iArr[251] = 223;
        stdEnc = iArr;
    }

    DocumentFont(PRIndirectReference pRIndirectReference) {
        this.encoding = "";
        this.fontSpecific = false;
        this.refFont = pRIndirectReference;
        this.fontType = 4;
        this.font = (PdfDictionary) PdfReader.getPdfObject((PdfObject) pRIndirectReference);
        this.fontName = PdfName.decodeName(this.font.getAsName(PdfName.BASEFONT).toString());
        PdfName asName = this.font.getAsName(PdfName.SUBTYPE);
        if (PdfName.TYPE1.equals(asName) || PdfName.TRUETYPE.equals(asName)) {
            doType1TT();
            return;
        }
        int i = 0;
        while (true) {
            String[] strArr = cjkNames;
            if (i >= strArr.length) {
                String decodeName = PdfName.decodeName(this.font.getAsName(PdfName.ENCODING).toString());
                int i2 = 0;
                while (true) {
                    String[] strArr2 = cjkEncs2;
                    if (i2 >= strArr2.length) {
                        if (PdfName.TYPE0.equals(asName) && decodeName.equals(BaseFont.IDENTITY_H)) {
                            processType0(this.font);
                            this.isType0 = true;
                            return;
                        }
                        return;
                    } else if (decodeName.startsWith(strArr2[i2])) {
                        i2 = i2 > 3 ? i2 - 4 : i2;
                        try {
                            this.cjkMirror = BaseFont.createFont(cjkNames2[i2], cjkEncs2[i2], false);
                            return;
                        } catch (Exception e) {
                            throw new ExceptionConverter(e);
                        }
                    } else {
                        i2++;
                    }
                }
            } else if (this.fontName.startsWith(strArr[i])) {
                this.fontName = cjkNames[i];
                try {
                    this.cjkMirror = BaseFont.createFont(this.fontName, cjkEncs[i], false);
                    return;
                } catch (Exception e2) {
                    throw new ExceptionConverter(e2);
                }
            } else {
                i++;
            }
        }
    }

    private void processType0(PdfDictionary pdfDictionary) {
        try {
            PdfObject pdfObjectRelease = PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.TOUNICODE));
            PdfDictionary pdfDictionary2 = (PdfDictionary) PdfReader.getPdfObjectRelease(((PdfArray) PdfReader.getPdfObjectRelease(pdfDictionary.get(PdfName.DESCENDANTFONTS))).getPdfObject(0));
            PdfNumber pdfNumber = (PdfNumber) PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.f670DW));
            int i = 1000;
            if (pdfNumber != null) {
                i = pdfNumber.intValue();
            }
            IntHashtable readWidths = readWidths((PdfArray) PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.f738W)));
            fillFontDesc((PdfDictionary) PdfReader.getPdfObjectRelease(pdfDictionary2.get(PdfName.FONTDESCRIPTOR)));
            if (pdfObjectRelease != null) {
                fillMetrics(PdfReader.getStreamBytes((PRStream) pdfObjectRelease), readWidths, i);
            }
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    private IntHashtable readWidths(PdfArray pdfArray) {
        IntHashtable intHashtable = new IntHashtable();
        if (pdfArray == null) {
            return intHashtable;
        }
        int i = 0;
        while (i < pdfArray.size()) {
            int intValue = ((PdfNumber) PdfReader.getPdfObjectRelease(pdfArray.getPdfObject(i))).intValue();
            int i2 = i + 1;
            PdfObject pdfObjectRelease = PdfReader.getPdfObjectRelease(pdfArray.getPdfObject(i2));
            if (pdfObjectRelease.isArray()) {
                PdfArray pdfArray2 = (PdfArray) pdfObjectRelease;
                int i3 = intValue;
                int i4 = 0;
                while (i4 < pdfArray2.size()) {
                    intHashtable.put(i3, ((PdfNumber) PdfReader.getPdfObjectRelease(pdfArray2.getPdfObject(i4))).intValue());
                    i4++;
                    i3++;
                }
            } else {
                int intValue2 = ((PdfNumber) pdfObjectRelease).intValue();
                i2++;
                int intValue3 = ((PdfNumber) PdfReader.getPdfObjectRelease(pdfArray.getPdfObject(i2))).intValue();
                while (intValue <= intValue2) {
                    intHashtable.put(intValue, intValue3);
                    intValue++;
                }
            }
            i = i2 + 1;
        }
        return intHashtable;
    }

    private String decodeString(PdfString pdfString) {
        if (pdfString.isHexWriting()) {
            return PdfEncodings.convertToString(pdfString.getBytes(), "UnicodeBigUnmarked");
        }
        return pdfString.toUnicodeString();
    }

    private void fillMetrics(byte[] bArr, IntHashtable intHashtable, int i) {
        IntHashtable intHashtable2 = intHashtable;
        try {
            PdfContentParser pdfContentParser = new PdfContentParser(new PRTokeniser(bArr));
            PdfObject pdfObject = null;
            while (true) {
                PdfObject readPRObject = pdfContentParser.readPRObject();
                if (readPRObject != null) {
                    if (readPRObject.type() != 200) {
                        pdfObject = readPRObject;
                    } else if (readPRObject.toString().equals("beginbfchar")) {
                        int intValue = ((PdfNumber) pdfObject).intValue();
                        for (int i2 = 0; i2 < intValue; i2++) {
                            String decodeString = decodeString((PdfString) pdfContentParser.readPRObject());
                            String decodeString2 = decodeString((PdfString) pdfContentParser.readPRObject());
                            if (decodeString2.length() == 1) {
                                int charAt = decodeString.charAt(0);
                                this.metrics.put(new Integer(decodeString2.charAt(decodeString2.length() - 1)), new int[]{charAt, intHashtable2.containsKey(charAt) ? intHashtable2.get(charAt) : i});
                            }
                        }
                    } else if (readPRObject.toString().equals("beginbfrange")) {
                        int intValue2 = ((PdfNumber) pdfObject).intValue();
                        for (int i3 = 0; i3 < intValue2; i3++) {
                            String decodeString3 = decodeString((PdfString) pdfContentParser.readPRObject());
                            String decodeString4 = decodeString((PdfString) pdfContentParser.readPRObject());
                            int charAt2 = decodeString3.charAt(0);
                            char charAt3 = decodeString4.charAt(0);
                            PdfObject readPRObject2 = pdfContentParser.readPRObject();
                            if (readPRObject2.isString()) {
                                String decodeString5 = decodeString((PdfString) readPRObject2);
                                if (decodeString5.length() == 1) {
                                    int charAt4 = decodeString5.charAt(decodeString5.length() - 1);
                                    while (charAt2 <= charAt3) {
                                        this.metrics.put(new Integer(charAt4), new int[]{charAt2, intHashtable2.containsKey(charAt2) ? intHashtable2.get(charAt2) : i});
                                        charAt2++;
                                        charAt4++;
                                    }
                                }
                            } else {
                                PdfArray pdfArray = (PdfArray) readPRObject2;
                                int i4 = charAt2;
                                int i5 = 0;
                                while (i5 < pdfArray.size()) {
                                    String decodeString6 = decodeString(pdfArray.getAsString(i5));
                                    if (decodeString6.length() == 1) {
                                        this.metrics.put(new Integer(decodeString6.charAt(decodeString6.length() - 1)), new int[]{i4, intHashtable2.containsKey(i4) ? intHashtable2.get(i4) : i});
                                    }
                                    i5++;
                                    i4++;
                                }
                            }
                        }
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    private void doType1TT() {
        PdfObject pdfObject = PdfReader.getPdfObject(this.font.get(PdfName.ENCODING));
        if (pdfObject == null) {
            fillEncoding((PdfName) null);
        } else if (pdfObject.isName()) {
            fillEncoding((PdfName) pdfObject);
        } else {
            PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
            PdfObject pdfObject2 = PdfReader.getPdfObject(pdfDictionary.get(PdfName.BASEENCODING));
            if (pdfObject2 == null) {
                fillEncoding((PdfName) null);
            } else {
                fillEncoding((PdfName) pdfObject2);
            }
            PdfArray asArray = pdfDictionary.getAsArray(PdfName.DIFFERENCES);
            if (asArray != null) {
                this.diffmap = new IntHashtable();
                int i = 0;
                for (int i2 = 0; i2 < asArray.size(); i2++) {
                    PdfObject pdfObject3 = asArray.getPdfObject(i2);
                    if (pdfObject3.isNumber()) {
                        i = ((PdfNumber) pdfObject3).intValue();
                    } else {
                        int[] nameToUnicode = GlyphList.nameToUnicode(PdfName.decodeName(((PdfName) pdfObject3).toString()));
                        if (nameToUnicode != null && nameToUnicode.length > 0) {
                            this.uni2byte.put(nameToUnicode[0], i);
                            this.diffmap.put(nameToUnicode[0], i);
                        }
                        i++;
                    }
                }
            }
        }
        PdfArray asArray2 = this.font.getAsArray(PdfName.WIDTHS);
        PdfNumber asNumber = this.font.getAsNumber(PdfName.FIRSTCHAR);
        PdfNumber asNumber2 = this.font.getAsNumber(PdfName.LASTCHAR);
        if (BuiltinFonts14.containsKey(this.fontName)) {
            try {
                BaseFont createFont = BaseFont.createFont(this.fontName, "Cp1252", false);
                int[] orderedKeys = this.uni2byte.toOrderedKeys();
                for (int i3 = 0; i3 < orderedKeys.length; i3++) {
                    int i4 = this.uni2byte.get(orderedKeys[i3]);
                    this.widths[i4] = createFont.getRawWidth(i4, GlyphList.unicodeToName(orderedKeys[i3]));
                }
                IntHashtable intHashtable = this.diffmap;
                if (intHashtable != null) {
                    int[] orderedKeys2 = intHashtable.toOrderedKeys();
                    for (int i5 = 0; i5 < orderedKeys2.length; i5++) {
                        int i6 = this.diffmap.get(orderedKeys2[i5]);
                        this.widths[i6] = createFont.getRawWidth(i6, GlyphList.unicodeToName(orderedKeys2[i5]));
                    }
                    this.diffmap = null;
                }
                this.Ascender = createFont.getFontDescriptor(1, 1000.0f);
                this.CapHeight = createFont.getFontDescriptor(2, 1000.0f);
                this.Descender = createFont.getFontDescriptor(3, 1000.0f);
                this.ItalicAngle = createFont.getFontDescriptor(4, 1000.0f);
                this.llx = createFont.getFontDescriptor(5, 1000.0f);
                this.lly = createFont.getFontDescriptor(6, 1000.0f);
                this.urx = createFont.getFontDescriptor(7, 1000.0f);
                this.ury = createFont.getFontDescriptor(8, 1000.0f);
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }
        if (!(asNumber == null || asNumber2 == null || asArray2 == null)) {
            int intValue = asNumber.intValue();
            for (int i7 = 0; i7 < asArray2.size(); i7++) {
                this.widths[intValue + i7] = asArray2.getAsNumber(i7).intValue();
            }
        }
        fillFontDesc(this.font.getAsDict(PdfName.FONTDESCRIPTOR));
    }

    private void fillFontDesc(PdfDictionary pdfDictionary) {
        if (pdfDictionary != null) {
            PdfNumber asNumber = pdfDictionary.getAsNumber(PdfName.ASCENT);
            if (asNumber != null) {
                this.Ascender = asNumber.floatValue();
            }
            PdfNumber asNumber2 = pdfDictionary.getAsNumber(PdfName.CAPHEIGHT);
            if (asNumber2 != null) {
                this.CapHeight = asNumber2.floatValue();
            }
            PdfNumber asNumber3 = pdfDictionary.getAsNumber(PdfName.DESCENT);
            if (asNumber3 != null) {
                this.Descender = asNumber3.floatValue();
            }
            PdfNumber asNumber4 = pdfDictionary.getAsNumber(PdfName.ITALICANGLE);
            if (asNumber4 != null) {
                this.ItalicAngle = asNumber4.floatValue();
            }
            PdfArray asArray = pdfDictionary.getAsArray(PdfName.FONTBBOX);
            if (asArray != null) {
                this.llx = asArray.getAsNumber(0).floatValue();
                this.lly = asArray.getAsNumber(1).floatValue();
                this.urx = asArray.getAsNumber(2).floatValue();
                this.ury = asArray.getAsNumber(3).floatValue();
                float f = this.llx;
                float f2 = this.urx;
                if (f > f2) {
                    this.llx = f2;
                    this.urx = f;
                }
                float f3 = this.lly;
                float f4 = this.ury;
                if (f3 > f4) {
                    this.lly = f4;
                    this.ury = f3;
                }
            }
        }
    }

    private void fillEncoding(PdfName pdfName) {
        int i = 0;
        if (PdfName.MAC_ROMAN_ENCODING.equals(pdfName) || PdfName.WIN_ANSI_ENCODING.equals(pdfName)) {
            byte[] bArr = new byte[256];
            for (int i2 = 0; i2 < 256; i2++) {
                bArr[i2] = (byte) i2;
            }
            char[] charArray = PdfEncodings.convertToString(bArr, PdfName.MAC_ROMAN_ENCODING.equals(pdfName) ? BaseFont.MACROMAN : "Cp1252").toCharArray();
            while (i < 256) {
                this.uni2byte.put(charArray[i], i);
                i++;
            }
            return;
        }
        while (i < 256) {
            this.uni2byte.put(stdEnc[i], i);
            i++;
        }
    }

    public String[][] getFamilyFontName() {
        return getFullFontName();
    }

    public float getFontDescriptor(int i, float f) {
        float f2;
        BaseFont baseFont = this.cjkMirror;
        if (baseFont != null) {
            return baseFont.getFontDescriptor(i, f);
        }
        switch (i) {
            case 1:
            case 9:
                f2 = this.Ascender;
                break;
            case 2:
                f2 = this.CapHeight;
                break;
            case 3:
            case 10:
                f2 = this.Descender;
                break;
            case 4:
                return this.ItalicAngle;
            case 5:
                f2 = this.llx;
                break;
            case 6:
                f2 = this.lly;
                break;
            case 7:
                f2 = this.urx;
                break;
            case 8:
                f2 = this.ury;
                break;
            case 11:
                return 0.0f;
            case 12:
                f2 = this.urx - this.llx;
                break;
            default:
                return 0.0f;
        }
        return (f2 * f) / 1000.0f;
    }

    public String[][] getFullFontName() {
        return new String[][]{new String[]{"", "", "", this.fontName}};
    }

    public String[][] getAllNameEntries() {
        return new String[][]{new String[]{"4", "", "", "", this.fontName}};
    }

    public String getPostscriptFontName() {
        return this.fontName;
    }

    public int getWidth(int i) {
        BaseFont baseFont = this.cjkMirror;
        if (baseFont != null) {
            return baseFont.getWidth(i);
        }
        if (!this.isType0) {
            return super.getWidth(i);
        }
        int[] iArr = (int[]) this.metrics.get(new Integer(i));
        if (iArr != null) {
            return iArr[1];
        }
        return 0;
    }

    public int getWidth(String str) {
        BaseFont baseFont = this.cjkMirror;
        if (baseFont != null) {
            return baseFont.getWidth(str);
        }
        if (!this.isType0) {
            return super.getWidth(str);
        }
        int i = 0;
        for (char num : str.toCharArray()) {
            int[] iArr = (int[]) this.metrics.get(new Integer(num));
            if (iArr != null) {
                i += iArr[1];
            }
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public byte[] convertToBytes(String str) {
        if (this.cjkMirror != null) {
            return PdfEncodings.convertToBytes(str, "UnicodeBigUnmarked");
        }
        if (this.isType0) {
            byte[] bArr = new byte[(r2 * 2)];
            int i = 0;
            for (char num : str.toCharArray()) {
                int[] iArr = (int[]) this.metrics.get(new Integer(num));
                if (iArr != null) {
                    int i2 = iArr[0];
                    int i3 = i + 1;
                    bArr[i] = (byte) (i2 / 256);
                    i = i3 + 1;
                    bArr[i3] = (byte) i2;
                }
            }
            if (i == bArr.length) {
                return bArr;
            }
            byte[] bArr2 = new byte[i];
            System.arraycopy(bArr, 0, bArr2, 0, i);
            return bArr2;
        }
        char[] charArray = str.toCharArray();
        byte[] bArr3 = new byte[charArray.length];
        int i4 = 0;
        for (int i5 = 0; i5 < charArray.length; i5++) {
            if (this.uni2byte.containsKey(charArray[i5])) {
                bArr3[i4] = (byte) this.uni2byte.get(charArray[i5]);
                i4++;
            }
        }
        if (i4 == bArr3.length) {
            return bArr3;
        }
        byte[] bArr4 = new byte[i4];
        System.arraycopy(bArr3, 0, bArr4, 0, i4);
        return bArr4;
    }

    /* access modifiers changed from: package-private */
    public byte[] convertToBytes(int i) {
        if (this.cjkMirror != null) {
            return PdfEncodings.convertToBytes((char) i, "UnicodeBigUnmarked");
        }
        if (this.isType0) {
            int[] iArr = (int[]) this.metrics.get(new Integer(i));
            if (iArr == null) {
                return new byte[0];
            }
            int i2 = iArr[0];
            return new byte[]{(byte) (i2 / 256), (byte) i2};
        } else if (!this.uni2byte.containsKey(i)) {
            return new byte[0];
        } else {
            return new byte[]{(byte) this.uni2byte.get(i)};
        }
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference getIndirectReference() {
        return this.refFont;
    }

    public boolean charExists(int i) {
        BaseFont baseFont = this.cjkMirror;
        if (baseFont != null) {
            return baseFont.charExists(i);
        }
        if (this.isType0) {
            return this.metrics.containsKey(new Integer(i));
        }
        return super.charExists(i);
    }

    /* access modifiers changed from: package-private */
    public IntHashtable getUni2Byte() {
        return this.uni2byte;
    }
}
