package com.lowagie.text.pdf;

public class PdfSignature extends PdfDictionary {
    public PdfSignature(PdfName pdfName, PdfName pdfName2) {
        super(PdfName.SIG);
        put(PdfName.FILTER, pdfName);
        put(PdfName.SUBFILTER, pdfName2);
    }

    public void setByteRange(int[] iArr) {
        PdfArray pdfArray = new PdfArray();
        for (int pdfNumber : iArr) {
            pdfArray.add((PdfObject) new PdfNumber(pdfNumber));
        }
        put(PdfName.BYTERANGE, pdfArray);
    }

    public void setContents(byte[] bArr) {
        put(PdfName.CONTENTS, new PdfString(bArr).setHexWriting(true));
    }

    public void setCert(byte[] bArr) {
        put(PdfName.CERT, new PdfString(bArr));
    }

    public void setName(String str) {
        put(PdfName.NAME, new PdfString(str, PdfObject.TEXT_UNICODE));
    }

    public void setDate(PdfDate pdfDate) {
        put(PdfName.f694M, pdfDate);
    }

    public void setLocation(String str) {
        put(PdfName.LOCATION, new PdfString(str, PdfObject.TEXT_UNICODE));
    }

    public void setReason(String str) {
        put(PdfName.REASON, new PdfString(str, PdfObject.TEXT_UNICODE));
    }

    public void setContact(String str) {
        put(PdfName.CONTACTINFO, new PdfString(str, PdfObject.TEXT_UNICODE));
    }
}
