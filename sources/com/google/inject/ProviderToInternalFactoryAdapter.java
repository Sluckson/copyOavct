package com.google.inject;

import com.google.inject.internal.Errors;
import com.google.inject.internal.ErrorsException;
import com.google.inject.internal.InternalContext;
import com.google.inject.internal.InternalFactory;
import com.google.inject.spi.Message;

class ProviderToInternalFactoryAdapter<T> implements Provider<T> {
    private final InjectorImpl injector;
    /* access modifiers changed from: private */
    public final InternalFactory<? extends T> internalFactory;

    public ProviderToInternalFactoryAdapter(InjectorImpl injectorImpl, InternalFactory<? extends T> internalFactory2) {
        this.injector = injectorImpl;
        this.internalFactory = internalFactory2;
    }

    public T get() {
        final Errors errors = new Errors();
        try {
            T callInContext = this.injector.callInContext(new ContextualCallable<T>() {
                public T call(InternalContext internalContext) throws ErrorsException {
                    return ProviderToInternalFactoryAdapter.this.internalFactory.get(errors, internalContext, internalContext.getDependency());
                }
            });
            errors.throwIfNewErrors(0);
            return callInContext;
        } catch (ErrorsException e) {
            throw new ProvisionException((Iterable<Message>) errors.merge(e.getErrors()).getMessages());
        }
    }

    public String toString() {
        return this.internalFactory.toString();
    }
}
