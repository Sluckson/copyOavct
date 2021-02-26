package com.google.inject;

import com.google.inject.internal.Errors;
import com.google.inject.internal.ErrorsException;
import com.google.inject.internal.InternalContext;
import com.google.inject.internal.InternalFactory;
import com.google.inject.internal.ToStringBuilder;
import com.google.inject.spi.Dependency;

class ConstantFactory<T> implements InternalFactory<T> {
    private final Initializable<T> initializable;

    public ConstantFactory(Initializable<T> initializable2) {
        this.initializable = initializable2;
    }

    public T get(Errors errors, InternalContext internalContext, Dependency dependency) throws ErrorsException {
        return this.initializable.get(errors);
    }

    public String toString() {
        return new ToStringBuilder(ConstantFactory.class).add("value", this.initializable).toString();
    }
}
