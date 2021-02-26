package com.google.inject.internal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

public class ConstructionContext<T> {
    boolean constructing;
    T currentReference;
    List<DelegatingInvocationHandler<T>> invocationHandlers;

    public T getCurrentReference() {
        return this.currentReference;
    }

    public void removeCurrentReference() {
        this.currentReference = null;
    }

    public void setCurrentReference(T t) {
        this.currentReference = t;
    }

    public boolean isConstructing() {
        return this.constructing;
    }

    public void startConstruction() {
        this.constructing = true;
    }

    public void finishConstruction() {
        this.constructing = false;
        this.invocationHandlers = null;
    }

    public Object createProxy(Errors errors, Class<?> cls) throws ErrorsException {
        if (cls.isInterface()) {
            if (this.invocationHandlers == null) {
                this.invocationHandlers = new ArrayList();
            }
            DelegatingInvocationHandler delegatingInvocationHandler = new DelegatingInvocationHandler();
            this.invocationHandlers.add(delegatingInvocationHandler);
            return cls.cast(Proxy.newProxyInstance(BytecodeGen.getClassLoader(cls), new Class[]{cls}, delegatingInvocationHandler));
        }
        throw errors.cannotSatisfyCircularDependency(cls).toException();
    }

    public void setProxyDelegates(T t) {
        List<DelegatingInvocationHandler<T>> list = this.invocationHandlers;
        if (list != null) {
            for (DelegatingInvocationHandler<T> delegate : list) {
                delegate.setDelegate(t);
            }
        }
    }

    static class DelegatingInvocationHandler<T> implements InvocationHandler {
        T delegate;

        DelegatingInvocationHandler() {
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            T t = this.delegate;
            if (t != null) {
                try {
                    return method.invoke(t, objArr);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (IllegalArgumentException e2) {
                    throw new RuntimeException(e2);
                } catch (InvocationTargetException e3) {
                    throw e3.getTargetException();
                }
            } else {
                throw new IllegalStateException("This is a proxy used to support circular references involving constructors. The object we're proxying is not constructed yet. Please wait until after injection has completed to use this object.");
            }
        }

        /* access modifiers changed from: package-private */
        public void setDelegate(T t) {
            this.delegate = t;
        }
    }
}
