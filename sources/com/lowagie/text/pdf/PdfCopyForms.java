package com.lowagie.text.pdf;

import com.lowagie.text.DocWriter;
import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.interfaces.PdfEncryptionSettings;
import com.lowagie.text.pdf.interfaces.PdfViewerPreferences;
import java.io.IOException;
import java.io.OutputStream;
import java.security.cert.Certificate;
import java.util.List;

public class PdfCopyForms implements PdfViewerPreferences, PdfEncryptionSettings {

    /* renamed from: fc */
    private PdfCopyFormsImp f637fc;

    public PdfCopyForms(OutputStream outputStream) throws DocumentException {
        this.f637fc = new PdfCopyFormsImp(outputStream);
    }

    public void addDocument(PdfReader pdfReader) throws DocumentException, IOException {
        this.f637fc.addDocument(pdfReader);
    }

    public void addDocument(PdfReader pdfReader, List list) throws DocumentException, IOException {
        this.f637fc.addDocument(pdfReader, list);
    }

    public void addDocument(PdfReader pdfReader, String str) throws DocumentException, IOException {
        this.f637fc.addDocument(pdfReader, SequenceList.expand(str, pdfReader.getNumberOfPages()));
    }

    public void copyDocumentFields(PdfReader pdfReader) throws DocumentException {
        this.f637fc.copyDocumentFields(pdfReader);
    }

    public void setEncryption(byte[] bArr, byte[] bArr2, int i, boolean z) throws DocumentException {
        this.f637fc.setEncryption(bArr, bArr2, i, z ? 1 : 0);
    }

    public void setEncryption(boolean z, String str, String str2, int i) throws DocumentException {
        setEncryption(DocWriter.getISOBytes(str), DocWriter.getISOBytes(str2), i, z);
    }

    public void close() {
        this.f637fc.close();
    }

    public void open() {
        this.f637fc.openDoc();
    }

    public void addJavaScript(String str) {
        this.f637fc.addJavaScript(str, !PdfEncodings.isPdfDocEncoding(str));
    }

    public void setOutlines(List list) {
        this.f637fc.setOutlines(list);
    }

    public PdfWriter getWriter() {
        return this.f637fc;
    }

    public boolean isFullCompression() {
        return this.f637fc.isFullCompression();
    }

    public void setFullCompression() {
        this.f637fc.setFullCompression();
    }

    public void setEncryption(byte[] bArr, byte[] bArr2, int i, int i2) throws DocumentException {
        this.f637fc.setEncryption(bArr, bArr2, i, i2);
    }

    public void addViewerPreference(PdfName pdfName, PdfObject pdfObject) {
        this.f637fc.addViewerPreference(pdfName, pdfObject);
    }

    public void setViewerPreferences(int i) {
        this.f637fc.setViewerPreferences(i);
    }

    public void setEncryption(Certificate[] certificateArr, int[] iArr, int i) throws DocumentException {
        this.f637fc.setEncryption(certificateArr, iArr, i);
    }
}
