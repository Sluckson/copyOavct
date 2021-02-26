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
import com.google.inject.spi.ProviderInstanceBinding;
import java.util.Set;

public final class ProviderInstanceBindingImpl<T> extends BindingImpl<T> implements ProviderInstanceBinding<T> {
    final ImmutableSet<InjectionPoint> injectionPoints;
    final Provider<? extends T> providerInstance;

    public ProviderInstanceBindingImpl(Injector injector, Key<T> key, Object obj, InternalFactory<? extends T> internalFactory, Scoping scoping, Provider<? extends T> provider, Set<InjectionPoint> set) {
        super(injector, key, obj, internalFactory, scoping);
        this.providerInstance = provider;
        this.injectionPoints = ImmutableSet.copyOf(set);
    }

    public ProviderInstanceBindingImpl(Object obj, Key<T> key, Scoping scoping, Set<InjectionPoint> set, Provider<? extends T> provider) {
        super(obj, key, scoping);
        this.injectionPoints = ImmutableSet.copyOf(set);
        this.providerInstance = provider;
    }

    public <V> V acceptTargetVisitor(BindingTargetVisitor<? super T, V> bindingTargetVisitor) {
        return bindingTargetVisitor.visit((ProviderInstanceBinding<? extends Object>) this);
    }

    public Provider<? extends T> getProviderInstance() {
        return this.providerInstance;
    }

    public Set<InjectionPoint> getInjectionPoints() {
        return this.injectionPoints;
    }

    public Set<Dependency<?>> getDependencies() {
        Provider<? extends T> provider = this.providerInstance;
        return provider instanceof HasDependencies ? ImmutableSet.copyOf(((HasDependencies) provider).getDependencies()) : Dependency.forInjectionPoints(this.injectionPoints);
    }

    public BindingImpl<T> withScoping(Scoping scoping) {
        return new ProviderInstanceBindingImpl(getSource(), getKey(), scoping, this.injectionPoints, this.providerInstance);
    }

    public BindingImpl<T> withKey(Key<T> key) {
        return new ProviderInstanceBindingImpl(getSource(), key, getScoping(), this.injectionPoints, this.providerInstance);
    }

    public void applyTo(Binder binder) {
        getScoping().applyTo(binder.withSource(getSource()).bind(getKey()).toProvider(getProviderInstance()));
    }

    public String toString() {
        return new ToStringBuilder(ProviderInstanceBinding.class).add("key", getKey()).add(FirebaseAnalytics.Param.SOURCE, getSource()).add("scope", getScoping()).add("provider", this.providerInstance).toString();
    }
}
