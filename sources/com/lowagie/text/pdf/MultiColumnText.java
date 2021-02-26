package com.lowagie.text.pdf;

import com.lowagie.text.Chunk;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.ElementListener;
import com.lowagie.text.Phrase;
import java.util.ArrayList;

public class MultiColumnText implements Element {
    public static final float AUTOMATIC = -1.0f;
    private ArrayList columnDefs;
    private ColumnText columnText;
    private boolean columnsRightToLeft;
    private int currentColumn;
    /* access modifiers changed from: private */
    public float desiredHeight;
    private PdfDocument document;
    private float nextY;
    private boolean overflow;
    private boolean simple;
    /* access modifiers changed from: private */
    public float top;
    private float totalHeight;

    public ArrayList getChunks() {
        return null;
    }

    public boolean isContent() {
        return true;
    }

    public boolean isNestable() {
        return false;
    }

    public int type() {
        return 40;
    }

    public MultiColumnText() {
        this(-1.0f);
    }

    public MultiColumnText(float f) {
        this.simple = true;
        this.currentColumn = 0;
        this.nextY = -1.0f;
        this.columnsRightToLeft = false;
        this.columnDefs = new ArrayList();
        this.desiredHeight = f;
        this.top = -1.0f;
        this.columnText = new ColumnText((PdfContentByte) null);
        this.totalHeight = 0.0f;
    }

    public MultiColumnText(float f, float f2) {
        this.simple = true;
        this.currentColumn = 0;
        this.nextY = -1.0f;
        this.columnsRightToLeft = false;
        this.columnDefs = new ArrayList();
        this.desiredHeight = f2;
        this.top = f;
        this.nextY = f;
        this.columnText = new ColumnText((PdfContentByte) null);
        this.totalHeight = 0.0f;
    }

    public boolean isOverflow() {
        return this.overflow;
    }

    public void useColumnParams(ColumnText columnText2) {
        this.columnText.setSimpleVars(columnText2);
    }

    public void addColumn(float[] fArr, float[] fArr2) {
        ColumnDef columnDef = new ColumnDef(fArr, fArr2);
        if (!columnDef.isSimple()) {
            this.simple = false;
        }
        this.columnDefs.add(columnDef);
    }

    public void addSimpleColumn(float f, float f2) {
        this.columnDefs.add(new ColumnDef(f, f2));
    }

    public void addRegularColumns(float f, float f2, float f3, int i) {
        float f4 = ((f2 - f) - (((float) (i - 1)) * f3)) / ((float) i);
        for (int i2 = 0; i2 < i; i2++) {
            addSimpleColumn(f, f + f4);
            f += f4 + f3;
        }
    }

    public void addText(Phrase phrase) {
        this.columnText.addText(phrase);
    }

    public void addText(Chunk chunk) {
        this.columnText.addText(chunk);
    }

