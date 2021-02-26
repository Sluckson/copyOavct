package com.lowagie.text;

import java.util.ArrayList;

public class Meta implements Element {
    private StringBuffer content;
    private int type;

    public boolean isContent() {
        return false;
    }

    public boolean isNestable() {
        return false;
    }

    Meta(int i, String str) {
        this.type = i;
        this.content = new StringBuffer(str);
    }

    public Meta(String str, String str2) {
        this.type = getType(str);
        this.content = new StringBuffer(str2);
    }

    public boolean process(ElementListener elementListener) {
        try {
            return elementListener.add(this);
        } catch (DocumentException unused) {
            return false;
        }
    }

    public int type() {
        return this.type;
    }

    public ArrayList getChunks() {
        return new ArrayList();
    }

    public StringBuffer append(String str) {
        StringBuffer stringBuffer = this.content;
        stringBuffer.append(str);
        return stringBuffer;
    }

    public String getContent() {
        return this.content.toString();
    }

    public String getName() {
        switch (this.type) {
            case 1:
                return "title";
            case 2:
                return "subject";
            case 3:
                return "keywords";
            case 4:
                return "author";
            case 5:
                return ElementTags.PRODUCER;
            case 6:
                return ElementTags.CREATIONDATE;
            default:
                return "unknown";
        }
    }

    public static int getType(String str) {
        if ("subject".equals(str)) {
            return 2;
        }
        if ("keywords".equals(str)) {
            return 3;
        }
        if ("author".equals(str)) {
            return 4;
        }
        if ("title".equals(str)) {
            return 1;
        }
        if (ElementTags.PRODUCER.equals(str)) {
            return 5;
        }
        return ElementTags.CREATIONDATE.equals(str) ? 6 : 0;
    }
}
