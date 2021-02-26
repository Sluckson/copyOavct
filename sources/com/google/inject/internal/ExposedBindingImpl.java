package com.google.inject.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.inject.Binder;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.spi.BindingTargetVisitor;
import com.google.inject.spi.Dependency;
import com.google.inject.spi.ExposedBinding;
import com.google.inject.spi.PrivateElements;
import java.util.Set;

public class ExposedBindingImpl<T> extends BindingImpl<T> implements ExposedBinding<T> {
    private final PrivateElements privateElements;

    public ExposedBindingImpl(Injector injector, Object obj, Key<T> key, InternalFactory<T> internalFactory, PrivateElements privateElements2) {
        super(injector, key, obj, internalFactory, Scoping.UNSCOPED);
        this.privateElements = privateElements2;
    }

    public ExposedBindingImpl(Object obj, Key<T> key, Scoping scoping, PrivateElements privateElements2) {
        super(obj, key, scoping);
        this.privateElements = privateElements2;
    }

    public <V> V acceptTargetVisitor(BindingTargetVisitor<? super T, V> bindingTargetVisitor) {
        return bindingTargetVisitor.visit((ExposedBinding<? extends Object>) this);
    }

    public Set<Dependency<?>> getDependencies() {
        return ImmutableSet.m349of(Dependency.get(Key.get(Injector.class)));
    }

    public PrivateElements getPrivateElements() {
        return this.privateElements;
    }

    public BindingImpl<T> withScoping(Scoping scoping) {
        return new ExposedBindingImpl(getSource(), getKey(), scoping, this.privateElements);
    }

    public ExposedBindingImpl<T> withKey(Key<T> key) {
        return new ExposedBindingImpl<>(getSource(), key, getScoping(), this.privateElements);
    }

    public String toString() {
        return new ToStringBuilder(ExposedBinding.class).add("key", getKey()).add(FirebaseAnalytics.Param.SOURCE, getSource()).add("privateElements", this.privateElements).toString();
    }

    public void applyTo(Binder binder) {
        throw new UnsupportedOperationException("This element represents a synthetic binding.");
    }
}
