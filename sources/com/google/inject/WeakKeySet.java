package com.google.inject;

import com.google.inject.internal.Sets;
import java.util.Set;

final class WeakKeySet {
    private Set<String> backingSet = Sets.newHashSet();

    WeakKeySet() {
    }

    public boolean add(Key<?> key) {
        return this.backingSet.add(key.toString());
    }

    public boolean contains(Object obj) {
        return (obj instanceof Key) && this.backingSet.contains(obj.toString());
    }
}
