package com.lowagie.text.pdf;

import com.lowagie.text.Chunk;
import com.lowagie.text.Phrase;
import harmony.java.awt.Color;
import java.util.ArrayList;
import java.util.Iterator;

public class VerticalText {
    public static final int NO_MORE_COLUMN = 2;
    public static final int NO_MORE_TEXT = 1;
    protected int alignment = 0;
    protected ArrayList chunks = new ArrayList();
    protected int currentChunkMarker = -1;
    protected PdfChunk currentStandbyChunk;
    protected float height;
    protected float leading;
    protected int maxLines;
    protected String splittedChunkText;
    protected float startX;
    protected float startY;
    protected PdfContentByte text;

    public VerticalText(PdfContentByte pdfContentByte) {
        this.text = pdfContentByte;
    }

    public void addText(Phrase phrase) {
        Iterator it = phrase.getChunks().iterator();
        while (it.hasNext()) {
            this.chunks.add(new PdfChunk((Chunk) it.next(), (PdfAction) null));
        }
    }

    public void addText(Chunk chunk) {
        this.chunks.add(new PdfChunk(chunk, (PdfAction) null));
    }

    public void setVerticalLayout(float f, float f2, float f3, int i, float f4) {
        this.startX = f;
        this.startY = f2;
        this.height = f3;
        this.maxLines = i;
        setLeading(f4);
    }

    public void setLeading(float f) {
        this.leading = f;
    }

    public float getLeading() {
        return this.leading;
    }

    /* access modifiers changed from: protected */
    public PdfLine createLine(float f) {
        if (this.chunks.isEmpty()) {
            return null;
        }
        this.splittedChunkText = null;
        this.currentStandbyChunk = null;
        PdfLine pdfLine = new PdfLine(0.0f, f, this.alignment, 0.0f);
        int i = 0;
        while (true) {
            this.currentChunkMarker = i;
            if (this.currentChunkMarker >= this.chunks.size()) {
                return pdfLine;
            }
            PdfChunk pdfChunk = (PdfChunk) this.chunks.get(this.currentChunkMarker);
            String pdfChunk2 = pdfChunk.toString();
            this.currentStandbyChunk = pdfLine.add(pdfChunk);
            if (this.currentStandbyChunk != null) {
                this.splittedChunkText = pdfChunk.toString();
                pdfChunk.setValue(pdfChunk2);
                return pdfLine;
            }
            i = this.currentChunkMarker + 1;
        }
    }

    /* access modifiers changed from: protected */
    public void shortenChunkArray() {
        int i = this.currentChunkMarker;
        if (i >= 0) {
            if (i >= this.chunks.size()) {
                this.chunks.clear();
                return;
            }
            ((PdfChunk) this.chunks.get(this.currentChunkMarker)).setValue(this.splittedChunkText);
            this.chunks.set(this.currentChunkMarker, this.currentStandbyChunk);
            for (int i2 = this.currentChunkMarker - 1; i2 >= 0; i2--) {
                this.chunks.remove(i2);
            }
        }
    }

    /* renamed from: go */
    public int mo54289go() {
        return mo54290go(false);
    }

    /* renamed from: go */
    public int mo54290go(boolean z) {
        PdfContentByte pdfContentByte;
        int i;
        PdfContentByte pdfContentByte2 = this.text;
        if (pdfContentByte2 != null) {
            pdfContentByte = pdfContentByte2.getDuplicate();
        } else if (z) {
            pdfContentByte = null;
        } else {
            throw new NullPointerException("VerticalText.go with simulate==false and text==null.");
        }
        boolean z2 = false;
        while (true) {
            i = 1;
            if (this.maxLines <= 0) {
                i = 2;
                if (this.chunks.isEmpty()) {
                    i = 3;
                }
            } else if (this.chunks.isEmpty()) {
                break;
            } else {
                PdfLine createLine = createLine(this.height);
                if (!z && !z2) {
                    this.text.beginText();
                    z2 = true;
                }
                shortenChunkArray();
                if (!z) {
                    this.text.setTextMatrix(this.startX, this.startY - createLine.indentLeft());
                    writeLine(createLine, this.text, pdfContentByte);
                }
                this.maxLines--;
                this.startX -= this.leading;
            }
        }
        if (z2) {
            this.text.endText();
            this.text.add(pdfContentByte);
        }
        return i;
    }

    /* access modifiers changed from: package-private */
    public void writeLine(PdfLine pdfLine, PdfContentByte pdfContentByte, PdfContentByte pdfContentByte2) {
        Iterator it = pdfLine.iterator();
        PdfFont pdfFont = null;
        while (it.hasNext()) {
            PdfChunk pdfChunk = (PdfChunk) it.next();
            if (pdfChunk.font().compareTo(pdfFont) != 0) {
                pdfFont = pdfChunk.font();
                pdfContentByte.setFontAndSize(pdfFont.getFont(), pdfFont.size());
            }
            Color color = pdfChunk.color();
            if (color != null) {
                pdfContentByte.setColorFill(color);
            }
            pdfContentByte.showText(pdfChunk.toString());
            if (color != null) {
                pdfContentByte.resetRGBColorFill();
            }
        }
    }

    public void setOrigin(float f, float f2) {
        this.startX = f;
        this.startY = f2;
    }

    public float getOriginX() {
        return this.startX;
    }

    public float getOriginY() {
        return this.startY;
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    public void setMaxLines(int i) {
        this.maxLines = i;
    }

    public float getHeight() {
        return this.height;
    }

    public void setHeight(float f) {
        this.height = f;
    }

    public void setAlignment(int i) {
        this.alignment = i;
    }

    public int getAlignment() {
        return this.alignment;
    }
}
