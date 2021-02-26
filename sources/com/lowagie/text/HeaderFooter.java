package com.lowagie.text;

public class HeaderFooter extends Rectangle {
    private Phrase after = null;
    private int alignment;
    private Phrase before = null;
    private boolean numbered;
    private int pageN;

    public HeaderFooter(Phrase phrase, Phrase phrase2) {
        super(0.0f, 0.0f, 0.0f, 0.0f);
        setBorder(3);
        setBorderWidth(1.0f);
        this.numbered = true;
        this.before = phrase;
        this.after = phrase2;
    }

    public HeaderFooter(Phrase phrase, boolean z) {
        super(0.0f, 0.0f, 0.0f, 0.0f);
        setBorder(3);
        setBorderWidth(1.0f);
        this.numbered = z;
        this.before = phrase;
    }

    public boolean isNumbered() {
        return this.numbered;
    }

    public Phrase getBefore() {
        return this.before;
    }

    public Phrase getAfter() {
        return this.after;
    }

    public void setPageNumber(int i) {
        this.pageN = i;
    }

    public void setAlignment(int i) {
        this.alignment = i;
    }

    public Paragraph paragraph() {
        Paragraph paragraph = new Paragraph(this.before.getLeading());
        paragraph.add(this.before);
        if (this.numbered) {
            paragraph.addSpecial(new Chunk(String.valueOf(this.pageN), this.before.getFont()));
        }
        Phrase phrase = this.after;
        if (phrase != null) {
            paragraph.addSpecial(phrase);
        }
        paragraph.setAlignment(this.alignment);
        return paragraph;
    }

    public int alignment() {
        return this.alignment;
    }
}
