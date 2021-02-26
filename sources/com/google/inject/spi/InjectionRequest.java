package com.google.inject.spi;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.inject.Binder;
import com.google.inject.ConfigurationException;
import com.google.inject.TypeLiteral;
import com.google.inject.internal.Preconditions;
import java.util.Set;

public final class InjectionRequest<T> implements Element {
    private final T instance;
    private final Object source;
    private final TypeLiteral<T> type;

    public InjectionRequest(Object obj, TypeLiteral<T> typeLiteral, T t) {
        this.source = Preconditions.checkNotNull(obj, FirebaseAnalytics.Param.SOURCE);
        this.type = (TypeLiteral) Preconditions.checkNotNull(typeLiteral, "type");
        this.instance = Preconditions.checkNotNull(t, "instance");
    }

    public Object getSource() {
        return this.source;
    }

    public T getInstance() {
        return this.instance;
    }

    public TypeLiteral<T> getType() {
        return this.type;
    }

    public Set<InjectionPoint> getInjectionPoints() throws ConfigurationException {
        return InjectionPoint.forInstanceMethodsAndFields(this.instance.getClass());
    }

    public <R> R acceptVisitor(ElementVisitor<R> elementVisitor) {
        return elementVisitor.visit(this);
    }

    public void applyTo(Binder binder) {
        binder.withSource(getSource()).requestInjection(this.type, this.instance);
    }
}
