package com.google.inject.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.inject.Binder;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.spi.BindingTargetVisitor;
import com.google.inject.spi.Dependency;
import com.google.inject.spi.UntargettedBinding;

public class UntargettedBindingImpl<T> extends BindingImpl<T> implements UntargettedBinding<T> {
    public UntargettedBindingImpl(Injector injector, Key<T> key, Object obj) {
        super(injector, key, obj, new InternalFactory<T>() {
            public T get(Errors errors, InternalContext internalContext, Dependency<?> dependency) {
                throw new AssertionError();
            }
        }, Scoping.UNSCOPED);
    }

    public UntargettedBindingImpl(Object obj, Key<T> key, Scoping scoping) {
        super(obj, key, scoping);
    }

    public <V> V acceptTargetVisitor(BindingTargetVisitor<? super T, V> bindingTargetVisitor) {
        return bindingTargetVisitor.visit((UntargettedBinding<? extends Object>) this);
    }

    public BindingImpl<T> withScoping(Scoping scoping) {
        return new UntargettedBindingImpl(getSource(), getKey(), scoping);
    }

    public BindingImpl<T> withKey(Key<T> key) {
        return new UntargettedBindingImpl(getSource(), key, getScoping());
    }

    public void applyTo(Binder binder) {
        getScoping().applyTo(binder.withSource(getSource()).bind(getKey()));
    }

    public String toString() {
        return new ToStringBuilder(UntargettedBinding.class).add("key", getKey()).add(FirebaseAnalytics.Param.SOURCE, getSource()).toString();
    }
}
