package com.wowza.gocoder.sdk.api.data;

import com.lowagie.text.html.HtmlTags;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.codehaus.jackson.util.MinimalPrettyPrinter;

/* compiled from: GoCoderSDK */
public class WOWZDataList extends WOWZData implements Serializable, Iterable {

    /* renamed from: a */
    private ArrayList<WOWZData> f3598a = new ArrayList<>();

    public WOWZDataList() {
        this.mDataType = WOWZDataType.DATA_LIST;
    }

    public int size() {
        return this.f3598a.size();
    }

    public void add(int i, WOWZData wOWZData) {
        this.f3598a.add(i, wOWZData);
    }

    public void add(int i, int i2) {
        this.f3598a.add(i, new WOWZDataItem(i2));
    }

    public void add(int i, short s) {
        this.f3598a.add(i, new WOWZDataItem(s));
    }

    public void add(int i, long j) {
        this.f3598a.add(i, new WOWZDataItem(j));
    }

    public void add(int i, float f) {
        this.f3598a.add(i, new WOWZDataItem(f));
    }

    public void add(int i, double d) {
        this.f3598a.add(i, new WOWZDataItem(d));
    }

    public void add(int i, String str) {
        this.f3598a.add(i, new WOWZDataItem(str));
    }

    public void add(int i, boolean z) {
        this.f3598a.add(i, new WOWZDataItem(z));
    }

    public void add(int i, Date date) {
        this.f3598a.add(i, new WOWZDataItem(date));
    }

    public boolean add(WOWZData wOWZData) {
        return this.f3598a.add(wOWZData);
    }

    public void add(int i) {
        this.f3598a.add(new WOWZDataItem(i));
    }

    public void add(short s) {
        this.f3598a.add(new WOWZDataItem(s));
    }

    public void add(long j) {
        this.f3598a.add(new WOWZDataItem(j));
    }

    public void add(float f) {
        this.f3598a.add(new WOWZDataItem(f));
    }

    public void add(double d) {
        this.f3598a.add(new WOWZDataItem(d));
    }

    public void add(String str) {
        this.f3598a.add(new WOWZDataItem(str));
    }

    public void add(boolean z) {
        this.f3598a.add(new WOWZDataItem(z));
    }

    public void add(Date date) {
        this.f3598a.add(new WOWZDataItem(date));
    }

    public WOWZData get(int i) {
        if (this.f3598a.size() > i) {
            return this.f3598a.get(i);
        }
        return null;
    }

    public boolean contains(WOWZData wOWZData) {
        return this.f3598a.contains(wOWZData);
    }

    public int indexOf(WOWZData wOWZData) {
        return this.f3598a.indexOf(wOWZData);
    }

    public int lastIndexOf(WOWZData wOWZData) {
        return this.f3598a.lastIndexOf(wOWZData);
    }

    public boolean isEmpty() {
        return this.f3598a.isEmpty();
    }

    public Iterator iterator() {
        return this.f3598a.iterator();
    }

    public WOWZData remove(int i) {
        return this.f3598a.remove(i);
    }

    public boolean remove(WOWZData wOWZData) {
        return this.f3598a.remove(wOWZData);
    }

    public void clear() {
        this.f3598a.clear();
    }

    public String toString() {
        return toString(true, 0);
    }

    public String toString(boolean z, int i) {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            WOWZDataType dataType = get(i2).getDataType();
            if (i > 0) {
                sb.append(String.format("%1$" + i + HtmlTags.f607S, new Object[]{MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR}));
            }
            if (dataType.equals(WOWZDataType.DATA_LIST) || dataType.equals(WOWZDataType.DATA_MAP)) {
                sb.append(String.format("%s", new Object[]{get(i2).toString(z, i + 2)}));
            } else {
                sb.append(get(i2).toString());
            }
            if (i2 < size - 1) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
