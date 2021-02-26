package com.lowagie.text.pdf;

import com.lowagie.text.Chunk;
import com.lowagie.text.ListItem;
import java.util.ArrayList;
import java.util.Iterator;

public class PdfLine {
    protected int alignment;
    protected float height;
    protected boolean isRTL = false;
    protected float left;
    protected ArrayList line;
    protected Chunk listSymbol = null;
    protected boolean newlineSplit = false;
    protected float originalWidth;
    protected float symbolIndent;
    protected float width;

    PdfLine(float f, float f2, int i, float f3) {
        this.left = f;
        this.width = f2 - f;
        this.originalWidth = this.width;
        this.alignment = i;
        this.height = f3;
        this.line = new ArrayList();
    }

    PdfLine(float f, float f2, float f3, int i, boolean z, ArrayList arrayList, boolean z2) {
        this.left = f;
        this.originalWidth = f2;
        this.width = f3;
        this.alignment = i;
        this.line = arrayList;
        this.newlineSplit = z;
        this.isRTL = z2;
    }

    /* access modifiers changed from: package-private */
    public PdfChunk add(PdfChunk pdfChunk) {
        if (pdfChunk == null || pdfChunk.toString().equals("")) {
            return null;
        }
        PdfChunk split = pdfChunk.split(this.width);
        this.newlineSplit = pdfChunk.isNewlineSplit() || split == null;
        if (pdfChunk.isTab()) {
            Object[] objArr = (Object[]) pdfChunk.getAttribute(Chunk.TAB);
            float floatValue = ((Float) objArr[1]).floatValue();
            if (((Boolean) objArr[2]).booleanValue() && floatValue < this.originalWidth - this.width) {
                return pdfChunk;
            }
            this.width = this.originalWidth - floatValue;
            pdfChunk.adjustLeft(this.left);
            addToLine(pdfChunk);
        } else if (pdfChunk.length() > 0 || pdfChunk.isImage()) {
            if (split != null) {
                pdfChunk.trimLastSpace();
            }
            this.width -= pdfChunk.width();
            addToLine(pdfChunk);
        } else if (this.line.size() < 1) {
            PdfChunk truncate = split.truncate(this.width);
            this.width -= split.width();
            if (split.length() > 0) {
                addToLine(split);
                return truncate;
            }
            if (truncate != null) {
                addToLine(truncate);
            }
            return null;
        } else {
            float f = this.width;
            ArrayList arrayList = this.line;
            this.width = f + ((PdfChunk) arrayList.get(arrayList.size() - 1)).trimLastSpace();
        }
        return split;
    }

    private void addToLine(PdfChunk pdfChunk) {
        if (pdfChunk.changeLeading && pdfChunk.isImage()) {
            float scaledHeight = pdfChunk.getImage().getScaledHeight() + pdfChunk.getImageOffsetY() + pdfChunk.getImage().getBorderWidthTop();
            if (scaledHeight > this.height) {
                this.height = scaledHeight;
            }
        }
        this.line.add(pdfChunk);
    }

    public int size() {
        return this.line.size();
    }

    public Iterator iterator() {
        return this.line.iterator();
    }

    /* access modifiers changed from: package-private */
    public float height() {
        return this.height;
    }

    /* access modifiers changed from: package-private */
    public float indentLeft() {
        if (this.isRTL) {
            int i = this.alignment;
            if (i == 0) {
                return this.left + this.width;
            }
            if (i != 1) {
                return this.left;
            }
            return this.left + (this.width / 2.0f);
        }
        if (getSeparatorCount() == 0) {
            int i2 = this.alignment;
            if (i2 == 1) {
                return this.left + (this.width / 2.0f);
            }
            if (i2 == 2) {
                return this.left + this.width;
            }
        }
        return this.left;
    }

    public boolean hasToBeJustified() {
        int i = this.alignment;
        return (i == 3 || i == 8) && this.width != 0.0f;
    }

    public void resetAlignment() {
        if (this.alignment == 3) {
            this.alignment = 0;
        }
    }

