package com.lowagie.text.pdf;

import com.lowagie.text.Rectangle;
import java.io.IOException;

public class PdfTemplate extends PdfContentByte {
    public static final int TYPE_IMPORTED = 2;
    public static final int TYPE_PATTERN = 3;
    public static final int TYPE_TEMPLATE = 1;
    protected Rectangle bBox;
    protected PdfTransparencyGroup group;
    protected PdfOCG layer;
    protected PdfArray matrix;
    protected PageResources pageResources;
    protected PdfIndirectReference thisReference;
    protected int type;

    protected PdfTemplate() {
        super((PdfWriter) null);
        this.bBox = new Rectangle(0.0f, 0.0f);
        this.type = 1;
    }

    PdfTemplate(PdfWriter pdfWriter) {
        super(pdfWriter);
        this.bBox = new Rectangle(0.0f, 0.0f);
        this.type = 1;
        this.pageResources = new PageResources();
        this.pageResources.addDefaultColor(pdfWriter.getDefaultColorspace());
        this.thisReference = this.writer.getPdfIndirectReference();
    }

    public static PdfTemplate createTemplate(PdfWriter pdfWriter, float f, float f2) {
        return createTemplate(pdfWriter, f, f2, (PdfName) null);
    }

    static PdfTemplate createTemplate(PdfWriter pdfWriter, float f, float f2, PdfName pdfName) {
        PdfTemplate pdfTemplate = new PdfTemplate(pdfWriter);
        pdfTemplate.setWidth(f);
        pdfTemplate.setHeight(f2);
        pdfWriter.addDirectTemplateSimple(pdfTemplate, pdfName);
        return pdfTemplate;
    }

    public void setWidth(float f) {
        this.bBox.setLeft(0.0f);
        this.bBox.setRight(f);
    }

    public void setHeight(float f) {
        this.bBox.setBottom(0.0f);
        this.bBox.setTop(f);
    }

    public float getWidth() {
        return this.bBox.getWidth();
    }

    public float getHeight() {
        return this.bBox.getHeight();
    }

    public Rectangle getBoundingBox() {
        return this.bBox;
    }

    public void setBoundingBox(Rectangle rectangle) {
        this.bBox = rectangle;
    }

    public void setLayer(PdfOCG pdfOCG) {
        this.layer = pdfOCG;
    }

    public PdfOCG getLayer() {
        return this.layer;
    }

    public void setMatrix(float f, float f2, float f3, float f4, float f5, float f6) {
        this.matrix = new PdfArray();
        this.matrix.add((PdfObject) new PdfNumber(f));
        this.matrix.add((PdfObject) new PdfNumber(f2));
        this.matrix.add((PdfObject) new PdfNumber(f3));
        this.matrix.add((PdfObject) new PdfNumber(f4));
        this.matrix.add((PdfObject) new PdfNumber(f5));
        this.matrix.add((PdfObject) new PdfNumber(f6));
    }

    /* access modifiers changed from: package-private */
    public PdfArray getMatrix() {
        return this.matrix;
    }

    public PdfIndirectReference getIndirectReference() {
        if (this.thisReference == null) {
            this.thisReference = this.writer.getPdfIndirectReference();
        }
        return this.thisReference;
    }

    public void beginVariableText() {
        this.content.append("/Tx BMC ");
    }

    public void endVariableText() {
        this.content.append("EMC ");
    }

    /* access modifiers changed from: package-private */
    public PdfObject getResources() {
        return getPageResources().getResources();
    }

    /* access modifiers changed from: package-private */
    public PdfStream getFormXObject(int i) throws IOException {
        return new PdfFormXObject(this, i);
    }

    public PdfContentByte getDuplicate() {
        PdfTemplate pdfTemplate = new PdfTemplate();
        pdfTemplate.writer = this.writer;
        pdfTemplate.pdf = this.pdf;
        pdfTemplate.thisReference = this.thisReference;
        pdfTemplate.pageResources = this.pageResources;
        pdfTemplate.bBox = new Rectangle(this.bBox);
        pdfTemplate.group = this.group;
        pdfTemplate.layer = this.layer;
        PdfArray pdfArray = this.matrix;
        if (pdfArray != null) {
            pdfTemplate.matrix = new PdfArray(pdfArray);
        }
        pdfTemplate.separator = this.separator;
        return pdfTemplate;
    }

    public int getType() {
        return this.type;
    }

    /* access modifiers changed from: package-private */
    public PageResources getPageResources() {
        return this.pageResources;
    }

    public PdfTransparencyGroup getGroup() {
        return this.group;
    }

    public void setGroup(PdfTransparencyGroup pdfTransparencyGroup) {
        this.group = pdfTransparencyGroup;
    }
}
