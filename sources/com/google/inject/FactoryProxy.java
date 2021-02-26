package com.google.inject;

import com.google.inject.BindingProcessor;
import com.google.inject.internal.Errors;
import com.google.inject.internal.ErrorsException;
import com.google.inject.internal.InternalContext;
import com.google.inject.internal.InternalFactory;
import com.google.inject.internal.ToStringBuilder;
import com.google.inject.spi.Dependency;

class FactoryProxy<T> implements InternalFactory<T>, BindingProcessor.CreationListener {
    private final InjectorImpl injector;
    private final Key<T> key;
    private final Object source;
    private InternalFactory<? extends T> targetFactory;
    private final Key<? extends T> targetKey;

    FactoryProxy(InjectorImpl injectorImpl, Key<T> key2, Key<? extends T> key3, Object obj) {
        this.injector = injectorImpl;
        this.key = key2;
        this.targetKey = key3;
        this.source = obj;
    }

    public void notify(Errors errors) {
        try {
            this.targetFactory = this.injector.getInternalFactory(this.targetKey, errors.withSource(this.source));
        } catch (ErrorsException e) {
            errors.merge(e.getErrors());
        }
    }

    public T get(Errors errors, InternalContext internalContext, Dependency<?> dependency) throws ErrorsException {
        return this.targetFactory.get(errors.withSource(this.targetKey), internalContext, dependency);
    }

    public String toString() {
        return new ToStringBuilder(FactoryProxy.class).add("key", this.key).add("provider", this.targetFactory).toString();
    }
}
