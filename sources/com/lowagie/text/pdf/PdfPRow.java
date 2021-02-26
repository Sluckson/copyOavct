package com.lowagie.text.pdf;

import com.lowagie.text.DocumentException;
import com.lowagie.text.ExceptionConverter;
import com.lowagie.text.Image;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import harmony.java.awt.Color;

public class PdfPRow {
    public static final float BOTTOM_LIMIT = -1.07374182E9f;
    public static final float RIGHT_LIMIT = 20000.0f;
    protected boolean calculated = false;
    private int[] canvasesPos;
    protected PdfPCell[] cells;
    protected float[] extraHeights;
    protected float maxHeight = 0.0f;
    protected float[] widths;

    public PdfPRow(PdfPCell[] pdfPCellArr) {
        this.cells = pdfPCellArr;
        this.widths = new float[pdfPCellArr.length];
        initExtraHeights();
    }

    public PdfPRow(PdfPRow pdfPRow) {
        this.maxHeight = pdfPRow.maxHeight;
        this.calculated = pdfPRow.calculated;
        this.cells = new PdfPCell[pdfPRow.cells.length];
        int i = 0;
        while (true) {
            PdfPCell[] pdfPCellArr = this.cells;
            if (i >= pdfPCellArr.length) {
                this.widths = new float[pdfPCellArr.length];
                System.arraycopy(pdfPRow.widths, 0, this.widths, 0, pdfPCellArr.length);
                initExtraHeights();
                return;
            }
            PdfPCell[] pdfPCellArr2 = pdfPRow.cells;
            if (pdfPCellArr2[i] != null) {
                pdfPCellArr[i] = new PdfPCell(pdfPCellArr2[i]);
            }
            i++;
        }
    }

    public boolean setWidths(float[] fArr) {
        int length = fArr.length;
        PdfPCell[] pdfPCellArr = this.cells;
        int i = 0;
        if (length != pdfPCellArr.length) {
            return false;
        }
        System.arraycopy(fArr, 0, this.widths, 0, pdfPCellArr.length);
        this.calculated = false;
        float f = 0.0f;
        while (i < fArr.length) {
            PdfPCell pdfPCell = this.cells[i];
            if (pdfPCell == null) {
                f += fArr[i];
            } else {
                pdfPCell.setLeft(f);
                int colspan = pdfPCell.getColspan() + i;
                while (i < colspan) {
                    f += fArr[i];
                    i++;
                }
                i--;
                pdfPCell.setRight(f);
                pdfPCell.setTop(0.0f);
            }
            i++;
        }
        return true;
    }

    public void initExtraHeights() {
        this.extraHeights = new float[this.cells.length];
        int i = 0;
        while (true) {
            float[] fArr = this.extraHeights;
            if (i < fArr.length) {
                fArr[i] = 0.0f;
                i++;
            } else {
                return;
            }
        }
    }

    public void setExtraHeight(int i, float f) {
        if (i >= 0 && i < this.cells.length) {
            this.extraHeights[i] = f;
        }
    }

    public float calculateHeights() {
        this.maxHeight = 0.0f;
        int i = 0;
        while (true) {
            PdfPCell[] pdfPCellArr = this.cells;
            if (i >= pdfPCellArr.length) {
                this.calculated = true;
                return this.maxHeight;
            }
            PdfPCell pdfPCell = pdfPCellArr[i];
            if (pdfPCell != null) {
                float maxHeight2 = pdfPCell.getMaxHeight();
                if (maxHeight2 > this.maxHeight && pdfPCell.getRowspan() == 1) {
                    this.maxHeight = maxHeight2;
                }
            }
            i++;
        }
    }

