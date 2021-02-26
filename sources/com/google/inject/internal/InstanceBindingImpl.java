package com.google.inject.internal;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.inject.Binder;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.Provider;
import com.google.inject.spi.BindingTargetVisitor;
import com.google.inject.spi.Dependency;
import com.google.inject.spi.HasDependencies;
import com.google.inject.spi.InjectionPoint;
import com.google.inject.spi.InstanceBinding;
import com.google.inject.util.Providers;
import java.util.Set;

public class InstanceBindingImpl<T> extends BindingImpl<T> implements InstanceBinding<T> {
    final ImmutableSet<InjectionPoint> injectionPoints;
    final T instance;
    final Provider<T> provider;

    public InstanceBindingImpl(Injector injector, Key<T> key, Object obj, InternalFactory<? extends T> internalFactory, Set<InjectionPoint> set, T t) {
        super(injector, key, obj, internalFactory, Scoping.UNSCOPED);
        this.injectionPoints = ImmutableSet.copyOf(set);
        this.instance = t;
        this.provider = Providers.m353of(t);
    }

    public InstanceBindingImpl(Object obj, Key<T> key, Scoping scoping, Set<InjectionPoint> set, T t) {
        super(obj, key, scoping);
        this.injectionPoints = ImmutableSet.copyOf(set);
        this.instance = t;
        this.provider = Providers.m353of(t);
    }

    public Provider<T> getProvider() {
        return this.provider;
    }

    public <V> V acceptTargetVisitor(BindingTargetVisitor<? super T, V> bindingTargetVisitor) {
        return bindingTargetVisitor.visit((InstanceBinding<? extends Object>) this);
    }

    public T getInstance() {
        return this.instance;
    }

    public Set<InjectionPoint> getInjectionPoints() {
        return this.injectionPoints;
    }

    public Set<Dependency<?>> getDependencies() {
        T t = this.instance;
        return t instanceof HasDependencies ? ImmutableSet.copyOf(((HasDependencies) t).getDependencies()) : Dependency.forInjectionPoints(this.injectionPoints);
    }

    public BindingImpl<T> withScoping(Scoping scoping) {
        return new InstanceBindingImpl(getSource(), getKey(), scoping, this.injectionPoints, this.instance);
    }

    public BindingImpl<T> withKey(Key<T> key) {
        return new InstanceBindingImpl(getSource(), key, getScoping(), this.injectionPoints, this.instance);
    }

    public void applyTo(Binder binder) {
        binder.withSource(getSource()).bind(getKey()).toInstance(this.instance);
    }

    public String toString() {
        return new ToStringBuilder(InstanceBinding.class).add("key", getKey()).add(FirebaseAnalytics.Param.SOURCE, getSource()).add("instance", this.instance).toString();
    }
}
