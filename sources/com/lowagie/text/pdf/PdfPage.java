package com.lowagie.text.pdf;

import com.lowagie.text.pdf.codec.TIFFConstants;
import java.util.HashMap;

public class PdfPage extends PdfDictionary {
    public static final PdfNumber INVERTEDPORTRAIT = new PdfNumber(180);
    public static final PdfNumber LANDSCAPE = new PdfNumber(90);
    public static final PdfNumber PORTRAIT = new PdfNumber(0);
    public static final PdfNumber SEASCAPE = new PdfNumber((int) TIFFConstants.TIFFTAG_IMAGEDESCRIPTION);
    private static final PdfName[] boxNames = {PdfName.CROPBOX, PdfName.TRIMBOX, PdfName.ARTBOX, PdfName.BLEEDBOX};
    private static final String[] boxStrings = {"crop", "trim", "art", "bleed"};
    PdfRectangle mediaBox;

    public boolean isParent() {
        return false;
    }

    PdfPage(PdfRectangle pdfRectangle, HashMap hashMap, PdfDictionary pdfDictionary, int i) {
        super(PAGE);
        this.mediaBox = pdfRectangle;
        put(PdfName.MEDIABOX, pdfRectangle);
        put(PdfName.RESOURCES, pdfDictionary);
        if (i != 0) {
            put(PdfName.ROTATE, new PdfNumber(i));
        }
        int i2 = 0;
        while (true) {
            String[] strArr = boxStrings;
            if (i2 < strArr.length) {
                PdfObject pdfObject = (PdfObject) hashMap.get(strArr[i2]);
                if (pdfObject != null) {
                    put(boxNames[i2], pdfObject);
                }
                i2++;
            } else {
                return;
            }
        }
    }

    PdfPage(PdfRectangle pdfRectangle, HashMap hashMap, PdfDictionary pdfDictionary) {
        this(pdfRectangle, hashMap, pdfDictionary, 0);
    }

    /* access modifiers changed from: package-private */
    public void add(PdfIndirectReference pdfIndirectReference) {
        put(PdfName.CONTENTS, pdfIndirectReference);
    }

    /* access modifiers changed from: package-private */
    public PdfRectangle rotateMediaBox() {
        this.mediaBox = this.mediaBox.rotate();
        put(PdfName.MEDIABOX, this.mediaBox);
        return this.mediaBox;
    }

    /* access modifiers changed from: package-private */
    public PdfRectangle getMediaBox() {
        return this.mediaBox;
    }
}
