package com.lowagie.text;

import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import harmony.java.awt.Dimension;
import harmony.java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

public class Table extends Rectangle implements LargeElement {
    private int alignment;
    protected boolean autoFillEmptyCells;
    private float cellpadding;
    boolean cellsFitPage;
    private float cellspacing;
    private int columns;
    protected boolean complete;
    protected boolean convert2pdfptable;
    private Point curPosition;
    private Cell defaultCell;
    private int lastHeaderRow;
    private boolean locked;
    private boolean mTableInserted;
    protected boolean notAddedYet;
    float offset;
    private ArrayList rows;
    boolean tableFitsPage;
    private float width;
    private float[] widths;

    public boolean isNestable() {
        return true;
    }

    public int type() {
        return 22;
    }

    public Table(int i) throws BadElementException {
        this(i, 1);
    }

    public Table(int i, int i2) throws BadElementException {
        super(0.0f, 0.0f, 0.0f, 0.0f);
        this.rows = new ArrayList();
        this.curPosition = new Point(0, 0);
        this.defaultCell = new Cell(true);
        this.lastHeaderRow = -1;
        this.alignment = 1;
        this.width = 80.0f;
        this.locked = false;
        this.mTableInserted = false;
        this.autoFillEmptyCells = false;
        this.tableFitsPage = false;
        this.cellsFitPage = false;
        this.offset = Float.NaN;
        this.convert2pdfptable = false;
        this.notAddedYet = true;
        this.complete = true;
        setBorder(15);
        setBorderWidth(1.0f);
        this.defaultCell.setBorder(15);
        if (i > 0) {
            this.columns = i;
            for (int i3 = 0; i3 < i2; i3++) {
                this.rows.add(new Row(i));
            }
            this.curPosition = new Point(0, 0);
            this.widths = new float[i];
            float f = 100.0f / ((float) i);
            for (int i4 = 0; i4 < i; i4++) {
                this.widths[i4] = f;
            }
            return;
        }
        throw new BadElementException("A table should have at least 1 column.");
    }

    public Table(Table table) {
        super(0.0f, 0.0f, 0.0f, 0.0f);
        this.rows = new ArrayList();
        this.curPosition = new Point(0, 0);
        this.defaultCell = new Cell(true);
        this.lastHeaderRow = -1;
        this.alignment = 1;
        this.width = 80.0f;
        this.locked = false;
        this.mTableInserted = false;
        this.autoFillEmptyCells = false;
        this.tableFitsPage = false;
        this.cellsFitPage = false;
        this.offset = Float.NaN;
        this.convert2pdfptable = false;
        this.notAddedYet = true;
        this.complete = true;
        cloneNonPositionParameters(table);
        this.columns = table.columns;
        this.rows = table.rows;
        this.curPosition = table.curPosition;
        this.defaultCell = table.defaultCell;
        this.lastHeaderRow = table.lastHeaderRow;
        this.alignment = table.alignment;
        this.cellpadding = table.cellpadding;
        this.cellspacing = table.cellspacing;
        this.width = table.width;
        this.widths = table.widths;
        this.autoFillEmptyCells = table.autoFillEmptyCells;
        this.tableFitsPage = table.tableFitsPage;
        this.cellsFitPage = table.cellsFitPage;
        this.offset = table.offset;
        this.convert2pdfptable = table.convert2pdfptable;
    }

    public boolean process(ElementListener elementListener) {
        try {
            return elementListener.add(this);
        } catch (DocumentException unused) {
            return false;
        }
    }

    public ArrayList getChunks() {
        return new ArrayList();
    }

    public int getColumns() {
        return this.columns;
    }

    public int size() {
        return this.rows.size();
    }

    public Dimension getDimension() {
        return new Dimension(this.columns, size());
    }

    public Cell getDefaultCell() {
        return this.defaultCell;
    }

    public void setDefaultCell(Cell cell) {
        this.defaultCell = cell;
    }

    public int getLastHeaderRow() {
        return this.lastHeaderRow;
    }

    public void setLastHeaderRow(int i) {
        this.lastHeaderRow = i;
    }

