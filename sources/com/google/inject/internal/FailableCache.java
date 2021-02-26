package com.google.inject.internal;

import java.util.Map;

public abstract class FailableCache<K, V> {
    private final Map<K, Object> delegate = new MapMaker().makeComputingMap(new Function<K, Object>() {
        public Object apply(@Nullable K k) {
            Object obj;
            Errors errors = new Errors();
            try {
                obj = FailableCache.this.create(k, errors);
            } catch (ErrorsException e) {
                errors.merge(e.getErrors());
                obj = null;
            }
            return errors.hasErrors() ? errors : obj;
        }
    });

    /* access modifiers changed from: protected */
    public abstract V create(K k, Errors errors) throws ErrorsException;

    public V get(K k, Errors errors) throws ErrorsException {
        V v = this.delegate.get(k);
        if (!(v instanceof Errors)) {
            return v;
        }
        errors.merge((Errors) v);
        throw errors.toException();
    }
}
