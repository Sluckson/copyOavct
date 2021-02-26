package com.lowagie.text.pdf.parser;

public class SimpleTextExtractingPdfContentStreamProcessor extends PdfContentStreamProcessor {
    Matrix lastEndingTextMatrix = null;
    Matrix lastTextLineMatrix = null;
    StringBuffer result = null;

    public void reset() {
        super.reset();
        this.lastTextLineMatrix = null;
        this.lastEndingTextMatrix = null;
        this.result = new StringBuffer();
    }

    public String getResultantText() {
        return this.result.toString();
    }

    public void displayText(String str, Matrix matrix) {
        Matrix matrix2 = this.lastTextLineMatrix;
        boolean z = (matrix2 == null || matrix2.get(7) == getCurrentTextLineMatrix().get(7)) ? false : true;
        float f = getCurrentTextMatrix().get(6);
        if (z) {
            this.result.append(10);
        } else {
            Matrix matrix3 = this.lastEndingTextMatrix;
            if (matrix3 != null) {
                if (f - matrix3.get(6) > (new Matrix(((((((float) mo54701gs().font.getWidth(32)) / 1000.0f) * mo54701gs().fontSize) + mo54701gs().characterSpacing) + mo54701gs().wordSpacing) * mo54701gs().horizontalScaling, 0.0f).multiply(getCurrentTextMatrix()).get(6) - getCurrentTextMatrix().get(6)) / 2.0f) {
                    this.result.append(' ');
                }
            }
        }
        this.result.append(str);
        this.lastTextLineMatrix = getCurrentTextLineMatrix();
        this.lastEndingTextMatrix = matrix;
    }
}
