package com.lowagie.text.pdf;

import com.lowagie.text.pdf.fonts.cmaps.CMap;
import com.lowagie.text.pdf.fonts.cmaps.CMapParser;
import java.io.ByteArrayInputStream;
import java.io.IOException;

public class CMapAwareDocumentFont extends DocumentFont {
    private char[] cidbyte2uni;
    private PdfDictionary fontDic;
    private int spaceWidth;
    private CMap toUnicodeCmap;

    public CMapAwareDocumentFont(PRIndirectReference pRIndirectReference) {
        super(pRIndirectReference);
        this.fontDic = (PdfDictionary) PdfReader.getPdfObjectRelease((PdfObject) pRIndirectReference);
        processToUnicode();
        if (this.toUnicodeCmap == null) {
            processUni2Byte();
        }
        this.spaceWidth = super.getWidth(32);
        if (this.spaceWidth == 0) {
            this.spaceWidth = computeAverageWidth();
        }
    }

    private void processToUnicode() {
        PdfObject pdfObject = this.fontDic.get(PdfName.TOUNICODE);
        if (pdfObject != null) {
            try {
                this.toUnicodeCmap = new CMapParser().parse(new ByteArrayInputStream(PdfReader.getStreamBytes((PRStream) PdfReader.getPdfObjectRelease(pdfObject))));
            } catch (IOException e) {
                throw new Error("Unable to process ToUnicode map - " + e.getMessage(), e);
            }
        }
    }

    private void processUni2Byte() {
        IntHashtable uni2Byte = getUni2Byte();
        int[] orderedKeys = uni2Byte.toOrderedKeys();
        this.cidbyte2uni = new char[256];
        for (int i = 0; i < orderedKeys.length; i++) {
            int i2 = uni2Byte.get(orderedKeys[i]);
            char[] cArr = this.cidbyte2uni;
            if (cArr[i2] == 0) {
                cArr[i2] = (char) orderedKeys[i];
            }
        }
    }

    private int computeAverageWidth() {
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < this.widths.length; i3++) {
            if (this.widths[i3] != 0) {
                i2 += this.widths[i3];
                i++;
            }
        }
        if (i != 0) {
            return i2 / i;
        }
        return 0;
    }

    public int getWidth(int i) {
        if (i == 32) {
            return this.spaceWidth;
        }
        return super.getWidth(i);
    }

    private String decodeSingleCID(byte[] bArr, int i, int i2) {
        CMap cMap = this.toUnicodeCmap;
        if (cMap != null) {
            if (i + i2 <= bArr.length) {
                return cMap.lookup(bArr, i, i2);
            }
            throw new ArrayIndexOutOfBoundsException("Invalid index: " + i + i2);
        } else if (i2 == 1) {
            return new String(this.cidbyte2uni, bArr[i] & 255, 1);
        } else {
            throw new Error("Multi-byte glyphs not implemented yet");
        }
    }

    public String decode(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        int i3 = i;
        while (i3 < i + i2) {
            String decodeSingleCID = decodeSingleCID(bArr, i3, 1);
            if (decodeSingleCID == null) {
                decodeSingleCID = decodeSingleCID(bArr, i3, 2);
                i3++;
            }
            stringBuffer.append(decodeSingleCID);
            i3++;
        }
        return stringBuffer.toString();
    }

    public String encode(byte[] bArr, int i, int i2) {
        return decode(bArr, i, i2);
    }
}
