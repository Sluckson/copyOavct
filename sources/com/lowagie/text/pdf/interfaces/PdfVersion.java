package com.lowagie.text.pdf.interfaces;

import com.lowagie.text.pdf.PdfDeveloperExtension;
import com.lowagie.text.pdf.PdfName;

public interface PdfVersion {
    void addDeveloperExtension(PdfDeveloperExtension pdfDeveloperExtension);

    void setAtLeastPdfVersion(char c);

    void setPdfVersion(char c);

    void setPdfVersion(PdfName pdfName);
}
