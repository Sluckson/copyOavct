package com.google.inject.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.inject.Binding;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.spi.BindingScopingVisitor;
import com.google.inject.spi.ElementVisitor;
import com.google.inject.spi.InstanceBinding;

public abstract class BindingImpl<T> implements Binding<T> {
    private final Injector injector;
    private final InternalFactory<? extends T> internalFactory;
    private final Key<T> key;
    private volatile Provider<T> provider;
    private final Scoping scoping;
    private final Object source;

    public BindingImpl(Injector injector2, Key<T> key2, Object obj, InternalFactory<? extends T> internalFactory2, Scoping scoping2) {
        this.injector = injector2;
        this.key = key2;
        this.source = obj;
        this.internalFactory = internalFactory2;
        this.scoping = scoping2;
    }

    protected BindingImpl(Object obj, Key<T> key2, Scoping scoping2) {
        this.internalFactory = null;
        this.injector = null;
        this.source = obj;
        this.key = key2;
        this.scoping = scoping2;
    }

    public Key<T> getKey() {
        return this.key;
    }

    public Object getSource() {
        return this.source;
    }

    public Provider<T> getProvider() {
        if (this.provider == null) {
            Injector injector2 = this.injector;
            if (injector2 != null) {
                this.provider = injector2.getProvider(this.key);
            } else {
                throw new UnsupportedOperationException("getProvider() not supported for module bindings");
            }
        }
        return this.provider;
    }

    public InternalFactory<? extends T> getInternalFactory() {
        return this.internalFactory;
    }

    public Scoping getScoping() {
        return this.scoping;
    }

    public boolean isConstant() {
        return this instanceof InstanceBinding;
    }

    public <V> V acceptVisitor(ElementVisitor<V> elementVisitor) {
        return elementVisitor.visit((Binding<T>) this);
    }

    public <V> V acceptScopingVisitor(BindingScopingVisitor<V> bindingScopingVisitor) {
        return this.scoping.acceptVisitor(bindingScopingVisitor);
    }

    /* access modifiers changed from: protected */
    public BindingImpl<T> withScoping(Scoping scoping2) {
        throw new AssertionError();
    }

    /* access modifiers changed from: protected */
    public BindingImpl<T> withKey(Key<T> key2) {
        throw new AssertionError();
    }

    public String toString() {
        return new ToStringBuilder(Binding.class).add("key", this.key).add("scope", this.scoping).add(FirebaseAnalytics.Param.SOURCE, this.source).toString();
    }

    public Injector getInjector() {
        return this.injector;
    }
}
