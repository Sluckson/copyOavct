package com.google.inject.internal;

import com.google.inject.internal.CustomConcurrentHashMap;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

public final class MapMaker {
    /* access modifiers changed from: private */
    public static final ValueReference<Object, Object> COMPUTING = new ValueReference<Object, Object>() {
        public Object get() {
            return null;
        }

        public ValueReference<Object, Object> copyFor(ReferenceEntry<Object, Object> referenceEntry) {
            throw new AssertionError();
        }

        public Object waitForValue() {
            throw new AssertionError();
        }
    };
    /* access modifiers changed from: private */
    public final CustomConcurrentHashMap.Builder builder = new CustomConcurrentHashMap.Builder();
    /* access modifiers changed from: private */
    public long expirationNanos = 0;
    /* access modifiers changed from: private */
    public Strength keyStrength = Strength.STRONG;
    private boolean useCustomMap;
    /* access modifiers changed from: private */
    public Strength valueStrength = Strength.STRONG;

    private interface ReferenceEntry<K, V> {
        int getHash();

        K getKey();

        ReferenceEntry<K, V> getNext();

        ValueReference<K, V> getValueReference();

        void setValueReference(ValueReference<K, V> valueReference);

        void valueReclaimed();
    }

    private enum Strength {
        WEAK {
            /* access modifiers changed from: package-private */
            public boolean equal(Object obj, Object obj2) {
                return obj == obj2;
            }

            /* access modifiers changed from: package-private */
            public int hash(Object obj) {
                return System.identityHashCode(obj);
            }

            /* access modifiers changed from: package-private */
            public <K, V> ValueReference<K, V> referenceValue(ReferenceEntry<K, V> referenceEntry, V v) {
                return new WeakValueReference(v, referenceEntry);
            }

            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> newEntry(CustomConcurrentHashMap.Internals<K, V, ReferenceEntry<K, V>> internals, K k, int i, ReferenceEntry<K, V> referenceEntry) {
                return referenceEntry == null ? new WeakEntry(internals, k, i) : new LinkedWeakEntry(internals, k, i, referenceEntry);
            }

            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> copyEntry(K k, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                WeakEntry weakEntry = (WeakEntry) referenceEntry;
                return referenceEntry2 == null ? new WeakEntry(weakEntry.internals, k, weakEntry.hash) : new LinkedWeakEntry(weakEntry.internals, k, weakEntry.hash, referenceEntry2);
            }
        },
        SOFT {
            /* access modifiers changed from: package-private */
            public boolean equal(Object obj, Object obj2) {
                return obj == obj2;
            }

            /* access modifiers changed from: package-private */
            public int hash(Object obj) {
                return System.identityHashCode(obj);
            }

            /* access modifiers changed from: package-private */
            public <K, V> ValueReference<K, V> referenceValue(ReferenceEntry<K, V> referenceEntry, V v) {
                return new SoftValueReference(v, referenceEntry);
            }

            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> newEntry(CustomConcurrentHashMap.Internals<K, V, ReferenceEntry<K, V>> internals, K k, int i, ReferenceEntry<K, V> referenceEntry) {
                return referenceEntry == null ? new SoftEntry(internals, k, i) : new LinkedSoftEntry(internals, k, i, referenceEntry);
            }

            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> copyEntry(K k, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                SoftEntry softEntry = (SoftEntry) referenceEntry;
                return referenceEntry2 == null ? new SoftEntry(softEntry.internals, k, softEntry.hash) : new LinkedSoftEntry(softEntry.internals, k, softEntry.hash, referenceEntry2);
            }
        },
        STRONG {
            /* access modifiers changed from: package-private */
            public boolean equal(Object obj, Object obj2) {
                return obj.equals(obj2);
            }

            /* access modifiers changed from: package-private */
            public int hash(Object obj) {
                return obj.hashCode();
            }

            /* access modifiers changed from: package-private */
            public <K, V> ValueReference<K, V> referenceValue(ReferenceEntry<K, V> referenceEntry, V v) {
                return new StrongValueReference(v);
            }

            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> newEntry(CustomConcurrentHashMap.Internals<K, V, ReferenceEntry<K, V>> internals, K k, int i, ReferenceEntry<K, V> referenceEntry) {
                return referenceEntry == null ? new StrongEntry(internals, k, i) : new LinkedStrongEntry(internals, k, i, referenceEntry);
            }

            /* access modifiers changed from: package-private */
            public <K, V> ReferenceEntry<K, V> copyEntry(K k, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                StrongEntry strongEntry = (StrongEntry) referenceEntry;
                return referenceEntry2 == null ? new StrongEntry(strongEntry.internals, k, strongEntry.hash) : new LinkedStrongEntry(strongEntry.internals, k, strongEntry.hash, referenceEntry2);
            }
        };

