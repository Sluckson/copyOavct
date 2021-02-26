package com.lowagie.text.pdf;

public interface TSAClient {
    byte[] getTimeStampToken(PdfPKCS7 pdfPKCS7, byte[] bArr) throws Exception;

    int getTokenSizeEstimate();
}
