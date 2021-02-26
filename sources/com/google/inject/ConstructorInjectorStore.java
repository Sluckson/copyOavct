package com.google.inject;

import com.google.inject.internal.Errors;
import com.google.inject.internal.ErrorsException;
import com.google.inject.internal.FailableCache;
import com.google.inject.spi.InjectionPoint;

class ConstructorInjectorStore {
    private final FailableCache<TypeLiteral<?>, ConstructorInjector<?>> cache = new FailableCache<TypeLiteral<?>, ConstructorInjector<?>>() {
        /* access modifiers changed from: protected */
        public ConstructorInjector<?> create(TypeLiteral<?> typeLiteral, Errors errors) throws ErrorsException {
            return ConstructorInjectorStore.this.createConstructor(typeLiteral, errors);
        }
    };
    private final InjectorImpl injector;

    ConstructorInjectorStore(InjectorImpl injectorImpl) {
        this.injector = injectorImpl;
    }

    public <T> ConstructorInjector<T> get(TypeLiteral<T> typeLiteral, Errors errors) throws ErrorsException {
        return this.cache.get(typeLiteral, errors);
    }

    /* access modifiers changed from: private */
    public <T> ConstructorInjector<T> createConstructor(TypeLiteral<T> typeLiteral, Errors errors) throws ErrorsException {
        int size = errors.size();
        try {
            InjectionPoint forConstructorOf = InjectionPoint.forConstructorOf((TypeLiteral<?>) typeLiteral);
            SingleParameterInjector[] parametersInjectors = this.injector.getParametersInjectors(forConstructorOf.getDependencies(), errors);
            MembersInjectorImpl<T> membersInjectorImpl = this.injector.membersInjectorStore.get(typeLiteral, errors);
            DefaultConstructionProxyFactory defaultConstructionProxyFactory = new DefaultConstructionProxyFactory(forConstructorOf);
            errors.throwIfNewErrors(size);
            return new ConstructorInjector<>(membersInjectorImpl.getInjectionPoints(), defaultConstructionProxyFactory.create(), parametersInjectors, membersInjectorImpl);
        } catch (ConfigurationException e) {
            errors.merge(e.getErrorMessages());
            throw errors.toException();
        }
    }
}