        /* access modifiers changed from: package-private */
        public abstract <K, V> ReferenceEntry<K, V> copyEntry(K k, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2);

        /* access modifiers changed from: package-private */
        public abstract boolean equal(Object obj, Object obj2);

        /* access modifiers changed from: package-private */
        public abstract int hash(Object obj);

        /* access modifiers changed from: package-private */
        public abstract <K, V> ReferenceEntry<K, V> newEntry(CustomConcurrentHashMap.Internals<K, V, ReferenceEntry<K, V>> internals, K k, int i, ReferenceEntry<K, V> referenceEntry);

        /* access modifiers changed from: package-private */
        public abstract <K, V> ValueReference<K, V> referenceValue(ReferenceEntry<K, V> referenceEntry, V v);
    }

    private interface ValueReference<K, V> {
        ValueReference<K, V> copyFor(ReferenceEntry<K, V> referenceEntry);

        V get();

        V waitForValue() throws InterruptedException;
    }

    public MapMaker initialCapacity(int i) {
        this.builder.initialCapacity(i);
        return this;
    }

    public MapMaker loadFactor(float f) {
        this.builder.loadFactor(f);
        return this;
    }

    public MapMaker concurrencyLevel(int i) {
        this.builder.concurrencyLevel(i);
        return this;
    }

    public MapMaker weakKeys() {
        return setKeyStrength(Strength.WEAK);
    }

    public MapMaker softKeys() {
        return setKeyStrength(Strength.SOFT);
    }

    private MapMaker setKeyStrength(Strength strength) {
        if (this.keyStrength == Strength.STRONG) {
            this.keyStrength = strength;
            this.useCustomMap = true;
            return this;
        }
        throw new IllegalStateException("Key strength was already set to " + this.keyStrength + ".");
    }

    public MapMaker weakValues() {
        return setValueStrength(Strength.WEAK);
    }

    public MapMaker softValues() {
        return setValueStrength(Strength.SOFT);
    }

    private MapMaker setValueStrength(Strength strength) {
        if (this.valueStrength == Strength.STRONG) {
            this.valueStrength = strength;
            this.useCustomMap = true;
            return this;
        }
        throw new IllegalStateException("Value strength was already set to " + this.valueStrength + ".");
    }

    public MapMaker expiration(long j, TimeUnit timeUnit) {
        if (this.expirationNanos != 0) {
            throw new IllegalStateException("expiration time of " + this.expirationNanos + " ns was already set");
        } else if (j > 0) {
            this.expirationNanos = timeUnit.toNanos(j);
            this.useCustomMap = true;
            return this;
        } else {
            throw new IllegalArgumentException("invalid duration: " + j);
        }
    }

    public <K, V> ConcurrentMap<K, V> makeMap() {
        return this.useCustomMap ? new StrategyImpl(this).map : new ConcurrentHashMap(this.builder.initialCapacity, this.builder.loadFactor, this.builder.concurrencyLevel);
    }

    public <K, V> ConcurrentMap<K, V> makeComputingMap(Function<? super K, ? extends V> function) {
        return new StrategyImpl(this, function).map;
    }

    private static class StrategyImpl<K, V> implements Serializable, CustomConcurrentHashMap.ComputingStrategy<K, V, ReferenceEntry<K, V>> {
        private static final long serialVersionUID = 0;
        final long expirationNanos;
        CustomConcurrentHashMap.Internals<K, V, ReferenceEntry<K, V>> internals;
        final Strength keyStrength;
        final ConcurrentMap<K, V> map;
        final Strength valueStrength;

        StrategyImpl(MapMaker mapMaker) {
            this.keyStrength = mapMaker.keyStrength;
            this.valueStrength = mapMaker.valueStrength;
            this.expirationNanos = mapMaker.expirationNanos;
            this.map = mapMaker.builder.buildMap(this);
        }

        StrategyImpl(MapMaker mapMaker, Function<? super K, ? extends V> function) {
            this.keyStrength = mapMaker.keyStrength;
            this.valueStrength = mapMaker.valueStrength;
            this.expirationNanos = mapMaker.expirationNanos;
            this.map = mapMaker.builder.buildComputingMap(this, function);
        }

