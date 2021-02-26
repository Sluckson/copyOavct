package com.lowagie.text.pdf;

import com.lowagie.text.Chunk;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Image;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.events.PdfPCellEventForwarder;
import java.util.List;

public class PdfPCell extends Rectangle {
    private PdfPCellEvent cellEvent;
    private int colspan;
    private ColumnText column;
    private float fixedHeight;
    private Image image;
    private float minimumHeight;
    private boolean noWrap;
    private float paddingBottom;
    private float paddingLeft;
    private float paddingRight;
    private float paddingTop;
    protected Phrase phrase;
    private int rotation;
    private int rowspan;
    private PdfPTable table;
    private boolean useBorderPadding;
    private boolean useDescender;
    private int verticalAlignment;

    public PdfPCell() {
        super(0.0f, 0.0f, 0.0f, 0.0f);
        this.column = new ColumnText((PdfContentByte) null);
        this.verticalAlignment = 4;
        this.paddingLeft = 2.0f;
        this.paddingRight = 2.0f;
        this.paddingTop = 2.0f;
        this.paddingBottom = 2.0f;
        this.fixedHeight = 0.0f;
        this.noWrap = false;
        this.colspan = 1;
        this.rowspan = 1;
        this.useBorderPadding = false;
        this.borderWidth = 0.5f;
        this.border = 15;
        this.column.setLeading(0.0f, 1.0f);
    }

    public PdfPCell(Phrase phrase2) {
        super(0.0f, 0.0f, 0.0f, 0.0f);
        this.column = new ColumnText((PdfContentByte) null);
        this.verticalAlignment = 4;
        this.paddingLeft = 2.0f;
        this.paddingRight = 2.0f;
        this.paddingTop = 2.0f;
        this.paddingBottom = 2.0f;
        this.fixedHeight = 0.0f;
        this.noWrap = false;
        this.colspan = 1;
        this.rowspan = 1;
        this.useBorderPadding = false;
        this.borderWidth = 0.5f;
        this.border = 15;
        ColumnText columnText = this.column;
        this.phrase = phrase2;
        columnText.addText(phrase2);
        this.column.setLeading(0.0f, 1.0f);
    }

    public PdfPCell(Image image2) {
        this(image2, false);
    }

    public PdfPCell(Image image2, boolean z) {
        super(0.0f, 0.0f, 0.0f, 0.0f);
        this.column = new ColumnText((PdfContentByte) null);
        this.verticalAlignment = 4;
        this.paddingLeft = 2.0f;
        this.paddingRight = 2.0f;
        this.paddingTop = 2.0f;
        this.paddingBottom = 2.0f;
        this.fixedHeight = 0.0f;
        this.noWrap = false;
        this.colspan = 1;
        this.rowspan = 1;
        this.useBorderPadding = false;
        this.borderWidth = 0.5f;
        this.border = 15;
        if (z) {
            this.image = image2;
            this.column.setLeading(0.0f, 1.0f);
            setPadding(this.borderWidth / 2.0f);
            return;
        }
        ColumnText columnText = this.column;
        Phrase phrase2 = new Phrase(new Chunk(image2, 0.0f, 0.0f));
        this.phrase = phrase2;
        columnText.addText(phrase2);
        this.column.setLeading(0.0f, 1.0f);
        setPadding(0.0f);
    }

    public PdfPCell(PdfPTable pdfPTable) {
        this(pdfPTable, (PdfPCell) null);
    }

    public PdfPCell(PdfPTable pdfPTable, PdfPCell pdfPCell) {
        super(0.0f, 0.0f, 0.0f, 0.0f);
        this.column = new ColumnText((PdfContentByte) null);
        this.verticalAlignment = 4;
        this.paddingLeft = 2.0f;
        this.paddingRight = 2.0f;
        this.paddingTop = 2.0f;
        this.paddingBottom = 2.0f;
        this.fixedHeight = 0.0f;
        this.noWrap = false;
        this.colspan = 1;
        this.rowspan = 1;
        this.useBorderPadding = false;
        this.borderWidth = 0.5f;
        this.border = 15;
        this.column.setLeading(0.0f, 1.0f);
        this.table = pdfPTable;
        pdfPTable.setWidthPercentage(100.0f);
        pdfPTable.setExtendLastRow(true);
        this.column.addElement(pdfPTable);
        if (pdfPCell != null) {
            cloneNonPositionParameters(pdfPCell);
            this.verticalAlignment = pdfPCell.verticalAlignment;
            this.paddingLeft = pdfPCell.paddingLeft;
            this.paddingRight = pdfPCell.paddingRight;
            this.paddingTop = pdfPCell.paddingTop;
            this.paddingBottom = pdfPCell.paddingBottom;
            this.colspan = pdfPCell.colspan;
            this.rowspan = pdfPCell.rowspan;
            this.cellEvent = pdfPCell.cellEvent;
            this.useDescender = pdfPCell.useDescender;
            this.useBorderPadding = pdfPCell.useBorderPadding;
            this.rotation = pdfPCell.rotation;
            return;
        }
        setPadding(0.0f);
    }

