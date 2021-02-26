package com.google.inject.internal;

import java.util.Collection;
import java.util.Set;

public final class Collections2 {
    private Collections2() {
    }

    static <E> Collection<E> toCollection(Iterable<E> iterable) {
        return iterable instanceof Collection ? (Collection) iterable : Lists.newArrayList(iterable);
    }

    static boolean setEquals(Set<?> set, @Nullable Object obj) {
        if (obj == set) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set2 = (Set) obj;
        if (set.size() != set2.size() || !set.containsAll(set2)) {
            return false;
        }
        return true;
    }
}
