package com.google.inject.spi;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.inject.Binder;
import com.google.inject.ConfigurationException;
import com.google.inject.internal.Preconditions;
import java.util.Set;

public final class StaticInjectionRequest implements Element {
    private final Object source;
    private final Class<?> type;

    StaticInjectionRequest(Object obj, Class<?> cls) {
        this.source = Preconditions.checkNotNull(obj, FirebaseAnalytics.Param.SOURCE);
        this.type = (Class) Preconditions.checkNotNull(cls, "type");
    }

    public Object getSource() {
        return this.source;
    }

    public Class<?> getType() {
        return this.type;
    }

    public Set<InjectionPoint> getInjectionPoints() throws ConfigurationException {
        return InjectionPoint.forStaticMethodsAndFields(this.type);
    }

    public void applyTo(Binder binder) {
        binder.withSource(getSource()).requestStaticInjection(this.type);
    }

    public <T> T acceptVisitor(ElementVisitor<T> elementVisitor) {
        return elementVisitor.visit(this);
    }
}
