package com.google.inject;

import com.google.inject.BindingProcessor;
import com.google.inject.internal.Errors;
import com.google.inject.internal.ErrorsException;
import com.google.inject.internal.InternalContext;
import com.google.inject.internal.InternalFactory;
import com.google.inject.spi.Dependency;

class BoundProviderFactory<T> implements InternalFactory<T>, BindingProcessor.CreationListener {
    private final InjectorImpl injector;
    private InternalFactory<? extends Provider<? extends T>> providerFactory;
    final Key<? extends Provider<? extends T>> providerKey;
    final Object source;

    BoundProviderFactory(InjectorImpl injectorImpl, Key<? extends Provider<? extends T>> key, Object obj) {
        this.injector = injectorImpl;
        this.providerKey = key;
        this.source = obj;
    }

    public void notify(Errors errors) {
        try {
            this.providerFactory = this.injector.getInternalFactory(this.providerKey, errors.withSource(this.source));
        } catch (ErrorsException e) {
            errors.merge(e.getErrors());
        }
    }

    public T get(Errors errors, InternalContext internalContext, Dependency<?> dependency) throws ErrorsException {
        Errors withSource = errors.withSource(this.providerKey);
        try {
            return withSource.checkForNull(((Provider) this.providerFactory.get(withSource, internalContext, dependency)).get(), this.source, dependency);
        } catch (RuntimeException e) {
            throw withSource.errorInProvider(e).toException();
        }
    }

    public String toString() {
        return this.providerKey.toString();
    }
}
