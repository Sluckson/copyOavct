package com.lowagie.text.pdf;

public class PdfBorderDictionary extends PdfDictionary {
    public static final int STYLE_BEVELED = 2;
    public static final int STYLE_DASHED = 1;
    public static final int STYLE_INSET = 3;
    public static final int STYLE_SOLID = 0;
    public static final int STYLE_UNDERLINE = 4;

    public PdfBorderDictionary(float f, int i, PdfDashPattern pdfDashPattern) {
        put(PdfName.f738W, new PdfNumber(f));
        if (i == 0) {
            put(PdfName.f719S, PdfName.f719S);
        } else if (i == 1) {
            if (pdfDashPattern != null) {
                put(PdfName.f661D, pdfDashPattern);
            }
            put(PdfName.f719S, PdfName.f661D);
        } else if (i == 2) {
            put(PdfName.f719S, PdfName.f646B);
        } else if (i == 3) {
            put(PdfName.f719S, PdfName.f686I);
        } else if (i == 4) {
            put(PdfName.f719S, PdfName.f733U);
        } else {
            throw new IllegalArgumentException("Invalid border style.");
        }
    }

    public PdfBorderDictionary(float f, int i) {
        this(f, i, (PdfDashPattern) null);
    }
}
