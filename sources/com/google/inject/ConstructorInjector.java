package com.google.inject;

import com.google.inject.internal.ConstructionContext;
import com.google.inject.internal.Errors;
import com.google.inject.internal.ErrorsException;
import com.google.inject.internal.ImmutableSet;
import com.google.inject.internal.InternalContext;
import com.google.inject.spi.InjectionPoint;
import java.lang.reflect.InvocationTargetException;

class ConstructorInjector<T> {
    private final ConstructionProxy<T> constructionProxy;
    private final ImmutableSet<InjectionPoint> injectableMembers;
    private final MembersInjectorImpl<T> membersInjector;
    private final SingleParameterInjector<?>[] parameterInjectors;

    ConstructorInjector(ImmutableSet<InjectionPoint> immutableSet, ConstructionProxy<T> constructionProxy2, SingleParameterInjector<?>[] singleParameterInjectorArr, MembersInjectorImpl<T> membersInjectorImpl) throws ErrorsException {
        this.injectableMembers = immutableSet;
        this.constructionProxy = constructionProxy2;
        this.parameterInjectors = singleParameterInjectorArr;
        this.membersInjector = membersInjectorImpl;
    }

    public ImmutableSet<InjectionPoint> getInjectableMembers() {
        return this.injectableMembers;
    }

    /* access modifiers changed from: package-private */
    public ConstructionProxy<T> getConstructionProxy() {
        return this.constructionProxy;
    }

    /* access modifiers changed from: package-private */
    public Object construct(Errors errors, InternalContext internalContext, Class<?> cls) throws ErrorsException {
        ConstructionContext constructionContext = internalContext.getConstructionContext(this);
        if (constructionContext.isConstructing()) {
            return constructionContext.createProxy(errors, cls);
        }
        Object currentReference = constructionContext.getCurrentReference();
        if (currentReference != null) {
            return currentReference;
        }
        try {
            constructionContext.startConstruction();
            T newInstance = this.constructionProxy.newInstance(SingleParameterInjector.getAll(errors, internalContext, this.parameterInjectors));
            constructionContext.setProxyDelegates(newInstance);
            constructionContext.finishConstruction();
            constructionContext.setCurrentReference(newInstance);
            this.membersInjector.injectMembers(newInstance, errors, internalContext);
            this.membersInjector.notifyListeners(newInstance, errors);
            constructionContext.removeCurrentReference();
            return newInstance;
        } catch (InvocationTargetException e) {
            try {
                Throwable cause = e.getCause();
                Throwable th = e;
                if (cause != null) {
                    th = e.getCause();
                }
                throw errors.withSource(this.constructionProxy.getInjectionPoint()).errorInjectingConstructor(th).toException();
            } catch (Throwable th2) {
                constructionContext.removeCurrentReference();
                throw th2;
            }
        } catch (Throwable th3) {
            constructionContext.finishConstruction();
            throw th3;
        }
    }
}