        public void setValue(ReferenceEntry<K, V> referenceEntry, V v) {
            setValueReference(referenceEntry, this.valueStrength.referenceValue(referenceEntry, v));
            if (this.expirationNanos > 0) {
                scheduleRemoval(referenceEntry.getKey(), v);
            }
        }

        /* access modifiers changed from: package-private */
        public void scheduleRemoval(K k, V v) {
            final WeakReference weakReference = new WeakReference(k);
            final WeakReference weakReference2 = new WeakReference(v);
            ExpirationTimer.instance.schedule(new TimerTask() {
                public void run() {
                    Object obj = weakReference.get();
                    if (obj != null) {
                        StrategyImpl.this.map.remove(obj, weakReference2.get());
                    }
                }
            }, TimeUnit.NANOSECONDS.toMillis(this.expirationNanos));
        }

        public boolean equalKeys(K k, Object obj) {
            return this.keyStrength.equal(k, obj);
        }

        public boolean equalValues(V v, Object obj) {
            return this.valueStrength.equal(v, obj);
        }

        public int hashKey(Object obj) {
            return this.keyStrength.hash(obj);
        }

        public K getKey(ReferenceEntry<K, V> referenceEntry) {
            return referenceEntry.getKey();
        }

        public int getHash(ReferenceEntry referenceEntry) {
            return referenceEntry.getHash();
        }

        public ReferenceEntry<K, V> newEntry(K k, int i, ReferenceEntry<K, V> referenceEntry) {
            return this.keyStrength.newEntry(this.internals, k, i, referenceEntry);
        }

        public ReferenceEntry<K, V> copyEntry(K k, ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
            ValueReference<K, V> valueReference = referenceEntry.getValueReference();
            if (valueReference == MapMaker.COMPUTING) {
                ReferenceEntry<K, V> newEntry = newEntry(k, referenceEntry.getHash(), referenceEntry2);
                newEntry.setValueReference(new FutureValueReference(referenceEntry, newEntry));
                return newEntry;
            }
            ReferenceEntry<K, V> newEntry2 = newEntry(k, referenceEntry.getHash(), referenceEntry2);
            newEntry2.setValueReference(valueReference.copyFor(newEntry2));
            return newEntry2;
        }

        public V waitForValue(ReferenceEntry<K, V> referenceEntry) throws InterruptedException {
            ValueReference<K, V> valueReference = referenceEntry.getValueReference();
            if (valueReference == MapMaker.COMPUTING) {
                synchronized (referenceEntry) {
                    while (true) {
                        valueReference = referenceEntry.getValueReference();
                        if (valueReference == MapMaker.COMPUTING) {
                            referenceEntry.wait();
                        }
                    }
                }
                break;
            }
            return valueReference.waitForValue();
        }

        public V getValue(ReferenceEntry<K, V> referenceEntry) {
            return referenceEntry.getValueReference().get();
        }

        public V compute(K k, ReferenceEntry<K, V> referenceEntry, Function<? super K, ? extends V> function) {
            try {
                V apply = function.apply(k);
                if (apply != null) {
                    setValue(referenceEntry, apply);
                    return apply;
                }
                String str = function + " returned null for key " + k + ".";
                setValueReference(referenceEntry, new NullOutputExceptionReference(str));
                throw new NullOutputException(str);
            } catch (Throwable th) {
                setValueReference(referenceEntry, new ComputationExceptionReference(th));
                throw new ComputationException(th);
            }
        }

        /* access modifiers changed from: package-private */
        public void setValueReference(ReferenceEntry<K, V> referenceEntry, ValueReference<K, V> valueReference) {
            boolean z = referenceEntry.getValueReference() == MapMaker.COMPUTING;
            referenceEntry.setValueReference(valueReference);
            if (z) {
                synchronized (referenceEntry) {
                    referenceEntry.notifyAll();
                }
            }
        }

        private class FutureValueReference implements ValueReference<K, V> {
            final ReferenceEntry<K, V> newEntry;
            final ReferenceEntry<K, V> original;

            FutureValueReference(ReferenceEntry<K, V> referenceEntry, ReferenceEntry<K, V> referenceEntry2) {
                this.original = referenceEntry;
                this.newEntry = referenceEntry2;
            }

            public V get() {
                try {
                    return this.original.getValueReference().get();
                } catch (Throwable th) {
                    removeEntry();
                    throw th;
                }
            }

