package com.lowagie.text.pdf;

public class PdfStructureElement extends PdfDictionary {
    private PdfStructureElement parent;
    private PdfIndirectReference reference;
    private PdfStructureTreeRoot top;

    public PdfStructureElement(PdfStructureElement pdfStructureElement, PdfName pdfName) {
        this.top = pdfStructureElement.top;
        init(pdfStructureElement, pdfName);
        this.parent = pdfStructureElement;
        put(PdfName.f707P, pdfStructureElement.reference);
    }

    public PdfStructureElement(PdfStructureTreeRoot pdfStructureTreeRoot, PdfName pdfName) {
        this.top = pdfStructureTreeRoot;
        init(pdfStructureTreeRoot, pdfName);
        put(PdfName.f707P, pdfStructureTreeRoot.getReference());
    }

    private void init(PdfDictionary pdfDictionary, PdfName pdfName) {
        PdfArray pdfArray;
        PdfObject pdfObject = pdfDictionary.get(PdfName.f691K);
        if (pdfObject == null || pdfObject.isArray()) {
            if (pdfObject == null) {
                pdfArray = new PdfArray();
                pdfDictionary.put(PdfName.f691K, pdfArray);
            } else {
                pdfArray = (PdfArray) pdfObject;
            }
            pdfArray.add((PdfObject) this);
            put(PdfName.f719S, pdfName);
            this.reference = this.top.getWriter().getPdfIndirectReference();
            return;
        }
        throw new IllegalArgumentException("The parent has already another function.");
    }

    public PdfDictionary getParent() {
        return this.parent;
    }

    /* access modifiers changed from: package-private */
    public void setPageMark(int i, int i2) {
        if (i2 >= 0) {
            put(PdfName.f691K, new PdfNumber(i2));
        }
        this.top.setPageMark(i, this.reference);
    }

    public PdfIndirectReference getReference() {
        return this.reference;
    }
}
