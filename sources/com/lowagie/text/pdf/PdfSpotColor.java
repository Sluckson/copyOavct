package com.lowagie.text.pdf;

import harmony.java.awt.Color;

public class PdfSpotColor {
    public Color altcs;
    public PdfName name;
    protected float tint;

    public PdfSpotColor(String str, float f, Color color) {
        this.name = new PdfName(str);
        this.tint = f;
        this.altcs = color;
    }

    public float getTint() {
        return this.tint;
    }

    public Color getAlternativeCS() {
        return this.altcs;
    }

    /* access modifiers changed from: protected */
    public PdfObject getSpotObject(PdfWriter pdfWriter) {
        PdfFunction pdfFunction;
        PdfArray pdfArray = new PdfArray((PdfObject) PdfName.SEPARATION);
        pdfArray.add((PdfObject) this.name);
        Color color = this.altcs;
        if (color instanceof ExtendedColor) {
            int i = ((ExtendedColor) color).type;
            if (i == 1) {
                pdfArray.add((PdfObject) PdfName.DEVICEGRAY);
                PdfWriter pdfWriter2 = pdfWriter;
                pdfFunction = PdfFunction.type2(pdfWriter2, new float[]{0.0f, 1.0f}, (float[]) null, new float[]{0.0f}, new float[]{((GrayColor) this.altcs).getGray()}, 1.0f);
            } else if (i == 2) {
                pdfArray.add((PdfObject) PdfName.DEVICECMYK);
                CMYKColor cMYKColor = (CMYKColor) this.altcs;
                PdfWriter pdfWriter3 = pdfWriter;
                pdfFunction = PdfFunction.type2(pdfWriter3, new float[]{0.0f, 1.0f}, (float[]) null, new float[]{0.0f, 0.0f, 0.0f, 0.0f}, new float[]{cMYKColor.getCyan(), cMYKColor.getMagenta(), cMYKColor.getYellow(), cMYKColor.getBlack()}, 1.0f);
            } else {
                throw new RuntimeException("Only RGB, Gray and CMYK are supported as alternative color spaces.");
            }
        } else {
            pdfArray.add((PdfObject) PdfName.DEVICERGB);
            PdfWriter pdfWriter4 = pdfWriter;
            pdfFunction = PdfFunction.type2(pdfWriter4, new float[]{0.0f, 1.0f}, (float[]) null, new float[]{1.0f, 1.0f, 1.0f}, new float[]{((float) this.altcs.getRed()) / 255.0f, ((float) this.altcs.getGreen()) / 255.0f, ((float) this.altcs.getBlue()) / 255.0f}, 1.0f);
        }
        pdfArray.add((PdfObject) pdfFunction.getReference());
        return pdfArray;
    }
}
