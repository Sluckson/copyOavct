package com.salesforce.marketingcloud.registration;

import androidx.annotation.NonNull;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* renamed from: com.salesforce.marketingcloud.registration.a */
class C4129a implements Map<String, String> {

    /* renamed from: a */
    private final HashMap<String, String> f3398a;

    /* renamed from: b */
    private final TreeMap<String, String> f3399b;

    C4129a() {
        this.f3398a = new HashMap<>();
        this.f3399b = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    }

    C4129a(Map<String, String> map) {
        this();
        if (map != null) {
            this.f3398a.putAll(map);
            for (String next : this.f3398a.keySet()) {
                this.f3399b.put(next, next);
            }
        }
    }

    /* renamed from: a */
    public String get(Object obj) {
        String str = this.f3399b.get(obj);
        if (str != null) {
            return this.f3398a.get(str);
        }
        return null;
    }

    /* renamed from: a */
    public String put(String str, String str2) {
        String str3 = null;
        if (str == null) {
            return null;
        }
        String str4 = this.f3399b.get(str);
        if (str4 != null) {
            str3 = this.f3398a.remove(str4);
        }
        this.f3399b.put(str, str);
        this.f3398a.put(str, str2);
        return str3;
    }

    /* renamed from: b */
    public String remove(Object obj) {
        return this.f3398a.remove(this.f3399b.remove(obj));
    }

    public void clear() {
        this.f3398a.clear();
        this.f3399b.clear();
    }

    public boolean containsKey(Object obj) {
        return this.f3399b.containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return this.f3398a.containsValue(obj);
    }

    @NonNull
    public Set<Map.Entry<String, String>> entrySet() {
        return this.f3398a.entrySet();
    }

    public boolean isEmpty() {
        return this.f3398a.isEmpty();
    }

    @NonNull
    public Set<String> keySet() {
        return this.f3398a.keySet();
    }

    public void putAll(@NonNull Map<? extends String, ? extends String> map) {
        if (map != null && !map.isEmpty()) {
            for (Map.Entry next : map.entrySet()) {
                put((String) next.getKey(), (String) next.getValue());
            }
        }
    }

    public int size() {
        return this.f3398a.size();
    }

    @NonNull
    public Collection<String> values() {
        return this.f3398a.values();
    }
}
