package com.google.inject.internal;

import com.google.inject.Binder;
import com.google.inject.Key;
import com.google.inject.Module;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.google.inject.spi.Dependency;
import com.google.inject.spi.Message;
import com.google.inject.util.Modules;
import java.lang.annotation.Annotation;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public final class ProviderMethodsModule implements Module {
    private final Object delegate;
    private final TypeLiteral<?> typeLiteral = TypeLiteral.get(this.delegate.getClass());

    private ProviderMethodsModule(Object obj) {
        this.delegate = Preconditions.checkNotNull(obj, "delegate");
    }

    public static Module forModule(Module module) {
        return forObject(module);
    }

    public static Module forObject(Object obj) {
        if (obj instanceof ProviderMethodsModule) {
            return Modules.EMPTY_MODULE;
        }
        return new ProviderMethodsModule(obj);
    }

    public synchronized void configure(Binder binder) {
        for (ProviderMethod<?> configure : getProviderMethods(binder)) {
            configure.configure(binder);
        }
    }

    public List<ProviderMethod<?>> getProviderMethods(Binder binder) {
        ArrayList newArrayList = Lists.newArrayList();
        for (Class cls = this.delegate.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            for (Method method : cls.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Provides.class)) {
                    newArrayList.add(createProviderMethod(binder, method));
                }
            }
        }
        return newArrayList;
    }

    /* access modifiers changed from: package-private */
    public <T> ProviderMethod<T> createProviderMethod(Binder binder, Method method) {
        Binder withSource = binder.withSource(method);
        Errors errors = new Errors(method);
        ArrayList newArrayList = Lists.newArrayList();
        ArrayList newArrayList2 = Lists.newArrayList();
        List<TypeLiteral<?>> parameterTypes = this.typeLiteral.getParameterTypes(method);
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (int i = 0; i < parameterTypes.size(); i++) {
            Key key = getKey(errors, parameterTypes.get(i), method, parameterAnnotations[i]);
            newArrayList.add(Dependency.get(key));
            newArrayList2.add(withSource.getProvider(key));
        }
        Key<?> key2 = getKey(errors, this.typeLiteral.getReturnType(method), method, method.getAnnotations());
        Class<? extends Annotation> findScopeAnnotation = Annotations.findScopeAnnotation(errors, method.getAnnotations());
        for (Message addError : errors.getMessages()) {
            withSource.addError(addError);
        }
        return new ProviderMethod(key2, method, this.delegate, ImmutableSet.copyOf(newArrayList), newArrayList2, findScopeAnnotation);
    }

    /* access modifiers changed from: package-private */
    public <T> Key<T> getKey(Errors errors, TypeLiteral<T> typeLiteral2, Member member, Annotation[] annotationArr) {
        Annotation findBindingAnnotation = Annotations.findBindingAnnotation(errors, member, annotationArr);
        return findBindingAnnotation == null ? Key.get(typeLiteral2) : Key.get(typeLiteral2, findBindingAnnotation);
    }

    public boolean equals(Object obj) {
        return (obj instanceof ProviderMethodsModule) && ((ProviderMethodsModule) obj).delegate == this.delegate;
    }

    public int hashCode() {
        return this.delegate.hashCode();
    }
}
