package com.google.inject;

import com.google.inject.internal.ErrorsException;
import com.google.inject.internal.InternalContext;

interface ContextualCallable<T> {
    T call(InternalContext internalContext) throws ErrorsException;
}
