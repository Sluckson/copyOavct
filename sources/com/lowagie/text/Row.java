package com.lowagie.text;

import java.util.ArrayList;

public class Row implements Element {
    public static final int CELL = 1;
    public static final int NULL = 0;
    public static final int TABLE = 2;
    protected Object[] cells;
    protected int columns;
    protected int currentColumn = 0;
    protected int horizontalAlignment;
    protected boolean[] reserved;

    public boolean isContent() {
        return true;
    }

    public boolean isNestable() {
        return false;
    }

    public int type() {
        return 21;
    }

    protected Row(int i) {
        this.columns = i;
        this.reserved = new boolean[i];
        this.cells = new Object[i];
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

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: com.lowagie.text.Cell[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: com.lowagie.text.Cell} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v10, resolved type: java.lang.Object[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v11, resolved type: com.lowagie.text.Cell} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: com.lowagie.text.Cell} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void deleteColumn(int r7) {
        /*
            r6 = this;
            int r0 = r6.columns
            if (r7 >= r0) goto L_0x0083
            if (r7 < 0) goto L_0x0083
            r1 = 1
            int r0 = r0 - r1
            r6.columns = r0
            int r0 = r6.columns
            boolean[] r2 = new boolean[r0]
            com.lowagie.text.Cell[] r0 = new com.lowagie.text.Cell[r0]
            r3 = 0
        L_0x0011:
            if (r3 < r7) goto L_0x0053
            r3 = r7
        L_0x0014:
            int r4 = r6.columns
            if (r3 < r4) goto L_0x0043
            java.lang.Object[] r3 = r6.cells
            r4 = r3[r7]
            if (r4 == 0) goto L_0x003e
            r3 = r3[r7]
            com.lowagie.text.Cell r3 = (com.lowagie.text.Cell) r3
            int r3 = r3.getColspan()
            if (r3 <= r1) goto L_0x003e
            java.lang.Object[] r3 = r6.cells
            r3 = r3[r7]
            r0[r7] = r3
            r3 = r0[r7]
            com.lowagie.text.Cell r3 = (com.lowagie.text.Cell) r3
            r7 = r0[r7]
            com.lowagie.text.Cell r7 = (com.lowagie.text.Cell) r7
            int r7 = r7.getColspan()
            int r7 = r7 - r1
            r3.setColspan(r7)
        L_0x003e:
            r6.reserved = r2
            r6.cells = r0
            return
        L_0x0043:
            boolean[] r4 = r6.reserved
            int r5 = r3 + 1
            boolean r4 = r4[r5]
            r2[r3] = r4
            java.lang.Object[] r4 = r6.cells
            r4 = r4[r5]
            r0[r3] = r4
            r3 = r5
            goto L_0x0014
        L_0x0053:
            boolean[] r4 = r6.reserved
            boolean r4 = r4[r3]
            r2[r3] = r4
            java.lang.Object[] r4 = r6.cells
            r4 = r4[r3]
            r0[r3] = r4
            r4 = r0[r3]
            if (r4 == 0) goto L_0x0080
            r4 = r0[r3]
            com.lowagie.text.Cell r4 = (com.lowagie.text.Cell) r4
            int r4 = r4.getColspan()
            int r4 = r4 + r3
            if (r4 <= r7) goto L_0x0080
            r4 = r0[r3]
            com.lowagie.text.Cell r4 = (com.lowagie.text.Cell) r4
            java.lang.Object[] r5 = r6.cells
            r5 = r5[r3]
            com.lowagie.text.Cell r5 = (com.lowagie.text.Cell) r5
            int r5 = r5.getColspan()
            int r5 = r5 - r1
            r4.setColspan(r5)
        L_0x0080:
            int r3 = r3 + 1
            goto L_0x0011
        L_0x0083:
            java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "getCell at illegal index : "
            r1.<init>(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.Row.deleteColumn(int):void");
    }

    /* access modifiers changed from: package-private */
    public int addElement(Object obj) {
        return addElement(obj, this.currentColumn);
    }

    /* access modifiers changed from: package-private */
    public int addElement(Object obj, int i) {
        if (obj == null) {
            throw new NullPointerException("addCell - null argument");
        } else if (i < 0 || i > this.columns) {
            throw new IndexOutOfBoundsException("addCell - illegal column argument");
        } else if (getObjectID(obj) == 1 || getObjectID(obj) == 2) {
            int colspan = Cell.class.isInstance(obj) ? ((Cell) obj).getColspan() : 1;
            if (!reserve(i, colspan)) {
                return -1;
            }
            this.cells[i] = obj;
            this.currentColumn += colspan - 1;
            return i;
        } else {
            throw new IllegalArgumentException("addCell - only Cells or Tables allowed");
        }
    }

    /* access modifiers changed from: package-private */
    public void setElement(Object obj, int i) {
        boolean[] zArr = this.reserved;
        if (!zArr[i]) {
            this.cells[i] = obj;
            if (obj != null) {
                zArr[i] = true;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("setElement - position already taken");
    }

    /* access modifiers changed from: package-private */
    public boolean reserve(int i) {
        return reserve(i, 1);
    }

    /* access modifiers changed from: package-private */
    public boolean reserve(int i, int i2) {
        int i3;
        if (i < 0 || (i3 = i2 + i) > this.columns) {
            throw new IndexOutOfBoundsException("reserve - incorrect column/size");
        }
        int i4 = i;
        while (i4 < i3) {
            boolean[] zArr = this.reserved;
            if (zArr[i4]) {
                while (i4 >= i) {
                    this.reserved[i4] = false;
                    i4--;
                }
                return false;
            }
            zArr[i4] = true;
            i4++;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean isReserved(int i) {
        return this.reserved[i];
    }

    /* access modifiers changed from: package-private */
    public int getElementID(int i) {
        Object[] objArr = this.cells;
        if (objArr[i] == null) {
            return 0;
        }
        if (Cell.class.isInstance(objArr[i])) {
            return 1;
        }
        return Table.class.isInstance(this.cells[i]) ? 2 : -1;
    }

    /* access modifiers changed from: package-private */
    public int getObjectID(Object obj) {
        if (obj == null) {
            return 0;
        }
        if (Cell.class.isInstance(obj)) {
            return 1;
        }
        return Table.class.isInstance(obj) ? 2 : -1;
    }

    public Object getCell(int i) {
        if (i >= 0 && i <= this.columns) {
            return this.cells[i];
        }
        throw new IndexOutOfBoundsException("getCell at illegal index :" + i + " max is " + this.columns);
    }

    public boolean isEmpty() {
        for (int i = 0; i < this.columns; i++) {
            if (this.cells[i] != null) {
                return false;
            }
        }
        return true;
    }

    public int getColumns() {
        return this.columns;
    }

    public void setHorizontalAlignment(int i) {
        this.horizontalAlignment = i;
    }

    public int getHorizontalAlignment() {
        return this.horizontalAlignment;
    }
}