    public int endHeaders() {
        this.lastHeaderRow = this.curPosition.f4903x - 1;
        return this.lastHeaderRow;
    }

    public int getAlignment() {
        return this.alignment;
    }

    public void setAlignment(int i) {
        this.alignment = i;
    }

    public void setAlignment(String str) {
        if ("Left".equalsIgnoreCase(str)) {
            this.alignment = 0;
        } else if ("right".equalsIgnoreCase(str)) {
            this.alignment = 2;
        } else {
            this.alignment = 1;
        }
    }

    public float getPadding() {
        return this.cellpadding;
    }

    public void setPadding(float f) {
        this.cellpadding = f;
    }

    public float getSpacing() {
        return this.cellspacing;
    }

    public void setSpacing(float f) {
        this.cellspacing = f;
    }

    public void setAutoFillEmptyCells(boolean z) {
        this.autoFillEmptyCells = z;
    }

    public float getWidth() {
        return this.width;
    }

    public void setWidth(float f) {
        this.width = f;
    }

    public boolean isLocked() {
        return this.locked;
    }

    public void setLocked(boolean z) {
        this.locked = z;
    }

    public float[] getProportionalWidths() {
        return this.widths;
    }

    public void setWidths(float[] fArr) throws BadElementException {
        int i;
        if (fArr.length == this.columns) {
            int i2 = 0;
            int i3 = 0;
            float f = 0.0f;
            while (true) {
                i = this.columns;
                if (i3 >= i) {
                    break;
                }
                f += fArr[i3];
                i3++;
            }
            this.widths[i - 1] = 100.0f;
            while (true) {
                int i4 = this.columns;
                if (i2 < i4 - 1) {
                    float f2 = (fArr[i2] * 100.0f) / f;
                    float[] fArr2 = this.widths;
                    fArr2[i2] = f2;
                    int i5 = i4 - 1;
                    fArr2[i5] = fArr2[i5] - f2;
                    i2++;
                } else {
                    return;
                }
            }
        } else {
            throw new BadElementException("Wrong number of columns.");
        }
    }

    public void setWidths(int[] iArr) throws DocumentException {
        float[] fArr = new float[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            fArr[i] = (float) iArr[i];
        }
        setWidths(fArr);
    }

    public boolean isTableFitsPage() {
        return this.tableFitsPage;
    }

    public void setTableFitsPage(boolean z) {
        this.tableFitsPage = z;
        if (z) {
            setCellsFitPage(true);
        }
    }

    public boolean isCellsFitPage() {
        return this.cellsFitPage;
    }

    public void setCellsFitPage(boolean z) {
        this.cellsFitPage = z;
    }

    public void setOffset(float f) {
        this.offset = f;
    }

    public float getOffset() {
        return this.offset;
    }

    public boolean isConvert2pdfptable() {
        return this.convert2pdfptable;
    }

    public void setConvert2pdfptable(boolean z) {
        this.convert2pdfptable = z;
    }

    public void addCell(Cell cell, int i, int i2) throws BadElementException {
        addCell(cell, new Point(i, i2));
    }

    public void addCell(Cell cell, Point point) throws BadElementException {
        if (cell == null) {
            throw new NullPointerException("addCell - cell has null-value");
        } else if (point != null) {
            if (cell.isTable()) {
                insertTable((Table) cell.getElements().next(), point);
            }
            if (point.f4903x < 0) {
                throw new BadElementException("row coordinate of location must be >= 0");
            } else if (point.f4904y <= 0 && point.f4904y > this.columns) {
                throw new BadElementException("column coordinate of location must be >= 0 and < nr of columns");
            } else if (isValidLocation(cell, point)) {
                if (cell.getBorder() == -1) {
                    cell.setBorder(this.defaultCell.getBorder());
                }
                cell.fill();
                placeCell(this.rows, cell, point);
                setCurrentLocationToNextValidPosition(point);
            } else {
                throw new BadElementException("Adding a cell at the location (" + point.f4903x + "," + point.f4904y + ") with a colspan of " + cell.getColspan() + " and a rowspan of " + cell.getRowspan() + " is illegal (beyond boundaries/overlapping).");
            }
        } else {
            throw new NullPointerException("addCell - point has null-value");
        }
    }

