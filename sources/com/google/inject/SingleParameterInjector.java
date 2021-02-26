package com.google.inject;

import com.google.inject.internal.Errors;
import com.google.inject.internal.ErrorsException;
import com.google.inject.internal.InternalContext;
import com.google.inject.internal.InternalFactory;
import com.google.inject.spi.Dependency;

class SingleParameterInjector<T> {
    private static final Object[] NO_ARGUMENTS = new Object[0];
    private final Dependency<T> dependency;
    private final InternalFactory<? extends T> factory;

    SingleParameterInjector(Dependency<T> dependency2, InternalFactory<? extends T> internalFactory) {
        this.dependency = dependency2;
        this.factory = internalFactory;
    }

    private T inject(Errors errors, InternalContext internalContext) throws ErrorsException {
        internalContext.setDependency(this.dependency);
        try {
            return this.factory.get(errors.withSource(this.dependency), internalContext, this.dependency);
        } finally {
            internalContext.setDependency((Dependency) null);
        }
    }

    static Object[] getAll(Errors errors, InternalContext internalContext, SingleParameterInjector<?>[] singleParameterInjectorArr) throws ErrorsException {
        if (singleParameterInjectorArr == null) {
            return NO_ARGUMENTS;
        }
        int size = errors.size();
        int length = singleParameterInjectorArr.length;
        Object[] objArr = new Object[length];
        for (int i = 0; i < length; i++) {
            try {
                objArr[i] = singleParameterInjectorArr[i].inject(errors, internalContext);
            } catch (ErrorsException e) {
                errors.merge(e.getErrors());
            }
        }
        errors.throwIfNewErrors(size);
        return objArr;
    }
}
