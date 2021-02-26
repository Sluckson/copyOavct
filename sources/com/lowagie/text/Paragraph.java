package com.lowagie.text;

import java.util.ArrayList;

public class Paragraph extends Phrase {
    private static final long serialVersionUID = 7852314969733375514L;
    protected int alignment = -1;
    private float extraParagraphSpace = 0.0f;
    private float firstLineIndent = 0.0f;
    protected float indentationLeft;
    protected float indentationRight;
    protected boolean keeptogether = false;
    protected float multipliedLeading = 0.0f;
    protected float spacingAfter;
    protected float spacingBefore;

    public int type() {
        return 12;
    }

    public Paragraph() {
    }

    public Paragraph(float f) {
        super(f);
    }

    public Paragraph(Chunk chunk) {
        super(chunk);
    }

    public Paragraph(float f, Chunk chunk) {
        super(f, chunk);
    }

    public Paragraph(String str) {
        super(str);
    }

    public Paragraph(String str, Font font) {
        super(str, font);
    }

    public Paragraph(float f, String str) {
        super(f, str);
    }

    public Paragraph(float f, String str, Font font) {
        super(f, str, font);
    }

    public Paragraph(Phrase phrase) {
        super(phrase);
        if (phrase instanceof Paragraph) {
            Paragraph paragraph = (Paragraph) phrase;
            setAlignment(paragraph.alignment);
            setLeading(phrase.getLeading(), paragraph.multipliedLeading);
            setIndentationLeft(paragraph.getIndentationLeft());
            setIndentationRight(paragraph.getIndentationRight());
            setFirstLineIndent(paragraph.getFirstLineIndent());
            setSpacingAfter(paragraph.spacingAfter());
            setSpacingBefore(paragraph.spacingBefore());
            setExtraParagraphSpace(paragraph.getExtraParagraphSpace());
        }
    }

    public boolean add(Object obj) {
        if (obj instanceof List) {
            List list = (List) obj;
            list.setIndentationLeft(list.getIndentationLeft() + this.indentationLeft);
            list.setIndentationRight(this.indentationRight);
            return super.add(list);
        } else if (obj instanceof Image) {
            super.addSpecial(obj);
            return true;
        } else if (!(obj instanceof Paragraph)) {
            return super.add(obj);
        } else {
            super.add(obj);
            ArrayList chunks = getChunks();
            if (!chunks.isEmpty()) {
                super.add(new Chunk("\n", ((Chunk) chunks.get(chunks.size() - 1)).getFont()));
            } else {
                super.add(Chunk.NEWLINE);
            }
            return true;
        }
    }

    public void setAlignment(int i) {
        this.alignment = i;
    }

    public void setAlignment(String str) {
        if ("Center".equalsIgnoreCase(str)) {
            this.alignment = 1;
        } else if ("Right".equalsIgnoreCase(str)) {
            this.alignment = 2;
        } else if ("Justify".equalsIgnoreCase(str)) {
            this.alignment = 3;
        } else if (ElementTags.ALIGN_JUSTIFIED_ALL.equalsIgnoreCase(str)) {
            this.alignment = 8;
        } else {
            this.alignment = 0;
        }
    }

    public void setLeading(float f) {
        this.leading = f;
        this.multipliedLeading = 0.0f;
    }

    public void setMultipliedLeading(float f) {
        this.leading = 0.0f;
        this.multipliedLeading = f;
    }

    public void setLeading(float f, float f2) {
        this.leading = f;
        this.multipliedLeading = f2;
    }

    public void setIndentationLeft(float f) {
        this.indentationLeft = f;
    }

    public void setIndentationRight(float f) {
        this.indentationRight = f;
    }

    public void setFirstLineIndent(float f) {
        this.firstLineIndent = f;
    }

    public void setSpacingBefore(float f) {
        this.spacingBefore = f;
    }

    public void setSpacingAfter(float f) {
        this.spacingAfter = f;
    }

    public void setKeepTogether(boolean z) {
        this.keeptogether = z;
    }

    public boolean getKeepTogether() {
        return this.keeptogether;
    }

    public int getAlignment() {
        return this.alignment;
    }

    public float getMultipliedLeading() {
        return this.multipliedLeading;
    }

    public float getTotalLeading() {
        float calculatedLeading = this.font == null ? this.multipliedLeading * 12.0f : this.font.getCalculatedLeading(this.multipliedLeading);
        if (calculatedLeading <= 0.0f || hasLeading()) {
            return getLeading() + calculatedLeading;
        }
        return calculatedLeading;
    }

    public float getIndentationLeft() {
        return this.indentationLeft;
    }

    public float getIndentationRight() {
        return this.indentationRight;
    }

    public float getFirstLineIndent() {
        return this.firstLineIndent;
    }

    public float getSpacingBefore() {
        return this.spacingBefore;
    }

    public float getSpacingAfter() {
        return this.spacingAfter;
    }

    public float getExtraParagraphSpace() {
        return this.extraParagraphSpace;
    }

    public void setExtraParagraphSpace(float f) {
        this.extraParagraphSpace = f;
    }

    public float spacingBefore() {
        return getSpacingBefore();
    }

    public float spacingAfter() {
        return this.spacingAfter;
    }
}
