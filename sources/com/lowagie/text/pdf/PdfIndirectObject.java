package com.lowagie.text.pdf;

import com.lowagie.text.DocWriter;
import java.io.IOException;
import java.io.OutputStream;

public class PdfIndirectObject {
    static final byte[] ENDOBJ = DocWriter.getISOBytes("\nendobj\n");
    static final int SIZEOBJ = (STARTOBJ.length + ENDOBJ.length);
    static final byte[] STARTOBJ = DocWriter.getISOBytes(" obj\n");
    protected int generation;
    protected int number;
    PdfObject object;
    PdfWriter writer;

    PdfIndirectObject(int i, PdfObject pdfObject, PdfWriter pdfWriter) {
        this(i, 0, pdfObject, pdfWriter);
    }

    PdfIndirectObject(PdfIndirectReference pdfIndirectReference, PdfObject pdfObject, PdfWriter pdfWriter) {
        this(pdfIndirectReference.getNumber(), pdfIndirectReference.getGeneration(), pdfObject, pdfWriter);
    }

    PdfIndirectObject(int i, int i2, PdfObject pdfObject, PdfWriter pdfWriter) {
        this.generation = 0;
        this.writer = pdfWriter;
        this.number = i;
        this.generation = i2;
        this.object = pdfObject;
        PdfEncryption encryption = pdfWriter != null ? pdfWriter.getEncryption() : null;
        if (encryption != null) {
            encryption.setHashKey(i, i2);
        }
    }

    public PdfIndirectReference getIndirectReference() {
        return new PdfIndirectReference(this.object.type(), this.number, this.generation);
    }

    /* access modifiers changed from: package-private */
    public void writeTo(OutputStream outputStream) throws IOException {
        outputStream.write(DocWriter.getISOBytes(String.valueOf(this.number)));
        outputStream.write(32);
        outputStream.write(DocWriter.getISOBytes(String.valueOf(this.generation)));
        outputStream.write(STARTOBJ);
        this.object.toPdf(this.writer, outputStream);
        outputStream.write(ENDOBJ);
    }
}
