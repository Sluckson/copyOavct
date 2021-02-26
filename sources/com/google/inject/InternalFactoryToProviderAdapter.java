package com.google.inject;

import com.google.inject.internal.Errors;
import com.google.inject.internal.ErrorsException;
import com.google.inject.internal.InternalContext;
import com.google.inject.internal.InternalFactory;
import com.google.inject.internal.SourceProvider;
import com.google.inject.spi.Dependency;

class InternalFactoryToProviderAdapter<T> implements InternalFactory<T> {
    private final Initializable<Provider<? extends T>> initializable;
    private final Object source;

    public InternalFactoryToProviderAdapter(Initializable<Provider<? extends T>> initializable2) {
        this(initializable2, SourceProvider.UNKNOWN_SOURCE);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [java.lang.Object, com.google.inject.Initializable<com.google.inject.Provider<? extends T>>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public InternalFactoryToProviderAdapter(com.google.inject.Initializable<com.google.inject.Provider<? extends T>> r2, java.lang.Object r3) {
        /*
            r1 = this;
            r1.<init>()
            java.lang.String r0 = "provider"
            java.lang.Object r2 = com.google.inject.internal.Preconditions.checkNotNull(r2, r0)
            com.google.inject.Initializable r2 = (com.google.inject.Initializable) r2
            r1.initializable = r2
            java.lang.String r2 = "source"
            java.lang.Object r2 = com.google.inject.internal.Preconditions.checkNotNull(r3, r2)
            r1.source = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.inject.InternalFactoryToProviderAdapter.<init>(com.google.inject.Initializable, java.lang.Object):void");
    }

    public T get(Errors errors, InternalContext internalContext, Dependency<?> dependency) throws ErrorsException {
        try {
            return errors.checkForNull(this.initializable.get(errors).get(), this.source, dependency);
        } catch (RuntimeException e) {
            throw errors.withSource(this.source).errorInProvider(e).toException();
        }
    }

    public String toString() {
        return this.initializable.toString();
    }
}
