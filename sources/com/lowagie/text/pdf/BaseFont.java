package com.lowagie.text.pdf;

import com.lowagie.text.DocumentException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import lib.android.paypal.com.magnessdk.p058a.C4820b;

public abstract class BaseFont {
    public static final int ASCENT = 1;
    public static final int AWT_ASCENT = 9;
    public static final int AWT_DESCENT = 10;
    public static final int AWT_LEADING = 11;
    public static final int AWT_MAXADVANCE = 12;
    public static final int BBOXLLX = 5;
    public static final int BBOXLLY = 6;
    public static final int BBOXURX = 7;
    public static final int BBOXURY = 8;
    protected static final HashMap BuiltinFonts14 = new HashMap();
    public static final boolean CACHED = true;
    public static final int CAPHEIGHT = 2;
    public static final int[] CHAR_RANGE_ARABIC;
    public static final int[] CHAR_RANGE_CYRILLIC;
    public static final int[] CHAR_RANGE_HEBREW;
    public static final int[] CHAR_RANGE_LATIN;
    public static final char CID_NEWLINE = '翿';
    public static final String COURIER = "Courier";
    public static final String COURIER_BOLD = "Courier-Bold";
    public static final String COURIER_BOLDOBLIQUE = "Courier-BoldOblique";
    public static final String COURIER_OBLIQUE = "Courier-Oblique";
    public static final String CP1250 = "Cp1250";
    public static final String CP1252 = "Cp1252";
    public static final String CP1257 = "Cp1257";
    public static final int DESCENT = 3;
    public static final boolean EMBEDDED = true;
    public static final int FONT_TYPE_CJK = 2;
    public static final int FONT_TYPE_DOCUMENT = 4;
    public static final int FONT_TYPE_T1 = 0;
    public static final int FONT_TYPE_T3 = 5;
    public static final int FONT_TYPE_TT = 1;
    public static final int FONT_TYPE_TTUNI = 3;
    public static final String HELVETICA = "Helvetica";
    public static final String HELVETICA_BOLD = "Helvetica-Bold";
    public static final String HELVETICA_BOLDOBLIQUE = "Helvetica-BoldOblique";
    public static final String HELVETICA_OBLIQUE = "Helvetica-Oblique";
    public static final String IDENTITY_H = "Identity-H";
    public static final String IDENTITY_V = "Identity-V";
    public static final int ITALICANGLE = 4;
    public static final String MACROMAN = "MacRoman";
    public static final boolean NOT_CACHED = false;
    public static final boolean NOT_EMBEDDED = false;
    public static final String RESOURCE_PATH = "com/lowagie/text/pdf/fonts/";
    public static final int STRIKETHROUGH_POSITION = 15;
    public static final int STRIKETHROUGH_THICKNESS = 16;
    public static final int SUBSCRIPT_OFFSET = 18;
    public static final int SUBSCRIPT_SIZE = 17;
    public static final int SUPERSCRIPT_OFFSET = 20;
    public static final int SUPERSCRIPT_SIZE = 19;
    public static final String SYMBOL = "Symbol";
    public static final String TIMES_BOLD = "Times-Bold";
    public static final String TIMES_BOLDITALIC = "Times-BoldItalic";
    public static final String TIMES_ITALIC = "Times-Italic";
    public static final String TIMES_ROMAN = "Times-Roman";
    public static final int UNDERLINE_POSITION = 13;
    public static final int UNDERLINE_THICKNESS = 14;
    public static final String WINANSI = "Cp1252";
    public static final String ZAPFDINGBATS = "ZapfDingbats";
    protected static HashMap fontCache = new HashMap();
    public static final String notdef = ".notdef";
    protected int[][] charBBoxes = new int[256][];
    protected int compressionLevel = -1;
    protected String[] differences = new String[256];
    protected boolean directTextToByte = false;
    protected boolean embedded;
    protected String encoding;
    protected boolean fastWinansi = false;
    protected boolean fontSpecific = true;
    int fontType;
    protected boolean forceWidthsOutput = false;
    protected IntHashtable specialMap;
    protected boolean subset = true;
    protected ArrayList subsetRanges;
    protected char[] unicodeDifferences = new char[256];
    protected int[] widths = new int[256];

    public abstract String[][] getAllNameEntries();

