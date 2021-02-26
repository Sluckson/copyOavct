package com.lowagie.text.pdf;

import com.lowagie.text.Cell;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Row;
import com.lowagie.text.Table;
import java.util.ArrayList;
import java.util.Iterator;

public class PdfTable extends Rectangle {
    private ArrayList cells = new ArrayList();
    private int columns;
    private ArrayList headercells = new ArrayList();
    protected float[] positions;
    protected Table table;

    public int type() {
        return 22;
    }

    PdfTable(Table table2, float f, float f2, float f3) {
        super(f, f3, f2, f3);
        this.table = table2;
        table2.complete();
        cloneNonPositionParameters(table2);
        this.columns = table2.getColumns();
        this.positions = table2.getWidths(f, f2 - f);
        setLeft(this.positions[0]);
        float[] fArr = this.positions;
        setRight(fArr[fArr.length - 1]);
        updateRowAdditionsInternal();
    }

    /* access modifiers changed from: package-private */
    public void updateRowAdditions() {
        this.table.complete();
        updateRowAdditionsInternal();
        this.table.deleteAllRows();
    }

    private void updateRowAdditionsInternal() {
        boolean z;
        PdfCell pdfCell;
        int rows = rows();
        int lastHeaderRow = this.table.getLastHeaderRow() + 1;
        ArrayList arrayList = new ArrayList();
        int size = this.table.size() + 1;
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = getBottom();
        }
        Iterator it = this.table.iterator();
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            Row row = (Row) it.next();
            if (row.isEmpty()) {
                if (i2 < size - 1) {
                    int i4 = i2 + 1;
                    if (fArr[i4] > fArr[i2]) {
                        fArr[i4] = fArr[i2];
                    }
                }
                z = false;
            } else {
                z = false;
                for (int i5 = 0; i5 < row.getColumns(); i5++) {
                    Cell cell = (Cell) row.getCell(i5);
                    if (cell != null) {
                        float[] fArr2 = this.positions;
                        PdfCell pdfCell2 = r14;
                        PdfCell pdfCell3 = new PdfCell(cell, i2 + rows, fArr2[i5], fArr2[i5 + cell.getColspan()], fArr[i2], cellspacing(), cellpadding());
                        if (i2 < lastHeaderRow) {
                            pdfCell2.setHeader();
                            pdfCell = pdfCell2;
                            this.headercells.add(pdfCell);
                            if (!this.table.isNotAddedYet()) {
                            }
                        } else {
                            pdfCell = pdfCell2;
                        }
                        try {
                            if ((fArr[i2] - pdfCell.getHeight()) - cellpadding() < fArr[i2 + pdfCell.rowspan()]) {
                                fArr[pdfCell.rowspan() + i2] = (fArr[i2] - pdfCell.getHeight()) - cellpadding();
                            }
                        } catch (ArrayIndexOutOfBoundsException unused) {
                            int i6 = size - 1;
                            if (fArr[i2] - pdfCell.getHeight() < fArr[i6]) {
                                fArr[i6] = fArr[i2] - pdfCell.getHeight();
                            }
                        }
                        pdfCell.setGroupNumber(i3);
                        z |= cell.getGroupChange();
                        arrayList.add(pdfCell);
                    }
                }
            }
            i2++;
            if (z) {
                i3++;
            }
        }
        int size2 = arrayList.size();
        for (int i7 = 0; i7 < size2; i7++) {
            PdfCell pdfCell4 = (PdfCell) arrayList.get(i7);
            try {
                pdfCell4.setBottom(fArr[(pdfCell4.rownumber() - rows) + pdfCell4.rowspan()]);
            } catch (ArrayIndexOutOfBoundsException unused2) {
                pdfCell4.setBottom(fArr[size - 1]);
            }
        }
        this.cells.addAll(arrayList);
        setBottom(fArr[size - 1]);
    }

    /* access modifiers changed from: package-private */
    public int rows() {
        if (this.cells.isEmpty()) {
            return 0;
        }
        ArrayList arrayList = this.cells;
        return ((PdfCell) arrayList.get(arrayList.size() - 1)).rownumber() + 1;
    }

    /* access modifiers changed from: package-private */
    public ArrayList getHeaderCells() {
        return this.headercells;
    }

    /* access modifiers changed from: package-private */
    public boolean hasHeader() {
        return !this.headercells.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public ArrayList getCells() {
        return this.cells;
    }

    /* access modifiers changed from: package-private */
    public int columns() {
        return this.columns;
    }

    /* access modifiers changed from: package-private */
    public final float cellpadding() {
        return this.table.getPadding();
    }

    /* access modifiers changed from: package-private */
    public final float cellspacing() {
        return this.table.getSpacing();
    }

    public final boolean hasToFitPageTable() {
        return this.table.isTableFitsPage();
    }

    public final boolean hasToFitPageCells() {
        return this.table.isCellsFitPage();
    }

    public float getOffset() {
        return this.table.getOffset();
    }
}
