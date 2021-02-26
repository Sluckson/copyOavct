package com.google.inject.spi;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.inject.Binder;
import com.google.inject.Scope;
import com.google.inject.internal.Preconditions;
import java.lang.annotation.Annotation;

public final class ScopeBinding implements Element {
    private final Class<? extends Annotation> annotationType;
    private final Scope scope;
    private final Object source;

    ScopeBinding(Object obj, Class<? extends Annotation> cls, Scope scope2) {
        this.source = Preconditions.checkNotNull(obj, FirebaseAnalytics.Param.SOURCE);
        this.annotationType = (Class) Preconditions.checkNotNull(cls, "annotationType");
        this.scope = (Scope) Preconditions.checkNotNull(scope2, "scope");
    }

    public Object getSource() {
        return this.source;
    }

    public Class<? extends Annotation> getAnnotationType() {
        return this.annotationType;
    }

    public Scope getScope() {
        return this.scope;
    }

    public <T> T acceptVisitor(ElementVisitor<T> elementVisitor) {
        return elementVisitor.visit(this);
    }

    public void applyTo(Binder binder) {
        binder.withSource(getSource()).bindScope(this.annotationType, this.scope);
    }
}