    public int getCidCode(int i) {
        return i;
    }

    public abstract String[][] getFamilyFontName();

    public abstract float getFontDescriptor(int i, float f);

    public abstract String[][] getFullFontName();

    /* access modifiers changed from: package-private */
    public abstract PdfStream getFullFontStream() throws IOException, DocumentException;

    public abstract int getKerning(int i, int i2);

    public abstract String getPostscriptFontName();

    /* access modifiers changed from: protected */
    public abstract int[] getRawCharBBox(int i, String str);

    /* access modifiers changed from: package-private */
    public abstract int getRawWidth(int i, String str);

    public int getUnicodeEquivalent(int i) {
        return i;
    }

    public abstract boolean hasKernPairs();

    public abstract boolean setKerning(int i, int i2, int i3);

    public abstract void setPostscriptFontName(String str);

    /* access modifiers changed from: package-private */
    public abstract void writeFont(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, Object[] objArr) throws DocumentException, IOException;

    static {
        int[] iArr = new int[8];
        iArr[1] = 383;
        iArr[2] = 8192;
        iArr[3] = 8303;
        iArr[4] = 8352;
        iArr[5] = 8399;
        iArr[6] = 64256;
        iArr[7] = 64262;
        CHAR_RANGE_LATIN = iArr;
        int[] iArr2 = new int[10];
        iArr2[1] = 127;
        iArr2[2] = 1536;
        iArr2[3] = 1663;
        iArr2[4] = 8352;
        iArr2[5] = 8399;
        iArr2[6] = 64336;
        iArr2[7] = 64511;
        iArr2[8] = 65136;
        iArr2[9] = 65279;
        CHAR_RANGE_ARABIC = iArr2;
        int[] iArr3 = new int[8];
        iArr3[1] = 127;
        iArr3[2] = 1424;
        iArr3[3] = 1535;
        iArr3[4] = 8352;
        iArr3[5] = 8399;
        iArr3[6] = 64285;
        iArr3[7] = 64335;
        CHAR_RANGE_HEBREW = iArr3;
        int[] iArr4 = new int[8];
        iArr4[1] = 127;
        iArr4[2] = 1024;
        iArr4[3] = 1327;
        iArr4[4] = 8192;
        iArr4[5] = 8303;
        iArr4[6] = 8352;
        iArr4[7] = 8399;
        CHAR_RANGE_CYRILLIC = iArr4;
        BuiltinFonts14.put("Courier", PdfName.COURIER);
        BuiltinFonts14.put("Courier-Bold", PdfName.COURIER_BOLD);
        BuiltinFonts14.put("Courier-BoldOblique", PdfName.COURIER_BOLDOBLIQUE);
        BuiltinFonts14.put("Courier-Oblique", PdfName.COURIER_OBLIQUE);
        BuiltinFonts14.put("Helvetica", PdfName.HELVETICA);
        BuiltinFonts14.put("Helvetica-Bold", PdfName.HELVETICA_BOLD);
        BuiltinFonts14.put("Helvetica-BoldOblique", PdfName.HELVETICA_BOLDOBLIQUE);
        BuiltinFonts14.put("Helvetica-Oblique", PdfName.HELVETICA_OBLIQUE);
        BuiltinFonts14.put("Symbol", PdfName.SYMBOL);
        BuiltinFonts14.put("Times-Roman", PdfName.TIMES_ROMAN);
        BuiltinFonts14.put("Times-Bold", PdfName.TIMES_BOLD);
        BuiltinFonts14.put("Times-BoldItalic", PdfName.TIMES_BOLDITALIC);
        BuiltinFonts14.put("Times-Italic", PdfName.TIMES_ITALIC);
        BuiltinFonts14.put("ZapfDingbats", PdfName.ZAPFDINGBATS);
    }

    static class StreamFont extends PdfStream {
        public StreamFont(byte[] bArr, int[] iArr, int i) throws DocumentException {
            try {
                this.bytes = bArr;
                put(PdfName.LENGTH, new PdfNumber(this.bytes.length));
                int i2 = 0;
                while (i2 < iArr.length) {
                    StringBuilder sb = new StringBuilder("Length");
                    int i3 = i2 + 1;
                    sb.append(i3);
                    put(new PdfName(sb.toString()), new PdfNumber(iArr[i2]));
                    i2 = i3;
                }
                flateCompress(i);
            } catch (Exception e) {
                throw new DocumentException(e);
            }
        }

