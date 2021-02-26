package com.lowagie.text;

import org.codehaus.jackson.util.MinimalPrettyPrinter;

public class ZapfDingbatsNumberList extends List {
    protected int type;

    public ZapfDingbatsNumberList(int i) {
        super(true);
        this.type = i;
        this.symbol.setFont(FontFactory.getFont("ZapfDingbats", this.symbol.getFont().getSize(), 0));
        this.postSymbol = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
    }

    public ZapfDingbatsNumberList(int i, int i2) {
        super(true, (float) i2);
        this.type = i;
        this.symbol.setFont(FontFactory.getFont("ZapfDingbats", this.symbol.getFont().getSize(), 0));
        this.postSymbol = MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR;
    }

    public void setType(int i) {
        this.type = i;
    }

    public int getType() {
        return this.type;
    }

    public boolean add(Object obj) {
        if (obj instanceof ListItem) {
            ListItem listItem = (ListItem) obj;
            Chunk chunk = new Chunk(this.preSymbol, this.symbol.getFont());
            int i = this.type;
            if (i == 0) {
                chunk.append(String.valueOf((char) (this.first + this.list.size() + 171)));
            } else if (i == 1) {
                chunk.append(String.valueOf((char) (this.first + this.list.size() + 181)));
            } else if (i != 2) {
                chunk.append(String.valueOf((char) (this.first + this.list.size() + 201)));
            } else {
                chunk.append(String.valueOf((char) (this.first + this.list.size() + 191)));
            }
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
