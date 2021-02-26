package com.lowagie.text.pdf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class PdfStructureTreeRoot extends PdfDictionary {
    private HashMap parentTree = new HashMap();
    private PdfIndirectReference reference;
    private PdfWriter writer;

    PdfStructureTreeRoot(PdfWriter pdfWriter) {
        super(PdfName.STRUCTTREEROOT);
        this.writer = pdfWriter;
        this.reference = pdfWriter.getPdfIndirectReference();
    }

    public void mapRole(PdfName pdfName, PdfName pdfName2) {
        PdfDictionary pdfDictionary = (PdfDictionary) get(PdfName.ROLEMAP);
        if (pdfDictionary == null) {
            pdfDictionary = new PdfDictionary();
            put(PdfName.ROLEMAP, pdfDictionary);
        }
        pdfDictionary.put(pdfName, pdfName2);
    }

    public PdfWriter getWriter() {
        return this.writer;
    }

    public PdfIndirectReference getReference() {
        return this.reference;
    }

    /* access modifiers changed from: package-private */
    public void setPageMark(int i, PdfIndirectReference pdfIndirectReference) {
        Integer num = new Integer(i);
        PdfArray pdfArray = (PdfArray) this.parentTree.get(num);
        if (pdfArray == null) {
            pdfArray = new PdfArray();
            this.parentTree.put(num, pdfArray);
        }
        pdfArray.add((PdfObject) pdfIndirectReference);
    }

    private void nodeProcess(PdfDictionary pdfDictionary, PdfIndirectReference pdfIndirectReference) throws IOException {
        PdfObject pdfObject = pdfDictionary.get(PdfName.f691K);
        if (pdfObject != null && pdfObject.isArray()) {
            PdfArray pdfArray = (PdfArray) pdfObject;
            if (!((PdfObject) pdfArray.getArrayList().get(0)).isNumber()) {
                ArrayList arrayList = pdfArray.getArrayList();
                for (int i = 0; i < arrayList.size(); i++) {
                    PdfStructureElement pdfStructureElement = (PdfStructureElement) arrayList.get(i);
                    arrayList.set(i, pdfStructureElement.getReference());
                    nodeProcess(pdfStructureElement, pdfStructureElement.getReference());
                }
            }
        }
        if (pdfIndirectReference != null) {
            this.writer.addToBody((PdfObject) pdfDictionary, pdfIndirectReference);
        }
    }

    /* access modifiers changed from: package-private */
    public void buildTree() throws IOException {
        HashMap hashMap = new HashMap();
        for (Integer num : this.parentTree.keySet()) {
            hashMap.put(num, this.writer.addToBody((PdfArray) this.parentTree.get(num)).getIndirectReference());
        }
        PdfDictionary writeTree = PdfNumberTree.writeTree(hashMap, this.writer);
        if (writeTree != null) {
            put(PdfName.PARENTTREE, this.writer.addToBody(writeTree).getIndirectReference());
        }
        nodeProcess(this, this.reference);
    }
}
