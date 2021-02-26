package com.lowagie.text.pdf.interfaces;

import com.lowagie.text.pdf.PdfAcroForm;
import com.lowagie.text.pdf.PdfAnnotation;
import com.lowagie.text.pdf.PdfFormField;

public interface PdfAnnotations {
    void addAnnotation(PdfAnnotation pdfAnnotation);

    void addCalculationOrder(PdfFormField pdfFormField);

    PdfAcroForm getAcroForm();

    void setSigFlags(int i);
}
