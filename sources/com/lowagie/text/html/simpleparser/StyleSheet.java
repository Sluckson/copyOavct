package com.lowagie.text.html.simpleparser;

import com.lowagie.text.html.Markup;
import java.util.HashMap;

public class StyleSheet {
    public HashMap classMap = new HashMap();
    public HashMap tagMap = new HashMap();

    public void applyStyle(String str, HashMap hashMap) {
        HashMap hashMap2;
        HashMap hashMap3 = (HashMap) this.tagMap.get(str.toLowerCase());
        if (hashMap3 != null) {
            HashMap hashMap4 = new HashMap(hashMap3);
            hashMap4.putAll(hashMap);
            hashMap.putAll(hashMap4);
        }
        String str2 = (String) hashMap.get(Markup.HTML_ATTR_CSS_CLASS);
        if (str2 != null && (hashMap2 = (HashMap) this.classMap.get(str2.toLowerCase())) != null) {
            hashMap.remove(Markup.HTML_ATTR_CSS_CLASS);
            HashMap hashMap5 = new HashMap(hashMap2);
            hashMap5.putAll(hashMap);
            hashMap.putAll(hashMap5);
        }
    }

    public void loadStyle(String str, HashMap hashMap) {
        this.classMap.put(str.toLowerCase(), hashMap);
    }

    public void loadStyle(String str, String str2, String str3) {
        String lowerCase = str.toLowerCase();
        HashMap hashMap = (HashMap) this.classMap.get(lowerCase);
        if (hashMap == null) {
            hashMap = new HashMap();
            this.classMap.put(lowerCase, hashMap);
        }
        hashMap.put(str2, str3);
    }

    public void loadTagStyle(String str, HashMap hashMap) {
        this.tagMap.put(str.toLowerCase(), hashMap);
    }

    public void loadTagStyle(String str, String str2, String str3) {
        String lowerCase = str.toLowerCase();
        HashMap hashMap = (HashMap) this.tagMap.get(lowerCase);
        if (hashMap == null) {
            hashMap = new HashMap();
            this.tagMap.put(lowerCase, hashMap);
        }
        hashMap.put(str2, str3);
    }
}
