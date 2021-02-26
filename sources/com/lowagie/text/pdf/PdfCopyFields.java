package com.lowagie.text.pdf;

import com.lowagie.text.DocWriter;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.interfaces.PdfEncryptionSettings;
import com.lowagie.text.pdf.interfaces.PdfViewerPreferences;
import java.io.IOException;
import java.io.OutputStream;
import java.security.cert.Certificate;
import java.util.List;

public class PdfCopyFields implements PdfViewerPreferences, PdfEncryptionSettings {

    /* renamed from: fc */
    private PdfCopyFieldsImp f635fc;

    public PdfCopyFields(OutputStream outputStream) throws DocumentException {
        this.f635fc = new PdfCopyFieldsImp(outputStream);
    }

    public PdfCopyFields(OutputStream outputStream, char c) throws DocumentException {
        this.f635fc = new PdfCopyFieldsImp(outputStream, c);
    }

    public void addDocument(PdfReader pdfReader) throws DocumentException, IOException {
        this.f635fc.addDocument(pdfReader);
    }

    public void addDocument(PdfReader pdfReader, List list) throws DocumentException, IOException {
        this.f635fc.addDocument(pdfReader, list);
    }

    public void addDocument(PdfReader pdfReader, String str) throws DocumentException, IOException {
        this.f635fc.addDocument(pdfReader, SequenceList.expand(str, pdfReader.getNumberOfPages()));
    }

    public void setEncryption(byte[] bArr, byte[] bArr2, int i, boolean z) throws DocumentException {
        this.f635fc.setEncryption(bArr, bArr2, i, z ? 1 : 0);
    }

    public void setEncryption(boolean z, String str, String str2, int i) throws DocumentException {
        setEncryption(DocWriter.getISOBytes(str), DocWriter.getISOBytes(str2), i, z);
    }

    public void close() {
        this.f635fc.close();
    }

    public void open() {
        this.f635fc.openDoc();
    }

    public void addJavaScript(String str) {
        this.f635fc.addJavaScript(str, !PdfEncodings.isPdfDocEncoding(str));
    }

    public void setOutlines(List list) {
        this.f635fc.setOutlines(list);
    }

    public PdfWriter getWriter() {
        return this.f635fc;
    }

    public boolean isFullCompression() {
        return this.f635fc.isFullCompression();
    }

    public void setFullCompression() {
        this.f635fc.setFullCompression();
    }

    public void setEncryption(byte[] bArr, byte[] bArr2, int i, int i2) throws DocumentException {
        this.f635fc.setEncryption(bArr, bArr2, i, i2);
    }

    public void addViewerPreference(PdfName pdfName, PdfObject pdfObject) {
        this.f635fc.addViewerPreference(pdfName, pdfObject);
    }

    public void setViewerPreferences(int i) {
        this.f635fc.setViewerPreferences(i);
    }

    public void setEncryption(Certificate[] certificateArr, int[] iArr, int i) throws DocumentException {
        this.f635fc.setEncryption(certificateArr, iArr, i);
    }
}
