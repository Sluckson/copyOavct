package com.google.inject.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.inject.Binder;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.spi.BindingTargetVisitor;
import com.google.inject.spi.LinkedKeyBinding;

public final class LinkedBindingImpl<T> extends BindingImpl<T> implements LinkedKeyBinding<T> {
    final Key<? extends T> targetKey;

    public LinkedBindingImpl(Injector injector, Key<T> key, Object obj, InternalFactory<? extends T> internalFactory, Scoping scoping, Key<? extends T> key2) {
        super(injector, key, obj, internalFactory, scoping);
        this.targetKey = key2;
    }

    public LinkedBindingImpl(Object obj, Key<T> key, Scoping scoping, Key<? extends T> key2) {
        super(obj, key, scoping);
        this.targetKey = key2;
    }

    public <V> V acceptTargetVisitor(BindingTargetVisitor<? super T, V> bindingTargetVisitor) {
        return bindingTargetVisitor.visit((LinkedKeyBinding<? extends Object>) this);
    }

    public Key<? extends T> getLinkedKey() {
        return this.targetKey;
    }

    public BindingImpl<T> withScoping(Scoping scoping) {
        return new LinkedBindingImpl(getSource(), getKey(), scoping, this.targetKey);
    }

    public BindingImpl<T> withKey(Key<T> key) {
        return new LinkedBindingImpl(getSource(), key, getScoping(), this.targetKey);
    }

    public void applyTo(Binder binder) {
        getScoping().applyTo(binder.withSource(getSource()).bind(getKey()).mo36513to(getLinkedKey()));
    }

    public String toString() {
        return new ToStringBuilder(LinkedKeyBinding.class).add("key", getKey()).add(FirebaseAnalytics.Param.SOURCE, getSource()).add("scope", getScoping()).add("target", this.targetKey).toString();
    }
}