    public PdfPCell(PdfPCell pdfPCell) {
        super(pdfPCell.llx, pdfPCell.lly, pdfPCell.urx, pdfPCell.ury);
        this.column = new ColumnText((PdfContentByte) null);
        this.verticalAlignment = 4;
        this.paddingLeft = 2.0f;
        this.paddingRight = 2.0f;
        this.paddingTop = 2.0f;
        this.paddingBottom = 2.0f;
        this.fixedHeight = 0.0f;
        this.noWrap = false;
        this.colspan = 1;
        this.rowspan = 1;
        this.useBorderPadding = false;
        cloneNonPositionParameters(pdfPCell);
        this.verticalAlignment = pdfPCell.verticalAlignment;
        this.paddingLeft = pdfPCell.paddingLeft;
        this.paddingRight = pdfPCell.paddingRight;
        this.paddingTop = pdfPCell.paddingTop;
        this.paddingBottom = pdfPCell.paddingBottom;
        this.phrase = pdfPCell.phrase;
        this.fixedHeight = pdfPCell.fixedHeight;
        this.minimumHeight = pdfPCell.minimumHeight;
        this.noWrap = pdfPCell.noWrap;
        this.colspan = pdfPCell.colspan;
        this.rowspan = pdfPCell.rowspan;
        PdfPTable pdfPTable = pdfPCell.table;
        if (pdfPTable != null) {
            this.table = new PdfPTable(pdfPTable);
        }
        this.image = Image.getInstance(pdfPCell.image);
        this.cellEvent = pdfPCell.cellEvent;
        this.useDescender = pdfPCell.useDescender;
        this.column = ColumnText.duplicate(pdfPCell.column);
        this.useBorderPadding = pdfPCell.useBorderPadding;
        this.rotation = pdfPCell.rotation;
    }

    public void addElement(Element element) {
        if (this.table != null) {
            this.table = null;
            this.column.setText((Phrase) null);
        }
        this.column.addElement(element);
    }

    public Phrase getPhrase() {
        return this.phrase;
    }

    public void setPhrase(Phrase phrase2) {
        this.table = null;
        this.image = null;
        ColumnText columnText = this.column;
        this.phrase = phrase2;
        columnText.setText(phrase2);
    }

    public int getHorizontalAlignment() {
        return this.column.getAlignment();
    }

    public void setHorizontalAlignment(int i) {
        this.column.setAlignment(i);
    }

    public int getVerticalAlignment() {
        return this.verticalAlignment;
    }

    public void setVerticalAlignment(int i) {
        PdfPTable pdfPTable = this.table;
        if (pdfPTable != null) {
            pdfPTable.setExtendLastRow(i == 4);
        }
        this.verticalAlignment = i;
    }

    public float getEffectivePaddingLeft() {
        if (!isUseBorderPadding()) {
            return this.paddingLeft;
        }
        return this.paddingLeft + (getBorderWidthLeft() / (isUseVariableBorders() ? 1.0f : 2.0f));
    }

    public float getPaddingLeft() {
        return this.paddingLeft;
    }

    public void setPaddingLeft(float f) {
        this.paddingLeft = f;
    }

    public float getEffectivePaddingRight() {
        if (!isUseBorderPadding()) {
            return this.paddingRight;
        }
        return this.paddingRight + (getBorderWidthRight() / (isUseVariableBorders() ? 1.0f : 2.0f));
    }

    public float getPaddingRight() {
        return this.paddingRight;
    }

    public void setPaddingRight(float f) {
        this.paddingRight = f;
    }

    public float getEffectivePaddingTop() {
        if (!isUseBorderPadding()) {
            return this.paddingTop;
        }
        return this.paddingTop + (getBorderWidthTop() / (isUseVariableBorders() ? 1.0f : 2.0f));
    }