            public ValueReference<K, V> copyFor(ReferenceEntry<K, V> referenceEntry) {
                return new FutureValueReference(this.original, referenceEntry);
            }

            public V waitForValue() throws InterruptedException {
                try {
                    return StrategyImpl.this.waitForValue(this.original);
                } catch (Throwable th) {
                    removeEntry();
                    throw th;
                }
            }

            /* access modifiers changed from: package-private */
            public void removeEntry() {
                StrategyImpl.this.internals.removeEntry(this.newEntry);
            }
        }

        public ReferenceEntry<K, V> getNext(ReferenceEntry<K, V> referenceEntry) {
            return referenceEntry.getNext();
        }

        public void setInternals(CustomConcurrentHashMap.Internals<K, V, ReferenceEntry<K, V>> internals2) {
            this.internals = internals2;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.keyStrength);
            objectOutputStream.writeObject(this.valueStrength);
            objectOutputStream.writeLong(this.expirationNanos);
            objectOutputStream.writeObject(this.internals);
            objectOutputStream.writeObject(this.map);
        }

        private static class Fields {
            static final Field expirationNanos = findField("expirationNanos");
            static final Field internals = findField("internals");
            static final Field keyStrength = findField("keyStrength");
            static final Field map = findField("map");
            static final Field valueStrength = findField("valueStrength");

            private Fields() {
            }