    public void addElement(Element element) throws DocumentException {
        if (this.simple) {
            this.columnText.addElement(element);
        } else if (element instanceof Phrase) {
            this.columnText.addText((Phrase) element);
        } else if (element instanceof Chunk) {
            this.columnText.addText((Chunk) element);
        } else {
            throw new DocumentException("Can't add " + element.getClass() + " to MultiColumnText with complex columns");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d2, code lost:
        r12.totalHeight += r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00db, code lost:
        if (r12.desiredHeight == -1.0f) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00e3, code lost:
        if (r12.totalHeight < r12.desiredHeight) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00e5, code lost:
        r12.overflow = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public float write(com.lowagie.text.pdf.PdfContentByte r13, com.lowagie.text.pdf.PdfDocument r14, float r15) throws com.lowagie.text.DocumentException {
        /*
            r12 = this;
            r12.document = r14
            com.lowagie.text.pdf.ColumnText r0 = r12.columnText
            r0.setCanvas(r13)
            java.util.ArrayList r13 = r12.columnDefs
            boolean r13 = r13.isEmpty()
            if (r13 != 0) goto L_0x010a
            r13 = 0
            r12.overflow = r13
            r0 = 0
            r1 = 1
            r3 = r15
            r15 = 0
        L_0x0016:
            r2 = 0
        L_0x0017:
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r15 == 0) goto L_0x001d
            goto L_0x00e7
        L_0x001d:
            float r5 = r12.top     // Catch:{ DocumentException -> 0x0105 }
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 != 0) goto L_0x002a
            float r5 = r14.getVerticalPosition(r1)     // Catch:{ DocumentException -> 0x0105 }
            r12.top = r5     // Catch:{ DocumentException -> 0x0105 }
            goto L_0x0036
        L_0x002a:
            float r5 = r12.nextY     // Catch:{ DocumentException -> 0x0105 }
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 != 0) goto L_0x0036
            float r5 = r14.getVerticalPosition(r1)     // Catch:{ DocumentException -> 0x0105 }
            r12.nextY = r5     // Catch:{ DocumentException -> 0x0105 }
        L_0x0036:
            java.util.ArrayList r5 = r12.columnDefs     // Catch:{ DocumentException -> 0x0105 }
            int r6 = r12.getCurrentColumn()     // Catch:{ DocumentException -> 0x0105 }
            java.lang.Object r5 = r5.get(r6)     // Catch:{ DocumentException -> 0x0105 }
            com.lowagie.text.pdf.MultiColumnText$ColumnDef r5 = (com.lowagie.text.pdf.MultiColumnText.ColumnDef) r5     // Catch:{ DocumentException -> 0x0105 }
            com.lowagie.text.pdf.ColumnText r6 = r12.columnText     // Catch:{ DocumentException -> 0x0105 }
            float r7 = r12.top     // Catch:{ DocumentException -> 0x0105 }
            r6.setYLine(r7)     // Catch:{ DocumentException -> 0x0105 }
            r6 = 4
            float[] r6 = r5.resolvePositions((int) r6)     // Catch:{ DocumentException -> 0x0105 }
            r7 = 8
            float[] r7 = r5.resolvePositions((int) r7)     // Catch:{ DocumentException -> 0x0105 }
            boolean r8 = r14.isMarginMirroring()     // Catch:{ DocumentException -> 0x0105 }
            r9 = 2
            if (r8 == 0) goto L_0x0090
            int r8 = r14.getPageNumber()     // Catch:{ DocumentException -> 0x0105 }
            int r8 = r8 % r9
            if (r8 != 0) goto L_0x0090
            float r8 = r14.rightMargin()     // Catch:{ DocumentException -> 0x0105 }
            float r10 = r14.left()     // Catch:{ DocumentException -> 0x0105 }
            float r8 = r8 - r10
            java.lang.Object r6 = r6.clone()     // Catch:{ DocumentException -> 0x0105 }
            float[] r6 = (float[]) r6     // Catch:{ DocumentException -> 0x0105 }
            java.lang.Object r7 = r7.clone()     // Catch:{ DocumentException -> 0x0105 }
            float[] r7 = (float[]) r7     // Catch:{ DocumentException -> 0x0105 }
            r10 = 0
        L_0x0078:
            int r11 = r6.length     // Catch:{ DocumentException -> 0x0105 }
            if (r10 < r11) goto L_0x0088
            r10 = 0
        L_0x007c:
            int r11 = r7.length     // Catch:{ DocumentException -> 0x0105 }
            if (r10 < r11) goto L_0x0080
            goto L_0x0090
        L_0x0080:
            r11 = r7[r10]     // Catch:{ DocumentException -> 0x0105 }
            float r11 = r11 - r8
            r7[r10] = r11     // Catch:{ DocumentException -> 0x0105 }
            int r10 = r10 + 2
            goto L_0x007c
        L_0x0088:
            r11 = r6[r10]     // Catch:{ DocumentException -> 0x0105 }
            float r11 = r11 - r8
            r6[r10] = r11     // Catch:{ DocumentException -> 0x0105 }
            int r10 = r10 + 2
            goto L_0x0078
        L_0x0090:
            float r8 = r12.getHeight(r6, r7)     // Catch:{ DocumentException -> 0x0105 }
            float r2 = java.lang.Math.max(r2, r8)     // Catch:{ DocumentException -> 0x0105 }
            boolean r5 = r5.isSimple()     // Catch:{ DocumentException -> 0x0105 }
            if (r5 == 0) goto L_0x00ad
            com.lowagie.text.pdf.ColumnText r5 = r12.columnText     // Catch:{ DocumentException -> 0x0105 }
            r8 = r6[r9]     // Catch:{ DocumentException -> 0x0105 }
            r9 = 3
            r6 = r6[r9]     // Catch:{ DocumentException -> 0x0105 }
            r9 = r7[r13]     // Catch:{ DocumentException -> 0x0105 }
            r7 = r7[r1]     // Catch:{ DocumentException -> 0x0105 }
            r5.setSimpleColumn(r8, r6, r9, r7)     // Catch:{ DocumentException -> 0x0105 }
            goto L_0x00b2
        L_0x00ad:
            com.lowagie.text.pdf.ColumnText r5 = r12.columnText     // Catch:{ DocumentException -> 0x0105 }
            r5.setColumns(r6, r7)     // Catch:{ DocumentException -> 0x0105 }
        L_0x00b2:
            com.lowagie.text.pdf.ColumnText r5 = r12.columnText     // Catch:{ DocumentException -> 0x0105 }
            int r5 = r5.mo52494go()     // Catch:{ DocumentException -> 0x0105 }
            r5 = r5 & r1
            if (r5 == 0) goto L_0x00c6
            com.lowagie.text.pdf.ColumnText r15 = r12.columnText     // Catch:{ DocumentException -> 0x0105 }
            float r15 = r15.getYLine()     // Catch:{ DocumentException -> 0x0105 }
            r12.top = r15     // Catch:{ DocumentException -> 0x0105 }
            r15 = 1
            goto L_0x0017
        L_0x00c6:
            boolean r5 = r12.shiftCurrentColumn()     // Catch:{ DocumentException -> 0x0105 }
            if (r5 == 0) goto L_0x00d2
            float r4 = r12.nextY     // Catch:{ DocumentException -> 0x0105 }
            r12.top = r4     // Catch:{ DocumentException -> 0x0105 }
            goto L_0x0017
        L_0x00d2:
            float r5 = r12.totalHeight     // Catch:{ DocumentException -> 0x0105 }
            float r5 = r5 + r2
            r12.totalHeight = r5     // Catch:{ DocumentException -> 0x0105 }
            float r5 = r12.desiredHeight     // Catch:{ DocumentException -> 0x0105 }
            int r5 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r5 == 0) goto L_0x00fe
            float r5 = r12.totalHeight     // Catch:{ DocumentException -> 0x0105 }
            float r6 = r12.desiredHeight     // Catch:{ DocumentException -> 0x0105 }
            int r5 = (r5 > r6 ? 1 : (r5 == r6 ? 0 : -1))
            if (r5 < 0) goto L_0x00fe
            r12.overflow = r1     // Catch:{ DocumentException -> 0x0105 }
        L_0x00e7:
            float r13 = r12.desiredHeight
            int r13 = (r13 > r4 ? 1 : (r13 == r4 ? 0 : -1))
            if (r13 != 0) goto L_0x00fd
            java.util.ArrayList r13 = r12.columnDefs
            int r13 = r13.size()
            if (r13 != r1) goto L_0x00fd
            com.lowagie.text.pdf.ColumnText r13 = r12.columnText
            float r13 = r13.getYLine()
            float r2 = r3 - r13
        L_0x00fd:
            return r2
        L_0x00fe:
            float r3 = r12.nextY     // Catch:{ DocumentException -> 0x0105 }
            r12.newPage()     // Catch:{ DocumentException -> 0x0105 }
            goto L_0x0016
        L_0x0105:
            r13 = move-exception
            r13.printStackTrace()
            throw r13
        L_0x010a:
            com.lowagie.text.DocumentException r13 = new com.lowagie.text.DocumentException
            java.lang.String r14 = "MultiColumnText has no columns"
            r13.<init>((java.lang.String) r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.MultiColumnText.write(com.lowagie.text.pdf.PdfContentByte, com.lowagie.text.pdf.PdfDocument, float):float");
    }

    private void newPage() throws DocumentException {
        resetCurrentColumn();
        if (this.desiredHeight == -1.0f) {
            this.nextY = -1.0f;
            this.top = -1.0f;
        } else {
            this.top = this.nextY;
        }
        this.totalHeight = 0.0f;
        PdfDocument pdfDocument = this.document;
        if (pdfDocument != null) {
            pdfDocument.newPage();
        }
    }

    private float getHeight(float[] fArr, float[] fArr2) {
        float f = Float.MAX_VALUE;
        float f2 = Float.MIN_VALUE;
        for (int i = 0; i < fArr.length; i += 2) {
            int i2 = i + 1;
            f = Math.min(f, fArr[i2]);
            f2 = Math.max(f2, fArr[i2]);
        }
        for (int i3 = 0; i3 < fArr2.length; i3 += 2) {
            int i4 = i3 + 1;
            f = Math.min(f, fArr2[i4]);
            f2 = Math.max(f2, fArr2[i4]);
        }
        return f2 - f;
    }

    public boolean process(ElementListener elementListener) {
        try {
            return elementListener.add(this);
        } catch (DocumentException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public float getColumnBottom() {
        float f = this.desiredHeight;
        if (f == -1.0f) {
            return this.document.bottom();
        }
        return Math.max(this.top - (f - this.totalHeight), this.document.bottom());
    }

    public void nextColumn() throws DocumentException {
        this.currentColumn = (this.currentColumn + 1) % this.columnDefs.size();
        this.top = this.nextY;
        if (this.currentColumn == 0) {
            newPage();
        }
    }

    public int getCurrentColumn() {
        if (this.columnsRightToLeft) {
            return (this.columnDefs.size() - this.currentColumn) - 1;
        }
        return this.currentColumn;
    }

    public void resetCurrentColumn() {
        this.currentColumn = 0;
    }

    public boolean shiftCurrentColumn() {
        if (this.currentColumn + 1 >= this.columnDefs.size()) {
            return false;
        }
        this.currentColumn++;
        return true;
    }

    public void setColumnsRightToLeft(boolean z) {
        this.columnsRightToLeft = z;
    }

    public void setSpaceCharRatio(float f) {
        this.columnText.setSpaceCharRatio(f);
    }

    public void setRunDirection(int i) {
        this.columnText.setRunDirection(i);
    }

    public void setArabicOptions(int i) {
        this.columnText.setArabicOptions(i);
    }

    public void setAlignment(int i) {
        this.columnText.setAlignment(i);
    }

    private class ColumnDef {
        private float[] left;
        private float[] right;

        ColumnDef(float[] fArr, float[] fArr2) {
            this.left = fArr;
            this.right = fArr2;
        }

        ColumnDef(float f, float f2) {
            this.left = new float[4];
            float[] fArr = this.left;
            fArr[0] = f;
            fArr[1] = MultiColumnText.this.top;
            this.left[2] = f;
            if (MultiColumnText.this.desiredHeight == -1.0f || MultiColumnText.this.top == -1.0f) {
                this.left[3] = -1.0f;
            } else {
                this.left[3] = MultiColumnText.this.top - MultiColumnText.this.desiredHeight;
            }
            this.right = new float[4];
            float[] fArr2 = this.right;
            fArr2[0] = f2;
            fArr2[1] = MultiColumnText.this.top;
            this.right[2] = f2;
            if (MultiColumnText.this.desiredHeight == -1.0f || MultiColumnText.this.top == -1.0f) {
                this.right[3] = -1.0f;
            } else {
                this.right[3] = MultiColumnText.this.top - MultiColumnText.this.desiredHeight;
            }
        }

        /* access modifiers changed from: package-private */
        public float[] resolvePositions(int i) {
            if (i == 4) {
                return resolvePositions(this.left);
            }
            return resolvePositions(this.right);
        }

        private float[] resolvePositions(float[] fArr) {
            if (!isSimple()) {
                fArr[1] = MultiColumnText.this.top;
                return fArr;
            } else if (MultiColumnText.this.top != -1.0f) {
                fArr[1] = MultiColumnText.this.top;
                fArr[3] = MultiColumnText.this.getColumnBottom();
                return fArr;
            } else {
                throw new RuntimeException("resolvePositions called with top=AUTOMATIC (-1).  Top position must be set befure lines can be resolved");
            }
        }

        /* access modifiers changed from: private */
        public boolean isSimple() {
            float[] fArr = this.left;
            if (fArr.length == 4) {
                float[] fArr2 = this.right;
                return fArr2.length == 4 && fArr[0] == fArr[2] && fArr2[0] == fArr2[2];
            }
        }
    }
}
