package com.google.inject.internal;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class ImmutableCollection<E> implements Collection<E>, Serializable {
    /* access modifiers changed from: private */
    public static final Object[] EMPTY_ARRAY = new Object[0];
    static final ImmutableCollection<Object> EMPTY_IMMUTABLE_COLLECTION = new EmptyImmutableCollection();
    /* access modifiers changed from: private */
    public static final UnmodifiableIterator<Object> EMPTY_ITERATOR = new UnmodifiableIterator<Object>() {
        public boolean hasNext() {
            return false;
        }

        public Object next() {
            throw new NoSuchElementException();
        }
    };

    public abstract UnmodifiableIterator<E> iterator();

    ImmutableCollection() {
    }

    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    public <T> T[] toArray(T[] tArr) {
        int size = size();
        if (tArr.length < size) {
            tArr = ObjectArrays.newArray(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        int i = 0;
        Iterator it = iterator();
        while (it.hasNext()) {
            tArr[i] = it.next();
            i++;
        }
        return tArr;
    }

    public boolean contains(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        Iterator it = iterator();
        while (it.hasNext()) {
            if (it.next().equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsAll(Collection<?> collection) {
        for (Object contains : collection) {
            if (!contains(contains)) {
                return false;
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(size() * 16);
        sb.append('[');
        UnmodifiableIterator it = iterator();
        if (it.hasNext()) {
            sb.append(it.next());
        }
        while (it.hasNext()) {
            sb.append(", ");
            sb.append(it.next());
        }
        sb.append(']');
        return sb.toString();
    }

    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        throw new UnsupportedOperationException();
    }

    private static class EmptyImmutableCollection extends ImmutableCollection<Object> {
        public boolean contains(@Nullable Object obj) {
            return false;
        }

        public boolean isEmpty() {
            return true;
        }

        public int size() {
            return 0;
        }

        private EmptyImmutableCollection() {
        }

        public UnmodifiableIterator<Object> iterator() {
            return ImmutableCollection.EMPTY_ITERATOR;
        }

        public Object[] toArray() {
            return ImmutableCollection.EMPTY_ARRAY;
        }

        public <T> T[] toArray(T[] tArr) {
            if (tArr.length > 0) {
                tArr[0] = null;
            }
            return tArr;
        }
    }

    private static class ArrayImmutableCollection<E> extends ImmutableCollection<E> {
        /* access modifiers changed from: private */
        public final E[] elements;

        public boolean isEmpty() {
            return false;
        }

        ArrayImmutableCollection(E[] eArr) {
            this.elements = eArr;
        }

        public int size() {
            return this.elements.length;
        }

        public UnmodifiableIterator<E> iterator() {
            return new UnmodifiableIterator<E>() {

                /* renamed from: i */
                int f379i = 0;

                public boolean hasNext() {
                    return this.f379i < ArrayImmutableCollection.this.elements.length;
                }

                public E next() {
                    if (hasNext()) {
                        E[] access$300 = ArrayImmutableCollection.this.elements;
                        int i = this.f379i;
                        this.f379i = i + 1;
                        return access$300[i];
                    }
                    throw new NoSuchElementException();
                }
            };
        }
    }

    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            Object[] objArr = this.elements;
            return objArr.length == 0 ? ImmutableCollection.EMPTY_IMMUTABLE_COLLECTION : new ArrayImmutableCollection((Object[]) objArr.clone());
        }
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new SerializedForm(toArray());
    }
}
