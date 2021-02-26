package com.lowagie.text;

public interface DocListener extends ElementListener {
    void close();

    boolean newPage();

    void open();

    void resetFooter();

    void resetHeader();

    void resetPageCount();

    void setFooter(HeaderFooter headerFooter);

    void setHeader(HeaderFooter headerFooter);

    boolean setMarginMirroring(boolean z);

    boolean setMarginMirroringTopBottom(boolean z);

    boolean setMargins(float f, float f2, float f3, float f4);

    void setPageCount(int i);

    boolean setPageSize(Rectangle rectangle);
}
