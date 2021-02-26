package com.google.inject.internal;

import java.util.LinkedHashMap;
import java.util.Map;

public class ToStringBuilder {
    final Map<String, Object> map = new LinkedHashMap();
    final String name;

    public ToStringBuilder(String str) {
        this.name = str;
    }

    public ToStringBuilder(Class cls) {
        this.name = cls.getSimpleName();
    }

    public ToStringBuilder add(String str, Object obj) {
        if (this.map.put(str, obj) == null) {
            return this;
        }
        throw new RuntimeException("Duplicate names: " + str);
    }

    public String toString() {
        return this.name + this.map.toString().replace('{', '[').replace('}', ']');
    }
}
