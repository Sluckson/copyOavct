package org.codehaus.jackson.util;

import java.util.LinkedHashMap;
import java.util.Map;

public final class InternCache extends LinkedHashMap<String, String> {
    private static final int MAX_ENTRIES = 192;
    public static final InternCache instance = new InternCache();

    private InternCache() {
        super(192, 0.8f, true);
    }

    /* access modifiers changed from: protected */
    public boolean removeEldestEntry(Map.Entry<String, String> entry) {
        return size() > 192;
    }

    public synchronized String intern(String str) {
        String str2;
        str2 = (String) get(str);
        if (str2 == null) {
            str2 = str.intern();
            put(str2, str2);
        }
        return str2;
    }
}
