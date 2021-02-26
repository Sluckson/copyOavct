package com.lowagie.text.pdf.interfaces;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfAction;
import com.lowagie.text.pdf.PdfName;
import com.lowagie.text.pdf.PdfTransition;

public interface PdfPageActions {
    void setDuration(int i);

    void setPageAction(PdfName pdfName, PdfAction pdfAction) throws DocumentException;

    void setTransition(PdfTransition pdfTransition);
}
