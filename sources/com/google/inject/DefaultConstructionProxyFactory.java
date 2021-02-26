package com.google.inject;

import com.google.inject.spi.InjectionPoint;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

class DefaultConstructionProxyFactory<T> implements ConstructionProxyFactory<T> {
    /* access modifiers changed from: private */
    public final InjectionPoint injectionPoint;

    DefaultConstructionProxyFactory(InjectionPoint injectionPoint2) {
        this.injectionPoint = injectionPoint2;
    }

    public ConstructionProxy<T> create() {
        final Constructor constructor = (Constructor) this.injectionPoint.getMember();
        if (!Modifier.isPublic(constructor.getModifiers())) {
            constructor.setAccessible(true);
        }
        return new ConstructionProxy<T>() {
            public T newInstance(Object... objArr) throws InvocationTargetException {
                try {
                    return constructor.newInstance(objArr);
                } catch (InstantiationException e) {
                    throw new AssertionError(e);
                } catch (IllegalAccessException e2) {
                    throw new AssertionError(e2);
                }
            }

            public InjectionPoint getInjectionPoint() {
                return DefaultConstructionProxyFactory.this.injectionPoint;
            }

            public Constructor<T> getConstructor() {
                return constructor;
            }
        };
    }
}