        public StreamFont(byte[] bArr, String str, int i) throws DocumentException {
            try {
                this.bytes = bArr;
                put(PdfName.LENGTH, new PdfNumber(this.bytes.length));
                if (str != null) {
                    put(PdfName.SUBTYPE, new PdfName(str));
                }
                flateCompress(i);
            } catch (Exception e) {
                throw new DocumentException(e);
            }
        }
    }

    protected BaseFont() {
    }

    public static BaseFont createFont() throws DocumentException, IOException {
        return createFont("Helvetica", "Cp1252", false);
    }

    public static BaseFont createFont(String str, String str2, boolean z) throws DocumentException, IOException {
        return createFont(str, str2, z, true, (byte[]) null, (byte[]) null, false);
    }

    public static BaseFont createFont(String str, String str2, boolean z, boolean z2) throws DocumentException, IOException {
        return createFont(str, str2, z, true, (byte[]) null, (byte[]) null, z2);
    }

    public static BaseFont createFont(String str, String str2, boolean z, boolean z2, byte[] bArr, byte[] bArr2) throws DocumentException, IOException {
        return createFont(str, str2, z, z2, bArr, bArr2, false);
    }

    public static BaseFont createFont(String str, String str2, boolean z, boolean z2, byte[] bArr, byte[] bArr2, boolean z3) throws DocumentException, IOException {
        return createFont(str, str2, z, z2, bArr, bArr2, false, false);
    }

