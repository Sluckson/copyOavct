package com.google.firebase.encoders;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.annotation.Annotation;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class FieldDescriptor {
    private final String name;
    private final Map<Class<?>, Object> properties;

    private FieldDescriptor(String str, Map<Class<?>, Object> map) {
        this.name = str;
        this.properties = map;
    }

    @NonNull
    public String getName() {
        return this.name;
    }

    @Nullable
    public <T extends Annotation> T getProperty(@NonNull Class<T> cls) {
        return (Annotation) this.properties.get(cls);
    }

    @NonNull
    public static Builder builder(@NonNull String str) {
        return new Builder(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FieldDescriptor)) {
            return false;
        }
        FieldDescriptor fieldDescriptor = (FieldDescriptor) obj;
        if (!this.name.equals(fieldDescriptor.name) || !this.properties.equals(fieldDescriptor.properties)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.properties.hashCode();
    }

    @NonNull
    public String toString() {
        return "FieldDescriptor{name=" + this.name + ", properties=" + this.properties.values() + "}";
    }

    public static final class Builder {
        private final String name;
        private Map<Class<?>, Object> properties = null;

        Builder(String str) {
            this.name = str;
        }

        @NonNull
        public <T extends Annotation> Builder withProperty(@NonNull T t) {
            if (this.properties == null) {
                this.properties = new HashMap();
            }
            this.properties.put(t.annotationType(), t);
            return this;
        }

        @NonNull
        public FieldDescriptor build() {
            Map map;
            String str = this.name;
            Map<Class<?>, Object> map2 = this.properties;
            if (map2 == null) {
                map = Collections.emptyMap();
            } else {
                map = Collections.unmodifiableMap(new HashMap(map2));
            }
            return new FieldDescriptor(str, map);
        }
    }
}
