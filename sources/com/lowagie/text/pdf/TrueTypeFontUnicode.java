package com.lowagie.text.pdf;

import androidx.core.view.InputDeviceCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.common.primitives.SignedBytes;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Utilities;
import com.lowagie.text.pdf.BaseFont;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

class TrueTypeFontUnicode extends TrueTypeFont implements Comparator {
    private static final byte[] rotbits = {Byte.MIN_VALUE, SignedBytes.MAX_POWER_OF_TWO, 32, 16, 8, 4, 2, 1};
    boolean vertical = false;

    /* access modifiers changed from: package-private */
    public byte[] convertToBytes(int i) {
        return null;
    }

    /* access modifiers changed from: package-private */
    public byte[] convertToBytes(String str) {
        return null;
    }

    TrueTypeFontUnicode(String str, String str2, boolean z, byte[] bArr, boolean z2) throws DocumentException, IOException {
        String baseName = getBaseName(str);
        String tTCName = getTTCName(baseName);
        if (baseName.length() < str.length()) {
            this.style = str.substring(baseName.length());
        }
        this.encoding = str2;
        this.embedded = z;
        this.fileName = tTCName;
        this.ttcIndex = "";
        if (tTCName.length() < baseName.length()) {
            this.ttcIndex = baseName.substring(tTCName.length() + 1);
        }
        this.fontType = 3;
        if ((this.fileName.toLowerCase().endsWith(".ttf") || this.fileName.toLowerCase().endsWith(".otf") || this.fileName.toLowerCase().endsWith(".ttc")) && ((str2.equals(BaseFont.IDENTITY_H) || str2.equals(BaseFont.IDENTITY_V)) && z)) {
            process(bArr, z2);
            if (this.os_2.fsType != 2) {
                if ((this.cmap31 == null && !this.fontSpecific) || (this.cmap10 == null && this.fontSpecific)) {
                    this.directTextToByte = true;
                }
                if (this.fontSpecific) {
                    this.fontSpecific = false;
                    String str3 = this.encoding;
                    this.encoding = "";
                    createEncoding();
                    this.encoding = str3;
                    this.fontSpecific = true;
                }
                this.vertical = str2.endsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
                return;
            }
            throw new DocumentException(String.valueOf(this.fileName) + this.style + " cannot be embedded due to licensing restrictions.");
        }
        throw new DocumentException(String.valueOf(this.fileName) + MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR + this.style + " is not a TTF font file.");
    }

    public int getWidth(int i) {
        if (this.vertical) {
            return 1000;
        }
        if (!this.fontSpecific) {
            return getRawWidth(i, this.encoding);
        }
        int i2 = 65280 & i;
        if (i2 == 0 || i2 == 61440) {
            return getRawWidth(i & 255, (String) null);
        }
        return 0;
    }

    public int getWidth(String str) {
        if (this.vertical) {
            return str.length() * 1000;
        }
        int i = 0;
        if (this.fontSpecific) {
            char[] charArray = str.toCharArray();
            int length = charArray.length;
            int i2 = 0;
            while (i < length) {
                char c = charArray[i];
                char c2 = 65280 & c;
                if (c2 == 0 || c2 == 61440) {
                    i2 += getRawWidth(c & 255, (String) null);
                }
                i++;
            }
            return i2;
        }
        int length2 = str.length();
        int i3 = 0;
        while (i < length2) {
            if (Utilities.isSurrogatePair(str, i)) {
                i3 += getRawWidth(Utilities.convertToUtf32(str, i), this.encoding);
                i++;
            } else {
                i3 += getRawWidth(str.charAt(i), this.encoding);
            }
            i++;
        }
        return i3;
    }

    private PdfStream getToUnicode(Object[] objArr) {
        if (objArr.length == 0) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer("/CIDInit /ProcSet findresource begin\n12 dict begin\nbegincmap\n/CIDSystemInfo\n<< /Registry (TTX+0)\n/Ordering (T42UV)\n/Supplement 0\n>> def\n/CMapName /TTX+0 def\n/CMapType 2 def\n1 begincodespacerange\n<0000><FFFF>\nendcodespacerange\n");
        int i = 0;
        for (int i2 = 0; i2 < objArr.length; i2++) {
            if (i == 0) {
                if (i2 != 0) {
                    stringBuffer.append("endbfrange\n");
                }
                i = Math.min(100, objArr.length - i2);
                stringBuffer.append(i);
                stringBuffer.append(" beginbfrange\n");
            }
            i--;
            int[] iArr = objArr[i2];
            String hex = toHex(iArr[0]);
            stringBuffer.append(hex);
            stringBuffer.append(hex);
            stringBuffer.append(toHex(iArr[2]));
            stringBuffer.append(10);
        }
        stringBuffer.append("endbfrange\nendcmap\nCMapName currentdict /CMap defineresource pop\nend end\n");
        PdfStream pdfStream = new PdfStream(PdfEncodings.convertToBytes(stringBuffer.toString(), (String) null));
        pdfStream.flateCompress(this.compressionLevel);
        return pdfStream;
    }

