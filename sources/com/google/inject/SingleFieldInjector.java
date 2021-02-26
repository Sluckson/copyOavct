package com.google.inject;

import com.google.inject.internal.Errors;
import com.google.inject.internal.ErrorsException;
import com.google.inject.internal.InternalContext;
import com.google.inject.internal.InternalFactory;
import com.google.inject.spi.Dependency;
import com.google.inject.spi.InjectionPoint;
import java.lang.reflect.Field;

class SingleFieldInjector implements SingleMemberInjector {
    final Dependency<?> dependency;
    final InternalFactory<?> factory;
    final Field field;
    final InjectionPoint injectionPoint;

    public SingleFieldInjector(InjectorImpl injectorImpl, InjectionPoint injectionPoint2, Errors errors) throws ErrorsException {
        this.injectionPoint = injectionPoint2;
        this.field = (Field) injectionPoint2.getMember();
        this.dependency = injectionPoint2.getDependencies().get(0);
        this.field.setAccessible(true);
        this.factory = injectorImpl.getInternalFactory(this.dependency.getKey(), errors);
    }

    public InjectionPoint getInjectionPoint() {
        return this.injectionPoint;
    }

    public void inject(Errors errors, InternalContext internalContext, Object obj) {
        Errors withSource = errors.withSource(this.dependency);
        internalContext.setDependency(this.dependency);
        try {
            this.field.set(obj, this.factory.get(withSource, internalContext, this.dependency));
        } catch (ErrorsException e) {
            withSource.withSource(this.injectionPoint).merge(e.getErrors());
        } catch (IllegalAccessException e2) {
            throw new AssertionError(e2);
        } catch (Throwable th) {
            internalContext.setDependency((Dependency) null);
            throw th;
        }
        internalContext.setDependency((Dependency) null);
    }
}
