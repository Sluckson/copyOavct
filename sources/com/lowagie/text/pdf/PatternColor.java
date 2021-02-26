package com.lowagie.text.pdf;

public class PatternColor extends ExtendedColor {
    private static final long serialVersionUID = -1185448552860615964L;
    PdfPatternPainter painter;

    public boolean equals(Object obj) {
        return this == obj;
    }

    public PatternColor(PdfPatternPainter pdfPatternPainter) {
        super(4, 0.5f, 0.5f, 0.5f);
        this.painter = pdfPatternPainter;
    }

    public PdfPatternPainter getPainter() {
        return this.painter;
    }

    public int hashCode() {
        return this.painter.hashCode();
    }
}