    /* JADX WARNING: type inference failed for: r13v1, types: [com.lowagie.text.pdf.BaseFont, java.lang.Object] */
    /* JADX WARNING: type inference failed for: r13v2 */
    /* JADX WARNING: type inference failed for: r13v15 */
    /* JADX WARNING: type inference failed for: r1v11, types: [com.lowagie.text.pdf.TrueTypeFontUnicode] */
    /* JADX WARNING: type inference failed for: r1v12, types: [com.lowagie.text.pdf.TrueTypeFont] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.lowagie.text.pdf.BaseFont createFont(java.lang.String r8, java.lang.String r9, boolean r10, boolean r11, byte[] r12, byte[] r13, boolean r14, boolean r15) throws com.lowagie.text.DocumentException, java.io.IOException {
        /*
            java.lang.String r0 = getBaseName(r8)
            java.lang.String r9 = normalizeEncoding(r9)
            java.util.HashMap r1 = BuiltinFonts14
            boolean r1 = r1.containsKey(r8)
            r2 = 0
            if (r1 == 0) goto L_0x0013
            r3 = 0
            goto L_0x0017
        L_0x0013:
            boolean r3 = com.lowagie.text.pdf.CJKFont.isCJKFont(r0, r9)
        L_0x0017:
            if (r1 != 0) goto L_0x0032
            if (r3 == 0) goto L_0x001c
            goto L_0x0032
        L_0x001c:
            java.lang.String r2 = "Identity-H"
            boolean r2 = r9.equals(r2)
            if (r2 != 0) goto L_0x002f
            java.lang.String r2 = "Identity-V"
            boolean r2 = r9.equals(r2)
            if (r2 == 0) goto L_0x002d
            goto L_0x002f
        L_0x002d:
            r4 = r10
            goto L_0x0033
        L_0x002f:
            r10 = 1
            r4 = 1
            goto L_0x0033
        L_0x0032:
            r4 = 0
        L_0x0033:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r2 = java.lang.String.valueOf(r8)
            r10.<init>(r2)
            java.lang.String r2 = "\n"
            r10.append(r2)
            r10.append(r9)
            java.lang.String r2 = "\n"
            r10.append(r2)
            r10.append(r4)
            java.lang.String r10 = r10.toString()
            if (r11 == 0) goto L_0x0064
            java.util.HashMap r2 = fontCache
            monitor-enter(r2)
            java.util.HashMap r5 = fontCache     // Catch:{ all -> 0x0061 }
            java.lang.Object r5 = r5.get(r10)     // Catch:{ all -> 0x0061 }
            com.lowagie.text.pdf.BaseFont r5 = (com.lowagie.text.pdf.BaseFont) r5     // Catch:{ all -> 0x0061 }
            monitor-exit(r2)     // Catch:{ all -> 0x0061 }
            if (r5 == 0) goto L_0x0064
            return r5
        L_0x0061:
            r8 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0061 }
            throw r8
        L_0x0064:
            if (r1 != 0) goto L_0x0104
            java.lang.String r1 = r8.toLowerCase()
            java.lang.String r2 = ".afm"
            boolean r1 = r1.endsWith(r2)
            if (r1 != 0) goto L_0x0104
            java.lang.String r1 = r8.toLowerCase()
            java.lang.String r2 = ".pfm"
            boolean r1 = r1.endsWith(r2)
            if (r1 == 0) goto L_0x0080
            goto L_0x0104
        L_0x0080:
            java.lang.String r13 = r0.toLowerCase()
            java.lang.String r1 = ".ttf"
            boolean r13 = r13.endsWith(r1)
            if (r13 != 0) goto L_0x00d4
            java.lang.String r13 = r0.toLowerCase()
            java.lang.String r1 = ".otf"
            boolean r13 = r13.endsWith(r1)
            if (r13 != 0) goto L_0x00d4
            java.lang.String r13 = r0.toLowerCase()
            java.lang.String r0 = ".ttc,"
            int r13 = r13.indexOf(r0)
            if (r13 <= 0) goto L_0x00a5
            goto L_0x00d4
        L_0x00a5:
            if (r3 == 0) goto L_0x00af
            com.lowagie.text.pdf.CJKFont r12 = new com.lowagie.text.pdf.CJKFont
            r12.<init>(r8, r9, r4)
            r13 = r12
            goto L_0x0118
        L_0x00af:
            if (r14 == 0) goto L_0x00b3
            r8 = 0
            return r8
        L_0x00b3:
            com.lowagie.text.DocumentException r10 = new com.lowagie.text.DocumentException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "Font '"
            r11.<init>(r12)
            r11.append(r8)
            java.lang.String r8 = "' with '"
            r11.append(r8)
            r11.append(r9)
            java.lang.String r8 = "' is not recognized."
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            r10.<init>((java.lang.String) r8)
            throw r10
        L_0x00d4:
            java.lang.String r13 = "Identity-H"
            boolean r13 = r9.equals(r13)
            if (r13 != 0) goto L_0x00f9
            java.lang.String r13 = "Identity-V"
            boolean r13 = r9.equals(r13)
            if (r13 == 0) goto L_0x00e5
            goto L_0x00f9
        L_0x00e5:
            com.lowagie.text.pdf.TrueTypeFont r13 = new com.lowagie.text.pdf.TrueTypeFont
            r6 = 0
            r1 = r13
            r2 = r8
            r3 = r9
            r5 = r12
            r7 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7)
            java.lang.String r8 = "Cp1252"
            boolean r8 = r9.equals(r8)
            r13.fastWinansi = r8
            goto L_0x0118
        L_0x00f9:
            com.lowagie.text.pdf.TrueTypeFontUnicode r13 = new com.lowagie.text.pdf.TrueTypeFontUnicode
            r1 = r13
            r2 = r8
            r3 = r9
            r5 = r12
            r6 = r15
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x0118
        L_0x0104:
            com.lowagie.text.pdf.Type1Font r14 = new com.lowagie.text.pdf.Type1Font
            r1 = r14
            r2 = r8
            r3 = r9
            r5 = r12
            r6 = r13
            r7 = r15
            r1.<init>(r2, r3, r4, r5, r6, r7)
            java.lang.String r8 = "Cp1252"
            boolean r8 = r9.equals(r8)
            r14.fastWinansi = r8
            r13 = r14
        L_0x0118:
            if (r11 == 0) goto L_0x0133
            java.util.HashMap r8 = fontCache
            monitor-enter(r8)
            java.util.HashMap r9 = fontCache     // Catch:{ all -> 0x0130 }
            java.lang.Object r9 = r9.get(r10)     // Catch:{ all -> 0x0130 }
            com.lowagie.text.pdf.BaseFont r9 = (com.lowagie.text.pdf.BaseFont) r9     // Catch:{ all -> 0x0130 }
            if (r9 == 0) goto L_0x0129
            monitor-exit(r8)     // Catch:{ all -> 0x0130 }
            return r9
        L_0x0129:
            java.util.HashMap r9 = fontCache     // Catch:{ all -> 0x0130 }
            r9.put(r10, r13)     // Catch:{ all -> 0x0130 }
            monitor-exit(r8)     // Catch:{ all -> 0x0130 }
            goto L_0x0133
        L_0x0130:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0130 }
            throw r9
        L_0x0133:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.BaseFont.createFont(java.lang.String, java.lang.String, boolean, boolean, byte[], byte[], boolean, boolean):com.lowagie.text.pdf.BaseFont");
    }

    public static BaseFont createFont(PRIndirectReference pRIndirectReference) {
        return new DocumentFont(pRIndirectReference);
    }

    protected static String getBaseName(String str) {
        if (str.endsWith(",Bold")) {
            return str.substring(0, str.length() - 5);
        }
        if (str.endsWith(",Italic")) {
            return str.substring(0, str.length() - 7);
        }
        return str.endsWith(",BoldItalic") ? str.substring(0, str.length() - 11) : str;
    }

    protected static String normalizeEncoding(String str) {
        if (str.equals("winansi") || str.equals("")) {
            return "Cp1252";
        }
        return str.equals("macroman") ? MACROMAN : str;
    }

    /* access modifiers changed from: protected */
    public void createEncoding() {
        int i;
        int i2 = 0;
        if (this.encoding.startsWith("#")) {
            this.specialMap = new IntHashtable();
            StringTokenizer stringTokenizer = new StringTokenizer(this.encoding.substring(1), " ,\t\n\r\f");
            if (stringTokenizer.nextToken().equals(C4820b.f5527g)) {
                while (stringTokenizer.hasMoreTokens()) {
                    String nextToken = stringTokenizer.nextToken();
                    String nextToken2 = stringTokenizer.nextToken();
                    char parseInt = (char) Integer.parseInt(stringTokenizer.nextToken(), 16);
                    if (nextToken.startsWith("'")) {
                        i = nextToken.charAt(1);
                    } else {
                        i = Integer.parseInt(nextToken);
                    }
                    int i3 = i % 256;
                    this.specialMap.put(parseInt, i3);
                    this.differences[i3] = nextToken2;
                    this.unicodeDifferences[i3] = parseInt;
                    this.widths[i3] = getRawWidth(parseInt, nextToken2);
                    this.charBBoxes[i3] = getRawCharBBox(parseInt, nextToken2);
                }
            } else {
                int parseInt2 = stringTokenizer.hasMoreTokens() ? Integer.parseInt(stringTokenizer.nextToken()) : 0;
                while (stringTokenizer.hasMoreTokens() && parseInt2 < 256) {
                    int parseInt3 = Integer.parseInt(stringTokenizer.nextToken(), 16) % 65536;
                    String unicodeToName = GlyphList.unicodeToName(parseInt3);
                    if (unicodeToName != null) {
                        this.specialMap.put(parseInt3, parseInt2);
                        this.differences[parseInt2] = unicodeToName;
                        this.unicodeDifferences[parseInt2] = (char) parseInt3;
                        this.widths[parseInt2] = getRawWidth(parseInt3, unicodeToName);
                        this.charBBoxes[parseInt2] = getRawCharBBox(parseInt3, unicodeToName);
                        parseInt2++;
                    }
                }
            }
            while (i2 < 256) {
                String[] strArr = this.differences;
                if (strArr[i2] == null) {
                    strArr[i2] = notdef;
                }
                i2++;
            }
        } else if (this.fontSpecific) {
            while (i2 < 256) {
                this.widths[i2] = getRawWidth(i2, (String) null);
                this.charBBoxes[i2] = getRawCharBBox(i2, (String) null);
                i2++;
            }
        } else {
            byte[] bArr = new byte[1];
            for (int i4 = 0; i4 < 256; i4++) {
                bArr[0] = (byte) i4;
                String convertToString = PdfEncodings.convertToString(bArr, this.encoding);
                char charAt = convertToString.length() > 0 ? convertToString.charAt(0) : '?';
                String unicodeToName2 = GlyphList.unicodeToName(charAt);
                if (unicodeToName2 == null) {
                    unicodeToName2 = notdef;
                }
                this.differences[i4] = unicodeToName2;
                this.unicodeDifferences[i4] = charAt;
                this.widths[i4] = getRawWidth(charAt, unicodeToName2);
                this.charBBoxes[i4] = getRawCharBBox(charAt, unicodeToName2);
            }
        }
    }

