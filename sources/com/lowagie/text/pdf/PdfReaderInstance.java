package com.lowagie.text.pdf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

class PdfReaderInstance {
    static final PdfLiteral IDENTITYMATRIX = new PdfLiteral("[1 0 0 1 0 0]");
    static final PdfNumber ONE = new PdfNumber(1);
    RandomAccessFileOrArray file;
    HashMap importedPages = new HashMap();
    int[] myXref;
    ArrayList nextRound = new ArrayList();
    PdfReader reader;
    HashMap visited = new HashMap();
    PdfWriter writer;

    PdfReaderInstance(PdfReader pdfReader, PdfWriter pdfWriter) {
        this.reader = pdfReader;
        this.writer = pdfWriter;
        this.file = pdfReader.getSafeFile();
        this.myXref = new int[pdfReader.getXrefSize()];
    }

    /* access modifiers changed from: package-private */
    public PdfReader getReader() {
        return this.reader;
    }

    /* access modifiers changed from: package-private */
    public PdfImportedPage getImportedPage(int i) {
        if (!this.reader.isOpenedWithFullPermissions()) {
            throw new IllegalArgumentException("PdfReader not opened with owner password");
        } else if (i < 1 || i > this.reader.getNumberOfPages()) {
            throw new IllegalArgumentException("Invalid page number: " + i);
        } else {
            Integer num = new Integer(i);
            PdfImportedPage pdfImportedPage = (PdfImportedPage) this.importedPages.get(num);
            if (pdfImportedPage != null) {
                return pdfImportedPage;
            }
            PdfImportedPage pdfImportedPage2 = new PdfImportedPage(this, this.writer, i);
            this.importedPages.put(num, pdfImportedPage2);
            return pdfImportedPage2;
        }
    }

    /* access modifiers changed from: package-private */
    public int getNewObjectNumber(int i, int i2) {
        int[] iArr = this.myXref;
        if (iArr[i] == 0) {
            iArr[i] = this.writer.getIndirectReferenceNumber();
            this.nextRound.add(new Integer(i));
        }
        return this.myXref[i];
    }

    /* access modifiers changed from: package-private */
    public RandomAccessFileOrArray getReaderFile() {
        return this.file;
    }

    /* access modifiers changed from: package-private */
    public PdfObject getResources(int i) {
        return PdfReader.getPdfObjectRelease(this.reader.getPageNRelease(i).get(PdfName.RESOURCES));
    }

    /* access modifiers changed from: package-private */
    public PdfStream getFormXObject(int i, int i2) throws IOException {
        byte[] bArr;
        PdfDictionary pageNRelease = this.reader.getPageNRelease(i);
        PdfObject pdfObjectRelease = PdfReader.getPdfObjectRelease(pageNRelease.get(PdfName.CONTENTS));
        PdfDictionary pdfDictionary = new PdfDictionary();
        if (pdfObjectRelease == null) {
            bArr = new byte[0];
        } else if (pdfObjectRelease.isStream()) {
            pdfDictionary.putAll((PRStream) pdfObjectRelease);
            bArr = null;
        } else {
            bArr = this.reader.getPageContent(i, this.file);
        }
        pdfDictionary.put(PdfName.RESOURCES, PdfReader.getPdfObjectRelease(pageNRelease.get(PdfName.RESOURCES)));
        pdfDictionary.put(PdfName.TYPE, PdfName.XOBJECT);
        pdfDictionary.put(PdfName.SUBTYPE, PdfName.FORM);
        PdfImportedPage pdfImportedPage = (PdfImportedPage) this.importedPages.get(new Integer(i));
        pdfDictionary.put(PdfName.BBOX, new PdfRectangle(pdfImportedPage.getBoundingBox()));
        PdfArray matrix = pdfImportedPage.getMatrix();
        if (matrix == null) {
            pdfDictionary.put(PdfName.MATRIX, IDENTITYMATRIX);
        } else {
            pdfDictionary.put(PdfName.MATRIX, matrix);
        }
        pdfDictionary.put(PdfName.FORMTYPE, ONE);
        if (bArr == null) {
            return new PRStream((PRStream) pdfObjectRelease, pdfDictionary);
        }
        PRStream pRStream = new PRStream(this.reader, bArr, i2);
        pRStream.putAll(pdfDictionary);
        return pRStream;
    }

    /* access modifiers changed from: package-private */
    public void writeAllVisited() throws IOException {
        while (!this.nextRound.isEmpty()) {
            ArrayList arrayList = this.nextRound;
            this.nextRound = new ArrayList();
            for (int i = 0; i < arrayList.size(); i++) {
                Integer num = (Integer) arrayList.get(i);
                if (!this.visited.containsKey(num)) {
                    this.visited.put(num, (Object) null);
                    int intValue = num.intValue();
                    this.writer.addToBody(this.reader.getPdfObjectRelease(intValue), this.myXref[intValue]);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void writeAllPages() throws IOException {
        try {
            this.file.reOpen();
            for (PdfImportedPage pdfImportedPage : this.importedPages.values()) {
                this.writer.addToBody((PdfObject) pdfImportedPage.getFormXObject(this.writer.getCompressionLevel()), pdfImportedPage.getIndirectReference());
            }
            writeAllVisited();
        } finally {
            try {
                this.reader.close();
                this.file.close();
            } catch (Exception unused) {
            }
        }
    }
}
