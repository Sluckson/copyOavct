package com.lowagie.text;

import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class ZapfDingbatsList extends List {

    /* renamed from: zn */
    protected int f602zn;

    public ZapfDingbatsList(int i) {
        super(true);
        this.f602zn = i;
        this.symbol.setFont(FontFactory.getFont("ZapfDingbats", this.symbol.getFont().getSize(), 0));
        this.postSymbol = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
    }

    public ZapfDingbatsList(int i, int i2) {
        super(true, (float) i2);
        this.f602zn = i;
        this.symbol.setFont(FontFactory.getFont("ZapfDingbats", this.symbol.getFont().getSize(), 0));
        this.postSymbol = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
    }

    public void setCharNumber(int i) {
        this.f602zn = i;
    }

    public int getCharNumber() {
        return this.f602zn;
    }

    public boolean add(Object obj) {
        if (obj instanceof ListItem) {
            ListItem listItem = (ListItem) obj;
            Chunk chunk = new Chunk(this.preSymbol, this.symbol.getFont());
            chunk.append(String.valueOf((char) this.f602zn));
            chunk.append(this.postSymbol);
            listItem.setListSymbol(chunk);
            listItem.setIndentationLeft(this.symbolIndent, this.autoindent);
            listItem.setIndentationRight(0.0f);
            this.list.add(listItem);
            return false;
        } else if (obj instanceof List) {
            List list = (List) obj;
            list.setIndentationLeft(list.getIndentationLeft() + this.symbolIndent);
            this.first--;
            return this.list.add(list);
        } else if (obj instanceof String) {
            return add(new ListItem((String) obj));
        } else {
            return false;
        }
    }
}
