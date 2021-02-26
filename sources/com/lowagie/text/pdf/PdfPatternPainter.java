package com.lowagie.text.pdf;

import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.Rectangle;
import harmony.java.awt.Color;

public final class PdfPatternPainter extends PdfTemplate {
    Color defaultColor;
    boolean stencil = false;
    float xstep;
    float ystep;

    private PdfPatternPainter() {
        this.type = 3;
    }

    PdfPatternPainter(PdfWriter pdfWriter) {
        super(pdfWriter);
        this.type = 3;
    }

    PdfPatternPainter(PdfWriter pdfWriter, Color color) {
        this(pdfWriter);
        if (color == null) {
            this.defaultColor = Color.gray;
        } else {
            this.defaultColor = color;
        }
    }

    public void setXStep(float f) {
        this.xstep = f;
    }

    public void setYStep(float f) {
        this.ystep = f;
    }

    public float getXStep() {
        return this.xstep;
    }

    public float getYStep() {
        return this.ystep;
    }

    public boolean isStencil() {
        return this.stencil;
    }

    public void setPatternMatrix(float f, float f2, float f3, float f4, float f5, float f6) {
        setMatrix(f, f2, f3, f4, f5, f6);
    }

    /* access modifiers changed from: package-private */
    public PdfPattern getPattern() {
        return new PdfPattern(this);
    }

    /* access modifiers changed from: package-private */
    public PdfPattern getPattern(int i) {
        return new PdfPattern(this, i);
    }

    public PdfContentByte getDuplicate() {
        PdfPatternPainter pdfPatternPainter = new PdfPatternPainter();
        pdfPatternPainter.writer = this.writer;
        pdfPatternPainter.pdf = this.pdf;
        pdfPatternPainter.thisReference = this.thisReference;
        pdfPatternPainter.pageResources = this.pageResources;
        pdfPatternPainter.bBox = new Rectangle(this.bBox);
        pdfPatternPainter.xstep = this.xstep;
        pdfPatternPainter.ystep = this.ystep;
        pdfPatternPainter.matrix = this.matrix;
        pdfPatternPainter.stencil = this.stencil;
        pdfPatternPainter.defaultColor = this.defaultColor;
        return pdfPatternPainter;
    }

    public Color getDefaultColor() {
        return this.defaultColor;
    }

    public void setGrayFill(float f) {
        checkNoColor();
        super.setGrayFill(f);
    }

    public void resetGrayFill() {
        checkNoColor();
        super.resetGrayFill();
    }

    public void setGrayStroke(float f) {
        checkNoColor();
        super.setGrayStroke(f);
    }

    public void resetGrayStroke() {
        checkNoColor();
        super.resetGrayStroke();
    }

    public void setRGBColorFillF(float f, float f2, float f3) {
        checkNoColor();
        super.setRGBColorFillF(f, f2, f3);
    }

    public void resetRGBColorFill() {
        checkNoColor();
        super.resetRGBColorFill();
    }

    public void setRGBColorStrokeF(float f, float f2, float f3) {
        checkNoColor();
        super.setRGBColorStrokeF(f, f2, f3);
    }

    public void resetRGBColorStroke() {
        checkNoColor();
        super.resetRGBColorStroke();
    }

    public void setCMYKColorFillF(float f, float f2, float f3, float f4) {
        checkNoColor();
        super.setCMYKColorFillF(f, f2, f3, f4);
    }

    public void resetCMYKColorFill() {
        checkNoColor();
        super.resetCMYKColorFill();
    }

    public void setCMYKColorStrokeF(float f, float f2, float f3, float f4) {
        checkNoColor();
        super.setCMYKColorStrokeF(f, f2, f3, f4);
    }

    public void resetCMYKColorStroke() {
        checkNoColor();
        super.resetCMYKColorStroke();
    }

    public void addImage(Image image, float f, float f2, float f3, float f4, float f5, float f6) throws DocumentException {
        if (this.stencil && !image.isMask()) {
            checkNoColor();
        }
        super.addImage(image, f, f2, f3, f4, f5, f6);
    }

    public void setCMYKColorFill(int i, int i2, int i3, int i4) {
        checkNoColor();
        super.setCMYKColorFill(i, i2, i3, i4);
    }

    public void setCMYKColorStroke(int i, int i2, int i3, int i4) {
        checkNoColor();
        super.setCMYKColorStroke(i, i2, i3, i4);
    }

    public void setRGBColorFill(int i, int i2, int i3) {
        checkNoColor();
        super.setRGBColorFill(i, i2, i3);
    }

    public void setRGBColorStroke(int i, int i2, int i3) {
        checkNoColor();
        super.setRGBColorStroke(i, i2, i3);
    }

    public void setColorStroke(Color color) {
        checkNoColor();
        super.setColorStroke(color);
    }

    public void setColorFill(Color color) {
        checkNoColor();
        super.setColorFill(color);
    }

    public void setColorFill(PdfSpotColor pdfSpotColor, float f) {
        checkNoColor();
        super.setColorFill(pdfSpotColor, f);
    }

    public void setColorStroke(PdfSpotColor pdfSpotColor, float f) {
        checkNoColor();
        super.setColorStroke(pdfSpotColor, f);
    }

    public void setPatternFill(PdfPatternPainter pdfPatternPainter) {
        checkNoColor();
        super.setPatternFill(pdfPatternPainter);
    }

    public void setPatternFill(PdfPatternPainter pdfPatternPainter, Color color, float f) {
        checkNoColor();
        super.setPatternFill(pdfPatternPainter, color, f);
    }

    public void setPatternStroke(PdfPatternPainter pdfPatternPainter, Color color, float f) {
        checkNoColor();
        super.setPatternStroke(pdfPatternPainter, color, f);
    }

    public void setPatternStroke(PdfPatternPainter pdfPatternPainter) {
        checkNoColor();
        super.setPatternStroke(pdfPatternPainter);
    }

    /* access modifiers changed from: package-private */
    public void checkNoColor() {
        if (this.stencil) {
            throw new RuntimeException("Colors are not allowed in uncolored tile patterns.");
        }
    }
}
