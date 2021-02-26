package com.google.inject.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.inject.Binder;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.spi.BindingTargetVisitor;
import com.google.inject.spi.ProviderKeyBinding;

public final class LinkedProviderBindingImpl<T> extends BindingImpl<T> implements ProviderKeyBinding<T> {
    final Key<? extends Provider<? extends T>> providerKey;

    public LinkedProviderBindingImpl(Injector injector, Key<T> key, Object obj, InternalFactory<? extends T> internalFactory, Scoping scoping, Key<? extends Provider<? extends T>> key2) {
        super(injector, key, obj, internalFactory, scoping);
        this.providerKey = key2;
    }

    LinkedProviderBindingImpl(Object obj, Key<T> key, Scoping scoping, Key<? extends Provider<? extends T>> key2) {
        super(obj, key, scoping);
        this.providerKey = key2;
    }

    public <V> V acceptTargetVisitor(BindingTargetVisitor<? super T, V> bindingTargetVisitor) {
        return bindingTargetVisitor.visit((ProviderKeyBinding<? extends Object>) this);
    }

    public Key<? extends Provider<? extends T>> getProviderKey() {
        return this.providerKey;
    }

    public BindingImpl<T> withScoping(Scoping scoping) {
        return new LinkedProviderBindingImpl(getSource(), getKey(), scoping, this.providerKey);
    }

    public BindingImpl<T> withKey(Key<T> key) {
        return new LinkedProviderBindingImpl(getSource(), key, getScoping(), this.providerKey);
    }

    public void applyTo(Binder binder) {
        getScoping().applyTo(binder.withSource(getSource()).bind(getKey()).toProvider(getProviderKey()));
    }

    public String toString() {
        return new ToStringBuilder(ProviderKeyBinding.class).add("key", getKey()).add(FirebaseAnalytics.Param.SOURCE, getSource()).add("scope", getScoping()).add("provider", this.providerKey).toString();
    }
}
