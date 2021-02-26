package com.google.inject.internal;

import com.google.inject.spi.Dependency;

public interface InternalFactory<T> {
    T get(Errors errors, InternalContext internalContext, Dependency<?> dependency) throws ErrorsException;
}
