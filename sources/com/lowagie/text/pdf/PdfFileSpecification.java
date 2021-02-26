package com.lowagie.text.pdf;

import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.lowagie.text.pdf.collection.PdfCollectionItem;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class PdfFileSpecification extends PdfDictionary {
    protected PdfIndirectReference ref;
    protected PdfWriter writer;

    public PdfFileSpecification() {
        super(PdfName.FILESPEC);
    }

    public static PdfFileSpecification url(PdfWriter pdfWriter, String str) {
        PdfFileSpecification pdfFileSpecification = new PdfFileSpecification();
        pdfFileSpecification.writer = pdfWriter;
        pdfFileSpecification.put(PdfName.f677FS, PdfName.URL);
        pdfFileSpecification.put(PdfName.f673F, new PdfString(str));
        return pdfFileSpecification;
    }

    public static PdfFileSpecification fileEmbedded(PdfWriter pdfWriter, String str, String str2, byte[] bArr) throws IOException {
        return fileEmbedded(pdfWriter, str, str2, bArr, 9);
    }

    public static PdfFileSpecification fileEmbedded(PdfWriter pdfWriter, String str, String str2, byte[] bArr, int i) throws IOException {
        return fileEmbedded(pdfWriter, str, str2, bArr, (String) null, (PdfDictionary) null, i);
    }

    public static PdfFileSpecification fileEmbedded(PdfWriter pdfWriter, String str, String str2, byte[] bArr, boolean z) throws IOException {
        return fileEmbedded(pdfWriter, str, str2, bArr, (String) null, (PdfDictionary) null, z ? 9 : 0);
    }

    public static PdfFileSpecification fileEmbedded(PdfWriter pdfWriter, String str, String str2, byte[] bArr, boolean z, String str3, PdfDictionary pdfDictionary) throws IOException {
        return fileEmbedded(pdfWriter, str, str2, bArr, (String) null, (PdfDictionary) null, z ? 9 : 0);
    }

    public static PdfFileSpecification fileEmbedded(PdfWriter pdfWriter, String str, String str2, byte[] bArr, String str3, PdfDictionary pdfDictionary, int i) throws IOException {
        PdfEFStream pdfEFStream;
        PdfFileSpecification pdfFileSpecification = new PdfFileSpecification();
        pdfFileSpecification.writer = pdfWriter;
        pdfFileSpecification.put(PdfName.f673F, new PdfString(str2));
        pdfFileSpecification.setUnicodeFileName(str2, false);
        InputStream inputStream = null;
        try {
            PdfIndirectReference pdfIndirectReference = pdfWriter.getPdfIndirectReference();
            if (bArr == null) {
                if (new File(str).canRead()) {
                    inputStream = new FileInputStream(str);
                } else {
                    if (!str.startsWith("file:/") && !str.startsWith("http://") && !str.startsWith("https://")) {
                        if (!str.startsWith("jar:")) {
                            inputStream = BaseFont.getResourceStream(str);
                            if (inputStream == null) {
                                throw new IOException(String.valueOf(str) + " not found as file or resource.");
                            }
                        }
                    }
                    inputStream = FirebasePerfUrlConnection.openStream(new URL(str));
                }
                pdfEFStream = new PdfEFStream(inputStream, pdfWriter);
            } else {
                pdfEFStream = new PdfEFStream(bArr);
            }
            pdfEFStream.put(PdfName.TYPE, PdfName.EMBEDDEDFILE);
            pdfEFStream.flateCompress(i);
            pdfEFStream.put(PdfName.PARAMS, pdfIndirectReference);
            if (str3 != null) {
                pdfEFStream.put(PdfName.SUBTYPE, new PdfName(str3));
            }
            PdfIndirectReference indirectReference = pdfWriter.addToBody(pdfEFStream).getIndirectReference();
            if (bArr == null) {
                pdfEFStream.writeLength();
            }
            PdfDictionary pdfDictionary2 = new PdfDictionary();
            if (pdfDictionary != null) {
                pdfDictionary2.merge(pdfDictionary);
            }
            pdfDictionary2.put(PdfName.SIZE, new PdfNumber(pdfEFStream.getRawLength()));
            pdfWriter.addToBody((PdfObject) pdfDictionary2, pdfIndirectReference);
            PdfDictionary pdfDictionary3 = new PdfDictionary();
            pdfDictionary3.put(PdfName.f673F, indirectReference);
            pdfDictionary3.put(PdfName.f734UF, indirectReference);
            pdfFileSpecification.put(PdfName.f672EF, pdfDictionary3);
            return pdfFileSpecification;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Exception unused) {
                }
            }
        }
    }

    public static PdfFileSpecification fileExtern(PdfWriter pdfWriter, String str) {
        PdfFileSpecification pdfFileSpecification = new PdfFileSpecification();
        pdfFileSpecification.writer = pdfWriter;
        pdfFileSpecification.put(PdfName.f673F, new PdfString(str));
        pdfFileSpecification.setUnicodeFileName(str, false);
        return pdfFileSpecification;
    }

    public PdfIndirectReference getReference() throws IOException {
        PdfIndirectReference pdfIndirectReference = this.ref;
        if (pdfIndirectReference != null) {
            return pdfIndirectReference;
        }
        this.ref = this.writer.addToBody(this).getIndirectReference();
        return this.ref;
    }

    public void setMultiByteFileName(byte[] bArr) {
        put(PdfName.f673F, new PdfString(bArr).setHexWriting(true));
    }

    public void setUnicodeFileName(String str, boolean z) {
        put(PdfName.f734UF, new PdfString(str, z ? PdfObject.TEXT_UNICODE : PdfObject.TEXT_PDFDOCENCODING));
    }

    public void setVolatile(boolean z) {
        put(PdfName.f736V, new PdfBoolean(z));
    }

    public void addDescription(String str, boolean z) {
        put(PdfName.DESC, new PdfString(str, z ? PdfObject.TEXT_UNICODE : PdfObject.TEXT_PDFDOCENCODING));
    }

    public void addCollectionItem(PdfCollectionItem pdfCollectionItem) {
        put(PdfName.f658CI, pdfCollectionItem);
    }
}
