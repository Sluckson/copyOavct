package com.google.inject.internal;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public final class Maps {
    private Maps() {
    }

    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<>();
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap() {
        return new LinkedHashMap<>();
    }

    public static <K extends Comparable, V> TreeMap<K, V> newTreeMap() {
        return new TreeMap<>();
    }

    public static <K, V> IdentityHashMap<K, V> newIdentityHashMap() {
        return new IdentityHashMap<>();
    }

    public static <K, V> Map.Entry<K, V> immutableEntry(@Nullable K k, @Nullable V v) {
        return new ImmutableEntry(k, v);
    }
}
