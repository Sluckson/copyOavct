package com.lowagie.text.pdf;

public class PdfTransparencyGroup extends PdfDictionary {
    public PdfTransparencyGroup() {
        put(PdfName.f719S, PdfName.TRANSPARENCY);
    }

    public void setIsolated(boolean z) {
        if (z) {
            put(PdfName.f686I, PdfBoolean.PDFTRUE);
        } else {
            remove(PdfName.f686I);
        }
    }

    public void setKnockout(boolean z) {
        if (z) {
            put(PdfName.f691K, PdfBoolean.PDFTRUE);
        } else {
            remove(PdfName.f691K);
        }
    }
}
