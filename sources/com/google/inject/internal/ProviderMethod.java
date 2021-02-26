package com.google.inject.internal;

import com.google.inject.Binder;
import com.google.inject.Exposed;
import com.google.inject.Key;
import com.google.inject.PrivateBinder;
import com.google.inject.Provider;
import com.google.inject.spi.Dependency;
import com.google.inject.spi.ProviderWithDependencies;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

public class ProviderMethod<T> implements ProviderWithDependencies<T> {
    private final ImmutableSet<Dependency<?>> dependencies;
    private final boolean exposed;
    private final Object instance;
    private final Key<T> key;
    private final Method method;
    private final List<Provider<?>> parameterProviders;
    private final Class<? extends Annotation> scopeAnnotation;

    ProviderMethod(Key<T> key2, Method method2, Object obj, ImmutableSet<Dependency<?>> immutableSet, List<Provider<?>> list, Class<? extends Annotation> cls) {
        this.key = key2;
        this.scopeAnnotation = cls;
        this.instance = obj;
        this.dependencies = immutableSet;
        this.method = method2;
        this.parameterProviders = list;
        this.exposed = method2.isAnnotationPresent(Exposed.class);
        method2.setAccessible(true);
    }

    public Key<T> getKey() {
        return this.key;
    }

    public Method getMethod() {
        return this.method;
    }

    public Object getInstance() {
        return this.instance;
    }

    public void configure(Binder binder) {
        Binder withSource = binder.withSource(this.method);
        if (this.scopeAnnotation != null) {
            withSource.bind(this.key).toProvider(this).mo36522in(this.scopeAnnotation);
        } else {
            withSource.bind(this.key).toProvider(this);
        }
        if (this.exposed) {
            ((PrivateBinder) withSource).expose((Key<?>) this.key);
        }
    }

    public T get() {
        Object[] objArr = new Object[this.parameterProviders.size()];
        for (int i = 0; i < objArr.length; i++) {
            objArr[i] = this.parameterProviders.get(i).get();
        }
        try {
            return this.method.invoke(this.instance, objArr);
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (InvocationTargetException e2) {
            throw new RuntimeException(e2);
        }
    }

    public Set<Dependency<?>> getDependencies() {
        return this.dependencies;
    }
}
