package com.google.inject.internal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private static final ImmutableSet<?> EMPTY_IMMUTABLE_SET = new EmptyImmutableSet();

    /* access modifiers changed from: package-private */
    public boolean isHashCodeFast() {
        return false;
    }

    public abstract UnmodifiableIterator<E> iterator();

    /* renamed from: of */
    public static <E> ImmutableSet<E> m348of() {
        return EMPTY_IMMUTABLE_SET;
    }

    /* renamed from: of */
    public static <E> ImmutableSet<E> m349of(E e) {
        return new SingletonImmutableSet(e, e.hashCode());
    }

    /* renamed from: of */
    public static <E> ImmutableSet<E> m350of(E... eArr) {
        int length = eArr.length;
        if (length == 0) {
            return m348of();
        }
        if (length != 1) {
            return create(Arrays.asList(eArr), eArr.length);
        }
        return m349of(eArr[0]);
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableSet) {
            return (ImmutableSet) iterable;
        }
        return copyOfInternal(Collections2.toCollection(iterable));
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        return copyOfInternal(Lists.newArrayList(it));
    }

    private static <E> ImmutableSet<E> copyOfInternal(Collection<? extends E> collection) {
        int size = collection.size();
        if (size == 0) {
            return m348of();
        }
        if (size != 1) {
            return create(collection, collection.size());
        }
        return m349of(collection.iterator().next());
    }

    ImmutableSet() {
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableSet) || !isHashCodeFast() || !((ImmutableSet) obj).isHashCodeFast() || hashCode() == obj.hashCode()) {
            return Collections2.setEquals(this, obj);
        }
        return false;
    }

    public int hashCode() {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            i += it.next().hashCode();
        }
        return i;
    }

    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        UnmodifiableIterator it = iterator();
        StringBuilder sb = new StringBuilder(size() * 16);
        sb.append('[');
        sb.append(it.next().toString());
        for (int i = 1; i < size(); i++) {
            sb.append(", ");
            sb.append(it.next().toString());
        }
        sb.append(']');
        return sb.toString();
    }

    private static final class EmptyImmutableSet extends ImmutableSet<Object> {
        private static final Object[] EMPTY_ARRAY = new Object[0];

        public boolean contains(Object obj) {
            return false;
        }

        public final int hashCode() {
            return 0;
        }

        public boolean isEmpty() {
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean isHashCodeFast() {
            return true;
        }

        public int size() {
            return 0;
        }

        public String toString() {
            return "[]";
        }

        private EmptyImmutableSet() {
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

        public boolean containsAll(Collection<?> collection) {
            return collection.isEmpty();
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof Set) {
                return ((Set) obj).isEmpty();
            }
            return false;
        }
    }

    private static final class SingletonImmutableSet<E> extends ImmutableSet<E> {
        final E element;
        final int hashCode;

        public boolean isEmpty() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean isHashCodeFast() {
            return true;
        }

        public int size() {
            return 1;
        }

        SingletonImmutableSet(E e, int i) {
            this.element = e;
            this.hashCode = i;
        }

        public boolean contains(Object obj) {
            return this.element.equals(obj);
        }

        public UnmodifiableIterator<E> iterator() {
            return Iterators.singletonIterator(this.element);
        }

        public Object[] toArray() {
            return new Object[]{this.element};
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: T[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: T[]} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <T> T[] toArray(T[] r3) {
            /*
                r2 = this;
                int r0 = r3.length
                r1 = 1
                if (r0 != 0) goto L_0x0009
                java.lang.Object[] r3 = com.google.inject.internal.ObjectArrays.newArray(r3, r1)
                goto L_0x000f
            L_0x0009:
                int r0 = r3.length
                if (r0 <= r1) goto L_0x000f
                r0 = 0
                r3[r1] = r0
            L_0x000f:
                r0 = 0
                E r1 = r2.element
                r3[r0] = r1
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.inject.internal.ImmutableSet.SingletonImmutableSet.toArray(java.lang.Object[]):java.lang.Object[]");
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Set)) {
                return false;
            }
            Set set = (Set) obj;
            if (set.size() != 1 || !this.element.equals(set.iterator().next())) {
                return false;
            }
            return true;
        }

        public final int hashCode() {
            return this.hashCode;
        }

        public String toString() {
            String obj = this.element.toString();
            StringBuilder sb = new StringBuilder(obj.length() + 2);
            sb.append('[');
            sb.append(obj);
            sb.append(']');
            return sb.toString();
        }
    }

    private static <E> ImmutableSet<E> create(Iterable<? extends E> iterable, int i) {
        int chooseTableSize = Hashing.chooseTableSize(i);
        Object[] objArr = new Object[chooseTableSize];
        int i2 = chooseTableSize - 1;
        ArrayList arrayList = new ArrayList(i);
        int i3 = 0;
        for (Object next : iterable) {
            int hashCode = next.hashCode();
            int smear = Hashing.smear(hashCode);
            while (true) {
                int i4 = smear & i2;
                Object obj = objArr[i4];
                if (obj == null) {
                    objArr[i4] = next;
                    arrayList.add(next);
                    i3 += hashCode;
                    break;
                } else if (obj.equals(next)) {
                    break;
                } else {
                    smear++;
                }
            }
        }
        return arrayList.size() == 1 ? new SingletonImmutableSet(arrayList.get(0), i3) : new RegularImmutableSet(arrayList.toArray(), i3, objArr, i2);
    }

    static abstract class ArrayImmutableSet<E> extends ImmutableSet<E> {
        final Object[] elements;

        public boolean isEmpty() {
            return false;
        }

        ArrayImmutableSet(Object[] objArr) {
            this.elements = objArr;
        }

        public int size() {
            return this.elements.length;
        }

        public UnmodifiableIterator<E> iterator() {
            return Iterators.forArray(this.elements);
        }

        public Object[] toArray() {
            Object[] objArr = new Object[size()];
            System.arraycopy(this.elements, 0, objArr, 0, size());
            return objArr;
        }

        public <T> T[] toArray(T[] tArr) {
            int size = size();
            if (tArr.length < size) {
                tArr = ObjectArrays.newArray(tArr, size);
            } else if (tArr.length > size) {
                tArr[size] = null;
            }
            System.arraycopy(this.elements, 0, tArr, 0, size);
            return tArr;
        }

        public boolean containsAll(Collection<?> collection) {
            if (collection == this) {
                return true;
            }
            if (!(collection instanceof ArrayImmutableSet)) {
                return ImmutableSet.super.containsAll(collection);
            }
            if (collection.size() > size()) {
                return false;
            }
            for (Object contains : ((ArrayImmutableSet) collection).elements) {
                if (!contains(contains)) {
                    return false;
                }
            }
            return true;
        }
    }

    private static final class RegularImmutableSet<E> extends ArrayImmutableSet<E> {
        final int hashCode;
        final int mask;
        final Object[] table;

        /* access modifiers changed from: package-private */
        public boolean isHashCodeFast() {
            return true;
        }

        RegularImmutableSet(Object[] objArr, int i, Object[] objArr2, int i2) {
            super(objArr);
            this.table = objArr2;
            this.mask = i2;
            this.hashCode = i;
        }

        public boolean contains(Object obj) {
            if (obj == null) {
                return false;
            }
            int smear = Hashing.smear(obj.hashCode());
            while (true) {
                Object obj2 = this.table[this.mask & smear];
                if (obj2 == null) {
                    return false;
                }
                if (obj2.equals(obj)) {
                    return true;
                }
                smear++;
            }
        }

        public int hashCode() {
            return this.hashCode;
        }
    }

    static abstract class TransformedImmutableSet<D, E> extends ImmutableSet<E> {
        final int hashCode;
        final D[] source;

        public boolean isEmpty() {
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean isHashCodeFast() {
            return true;
        }

        /* access modifiers changed from: package-private */
        public abstract E transform(D d);

        TransformedImmutableSet(D[] dArr, int i) {
            this.source = dArr;
            this.hashCode = i;
        }

        public int size() {
            return this.source.length;
        }

        public UnmodifiableIterator<E> iterator() {
            return Iterators.unmodifiableIterator(new AbstractIterator<E>() {
                int index = 0;

                /* access modifiers changed from: protected */
                public E computeNext() {
                    if (this.index >= TransformedImmutableSet.this.source.length) {
                        return endOfData();
                    }
                    TransformedImmutableSet transformedImmutableSet = TransformedImmutableSet.this;
                    D[] dArr = transformedImmutableSet.source;
                    int i = this.index;
                    this.index = i + 1;
                    return transformedImmutableSet.transform(dArr[i]);
                }
            });
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
            while (true) {
                D[] dArr = this.source;
                if (i >= dArr.length) {
                    return tArr;
                }
                tArr[i] = transform(dArr[i]);
                i++;
            }
        }

        public final int hashCode() {
            return this.hashCode;
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
            return ImmutableSet.m350of((E[]) this.elements);
        }
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> Builder<E> builder() {
        return new Builder<>();
    }

    public static class Builder<E> {
        final ArrayList<E> contents = Lists.newArrayList();

        public Builder<E> add(E e) {
            Preconditions.checkNotNull(e, "element cannot be null");
            this.contents.add(e);
            return this;
        }

        public Builder<E> add(E... eArr) {
            Preconditions.checkNotNull(eArr, "elements cannot be null");
            List asList = Arrays.asList(eArr);
            Preconditions.checkContentsNotNull(asList, "elements cannot contain null");
            this.contents.addAll(asList);
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

        public Builder<E> addAll(Iterator<? extends E> it) {
            while (it.hasNext()) {
                Object next = it.next();
                Preconditions.checkNotNull(next, "element cannot be null");
                this.contents.add(next);
            }
            return this;
        }

        public ImmutableSet<E> build() {
            return ImmutableSet.copyOf(this.contents);
        }
    }
}
