package com.lowagie.text.pdf;

import java.io.IOException;

public class PdfRendition extends PdfDictionary {
    PdfRendition(String str, PdfFileSpecification pdfFileSpecification, String str2) throws IOException {
        put(PdfName.f719S, new PdfName("MR"));
        PdfName pdfName = PdfName.f696N;
        put(pdfName, new PdfString("Rendition for " + str));
        put(PdfName.f652C, new PdfMediaClipData(str, pdfFileSpecification, str2));
    }
}
