package com.google.inject;

import com.google.inject.InjectorImpl;
import com.google.inject.internal.Errors;
import com.google.inject.internal.ErrorsException;
import com.google.inject.internal.InternalContext;
import com.google.inject.spi.InjectionPoint;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

class SingleMethodInjector implements SingleMemberInjector {
    final InjectionPoint injectionPoint;
    final InjectorImpl.MethodInvoker methodInvoker;
    final SingleParameterInjector<?>[] parameterInjectors;

    public SingleMethodInjector(InjectorImpl injectorImpl, InjectionPoint injectionPoint2, Errors errors) throws ErrorsException {
        this.injectionPoint = injectionPoint2;
        this.methodInvoker = createMethodInvoker((Method) injectionPoint2.getMember());
        this.parameterInjectors = injectorImpl.getParametersInjectors(injectionPoint2.getDependencies(), errors);
    }

    private InjectorImpl.MethodInvoker createMethodInvoker(final Method method) {
        int modifiers = method.getModifiers();
        if (!Modifier.isPrivate(modifiers)) {
            Modifier.isProtected(modifiers);
        }
        if (!Modifier.isPublic(modifiers)) {
            method.setAccessible(true);
        }
        return new InjectorImpl.MethodInvoker() {
            public Object invoke(Object obj, Object... objArr) throws IllegalAccessException, InvocationTargetException {
                return method.invoke(obj, objArr);
            }
        };
    }

    public InjectionPoint getInjectionPoint() {
        return this.injectionPoint;
    }

    public void inject(Errors errors, InternalContext internalContext, Object obj) {
        try {
            try {
                this.methodInvoker.invoke(obj, SingleParameterInjector.getAll(errors, internalContext, this.parameterInjectors));
            } catch (IllegalAccessException e) {
                throw new AssertionError(e);
            } catch (InvocationTargetException e2) {
                Throwable cause = e2.getCause();
                Throwable th = e2;
                if (cause != null) {
                    th = e2.getCause();
                }
                errors.withSource(this.injectionPoint).errorInjectingMethod(th);
            }
        } catch (ErrorsException e3) {
            errors.merge(e3.getErrors());
        }
    }
}