    public void addCell(Cell cell) {
        try {
            addCell(cell, this.curPosition);
        } catch (BadElementException unused) {
        }
    }

    public void addCell(Phrase phrase) throws BadElementException {
        addCell(phrase, this.curPosition);
    }

    public void addCell(Phrase phrase, Point point) throws BadElementException {
        Cell cell = new Cell((Element) phrase);
        cell.setBorder(this.defaultCell.getBorder());
        cell.setBorderWidth(this.defaultCell.getBorderWidth());
        cell.setBorderColor(this.defaultCell.getBorderColor());
        cell.setBackgroundColor(this.defaultCell.getBackgroundColor());
        cell.setHorizontalAlignment(this.defaultCell.getHorizontalAlignment());
        cell.setVerticalAlignment(this.defaultCell.getVerticalAlignment());
        cell.setColspan(this.defaultCell.getColspan());
        cell.setRowspan(this.defaultCell.getRowspan());
        addCell(cell, point);
    }

    public void addCell(String str) throws BadElementException {
        addCell(new Phrase(str), this.curPosition);
    }

    public void addCell(String str, Point point) throws BadElementException {
        addCell(new Phrase(str), point);
    }

    public void insertTable(Table table) {
        if (table != null) {
            insertTable(table, this.curPosition);
            return;
        }
        throw new NullPointerException("insertTable - table has null-value");
    }

    public void insertTable(Table table, int i, int i2) {
        if (table != null) {
            insertTable(table, new Point(i, i2));
            return;
        }
        throw new NullPointerException("insertTable - table has null-value");
    }

    public void insertTable(Table table, Point point) {
        if (table == null) {
            throw new NullPointerException("insertTable - table has null-value");
        } else if (point != null) {
            this.mTableInserted = true;
            table.complete();
            if (point.f4904y <= this.columns) {
                int size = (point.f4903x + 1) - this.rows.size();
                if (size > 0) {
                    for (int i = 0; i < size; i++) {
                        this.rows.add(new Row(this.columns));
                    }
                }
                ((Row) this.rows.get(point.f4903x)).setElement(table, point.f4904y);
                setCurrentLocationToNextValidPosition(point);
                return;
            }
            throw new IllegalArgumentException("insertTable -- wrong columnposition(" + point.f4904y + ") of location; max =" + this.columns);
        } else {
            throw new NullPointerException("insertTable - point has null-value");
        }
    }

    public void addColumns(int i) {
        int i2;
        ArrayList arrayList = new ArrayList(this.rows.size());
        int i3 = this.columns + i;
        int i4 = 0;
        while (i4 < this.rows.size()) {
            Row row = new Row(i3);
            int i5 = 0;
            while (true) {
                i2 = this.columns;
                if (i5 >= i2) {
                    break;
                }
                row.setElement(((Row) this.rows.get(i4)).getCell(i5), i5);
                i5++;
            }
            while (i2 < i3 && i4 < this.curPosition.f4903x) {
                row.setElement((Object) null, i2);
                i2++;
            }
            arrayList.add(row);
            i4++;
        }
        float[] fArr = new float[i3];
        System.arraycopy(this.widths, 0, fArr, 0, this.columns);
        for (int i6 = this.columns; i6 < i3; i6++) {
            fArr[i6] = 0.0f;
        }
        this.columns = i3;
        this.widths = fArr;
        this.rows = arrayList;
    }

    public void deleteColumn(int i) throws BadElementException {
        int i2 = this.columns - 1;
        this.columns = i2;
        float[] fArr = new float[i2];
        System.arraycopy(this.widths, 0, fArr, 0, i);
        System.arraycopy(this.widths, i + 1, fArr, i, this.columns - i);
        setWidths(fArr);
        System.arraycopy(this.widths, 0, fArr, 0, this.columns);
        this.widths = fArr;
        int size = this.rows.size();
        for (int i3 = 0; i3 < size; i3++) {
            Row row = (Row) this.rows.get(i3);
            row.deleteColumn(i);
            this.rows.set(i3, row);
        }
        if (i == this.columns) {
            Point point = this.curPosition;
            point.setLocation(point.f4903x + 1, 0);
        }
    }

