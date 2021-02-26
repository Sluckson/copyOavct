package com.lowagie.text.pdf;

import java.util.Collection;
import java.util.HashSet;

public class PdfLayerMembership extends PdfDictionary implements PdfOCG {
    public static final PdfName ALLOFF = new PdfName("AllOff");
    public static final PdfName ALLON = new PdfName("AllOn");
    public static final PdfName ANYOFF = new PdfName("AnyOff");
    public static final PdfName ANYON = new PdfName("AnyOn");
    HashSet layers = new HashSet();
    PdfArray members = new PdfArray();
    PdfIndirectReference ref;

    public PdfObject getPdfObject() {
        return this;
    }

    public PdfLayerMembership(PdfWriter pdfWriter) {
        super(PdfName.OCMD);
        put(PdfName.OCGS, this.members);
        this.ref = pdfWriter.getPdfIndirectReference();
    }

    public PdfIndirectReference getRef() {
        return this.ref;
    }

    public void addMember(PdfLayer pdfLayer) {
        if (!this.layers.contains(pdfLayer)) {
            this.members.add((PdfObject) pdfLayer.getRef());
            this.layers.add(pdfLayer);
        }
    }

    public Collection getLayers() {
        return this.layers;
    }

    public void setVisibilityPolicy(PdfName pdfName) {
        put(PdfName.f707P, pdfName);
    }
}