    public float getPaddingTop() {
        return this.paddingTop;
    }

    public void setPaddingTop(float f) {
        this.paddingTop = f;
    }

    public float getEffectivePaddingBottom() {
        if (!isUseBorderPadding()) {
            return this.paddingBottom;
        }
        return this.paddingBottom + (getBorderWidthBottom() / (isUseVariableBorders() ? 1.0f : 2.0f));
    }

    public float getPaddingBottom() {
        return this.paddingBottom;
    }

    public void setPaddingBottom(float f) {
        this.paddingBottom = f;
    }

    public void setPadding(float f) {
        this.paddingBottom = f;
        this.paddingTop = f;
        this.paddingLeft = f;
        this.paddingRight = f;
    }

    public boolean isUseBorderPadding() {
        return this.useBorderPadding;
    }

    public void setUseBorderPadding(boolean z) {
        this.useBorderPadding = z;
    }

    public void setLeading(float f, float f2) {
        this.column.setLeading(f, f2);
    }

    public float getLeading() {
        return this.column.getLeading();
    }

    public float getMultipliedLeading() {
        return this.column.getMultipliedLeading();
    }

    public void setIndent(float f) {
        this.column.setIndent(f);
    }

    public float getIndent() {
        return this.column.getIndent();
    }

    public float getExtraParagraphSpace() {
        return this.column.getExtraParagraphSpace();
    }

    public void setExtraParagraphSpace(float f) {
        this.column.setExtraParagraphSpace(f);
    }

    public void setFixedHeight(float f) {
        this.fixedHeight = f;
        this.minimumHeight = 0.0f;
    }

    public float getFixedHeight() {
        return this.fixedHeight;
    }

    public boolean hasFixedHeight() {
        return getFixedHeight() > 0.0f;
    }

    public void setMinimumHeight(float f) {
        this.minimumHeight = f;
        this.fixedHeight = 0.0f;
    }

    public float getMinimumHeight() {
        return this.minimumHeight;
    }

    public boolean hasMinimumHeight() {
        return getMinimumHeight() > 0.0f;
    }

    public boolean isNoWrap() {
        return this.noWrap;
    }

    public void setNoWrap(boolean z) {
        this.noWrap = z;
    }

    public PdfPTable getTable() {
        return this.table;
    }

    /* access modifiers changed from: package-private */
    public void setTable(PdfPTable pdfPTable) {
        this.table = pdfPTable;
        this.column.setText((Phrase) null);
        this.image = null;
        if (pdfPTable != null) {
            pdfPTable.setExtendLastRow(this.verticalAlignment == 4);
            this.column.addElement(pdfPTable);
            pdfPTable.setWidthPercentage(100.0f);
        }
    }

    public int getColspan() {
        return this.colspan;
    }

    public void setColspan(int i) {
        this.colspan = i;
    }

    public int getRowspan() {
        return this.rowspan;
    }

    public void setRowspan(int i) {
        this.rowspan = i;
    }

    public void setFollowingIndent(float f) {
        this.column.setFollowingIndent(f);
    }

    public float getFollowingIndent() {
        return this.column.getFollowingIndent();
    }

    public void setRightIndent(float f) {
        this.column.setRightIndent(f);
    }

    public float getRightIndent() {
        return this.column.getRightIndent();
    }

    public float getSpaceCharRatio() {
        return this.column.getSpaceCharRatio();
    }

    public void setSpaceCharRatio(float f) {
        this.column.setSpaceCharRatio(f);
    }

    public void setRunDirection(int i) {
        this.column.setRunDirection(i);
    }

    public int getRunDirection() {
        return this.column.getRunDirection();
    }

    public Image getImage() {
        return this.image;
    }

    public void setImage(Image image2) {
        this.column.setText((Phrase) null);
        this.table = null;
        this.image = image2;
    }

    public PdfPCellEvent getCellEvent() {
        return this.cellEvent;
    }

