package com.google.inject.internal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

final class CustomConcurrentHashMap {

    public interface ComputingStrategy<K, V, E> extends Strategy<K, V, E> {
        V compute(K k, E e, Function<? super K, ? extends V> function);

        V waitForValue(E e) throws InterruptedException;
    }

    public interface Internals<K, V, E> {
        E getEntry(K k);

        boolean removeEntry(E e);

        boolean removeEntry(E e, @Nullable V v);
    }

    public interface Strategy<K, V, E> {
        E copyEntry(K k, E e, E e2);

        boolean equalKeys(K k, Object obj);

        boolean equalValues(V v, Object obj);

        int getHash(E e);

        K getKey(E e);

        E getNext(E e);

        V getValue(E e);

        int hashKey(Object obj);

        E newEntry(K k, int i, E e);

        void setInternals(Internals<K, V, E> internals);

        void setValue(E e, V v);
    }

    /* access modifiers changed from: private */
    public static int rehash(int i) {
        int i2 = i + ((i << 15) ^ -12931);
        int i3 = i2 ^ (i2 >>> 10);
        int i4 = i3 + (i3 << 3);
        int i5 = i4 ^ (i4 >>> 6);
        int i6 = i5 + (i5 << 2) + (i5 << 14);
        return i6 ^ (i6 >>> 16);
    }

    private CustomConcurrentHashMap() {
    }

    static final class Builder {
        int concurrencyLevel = 16;
        int initialCapacity = 16;
        float loadFactor = 0.75f;

        Builder() {
        }

        public Builder loadFactor(float f) {
            if (f > 0.0f) {
                this.loadFactor = f;
                return this;
            }
            throw new IllegalArgumentException();
        }

        public Builder initialCapacity(int i) {
            if (i >= 0) {
                this.initialCapacity = i;
                return this;
            }
            throw new IllegalArgumentException();
        }

        public Builder concurrencyLevel(int i) {
            if (i > 0) {
                this.concurrencyLevel = i;
                return this;
            }
            throw new IllegalArgumentException();
        }

        public <K, V, E> ConcurrentMap<K, V> buildMap(Strategy<K, V, E> strategy) {
            if (strategy != null) {
                return new Impl(strategy, this);
            }
            throw new NullPointerException("strategy");
        }

        public <K, V, E> ConcurrentMap<K, V> buildComputingMap(ComputingStrategy<K, V, E> computingStrategy, Function<? super K, ? extends V> function) {
            if (computingStrategy == null) {
                throw new NullPointerException("strategy");
            } else if (function != null) {
                return new ComputingImpl(computingStrategy, this, function);
            } else {
                throw new NullPointerException("computer");
            }
        }
    }

    static class Impl<K, V, E> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {
        static final int MAXIMUM_CAPACITY = 1073741824;
        static final int MAX_SEGMENTS = 65536;
        static final int RETRIES_BEFORE_LOCK = 2;
        private static final long serialVersionUID = 0;
        Set<Map.Entry<K, V>> entrySet;
        Set<K> keySet;
        final float loadFactor;
        final int segmentMask;
        final int segmentShift;
        final Impl<K, V, E>.Segment[] segments;
        final Strategy<K, V, E> strategy;
        Collection<V> values;

