package com.lowagie.text.pdf;

class ColorDetails {
    PdfName colorName;
    PdfIndirectReference indirectReference;
    PdfSpotColor spotcolor;

    ColorDetails(PdfName pdfName, PdfIndirectReference pdfIndirectReference, PdfSpotColor pdfSpotColor) {
        this.colorName = pdfName;
        this.indirectReference = pdfIndirectReference;
        this.spotcolor = pdfSpotColor;
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference getIndirectReference() {
        return this.indirectReference;
    }

    /* access modifiers changed from: package-private */
    public PdfName getColorName() {
        return this.colorName;
    }

    /* access modifiers changed from: package-private */
    public PdfObject getSpotColor(PdfWriter pdfWriter) {
        return this.spotcolor.getSpotObject(pdfWriter);
    }
}
