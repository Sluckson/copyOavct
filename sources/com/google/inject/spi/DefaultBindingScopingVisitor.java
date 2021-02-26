package com.google.inject.spi;

import com.google.inject.Scope;
import java.lang.annotation.Annotation;

public class DefaultBindingScopingVisitor<V> implements BindingScopingVisitor<V> {
    /* access modifiers changed from: protected */
    public V visitOther() {
        return null;
    }

    public V visitEagerSingleton() {
        return visitOther();
    }

    public V visitScope(Scope scope) {
        return visitOther();
    }

    public V visitScopeAnnotation(Class<? extends Annotation> cls) {
        return visitOther();
    }

    public V visitNoScoping() {
        return visitOther();
    }
}