            static Field findField(String str) {
                try {
                    Field declaredField = StrategyImpl.class.getDeclaredField(str);
                    declaredField.setAccessible(true);
                    return declaredField;
                } catch (NoSuchFieldException e) {
                    throw new AssertionError(e);
                }
            }
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            try {
                Fields.keyStrength.set(this, objectInputStream.readObject());
                Fields.valueStrength.set(this, objectInputStream.readObject());
                Fields.expirationNanos.set(this, Long.valueOf(objectInputStream.readLong()));
                Fields.internals.set(this, objectInputStream.readObject());
                Fields.map.set(this, objectInputStream.readObject());
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* access modifiers changed from: private */
    public static <K, V> ValueReference<K, V> computing() {
        return COMPUTING;
    }

    private static class NullOutputExceptionReference<K, V> implements ValueReference<K, V> {
        final String message;

        public ValueReference<K, V> copyFor(ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        public V get() {
            return null;
        }

        NullOutputExceptionReference(String str) {
            this.message = str;
        }

        public V waitForValue() {
            throw new NullOutputException(this.message);
        }
    }

    private static class ComputationExceptionReference<K, V> implements ValueReference<K, V> {

        /* renamed from: t */
        final Throwable f382t;

        public ValueReference<K, V> copyFor(ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        public V get() {
            return null;
        }

        ComputationExceptionReference(Throwable th) {
            this.f382t = th;
        }

        public V waitForValue() {
            throw new AsynchronousComputationException(this.f382t);
        }
    }

    private static class QueueHolder {
        static final FinalizableReferenceQueue queue = new FinalizableReferenceQueue();

        private QueueHolder() {
        }
    }

    private static class StrongEntry<K, V> implements ReferenceEntry<K, V> {
        final int hash;
        final CustomConcurrentHashMap.Internals<K, V, ReferenceEntry<K, V>> internals;
        final K key;
        volatile ValueReference<K, V> valueReference = MapMaker.computing();

        public ReferenceEntry<K, V> getNext() {
            return null;
        }

        StrongEntry(CustomConcurrentHashMap.Internals<K, V, ReferenceEntry<K, V>> internals2, K k, int i) {
            this.internals = internals2;
            this.key = k;
            this.hash = i;
        }

        public K getKey() {
            return this.key;
        }

        public ValueReference<K, V> getValueReference() {
            return this.valueReference;
        }

        public void setValueReference(ValueReference<K, V> valueReference2) {
            this.valueReference = valueReference2;
        }

        public void valueReclaimed() {
            this.internals.removeEntry(this, null);
        }

        public int getHash() {
            return this.hash;
        }
    }

    private static class LinkedStrongEntry<K, V> extends StrongEntry<K, V> {
        final ReferenceEntry<K, V> next;

        LinkedStrongEntry(CustomConcurrentHashMap.Internals<K, V, ReferenceEntry<K, V>> internals, K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(internals, k, i);
            this.next = referenceEntry;
        }

        public ReferenceEntry<K, V> getNext() {
            return this.next;
        }
    }

    private static class SoftEntry<K, V> extends FinalizableSoftReference<K> implements ReferenceEntry<K, V> {
        final int hash;
        final CustomConcurrentHashMap.Internals<K, V, ReferenceEntry<K, V>> internals;
        volatile ValueReference<K, V> valueReference = MapMaker.computing();

        public ReferenceEntry<K, V> getNext() {
            return null;
        }

        SoftEntry(CustomConcurrentHashMap.Internals<K, V, ReferenceEntry<K, V>> internals2, K k, int i) {
            super(k, QueueHolder.queue);
            this.internals = internals2;
            this.hash = i;
        }

        public K getKey() {
            return get();
        }

        public void finalizeReferent() {
            this.internals.removeEntry(this);
        }

        public ValueReference<K, V> getValueReference() {
            return this.valueReference;
        }

        public void setValueReference(ValueReference<K, V> valueReference2) {
            this.valueReference = valueReference2;
        }

        public void valueReclaimed() {
            this.internals.removeEntry(this, null);
        }

        public int getHash() {
            return this.hash;
        }
    }

    private static class LinkedSoftEntry<K, V> extends SoftEntry<K, V> {
        final ReferenceEntry<K, V> next;

        LinkedSoftEntry(CustomConcurrentHashMap.Internals<K, V, ReferenceEntry<K, V>> internals, K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(internals, k, i);
            this.next = referenceEntry;
        }

        public ReferenceEntry<K, V> getNext() {
            return this.next;
        }
    }

    private static class WeakEntry<K, V> extends FinalizableWeakReference<K> implements ReferenceEntry<K, V> {
        final int hash;
        final CustomConcurrentHashMap.Internals<K, V, ReferenceEntry<K, V>> internals;
        volatile ValueReference<K, V> valueReference = MapMaker.computing();

        public ReferenceEntry<K, V> getNext() {
            return null;
        }

        WeakEntry(CustomConcurrentHashMap.Internals<K, V, ReferenceEntry<K, V>> internals2, K k, int i) {
            super(k, QueueHolder.queue);
            this.internals = internals2;
            this.hash = i;
        }

        public K getKey() {
            return get();
        }

        public void finalizeReferent() {
            this.internals.removeEntry(this);
        }

        public ValueReference<K, V> getValueReference() {
            return this.valueReference;
        }

        public void setValueReference(ValueReference<K, V> valueReference2) {
            this.valueReference = valueReference2;
        }

        public void valueReclaimed() {
            this.internals.removeEntry(this, null);
        }

        public int getHash() {
            return this.hash;
        }
    }

    private static class LinkedWeakEntry<K, V> extends WeakEntry<K, V> {
        final ReferenceEntry<K, V> next;

        LinkedWeakEntry(CustomConcurrentHashMap.Internals<K, V, ReferenceEntry<K, V>> internals, K k, int i, ReferenceEntry<K, V> referenceEntry) {
            super(internals, k, i);
            this.next = referenceEntry;
        }

        public ReferenceEntry<K, V> getNext() {
            return this.next;
        }
    }

    private static class WeakValueReference<K, V> extends FinalizableWeakReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> entry;

        WeakValueReference(V v, ReferenceEntry<K, V> referenceEntry) {
            super(v, QueueHolder.queue);
            this.entry = referenceEntry;
        }

        public void finalizeReferent() {
            this.entry.valueReclaimed();
        }

        public ValueReference<K, V> copyFor(ReferenceEntry<K, V> referenceEntry) {
            return new WeakValueReference(get(), referenceEntry);
        }

        public V waitForValue() throws InterruptedException {
            return get();
        }
    }

    private static class SoftValueReference<K, V> extends FinalizableSoftReference<V> implements ValueReference<K, V> {
        final ReferenceEntry<K, V> entry;

        SoftValueReference(V v, ReferenceEntry<K, V> referenceEntry) {
            super(v, QueueHolder.queue);
            this.entry = referenceEntry;
        }

        public void finalizeReferent() {
            this.entry.valueReclaimed();
        }

        public ValueReference<K, V> copyFor(ReferenceEntry<K, V> referenceEntry) {
            return new SoftValueReference(get(), referenceEntry);
        }

        public V waitForValue() {
            return get();
        }
    }

    private static class StrongValueReference<K, V> implements ValueReference<K, V> {
        final V referent;

        public ValueReference<K, V> copyFor(ReferenceEntry<K, V> referenceEntry) {
            return this;
        }

        StrongValueReference(V v) {
            this.referent = v;
        }

        public V get() {
            return this.referent;
        }

        public V waitForValue() {
            return get();
        }
    }
}
