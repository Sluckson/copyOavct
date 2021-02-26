package com.lowagie.text;

public class ChapterAutoNumber extends Chapter {
    private static final long serialVersionUID = -9217457637987854167L;
    protected boolean numberSet = false;

    public ChapterAutoNumber(Paragraph paragraph) {
        super(paragraph, 0);
    }

    public ChapterAutoNumber(String str) {
        super(str, 0);
    }

    public Section addSection(String str) {
        if (!isAddedCompletely()) {
            return addSection(str, 2);
        }
        throw new IllegalStateException("This LargeElement has already been added to the Document.");
    }

    public Section addSection(Paragraph paragraph) {
        if (!isAddedCompletely()) {
            return addSection(paragraph, 2);
        }
        throw new IllegalStateException("This LargeElement has already been added to the Document.");
    }

    public int setAutomaticNumber(int i) {
        if (this.numberSet) {
            return i;
        }
        int i2 = i + 1;
        super.setChapterNumber(i2);
        this.numberSet = true;
        return i2;
    }
}