    /* access modifiers changed from: package-private */
    public void setExtraIndent(float f) {
        this.left += f;
        this.width -= f;
    }

    /* access modifiers changed from: package-private */
    public float widthLeft() {
        return this.width;
    }

    /* access modifiers changed from: package-private */
    public int numberOfSpaces() {
        String pdfLine = toString();
        int length = pdfLine.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (pdfLine.charAt(i2) == ' ') {
                i++;
            }
        }
        return i;
    }

    public void setListItem(ListItem listItem) {
        this.listSymbol = listItem.getListSymbol();
        this.symbolIndent = listItem.getIndentationLeft();
    }

    public Chunk listSymbol() {
        return this.listSymbol;
    }

    public float listIndent() {
        return this.symbolIndent;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.line.iterator();
        while (it.hasNext()) {
            stringBuffer.append(((PdfChunk) it.next()).toString());
        }
        return stringBuffer.toString();
    }

    public int GetLineLengthUtf32() {
        Iterator it = this.line.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += ((PdfChunk) it.next()).lengthUtf32();
        }
        return i;
    }

    public boolean isNewlineSplit() {
        return this.newlineSplit && this.alignment != 8;
    }

    public int getLastStrokeChunk() {
        int size = this.line.size() - 1;
        while (size >= 0 && !((PdfChunk) this.line.get(size)).isStroked()) {
            size--;
        }
        return size;
    }

    public PdfChunk getChunk(int i) {
        if (i < 0 || i >= this.line.size()) {
            return null;
        }
        return (PdfChunk) this.line.get(i);
    }

    public float getOriginalWidth() {
        return this.originalWidth;
    }

    /* access modifiers changed from: package-private */
    public float[] getMaxSize() {
        float f = 0.0f;
        float f2 = -10000.0f;
        for (int i = 0; i < this.line.size(); i++) {
            PdfChunk pdfChunk = (PdfChunk) this.line.get(i);
            if (!pdfChunk.isImage()) {
                f = Math.max(pdfChunk.font().size(), f);
            } else {
                f2 = Math.max(pdfChunk.getImage().getScaledHeight() + pdfChunk.getImageOffsetY(), f2);
            }
        }
        return new float[]{f, f2};
    }

    /* access modifiers changed from: package-private */
    public boolean isRTL() {
        return this.isRTL;
    }

    /* access modifiers changed from: package-private */
    public int getSeparatorCount() {
        Iterator it = this.line.iterator();
        int i = 0;
        while (it.hasNext()) {
            PdfChunk pdfChunk = (PdfChunk) it.next();
            if (pdfChunk.isTab()) {
                return 0;
            }
            if (pdfChunk.isHorizontalSeparator()) {
                i++;
            }
        }
        return i;
    }

    public float getWidthCorrected(float f, float f2) {
        float f3 = 0.0f;
        for (int i = 0; i < this.line.size(); i++) {
            f3 += ((PdfChunk) this.line.get(i)).getWidthCorrected(f, f2);
        }
        return f3;
    }

    public float getAscender() {
        float f = 0.0f;
        for (int i = 0; i < this.line.size(); i++) {
            PdfChunk pdfChunk = (PdfChunk) this.line.get(i);
            if (pdfChunk.isImage()) {
                f = Math.max(f, pdfChunk.getImage().getScaledHeight() + pdfChunk.getImageOffsetY());
            } else {
                PdfFont font = pdfChunk.font();
                f = Math.max(f, font.getFont().getFontDescriptor(1, font.size()));
            }
        }
        return f;
    }

    public float getDescender() {
        float f = 0.0f;
        for (int i = 0; i < this.line.size(); i++) {
            PdfChunk pdfChunk = (PdfChunk) this.line.get(i);
            if (pdfChunk.isImage()) {
                f = Math.min(f, pdfChunk.getImageOffsetY());
            } else {
                PdfFont font = pdfChunk.font();
                f = Math.min(f, font.getFont().getFontDescriptor(3, font.size()));
            }
        }
        return f;
    }
}
