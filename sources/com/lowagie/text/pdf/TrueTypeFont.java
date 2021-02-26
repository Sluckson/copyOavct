package com.lowagie.text.pdf;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.pdf.BaseFont;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

class TrueTypeFont extends BaseFont {
    static final String[] codePages;
    protected int[] GlyphWidths;
    protected String[][] allNameEntries;
    protected int[][] bboxes;
    protected boolean cff = false;
    protected int cffLength;
    protected int cffOffset;
    protected HashMap cmap10;
    protected HashMap cmap31;
    protected HashMap cmapExt;
    protected int directoryOffset;
    protected String[][] familyName;
    protected String fileName;
    protected String fontName;
    protected String[][] fullName;
    protected FontHeader head = new FontHeader();
    protected HorizontalHeader hhea = new HorizontalHeader();
    protected boolean isFixedPitch = false;
    protected double italicAngle;
    protected boolean justNames = false;
    protected IntHashtable kerning = new IntHashtable();
    protected WindowsMetrics os_2 = new WindowsMetrics();

    /* renamed from: rf */
    protected RandomAccessFileOrArray f765rf;
    protected String style = "";
    protected HashMap tables;
    protected String ttcIndex;
    protected int underlinePosition;
    protected int underlineThickness;

    static {
        String[] strArr = new String[64];
        strArr[0] = "1252 Latin 1";
        strArr[1] = "1250 Latin 2: Eastern Europe";
        strArr[2] = "1251 Cyrillic";
        strArr[3] = "1253 Greek";
        strArr[4] = "1254 Turkish";
        strArr[5] = "1255 Hebrew";
        strArr[6] = "1256 Arabic";
        strArr[7] = "1257 Windows Baltic";
        strArr[8] = "1258 Vietnamese";
        strArr[16] = "874 Thai";
        strArr[17] = "932 JIS/Japan";
        strArr[18] = "936 Chinese: Simplified chars--PRC and Singapore";
        strArr[19] = "949 Korean Wansung";
        strArr[20] = "950 Chinese: Traditional chars--Taiwan and Hong Kong";
        strArr[21] = "1361 Korean Johab";
        strArr[29] = "Macintosh Character Set (US Roman)";
        strArr[30] = "OEM Character Set";
        strArr[31] = "Symbol Character Set";
        strArr[48] = "869 IBM Greek";
        strArr[49] = "866 MS-DOS Russian";
        strArr[50] = "865 MS-DOS Nordic";
        strArr[51] = "864 Arabic";
        strArr[52] = "863 MS-DOS Canadian French";
        strArr[53] = "862 Hebrew";
        strArr[54] = "861 MS-DOS Icelandic";
        strArr[55] = "860 MS-DOS Portuguese";
        strArr[56] = "857 IBM Turkish";
        strArr[57] = "855 IBM Cyrillic; primarily Russian";
        strArr[58] = "852 Latin 2";
        strArr[59] = "775 MS-DOS Baltic";
        strArr[60] = "737 Greek; former 437 G";
        strArr[61] = "708 Arabic; ASMO 708";
        strArr[62] = "850 WE/Latin 1";
        strArr[63] = "437 US";
        codePages = strArr;
    }

    protected static class FontHeader {
        int flags;
        int macStyle;
        int unitsPerEm;
        short xMax;
        short xMin;
        short yMax;
        short yMin;

        protected FontHeader() {
        }
    }

    protected static class HorizontalHeader {
        short Ascender;
        short Descender;
        short LineGap;
        int advanceWidthMax;
        short caretSlopeRise;
        short caretSlopeRun;
        short minLeftSideBearing;
        short minRightSideBearing;
        int numberOfHMetrics;
        short xMaxExtent;

        protected HorizontalHeader() {
        }
    }

    protected static class WindowsMetrics {
        byte[] achVendID = new byte[4];
        int fsSelection;
        short fsType;
        byte[] panose = new byte[10];
        int sCapHeight;
        short sFamilyClass;
        short sTypoAscender;
        short sTypoDescender;
        short sTypoLineGap;
        int ulCodePageRange1;
        int ulCodePageRange2;
        int usFirstCharIndex;
        int usLastCharIndex;
        int usWeightClass;
        int usWidthClass;
        int usWinAscent;
        int usWinDescent;
        short xAvgCharWidth;
        short yStrikeoutPosition;
        short yStrikeoutSize;
        short ySubscriptXOffset;
        short ySubscriptXSize;
        short ySubscriptYOffset;
        short ySubscriptYSize;
        short ySuperscriptXOffset;
        short ySuperscriptXSize;
        short ySuperscriptYOffset;
        short ySuperscriptYSize;

        protected WindowsMetrics() {
        }
    }

    protected TrueTypeFont() {
    }

    TrueTypeFont(String str, String str2, boolean z, byte[] bArr, boolean z2, boolean z3) throws DocumentException, IOException {
        this.justNames = z2;
        String baseName = getBaseName(str);
        String tTCName = getTTCName(baseName);
        if (baseName.length() < str.length()) {
            this.style = str.substring(baseName.length());
        }
        this.encoding = str2;
        this.embedded = z;
        this.fileName = tTCName;
        this.fontType = 1;
        this.ttcIndex = "";
        if (tTCName.length() < baseName.length()) {
            this.ttcIndex = baseName.substring(tTCName.length() + 1);
        }
        if (this.fileName.toLowerCase().endsWith(".ttf") || this.fileName.toLowerCase().endsWith(".otf") || this.fileName.toLowerCase().endsWith(".ttc")) {
            process(bArr, z3);
            if (z2 || !this.embedded || this.os_2.fsType != 2) {
                if (!this.encoding.startsWith("#")) {
                    PdfEncodings.convertToBytes(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, str2);
                }
                createEncoding();
                return;
            }
            throw new DocumentException(String.valueOf(this.fileName) + this.style + " cannot be embedded due to licensing restrictions.");
        }
        throw new DocumentException(String.valueOf(this.fileName) + this.style + " is not a TTF, OTF or TTC font file.");
    }

    protected static String getTTCName(String str) {
        int indexOf = str.toLowerCase().indexOf(".ttc,");
        if (indexOf < 0) {
            return str;
        }
        return str.substring(0, indexOf + 4);
    }

