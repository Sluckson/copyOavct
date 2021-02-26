package com.lowagie.text.pdf;

public class PdfGState extends PdfDictionary {
    public static final PdfName BM_COLORBURN = new PdfName("ColorBurn");
    public static final PdfName BM_COLORDODGE = new PdfName("ColorDodge");
    public static final PdfName BM_COMPATIBLE = new PdfName("Compatible");
    public static final PdfName BM_DARKEN = new PdfName("Darken");
    public static final PdfName BM_DIFFERENCE = new PdfName("Difference");
    public static final PdfName BM_EXCLUSION = new PdfName("Exclusion");
    public static final PdfName BM_HARDLIGHT = new PdfName("HardLight");
    public static final PdfName BM_LIGHTEN = new PdfName("Lighten");
    public static final PdfName BM_MULTIPLY = new PdfName("Multiply");
    public static final PdfName BM_NORMAL = new PdfName("Normal");
    public static final PdfName BM_OVERLAY = new PdfName("Overlay");
    public static final PdfName BM_SCREEN = new PdfName("Screen");
    public static final PdfName BM_SOFTLIGHT = new PdfName("SoftLight");

    public void setOverPrintStroking(boolean z) {
        put(PdfName.f706OP, z ? PdfBoolean.PDFTRUE : PdfBoolean.PDFFALSE);
    }

    public void setOverPrintNonStroking(boolean z) {
        put(PdfName.f747op, z ? PdfBoolean.PDFTRUE : PdfBoolean.PDFFALSE);
    }

    public void setOverPrintMode(int i) {
        put(PdfName.OPM, new PdfNumber(i == 0 ? 0 : 1));
    }

    public void setStrokeOpacity(float f) {
        put(PdfName.f655CA, new PdfNumber(f));
    }

    public void setFillOpacity(float f) {
        put(PdfName.f746ca, new PdfNumber(f));
    }

    public void setAlphaIsShape(boolean z) {
        put(PdfName.AIS, z ? PdfBoolean.PDFTRUE : PdfBoolean.PDFFALSE);
    }

    public void setTextKnockout(boolean z) {
        put(PdfName.f728TK, z ? PdfBoolean.PDFTRUE : PdfBoolean.PDFFALSE);
    }

    public void setBlendMode(PdfName pdfName) {
        put(PdfName.f650BM, pdfName);
    }
}