    private static String toHex4(int i) {
        String str = "0000" + Integer.toHexString(i);
        return str.substring(str.length() - 4);
    }

    static String toHex(int i) {
        if (i < 65536) {
            return "<" + toHex4(i) + ">";
        }
        int i2 = i - 65536;
        return "[<" + toHex4((i2 / 1024) + 55296) + toHex4((i2 % 1024) + 56320) + ">]";
    }

    private PdfDictionary getCIDFontType2(PdfIndirectReference pdfIndirectReference, String str, Object[] objArr) {
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.FONT);
        if (this.cff) {
            pdfDictionary.put(PdfName.SUBTYPE, PdfName.CIDFONTTYPE0);
            pdfDictionary.put(PdfName.BASEFONT, new PdfName(String.valueOf(str) + this.fontName + "-" + this.encoding));
        } else {
            pdfDictionary.put(PdfName.SUBTYPE, PdfName.CIDFONTTYPE2);
            pdfDictionary.put(PdfName.BASEFONT, new PdfName(String.valueOf(str) + this.fontName));
        }
        pdfDictionary.put(PdfName.FONTDESCRIPTOR, pdfIndirectReference);
        if (!this.cff) {
            pdfDictionary.put(PdfName.CIDTOGIDMAP, PdfName.IDENTITY);
        }
        PdfDictionary pdfDictionary2 = new PdfDictionary();
        pdfDictionary2.put(PdfName.REGISTRY, new PdfString("Adobe"));
        pdfDictionary2.put(PdfName.ORDERING, new PdfString("Identity"));
        pdfDictionary2.put(PdfName.SUPPLEMENT, new PdfNumber(0));
        pdfDictionary.put(PdfName.CIDSYSTEMINFO, pdfDictionary2);
        if (!this.vertical) {
            pdfDictionary.put(PdfName.f670DW, new PdfNumber(1000));
            StringBuffer stringBuffer = new StringBuffer("[");
            int i = -10;
            boolean z = true;
            for (int[] iArr : objArr) {
                if (iArr[1] != 1000) {
                    int i2 = iArr[0];
                    if (i2 == i + 1) {
                        stringBuffer.append(' ');
                        stringBuffer.append(iArr[1]);
                    } else {
                        if (!z) {
                            stringBuffer.append(']');
                        }
                        stringBuffer.append(i2);
                        stringBuffer.append('[');
                        stringBuffer.append(iArr[1]);
                        z = false;
                    }
                    i = i2;
                }
            }
            if (stringBuffer.length() > 1) {
                stringBuffer.append("]]");
                pdfDictionary.put(PdfName.f738W, new PdfLiteral(stringBuffer.toString()));
            }
        }
        return pdfDictionary;
    }

    private PdfDictionary getFontBaseType(PdfIndirectReference pdfIndirectReference, String str, PdfIndirectReference pdfIndirectReference2) {
        PdfDictionary pdfDictionary = new PdfDictionary(PdfName.FONT);
        pdfDictionary.put(PdfName.SUBTYPE, PdfName.TYPE0);
        if (this.cff) {
            PdfName pdfName = PdfName.BASEFONT;
            pdfDictionary.put(pdfName, new PdfName(String.valueOf(str) + this.fontName + "-" + this.encoding));
        } else {
            PdfName pdfName2 = PdfName.BASEFONT;
            pdfDictionary.put(pdfName2, new PdfName(String.valueOf(str) + this.fontName));
        }
        pdfDictionary.put(PdfName.ENCODING, new PdfName(this.encoding));
        pdfDictionary.put(PdfName.DESCENDANTFONTS, new PdfArray((PdfObject) pdfIndirectReference));
        if (pdfIndirectReference2 != null) {
            pdfDictionary.put(PdfName.TOUNICODE, pdfIndirectReference2);
        }
        return pdfDictionary;
    }

    public int compare(Object obj, Object obj2) {
        int i = ((int[]) obj)[0];
        int i2 = ((int[]) obj2)[0];
        if (i < i2) {
            return -1;
        }
        if (i == i2) {
            return 0;
        }
        return 1;
    }

    /* access modifiers changed from: package-private */
    public void writeFont(PdfWriter pdfWriter, PdfIndirectReference pdfIndirectReference, Object[] objArr) throws DocumentException, IOException {
        PdfIndirectReference pdfIndirectReference2;
        PdfIndirectReference pdfIndirectReference3;
        byte[] bArr;
        PdfStream pdfStream;
        HashMap hashMap = objArr[0];
        addRangeUni(hashMap, true, this.subset);
        Object[] array = hashMap.values().toArray();
        Arrays.sort(array, this);
        PdfIndirectReference pdfIndirectReference4 = null;
        if (pdfWriter.getPDFXConformance() == 3 || pdfWriter.getPDFXConformance() == 4) {
            if (array.length == 0) {
                pdfStream = new PdfStream(new byte[]{Byte.MIN_VALUE});
            } else {
                byte[] bArr2 = new byte[((((int[]) array[array.length - 1])[0] / 8) + 1)];
                for (Object obj : array) {
                    int i = ((int[]) obj)[0];
                    int i2 = i / 8;
                    bArr2[i2] = (byte) (rotbits[i % 8] | bArr2[i2]);
                }
                PdfStream pdfStream2 = new PdfStream(bArr2);
                pdfStream2.flateCompress(this.compressionLevel);
                pdfStream = pdfStream2;
            }
            pdfIndirectReference2 = pdfWriter.addToBody(pdfStream).getIndirectReference();
        } else {
            pdfIndirectReference2 = null;
        }
        if (this.cff) {
            byte[] readCffFont = readCffFont();
            if (this.subset || this.subsetRanges != null) {
                CFFFontSubset cFFFontSubset = new CFFFontSubset(new RandomAccessFileOrArray(readCffFont), hashMap);
                readCffFont = cFFFontSubset.Process(cFFFontSubset.getNames()[0]);
            }
            pdfIndirectReference3 = pdfWriter.addToBody(new BaseFont.StreamFont(readCffFont, "CIDFontType0C", this.compressionLevel)).getIndirectReference();
        } else {
            if (this.subset || this.directoryOffset != 0) {
                bArr = new TrueTypeFontSubSet(this.fileName, new RandomAccessFileOrArray(this.f765rf), hashMap, this.directoryOffset, false, false).process();
            } else {
                bArr = getFullFont();
            }
            pdfIndirectReference3 = pdfWriter.addToBody(new BaseFont.StreamFont(bArr, new int[]{bArr.length}, this.compressionLevel)).getIndirectReference();
        }
        String createSubsetPrefix = this.subset ? createSubsetPrefix() : "";
        PdfIndirectReference indirectReference = pdfWriter.addToBody(getCIDFontType2(pdfWriter.addToBody(getFontDescriptor(pdfIndirectReference3, createSubsetPrefix, pdfIndirectReference2)).getIndirectReference(), createSubsetPrefix, array)).getIndirectReference();
        PdfStream toUnicode = getToUnicode(array);
        if (toUnicode != null) {
            pdfIndirectReference4 = pdfWriter.addToBody(toUnicode).getIndirectReference();
        }
        pdfWriter.addToBody((PdfObject) getFontBaseType(indirectReference, createSubsetPrefix, pdfIndirectReference4), pdfIndirectReference);
    }

    public PdfStream getFullFontStream() throws IOException, DocumentException {
        if (this.cff) {
            return new BaseFont.StreamFont(readCffFont(), "CIDFontType0C", this.compressionLevel);
        }
        return super.getFullFontStream();
    }

    public int[] getMetricsTT(int i) {
        HashMap hashMap;
        if (this.cmapExt != null) {
            return (int[]) this.cmapExt.get(new Integer(i));
        }
        if (this.fontSpecific) {
            hashMap = this.cmap10;
        } else {
            hashMap = this.cmap31;
        }
        if (hashMap == null) {
            return null;
        }
        if (!this.fontSpecific) {
            return (int[]) hashMap.get(new Integer(i));
        }
        int i2 = i & InputDeviceCompat.SOURCE_ANY;
        if (i2 == 0 || i2 == 61440) {
            return (int[]) hashMap.get(new Integer(i & 255));
        }
        return null;
    }

    public boolean charExists(int i) {
        return getMetricsTT(i) != null;
    }

    public boolean setCharAdvance(int i, int i2) {
        int[] metricsTT = getMetricsTT(i);
        if (metricsTT == null) {
            return false;
        }
        metricsTT[1] = i2;
        return true;
    }

    public int[] getCharBBox(int i) {
        int[] metricsTT;
        if (this.bboxes == null || (metricsTT = getMetricsTT(i)) == null) {
            return null;
        }
        return this.bboxes[metricsTT[0]];
    }
}
