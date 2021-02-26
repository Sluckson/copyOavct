package com.lowagie.text.pdf;

import harmony.java.awt.Font;

public interface FontMapper {
    BaseFont awtToPdf(Font font);

    Font pdfToAwt(BaseFont baseFont, int i);
}
