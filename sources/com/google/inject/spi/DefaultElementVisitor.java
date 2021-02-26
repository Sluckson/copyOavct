package com.google.inject.spi;

import com.google.inject.Binding;

public abstract class DefaultElementVisitor<V> implements ElementVisitor<V> {
    /* access modifiers changed from: protected */
    public V visitOther(Element element) {
        return null;
    }

    public V visit(Message message) {
        return visitOther(message);
    }

    public <T> V visit(Binding<T> binding) {
        return visitOther(binding);
    }

    public V visit(ScopeBinding scopeBinding) {
        return visitOther(scopeBinding);
    }

    public V visit(TypeConverterBinding typeConverterBinding) {
        return visitOther(typeConverterBinding);
    }

    public <T> V visit(ProviderLookup<T> providerLookup) {
        return visitOther(providerLookup);
    }

    public V visit(InjectionRequest injectionRequest) {
        return visitOther(injectionRequest);
    }

    public V visit(StaticInjectionRequest staticInjectionRequest) {
        return visitOther(staticInjectionRequest);
    }

    public V visit(PrivateElements privateElements) {
        return visitOther(privateElements);
    }

    public <T> V visit(MembersInjectorLookup<T> membersInjectorLookup) {
        return visitOther(membersInjectorLookup);
    }

    public V visit(TypeListenerBinding typeListenerBinding) {
        return visitOther(typeListenerBinding);
    }
}
