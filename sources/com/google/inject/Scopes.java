package com.google.inject;

import com.google.inject.internal.Errors;
import com.google.inject.internal.InternalFactory;
import com.google.inject.internal.Scoping;
import java.lang.annotation.Annotation;

public class Scopes {
    public static final Scope NO_SCOPE = new Scope() {
        public <T> Provider<T> scope(Key<T> key, Provider<T> provider) {
            return provider;
        }

        public String toString() {
            return "Scopes.NO_SCOPE";
        }
    };
    public static final Scope SINGLETON = new Scope() {
        public String toString() {
            return "Scopes.SINGLETON";
        }

        public <T> Provider<T> scope(Key<T> key, final Provider<T> provider) {
            return new Provider<T>() {
                private volatile T instance;

                public T get() {
                    if (this.instance == null) {
                        synchronized (InjectorImpl.class) {
                            if (this.instance == null) {
                                this.instance = provider.get();
                            }
                        }
                    }
                    return this.instance;
                }

                public String toString() {
                    return String.format("%s[%s]", new Object[]{provider, Scopes.SINGLETON});
                }
            };
        }
    };

    private Scopes() {
    }

    static <T> InternalFactory<? extends T> scope(Key<T> key, InjectorImpl injectorImpl, InternalFactory<? extends T> internalFactory, Scoping scoping) {
        if (scoping.isNoScope()) {
            return internalFactory;
        }
        return new InternalFactoryToProviderAdapter(Initializables.m301of(scoping.getScopeInstance().scope(key, new ProviderToInternalFactoryAdapter(injectorImpl, internalFactory))));
    }

    static Scoping makeInjectable(Scoping scoping, InjectorImpl injectorImpl, Errors errors) {
        Class<? extends Annotation> scopeAnnotation = scoping.getScopeAnnotation();
        if (scopeAnnotation == null) {
            return scoping;
        }
        Scope scope = injectorImpl.state.getScope(scopeAnnotation);
        if (scope != null) {
            return Scoping.forInstance(scope);
        }
        errors.scopeNotFound(scopeAnnotation);
        return Scoping.UNSCOPED;
    }
}