    /* access modifiers changed from: package-private */
    public void fillTables() throws DocumentException, IOException {
        int[] iArr = (int[]) this.tables.get("head");
        if (iArr != null) {
            this.f765rf.seek(iArr[0] + 16);
            this.head.flags = this.f765rf.readUnsignedShort();
            this.head.unitsPerEm = this.f765rf.readUnsignedShort();
            this.f765rf.skipBytes(16);
            this.head.xMin = this.f765rf.readShort();
            this.head.yMin = this.f765rf.readShort();
            this.head.xMax = this.f765rf.readShort();
            this.head.yMax = this.f765rf.readShort();
            this.head.macStyle = this.f765rf.readUnsignedShort();
            int[] iArr2 = (int[]) this.tables.get("hhea");
            if (iArr2 != null) {
                this.f765rf.seek(iArr2[0] + 4);
                this.hhea.Ascender = this.f765rf.readShort();
                this.hhea.Descender = this.f765rf.readShort();
                this.hhea.LineGap = this.f765rf.readShort();
                this.hhea.advanceWidthMax = this.f765rf.readUnsignedShort();
                this.hhea.minLeftSideBearing = this.f765rf.readShort();
                this.hhea.minRightSideBearing = this.f765rf.readShort();
                this.hhea.xMaxExtent = this.f765rf.readShort();
                this.hhea.caretSlopeRise = this.f765rf.readShort();
                this.hhea.caretSlopeRun = this.f765rf.readShort();
                this.f765rf.skipBytes(12);
                this.hhea.numberOfHMetrics = this.f765rf.readUnsignedShort();
                int[] iArr3 = (int[]) this.tables.get("OS/2");
                if (iArr3 != null) {
                    this.f765rf.seek(iArr3[0]);
                    int readUnsignedShort = this.f765rf.readUnsignedShort();
                    this.os_2.xAvgCharWidth = this.f765rf.readShort();
                    this.os_2.usWeightClass = this.f765rf.readUnsignedShort();
                    this.os_2.usWidthClass = this.f765rf.readUnsignedShort();
                    this.os_2.fsType = this.f765rf.readShort();
                    this.os_2.ySubscriptXSize = this.f765rf.readShort();
                    this.os_2.ySubscriptYSize = this.f765rf.readShort();
                    this.os_2.ySubscriptXOffset = this.f765rf.readShort();
                    this.os_2.ySubscriptYOffset = this.f765rf.readShort();
                    this.os_2.ySuperscriptXSize = this.f765rf.readShort();
                    this.os_2.ySuperscriptYSize = this.f765rf.readShort();
                    this.os_2.ySuperscriptXOffset = this.f765rf.readShort();
                    this.os_2.ySuperscriptYOffset = this.f765rf.readShort();
                    this.os_2.yStrikeoutSize = this.f765rf.readShort();
                    this.os_2.yStrikeoutPosition = this.f765rf.readShort();
                    this.os_2.sFamilyClass = this.f765rf.readShort();
                    this.f765rf.readFully(this.os_2.panose);
                    this.f765rf.skipBytes(16);
                    this.f765rf.readFully(this.os_2.achVendID);
                    this.os_2.fsSelection = this.f765rf.readUnsignedShort();
                    this.os_2.usFirstCharIndex = this.f765rf.readUnsignedShort();
                    this.os_2.usLastCharIndex = this.f765rf.readUnsignedShort();
                    this.os_2.sTypoAscender = this.f765rf.readShort();
                    this.os_2.sTypoDescender = this.f765rf.readShort();
                    if (this.os_2.sTypoDescender > 0) {
                        WindowsMetrics windowsMetrics = this.os_2;
                        windowsMetrics.sTypoDescender = (short) (-windowsMetrics.sTypoDescender);
                    }
                    this.os_2.sTypoLineGap = this.f765rf.readShort();
                    this.os_2.usWinAscent = this.f765rf.readUnsignedShort();
                    this.os_2.usWinDescent = this.f765rf.readUnsignedShort();
                    WindowsMetrics windowsMetrics2 = this.os_2;
                    windowsMetrics2.ulCodePageRange1 = 0;
                    windowsMetrics2.ulCodePageRange2 = 0;
                    if (readUnsignedShort > 0) {
                        windowsMetrics2.ulCodePageRange1 = this.f765rf.readInt();
                        this.os_2.ulCodePageRange2 = this.f765rf.readInt();
                    }
                    boolean z = true;
                    if (readUnsignedShort > 1) {
                        this.f765rf.skipBytes(2);
                        this.os_2.sCapHeight = this.f765rf.readShort();
                    } else {
                        this.os_2.sCapHeight = (int) (((double) this.head.unitsPerEm) * 0.7d);
                    }
                    int[] iArr4 = (int[]) this.tables.get("post");
                    if (iArr4 == null) {
                        this.italicAngle = ((-Math.atan2((double) this.hhea.caretSlopeRun, (double) this.hhea.caretSlopeRise)) * 180.0d) / 3.141592653589793d;
                        return;
                    }
                    this.f765rf.seek(iArr4[0] + 4);
                    this.italicAngle = ((double) this.f765rf.readShort()) + (((double) this.f765rf.readUnsignedShort()) / 16384.0d);
                    this.underlinePosition = this.f765rf.readShort();
                    this.underlineThickness = this.f765rf.readShort();
                    if (this.f765rf.readInt() == 0) {
                        z = false;
                    }
                    this.isFixedPitch = z;
                    return;
                }
                throw new DocumentException("Table 'OS/2' does not exist in " + this.fileName + this.style);
            }
            throw new DocumentException("Table 'hhea' does not exist " + this.fileName + this.style);
        }
        throw new DocumentException("Table 'head' does not exist in " + this.fileName + this.style);
    }

    /* access modifiers changed from: package-private */
    public String getBaseFont() throws DocumentException, IOException {
        int[] iArr = (int[]) this.tables.get("name");
        if (iArr != null) {
            this.f765rf.seek(iArr[0] + 2);
            int readUnsignedShort = this.f765rf.readUnsignedShort();
            int readUnsignedShort2 = this.f765rf.readUnsignedShort();
            for (int i = 0; i < readUnsignedShort; i++) {
                int readUnsignedShort3 = this.f765rf.readUnsignedShort();
                this.f765rf.readUnsignedShort();
                this.f765rf.readUnsignedShort();
                int readUnsignedShort4 = this.f765rf.readUnsignedShort();
                int readUnsignedShort5 = this.f765rf.readUnsignedShort();
                int readUnsignedShort6 = this.f765rf.readUnsignedShort();
                if (readUnsignedShort4 == 6) {
                    this.f765rf.seek(iArr[0] + readUnsignedShort2 + readUnsignedShort6);
                    if (readUnsignedShort3 == 0 || readUnsignedShort3 == 3) {
                        return readUnicodeString(readUnsignedShort5);
                    }
                    return readStandardString(readUnsignedShort5);
                }
            }
            return new File(this.fileName).getName().replace(' ', '-');
        }
        throw new DocumentException("Table 'name' does not exist in " + this.fileName + this.style);
    }

