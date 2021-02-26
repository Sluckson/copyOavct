package com.lowagie.text.pdf;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import java.io.IOException;

public class PdfImportedPage extends PdfTemplate {
    int pageNumber;
    PdfReaderInstance readerInstance;

    public PdfImportedPage getFromReader() {
        return this;
    }

    PdfImportedPage(PdfReaderInstance pdfReaderInstance, PdfWriter pdfWriter, int i) {
        this.readerInstance = pdfReaderInstance;
        this.pageNumber = i;
        this.writer = pdfWriter;
        this.bBox = pdfReaderInstance.getReader().getPageSize(i);
        setMatrix(1.0f, 0.0f, 0.0f, 1.0f, -this.bBox.getLeft(), -this.bBox.getBottom());
        this.type = 2;
    }

    public int getPageNumber() {
        return this.pageNumber;
    }

    public void addImage(Image image, float f, float f2, float f3, float f4, float f5, float f6) throws DocumentException {
        throwError();
    }

    public void addTemplate(PdfTemplate pdfTemplate, float f, float f2, float f3, float f4, float f5, float f6) {
        throwError();
    }

    public PdfContentByte getDuplicate() {
        throwError();
        return null;
    }

    /* access modifiers changed from: package-private */
    public PdfStream getFormXObject(int i) throws IOException {
        return this.readerInstance.getFormXObject(this.pageNumber, i);
    }

    public void setColorFill(PdfSpotColor pdfSpotColor, float f) {
        throwError();
    }

    public void setColorStroke(PdfSpotColor pdfSpotColor, float f) {
        throwError();
    }

    /* access modifiers changed from: package-private */
    public PdfObject getResources() {
        return this.readerInstance.getResources(this.pageNumber);
    }

    public void setFontAndSize(BaseFont baseFont, float f) {
        throwError();
    }

    public void setGroup(PdfTransparencyGroup pdfTransparencyGroup) {
        throwError();
    }

    /* access modifiers changed from: package-private */
    public void throwError() {
        throw new RuntimeException("Content can not be added to a PdfImportedPage.");
    }

    /* access modifiers changed from: package-private */
    public PdfReaderInstance getPdfReaderInstance() {
        return this.readerInstance;
    }
}
