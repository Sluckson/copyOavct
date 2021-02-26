package com.lowagie.text.pdf;

import com.lowagie.text.Chunk;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.SimpleTable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ColumnText {
    public static final int AR_COMPOSEDTASHKEEL = 4;
    public static final int AR_LIG = 8;
    public static final int AR_NOVOWEL = 1;
    public static final int DIGITS_AN2EN = 64;
    public static final int DIGITS_EN2AN = 32;
    public static final int DIGITS_EN2AN_INIT_AL = 128;
    public static final int DIGITS_EN2AN_INIT_LR = 96;
    public static final int DIGIT_TYPE_AN = 0;
    public static final int DIGIT_TYPE_AN_EXTENDED = 256;
    public static final float GLOBAL_SPACE_CHAR_RATIO = 0.0f;
    protected static final int LINE_STATUS_NOLINE = 2;
    protected static final int LINE_STATUS_OFFLIMITS = 1;
    protected static final int LINE_STATUS_OK = 0;
    public static final int NO_MORE_COLUMN = 2;
    public static final int NO_MORE_TEXT = 1;
    public static final int START_COLUMN = 0;
    private boolean adjustFirstLine = true;
    protected int alignment = 0;
    private int arabicOptions = 0;
    protected BidiLine bidiLine;
    protected PdfContentByte canvas;
    protected PdfContentByte[] canvases;
    protected boolean composite = false;
    protected ColumnText compositeColumn;
    protected LinkedList compositeElements;
    protected float currentLeading = 16.0f;
    protected float descender;
    protected float extraParagraphSpace = 0.0f;
    private float filledWidth;
    private float firstLineY;
    private boolean firstLineYDone = false;
    protected float fixedLeading = 16.0f;
    protected float followingIndent = 0.0f;
    protected float indent = 0.0f;
    private boolean lastWasNewline = true;
    protected ArrayList leftWall;
    protected float leftX;
    protected int lineStatus;
    private int linesWritten;
    protected int listIdx = 0;
    protected float maxY;
    protected float minY;
    protected float multipliedLeading = 0.0f;
    protected boolean rectangularMode = false;
    protected float rectangularWidth = -1.0f;
    protected float rightIndent = 0.0f;
    protected ArrayList rightWall;
    protected float rightX;
    protected int runDirection = 0;
    private float spaceCharRatio = 0.0f;
    private boolean splittedRow;
    private boolean useAscender = false;
    protected Phrase waitPhrase;
    protected float yLine;

    public static boolean hasMoreText(int i) {
        return (i & 1) == 0;
    }

    public ColumnText(PdfContentByte pdfContentByte) {
        this.canvas = pdfContentByte;
    }

    public static ColumnText duplicate(ColumnText columnText) {
        ColumnText columnText2 = new ColumnText((PdfContentByte) null);
        columnText2.setACopy(columnText);
        return columnText2;
    }

    public ColumnText setACopy(ColumnText columnText) {
        setSimpleVars(columnText);
        BidiLine bidiLine2 = columnText.bidiLine;
        if (bidiLine2 != null) {
            this.bidiLine = new BidiLine(bidiLine2);
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void setSimpleVars(ColumnText columnText) {
        this.maxY = columnText.maxY;
        this.minY = columnText.minY;
        this.alignment = columnText.alignment;
        this.leftWall = null;
        ArrayList arrayList = columnText.leftWall;
        if (arrayList != null) {
            this.leftWall = new ArrayList(arrayList);
        }
        this.rightWall = null;
        ArrayList arrayList2 = columnText.rightWall;
        if (arrayList2 != null) {
            this.rightWall = new ArrayList(arrayList2);
        }
        this.yLine = columnText.yLine;
        this.currentLeading = columnText.currentLeading;
        this.fixedLeading = columnText.fixedLeading;
        this.multipliedLeading = columnText.multipliedLeading;
        this.canvas = columnText.canvas;
        this.canvases = columnText.canvases;
        this.lineStatus = columnText.lineStatus;
        this.indent = columnText.indent;
        this.followingIndent = columnText.followingIndent;
        this.rightIndent = columnText.rightIndent;
        this.extraParagraphSpace = columnText.extraParagraphSpace;
        this.rectangularWidth = columnText.rectangularWidth;
        this.rectangularMode = columnText.rectangularMode;
        this.spaceCharRatio = columnText.spaceCharRatio;
        this.lastWasNewline = columnText.lastWasNewline;
        this.linesWritten = columnText.linesWritten;
        this.arabicOptions = columnText.arabicOptions;
        this.runDirection = columnText.runDirection;
        this.descender = columnText.descender;
        this.composite = columnText.composite;
        this.splittedRow = columnText.splittedRow;
        if (columnText.composite) {
            this.compositeElements = new LinkedList(columnText.compositeElements);
            if (this.splittedRow) {
                this.compositeElements.set(0, new PdfPTable((PdfPTable) this.compositeElements.getFirst()));
            }
            ColumnText columnText2 = columnText.compositeColumn;
            if (columnText2 != null) {
                this.compositeColumn = duplicate(columnText2);
            }
        }
        this.listIdx = columnText.listIdx;
        this.firstLineY = columnText.firstLineY;
        this.leftX = columnText.leftX;
        this.rightX = columnText.rightX;
        this.firstLineYDone = columnText.firstLineYDone;
        this.waitPhrase = columnText.waitPhrase;
        this.useAscender = columnText.useAscender;
        this.filledWidth = columnText.filledWidth;
        this.adjustFirstLine = columnText.adjustFirstLine;
    }

    private void addWaitingPhrase() {
        if (this.bidiLine == null && this.waitPhrase != null) {
            this.bidiLine = new BidiLine();
            Iterator it = this.waitPhrase.getChunks().iterator();
            while (it.hasNext()) {
                this.bidiLine.addChunk(new PdfChunk((Chunk) it.next(), (PdfAction) null));
            }
            this.waitPhrase = null;
        }
    }

    public void addText(Phrase phrase) {
        if (phrase != null && !this.composite) {
            addWaitingPhrase();
            if (this.bidiLine == null) {
                this.waitPhrase = phrase;
                return;
            }
            Iterator it = phrase.getChunks().iterator();
            while (it.hasNext()) {
                this.bidiLine.addChunk(new PdfChunk((Chunk) it.next(), (PdfAction) null));
            }
        }
    }

    public void setText(Phrase phrase) {
        this.bidiLine = null;
        this.composite = false;
        this.compositeColumn = null;
        this.compositeElements = null;
        this.listIdx = 0;
        this.splittedRow = false;
        this.waitPhrase = phrase;
    }

    public void addText(Chunk chunk) {
        if (chunk != null && !this.composite) {
            addText(new Phrase(chunk));
        }
    }

    public void addElement(Element element) {
        Element element2;
        if (element != null) {
            if (element instanceof Image) {
                Image image = (Image) element;
                PdfPTable pdfPTable = new PdfPTable(1);
                float widthPercentage = image.getWidthPercentage();
                if (widthPercentage == 0.0f) {
                    pdfPTable.setTotalWidth(image.getScaledWidth());
                    pdfPTable.setLockedWidth(true);
                } else {
                    pdfPTable.setWidthPercentage(widthPercentage);
                }
                pdfPTable.setSpacingAfter(image.getSpacingAfter());
                pdfPTable.setSpacingBefore(image.getSpacingBefore());
                int alignment2 = image.getAlignment();
                if (alignment2 == 0) {
                    pdfPTable.setHorizontalAlignment(0);
                } else if (alignment2 != 2) {
                    pdfPTable.setHorizontalAlignment(1);
                } else {
                    pdfPTable.setHorizontalAlignment(2);
                }
                PdfPCell pdfPCell = new PdfPCell(image, true);
                pdfPCell.setPadding(0.0f);
                pdfPCell.setBorder(image.getBorder());
                pdfPCell.setBorderColor(image.getBorderColor());
                pdfPCell.setBorderWidth(image.getBorderWidth());
                pdfPCell.setBackgroundColor(image.getBackgroundColor());
                pdfPTable.addCell(pdfPCell);
                element = pdfPTable;
            }
            if (element.type() == 10) {
                element2 = new Paragraph((Chunk) element);
            } else {
                element2 = element.type() == 11 ? new Paragraph((Phrase) element) : element;
            }
            if (element2 instanceof SimpleTable) {
                try {
                    element2 = ((SimpleTable) element2).createPdfPTable();
                } catch (DocumentException unused) {
                    throw new IllegalArgumentException("Element not allowed.");
                }
            } else if (!(element2.type() == 12 || element2.type() == 14 || element2.type() == 23 || element2.type() == 55)) {
                throw new IllegalArgumentException("Element not allowed.");
            }
            if (!this.composite) {
                this.composite = true;
                this.compositeElements = new LinkedList();
                this.bidiLine = null;
                this.waitPhrase = null;
            }
            this.compositeElements.add(element2);
        }
    }

    /* access modifiers changed from: protected */
    public ArrayList convertColumn(float[] fArr) {
        if (fArr.length >= 4) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i < fArr.length - 2) {
                float f = fArr[i];
                float f2 = fArr[i + 1];
                int i2 = i + 2;
                float f3 = fArr[i2];
                float f4 = fArr[i + 3];
                if (f2 != f4) {
                    float f5 = (f - f3) / (f2 - f4);
                    float[] fArr2 = {Math.min(f2, f4), Math.max(f2, f4), f5, f - (f5 * f2)};
                    arrayList.add(fArr2);
                    this.maxY = Math.max(this.maxY, fArr2[1]);
                    this.minY = Math.min(this.minY, fArr2[0]);
                }
                i = i2;
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
            throw new RuntimeException("No valid column line found.");
        }
        throw new RuntimeException("No valid column line found.");
    }

    /* access modifiers changed from: protected */
    public float findLimitsPoint(ArrayList arrayList) {
        this.lineStatus = 0;
        float f = this.yLine;
        if (f < this.minY || f > this.maxY) {
            this.lineStatus = 1;
            return 0.0f;
        }
        for (int i = 0; i < arrayList.size(); i++) {
            float[] fArr = (float[]) arrayList.get(i);
            float f2 = this.yLine;
            if (f2 >= fArr[0] && f2 <= fArr[1]) {
                return (fArr[2] * f2) + fArr[3];
            }
        }
        this.lineStatus = 2;
        return 0.0f;
    }

    /* access modifiers changed from: protected */
    public float[] findLimitsOneLine() {
        float findLimitsPoint = findLimitsPoint(this.leftWall);
        int i = this.lineStatus;
        if (i == 1 || i == 2) {
            return null;
        }
        float findLimitsPoint2 = findLimitsPoint(this.rightWall);
        if (this.lineStatus == 2) {
            return null;
        }
        return new float[]{findLimitsPoint, findLimitsPoint2};
    }

    /* access modifiers changed from: protected */
    public float[] findLimitsTwoLines() {
        boolean z = false;
        while (true) {
            if (z && this.currentLeading == 0.0f) {
                return null;
            }
            float[] findLimitsOneLine = findLimitsOneLine();
            int i = this.lineStatus;
            if (i == 1) {
                return null;
            }
            this.yLine -= this.currentLeading;
            if (i != 2) {
                float[] findLimitsOneLine2 = findLimitsOneLine();
                int i2 = this.lineStatus;
                if (i2 == 1) {
                    return null;
                }
                if (i2 == 2) {
                    this.yLine -= this.currentLeading;
                } else if (findLimitsOneLine[0] < findLimitsOneLine2[1] && findLimitsOneLine2[0] < findLimitsOneLine[1]) {
                    return new float[]{findLimitsOneLine[0], findLimitsOneLine[1], findLimitsOneLine2[0], findLimitsOneLine2[1]};
                }
            }
            z = true;
        }
    }

    public void setColumns(float[] fArr, float[] fArr2) {
        this.maxY = -1.0E21f;
        this.minY = 1.0E21f;
        setYLine(Math.max(fArr[1], fArr[fArr.length - 1]));
        this.rightWall = convertColumn(fArr2);
        this.leftWall = convertColumn(fArr);
        this.rectangularWidth = -1.0f;
        this.rectangularMode = false;
    }

    public void setSimpleColumn(Phrase phrase, float f, float f2, float f3, float f4, float f5, int i) {
        addText(phrase);
        setSimpleColumn(f, f2, f3, f4, f5, i);
    }

    public void setSimpleColumn(float f, float f2, float f3, float f4, float f5, int i) {
        setLeading(f5);
        this.alignment = i;
        setSimpleColumn(f, f2, f3, f4);
    }

    public void setSimpleColumn(float f, float f2, float f3, float f4) {
        this.leftX = Math.min(f, f3);
        this.maxY = Math.max(f2, f4);
        this.minY = Math.min(f2, f4);
        this.rightX = Math.max(f, f3);
        this.yLine = this.maxY;
        this.rectangularWidth = this.rightX - this.leftX;
        if (this.rectangularWidth < 0.0f) {
            this.rectangularWidth = 0.0f;
        }
        this.rectangularMode = true;
    }

    public void setLeading(float f) {
        this.fixedLeading = f;
        this.multipliedLeading = 0.0f;
    }

    public void setLeading(float f, float f2) {
        this.fixedLeading = f;
        this.multipliedLeading = f2;
    }

    public float getLeading() {
        return this.fixedLeading;
    }

    public float getMultipliedLeading() {
        return this.multipliedLeading;
    }

    public void setYLine(float f) {
        this.yLine = f;
    }

    public float getYLine() {
        return this.yLine;
    }

    public void setAlignment(int i) {
        this.alignment = i;
    }

    public int getAlignment() {
        return this.alignment;
    }

    public void setIndent(float f) {
        this.indent = f;
        this.lastWasNewline = true;
    }

    public float getIndent() {
        return this.indent;
    }

    public void setFollowingIndent(float f) {
        this.followingIndent = f;
        this.lastWasNewline = true;
    }

    public float getFollowingIndent() {
        return this.followingIndent;
    }

    public void setRightIndent(float f) {
        this.rightIndent = f;
        this.lastWasNewline = true;
    }

    public float getRightIndent() {
        return this.rightIndent;
    }

    /* renamed from: go */
    public int mo52494go() throws DocumentException {
        return mo52495go(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008b, code lost:
        r2 = 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x011b, code lost:
        r0.bidiLine.restore();
     */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01c8  */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x01cb  */
    /* renamed from: go */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo52495go(boolean r24) throws com.lowagie.text.DocumentException {
        /*
            r23 = this;
            r0 = r23
            boolean r1 = r0.composite
            if (r1 == 0) goto L_0x000b
            int r1 = r23.goComposite(r24)
            return r1
        L_0x000b:
            r23.addWaitingPhrase()
            com.lowagie.text.pdf.BidiLine r1 = r0.bidiLine
            r2 = 1
            if (r1 != 0) goto L_0x0014
            return r2
        L_0x0014:
            r1 = 0
            r0.descender = r1
            r3 = 0
            r0.linesWritten = r3
            float r4 = r0.spaceCharRatio
            r5 = 2
            java.lang.Object[] r12 = new java.lang.Object[r5]
            java.lang.Float r6 = new java.lang.Float
            r6.<init>(r1)
            r12[r2] = r6
            r6 = 2143289344(0x7fc00000, float:NaN)
            r0.firstLineY = r6
            int r6 = r0.runDirection
            if (r6 == 0) goto L_0x0031
            r19 = r6
            goto L_0x0033
        L_0x0031:
            r19 = 1
        L_0x0033:
            com.lowagie.text.pdf.PdfContentByte r6 = r0.canvas
            r7 = 0
            if (r6 == 0) goto L_0x0048
            com.lowagie.text.pdf.PdfDocument r8 = r6.getPdfDocument()
            com.lowagie.text.pdf.PdfContentByte r9 = r0.canvas
            com.lowagie.text.pdf.PdfContentByte r9 = r9.getDuplicate()
            r21 = r6
            r20 = r8
            r11 = r9
            goto L_0x004f
        L_0x0048:
            if (r24 == 0) goto L_0x01de
            r11 = r7
            r20 = r11
            r21 = r20
        L_0x004f:
            r6 = 981668463(0x3a83126f, float:0.001)
            if (r24 != 0) goto L_0x0068
            int r8 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r8 != 0) goto L_0x0061
            com.lowagie.text.pdf.PdfWriter r4 = r11.getPdfWriter()
            float r4 = r4.getSpaceCharRatio()
            goto L_0x0068
        L_0x0061:
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 >= 0) goto L_0x0068
            r4 = 981668463(0x3a83126f, float:0.001)
        L_0x0068:
            r6 = 0
        L_0x0069:
            boolean r8 = r0.lastWasNewline
            if (r8 == 0) goto L_0x0070
            float r8 = r0.indent
            goto L_0x0072
        L_0x0070:
            float r8 = r0.followingIndent
        L_0x0072:
            boolean r9 = r0.rectangularMode
            r10 = 3
            if (r9 == 0) goto L_0x0122
            float r9 = r0.rectangularWidth
            float r13 = r0.rightIndent
            float r13 = r13 + r8
            int r9 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r9 > 0) goto L_0x008e
            com.lowagie.text.pdf.BidiLine r1 = r0.bidiLine
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x008b
            r2 = 3
            goto L_0x0181
        L_0x008b:
            r2 = 2
            goto L_0x0181
        L_0x008e:
            com.lowagie.text.pdf.BidiLine r9 = r0.bidiLine
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x0098
            goto L_0x0181
        L_0x0098:
            com.lowagie.text.pdf.BidiLine r13 = r0.bidiLine
            float r14 = r0.leftX
            float r9 = r0.rectangularWidth
            float r9 = r9 - r8
            float r10 = r0.rightIndent
            float r15 = r9 - r10
            int r9 = r0.alignment
            int r10 = r0.arabicOptions
            r16 = r9
            r17 = r19
            r18 = r10
            com.lowagie.text.pdf.PdfLine r9 = r13.processLine(r14, r15, r16, r17, r18)
            if (r9 != 0) goto L_0x00b5
            goto L_0x0181
        L_0x00b5:
            float[] r10 = r9.getMaxSize()
            boolean r13 = r23.isUseAscender()
            if (r13 == 0) goto L_0x00ce
            float r13 = r0.firstLineY
            boolean r13 = java.lang.Float.isNaN(r13)
            if (r13 == 0) goto L_0x00ce
            float r10 = r9.getAscender()
            r0.currentLeading = r10
            goto L_0x00df
        L_0x00ce:
            float r13 = r0.fixedLeading
            r14 = r10[r3]
            float r15 = r0.multipliedLeading
            float r14 = r14 * r15
            float r13 = r13 + r14
            r10 = r10[r2]
            float r10 = java.lang.Math.max(r13, r10)
            r0.currentLeading = r10
        L_0x00df:
            float r10 = r0.yLine
            float r13 = r0.maxY
            int r13 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r13 > 0) goto L_0x011b
            float r13 = r0.currentLeading
            float r14 = r10 - r13
            float r15 = r0.minY
            int r14 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1))
            if (r14 >= 0) goto L_0x00f2
            goto L_0x011b
        L_0x00f2:
            float r10 = r10 - r13
            r0.yLine = r10
            if (r24 != 0) goto L_0x00fd
            if (r6 != 0) goto L_0x00fd
            r11.beginText()
            r6 = 1
        L_0x00fd:
            float r10 = r0.firstLineY
            boolean r10 = java.lang.Float.isNaN(r10)
            if (r10 == 0) goto L_0x0109
            float r10 = r0.yLine
            r0.firstLineY = r10
        L_0x0109:
            float r10 = r0.rectangularWidth
            float r13 = r9.widthLeft()
            float r10 = r10 - r13
            r0.updateFilledWidth(r10)
            float r10 = r0.leftX
            r14 = r6
            r13 = r9
            r22 = r10
            goto L_0x018e
        L_0x011b:
            com.lowagie.text.pdf.BidiLine r1 = r0.bidiLine
            r1.restore()
            goto L_0x008b
        L_0x0122:
            float r9 = r0.yLine
            float[] r13 = r23.findLimitsTwoLines()
            if (r13 != 0) goto L_0x0138
            com.lowagie.text.pdf.BidiLine r1 = r0.bidiLine
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0134
            r2 = 3
            goto L_0x0135
        L_0x0134:
            r2 = 2
        L_0x0135:
            r0.yLine = r9
            goto L_0x0181
        L_0x0138:
            com.lowagie.text.pdf.BidiLine r14 = r0.bidiLine
            boolean r14 = r14.isEmpty()
            if (r14 == 0) goto L_0x0143
            r0.yLine = r9
            goto L_0x0181
        L_0x0143:
            r14 = r13[r3]
            r15 = r13[r5]
            float r22 = java.lang.Math.max(r14, r15)
            r14 = r13[r2]
            r10 = r13[r10]
            float r10 = java.lang.Math.min(r14, r10)
            float r10 = r10 - r22
            float r13 = r0.rightIndent
            float r13 = r13 + r8
            int r13 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r13 > 0) goto L_0x015e
            goto L_0x0069
        L_0x015e:
            if (r24 != 0) goto L_0x0166
            if (r6 != 0) goto L_0x0166
            r11.beginText()
            r6 = 1
        L_0x0166:
            com.lowagie.text.pdf.BidiLine r13 = r0.bidiLine
            float r10 = r10 - r8
            float r14 = r0.rightIndent
            float r15 = r10 - r14
            int r10 = r0.alignment
            int r14 = r0.arabicOptions
            r18 = r14
            r14 = r22
            r16 = r10
            r17 = r19
            com.lowagie.text.pdf.PdfLine r10 = r13.processLine(r14, r15, r16, r17, r18)
            if (r10 != 0) goto L_0x018c
            r0.yLine = r9
        L_0x0181:
            if (r6 == 0) goto L_0x018b
            r11.endText()
            com.lowagie.text.pdf.PdfContentByte r1 = r0.canvas
            r1.add(r11)
        L_0x018b:
            return r2
        L_0x018c:
            r14 = r6
            r13 = r10
        L_0x018e:
            if (r24 != 0) goto L_0x01b9
            r12[r3] = r7
            boolean r6 = r13.isRTL()
            if (r6 == 0) goto L_0x019a
            float r8 = r0.rightIndent
        L_0x019a:
            float r22 = r22 + r8
            float r6 = r13.indentLeft()
            float r6 = r22 + r6
            float r7 = r0.yLine
            r11.setTextMatrix(r6, r7)
            r6 = r20
            r7 = r13
            r8 = r11
            r9 = r21
            r10 = r12
            r15 = r11
            r11 = r4
            r6.writeLineToContent(r7, r8, r9, r10, r11)
            r6 = r12[r3]
            com.lowagie.text.pdf.PdfFont r6 = (com.lowagie.text.pdf.PdfFont) r6
            r7 = r6
            goto L_0x01ba
        L_0x01b9:
            r15 = r11
        L_0x01ba:
            boolean r6 = r13.isNewlineSplit()
            r0.lastWasNewline = r6
            float r6 = r0.yLine
            boolean r8 = r13.isNewlineSplit()
            if (r8 == 0) goto L_0x01cb
            float r8 = r0.extraParagraphSpace
            goto L_0x01cc
        L_0x01cb:
            r8 = 0
        L_0x01cc:
            float r6 = r6 - r8
            r0.yLine = r6
            int r6 = r0.linesWritten
            int r6 = r6 + r2
            r0.linesWritten = r6
            float r6 = r13.getDescender()
            r0.descender = r6
            r6 = r14
            r11 = r15
            goto L_0x0069
        L_0x01de:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "ColumnText.go with simulate==false and text==null."
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.ColumnText.mo52495go(boolean):int");
    }

    public float getExtraParagraphSpace() {
        return this.extraParagraphSpace;
    }

    public void setExtraParagraphSpace(float f) {
        this.extraParagraphSpace = f;
    }

    public void clearChunks() {
        BidiLine bidiLine2 = this.bidiLine;
        if (bidiLine2 != null) {
            bidiLine2.clearChunks();
        }
    }

    public float getSpaceCharRatio() {
        return this.spaceCharRatio;
    }

    public void setSpaceCharRatio(float f) {
        this.spaceCharRatio = f;
    }

    public void setRunDirection(int i) {
        if (i < 0 || i > 3) {
            throw new RuntimeException("Invalid run direction: " + i);
        }
        this.runDirection = i;
    }

    public int getRunDirection() {
        return this.runDirection;
    }

    public int getLinesWritten() {
        return this.linesWritten;
    }

    public int getArabicOptions() {
        return this.arabicOptions;
    }

    public void setArabicOptions(int i) {
        this.arabicOptions = i;
    }

    public float getDescender() {
        return this.descender;
    }

    public static float getWidth(Phrase phrase, int i, int i2) {
        ColumnText columnText = new ColumnText((PdfContentByte) null);
        columnText.addText(phrase);
        columnText.addWaitingPhrase();
        PdfLine processLine = columnText.bidiLine.processLine(0.0f, 20000.0f, 0, i, i2);
        if (processLine == null) {
            return 0.0f;
        }
        return 20000.0f - processLine.widthLeft();
    }

    public static float getWidth(Phrase phrase) {
        return getWidth(phrase, 1, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0087, code lost:
        if (r3 == 2) goto L_0x008b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void showTextAligned(com.lowagie.text.pdf.PdfContentByte r18, int r19, com.lowagie.text.Phrase r20, float r21, float r22, float r23, int r24, int r25) {
        /*
            r0 = r19
            r1 = r23
            r7 = r24
            r8 = 0
            r9 = 2
            if (r0 == 0) goto L_0x0011
            r2 = 1
            if (r0 == r2) goto L_0x0011
            if (r0 == r9) goto L_0x0011
            r15 = 0
            goto L_0x0012
        L_0x0011:
            r15 = r0
        L_0x0012:
            r18.saveState()
            com.lowagie.text.pdf.ColumnText r14 = new com.lowagie.text.pdf.ColumnText
            r13 = r18
            r14.<init>(r13)
            r10 = -1082130432(0xffffffffbf800000, float:-1.0)
            r11 = 1073741824(0x40000000, float:2.0)
            r0 = 1184645120(0x469c4000, float:20000.0)
            r2 = -962838528(0xffffffffc69c4000, float:-20000.0)
            r3 = 0
            if (r15 == 0) goto L_0x0038
            if (r15 == r9) goto L_0x0032
            r12 = -962838528(0xffffffffc69c4000, float:-20000.0)
        L_0x002e:
            r16 = 1184645120(0x469c4000, float:20000.0)
            goto L_0x003a
        L_0x0032:
            r12 = -962838528(0xffffffffc69c4000, float:-20000.0)
            r16 = 0
            goto L_0x003a
        L_0x0038:
            r12 = 0
            goto L_0x002e
        L_0x003a:
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0047
            float r12 = r12 + r21
            float r0 = r22 + r10
            float r16 = r16 + r21
            float r1 = r22 + r11
            goto L_0x006e
        L_0x0047:
            double r0 = (double) r1
            r2 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r0 = r0 * r2
            r2 = 4640537203540230144(0x4066800000000000, double:180.0)
            double r0 = r0 / r2
            double r2 = java.lang.Math.cos(r0)
            float r4 = (float) r2
            double r0 = java.lang.Math.sin(r0)
            float r2 = (float) r0
            float r3 = -r2
            r0 = r18
            r1 = r4
            r5 = r21
            r6 = r22
            r0.concatCTM(r1, r2, r3, r4, r5, r6)
            r0 = -1082130432(0xffffffffbf800000, float:-1.0)
            r1 = 1073741824(0x40000000, float:2.0)
        L_0x006e:
            r2 = 1073741824(0x40000000, float:2.0)
            r10 = r14
            r11 = r20
            r13 = r0
            r0 = r14
            r14 = r16
            r3 = r15
            r15 = r1
            r16 = r2
            r17 = r3
            r10.setSimpleColumn(r11, r12, r13, r14, r15, r16, r17)
            r1 = 3
            if (r7 != r1) goto L_0x008a
            if (r3 != 0) goto L_0x0087
            r8 = 2
            goto L_0x008b
        L_0x0087:
            if (r3 != r9) goto L_0x008a
            goto L_0x008b
        L_0x008a:
            r8 = r3
        L_0x008b:
            r0.setAlignment(r8)
            r1 = r25
            r0.setArabicOptions(r1)
            r0.setRunDirection(r7)
            r0.mo52494go()     // Catch:{ DocumentException -> 0x009d }
            r18.restoreState()
            return
        L_0x009d:
            r0 = move-exception
            r1 = r0
            com.lowagie.text.ExceptionConverter r0 = new com.lowagie.text.ExceptionConverter
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.ColumnText.showTextAligned(com.lowagie.text.pdf.PdfContentByte, int, com.lowagie.text.Phrase, float, float, float, int, int):void");
    }

    public static void showTextAligned(PdfContentByte pdfContentByte, int i, Phrase phrase, float f, float f2, float f3) {
        showTextAligned(pdfContentByte, i, phrase, f, f2, f3, 1, 0);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v41, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v30, resolved type: com.lowagie.text.ListItem} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0264, code lost:
        r3 = r0.compositeColumn;
        r0.yLine = r3.yLine;
        r0.linesWritten += r3.linesWritten;
        r0.descender = r3.descender;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x027b, code lost:
        if (java.lang.Float.isNaN(r3.firstLineY) != false) goto L_0x02a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0281, code lost:
        if (r0.compositeColumn.firstLineYDone != false) goto L_0x02a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0283, code lost:
        if (r22 != false) goto L_0x02a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0285, code lost:
        r13 = r0.canvas;
        r15 = new com.lowagie.text.Phrase(r4.getListSymbol());
        r3 = r0.compositeColumn;
        showTextAligned(r13, 0, r15, r3.leftX + r12, r3.firstLineY, 0.0f);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x02a0, code lost:
        r0.compositeColumn.firstLineYDone = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x02a6, code lost:
        if ((r7 & 1) == 0) goto L_0x02b8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x02a8, code lost:
        r0.compositeColumn = null;
        r0.listIdx++;
        r0.yLine -= r4.getSpacingAfter();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x02ba, code lost:
        if ((r7 & 2) == 0) goto L_0x013a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x02bc, code lost:
        return 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:257:0x0534, code lost:
        if (r2 > -1.07374182E9f) goto L_0x0538;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:221:0x0488  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0528  */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x054e  */
    /* JADX WARNING: Removed duplicated region for block: B:296:0x0563 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int goComposite(boolean r22) throws com.lowagie.text.DocumentException {
        /*
            r21 = this;
            r0 = r21
            boolean r1 = r0.rectangularMode
            if (r1 == 0) goto L_0x05ab
            r1 = 0
            r0.linesWritten = r1
            r2 = 0
            r0.descender = r2
            boolean r3 = r0.adjustFirstLine
        L_0x000e:
            java.util.LinkedList r4 = r0.compositeElements
            boolean r4 = r4.isEmpty()
            r5 = 1
            if (r4 == 0) goto L_0x0018
            return r5
        L_0x0018:
            java.util.LinkedList r4 = r0.compositeElements
            java.lang.Object r4 = r4.getFirst()
            com.lowagie.text.Element r4 = (com.lowagie.text.Element) r4
            int r6 = r4.type()
            r7 = 12
            r8 = 0
            r9 = 2
            if (r6 != r7) goto L_0x013d
            com.lowagie.text.Paragraph r4 = (com.lowagie.text.Paragraph) r4
            r6 = 0
            r7 = 0
        L_0x002e:
            if (r6 < r9) goto L_0x0032
            goto L_0x0110
        L_0x0032:
            float r7 = r0.yLine
            com.lowagie.text.pdf.ColumnText r10 = r0.compositeColumn
            if (r10 != 0) goto L_0x00b2
            com.lowagie.text.pdf.ColumnText r10 = new com.lowagie.text.pdf.ColumnText
            com.lowagie.text.pdf.PdfContentByte r11 = r0.canvas
            r10.<init>(r11)
            r0.compositeColumn = r10
            com.lowagie.text.pdf.ColumnText r10 = r0.compositeColumn
            if (r3 == 0) goto L_0x0048
            boolean r11 = r0.useAscender
            goto L_0x0049
        L_0x0048:
            r11 = 0
        L_0x0049:
            r10.setUseAscender(r11)
            com.lowagie.text.pdf.ColumnText r10 = r0.compositeColumn
            int r11 = r4.getAlignment()
            r10.setAlignment(r11)
            com.lowagie.text.pdf.ColumnText r10 = r0.compositeColumn
            float r11 = r4.getIndentationLeft()
            float r12 = r4.getFirstLineIndent()
            float r11 = r11 + r12
            r10.setIndent(r11)
            com.lowagie.text.pdf.ColumnText r10 = r0.compositeColumn
            float r11 = r4.getExtraParagraphSpace()
            r10.setExtraParagraphSpace(r11)
            com.lowagie.text.pdf.ColumnText r10 = r0.compositeColumn
            float r11 = r4.getIndentationLeft()
            r10.setFollowingIndent(r11)
            com.lowagie.text.pdf.ColumnText r10 = r0.compositeColumn
            float r11 = r4.getIndentationRight()
            r10.setRightIndent(r11)
            com.lowagie.text.pdf.ColumnText r10 = r0.compositeColumn
            float r11 = r4.getLeading()
            float r12 = r4.getMultipliedLeading()
            r10.setLeading(r11, r12)
            com.lowagie.text.pdf.ColumnText r10 = r0.compositeColumn
            int r11 = r0.runDirection
            r10.setRunDirection(r11)
            com.lowagie.text.pdf.ColumnText r10 = r0.compositeColumn
            int r11 = r0.arabicOptions
            r10.setArabicOptions(r11)
            com.lowagie.text.pdf.ColumnText r10 = r0.compositeColumn
            float r11 = r0.spaceCharRatio
            r10.setSpaceCharRatio(r11)
            com.lowagie.text.pdf.ColumnText r10 = r0.compositeColumn
            r10.addText((com.lowagie.text.Phrase) r4)
            if (r3 != 0) goto L_0x00b0
            float r10 = r0.yLine
            float r11 = r4.getSpacingBefore()
            float r10 = r10 - r11
            r0.yLine = r10
        L_0x00b0:
            r10 = 1
            goto L_0x00b3
        L_0x00b2:
            r10 = 0
        L_0x00b3:
            com.lowagie.text.pdf.ColumnText r11 = r0.compositeColumn
            float r12 = r0.leftX
            r11.leftX = r12
            float r12 = r0.rightX
            r11.rightX = r12
            float r12 = r0.yLine
            r11.yLine = r12
            float r12 = r0.rectangularWidth
            r11.rectangularWidth = r12
            boolean r12 = r0.rectangularMode
            r11.rectangularMode = r12
            float r12 = r0.minY
            r11.minY = r12
            float r12 = r0.maxY
            r11.maxY = r12
            boolean r11 = r4.getKeepTogether()
            if (r11 == 0) goto L_0x00dd
            if (r10 == 0) goto L_0x00dd
            if (r3 != 0) goto L_0x00dd
            r10 = 1
            goto L_0x00de
        L_0x00dd:
            r10 = 0
        L_0x00de:
            com.lowagie.text.pdf.ColumnText r11 = r0.compositeColumn
            if (r22 != 0) goto L_0x00e8
            if (r10 == 0) goto L_0x00e6
            if (r6 == 0) goto L_0x00e8
        L_0x00e6:
            r12 = 0
            goto L_0x00e9
        L_0x00e8:
            r12 = 1
        L_0x00e9:
            int r11 = r11.mo52495go(r12)
            com.lowagie.text.pdf.ColumnText r12 = r0.compositeColumn
            float r12 = r12.filledWidth
            r0.updateFilledWidth(r12)
            r12 = r11 & 1
            if (r12 != 0) goto L_0x00ff
            if (r10 == 0) goto L_0x00ff
            r0.compositeColumn = r8
            r0.yLine = r7
            return r9
        L_0x00ff:
            if (r22 != 0) goto L_0x010f
            if (r10 != 0) goto L_0x0104
            goto L_0x010f
        L_0x0104:
            if (r6 != 0) goto L_0x010a
            r0.compositeColumn = r8
            r0.yLine = r7
        L_0x010a:
            int r6 = r6 + 1
            r7 = r11
            goto L_0x002e
        L_0x010f:
            r7 = r11
        L_0x0110:
            com.lowagie.text.pdf.ColumnText r3 = r0.compositeColumn
            float r5 = r3.yLine
            r0.yLine = r5
            int r5 = r0.linesWritten
            int r6 = r3.linesWritten
            int r5 = r5 + r6
            r0.linesWritten = r5
            float r3 = r3.descender
            r0.descender = r3
            r3 = r7 & 1
            if (r3 == 0) goto L_0x0135
            r0.compositeColumn = r8
            java.util.LinkedList r3 = r0.compositeElements
            r3.removeFirst()
            float r3 = r0.yLine
            float r4 = r4.getSpacingAfter()
            float r3 = r3 - r4
            r0.yLine = r3
        L_0x0135:
            r3 = r7 & 2
            if (r3 == 0) goto L_0x013a
            return r9
        L_0x013a:
            r3 = 0
            goto L_0x000e
        L_0x013d:
            int r6 = r4.type()
            r7 = 14
            if (r6 != r7) goto L_0x0322
            com.lowagie.text.List r4 = (com.lowagie.text.List) r4
            java.util.ArrayList r6 = r4.getItems()
            float r7 = r4.getIndentationLeft()
            java.util.Stack r10 = new java.util.Stack
            r10.<init>()
            r11 = r4
            r12 = r7
            r4 = 0
            r7 = 0
        L_0x0158:
            int r13 = r6.size()
            if (r4 < r13) goto L_0x0160
            r4 = r8
            goto L_0x016f
        L_0x0160:
            java.lang.Object r13 = r6.get(r4)
            boolean r14 = r13 instanceof com.lowagie.text.ListItem
            if (r14 == 0) goto L_0x02c0
            int r14 = r0.listIdx
            if (r7 != r14) goto L_0x02bd
            r4 = r13
            com.lowagie.text.ListItem r4 = (com.lowagie.text.ListItem) r4
        L_0x016f:
            r6 = 0
            r7 = 0
        L_0x0171:
            if (r6 < r9) goto L_0x0175
            goto L_0x0264
        L_0x0175:
            float r7 = r0.yLine
            com.lowagie.text.pdf.ColumnText r10 = r0.compositeColumn
            if (r10 != 0) goto L_0x0206
            if (r4 != 0) goto L_0x0186
            r0.listIdx = r1
            java.util.LinkedList r4 = r0.compositeElements
            r4.removeFirst()
            goto L_0x05a8
        L_0x0186:
            com.lowagie.text.pdf.ColumnText r10 = new com.lowagie.text.pdf.ColumnText
            com.lowagie.text.pdf.PdfContentByte r13 = r0.canvas
            r10.<init>(r13)
            r0.compositeColumn = r10
            com.lowagie.text.pdf.ColumnText r10 = r0.compositeColumn
            if (r3 == 0) goto L_0x0196
            boolean r13 = r0.useAscender
            goto L_0x0197
        L_0x0196:
            r13 = 0
        L_0x0197:
            r10.setUseAscender(r13)
            com.lowagie.text.pdf.ColumnText r10 = r0.compositeColumn
            int r13 = r4.getAlignment()
            r10.setAlignment(r13)
            com.lowagie.text.pdf.ColumnText r10 = r0.compositeColumn
            float r13 = r4.getIndentationLeft()
            float r13 = r13 + r12
            float r14 = r4.getFirstLineIndent()
            float r13 = r13 + r14
            r10.setIndent(r13)
            com.lowagie.text.pdf.ColumnText r10 = r0.compositeColumn
            float r13 = r4.getExtraParagraphSpace()
            r10.setExtraParagraphSpace(r13)
            com.lowagie.text.pdf.ColumnText r10 = r0.compositeColumn
            float r13 = r10.getIndent()
            r10.setFollowingIndent(r13)
            com.lowagie.text.pdf.ColumnText r10 = r0.compositeColumn
            float r13 = r4.getIndentationRight()
            float r14 = r11.getIndentationRight()
            float r13 = r13 + r14
            r10.setRightIndent(r13)
            com.lowagie.text.pdf.ColumnText r10 = r0.compositeColumn
            float r13 = r4.getLeading()
            float r14 = r4.getMultipliedLeading()
            r10.setLeading(r13, r14)
            com.lowagie.text.pdf.ColumnText r10 = r0.compositeColumn
            int r13 = r0.runDirection
            r10.setRunDirection(r13)
            com.lowagie.text.pdf.ColumnText r10 = r0.compositeColumn
            int r13 = r0.arabicOptions
            r10.setArabicOptions(r13)
            com.lowagie.text.pdf.ColumnText r10 = r0.compositeColumn
            float r13 = r0.spaceCharRatio
            r10.setSpaceCharRatio(r13)
            com.lowagie.text.pdf.ColumnText r10 = r0.compositeColumn
            r10.addText((com.lowagie.text.Phrase) r4)
            if (r3 != 0) goto L_0x0204
            float r10 = r0.yLine
            float r13 = r4.getSpacingBefore()
            float r10 = r10 - r13
            r0.yLine = r10
        L_0x0204:
            r10 = 1
            goto L_0x0207
        L_0x0206:
            r10 = 0
        L_0x0207:
            com.lowagie.text.pdf.ColumnText r13 = r0.compositeColumn
            float r14 = r0.leftX
            r13.leftX = r14
            float r14 = r0.rightX
            r13.rightX = r14
            float r14 = r0.yLine
            r13.yLine = r14
            float r14 = r0.rectangularWidth
            r13.rectangularWidth = r14
            boolean r14 = r0.rectangularMode
            r13.rectangularMode = r14
            float r14 = r0.minY
            r13.minY = r14
            float r14 = r0.maxY
            r13.maxY = r14
            boolean r13 = r4.getKeepTogether()
            if (r13 == 0) goto L_0x0231
            if (r10 == 0) goto L_0x0231
            if (r3 != 0) goto L_0x0231
            r10 = 1
            goto L_0x0232
        L_0x0231:
            r10 = 0
        L_0x0232:
            com.lowagie.text.pdf.ColumnText r13 = r0.compositeColumn
            if (r22 != 0) goto L_0x023c
            if (r10 == 0) goto L_0x023a
            if (r6 == 0) goto L_0x023c
        L_0x023a:
            r14 = 0
            goto L_0x023d
        L_0x023c:
            r14 = 1
        L_0x023d:
            int r13 = r13.mo52495go(r14)
            com.lowagie.text.pdf.ColumnText r14 = r0.compositeColumn
            float r14 = r14.filledWidth
            r0.updateFilledWidth(r14)
            r14 = r13 & 1
            if (r14 != 0) goto L_0x0253
            if (r10 == 0) goto L_0x0253
            r0.compositeColumn = r8
            r0.yLine = r7
            return r9
        L_0x0253:
            if (r22 != 0) goto L_0x0263
            if (r10 != 0) goto L_0x0258
            goto L_0x0263
        L_0x0258:
            if (r6 != 0) goto L_0x025e
            r0.compositeColumn = r8
            r0.yLine = r7
        L_0x025e:
            int r6 = r6 + 1
            r7 = r13
            goto L_0x0171
        L_0x0263:
            r7 = r13
        L_0x0264:
            com.lowagie.text.pdf.ColumnText r3 = r0.compositeColumn
            float r6 = r3.yLine
            r0.yLine = r6
            int r6 = r0.linesWritten
            int r10 = r3.linesWritten
            int r6 = r6 + r10
            r0.linesWritten = r6
            float r6 = r3.descender
            r0.descender = r6
            float r3 = r3.firstLineY
            boolean r3 = java.lang.Float.isNaN(r3)
            if (r3 != 0) goto L_0x02a4
            com.lowagie.text.pdf.ColumnText r3 = r0.compositeColumn
            boolean r3 = r3.firstLineYDone
            if (r3 != 0) goto L_0x02a4
            if (r22 != 0) goto L_0x02a0
            com.lowagie.text.pdf.PdfContentByte r13 = r0.canvas
            r14 = 0
            com.lowagie.text.Phrase r15 = new com.lowagie.text.Phrase
            com.lowagie.text.Chunk r3 = r4.getListSymbol()
            r15.<init>((com.lowagie.text.Chunk) r3)
            com.lowagie.text.pdf.ColumnText r3 = r0.compositeColumn
            float r6 = r3.leftX
            float r16 = r6 + r12
            float r3 = r3.firstLineY
            r18 = 0
            r17 = r3
            showTextAligned(r13, r14, r15, r16, r17, r18)
        L_0x02a0:
            com.lowagie.text.pdf.ColumnText r3 = r0.compositeColumn
            r3.firstLineYDone = r5
        L_0x02a4:
            r3 = r7 & 1
            if (r3 == 0) goto L_0x02b8
            r0.compositeColumn = r8
            int r3 = r0.listIdx
            int r3 = r3 + r5
            r0.listIdx = r3
            float r3 = r0.yLine
            float r4 = r4.getSpacingAfter()
            float r3 = r3 - r4
            r0.yLine = r3
        L_0x02b8:
            r3 = r7 & 2
            if (r3 == 0) goto L_0x013a
            return r9
        L_0x02bd:
            int r7 = r7 + 1
            goto L_0x02ea
        L_0x02c0:
            boolean r14 = r13 instanceof com.lowagie.text.List
            if (r14 == 0) goto L_0x02ea
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r1] = r11
            java.lang.Integer r11 = new java.lang.Integer
            r11.<init>(r4)
            r6[r5] = r11
            java.lang.Float r4 = new java.lang.Float
            r4.<init>(r12)
            r6[r9] = r4
            r10.push(r6)
            com.lowagie.text.List r13 = (com.lowagie.text.List) r13
            java.util.ArrayList r4 = r13.getItems()
            float r6 = r13.getIndentationLeft()
            float r12 = r12 + r6
            r6 = -1
            r6 = r4
            r11 = r13
            r4 = -1
            goto L_0x031f
        L_0x02ea:
            int r13 = r6.size()
            int r13 = r13 - r5
            if (r4 != r13) goto L_0x031f
            boolean r13 = r10.isEmpty()
            if (r13 != 0) goto L_0x031f
            java.lang.Object r4 = r10.pop()
            java.lang.Object[] r4 = (java.lang.Object[]) r4
            r6 = r4[r1]
            com.lowagie.text.List r6 = (com.lowagie.text.List) r6
            java.util.ArrayList r11 = r6.getItems()
            r12 = r4[r5]
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            r4 = r4[r9]
            java.lang.Float r4 = (java.lang.Float) r4
            float r4 = r4.floatValue()
            r19 = r12
            r12 = r4
            r4 = r19
            r20 = r11
            r11 = r6
            r6 = r20
        L_0x031f:
            int r4 = r4 + r5
            goto L_0x0158
        L_0x0322:
            int r6 = r4.type()
            r7 = 23
            if (r6 != r7) goto L_0x0581
            float r6 = r0.yLine
            float r7 = r0.minY
            int r7 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r7 < 0) goto L_0x0580
            float r7 = r0.maxY
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r6 <= 0) goto L_0x033a
            goto L_0x0580
        L_0x033a:
            com.lowagie.text.pdf.PdfPTable r4 = (com.lowagie.text.pdf.PdfPTable) r4
            int r6 = r4.size()
            int r7 = r4.getHeaderRows()
            if (r6 > r7) goto L_0x034d
            java.util.LinkedList r4 = r0.compositeElements
            r4.removeFirst()
            goto L_0x05a8
        L_0x034d:
            float r6 = r0.yLine
            if (r3 != 0) goto L_0x035a
            int r7 = r0.listIdx
            if (r7 != 0) goto L_0x035a
            float r7 = r4.spacingBefore()
            float r6 = r6 - r7
        L_0x035a:
            r14 = r6
            float r6 = r0.minY
            int r6 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r6 < 0) goto L_0x0580
            float r6 = r0.maxY
            int r6 = (r14 > r6 ? 1 : (r14 == r6 ? 0 : -1))
            if (r6 <= 0) goto L_0x0369
            goto L_0x0580
        L_0x0369:
            r0.currentLeading = r2
            float r6 = r0.leftX
            boolean r7 = r4.isLockedWidth()
            if (r7 == 0) goto L_0x037b
            float r7 = r4.getTotalWidth()
            r0.updateFilledWidth(r7)
            goto L_0x0389
        L_0x037b:
            float r7 = r0.rectangularWidth
            float r10 = r4.getWidthPercentage()
            float r7 = r7 * r10
            r10 = 1120403456(0x42c80000, float:100.0)
            float r7 = r7 / r10
            r4.setTotalWidth((float) r7)
        L_0x0389:
            int r10 = r4.getHeaderRows()
            int r11 = r4.getFooterRows()
            if (r11 <= r10) goto L_0x0394
            r11 = r10
        L_0x0394:
            int r12 = r10 - r11
            float r13 = r4.getHeaderHeight()
            float r16 = r4.getFooterHeight()
            if (r3 != 0) goto L_0x03ad
            boolean r15 = r4.isSkipFirstHeader()
            if (r15 == 0) goto L_0x03ad
            int r15 = r0.listIdx
            if (r15 > r10) goto L_0x03ad
            r17 = 1
            goto L_0x03af
        L_0x03ad:
            r17 = 0
        L_0x03af:
            if (r17 != 0) goto L_0x03c9
            float r13 = r14 - r13
            float r15 = r0.minY
            int r15 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r15 < 0) goto L_0x03bf
            float r15 = r0.maxY
            int r15 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r15 <= 0) goto L_0x03ca
        L_0x03bf:
            if (r3 == 0) goto L_0x03c8
            java.util.LinkedList r4 = r0.compositeElements
            r4.removeFirst()
            goto L_0x05a8
        L_0x03c8:
            return r9
        L_0x03c9:
            r13 = r14
        L_0x03ca:
            int r15 = r0.listIdx
            if (r15 >= r10) goto L_0x03d0
            r0.listIdx = r10
        L_0x03d0:
            boolean r15 = r4.isComplete()
            if (r15 != 0) goto L_0x03d8
            float r13 = r13 - r16
        L_0x03d8:
            int r15 = r0.listIdx
        L_0x03da:
            int r2 = r4.size()
            if (r15 < r2) goto L_0x03e1
            goto L_0x03ed
        L_0x03e1:
            float r2 = r4.getRowHeight(r15)
            float r2 = r13 - r2
            float r9 = r0.minY
            int r9 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r9 >= 0) goto L_0x057a
        L_0x03ed:
            boolean r2 = r4.isComplete()
            if (r2 != 0) goto L_0x03f5
            float r13 = r13 + r16
        L_0x03f5:
            int r2 = r4.size()
            if (r15 >= r2) goto L_0x0484
            boolean r2 = r4.isSplitRows()
            if (r2 == 0) goto L_0x044f
            boolean r2 = r4.isSplitLate()
            if (r2 == 0) goto L_0x040d
            int r2 = r0.listIdx
            if (r15 != r2) goto L_0x044f
            if (r3 == 0) goto L_0x044f
        L_0x040d:
            boolean r2 = r0.splittedRow
            if (r2 != 0) goto L_0x042d
            r0.splittedRow = r5
            com.lowagie.text.pdf.PdfPTable r2 = new com.lowagie.text.pdf.PdfPTable
            r2.<init>((com.lowagie.text.pdf.PdfPTable) r4)
            java.util.LinkedList r3 = r0.compositeElements
            r3.set(r1, r2)
            java.util.ArrayList r3 = r2.getRows()
        L_0x0421:
            int r4 = r0.listIdx
            if (r10 < r4) goto L_0x0427
            r4 = r2
            goto L_0x042d
        L_0x0427:
            r3.set(r10, r8)
            int r10 = r10 + 1
            goto L_0x0421
        L_0x042d:
            float r2 = r0.minY
            float r2 = r13 - r2
            com.lowagie.text.pdf.PdfPRow r3 = r4.getRow(r15)
            com.lowagie.text.pdf.PdfPRow r2 = r3.splitRow(r4, r15, r2)
            if (r2 != 0) goto L_0x0441
            int r2 = r0.listIdx
            if (r15 != r2) goto L_0x044c
            r2 = 2
            return r2
        L_0x0441:
            float r13 = r0.minY
            java.util.ArrayList r3 = r4.getRows()
            int r15 = r15 + 1
            r3.add(r15, r2)
        L_0x044c:
            r3 = r15
            r2 = 2
            goto L_0x0486
        L_0x044f:
            boolean r2 = r4.isSplitRows()
            if (r2 != 0) goto L_0x0464
            int r2 = r0.listIdx
            if (r15 != r2) goto L_0x0464
            if (r3 == 0) goto L_0x0464
            java.util.LinkedList r2 = r0.compositeElements
            r2.removeFirst()
            r0.splittedRow = r1
            goto L_0x05a8
        L_0x0464:
            int r2 = r0.listIdx
            if (r15 != r2) goto L_0x0484
            if (r3 != 0) goto L_0x0484
            boolean r2 = r4.isSplitRows()
            if (r2 == 0) goto L_0x0476
            boolean r2 = r4.isSplitLate()
            if (r2 == 0) goto L_0x0484
        L_0x0476:
            int r2 = r4.getFooterRows()
            if (r2 == 0) goto L_0x0482
            boolean r2 = r4.isComplete()
            if (r2 == 0) goto L_0x0484
        L_0x0482:
            r2 = 2
            return r2
        L_0x0484:
            r2 = 2
            r3 = r15
        L_0x0486:
            if (r22 != 0) goto L_0x0528
            int r9 = r4.getHorizontalAlignment()
            if (r9 == 0) goto L_0x049c
            if (r9 == r2) goto L_0x0498
            float r2 = r0.rectangularWidth
            float r2 = r2 - r7
            r7 = 1073741824(0x40000000, float:2.0)
            float r2 = r2 / r7
        L_0x0496:
            float r6 = r6 + r2
            goto L_0x049c
        L_0x0498:
            float r2 = r0.rectangularWidth
            float r2 = r2 - r7
            goto L_0x0496
        L_0x049c:
            com.lowagie.text.pdf.PdfPTable r10 = com.lowagie.text.pdf.PdfPTable.shallowCopy(r4)
            java.util.ArrayList r2 = r10.getRows()
            if (r17 != 0) goto L_0x04b4
            r7 = 0
        L_0x04a7:
            if (r7 < r12) goto L_0x04aa
            goto L_0x04b7
        L_0x04aa:
            com.lowagie.text.pdf.PdfPRow r9 = r4.getRow(r7)
            r2.add(r9)
            int r7 = r7 + 1
            goto L_0x04a7
        L_0x04b4:
            r10.setHeaderRows(r11)
        L_0x04b7:
            int r7 = r0.listIdx
            java.util.ArrayList r7 = r4.getRows(r7, r3)
            r2.addAll(r7)
            boolean r7 = r4.isSkipLastFooter()
            r7 = r7 ^ r5
            int r9 = r4.size()
            if (r3 >= r9) goto L_0x04cf
            r10.setComplete(r5)
            r7 = 1
        L_0x04cf:
            r9 = 0
        L_0x04d0:
            if (r9 >= r11) goto L_0x04e7
            boolean r15 = r10.isComplete()
            if (r15 == 0) goto L_0x04e7
            if (r7 != 0) goto L_0x04db
            goto L_0x04e7
        L_0x04db:
            int r15 = r9 + r12
            com.lowagie.text.pdf.PdfPRow r15 = r4.getRow(r15)
            r2.add(r15)
            int r9 = r9 + 1
            goto L_0x04d0
        L_0x04e7:
            int r7 = r2.size()
            int r7 = r7 - r5
            int r7 = r7 - r11
            java.lang.Object r2 = r2.get(r7)
            com.lowagie.text.pdf.PdfPRow r2 = (com.lowagie.text.pdf.PdfPRow) r2
            boolean r5 = r4.isExtendLastRow()
            if (r5 == 0) goto L_0x0508
            float r5 = r2.getMaxHeights()
            float r7 = r0.minY
            float r13 = r13 - r7
            float r13 = r13 + r5
            r2.setMaxHeights(r13)
            float r13 = r0.minY
            r7 = r13
            goto L_0x050a
        L_0x0508:
            r7 = r13
            r5 = 0
        L_0x050a:
            com.lowagie.text.pdf.PdfContentByte[] r15 = r0.canvases
            if (r15 == 0) goto L_0x0515
            r11 = 0
            r12 = -1
            r13 = r6
            r10.writeSelectedRows((int) r11, (int) r12, (float) r13, (float) r14, (com.lowagie.text.pdf.PdfContentByte[]) r15)
            goto L_0x051d
        L_0x0515:
            r11 = 0
            r12 = -1
            com.lowagie.text.pdf.PdfContentByte r15 = r0.canvas
            r13 = r6
            r10.writeSelectedRows((int) r11, (int) r12, (float) r13, (float) r14, (com.lowagie.text.pdf.PdfContentByte) r15)
        L_0x051d:
            boolean r6 = r4.isExtendLastRow()
            if (r6 == 0) goto L_0x0526
            r2.setMaxHeights(r5)
        L_0x0526:
            r2 = r7
            goto L_0x0538
        L_0x0528:
            boolean r2 = r4.isExtendLastRow()
            if (r2 == 0) goto L_0x0537
            float r2 = r0.minY
            r5 = -830472192(0xffffffffce800000, float:-1.07374182E9)
            int r5 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r5 <= 0) goto L_0x0537
            goto L_0x0538
        L_0x0537:
            r2 = r13
        L_0x0538:
            r0.yLine = r2
            if (r17 != 0) goto L_0x0548
            boolean r2 = r4.isComplete()
            if (r2 != 0) goto L_0x0548
            float r2 = r0.yLine
            float r2 = r2 + r16
            r0.yLine = r2
        L_0x0548:
            int r2 = r4.size()
            if (r3 < r2) goto L_0x0563
            float r2 = r0.yLine
            float r3 = r4.spacingAfter()
            float r2 = r2 - r3
            r0.yLine = r2
            java.util.LinkedList r2 = r0.compositeElements
            r2.removeFirst()
            r0.splittedRow = r1
            r0.listIdx = r1
            r2 = 0
            goto L_0x013a
        L_0x0563:
            boolean r1 = r0.splittedRow
            if (r1 == 0) goto L_0x0576
            java.util.ArrayList r1 = r4.getRows()
            int r2 = r0.listIdx
        L_0x056d:
            if (r2 < r3) goto L_0x0570
            goto L_0x0576
        L_0x0570:
            r1.set(r2, r8)
            int r2 = r2 + 1
            goto L_0x056d
        L_0x0576:
            r0.listIdx = r3
            r9 = 2
            return r9
        L_0x057a:
            r9 = 2
            int r15 = r15 + 1
            r13 = r2
            goto L_0x03da
        L_0x0580:
            return r9
        L_0x0581:
            int r2 = r4.type()
            r5 = 55
            if (r2 != r5) goto L_0x05a3
            if (r22 != 0) goto L_0x059d
            r6 = r4
            com.lowagie.text.pdf.draw.DrawInterface r6 = (com.lowagie.text.pdf.draw.DrawInterface) r6
            com.lowagie.text.pdf.PdfContentByte r7 = r0.canvas
            float r8 = r0.leftX
            float r9 = r0.minY
            float r10 = r0.rightX
            float r11 = r0.maxY
            float r12 = r0.yLine
            r6.draw(r7, r8, r9, r10, r11, r12)
        L_0x059d:
            java.util.LinkedList r2 = r0.compositeElements
            r2.removeFirst()
            goto L_0x05a8
        L_0x05a3:
            java.util.LinkedList r2 = r0.compositeElements
            r2.removeFirst()
        L_0x05a8:
            r2 = 0
            goto L_0x000e
        L_0x05ab:
            com.lowagie.text.DocumentException r1 = new com.lowagie.text.DocumentException
            java.lang.String r2 = "Irregular columns are not supported in composite mode."
            r1.<init>((java.lang.String) r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.ColumnText.goComposite(boolean):int");
    }

    public PdfContentByte getCanvas() {
        return this.canvas;
    }

    public void setCanvas(PdfContentByte pdfContentByte) {
        this.canvas = pdfContentByte;
        this.canvases = null;
        ColumnText columnText = this.compositeColumn;
        if (columnText != null) {
            columnText.setCanvas(pdfContentByte);
        }
    }

    public void setCanvases(PdfContentByte[] pdfContentByteArr) {
        this.canvases = pdfContentByteArr;
        this.canvas = pdfContentByteArr[3];
        ColumnText columnText = this.compositeColumn;
        if (columnText != null) {
            columnText.setCanvases(pdfContentByteArr);
        }
    }

    public PdfContentByte[] getCanvases() {
        return this.canvases;
    }

    public boolean zeroHeightElement() {
        return this.composite && !this.compositeElements.isEmpty() && ((Element) this.compositeElements.getFirst()).type() == 55;
    }

    public boolean isUseAscender() {
        return this.useAscender;
    }

    public void setUseAscender(boolean z) {
        this.useAscender = z;
    }

    public float getFilledWidth() {
        return this.filledWidth;
    }

    public void setFilledWidth(float f) {
        this.filledWidth = f;
    }

    public void updateFilledWidth(float f) {
        if (f > this.filledWidth) {
            this.filledWidth = f;
        }
    }

    public boolean isAdjustFirstLine() {
        return this.adjustFirstLine;
    }

    public void setAdjustFirstLine(boolean z) {
        this.adjustFirstLine = z;
    }
}