    /* access modifiers changed from: package-private */
    public String[][] getNames(int i) throws DocumentException, IOException {
        String str;
        int[] iArr = (int[]) this.tables.get("name");
        if (iArr != null) {
            this.f765rf.seek(iArr[0] + 2);
            int readUnsignedShort = this.f765rf.readUnsignedShort();
            int readUnsignedShort2 = this.f765rf.readUnsignedShort();
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < readUnsignedShort; i2++) {
                int readUnsignedShort3 = this.f765rf.readUnsignedShort();
                int readUnsignedShort4 = this.f765rf.readUnsignedShort();
                int readUnsignedShort5 = this.f765rf.readUnsignedShort();
                int readUnsignedShort6 = this.f765rf.readUnsignedShort();
                int readUnsignedShort7 = this.f765rf.readUnsignedShort();
                int readUnsignedShort8 = this.f765rf.readUnsignedShort();
                if (readUnsignedShort6 == i) {
                    int filePointer = this.f765rf.getFilePointer();
                    this.f765rf.seek(iArr[0] + readUnsignedShort2 + readUnsignedShort8);
                    if (readUnsignedShort3 == 0 || readUnsignedShort3 == 3 || (readUnsignedShort3 == 2 && readUnsignedShort4 == 1)) {
                        str = readUnicodeString(readUnsignedShort7);
                    } else {
                        str = readStandardString(readUnsignedShort7);
                    }
                    arrayList.add(new String[]{String.valueOf(readUnsignedShort3), String.valueOf(readUnsignedShort4), String.valueOf(readUnsignedShort5), str});
                    this.f765rf.seek(filePointer);
                }
            }
            String[][] strArr = new String[arrayList.size()][];
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                strArr[i3] = (String[]) arrayList.get(i3);
            }
            return strArr;
        }
        throw new DocumentException("Table 'name' does not exist in " + this.fileName + this.style);
    }

    /* access modifiers changed from: package-private */
    public String[][] getAllNames() throws DocumentException, IOException {
        String str;
        int[] iArr = (int[]) this.tables.get("name");
        if (iArr != null) {
            this.f765rf.seek(iArr[0] + 2);
            int readUnsignedShort = this.f765rf.readUnsignedShort();
            int readUnsignedShort2 = this.f765rf.readUnsignedShort();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < readUnsignedShort; i++) {
                int readUnsignedShort3 = this.f765rf.readUnsignedShort();
                int readUnsignedShort4 = this.f765rf.readUnsignedShort();
                int readUnsignedShort5 = this.f765rf.readUnsignedShort();
                int readUnsignedShort6 = this.f765rf.readUnsignedShort();
                int readUnsignedShort7 = this.f765rf.readUnsignedShort();
                int readUnsignedShort8 = this.f765rf.readUnsignedShort();
                int filePointer = this.f765rf.getFilePointer();
                this.f765rf.seek(iArr[0] + readUnsignedShort2 + readUnsignedShort8);
                if (readUnsignedShort3 == 0 || readUnsignedShort3 == 3 || (readUnsignedShort3 == 2 && readUnsignedShort4 == 1)) {
                    str = readUnicodeString(readUnsignedShort7);
                } else {
                    str = readStandardString(readUnsignedShort7);
                }
                arrayList.add(new String[]{String.valueOf(readUnsignedShort6), String.valueOf(readUnsignedShort3), String.valueOf(readUnsignedShort4), String.valueOf(readUnsignedShort5), str});
                this.f765rf.seek(filePointer);
            }
            String[][] strArr = new String[arrayList.size()][];
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                strArr[i2] = (String[]) arrayList.get(i2);
            }
            return strArr;
        }
        throw new DocumentException("Table 'name' does not exist in " + this.fileName + this.style);
    }

    /* access modifiers changed from: package-private */
    public void checkCff() {
        int[] iArr = (int[]) this.tables.get("CFF ");
        if (iArr != null) {
            this.cff = true;
            this.cffOffset = iArr[0];
            this.cffLength = iArr[1];
        }
    }

    /* access modifiers changed from: package-private */
    public void process(byte[] bArr, boolean z) throws DocumentException, IOException {
        this.tables = new HashMap();
        if (bArr == null) {
            try {
                this.f765rf = new RandomAccessFileOrArray(this.fileName, z, Document.plainRandomAccess);
            } catch (Throwable th) {
                RandomAccessFileOrArray randomAccessFileOrArray = this.f765rf;
                if (randomAccessFileOrArray != null) {
                    randomAccessFileOrArray.close();
                    if (!this.embedded) {
                        this.f765rf = null;
                    }
                }
                throw th;
            }
        } else {
            this.f765rf = new RandomAccessFileOrArray(bArr);
        }
        if (this.ttcIndex.length() > 0) {
            int parseInt = Integer.parseInt(this.ttcIndex);
            if (parseInt < 0) {
                throw new DocumentException("The font index for " + this.fileName + " must be positive.");
            } else if (readStandardString(4).equals("ttcf")) {
                this.f765rf.skipBytes(4);
                int readInt = this.f765rf.readInt();
                if (parseInt < readInt) {
                    this.f765rf.skipBytes(parseInt * 4);
                    this.directoryOffset = this.f765rf.readInt();
                } else {
                    throw new DocumentException("The font index for " + this.fileName + " must be between 0 and " + (readInt - 1) + ". It was " + parseInt + ".");
                }
            } else {
                throw new DocumentException(String.valueOf(this.fileName) + " is not a valid TTC file.");
            }
        }
        this.f765rf.seek(this.directoryOffset);
        int readInt2 = this.f765rf.readInt();
        if (readInt2 != 65536) {
            if (readInt2 != 1330926671) {
                throw new DocumentException(String.valueOf(this.fileName) + " is not a valid TTF or OTF file.");
            }
        }
        int readUnsignedShort = this.f765rf.readUnsignedShort();
        this.f765rf.skipBytes(6);
        for (int i = 0; i < readUnsignedShort; i++) {
            String readStandardString = readStandardString(4);
            this.f765rf.skipBytes(4);
            this.tables.put(readStandardString, new int[]{this.f765rf.readInt(), this.f765rf.readInt()});
        }
        checkCff();
        this.fontName = getBaseFont();
        this.fullName = getNames(4);
        this.familyName = getNames(1);
        this.allNameEntries = getAllNames();
        if (!this.justNames) {
            fillTables();
            readGlyphWidths();
            readCMaps();
            readKerning();
            readBbox();
            this.GlyphWidths = null;
        }
        RandomAccessFileOrArray randomAccessFileOrArray2 = this.f765rf;
        if (randomAccessFileOrArray2 != null) {
            randomAccessFileOrArray2.close();
            if (!this.embedded) {
                this.f765rf = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public String readStandardString(int i) throws IOException {
        byte[] bArr = new byte[i];
        this.f765rf.readFully(bArr);
        try {
            return new String(bArr, "Cp1252");
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* access modifiers changed from: protected */
    public String readUnicodeString(int i) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = i / 2;
        for (int i3 = 0; i3 < i2; i3++) {
            stringBuffer.append(this.f765rf.readChar());
        }
        return stringBuffer.toString();
    }

    /* access modifiers changed from: protected */
    public void readGlyphWidths() throws DocumentException, IOException {
        int[] iArr = (int[]) this.tables.get("hmtx");
        if (iArr != null) {
            this.f765rf.seek(iArr[0]);
            this.GlyphWidths = new int[this.hhea.numberOfHMetrics];
            for (int i = 0; i < this.hhea.numberOfHMetrics; i++) {
                this.GlyphWidths[i] = (this.f765rf.readUnsignedShort() * 1000) / this.head.unitsPerEm;
                this.f765rf.readUnsignedShort();
            }
            return;
        }
        throw new DocumentException("Table 'hmtx' does not exist in " + this.fileName + this.style);
    }

    /* access modifiers changed from: protected */
    public int getGlyphWidth(int i) {
        int[] iArr = this.GlyphWidths;
        if (i >= iArr.length) {
            i = iArr.length - 1;
        }
        return this.GlyphWidths[i];
    }

    private void readBbox() throws DocumentException, IOException {
        int[] iArr;
        int[] iArr2 = (int[]) this.tables.get("head");
        if (iArr2 != null) {
            this.f765rf.seek(iArr2[0] + 51);
            boolean z = this.f765rf.readUnsignedShort() == 0;
            int[] iArr3 = (int[]) this.tables.get("loca");
            if (iArr3 != null) {
                this.f765rf.seek(iArr3[0]);
                if (z) {
                    int i = iArr3[1] / 2;
                    iArr = new int[i];
                    for (int i2 = 0; i2 < i; i2++) {
                        iArr[i2] = this.f765rf.readUnsignedShort() * 2;
                    }
                } else {
                    int i3 = iArr3[1] / 4;
                    iArr = new int[i3];
                    for (int i4 = 0; i4 < i3; i4++) {
                        iArr[i4] = this.f765rf.readInt();
                    }
                }
                int[] iArr4 = (int[]) this.tables.get("glyf");
                if (iArr4 != null) {
                    int i5 = iArr4[0];
                    this.bboxes = new int[(iArr.length - 1)][];
                    int i6 = 0;
                    while (i6 < iArr.length - 1) {
                        int i7 = iArr[i6];
                        int i8 = i6 + 1;
                        if (i7 != iArr[i8]) {
                            this.f765rf.seek(i7 + i5 + 2);
                            this.bboxes[i6] = new int[]{(this.f765rf.readShort() * 1000) / this.head.unitsPerEm, (this.f765rf.readShort() * 1000) / this.head.unitsPerEm, (this.f765rf.readShort() * 1000) / this.head.unitsPerEm, (this.f765rf.readShort() * 1000) / this.head.unitsPerEm};
                        }
                        i6 = i8;
                    }
                    return;
                }
                throw new DocumentException("Table 'glyf' does not exist in " + this.fileName + this.style);
            }
            return;
        }
        throw new DocumentException("Table 'head' does not exist in " + this.fileName + this.style);
    }

    /* access modifiers changed from: package-private */
    public void readCMaps() throws DocumentException, IOException {
        int[] iArr = (int[]) this.tables.get("cmap");
        if (iArr != null) {
            this.f765rf.seek(iArr[0]);
            this.f765rf.skipBytes(2);
            int readUnsignedShort = this.f765rf.readUnsignedShort();
            this.fontSpecific = false;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < readUnsignedShort; i5++) {
                int readUnsignedShort2 = this.f765rf.readUnsignedShort();
                int readUnsignedShort3 = this.f765rf.readUnsignedShort();
                int readInt = this.f765rf.readInt();
                if (readUnsignedShort2 == 3 && readUnsignedShort3 == 0) {
                    this.fontSpecific = true;
                    i3 = readInt;
                } else if (readUnsignedShort2 == 3 && readUnsignedShort3 == 1) {
                    i2 = readInt;
                } else if (readUnsignedShort2 == 3 && readUnsignedShort3 == 10) {
                    i4 = readInt;
                }
                if (readUnsignedShort2 == 1 && readUnsignedShort3 == 0) {
                    i = readInt;
                }
            }
            if (i > 0) {
                this.f765rf.seek(iArr[0] + i);
                int readUnsignedShort4 = this.f765rf.readUnsignedShort();
                if (readUnsignedShort4 == 0) {
                    this.cmap10 = readFormat0();
                } else if (readUnsignedShort4 == 4) {
                    this.cmap10 = readFormat4();
                } else if (readUnsignedShort4 == 6) {
                    this.cmap10 = readFormat6();
                }
            }
            if (i2 > 0) {
                this.f765rf.seek(iArr[0] + i2);
                if (this.f765rf.readUnsignedShort() == 4) {
                    this.cmap31 = readFormat4();
                }
            }
            if (i3 > 0) {
                this.f765rf.seek(iArr[0] + i3);
                if (this.f765rf.readUnsignedShort() == 4) {
                    this.cmap10 = readFormat4();
                }
            }
            if (i4 > 0) {
                this.f765rf.seek(iArr[0] + i4);
                int readUnsignedShort5 = this.f765rf.readUnsignedShort();
                if (readUnsignedShort5 == 0) {
                    this.cmapExt = readFormat0();
                } else if (readUnsignedShort5 == 4) {
                    this.cmapExt = readFormat4();
                } else if (readUnsignedShort5 == 6) {
                    this.cmapExt = readFormat6();
                } else if (readUnsignedShort5 == 12) {
                    this.cmapExt = readFormat12();
                }
            }
        } else {
            throw new DocumentException("Table 'cmap' does not exist in " + this.fileName + this.style);
        }
    }

    /* access modifiers changed from: package-private */
    public HashMap readFormat12() throws IOException {
        HashMap hashMap = new HashMap();
        this.f765rf.skipBytes(2);
        this.f765rf.readInt();
        this.f765rf.skipBytes(4);
        int readInt = this.f765rf.readInt();
        for (int i = 0; i < readInt; i++) {
            int readInt2 = this.f765rf.readInt();
            int readInt3 = this.f765rf.readInt();
            for (int readInt4 = this.f765rf.readInt(); readInt4 <= readInt2; readInt4++) {
                int[] iArr = new int[2];
                iArr[0] = readInt3;
                iArr[1] = getGlyphWidth(iArr[0]);
                hashMap.put(new Integer(readInt4), iArr);
                readInt3++;
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public HashMap readFormat0() throws IOException {
        HashMap hashMap = new HashMap();
        this.f765rf.skipBytes(4);
        for (int i = 0; i < 256; i++) {
            int[] iArr = new int[2];
            iArr[0] = this.f765rf.readUnsignedByte();
            iArr[1] = getGlyphWidth(iArr[0]);
            hashMap.put(new Integer(i), iArr);
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public HashMap readFormat4() throws IOException {
        int i;
        HashMap hashMap = new HashMap();
        int readUnsignedShort = this.f765rf.readUnsignedShort();
        this.f765rf.skipBytes(2);
        int readUnsignedShort2 = this.f765rf.readUnsignedShort() / 2;
        this.f765rf.skipBytes(6);
        int[] iArr = new int[readUnsignedShort2];
        for (int i2 = 0; i2 < readUnsignedShort2; i2++) {
            iArr[i2] = this.f765rf.readUnsignedShort();
        }
        this.f765rf.skipBytes(2);
        int[] iArr2 = new int[readUnsignedShort2];
        for (int i3 = 0; i3 < readUnsignedShort2; i3++) {
            iArr2[i3] = this.f765rf.readUnsignedShort();
        }
        int[] iArr3 = new int[readUnsignedShort2];
        for (int i4 = 0; i4 < readUnsignedShort2; i4++) {
            iArr3[i4] = this.f765rf.readUnsignedShort();
        }
        int[] iArr4 = new int[readUnsignedShort2];
        for (int i5 = 0; i5 < readUnsignedShort2; i5++) {
            iArr4[i5] = this.f765rf.readUnsignedShort();
        }
        int[] iArr5 = new int[(((readUnsignedShort / 2) - 8) - (readUnsignedShort2 * 4))];
        for (int i6 = 0; i6 < iArr5.length; i6++) {
            iArr5[i6] = this.f765rf.readUnsignedShort();
        }
        for (int i7 = 0; i7 < readUnsignedShort2; i7++) {
            int i8 = iArr2[i7];
            while (i8 <= iArr[i7] && i8 != 65535) {
                if (iArr4[i7] == 0) {
                    i = iArr3[i7] + i8;
                } else {
                    int i9 = ((((iArr4[i7] / 2) + i7) - readUnsignedShort2) + i8) - iArr2[i7];
                    if (i9 >= iArr5.length) {
                        i8++;
                    } else {
                        i = iArr5[i9] + iArr3[i7];
                    }
                }
                int i10 = 65535 & i;
                int[] iArr6 = new int[2];
                iArr6[0] = i10;
                iArr6[1] = getGlyphWidth(iArr6[0]);
                hashMap.put(new Integer((!this.fontSpecific || (65280 & i8) != 61440) ? i8 : i8 & 255), iArr6);
                i8++;
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public HashMap readFormat6() throws IOException {
        HashMap hashMap = new HashMap();
        this.f765rf.skipBytes(4);
        int readUnsignedShort = this.f765rf.readUnsignedShort();
        int readUnsignedShort2 = this.f765rf.readUnsignedShort();
        for (int i = 0; i < readUnsignedShort2; i++) {
            int[] iArr = new int[2];
            iArr[0] = this.f765rf.readUnsignedShort();
            iArr[1] = getGlyphWidth(iArr[0]);
            hashMap.put(new Integer(i + readUnsignedShort), iArr);
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public void readKerning() throws IOException {
        int[] iArr = (int[]) this.tables.get("kern");
        if (iArr != null) {
            this.f765rf.seek(iArr[0] + 2);
            int readUnsignedShort = this.f765rf.readUnsignedShort();
            int i = iArr[0] + 4;
            int i2 = 0;
            for (int i3 = 0; i3 < readUnsignedShort; i3++) {
                i += i2;
                this.f765rf.seek(i);
                this.f765rf.skipBytes(2);
                i2 = this.f765rf.readUnsignedShort();
                if ((this.f765rf.readUnsignedShort() & 65527) == 1) {
                    int readUnsignedShort2 = this.f765rf.readUnsignedShort();
                    this.f765rf.skipBytes(6);
                    for (int i4 = 0; i4 < readUnsignedShort2; i4++) {
                        this.kerning.put(this.f765rf.readInt(), (this.f765rf.readShort() * 1000) / this.head.unitsPerEm);
                    }
                }
            }
        }
    }

    public int getKerning(int i, int i2) {
        int[] metricsTT = getMetricsTT(i);
        if (metricsTT == null) {
            return 0;
        }
        int i3 = metricsTT[0];
        int[] metricsTT2 = getMetricsTT(i2);
        if (metricsTT2 == null) {
            return 0;
        }
        return this.kerning.get((i3 << 16) + metricsTT2[0]);
    }

    /* access modifiers changed from: package-private */
    public int getRawWidth(int i, String str) {
        int[] metricsTT = getMetricsTT(i);
        if (metricsTT == null) {
            return 0;
        }
        return metricsTT[1];
    }

    /* access modifiers changed from: protected */
    public PdfDictionary getFontDescriptor(PdfIndirectReference pdfIndirectReference, String str, PdfIndirectReference pdfIndirectReference2) {
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.FONTDESCRIPTOR);
        pdfDictionary.put(PdfName.ASCENT, new PdfNumber((this.os_2.sTypoAscender * 1000) / this.head.unitsPerEm));
        pdfDictionary.put(PdfName.CAPHEIGHT, new PdfNumber((this.os_2.sCapHeight * 1000) / this.head.unitsPerEm));
        pdfDictionary.put(PdfName.DESCENT, new PdfNumber((this.os_2.sTypoDescender * 1000) / this.head.unitsPerEm));
        pdfDictionary.put(PdfName.FONTBBOX, new PdfRectangle((float) ((this.head.xMin * 1000) / this.head.unitsPerEm), (float) ((this.head.yMin * 1000) / this.head.unitsPerEm), (float) ((this.head.xMax * 1000) / this.head.unitsPerEm), (float) ((this.head.yMax * 1000) / this.head.unitsPerEm)));
        if (pdfIndirectReference2 != null) {
            pdfDictionary.put(PdfName.CIDSET, pdfIndirectReference2);
        }
        if (!this.cff) {
            PdfName pdfName = PdfName.FONTNAME;
            pdfDictionary.put(pdfName, new PdfName(String.valueOf(str) + this.fontName + this.style));
        } else if (this.encoding.startsWith("Identity-")) {
            PdfName pdfName2 = PdfName.FONTNAME;
            pdfDictionary.put(pdfName2, new PdfName(String.valueOf(str) + this.fontName + "-" + this.encoding));
        } else {
            PdfName pdfName3 = PdfName.FONTNAME;
            pdfDictionary.put(pdfName3, new PdfName(String.valueOf(str) + this.fontName + this.style));
        }
        pdfDictionary.put(PdfName.ITALICANGLE, new PdfNumber(this.italicAngle));
        pdfDictionary.put(PdfName.STEMV, new PdfNumber(80));
        if (pdfIndirectReference != null) {
            if (this.cff) {
                pdfDictionary.put(PdfName.FONTFILE3, pdfIndirectReference);
            } else {
                pdfDictionary.put(PdfName.FONTFILE2, pdfIndirectReference);
            }
        }
        int i = 0;
        if (this.isFixedPitch) {
            i = 1;
        }
        int i2 = i | (this.fontSpecific ? 4 : 32);
        if ((this.head.macStyle & 2) != 0) {
            i2 |= 64;
        }
        if ((this.head.macStyle & 1) != 0) {
            i2 |= 262144;
        }
        pdfDictionary.put(PdfName.FLAGS, new PdfNumber(i2));
        return pdfDictionary;
    }

    /* access modifiers changed from: protected */
    public PdfDictionary getFontBaseType(PdfIndirectReference pdfIndirectReference, String str, int i, int i2, byte[] bArr) {
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.FONT);
        if (this.cff) {
            pdfDictionary.put(PdfName.SUBTYPE, PdfName.TYPE1);
            PdfName pdfName = PdfName.BASEFONT;
            pdfDictionary.put(pdfName, new PdfName(String.valueOf(this.fontName) + this.style));
        } else {
            pdfDictionary.put(PdfName.SUBTYPE, PdfName.TRUETYPE);
            PdfName pdfName2 = PdfName.BASEFONT;
            pdfDictionary.put(pdfName2, new PdfName(String.valueOf(str) + this.fontName + this.style));
        }
        PdfName pdfName3 = PdfName.BASEFONT;
        pdfDictionary.put(pdfName3, new PdfName(String.valueOf(str) + this.fontName + this.style));
        if (!this.fontSpecific) {
            int i3 = i;
            while (true) {
                if (i3 > i2) {
                    break;
                } else if (!this.differences[i3].equals(BaseFont.notdef)) {
                    i = i3;
                    break;
                } else {
                    i3++;
                }
            }
            if (this.encoding.equals("Cp1252") || this.encoding.equals(BaseFont.MACROMAN)) {
                pdfDictionary.put(PdfName.ENCODING, this.encoding.equals("Cp1252") ? PdfName.WIN_ANSI_ENCODING : PdfName.MAC_ROMAN_ENCODING);
            } else {
                PdfDictionary pdfDictionary2 = new PdfDictionary(PdfName.ENCODING);
                PdfArray pdfArray = new PdfArray();
                boolean z = true;
                for (int i4 = i; i4 <= i2; i4++) {
                    if (bArr[i4] != 0) {
                        if (z) {
                            pdfArray.add((PdfObject) new PdfNumber(i4));
                            z = false;
                        }
                        pdfArray.add((PdfObject) new PdfName(this.differences[i4]));
                    } else {
                        z = true;
                    }
                }
                pdfDictionary2.put(PdfName.DIFFERENCES, pdfArray);
                pdfDictionary.put(PdfName.ENCODING, pdfDictionary2);
            }
        }
        pdfDictionary.put(PdfName.FIRSTCHAR, new PdfNumber(i));
        pdfDictionary.put(PdfName.LASTCHAR, new PdfNumber(i2));
        PdfArray pdfArray2 = new PdfArray();
        while (i <= i2) {
            if (bArr[i] == 0) {
                pdfArray2.add((PdfObject) new PdfNumber(0));
            } else {
                pdfArray2.add((PdfObject) new PdfNumber(this.widths[i]));
            }
            i++;
        }
        pdfDictionary.put(PdfName.WIDTHS, pdfArray2);
        if (pdfIndirectReference != null) {
            pdfDictionary.put(PdfName.FONTDESCRIPTOR, pdfIndirectReference);
        }
        return pdfDictionary;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0020 A[SYNTHETIC, Splitter:B:13:0x0020] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getFullFont() throws java.io.IOException {
        /*
            r4 = this;
            r0 = 0
            com.lowagie.text.pdf.RandomAccessFileOrArray r1 = new com.lowagie.text.pdf.RandomAccessFileOrArray     // Catch:{ all -> 0x001a }
            com.lowagie.text.pdf.RandomAccessFileOrArray r2 = r4.f765rf     // Catch:{ all -> 0x001a }
            r1.<init>((com.lowagie.text.pdf.RandomAccessFileOrArray) r2)     // Catch:{ all -> 0x001a }
            r1.reOpen()     // Catch:{ all -> 0x0018 }
            int r0 = r1.length()     // Catch:{ all -> 0x0018 }
            byte[] r0 = new byte[r0]     // Catch:{ all -> 0x0018 }
            r1.readFully(r0)     // Catch:{ all -> 0x0018 }
            r1.close()     // Catch:{ Exception -> 0x0017 }
        L_0x0017:
            return r0
        L_0x0018:
            r0 = move-exception
            goto L_0x001e
        L_0x001a:
            r1 = move-exception
            r3 = r1
            r1 = r0
            r0 = r3
        L_0x001e:
            if (r1 == 0) goto L_0x0023
            r1.close()     // Catch:{ Exception -> 0x0023 }
        L_0x0023:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.TrueTypeFont.getFullFont():byte[]");
    }

    protected static int[] compactRanges(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            int[] iArr = (int[]) arrayList.get(i);
            for (int i2 = 0; i2 < iArr.length; i2 += 2) {
                int i3 = i2 + 1;
                arrayList2.add(new int[]{Math.max(0, Math.min(iArr[i2], iArr[i3])), Math.min(65535, Math.max(iArr[i2], iArr[i3]))});
            }
        }
        int i4 = 0;
        while (i4 < arrayList2.size() - 1) {
            int i5 = i4 + 1;
            int i6 = i5;
            while (i6 < arrayList2.size()) {
                int[] iArr2 = (int[]) arrayList2.get(i4);
                int[] iArr3 = (int[]) arrayList2.get(i6);
                if ((iArr2[0] >= iArr3[0] && iArr2[0] <= iArr3[1]) || (iArr2[1] >= iArr3[0] && iArr2[0] <= iArr3[1])) {
                    iArr2[0] = Math.min(iArr2[0], iArr3[0]);
                    iArr2[1] = Math.max(iArr2[1], iArr3[1]);
                    arrayList2.remove(i6);
                    i6--;
                }
                i6++;
            }
            i4 = i5;
        }
        int[] iArr4 = new int[(arrayList2.size() * 2)];
        for (int i7 = 0; i7 < arrayList2.size(); i7++) {
            int[] iArr5 = (int[]) arrayList2.get(i7);
            int i8 = i7 * 2;
            iArr4[i8] = iArr5[0];
            iArr4[i8 + 1] = iArr5[1];
        }
        return iArr4;
    }

    /* access modifiers changed from: protected */
    public void addRangeUni(HashMap hashMap, boolean z, boolean z2) {
        int[] iArr;
        HashMap hashMap2;
        boolean z3;
        if (z2) {
            return;
        }
        if (this.subsetRanges != null || this.directoryOffset > 0) {
            if (this.subsetRanges != null || this.directoryOffset <= 0) {
                iArr = compactRanges(this.subsetRanges);
            } else {
                iArr = new int[2];
                iArr[1] = 65535;
            }
            if ((this.fontSpecific || (hashMap2 = this.cmap31) == null) && ((!this.fontSpecific || (hashMap2 = this.cmap10) == null) && (hashMap2 = this.cmap31) == null)) {
                hashMap2 = this.cmap10;
            }
            for (Map.Entry entry : hashMap2.entrySet()) {
                int[] iArr2 = (int[]) entry.getValue();
                Integer num = new Integer(iArr2[0]);
                if (!hashMap.containsKey(num)) {
                    int intValue = ((Integer) entry.getKey()).intValue();
                    int i = 0;
                    while (true) {
                        if (i < iArr.length) {
                            if (intValue >= iArr[i] && intValue <= iArr[i + 1]) {
                                z3 = false;
                                break;
                            }
                            i += 2;
                        } else {
                            z3 = true;
                            break;
                        }
                    }
                    if (!z3) {
                        hashMap.put(num, z ? new int[]{iArr2[0], iArr2[1], intValue} : null);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void writeFont(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, Object[] objArr) throws DocumentException, IOException {
        int i;
        int i2;
        String str;
        PdfIndirectReference pdfIndirectReference2;
        byte[] bArr;
        int[] iArr;
        PdfWriter pdfWriter2 = pdfWriter;
        int intValue = objArr[0].intValue();
        int intValue2 = objArr[1].intValue();
        byte[] bArr2 = objArr[2];
        boolean z = objArr[3].booleanValue() && this.subset;
        if (!z) {
            i = bArr2.length - 1;
            for (int i3 = 0; i3 < bArr2.length; i3++) {
                bArr2[i3] = 1;
            }
            i2 = 0;
        } else {
            i = intValue2;
            i2 = intValue;
        }
        String str2 = "";
        if (!this.embedded) {
            str = str2;
            pdfIndirectReference2 = null;
        } else if (this.cff) {
            pdfIndirectReference2 = pdfWriter2.addToBody(new BaseFont.StreamFont(readCffFont(), "Type1C", this.compressionLevel)).getIndirectReference();
            str = str2;
        } else {
            if (z) {
                str2 = createSubsetPrefix();
            }
            String str3 = str2;
            HashMap hashMap = new HashMap();
            for (int i4 = i2; i4 <= i; i4++) {
                if (bArr2[i4] != 0) {
                    if (this.specialMap != null) {
                        int[] nameToUnicode = GlyphList.nameToUnicode(this.differences[i4]);
                        iArr = nameToUnicode != null ? getMetricsTT(nameToUnicode[0]) : null;
                    } else if (this.fontSpecific) {
                        iArr = getMetricsTT(i4);
                    } else {
                        iArr = getMetricsTT(this.unicodeDifferences[i4]);
                    }
                    if (iArr != null) {
                        hashMap.put(new Integer(iArr[0]), (Object) null);
                    }
                }
            }
            addRangeUni(hashMap, false, z);
            if (!z && this.directoryOffset == 0 && this.subsetRanges == null) {
                bArr = getFullFont();
            } else {
                bArr = new TrueTypeFontSubSet(this.fileName, new RandomAccessFileOrArray(this.f765rf), hashMap, this.directoryOffset, true, !z).process();
            }
            pdfIndirectReference2 = pdfWriter2.addToBody(new BaseFont.StreamFont(bArr, new int[]{bArr.length}, this.compressionLevel)).getIndirectReference();
            str = str3;
        }
        PdfDictionary fontDescriptor = getFontDescriptor(pdfIndirectReference2, str, (PdfIndirectReference) null);
        if (fontDescriptor != null) {
            pdfIndirectReference2 = pdfWriter2.addToBody(fontDescriptor).getIndirectReference();
        }
        pdfWriter2.addToBody((PdfObject) getFontBaseType(pdfIndirectReference2, str, i2, i, bArr2), pdfIndirectReference);
    }

    /* access modifiers changed from: protected */
    public byte[] readCffFont() throws IOException {
        RandomAccessFileOrArray randomAccessFileOrArray = new RandomAccessFileOrArray(this.f765rf);
        byte[] bArr = new byte[this.cffLength];
        try {
            randomAccessFileOrArray.reOpen();
            randomAccessFileOrArray.seek(this.cffOffset);
            randomAccessFileOrArray.readFully(bArr);
            return bArr;
        } finally {
            try {
                randomAccessFileOrArray.close();
            } catch (Exception unused) {
            }
        }
    }

    public PdfStream getFullFontStream() throws IOException, DocumentException {
        if (this.cff) {
            return new BaseFont.StreamFont(readCffFont(), "Type1C", this.compressionLevel);
        }
        byte[] fullFont = getFullFont();
        return new BaseFont.StreamFont(fullFont, new int[]{fullFont.length}, this.compressionLevel);
    }

    public float getFontDescriptor(int i, float f) {
        float f2;
        int i2;
        switch (i) {
            case 1:
                return (((float) this.os_2.sTypoAscender) * f) / ((float) this.head.unitsPerEm);
            case 2:
                return (((float) this.os_2.sCapHeight) * f) / ((float) this.head.unitsPerEm);
            case 3:
                return (((float) this.os_2.sTypoDescender) * f) / ((float) this.head.unitsPerEm);
            case 4:
                return (float) this.italicAngle;
            case 5:
                f2 = f * ((float) this.head.xMin);
                i2 = this.head.unitsPerEm;
                break;
            case 6:
                f2 = f * ((float) this.head.yMin);
                i2 = this.head.unitsPerEm;
                break;
            case 7:
                f2 = f * ((float) this.head.xMax);
                i2 = this.head.unitsPerEm;
                break;
            case 8:
                f2 = f * ((float) this.head.yMax);
                i2 = this.head.unitsPerEm;
                break;
            case 9:
                f2 = f * ((float) this.hhea.Ascender);
                i2 = this.head.unitsPerEm;
                break;
            case 10:
                f2 = f * ((float) this.hhea.Descender);
                i2 = this.head.unitsPerEm;
                break;
            case 11:
                f2 = f * ((float) this.hhea.LineGap);
                i2 = this.head.unitsPerEm;
                break;
            case 12:
                f2 = f * ((float) this.hhea.advanceWidthMax);
                i2 = this.head.unitsPerEm;
                break;
            case 13:
                return (((float) (this.underlinePosition - (this.underlineThickness / 2))) * f) / ((float) this.head.unitsPerEm);
            case 14:
                return (((float) this.underlineThickness) * f) / ((float) this.head.unitsPerEm);
            case 15:
                return (((float) this.os_2.yStrikeoutPosition) * f) / ((float) this.head.unitsPerEm);
            case 16:
                return (((float) this.os_2.yStrikeoutSize) * f) / ((float) this.head.unitsPerEm);
            case 17:
                return (((float) this.os_2.ySubscriptYSize) * f) / ((float) this.head.unitsPerEm);
            case 18:
                return (((float) (-this.os_2.ySubscriptYOffset)) * f) / ((float) this.head.unitsPerEm);
            case 19:
                return (((float) this.os_2.ySuperscriptYSize) * f) / ((float) this.head.unitsPerEm);
            case 20:
                return (((float) this.os_2.ySuperscriptYOffset) * f) / ((float) this.head.unitsPerEm);
            default:
                return 0.0f;
        }
        return f2 / ((float) i2);
    }

    public int[] getMetricsTT(int i) {
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3 = this.cmapExt;
        if (hashMap3 != null) {
            return (int[]) hashMap3.get(new Integer(i));
        }
        if (!this.fontSpecific && (hashMap2 = this.cmap31) != null) {
            return (int[]) hashMap2.get(new Integer(i));
        }
        if (this.fontSpecific && (hashMap = this.cmap10) != null) {
            return (int[]) hashMap.get(new Integer(i));
        }
        HashMap hashMap4 = this.cmap31;
        if (hashMap4 != null) {
            return (int[]) hashMap4.get(new Integer(i));
        }
        HashMap hashMap5 = this.cmap10;
        if (hashMap5 != null) {
            return (int[]) hashMap5.get(new Integer(i));
        }
        return null;
    }

    public String getPostscriptFontName() {
        return this.fontName;
    }

    public String[] getCodePagesSupported() {
        long j = (((long) this.os_2.ulCodePageRange2) << 32) + (((long) this.os_2.ulCodePageRange1) & 4294967295L);
        long j2 = 1;
        long j3 = 1;
        int i = 0;
        for (int i2 = 0; i2 < 64; i2++) {
            if (!((j & j3) == 0 || codePages[i2] == null)) {
                i++;
            }
            j3 <<= 1;
        }
        String[] strArr = new String[i];
        int i3 = 0;
        for (int i4 = 0; i4 < 64; i4++) {
            if ((j & j2) != 0) {
                String[] strArr2 = codePages;
                if (strArr2[i4] != null) {
                    strArr[i3] = strArr2[i4];
                    i3++;
                }
            }
            j2 <<= 1;
        }
        return strArr;
    }

    public String[][] getFullFontName() {
        return this.fullName;
    }

    public String[][] getAllNameEntries() {
        return this.allNameEntries;
    }

    public String[][] getFamilyFontName() {
        return this.familyName;
    }

    public boolean hasKernPairs() {
        return this.kerning.size() > 0;
    }

    public void setPostscriptFontName(String str) {
        this.fontName = str;
    }

    public boolean setKerning(int i, int i2, int i3) {
        int[] metricsTT = getMetricsTT(i);
        if (metricsTT == null) {
            return false;
        }
        int i4 = metricsTT[0];
        int[] metricsTT2 = getMetricsTT(i2);
        if (metricsTT2 == null) {
            return false;
        }
        this.kerning.put((i4 << 16) + metricsTT2[0], i3);
        return true;
    }

    /* access modifiers changed from: protected */
    public int[] getRawCharBBox(int i, String str) {
        HashMap hashMap;
        int[] iArr;
        int[][] iArr2;
        if (str == null || (hashMap = this.cmap31) == null) {
            hashMap = this.cmap10;
        }
        if (hashMap == null || (iArr = (int[]) hashMap.get(new Integer(i))) == null || (iArr2 = this.bboxes) == null) {
            return null;
        }
        return iArr2[iArr[0]];
    }
}
