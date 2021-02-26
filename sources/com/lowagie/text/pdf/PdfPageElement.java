package com.lowagie.text.pdf;

interface PdfPageElement {
    boolean isParent();

    void setParent(PdfIndirectReference pdfIndirectReference);
}