    public boolean deleteRow(int i) {
        if (i < 0 || i >= this.rows.size()) {
            return false;
        }
        this.rows.remove(i);
        Point point = this.curPosition;
        point.setLocation(point.f4903x - 1, this.curPosition.f4904y);
        return true;
    }

    public void deleteAllRows() {
        this.rows.clear();
        this.rows.add(new Row(this.columns));
        this.curPosition.setLocation(0, 0);
        this.lastHeaderRow = -1;
    }

    public boolean deleteLastRow() {
        return deleteRow(this.rows.size() - 1);
    }

    public void complete() {
        if (this.mTableInserted) {
            mergeInsertedTables();
            this.mTableInserted = false;
        }
        if (this.autoFillEmptyCells) {
            fillEmptyMatrixCells();
        }
    }

    public Object getElement(int i, int i2) {
        return ((Row) this.rows.get(i)).getCell(i2);
    }

    private void mergeInsertedTables() {
        int i;
        float[] fArr;
        float[] fArr2;
        Table table;
        float[][] fArr3;
        float[][] fArr4;
        Table table2 = this;
        int i2 = table2.columns;
        int[] iArr = new int[i2];
        float[][] fArr5 = new float[i2][];
        int[] iArr2 = new int[table2.rows.size()];
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
        while (true) {
            i = 1;
            if (i3 >= table2.columns) {
                break;
            }
            boolean z2 = z;
            int i5 = 1;
            float[] fArr6 = null;
            int i6 = 0;
            while (i6 < table2.rows.size()) {
                if (Table.class.isInstance(((Row) table2.rows.get(i6)).getCell(i3))) {
                    Table table3 = (Table) ((Row) table2.rows.get(i6)).getCell(i3);
                    if (fArr6 == null) {
                        fArr6 = table3.widths;
                        i5 = fArr6.length;
                        fArr3 = fArr5;
                        z2 = true;
                    } else {
                        int i7 = table3.getDimension().width;
                        float[] fArr7 = new float[(fArr6.length * i7)];
                        float f = table3.widths[0] + 0.0f;
                        float f2 = fArr6[0] + 0.0f;
                        int i8 = 0;
                        int i9 = 0;
                        int i10 = 0;
                        float f3 = 0.0f;
                        while (i9 < fArr6.length && i10 < i7) {
                            if (f > f2) {
                                fArr7[i8] = f2 - f3;
                                i9++;
                                if (i9 < fArr6.length) {
                                    f2 += fArr6[i9];
                                }
                                fArr4 = fArr5;
                            } else {
                                fArr7[i8] = f - f3;
                                i10++;
                                fArr4 = fArr5;
                                if (((double) Math.abs(f - f2)) < 1.0E-4d && (i9 = i9 + 1) < fArr6.length) {
                                    f2 += fArr6[i9];
                                }
                                if (i10 < i7) {
                                    f += table3.widths[i10];
                                }
                            }
                            f3 += fArr7[i8];
                            i8++;
                            fArr5 = fArr4;
                        }
                        fArr3 = fArr5;
                        float[] fArr8 = new float[i8];
                        System.arraycopy(fArr7, 0, fArr8, 0, i8);
                        fArr6 = fArr8;
                        i5 = i8;
                        z2 = true;
                        i6++;
                        table2 = this;
                        fArr5 = fArr3;
                    }
                } else {
                    fArr3 = fArr5;
                }
                i6++;
                table2 = this;
                fArr5 = fArr3;
            }
            fArr5[i3] = fArr6;
            i4 += i5;
            iArr[i3] = i5;
            i3++;
            z = z2;
        }
        int i11 = 0;
        int i12 = 0;
        while (i11 < table2.rows.size()) {
            int i13 = 1;
            for (int i14 = 0; i14 < table2.columns; i14++) {
                if (Table.class.isInstance(((Row) table2.rows.get(i11)).getCell(i14))) {
                    Table table4 = (Table) ((Row) table2.rows.get(i11)).getCell(i14);
                    if (table4.getDimension().height > i13) {
                        i13 = table4.getDimension().height;
                    }
                    z = true;
                }
            }
            i12 += i13;
            iArr2[i11] = i13;
            i11++;
            i = 1;
        }
        if (i4 != table2.columns || i12 != table2.rows.size() || z) {
            float[] fArr9 = new float[i4];
            int i15 = 0;
            int i16 = 0;
            while (true) {
                float[] fArr10 = table2.widths;
                if (i15 >= fArr10.length) {
                    break;
                }
                float[] fArr11 = fArr9;
                if (iArr[i15] != 1) {
                    for (int i17 = 0; i17 < iArr[i15]; i17++) {
                        fArr11[i16] = (table2.widths[i15] * fArr5[i15][i17]) / 100.0f;
                        i16++;
                    }
                } else {
                    fArr11[i16] = fArr10[i15];
                    i16++;
                }
                i15++;
                fArr9 = fArr11;
                i = 1;
            }
            ArrayList arrayList = new ArrayList(i12);
            int i18 = 0;
            while (i18 < i12) {
                float[] fArr12 = fArr9;
                arrayList.add(new Row(i4));
                i18++;
                i = 1;
            }
            int i19 = 0;
            for (int i20 = 0; i20 < table2.rows.size(); i20++) {
                int i21 = 0;
                int i22 = 0;
                while (i21 < table2.columns) {
                    if (Table.class.isInstance(((Row) table2.rows.get(i20)).getCell(i21))) {
                        Table table5 = (Table) ((Row) table2.rows.get(i20)).getCell(i21);
                        int[] iArr3 = new int[(table5.widths.length + i)];
                        int i23 = 0;
                        int i24 = 0;
                        while (true) {
                            float[] fArr13 = table5.widths;
                            if (i23 >= fArr13.length) {
                                break;
                            }
                            Table table6 = table5;
                            float[] fArr14 = fArr9;
                            iArr3[i23] = i22 + i24;
                            float f4 = fArr13[i23];
                            int i25 = i24;
                            float f5 = 0.0f;
                            while (true) {
                                if (i25 >= iArr[i21]) {
                                    i24 = i25;
                                    break;
                                }
                                i24 = i25 + 1;
                                f5 += fArr5[i21][i25];
                                float f6 = f4;
                                if (((double) Math.abs(f4 - f5)) < 1.0E-4d) {
                                    break;
                                }
                                f4 = f6;
                                i25 = i24;
                            }
                            i23++;
                            table5 = table6;
                            fArr9 = fArr14;
                        }
                        iArr3[i23] = i22 + i24;
                        for (int i26 = 0; i26 < table5.getDimension().height; i26++) {
                            int i27 = 0;
                            while (i27 < table5.getDimension().width) {
                                Object element = table5.getElement(i26, i27);
                                if (element != null) {
                                    int i28 = i22 + i27;
                                    table = table5;
                                    if (Cell.class.isInstance(element)) {
                                        Cell cell = (Cell) element;
                                        i28 = iArr3[i27];
                                        fArr2 = fArr9;
                                        cell.setColspan(iArr3[i27 + cell.getColspan()] - i28);
                                    } else {
                                        fArr2 = fArr9;
                                    }
                                    ((Row) arrayList.get(i26 + i19)).addElement(element, i28);
                                } else {
                                    table = table5;
                                    fArr2 = fArr9;
                                }
                                i27++;
                                table5 = table;
                                fArr9 = fArr2;
                            }
                        }
                        fArr = fArr9;
                    } else {
                        fArr = fArr9;
                        Object element2 = table2.getElement(i20, i21);
                        if (Cell.class.isInstance(element2)) {
                            Cell cell2 = (Cell) element2;
                            cell2.setRowspan((((Cell) ((Row) table2.rows.get(i20)).getCell(i21)).getRowspan() + iArr2[i20]) - 1);
                            cell2.setColspan((((Cell) ((Row) table2.rows.get(i20)).getCell(i21)).getColspan() + iArr[i21]) - 1);
                            table2.placeCell(arrayList, cell2, new Point(i19, i22));
                        }
                    }
                    i22 += iArr[i21];
                    i21++;
                    fArr9 = fArr;
                    i = 1;
                }
                i19 += iArr2[i20];
            }
            table2.columns = i4;
            table2.rows = arrayList;
            table2.widths = fArr9;
        }
    }

