package com.lowagie.text.pdf;

import androidx.exifinterface.media.ExifInterface;
import com.google.common.base.Ascii;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.lowagie.text.ElementTags;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.html.HtmlTags;
import kotlin.text.Typography;
import p052cz.msebera.android.httpclient.cookie.ClientCookie;

public class CFFFont {
    static final String[] operatorNames = {ClientCookie.VERSION_ATTR, "Notice", "FullName", "FamilyName", "Weight", "FontBBox", "BlueValues", "OtherBlues", "FamilyBlues", "FamilyOtherBlues", "StdHW", "StdVW", "UNKNOWN_12", "UniqueID", "XUID", "charset", "Encoding", "CharStrings", "Private", "Subrs", "defaultWidthX", "nominalWidthX", "UNKNOWN_22", "UNKNOWN_23", "UNKNOWN_24", "UNKNOWN_25", "UNKNOWN_26", "UNKNOWN_27", "UNKNOWN_28", "UNKNOWN_29", "UNKNOWN_30", "UNKNOWN_31", ExifInterface.TAG_COPYRIGHT, "isFixedPitch", "ItalicAngle", "UnderlinePosition", "UnderlineThickness", "PaintType", "CharstringType", "FontMatrix", "StrokeWidth", "BlueScale", "BlueShift", "BlueFuzz", "StemSnapH", "StemSnapV", "ForceBold", "UNKNOWN_12_15", "UNKNOWN_12_16", "LanguageGroup", "ExpansionFactor", "initialRandomSeed", "SyntheticBase", "PostScript", "BaseFontName", "BaseFontBlend", "UNKNOWN_12_24", "UNKNOWN_12_25", "UNKNOWN_12_26", "UNKNOWN_12_27", "UNKNOWN_12_28", "UNKNOWN_12_29", "ROS", "CIDFontVersion", "CIDFontRevision", "CIDFontType", "CIDCount", "UIDBase", "FDArray", "FDSelect", "FontName"};
    static final String[] standardStrings = {BaseFont.notdef, "space", "exclam", "quotedbl", "numbersign", "dollar", "percent", "ampersand", "quoteright", "parenleft", "parenright", "asterisk", "plus", "comma", "hyphen", "period", "slash", "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "colon", "semicolon", "less", "equal", "greater", "question", "at", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, ExifInterface.GPS_DIRECTION_TRUE, "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, "X", "Y", "Z", "bracketleft", "backslash", "bracketright", "asciicircum", "underscore", "quoteleft", HtmlTags.ANCHOR, HtmlTags.f603B, "c", "d", "e", "f", "g", "h", HtmlTags.f606I, "j", "k", "l", "m", "n", "o", "p", "q", "r", HtmlTags.f607S, "t", HtmlTags.f608U, "v", "w", "x", "y", "z", "braceleft", "bar", "braceright", "asciitilde", "exclamdown", "cent", "sterling", "fraction", "yen", "florin", ElementTags.SECTION, FirebaseAnalytics.Param.CURRENCY, "quotesingle", "quotedblleft", "guillemotleft", "guilsinglleft", "guilsinglright", "fi", "fl", "endash", "dagger", "daggerdbl", "periodcentered", ElementTags.PARAGRAPH, "bullet", "quotesinglbase", "quotedblbase", "quotedblright", "guillemotright", "ellipsis", "perthousand", "questiondown", "grave", "acute", "circumflex", "tilde", "macron", "breve", "dotaccent", "dieresis", "ring", "cedilla", "hungarumlaut", "ogonek", "caron", "emdash", "AE", "ordfeminine", "Lslash", "Oslash", "OE", "ordmasculine", "ae", "dotlessi", "lslash", "oslash", "oe", "germandbls", "onesuperior", "logicalnot", "mu", "trademark", "Eth", "onehalf", "plusminus", "Thorn", "onequarter", "divide", "brokenbar", "degree", "thorn", "threequarters", "twosuperior", "registered", "minus", "eth", "multiply", "threesuperior", "copyright", "Aacute", "Acircumflex", "Adieresis", "Agrave", "Aring", "Atilde", "Ccedilla", "Eacute", "Ecircumflex", "Edieresis", "Egrave", "Iacute", "Icircumflex", "Idieresis", "Igrave", "Ntilde", "Oacute", "Ocircumflex", "Odieresis", "Ograve", "Otilde", "Scaron", "Uacute", "Ucircumflex", "Udieresis", "Ugrave", "Yacute", "Ydieresis", "Zcaron", "aacute", "acircumflex", "adieresis", "agrave", "aring", "atilde", "ccedilla", "eacute", "ecircumflex", "edieresis", "egrave", "iacute", "icircumflex", "idieresis", "igrave", "ntilde", "oacute", "ocircumflex", "odieresis", "ograve", "otilde", "scaron", "uacute", "ucircumflex", "udieresis", "ugrave", "yacute", "ydieresis", "zcaron", "exclamsmall", "Hungarumlautsmall", "dollaroldstyle", "dollarsuperior", "ampersandsmall", "Acutesmall", "parenleftsuperior", "parenrightsuperior", "twodotenleader", "onedotenleader", "zerooldstyle", "oneoldstyle", "twooldstyle", "threeoldstyle", "fouroldstyle", "fiveoldstyle", "sixoldstyle", "sevenoldstyle", "eightoldstyle", "nineoldstyle", "commasuperior", "threequartersemdash", "periodsuperior", "questionsmall", "asuperior", "bsuperior", "centsuperior", "dsuperior", "esuperior", "isuperior", "lsuperior", "msuperior", "nsuperior", "osuperior", "rsuperior", "ssuperior", "tsuperior", "ff", "ffi", "ffl", "parenleftinferior", "parenrightinferior", "Circumflexsmall", "hyphensuperior", "Gravesmall", "Asmall", "Bsmall", "Csmall", "Dsmall", "Esmall", "Fsmall", "Gsmall", "Hsmall", "Ismall", "Jsmall", "Ksmall", "Lsmall", "Msmall", "Nsmall", "Osmall", "Psmall", "Qsmall", "Rsmall", "Ssmall", "Tsmall", "Usmall", "Vsmall", "Wsmall", "Xsmall", "Ysmall", "Zsmall", "colonmonetary", "onefitted", "rupiah", "Tildesmall", "exclamdownsmall", "centoldstyle", "Lslashsmall", "Scaronsmall", "Zcaronsmall", "Dieresissmall", "Brevesmall", "Caronsmall", "Dotaccentsmall", "Macronsmall", "figuredash", "hypheninferior", "Ogoneksmall", "Ringsmall", "Cedillasmall", "questiondownsmall", "oneeighth", "threeeighths", "fiveeighths", "seveneighths", "onethird", "twothirds", "zerosuperior", "foursuperior", "fivesuperior", "sixsuperior", "sevensuperior", "eightsuperior", "ninesuperior", "zeroinferior", "oneinferior", "twoinferior", "threeinferior", "fourinferior", "fiveinferior", "sixinferior", "seveninferior", "eightinferior", "nineinferior", "centinferior", "dollarinferior", "periodinferior", "commainferior", "Agravesmall", "Aacutesmall", "Acircumflexsmall", "Atildesmall", "Adieresissmall", "Aringsmall", "AEsmall", "Ccedillasmall", "Egravesmall", "Eacutesmall", "Ecircumflexsmall", "Edieresissmall", "Igravesmall", "Iacutesmall", "Icircumflexsmall", "Idieresissmall", "Ethsmall", "Ntildesmall", "Ogravesmall", "Oacutesmall", "Ocircumflexsmall", "Otildesmall", "Odieresissmall", "OEsmall", "Oslashsmall", "Ugravesmall", "Uacutesmall", "Ucircumflexsmall", "Udieresissmall", "Yacutesmall", "Thornsmall", "Ydieresissmall", "001.000", "001.001", "001.002", "001.003", "Black", "Bold", "Book", "Light", "Medium", "Regular", "Roman", "Semibold"};
    protected int arg_count = 0;
    protected Object[] args = new Object[48];
    protected RandomAccessFileOrArray buf;
    protected Font[] fonts;
    protected int gsubrIndexOffset;
    protected int[] gsubrOffsets;
    protected String key;
    protected int nameIndexOffset;
    protected int[] nameOffsets;
    int nextIndexOffset;
    private int offSize;
    protected int stringIndexOffset;
    protected int[] stringOffsets;
    protected int topdictIndexOffset;
    protected int[] topdictOffsets;

