package com.lowagie.text.pdf;

import harmony.java.awt.Color;

class PdfColor extends PdfArray {
    PdfColor(int i, int i2, int i3) {
        super((PdfObject) new PdfNumber(((double) (i & 255)) / 255.0d));
        add((PdfObject) new PdfNumber(((double) (i2 & 255)) / 255.0d));
        add((PdfObject) new PdfNumber(((double) (i3 & 255)) / 255.0d));
    }

    PdfColor(Color color) {
        this(color.getRed(), color.getGreen(), color.getBlue());
    }
}