    private void fillEmptyMatrixCells() {
        int i = 0;
        while (i < this.rows.size()) {
            try {
                for (int i2 = 0; i2 < this.columns; i2++) {
                    if (!((Row) this.rows.get(i)).isReserved(i2)) {
                        addCell(this.defaultCell, new Point(i, i2));
                    }
                }
                i++;
            } catch (BadElementException e) {
                throw new ExceptionConverter(e);
            }
        }
    }

    private boolean isValidLocation(Cell cell, Point point) {
        if (point.f4903x < this.rows.size()) {
            if (point.f4904y + cell.getColspan() > this.columns) {
                return false;
            }
            int rowspan = this.rows.size() - point.f4903x > cell.getRowspan() ? cell.getRowspan() : this.rows.size() - point.f4903x;
            int colspan = this.columns - point.f4904y > cell.getColspan() ? cell.getColspan() : this.columns - point.f4904y;
            for (int i = point.f4903x; i < point.f4903x + rowspan; i++) {
                for (int i2 = point.f4904y; i2 < point.f4904y + colspan; i2++) {
                    if (((Row) this.rows.get(i)).isReserved(i2)) {
                        return false;
                    }
                }
            }
            return true;
        } else if (point.f4904y + cell.getColspan() > this.columns) {
            return false;
        } else {
            return true;
        }
    }

