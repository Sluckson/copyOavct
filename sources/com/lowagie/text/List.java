package com.lowagie.text;

import com.lowagie.text.factories.RomanAlphabetFactory;
import java.util.ArrayList;
import java.util.Iterator;

public class List implements TextElementArray {
    public static final boolean ALPHABETICAL = true;
    public static final boolean LOWERCASE = true;
    public static final boolean NUMERICAL = false;
    public static final boolean ORDERED = true;
    public static final boolean UNORDERED = false;
    public static final boolean UPPERCASE = false;
    protected boolean alignindent;
    protected boolean autoindent;
    protected int first;
    protected float indentationLeft;
    protected float indentationRight;
    protected boolean lettered;
    protected ArrayList list;
    protected boolean lowercase;
    protected boolean numbered;
    protected String postSymbol;
    protected String preSymbol;
    protected Chunk symbol;
    protected float symbolIndent;

    public boolean isContent() {
        return true;
    }

    public boolean isNestable() {
        return true;
    }

    public int type() {
        return 14;
    }

    public List() {
        this(false, false);
    }

    public List(float f) {
        this.list = new ArrayList();
        this.numbered = false;
        this.lettered = false;
        this.lowercase = false;
        this.autoindent = false;
        this.alignindent = false;
        this.first = 1;
        this.symbol = new Chunk("- ");
        this.preSymbol = "";
        this.postSymbol = ". ";
        this.indentationLeft = 0.0f;
        this.indentationRight = 0.0f;
        this.symbolIndent = 0.0f;
        this.symbolIndent = f;
    }

    public List(boolean z) {
        this(z, false);
    }

    public List(boolean z, boolean z2) {
        this.list = new ArrayList();
        this.numbered = false;
        this.lettered = false;
        this.lowercase = false;
        this.autoindent = false;
        this.alignindent = false;
        this.first = 1;
        this.symbol = new Chunk("- ");
        this.preSymbol = "";
        this.postSymbol = ". ";
        this.indentationLeft = 0.0f;
        this.indentationRight = 0.0f;
        this.symbolIndent = 0.0f;
        this.numbered = z;
        this.lettered = z2;
        this.autoindent = true;
        this.alignindent = true;
    }

    public List(boolean z, float f) {
        this(z, false, f);
    }

    public List(boolean z, boolean z2, float f) {
        this.list = new ArrayList();
        this.numbered = false;
        this.lettered = false;
        this.lowercase = false;
        this.autoindent = false;
        this.alignindent = false;
        this.first = 1;
        this.symbol = new Chunk("- ");
        this.preSymbol = "";
        this.postSymbol = ". ";
        this.indentationLeft = 0.0f;
        this.indentationRight = 0.0f;
        this.symbolIndent = 0.0f;
        this.numbered = z;
        this.lettered = z2;
        this.symbolIndent = f;
    }

    public boolean process(ElementListener elementListener) {
        try {
            Iterator it = this.list.iterator();
            while (it.hasNext()) {
                elementListener.add((Element) it.next());
            }
            return true;
        } catch (DocumentException unused) {
            return false;
        }
    }

    public ArrayList getChunks() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.list.iterator();
        while (it.hasNext()) {
            arrayList.addAll(((Element) it.next()).getChunks());
        }
        return arrayList;
    }

    public boolean add(Object obj) {
        if (obj instanceof ListItem) {
            ListItem listItem = (ListItem) obj;
            if (this.numbered || this.lettered) {
                Chunk chunk = new Chunk(this.preSymbol, this.symbol.getFont());
                int size = this.first + this.list.size();
                if (this.lettered) {
                    chunk.append(RomanAlphabetFactory.getString(size, this.lowercase));
                } else {
                    chunk.append(String.valueOf(size));
                }
                chunk.append(this.postSymbol);
                listItem.setListSymbol(chunk);
            } else {
                listItem.setListSymbol(this.symbol);
            }
            listItem.setIndentationLeft(this.symbolIndent, this.autoindent);
            listItem.setIndentationRight(0.0f);
            return this.list.add(listItem);
        } else if (obj instanceof List) {
            List list2 = (List) obj;
            list2.setIndentationLeft(list2.getIndentationLeft() + this.symbolIndent);
            this.first--;
            return this.list.add(list2);
        } else if (obj instanceof String) {
            return add(new ListItem((String) obj));
        } else {
            return false;
        }
    }

    public void normalizeIndentation() {
        Iterator it = this.list.iterator();
        float f = 0.0f;
        while (it.hasNext()) {
            Element element = (Element) it.next();
            if (element instanceof ListItem) {
                f = Math.max(f, ((ListItem) element).getIndentationLeft());
            }
        }
        Iterator it2 = this.list.iterator();
        while (it2.hasNext()) {
            Element element2 = (Element) it2.next();
            if (element2 instanceof ListItem) {
                ((ListItem) element2).setIndentationLeft(f);
            }
        }
    }

    public void setNumbered(boolean z) {
        this.numbered = z;
    }

    public void setLettered(boolean z) {
        this.lettered = z;
    }

    public void setLowercase(boolean z) {
        this.lowercase = z;
    }

    public void setAutoindent(boolean z) {
        this.autoindent = z;
    }

    public void setAlignindent(boolean z) {
        this.alignindent = z;
    }

    public void setFirst(int i) {
        this.first = i;
    }

    public void setListSymbol(Chunk chunk) {
        this.symbol = chunk;
    }

    public void setListSymbol(String str) {
        this.symbol = new Chunk(str);
    }

    public void setIndentationLeft(float f) {
        this.indentationLeft = f;
    }

    public void setIndentationRight(float f) {
        this.indentationRight = f;
    }

    public void setSymbolIndent(float f) {
        this.symbolIndent = f;
    }

    public ArrayList getItems() {
        return this.list;
    }

    public int size() {
        return this.list.size();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public float getTotalLeading() {
        if (this.list.size() < 1) {
            return -1.0f;
        }
        return ((ListItem) this.list.get(0)).getTotalLeading();
    }

    public boolean isNumbered() {
        return this.numbered;
    }

    public boolean isLettered() {
        return this.lettered;
    }

    public boolean isLowercase() {
        return this.lowercase;
    }

    public boolean isAutoindent() {
        return this.autoindent;
    }

    public boolean isAlignindent() {
        return this.alignindent;
    }

    public int getFirst() {
        return this.first;
    }

    public Chunk getSymbol() {
        return this.symbol;
    }

    public float getIndentationLeft() {
        return this.indentationLeft;
    }

    public float getIndentationRight() {
        return this.indentationRight;
    }

    public float getSymbolIndent() {
        return this.symbolIndent;
    }

    public String getPostSymbol() {
        return this.postSymbol;
    }

    public void setPostSymbol(String str) {
        this.postSymbol = str;
    }

    public String getPreSymbol() {
        return this.preSymbol;
    }

    public void setPreSymbol(String str) {
        this.preSymbol = str;
    }
}
