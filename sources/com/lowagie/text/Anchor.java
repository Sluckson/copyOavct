package com.lowagie.text;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

public class Anchor extends Phrase {
    private static final long serialVersionUID = -852278536049236911L;
    protected String name = null;
    protected String reference = null;

    public int type() {
        return 17;
    }

    public Anchor() {
        super(16.0f);
    }

    public Anchor(float f) {
        super(f);
    }

    public Anchor(Chunk chunk) {
        super(chunk);
    }

    public Anchor(String str) {
        super(str);
    }

    public Anchor(String str, Font font) {
        super(str, font);
    }

    public Anchor(float f, Chunk chunk) {
        super(f, chunk);
    }

    public Anchor(float f, String str) {
        super(f, str);
    }

    public Anchor(float f, String str, Font font) {
        super(f, str, font);
    }

    public Anchor(Phrase phrase) {
        super(phrase);
        if (phrase instanceof Anchor) {
            Anchor anchor = (Anchor) phrase;
            setName(anchor.name);
            setReference(anchor.reference);
        }
    }

    public boolean process(ElementListener elementListener) {
        try {
            Iterator it = getChunks().iterator();
            boolean z = this.reference != null && this.reference.startsWith("#");
            boolean z2 = true;
            while (it.hasNext()) {
                Chunk chunk = (Chunk) it.next();
                if (this.name != null && z2 && !chunk.isEmpty()) {
                    chunk.setLocalDestination(this.name);
                    z2 = false;
                }
                if (z) {
                    chunk.setLocalGoto(this.reference.substring(1));
                }
                elementListener.add(chunk);
            }
            return true;
        } catch (DocumentException unused) {
            return false;
        }
    }

    public ArrayList getChunks() {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterator();
        String str = this.reference;
        boolean z = str != null && str.startsWith("#");
        boolean z2 = true;
        while (it.hasNext()) {
            Chunk chunk = (Chunk) it.next();
            if (this.name != null && z2 && !chunk.isEmpty()) {
                chunk.setLocalDestination(this.name);
                z2 = false;
            }
            if (z) {
                chunk.setLocalGoto(this.reference.substring(1));
            } else {
                String str2 = this.reference;
                if (str2 != null) {
                    chunk.setAnchor(str2);
                }
            }
            arrayList.add(chunk);
        }
        return arrayList;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setReference(String str) {
        this.reference = str;
    }

    public String getName() {
        return this.name;
    }

    public String getReference() {
        return this.reference;
    }

    public URL getUrl() {
        try {
            return new URL(this.reference);
        } catch (MalformedURLException unused) {
            return null;
        }
    }
}