    public int getWidth(int i) {
        if (!this.fastWinansi) {
            byte[] convertToBytes = convertToBytes((int) (char) i);
            int i2 = 0;
            for (byte b : convertToBytes) {
                i2 += this.widths[b & 255];
            }
            return i2;
        } else if (i < 128 || (i >= 160 && i <= 255)) {
            return this.widths[i];
        } else {
            return this.widths[PdfEncodings.winansi.get(i)];
        }
    }

    public int getWidth(String str) {
        int i;
        int i2 = 0;
        if (this.fastWinansi) {
            int length = str.length();
            int i3 = 0;
            while (i2 < length) {
                char charAt = str.charAt(i2);
                if (charAt < 128 || (charAt >= 160 && charAt <= 255)) {
                    i = this.widths[charAt];
                } else {
                    i = this.widths[PdfEncodings.winansi.get(charAt)];
                }
                i3 += i;
                i2++;
            }
            return i3;
        }
        byte[] convertToBytes = convertToBytes(str);
        int i4 = 0;
        while (i2 < convertToBytes.length) {
            i4 += this.widths[convertToBytes[i2] & 255];
            i2++;
        }
        return i4;
    }

    public int getDescent(String str) {
        char[] charArray = str.toCharArray();
        int i = 0;
        for (char charBBox : charArray) {
            int[] charBBox2 = getCharBBox(charBBox);
            if (charBBox2 != null && charBBox2[1] < i) {
                i = charBBox2[1];
            }
        }
        return i;
    }

