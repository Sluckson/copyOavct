package com.lowagie.text.pdf;

import harmony.java.awt.Color;
import java.io.IOException;

public class PdfShading {
    protected boolean antiAlias = false;
    protected float[] bBox;
    protected ColorDetails colorDetails;
    private Color cspace;
    protected PdfDictionary shading;
    protected PdfName shadingName;
    protected PdfIndirectReference shadingReference;
    protected int shadingType;
    protected PdfWriter writer;

    protected PdfShading(PdfWriter pdfWriter) {
        this.writer = pdfWriter;
    }

    /* access modifiers changed from: protected */
    public void setColorSpace(Color color) {
        PdfObject pdfObject;
        this.cspace = color;
        int type = ExtendedColor.getType(color);
        if (type == 1) {
            pdfObject = PdfName.DEVICEGRAY;
        } else if (type == 2) {
            pdfObject = PdfName.DEVICECMYK;
        } else if (type != 3) {
            if (type == 4 || type == 5) {
                throwColorSpaceError();
            }
            pdfObject = PdfName.DEVICERGB;
        } else {
            this.colorDetails = this.writer.addSimple(((SpotColor) color).getPdfSpotColor());
            pdfObject = this.colorDetails.getIndirectReference();
        }
        this.shading.put(PdfName.COLORSPACE, pdfObject);
    }

    public Color getColorSpace() {
        return this.cspace;
    }

    public static void throwColorSpaceError() {
        throw new IllegalArgumentException("A tiling or shading pattern cannot be used as a color space in a shading pattern");
    }

    public static void checkCompatibleColors(Color color, Color color2) {
        int type = ExtendedColor.getType(color);
        if (type != ExtendedColor.getType(color2)) {
            throw new IllegalArgumentException("Both colors must be of the same type.");
        } else if (type == 3 && ((SpotColor) color).getPdfSpotColor() != ((SpotColor) color2).getPdfSpotColor()) {
            throw new IllegalArgumentException("The spot color must be the same, only the tint can vary.");
        } else if (type == 4 || type == 5) {
            throwColorSpaceError();
        }
    }

    public static float[] getColorArray(Color color) {
        int type = ExtendedColor.getType(color);
        if (type == 0) {
            return new float[]{((float) color.getRed()) / 255.0f, ((float) color.getGreen()) / 255.0f, ((float) color.getBlue()) / 255.0f};
        } else if (type == 1) {
            return new float[]{((GrayColor) color).getGray()};
        } else if (type == 2) {
            CMYKColor cMYKColor = (CMYKColor) color;
            return new float[]{cMYKColor.getCyan(), cMYKColor.getMagenta(), cMYKColor.getYellow(), cMYKColor.getBlack()};
        } else if (type != 3) {
            throwColorSpaceError();
            return null;
        } else {
            return new float[]{((SpotColor) color).getTint()};
        }
    }

    public static PdfShading type1(PdfWriter pdfWriter, Color color, float[] fArr, float[] fArr2, PdfFunction pdfFunction) {
        PdfShading pdfShading = new PdfShading(pdfWriter);
        pdfShading.shading = new PdfDictionary();
        pdfShading.shadingType = 1;
        pdfShading.shading.put(PdfName.SHADINGTYPE, new PdfNumber(pdfShading.shadingType));
        pdfShading.setColorSpace(color);
        if (fArr != null) {
            pdfShading.shading.put(PdfName.DOMAIN, new PdfArray(fArr));
        }
        if (fArr2 != null) {
            pdfShading.shading.put(PdfName.MATRIX, new PdfArray(fArr2));
        }
        pdfShading.shading.put(PdfName.FUNCTION, pdfFunction.getReference());
        return pdfShading;
    }

