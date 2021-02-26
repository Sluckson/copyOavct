package com.lowagie.text.html.simpleparser;

import com.lowagie.text.ElementTags;
import java.util.ArrayList;
import java.util.HashMap;

public class ChainedProperties {
    public static final int[] fontSizes = {8, 10, 12, 14, 18, 24, 36};
    public ArrayList chain = new ArrayList();

    public String getProperty(String str) {
        for (int size = this.chain.size() - 1; size >= 0; size--) {
            String str2 = (String) ((HashMap) ((Object[]) this.chain.get(size))[1]).get(str);
            if (str2 != null) {
                return str2;
            }
        }
        return null;
    }

    public boolean hasProperty(String str) {
        for (int size = this.chain.size() - 1; size >= 0; size--) {
            if (((HashMap) ((Object[]) this.chain.get(size))[1]).containsKey(str)) {
                return true;
            }
        }
        return false;
    }

    public void addToChain(String str, HashMap hashMap) {
        int i;
        String str2 = (String) hashMap.get(ElementTags.SIZE);
        if (str2 != null) {
            if (str2.endsWith("pt")) {
                hashMap.put(ElementTags.SIZE, str2.substring(0, str2.length() - 2));
            } else {
                if (str2.startsWith("+") || str2.startsWith("-")) {
                    String property = getProperty("basefontsize");
                    if (property == null) {
                        property = "12";
                    }
                    int parseFloat = (int) Float.parseFloat(property);
                    int length = fontSizes.length - 1;
                    while (true) {
                        if (length < 0) {
                            length = 0;
                            break;
                        } else if (parseFloat >= fontSizes[length]) {
                            break;
                        } else {
                            length--;
                        }
                    }
                    if (str2.startsWith("+")) {
                        str2 = str2.substring(1);
                    }
                    i = Integer.parseInt(str2) + length;
                } else {
                    try {
                        i = Integer.parseInt(str2) - 1;
                    } catch (NumberFormatException unused) {
                        i = 0;
                    }
                }
                if (i < 0) {
                    i = 0;
                } else {
                    int[] iArr = fontSizes;
                    if (i >= iArr.length) {
                        i = iArr.length - 1;
                    }
                }
                hashMap.put(ElementTags.SIZE, Integer.toString(fontSizes[i]));
            }
        }
        this.chain.add(new Object[]{str, hashMap});
    }

    public void removeChain(String str) {
        for (int size = this.chain.size() - 1; size >= 0; size--) {
            if (str.equals(((Object[]) this.chain.get(size))[0])) {
                this.chain.remove(size);
                return;
            }
        }
    }
}