    public void writeBorderAndBackground(float f, float f2, float f3, PdfPCell pdfPCell, PdfContentByte[] pdfContentByteArr) {
        Color backgroundColor = pdfPCell.getBackgroundColor();
        if (backgroundColor != null || pdfPCell.hasBorders()) {
            float right = pdfPCell.getRight() + f;
            float top = pdfPCell.getTop() + f2;
            float left = pdfPCell.getLeft() + f;
            float f4 = top - f3;
            if (backgroundColor != null) {
                PdfContentByte pdfContentByte = pdfContentByteArr[1];
                pdfContentByte.setColorFill(backgroundColor);
                pdfContentByte.rectangle(left, f4, right - left, top - f4);
                pdfContentByte.fill();
            }
            if (pdfPCell.hasBorders()) {
                Rectangle rectangle = new Rectangle(left, f4, right, top);
                rectangle.cloneNonPositionParameters(pdfPCell);
                rectangle.setBackgroundColor((Color) null);
                pdfContentByteArr[2].rectangle(rectangle);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void saveAndRotateCanvases(PdfContentByte[] pdfContentByteArr, float f, float f2, float f3, float f4, float f5, float f6) {
        if (this.canvasesPos == null) {
            this.canvasesPos = new int[8];
        }
        for (int i = 0; i < 4; i++) {
            ByteBuffer internalBuffer = pdfContentByteArr[i].getInternalBuffer();
            int i2 = i * 2;
            this.canvasesPos[i2] = internalBuffer.size();
            pdfContentByteArr[i].saveState();
            pdfContentByteArr[i].concatCTM(f, f2, f3, f4, f5, f6);
            this.canvasesPos[i2 + 1] = internalBuffer.size();
        }
    }

    /* access modifiers changed from: protected */
    public void restoreCanvases(PdfContentByte[] pdfContentByteArr) {
        for (int i = 0; i < 4; i++) {
            ByteBuffer internalBuffer = pdfContentByteArr[i].getInternalBuffer();
            int size = internalBuffer.size();
            pdfContentByteArr[i].restoreState();
            int[] iArr = this.canvasesPos;
            int i2 = i * 2;
            if (size == iArr[i2 + 1]) {
                internalBuffer.setSize(iArr[i2]);
            }
        }
    }

    public static float setColumn(ColumnText columnText, float f, float f2, float f3, float f4) {
        if (f > f3) {
            f3 = f;
        }
        if (f2 > f4) {
            f4 = f2;
        }
        columnText.setSimpleColumn(f, f2, f3, f4);
        return f4;
    }

    public void writeCells(int i, int i2, float f, float f2, PdfContentByte[] pdfContentByteArr) {
        int i3;
        float f3;
        float f4;
        float f5;
        float left;
        ColumnText columnText;
        boolean z;
        float f6;
        float f7;
        float f8;
        int i4 = i2;
        PdfContentByte[] pdfContentByteArr2 = pdfContentByteArr;
        if (!this.calculated) {
            calculateHeights();
        }
        if (i4 < 0) {
            i3 = this.cells.length;
        } else {
            i3 = Math.min(i4, this.cells.length);
        }
        int i5 = i < 0 ? 0 : i;
        if (i5 < i3) {
            float f9 = f;
            while (i5 >= 0 && this.cells[i5] == null) {
                if (i5 > 0) {
                    f9 -= this.widths[i5 - 1];
                }
                i5--;
            }
            if (i5 < 0) {
                i5 = 0;
            }
            PdfPCell[] pdfPCellArr = this.cells;
            if (pdfPCellArr[i5] != null) {
                f9 -= pdfPCellArr[i5].getLeft();
            }
            float f10 = f9;
            for (int i6 = i5; i6 < i3; i6++) {
                PdfPCell pdfPCell = this.cells[i6];
                if (pdfPCell != null) {
                    float f11 = this.maxHeight + this.extraHeights[i6];
                    writeBorderAndBackground(f10, f2, f11, pdfPCell, pdfContentByteArr);
                    Image image = pdfPCell.getImage();
                    float top = (pdfPCell.getTop() + f2) - pdfPCell.getEffectivePaddingTop();
                    if (pdfPCell.getHeight() <= f11) {
                        int verticalAlignment = pdfPCell.getVerticalAlignment();
                        if (verticalAlignment == 5) {
                            f8 = pdfPCell.getTop() + f2 + ((pdfPCell.getHeight() - f11) / 2.0f);
                            f7 = pdfPCell.getEffectivePaddingTop();
                        } else if (verticalAlignment == 6) {
                            f8 = ((pdfPCell.getTop() + f2) - f11) + pdfPCell.getHeight();
                            f7 = pdfPCell.getEffectivePaddingTop();
                        }
                        top = f8 - f7;
                    }
                    if (image != null) {
                        if (pdfPCell.getRotation() != 0) {
                            image = Image.getInstance(image);
                            image.setRotation(image.getImageRotation() + ((float) ((((double) pdfPCell.getRotation()) * 3.141592653589793d) / 180.0d)));
                        }
                        if (pdfPCell.getHeight() > f11) {
                            image.scalePercent(100.0f);
                            image.scalePercent((((f11 - pdfPCell.getEffectivePaddingTop()) - pdfPCell.getEffectivePaddingBottom()) / image.getScaledHeight()) * 100.0f);
                            z = true;
                        } else {
                            z = false;
                        }
                        float left2 = pdfPCell.getLeft() + f10 + pdfPCell.getEffectivePaddingLeft();
                        if (z) {
                            int horizontalAlignment = pdfPCell.getHorizontalAlignment();
                            if (horizontalAlignment != 1) {
                                if (horizontalAlignment == 2) {
                                    f6 = ((pdfPCell.getRight() + f10) - pdfPCell.getEffectivePaddingRight()) - image.getScaledWidth();
                                }
                                top = (pdfPCell.getTop() + f2) - pdfPCell.getEffectivePaddingTop();
                            } else {
                                f6 = (((((pdfPCell.getLeft() + pdfPCell.getEffectivePaddingLeft()) + pdfPCell.getRight()) - pdfPCell.getEffectivePaddingRight()) - image.getScaledWidth()) / 2.0f) + f10;
                            }
                            left2 = f6;
                            top = (pdfPCell.getTop() + f2) - pdfPCell.getEffectivePaddingTop();
                        }
                        image.setAbsolutePosition(left2, top - image.getScaledHeight());
                        try {
                            pdfContentByteArr2[3].addImage(image);
                        } catch (DocumentException e) {
                            throw new ExceptionConverter(e);
                        }
                    } else if (pdfPCell.getRotation() == 90 || pdfPCell.getRotation() == 270) {
                        float effectivePaddingTop = (f11 - pdfPCell.getEffectivePaddingTop()) - pdfPCell.getEffectivePaddingBottom();
                        float width = (pdfPCell.getWidth() - pdfPCell.getEffectivePaddingLeft()) - pdfPCell.getEffectivePaddingRight();
                        ColumnText duplicate = ColumnText.duplicate(pdfPCell.getColumn());
                        duplicate.setCanvases(pdfContentByteArr2);
                        duplicate.setSimpleColumn(0.0f, 0.0f, 0.001f + effectivePaddingTop, -width);
                        try {
                            duplicate.mo52495go(true);
                            float f12 = -duplicate.getYLine();
                            if (effectivePaddingTop <= 0.0f || width <= 0.0f) {
                                f12 = 0.0f;
                            }
                            if (f12 > 0.0f) {
                                if (pdfPCell.isUseDescender()) {
                                    f12 -= duplicate.getDescender();
                                }
                                ColumnText duplicate2 = ColumnText.duplicate(pdfPCell.getColumn());
                                duplicate2.setCanvases(pdfContentByteArr2);
                                duplicate2.setSimpleColumn(-0.003f, -0.001f, effectivePaddingTop + 0.003f, f12);
                                if (pdfPCell.getRotation() == 90) {
                                    float top2 = ((pdfPCell.getTop() + f2) - f11) + pdfPCell.getEffectivePaddingBottom();
                                    int verticalAlignment2 = pdfPCell.getVerticalAlignment();
                                    if (verticalAlignment2 != 5) {
                                        left = verticalAlignment2 != 6 ? pdfPCell.getLeft() + f10 + pdfPCell.getEffectivePaddingLeft() + f12 : ((pdfPCell.getLeft() + f10) + pdfPCell.getWidth()) - pdfPCell.getEffectivePaddingRight();
                                    } else {
                                        left = pdfPCell.getLeft() + f10 + ((((pdfPCell.getWidth() + pdfPCell.getEffectivePaddingLeft()) - pdfPCell.getEffectivePaddingRight()) + f12) / 2.0f);
                                    }
                                    saveAndRotateCanvases(pdfContentByteArr, 0.0f, 1.0f, -1.0f, 0.0f, left, top2);
                                } else {
                                    float top3 = (pdfPCell.getTop() + f2) - pdfPCell.getEffectivePaddingTop();
                                    int verticalAlignment3 = pdfPCell.getVerticalAlignment();
                                    if (verticalAlignment3 == 5) {
                                        f4 = pdfPCell.getLeft() + f10;
                                        f3 = (((pdfPCell.getWidth() + pdfPCell.getEffectivePaddingLeft()) - pdfPCell.getEffectivePaddingRight()) - f12) / 2.0f;
                                        f5 = f4 + f3;
                                    } else if (verticalAlignment3 != 6) {
                                        f5 = (((pdfPCell.getLeft() + f10) + pdfPCell.getWidth()) - pdfPCell.getEffectivePaddingRight()) - f12;
                                    } else {
                                        f4 = pdfPCell.getLeft() + f10;
                                        f3 = pdfPCell.getEffectivePaddingLeft();
                                        f5 = f4 + f3;
                                    }
                                    saveAndRotateCanvases(pdfContentByteArr, 0.0f, -1.0f, 1.0f, 0.0f, f5, top3);
                                }
                                try {
                                    duplicate2.mo52494go();
                                    restoreCanvases(pdfContentByteArr2);
                                } catch (DocumentException e2) {
                                    throw new ExceptionConverter(e2);
                                } catch (Throwable th) {
                                    restoreCanvases(pdfContentByteArr2);
                                    throw th;
                                }
                            }
                        } catch (DocumentException e3) {
                            throw new ExceptionConverter(e3);
                        }
                    } else {
                        float fixedHeight = pdfPCell.getFixedHeight();
                        float right = (pdfPCell.getRight() + f10) - pdfPCell.getEffectivePaddingRight();
                        float left3 = pdfPCell.getLeft() + f10 + pdfPCell.getEffectivePaddingLeft();
                        if (pdfPCell.isNoWrap()) {
                            int horizontalAlignment2 = pdfPCell.getHorizontalAlignment();
                            if (horizontalAlignment2 == 1) {
                                right += 10000.0f;
                                left3 -= 10000.0f;
                            } else if (horizontalAlignment2 == 2 ? pdfPCell.getRotation() != 180 : pdfPCell.getRotation() == 180) {
                                left3 -= 20000.0f;
                            } else {
                                right += 20000.0f;
                            }
                        }
                        ColumnText duplicate3 = ColumnText.duplicate(pdfPCell.getColumn());
                        duplicate3.setCanvases(pdfContentByteArr2);
                        float effectivePaddingTop2 = top - ((f11 - pdfPCell.getEffectivePaddingTop()) - pdfPCell.getEffectivePaddingBottom());
                        if (fixedHeight > 0.0f && pdfPCell.getHeight() > f11) {
                            top = (pdfPCell.getTop() + f2) - pdfPCell.getEffectivePaddingTop();
                            effectivePaddingTop2 = pdfPCell.getEffectivePaddingBottom() + ((pdfPCell.getTop() + f2) - f11);
                        }
                        if ((top > effectivePaddingTop2 || duplicate3.zeroHeightElement()) && left3 < right) {
                            duplicate3.setSimpleColumn(left3, effectivePaddingTop2 - 0.001f, right, top);
                            if (pdfPCell.getRotation() == 180) {
                                columnText = duplicate3;
                                saveAndRotateCanvases(pdfContentByteArr, -1.0f, 0.0f, 0.0f, -1.0f, left3 + right, (((f2 + f2) - f11) + pdfPCell.getEffectivePaddingBottom()) - pdfPCell.getEffectivePaddingTop());
                            } else {
                                columnText = duplicate3;
                            }
                            try {
                                columnText.mo52494go();
                                if (pdfPCell.getRotation() == 180) {
                                    restoreCanvases(pdfContentByteArr2);
                                }
                            } catch (DocumentException e4) {
                                throw new ExceptionConverter(e4);
                            } catch (Throwable th2) {
                                if (pdfPCell.getRotation() == 180) {
                                    restoreCanvases(pdfContentByteArr2);
                                }
                                throw th2;
                            }
                        }
                    }
                    PdfPCellEvent cellEvent = pdfPCell.getCellEvent();
                    if (cellEvent != null) {
                        cellEvent.cellLayout(pdfPCell, new Rectangle(pdfPCell.getLeft() + f10, (pdfPCell.getTop() + f2) - f11, pdfPCell.getRight() + f10, pdfPCell.getTop() + f2), pdfContentByteArr2);
                    }
                }
            }
        }
    }

    public boolean isCalculated() {
        return this.calculated;
    }

    public float getMaxHeights() {
        if (this.calculated) {
            return this.maxHeight;
        }
        return calculateHeights();
    }

    public void setMaxHeights(float f) {
        this.maxHeight = f;
    }

    /* access modifiers changed from: package-private */
    public float[] getEventWidth(float f) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            PdfPCell[] pdfPCellArr = this.cells;
            if (i2 >= pdfPCellArr.length) {
                break;
            }
            if (pdfPCellArr[i2] != null) {
                i3++;
            }
            i2++;
        }
        int i4 = 1;
        float[] fArr = new float[(i3 + 1)];
        fArr[0] = f;
        while (true) {
            PdfPCell[] pdfPCellArr2 = this.cells;
            if (i >= pdfPCellArr2.length) {
                return fArr;
            }
            if (pdfPCellArr2[i] != null) {
                fArr[i4] = fArr[i4 - 1] + pdfPCellArr2[i].getWidth();
                i4++;
            }
            i++;
        }
    }

    public PdfPRow splitRow(PdfPTable pdfPTable, int i, float f) {
        boolean z;
        float f2;
        PdfPRow pdfPRow = this;
        PdfPTable pdfPTable2 = pdfPTable;
        int i2 = i;
        float f3 = f;
        PdfPCell[] pdfPCellArr = pdfPRow.cells;
        PdfPCell[] pdfPCellArr2 = new PdfPCell[pdfPCellArr.length];
        float[] fArr = new float[pdfPCellArr.length];
        float[] fArr2 = new float[pdfPCellArr.length];
        int i3 = 0;
        boolean z2 = true;
        while (true) {
            PdfPCell[] pdfPCellArr3 = pdfPRow.cells;
            if (i3 >= pdfPCellArr3.length) {
                break;
            }
            PdfPCell pdfPCell = pdfPCellArr3[i3];
            if (pdfPCell != null) {
                fArr[i3] = pdfPCell.getFixedHeight();
                fArr2[i3] = pdfPCell.getMinimumHeight();
                Image image = pdfPCell.getImage();
                PdfPCell pdfPCell2 = new PdfPCell(pdfPCell);
                if (image == null) {
                    ColumnText duplicate = ColumnText.duplicate(pdfPCell.getColumn());
                    float left = pdfPCell.getLeft() + pdfPCell.getEffectivePaddingLeft();
                    float top = (pdfPCell.getTop() + pdfPCell.getEffectivePaddingBottom()) - f3;
                    float right = pdfPCell.getRight() - pdfPCell.getEffectivePaddingRight();
                    float top2 = pdfPCell.getTop() - pdfPCell.getEffectivePaddingTop();
                    int rotation = pdfPCell.getRotation();
                    if (rotation == 90 || rotation == 270) {
                        f2 = setColumn(duplicate, top, left, top2, right);
                    } else {
                        if (pdfPCell.isNoWrap()) {
                            right = 20000.0f;
                        }
                        f2 = setColumn(duplicate, left, top, right, top2);
                    }
                    try {
                        int go = duplicate.mo52495go(true);
                        boolean z3 = duplicate.getYLine() == f2;
                        if (z3) {
                            pdfPCell2.setColumn(ColumnText.duplicate(pdfPCell.getColumn()));
                            duplicate.setFilledWidth(0.0f);
                        } else if ((go & 1) == 0) {
                            pdfPCell2.setColumn(duplicate);
                            duplicate.setFilledWidth(0.0f);
                        } else {
                            pdfPCell2.setPhrase((Phrase) null);
                        }
                        z = z2 && z3;
                    } catch (DocumentException e) {
                        throw new ExceptionConverter(e);
                    }
                } else if (f3 > pdfPCell.getEffectivePaddingBottom() + pdfPCell.getEffectivePaddingTop() + 2.0f) {
                    pdfPCell2.setPhrase((Phrase) null);
                    z = false;
                } else {
                    z = z2;
                }
                pdfPCellArr2[i3] = pdfPCell2;
                pdfPCell.setFixedHeight(f3);
                z2 = z;
            } else if (pdfPTable2.rowSpanAbove(i2, i3)) {
                float rowHeight = pdfPTable.getRowHeight(i) + f3;
                int i4 = i2;
                while (true) {
                    i4--;
                    if (!pdfPTable2.rowSpanAbove(i4, i3)) {
                        break;
                    }
                    rowHeight += pdfPTable2.getRowHeight(i4);
                }
                PdfPRow row = pdfPTable2.getRow(i4);
                if (!(row == null || row.getCells()[i3] == null)) {
                    pdfPCellArr2[i3] = new PdfPCell(row.getCells()[i3]);
                    pdfPCellArr2[i3].consumeHeight(rowHeight);
                    pdfPCellArr2[i3].setRowspan((row.getCells()[i3].getRowspan() - i2) + i4);
                    z2 = false;
                }
            }
            i3++;
            pdfPRow = this;
            pdfPTable2 = pdfPTable;
        }
        if (z2) {
            int i5 = 0;
            while (true) {
                PdfPCell[] pdfPCellArr4 = pdfPRow.cells;
                if (i5 >= pdfPCellArr4.length) {
                    return null;
                }
                PdfPCell pdfPCell3 = pdfPCellArr4[i5];
                if (pdfPCell3 != null) {
                    if (fArr[i5] > 0.0f) {
                        pdfPCell3.setFixedHeight(fArr[i5]);
                    } else {
                        pdfPCell3.setMinimumHeight(fArr2[i5]);
                    }
                }
                i5++;
            }
        } else {
            calculateHeights();
            PdfPRow pdfPRow2 = new PdfPRow(pdfPCellArr2);
            pdfPRow2.widths = (float[]) pdfPRow.widths.clone();
            pdfPRow2.calculateHeights();
            return pdfPRow2;
        }
    }

    public PdfPCell[] getCells() {
        return this.cells;
    }
}
