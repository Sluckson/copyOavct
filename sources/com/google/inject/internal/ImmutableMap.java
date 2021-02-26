package com.google.inject.internal;

import com.google.inject.internal.ImmutableSet;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;

public abstract class ImmutableMap<K, V> implements ConcurrentMap<K, V>, Serializable {
    private static final ImmutableMap<?, ?> EMPTY_IMMUTABLE_MAP = new EmptyImmutableMap();

    public abstract boolean containsKey(@Nullable Object obj);

    public abstract boolean containsValue(@Nullable Object obj);

    public abstract ImmutableSet<Map.Entry<K, V>> entrySet();

    public abstract V get(@Nullable Object obj);

    public abstract ImmutableSet<K> keySet();

    public abstract ImmutableCollection<V> values();

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m342of() {
        return EMPTY_IMMUTABLE_MAP;
    }

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m343of(K k, V v) {
        return new SingletonImmutableMap(Preconditions.checkNotNull(k), Preconditions.checkNotNull(v));
    }

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m344of(K k, V v, K k2, V v2) {
        return new RegularImmutableMap(new Map.Entry[]{entryOf(k, v), entryOf(k2, v2)});
    }

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m345of(K k, V v, K k2, V v2, K k3, V v3) {
        return new RegularImmutableMap(new Map.Entry[]{entryOf(k, v), entryOf(k2, v2), entryOf(k3, v3)});
    }

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m346of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        return new RegularImmutableMap(new Map.Entry[]{entryOf(k, v), entryOf(k2, v2), entryOf(k3, v3), entryOf(k4, v4)});
    }

    /* renamed from: of */
    public static <K, V> ImmutableMap<K, V> m347of(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        return new RegularImmutableMap(new Map.Entry[]{entryOf(k, v), entryOf(k2, v2), entryOf(k3, v3), entryOf(k4, v4), entryOf(k5, v5)});
    }

    public static <K, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    /* access modifiers changed from: private */
    public static <K, V> Map.Entry<K, V> entryOf(K k, V v) {
        return Maps.immutableEntry(Preconditions.checkNotNull(k), Preconditions.checkNotNull(v));
    }

    public static class Builder<K, V> {
        final List<Map.Entry<K, V>> entries = Lists.newArrayList();

        public Builder<K, V> put(K k, V v) {
            this.entries.add(ImmutableMap.entryOf(k, v));
            return this;
        }

        public Builder<K, V> putAll(Map<? extends K, ? extends V> map) {
            for (Map.Entry next : map.entrySet()) {
                put(next.getKey(), next.getValue());
            }
            return this;
        }

        public ImmutableMap<K, V> build() {
            return fromEntryList(this.entries);
        }

        private static <K, V> ImmutableMap<K, V> fromEntryList(List<Map.Entry<K, V>> list) {
            int size = list.size();
            if (size == 0) {
                return ImmutableMap.m342of();
            }
            if (size != 1) {
                return new RegularImmutableMap((Map.Entry[]) list.toArray(new Map.Entry[list.size()]));
            }
            return new SingletonImmutableMap((Map.Entry) Iterables.getOnlyElement(list));
        }
    }

    public static <K, V> ImmutableMap<K, V> copyOf(Map<? extends K, ? extends V> map) {
        if (map instanceof ImmutableMap) {
            return (ImmutableMap) map;
        }
        int size = map.size();
        if (size == 0) {
            return m342of();
        }
        if (size != 1) {
            Map.Entry[] entryArr = new Map.Entry[size];
            int i = 0;
            for (Map.Entry next : map.entrySet()) {
                entryArr[i] = entryOf(next.getKey(), next.getValue());
                i++;
            }
            return new RegularImmutableMap(entryArr);
        }
        Map.Entry entry = (Map.Entry) Iterables.getOnlyElement(map.entrySet());
        return m343of(entry.getKey(), entry.getValue());
    }

    ImmutableMap() {
    }

    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final V putIfAbsent(K k, V v) {
        throw new UnsupportedOperationException();
    }

    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    public final boolean replace(K k, V v, V v2) {
        throw new UnsupportedOperationException();
    }

    public final V replace(K k, V v) {
        throw new UnsupportedOperationException();
    }

    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public int hashCode() {
        return entrySet().hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(size() * 16);
        sb.append('{');
        UnmodifiableIterator it = entrySet().iterator();
        sb.append(it.next());
        while (it.hasNext()) {
            sb.append(", ");
            sb.append(it.next());
        }
        sb.append('}');
        return sb.toString();
    }

    private static final class EmptyImmutableMap extends ImmutableMap<Object, Object> {
        public boolean containsKey(Object obj) {
            return false;
        }

        public boolean containsValue(Object obj) {
            return false;
        }

        public Object get(Object obj) {
            return null;
        }

        public int hashCode() {
            return 0;
        }

        public boolean isEmpty() {
            return true;
        }

        public int size() {
            return 0;
        }

        public String toString() {
            return "{}";
        }

        private EmptyImmutableMap() {
        }

        public ImmutableSet<Map.Entry<Object, Object>> entrySet() {
            return ImmutableSet.m348of();
        }

        public ImmutableSet<Object> keySet() {
            return ImmutableSet.m348of();
        }

        public ImmutableCollection<Object> values() {
            return ImmutableCollection.EMPTY_IMMUTABLE_COLLECTION;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj instanceof Map) {
                return ((Map) obj).isEmpty();
            }
            return false;
        }
    }

    private static final class SingletonImmutableMap<K, V> extends ImmutableMap<K, V> {
        private transient Map.Entry<K, V> entry;
        private transient ImmutableSet<Map.Entry<K, V>> entrySet;
        private transient ImmutableSet<K> keySet;
        private final transient K singleKey;
        private final transient V singleValue;
        private transient ImmutableCollection<V> values;

        public boolean isEmpty() {
            return false;
        }

        public int size() {
            return 1;
        }

        private SingletonImmutableMap(K k, V v) {
            this.singleKey = k;
            this.singleValue = v;
        }

        private SingletonImmutableMap(Map.Entry<K, V> entry2) {
            this.entry = entry2;
            this.singleKey = entry2.getKey();
            this.singleValue = entry2.getValue();
        }

        private Map.Entry<K, V> entry() {
            Map.Entry<K, V> entry2 = this.entry;
            if (entry2 != null) {
                return entry2;
            }
            Map.Entry<K, V> immutableEntry = Maps.immutableEntry(this.singleKey, this.singleValue);
            this.entry = immutableEntry;
            return immutableEntry;
        }

        public V get(Object obj) {
            if (this.singleKey.equals(obj)) {
                return this.singleValue;
            }
            return null;
        }

        public boolean containsKey(Object obj) {
            return this.singleKey.equals(obj);
        }

        public boolean containsValue(Object obj) {
            return this.singleValue.equals(obj);
        }

        public ImmutableSet<Map.Entry<K, V>> entrySet() {
            ImmutableSet<Map.Entry<K, V>> immutableSet = this.entrySet;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<Map.Entry<K, V>> of = ImmutableSet.m349of(entry());
            this.entrySet = of;
            return of;
        }

        public ImmutableSet<K> keySet() {
            ImmutableSet<K> immutableSet = this.keySet;
            if (immutableSet != null) {
                return immutableSet;
            }
            ImmutableSet<K> of = ImmutableSet.m349of(this.singleKey);
            this.keySet = of;
            return of;
        }

        public ImmutableCollection<V> values() {
            ImmutableCollection<V> immutableCollection = this.values;
            if (immutableCollection != null) {
                return immutableCollection;
            }
            Values values2 = new Values(this.singleValue);
            this.values = values2;
            return values2;
        }

        private static class Values<V> extends ImmutableCollection<V> {
            final V singleValue;

            public boolean isEmpty() {
                return false;
            }

            public int size() {
                return 1;
            }

            Values(V v) {
                this.singleValue = v;
            }

            public boolean contains(Object obj) {
                return this.singleValue.equals(obj);
            }

            public UnmodifiableIterator<V> iterator() {
                return Iterators.singletonIterator(this.singleValue);
            }
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map)) {
                return false;
            }
            Map map = (Map) obj;
            if (map.size() != 1) {
                return false;
            }
            Map.Entry entry2 = (Map.Entry) map.entrySet().iterator().next();
            if (!this.singleKey.equals(entry2.getKey()) || !this.singleValue.equals(entry2.getValue())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.singleKey.hashCode() ^ this.singleValue.hashCode();
        }

        public String toString() {
            return '{' + this.singleKey.toString() + '=' + this.singleValue.toString() + '}';
        }
    }

    private static final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
        /* access modifiers changed from: private */
        public final transient Map.Entry<K, V>[] entries;
        private transient ImmutableSet<Map.Entry<K, V>> entrySet;
        private transient ImmutableSet<K> keySet;
        /* access modifiers changed from: private */
        public final transient int keySetHashCode;
        private final transient int mask;
        private final transient Object[] table;
        private transient ImmutableCollection<V> values;

        public boolean isEmpty() {
            return false;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:5:0x0037, code lost:
            r3 = r3.getValue();
            r6 = r9.table;
            r6[r7] = r4;
            r6[r7 + 1] = r3;
            r2 = r2 + r5;
            r1 = r1 + 1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private RegularImmutableMap(java.util.Map.Entry<?, ?>... r10) {
            /*
                r9 = this;
                r9.<init>()
                r0 = r10
                java.util.Map$Entry[] r0 = (java.util.Map.Entry[]) r0
                r9.entries = r0
                int r10 = r10.length
                int r10 = com.google.inject.internal.Hashing.chooseTableSize(r10)
                int r0 = r10 * 2
                java.lang.Object[] r0 = new java.lang.Object[r0]
                r9.table = r0
                int r10 = r10 + -1
                r9.mask = r10
                java.util.Map$Entry<K, V>[] r10 = r9.entries
                int r0 = r10.length
                r1 = 0
                r2 = 0
            L_0x001c:
                if (r1 >= r0) goto L_0x0067
                r3 = r10[r1]
                java.lang.Object r4 = r3.getKey()
                int r5 = r4.hashCode()
                int r6 = com.google.inject.internal.Hashing.smear(r5)
            L_0x002c:
                int r7 = r9.mask
                r7 = r7 & r6
                int r7 = r7 * 2
                java.lang.Object[] r8 = r9.table
                r8 = r8[r7]
                if (r8 != 0) goto L_0x0047
                java.lang.Object r3 = r3.getValue()
                java.lang.Object[] r6 = r9.table
                r6[r7] = r4
                int r7 = r7 + 1
                r6[r7] = r3
                int r2 = r2 + r5
                int r1 = r1 + 1
                goto L_0x001c
            L_0x0047:
                boolean r7 = r8.equals(r4)
                if (r7 != 0) goto L_0x0050
                int r6 = r6 + 1
                goto L_0x002c
            L_0x0050:
                java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "duplicate key: "
                r0.append(r1)
                r0.append(r4)
                java.lang.String r0 = r0.toString()
                r10.<init>(r0)
                throw r10
            L_0x0067:
                r9.keySetHashCode = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.inject.internal.ImmutableMap.RegularImmutableMap.<init>(java.util.Map$Entry[]):void");
        }

        public V get(Object obj) {
            if (obj == null) {
                return null;
            }
            int smear = Hashing.smear(obj.hashCode());
            while (true) {
                int i = (this.mask & smear) * 2;
                Object obj2 = this.table[i];
                if (obj2 == null) {
                    return null;
                }
                if (obj2.equals(obj)) {
                    return this.table[i + 1];
                }
                smear++;
            }
        }

        public int size() {
            return this.entries.length;
        }

        public boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        public boolean containsValue(Object obj) {
            if (obj == null) {
                return false;
            }
            for (Map.Entry<K, V> value : this.entries) {
                if (value.getValue().equals(obj)) {
                    return true;
                }
            }
            return false;
        }

        public ImmutableSet<Map.Entry<K, V>> entrySet() {
            ImmutableSet<Map.Entry<K, V>> immutableSet = this.entrySet;
            if (immutableSet != null) {
                return immutableSet;
            }
            EntrySet entrySet2 = new EntrySet(this);
            this.entrySet = entrySet2;
            return entrySet2;
        }

        private static class EntrySet<K, V> extends ImmutableSet.ArrayImmutableSet<Map.Entry<K, V>> {
            final RegularImmutableMap<K, V> map;

            EntrySet(RegularImmutableMap<K, V> regularImmutableMap) {
                super(regularImmutableMap.entries);
                this.map = regularImmutableMap;
            }

            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                V v = this.map.get(entry.getKey());
                if (v == null || !v.equals(entry.getValue())) {
                    return false;
                }
                return true;
            }
        }

        public ImmutableSet<K> keySet() {
            ImmutableSet<K> immutableSet = this.keySet;
            if (immutableSet != null) {
                return immutableSet;
            }
            KeySet keySet2 = new KeySet(this);
            this.keySet = keySet2;
            return keySet2;
        }

        private static class KeySet<K, V> extends ImmutableSet.TransformedImmutableSet<Map.Entry<K, V>, K> {
            final RegularImmutableMap<K, V> map;

            KeySet(RegularImmutableMap<K, V> regularImmutableMap) {
                super(regularImmutableMap.entries, regularImmutableMap.keySetHashCode);
                this.map = regularImmutableMap;
            }

            /* access modifiers changed from: package-private */
            public K transform(Map.Entry<K, V> entry) {
                return entry.getKey();
            }

            public boolean contains(Object obj) {
                return this.map.containsKey(obj);
            }
        }

        public ImmutableCollection<V> values() {
            ImmutableCollection<V> immutableCollection = this.values;
            if (immutableCollection != null) {
                return immutableCollection;
            }
            Values values2 = new Values(this);
            this.values = values2;
            return values2;
        }

        private static class Values<V> extends ImmutableCollection<V> {
            final RegularImmutableMap<?, V> map;

            public boolean isEmpty() {
                return false;
            }

            Values(RegularImmutableMap<?, V> regularImmutableMap) {
                this.map = regularImmutableMap;
            }

            public int size() {
                return this.map.entries.length;
            }

            public UnmodifiableIterator<V> iterator() {
                return Iterators.unmodifiableIterator(new AbstractIterator<V>() {
                    int index = 0;

                    /* access modifiers changed from: protected */
                    public V computeNext() {
                        if (this.index >= Values.this.map.entries.length) {
                            return endOfData();
                        }
                        Map.Entry[] access$500 = Values.this.map.entries;
                        int i = this.index;
                        this.index = i + 1;
                        return access$500[i].getValue();
                    }
                });
            }

            public boolean contains(Object obj) {
                return this.map.containsValue(obj);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(size() * 16);
            sb.append('{');
            sb.append(this.entries[0]);
            for (int i = 1; i < this.entries.length; i++) {
                sb.append(", ");
                sb.append(this.entries[i].toString());
            }
            sb.append('}');
            return sb.toString();
        }
    }

    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] keys;
        final Object[] values;

        SerializedForm(ImmutableMap<?, ?> immutableMap) {
            this.keys = new Object[immutableMap.size()];
            this.values = new Object[immutableMap.size()];
            UnmodifiableIterator<Map.Entry<?, ?>> it = immutableMap.entrySet().iterator();
            int i = 0;
            while (it.hasNext()) {
                Map.Entry next = it.next();
                this.keys[i] = next.getKey();
                this.values[i] = next.getValue();
                i++;
            }
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            Builder builder = new Builder();
            int i = 0;
            while (true) {
                Object[] objArr = this.keys;
                if (i >= objArr.length) {
                    return builder.build();
                }
                builder.put(objArr[i], this.values[i]);
                i++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new SerializedForm(this);
    }
}
