package com.lowagie.text.pdf.codec.wmf;

public class MetaObject {
    public static final int META_BRUSH = 2;
    public static final int META_FONT = 3;
    public static final int META_NOT_SUPPORTED = 0;
    public static final int META_PEN = 1;
    public int type = 0;

    public MetaObject() {
    }

    public MetaObject(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }
}
