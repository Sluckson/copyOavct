package com.wowza.gocoder.sdk.api.data;

import com.lowagie.text.html.HtmlTags;
import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Set;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* compiled from: GoCoderSDK */
public class WOWZDataMap extends WOWZData implements Serializable {

    /* renamed from: a */
    private LinkedHashMap<String, WOWZData> f3599a = new LinkedHashMap<>();

    public WOWZDataMap() {
        this.mDataType = WOWZDataType.DATA_MAP;
    }

    public int size() {
        return this.f3599a.size();
    }

    public void put(String str, WOWZData wOWZData) {
        this.f3599a.put(str, wOWZData);
    }

    public void put(String str, int i) {
        this.f3599a.put(str, new WOWZDataItem(i));
    }

    public void put(String str, short s) {
        this.f3599a.put(str, new WOWZDataItem(s));
    }

    public void put(String str, long j) {
        this.f3599a.put(str, new WOWZDataItem(j));
    }

    public void put(String str, float f) {
        this.f3599a.put(str, new WOWZDataItem(f));
    }

    public void put(String str, double d) {
        this.f3599a.put(str, new WOWZDataItem(d));
    }

    public void put(String str, String str2) {
        this.f3599a.put(str, new WOWZDataItem(str2));
    }

    public void put(String str, boolean z) {
        this.f3599a.put(str, new WOWZDataItem(z));
    }

    public void put(String str, Date date) {
        this.f3599a.put(str, new WOWZDataItem(date));
    }

    public boolean containsKey(String str) {
        return this.f3599a.containsKey(str);
    }

    public boolean containsValue(Object obj) {
        return this.f3599a.containsValue(obj);
    }

    public WOWZData get(String str) {
        if (this.f3599a.containsKey(str)) {
            return this.f3599a.get(str);
        }
        return null;
    }

    public boolean isEmpty() {
        return this.f3599a.isEmpty();
    }

    public String[] keys() {
        return (String[]) this.f3599a.keySet().toArray(new String[this.f3599a.keySet().size()]);
    }

    public Set keySet() {
        return this.f3599a.keySet();
    }

    public WOWZData remove(String str) {
        if (containsKey(str)) {
            return (WOWZData) this.f3599a.remove(str);
        }
        return null;
    }

    public void clear() {
        this.f3599a.clear();
    }

    public String toString() {
        return toString(true, 0);
    }

    public String toString(boolean z) {
        return toString(z, 0);
    }

    public String toString(boolean z, int i) {
        String str;
        StringBuilder sb = new StringBuilder();
        String[] keys = keys();
        int length = keys.length;
        int i2 = 0;
        for (String length2 : keys) {
            i2 = Math.max(i2, length2.length());
        }
        for (int i3 = 0; i3 < length; i3++) {
            String str2 = keys[i3];
            WOWZDataType dataType = get(str2).getDataType();
            if (!z) {
                str = (dataType.equals(WOWZDataType.DATA_LIST) || dataType.equals(WOWZDataType.DATA_MAP)) ? "%s:\n%s" : "%s: %s";
            } else if (dataType.equals(WOWZDataType.DATA_LIST) || dataType.equals(WOWZDataType.DATA_MAP)) {
                str = "%1$" + i2 + "s:\n%2$s";
            } else {
                str = "%1$" + i2 + "s: %2$s";
            }
            if (i > 0) {
                sb.append(String.format("%1$" + i + HtmlTags.f607S, new Object[]{MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR}));
            }
            int i4 = i + 2;
            if (dataType.equals(WOWZDataType.DATA_LIST) || dataType.equals(WOWZDataType.DATA_MAP)) {
                sb.append(String.format(str, new Object[]{str2, get(str2).toString(z, i4)}));
            } else {
                sb.append(String.format(str, new Object[]{str2, get(str2).toString()}));
            }
            if (i3 < length - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
