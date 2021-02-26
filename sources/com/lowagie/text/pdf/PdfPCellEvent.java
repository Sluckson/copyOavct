package com.lowagie.text.pdf;

import com.lowagie.text.Rectangle;

public interface PdfPCellEvent {
    void cellLayout(PdfPCell pdfPCell, Rectangle rectangle, PdfContentByte[] pdfContentByteArr);
}
