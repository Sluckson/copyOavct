package com.google.inject.name;

import com.google.inject.Binder;
import com.google.inject.Key;
import java.lang.annotation.Annotation;
import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;

public class Names {
    private Names() {
    }

    public static Named named(String str) {
        return new NamedImpl(str);
    }

    public static void bindProperties(Binder binder, Map<String, String> map) {
        Binder skipSources = binder.skipSources(Names.class);
        for (Map.Entry next : map.entrySet()) {
            skipSources.bind(Key.get(String.class, (Annotation) new NamedImpl((String) next.getKey()))).toInstance((String) next.getValue());
        }
    }

    public static void bindProperties(Binder binder, Properties properties) {
        Binder skipSources = binder.skipSources(Names.class);
        Enumeration<?> propertyNames = properties.propertyNames();
        while (propertyNames.hasMoreElements()) {
            String str = (String) propertyNames.nextElement();
            skipSources.bind(Key.get(String.class, (Annotation) new NamedImpl(str))).toInstance(properties.getProperty(str));
        }
    }
}
