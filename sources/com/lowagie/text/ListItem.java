package com.lowagie.text;

public class ListItem extends Paragraph {
    private static final long serialVersionUID = 1970670787169329006L;
    private Chunk symbol;

    public int type() {
        return 15;
    }

    public ListItem() {
    }

    public ListItem(float f) {
        super(f);
    }

    public ListItem(Chunk chunk) {
        super(chunk);
    }

    public ListItem(String str) {
        super(str);
    }

    public ListItem(String str, Font font) {
        super(str, font);
    }

    public ListItem(float f, Chunk chunk) {
        super(f, chunk);
    }

    public ListItem(float f, String str) {
        super(f, str);
    }

    public ListItem(float f, String str, Font font) {
        super(f, str, font);
    }

    public ListItem(Phrase phrase) {
        super(phrase);
    }

    public void setListSymbol(Chunk chunk) {
        if (this.symbol == null) {
            this.symbol = chunk;
            if (this.symbol.getFont().isStandardFont()) {
                this.symbol.setFont(this.font);
            }
        }
    }

    public void setIndentationLeft(float f, boolean z) {
        if (z) {
            setIndentationLeft(getListSymbol().getWidthPoint());
        } else {
            setIndentationLeft(f);
        }
    }

    public Chunk getListSymbol() {
        return this.symbol;
    }
}
