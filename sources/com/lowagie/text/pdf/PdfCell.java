package com.lowagie.text.pdf;

import com.lowagie.text.Anchor;
import com.lowagie.text.Chunk;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.List;
import com.lowagie.text.ListItem;
import com.lowagie.text.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

public class PdfCell extends Rectangle {
    private float cellpadding;
    private float cellspacing;
    private float contentHeight = 0.0f;
    private PdfLine firstLine;
    private int groupNumber;
    private boolean header = false;
    private ArrayList images;
    private PdfLine lastLine;
    private float leading;
    private PdfLine line;
    private ArrayList lines;
    private int rownumber;
    private int rowspan;
    private boolean useAscender;
    private boolean useBorderPadding;
    private boolean useDescender;
    private int verticalAlignment;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PdfCell(com.lowagie.text.Cell r18, int r19, float r20, float r21, float r22, float r23, float r24) {
        /*
            r17 = this;
            r6 = r17
            r0 = r20
            r1 = r21
            r7 = r22
            r2 = r23
            r3 = r24
            r6.<init>(r0, r7, r1, r7)
            r8 = 0
            r6.header = r8
            r4 = 0
            r6.contentHeight = r4
            r17.cloneNonPositionParameters(r18)
            r6.cellpadding = r3
            r6.cellspacing = r2
            int r5 = r18.getVerticalAlignment()
            r6.verticalAlignment = r5
            boolean r5 = r18.isUseAscender()
            r6.useAscender = r5
            boolean r5 = r18.isUseDescender()
            r6.useDescender = r5
            boolean r5 = r18.isUseBorderPadding()
            r6.useBorderPadding = r5
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6.lines = r5
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            r6.images = r5
            float r5 = r18.getLeading()
            r6.leading = r5
            int r9 = r18.getHorizontalAlignment()
            float r2 = r2 + r3
            float r0 = r0 + r2
            float r1 = r1 - r2
            r2 = 4
            float r2 = r6.getBorderWidthInside(r2)
            float r10 = r0 + r2
            r0 = 8
            float r0 = r6.getBorderWidthInside(r0)
            float r11 = r1 - r0
            r6.contentHeight = r4
            int r0 = r18.getRowspan()
            r6.rowspan = r0
            java.util.Iterator r12 = r18.getElements()
        L_0x006a:
            boolean r0 = r12.hasNext()
            r1 = 0
            if (r0 != 0) goto L_0x0187
            r17.flushCurrentLine()
            java.util.ArrayList r0 = r6.lines
            int r0 = r0.size()
            int r2 = r18.getMaxLines()
            r3 = 1
            if (r0 <= r2) goto L_0x0125
        L_0x0081:
            java.util.ArrayList r0 = r6.lines
            int r0 = r0.size()
            int r2 = r18.getMaxLines()
            if (r0 > r2) goto L_0x0119
            int r0 = r18.getMaxLines()
            if (r0 <= 0) goto L_0x0125
            java.lang.String r0 = r18.getShowTruncation()
            if (r0 == 0) goto L_0x0125
            int r2 = r0.length()
            if (r2 <= 0) goto L_0x0125
            java.util.ArrayList r2 = r6.lines
            int r4 = r2.size()
            int r4 = r4 - r3
            java.lang.Object r2 = r2.get(r4)
            com.lowagie.text.pdf.PdfLine r2 = (com.lowagie.text.pdf.PdfLine) r2
            r6.lastLine = r2
            com.lowagie.text.pdf.PdfLine r2 = r6.lastLine
            int r2 = r2.size()
            if (r2 < 0) goto L_0x0109
            com.lowagie.text.pdf.PdfLine r1 = r6.lastLine
            int r2 = r1.size()
            int r2 = r2 - r3
            com.lowagie.text.pdf.PdfChunk r1 = r1.getChunk(r2)
            com.lowagie.text.pdf.PdfChunk r2 = new com.lowagie.text.pdf.PdfChunk
            r2.<init>((java.lang.String) r0, (com.lowagie.text.pdf.PdfChunk) r1)
            float r2 = r2.width()
        L_0x00ca:
            java.lang.String r4 = r1.toString()
            int r4 = r4.length()
            if (r4 <= 0) goto L_0x00f1
            float r4 = r1.width()
            float r4 = r4 + r2
            float r5 = r11 - r10
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 > 0) goto L_0x00e0
            goto L_0x00f1
        L_0x00e0:
            java.lang.String r4 = r1.toString()
            int r5 = r1.length()
            int r5 = r5 - r3
            java.lang.String r4 = r4.substring(r8, r5)
            r1.setValue(r4)
            goto L_0x00ca
        L_0x00f1:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = r1.toString()
            java.lang.String r4 = java.lang.String.valueOf(r4)
            r2.<init>(r4)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.setValue(r0)
            goto L_0x0125
        L_0x0109:
            com.lowagie.text.pdf.PdfLine r2 = r6.lastLine
            com.lowagie.text.pdf.PdfChunk r4 = new com.lowagie.text.pdf.PdfChunk
            com.lowagie.text.Chunk r5 = new com.lowagie.text.Chunk
            r5.<init>((java.lang.String) r0)
            r4.<init>((com.lowagie.text.Chunk) r5, (com.lowagie.text.pdf.PdfAction) r1)
            r2.add(r4)
            goto L_0x0125
        L_0x0119:
            java.util.ArrayList r0 = r6.lines
            int r0 = r0.size()
            int r0 = r0 - r3
            r6.removeLine(r0)
            goto L_0x0081
        L_0x0125:
            boolean r0 = r6.useDescender
            if (r0 == 0) goto L_0x0136
            com.lowagie.text.pdf.PdfLine r0 = r6.lastLine
            if (r0 == 0) goto L_0x0136
            float r1 = r6.contentHeight
            float r0 = r0.getDescender()
            float r1 = r1 - r0
            r6.contentHeight = r1
        L_0x0136:
            java.util.ArrayList r0 = r6.lines
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0160
            java.util.ArrayList r0 = r6.lines
            java.lang.Object r0 = r0.get(r8)
            com.lowagie.text.pdf.PdfLine r0 = (com.lowagie.text.pdf.PdfLine) r0
            r6.firstLine = r0
            float r0 = r17.firstLineRealHeight()
            float r1 = r6.contentHeight
            com.lowagie.text.pdf.PdfLine r2 = r6.firstLine
            float r2 = r2.height()
            float r1 = r1 - r2
            r6.contentHeight = r1
            com.lowagie.text.pdf.PdfLine r1 = r6.firstLine
            r1.height = r0
            float r1 = r6.contentHeight
            float r1 = r1 + r0
            r6.contentHeight = r1
        L_0x0160:
            float r0 = r6.contentHeight
            float r0 = r7 - r0
            float r1 = r17.cellpadding()
            r2 = 1073741824(0x40000000, float:2.0)
            float r1 = r1 * r2
            float r0 = r0 - r1
            float r1 = r17.cellspacing()
            float r1 = r1 * r2
            float r0 = r0 - r1
            float r1 = r6.getBorderWidthInside(r3)
            r2 = 2
            float r2 = r6.getBorderWidthInside(r2)
            float r1 = r1 + r2
            float r0 = r0 - r1
            r6.setBottom(r0)
            r13 = r19
            r6.rownumber = r13
            return
        L_0x0187:
            r13 = r19
            java.lang.Object r0 = r12.next()
            com.lowagie.text.Element r0 = (com.lowagie.text.Element) r0
            int r2 = r0.type()
            r3 = 14
            if (r2 == r3) goto L_0x024e
            switch(r2) {
                case 32: goto L_0x0239;
                case 33: goto L_0x0239;
                case 34: goto L_0x0239;
                case 35: goto L_0x0239;
                case 36: goto L_0x0239;
                default: goto L_0x019a;
            }
        L_0x019a:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r6.processActions(r0, r1, r2)
            float r1 = r6.leading
            boolean r3 = r0 instanceof com.lowagie.text.Phrase
            if (r3 == 0) goto L_0x01af
            r1 = r0
            com.lowagie.text.Phrase r1 = (com.lowagie.text.Phrase) r1
            float r1 = r1.getLeading()
        L_0x01af:
            boolean r3 = r0 instanceof com.lowagie.text.Paragraph
            if (r3 == 0) goto L_0x01c2
            r3 = r0
            com.lowagie.text.Paragraph r3 = (com.lowagie.text.Paragraph) r3
            float r4 = r3.getIndentationLeft()
            float r4 = r4 + r10
            float r3 = r3.getIndentationRight()
            float r3 = r11 - r3
            goto L_0x01c4
        L_0x01c2:
            r4 = r10
            r3 = r11
        L_0x01c4:
            com.lowagie.text.pdf.PdfLine r5 = r6.line
            if (r5 != 0) goto L_0x01cf
            com.lowagie.text.pdf.PdfLine r5 = new com.lowagie.text.pdf.PdfLine
            r5.<init>(r4, r3, r9, r1)
            r6.line = r5
        L_0x01cf:
            java.util.ArrayList r5 = r0.getChunks()
            boolean r14 = r5.isEmpty()
            if (r14 == 0) goto L_0x01e6
            com.lowagie.text.pdf.PdfLine r2 = r6.line
            r6.addLine(r2)
            com.lowagie.text.pdf.PdfLine r2 = new com.lowagie.text.pdf.PdfLine
            r2.<init>(r4, r3, r9, r1)
            r6.line = r2
            goto L_0x01f1
        L_0x01e6:
            java.util.Iterator r5 = r5.iterator()
            r14 = 0
        L_0x01eb:
            boolean r15 = r5.hasNext()
            if (r15 != 0) goto L_0x020d
        L_0x01f1:
            int r0 = r0.type()
            r1 = 12
            if (r0 == r1) goto L_0x0203
            r1 = 13
            if (r0 == r1) goto L_0x0203
            r1 = 16
            if (r0 == r1) goto L_0x0203
            goto L_0x006a
        L_0x0203:
            com.lowagie.text.pdf.PdfLine r0 = r6.line
            r0.resetAlignment()
            r17.flushCurrentLine()
            goto L_0x006a
        L_0x020d:
            java.lang.Object r15 = r5.next()
            com.lowagie.text.Chunk r15 = (com.lowagie.text.Chunk) r15
            com.lowagie.text.pdf.PdfChunk r8 = new com.lowagie.text.pdf.PdfChunk
            int r16 = r14 + 1
            java.lang.Object r14 = r2.get(r14)
            com.lowagie.text.pdf.PdfAction r14 = (com.lowagie.text.pdf.PdfAction) r14
            r8.<init>((com.lowagie.text.Chunk) r15, (com.lowagie.text.pdf.PdfAction) r14)
        L_0x0220:
            com.lowagie.text.pdf.PdfLine r14 = r6.line
            com.lowagie.text.pdf.PdfChunk r8 = r14.add(r8)
            if (r8 != 0) goto L_0x022c
            r14 = r16
            r8 = 0
            goto L_0x01eb
        L_0x022c:
            com.lowagie.text.pdf.PdfLine r14 = r6.line
            r6.addLine(r14)
            com.lowagie.text.pdf.PdfLine r14 = new com.lowagie.text.pdf.PdfLine
            r14.<init>(r4, r3, r9, r1)
            r6.line = r14
            goto L_0x0220
        L_0x0239:
            r1 = r0
            com.lowagie.text.Image r1 = (com.lowagie.text.Image) r1
            r0 = 1053609165(0x3ecccccd, float:0.4)
            float r2 = r6.leading
            float r4 = r2 * r0
            r0 = r17
            r2 = r10
            r3 = r11
            r5 = r9
            r0.addImage(r1, r2, r3, r4, r5)
        L_0x024b:
            r8 = 0
            goto L_0x006a
        L_0x024e:
            com.lowagie.text.pdf.PdfLine r1 = r6.line
            if (r1 == 0) goto L_0x0262
            int r1 = r1.size()
            if (r1 <= 0) goto L_0x0262
            com.lowagie.text.pdf.PdfLine r1 = r6.line
            r1.resetAlignment()
            com.lowagie.text.pdf.PdfLine r1 = r6.line
            r6.addLine(r1)
        L_0x0262:
            com.lowagie.text.List r0 = (com.lowagie.text.List) r0
            r6.addList(r0, r10, r11, r9)
            com.lowagie.text.pdf.PdfLine r0 = new com.lowagie.text.pdf.PdfLine
            float r1 = r6.leading
            r0.<init>(r10, r11, r9, r1)
            r6.line = r0
            goto L_0x024b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.PdfCell.<init>(com.lowagie.text.Cell, int, float, float, float, float, float):void");
    }

    private void addList(List list, float f, float f2, int i) {
        ArrayList arrayList = new ArrayList();
        processActions(list, (PdfAction) null, arrayList);
        Iterator it = list.getItems().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            Element element = (Element) it.next();
            int type = element.type();
            if (type == 14) {
                List list2 = (List) element;
                addList(list2, list2.getIndentationLeft() + f, f2, i);
            } else if (type == 15) {
                ListItem listItem = (ListItem) element;
                this.line = new PdfLine(listItem.getIndentationLeft() + f, f2, i, listItem.getLeading());
                this.line.setListItem(listItem);
                Iterator it2 = listItem.getChunks().iterator();
                while (it2.hasNext()) {
                    int i3 = i2 + 1;
                    PdfChunk pdfChunk = new PdfChunk((Chunk) it2.next(), (PdfAction) arrayList.get(i2));
                    while (true) {
                        pdfChunk = this.line.add(pdfChunk);
                        if (pdfChunk == null) {
                            break;
                        }
                        addLine(this.line);
                        this.line = new PdfLine(listItem.getIndentationLeft() + f, f2, i, listItem.getLeading());
                    }
                    this.line.resetAlignment();
                    addLine(this.line);
                    this.line = new PdfLine(listItem.getIndentationLeft() + f, f2, i, this.leading);
                    i2 = i3;
                }
            }
        }
    }

    public void setBottom(float f) {
        float f2;
        super.setBottom(f);
        float firstLineRealHeight = firstLineRealHeight();
        float cellpadding2 = (this.ury - f) - (((cellpadding() * 2.0f) + (cellspacing() * 2.0f)) + (getBorderWidthInside(1) + getBorderWidthInside(2)));
        int i = this.verticalAlignment;
        if (i == 5) {
            f2 = (cellpadding2 - this.contentHeight) / 2.0f;
        } else if (i != 6) {
            f2 = 0.0f;
        } else {
            f2 = cellpadding2 - this.contentHeight;
        }
        float cellpadding3 = f2 + cellpadding() + cellspacing() + getBorderWidthInside(1);
        PdfLine pdfLine = this.firstLine;
        if (pdfLine != null) {
            pdfLine.height = firstLineRealHeight + cellpadding3;
        }
    }

    public float getLeft() {
        return super.getLeft(this.cellspacing);
    }

    public float getRight() {
        return super.getRight(this.cellspacing);
    }

    public float getTop() {
        return super.getTop(this.cellspacing);
    }

    public float getBottom() {
        return super.getBottom(this.cellspacing);
    }

    private void addLine(PdfLine pdfLine) {
        this.lines.add(pdfLine);
        this.contentHeight += pdfLine.height();
        this.lastLine = pdfLine;
        this.line = null;
    }

    private PdfLine removeLine(int i) {
        PdfLine pdfLine = (PdfLine) this.lines.remove(i);
        this.contentHeight -= pdfLine.height();
        if (i == 0 && !this.lines.isEmpty()) {
            this.firstLine = (PdfLine) this.lines.get(0);
            float firstLineRealHeight = firstLineRealHeight();
            this.contentHeight -= this.firstLine.height();
            this.firstLine.height = firstLineRealHeight;
            this.contentHeight += firstLineRealHeight;
        }
        return pdfLine;
    }

    private void flushCurrentLine() {
        PdfLine pdfLine = this.line;
        if (pdfLine != null && pdfLine.size() > 0) {
            addLine(this.line);
        }
    }

    private float firstLineRealHeight() {
        PdfChunk chunk;
        PdfLine pdfLine = this.firstLine;
        if (pdfLine == null || (chunk = pdfLine.getChunk(0)) == null) {
            return 0.0f;
        }
        if (chunk.getImage() != null) {
            return this.firstLine.getChunk(0).getImage().getScaledHeight();
        }
        return this.useAscender ? this.firstLine.getAscender() : this.leading;
    }

    private float getBorderWidthInside(int i) {
        float f;
        if (!this.useBorderPadding) {
            return 0.0f;
        }
        if (i == 1) {
            f = getBorderWidthTop();
        } else if (i == 4) {
            f = getBorderWidthLeft();
        } else if (i != 8) {
            f = getBorderWidthBottom();
        } else {
            f = getBorderWidthRight();
        }
        return !isUseVariableBorders() ? f / 2.0f : f;
    }

    private float addImage(Image image, float f, float f2, float f3, int i) {
        float f4;
        Image instance = Image.getInstance(image);
        float f5 = f2 - f;
        if (instance.getScaledWidth() > f5) {
            instance.scaleToFit(f5, Float.MAX_VALUE);
        }
        flushCurrentLine();
        if (this.line == null) {
            this.line = new PdfLine(f, f2, i, this.leading);
        }
        PdfLine pdfLine = this.line;
        if ((instance.getAlignment() & 2) == 2) {
            f4 = f5 - instance.getScaledWidth();
        } else {
            f4 = (instance.getAlignment() & 1) == 1 ? (((f5 - 0.0f) - instance.getScaledWidth()) / 2.0f) + 0.0f : 0.0f;
        }
        pdfLine.add(new PdfChunk(new Chunk(instance, f4, 0.0f), (PdfAction) null));
        addLine(pdfLine);
        return pdfLine.height();
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList getLines(float r8, float r9) {
        /*
            r7 = this;
            float r0 = r7.getTop()
            float r8 = java.lang.Math.min(r0, r8)
            float r0 = r7.cellspacing
            float r0 = r0 + r8
            r7.setTop(r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            float r1 = r7.getTop()
            int r1 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r1 >= 0) goto L_0x001c
            return r0
        L_0x001c:
            java.util.ArrayList r1 = r7.lines
            int r1 = r1.size()
            r2 = 1
            r3 = 0
            r4 = r8
            r8 = 0
        L_0x0026:
            if (r8 >= r1) goto L_0x0053
            if (r2 != 0) goto L_0x002b
            goto L_0x0053
        L_0x002b:
            java.util.ArrayList r5 = r7.lines
            java.lang.Object r5 = r5.get(r8)
            com.lowagie.text.pdf.PdfLine r5 = (com.lowagie.text.pdf.PdfLine) r5
            r7.line = r5
            com.lowagie.text.pdf.PdfLine r5 = r7.line
            float r5 = r5.height()
            float r4 = r4 - r5
            float r5 = r7.cellpadding
            float r5 = r5 + r9
            r6 = 2
            float r6 = r7.getBorderWidthInside(r6)
            float r5 = r5 + r6
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 <= 0) goto L_0x004f
            com.lowagie.text.pdf.PdfLine r5 = r7.line
            r0.add(r5)
            goto L_0x0050
        L_0x004f:
            r2 = 0
        L_0x0050:
            int r8 = r8 + 1
            goto L_0x0026
        L_0x0053:
            boolean r8 = r7.header
            r9 = 0
            if (r8 != 0) goto L_0x007d
            if (r2 == 0) goto L_0x0064
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r7.lines = r8
            r7.contentHeight = r9
            goto L_0x007d
        L_0x0064:
            int r8 = r0.size()
            r1 = 0
            r2 = 0
        L_0x006a:
            if (r1 < r8) goto L_0x006d
            goto L_0x007e
        L_0x006d:
            com.lowagie.text.pdf.PdfLine r4 = r7.removeLine(r3)
            r7.line = r4
            com.lowagie.text.pdf.PdfLine r4 = r7.line
            float r4 = r4.height()
            float r2 = r2 + r4
            int r1 = r1 + 1
            goto L_0x006a
        L_0x007d:
            r2 = 0
        L_0x007e:
            int r8 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r8 <= 0) goto L_0x00a5
            java.util.ArrayList r8 = r7.images
            java.util.Iterator r8 = r8.iterator()
        L_0x0088:
            boolean r9 = r8.hasNext()
            if (r9 != 0) goto L_0x008f
            goto L_0x00a5
        L_0x008f:
            java.lang.Object r9 = r8.next()
            com.lowagie.text.Image r9 = (com.lowagie.text.Image) r9
            float r1 = r9.getAbsoluteX()
            float r3 = r9.getAbsoluteY()
            float r3 = r3 - r2
            float r4 = r7.leading
            float r3 = r3 - r4
            r9.setAbsolutePosition(r1, r3)
            goto L_0x0088
        L_0x00a5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lowagie.text.pdf.PdfCell.getLines(float, float):java.util.ArrayList");
    }

    public ArrayList getImages(float f, float f2) {
        if (getTop() < f2) {
            return new ArrayList();
        }
        float min = Math.min(getTop(), f);
        ArrayList arrayList = new ArrayList();
        Iterator it = this.images.iterator();
        while (it.hasNext() && !this.header) {
            Image image = (Image) it.next();
            float absoluteY = min - image.getAbsoluteY();
            if (absoluteY > this.cellpadding + f2) {
                image.setAbsolutePosition(image.getAbsoluteX(), absoluteY);
                arrayList.add(image);
                it.remove();
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public boolean isHeader() {
        return this.header;
    }

    /* access modifiers changed from: package-private */
    public void setHeader() {
        this.header = true;
    }

    /* access modifiers changed from: package-private */
    public boolean mayBeRemoved() {
        if (!this.header) {
            return this.lines.isEmpty() && this.images.isEmpty();
        }
        return true;
    }

    public int size() {
        return this.lines.size();
    }

    private float remainingLinesHeight() {
        float f = 0.0f;
        if (this.lines.isEmpty()) {
            return 0.0f;
        }
        int size = this.lines.size();
        for (int i = 0; i < size; i++) {
            f += ((PdfLine) this.lines.get(i)).height();
        }
        return f;
    }

    public float remainingHeight() {
        Iterator it = this.images.iterator();
        float f = 0.0f;
        while (it.hasNext()) {
            f += ((Image) it.next()).getScaledHeight();
        }
        return remainingLinesHeight() + this.cellspacing + (this.cellpadding * 2.0f) + f;
    }

    public float leading() {
        return this.leading;
    }

    public int rownumber() {
        return this.rownumber;
    }

    public int rowspan() {
        return this.rowspan;
    }

    public float cellspacing() {
        return this.cellspacing;
    }

    public float cellpadding() {
        return this.cellpadding;
    }

    /* access modifiers changed from: protected */
    public void processActions(Element element, PdfAction pdfAction, ArrayList arrayList) {
        String reference;
        if (element.type() == 17 && (reference = ((Anchor) element).getReference()) != null) {
            pdfAction = new PdfAction(reference);
        }
        switch (element.type()) {
            case 10:
                arrayList.add(pdfAction);
                return;
            case 11:
            case 12:
            case 13:
            case 15:
            case 16:
            case 17:
                Iterator it = ((ArrayList) element).iterator();
                while (it.hasNext()) {
                    processActions((Element) it.next(), pdfAction, arrayList);
                }
                return;
            case 14:
                Iterator it2 = ((List) element).getItems().iterator();
                while (it2.hasNext()) {
                    processActions((Element) it2.next(), pdfAction, arrayList);
                }
                return;
            default:
                int size = element.getChunks().size();
                while (true) {
                    int i = size - 1;
                    if (size > 0) {
                        arrayList.add(pdfAction);
                        size = i;
                    } else {
                        return;
                    }
                }
        }
    }

    public int getGroupNumber() {
        return this.groupNumber;
    }

    /* access modifiers changed from: package-private */
    public void setGroupNumber(int i) {
        this.groupNumber = i;
    }

    public Rectangle rectangle(float f, float f2) {
        Rectangle rectangle = new Rectangle(getLeft(), getBottom(), getRight(), getTop());
        rectangle.cloneNonPositionParameters(this);
        if (getTop() > f) {
            rectangle.setTop(f);
            rectangle.setBorder(this.border - (this.border & 1));
        }
        if (getBottom() < f2) {
            rectangle.setBottom(f2);
            rectangle.setBorder(this.border - (this.border & 2));
        }
        return rectangle;
    }

    public void setUseAscender(boolean z) {
        this.useAscender = z;
    }

    public boolean isUseAscender() {
        return this.useAscender;
    }

    public void setUseDescender(boolean z) {
        this.useDescender = z;
    }

    public boolean isUseDescender() {
        return this.useDescender;
    }

    public void setUseBorderPadding(boolean z) {
        this.useBorderPadding = z;
    }

    public boolean isUseBorderPadding() {
        return this.useBorderPadding;
    }
}
