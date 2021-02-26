package com.lowagie.text.pdf.draw;

import com.lowagie.text.pdf.PdfContentByte;
import harmony.java.awt.Color;

public class LineSeparator extends VerticalPositionMark {
    protected int alignment = 1;
    protected Color lineColor;
    protected float lineWidth = 1.0f;
    protected float percentage = 100.0f;

    public LineSeparator(float f, float f2, Color color, int i, float f3) {
        this.lineWidth = f;
        this.percentage = f2;
        this.lineColor = color;
        this.alignment = i;
        this.offset = f3;
    }

    public LineSeparator() {
    }

    public void draw(PdfContentByte pdfContentByte, float f, float f2, float f3, float f4, float f5) {
        pdfContentByte.saveState();
        drawLine(pdfContentByte, f, f3, f5);
        pdfContentByte.restoreState();
    }

    public void drawLine(PdfContentByte pdfContentByte, float f, float f2, float f3) {
        float f4;
        float f5 = 0.0f;
        if (getPercentage() < 0.0f) {
            f4 = -getPercentage();
        } else {
            f4 = ((f2 - f) * getPercentage()) / 100.0f;
        }
        int alignment2 = getAlignment();
        if (alignment2 != 0) {
            f5 = alignment2 != 2 ? ((f2 - f) - f4) / 2.0f : (f2 - f) - f4;
        }
        pdfContentByte.setLineWidth(getLineWidth());
        if (getLineColor() != null) {
            pdfContentByte.setColorStroke(getLineColor());
        }
        pdfContentByte.moveTo(f5 + f, this.offset + f3);
        pdfContentByte.lineTo(f5 + f4 + f, f3 + this.offset);
        pdfContentByte.stroke();
    }

    public float getLineWidth() {
        return this.lineWidth;
    }

    public void setLineWidth(float f) {
        this.lineWidth = f;
    }

    public float getPercentage() {
        return this.percentage;
    }

    public void setPercentage(float f) {
        this.percentage = f;
    }

    public Color getLineColor() {
        return this.lineColor;
    }

    public void setLineColor(Color color) {
        this.lineColor = color;
    }

    public int getAlignment() {
        return this.alignment;
    }

    public void setAlignment(int i) {
        this.alignment = i;
    }
}