    private void assumeTableDefaults(Cell cell) {
        if (cell.getBorder() == -1) {
            cell.setBorder(this.defaultCell.getBorder());
        }
        if (cell.getBorderWidth() == -1.0f) {
            cell.setBorderWidth(this.defaultCell.getBorderWidth());
        }
        if (cell.getBorderColor() == null) {
            cell.setBorderColor(this.defaultCell.getBorderColor());
        }
        if (cell.getBackgroundColor() == null) {
            cell.setBackgroundColor(this.defaultCell.getBackgroundColor());
        }
        if (cell.getHorizontalAlignment() == -1) {
            cell.setHorizontalAlignment(this.defaultCell.getHorizontalAlignment());
        }
        if (cell.getVerticalAlignment() == -1) {
            cell.setVerticalAlignment(this.defaultCell.getVerticalAlignment());
        }
    }

    private void placeCell(ArrayList arrayList, Cell cell, Point point) {
        int rowspan = (point.f4903x + cell.getRowspan()) - arrayList.size();
        assumeTableDefaults(cell);
        if (point.f4903x + cell.getRowspan() > arrayList.size()) {
            for (int i = 0; i < rowspan; i++) {
                arrayList.add(new Row(this.columns));
            }
        }
        int i2 = point.f4903x;
        do {
            i2++;
            if (i2 >= point.f4903x + cell.getRowspan()) {
                ((Row) arrayList.get(point.f4903x)).addElement(cell, point.f4904y);
                return;
            }
        } while (((Row) arrayList.get(i2)).reserve(point.f4904y, cell.getColspan()));
        throw new RuntimeException("addCell - error in reserve");
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void setCurrentLocationToNextValidPosition(harmony.java.awt.Point r3) {
        /*
            r2 = this;
            int r0 = r3.f4903x
            int r3 = r3.f4904y
        L_0x0004:
            int r3 = r3 + 1
            int r1 = r2.columns
            if (r3 != r1) goto L_0x000d
            int r0 = r0 + 1
            r3 = 0
        L_0x000d:
            java.util.ArrayList r1 = r2.rows
            int r1 = r1.size()
            if (r0 >= r1) goto L_0x0027
            int r1 = r2.columns
            if (r3 >= r1) goto L_0x0027
            java.util.ArrayList r1 = r2.rows
            java.lang.Object r1 = r1.get(r0)
            com.lowagie.text.Row r1 = (com.lowagie.text.Row) r1
            boolean r1 = r1.isReserved(r3)
            if (r1 != 0) goto L_0x0004
        L_0x0027:
            harmony.java.awt.Point r1 = new harmony.java.awt.Point
            r1.<init>(r0, r3)
            r2.curPosition = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.Table.setCurrentLocationToNextValidPosition(harmony.java.awt.Point):void");
    }

    public float[] getWidths(float f, float f2) {
        float f3;
        int i = 1;
        float[] fArr = new float[(this.columns + 1)];
        if (this.locked) {
            f3 = (this.width * 100.0f) / f2;
        } else {
            f3 = this.width;
        }
        int i2 = this.alignment;
        if (i2 == 0) {
            fArr[0] = f;
        } else if (i2 != 2) {
            fArr[0] = f + (((100.0f - f3) * f2) / 200.0f);
        } else {
            fArr[0] = f + (((100.0f - f3) * f2) / 100.0f);
        }
        float f4 = (f2 * f3) / 100.0f;
        while (true) {
            int i3 = this.columns;
            if (i >= i3) {
                fArr[i3] = fArr[0] + f4;
                return fArr;
            }
            int i4 = i - 1;
            fArr[i] = fArr[i4] + ((this.widths[i4] * f4) / 100.0f);
            i++;
        }
    }

    public Iterator iterator() {
        return this.rows.iterator();
    }

    public PdfPTable createPdfPTable() throws BadElementException {
        PdfPCell pdfPCell;
        if (this.convert2pdfptable) {
            setAutoFillEmptyCells(true);
            complete();
            PdfPTable pdfPTable = new PdfPTable(this.widths);
            pdfPTable.setComplete(this.complete);
            if (isNotAddedYet()) {
                pdfPTable.setSkipFirstHeader(true);
            }
            SimpleTable simpleTable = new SimpleTable();
            simpleTable.cloneNonPositionParameters(this);
            simpleTable.setCellspacing(this.cellspacing);
            pdfPTable.setTableEvent(simpleTable);
            pdfPTable.setHeaderRows(this.lastHeaderRow + 1);
            pdfPTable.setSplitLate(this.cellsFitPage);
            pdfPTable.setKeepTogether(this.tableFitsPage);
            if (!Float.isNaN(this.offset)) {
                pdfPTable.setSpacingBefore(this.offset);
            }
            pdfPTable.setHorizontalAlignment(this.alignment);
            if (this.locked) {
                pdfPTable.setTotalWidth(this.width);
                pdfPTable.setLockedWidth(true);
            } else {
                pdfPTable.setWidthPercentage(this.width);
            }
            Iterator it = iterator();
            while (it.hasNext()) {
                Row row = (Row) it.next();
                for (int i = 0; i < row.getColumns(); i++) {
                    Element element = (Element) row.getCell(i);
                    if (element != null) {
                        if (element instanceof Table) {
                            pdfPCell = new PdfPCell(((Table) element).createPdfPTable());
                        } else if (element instanceof Cell) {
                            Cell cell = (Cell) element;
                            pdfPCell = cell.createPdfPCell();
                            pdfPCell.setPadding(this.cellpadding + (this.cellspacing / 2.0f));
                            SimpleCell simpleCell = new SimpleCell(false);
                            simpleCell.cloneNonPositionParameters(cell);
                            simpleCell.setSpacing(this.cellspacing * 2.0f);
                            pdfPCell.setCellEvent(simpleCell);
                        } else {
                            pdfPCell = new PdfPCell();
                        }
                        pdfPTable.addCell(pdfPCell);
                    }
                }
            }
            return pdfPTable;
        }
        throw new BadElementException("No error, just an old style table");
    }

    public boolean isNotAddedYet() {
        return this.notAddedYet;
    }

    public void setNotAddedYet(boolean z) {
        this.notAddedYet = z;
    }

    public void flushContent() {
        setNotAddedYet(false);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < getLastHeaderRow() + 1; i++) {
            arrayList.add(this.rows.get(i));
        }
        this.rows = arrayList;
    }

    public boolean isComplete() {
        return this.complete;
    }

    public void setComplete(boolean z) {
        this.complete = z;
    }

    public Cell getDefaultLayout() {
        return getDefaultCell();
    }

    public void setDefaultLayout(Cell cell) {
        this.defaultCell = cell;
    }
}
