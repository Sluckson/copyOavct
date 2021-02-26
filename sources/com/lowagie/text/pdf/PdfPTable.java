package com.lowagie.text.pdf;

import com.lowagie.text.DocumentException;
import com.lowagie.text.ElementListener;
import com.lowagie.text.Image;
import com.lowagie.text.LargeElement;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.events.PdfPTableEventForwarder;
import java.util.ArrayList;

public class PdfPTable implements LargeElement {
    public static final int BACKGROUNDCANVAS = 1;
    public static final int BASECANVAS = 0;
    public static final int LINECANVAS = 2;
    public static final int TEXTCANVAS = 3;
    protected float[] absoluteWidths;
    protected boolean complete;
    protected PdfPCell[] currentRow;
    protected int currentRowIdx;
    protected PdfPCell defaultCell;
    private boolean extendLastRow;
    private int footerRows;
    protected int headerRows;
    private boolean headersInEvent;
    private int horizontalAlignment;
    protected boolean isColspan;
    private boolean keepTogether;
    private boolean lockedWidth;
    protected float[] relativeWidths;
    protected boolean rowCompleted;
    protected ArrayList rows;
    protected int runDirection;
    private boolean skipFirstHeader;
    private boolean skipLastFooter;
    protected float spacingAfter;
    protected float spacingBefore;
    private boolean splitLate;
    private boolean splitRows;
    protected PdfPTableEvent tableEvent;
    protected float totalHeight;
    protected float totalWidth;
    protected float widthPercentage;

    public boolean isContent() {
        return true;
    }

    public boolean isNestable() {
        return true;
    }

    public int type() {
        return 23;
    }

    protected PdfPTable() {
        this.rows = new ArrayList();
        this.totalHeight = 0.0f;
        this.currentRowIdx = 0;
        this.defaultCell = new PdfPCell((Phrase) null);
        this.totalWidth = 0.0f;
        this.widthPercentage = 80.0f;
        this.horizontalAlignment = 1;
        this.skipFirstHeader = false;
        this.skipLastFooter = false;
        this.isColspan = false;
        this.runDirection = 0;
        this.lockedWidth = false;
        this.splitRows = true;
        this.splitLate = true;
        this.complete = true;
        this.rowCompleted = true;
    }

    public PdfPTable(float[] fArr) {
        this.rows = new ArrayList();
        this.totalHeight = 0.0f;
        this.currentRowIdx = 0;
        this.defaultCell = new PdfPCell((Phrase) null);
        this.totalWidth = 0.0f;
        this.widthPercentage = 80.0f;
        this.horizontalAlignment = 1;
        this.skipFirstHeader = false;
        this.skipLastFooter = false;
        this.isColspan = false;
        this.runDirection = 0;
        this.lockedWidth = false;
        this.splitRows = true;
        this.splitLate = true;
        this.complete = true;
        this.rowCompleted = true;
        if (fArr == null) {
            throw new NullPointerException("The widths array in PdfPTable constructor can not be null.");
        } else if (fArr.length != 0) {
            this.relativeWidths = new float[fArr.length];
            System.arraycopy(fArr, 0, this.relativeWidths, 0, fArr.length);
            this.absoluteWidths = new float[fArr.length];
            calculateWidths();
            this.currentRow = new PdfPCell[this.absoluteWidths.length];
            this.keepTogether = false;
        } else {
            throw new IllegalArgumentException("The widths array in PdfPTable constructor can not have zero length.");
        }
    }

    public PdfPTable(int i) {
        this.rows = new ArrayList();
        this.totalHeight = 0.0f;
        this.currentRowIdx = 0;
        this.defaultCell = new PdfPCell((Phrase) null);
        this.totalWidth = 0.0f;
        this.widthPercentage = 80.0f;
        this.horizontalAlignment = 1;
        this.skipFirstHeader = false;
        this.skipLastFooter = false;
        this.isColspan = false;
        this.runDirection = 0;
        this.lockedWidth = false;
        this.splitRows = true;
        this.splitLate = true;
        this.complete = true;
        this.rowCompleted = true;
        if (i > 0) {
            this.relativeWidths = new float[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.relativeWidths[i2] = 1.0f;
            }
            this.absoluteWidths = new float[this.relativeWidths.length];
            calculateWidths();
            this.currentRow = new PdfPCell[this.absoluteWidths.length];
            this.keepTogether = false;
            return;
        }
        throw new IllegalArgumentException("The number of columns in PdfPTable constructor must be greater than zero.");
    }

