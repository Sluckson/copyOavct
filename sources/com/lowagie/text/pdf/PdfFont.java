package com.lowagie.text.pdf;

import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Image;

class PdfFont implements Comparable {
    private BaseFont font;
    protected float hScale = 1.0f;
    protected Image image;
    private float size;

    PdfFont(BaseFont baseFont, float f) {
        this.size = f;
        this.font = baseFont;
    }

    public int compareTo(Object obj) {
        if (this.image != null) {
            return 0;
        }
        if (obj == null) {
            return -1;
        }
        try {
            PdfFont pdfFont = (PdfFont) obj;
            if (this.font != pdfFont.font) {
                return 1;
            }
            if (size() != pdfFont.size()) {
                return 2;
            }
            return 0;
        } catch (ClassCastException unused) {
            return -2;
        }
    }

    /* access modifiers changed from: package-private */
    public float size() {
        Image image2 = this.image;
        if (image2 == null) {
            return this.size;
        }
        return image2.getScaledHeight();
    }

    /* access modifiers changed from: package-private */
    public float width() {
        return width(32);
    }

    /* access modifiers changed from: package-private */
    public float width(int i) {
        Image image2 = this.image;
        if (image2 == null) {
            return this.font.getWidthPoint(i, this.size) * this.hScale;
        }
        return image2.getScaledWidth();
    }

    /* access modifiers changed from: package-private */
    public float width(String str) {
        Image image2 = this.image;
        if (image2 == null) {
            return this.font.getWidthPoint(str, this.size) * this.hScale;
        }
        return image2.getScaledWidth();
    }

    /* access modifiers changed from: package-private */
    public BaseFont getFont() {
        return this.font;
    }

    /* access modifiers changed from: package-private */
    public void setImage(Image image2) {
        this.image = image2;
    }

    static PdfFont getDefaultFont() {
        try {
            return new PdfFont(BaseFont.createFont("Helvetica", "Cp1252", false), 12.0f);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    /* access modifiers changed from: package-private */
    public void setHorizontalScaling(float f) {
        this.hScale = f;
    }
}
