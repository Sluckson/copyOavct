package com.lowagie.text;

import com.lowagie.text.factories.RomanNumberFactory;

public class RomanList extends List {
    public RomanList() {
        super(true);
    }

    public RomanList(int i) {
        super(true, (float) i);
    }

    public RomanList(boolean z, int i) {
        super(true, (float) i);
        this.lowercase = z;
    }

    public boolean add(Object obj) {
        if (obj instanceof ListItem) {
            ListItem listItem = (ListItem) obj;
            Chunk chunk = new Chunk(this.preSymbol, this.symbol.getFont());
            chunk.append(RomanNumberFactory.getString(this.first + this.list.size(), this.lowercase));
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
