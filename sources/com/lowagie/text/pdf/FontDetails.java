package com.lowagie.text.pdf;

import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Utilities;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

class FontDetails {
    BaseFont baseFont;
    CJKFont cjkFont;
    IntHashtable cjkTag;
    PdfName fontName;
    int fontType;
    PdfIndirectReference indirectReference;
    HashMap longTag;
    byte[] shortTag;
    protected boolean subset = true;
    boolean symbolic;
    TrueTypeFontUnicode ttu;

    FontDetails(PdfName pdfName, PdfIndirectReference pdfIndirectReference, BaseFont baseFont2) {
        this.fontName = pdfName;
        this.indirectReference = pdfIndirectReference;
        this.baseFont = baseFont2;
        this.fontType = baseFont2.getFontType();
        int i = this.fontType;
        if (i == 0 || i == 1) {
            this.shortTag = new byte[256];
        } else if (i == 2) {
            this.cjkTag = new IntHashtable();
            this.cjkFont = (CJKFont) baseFont2;
        } else if (i == 3) {
            this.longTag = new HashMap();
            this.ttu = (TrueTypeFontUnicode) baseFont2;
            this.symbolic = baseFont2.isFontSpecific();
        }
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference getIndirectReference() {
        return this.indirectReference;
    }

    /* access modifiers changed from: package-private */
    public PdfName getFontName() {
        return this.fontName;
    }

    /* access modifiers changed from: package-private */
    public BaseFont getBaseFont() {
        return this.baseFont;
    }

    /* access modifiers changed from: package-private */
    public byte[] convertToBytes(String str) {
        int i;
        int i2;
        int i3 = this.fontType;
        if (i3 == 0 || i3 == 1) {
            byte[] convertToBytes = this.baseFont.convertToBytes(str);
            for (byte b : convertToBytes) {
                this.shortTag[b & 255] = 1;
            }
            return convertToBytes;
        } else if (i3 == 2) {
            int length = str.length();
            for (int i4 = 0; i4 < length; i4++) {
                this.cjkTag.put(this.cjkFont.getCidCode(str.charAt(i4)), 0);
            }
            return this.baseFont.convertToBytes(str);
        } else if (i3 == 3) {
            try {
                int length2 = str.length();
                char[] cArr = new char[length2];
                if (this.symbolic) {
                    byte[] convertToBytes2 = PdfEncodings.convertToBytes(str, "symboltt");
                    int length3 = convertToBytes2.length;
                    i = 0;
                    for (int i5 = 0; i5 < length3; i5++) {
                        int[] metricsTT = this.ttu.getMetricsTT(convertToBytes2[i5] & 255);
                        if (metricsTT != null) {
                            this.longTag.put(new Integer(metricsTT[0]), new int[]{metricsTT[0], metricsTT[1], this.ttu.getUnicodeDifferences(convertToBytes2[i5] & 255)});
                            cArr[i] = (char) metricsTT[0];
                            i++;
                        }
                    }
                } else {
                    int i6 = 0;
                    i = 0;
                    while (i6 < length2) {
                        if (Utilities.isSurrogatePair(str, i6)) {
                            i2 = Utilities.convertToUtf32(str, i6);
                            i6++;
                        } else {
                            i2 = str.charAt(i6);
                        }
                        int[] metricsTT2 = this.ttu.getMetricsTT(i2);
                        if (metricsTT2 != null) {
                            int i7 = metricsTT2[0];
                            Integer num = new Integer(i7);
                            if (!this.longTag.containsKey(num)) {
                                this.longTag.put(num, new int[]{i7, metricsTT2[1], i2});
                            }
                            int i8 = i + 1;
                            cArr[i] = (char) i7;
                            i = i8;
                        }
                        i6++;
                    }
                }
                return new String(cArr, 0, i).getBytes("UnicodeBigUnmarked");
            } catch (UnsupportedEncodingException e) {
                throw new ExceptionConverter(e);
            }
        } else if (i3 == 4) {
            return this.baseFont.convertToBytes(str);
        } else {
            if (i3 != 5) {
                return null;
            }
            return this.baseFont.convertToBytes(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void writeFont(PdfWriter pdfWriter) {
        try {
            int i = this.fontType;
            if (i == 0 || i == 1) {
                int i2 = 0;
                while (true) {
                    if (i2 >= 256) {
                        break;
                    } else if (this.shortTag[i2] != 0) {
                        break;
                    } else {
                        i2++;
                    }
                }
                int i3 = 255;
                int i4 = 255;
                while (true) {
                    if (i4 < i2) {
                        break;
                    } else if (this.shortTag[i4] != 0) {
                        break;
                    } else {
                        i4--;
                    }
                }
                if (i2 > 255) {
                    i2 = 255;
                } else {
                    i3 = i4;
                }
                this.baseFont.writeFont(pdfWriter, this.indirectReference, new Object[]{new Integer(i2), new Integer(i3), this.shortTag, Boolean.valueOf(this.subset)});
            } else if (i == 2) {
                this.baseFont.writeFont(pdfWriter, this.indirectReference, new Object[]{this.cjkTag});
            } else if (i == 3) {
                this.baseFont.writeFont(pdfWriter, this.indirectReference, new Object[]{this.longTag, Boolean.valueOf(this.subset)});
            } else if (i == 5) {
                this.baseFont.writeFont(pdfWriter, this.indirectReference, (Object[]) null);
            }
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean isSubset() {
        return this.subset;
    }

    public void setSubset(boolean z) {
        this.subset = z;
    }
}