    protected static final class IndexBaseItem extends Item {
    }

    public String getString(char c) {
        String[] strArr = standardStrings;
        if (c < strArr.length) {
            return strArr[c];
        }
        if (c >= strArr.length + (this.stringOffsets.length - 1)) {
            return null;
        }
        int length = c - strArr.length;
        int position = getPosition();
        seek(this.stringOffsets[length]);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = this.stringOffsets[length]; i < this.stringOffsets[length + 1]; i++) {
            stringBuffer.append(getCard8());
        }
        seek(position);
        return stringBuffer.toString();
    }

    /* access modifiers changed from: package-private */
    public char getCard8() {
        try {
            return (char) (this.buf.readByte() & 255);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* access modifiers changed from: package-private */
    public char getCard16() {
        try {
            return this.buf.readChar();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* access modifiers changed from: package-private */
    public int getOffset(int i) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 * 256) + getCard8();
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public void seek(int i) {
        try {
            this.buf.seek(i);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* access modifiers changed from: package-private */
    public short getShort() {
        try {
            return this.buf.readShort();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* access modifiers changed from: package-private */
    public int getInt() {
        try {
            return this.buf.readInt();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* access modifiers changed from: package-private */
    public int getPosition() {
        try {
            return this.buf.getFilePointer();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* access modifiers changed from: package-private */
    public int[] getIndex(int i) {
        seek(i);
        char card16 = getCard16();
        int i2 = card16 + 1;
        int[] iArr = new int[i2];
        if (card16 == 0) {
            iArr[0] = -1;
            return iArr;
        }
        char card8 = getCard8();
        for (int i3 = 0; i3 <= card16; i3++) {
            iArr[i3] = ((((i + 2) + 1) + (i2 * card8)) - 1) + getOffset(card8);
        }
        return iArr;
    }

    /* access modifiers changed from: protected */
    public void getDictItem() {
        for (int i = 0; i < this.arg_count; i++) {
            this.args[i] = null;
        }
        this.arg_count = 0;
        this.key = null;
        boolean z = false;
        while (!z) {
            char card8 = getCard8();
            if (card8 == 29) {
                this.args[this.arg_count] = new Integer(getInt());
                this.arg_count++;
            } else if (card8 == 28) {
                this.args[this.arg_count] = new Integer(getShort());
                this.arg_count++;
            } else if (card8 >= ' ' && card8 <= 246) {
                this.args[this.arg_count] = new Integer((byte) (card8 - 139));
                this.arg_count++;
            } else if (card8 >= 247 && card8 <= 250) {
                this.args[this.arg_count] = new Integer((short) (((card8 - 247) * 256) + getCard8() + 108));
                this.arg_count++;
            } else if (card8 >= 251 && card8 <= 254) {
                this.args[this.arg_count] = new Integer((short) ((((-(card8 - 251)) * 256) - getCard8()) - 108));
                this.arg_count++;
            } else if (card8 == 30) {
                String str = "";
                boolean z2 = false;
                byte b = 0;
                char c = 0;
                int i2 = 0;
                while (!z2) {
                    if (b == 0) {
                        c = getCard8();
                        b = 2;
                    }
                    if (b == 1) {
                        i2 = c / 16;
                        b = (byte) (b - 1);
                    }
                    if (b == 2) {
                        i2 = c % 16;
                        b = (byte) (b - 1);
                    }
                    switch (i2) {
                        case 10:
                            str = String.valueOf(str) + ".";
                            break;
                        case 11:
                            str = String.valueOf(str) + ExifInterface.LONGITUDE_EAST;
                            break;
                        case 12:
                            str = String.valueOf(str) + "E-";
                            break;
                        case 14:
                            str = String.valueOf(str) + "-";
                            break;
                        case 15:
                            z2 = true;
                            break;
                        default:
                            if (i2 >= 0 && i2 <= 9) {
                                str = String.valueOf(str) + String.valueOf(i2);
                                break;
                            } else {
                                str = String.valueOf(str) + "<NIBBLE ERROR: " + i2 + Typography.greater;
                                z2 = true;
                                break;
                            }
                            break;
                    }
                }
                Object[] objArr = this.args;
                int i3 = this.arg_count;
                objArr[i3] = str;
                this.arg_count = i3 + 1;
            } else if (card8 <= 21) {
                if (card8 != 12) {
                    this.key = operatorNames[card8];
                } else {
                    this.key = operatorNames[getCard8() + ' '];
                }
                z = true;
            }
        }
    }

    protected static abstract class Item {
        protected int myOffset = -1;

        public void emit(byte[] bArr) {
        }

        public void xref() {
        }

        protected Item() {
        }

        public void increment(int[] iArr) {
            this.myOffset = iArr[0];
        }
    }

    protected static abstract class OffsetItem extends Item {
        public int value;

        protected OffsetItem() {
        }

        public void set(int i) {
            this.value = i;
        }
    }

    protected static final class RangeItem extends Item {
        private RandomAccessFileOrArray buf;
        public int length;
        public int offset;

        public RangeItem(RandomAccessFileOrArray randomAccessFileOrArray, int i, int i2) {
            this.offset = i;
            this.length = i2;
            this.buf = randomAccessFileOrArray;
        }

        public void increment(int[] iArr) {
            super.increment(iArr);
            iArr[0] = iArr[0] + this.length;
        }

        public void emit(byte[] bArr) {
            try {
                this.buf.seek(this.offset);
                for (int i = this.myOffset; i < this.myOffset + this.length; i++) {
                    bArr[i] = this.buf.readByte();
                }
            } catch (Exception e) {
                throw new ExceptionConverter(e);
            }
        }
    }

    protected static final class IndexOffsetItem extends OffsetItem {
        public final int size;

        public IndexOffsetItem(int i, int i2) {
            this.size = i;
            this.value = i2;
        }

        public IndexOffsetItem(int i) {
            this.size = i;
        }

        public void increment(int[] iArr) {
            super.increment(iArr);
            iArr[0] = iArr[0] + this.size;
        }

        public void emit(byte[] bArr) {
            int i;
            int i2;
            int i3;
            int i4 = this.size;
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        i3 = 0;
                    } else if (i4 == 4) {
                        bArr[this.myOffset + 0] = (byte) ((this.value >>> 24) & 255);
                        i3 = 1;
                    } else {
                        return;
                    }
                    bArr[this.myOffset + i3] = (byte) ((this.value >>> 16) & 255);
                    i2 = i3 + 1;
                } else {
                    i2 = 0;
                }
                bArr[this.myOffset + i2] = (byte) ((this.value >>> 8) & 255);
                i = i2 + 1;
            } else {
                i = 0;
            }
            bArr[this.myOffset + i] = (byte) ((this.value >>> 0) & 255);
        }
    }

    protected static final class IndexMarkerItem extends Item {
        private IndexBaseItem indexBase;
        private OffsetItem offItem;

        public IndexMarkerItem(OffsetItem offsetItem, IndexBaseItem indexBaseItem) {
            this.offItem = offsetItem;
            this.indexBase = indexBaseItem;
        }

        public void xref() {
            this.offItem.set((this.myOffset - this.indexBase.myOffset) + 1);
        }
    }

    protected static final class SubrMarkerItem extends Item {
        private IndexBaseItem indexBase;
        private OffsetItem offItem;

        public SubrMarkerItem(OffsetItem offsetItem, IndexBaseItem indexBaseItem) {
            this.offItem = offsetItem;
            this.indexBase = indexBaseItem;
        }

        public void xref() {
            this.offItem.set(this.myOffset - this.indexBase.myOffset);
        }
    }

    protected static final class DictOffsetItem extends OffsetItem {
        public final int size = 5;

        public void increment(int[] iArr) {
            super.increment(iArr);
            iArr[0] = iArr[0] + this.size;
        }

        public void emit(byte[] bArr) {
            if (this.size == 5) {
                bArr[this.myOffset] = Ascii.f267GS;
                bArr[this.myOffset + 1] = (byte) ((this.value >>> 24) & 255);
                bArr[this.myOffset + 2] = (byte) ((this.value >>> 16) & 255);
                bArr[this.myOffset + 3] = (byte) ((this.value >>> 8) & 255);
                bArr[this.myOffset + 4] = (byte) ((this.value >>> 0) & 255);
            }
        }
    }

    protected static final class UInt24Item extends Item {
        public int value;

        public UInt24Item(int i) {
            this.value = i;
        }

        public void increment(int[] iArr) {
            super.increment(iArr);
            iArr[0] = iArr[0] + 3;
        }

        public void emit(byte[] bArr) {
            bArr[this.myOffset + 0] = (byte) ((this.value >>> 16) & 255);
            bArr[this.myOffset + 1] = (byte) ((this.value >>> 8) & 255);
            bArr[this.myOffset + 2] = (byte) ((this.value >>> 0) & 255);
        }
    }

    protected static final class UInt32Item extends Item {
        public int value;

        public UInt32Item(int i) {
            this.value = i;
        }

        public void increment(int[] iArr) {
            super.increment(iArr);
            iArr[0] = iArr[0] + 4;
        }

        public void emit(byte[] bArr) {
            bArr[this.myOffset + 0] = (byte) ((this.value >>> 24) & 255);
            bArr[this.myOffset + 1] = (byte) ((this.value >>> 16) & 255);
            bArr[this.myOffset + 2] = (byte) ((this.value >>> 8) & 255);
            bArr[this.myOffset + 3] = (byte) ((this.value >>> 0) & 255);
        }
    }

    protected static final class UInt16Item extends Item {
        public char value;

        public UInt16Item(char c) {
            this.value = c;
        }

        public void increment(int[] iArr) {
            super.increment(iArr);
            iArr[0] = iArr[0] + 2;
        }

        public void emit(byte[] bArr) {
            bArr[this.myOffset + 0] = (byte) ((this.value >>> 8) & 255);
            bArr[this.myOffset + 1] = (byte) ((this.value >>> 0) & 255);
        }
    }

    protected static final class UInt8Item extends Item {
        public char value;

        public UInt8Item(char c) {
            this.value = c;
        }

        public void increment(int[] iArr) {
            super.increment(iArr);
            iArr[0] = iArr[0] + 1;
        }

        public void emit(byte[] bArr) {
            bArr[this.myOffset + 0] = (byte) ((this.value >>> 0) & 255);
        }
    }

    protected static final class StringItem extends Item {

        /* renamed from: s */
        public String f633s;

        public StringItem(String str) {
            this.f633s = str;
        }

        public void increment(int[] iArr) {
            super.increment(iArr);
            iArr[0] = iArr[0] + this.f633s.length();
        }

        public void emit(byte[] bArr) {
            for (int i = 0; i < this.f633s.length(); i++) {
                bArr[this.myOffset + i] = (byte) (this.f633s.charAt(i) & 255);
            }
        }
    }

    protected static final class DictNumberItem extends Item {
        public int size = 5;
        public final int value;

        public DictNumberItem(int i) {
            this.value = i;
        }

        public void increment(int[] iArr) {
            super.increment(iArr);
            iArr[0] = iArr[0] + this.size;
        }

        public void emit(byte[] bArr) {
            if (this.size == 5) {
                bArr[this.myOffset] = Ascii.f267GS;
                bArr[this.myOffset + 1] = (byte) ((this.value >>> 24) & 255);
                bArr[this.myOffset + 2] = (byte) ((this.value >>> 16) & 255);
                bArr[this.myOffset + 3] = (byte) ((this.value >>> 8) & 255);
                bArr[this.myOffset + 4] = (byte) ((this.value >>> 0) & 255);
            }
        }
    }

    protected static final class MarkerItem extends Item {

        /* renamed from: p */
        OffsetItem f632p;

        public MarkerItem(OffsetItem offsetItem) {
            this.f632p = offsetItem;
        }

        public void xref() {
            this.f632p.set(this.myOffset);
        }
    }

    /* access modifiers changed from: protected */
    public RangeItem getEntireIndexRange(int i) {
        seek(i);
        char card16 = getCard16();
        if (card16 == 0) {
            return new RangeItem(this.buf, i, 2);
        }
        char card8 = getCard8();
        seek(i + 2 + 1 + (card16 * card8));
        return new RangeItem(this.buf, i, ((card16 + 1) * card8) + 3 + (getOffset(card8) - 1));
    }

    /* JADX WARNING: type inference failed for: r7v10 */
    /* JADX WARNING: type inference failed for: r7v11 */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=?, for r7v2, types: [int, char] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public byte[] getCID(java.lang.String r22) {
        /*
            r21 = this;
            r0 = r21
            r1 = 0
            r2 = 0
        L_0x0004:
            com.lowagie.text.pdf.CFFFont$Font[] r3 = r0.fonts
            int r4 = r3.length
            if (r2 < r4) goto L_0x000a
            goto L_0x0016
        L_0x000a:
            r3 = r3[r2]
            java.lang.String r3 = r3.name
            r4 = r22
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L_0x03fa
        L_0x0016:
            com.lowagie.text.pdf.CFFFont$Font[] r3 = r0.fonts
            int r3 = r3.length
            if (r2 != r3) goto L_0x001d
            r1 = 0
            return r1
        L_0x001d:
            java.util.LinkedList r3 = new java.util.LinkedList
            r3.<init>()
            r0.seek(r1)
            r21.getCard8()
            r21.getCard8()
            char r4 = r21.getCard8()
            r21.getCard8()
            r0.nextIndexOffset = r4
            com.lowagie.text.pdf.CFFFont$RangeItem r5 = new com.lowagie.text.pdf.CFFFont$RangeItem
            com.lowagie.text.pdf.RandomAccessFileOrArray r6 = r0.buf
            r5.<init>(r6, r1, r4)
            r3.addLast(r5)
            com.lowagie.text.pdf.CFFFont$Font[] r4 = r0.fonts
            r4 = r4[r2]
            boolean r4 = r4.isCID
            r5 = -1
            if (r4 != 0) goto L_0x0062
            com.lowagie.text.pdf.CFFFont$Font[] r4 = r0.fonts
            r4 = r4[r2]
            int r4 = r4.charstringsOffset
            r0.seek(r4)
            char r5 = r21.getCard16()
            int r4 = r0.stringIndexOffset
            r0.seek(r4)
            char r4 = r21.getCard16()
            java.lang.String[] r6 = standardStrings
            int r6 = r6.length
            int r4 = r4 + r6
            goto L_0x0063
        L_0x0062:
            r4 = -1
        L_0x0063:
            com.lowagie.text.pdf.CFFFont$UInt16Item r6 = new com.lowagie.text.pdf.CFFFont$UInt16Item
            r7 = 1
            r6.<init>(r7)
            r3.addLast(r6)
            com.lowagie.text.pdf.CFFFont$UInt8Item r6 = new com.lowagie.text.pdf.CFFFont$UInt8Item
            r6.<init>(r7)
            r3.addLast(r6)
            com.lowagie.text.pdf.CFFFont$UInt8Item r6 = new com.lowagie.text.pdf.CFFFont$UInt8Item
            r6.<init>(r7)
            r3.addLast(r6)
            com.lowagie.text.pdf.CFFFont$UInt8Item r6 = new com.lowagie.text.pdf.CFFFont$UInt8Item
            com.lowagie.text.pdf.CFFFont$Font[] r8 = r0.fonts
            r8 = r8[r2]
            java.lang.String r8 = r8.name
            int r8 = r8.length()
            int r8 = r8 + r7
            char r8 = (char) r8
            r6.<init>(r8)
            r3.addLast(r6)
            com.lowagie.text.pdf.CFFFont$StringItem r6 = new com.lowagie.text.pdf.CFFFont$StringItem
            com.lowagie.text.pdf.CFFFont$Font[] r8 = r0.fonts
            r8 = r8[r2]
            java.lang.String r8 = r8.name
            r6.<init>(r8)
            r3.addLast(r6)
            com.lowagie.text.pdf.CFFFont$UInt16Item r6 = new com.lowagie.text.pdf.CFFFont$UInt16Item
            r6.<init>(r7)
            r3.addLast(r6)
            com.lowagie.text.pdf.CFFFont$UInt8Item r6 = new com.lowagie.text.pdf.CFFFont$UInt8Item
            r8 = 2
            r6.<init>(r8)
            r3.addLast(r6)
            com.lowagie.text.pdf.CFFFont$UInt16Item r6 = new com.lowagie.text.pdf.CFFFont$UInt16Item
            r6.<init>(r7)
            r3.addLast(r6)
            com.lowagie.text.pdf.CFFFont$IndexOffsetItem r6 = new com.lowagie.text.pdf.CFFFont$IndexOffsetItem
            r6.<init>(r8)
            r3.addLast(r6)
            com.lowagie.text.pdf.CFFFont$IndexBaseItem r9 = new com.lowagie.text.pdf.CFFFont$IndexBaseItem
            r9.<init>()
            r3.addLast(r9)
            com.lowagie.text.pdf.CFFFont$DictOffsetItem r10 = new com.lowagie.text.pdf.CFFFont$DictOffsetItem
            r10.<init>()
            com.lowagie.text.pdf.CFFFont$DictOffsetItem r11 = new com.lowagie.text.pdf.CFFFont$DictOffsetItem
            r11.<init>()
            com.lowagie.text.pdf.CFFFont$DictOffsetItem r12 = new com.lowagie.text.pdf.CFFFont$DictOffsetItem
            r12.<init>()
            com.lowagie.text.pdf.CFFFont$DictOffsetItem r13 = new com.lowagie.text.pdf.CFFFont$DictOffsetItem
            r13.<init>()
            com.lowagie.text.pdf.CFFFont$Font[] r14 = r0.fonts
            r14 = r14[r2]
            boolean r14 = r14.isCID
            r15 = 12
            if (r14 != 0) goto L_0x012a
            com.lowagie.text.pdf.CFFFont$DictNumberItem r14 = new com.lowagie.text.pdf.CFFFont$DictNumberItem
            r14.<init>(r4)
            r3.addLast(r14)
            com.lowagie.text.pdf.CFFFont$DictNumberItem r14 = new com.lowagie.text.pdf.CFFFont$DictNumberItem
            int r4 = r4 + r7
            r14.<init>(r4)
            r3.addLast(r14)
            com.lowagie.text.pdf.CFFFont$DictNumberItem r4 = new com.lowagie.text.pdf.CFFFont$DictNumberItem
            r4.<init>(r1)
            r3.addLast(r4)
            com.lowagie.text.pdf.CFFFont$UInt8Item r4 = new com.lowagie.text.pdf.CFFFont$UInt8Item
            r4.<init>(r15)
            r3.addLast(r4)
            com.lowagie.text.pdf.CFFFont$UInt8Item r4 = new com.lowagie.text.pdf.CFFFont$UInt8Item
            r14 = 30
            r4.<init>(r14)
            r3.addLast(r4)
            com.lowagie.text.pdf.CFFFont$DictNumberItem r4 = new com.lowagie.text.pdf.CFFFont$DictNumberItem
            r4.<init>(r5)
            r3.addLast(r4)
            com.lowagie.text.pdf.CFFFont$UInt8Item r4 = new com.lowagie.text.pdf.CFFFont$UInt8Item
            r4.<init>(r15)
            r3.addLast(r4)
            com.lowagie.text.pdf.CFFFont$UInt8Item r4 = new com.lowagie.text.pdf.CFFFont$UInt8Item
            r14 = 34
            r4.<init>(r14)
            r3.addLast(r4)
        L_0x012a:
            r3.addLast(r12)
            com.lowagie.text.pdf.CFFFont$UInt8Item r4 = new com.lowagie.text.pdf.CFFFont$UInt8Item
            r4.<init>(r15)
            r3.addLast(r4)
            com.lowagie.text.pdf.CFFFont$UInt8Item r4 = new com.lowagie.text.pdf.CFFFont$UInt8Item
            r14 = 36
            r4.<init>(r14)
            r3.addLast(r4)
            r3.addLast(r13)
            com.lowagie.text.pdf.CFFFont$UInt8Item r4 = new com.lowagie.text.pdf.CFFFont$UInt8Item
            r4.<init>(r15)
            r3.addLast(r4)
            com.lowagie.text.pdf.CFFFont$UInt8Item r4 = new com.lowagie.text.pdf.CFFFont$UInt8Item
            r14 = 37
            r4.<init>(r14)
            r3.addLast(r4)
            r3.addLast(r10)
            com.lowagie.text.pdf.CFFFont$UInt8Item r4 = new com.lowagie.text.pdf.CFFFont$UInt8Item
            r14 = 15
            r4.<init>(r14)
            r3.addLast(r4)
            r3.addLast(r11)
            com.lowagie.text.pdf.CFFFont$UInt8Item r4 = new com.lowagie.text.pdf.CFFFont$UInt8Item
            r14 = 17
            r4.<init>(r14)
            r3.addLast(r4)
            int[] r4 = r0.topdictOffsets
            r4 = r4[r2]
            r0.seek(r4)
        L_0x0175:
            int r4 = r21.getPosition()
            int[] r14 = r0.topdictOffsets
            int r15 = r2 + 1
            r14 = r14[r15]
            if (r4 < r14) goto L_0x03c1
            com.lowagie.text.pdf.CFFFont$IndexMarkerItem r4 = new com.lowagie.text.pdf.CFFFont$IndexMarkerItem
            r4.<init>(r6, r9)
            r3.addLast(r4)
            com.lowagie.text.pdf.CFFFont$Font[] r4 = r0.fonts
            r4 = r4[r2]
            boolean r4 = r4.isCID
            r14 = 3
            if (r4 == 0) goto L_0x019d
            int r4 = r0.stringIndexOffset
            com.lowagie.text.pdf.CFFFont$RangeItem r4 = r0.getEntireIndexRange(r4)
            r3.addLast(r4)
            goto L_0x025d
        L_0x019d:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            com.lowagie.text.pdf.CFFFont$Font[] r6 = r0.fonts
            r6 = r6[r2]
            java.lang.String r6 = r6.name
            java.lang.String r6 = java.lang.String.valueOf(r6)
            r4.<init>(r6)
            java.lang.String r6 = "-OneRange"
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            int r6 = r4.length()
            r9 = 127(0x7f, float:1.78E-43)
            if (r6 <= r9) goto L_0x01c1
            java.lang.String r4 = r4.substring(r1, r9)
        L_0x01c1:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r9 = "AdobeIdentity"
            r6.<init>(r9)
            r6.append(r4)
            java.lang.String r15 = r6.toString()
            int[] r6 = r0.stringOffsets
            int r9 = r6.length
            int r9 = r9 - r7
            r9 = r6[r9]
            r16 = r6[r1]
            int r9 = r9 - r16
            r6 = r6[r1]
            int r16 = r6 + -1
            int r6 = r15.length()
            int r6 = r6 + r9
            r8 = 255(0xff, float:3.57E-43)
            if (r6 > r8) goto L_0x01e8
            r8 = 1
            goto L_0x0202
        L_0x01e8:
            int r6 = r15.length()
            int r6 = r6 + r9
            r8 = 65535(0xffff, float:9.1834E-41)
            if (r6 > r8) goto L_0x01f4
            r8 = 2
            goto L_0x0202
        L_0x01f4:
            int r6 = r15.length()
            int r6 = r6 + r9
            r8 = 16777215(0xffffff, float:2.3509886E-38)
            if (r6 > r8) goto L_0x0200
            r8 = 3
            goto L_0x0202
        L_0x0200:
            r6 = 4
            r8 = 4
        L_0x0202:
            com.lowagie.text.pdf.CFFFont$UInt16Item r6 = new com.lowagie.text.pdf.CFFFont$UInt16Item
            int[] r1 = r0.stringOffsets
            int r1 = r1.length
            int r1 = r1 - r7
            int r1 = r1 + r14
            char r1 = (char) r1
            r6.<init>(r1)
            r3.addLast(r6)
            com.lowagie.text.pdf.CFFFont$UInt8Item r1 = new com.lowagie.text.pdf.CFFFont$UInt8Item
            char r6 = (char) r8
            r1.<init>(r6)
            r3.addLast(r1)
            r1 = 0
        L_0x021a:
            int[] r6 = r0.stringOffsets
            int r14 = r6.length
            if (r1 < r14) goto L_0x03ab
            int r1 = r6.length
            int r1 = r1 - r7
            r1 = r6[r1]
            int r1 = r1 - r16
            int r1 = r1 + 5
            com.lowagie.text.pdf.CFFFont$IndexOffsetItem r6 = new com.lowagie.text.pdf.CFFFont$IndexOffsetItem
            r6.<init>(r8, r1)
            r3.addLast(r6)
            int r1 = r1 + 8
            com.lowagie.text.pdf.CFFFont$IndexOffsetItem r6 = new com.lowagie.text.pdf.CFFFont$IndexOffsetItem
            r6.<init>(r8, r1)
            r3.addLast(r6)
            int r4 = r4.length()
            int r1 = r1 + r4
            com.lowagie.text.pdf.CFFFont$IndexOffsetItem r4 = new com.lowagie.text.pdf.CFFFont$IndexOffsetItem
            r4.<init>(r8, r1)
            r3.addLast(r4)
            com.lowagie.text.pdf.CFFFont$RangeItem r1 = new com.lowagie.text.pdf.CFFFont$RangeItem
            com.lowagie.text.pdf.RandomAccessFileOrArray r4 = r0.buf
            int[] r6 = r0.stringOffsets
            r8 = 0
            r6 = r6[r8]
            r1.<init>(r4, r6, r9)
            r3.addLast(r1)
            com.lowagie.text.pdf.CFFFont$StringItem r1 = new com.lowagie.text.pdf.CFFFont$StringItem
            r1.<init>(r15)
            r3.addLast(r1)
        L_0x025d:
            int r1 = r0.gsubrIndexOffset
            com.lowagie.text.pdf.CFFFont$RangeItem r1 = r0.getEntireIndexRange(r1)
            r3.addLast(r1)
            com.lowagie.text.pdf.CFFFont$Font[] r1 = r0.fonts
            r1 = r1[r2]
            boolean r1 = r1.isCID
            if (r1 != 0) goto L_0x034f
            com.lowagie.text.pdf.CFFFont$MarkerItem r1 = new com.lowagie.text.pdf.CFFFont$MarkerItem
            r1.<init>(r13)
            r3.addLast(r1)
            com.lowagie.text.pdf.CFFFont$UInt8Item r1 = new com.lowagie.text.pdf.CFFFont$UInt8Item
            r14 = 3
            r1.<init>(r14)
            r3.addLast(r1)
            com.lowagie.text.pdf.CFFFont$UInt16Item r1 = new com.lowagie.text.pdf.CFFFont$UInt16Item
            r1.<init>(r7)
            r3.addLast(r1)
            com.lowagie.text.pdf.CFFFont$UInt16Item r1 = new com.lowagie.text.pdf.CFFFont$UInt16Item
            r4 = 0
            r1.<init>(r4)
            r3.addLast(r1)
            com.lowagie.text.pdf.CFFFont$UInt8Item r1 = new com.lowagie.text.pdf.CFFFont$UInt8Item
            r1.<init>(r4)
            r3.addLast(r1)
            com.lowagie.text.pdf.CFFFont$UInt16Item r1 = new com.lowagie.text.pdf.CFFFont$UInt16Item
            char r4 = (char) r5
            r1.<init>(r4)
            r3.addLast(r1)
            com.lowagie.text.pdf.CFFFont$MarkerItem r1 = new com.lowagie.text.pdf.CFFFont$MarkerItem
            r1.<init>(r10)
            r3.addLast(r1)
            com.lowagie.text.pdf.CFFFont$UInt8Item r1 = new com.lowagie.text.pdf.CFFFont$UInt8Item
            r4 = 2
            r1.<init>(r4)
            r3.addLast(r1)
            com.lowagie.text.pdf.CFFFont$UInt16Item r1 = new com.lowagie.text.pdf.CFFFont$UInt16Item
            r1.<init>(r7)
            r3.addLast(r1)
            com.lowagie.text.pdf.CFFFont$UInt16Item r1 = new com.lowagie.text.pdf.CFFFont$UInt16Item
            int r5 = r5 - r7
            char r4 = (char) r5
            r1.<init>(r4)
            r3.addLast(r1)
            com.lowagie.text.pdf.CFFFont$MarkerItem r1 = new com.lowagie.text.pdf.CFFFont$MarkerItem
            r1.<init>(r12)
            r3.addLast(r1)
            com.lowagie.text.pdf.CFFFont$UInt16Item r1 = new com.lowagie.text.pdf.CFFFont$UInt16Item
            r1.<init>(r7)
            r3.addLast(r1)
            com.lowagie.text.pdf.CFFFont$UInt8Item r1 = new com.lowagie.text.pdf.CFFFont$UInt8Item
            r1.<init>(r7)
            r3.addLast(r1)
            com.lowagie.text.pdf.CFFFont$UInt8Item r1 = new com.lowagie.text.pdf.CFFFont$UInt8Item
            r1.<init>(r7)
            r3.addLast(r1)
            com.lowagie.text.pdf.CFFFont$IndexOffsetItem r1 = new com.lowagie.text.pdf.CFFFont$IndexOffsetItem
            r1.<init>(r7)
            r3.addLast(r1)
            com.lowagie.text.pdf.CFFFont$IndexBaseItem r4 = new com.lowagie.text.pdf.CFFFont$IndexBaseItem
            r4.<init>()
            r3.addLast(r4)
            com.lowagie.text.pdf.CFFFont$DictNumberItem r5 = new com.lowagie.text.pdf.CFFFont$DictNumberItem
            com.lowagie.text.pdf.CFFFont$Font[] r6 = r0.fonts
            r6 = r6[r2]
            int r6 = r6.privateLength
            r5.<init>(r6)
            r3.addLast(r5)
            com.lowagie.text.pdf.CFFFont$DictOffsetItem r5 = new com.lowagie.text.pdf.CFFFont$DictOffsetItem
            r5.<init>()
            r3.addLast(r5)
            com.lowagie.text.pdf.CFFFont$UInt8Item r6 = new com.lowagie.text.pdf.CFFFont$UInt8Item
            r8 = 18
            r6.<init>(r8)
            r3.addLast(r6)
            com.lowagie.text.pdf.CFFFont$IndexMarkerItem r6 = new com.lowagie.text.pdf.CFFFont$IndexMarkerItem
            r6.<init>(r1, r4)
            r3.addLast(r6)
            com.lowagie.text.pdf.CFFFont$MarkerItem r1 = new com.lowagie.text.pdf.CFFFont$MarkerItem
            r1.<init>(r5)
            r3.addLast(r1)
            com.lowagie.text.pdf.CFFFont$RangeItem r1 = new com.lowagie.text.pdf.CFFFont$RangeItem
            com.lowagie.text.pdf.RandomAccessFileOrArray r4 = r0.buf
            com.lowagie.text.pdf.CFFFont$Font[] r5 = r0.fonts
            r5 = r5[r2]
            int r5 = r5.privateOffset
            com.lowagie.text.pdf.CFFFont$Font[] r6 = r0.fonts
            r6 = r6[r2]
            int r6 = r6.privateLength
            r1.<init>(r4, r5, r6)
            r3.addLast(r1)
            com.lowagie.text.pdf.CFFFont$Font[] r1 = r0.fonts
            r1 = r1[r2]
            int r1 = r1.privateSubrs
            if (r1 < 0) goto L_0x034f
            com.lowagie.text.pdf.CFFFont$Font[] r1 = r0.fonts
            r1 = r1[r2]
            int r1 = r1.privateSubrs
            com.lowagie.text.pdf.CFFFont$RangeItem r1 = r0.getEntireIndexRange(r1)
            r3.addLast(r1)
        L_0x034f:
            com.lowagie.text.pdf.CFFFont$MarkerItem r1 = new com.lowagie.text.pdf.CFFFont$MarkerItem
            r1.<init>(r11)
            r3.addLast(r1)
            com.lowagie.text.pdf.CFFFont$Font[] r1 = r0.fonts
            r1 = r1[r2]
            int r1 = r1.charstringsOffset
            com.lowagie.text.pdf.CFFFont$RangeItem r1 = r0.getEntireIndexRange(r1)
            r3.addLast(r1)
            int[] r1 = new int[r7]
            r17 = 0
            r1[r17] = r17
            java.util.Iterator r18 = r3.iterator()
        L_0x036e:
            boolean r2 = r18.hasNext()
            if (r2 != 0) goto L_0x03a1
            java.util.Iterator r2 = r3.iterator()
        L_0x0378:
            boolean r4 = r2.hasNext()
            if (r4 != 0) goto L_0x0397
            r1 = r1[r17]
            byte[] r4 = new byte[r1]
            java.util.Iterator r5 = r3.iterator()
        L_0x0386:
            boolean r1 = r5.hasNext()
            if (r1 != 0) goto L_0x038d
            return r4
        L_0x038d:
            java.lang.Object r1 = r5.next()
            com.lowagie.text.pdf.CFFFont$Item r1 = (com.lowagie.text.pdf.CFFFont.Item) r1
            r1.emit(r4)
            goto L_0x0386
        L_0x0397:
            java.lang.Object r4 = r2.next()
            com.lowagie.text.pdf.CFFFont$Item r4 = (com.lowagie.text.pdf.CFFFont.Item) r4
            r4.xref()
            goto L_0x0378
        L_0x03a1:
            java.lang.Object r2 = r18.next()
            com.lowagie.text.pdf.CFFFont$Item r2 = (com.lowagie.text.pdf.CFFFont.Item) r2
            r2.increment(r1)
            goto L_0x036e
        L_0x03ab:
            r14 = 3
            r17 = 0
            r20 = 2
            com.lowagie.text.pdf.CFFFont$IndexOffsetItem r7 = new com.lowagie.text.pdf.CFFFont$IndexOffsetItem
            r6 = r6[r1]
            int r6 = r6 - r16
            r7.<init>(r8, r6)
            r3.addLast(r7)
            int r1 = r1 + 1
            r7 = 1
            goto L_0x021a
        L_0x03c1:
            r17 = 0
            r20 = 2
            int r1 = r21.getPosition()
            r21.getDictItem()
            int r4 = r21.getPosition()
            java.lang.String r7 = r0.key
            java.lang.String r8 = "Encoding"
            if (r7 == r8) goto L_0x03f5
            java.lang.String r8 = "Private"
            if (r7 == r8) goto L_0x03f5
            java.lang.String r8 = "FDSelect"
            if (r7 == r8) goto L_0x03f5
            java.lang.String r8 = "FDArray"
            if (r7 == r8) goto L_0x03f5
            java.lang.String r8 = "charset"
            if (r7 == r8) goto L_0x03f5
            java.lang.String r8 = "CharStrings"
            if (r7 == r8) goto L_0x03f5
            com.lowagie.text.pdf.CFFFont$RangeItem r7 = new com.lowagie.text.pdf.CFFFont$RangeItem
            com.lowagie.text.pdf.RandomAccessFileOrArray r8 = r0.buf
            int r4 = r4 - r1
            r7.<init>(r8, r1, r4)
            r3.add(r7)
        L_0x03f5:
            r1 = 0
            r7 = 1
            r8 = 2
            goto L_0x0175
        L_0x03fa:
            r17 = 0
            int r2 = r2 + 1
            r1 = 0
            goto L_0x0004
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.CFFFont.getCID(java.lang.String):byte[]");
    }

    public boolean isCID(String str) {
        int i = 0;
        while (true) {
            Font[] fontArr = this.fonts;
            if (i >= fontArr.length) {
                return false;
            }
            if (str.equals(fontArr[i].name)) {
                return this.fonts[i].isCID;
            }
            i++;
        }
    }

    public boolean exists(String str) {
        int i = 0;
        while (true) {
            Font[] fontArr = this.fonts;
            if (i >= fontArr.length) {
                return false;
            }
            if (str.equals(fontArr[i].name)) {
                return true;
            }
            i++;
        }
    }

    public String[] getNames() {
        String[] strArr = new String[this.fonts.length];
        int i = 0;
        while (true) {
            Font[] fontArr = this.fonts;
            if (i >= fontArr.length) {
                return strArr;
            }
            strArr[i] = fontArr[i].name;
            i++;
        }
    }

    protected final class Font {
        public int CharsetLength;
        public int CharstringType = 2;
        public int FDArrayCount;
        public int[] FDArrayOffsets;
        public int FDArrayOffsize;
        public int[] FDSelect;
        public int FDSelectFormat;
        public int FDSelectLength;
        public int[] PrivateSubrsOffset;
        public int[][] PrivateSubrsOffsetsArray;
        public int[] SubrsOffsets;
        public int[] charset;
        public int charsetOffset = -1;
        public int charstringsOffset = -1;
        public int[] charstringsOffsets;
        public int encodingOffset = -1;
        public int fdarrayOffset = -1;
        public int[] fdprivateLengths;
        public int[] fdprivateOffsets;
        public int[] fdprivateSubrs;
        public int fdselectOffset = -1;
        public String fullName;
        public boolean isCID = false;
        public String name;
        public int nglyphs;
        public int nstrings;
        public int privateLength = -1;
        public int privateOffset = -1;
        public int privateSubrs = -1;

        protected Font() {
        }
    }

    public CFFFont(RandomAccessFileOrArray randomAccessFileOrArray) {
        int i;
        int i2;
        int i3;
        this.buf = randomAccessFileOrArray;
        seek(0);
        getCard8();
        getCard8();
        char card8 = getCard8();
        this.offSize = getCard8();
        this.nameIndexOffset = card8;
        this.nameOffsets = getIndex(this.nameIndexOffset);
        int[] iArr = this.nameOffsets;
        this.topdictIndexOffset = iArr[iArr.length - 1];
        this.topdictOffsets = getIndex(this.topdictIndexOffset);
        int[] iArr2 = this.topdictOffsets;
        this.stringIndexOffset = iArr2[iArr2.length - 1];
        this.stringOffsets = getIndex(this.stringIndexOffset);
        int[] iArr3 = this.stringOffsets;
        this.gsubrIndexOffset = iArr3[iArr3.length - 1];
        this.gsubrOffsets = getIndex(this.gsubrIndexOffset);
        this.fonts = new Font[(this.nameOffsets.length - 1)];
        int i4 = 0;
        while (i4 < this.nameOffsets.length - 1) {
            this.fonts[i4] = new Font();
            seek(this.nameOffsets[i4]);
            this.fonts[i4].name = "";
            int i5 = this.nameOffsets[i4];
            while (true) {
                i3 = i4 + 1;
                if (i5 >= this.nameOffsets[i3]) {
                    break;
                }
                Font font = this.fonts[i4];
                font.name = String.valueOf(font.name) + getCard8();
                i5++;
            }
            i4 = i3;
        }
        int i6 = 0;
        while (true) {
            int[] iArr4 = this.topdictOffsets;
            if (i6 < iArr4.length - 1) {
                seek(iArr4[i6]);
                while (true) {
                    i = i6 + 1;
                    if (getPosition() >= this.topdictOffsets[i]) {
                        break;
                    }
                    getDictItem();
                    String str = this.key;
                    if (str == "FullName") {
                        this.fonts[i6].fullName = getString((char) ((Integer) this.args[0]).intValue());
                    } else if (str == "ROS") {
                        this.fonts[i6].isCID = true;
                    } else if (str == "Private") {
                        this.fonts[i6].privateLength = ((Integer) this.args[0]).intValue();
                        this.fonts[i6].privateOffset = ((Integer) this.args[1]).intValue();
                    } else if (str == "charset") {
                        this.fonts[i6].charsetOffset = ((Integer) this.args[0]).intValue();
                    } else if (str == "Encoding") {
                        this.fonts[i6].encodingOffset = ((Integer) this.args[0]).intValue();
                        ReadEncoding(this.fonts[i6].encodingOffset);
                    } else if (str == "CharStrings") {
                        this.fonts[i6].charstringsOffset = ((Integer) this.args[0]).intValue();
                        int position = getPosition();
                        Font[] fontArr = this.fonts;
                        fontArr[i6].charstringsOffsets = getIndex(fontArr[i6].charstringsOffset);
                        seek(position);
                    } else if (str == "FDArray") {
                        this.fonts[i6].fdarrayOffset = ((Integer) this.args[0]).intValue();
                    } else if (str == "FDSelect") {
                        this.fonts[i6].fdselectOffset = ((Integer) this.args[0]).intValue();
                    } else if (str == "CharstringType") {
                        this.fonts[i6].CharstringType = ((Integer) this.args[0]).intValue();
                    }
                }
                if (this.fonts[i6].privateOffset >= 0) {
                    seek(this.fonts[i6].privateOffset);
                    while (getPosition() < this.fonts[i6].privateOffset + this.fonts[i6].privateLength) {
                        getDictItem();
                        if (this.key == "Subrs") {
                            this.fonts[i6].privateSubrs = ((Integer) this.args[0]).intValue() + this.fonts[i6].privateOffset;
                        }
                    }
                }
                if (this.fonts[i6].fdarrayOffset >= 0) {
                    int[] index = getIndex(this.fonts[i6].fdarrayOffset);
                    Font[] fontArr2 = this.fonts;
                    fontArr2[i6].fdprivateOffsets = new int[(index.length - 1)];
                    fontArr2[i6].fdprivateLengths = new int[(index.length - 1)];
                    int i7 = 0;
                    while (i7 < index.length - 1) {
                        seek(index[i7]);
                        while (true) {
                            i2 = i7 + 1;
                            if (getPosition() >= index[i2]) {
                                break;
                            }
                            getDictItem();
                        }
                        if (this.key == "Private") {
                            this.fonts[i6].fdprivateLengths[i7] = ((Integer) this.args[0]).intValue();
                            this.fonts[i6].fdprivateOffsets[i7] = ((Integer) this.args[1]).intValue();
                        }
                        i7 = i2;
                    }
                }
                i6 = i;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void ReadEncoding(int i) {
        seek(i);
        getCard8();
    }
}