    public void setCellEvent(PdfPCellEvent pdfPCellEvent) {
        if (pdfPCellEvent == null) {
            this.cellEvent = null;
            return;
        }
        PdfPCellEvent pdfPCellEvent2 = this.cellEvent;
        if (pdfPCellEvent2 == null) {
            this.cellEvent = pdfPCellEvent;
        } else if (pdfPCellEvent2 instanceof PdfPCellEventForwarder) {
            ((PdfPCellEventForwarder) pdfPCellEvent2).addCellEvent(pdfPCellEvent);
        } else {
            PdfPCellEventForwarder pdfPCellEventForwarder = new PdfPCellEventForwarder();
            pdfPCellEventForwarder.addCellEvent(this.cellEvent);
            pdfPCellEventForwarder.addCellEvent(pdfPCellEvent);
            this.cellEvent = pdfPCellEventForwarder;
        }
    }

    public int getArabicOptions() {
        return this.column.getArabicOptions();
    }

    public void setArabicOptions(int i) {
        this.column.setArabicOptions(i);
    }

    public boolean isUseAscender() {
        return this.column.isUseAscender();
    }

    public void setUseAscender(boolean z) {
        this.column.setUseAscender(z);
    }

    public boolean isUseDescender() {
        return this.useDescender;
    }

    public void setUseDescender(boolean z) {
        this.useDescender = z;
    }

    public ColumnText getColumn() {
        return this.column;
    }

    public List getCompositeElements() {
        return getColumn().compositeElements;
    }

    public void setColumn(ColumnText columnText) {
        this.column = columnText;
    }

    public int getRotation() {
        return this.rotation;
    }

    public void setRotation(int i) {
        int i2 = i % 360;
        if (i2 < 0) {
            i2 += 360;
        }
        if (i2 % 90 == 0) {
            this.rotation = i2;
            return;
        }
        throw new IllegalArgumentException("Rotation must be a multiple of 90.");
    }

    /* access modifiers changed from: package-private */
    public void consumeHeight(float f) {
        float right = getRight() - getEffectivePaddingRight();
        float left = getLeft() + getEffectivePaddingLeft();
        float effectivePaddingTop = (f - getEffectivePaddingTop()) - getEffectivePaddingBottom();
        if (getRotation() == 90 || getRotation() == 270) {
            this.column.setSimpleColumn(0.0f, left, effectivePaddingTop + 0.001f, right);
        } else {
            this.column.setSimpleColumn(left, effectivePaddingTop + 0.001f, right, 0.0f);
        }
        try {
            this.column.mo52495go(true);
        } catch (DocumentException unused) {
        }
    }

    public float getMaxHeight() {
        float f;
        float f2;
        float f3;
        boolean z = getRotation() == 90 || getRotation() == 270;
        Image image2 = getImage();
        if (image2 != null) {
            image2.scalePercent(100.0f);
            image2.scalePercent(((((getRight() - getEffectivePaddingRight()) - getEffectivePaddingLeft()) - getLeft()) / (z ? image2.getScaledHeight() : image2.getScaledWidth())) * 100.0f);
            setBottom(((getTop() - getEffectivePaddingTop()) - getEffectivePaddingBottom()) - (z ? image2.getScaledWidth() : image2.getScaledHeight()));
        } else if (!z || !hasFixedHeight()) {
            ColumnText duplicate = ColumnText.duplicate(getColumn());
            float f4 = 20000.0f;
            if (z) {
                f3 = getRight() - getEffectivePaddingRight();
                f2 = 0.0f;
                f = getLeft() + getEffectivePaddingLeft();
            } else {
                if (!isNoWrap()) {
                    f4 = getRight() - getEffectivePaddingRight();
                }
                f3 = getTop() - getEffectivePaddingTop();
                f2 = getLeft() + getEffectivePaddingLeft();
                f = hasFixedHeight() ? (getEffectivePaddingBottom() + f3) - getFixedHeight() : -1.07374182E9f;
            }
            PdfPRow.setColumn(duplicate, f2, f, f4, f3);
            try {
                duplicate.mo52495go(true);
                if (z) {
                    setBottom(((getTop() - getEffectivePaddingTop()) - getEffectivePaddingBottom()) - duplicate.getFilledWidth());
                } else {
                    float yLine = duplicate.getYLine();
                    if (isUseDescender()) {
                        yLine += duplicate.getDescender();
                    }
                    setBottom(yLine - getEffectivePaddingBottom());
                }
            } catch (DocumentException e) {
                throw new ExceptionConverter(e);
            }
        } else {
            setBottom(getTop() - getFixedHeight());
        }
        float height = getHeight();
        if (height < getFixedHeight()) {
            return getFixedHeight();
        }
        if (height < getMinimumHeight()) {
            return getMinimumHeight();
        }
        return height;
    }
}