    public int getAscent(String str) {
        char[] charArray = str.toCharArray();
        int i = 0;
        for (char charBBox : charArray) {
            int[] charBBox2 = getCharBBox(charBBox);
            if (charBBox2 != null && charBBox2[3] > i) {
                i = charBBox2[3];
            }
        }
        return i;
    }

    public float getDescentPoint(String str, float f) {
        return ((float) getDescent(str)) * 0.001f * f;
    }

    public float getAscentPoint(String str, float f) {
        return ((float) getAscent(str)) * 0.001f * f;
    }

    public float getWidthPointKerned(String str, float f) {
        float width = ((float) getWidth(str)) * 0.001f * f;
        if (!hasKernPairs()) {
            return width;
        }
        int length = str.length() - 1;
        char[] charArray = str.toCharArray();
        int i = 0;
        int i2 = 0;
        while (i < length) {
            char c = charArray[i];
            i++;
            i2 += getKerning(c, charArray[i]);
        }
        return width + (((float) i2) * 0.001f * f);
    }

    public float getWidthPoint(String str, float f) {
        return ((float) getWidth(str)) * 0.001f * f;
    }

    public float getWidthPoint(int i, float f) {
        return ((float) getWidth(i)) * 0.001f * f;
    }

    /* access modifiers changed from: package-private */
    public byte[] convertToBytes(String str) {
        if (this.directTextToByte) {
            return PdfEncodings.convertToBytes(str, (String) null);
        }
        if (this.specialMap == null) {
            return PdfEncodings.convertToBytes(str, this.encoding);
        }
        byte[] bArr = new byte[str.length()];
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (this.specialMap.containsKey(charAt)) {
                bArr[i] = (byte) this.specialMap.get(charAt);
                i++;
            }
        }
        if (i >= length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }

    /* access modifiers changed from: package-private */
    public byte[] convertToBytes(int i) {
        if (this.directTextToByte) {
            return PdfEncodings.convertToBytes((char) i, (String) null);
        }
        IntHashtable intHashtable = this.specialMap;
        if (intHashtable == null) {
            return PdfEncodings.convertToBytes((char) i, this.encoding);
        }
        if (!intHashtable.containsKey(i)) {
            return new byte[0];
        }
        return new byte[]{(byte) this.specialMap.get(i)};
    }

    public String getEncoding() {
        return this.encoding;
    }

    public int getFontType() {
        return this.fontType;
    }

    public boolean isEmbedded() {
        return this.embedded;
    }

    public boolean isFontSpecific() {
        return this.fontSpecific;
    }

