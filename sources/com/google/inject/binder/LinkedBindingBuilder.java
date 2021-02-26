package com.google.inject.binder;

import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.TypeLiteral;

public interface LinkedBindingBuilder<T> extends ScopedBindingBuilder {
    /* renamed from: to */
    ScopedBindingBuilder mo36513to(Key<? extends T> key);

    /* renamed from: to */
    ScopedBindingBuilder mo36514to(TypeLiteral<? extends T> typeLiteral);

    /* renamed from: to */
    ScopedBindingBuilder mo36515to(Class<? extends T> cls);

    void toInstance(T t);

    ScopedBindingBuilder toProvider(Key<? extends Provider<? extends T>> key);

    ScopedBindingBuilder toProvider(Provider<? extends T> provider);

    ScopedBindingBuilder toProvider(Class<? extends Provider<? extends T>> cls);
}
