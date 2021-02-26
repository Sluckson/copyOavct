package com.lowagie.text.pdf.interfaces;

import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfObject;

public interface PdfViewerPreferences {
    void addViewerPreference(PdfName pdfName, PdfObject pdfObject);

    void setViewerPreferences(int i);
}