    public static String createSubsetPrefix() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = String.valueOf(str) + ((char) ((int) ((Math.random() * 26.0d) + 65.0d)));
        }
        return String.valueOf(str) + "+";
    }

    /* access modifiers changed from: package-private */
    public char getUnicodeDifferences(int i) {
        return this.unicodeDifferences[i];
    }

    public static String[][] getFullFontName(String str, String str2, byte[] bArr) throws DocumentException, IOException {
        BaseFont baseFont;
        String baseName = getBaseName(str);
        if (baseName.toLowerCase().endsWith(".ttf") || baseName.toLowerCase().endsWith(".otf") || baseName.toLowerCase().indexOf(".ttc,") > 0) {
            baseFont = new TrueTypeFont(str, "Cp1252", false, bArr, true, false);
        } else {
            baseFont = createFont(str, str2, false, false, bArr, (byte[]) null);
        }
        return baseFont.getFullFontName();
    }

    public static Object[] getAllFontNames(String str, String str2, byte[] bArr) throws DocumentException, IOException {
        BaseFont baseFont;
        String baseName = getBaseName(str);
        if (baseName.toLowerCase().endsWith(".ttf") || baseName.toLowerCase().endsWith(".otf") || baseName.toLowerCase().indexOf(".ttc,") > 0) {
            baseFont = new TrueTypeFont(str, "Cp1252", false, bArr, true, false);
        } else {
            baseFont = createFont(str, str2, false, false, bArr, (byte[]) null);
        }
        return new Object[]{baseFont.getPostscriptFontName(), baseFont.getFamilyFontName(), baseFont.getFullFontName()};
    }

    public static String[][] getAllNameEntries(String str, String str2, byte[] bArr) throws DocumentException, IOException {
        BaseFont baseFont;
        String baseName = getBaseName(str);
        if (baseName.toLowerCase().endsWith(".ttf") || baseName.toLowerCase().endsWith(".otf") || baseName.toLowerCase().indexOf(".ttc,") > 0) {
            baseFont = new TrueTypeFont(str, "Cp1252", false, bArr, true, false);
        } else {
            baseFont = createFont(str, str2, false, false, bArr, (byte[]) null);
        }
        return baseFont.getAllNameEntries();
    }

    public String[] getCodePagesSupported() {
        return new String[0];
    }

    public static String[] enumerateTTCNames(String str) throws DocumentException, IOException {
        return new EnumerateTTC(str).getNames();
    }

    public static String[] enumerateTTCNames(byte[] bArr) throws DocumentException, IOException {
        return new EnumerateTTC(bArr).getNames();
    }

    public int[] getWidths() {
        return this.widths;
    }

    public String[] getDifferences() {
        return this.differences;
    }

    public char[] getUnicodeDifferences() {
        return this.unicodeDifferences;
    }

    public boolean isForceWidthsOutput() {
        return this.forceWidthsOutput;
    }

    public void setForceWidthsOutput(boolean z) {
        this.forceWidthsOutput = z;
    }

    public boolean isDirectTextToByte() {
        return this.directTextToByte;
    }

    public void setDirectTextToByte(boolean z) {
        this.directTextToByte = z;
    }

    public boolean isSubset() {
        return this.subset;
    }

    public void setSubset(boolean z) {
        this.subset = z;
    }

    public static InputStream getResourceStream(String str) {
        return getResourceStream(str, (ClassLoader) null);
    }

    public static InputStream getResourceStream(String str, ClassLoader classLoader) {
        if (str.startsWith("/")) {
            str = str.substring(1);
        }
        InputStream inputStream = null;
        if (classLoader != null && (inputStream = classLoader.getResourceAsStream(str)) != null) {
            return inputStream;
        }
        try {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                inputStream = contextClassLoader.getResourceAsStream(str);
            }
        } catch (Throwable unused) {
        }
        if (inputStream == null) {
            inputStream = BaseFont.class.getResourceAsStream("/" + str);
        }
        return inputStream == null ? ClassLoader.getSystemResourceAsStream(str) : inputStream;
    }

    public boolean charExists(int i) {
        return convertToBytes(i).length > 0;
    }

    public boolean setCharAdvance(int i, int i2) {
        byte[] convertToBytes = convertToBytes(i);
        if (convertToBytes.length == 0) {
            return false;
        }
        this.widths[convertToBytes[0] & 255] = i2;
        return true;
    }

    private static void addFont(PRIndirectReference pRIndirectReference, IntHashtable intHashtable, ArrayList arrayList) {
        PdfObject pdfObject = PdfReader.getPdfObject((PdfObject) pRIndirectReference);
        if (pdfObject != null && pdfObject.isDictionary()) {
            PdfDictionary pdfDictionary = (PdfDictionary) pdfObject;
            PdfName asName = pdfDictionary.getAsName(PdfName.SUBTYPE);
            if (PdfName.TYPE1.equals(asName) || PdfName.TRUETYPE.equals(asName)) {
                arrayList.add(new Object[]{PdfName.decodeName(pdfDictionary.getAsName(PdfName.BASEFONT).toString()), pRIndirectReference});
                intHashtable.put(pRIndirectReference.getNumber(), 1);
            }
        }
    }

    private static void recourseFonts(PdfDictionary pdfDictionary, IntHashtable intHashtable, ArrayList arrayList, int i) {
        PdfDictionary asDict;
        int i2 = i + 1;
        if (i2 <= 50 && (asDict = pdfDictionary.getAsDict(PdfName.RESOURCES)) != null) {
            PdfDictionary asDict2 = asDict.getAsDict(PdfName.FONT);
            if (asDict2 != null) {
                for (PdfName pdfName : asDict2.getKeys()) {
                    PdfObject pdfObject = asDict2.get(pdfName);
                    if (pdfObject != null && pdfObject.isIndirect()) {
                        PRIndirectReference pRIndirectReference = (PRIndirectReference) pdfObject;
                        if (!intHashtable.containsKey(pRIndirectReference.getNumber())) {
                            addFont(pRIndirectReference, intHashtable, arrayList);
                        }
                    }
                }
            }
            PdfDictionary asDict3 = asDict.getAsDict(PdfName.XOBJECT);
            if (asDict3 != null) {
                for (PdfName asDict4 : asDict3.getKeys()) {
                    recourseFonts(asDict3.getAsDict(asDict4), intHashtable, arrayList, i2);
                }
            }
        }
    }

    public static ArrayList getDocumentFonts(PdfReader pdfReader) {
        IntHashtable intHashtable = new IntHashtable();
        ArrayList arrayList = new ArrayList();
        int numberOfPages = pdfReader.getNumberOfPages();
        for (int i = 1; i <= numberOfPages; i++) {
            recourseFonts(pdfReader.getPageN(i), intHashtable, arrayList, 1);
        }
        return arrayList;
    }

    public static ArrayList getDocumentFonts(PdfReader pdfReader, int i) {
        IntHashtable intHashtable = new IntHashtable();
        ArrayList arrayList = new ArrayList();
        recourseFonts(pdfReader.getPageN(i), intHashtable, arrayList, 1);
        return arrayList;
    }

    public int[] getCharBBox(int i) {
        byte[] convertToBytes = convertToBytes(i);
        if (convertToBytes.length == 0) {
            return null;
        }
        return this.charBBoxes[convertToBytes[0] & 255];
    }

    public void correctArabicAdvance() {
        for (char c = 1611; c <= 1624; c = (char) (c + 1)) {
            setCharAdvance(c, 0);
        }
        setCharAdvance(1648, 0);
        for (char c2 = 1750; c2 <= 1756; c2 = (char) (c2 + 1)) {
            setCharAdvance(c2, 0);
        }
        for (char c3 = 1759; c3 <= 1764; c3 = (char) (c3 + 1)) {
            setCharAdvance(c3, 0);
        }
        for (char c4 = 1767; c4 <= 1768; c4 = (char) (c4 + 1)) {
            setCharAdvance(c4, 0);
        }
        for (char c5 = 1770; c5 <= 1773; c5 = (char) (c5 + 1)) {
            setCharAdvance(c5, 0);
        }
    }

    public void addSubsetRange(int[] iArr) {
        if (this.subsetRanges == null) {
            this.subsetRanges = new ArrayList();
        }
        this.subsetRanges.add(iArr);
    }

    public int getCompressionLevel() {
        return this.compressionLevel;
    }

    public void setCompressionLevel(int i) {
        if (i < 0 || i > 9) {
            this.compressionLevel = -1;
        } else {
            this.compressionLevel = i;
        }
    }
}