        Impl(Strategy<K, V, E> strategy2, Builder builder) {
            this.loadFactor = builder.loadFactor;
            int i = builder.concurrencyLevel;
            int i2 = builder.initialCapacity;
            int i3 = 0;
            int i4 = 1;
            int i5 = 1;
            int i6 = 0;
            while (i5 < (i > 65536 ? 65536 : i)) {
                i6++;
                i5 <<= 1;
            }
            this.segmentShift = 32 - i6;
            this.segmentMask = i5 - 1;
            this.segments = newSegmentArray(i5);
            i2 = i2 > 1073741824 ? 1073741824 : i2;
            int i7 = i2 / i5;
            while (i4 < (i5 * i7 < i2 ? i7 + 1 : i7)) {
                i4 <<= 1;
            }
            while (true) {
                Impl<K, V, E>.Segment[] segmentArr = this.segments;
                if (i3 < segmentArr.length) {
                    segmentArr[i3] = new Segment(i4);
                    i3++;
                } else {
                    this.strategy = strategy2;
                    strategy2.setInternals(new InternalsImpl());
                    return;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int hash(Object obj) {
            return CustomConcurrentHashMap.rehash(this.strategy.hashKey(obj));
        }

        class InternalsImpl implements Internals<K, V, E>, Serializable {
            static final long serialVersionUID = 0;

            InternalsImpl() {
            }

            public E getEntry(K k) {
                if (k != null) {
                    int hash = Impl.this.hash(k);
                    return Impl.this.segmentFor(hash).getEntry(k, hash);
                }
                throw new NullPointerException("key");
            }

            public boolean removeEntry(E e, V v) {
                if (e != null) {
                    int hash = Impl.this.strategy.getHash(e);
                    return Impl.this.segmentFor(hash).removeEntry(e, hash, v);
                }
                throw new NullPointerException("entry");
            }

            public boolean removeEntry(E e) {
                if (e != null) {
                    int hash = Impl.this.strategy.getHash(e);
                    return Impl.this.segmentFor(hash).removeEntry(e, hash);
                }
                throw new NullPointerException("entry");
            }
        }

        /* access modifiers changed from: package-private */
        public Impl<K, V, E>.Segment[] newSegmentArray(int i) {
            return (Segment[]) Array.newInstance(Segment.class, i);
        }

        /* access modifiers changed from: package-private */
        public Impl<K, V, E>.Segment segmentFor(int i) {
            return this.segments[(i >>> this.segmentShift) & this.segmentMask];
        }

        final class Segment extends ReentrantLock {
            volatile int count;
            int modCount;
            volatile AtomicReferenceArray<E> table;
            int threshold;

            Segment(int i) {
                setTable(newEntryArray(i));
            }

            /* access modifiers changed from: package-private */
            public AtomicReferenceArray<E> newEntryArray(int i) {
                return new AtomicReferenceArray<>(i);
            }

            /* access modifiers changed from: package-private */
            public void setTable(AtomicReferenceArray<E> atomicReferenceArray) {
                this.threshold = (int) (((float) atomicReferenceArray.length()) * Impl.this.loadFactor);
                this.table = atomicReferenceArray;
            }

            /* access modifiers changed from: package-private */
            public E getFirst(int i) {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                return atomicReferenceArray.get(i & (atomicReferenceArray.length() - 1));
            }

            public E getEntry(Object obj, int i) {
                K key;
                Strategy<K, V, E> strategy = Impl.this.strategy;
                if (this.count == 0) {
                    return null;
                }
                for (E first = getFirst(i); first != null; first = strategy.getNext(first)) {
                    if (strategy.getHash(first) == i && (key = strategy.getKey(first)) != null && strategy.equalKeys(key, obj)) {
                        return first;
                    }
                }
                return null;
            }

            /* access modifiers changed from: package-private */
            public V get(Object obj, int i) {
                Object entry = getEntry(obj, i);
                if (entry == null) {
                    return null;
                }
                return Impl.this.strategy.getValue(entry);
            }

            /* access modifiers changed from: package-private */
            public boolean containsKey(Object obj, int i) {
                K key;
                Strategy<K, V, E> strategy = Impl.this.strategy;
                if (this.count != 0) {
                    E first = getFirst(i);
                    while (first != null) {
                        if (strategy.getHash(first) != i || (key = strategy.getKey(first)) == null || !strategy.equalKeys(key, obj)) {
                            first = strategy.getNext(first);
                        } else if (strategy.getValue(first) != null) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
                return false;
            }

            /* access modifiers changed from: package-private */
            public boolean containsValue(Object obj) {
                Strategy<K, V, E> strategy = Impl.this.strategy;
                if (this.count != 0) {
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    int length = atomicReferenceArray.length();
                    for (int i = 0; i < length; i++) {
                        for (E e = atomicReferenceArray.get(i); e != null; e = strategy.getNext(e)) {
                            V value = strategy.getValue(e);
                            if (value != null && strategy.equalValues(value, obj)) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }

            /* access modifiers changed from: package-private */
            public boolean replace(K k, int i, V v, V v2) {
                Strategy<K, V, E> strategy = Impl.this.strategy;
                lock();
                try {
                    for (E first = getFirst(i); first != null; first = strategy.getNext(first)) {
                        K key = strategy.getKey(first);
                        if (strategy.getHash(first) == i && key != null && strategy.equalKeys(k, key)) {
                            V value = strategy.getValue(first);
                            if (value == null) {
                                unlock();
                                return false;
                            } else if (strategy.equalValues(value, v)) {
                                strategy.setValue(first, v2);
                                return true;
                            }
                        }
                    }
                    unlock();
                    return false;
                } finally {
                    unlock();
                }
            }

            /* access modifiers changed from: package-private */
            public V replace(K k, int i, V v) {
                Strategy<K, V, E> strategy = Impl.this.strategy;
                lock();
                try {
                    E first = getFirst(i);
                    while (first != null) {
                        K key = strategy.getKey(first);
                        if (strategy.getHash(first) != i || key == null || !strategy.equalKeys(k, key)) {
                            first = strategy.getNext(first);
                        } else {
                            V value = strategy.getValue(first);
                            if (value == null) {
                                return null;
                            }
                            strategy.setValue(first, v);
                            unlock();
                            return value;
                        }
                    }
                    unlock();
                    return null;
                } finally {
                    unlock();
                }
            }

            /* access modifiers changed from: package-private */
            public V put(K k, int i, V v, boolean z) {
                Strategy<K, V, E> strategy = Impl.this.strategy;
                lock();
                int i2 = this.count;
                int i3 = i2 + 1;
                if (i2 > this.threshold) {
                    expand();
                }
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                E e2 = e;
                while (e2 != null) {
                    K key = strategy.getKey(e2);
                    if (strategy.getHash(e2) != i || key == null || !strategy.equalKeys(k, key)) {
                        try {
                            e2 = strategy.getNext(e2);
                        } catch (Throwable th) {
                            unlock();
                            throw th;
                        }
                    } else {
                        V value = strategy.getValue(e2);
                        if (!z || value == null) {
                            strategy.setValue(e2, v);
                            unlock();
                            return value;
                        }
                        unlock();
                        return value;
                    }
                }
                this.modCount++;
                E newEntry = strategy.newEntry(k, i, e);
                strategy.setValue(newEntry, v);
                atomicReferenceArray.set(length, newEntry);
                this.count = i3;
                unlock();
                return null;
            }

            /* access modifiers changed from: package-private */
            public void expand() {
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = atomicReferenceArray.length();
                if (length < 1073741824) {
                    Strategy<K, V, E> strategy = Impl.this.strategy;
                    AtomicReferenceArray<E> newEntryArray = newEntryArray(length << 1);
                    this.threshold = (int) (((float) newEntryArray.length()) * Impl.this.loadFactor);
                    int length2 = newEntryArray.length() - 1;
                    for (int i = 0; i < length; i++) {
                        E e = atomicReferenceArray.get(i);
                        if (e != null) {
                            E next = strategy.getNext(e);
                            int hash = strategy.getHash(e) & length2;
                            if (next == null) {
                                newEntryArray.set(hash, e);
                            } else {
                                E e2 = e;
                                while (next != null) {
                                    int hash2 = strategy.getHash(next) & length2;
                                    if (hash2 != hash) {
                                        e2 = next;
                                        hash = hash2;
                                    }
                                    next = strategy.getNext(next);
                                }
                                newEntryArray.set(hash, e2);
                                while (e != e2) {
                                    K key = strategy.getKey(e);
                                    if (key != null) {
                                        int hash3 = strategy.getHash(e) & length2;
                                        newEntryArray.set(hash3, strategy.copyEntry(key, e, newEntryArray.get(hash3)));
                                    }
                                    e = strategy.getNext(e);
                                }
                            }
                        }
                    }
                    this.table = newEntryArray;
                }
            }

            /* access modifiers changed from: package-private */
            public V remove(Object obj, int i) {
                Strategy<K, V, E> strategy = Impl.this.strategy;
                lock();
                try {
                    int i2 = this.count - 1;
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    int length = (atomicReferenceArray.length() - 1) & i;
                    E e = atomicReferenceArray.get(length);
                    E e2 = e;
                    while (e2 != null) {
                        K key = strategy.getKey(e2);
                        if (strategy.getHash(e2) != i || key == null || !strategy.equalKeys(key, obj)) {
                            e2 = strategy.getNext(e2);
                        } else {
                            V value = Impl.this.strategy.getValue(e2);
                            this.modCount++;
                            E next = strategy.getNext(e2);
                            while (e != e2) {
                                K key2 = strategy.getKey(e);
                                if (key2 != null) {
                                    next = strategy.copyEntry(key2, e, next);
                                }
                                e = strategy.getNext(e);
                            }
                            atomicReferenceArray.set(length, next);
                            this.count = i2;
                            return value;
                        }
                    }
                    unlock();
                    return null;
                } finally {
                    unlock();
                }
            }

            /* access modifiers changed from: package-private */
            public boolean remove(Object obj, int i, Object obj2) {
                Strategy<K, V, E> strategy = Impl.this.strategy;
                lock();
                int i2 = this.count - 1;
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e = atomicReferenceArray.get(length);
                E e2 = e;
                while (e2 != null) {
                    K key = strategy.getKey(e2);
                    if (strategy.getHash(e2) != i || key == null || !strategy.equalKeys(key, obj)) {
                        try {
                            e2 = strategy.getNext(e2);
                        } catch (Throwable th) {
                            unlock();
                            throw th;
                        }
                    } else {
                        V value = Impl.this.strategy.getValue(e2);
                        if (obj2 == value || !(obj2 == null || value == null || !strategy.equalValues(value, obj2))) {
                            this.modCount++;
                            E next = strategy.getNext(e2);
                            while (e != e2) {
                                K key2 = strategy.getKey(e);
                                if (key2 != null) {
                                    next = strategy.copyEntry(key2, e, next);
                                }
                                e = strategy.getNext(e);
                            }
                            atomicReferenceArray.set(length, next);
                            this.count = i2;
                            unlock();
                            return true;
                        }
                        unlock();
                        return false;
                    }
                }
                unlock();
                return false;
            }

            public boolean removeEntry(E e, int i, V v) {
                Strategy<K, V, E> strategy = Impl.this.strategy;
                lock();
                int i2 = this.count - 1;
                AtomicReferenceArray<E> atomicReferenceArray = this.table;
                int length = (atomicReferenceArray.length() - 1) & i;
                E e2 = atomicReferenceArray.get(length);
                E e3 = e2;
                while (e3 != null) {
                    if (strategy.getHash(e3) != i || !e.equals(e3)) {
                        try {
                            e3 = strategy.getNext(e3);
                        } catch (Throwable th) {
                            unlock();
                            throw th;
                        }
                    } else {
                        V value = strategy.getValue(e3);
                        if (value == v || (v != null && strategy.equalValues(value, v))) {
                            this.modCount++;
                            E next = strategy.getNext(e3);
                            while (e2 != e3) {
                                K key = strategy.getKey(e2);
                                if (key != null) {
                                    next = strategy.copyEntry(key, e2, next);
                                }
                                e2 = strategy.getNext(e2);
                            }
                            atomicReferenceArray.set(length, next);
                            this.count = i2;
                            unlock();
                            return true;
                        }
                        unlock();
                        return false;
                    }
                }
                unlock();
                return false;
            }

            public boolean removeEntry(E e, int i) {
                Strategy<K, V, E> strategy = Impl.this.strategy;
                lock();
                try {
                    int i2 = this.count - 1;
                    AtomicReferenceArray<E> atomicReferenceArray = this.table;
                    int length = (atomicReferenceArray.length() - 1) & i;
                    E e2 = atomicReferenceArray.get(length);
                    E e3 = e2;
                    while (e3 != null) {
                        if (strategy.getHash(e3) != i || !e.equals(e3)) {
                            e3 = strategy.getNext(e3);
                        } else {
                            this.modCount++;
                            E next = strategy.getNext(e3);
                            while (e2 != e3) {
                                K key = strategy.getKey(e2);
                                if (key != null) {
                                    next = strategy.copyEntry(key, e2, next);
                                }
                                e2 = strategy.getNext(e2);
                            }
                            atomicReferenceArray.set(length, next);
                            this.count = i2;
                            return true;
                        }
                    }
                    unlock();
                    return false;
                } finally {
                    unlock();
                }
            }

            /* access modifiers changed from: package-private */
            public void clear() {
                if (this.count != 0) {
                    lock();
                    try {
                        AtomicReferenceArray<E> atomicReferenceArray = this.table;
                        for (int i = 0; i < atomicReferenceArray.length(); i++) {
                            atomicReferenceArray.set(i, (Object) null);
                        }
                        this.modCount++;
                        this.count = 0;
                    } finally {
                        unlock();
                    }
                }
            }
        }

        public boolean isEmpty() {
            Impl<K, V, E>.Segment[] segmentArr = this.segments;
            int[] iArr = new int[segmentArr.length];
            int i = 0;
            for (int i2 = 0; i2 < segmentArr.length; i2++) {
                if (segmentArr[i2].count != 0) {
                    return false;
                }
                int i3 = segmentArr[i2].modCount;
                iArr[i2] = i3;
                i += i3;
            }
            if (i == 0) {
                return true;
            }
            for (int i4 = 0; i4 < segmentArr.length; i4++) {
                if (segmentArr[i4].count != 0 || iArr[i4] != segmentArr[i4].modCount) {
                    return false;
                }
            }
            return true;
        }

        public int size() {
            long j;
            long j2;
            Impl<K, V, E>.Segment[] segmentArr = this.segments;
            int[] iArr = new int[segmentArr.length];
            long j3 = 0;
            long j4 = 0;
            int i = 0;
            while (true) {
                if (i >= 2) {
                    long j5 = j3;
                    j = j4;
                    j2 = j5;
                    break;
                }
                j2 = 0;
                int i2 = 0;
                for (int i3 = 0; i3 < segmentArr.length; i3++) {
                    j2 += (long) segmentArr[i3].count;
                    int i4 = segmentArr[i3].modCount;
                    iArr[i3] = i4;
                    i2 += i4;
                }
                if (i2 != 0) {
                    long j6 = 0;
                    int i5 = 0;
                    while (true) {
                        if (i5 >= segmentArr.length) {
                            j = j6;
                            break;
                        }
                        j6 += (long) segmentArr[i5].count;
                        if (iArr[i5] != segmentArr[i5].modCount) {
                            j = -1;
                            break;
                        }
                        i5++;
                    }
                } else {
                    j = 0;
                }
                if (j == j2) {
                    break;
                }
                i++;
                long j7 = j;
                j3 = j2;
                j4 = j7;
            }
            if (j != j2) {
                for (Impl<K, V, E>.Segment lock : segmentArr) {
                    lock.lock();
                }
                long j8 = 0;
                for (Impl<K, V, E>.Segment segment : segmentArr) {
                    j8 = j2 + ((long) segment.count);
                }
                for (Impl<K, V, E>.Segment unlock : segmentArr) {
                    unlock.unlock();
                }
            }
            if (j2 > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            return (int) j2;
        }

        public V get(Object obj) {
            if (obj != null) {
                int hash = hash(obj);
                return segmentFor(hash).get(obj, hash);
            }
            throw new NullPointerException("key");
        }

        public boolean containsKey(Object obj) {
            if (obj != null) {
                int hash = hash(obj);
                return segmentFor(hash).containsKey(obj, hash);
            }
            throw new NullPointerException("key");
        }

        /* JADX INFO: finally extract failed */
        public boolean containsValue(Object obj) {
            if (obj != null) {
                Impl<K, V, E>.Segment[] segmentArr = this.segments;
                int[] iArr = new int[segmentArr.length];
                int i = 0;
                int i2 = 0;
                while (true) {
                    boolean z = true;
                    if (i2 < 2) {
                        int i3 = 0;
                        for (int i4 = 0; i4 < segmentArr.length; i4++) {
                            int i5 = segmentArr[i4].count;
                            int i6 = segmentArr[i4].modCount;
                            iArr[i4] = i6;
                            i3 += i6;
                            if (segmentArr[i4].containsValue(obj)) {
                                return true;
                            }
                        }
                        if (i3 != 0) {
                            int i7 = 0;
                            while (true) {
                                if (i7 >= segmentArr.length) {
                                    break;
                                }
                                int i8 = segmentArr[i7].count;
                                if (iArr[i7] != segmentArr[i7].modCount) {
                                    z = false;
                                    break;
                                }
                                i7++;
                            }
                        }
                        if (z) {
                            return false;
                        }
                        i2++;
                    } else {
                        for (Impl<K, V, E>.Segment lock : segmentArr) {
                            lock.lock();
                        }
                        try {
                            int length = segmentArr.length;
                            int i9 = 0;
                            while (true) {
                                if (i9 >= length) {
                                    z = false;
                                    break;
                                } else if (segmentArr[i9].containsValue(obj)) {
                                    break;
                                } else {
                                    i9++;
                                }
                            }
                            int length2 = segmentArr.length;
                            while (i < length2) {
                                segmentArr[i].unlock();
                                i++;
                            }
                            return z;
                        } catch (Throwable th) {
                            int length3 = segmentArr.length;
                            while (i < length3) {
                                segmentArr[i].unlock();
                                i++;
                            }
                            throw th;
                        }
                    }
                }
            } else {
                throw new NullPointerException("value");
            }
        }

        public V put(K k, V v) {
            if (k == null) {
                throw new NullPointerException("key");
            } else if (v != null) {
                int hash = hash(k);
                return segmentFor(hash).put(k, hash, v, false);
            } else {
                throw new NullPointerException("value");
            }
        }

        public V putIfAbsent(K k, V v) {
            if (k == null) {
                throw new NullPointerException("key");
            } else if (v != null) {
                int hash = hash(k);
                return segmentFor(hash).put(k, hash, v, true);
            } else {
                throw new NullPointerException("value");
            }
        }

        public void putAll(Map<? extends K, ? extends V> map) {
            for (Map.Entry next : map.entrySet()) {
                put(next.getKey(), next.getValue());
            }
        }

        public V remove(Object obj) {
            if (obj != null) {
                int hash = hash(obj);
                return segmentFor(hash).remove(obj, hash);
            }
            throw new NullPointerException("key");
        }

        public boolean remove(Object obj, Object obj2) {
            if (obj != null) {
                int hash = hash(obj);
                return segmentFor(hash).remove(obj, hash, obj2);
            }
            throw new NullPointerException("key");
        }

        public boolean replace(K k, V v, V v2) {
            if (k == null) {
                throw new NullPointerException("key");
            } else if (v == null) {
                throw new NullPointerException("oldValue");
            } else if (v2 != null) {
                int hash = hash(k);
                return segmentFor(hash).replace(k, hash, v, v2);
            } else {
                throw new NullPointerException("newValue");
            }
        }

        public V replace(K k, V v) {
            if (k == null) {
                throw new NullPointerException("key");
            } else if (v != null) {
                int hash = hash(k);
                return segmentFor(hash).replace(k, hash, v);
            } else {
                throw new NullPointerException("value");
            }
        }

        public void clear() {
            for (Impl<K, V, E>.Segment clear : this.segments) {
                clear.clear();
            }
        }

        public Set<K> keySet() {
            Set<K> set = this.keySet;
            if (set != null) {
                return set;
            }
            KeySet keySet2 = new KeySet();
            this.keySet = keySet2;
            return keySet2;
        }

        public Collection<V> values() {
            Collection<V> collection = this.values;
            if (collection != null) {
                return collection;
            }
            Values values2 = new Values();
            this.values = values2;
            return values2;
        }

        public Set<Map.Entry<K, V>> entrySet() {
            Set<Map.Entry<K, V>> set = this.entrySet;
            if (set != null) {
                return set;
            }
            EntrySet entrySet2 = new EntrySet();
            this.entrySet = entrySet2;
            return entrySet2;
        }

        abstract class HashIterator {
            AtomicReferenceArray<E> currentTable;
            Impl<K, V, E>.WriteThroughEntry lastReturned;
            E nextEntry;
            Impl<K, V, E>.WriteThroughEntry nextExternal;
            int nextSegmentIndex;
            int nextTableIndex = -1;

            HashIterator() {
                this.nextSegmentIndex = Impl.this.segments.length - 1;
                advance();
            }

            public boolean hasMoreElements() {
                return hasNext();
            }

            /* access modifiers changed from: package-private */
            public final void advance() {
                this.nextExternal = null;
                if (!nextInChain() && !nextInTable()) {
                    while (this.nextSegmentIndex >= 0) {
                        Impl<K, V, E>.Segment[] segmentArr = Impl.this.segments;
                        int i = this.nextSegmentIndex;
                        this.nextSegmentIndex = i - 1;
                        Impl<K, V, E>.Segment segment = segmentArr[i];
                        if (segment.count != 0) {
                            this.currentTable = segment.table;
                            this.nextTableIndex = this.currentTable.length() - 1;
                            if (nextInTable()) {
                                return;
                            }
                        }
                    }
                }
            }

            /* access modifiers changed from: package-private */
            public boolean nextInChain() {
                Strategy<K, V, E> strategy = Impl.this.strategy;
                E e = this.nextEntry;
                if (e == null) {
                    return false;
                }
                this.nextEntry = strategy.getNext(e);
                while (true) {
                    E e2 = this.nextEntry;
                    if (e2 == null) {
                        return false;
                    }
                    if (advanceTo(e2)) {
                        return true;
                    }
                    this.nextEntry = strategy.getNext(this.nextEntry);
                }
            }

            /* access modifiers changed from: package-private */
            public boolean nextInTable() {
                while (true) {
                    int i = this.nextTableIndex;
                    if (i < 0) {
                        return false;
                    }
                    AtomicReferenceArray<E> atomicReferenceArray = this.currentTable;
                    this.nextTableIndex = i - 1;
                    E e = atomicReferenceArray.get(i);
                    this.nextEntry = e;
                    if (e != null && (advanceTo(this.nextEntry) || nextInChain())) {
                        return true;
                    }
                }
            }

            /* access modifiers changed from: package-private */
            public boolean advanceTo(E e) {
                Strategy<K, V, E> strategy = Impl.this.strategy;
                K key = strategy.getKey(e);
                V value = strategy.getValue(e);
                if (key == null || value == null) {
                    return false;
                }
                this.nextExternal = new WriteThroughEntry(key, value);
                return true;
            }

            public boolean hasNext() {
                return this.nextExternal != null;
            }

            /* access modifiers changed from: package-private */
            public Impl<K, V, E>.WriteThroughEntry nextEntry() {
                Impl<K, V, E>.WriteThroughEntry writeThroughEntry = this.nextExternal;
                if (writeThroughEntry != null) {
                    this.lastReturned = writeThroughEntry;
                    advance();
                    return this.lastReturned;
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                Impl<K, V, E>.WriteThroughEntry writeThroughEntry = this.lastReturned;
                if (writeThroughEntry != null) {
                    Impl.this.remove(writeThroughEntry.getKey());
                    this.lastReturned = null;
                    return;
                }
                throw new IllegalStateException();
            }
        }

        final class KeyIterator extends Impl<K, V, E>.HashIterator implements Iterator<K> {
            KeyIterator() {
                super();
            }

            public K next() {
                return super.nextEntry().getKey();
            }
        }

        final class ValueIterator extends Impl<K, V, E>.HashIterator implements Iterator<V> {
            ValueIterator() {
                super();
            }

            public V next() {
                return super.nextEntry().getValue();
            }
        }

        final class WriteThroughEntry extends AbstractMapEntry<K, V> {
            final K key;
            V value;

            WriteThroughEntry(K k, V v) {
                this.key = k;
                this.value = v;
            }

            public K getKey() {
                return this.key;
            }

            public V getValue() {
                return this.value;
            }

            public V setValue(V v) {
                if (v != null) {
                    V put = Impl.this.put(getKey(), v);
                    this.value = v;
                    return put;
                }
                throw new NullPointerException();
            }
        }

        final class EntryIterator extends Impl<K, V, E>.HashIterator implements Iterator<Map.Entry<K, V>> {
            EntryIterator() {
                super();
            }

            public Map.Entry<K, V> next() {
                return nextEntry();
            }
        }

        final class KeySet extends AbstractSet<K> {
            KeySet() {
            }

            public Iterator<K> iterator() {
                return new KeyIterator();
            }

            public int size() {
                return Impl.this.size();
            }

            public boolean isEmpty() {
                return Impl.this.isEmpty();
            }

            public boolean contains(Object obj) {
                return Impl.this.containsKey(obj);
            }

            public boolean remove(Object obj) {
                return Impl.this.remove(obj) != null;
            }

            public void clear() {
                Impl.this.clear();
            }
        }

        final class Values extends AbstractCollection<V> {
            Values() {
            }

            public Iterator<V> iterator() {
                return new ValueIterator();
            }

            public int size() {
                return Impl.this.size();
            }

            public boolean isEmpty() {
                return Impl.this.isEmpty();
            }

            public boolean contains(Object obj) {
                return Impl.this.containsValue(obj);
            }

            public void clear() {
                Impl.this.clear();
            }
        }

        final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
            EntrySet() {
            }

            public Iterator<Map.Entry<K, V>> iterator() {
                return new EntryIterator();
            }

            /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
                r4 = (java.util.Map.Entry) r4;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean contains(java.lang.Object r4) {
                /*
                    r3 = this;
                    boolean r0 = r4 instanceof java.util.Map.Entry
                    r1 = 0
                    if (r0 != 0) goto L_0x0006
                    return r1
                L_0x0006:
                    java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                    java.lang.Object r0 = r4.getKey()
                    if (r0 != 0) goto L_0x000f
                    return r1
                L_0x000f:
                    com.google.inject.internal.CustomConcurrentHashMap$Impl r2 = com.google.inject.internal.CustomConcurrentHashMap.Impl.this
                    java.lang.Object r0 = r2.get(r0)
                    if (r0 == 0) goto L_0x0026
                    com.google.inject.internal.CustomConcurrentHashMap$Impl r2 = com.google.inject.internal.CustomConcurrentHashMap.Impl.this
                    com.google.inject.internal.CustomConcurrentHashMap$Strategy<K, V, E> r2 = r2.strategy
                    java.lang.Object r4 = r4.getValue()
                    boolean r4 = r2.equalValues(r0, r4)
                    if (r4 == 0) goto L_0x0026
                    r1 = 1
                L_0x0026:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.inject.internal.CustomConcurrentHashMap.Impl.EntrySet.contains(java.lang.Object):boolean");
            }

            /* JADX WARNING: Code restructure failed: missing block: B:3:0x0006, code lost:
                r4 = (java.util.Map.Entry) r4;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean remove(java.lang.Object r4) {
                /*
                    r3 = this;
                    boolean r0 = r4 instanceof java.util.Map.Entry
                    r1 = 0
                    if (r0 != 0) goto L_0x0006
                    return r1
                L_0x0006:
                    java.util.Map$Entry r4 = (java.util.Map.Entry) r4
                    java.lang.Object r0 = r4.getKey()
                    if (r0 == 0) goto L_0x001b
                    com.google.inject.internal.CustomConcurrentHashMap$Impl r2 = com.google.inject.internal.CustomConcurrentHashMap.Impl.this
                    java.lang.Object r4 = r4.getValue()
                    boolean r4 = r2.remove(r0, r4)
                    if (r4 == 0) goto L_0x001b
                    r1 = 1
                L_0x001b:
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.inject.internal.CustomConcurrentHashMap.Impl.EntrySet.remove(java.lang.Object):boolean");
            }

            public int size() {
                return Impl.this.size();
            }

            public boolean isEmpty() {
                return Impl.this.isEmpty();
            }

            public void clear() {
                Impl.this.clear();
            }
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeInt(size());
            objectOutputStream.writeFloat(this.loadFactor);
            objectOutputStream.writeInt(this.segments.length);
            objectOutputStream.writeObject(this.strategy);
            for (Map.Entry entry : entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject((Object) null);
        }

        static class Fields {
            static final Field loadFactor = findField("loadFactor");
            static final Field segmentMask = findField("segmentMask");
            static final Field segmentShift = findField("segmentShift");
            static final Field segments = findField("segments");
            static final Field strategy = findField("strategy");

            Fields() {
            }

            static Field findField(String str) {
                try {
                    Field declaredField = Impl.class.getDeclaredField(str);
                    declaredField.setAccessible(true);
                    return declaredField;
                } catch (NoSuchFieldException e) {
                    throw new AssertionError(e);
                }
            }
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            try {
                int readInt = objectInputStream.readInt();
                float readFloat = objectInputStream.readFloat();
                int readInt2 = objectInputStream.readInt();
                Strategy strategy2 = (Strategy) objectInputStream.readObject();
                Fields.loadFactor.set(this, Float.valueOf(readFloat));
                int i = 65536;
                if (readInt2 <= 65536) {
                    i = readInt2;
                }
                int i2 = 1;
                int i3 = 1;
                int i4 = 0;
                while (i3 < i) {
                    i4++;
                    i3 <<= 1;
                }
                Fields.segmentShift.set(this, Integer.valueOf(32 - i4));
                Fields.segmentMask.set(this, Integer.valueOf(i3 - 1));
                Fields.segments.set(this, newSegmentArray(i3));
                if (readInt > 1073741824) {
                    readInt = 1073741824;
                }
                int i5 = readInt / i3;
                if (i3 * i5 < readInt) {
                    i5++;
                }
                while (i2 < i5) {
                    i2 <<= 1;
                }
                for (int i6 = 0; i6 < this.segments.length; i6++) {
                    this.segments[i6] = new Segment(i2);
                }
                Fields.strategy.set(this, strategy2);
                while (true) {
                    Object readObject = objectInputStream.readObject();
                    if (readObject != null) {
                        put(readObject, objectInputStream.readObject());
                    } else {
                        return;
                    }
                }
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    static class ComputingImpl<K, V, E> extends Impl<K, V, E> {
        static final long serialVersionUID = 0;
        final Function<? super K, ? extends V> computer;
        final ComputingStrategy<K, V, E> computingStrategy;

        ComputingImpl(ComputingStrategy<K, V, E> computingStrategy2, Builder builder, Function<? super K, ? extends V> function) {
            super(computingStrategy2, builder);
            this.computingStrategy = computingStrategy2;
            this.computer = function;
        }

        public V get(Object obj) {
            V waitForValue;
            E e;
            boolean z;
            if (obj != null) {
                int hash = hash(obj);
                Impl<K, V, E>.Segment segmentFor = segmentFor(hash);
                while (true) {
                    E entry = segmentFor.getEntry(obj, hash);
                    boolean z2 = false;
                    if (entry == null) {
                        segmentFor.lock();
                        try {
                            E entry2 = segmentFor.getEntry(obj, hash);
                            if (entry2 == null) {
                                int i = segmentFor.count;
                                int i2 = i + 1;
                                if (i > segmentFor.threshold) {
                                    segmentFor.expand();
                                }
                                AtomicReferenceArray<E> atomicReferenceArray = segmentFor.table;
                                int length = (atomicReferenceArray.length() - 1) & hash;
                                E e2 = atomicReferenceArray.get(length);
                                segmentFor.modCount++;
                                e = this.computingStrategy.newEntry(obj, hash, e2);
                                atomicReferenceArray.set(length, e);
                                segmentFor.count = i2;
                                z = true;
                            } else {
                                e = entry2;
                                z = false;
                            }
                            if (z) {
                                try {
                                    V compute = this.computingStrategy.compute(obj, e, this.computer);
                                    if (compute != null) {
                                        return compute;
                                    }
                                    throw new NullPointerException("compute() returned null unexpectedly");
                                } catch (Throwable th) {
                                    segmentFor.removeEntry(e, hash);
                                    throw th;
                                }
                            } else {
                                entry = e;
                            }
                        } finally {
                            segmentFor.unlock();
                        }
                    }
                    while (true) {
                        try {
                            waitForValue = this.computingStrategy.waitForValue(entry);
                            break;
                        } catch (InterruptedException unused) {
                            z2 = true;
                        } catch (Throwable th2) {
                            if (z2) {
                                Thread.currentThread().interrupt();
                            }
                            throw th2;
                        }
                    }
                    if (waitForValue == null) {
                        segmentFor.removeEntry(entry, hash);
                        if (z2) {
                            Thread.currentThread().interrupt();
                        }
                    } else {
                        if (z2) {
                            Thread.currentThread().interrupt();
                        }
                        return waitForValue;
                    }
                }
            } else {
                throw new NullPointerException("key");
            }
        }
    }

    static class SimpleStrategy<K, V> implements Strategy<K, V, SimpleInternalEntry<K, V>> {
        public void setInternals(Internals<K, V, SimpleInternalEntry<K, V>> internals) {
        }

        SimpleStrategy() {
        }

        public SimpleInternalEntry<K, V> newEntry(K k, int i, SimpleInternalEntry<K, V> simpleInternalEntry) {
            return new SimpleInternalEntry<>(k, i, null, simpleInternalEntry);
        }

        public SimpleInternalEntry<K, V> copyEntry(K k, SimpleInternalEntry<K, V> simpleInternalEntry, SimpleInternalEntry<K, V> simpleInternalEntry2) {
            return new SimpleInternalEntry<>(k, simpleInternalEntry.hash, simpleInternalEntry.value, simpleInternalEntry2);
        }

        public void setValue(SimpleInternalEntry<K, V> simpleInternalEntry, V v) {
            simpleInternalEntry.value = v;
        }

        public V getValue(SimpleInternalEntry<K, V> simpleInternalEntry) {
            return simpleInternalEntry.value;
        }

        public boolean equalKeys(K k, Object obj) {
            return k.equals(obj);
        }

        public boolean equalValues(V v, Object obj) {
            return v.equals(obj);
        }

        public int hashKey(Object obj) {
            return obj.hashCode();
        }

        public K getKey(SimpleInternalEntry<K, V> simpleInternalEntry) {
            return simpleInternalEntry.key;
        }

        public SimpleInternalEntry<K, V> getNext(SimpleInternalEntry<K, V> simpleInternalEntry) {
            return simpleInternalEntry.next;
        }

        public int getHash(SimpleInternalEntry<K, V> simpleInternalEntry) {
            return simpleInternalEntry.hash;
        }
    }

    static class SimpleInternalEntry<K, V> {
        final int hash;
        final K key;
        final SimpleInternalEntry<K, V> next;
        volatile V value;

        SimpleInternalEntry(K k, int i, @Nullable V v, SimpleInternalEntry<K, V> simpleInternalEntry) {
            this.key = k;
            this.hash = i;
            this.value = v;
            this.next = simpleInternalEntry;
        }
    }
}
