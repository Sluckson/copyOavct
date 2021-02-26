package com.lowagie.text.pdf.parser;

import com.lowagie.text.pdf.PdfLiteral;
import java.util.ArrayList;

public interface ContentOperator {
    void invoke(PdfContentStreamProcessor pdfContentStreamProcessor, PdfLiteral pdfLiteral, ArrayList arrayList);
}
