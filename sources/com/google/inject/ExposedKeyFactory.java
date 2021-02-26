package com.google.inject;

import com.google.inject.BindingProcessor;
import com.google.inject.internal.BindingImpl;
import com.google.inject.internal.Errors;
import com.google.inject.internal.ErrorsException;
import com.google.inject.internal.InternalContext;
import com.google.inject.internal.InternalFactory;
import com.google.inject.spi.Dependency;
import com.google.inject.spi.PrivateElements;

class ExposedKeyFactory<T> implements InternalFactory<T>, BindingProcessor.CreationListener {
    private BindingImpl<T> delegate;
    private final Key<T> key;
    private final PrivateElements privateElements;

    public ExposedKeyFactory(Key<T> key2, PrivateElements privateElements2) {
        this.key = key2;
        this.privateElements = privateElements2;
    }

    public void notify(Errors errors) {
        BindingImpl<T> explicitBinding = ((InjectorImpl) this.privateElements.getInjector()).state.getExplicitBinding(this.key);
        if (explicitBinding.getInternalFactory() == this) {
            errors.withSource(explicitBinding.getSource()).exposedButNotBound(this.key);
        } else {
            this.delegate = explicitBinding;
        }
    }

    public T get(Errors errors, InternalContext internalContext, Dependency<?> dependency) throws ErrorsException {
        return this.delegate.getInternalFactory().get(errors, internalContext, dependency);
    }
}