    public PdfPTable(PdfPTable pdfPTable) {
        this.rows = new ArrayList();
        this.totalHeight = 0.0f;
        this.currentRowIdx = 0;
        this.defaultCell = new PdfPCell((Phrase) null);
        this.totalWidth = 0.0f;
        this.widthPercentage = 80.0f;
        this.horizontalAlignment = 1;
        this.skipFirstHeader = false;
        this.skipLastFooter = false;
        this.isColspan = false;
        this.runDirection = 0;
        this.lockedWidth = false;
        this.splitRows = true;
        this.splitLate = true;
        this.complete = true;
        this.rowCompleted = true;
        copyFormat(pdfPTable);
        int i = 0;
        while (true) {
            PdfPCell[] pdfPCellArr = this.currentRow;
            if (i >= pdfPCellArr.length) {
                break;
            }
            PdfPCell[] pdfPCellArr2 = pdfPTable.currentRow;
            if (pdfPCellArr2[i] == null) {
                break;
            }
            pdfPCellArr[i] = new PdfPCell(pdfPCellArr2[i]);
            i++;
        }
        for (int i2 = 0; i2 < pdfPTable.rows.size(); i2++) {
            PdfPRow pdfPRow = (PdfPRow) pdfPTable.rows.get(i2);
            if (pdfPRow != null) {
                pdfPRow = new PdfPRow(pdfPRow);
            }
            this.rows.add(pdfPRow);
        }
    }

    public static PdfPTable shallowCopy(PdfPTable pdfPTable) {
        PdfPTable pdfPTable2 = new PdfPTable();
        pdfPTable2.copyFormat(pdfPTable);
        return pdfPTable2;
    }

    /* access modifiers changed from: protected */
    public void copyFormat(PdfPTable pdfPTable) {
        this.relativeWidths = new float[pdfPTable.getNumberOfColumns()];
        this.absoluteWidths = new float[pdfPTable.getNumberOfColumns()];
        System.arraycopy(pdfPTable.relativeWidths, 0, this.relativeWidths, 0, getNumberOfColumns());
        System.arraycopy(pdfPTable.absoluteWidths, 0, this.absoluteWidths, 0, getNumberOfColumns());
        this.totalWidth = pdfPTable.totalWidth;
        this.totalHeight = pdfPTable.totalHeight;
        this.currentRowIdx = 0;
        this.tableEvent = pdfPTable.tableEvent;
        this.runDirection = pdfPTable.runDirection;
        this.defaultCell = new PdfPCell(pdfPTable.defaultCell);
        this.currentRow = new PdfPCell[pdfPTable.currentRow.length];
        this.isColspan = pdfPTable.isColspan;
        this.splitRows = pdfPTable.splitRows;
        this.spacingAfter = pdfPTable.spacingAfter;
        this.spacingBefore = pdfPTable.spacingBefore;
        this.headerRows = pdfPTable.headerRows;
        this.footerRows = pdfPTable.footerRows;
        this.lockedWidth = pdfPTable.lockedWidth;
        this.extendLastRow = pdfPTable.extendLastRow;
        this.headersInEvent = pdfPTable.headersInEvent;
        this.widthPercentage = pdfPTable.widthPercentage;
        this.splitLate = pdfPTable.splitLate;
        this.skipFirstHeader = pdfPTable.skipFirstHeader;
        this.skipLastFooter = pdfPTable.skipLastFooter;
        this.horizontalAlignment = pdfPTable.horizontalAlignment;
        this.keepTogether = pdfPTable.keepTogether;
        this.complete = pdfPTable.complete;
    }

    public void setWidths(float[] fArr) throws DocumentException {
        if (fArr.length == getNumberOfColumns()) {
            this.relativeWidths = new float[fArr.length];
            System.arraycopy(fArr, 0, this.relativeWidths, 0, fArr.length);
            this.absoluteWidths = new float[fArr.length];
            this.totalHeight = 0.0f;
            calculateWidths();
            calculateHeights(true);
            return;
        }
        throw new DocumentException("Wrong number of columns.");
    }

