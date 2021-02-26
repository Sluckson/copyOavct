package com.lowagie.text.pdf.interfaces;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.PdfAction;
import com.lowagie.text.pdf.PdfName;

public interface PdfDocumentActions {
    void setAdditionalAction(PdfName pdfName, PdfAction pdfAction) throws DocumentException;

    void setOpenAction(PdfAction pdfAction);

    void setOpenAction(String str);
}
