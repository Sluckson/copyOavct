package com.google.inject.internal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class Sets {
    private Sets() {
    }

    public static <E> HashSet<E> newHashSet() {
        return new HashSet<>();
    }

    public static <E> LinkedHashSet<E> newLinkedHashSet() {
        return new LinkedHashSet<>();
    }

    public static <E> Set<E> newSetFromMap(Map<E, Boolean> map) {
        return new SetFromMap(map);
    }

    private static class SetFromMap<E> extends AbstractSet<E> implements Set<E>, Serializable {
        static final long serialVersionUID = 0;

        /* renamed from: m */
        private final Map<E, Boolean> f383m;

        /* renamed from: s */
        private transient Set<E> f384s;

        SetFromMap(Map<E, Boolean> map) {
            Preconditions.checkArgument(map.isEmpty(), "Map is non-empty");
            this.f383m = map;
            this.f384s = map.keySet();
        }

        public void clear() {
            this.f383m.clear();
        }

        public int size() {
            return this.f383m.size();
        }

        public boolean isEmpty() {
            return this.f383m.isEmpty();
        }

        public boolean contains(Object obj) {
            return this.f383m.containsKey(obj);
        }

        public boolean remove(Object obj) {
            return this.f383m.remove(obj) != null;
        }

        public boolean add(E e) {
            return this.f383m.put(e, Boolean.TRUE) == null;
        }

        public Iterator<E> iterator() {
            return this.f384s.iterator();
        }

        public Object[] toArray() {
            return this.f384s.toArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return this.f384s.toArray(tArr);
        }

        public String toString() {
            return this.f384s.toString();
        }

        public int hashCode() {
            return this.f384s.hashCode();
        }

        public boolean equals(@Nullable Object obj) {
            return this == obj || this.f384s.equals(obj);
        }

        public boolean containsAll(Collection<?> collection) {
            return this.f384s.containsAll(collection);
        }

        public boolean removeAll(Collection<?> collection) {
            return this.f384s.removeAll(collection);
        }

        public boolean retainAll(Collection<?> collection) {
            return this.f384s.retainAll(collection);
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            objectInputStream.defaultReadObject();
            this.f384s = this.f383m.keySet();
        }
    }

    static int hashCodeImpl(Set<?> set) {
        Iterator<?> it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i += next != null ? next.hashCode() : 0;
        }
        return i;
    }
}