    public void setWidths(int[] iArr) throws DocumentException {
        float[] fArr = new float[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            fArr[i] = (float) iArr[i];
        }
        setWidths(fArr);
    }

    /* access modifiers changed from: protected */
    public void calculateWidths() {
        if (this.totalWidth > 0.0f) {
            int numberOfColumns = getNumberOfColumns();
            float f = 0.0f;
            for (int i = 0; i < numberOfColumns; i++) {
                f += this.relativeWidths[i];
            }
            for (int i2 = 0; i2 < numberOfColumns; i2++) {
                this.absoluteWidths[i2] = (this.totalWidth * this.relativeWidths[i2]) / f;
            }
        }
    }

    public void setTotalWidth(float f) {
        if (this.totalWidth != f) {
            this.totalWidth = f;
            this.totalHeight = 0.0f;
            calculateWidths();
            calculateHeights(true);
        }
    }

    public void setTotalWidth(float[] fArr) throws DocumentException {
        if (fArr.length == getNumberOfColumns()) {
            this.totalWidth = 0.0f;
            for (int i = 0; i < fArr.length; i++) {
                this.totalWidth += fArr[i];
            }
            setWidths(fArr);
            return;
        }
        throw new DocumentException("Wrong number of columns.");
    }

    public void setWidthPercentage(float[] fArr, Rectangle rectangle) throws DocumentException {
        if (fArr.length == getNumberOfColumns()) {
            float f = 0.0f;
            for (float f2 : fArr) {
                f += f2;
            }
            this.widthPercentage = (f / (rectangle.getRight() - rectangle.getLeft())) * 100.0f;
            setWidths(fArr);
            return;
        }
        throw new IllegalArgumentException("Wrong number of columns.");
    }

    public float getTotalWidth() {
        return this.totalWidth;
    }

    public float calculateHeights(boolean z) {
        if (this.totalWidth <= 0.0f) {
            return 0.0f;
        }
        this.totalHeight = 0.0f;
        for (int i = 0; i < this.rows.size(); i++) {
            this.totalHeight += getRowHeight(i, z);
        }
        return this.totalHeight;
    }

    public void calculateHeightsFast() {
        calculateHeights(false);
    }

    public PdfPCell getDefaultCell() {
        return this.defaultCell;
    }

    public void addCell(PdfPCell pdfPCell) {
        boolean z;
        this.rowCompleted = false;
        PdfPCell pdfPCell2 = new PdfPCell(pdfPCell);
        int min = Math.min(Math.max(pdfPCell2.getColspan(), 1), this.currentRow.length - this.currentRowIdx);
        pdfPCell2.setColspan(min);
        if (min != 1) {
            this.isColspan = true;
        }
        if (pdfPCell2.getRunDirection() == 0) {
            pdfPCell2.setRunDirection(this.runDirection);
        }
        skipColsWithRowspanAbove();
        int i = this.currentRowIdx;
        PdfPCell[] pdfPCellArr = this.currentRow;
        if (i < pdfPCellArr.length) {
            pdfPCellArr[i] = pdfPCell2;
            this.currentRowIdx = i + min;
            z = true;
        } else {
            z = false;
        }
        skipColsWithRowspanAbove();
        if (this.currentRowIdx >= this.currentRow.length) {
            int numberOfColumns = getNumberOfColumns();
            if (this.runDirection == 3) {
                PdfPCell[] pdfPCellArr2 = new PdfPCell[numberOfColumns];
                int length = this.currentRow.length;
                int i2 = 0;
                while (true) {
                    PdfPCell[] pdfPCellArr3 = this.currentRow;
                    if (i2 >= pdfPCellArr3.length) {
                        break;
                    }
                    PdfPCell pdfPCell3 = pdfPCellArr3[i2];
                    int colspan = pdfPCell3.getColspan();
                    length -= colspan;
                    pdfPCellArr2[length] = pdfPCell3;
                    i2 = i2 + (colspan - 1) + 1;
                }
                this.currentRow = pdfPCellArr2;
            }
            PdfPRow pdfPRow = new PdfPRow(this.currentRow);
            if (this.totalWidth > 0.0f) {
                pdfPRow.setWidths(this.absoluteWidths);
                this.totalHeight += pdfPRow.getMaxHeights();
            }
            this.rows.add(pdfPRow);
            this.currentRow = new PdfPCell[numberOfColumns];
            this.currentRowIdx = 0;
            this.rowCompleted = true;
        }
        if (!z) {
            PdfPCell[] pdfPCellArr4 = this.currentRow;
            int i3 = this.currentRowIdx;
            pdfPCellArr4[i3] = pdfPCell2;
            this.currentRowIdx = i3 + min;
        }
    }

