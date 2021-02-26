package com.google.inject;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.inject.internal.BindingImpl;
import com.google.inject.internal.Errors;
import com.google.inject.internal.ErrorsException;
import com.google.inject.internal.ImmutableSet;
import com.google.inject.internal.InternalContext;
import com.google.inject.internal.InternalFactory;
import com.google.inject.internal.Preconditions;
import com.google.inject.internal.Scoping;
import com.google.inject.internal.ToStringBuilder;
import com.google.inject.spi.BindingTargetVisitor;
import com.google.inject.spi.ConstructorBinding;
import com.google.inject.spi.Dependency;
import com.google.inject.spi.InjectionPoint;
import java.util.Set;

class ConstructorBindingImpl<T> extends BindingImpl<T> implements ConstructorBinding<T> {
    private final Factory<T> factory;

    private ConstructorBindingImpl(Injector injector, Key<T> key, Object obj, InternalFactory<? extends T> internalFactory, Scoping scoping, Factory<T> factory2) {
        super(injector, key, obj, internalFactory, scoping);
        this.factory = factory2;
    }

    static <T> ConstructorBindingImpl<T> create(InjectorImpl injectorImpl, Key<T> key, Object obj, Scoping scoping) {
        Factory factory2 = new Factory();
        return new ConstructorBindingImpl(injectorImpl, key, obj, Scopes.scope(key, injectorImpl, factory2, scoping), scoping, factory2);
    }

    public void initialize(InjectorImpl injectorImpl, Errors errors) throws ErrorsException {
        ConstructorInjector unused = this.factory.constructorInjector = injectorImpl.constructors.get(getKey().getTypeLiteral(), errors);
    }

    public <V> V acceptTargetVisitor(BindingTargetVisitor<? super T, V> bindingTargetVisitor) {
        Preconditions.checkState(this.factory.constructorInjector != null, "not initialized");
        return bindingTargetVisitor.visit((ConstructorBinding<? extends Object>) this);
    }

    public InjectionPoint getConstructor() {
        Preconditions.checkState(this.factory.constructorInjector != null, "Binding is not ready");
        return this.factory.constructorInjector.getConstructionProxy().getInjectionPoint();
    }

    public Set<InjectionPoint> getInjectableMembers() {
        Preconditions.checkState(this.factory.constructorInjector != null, "Binding is not ready");
        return this.factory.constructorInjector.getInjectableMembers();
    }

    public Set<Dependency<?>> getDependencies() {
        return Dependency.forInjectionPoints(new ImmutableSet.Builder().add(getConstructor()).addAll(getInjectableMembers()).build());
    }

    public void applyTo(Binder binder) {
        throw new UnsupportedOperationException("This element represents a synthetic binding.");
    }

    public String toString() {
        return new ToStringBuilder(ConstructorBinding.class).add("key", getKey()).add(FirebaseAnalytics.Param.SOURCE, getSource()).add("scope", getScoping()).toString();
    }

    private static class Factory<T> implements InternalFactory<T> {
        /* access modifiers changed from: private */
        public ConstructorInjector<T> constructorInjector;

        private Factory() {
        }

        public T get(Errors errors, InternalContext internalContext, Dependency<?> dependency) throws ErrorsException {
            Preconditions.checkState(this.constructorInjector != null, "Constructor not ready");
            return this.constructorInjector.construct(errors, internalContext, dependency.getKey().getRawType());
        }
    }
}
