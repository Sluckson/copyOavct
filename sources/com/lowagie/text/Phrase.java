package com.lowagie.text;

import com.lowagie.text.pdf.HyphenationEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Phrase extends ArrayList implements TextElementArray {
    private static final long serialVersionUID = 2643594602455068231L;
    protected Font font;
    protected HyphenationEvent hyphenation;
    protected float leading;

    public boolean isContent() {
        return true;
    }

    public boolean isNestable() {
        return true;
    }

    public int type() {
        return 11;
    }

    public Phrase() {
        this(16.0f);
    }

    public Phrase(Phrase phrase) {
        this.leading = Float.NaN;
        this.hyphenation = null;
        addAll(phrase);
        this.leading = phrase.getLeading();
        this.font = phrase.getFont();
        setHyphenation(phrase.getHyphenation());
    }

    public Phrase(float f) {
        this.leading = Float.NaN;
        this.hyphenation = null;
        this.leading = f;
        this.font = new Font();
    }

    public Phrase(Chunk chunk) {
        this.leading = Float.NaN;
        this.hyphenation = null;
        super.add(chunk);
        this.font = chunk.getFont();
        setHyphenation(chunk.getHyphenation());
    }

    public Phrase(float f, Chunk chunk) {
        this.leading = Float.NaN;
        this.hyphenation = null;
        this.leading = f;
        super.add(chunk);
        this.font = chunk.getFont();
        setHyphenation(chunk.getHyphenation());
    }

    public Phrase(String str) {
        this(Float.NaN, str, new Font());
    }

    public Phrase(String str, Font font2) {
        this(Float.NaN, str, font2);
    }

    public Phrase(float f, String str) {
        this(f, str, new Font());
    }

    public Phrase(float f, String str, Font font2) {
        this.leading = Float.NaN;
        this.hyphenation = null;
        this.leading = f;
        this.font = font2;
        if (str != null && str.length() != 0) {
            super.add(new Chunk(str, font2));
        }
    }

    public boolean process(ElementListener elementListener) {
        try {
            Iterator it = iterator();
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
        Iterator it = iterator();
        while (it.hasNext()) {
            arrayList.addAll(((Element) it.next()).getChunks());
        }
        return arrayList;
    }

    public void add(int i, Object obj) {
        if (obj != null) {
            try {
                Element element = (Element) obj;
                if (element.type() == 10) {
                    Chunk chunk = (Chunk) element;
                    if (!this.font.isStandardFont()) {
                        chunk.setFont(this.font.difference(chunk.getFont()));
                    }
                    if (this.hyphenation != null && chunk.getHyphenation() == null && !chunk.isEmpty()) {
                        chunk.setHyphenation(this.hyphenation);
                    }
                    super.add(i, chunk);
                    return;
                }
                if (!(element.type() == 11 || element.type() == 17 || element.type() == 29 || element.type() == 22 || element.type() == 55)) {
                    if (element.type() != 50) {
                        throw new ClassCastException(String.valueOf(element.type()));
                    }
                }
                super.add(i, element);
            } catch (ClassCastException e) {
                throw new ClassCastException("Insertion of illegal Element: " + e.getMessage());
            }
        }
    }

    public boolean add(Object obj) {
        boolean z;
        if (obj == null) {
            return false;
        }
        if (obj instanceof String) {
            return super.add(new Chunk((String) obj, this.font));
        }
        if (obj instanceof RtfElementInterface) {
            return super.add(obj);
        }
        try {
            Element element = (Element) obj;
            int type = element.type();
            if (type == 14 || type == 17 || type == 29 || type == 50 || type == 55 || type == 22 || type == 23) {
                return super.add(obj);
            }
            switch (type) {
                case 10:
                    return addChunk((Chunk) obj);
                case 11:
                case 12:
                    boolean z2 = true;
                    Iterator it = ((Phrase) obj).iterator();
                    while (it.hasNext()) {
                        Element element2 = (Element) it.next();
                        if (element2 instanceof Chunk) {
                            z = addChunk((Chunk) element2);
                        } else {
                            z = add(element2);
                        }
                        z2 &= z;
                    }
                    return z2;
                default:
                    throw new ClassCastException(String.valueOf(element.type()));
            }
        } catch (ClassCastException e) {
            throw new ClassCastException("Insertion of illegal Element: " + e.getMessage());
        }
    }

    public boolean addAll(Collection collection) {
        for (Object add : collection) {
            add(add);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean addChunk(Chunk chunk) {
        Font font2 = chunk.getFont();
        String content = chunk.getContent();
        Font font3 = this.font;
        if (font3 != null && !font3.isStandardFont()) {
            font2 = this.font.difference(chunk.getFont());
        }
        if (size() > 0 && !chunk.hasAttributes()) {
            try {
                Chunk chunk2 = (Chunk) get(size() - 1);
                if (!chunk2.hasAttributes() && ((font2 == null || font2.compareTo(chunk2.getFont()) == 0) && !"".equals(chunk2.getContent().trim()) && !"".equals(content.trim()))) {
                    chunk2.append(content);
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        Chunk chunk3 = new Chunk(content, font2);
        chunk3.setAttributes(chunk.getAttributes());
        if (this.hyphenation != null && chunk3.getHyphenation() == null && !chunk3.isEmpty()) {
            chunk3.setHyphenation(this.hyphenation);
        }
        return super.add(chunk3);
    }

    /* access modifiers changed from: protected */
    public void addSpecial(Object obj) {
        super.add(obj);
    }

    public void setLeading(float f) {
        this.leading = f;
    }

    public void setFont(Font font2) {
        this.font = font2;
    }

    public float getLeading() {
        Font font2;
        if (!Float.isNaN(this.leading) || (font2 = this.font) == null) {
            return this.leading;
        }
        return font2.getCalculatedLeading(1.5f);
    }

    public boolean hasLeading() {
        return !Float.isNaN(this.leading);
    }

    public Font getFont() {
        return this.font;
    }

    public String getContent() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = getChunks().iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next().toString());
        }
        return stringBuffer.toString();
    }

    public boolean isEmpty() {
        int size = size();
        if (size == 0) {
            return true;
        }
        if (size != 1) {
            return false;
        }
        Element element = (Element) get(0);
        return element.type() == 10 && ((Chunk) element).isEmpty();
    }

    public HyphenationEvent getHyphenation() {
        return this.hyphenation;
    }

    public void setHyphenation(HyphenationEvent hyphenationEvent) {
        this.hyphenation = hyphenationEvent;
    }

    private Phrase(boolean z) {
        this.leading = Float.NaN;
        this.hyphenation = null;
    }

    public static final Phrase getInstance(String str) {
        return getInstance(16, str, new Font());
    }

    public static final Phrase getInstance(int i, String str) {
        return getInstance(i, str, new Font());
    }

    public static final Phrase getInstance(int i, String str, Font font2) {
        Phrase phrase = new Phrase(true);
        phrase.setLeading((float) i);
        phrase.font = font2;
        if (font2.getFamily() != 3 && font2.getFamily() != 4 && font2.getBaseFont() == null) {
            while (true) {
                int index = SpecialSymbol.index(str);
                if (index <= -1) {
                    break;
                }
                if (index > 0) {
                    phrase.add(new Chunk(str.substring(0, index), font2));
                    str = str.substring(index);
                }
                Font font3 = new Font(3, font2.getSize(), font2.getStyle(), font2.getColor());
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(SpecialSymbol.getCorrespondingSymbol(str.charAt(0)));
                str = str.substring(1);
                while (SpecialSymbol.index(str) == 0) {
                    stringBuffer.append(SpecialSymbol.getCorrespondingSymbol(str.charAt(0)));
                    str = str.substring(1);
                }
                phrase.add(new Chunk(stringBuffer.toString(), font3));
            }
        }
        if (!(str == null || str.length() == 0)) {
            phrase.add(new Chunk(str, font2));
        }
        return phrase;
    }
}
