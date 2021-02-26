package com.lowagie.text.pdf;

import android.os.Environment;
import com.lowagie.text.DocWriter;
import com.lowagie.text.DocumentException;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.collection.PdfCollection;
import com.lowagie.text.pdf.interfaces.PdfEncryptionSettings;
import com.lowagie.text.pdf.interfaces.PdfViewerPreferences;
import com.lowagie.text.xml.xmp.PdfSchema;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SignatureException;
import java.security.cert.Certificate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PdfStamper implements PdfViewerPreferences, PdfEncryptionSettings {
    private boolean hasSignature;
    private HashMap moreInfo;
    private PdfSignatureAppearance sigApp;
    protected PdfStamperImp stamper;

    public PdfStamper(PdfReader pdfReader, OutputStream outputStream) throws DocumentException, IOException {
        this.stamper = new PdfStamperImp(pdfReader, outputStream, 0, false);
    }

    public PdfStamper(PdfReader pdfReader, OutputStream outputStream, char c) throws DocumentException, IOException {
        this.stamper = new PdfStamperImp(pdfReader, outputStream, c, false);
    }

    public PdfStamper(PdfReader pdfReader, OutputStream outputStream, char c, boolean z) throws DocumentException, IOException {
        this.stamper = new PdfStamperImp(pdfReader, outputStream, c, z);
    }

    public HashMap getMoreInfo() {
        return this.moreInfo;
    }

    public void setMoreInfo(HashMap hashMap) {
        this.moreInfo = hashMap;
    }

    public void replacePage(PdfReader pdfReader, int i, int i2) {
        this.stamper.replacePage(pdfReader, i, i2);
    }

    public void insertPage(int i, Rectangle rectangle) {
        this.stamper.insertPage(i, rectangle);
    }

    public PdfSignatureAppearance getSignatureAppearance() {
        return this.sigApp;
    }

    public void close() throws DocumentException, IOException {
        if (!this.hasSignature) {
            this.stamper.close(this.moreInfo);
            return;
        }
        this.sigApp.preClose();
        PdfSigGenericPKCS sigStandard = this.sigApp.getSigStandard();
        int posLength = (((PdfLiteral) sigStandard.get(PdfName.CONTENTS)).getPosLength() - 2) / 2;
        byte[] bArr = new byte[8192];
        InputStream rangeStream = this.sigApp.getRangeStream();
        while (true) {
            try {
                int read = rangeStream.read(bArr);
                if (read <= 0) {
                    byte[] bArr2 = new byte[posLength];
                    byte[] signerContents = sigStandard.getSignerContents();
                    System.arraycopy(signerContents, 0, bArr2, 0, signerContents.length);
                    PdfString pdfString = new PdfString(bArr2);
                    pdfString.setHexWriting(true);
                    PdfDictionary pdfDictionary = new PdfDictionary();
                    pdfDictionary.put(PdfName.CONTENTS, pdfString);
                    this.sigApp.close(pdfDictionary);
                    this.stamper.reader.close();
                    return;
                }
                sigStandard.getSigner().update(bArr, 0, read);
            } catch (SignatureException e) {
                throw new ExceptionConverter(e);
            }
        }
    }

    public PdfContentByte getUnderContent(int i) {
        return this.stamper.getUnderContent(i);
    }

    public PdfContentByte getOverContent(int i) {
        return this.stamper.getOverContent(i);
    }

    public boolean isRotateContents() {
        return this.stamper.isRotateContents();
    }

    public void setRotateContents(boolean z) {
        this.stamper.setRotateContents(z);
    }

    public void setEncryption(byte[] bArr, byte[] bArr2, int i, boolean z) throws DocumentException {
        if (this.stamper.isAppend()) {
            throw new DocumentException("Append mode does not support changing the encryption status.");
        } else if (!this.stamper.isContentWritten()) {
            this.stamper.setEncryption(bArr, bArr2, i, z ? 1 : 0);
        } else {
            throw new DocumentException("Content was already written to the output.");
        }
    }

    public void setEncryption(byte[] bArr, byte[] bArr2, int i, int i2) throws DocumentException {
        if (this.stamper.isAppend()) {
            throw new DocumentException("Append mode does not support changing the encryption status.");
        } else if (!this.stamper.isContentWritten()) {
            this.stamper.setEncryption(bArr, bArr2, i, i2);
        } else {
            throw new DocumentException("Content was already written to the output.");
        }
    }

    public void setEncryption(boolean z, String str, String str2, int i) throws DocumentException {
        setEncryption(DocWriter.getISOBytes(str), DocWriter.getISOBytes(str2), i, z);
    }

    public void setEncryption(int i, String str, String str2, int i2) throws DocumentException {
        setEncryption(DocWriter.getISOBytes(str), DocWriter.getISOBytes(str2), i2, i);
    }

    public void setEncryption(Certificate[] certificateArr, int[] iArr, int i) throws DocumentException {
        if (this.stamper.isAppend()) {
            throw new DocumentException("Append mode does not support changing the encryption status.");
        } else if (!this.stamper.isContentWritten()) {
            this.stamper.setEncryption(certificateArr, iArr, i);
        } else {
            throw new DocumentException("Content was already written to the output.");
        }
    }

    public PdfImportedPage getImportedPage(PdfReader pdfReader, int i) {
        return this.stamper.getImportedPage(pdfReader, i);
    }

    public PdfWriter getWriter() {
        return this.stamper;
    }

    public PdfReader getReader() {
        return this.stamper.reader;
    }

    public AcroFields getAcroFields() {
        return this.stamper.getAcroFields();
    }

    public void setFormFlattening(boolean z) {
        this.stamper.setFormFlattening(z);
    }

    public void setFreeTextFlattening(boolean z) {
        this.stamper.setFreeTextFlattening(z);
    }

    public void addAnnotation(PdfAnnotation pdfAnnotation, int i) {
        this.stamper.addAnnotation(pdfAnnotation, i);
    }

    public PdfFormField addSignature(String str, int i, float f, float f2, float f3, float f4) {
        PdfAcroForm acroForm = this.stamper.getAcroForm();
        PdfFormField createSignature = PdfFormField.createSignature(this.stamper);
        PdfAcroForm pdfAcroForm = acroForm;
        PdfFormField pdfFormField = createSignature;
        pdfAcroForm.setSignatureParams(pdfFormField, str, f, f2, f3, f4);
        pdfAcroForm.drawSignatureAppearences(pdfFormField, f, f2, f3, f4);
        addAnnotation(createSignature, i);
        return createSignature;
    }

    public void addComments(FdfReader fdfReader) throws IOException {
        this.stamper.addComments(fdfReader);
    }

    public void setOutlines(List list) {
        this.stamper.setOutlines(list);
    }

    public void setThumbnail(Image image, int i) throws PdfException, DocumentException {
        this.stamper.setThumbnail(image, i);
    }

    public boolean partialFormFlattening(String str) {
        return this.stamper.partialFormFlattening(str);
    }

    public void addJavaScript(String str) {
        this.stamper.addJavaScript(str, !PdfEncodings.isPdfDocEncoding(str));
    }

    public void addFileAttachment(String str, byte[] bArr, String str2, String str3) throws IOException {
        addFileAttachment(str, PdfFileSpecification.fileEmbedded(this.stamper, str2, str3, bArr));
    }

    public void addFileAttachment(String str, PdfFileSpecification pdfFileSpecification) throws IOException {
        this.stamper.addFileAttachment(str, pdfFileSpecification);
    }

    public void makePackage(PdfName pdfName) {
        PdfCollection pdfCollection = new PdfCollection(0);
        pdfCollection.put(PdfName.VIEW, pdfName);
        this.stamper.makePackage(pdfCollection);
    }

    public void makePackage(PdfCollection pdfCollection) {
        this.stamper.makePackage(pdfCollection);
    }

    public void setViewerPreferences(int i) {
        this.stamper.setViewerPreferences(i);
    }

    public void addViewerPreference(PdfName pdfName, PdfObject pdfObject) {
        this.stamper.addViewerPreference(pdfName, pdfObject);
    }

    public void setXmpMetadata(byte[] bArr) {
        this.stamper.setXmpMetadata(bArr);
    }

    public boolean isFullCompression() {
        return this.stamper.isFullCompression();
    }

    public void setFullCompression() {
        if (!this.stamper.isAppend()) {
            this.stamper.setFullCompression();
        }
    }

    public void setPageAction(PdfName pdfName, PdfAction pdfAction, int i) throws PdfException {
        this.stamper.setPageAction(pdfName, pdfAction, i);
    }

    public void setDuration(int i, int i2) {
        this.stamper.setDuration(i, i2);
    }

    public void setTransition(PdfTransition pdfTransition, int i) {
        this.stamper.setTransition(pdfTransition, i);
    }

    public static PdfStamper createSignature(PdfReader pdfReader, OutputStream outputStream, char c, File file, boolean z) throws DocumentException, IOException {
        PdfStamper pdfStamper;
        if (file == null) {
            ByteBuffer byteBuffer = new ByteBuffer();
            pdfStamper = new PdfStamper(pdfReader, byteBuffer, c, z);
            pdfStamper.sigApp = new PdfSignatureAppearance(pdfStamper.stamper);
            pdfStamper.sigApp.setSigout(byteBuffer);
        } else {
            if (file.isDirectory()) {
                file = File.createTempFile(PdfSchema.DEFAULT_XPATH_ID, (String) null, file);
            }
            PdfStamper pdfStamper2 = new PdfStamper(pdfReader, new FileOutputStream(Environment.getExternalStorageDirectory() + File.separator + "droidtext" + File.separator + file), c, z);
            pdfStamper2.sigApp = new PdfSignatureAppearance(pdfStamper2.stamper);
            pdfStamper2.sigApp.setTempFile(file);
            pdfStamper = pdfStamper2;
        }
        pdfStamper.sigApp.setOriginalout(outputStream);
        pdfStamper.sigApp.setStamper(pdfStamper);
        pdfStamper.hasSignature = true;
        PdfDictionary catalog = pdfReader.getCatalog();
        PdfDictionary pdfDictionary = (PdfDictionary) PdfReader.getPdfObject(catalog.get(PdfName.ACROFORM), catalog);
        if (pdfDictionary != null) {
            pdfDictionary.remove(PdfName.NEEDAPPEARANCES);
            pdfStamper.stamper.markUsed((PdfObject) pdfDictionary);
        }
        return pdfStamper;
    }

    public static PdfStamper createSignature(PdfReader pdfReader, OutputStream outputStream, char c) throws DocumentException, IOException {
        return createSignature(pdfReader, outputStream, c, (File) null, false);
    }

    public static PdfStamper createSignature(PdfReader pdfReader, OutputStream outputStream, char c, File file) throws DocumentException, IOException {
        return createSignature(pdfReader, outputStream, c, file, false);
    }

    public Map getPdfLayers() {
        return this.stamper.getPdfLayers();
    }
}