    private void skipColsWithRowspanAbove() {
        int i = this.runDirection == 3 ? -1 : 1;
        while (rowSpanAbove(this.rows.size(), this.currentRowIdx)) {
            this.currentRowIdx += i;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean rowSpanAbove(int i, int i2) {
        PdfPCell pdfPCell;
        if (i2 < getNumberOfColumns() && i2 >= 0 && i != 0) {
            int i3 = i - 1;
            PdfPRow pdfPRow = (PdfPRow) this.rows.get(i3);
            if (pdfPRow == null) {
                return false;
            }
            PdfPCell pdfPCell2 = pdfPRow.getCells()[i2];
            while (pdfPCell == null && i3 > 0) {
                i3--;
                pdfPRow = (PdfPRow) this.rows.get(i3);
                if (pdfPRow == null) {
                    return false;
                }
                pdfPCell2 = pdfPRow.getCells()[i2];
            }
            int i4 = i - i3;
            if (pdfPCell == null) {
                int i5 = i2 - 1;
                PdfPCell pdfPCell3 = pdfPRow.getCells()[i5];
                while (pdfPCell3 == null && i3 > 0) {
                    i5--;
                    pdfPCell3 = pdfPRow.getCells()[i5];
                }
                if (pdfPCell3 == null || pdfPCell3.getRowspan() <= i4) {
                    return false;
                }
                return true;
            }
            if (pdfPCell.getRowspan() == 1 && i4 > 1) {
                int i6 = i2 - 1;
                PdfPRow pdfPRow2 = (PdfPRow) this.rows.get(i3 + 1);
                i4--;
                pdfPCell = pdfPRow2.getCells()[i6];
                while (pdfPCell == null && i6 > 0) {
                    i6--;
                    pdfPCell = pdfPRow2.getCells()[i6];
                }
            }
            if (pdfPCell == null || pdfPCell.getRowspan() <= i4) {
                return false;
            }
            return true;
        }
        return false;
    }

    public void addCell(String str) {
        addCell(new Phrase(str));
    }

    public void addCell(PdfPTable pdfPTable) {
        this.defaultCell.setTable(pdfPTable);
        addCell(this.defaultCell);
        this.defaultCell.setTable((PdfPTable) null);
    }

    public void addCell(Image image) {
        this.defaultCell.setImage(image);
        addCell(this.defaultCell);
        this.defaultCell.setImage((Image) null);
    }

    public void addCell(Phrase phrase) {
        this.defaultCell.setPhrase(phrase);
        addCell(this.defaultCell);
        this.defaultCell.setPhrase((Phrase) null);
    }

    public float writeSelectedRows(int i, int i2, float f, float f2, PdfContentByte[] pdfContentByteArr) {
        return writeSelectedRows(0, -1, i, i2, f, f2, pdfContentByteArr);
    }

    public float writeSelectedRows(int i, int i2, int i3, int i4, float f, float f2, PdfContentByte[] pdfContentByteArr) {
        int i5;
        int i6;
        int i7 = i;
        int i8 = i2;
        int i9 = i4;
        if (this.totalWidth > 0.0f) {
            int size = this.rows.size();
            int i10 = i3 < 0 ? 0 : i3;
            if (i9 >= 0) {
                size = Math.min(i9, size);
            }
            if (i10 >= size) {
                return f2;
            }
            int numberOfColumns = getNumberOfColumns();
            if (i7 < 0) {
                i5 = 0;
            } else {
                i5 = Math.min(i7, numberOfColumns);
            }
            if (i8 < 0) {
                i6 = numberOfColumns;
            } else {
                i6 = Math.min(i8, numberOfColumns);
            }
            float f3 = f2;
            for (int i11 = i10; i11 < size; i11++) {
                float f4 = f;
                PdfPRow pdfPRow = (PdfPRow) this.rows.get(i11);
                if (pdfPRow != null) {
                    pdfPRow.writeCells(i5, i6, f, f3, pdfContentByteArr);
                    f3 -= pdfPRow.getMaxHeights();
                }
            }
            if (this.tableEvent != null && i5 == 0 && i6 == numberOfColumns) {
                float[] fArr = new float[((size - i10) + 1)];
                fArr[0] = f2;
                for (int i12 = i10; i12 < size; i12++) {
                    float f5 = f;
                    PdfPRow pdfPRow2 = (PdfPRow) this.rows.get(i12);
                    int i13 = i12 - i10;
                    fArr[i13 + 1] = fArr[i13] - (pdfPRow2 != null ? pdfPRow2.getMaxHeights() : 0.0f);
                }
                this.tableEvent.tableLayout(this, getEventWidths(f, i10, size, this.headersInEvent), fArr, this.headersInEvent ? this.headerRows : 0, i10, pdfContentByteArr);
            }
            return f3;
        }
        throw new RuntimeException("The table width must be greater than zero.");
    }

    public float writeSelectedRows(int i, int i2, float f, float f2, PdfContentByte pdfContentByte) {
        return writeSelectedRows(0, -1, i, i2, f, f2, pdfContentByte);
    }

    public float writeSelectedRows(int i, int i2, int i3, int i4, float f, float f2, PdfContentByte pdfContentByte) {
        int i5;
        int i6;
        int i7 = i;
        int i8 = i2;
        int numberOfColumns = getNumberOfColumns();
        if (i7 < 0) {
            i5 = 0;
        } else {
            i5 = Math.min(i, numberOfColumns);
        }
        if (i8 < 0) {
            i6 = numberOfColumns;
        } else {
            i6 = Math.min(i8, numberOfColumns);
        }
        boolean z = (i5 == 0 && i6 == numberOfColumns) ? false : true;
        if (z) {
            float f3 = 0.0f;
            for (int i9 = i5; i9 < i6; i9++) {
                PdfContentByte pdfContentByte2 = pdfContentByte;
                f3 += this.absoluteWidths[i9];
            }
            pdfContentByte.saveState();
            int i10 = 10000;
            float f4 = (float) (i5 == 0 ? 10000 : 0);
            if (i6 != numberOfColumns) {
                i10 = 0;
            }
            pdfContentByte.rectangle(f - f4, -10000.0f, f3 + f4 + ((float) i10), 20000.0f);
            pdfContentByte.clip();
            pdfContentByte.newPath();
        } else {
            PdfContentByte pdfContentByte3 = pdfContentByte;
        }
        PdfContentByte[] beginWritingRows = beginWritingRows(pdfContentByte);
        float writeSelectedRows = writeSelectedRows(i5, i6, i3, i4, f, f2, beginWritingRows);
        endWritingRows(beginWritingRows);
        if (z) {
            pdfContentByte.restoreState();
        }
        return writeSelectedRows;
    }

    public static PdfContentByte[] beginWritingRows(PdfContentByte pdfContentByte) {
        return new PdfContentByte[]{pdfContentByte, pdfContentByte.getDuplicate(), pdfContentByte.getDuplicate(), pdfContentByte.getDuplicate()};
    }

    public static void endWritingRows(PdfContentByte[] pdfContentByteArr) {
        PdfContentByte pdfContentByte = pdfContentByteArr[0];
        pdfContentByte.saveState();
        pdfContentByte.add(pdfContentByteArr[1]);
        pdfContentByte.restoreState();
        pdfContentByte.saveState();
        pdfContentByte.setLineCap(2);
        pdfContentByte.resetRGBColorStroke();
        pdfContentByte.add(pdfContentByteArr[2]);
        pdfContentByte.restoreState();
        pdfContentByte.add(pdfContentByteArr[3]);
    }

    public int size() {
        return this.rows.size();
    }

    public float getTotalHeight() {
        return this.totalHeight;
    }

    public float getRowHeight(int i) {
        return getRowHeight(i, false);
    }

    public float getRowHeight(int i, boolean z) {
        PdfPRow pdfPRow;
        int i2;
        float f;
        if (this.totalWidth <= 0.0f || i < 0 || i >= this.rows.size() || (pdfPRow = (PdfPRow) this.rows.get(i)) == null) {
            return 0.0f;
        }
        if (z) {
            pdfPRow.setWidths(this.absoluteWidths);
        }
        float maxHeights = pdfPRow.getMaxHeights();
        for (int i3 = 0; i3 < this.relativeWidths.length; i3++) {
            if (rowSpanAbove(i, i3)) {
                int i4 = 1;
                while (true) {
                    i2 = i - i4;
                    if (!rowSpanAbove(i2, i3)) {
                        break;
                    }
                    i4++;
                }
                PdfPCell pdfPCell = ((PdfPRow) this.rows.get(i2)).getCells()[i3];
                if (pdfPCell.getRowspan() == i4 + 1) {
                    f = pdfPCell.getMaxHeight();
                    while (i4 > 0) {
                        f -= getRowHeight(i - i4);
                        i4--;
                    }
                } else {
                    f = 0.0f;
                }
                if (f > maxHeights) {
                    maxHeights = f;
                }
            }
        }
        pdfPRow.setMaxHeights(maxHeights);
        return maxHeights;
    }

    public float getRowspanHeight(int i, int i2) {
        PdfPRow pdfPRow;
        PdfPCell pdfPCell;
        float f = 0.0f;
        if (this.totalWidth <= 0.0f || i < 0 || i >= this.rows.size() || (pdfPRow = (PdfPRow) this.rows.get(i)) == null || i2 >= pdfPRow.getCells().length || (pdfPCell = pdfPRow.getCells()[i2]) == null) {
            return 0.0f;
        }
        for (int i3 = 0; i3 < pdfPCell.getRowspan(); i3++) {
            f += getRowHeight(i + i3);
        }
        return f;
    }

    public float getHeaderHeight() {
        int min = Math.min(this.rows.size(), this.headerRows);
        float f = 0.0f;
        for (int i = 0; i < min; i++) {
            PdfPRow pdfPRow = (PdfPRow) this.rows.get(i);
            if (pdfPRow != null) {
                f += pdfPRow.getMaxHeights();
            }
        }
        return f;
    }

    public float getFooterHeight() {
        int min = Math.min(this.rows.size(), this.headerRows);
        float f = 0.0f;
        for (int max = Math.max(0, this.headerRows - this.footerRows); max < min; max++) {
            PdfPRow pdfPRow = (PdfPRow) this.rows.get(max);
            if (pdfPRow != null) {
                f += pdfPRow.getMaxHeights();
            }
        }
        return f;
    }

    public boolean deleteRow(int i) {
        PdfPRow pdfPRow;
        if (i < 0 || i >= this.rows.size()) {
            return false;
        }
        if (this.totalWidth > 0.0f && (pdfPRow = (PdfPRow) this.rows.get(i)) != null) {
            this.totalHeight -= pdfPRow.getMaxHeights();
        }
        this.rows.remove(i);
        int i2 = this.headerRows;
        if (i < i2) {
            this.headerRows = i2 - 1;
            int i3 = this.headerRows;
            int i4 = this.footerRows;
            if (i >= i3 - i4) {
                this.footerRows = i4 - 1;
            }
        }
        return true;
    }

    public boolean deleteLastRow() {
        return deleteRow(this.rows.size() - 1);
    }

    public void deleteBodyRows() {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.headerRows; i++) {
            arrayList.add(this.rows.get(i));
        }
        this.rows = arrayList;
        this.totalHeight = 0.0f;
        if (this.totalWidth > 0.0f) {
            this.totalHeight = getHeaderHeight();
        }
    }

    public int getNumberOfColumns() {
        return this.relativeWidths.length;
    }

    public int getHeaderRows() {
        return this.headerRows;
    }

    public void setHeaderRows(int i) {
        if (i < 0) {
            i = 0;
        }
        this.headerRows = i;
    }

    public ArrayList getChunks() {
        return new ArrayList();
    }

    public boolean process(ElementListener elementListener) {
        try {
            return elementListener.add(this);
        } catch (DocumentException unused) {
            return false;
        }
    }

    public float getWidthPercentage() {
        return this.widthPercentage;
    }

    public void setWidthPercentage(float f) {
        this.widthPercentage = f;
    }

    public int getHorizontalAlignment() {
        return this.horizontalAlignment;
    }

    public void setHorizontalAlignment(int i) {
        this.horizontalAlignment = i;
    }

    public PdfPRow getRow(int i) {
        return (PdfPRow) this.rows.get(i);
    }

    public ArrayList getRows() {
        return this.rows;
    }

    public ArrayList getRows(int i, int i2) {
        PdfPCell pdfPCell;
        ArrayList arrayList = new ArrayList();
        if (i < 0 || i2 > size()) {
            return arrayList;
        }
        PdfPRow adjustCellsInRow = adjustCellsInRow(i, i2);
        int i3 = 0;
        while (i3 < getNumberOfColumns()) {
            int i4 = i;
            while (true) {
                int i5 = i4 - 1;
                if (!rowSpanAbove(i4, i3)) {
                    break;
                }
                PdfPRow row = getRow(i5);
                if (!(row == null || (pdfPCell = row.getCells()[i3]) == null)) {
                    adjustCellsInRow.getCells()[i3] = new PdfPCell(pdfPCell);
                    float f = 0.0f;
                    int min = Math.min(pdfPCell.getRowspan() + i5, i2);
                    for (int i6 = i + 1; i6 < min; i6++) {
                        f += getRowHeight(i6);
                    }
                    adjustCellsInRow.setExtraHeight(i3, f);
                    adjustCellsInRow.getCells()[i3].consumeHeight((getRowspanHeight(i5, i3) - getRowHeight(i)) - f);
                }
                i4 = i5;
            }
            PdfPCell pdfPCell2 = adjustCellsInRow.getCells()[i3];
            if (pdfPCell2 == null) {
                i3++;
            } else {
                i3 += pdfPCell2.getColspan();
            }
        }
        arrayList.add(adjustCellsInRow);
        while (true) {
            i++;
            if (i >= i2) {
                return arrayList;
            }
            arrayList.add(adjustCellsInRow(i, i2));
        }
    }

    /* access modifiers changed from: protected */
    public PdfPRow adjustCellsInRow(int i, int i2) {
        PdfPRow pdfPRow = new PdfPRow(getRow(i));
        pdfPRow.initExtraHeights();
        PdfPCell[] cells = pdfPRow.getCells();
        for (int i3 = 0; i3 < cells.length; i3++) {
            PdfPCell pdfPCell = cells[i3];
            if (!(pdfPCell == null || pdfPCell.getRowspan() == 1)) {
                int min = Math.min(i2, pdfPCell.getRowspan() + i);
                float f = 0.0f;
                for (int i4 = 1 + i; i4 < min; i4++) {
                    f += getRowHeight(i4);
                }
                pdfPRow.setExtraHeight(i3, f);
            }
        }
        return pdfPRow;
    }

    public void setTableEvent(PdfPTableEvent pdfPTableEvent) {
        if (pdfPTableEvent == null) {
            this.tableEvent = null;
            return;
        }
        PdfPTableEvent pdfPTableEvent2 = this.tableEvent;
        if (pdfPTableEvent2 == null) {
            this.tableEvent = pdfPTableEvent;
        } else if (pdfPTableEvent2 instanceof PdfPTableEventForwarder) {
            ((PdfPTableEventForwarder) pdfPTableEvent2).addTableEvent(pdfPTableEvent);
        } else {
            PdfPTableEventForwarder pdfPTableEventForwarder = new PdfPTableEventForwarder();
            pdfPTableEventForwarder.addTableEvent(this.tableEvent);
            pdfPTableEventForwarder.addTableEvent(pdfPTableEvent);
            this.tableEvent = pdfPTableEventForwarder;
        }
    }

    public PdfPTableEvent getTableEvent() {
        return this.tableEvent;
    }

    public float[] getAbsoluteWidths() {
        return this.absoluteWidths;
    }

    /* access modifiers changed from: package-private */
    public float[][] getEventWidths(float f, int i, int i2, boolean z) {
        int i3;
        int i4;
        if (z) {
            i = Math.max(i, this.headerRows);
            i2 = Math.max(i2, this.headerRows);
        }
        int i5 = 0;
        float[][] fArr = new float[(((z ? this.headerRows : 0) + i2) - i)][];
        if (this.isColspan) {
            if (z) {
                i3 = 0;
                while (i5 < this.headerRows) {
                    PdfPRow pdfPRow = (PdfPRow) this.rows.get(i5);
                    if (pdfPRow == null) {
                        i3++;
                    } else {
                        fArr[i3] = pdfPRow.getEventWidth(f);
                        i3++;
                    }
                    i5++;
                }
            } else {
                i3 = 0;
            }
            while (i < i2) {
                PdfPRow pdfPRow2 = (PdfPRow) this.rows.get(i);
                if (pdfPRow2 == null) {
                    i4 = i3 + 1;
                } else {
                    fArr[i3] = pdfPRow2.getEventWidth(f);
                    i4 = i3 + 1;
                }
                i++;
            }
        } else {
            int numberOfColumns = getNumberOfColumns();
            float[] fArr2 = new float[(numberOfColumns + 1)];
            fArr2[0] = f;
            int i6 = 0;
            while (i6 < numberOfColumns) {
                int i7 = i6 + 1;
                fArr2[i7] = fArr2[i6] + this.absoluteWidths[i6];
                i6 = i7;
            }
            while (i5 < fArr.length) {
                fArr[i5] = fArr2;
                i5++;
            }
        }
        return fArr;
    }

    public boolean isSkipFirstHeader() {
        return this.skipFirstHeader;
    }

    public boolean isSkipLastFooter() {
        return this.skipLastFooter;
    }

    public void setSkipFirstHeader(boolean z) {
        this.skipFirstHeader = z;
    }

    public void setSkipLastFooter(boolean z) {
        this.skipLastFooter = z;
    }

    public void setRunDirection(int i) {
        if (i == 0 || i == 1 || i == 2 || i == 3) {
            this.runDirection = i;
            return;
        }
        throw new RuntimeException("Invalid run direction: " + i);
    }

    public int getRunDirection() {
        return this.runDirection;
    }

    public boolean isLockedWidth() {
        return this.lockedWidth;
    }

    public void setLockedWidth(boolean z) {
        this.lockedWidth = z;
    }

    public boolean isSplitRows() {
        return this.splitRows;
    }

    public void setSplitRows(boolean z) {
        this.splitRows = z;
    }

    public void setSpacingBefore(float f) {
        this.spacingBefore = f;
    }

    public void setSpacingAfter(float f) {
        this.spacingAfter = f;
    }

    public float spacingBefore() {
        return this.spacingBefore;
    }

    public float spacingAfter() {
        return this.spacingAfter;
    }

    public boolean isExtendLastRow() {
        return this.extendLastRow;
    }

    public void setExtendLastRow(boolean z) {
        this.extendLastRow = z;
    }

    public boolean isHeadersInEvent() {
        return this.headersInEvent;
    }

    public void setHeadersInEvent(boolean z) {
        this.headersInEvent = z;
    }

    public boolean isSplitLate() {
        return this.splitLate;
    }

    public void setSplitLate(boolean z) {
        this.splitLate = z;
    }

    public void setKeepTogether(boolean z) {
        this.keepTogether = z;
    }

    public boolean getKeepTogether() {
        return this.keepTogether;
    }

    public int getFooterRows() {
        return this.footerRows;
    }

    public void setFooterRows(int i) {
        if (i < 0) {
            i = 0;
        }
        this.footerRows = i;
    }

    public void completeRow() {
        while (!this.rowCompleted) {
            addCell(this.defaultCell);
        }
    }

    public void flushContent() {
        deleteBodyRows();
        setSkipFirstHeader(true);
    }

    public boolean isComplete() {
        return this.complete;
    }

    public void setComplete(boolean z) {
        this.complete = z;
    }
}
