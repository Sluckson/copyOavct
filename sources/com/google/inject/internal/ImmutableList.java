package com.google.inject.internal;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {
    private static final ImmutableList<?> EMPTY_IMMUTABLE_LIST = new EmptyImmutableList();

    public abstract int indexOf(@Nullable Object obj);

    public abstract UnmodifiableIterator<E> iterator();

    public abstract int lastIndexOf(@Nullable Object obj);

    public abstract ImmutableList<E> subList(int i, int i2);

    /* renamed from: of */
    public static <E> ImmutableList<E> m335of() {
        return EMPTY_IMMUTABLE_LIST;
    }

    /* renamed from: of */
    public static <E> ImmutableList<E> m336of(E e) {
        return new RegularImmutableList(copyIntoArray(e));
    }

    /* renamed from: of */
    public static <E> ImmutableList<E> m337of(E e, E e2) {
        return new RegularImmutableList(copyIntoArray(e, e2));
    }

    /* renamed from: of */
    public static <E> ImmutableList<E> m338of(E e, E e2, E e3) {
        return new RegularImmutableList(copyIntoArray(e, e2, e3));
    }

    /* renamed from: of */
    public static <E> ImmutableList<E> m339of(E e, E e2, E e3, E e4) {
        return new RegularImmutableList(copyIntoArray(e, e2, e3, e4));
    }

    /* renamed from: of */
    public static <E> ImmutableList<E> m340of(E e, E e2, E e3, E e4, E e5) {
        return new RegularImmutableList(copyIntoArray(e, e2, e3, e4, e5));
    }

    /* renamed from: of */
    public static <E> ImmutableList<E> m341of(E... eArr) {
        return eArr.length == 0 ? m335of() : new RegularImmutableList(copyIntoArray(eArr));
    }

    public static <E> ImmutableList<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableList) {
            return (ImmutableList) iterable;
        }
        if (iterable instanceof Collection) {
            return copyOfInternal((Collection) iterable);
        }
        return copyOfInternal(Lists.newArrayList(iterable));
    }

    public static <E> ImmutableList<E> copyOf(Iterator<? extends E> it) {
        return copyOfInternal(Lists.newArrayList(it));
    }

    private static <E> ImmutableList<E> copyOfInternal(ArrayList<? extends E> arrayList) {
        return arrayList.isEmpty() ? m335of() : new RegularImmutableList(nullChecked(arrayList.toArray()));
    }

    private static Object[] nullChecked(Object[] objArr) {
        int length = objArr.length;
        int i = 0;
        while (i < length) {
            if (objArr[i] != null) {
                i++;
            } else {
                throw new NullPointerException("at index " + i);
            }
        }
        return objArr;
    }

    private static <E> ImmutableList<E> copyOfInternal(Collection<? extends E> collection) {
        int size = collection.size();
        return size == 0 ? m335of() : createFromIterable(collection, size);
    }

    private ImmutableList() {
    }

    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    private static final class EmptyImmutableList extends ImmutableList<Object> {
        private static final Object[] EMPTY_ARRAY = new Object[0];

        public boolean contains(Object obj) {
            return false;
        }

        public int hashCode() {
            return 1;
        }

        public int indexOf(Object obj) {
            return -1;
        }

        public boolean isEmpty() {
            return true;
        }

        public int lastIndexOf(Object obj) {
            return -1;
        }

        public int size() {
            return 0;
        }

        public String toString() {
            return "[]";
        }

        private EmptyImmutableList() {
            super();
        }

        public UnmodifiableIterator<Object> iterator() {
            return Iterators.emptyIterator();
        }

        public Object[] toArray() {
            return EMPTY_ARRAY;
        }

        public <T> T[] toArray(T[] tArr) {
            if (tArr.length > 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        public Object get(int i) {
            Preconditions.checkElementIndex(i, 0);
            throw new AssertionError("unreachable");
        }

        public ImmutableList<Object> subList(int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, 0);
            return this;
        }

        public ListIterator<Object> listIterator() {
            return Iterators.emptyListIterator();
        }

        public ListIterator<Object> listIterator(int i) {
            Preconditions.checkPositionIndex(i, 0);
            return Iterators.emptyListIterator();
        }

        public boolean containsAll(Collection<?> collection) {
            return collection.isEmpty();
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof List) {
                return ((List) obj).isEmpty();
            }
            return false;
        }
    }

    private static final class RegularImmutableList<E> extends ImmutableList<E> {
        private final Object[] array;
        private final int offset;
        /* access modifiers changed from: private */
        public final int size;

        public boolean isEmpty() {
            return false;
        }

        private RegularImmutableList(Object[] objArr, int i, int i2) {
            super();
            this.offset = i;
            this.size = i2;
            this.array = objArr;
        }

        private RegularImmutableList(Object[] objArr) {
            this(objArr, 0, objArr.length);
        }

        public int size() {
            return this.size;
        }

        public boolean contains(Object obj) {
            return indexOf(obj) != -1;
        }

        public UnmodifiableIterator<E> iterator() {
            return Iterators.forArray(this.array, this.offset, this.size);
        }

        public Object[] toArray() {
            Object[] objArr = new Object[size()];
            System.arraycopy(this.array, this.offset, objArr, 0, this.size);
            return objArr;
        }

        public <T> T[] toArray(T[] tArr) {
            int length = tArr.length;
            int i = this.size;
            if (length < i) {
                tArr = ObjectArrays.newArray(tArr, i);
            } else if (tArr.length > i) {
                tArr[i] = null;
            }
            System.arraycopy(this.array, this.offset, tArr, 0, this.size);
            return tArr;
        }

        public E get(int i) {
            Preconditions.checkElementIndex(i, this.size);
            return this.array[i + this.offset];
        }

        public int indexOf(Object obj) {
            if (obj == null) {
                return -1;
            }
            for (int i = this.offset; i < this.offset + this.size; i++) {
                if (this.array[i].equals(obj)) {
                    return i - this.offset;
                }
            }
            return -1;
        }

        public int lastIndexOf(Object obj) {
            if (obj == null) {
                return -1;
            }
            int i = this.offset + this.size;
            while (true) {
                i--;
                if (i < this.offset) {
                    return -1;
                }
                if (this.array[i].equals(obj)) {
                    return i - this.offset;
                }
            }
        }

        public ImmutableList<E> subList(int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, this.size);
            return i == i2 ? ImmutableList.m335of() : new RegularImmutableList(this.array, this.offset + i, i2 - i);
        }

        public ListIterator<E> listIterator() {
            return listIterator(0);
        }

        public ListIterator<E> listIterator(final int i) {
            Preconditions.checkPositionIndex(i, this.size);
            return new ListIterator<E>() {
                int index = i;

                public boolean hasNext() {
                    return this.index < RegularImmutableList.this.size;
                }

                public boolean hasPrevious() {
                    return this.index > 0;
                }

                public int nextIndex() {
                    return this.index;
                }

                public int previousIndex() {
                    return this.index - 1;
                }

                public E next() {
                    try {
                        E e = RegularImmutableList.this.get(this.index);
                        this.index++;
                        return e;
                    } catch (IndexOutOfBoundsException unused) {
                        throw new NoSuchElementException();
                    }
                }

                public E previous() {
                    try {
                        this.index--;
                        return RegularImmutableList.this.get(this.index - 1);
                    } catch (IndexOutOfBoundsException unused) {
                        throw new NoSuchElementException();
                    }
                }

                public void set(E e) {
                    throw new UnsupportedOperationException();
                }

                public void add(E e) {
                    throw new UnsupportedOperationException();
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }
            };
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof List)) {
                return false;
            }
            List<Object> list = (List) obj;
            if (size() != list.size()) {
                return false;
            }
            int i = this.offset;
            if (obj instanceof RegularImmutableList) {
                RegularImmutableList regularImmutableList = (RegularImmutableList) obj;
                int i2 = regularImmutableList.offset;
                while (i2 < regularImmutableList.offset + regularImmutableList.size) {
                    int i3 = i + 1;
                    if (!this.array[i].equals(regularImmutableList.array[i2])) {
                        return false;
                    }
                    i2++;
                    i = i3;
                }
            } else {
                for (Object equals : list) {
                    int i4 = i + 1;
                    if (!this.array[i].equals(equals)) {
                        return false;
                    }
                    i = i4;
                }
            }
            return true;
        }

        public int hashCode() {
            int i = 1;
            for (int i2 = this.offset; i2 < this.offset + this.size; i2++) {
                i = (i * 31) + this.array[i2].hashCode();
            }
            return i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 16);
            sb.append('[');
            sb.append(this.array[this.offset]);
            int i = this.offset;
            while (true) {
                i++;
                if (i < this.offset + this.size) {
                    sb.append(", ");
                    sb.append(this.array[i]);
                } else {
                    sb.append(']');
                    return sb.toString();
                }
            }
        }
    }

    private static Object[] copyIntoArray(Object... objArr) {
        Object[] objArr2 = new Object[objArr.length];
        int length = objArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            Object obj = objArr[i];
            if (obj != null) {
                objArr2[i2] = obj;
                i++;
                i2++;
            } else {
                throw new NullPointerException("at index " + i2);
            }
        }
        return objArr2;
    }

    private static <E> ImmutableList<E> createFromIterable(Iterable<?> iterable, int i) {
        Object[] objArr = new Object[i];
        int i2 = i;
        int i3 = 0;
        for (Object next : iterable) {
            if (i3 == i2) {
                i2 = ((i2 / 2) + 1) * 3;
                objArr = copyOf(objArr, i2);
            }
            if (next != null) {
                objArr[i3] = next;
                i3++;
            } else {
                throw new NullPointerException("at index " + i3);
            }
        }
        if (i3 == 0) {
            return m335of();
        }
        if (i3 != i2) {
            objArr = copyOf(objArr, i3);
        }
        return new RegularImmutableList(objArr, 0, i3);
    }

    private static Object[] copyOf(Object[] objArr, int i) {
        Object[] objArr2 = new Object[i];
        System.arraycopy(objArr, 0, objArr2, 0, Math.min(objArr.length, i));
        return objArr2;
    }

    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            return ImmutableList.m341of((E[]) this.elements);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> Builder<E> builder() {
        return new Builder<>();
    }

    public static class Builder<E> {
        private final ArrayList<E> contents = Lists.newArrayList();

        public Builder<E> add(E e) {
            Preconditions.checkNotNull(e, "element cannot be null");
            this.contents.add(e);
            return this;
        }

        public Builder<E> addAll(Iterable<? extends E> iterable) {
            if (iterable instanceof Collection) {
                ArrayList<E> arrayList = this.contents;
                arrayList.ensureCapacity(arrayList.size() + ((Collection) iterable).size());
            }
            for (Object next : iterable) {
                Preconditions.checkNotNull(next, "elements contains a null");
                this.contents.add(next);
            }
            return this;
        }

        public ImmutableList<E> build() {
            return ImmutableList.copyOf(this.contents);
        }
    }
}