    public static PdfShading type2(PdfWriter pdfWriter, Color color, float[] fArr, float[] fArr2, PdfFunction pdfFunction, boolean[] zArr) {
        PdfShading pdfShading = new PdfShading(pdfWriter);
        pdfShading.shading = new PdfDictionary();
        pdfShading.shadingType = 2;
        pdfShading.shading.put(PdfName.SHADINGTYPE, new PdfNumber(pdfShading.shadingType));
        pdfShading.setColorSpace(color);
        pdfShading.shading.put(PdfName.COORDS, new PdfArray(fArr));
        if (fArr2 != null) {
            pdfShading.shading.put(PdfName.DOMAIN, new PdfArray(fArr2));
        }
        pdfShading.shading.put(PdfName.FUNCTION, pdfFunction.getReference());
        if (zArr != null && (zArr[0] || zArr[1])) {
            PdfArray pdfArray = new PdfArray((PdfObject) zArr[0] ? PdfBoolean.PDFTRUE : PdfBoolean.PDFFALSE);
            pdfArray.add((PdfObject) zArr[1] ? PdfBoolean.PDFTRUE : PdfBoolean.PDFFALSE);
            pdfShading.shading.put(PdfName.EXTEND, pdfArray);
        }
        return pdfShading;
    }

    public static PdfShading type3(PdfWriter pdfWriter, Color color, float[] fArr, float[] fArr2, PdfFunction pdfFunction, boolean[] zArr) {
        PdfShading type2 = type2(pdfWriter, color, fArr, fArr2, pdfFunction, zArr);
        type2.shadingType = 3;
        type2.shading.put(PdfName.SHADINGTYPE, new PdfNumber(type2.shadingType));
        return type2;
    }

    public static PdfShading simpleAxial(PdfWriter pdfWriter, float f, float f2, float f3, float f4, Color color, Color color2, boolean z, boolean z2) {
        checkCompatibleColors(color, color2);
        return type2(pdfWriter, color, new float[]{f, f2, f3, f4}, (float[]) null, PdfFunction.type2(pdfWriter, new float[]{0.0f, 1.0f}, (float[]) null, getColorArray(color), getColorArray(color2), 1.0f), new boolean[]{z, z2});
    }

    public static PdfShading simpleAxial(PdfWriter pdfWriter, float f, float f2, float f3, float f4, Color color, Color color2) {
        return simpleAxial(pdfWriter, f, f2, f3, f4, color, color2, true, true);
    }

    public static PdfShading simpleRadial(PdfWriter pdfWriter, float f, float f2, float f3, float f4, float f5, float f6, Color color, Color color2, boolean z, boolean z2) {
        checkCompatibleColors(color, color2);
        return type3(pdfWriter, color, new float[]{f, f2, f3, f4, f5, f6}, (float[]) null, PdfFunction.type2(pdfWriter, new float[]{0.0f, 1.0f}, (float[]) null, getColorArray(color), getColorArray(color2), 1.0f), new boolean[]{z, z2});
    }

    public static PdfShading simpleRadial(PdfWriter pdfWriter, float f, float f2, float f3, float f4, float f5, float f6, Color color, Color color2) {
        return simpleRadial(pdfWriter, f, f2, f3, f4, f5, f6, color, color2, true, true);
    }

    /* access modifiers changed from: package-private */
    public PdfName getShadingName() {
        return this.shadingName;
    }

    /* access modifiers changed from: package-private */
    public PdfIndirectReference getShadingReference() {
        if (this.shadingReference == null) {
            this.shadingReference = this.writer.getPdfIndirectReference();
        }
        return this.shadingReference;
    }

    /* access modifiers changed from: package-private */
    public void setName(int i) {
        this.shadingName = new PdfName("Sh" + i);
    }

    /* access modifiers changed from: package-private */
    public void addToBody() throws IOException {
        if (this.bBox != null) {
            this.shading.put(PdfName.BBOX, new PdfArray(this.bBox));
        }
        if (this.antiAlias) {
            this.shading.put(PdfName.ANTIALIAS, PdfBoolean.PDFTRUE);
        }
        this.writer.addToBody((PdfObject) this.shading, getShadingReference());
    }

    /* access modifiers changed from: package-private */
    public PdfWriter getWriter() {
        return this.writer;
    }

    /* access modifiers changed from: package-private */
    public ColorDetails getColorDetails() {
        return this.colorDetails;
    }

    public float[] getBBox() {
        return this.bBox;
    }

    public void setBBox(float[] fArr) {
        if (fArr.length == 4) {
            this.bBox = fArr;
            return;
        }
        throw new IllegalArgumentException("BBox must be a 4 element array.");
    }

    public boolean isAntiAlias() {
        return this.antiAlias;
    }

    public void setAntiAlias(boolean z) {
        this.antiAlias = z;
    }
}
